package emu.grasscutter.game.home;

import dev.morphia.annotations.Entity;
import emu.grasscutter.net.proto.HomeNpcDataOuterClass;
import emu.grasscutter.utils.Position;

@Entity
/* loaded from: grasscutter.jar:emu/grasscutter/game/home/HomeNPCItem.class */
public class HomeNPCItem {
    private int avatarId;
    private Position spawnPos;
    private Position spawnRot;
    private int costumeId;

    /*  JADX ERROR: Dependency scan failed at insn: 0x0010: INVOKE_CUSTOM r-4, r-3, r-2, r-1
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
    /*  JADX ERROR: Failed to decode insn: 0x0010: INVOKE_CUSTOM r0, r1, r2, r3, method: emu.grasscutter.game.home.HomeNPCItem.toString():java.lang.String
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Lemu/grasscutter/utils/Position;, Lemu/grasscutter/utils/Position;, I)Ljava/lang/String;}, HomeNPCItem(avatarId=, spawnPos=, spawnRot=, costumeId=)]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Lemu/grasscutter/utils/Position;, Lemu/grasscutter/utils/Position;, I)Ljava/lang/String;}, HomeNPCItem(avatarId=, spawnPos=, spawnRot=, costumeId=)]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public java.lang.String toString() {
        /*
            r5 = this;
            r0 = r5
            int r0 = r0.getAvatarId()
            r1 = r5
            emu.grasscutter.utils.Position r1 = r1.getSpawnPos()
            r2 = r5
            emu.grasscutter.utils.Position r2 = r2.getSpawnRot()
            r3 = r5
            int r3 = r3.getCostumeId()
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Lemu/grasscutter/utils/Position;, Lemu/grasscutter/utils/Position;, I)Ljava/lang/String;}, HomeNPCItem(avatarId=, spawnPos=, spawnRot=, costumeId=)]}
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.home.HomeNPCItem.toString():java.lang.String");
    }

    public void setAvatarId(int avatarId) {
        this.avatarId = avatarId;
    }

    public void setSpawnPos(Position spawnPos) {
        this.spawnPos = spawnPos;
    }

    public void setSpawnRot(Position spawnRot) {
        this.spawnRot = spawnRot;
    }

    public void setCostumeId(int costumeId) {
        this.costumeId = costumeId;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof HomeNPCItem)) {
            return false;
        }
        HomeNPCItem other = (HomeNPCItem) o;
        if (!other.canEqual(this) || getAvatarId() != other.getAvatarId() || getCostumeId() != other.getCostumeId()) {
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
        return other instanceof HomeNPCItem;
    }

    public int hashCode() {
        int result = (((1 * 59) + getAvatarId()) * 59) + getCostumeId();
        Object $spawnPos = getSpawnPos();
        int result2 = (result * 59) + ($spawnPos == null ? 43 : $spawnPos.hashCode());
        Object $spawnRot = getSpawnRot();
        return (result2 * 59) + ($spawnRot == null ? 43 : $spawnRot.hashCode());
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/game/home/HomeNPCItem$HomeNPCItemBuilder.class */
    public static class HomeNPCItemBuilder {
        private int avatarId;
        private Position spawnPos;
        private Position spawnRot;
        private int costumeId;

        /*  JADX ERROR: Dependency scan failed at insn: 0x0010: INVOKE_CUSTOM r-4, r-3, r-2, r-1
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
        /*  JADX ERROR: Failed to decode insn: 0x0010: INVOKE_CUSTOM r0, r1, r2, r3, method: emu.grasscutter.game.home.HomeNPCItem.HomeNPCItemBuilder.toString():java.lang.String
            jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Lemu/grasscutter/utils/Position;, Lemu/grasscutter/utils/Position;, I)Ljava/lang/String;}, HomeNPCItem.HomeNPCItemBuilder(avatarId=, spawnPos=, spawnRot=, costumeId=)]}
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
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Lemu/grasscutter/utils/Position;, Lemu/grasscutter/utils/Position;, I)Ljava/lang/String;}, HomeNPCItem.HomeNPCItemBuilder(avatarId=, spawnPos=, spawnRot=, costumeId=)]}
            	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
            	... 12 more
            */
        public java.lang.String toString() {
            /*
                r5 = this;
                r0 = r5
                int r0 = r0.avatarId
                r1 = r5
                emu.grasscutter.utils.Position r1 = r1.spawnPos
                r2 = r5
                emu.grasscutter.utils.Position r2 = r2.spawnRot
                r3 = r5
                int r3 = r3.costumeId
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Lemu/grasscutter/utils/Position;, Lemu/grasscutter/utils/Position;, I)Ljava/lang/String;}, HomeNPCItem.HomeNPCItemBuilder(avatarId=, spawnPos=, spawnRot=, costumeId=)]}
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.home.HomeNPCItem.HomeNPCItemBuilder.toString():java.lang.String");
        }

        HomeNPCItemBuilder() {
        }

        public HomeNPCItemBuilder avatarId(int avatarId) {
            this.avatarId = avatarId;
            return this;
        }

        public HomeNPCItemBuilder spawnPos(Position spawnPos) {
            this.spawnPos = spawnPos;
            return this;
        }

        public HomeNPCItemBuilder spawnRot(Position spawnRot) {
            this.spawnRot = spawnRot;
            return this;
        }

        public HomeNPCItemBuilder costumeId(int costumeId) {
            this.costumeId = costumeId;
            return this;
        }

        public HomeNPCItem build() {
            return new HomeNPCItem(this.avatarId, this.spawnPos, this.spawnRot, this.costumeId);
        }
    }

    HomeNPCItem(int avatarId, Position spawnPos, Position spawnRot, int costumeId) {
        this.avatarId = avatarId;
        this.spawnPos = spawnPos;
        this.spawnRot = spawnRot;
        this.costumeId = costumeId;
    }

    /* renamed from: of */
    public static HomeNPCItemBuilder m1197of() {
        return new HomeNPCItemBuilder();
    }

    public int getAvatarId() {
        return this.avatarId;
    }

    public Position getSpawnPos() {
        return this.spawnPos;
    }

    public Position getSpawnRot() {
        return this.spawnRot;
    }

    public int getCostumeId() {
        return this.costumeId;
    }

    public HomeNpcDataOuterClass.HomeNpcData toProto() {
        return HomeNpcDataOuterClass.HomeNpcData.newBuilder().setAvatarId(this.avatarId).setSpawnPos(this.spawnPos.toProto()).setSpawnRot(this.spawnRot.toProto()).setCostumeId(this.costumeId).build();
    }

    public static HomeNPCItem parseFrom(HomeNpcDataOuterClass.HomeNpcData homeNpcData) {
        return m1197of().avatarId(homeNpcData.getAvatarId()).spawnPos(new Position(homeNpcData.getSpawnPos())).spawnRot(new Position(homeNpcData.getSpawnRot())).costumeId(homeNpcData.getCostumeId()).build();
    }
}
