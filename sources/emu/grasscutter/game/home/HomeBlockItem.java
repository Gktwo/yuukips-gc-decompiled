package emu.grasscutter.game.home;

import dev.morphia.annotations.AbstractC1283Id;
import dev.morphia.annotations.Entity;
import emu.grasscutter.data.binout.HomeworldDefaultSaveData;
import emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass;
import java.util.List;

@Entity
/* loaded from: grasscutter.jar:emu/grasscutter/game/home/HomeBlockItem.class */
public class HomeBlockItem {
    @AbstractC1283Id
    private int blockId;
    private boolean unlocked;
    private List<HomeFurnitureItem> deployFurnitureList;
    private List<HomeFurnitureItem> persistentFurnitureList;
    private List<HomeAnimalItem> deployAnimalList;
    private List<HomeNPCItem> deployNPCList;

    /*  JADX ERROR: Dependency scan failed at insn: 0x0018: INVOKE_CUSTOM r-6, r-5, r-4, r-3, r-2, r-1
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
    /*  JADX ERROR: Failed to decode insn: 0x0018: INVOKE_CUSTOM r0, r1, r2, r3, r4, r5, method: emu.grasscutter.game.home.HomeBlockItem.toString():java.lang.String
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Z, Ljava/util/List;, Ljava/util/List;, Ljava/util/List;, Ljava/util/List;)Ljava/lang/String;}, HomeBlockItem(blockId=, unlocked=, deployFurnitureList=, persistentFurnitureList=, deployAnimalList=, deployNPCList=)]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Z, Ljava/util/List;, Ljava/util/List;, Ljava/util/List;, Ljava/util/List;)Ljava/lang/String;}, HomeBlockItem(blockId=, unlocked=, deployFurnitureList=, persistentFurnitureList=, deployAnimalList=, deployNPCList=)]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public java.lang.String toString() {
        /*
            r7 = this;
            r0 = r7
            int r0 = r0.getBlockId()
            r1 = r7
            boolean r1 = r1.isUnlocked()
            r2 = r7
            java.util.List r2 = r2.getDeployFurnitureList()
            r3 = r7
            java.util.List r3 = r3.getPersistentFurnitureList()
            r4 = r7
            java.util.List r4 = r4.getDeployAnimalList()
            r5 = r7
            java.util.List r5 = r5.getDeployNPCList()
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Z, Ljava/util/List;, Ljava/util/List;, Ljava/util/List;, Ljava/util/List;)Ljava/lang/String;}, HomeBlockItem(blockId=, unlocked=, deployFurnitureList=, persistentFurnitureList=, deployAnimalList=, deployNPCList=)]}
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.home.HomeBlockItem.toString():java.lang.String");
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/game/home/HomeBlockItem$HomeBlockItemBuilder.class */
    public static class HomeBlockItemBuilder {
        private int blockId;
        private boolean unlocked;
        private List<HomeFurnitureItem> deployFurnitureList;
        private List<HomeFurnitureItem> persistentFurnitureList;
        private List<HomeAnimalItem> deployAnimalList;
        private List<HomeNPCItem> deployNPCList;

        /*  JADX ERROR: Dependency scan failed at insn: 0x0018: INVOKE_CUSTOM r-6, r-5, r-4, r-3, r-2, r-1
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
        /*  JADX ERROR: Failed to decode insn: 0x0018: INVOKE_CUSTOM r0, r1, r2, r3, r4, r5, method: emu.grasscutter.game.home.HomeBlockItem.HomeBlockItemBuilder.toString():java.lang.String
            jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Z, Ljava/util/List;, Ljava/util/List;, Ljava/util/List;, Ljava/util/List;)Ljava/lang/String;}, HomeBlockItem.HomeBlockItemBuilder(blockId=, unlocked=, deployFurnitureList=, persistentFurnitureList=, deployAnimalList=, deployNPCList=)]}
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
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Z, Ljava/util/List;, Ljava/util/List;, Ljava/util/List;, Ljava/util/List;)Ljava/lang/String;}, HomeBlockItem.HomeBlockItemBuilder(blockId=, unlocked=, deployFurnitureList=, persistentFurnitureList=, deployAnimalList=, deployNPCList=)]}
            	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
            	... 12 more
            */
        public java.lang.String toString() {
            /*
                r7 = this;
                r0 = r7
                int r0 = r0.blockId
                r1 = r7
                boolean r1 = r1.unlocked
                r2 = r7
                java.util.List<emu.grasscutter.game.home.HomeFurnitureItem> r2 = r2.deployFurnitureList
                r3 = r7
                java.util.List<emu.grasscutter.game.home.HomeFurnitureItem> r3 = r3.persistentFurnitureList
                r4 = r7
                java.util.List<emu.grasscutter.game.home.HomeAnimalItem> r4 = r4.deployAnimalList
                r5 = r7
                java.util.List<emu.grasscutter.game.home.HomeNPCItem> r5 = r5.deployNPCList
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Z, Ljava/util/List;, Ljava/util/List;, Ljava/util/List;, Ljava/util/List;)Ljava/lang/String;}, HomeBlockItem.HomeBlockItemBuilder(blockId=, unlocked=, deployFurnitureList=, persistentFurnitureList=, deployAnimalList=, deployNPCList=)]}
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.home.HomeBlockItem.HomeBlockItemBuilder.toString():java.lang.String");
        }

        HomeBlockItemBuilder() {
        }

        public HomeBlockItemBuilder blockId(int blockId) {
            this.blockId = blockId;
            return this;
        }

        public HomeBlockItemBuilder unlocked(boolean unlocked) {
            this.unlocked = unlocked;
            return this;
        }

        public HomeBlockItemBuilder deployFurnitureList(List<HomeFurnitureItem> deployFurnitureList) {
            this.deployFurnitureList = deployFurnitureList;
            return this;
        }

        public HomeBlockItemBuilder persistentFurnitureList(List<HomeFurnitureItem> persistentFurnitureList) {
            this.persistentFurnitureList = persistentFurnitureList;
            return this;
        }

        public HomeBlockItemBuilder deployAnimalList(List<HomeAnimalItem> deployAnimalList) {
            this.deployAnimalList = deployAnimalList;
            return this;
        }

        public HomeBlockItemBuilder deployNPCList(List<HomeNPCItem> deployNPCList) {
            this.deployNPCList = deployNPCList;
            return this;
        }

        public HomeBlockItem build() {
            return new HomeBlockItem(this.blockId, this.unlocked, this.deployFurnitureList, this.persistentFurnitureList, this.deployAnimalList, this.deployNPCList);
        }
    }

    public void setBlockId(int blockId) {
        this.blockId = blockId;
    }

    public void setUnlocked(boolean unlocked) {
        this.unlocked = unlocked;
    }

    public void setDeployFurnitureList(List<HomeFurnitureItem> deployFurnitureList) {
        this.deployFurnitureList = deployFurnitureList;
    }

    public void setPersistentFurnitureList(List<HomeFurnitureItem> persistentFurnitureList) {
        this.persistentFurnitureList = persistentFurnitureList;
    }

    public void setDeployAnimalList(List<HomeAnimalItem> deployAnimalList) {
        this.deployAnimalList = deployAnimalList;
    }

    public void setDeployNPCList(List<HomeNPCItem> deployNPCList) {
        this.deployNPCList = deployNPCList;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof HomeBlockItem)) {
            return false;
        }
        HomeBlockItem other = (HomeBlockItem) o;
        if (!other.canEqual(this) || getBlockId() != other.getBlockId() || isUnlocked() != other.isUnlocked()) {
            return false;
        }
        Object this$deployFurnitureList = getDeployFurnitureList();
        Object other$deployFurnitureList = other.getDeployFurnitureList();
        if (this$deployFurnitureList == null) {
            if (other$deployFurnitureList != null) {
                return false;
            }
        } else if (!this$deployFurnitureList.equals(other$deployFurnitureList)) {
            return false;
        }
        Object this$persistentFurnitureList = getPersistentFurnitureList();
        Object other$persistentFurnitureList = other.getPersistentFurnitureList();
        if (this$persistentFurnitureList == null) {
            if (other$persistentFurnitureList != null) {
                return false;
            }
        } else if (!this$persistentFurnitureList.equals(other$persistentFurnitureList)) {
            return false;
        }
        Object this$deployAnimalList = getDeployAnimalList();
        Object other$deployAnimalList = other.getDeployAnimalList();
        if (this$deployAnimalList == null) {
            if (other$deployAnimalList != null) {
                return false;
            }
        } else if (!this$deployAnimalList.equals(other$deployAnimalList)) {
            return false;
        }
        Object this$deployNPCList = getDeployNPCList();
        Object other$deployNPCList = other.getDeployNPCList();
        return this$deployNPCList == null ? other$deployNPCList == null : this$deployNPCList.equals(other$deployNPCList);
    }

    protected boolean canEqual(Object other) {
        return other instanceof HomeBlockItem;
    }

    public int hashCode() {
        int result = (((1 * 59) + getBlockId()) * 59) + (isUnlocked() ? 79 : 97);
        Object $deployFurnitureList = getDeployFurnitureList();
        int result2 = (result * 59) + ($deployFurnitureList == null ? 43 : $deployFurnitureList.hashCode());
        Object $persistentFurnitureList = getPersistentFurnitureList();
        int result3 = (result2 * 59) + ($persistentFurnitureList == null ? 43 : $persistentFurnitureList.hashCode());
        Object $deployAnimalList = getDeployAnimalList();
        int result4 = (result3 * 59) + ($deployAnimalList == null ? 43 : $deployAnimalList.hashCode());
        Object $deployNPCList = getDeployNPCList();
        return (result4 * 59) + ($deployNPCList == null ? 43 : $deployNPCList.hashCode());
    }

    HomeBlockItem(int blockId, boolean unlocked, List<HomeFurnitureItem> deployFurnitureList, List<HomeFurnitureItem> persistentFurnitureList, List<HomeAnimalItem> deployAnimalList, List<HomeNPCItem> deployNPCList) {
        this.blockId = blockId;
        this.unlocked = unlocked;
        this.deployFurnitureList = deployFurnitureList;
        this.persistentFurnitureList = persistentFurnitureList;
        this.deployAnimalList = deployAnimalList;
        this.deployNPCList = deployNPCList;
    }

    /* renamed from: of */
    public static HomeBlockItemBuilder m1199of() {
        return new HomeBlockItemBuilder();
    }

    public int getBlockId() {
        return this.blockId;
    }

    public boolean isUnlocked() {
        return this.unlocked;
    }

    public List<HomeFurnitureItem> getDeployFurnitureList() {
        return this.deployFurnitureList;
    }

    public List<HomeFurnitureItem> getPersistentFurnitureList() {
        return this.persistentFurnitureList;
    }

    public List<HomeAnimalItem> getDeployAnimalList() {
        return this.deployAnimalList;
    }

    public List<HomeNPCItem> getDeployNPCList() {
        return this.deployNPCList;
    }

    public void update(HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfo homeBlockArrangementInfo) {
        this.blockId = homeBlockArrangementInfo.getBlockId();
        this.deployFurnitureList = homeBlockArrangementInfo.getDeployFurniureListList().stream().map(HomeFurnitureItem::parseFrom).toList();
        this.persistentFurnitureList = homeBlockArrangementInfo.getPersistentFurnitureListList().stream().map(HomeFurnitureItem::parseFrom).toList();
        this.deployAnimalList = homeBlockArrangementInfo.getDeployAnimalListList().stream().map(HomeAnimalItem::parseFrom).toList();
        this.deployNPCList = homeBlockArrangementInfo.getDeployNpcListList().stream().map(HomeNPCItem::parseFrom).toList();
    }

    public int calComfort() {
        return this.deployFurnitureList.stream().mapToInt((v0) -> {
            return v0.getComfort();
        }).sum();
    }

    public HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfo toProto() {
        HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfo.Builder proto = HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfo.newBuilder().setBlockId(this.blockId).setIsUnlocked(this.unlocked).setComfortValue(calComfort());
        this.deployFurnitureList.forEach(f -> {
            proto.addDeployFurniureList(f.toProto());
        });
        this.persistentFurnitureList.forEach(f -> {
            proto.addPersistentFurnitureList(f.toProto());
        });
        this.deployAnimalList.forEach(f -> {
            proto.addDeployAnimalList(f.toProto());
        });
        this.deployNPCList.forEach(f -> {
            proto.addDeployNpcList(f.toProto());
        });
        return proto.build();
    }

    public static HomeBlockItem parseFrom(HomeworldDefaultSaveData.HomeBlock homeBlock) {
        List<HomeFurnitureItem> list;
        List<HomeFurnitureItem> list2;
        HomeBlockItemBuilder unlocked = m1199of().blockId(homeBlock.getBlockId()).unlocked(homeBlock.getFurnitures() != null);
        if (homeBlock.getFurnitures() == null) {
            list = List.of();
        } else {
            list = homeBlock.getFurnitures().stream().map(HomeFurnitureItem::parseFrom).toList();
        }
        HomeBlockItemBuilder deployFurnitureList = unlocked.deployFurnitureList(list);
        if (homeBlock.getPersistentFurnitures() == null) {
            list2 = List.of();
        } else {
            list2 = homeBlock.getPersistentFurnitures().stream().map(HomeFurnitureItem::parseFrom).toList();
        }
        return deployFurnitureList.persistentFurnitureList(list2).deployAnimalList(List.of()).deployNPCList(List.of()).build();
    }
}
