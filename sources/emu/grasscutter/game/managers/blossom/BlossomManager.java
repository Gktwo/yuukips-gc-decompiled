package emu.grasscutter.game.managers.blossom;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.data.GameData;
import emu.grasscutter.data.GameDepot;
import emu.grasscutter.data.excels.BlossomRefreshExcelConfigData;
import emu.grasscutter.data.excels.RewardPreviewData;
import emu.grasscutter.data.excels.WorldLevelData;
import emu.grasscutter.game.entity.EntityGadget;
import emu.grasscutter.game.entity.GameEntity;
import emu.grasscutter.game.entity.gadget.GadgetWorktop;
import emu.grasscutter.game.world.Scene;
import emu.grasscutter.game.world.SpawnDataEntry;
import emu.grasscutter.net.proto.BlossomBriefInfoOuterClass;
import emu.grasscutter.server.packet.send.PacketBlossomBriefInfoNotify;
import emu.grasscutter.utils.Utils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p014it.unimi.dsi.fastutil.ints.IntArrayList;
import p014it.unimi.dsi.fastutil.ints.IntList;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;

/* loaded from: grasscutter.jar:emu/grasscutter/game/managers/blossom/BlossomManager.class */
public class BlossomManager {
    private final Scene scene;
    private final List<BlossomActivity> blossomActivities = new ArrayList();
    private final List<BlossomActivity> activeChests = new ArrayList();
    private final List<EntityGadget> createdEntity = new ArrayList();
    private final List<SpawnDataEntry> blossomConsumed = new ArrayList();

    /*  JADX ERROR: Dependency scan failed at insn: 0x0099: INVOKE_CUSTOM r-5
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
    /*  JADX ERROR: Failed to decode insn: 0x0099: INVOKE_CUSTOM r1, method: emu.grasscutter.game.managers.blossom.BlossomManager.onReward(emu.grasscutter.game.player.Player, emu.grasscutter.game.entity.EntityGadget, boolean):java.util.List<emu.grasscutter.game.inventory.GameItem>
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Blossom could not support world level : ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Blossom could not support world level : ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public java.util.List<emu.grasscutter.game.inventory.GameItem> onReward(emu.grasscutter.game.player.Player r7, emu.grasscutter.game.entity.EntityGadget r8, boolean r9) {
        /*
        // Method dump skipped, instructions count: 336
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.managers.blossom.BlossomManager.onReward(emu.grasscutter.game.player.Player, emu.grasscutter.game.entity.EntityGadget, boolean):java.util.List");
    }

    public BlossomManager(Scene scene) {
        this.scene = scene;
    }

    public void onTick() {
        synchronized (this.blossomActivities) {
            Iterator<BlossomActivity> it = this.blossomActivities.iterator();
            while (it.hasNext()) {
                BlossomActivity active = it.next();
                active.onTick();
                if (active.getPass()) {
                    this.scene.addEntity(active.getChest());
                    this.scene.setChallenge(null);
                    this.activeChests.add(active);
                    it.remove();
                }
            }
        }
    }

    public void recycleGadgetEntity(List<GameEntity> entities) {
        for (GameEntity entity : entities) {
            if (entity instanceof EntityGadget) {
                this.createdEntity.remove((EntityGadget) entity);
            }
        }
        notifyIcon();
    }

    public void initBlossom(EntityGadget gadget) {
        if (!this.createdEntity.contains(gadget) && !this.blossomConsumed.contains(gadget.getSpawnEntry()) && BlossomType.valueOf(gadget.getGadgetId()) != null) {
            gadget.buildContent();
            gadget.setState(204);
            int worldLevel = getWorldLevel();
            GadgetWorktop gadgetWorktop = (GadgetWorktop) gadget.getContent();
            gadgetWorktop.addWorktopOptions(new int[]{187});
            gadgetWorktop.setOnSelectWorktopOptionEvent(
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x005c: INVOKE  
                  (r0v16 'gadgetWorktop' emu.grasscutter.game.entity.gadget.GadgetWorktop A[D('gadgetWorktop' emu.grasscutter.game.entity.gadget.GadgetWorktop)])
                  (wrap: emu.grasscutter.game.entity.gadget.worktop.WorktopWorktopOptionHandler : 0x0057: INVOKE_CUSTOM (r1v7 emu.grasscutter.game.entity.gadget.worktop.WorktopWorktopOptionHandler A[REMOVE]) = 
                  (r6v0 'this' emu.grasscutter.game.managers.blossom.BlossomManager A[D('this' emu.grasscutter.game.managers.blossom.BlossomManager), DONT_INLINE, IMMUTABLE_TYPE, THIS])
                  (r0v13 'worldLevel' int A[D('worldLevel' int), DONT_INLINE])
                
                 handle type: INVOKE_INSTANCE
                 lambda: emu.grasscutter.game.entity.gadget.worktop.WorktopWorktopOptionHandler.onSelectWorktopOption(emu.grasscutter.game.entity.gadget.GadgetWorktop, int):boolean
                 call insn: ?: INVOKE  
                  (r1 I:emu.grasscutter.game.managers.blossom.BlossomManager)
                  (r2 I:int)
                  (v2 emu.grasscutter.game.entity.gadget.GadgetWorktop)
                  (v3 int)
                 type: VIRTUAL call: emu.grasscutter.game.managers.blossom.BlossomManager.lambda$initBlossom$0(int, emu.grasscutter.game.entity.gadget.GadgetWorktop, int):boolean)
                 type: VIRTUAL call: emu.grasscutter.game.entity.gadget.GadgetWorktop.setOnSelectWorktopOptionEvent(emu.grasscutter.game.entity.gadget.worktop.WorktopWorktopOptionHandler):void in method: emu.grasscutter.game.managers.blossom.BlossomManager.initBlossom(emu.grasscutter.game.entity.EntityGadget):void, file: grasscutter.jar:emu/grasscutter/game/managers/blossom/BlossomManager.class
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:94)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:137)
                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:349)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:302)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:271)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getCodeVar()" because the return value of "jadx.core.dex.instructions.args.RegisterArg.getSVar()" is null
                	at jadx.core.codegen.InsnGen.makeInlinedLambdaMethod(InsnGen.java:900)
                	at jadx.core.codegen.InsnGen.makeInvokeLambda(InsnGen.java:814)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:756)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:976)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:801)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:278)
                	... 23 more
                */
            /*
                this = this;
                r0 = r6
                java.util.List<emu.grasscutter.game.entity.EntityGadget> r0 = r0.createdEntity
                r1 = r7
                boolean r0 = r0.contains(r1)
                if (r0 == 0) goto L_0x000e
                return
            L_0x000e:
                r0 = r6
                java.util.List<emu.grasscutter.game.world.SpawnDataEntry> r0 = r0.blossomConsumed
                r1 = r7
                emu.grasscutter.game.world.SpawnDataEntry r1 = r1.getSpawnEntry()
                boolean r0 = r0.contains(r1)
                if (r0 == 0) goto L_0x001f
                return
            L_0x001f:
                r0 = r7
                int r0 = r0.getGadgetId()
                r8 = r0
                r0 = r8
                emu.grasscutter.game.managers.blossom.BlossomType r0 = emu.grasscutter.game.managers.blossom.BlossomType.valueOf(r0)
                if (r0 != 0) goto L_0x002c
                return
            L_0x002c:
                r0 = r7
                r0.buildContent()
                r0 = r7
                r1 = 204(0xcc, float:2.86E-43)
                r0.setState(r1)
                r0 = r6
                int r0 = r0.getWorldLevel()
                r9 = r0
                r0 = r7
                emu.grasscutter.game.entity.gadget.GadgetContent r0 = r0.getContent()
                emu.grasscutter.game.entity.gadget.GadgetWorktop r0 = (emu.grasscutter.game.entity.gadget.GadgetWorktop) r0
                r10 = r0
                r0 = r10
                r1 = 1
                int[] r1 = new int[r1]
                r2 = r1
                r3 = 0
                r4 = 187(0xbb, float:2.62E-43)
                r2[r3] = r4
                r0.addWorktopOptions(r1)
                r0 = r10
                r1 = r6
                r2 = r9
                void r1 = (v2, v3) -> { // emu.grasscutter.game.entity.gadget.worktop.WorktopWorktopOptionHandler.onSelectWorktopOption(emu.grasscutter.game.entity.gadget.GadgetWorktop, int):boolean
                    return r1.lambda$initBlossom$0(r2, v2, v3);
                }
                r0.setOnSelectWorktopOptionEvent(r1)
                r0 = r6
                java.util.List<emu.grasscutter.game.entity.EntityGadget> r0 = r0.createdEntity
                r1 = r7
                boolean r0 = r0.add(r1)
                r0 = r6
                r0.notifyIcon()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.managers.blossom.BlossomManager.initBlossom(emu.grasscutter.game.entity.EntityGadget):void");
        }

        public void notifyIcon() {
            int wl = getWorldLevel();
            int worldLevel = wl < 0 ? 0 : wl > 8 ? 8 : wl;
            WorldLevelData worldLevelData = GameData.getWorldLevelDataMap().get(worldLevel);
            int monsterLevel = worldLevelData != null ? worldLevelData.getMonsterLevel() : 1;
            List<BlossomBriefInfoOuterClass.BlossomBriefInfo> blossoms = new ArrayList<>();
            GameDepot.getSpawnLists().forEach(gridBlockId, spawnDataEntryList -> {
                int sceneId = monsterLevel.getSceneId();
                spawnDataEntryList.stream().map((v0) -> {
                    return v0.getGroup();
                }).map((v0) -> {
                    return v0.getSpawns();
                }).flatMap((v0) -> {
                    return v0.stream();
                }).filter(spawn -> {
                    return !this.blossomConsumed.contains(spawn);
                }).filter(spawn -> {
                    return BlossomType.valueOf(spawn.getGadgetId()) != null;
                }).forEach(spawn -> {
                    BlossomType type = BlossomType.valueOf(spawn.getGadgetId());
                    worldLevel.add(BlossomBriefInfoOuterClass.BlossomBriefInfo.newBuilder().setSceneId(sceneId).setPos(spawn.getPos().toProto()).setResin(20).setMonsterLevel(blossoms).setRewardId(getPreviewReward(type, worldLevel).intValue()).setCircleCampId(type.getCircleCampId()).setRefreshId(type.getBlossomChestId()).build());
                });
            });
            this.scene.broadcastPacket(new PacketBlossomBriefInfoNotify(blossoms));
        }

        public int getWorldLevel() {
            return this.scene.getWorld().getWorldLevel();
        }

        private static Integer getPreviewReward(BlossomType type, int worldLevel) {
            if (type == null) {
                Grasscutter.getLogger().error("Illegal blossom type {}", type);
                return null;
            }
            int blossomChestId = type.getBlossomChestId();
            ObjectIterator<BlossomRefreshExcelConfigData> it = GameData.getBlossomRefreshExcelConfigDataMap().values().iterator();
            while (it.hasNext()) {
                BlossomRefreshExcelConfigData data = it.next();
                if (blossomChestId == data.getBlossomChestId()) {
                    BlossomRefreshExcelConfigData.Drop[] dropVecList = data.getDropVec();
                    if (worldLevel <= dropVecList.length) {
                        return Integer.valueOf(dropVecList[worldLevel].getPreviewReward());
                    }
                    Grasscutter.getLogger().error("Illegal world level {}", Integer.valueOf(worldLevel));
                    return null;
                }
            }
            Grasscutter.getLogger().error("Cannot find blossom type {}", type);
            return null;
        }

        private static RewardPreviewData getRewardList(BlossomType type, int worldLevel) {
            Integer previewReward = getPreviewReward(type, worldLevel);
            if (previewReward == null) {
                return null;
            }
            return GameData.getRewardPreviewDataMap().get(previewReward.intValue());
        }

        public static IntList getRandomMonstersID(int difficulty, int count) {
            IntList result = new IntArrayList();
            List<Integer> monsters = GameDepot.getBlossomConfig().getMonsterIdsPerDifficulty().get(Integer.valueOf(difficulty));
            for (int i = 0; i < count; i++) {
                result.add(monsters.get(Utils.randomRange(0, monsters.size() - 1)).intValue());
            }
            return result;
        }
    }
