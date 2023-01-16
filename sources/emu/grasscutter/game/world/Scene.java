package emu.grasscutter.game.world;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.data.GameData;
import emu.grasscutter.data.binout.SceneNpcBornData;
import emu.grasscutter.data.binout.SceneNpcBornEntry;
import emu.grasscutter.data.binout.routes.Route;
import emu.grasscutter.data.excels.CodexAnimalData;
import emu.grasscutter.data.excels.DungeonData;
import emu.grasscutter.data.excels.ItemData;
import emu.grasscutter.data.excels.SceneData;
import emu.grasscutter.game.avatar.Avatar;
import emu.grasscutter.game.dungeons.DungeonManager;
import emu.grasscutter.game.dungeons.DungeonPassConditionType;
import emu.grasscutter.game.dungeons.DungeonSettleListener;
import emu.grasscutter.game.dungeons.challenge.WorldChallenge;
import emu.grasscutter.game.entity.EntityAvatar;
import emu.grasscutter.game.entity.EntityBaseGadget;
import emu.grasscutter.game.entity.EntityClientGadget;
import emu.grasscutter.game.entity.EntityGadget;
import emu.grasscutter.game.entity.EntityItem;
import emu.grasscutter.game.entity.EntityMonster;
import emu.grasscutter.game.entity.EntityRegion;
import emu.grasscutter.game.entity.GameEntity;
import emu.grasscutter.game.entity.gadget.GadgetContent;
import emu.grasscutter.game.entity.gadget.GadgetWorktop;
import emu.grasscutter.game.inventory.GameItem;
import emu.grasscutter.game.managers.blossom.BlossomManager;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.player.TeamManager;
import emu.grasscutter.game.props.FightProperty;
import emu.grasscutter.game.props.LifeState;
import emu.grasscutter.game.props.SceneType;
import emu.grasscutter.game.quest.QuestGroupSuite;
import emu.grasscutter.game.world.SpawnDataEntry;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.AttackResultOuterClass;
import emu.grasscutter.net.proto.SelectWorktopOptionReqOuterClass;
import emu.grasscutter.net.proto.VisionTypeOuterClass;
import emu.grasscutter.scripts.SceneIndexManager;
import emu.grasscutter.scripts.SceneScriptManager;
import emu.grasscutter.scripts.data.SceneBlock;
import emu.grasscutter.scripts.data.SceneGadget;
import emu.grasscutter.scripts.data.SceneGroup;
import emu.grasscutter.scripts.data.SceneRegion;
import emu.grasscutter.scripts.data.SceneSuite;
import emu.grasscutter.scripts.data.SceneTrigger;
import emu.grasscutter.scripts.data.ScriptArgs;
import emu.grasscutter.server.packet.send.PacketDungeonChallengeFinishNotify;
import emu.grasscutter.server.packet.send.PacketGroupSuiteNotify;
import emu.grasscutter.server.packet.send.PacketGroupUnloadNotify;
import emu.grasscutter.server.packet.send.PacketLifeStateChangeNotify;
import emu.grasscutter.server.packet.send.PacketSceneEntityAppearNotify;
import emu.grasscutter.server.packet.send.PacketSceneEntityDisappearNotify;
import emu.grasscutter.server.packet.send.PacketSceneForceLockNotify;
import emu.grasscutter.server.packet.send.PacketSceneForceUnlockNotify;
import emu.grasscutter.utils.Position;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.Nullable;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectMap;

/* loaded from: grasscutter.jar:emu/grasscutter/game/world/Scene.class */
public class Scene {
    private final World world;
    private final SceneData sceneData;
    private boolean dontDestroyWhenEmpty;
    private int autoCloseTime;
    private WorldChallenge challenge;
    private List<DungeonSettleListener> dungeonSettleListeners;
    DungeonManager dungeonManager;
    private DungeonData dungeonData;
    private int prevScenePoint;
    private int killedMonsterCount;
    private boolean finishedLoading = false;
    private final List<Runnable> afterLoadedCallbacks = new ArrayList();
    private final List<Player> players = new CopyOnWriteArrayList();
    private final Map<Integer, GameEntity> entities = new ConcurrentHashMap();
    private int time = PacketOpcodes.QuestGlobalVarNotify;
    private final long startTime = System.currentTimeMillis();
    private int prevScene = 3;
    Int2ObjectMap<Route> sceneRoutes = GameData.getSceneRoutes(getId());
    private final Set<SpawnDataEntry> spawnedEntities = ConcurrentHashMap.newKeySet();
    private final Set<SpawnDataEntry> deadSpawnedEntities = ConcurrentHashMap.newKeySet();
    private final Set<SceneBlock> loadedBlocks = ConcurrentHashMap.newKeySet();
    private Set<SpawnDataEntry.GridBlockId> loadedGridBlocks = new HashSet();
    private Set<SceneNpcBornEntry> npcBornEntrySet = ConcurrentHashMap.newKeySet();
    private SceneScriptManager scriptManager = new SceneScriptManager(this);
    private final BlossomManager blossomManager = new BlossomManager(this);
    private final HashSet<Integer> unlockedForces = new HashSet<>();

    /*  JADX ERROR: Dependency scan failed at insn: 0x0031: INVOKE_CUSTOM r0
        java.lang.IndexOutOfBoundsException: Index 4 out of bounds for length 4
        	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
        	at java.base/java.util.Objects.checkIndex(Objects.java:359)
        	at java.base/java.util.ArrayList.get(ArrayList.java:427)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInsn(UsageInfoVisitor.java:130)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.lambda$processInstructions$0(UsageInfoVisitor.java:79)
        	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInstructions(UsageInfoVisitor.java:77)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processMethod(UsageInfoVisitor.java:62)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processClass(UsageInfoVisitor.java:51)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.init(UsageInfoVisitor.java:36)
        	at jadx.core.dex.nodes.RootNode.runPreDecompileStage(RootNode.java:267)
        */
    /*  JADX ERROR: Failed to decode insn: 0x0031: INVOKE_CUSTOM r1, method: emu.grasscutter.game.world.Scene.onTick():void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, There are no scripts available in this scene:  ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:55)
        	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:568)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:438)
        	at jadx.core.dex.instructions.InsnDecoder.lambda$process$0(InsnDecoder.java:48)
        	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
        	at jadx.core.ProcessClass.process(ProcessClass.java:53)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:85)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:300)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:265)
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, There are no scripts available in this scene:  ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public void onTick() {
        /*
            r4 = this;
            r0 = r4
            emu.grasscutter.game.props.SceneType r0 = r0.getSceneType()
            emu.grasscutter.game.props.SceneType r1 = emu.grasscutter.game.props.SceneType.SCENE_HOME_WORLD
            if (r0 == r1) goto L_0x0014
            r0 = r4
            emu.grasscutter.game.props.SceneType r0 = r0.getSceneType()
            emu.grasscutter.game.props.SceneType r1 = emu.grasscutter.game.props.SceneType.SCENE_HOME_ROOM
            if (r0 != r1) goto L_0x0019
            r0 = r4
            r0.finishLoading()
            return
            r0 = r4
            emu.grasscutter.scripts.SceneScriptManager r0 = r0.getScriptManager()
            boolean r0 = r0.isInit()
            if (r0 == 0) goto L_0x002a
            r0 = r4
            r0.checkBlocks()
            goto L_0x0039
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            r1 = r4
            int r1 = r1.getId()
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, There are no scripts available in this scene:  ]}
            r0.debug(r1)
            goto L_0x0047
            r5 = move-exception
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            java.lang.String r1 = "Error Scene (checkBlocks) (Exception): "
            r2 = r5
            r0.error(r1, r2)
            r0 = r4
            emu.grasscutter.scripts.SceneScriptManager r0 = r0.scriptManager
            r0.checkRegions()
            goto L_0x005c
            r5 = move-exception
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            java.lang.String r1 = "Error Scene (checkRegions) (Exception): "
            r2 = r5
            r0.error(r1, r2)
            r0 = r4
            emu.grasscutter.game.dungeons.challenge.WorldChallenge r0 = r0.challenge
            if (r0 == 0) goto L_0x006a
            r0 = r4
            emu.grasscutter.game.dungeons.challenge.WorldChallenge r0 = r0.challenge
            r0.onCheckTimeOut()
            goto L_0x0078
            r5 = move-exception
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            java.lang.String r1 = "Error Scene (onCheckTimeOut) (Exception): "
            r2 = r5
            r0.error(r1, r2)
            r0 = r4
            emu.grasscutter.game.managers.blossom.BlossomManager r0 = r0.blossomManager
            r0.onTick()
            goto L_0x008d
            r5 = move-exception
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            java.lang.String r1 = "Error Scene (blossomManager) (Exception): "
            r2 = r5
            r0.error(r1, r2)
            r0 = r4
            r0.checkNpcGroup()
            goto L_0x009f
            r5 = move-exception
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            java.lang.String r1 = "Error Scene (checkNpcGroup) (Exception): "
            r2 = r5
            r0.error(r1, r2)
            r0 = r4
            emu.grasscutter.game.props.SceneType r0 = r0.getSceneType()
            emu.grasscutter.game.props.SceneType r1 = emu.grasscutter.game.props.SceneType.SCENE_WORLD
            if (r0 != r1) goto L_0x00ad
            r0 = r4
            r0.checkSpawns()
            goto L_0x00bb
            r5 = move-exception
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            java.lang.String r1 = "Error Scene (checkSpawns) (Exception): "
            r2 = r5
            r0.error(r1, r2)
            r0 = r4
            r0.finishLoading()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.world.Scene.onTick():void");
    }

    public World getWorld() {
        return this.world;
    }

    public SceneData getSceneData() {
        return this.sceneData;
    }

    public List<Player> getPlayers() {
        return this.players;
    }

    public Map<Integer, GameEntity> getEntities() {
        return this.entities;
    }

    public Set<SpawnDataEntry> getSpawnedEntities() {
        return this.spawnedEntities;
    }

    public Set<SpawnDataEntry> getDeadSpawnedEntities() {
        return this.deadSpawnedEntities;
    }

    public Set<SceneBlock> getLoadedBlocks() {
        return this.loadedBlocks;
    }

    public BlossomManager getBlossomManager() {
        return this.blossomManager;
    }

    public boolean isDontDestroyWhenEmpty() {
        return this.dontDestroyWhenEmpty;
    }

    public void setDontDestroyWhenEmpty(boolean dontDestroyWhenEmpty) {
        this.dontDestroyWhenEmpty = dontDestroyWhenEmpty;
    }

    public int getAutoCloseTime() {
        return this.autoCloseTime;
    }

    public void setAutoCloseTime(int autoCloseTime) {
        this.autoCloseTime = autoCloseTime;
    }

    public int getTime() {
        return this.time;
    }

    public SceneScriptManager getScriptManager() {
        return this.scriptManager;
    }

    public WorldChallenge getChallenge() {
        return this.challenge;
    }

    public void setChallenge(WorldChallenge challenge) {
        this.challenge = challenge;
    }

    public List<DungeonSettleListener> getDungeonSettleListeners() {
        return this.dungeonSettleListeners;
    }

    public DungeonManager getDungeonManager() {
        return this.dungeonManager;
    }

    public void setDungeonManager(DungeonManager dungeonManager) {
        this.dungeonManager = dungeonManager;
    }

    public DungeonData getDungeonData() {
        return this.dungeonData;
    }

    public int getPrevScene() {
        return this.prevScene;
    }

    public void setPrevScene(int prevScene) {
        this.prevScene = prevScene;
    }

    public int getPrevScenePoint() {
        return this.prevScenePoint;
    }

    public void setPrevScenePoint(int prevScenePoint) {
        this.prevScenePoint = prevScenePoint;
    }

    public int getKilledMonsterCount() {
        return this.killedMonsterCount;
    }

    public void setKilledMonsterCount(int killedMonsterCount) {
        this.killedMonsterCount = killedMonsterCount;
    }

    public Int2ObjectMap<Route> getSceneRoutes() {
        return this.sceneRoutes;
    }

    public boolean isFinishedLoading() {
        return this.finishedLoading;
    }

    public Scene(World world, SceneData sceneData) {
        this.world = world;
        this.sceneData = sceneData;
    }

    public int getId() {
        return this.sceneData.getId();
    }

    public SceneType getSceneType() {
        return getSceneData().getSceneType();
    }

    public int getPlayerCount() {
        return getPlayers().size();
    }

    public GameEntity getEntityById(int id) {
        return this.entities.get(Integer.valueOf(id));
    }

    public GameEntity getEntityByConfigId(int configId) {
        return this.entities.values().stream().filter(x -> {
            return x.getConfigId() == configId;
        }).findFirst().orElse(null);
    }

    @Nullable
    public Route getSceneRouteById(int routeId) {
        return this.sceneRoutes.get(routeId);
    }

    public void changeTime(int time) {
        this.time = time % 1440;
    }

    public int getSceneTime() {
        return (int) (System.currentTimeMillis() - this.startTime);
    }

    public void setDungeonData(DungeonData dungeonData) {
        if (dungeonData != null && this.dungeonData == null && getSceneType() == SceneType.SCENE_DUNGEON && dungeonData.getSceneId() == getId()) {
            this.dungeonData = dungeonData;
        }
    }

    public void addDungeonSettleObserver(DungeonSettleListener dungeonSettleListener) {
        if (this.dungeonSettleListeners == null) {
            this.dungeonSettleListeners = new ArrayList();
        }
        this.dungeonSettleListeners.add(dungeonSettleListener);
    }

    public List<DungeonSettleListener> getDungeonSettleObservers() {
        return this.dungeonSettleListeners;
    }

    public void triggerDungeonEvent(DungeonPassConditionType conditionType, int... params) {
        if (this.dungeonManager != null) {
            this.dungeonManager.triggerEvent(conditionType, params);
        }
    }

    public boolean isInScene(GameEntity entity) {
        return this.entities.containsKey(Integer.valueOf(entity.getId()));
    }

    public synchronized void addPlayer(Player player) {
        if (!getPlayers().contains(player)) {
            if (player.getScene() != null) {
                player.getScene().removePlayer(player);
            }
            getPlayers().add(player);
            player.setSceneId(getId());
            player.setScene(this);
            setupPlayerAvatars(player);
        }
    }

    public synchronized void removePlayer(Player player) {
        if (getChallenge() != null && getChallenge().inProgress()) {
            player.sendPacket(new PacketDungeonChallengeFinishNotify(getChallenge()));
        }
        getPlayers().remove(player);
        player.setScene(null);
        removePlayerAvatars(player);
        for (EntityBaseGadget gadget : player.getTeamManager().getGadgets()) {
            removeEntity(gadget);
        }
        if (getPlayerCount() <= 0 && !this.dontDestroyWhenEmpty) {
            getWorld().deregisterScene(this);
        }
    }

    private void setupPlayerAvatars(Player player) {
        EntityAvatar entity;
        player.getTeamManager().getActiveTeam().clear();
        for (Integer num : player.getTeamManager().getCurrentTeamInfo().getAvatars()) {
            Avatar tes = player.getAvatars().getAvatarById(num.intValue());
            if (!(tes == null || (entity = new EntityAvatar(player.getScene(), tes)) == null)) {
                player.getTeamManager().getActiveTeam().add(entity);
            }
        }
        if (player.getTeamManager().getCurrentCharacterIndex() >= player.getTeamManager().getActiveTeam().size() || player.getTeamManager().getCurrentCharacterIndex() < 0) {
            player.getTeamManager().setCurrentCharacterIndex(player.getTeamManager().getCurrentCharacterIndex() - 1);
        }
    }

    private synchronized void removePlayerAvatars(Player player) {
        List<EntityAvatar> team = player.getTeamManager().getActiveTeam();
        team.forEach(e -> {
            removeEntity(e, VisionTypeOuterClass.VisionType.VISION_TYPE_REMOVE);
        });
        team.clear();
    }

    public void spawnPlayer(Player player) {
        TeamManager teamManager = player.getTeamManager();
        if (!isInScene(teamManager.getCurrentAvatarEntity())) {
            if (teamManager.getCurrentAvatarEntity().getFightProperty(FightProperty.FIGHT_PROP_CUR_HP) <= 0.0f) {
                teamManager.getCurrentAvatarEntity().setFightProperty(FightProperty.FIGHT_PROP_CUR_HP, 1.0f);
            }
            addEntity(teamManager.getCurrentAvatarEntity());
            teamManager.getActiveTeam().stream().map((v0) -> {
                return v0.getAvatar();
            }).forEach((v0) -> {
                v0.sendSkillExtraChargeMap();
            });
        }
    }

    private boolean addEntityDirectly(GameEntity entity) {
        if (entity == null) {
            return false;
        }
        getEntities().put(Integer.valueOf(entity.getId()), entity);
        entity.onCreate();
        return true;
    }

    public synchronized void addEntity(GameEntity entity) {
        if (entity != null && addEntityDirectly(entity)) {
            broadcastPacket(new PacketSceneEntityAppearNotify(entity));
        }
    }

    public synchronized void addEntityToSingleClient(Player player, GameEntity entity) {
        if (entity != null && addEntityDirectly(entity)) {
            player.sendPacket(new PacketSceneEntityAppearNotify(entity));
        }
    }

    public void addEntities(Collection<? extends GameEntity> entities) {
        addEntities(entities, VisionTypeOuterClass.VisionType.VISION_TYPE_BORN);
    }

    public synchronized void addEntities(Collection<? extends GameEntity> entities, VisionTypeOuterClass.VisionType visionType) {
        if (!(entities == null || entities.isEmpty())) {
            Collection<? extends GameEntity> entities2 = (Collection) entities.stream().sorted(Comparator.comparing((v0) -> {
                return v0.getConfigId();
            })).collect(Collectors.toList());
            for (GameEntity entity : entities2) {
                addEntityDirectly(entity);
            }
            broadcastPacket(new PacketSceneEntityAppearNotify(entities2, visionType));
        }
    }

    private GameEntity removeEntityDirectly(GameEntity entity) {
        if (entity == null) {
            return null;
        }
        GameEntity removed = getEntities().remove(Integer.valueOf(entity.getId()));
        if (removed != null) {
            removed.onRemoved();
        }
        return removed;
    }

    public void removeEntity(GameEntity entity) {
        removeEntity(entity, VisionTypeOuterClass.VisionType.VISION_TYPE_DIE);
    }

    public synchronized boolean removeEntity(GameEntity entity, VisionTypeOuterClass.VisionType visionType) {
        GameEntity removed;
        if (entity == null || (removed = removeEntityDirectly(entity)) == null) {
            return false;
        }
        broadcastPacket(new PacketSceneEntityDisappearNotify(removed, visionType));
        return true;
    }

    public synchronized void removeEntities(List<GameEntity> entity, VisionTypeOuterClass.VisionType visionType) {
        if (entity != null) {
            List<GameEntity> toRemove = entity.stream().map(this::removeEntityDirectly).filter((v0) -> {
                return Objects.nonNull(v0);
            }).toList();
            if (toRemove.size() > 0) {
                broadcastPacket(new PacketSceneEntityDisappearNotify(toRemove, visionType));
            }
        }
    }

    public synchronized void replaceEntity(EntityAvatar oldEntity, EntityAvatar newEntity) {
        if (oldEntity != null && newEntity != null) {
            removeEntityDirectly(oldEntity);
            addEntityDirectly(newEntity);
            broadcastPacket(new PacketSceneEntityDisappearNotify(oldEntity, VisionTypeOuterClass.VisionType.VISION_TYPE_REPLACE));
            broadcastPacket(new PacketSceneEntityAppearNotify(newEntity, VisionTypeOuterClass.VisionType.VISION_TYPE_REPLACE, oldEntity.getId()));
        }
    }

    public void showOtherEntities(Player player) {
        GameEntity currentEntity = player.getTeamManager().getCurrentAvatarEntity();
        player.sendPacket(new PacketSceneEntityAppearNotify(getEntities().values().stream().filter(entity -> {
            return entity != currentEntity;
        }).toList(), VisionTypeOuterClass.VisionType.VISION_TYPE_MEET));
    }

    public void handleAttack(AttackResultOuterClass.AttackResult result) {
        GameEntity target = getEntityById(result.getDefenseId());
        if (target != null) {
            if (!(target instanceof EntityAvatar) || !((EntityAvatar) target).getPlayer().inGodmode()) {
                target.damage(result.getDamage(), result.getAttackerId());
            }
        }
    }

    public void killEntity(GameEntity target) {
        killEntity(target, 0);
    }

    public void killEntity(GameEntity target, int attackerId) {
        GameEntity attacker = null;
        if (attackerId > 0) {
            attacker = getEntityById(attackerId);
        }
        if (attacker != null) {
            if (attacker instanceof EntityClientGadget) {
                if (getEntityById(((EntityClientGadget) attacker).getOwnerEntityId()) instanceof EntityAvatar) {
                    ((EntityClientGadget) attacker).getOwner().getCodex().checkAnimal(target, CodexAnimalData.CountType.CODEX_COUNT_TYPE_KILL);
                }
            } else if (attacker instanceof EntityAvatar) {
                ((EntityAvatar) attacker).getPlayer().getCodex().checkAnimal(target, CodexAnimalData.CountType.CODEX_COUNT_TYPE_KILL);
            }
        }
        broadcastPacket(new PacketLifeStateChangeNotify(attackerId, target, LifeState.LIFE_DEAD));
        if ((target instanceof EntityMonster) && getSceneType() != SceneType.SCENE_DUNGEON && !getWorld().getServer().getDropSystem().handleMonsterDrop((EntityMonster) target)) {
            getWorld().getServer().getDropSystemLegacy().callDrop((EntityMonster) target);
        }
        removeEntity(target);
        target.onDeath(attackerId);
        DungeonPassConditionType dungeonPassConditionType = DungeonPassConditionType.DUNGEON_COND_KILL_MONSTER_COUNT;
        int i = this.killedMonsterCount + 1;
        this.killedMonsterCount = i;
        triggerDungeonEvent(dungeonPassConditionType, i);
    }

    public void reload() {
        try {
            for (Player player : getPlayers()) {
                World world = player.getWorld();
                Scene scene = player.getScene();
                Position pos = player.getPosition();
                world.transferPlayerToScene(player, 1, pos);
                world.transferPlayerToScene(player, scene.getId(), pos);
                scene.broadcastPacket(new PacketSceneEntityAppearNotify(player));
            }
        } catch (Exception e) {
            Grasscutter.getLogger().error("Error reload scene...", (Throwable) e);
        }
    }

    public void finishLoading() {
        if (!this.finishedLoading) {
            this.finishedLoading = true;
            this.afterLoadedCallbacks.forEach((v0) -> {
                v0.run();
            });
            this.afterLoadedCallbacks.clear();
        }
    }

    public void runWhenFinished(Runnable runnable) {
        if (isFinishedLoading()) {
            runnable.run();
        } else {
            this.afterLoadedCallbacks.add(runnable);
        }
    }

    public int getEntityLevel(int baseLevel, int worldLevelOverride) {
        int level = worldLevelOverride > 0 ? (worldLevelOverride + baseLevel) - 22 : baseLevel;
        int level2 = level >= 100 ? 100 : level;
        return level2 <= 0 ? 1 : level2;
    }

    public void loadNpcQuestForPlayerEnter(Player player) {
        List<QuestGroupSuite> questGroupSuites = player.getQuestManager().getSceneGroupSuite(player.getSceneId());
        if (questGroupSuites != null && questGroupSuites.size() > 0) {
            player.getScene().loadGroupForQuest(questGroupSuites);
            player.getSession().send(new PacketGroupSuiteNotify(questGroupSuites));
        }
    }

    public void checkNpcGroup() {
        Set<SceneNpcBornEntry> npcBornEntries = ConcurrentHashMap.newKeySet();
        for (Player player : getPlayers()) {
            npcBornEntries.addAll(loadNpcForPlayer(player));
        }
        List<Integer> toUnload = this.npcBornEntrySet.stream().filter(i -> {
            return !npcBornEntries.contains(i);
        }).map((v0) -> {
            return v0.getGroupId();
        }).toList();
        if (toUnload.size() > 0) {
            broadcastPacket(new PacketGroupUnloadNotify(toUnload));
        }
        this.npcBornEntrySet = npcBornEntries;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v112, resolved type: emu.grasscutter.game.entity.EntityGadget */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x02b1 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00d4 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void checkSpawns() {
        /*
        // Method dump skipped, instructions count: 894
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.world.Scene.checkSpawns():void");
    }

    public List<SceneBlock> getPlayerActiveBlocks(Player player) {
        return SceneIndexManager.queryNeighbors(getScriptManager().getBlocksIndex(), player.getPosition().toXZDoubleArray(), Grasscutter.getConfig().server.game.loadEntitiesForPlayerRange);
    }

    private boolean unloadBlockIfNotVisible(Collection<SceneBlock> visible, SceneBlock block) {
        if (visible.contains(block)) {
            return false;
        }
        try {
            onUnloadBlock(block);
            return true;
        } catch (Exception e) {
            Grasscutter.getLogger().error("Error onUnloadBlock: ", (Throwable) e);
            return false;
        }
    }

    private synchronized boolean loadBlock(SceneBlock block) {
        if (this.loadedBlocks.contains(block)) {
            return false;
        }
        onLoadBlock(block, this.players);
        this.loadedBlocks.add(block);
        return true;
    }

    public synchronized void checkBlocks() {
        Set<SceneBlock> visible = (Set) this.players.stream().map(player -> {
            return getPlayerActiveBlocks(player);
        }).flatMap((v0) -> {
            return v0.stream();
        }).collect(Collectors.toSet());
        this.loadedBlocks.removeIf(block -> {
            return unloadBlockIfNotVisible(visible, visible);
        });
        visible.stream().filter(block -> {
            return !loadBlock(block);
        }).forEach(block -> {
            onLoadGroup(this.players.stream().filter(p -> {
                return block.contains(p.getPosition());
            }).map(p -> {
                return playerMeetGroups(block, block);
            }).flatMap((v0) -> {
                return v0.stream();
            }).toList());
        });
    }

    public List<SceneGroup> playerMeetGroups(Player player, SceneBlock block) {
        List<SceneGroup> groups = SceneIndexManager.queryNeighbors(block.sceneGroupIndex, player.getPosition().toDoubleArray(), Grasscutter.getConfig().server.game.loadEntitiesForPlayerRange).stream().filter(group -> {
            return !this.scriptManager.getLoadedGroupSetPerBlock().get(Integer.valueOf(block.f956id)).contains(block);
        }).peek(group -> {
            this.scriptManager.getLoadedGroupSetPerBlock().get(Integer.valueOf(block.f956id)).add(block);
        }).toList();
        if (groups.size() == 0) {
            return List.of();
        }
        return groups;
    }

    public void onLoadBlock(SceneBlock block, List<Player> players) {
        getScriptManager().loadBlockFromScript(block);
        this.scriptManager.getLoadedGroupSetPerBlock().put(Integer.valueOf(block.f956id), new HashSet());
        onLoadGroup(players.stream().filter(player -> {
            return block.contains(player.getPosition());
        }).map(p -> {
            return playerMeetGroups(block, block);
        }).flatMap((v0) -> {
            return v0.stream();
        }).toList());
        Grasscutter.getLogger().debug("Scene {} Block {} loaded.", Integer.valueOf(getId()), Integer.valueOf(block.f956id));
    }

    public void loadTriggerFromGroup(SceneGroup group, String triggerName) {
        if (group.triggers != null) {
            getScriptManager().registerTrigger(group.triggers.values().stream().filter(p -> {
                return p != null && p.name.contains(triggerName);
            }).toList());
        }
        Stream<R> map = group.regions.values().stream().filter(q -> {
            return q.config_id == Integer.parseInt(triggerName.substring(13));
        }).map(region -> {
            return new EntityRegion(this, region);
        });
        SceneScriptManager scriptManager = getScriptManager();
        Objects.requireNonNull(scriptManager);
        map.forEach(this::registerRegion);
    }

    public void onLoadGroup(List<SceneGroup> groups) {
        int suite;
        SceneSuite suiteData;
        if (!(groups == null || groups.isEmpty())) {
            for (SceneGroup group : groups) {
                getScriptManager().loadGroupFromScript(group);
            }
            ArrayList<GameEntity> entities = new ArrayList<>();
            for (SceneGroup group2 : groups) {
                if (!(group2.init_config == null || (suite = group2.init_config.suite) == 0 || group2.suites == null || group2.suites.size() == 0 || (suiteData = group2.getSuiteByIndex(suite)) == null || suiteData.sceneTriggers == null)) {
                    List<SceneTrigger> list = suiteData.sceneTriggers;
                    SceneScriptManager scriptManager = getScriptManager();
                    Objects.requireNonNull(scriptManager);
                    list.forEach(this::registerTrigger);
                    List<SceneGadget> garbageGadgets = group2.getGarbageGadgets();
                    if (garbageGadgets != null) {
                        entities.addAll(garbageGadgets.stream().map(g -> {
                            return this.scriptManager.createGadget(group.f957id, group.block_id, group2);
                        }).filter((v0) -> {
                            return Objects.nonNull(v0);
                        }).toList());
                    }
                    entities.addAll(this.scriptManager.getGadgetsInGroupSuite(group2, suiteData));
                    entities.addAll(this.scriptManager.getMonstersInGroupSuite(group2, suiteData));
                    for (Player player : getPlayers()) {
                        player.getSession().send(new PacketGroupSuiteNotify(group2.f957id, suite));
                    }
                    this.scriptManager.registerRegionInGroupSuite(group2, suiteData);
                }
            }
            this.scriptManager.meetEntities(entities);
            groups.forEach(g -> {
                this.scriptManager.callEvent(new ScriptArgs(29, g.f957id));
            });
            Grasscutter.getLogger().debug("Scene {} loaded {} group(s)", Integer.valueOf(getId()), Integer.valueOf(groups.size()));
        }
    }

    public void onUnloadBlock(SceneBlock block) {
        if (block != null) {
            List<GameEntity> toRemove = getEntities().values().stream().filter(e -> {
                return e.getBlockId() == block.f956id;
            }).toList();
            if (toRemove.size() > 0) {
                toRemove.forEach(this::removeEntityDirectly);
                broadcastPacket(new PacketSceneEntityDisappearNotify(toRemove, VisionTypeOuterClass.VisionType.VISION_TYPE_REMOVE));
            }
            if (block.groups != null) {
                for (SceneGroup group : block.groups.values()) {
                    if (group.triggers != null) {
                        Collection<SceneTrigger> values = group.triggers.values();
                        SceneScriptManager scriptManager = getScriptManager();
                        Objects.requireNonNull(scriptManager);
                        values.forEach(this::deregisterTrigger);
                    }
                    if (group.regions != null) {
                        Collection<SceneRegion> values2 = group.regions.values();
                        SceneScriptManager scriptManager2 = getScriptManager();
                        Objects.requireNonNull(scriptManager2);
                        values2.forEach(this::deregisterRegion);
                    }
                }
            }
            this.scriptManager.getLoadedGroupSetPerBlock().remove(Integer.valueOf(block.f956id));
            Grasscutter.getLogger().debug("Scene {} Block {} is unloaded.", Integer.valueOf(getId()), Integer.valueOf(block.f956id));
        }
    }

    public void onPlayerCreateGadget(EntityClientGadget gadget) {
        addEntityDirectly(gadget);
        gadget.getOwner().getTeamManager().getGadgets().add(gadget);
        if (getPlayerCount() != 1 || getPlayers().get(0) != gadget.getOwner()) {
            broadcastPacketToOthers(gadget.getOwner(), new PacketSceneEntityAppearNotify(gadget));
        }
    }

    public void onPlayerDestroyGadget(int entityId) {
        GameEntity entity = getEntities().get(Integer.valueOf(entityId));
        if (entity != null && (entity instanceof EntityClientGadget)) {
            EntityClientGadget gadget = (EntityClientGadget) entity;
            removeEntityDirectly(gadget);
            gadget.getOwner().getTeamManager().getGadgets().remove(gadget);
            if (getPlayerCount() != 1 || getPlayers().get(0) != gadget.getOwner()) {
                broadcastPacketToOthers(gadget.getOwner(), new PacketSceneEntityDisappearNotify(gadget, VisionTypeOuterClass.VisionType.VISION_TYPE_DIE));
            }
        }
    }

    public void broadcastPacket(BasePacket packet) {
        for (Player player : getPlayers()) {
            player.getSession().send(packet);
        }
    }

    public void broadcastPacketToOthers(Player excludedPlayer, BasePacket packet) {
        if (!(getPlayerCount() == 1 && getPlayers().get(0) == excludedPlayer)) {
            for (Player player : getPlayers()) {
                if (player != excludedPlayer) {
                    player.getSession().send(packet);
                }
            }
        }
    }

    public void addItemEntity(int itemId, int amount, GameEntity bornForm) {
        ItemData itemData = GameData.getItemDataMap().get(itemId);
        if (itemData != null) {
            if (itemData.isEquip()) {
                float range = 1.5f + (0.05f * ((float) amount));
                for (int i = 0; i < amount; i++) {
                    addEntity(new EntityItem(this, null, itemData, bornForm.getPosition().nearby2d(range).addY(1.5f), 1));
                }
                return;
            }
            addEntity(new EntityItem(this, null, itemData, bornForm.getPosition().clone().addY(1.5f), amount));
        }
    }

    public void addDropEntity(GameItem item, GameEntity bornForm, Player player, boolean share) {
        ItemData itemData = GameData.getItemDataMap().get(item.getItemId());
        if (itemData != null) {
            if (itemData.isEquip()) {
                float range = 1.5f + (0.05f * ((float) item.getCount()));
                for (int j = 0; j < item.getCount(); j++) {
                    addEntity(new EntityItem(this, player, itemData, bornForm.getPosition().nearby2d(range).addY(1.5f), item.getCount(), share));
                }
                return;
            }
            addEntity(new EntityItem(this, player, itemData, bornForm.getPosition().clone().addY(1.5f), item.getCount(), share));
        }
    }

    public void loadNpcForPlayerEnter(Player player) {
        this.npcBornEntrySet.addAll(loadNpcForPlayer(player));
    }

    private List<SceneNpcBornEntry> loadNpcForPlayer(Player player) {
        SceneNpcBornData data = GameData.getSceneNpcBornData().get(getId());
        if (data == null) {
            Grasscutter.getLogger().debug("loadNpcForPlayer: Data No found > {}", Integer.valueOf(getId()));
            return List.of();
        }
        List<SceneNpcBornEntry> npcList = SceneIndexManager.queryNeighbors(data.getIndex(), player.getPosition().toDoubleArray(), Grasscutter.getConfig().server.game.loadEntitiesForPlayerRange);
        List<SceneNpcBornEntry> sceneNpcBornEntries = npcList.stream().filter(i -> {
            return !this.npcBornEntrySet.contains(i);
        }).toList();
        if (sceneNpcBornEntries.size() > 0) {
            broadcastPacket(new PacketGroupSuiteNotify(sceneNpcBornEntries));
        }
        return npcList;
    }

    public void loadGroupForQuest(List<QuestGroupSuite> sceneGroupSuite) {
        if (this.scriptManager.isInit()) {
            sceneGroupSuite.forEach(i -> {
                SceneSuite suite;
                SceneGroup group = this.scriptManager.getGroupById(i.getGroup());
                if (group != null && (suite = group.getSuiteByIndex(i.getSuite())) != null) {
                    this.scriptManager.addGroupSuite(group, suite);
                }
            });
        }
    }

    public void unlockForce(int force) {
        this.unlockedForces.add(Integer.valueOf(force));
        broadcastPacket(new PacketSceneForceUnlockNotify(force, true));
    }

    public void lockForce(int force) {
        this.unlockedForces.remove(Integer.valueOf(force));
        broadcastPacket(new PacketSceneForceLockNotify(force));
    }

    public void selectWorktopOptionWith(SelectWorktopOptionReqOuterClass.SelectWorktopOptionReq req) {
        GameEntity entity = getEntityById(req.getGadgetEntityId());
        if (entity != null && (entity instanceof EntityGadget)) {
            GadgetContent content = ((EntityGadget) entity).getContent();
            if ((content instanceof GadgetWorktop) && ((GadgetWorktop) content).onSelectWorktopOption(req)) {
                entity.getScene().removeEntity(entity, VisionTypeOuterClass.VisionType.VISION_TYPE_REMOVE);
            }
        }
    }
}
