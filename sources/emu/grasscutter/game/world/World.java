package emu.grasscutter.game.world;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.data.GameData;
import emu.grasscutter.data.excels.DungeonData;
import emu.grasscutter.data.excels.SceneData;
import emu.grasscutter.game.dungeons.DungeonManager;
import emu.grasscutter.game.entity.EntityAvatar;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.props.EnterReason;
import emu.grasscutter.game.props.EntityIdType;
import emu.grasscutter.game.props.SceneType;
import emu.grasscutter.game.quest.enums.QuestTrigger;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.EnterTypeOuterClass;
import emu.grasscutter.scripts.data.SceneConfig;
import emu.grasscutter.server.event.player.PlayerTeleportEvent;
import emu.grasscutter.server.game.GameServer;
import emu.grasscutter.server.packet.send.PacketDelTeamEntityNotify;
import emu.grasscutter.server.packet.send.PacketPlayerEnterSceneNotify;
import emu.grasscutter.server.packet.send.PacketScenePlayerInfoNotify;
import emu.grasscutter.server.packet.send.PacketSyncScenePlayTeamEntityNotify;
import emu.grasscutter.server.packet.send.PacketSyncTeamEntityNotify;
import emu.grasscutter.server.packet.send.PacketWorldPlayerInfoNotify;
import emu.grasscutter.server.packet.send.PacketWorldPlayerRTTNotify;
import emu.grasscutter.utils.Position;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectMaps;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;

/* loaded from: grasscutter.jar:emu/grasscutter/game/world/World.class */
public class World implements Iterable<Player> {
    private final GameServer server;
    private final Player owner;
    private final List<Player> players;
    private final Int2ObjectMap<Scene> scenes;
    private int levelEntityId;
    private int nextEntityId;
    private int nextPeerId;
    private int worldLevel;
    private boolean isMultiplayer;

    public World(Player player) {
        this(player, false);
    }

    public World(Player player, boolean isMultiplayer) {
        this.nextEntityId = 0;
        this.nextPeerId = 0;
        this.owner = player;
        this.server = player.getServer();
        this.players = Collections.synchronizedList(new ArrayList());
        this.scenes = Int2ObjectMaps.synchronize(new Int2ObjectOpenHashMap());
        this.levelEntityId = getNextEntityId(EntityIdType.MPLEVEL);
        this.worldLevel = player.getWorldLevel();
        this.isMultiplayer = isMultiplayer;
        this.owner.getServer().registerWorld(this);
    }

    public Player getHost() {
        return this.owner;
    }

    public GameServer getServer() {
        return this.server;
    }

    public int getLevelEntityId() {
        return this.levelEntityId;
    }

    public int getHostPeerId() {
        if (getHost() == null) {
            return 0;
        }
        return getHost().getPeerId();
    }

    public int getNextPeerId() {
        int i = this.nextPeerId + 1;
        this.nextPeerId = i;
        return i;
    }

    public int getWorldLevel() {
        return this.worldLevel;
    }

    public void setWorldLevel(int worldLevel) {
        this.worldLevel = worldLevel;
    }

    public List<Player> getPlayers() {
        return this.players;
    }

    public Int2ObjectMap<Scene> getScenes() {
        return this.scenes;
    }

    public Scene getSceneById(int sceneId) {
        Scene scene = getScenes().get(sceneId);
        if (scene != null) {
            return scene;
        }
        SceneData sceneData = GameData.getSceneDataMap().get(sceneId);
        if (sceneData == null) {
            return null;
        }
        Scene scene2 = new Scene(this, sceneData);
        registerScene(scene2);
        return scene2;
    }

    public int getPlayerCount() {
        return getPlayers().size();
    }

    public boolean isMultiplayer() {
        return this.isMultiplayer;
    }

    public int getNextEntityId(EntityIdType idType) {
        int i = this.nextEntityId + 1;
        this.nextEntityId = i;
        return (idType.getId() << 24) + i;
    }

    public synchronized void addPlayer(Player player) {
        if (!getPlayers().contains(player)) {
            if (player.getWorld() != null) {
                player.getWorld().removePlayer(player);
            }
            player.setWorld(this);
            getPlayers().add(player);
            player.setPeerId(getNextPeerId());
            player.getTeamManager().setEntityId(getNextEntityId(EntityIdType.TEAM));
            if (isMultiplayer()) {
                player.getTeamManager().getMpTeam().copyFrom(player.getTeamManager().getCurrentSinglePlayerTeamInfo(), player.getTeamManager().getMaxTeamSize());
                player.getTeamManager().setCurrentCharacterIndex(0);
            }
            getSceneById(player.getSceneId()).addPlayer(player);
            if (getPlayers().size() > 1) {
                updatePlayerInfos(player);
            }
        }
    }

    public synchronized void removePlayer(Player player) {
        player.sendPacket(new PacketDelTeamEntityNotify(player.getSceneId(), (List) getPlayers().stream().map(p -> {
            return Integer.valueOf(p.getTeamManager().getEntityId());
        }).collect(Collectors.toList())));
        getPlayers().remove(player);
        player.setWorld(null);
        getSceneById(player.getSceneId()).removePlayer(player);
        if (getPlayers().size() > 0) {
            updatePlayerInfos(player);
        }
        if (getHost() == player) {
            for (Player victim : new ArrayList<>(getPlayers())) {
                new World(victim).addPlayer(victim);
                victim.sendPacket(new PacketPlayerEnterSceneNotify(victim, EnterTypeOuterClass.EnterType.ENTER_TYPE_SELF, EnterReason.TeamKick, victim.getSceneId(), victim.getPosition()));
            }
        }
    }

    public void registerScene(Scene scene) {
        getScenes().put(scene.getId(), (int) scene);
    }

    public void deregisterScene(Scene scene) {
        getScenes().remove(scene.getId());
    }

    public boolean transferPlayerToScene(Player player, int sceneId, Position pos) {
        return transferPlayerToScene(player, sceneId, PlayerTeleportEvent.TeleportType.INTERNAL, null, pos);
    }

    public boolean transferPlayerToScene(Player player, int sceneId, PlayerTeleportEvent.TeleportType teleportType, Position pos) {
        return transferPlayerToScene(player, sceneId, teleportType, null, pos);
    }

    public boolean transferPlayerToScene(Player player, int sceneId, DungeonData data) {
        return transferPlayerToScene(player, sceneId, PlayerTeleportEvent.TeleportType.DUNGEON, data, null);
    }

    public boolean transferPlayerToScene(Player player, int sceneId, PlayerTeleportEvent.TeleportType teleportType, DungeonData dungeonData, Position teleportTo) {
        EnterReason enterReason;
        EntityAvatar entity = player.getTeamManager().getCurrentAvatarEntity();
        if (entity == null) {
            return false;
        }
        if (!entity.isAlive()) {
            Grasscutter.getLogger().error("Can't teleport when it's dead");
            return false;
        }
        PlayerTeleportEvent event = new PlayerTeleportEvent(player, teleportType, player.getPosition(), teleportTo);
        event.call();
        if (event.isCanceled()) {
            return false;
        }
        Position teleportTo2 = event.getDestination();
        if (GameData.getSceneDataMap().get(sceneId) == null) {
            return false;
        }
        Scene oldScene = null;
        if (player.getScene() != null) {
            oldScene = player.getScene();
            if (oldScene.getId() == sceneId) {
                oldScene.setDontDestroyWhenEmpty(true);
            }
            oldScene.removePlayer(player);
        }
        Scene newScene = getSceneById(sceneId);
        newScene.setDungeonData(dungeonData);
        newScene.addPlayer(player);
        player.setAvatarsAbilityForScene(newScene);
        if (dungeonData != null) {
            new DungeonManager(newScene, dungeonData).startDungeon();
        }
        SceneConfig config = newScene.getScriptManager().getConfig();
        if (teleportTo2 == null && config != null) {
            if (config.born_pos != null) {
                teleportTo2 = newScene.getScriptManager().getConfig().born_pos;
            }
            if (config.born_rot != null) {
                player.getRotation().set(config.born_rot);
            }
        }
        if (teleportTo2 == null) {
            teleportTo2 = player.getPosition();
        }
        player.getPosition().set(teleportTo2);
        if (!(oldScene == null || newScene == oldScene)) {
            newScene.setPrevScene(oldScene.getId());
            oldScene.setDontDestroyWhenEmpty(false);
        }
        EnterTypeOuterClass.EnterType enterType = EnterTypeOuterClass.EnterType.ENTER_TYPE_JUMP;
        switch (teleportType) {
            case INTERNAL:
                enterReason = EnterReason.TransPoint;
                break;
            case WAYPOINT:
                enterReason = EnterReason.TransPoint;
                break;
            case MAP:
                enterReason = EnterReason.TransPoint;
                break;
            case COMMAND:
                enterReason = EnterReason.Gm;
                break;
            case SCRIPT:
                enterReason = EnterReason.Lua;
                break;
            case CLIENT:
                enterReason = EnterReason.ClientTransmit;
                break;
            default:
                enterReason = EnterReason.None;
                break;
        }
        if (dungeonData != null) {
            enterType = EnterTypeOuterClass.EnterType.ENTER_TYPE_DUNGEON;
            enterReason = EnterReason.DungeonEnter;
        } else if (oldScene == newScene) {
            enterType = EnterTypeOuterClass.EnterType.ENTER_TYPE_GOTO;
        } else if (newScene.getSceneType() == SceneType.SCENE_HOME_WORLD) {
            enterReason = EnterReason.EnterHome;
            enterType = EnterTypeOuterClass.EnterType.ENTER_TYPE_SELF_HOME;
        }
        try {
            Grasscutter.getLogger().info("Player {} teleport to ({}) {} enter {} with {}", player.getNickname(), Integer.valueOf(sceneId), teleportTo2, enterReason.name(), teleportType.name());
        } catch (Exception e) {
        }
        player.sendPacket(new PacketPlayerEnterSceneNotify(player, enterType, enterReason, sceneId, teleportTo2));
        if (teleportType == PlayerTeleportEvent.TeleportType.INTERNAL || teleportType == PlayerTeleportEvent.TeleportType.SCRIPT) {
            return true;
        }
        player.getQuestManager().queueEvent(QuestTrigger.QUEST_CONTENT_ANY_MANUAL_TRANSPORT, new int[0]);
        return true;
    }

    private void updatePlayerInfos(Player paramPlayer) {
        for (Player player : getPlayers()) {
            if (player.hasSentLoginPackets() && player != paramPlayer) {
                if (isMultiplayer()) {
                    player.getTeamManager().getMpTeam().copyFrom(player.getTeamManager().getMpTeam(), player.getTeamManager().getMaxTeamSize());
                    player.getTeamManager().updateTeamEntities(null);
                }
                if (player.getSceneLoadState().getValue() < Player.SceneLoadState.INIT.getValue()) {
                    player.getSession().send(new PacketWorldPlayerInfoNotify(this));
                    player.getSession().send(new PacketScenePlayerInfoNotify(this));
                    player.getSession().send(new PacketWorldPlayerRTTNotify(this));
                    player.getSession().send(new PacketSyncTeamEntityNotify(player));
                    player.getSession().send(new PacketSyncScenePlayTeamEntityNotify(player));
                }
            }
        }
    }

    public void broadcastPacket(BasePacket packet) {
        for (Player player : getPlayers()) {
            player.getSession().send(packet);
        }
    }

    public boolean onTick() {
        if (getPlayerCount() == 0) {
            return true;
        }
        this.scenes.forEach(k, scene -> {
            scene.onTick();
        });
        return false;
    }

    public void close() {
    }

    @Override // java.lang.Iterable
    public Iterator<Player> iterator() {
        return getPlayers().iterator();
    }
}
