package emu.grasscutter.game.world;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.data.DataLoader;
import emu.grasscutter.data.GameData;
import emu.grasscutter.data.excels.InvestigationMonsterData;
import emu.grasscutter.data.excels.RewardPreviewData;
import emu.grasscutter.data.excels.WorldLevelData;
import emu.grasscutter.game.entity.gadget.chest.BossChestInteractHandler;
import emu.grasscutter.game.entity.gadget.chest.ChestInteractHandler;
import emu.grasscutter.game.entity.gadget.chest.NormalChestInteractHandler;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.proto.InvestigationMonsterOuterClass;
import emu.grasscutter.scripts.data.SceneBossChest;
import emu.grasscutter.scripts.data.SceneGroup;
import emu.grasscutter.scripts.data.SceneMonster;
import emu.grasscutter.server.game.BaseGameSystem;
import emu.grasscutter.server.game.GameServer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: grasscutter.jar:emu/grasscutter/game/world/WorldDataSystem.class */
public class WorldDataSystem extends BaseGameSystem {
    private final Map<String, ChestInteractHandler> chestInteractHandlerMap = new HashMap();
    private final Map<String, SceneGroup> sceneInvestigationGroupMap = new ConcurrentHashMap();

    /*  JADX ERROR: Dependency scan failed at insn: 0x0002: INVOKE_CUSTOM r-2, r-1
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
    /*  JADX ERROR: Failed to decode insn: 0x0002: INVOKE_CUSTOM r0, r1, method: emu.grasscutter.game.world.WorldDataSystem.getInvestigationGroup(int, int):emu.grasscutter.scripts.data.SceneGroup
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I)Ljava/lang/String;}, _]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I)Ljava/lang/String;}, _]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    private emu.grasscutter.scripts.data.SceneGroup getInvestigationGroup(int r5, int r6) {
        /*
            r4 = this;
            r0 = r5
            r1 = r6
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I)Ljava/lang/String;}, _]}
            r7 = r0
            r0 = r4
            java.util.Map<java.lang.String, emu.grasscutter.scripts.data.SceneGroup> r0 = r0.sceneInvestigationGroupMap
            r1 = r7
            boolean r0 = r0.containsKey(r1)
            if (r0 != 0) goto L_0x002f
            r0 = r6
            emu.grasscutter.scripts.data.SceneGroup r0 = emu.grasscutter.scripts.data.SceneGroup.m1194of(r0)
            r1 = r5
            emu.grasscutter.scripts.data.SceneGroup r0 = r0.load(r1)
            r8 = r0
            r0 = r4
            java.util.Map<java.lang.String, emu.grasscutter.scripts.data.SceneGroup> r0 = r0.sceneInvestigationGroupMap
            r1 = r7
            r2 = r8
            java.lang.Object r0 = r0.putIfAbsent(r1, r2)
            r0 = r8
            return r0
            r0 = r4
            java.util.Map<java.lang.String, emu.grasscutter.scripts.data.SceneGroup> r0 = r0.sceneInvestigationGroupMap
            r1 = r7
            java.lang.Object r0 = r0.get(r1)
            emu.grasscutter.scripts.data.SceneGroup r0 = (emu.grasscutter.scripts.data.SceneGroup) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.world.WorldDataSystem.getInvestigationGroup(int, int):emu.grasscutter.scripts.data.SceneGroup");
    }

    public WorldDataSystem(GameServer server) {
        super(server);
        loadChestConfig();
    }

    public synchronized void loadChestConfig() {
        this.chestInteractHandlerMap.put("SceneObj_Chest_Flora", new BossChestInteractHandler());
        try {
            DataLoader.loadList("ChestReward.json", ChestReward.class).forEach(reward -> {
                reward.getObjNames().forEach(name -> {
                    this.chestInteractHandlerMap.computeIfAbsent(reward, x -> {
                        return new NormalChestInteractHandler(reward);
                    });
                });
            });
        } catch (Exception e) {
            Grasscutter.getLogger().error("Unable to load chest reward config.", (Throwable) e);
        }
    }

    public Map<String, ChestInteractHandler> getChestInteractHandlerMap() {
        return this.chestInteractHandlerMap;
    }

    @Deprecated
    public RewardPreviewData getRewardByBossId(int monsterId) {
        Optional<InvestigationMonsterData> investigationMonsterData = GameData.getInvestigationMonsterDataMap().values().parallelStream().filter(imd -> {
            return imd.getMonsterIdList() != null && !imd.getMonsterIdList().isEmpty();
        }).filter(imd -> {
            return imd.getMonsterIdList().get(0).intValue() == monsterId;
        }).findFirst();
        if (investigationMonsterData.isEmpty()) {
            return null;
        }
        return GameData.getRewardPreviewDataMap().get(investigationMonsterData.get().getRewardPreviewId());
    }

    public int getMonsterLevel(SceneMonster monster, World world) {
        int level = monster.level;
        WorldLevelData worldLevelData = GameData.getWorldLevelDataMap().get(world.getWorldLevel());
        if (worldLevelData != null) {
            level = Math.max(level, worldLevelData.getMonsterLevel());
        }
        return level;
    }

    private InvestigationMonsterOuterClass.InvestigationMonster getInvestigationMonster(Player player, InvestigationMonsterData imd) {
        if (imd.getGroupIdList().isEmpty() || imd.getMonsterIdList().isEmpty()) {
            return null;
        }
        Integer groupId = imd.getGroupIdList().get(0);
        Integer monsterId = imd.getMonsterIdList().get(0);
        SceneGroup group = getInvestigationGroup(imd.getCityData().getSceneId(), groupId.intValue());
        if (group == null || group.monsters == null) {
            return null;
        }
        Optional<SceneMonster> monster = group.monsters.values().stream().filter(x -> {
            return x.monster_id == monsterId.intValue();
        }).findFirst();
        if (monster.isEmpty()) {
            return null;
        }
        InvestigationMonsterOuterClass.InvestigationMonster.Builder builder = InvestigationMonsterOuterClass.InvestigationMonster.newBuilder();
        builder.setId(imd.getId()).setCityId(imd.getCityId()).setSceneId(imd.getCityData().getSceneId()).setGroupId(groupId.intValue()).setMonsterId(monsterId.intValue()).setLevel(getMonsterLevel(monster.get(), player.getWorld())).setIsAlive(true).setNextRefreshTime(Integer.MAX_VALUE).setRefreshInterval(Integer.MAX_VALUE).setPos(monster.get().pos.toProto());
        if ("Boss".equals(imd.getMonsterCategory())) {
            Optional<SceneBossChest> bossChest = group.searchBossChestInGroup();
            if (bossChest.isPresent()) {
                builder.setResin(bossChest.get().resin);
                builder.setBossChestNum(bossChest.get().take_num);
            }
        }
        return builder.build();
    }

    public List<InvestigationMonsterOuterClass.InvestigationMonster> getInvestigationMonstersByCityId(Player player, int cityId) {
        if (GameData.getCityDataMap().get(cityId) != null) {
            return GameData.getInvestigationMonsterDataMap().values().parallelStream().filter(imd -> {
                return imd.getCityId() == cityId;
            }).map(imd -> {
                return getInvestigationMonster(player, player);
            }).filter((v0) -> {
                return Objects.nonNull(v0);
            }).toList();
        }
        Grasscutter.getLogger().warn("City not exist {}", Integer.valueOf(cityId));
        return List.of();
    }
}
