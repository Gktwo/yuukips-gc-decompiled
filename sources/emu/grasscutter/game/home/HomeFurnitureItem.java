package emu.grasscutter.game.home;

import dev.morphia.annotations.Entity;
import emu.grasscutter.data.GameData;
import emu.grasscutter.data.binout.HomeworldDefaultSaveData;
import emu.grasscutter.data.excels.ItemData;
import emu.grasscutter.net.proto.HomeFurnitureDataOuterClass;
import emu.grasscutter.net.proto.HomeMarkPointFurnitureDataOuterClass;
import emu.grasscutter.utils.Position;

@Entity
/* loaded from: grasscutter.jar:emu/grasscutter/game/home/HomeFurnitureItem.class */
public class HomeFurnitureItem {
    private int furnitureId;
    private int guid;
    private int parentFurnitureIndex;
    private Position spawnPos;
    private Position spawnRot;
    private int version;

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
    /*  JADX ERROR: Failed to decode insn: 0x0018: INVOKE_CUSTOM r0, r1, r2, r3, r4, r5, method: emu.grasscutter.game.home.HomeFurnitureItem.toString():java.lang.String
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I, I, Lemu/grasscutter/utils/Position;, Lemu/grasscutter/utils/Position;, I)Ljava/lang/String;}, HomeFurnitureItem(furnitureId=, guid=, parentFurnitureIndex=, spawnPos=, spawnRot=, version=)]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I, I, Lemu/grasscutter/utils/Position;, Lemu/grasscutter/utils/Position;, I)Ljava/lang/String;}, HomeFurnitureItem(furnitureId=, guid=, parentFurnitureIndex=, spawnPos=, spawnRot=, version=)]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public java.lang.String toString() {
        /*
            r7 = this;
            r0 = r7
            int r0 = r0.getFurnitureId()
            r1 = r7
            int r1 = r1.getGuid()
            r2 = r7
            int r2 = r2.getParentFurnitureIndex()
            r3 = r7
            emu.grasscutter.utils.Position r3 = r3.getSpawnPos()
            r4 = r7
            emu.grasscutter.utils.Position r4 = r4.getSpawnRot()
            r5 = r7
            int r5 = r5.getVersion()
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I, I, Lemu/grasscutter/utils/Position;, Lemu/grasscutter/utils/Position;, I)Ljava/lang/String;}, HomeFurnitureItem(furnitureId=, guid=, parentFurnitureIndex=, spawnPos=, spawnRot=, version=)]}
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.home.HomeFurnitureItem.toString():java.lang.String");
    }

    public void setFurnitureId(int furnitureId) {
        this.furnitureId = furnitureId;
    }

    public void setGuid(int guid) {
        this.guid = guid;
    }

    public void setParentFurnitureIndex(int parentFurnitureIndex) {
        this.parentFurnitureIndex = parentFurnitureIndex;
    }

    public void setSpawnPos(Position spawnPos) {
        this.spawnPos = spawnPos;
    }

    public void setSpawnRot(Position spawnRot) {
        this.spawnRot = spawnRot;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof HomeFurnitureItem)) {
            return false;
        }
        HomeFurnitureItem other = (HomeFurnitureItem) o;
        if (!other.canEqual(this) || getFurnitureId() != other.getFurnitureId() || getGuid() != other.getGuid() || getParentFurnitureIndex() != other.getParentFurnitureIndex() || getVersion() != other.getVersion()) {
            return false;
        }
        Object this$spawnPos = getSpawnPos();
        Object other$spawnPos = other.getSpawnPos();
        if (this$spawnPos == null) {
            if (other$spawnPos != null) {
                return false;
            }
        } else if (!this$spawnPos.equals(other$spawnPos)) {
            return false;
        }
        Object this$spawnRot = getSpawnRot();
        Object other$spawnRot = other.getSpawnRot();
        return this$spawnRot == null ? other$spawnRot == null : this$spawnRot.equals(other$spawnRot);
    }

    protected boolean canEqual(Object other) {
        return other instanceof HomeFurnitureItem;
    }

    public int hashCode() {
        int result = (((((((1 * 59) + getFurnitureId()) * 59) + getGuid()) * 59) + getParentFurnitureIndex()) * 59) + getVersion();
        Object $spawnPos = getSpawnPos();
        int result2 = (result * 59) + ($spawnPos == null ? 43 : $spawnPos.hashCode());
        Object $spawnRot = getSpawnRot();
        return (result2 * 59) + ($spawnRot == null ? 43 : $spawnRot.hashCode());
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/game/home/HomeFurnitureItem$HomeFurnitureItemBuilder.class */
    public static class HomeFurnitureItemBuilder {
        private int furnitureId;
        private int guid;
        private int parentFurnitureIndex;
        private Position spawnPos;
        private Position spawnRot;
        private int version;

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
        /*  JADX ERROR: Failed to decode insn: 0x0018: INVOKE_CUSTOM r0, r1, r2, r3, r4, r5, method: emu.grasscutter.game.home.HomeFurnitureItem.HomeFurnitureItemBuilder.toString():java.lang.String
            jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I, I, Lemu/grasscutter/utils/Position;, Lemu/grasscutter/utils/Position;, I)Ljava/lang/String;}, HomeFurnitureItem.HomeFurnitureItemBuilder(furnitureId=, guid=, parentFurnitureIndex=, spawnPos=, spawnRot=, version=)]}
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
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I, I, Lemu/grasscutter/utils/Position;, Lemu/grasscutter/utils/Position;, I)Ljava/lang/String;}, HomeFurnitureItem.HomeFurnitureItemBuilder(furnitureId=, guid=, parentFurnitureIndex=, spawnPos=, spawnRot=, version=)]}
            	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
            	... 12 more
            */
        public java.lang.String toString() {
            /*
                r7 = this;
                r0 = r7
                int r0 = r0.furnitureId
                r1 = r7
                int r1 = r1.guid
                r2 = r7
                int r2 = r2.parentFurnitureIndex
                r3 = r7
                emu.grasscutter.utils.Position r3 = r3.spawnPos
                r4 = r7
                emu.grasscutter.utils.Position r4 = r4.spawnRot
                r5 = r7
                int r5 = r5.version
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I, I, Lemu/grasscutter/utils/Position;, Lemu/grasscutter/utils/Position;, I)Ljava/lang/String;}, HomeFurnitureItem.HomeFurnitureItemBuilder(furnitureId=, guid=, parentFurnitureIndex=, spawnPos=, spawnRot=, version=)]}
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.home.HomeFurnitureItem.HomeFurnitureItemBuilder.toString():java.lang.String");
        }

        HomeFurnitureItemBuilder() {
        }

        public HomeFurnitureItemBuilder furnitureId(int furnitureId) {
            this.furnitureId = furnitureId;
            return this;
        }

        public HomeFurnitureItemBuilder guid(int guid) {
            this.guid = guid;
            return this;
        }

        public HomeFurnitureItemBuilder parentFurnitureIndex(int parentFurnitureIndex) {
            this.parentFurnitureIndex = parentFurnitureIndex;
            return this;
        }

        public HomeFurnitureItemBuilder spawnPos(Position spawnPos) {
            this.spawnPos = spawnPos;
            return this;
        }

        public HomeFurnitureItemBuilder spawnRot(Position spawnRot) {
            this.spawnRot = spawnRot;
            return this;
        }

        public HomeFurnitureItemBuilder version(int version) {
            this.version = version;
            return this;
        }

        public HomeFurnitureItem build() {
            return new HomeFurnitureItem(this.furnitureId, this.guid, this.parentFurnitureIndex, this.spawnPos, this.spawnRot, this.version);
        }
    }

    HomeFurnitureItem(int furnitureId, int guid, int parentFurnitureIndex, Position spawnPos, Position spawnRot, int version) {
        this.furnitureId = furnitureId;
        this.guid = guid;
        this.parentFurnitureIndex = parentFurnitureIndex;
        this.spawnPos = spawnPos;
        this.spawnRot = spawnRot;
        this.version = version;
    }

    /* renamed from: of */
    public static HomeFurnitureItemBuilder m1198of() {
        return new HomeFurnitureItemBuilder();
    }

    public int getFurnitureId() {
        return this.furnitureId;
    }

    public int getGuid() {
        return this.guid;
    }

    public int getParentFurnitureIndex() {
        return this.parentFurnitureIndex;
    }

    public Position getSpawnPos() {
        return this.spawnPos;
    }

    public Position getSpawnRot() {
        return this.spawnRot;
    }

    public int getVersion() {
        return this.version;
    }

    public HomeFurnitureDataOuterClass.HomeFurnitureData toProto() {
        return HomeFurnitureDataOuterClass.HomeFurnitureData.newBuilder().setFurnitureId(this.furnitureId).setGuid(this.guid).setParentFurnitureIndex(this.parentFurnitureIndex).setSpawnPos(this.spawnPos.toProto()).setSpawnRot(this.spawnRot.toProto()).setVersion(this.version).build();
    }

    public HomeMarkPointFurnitureDataOuterClass.HomeMarkPointFurnitureData toMarkPointProto(int type) {
        return HomeMarkPointFurnitureDataOuterClass.HomeMarkPointFurnitureData.newBuilder().setFurnitureId(this.furnitureId).setGuid(this.guid).setFurnitureType(type).setPos(this.spawnPos.toProto()).build();
    }

    public static HomeFurnitureItem parseFrom(HomeFurnitureDataOuterClass.HomeFurnitureData homeFurnitureData) {
        return m1198of().furnitureId(homeFurnitureData.getFurnitureId()).guid(homeFurnitureData.getGuid()).parentFurnitureIndex(homeFurnitureData.getParentFurnitureIndex()).spawnPos(new Position(homeFurnitureData.getSpawnPos())).spawnRot(new Position(homeFurnitureData.getSpawnRot())).version(homeFurnitureData.getVersion()).build();
    }

    public static HomeFurnitureItem parseFrom(HomeworldDefaultSaveData.HomeFurniture homeFurniture) {
        return m1198of().furnitureId(homeFurniture.getId()).parentFurnitureIndex(1).spawnPos(homeFurniture.getPos() == null ? new Position() : homeFurniture.getPos()).spawnRot(homeFurniture.getRot() == null ? new Position() : homeFurniture.getRot()).build();
    }

    public ItemData getAsItem() {
        return GameData.getItemDataMap().get(this.furnitureId);
    }

    public int getComfort() {
        ItemData item = getAsItem();
        if (item == null) {
            return 0;
        }
        return item.getComfort();
    }
}
