package emu.grasscutter.game.home;

import dev.morphia.annotations.AbstractC1283Id;
import dev.morphia.annotations.Entity;
import emu.grasscutter.net.proto.FurnitureMakeDataOuterClass;

@Entity
/* loaded from: grasscutter.jar:emu/grasscutter/game/home/FurnitureMakeSlotItem.class */
public class FurnitureMakeSlotItem {
    @AbstractC1283Id
    private int index;
    private int makeId;
    private int avatarId;
    private int beginTime;
    private int durTime;

    /*  JADX ERROR: Dependency scan failed at insn: 0x0014: INVOKE_CUSTOM r-5, r-4, r-3, r-2, r-1
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
    /*  JADX ERROR: Failed to decode insn: 0x0014: INVOKE_CUSTOM r0, r1, r2, r3, r4, method: emu.grasscutter.game.home.FurnitureMakeSlotItem.toString():java.lang.String
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I, I, I, I)Ljava/lang/String;}, FurnitureMakeSlotItem(index=, makeId=, avatarId=, beginTime=, durTime=)]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I, I, I, I)Ljava/lang/String;}, FurnitureMakeSlotItem(index=, makeId=, avatarId=, beginTime=, durTime=)]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public java.lang.String toString() {
        /*
            r6 = this;
            r0 = r6
            int r0 = r0.getIndex()
            r1 = r6
            int r1 = r1.getMakeId()
            r2 = r6
            int r2 = r2.getAvatarId()
            r3 = r6
            int r3 = r3.getBeginTime()
            r4 = r6
            int r4 = r4.getDurTime()
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I, I, I, I)Ljava/lang/String;}, FurnitureMakeSlotItem(index=, makeId=, avatarId=, beginTime=, durTime=)]}
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.home.FurnitureMakeSlotItem.toString():java.lang.String");
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setMakeId(int makeId) {
        this.makeId = makeId;
    }

    public void setAvatarId(int avatarId) {
        this.avatarId = avatarId;
    }

    public void setBeginTime(int beginTime) {
        this.beginTime = beginTime;
    }

    public void setDurTime(int durTime) {
        this.durTime = durTime;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof FurnitureMakeSlotItem)) {
            return false;
        }
        FurnitureMakeSlotItem other = (FurnitureMakeSlotItem) o;
        return other.canEqual(this) && getIndex() == other.getIndex() && getMakeId() == other.getMakeId() && getAvatarId() == other.getAvatarId() && getBeginTime() == other.getBeginTime() && getDurTime() == other.getDurTime();
    }

    protected boolean canEqual(Object other) {
        return other instanceof FurnitureMakeSlotItem;
    }

    public int hashCode() {
        return (((((((((1 * 59) + getIndex()) * 59) + getMakeId()) * 59) + getAvatarId()) * 59) + getBeginTime()) * 59) + getDurTime();
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/game/home/FurnitureMakeSlotItem$FurnitureMakeSlotItemBuilder.class */
    public static class FurnitureMakeSlotItemBuilder {
        private int index;
        private int makeId;
        private int avatarId;
        private int beginTime;
        private int durTime;

        /*  JADX ERROR: Dependency scan failed at insn: 0x0014: INVOKE_CUSTOM r-5, r-4, r-3, r-2, r-1
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
        /*  JADX ERROR: Failed to decode insn: 0x0014: INVOKE_CUSTOM r0, r1, r2, r3, r4, method: emu.grasscutter.game.home.FurnitureMakeSlotItem.FurnitureMakeSlotItemBuilder.toString():java.lang.String
            jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I, I, I, I)Ljava/lang/String;}, FurnitureMakeSlotItem.FurnitureMakeSlotItemBuilder(index=, makeId=, avatarId=, beginTime=, durTime=)]}
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
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I, I, I, I)Ljava/lang/String;}, FurnitureMakeSlotItem.FurnitureMakeSlotItemBuilder(index=, makeId=, avatarId=, beginTime=, durTime=)]}
            	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
            	... 12 more
            */
        public java.lang.String toString() {
            /*
                r6 = this;
                r0 = r6
                int r0 = r0.index
                r1 = r6
                int r1 = r1.makeId
                r2 = r6
                int r2 = r2.avatarId
                r3 = r6
                int r3 = r3.beginTime
                r4 = r6
                int r4 = r4.durTime
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I, I, I, I)Ljava/lang/String;}, FurnitureMakeSlotItem.FurnitureMakeSlotItemBuilder(index=, makeId=, avatarId=, beginTime=, durTime=)]}
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.home.FurnitureMakeSlotItem.FurnitureMakeSlotItemBuilder.toString():java.lang.String");
        }

        FurnitureMakeSlotItemBuilder() {
        }

        public FurnitureMakeSlotItemBuilder index(int index) {
            this.index = index;
            return this;
        }

        public FurnitureMakeSlotItemBuilder makeId(int makeId) {
            this.makeId = makeId;
            return this;
        }

        public FurnitureMakeSlotItemBuilder avatarId(int avatarId) {
            this.avatarId = avatarId;
            return this;
        }

        public FurnitureMakeSlotItemBuilder beginTime(int beginTime) {
            this.beginTime = beginTime;
            return this;
        }

        public FurnitureMakeSlotItemBuilder durTime(int durTime) {
            this.durTime = durTime;
            return this;
        }

        public FurnitureMakeSlotItem build() {
            return new FurnitureMakeSlotItem(this.index, this.makeId, this.avatarId, this.beginTime, this.durTime);
        }
    }

    FurnitureMakeSlotItem(int index, int makeId, int avatarId, int beginTime, int durTime) {
        this.index = index;
        this.makeId = makeId;
        this.avatarId = avatarId;
        this.beginTime = beginTime;
        this.durTime = durTime;
    }

    /* renamed from: of */
    public static FurnitureMakeSlotItemBuilder m1203of() {
        return new FurnitureMakeSlotItemBuilder();
    }

    public int getIndex() {
        return this.index;
    }

    public int getMakeId() {
        return this.makeId;
    }

    public int getAvatarId() {
        return this.avatarId;
    }

    public int getBeginTime() {
        return this.beginTime;
    }

    public int getDurTime() {
        return this.durTime;
    }

    public FurnitureMakeDataOuterClass.FurnitureMakeData toProto() {
        return FurnitureMakeDataOuterClass.FurnitureMakeData.newBuilder().setIndex(this.index).setAvatarId(this.avatarId).setMakeId(this.makeId).setBeginTime(this.beginTime).setDurTime(this.durTime).build();
    }
}
