package emu.grasscutter.game.dungeons;

import emu.grasscutter.GameConstants;
import emu.grasscutter.Grasscutter;
import emu.grasscutter.data.GameData;
import emu.grasscutter.data.binout.ScenePointEntry;
import emu.grasscutter.data.excels.DungeonData;
import emu.grasscutter.data.excels.DungeonPassConfigData;
import emu.grasscutter.game.dungeons.handlers.DungeonBaseHandler;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.props.SceneType;
import emu.grasscutter.game.world.Scene;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.server.game.BaseGameSystem;
import emu.grasscutter.server.game.GameServer;
import emu.grasscutter.server.packet.send.PacketDungeonEntryInfoRsp;
import emu.grasscutter.server.packet.send.PacketPlayerEnterDungeonRsp;
import emu.grasscutter.utils.Position;
import java.util.List;
import java.util.Objects;
import org.reflections.Reflections;
import org.reflections.scanners.Scanner;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;

/* loaded from: grasscutter.jar:emu/grasscutter/game/dungeons/DungeonSystem.class */
public class DungeonSystem extends BaseGameSystem {
    private static final BasicDungeonSettleListener basicDungeonSettleObserver = new BasicDungeonSettleListener();
    private final Int2ObjectMap<DungeonBaseHandler> passCondHandlers = new Int2ObjectOpenHashMap();

    public DungeonSystem(GameServer server) {
        super(server);
        registerHandlers();
    }

    public void registerHandlers() {
        registerHandlers(this.passCondHandlers, "emu.grasscutter.game.dungeons.pass_condition", DungeonBaseHandler.class);
    }

    public <T> void registerHandlers(Int2ObjectMap<T> map, String packageName, Class<T> clazz) {
        for (Class<? extends T> obj : new Reflections(packageName, new Scanner[0]).getSubTypesOf(clazz)) {
            registerPacketHandler(map, obj);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: it.unimi.dsi.fastutil.ints.Int2ObjectMap<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public <T> void registerPacketHandler(Int2ObjectMap<T> map, Class<? extends T> handlerClass) {
        try {
            DungeonValue opcode = (DungeonValue) handlerClass.getAnnotation(DungeonValue.class);
            if (opcode != null && opcode.value() != null) {
                map.put(opcode.value().ordinal(), (int) handlerClass.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getEntryInfo(Player player, int pointId) {
        ScenePointEntry entry = GameData.getScenePointEntryById(player.getScene().getId(), pointId);
        if (entry == null) {
            player.sendPacket(new PacketDungeonEntryInfoRsp());
        } else {
            player.sendPacket(new PacketDungeonEntryInfoRsp(player, entry.getPointData()));
        }
    }

    public boolean triggerCondition(DungeonPassConfigData.DungeonPassCondition condition, int... params) {
        DungeonBaseHandler handler = this.passCondHandlers.get(condition.getCondType().ordinal());
        if (handler != null) {
            return handler.execute(condition, params);
        }
        Grasscutter.getLogger().debug("Could not trigger condition {} at {}", condition.getCondType(), params);
        return false;
    }

    public boolean enterDungeon(Player player, int pointId, int dungeonId) {
        DungeonData data = GameData.getDungeonDataMap().get(dungeonId);
        if (data == null) {
            return false;
        }
        int sceneId = data.getSceneId();
        Grasscutter.getLogger().info("{}({}) is trying to enter dungeon {} and scene {}", player.getNickname(), Integer.valueOf(player.getUid()), Integer.valueOf(dungeonId), Integer.valueOf(sceneId));
        Scene scene = player.getScene();
        scene.setPrevScene(sceneId);
        if (player.getWorld().transferPlayerToScene(player, sceneId, data)) {
            scene = player.getScene();
            scene.addDungeonSettleObserver(basicDungeonSettleObserver);
        }
        scene.setPrevScenePoint(pointId);
        player.sendPacket(new PacketPlayerEnterDungeonRsp(pointId, dungeonId));
        return true;
    }

    public boolean handoffDungeon(Player player, int dungeonId, List<DungeonSettleListener> dungeonSettleListeners) {
        DungeonData data = GameData.getDungeonDataMap().get(dungeonId);
        if (data == null) {
            return false;
        }
        Grasscutter.getLogger().info("{}({}) is trying to enter tower dungeon {}", player.getNickname(), Integer.valueOf(player.getUid()), Integer.valueOf(dungeonId));
        if (!player.getWorld().transferPlayerToScene(player, data.getSceneId(), data)) {
            return true;
        }
        Scene scene = player.getScene();
        Objects.requireNonNull(scene);
        dungeonSettleListeners.forEach(this::addDungeonSettleObserver);
        return true;
    }

    public void exitDungeon(Player player) {
        Position d;
        Scene scene = player.getScene();
        if (scene != null && scene.getSceneType() == SceneType.SCENE_DUNGEON) {
            int prevScene = scene.getPrevScene() > 0 ? scene.getPrevScene() : 3;
            DungeonManager dungeonManager = scene.getDungeonManager();
            DungeonData dungeonData = dungeonManager != null ? dungeonManager.getDungeonData() : null;
            Position prevPos = new Position(GameConstants.START_POSITION);
            if (dungeonData != null) {
                ScenePointEntry entry = GameData.getScenePointEntryById(prevScene, scene.getPrevScenePoint());
                if (!(entry == null || (d = entry.getPointData().getTranPos()) == null)) {
                    prevPos.set(d);
                }
                if (dungeonManager != null && !dungeonManager.isFinishedSuccessfully()) {
                    dungeonManager.quitDungeon();
                }
            }
            player.getTeamManager().cleanTemporaryTeam();
            player.getTowerManager().clearEntry();
            player.getWorld().transferPlayerToScene(player, prevScene, prevPos);
            player.sendPacket(new BasePacket(PacketOpcodes.PlayerQuitDungeonRsp));
        }
    }
}
