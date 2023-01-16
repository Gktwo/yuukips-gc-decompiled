package emu.grasscutter.game.home;

import dev.morphia.annotations.Entity;
import emu.grasscutter.net.proto.HomeAnimalDataOuterClass;
import emu.grasscutter.utils.Position;

@Entity
/* loaded from: grasscutter.jar:emu/grasscutter/game/home/HomeAnimalItem.class */
public class HomeAnimalItem {
    private int furnitureId;
    private Position spawnPos;
    private Position spawnRot;

    /*  JADX ERROR: Dependency scan failed at insn: 0x000C: INVOKE_CUSTOM r-3, r-2, r-1
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
    /*  JADX ERROR: Failed to decode insn: 0x000C: INVOKE_CUSTOM r0, r1, r2, method: emu.grasscutter.game.home.HomeAnimalItem.toString():java.lang.String
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Lemu/grasscutter/utils/Position;, Lemu/grasscutter/utils/Position;)Ljava/lang/String;}, HomeAnimalItem(furnitureId=, spawnPos=, spawnRot=)]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Lemu/grasscutter/utils/Position;, Lemu/grasscutter/utils/Position;)Ljava/lang/String;}, HomeAnimalItem(furnitureId=, spawnPos=, spawnRot=)]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public java.lang.String toString() {
        /*
            r4 = this;
            r0 = r4
            int r0 = r0.getFurnitureId()
            r1 = r4
            emu.grasscutter.utils.Position r1 = r1.getSpawnPos()
            r2 = r4
            emu.grasscutter.utils.Position r2 = r2.getSpawnRot()
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Lemu/grasscutter/utils/Position;, Lemu/grasscutter/utils/Position;)Ljava/lang/String;}, HomeAnimalItem(furnitureId=, spawnPos=, spawnRot=)]}
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.home.HomeAnimalItem.toString():java.lang.String");
    }

    public void setFurnitureId(int furnitureId) {
        this.furnitureId = furnitureId;
    }

    public void setSpawnPos(Position spawnPos) {
        this.spawnPos = spawnPos;
    }

    public void setSpawnRot(Position spawnRot) {
        this.spawnRot = spawnRot;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof HomeAnimalItem)) {
            return false;
        }
        HomeAnimalItem other = (HomeAnimalItem) o;
        if (!other.canEqual(this) || getFurnitureId() != other.getFurnitureId()) {
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
        return other instanceof HomeAnimalItem;
    }

    public int hashCode() {
        int result = (1 * 59) + getFurnitureId();
        Object $spawnPos = getSpawnPos();
        int result2 = (result * 59) + ($spawnPos == null ? 43 : $spawnPos.hashCode());
        Object $spawnRot = getSpawnRot();
        return (result2 * 59) + ($spawnRot == null ? 43 : $spawnRot.hashCode());
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/game/home/HomeAnimalItem$HomeAnimalItemBuilder.class */
    public static class HomeAnimalItemBuilder {
        private int furnitureId;
        private Position spawnPos;
        private Position spawnRot;

        /*  JADX ERROR: Dependency scan failed at insn: 0x000C: INVOKE_CUSTOM r-3, r-2, r-1
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
        /*  JADX ERROR: Failed to decode insn: 0x000C: INVOKE_CUSTOM r0, r1, r2, method: emu.grasscutter.game.home.HomeAnimalItem.HomeAnimalItemBuilder.toString():java.lang.String
            jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Lemu/grasscutter/utils/Position;, Lemu/grasscutter/utils/Position;)Ljava/lang/String;}, HomeAnimalItem.HomeAnimalItemBuilder(furnitureId=, spawnPos=, spawnRot=)]}
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
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Lemu/grasscutter/utils/Position;, Lemu/grasscutter/utils/Position;)Ljava/lang/String;}, HomeAnimalItem.HomeAnimalItemBuilder(furnitureId=, spawnPos=, spawnRot=)]}
            	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
            	... 12 more
            */
        public java.lang.String toString() {
            /*
                r4 = this;
                r0 = r4
                int r0 = r0.furnitureId
                r1 = r4
                emu.grasscutter.utils.Position r1 = r1.spawnPos
                r2 = r4
                emu.grasscutter.utils.Position r2 = r2.spawnRot
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Lemu/grasscutter/utils/Position;, Lemu/grasscutter/utils/Position;)Ljava/lang/String;}, HomeAnimalItem.HomeAnimalItemBuilder(furnitureId=, spawnPos=, spawnRot=)]}
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.home.HomeAnimalItem.HomeAnimalItemBuilder.toString():java.lang.String");
        }

        HomeAnimalItemBuilder() {
        }

        public HomeAnimalItemBuilder furnitureId(int furnitureId) {
            this.furnitureId = furnitureId;
            return this;
        }

        public HomeAnimalItemBuilder spawnPos(Position spawnPos) {
            this.spawnPos = spawnPos;
            return this;
        }

        public HomeAnimalItemBuilder spawnRot(Position spawnRot) {
            this.spawnRot = spawnRot;
            return this;
        }

        public HomeAnimalItem build() {
            return new HomeAnimalItem(this.furnitureId, this.spawnPos, this.spawnRot);
        }
    }

    HomeAnimalItem(int furnitureId, Position spawnPos, Position spawnRot) {
        this.furnitureId = furnitureId;
        this.spawnPos = spawnPos;
        this.spawnRot = spawnRot;
    }

    /* renamed from: of */
    public static HomeAnimalItemBuilder m1200of() {
        return new HomeAnimalItemBuilder();
    }

    public int getFurnitureId() {
        return this.furnitureId;
    }

    public Position getSpawnPos() {
        return this.spawnPos;
    }

    public Position getSpawnRot() {
        return this.spawnRot;
    }

    public HomeAnimalDataOuterClass.HomeAnimalData toProto() {
        return HomeAnimalDataOuterClass.HomeAnimalData.newBuilder().setFurnitureId(this.furnitureId).setSpawnPos(this.spawnPos.toProto()).setSpawnRot(this.spawnRot.toProto()).build();
    }

    public static HomeAnimalItem parseFrom(HomeAnimalDataOuterClass.HomeAnimalData homeAnimalData) {
        return m1200of().furnitureId(homeAnimalData.getFurnitureId()).spawnPos(new Position(homeAnimalData.getSpawnPos())).spawnRot(new Position(homeAnimalData.getSpawnRot())).build();
    }
}
