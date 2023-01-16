package emu.grasscutter.game.home;

import dev.morphia.annotations.AbstractC1283Id;
import dev.morphia.annotations.Entity;
import emu.grasscutter.Grasscutter;
import emu.grasscutter.data.binout.HomeworldDefaultSaveData;
import emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass;
import emu.grasscutter.net.proto.HomeSceneArrangementInfoOuterClass;
import emu.grasscutter.utils.Position;
import java.util.Map;
import java.util.stream.Collectors;

@Entity
/* loaded from: grasscutter.jar:emu/grasscutter/game/home/HomeSceneItem.class */
public class HomeSceneItem {
    @AbstractC1283Id
    private int sceneId;
    private Map<Integer, HomeBlockItem> blockItems;
    private Position bornPos;
    private Position bornRot;
    private Position djinnPos;
    private int homeBgmId;
    private HomeFurnitureItem mainHouse;
    private int tmpVersion;

    /*  JADX ERROR: Dependency scan failed at insn: 0x0020: INVOKE_CUSTOM r-8, r-7, r-6, r-5, r-4, r-3, r-2, r-1
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
    /*  JADX ERROR: Failed to decode insn: 0x0020: INVOKE_CUSTOM r0, r1, r2, r3, r4, r5, r6, r7, method: emu.grasscutter.game.home.HomeSceneItem.toString():java.lang.String
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Ljava/util/Map;, Lemu/grasscutter/utils/Position;, Lemu/grasscutter/utils/Position;, Lemu/grasscutter/utils/Position;, I, Lemu/grasscutter/game/home/HomeFurnitureItem;, I)Ljava/lang/String;}, HomeSceneItem(sceneId=, blockItems=, bornPos=, bornRot=, djinnPos=, homeBgmId=, mainHouse=, tmpVersion=)]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Ljava/util/Map;, Lemu/grasscutter/utils/Position;, Lemu/grasscutter/utils/Position;, Lemu/grasscutter/utils/Position;, I, Lemu/grasscutter/game/home/HomeFurnitureItem;, I)Ljava/lang/String;}, HomeSceneItem(sceneId=, blockItems=, bornPos=, bornRot=, djinnPos=, homeBgmId=, mainHouse=, tmpVersion=)]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public java.lang.String toString() {
        /*
            r9 = this;
            r0 = r9
            int r0 = r0.getSceneId()
            r1 = r9
            java.util.Map r1 = r1.getBlockItems()
            r2 = r9
            emu.grasscutter.utils.Position r2 = r2.getBornPos()
            r3 = r9
            emu.grasscutter.utils.Position r3 = r3.getBornRot()
            r4 = r9
            emu.grasscutter.utils.Position r4 = r4.getDjinnPos()
            r5 = r9
            int r5 = r5.getHomeBgmId()
            r6 = r9
            emu.grasscutter.game.home.HomeFurnitureItem r6 = r6.getMainHouse()
            r7 = r9
            int r7 = r7.getTmpVersion()
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Ljava/util/Map;, Lemu/grasscutter/utils/Position;, Lemu/grasscutter/utils/Position;, Lemu/grasscutter/utils/Position;, I, Lemu/grasscutter/game/home/HomeFurnitureItem;, I)Ljava/lang/String;}, HomeSceneItem(sceneId=, blockItems=, bornPos=, bornRot=, djinnPos=, homeBgmId=, mainHouse=, tmpVersion=)]}
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.home.HomeSceneItem.toString():java.lang.String");
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/game/home/HomeSceneItem$HomeSceneItemBuilder.class */
    public static class HomeSceneItemBuilder {
        private int sceneId;
        private Map<Integer, HomeBlockItem> blockItems;
        private Position bornPos;
        private Position bornRot;
        private Position djinnPos;
        private int homeBgmId;
        private HomeFurnitureItem mainHouse;
        private int tmpVersion;

        /*  JADX ERROR: Dependency scan failed at insn: 0x0020: INVOKE_CUSTOM r-8, r-7, r-6, r-5, r-4, r-3, r-2, r-1
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
        /*  JADX ERROR: Failed to decode insn: 0x0020: INVOKE_CUSTOM r0, r1, r2, r3, r4, r5, r6, r7, method: emu.grasscutter.game.home.HomeSceneItem.HomeSceneItemBuilder.toString():java.lang.String
            jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Ljava/util/Map;, Lemu/grasscutter/utils/Position;, Lemu/grasscutter/utils/Position;, Lemu/grasscutter/utils/Position;, I, Lemu/grasscutter/game/home/HomeFurnitureItem;, I)Ljava/lang/String;}, HomeSceneItem.HomeSceneItemBuilder(sceneId=, blockItems=, bornPos=, bornRot=, djinnPos=, homeBgmId=, mainHouse=, tmpVersion=)]}
            	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:55)
            	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:568)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:438)
            	at jadx.core.dex.instructions.InsnDecoder.lambda$process$0(InsnDecoder.java:48)
            	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:315)
            	at jadx.core.ProcessClass.process(ProcessClass.java:53)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:85)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:300)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:265)
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Ljava/util/Map;, Lemu/grasscutter/utils/Position;, Lemu/grasscutter/utils/Position;, Lemu/grasscutter/utils/Position;, I, Lemu/grasscutter/game/home/HomeFurnitureItem;, I)Ljava/lang/String;}, HomeSceneItem.HomeSceneItemBuilder(sceneId=, blockItems=, bornPos=, bornRot=, djinnPos=, homeBgmId=, mainHouse=, tmpVersion=)]}
            	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
            	... 12 more
            */
        public java.lang.String toString() {
            /*
                r9 = this;
                r0 = r9
                int r0 = r0.sceneId
                r1 = r9
                java.util.Map<java.lang.Integer, emu.grasscutter.game.home.HomeBlockItem> r1 = r1.blockItems
                r2 = r9
                emu.grasscutter.utils.Position r2 = r2.bornPos
                r3 = r9
                emu.grasscutter.utils.Position r3 = r3.bornRot
                r4 = r9
                emu.grasscutter.utils.Position r4 = r4.djinnPos
                r5 = r9
                int r5 = r5.homeBgmId
                r6 = r9
                emu.grasscutter.game.home.HomeFurnitureItem r6 = r6.mainHouse
                r7 = r9
                int r7 = r7.tmpVersion
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Ljava/util/Map;, Lemu/grasscutter/utils/Position;, Lemu/grasscutter/utils/Position;, Lemu/grasscutter/utils/Position;, I, Lemu/grasscutter/game/home/HomeFurnitureItem;, I)Ljava/lang/String;}, HomeSceneItem.HomeSceneItemBuilder(sceneId=, blockItems=, bornPos=, bornRot=, djinnPos=, homeBgmId=, mainHouse=, tmpVersion=)]}
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.home.HomeSceneItem.HomeSceneItemBuilder.toString():java.lang.String");
        }

        HomeSceneItemBuilder() {
        }

        public HomeSceneItemBuilder sceneId(int sceneId) {
            this.sceneId = sceneId;
            return this;
        }

        public HomeSceneItemBuilder blockItems(Map<Integer, HomeBlockItem> blockItems) {
            this.blockItems = blockItems;
            return this;
        }

        public HomeSceneItemBuilder bornPos(Position bornPos) {
            this.bornPos = bornPos;
            return this;
        }

        public HomeSceneItemBuilder bornRot(Position bornRot) {
            this.bornRot = bornRot;
            return this;
        }

        public HomeSceneItemBuilder djinnPos(Position djinnPos) {
            this.djinnPos = djinnPos;
            return this;
        }

        public HomeSceneItemBuilder homeBgmId(int homeBgmId) {
            this.homeBgmId = homeBgmId;
            return this;
        }

        public HomeSceneItemBuilder mainHouse(HomeFurnitureItem mainHouse) {
            this.mainHouse = mainHouse;
            return this;
        }

        public HomeSceneItemBuilder tmpVersion(int tmpVersion) {
            this.tmpVersion = tmpVersion;
            return this;
        }

        public HomeSceneItem build() {
            return new HomeSceneItem(this.sceneId, this.blockItems, this.bornPos, this.bornRot, this.djinnPos, this.homeBgmId, this.mainHouse, this.tmpVersion);
        }
    }

    public void setSceneId(int sceneId) {
        this.sceneId = sceneId;
    }

    public void setBlockItems(Map<Integer, HomeBlockItem> blockItems) {
        this.blockItems = blockItems;
    }

    public void setBornPos(Position bornPos) {
        this.bornPos = bornPos;
    }

    public void setBornRot(Position bornRot) {
        this.bornRot = bornRot;
    }

    public void setDjinnPos(Position djinnPos) {
        this.djinnPos = djinnPos;
    }

    public void setHomeBgmId(int homeBgmId) {
        this.homeBgmId = homeBgmId;
    }

    public void setMainHouse(HomeFurnitureItem mainHouse) {
        this.mainHouse = mainHouse;
    }

    public void setTmpVersion(int tmpVersion) {
        this.tmpVersion = tmpVersion;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof HomeSceneItem)) {
            return false;
        }
        HomeSceneItem other = (HomeSceneItem) o;
        if (!other.canEqual(this) || getSceneId() != other.getSceneId() || getHomeBgmId() != other.getHomeBgmId() || getTmpVersion() != other.getTmpVersion()) {
            return false;
        }
        Object this$blockItems = getBlockItems();
        Object other$blockItems = other.getBlockItems();
        if (this$blockItems == null) {
            if (other$blockItems != null) {
                return false;
            }
        } else if (!this$blockItems.equals(other$blockItems)) {
            return false;
        }
        Object this$bornPos = getBornPos();
        Object other$bornPos = other.getBornPos();
        if (this$bornPos == null) {
            if (other$bornPos != null) {
                return false;
            }
        } else if (!this$bornPos.equals(other$bornPos)) {
            return false;
        }
        Object this$bornRot = getBornRot();
        Object other$bornRot = other.getBornRot();
        if (this$bornRot == null) {
            if (other$bornRot != null) {
                return false;
            }
        } else if (!this$bornRot.equals(other$bornRot)) {
            return false;
        }
        Object this$djinnPos = getDjinnPos();
        Object other$djinnPos = other.getDjinnPos();
        if (this$djinnPos == null) {
            if (other$djinnPos != null) {
                return false;
            }
        } else if (!this$djinnPos.equals(other$djinnPos)) {
            return false;
        }
        Object this$mainHouse = getMainHouse();
        Object other$mainHouse = other.getMainHouse();
        return this$mainHouse == null ? other$mainHouse == null : this$mainHouse.equals(other$mainHouse);
    }

    protected boolean canEqual(Object other) {
        return other instanceof HomeSceneItem;
    }

    public int hashCode() {
        int result = (((((1 * 59) + getSceneId()) * 59) + getHomeBgmId()) * 59) + getTmpVersion();
        Object $blockItems = getBlockItems();
        int result2 = (result * 59) + ($blockItems == null ? 43 : $blockItems.hashCode());
        Object $bornPos = getBornPos();
        int result3 = (result2 * 59) + ($bornPos == null ? 43 : $bornPos.hashCode());
        Object $bornRot = getBornRot();
        int result4 = (result3 * 59) + ($bornRot == null ? 43 : $bornRot.hashCode());
        Object $djinnPos = getDjinnPos();
        int result5 = (result4 * 59) + ($djinnPos == null ? 43 : $djinnPos.hashCode());
        Object $mainHouse = getMainHouse();
        return (result5 * 59) + ($mainHouse == null ? 43 : $mainHouse.hashCode());
    }

    HomeSceneItem(int sceneId, Map<Integer, HomeBlockItem> blockItems, Position bornPos, Position bornRot, Position djinnPos, int homeBgmId, HomeFurnitureItem mainHouse, int tmpVersion) {
        this.sceneId = sceneId;
        this.blockItems = blockItems;
        this.bornPos = bornPos;
        this.bornRot = bornRot;
        this.djinnPos = djinnPos;
        this.homeBgmId = homeBgmId;
        this.mainHouse = mainHouse;
        this.tmpVersion = tmpVersion;
    }

    /* renamed from: of */
    public static HomeSceneItemBuilder m1196of() {
        return new HomeSceneItemBuilder();
    }

    public int getSceneId() {
        return this.sceneId;
    }

    public Map<Integer, HomeBlockItem> getBlockItems() {
        return this.blockItems;
    }

    public Position getBornPos() {
        return this.bornPos;
    }

    public Position getBornRot() {
        return this.bornRot;
    }

    public Position getDjinnPos() {
        return this.djinnPos;
    }

    public int getHomeBgmId() {
        return this.homeBgmId;
    }

    public HomeFurnitureItem getMainHouse() {
        return this.mainHouse;
    }

    public int getTmpVersion() {
        return this.tmpVersion;
    }

    public static HomeSceneItem parseFrom(HomeworldDefaultSaveData defaultItem, int sceneId) {
        return m1196of().sceneId(sceneId).blockItems((Map) defaultItem.getHomeBlockLists().stream().map(HomeBlockItem::parseFrom).collect(Collectors.toMap((v0) -> {
            return v0.getBlockId();
        }, y -> {
            return y;
        }))).bornPos(defaultItem.getBornPos()).bornRot(defaultItem.getBornRot() == null ? new Position() : defaultItem.getBornRot()).djinnPos(defaultItem.getDjinPos() == null ? new Position() : defaultItem.getDjinPos()).mainHouse(defaultItem.getMainhouse() == null ? null : HomeFurnitureItem.parseFrom(defaultItem.getMainhouse())).build();
    }

    public void update(HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfo arrangementInfo) {
        for (HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfo blockItem : arrangementInfo.getBlockArrangementInfoListList()) {
            HomeBlockItem block = this.blockItems.get(Integer.valueOf(blockItem.getBlockId()));
            if (block == null) {
                Grasscutter.getLogger().warn("Could not found Home Block {}", Integer.valueOf(blockItem.getBlockId()));
            } else {
                block.update(blockItem);
                this.blockItems.put(Integer.valueOf(blockItem.getBlockId()), block);
            }
        }
        this.bornPos = new Position(arrangementInfo.getBornPos());
        this.bornRot = new Position(arrangementInfo.getBornRot());
        this.djinnPos = new Position(arrangementInfo.getDjinnPos());
        this.homeBgmId = arrangementInfo.getBgmId();
        this.mainHouse = HomeFurnitureItem.parseFrom(arrangementInfo.getMainHouse());
        this.tmpVersion = arrangementInfo.getTmpVersion();
    }

    public int getRoomSceneId() {
        if (this.mainHouse != null && this.mainHouse.getAsItem() != null) {
            return this.mainHouse.getAsItem().getRoomSceneId();
        }
        Grasscutter.getLogger().error("Could not found Home main");
        return 0;
    }

    public int calComfort() {
        return this.blockItems.values().stream().mapToInt((v0) -> {
            return v0.calComfort();
        }).sum();
    }

    public HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfo toProto() {
        HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfo.Builder proto = HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfo.newBuilder();
        try {
            this.blockItems.values().forEach(b -> {
                proto.addBlockArrangementInfoList(b.toProto());
            });
        } catch (Exception e) {
            Grasscutter.getLogger().error("Error blockItems: ", (Throwable) e);
        }
        try {
            proto.setComfortValue(calComfort()).setBornPos(this.bornPos.toProto()).setBornRot(this.bornRot.toProto()).setDjinnPos(this.djinnPos.toProto()).setIsSetBornPos(true).setSceneId(this.sceneId).setBgmId(this.homeBgmId).setTmpVersion(this.tmpVersion);
            if (this.mainHouse != null) {
                proto.setMainHouse(this.mainHouse.toProto());
            }
        } catch (Exception e2) {
            Grasscutter.getLogger().error("Error setComfortValue: ", (Throwable) e2);
        }
        return proto.build();
    }
}
