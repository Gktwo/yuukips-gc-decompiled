package emu.grasscutter.data.excels;

import com.google.gson.annotations.SerializedName;
import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceType;

@ResourceType(name = {"MonsterSpecialNameExcelConfigData.json"}, loadPriority = ResourceType.LoadPriority.HIGH)
/* loaded from: grasscutter.jar:emu/grasscutter/data/excels/MonsterSpecialNameData.class */
public class MonsterSpecialNameData extends GameResource {
    @SerializedName(value = "specialNameId", alternate = {"specialNameID"})
    private int specialNameId;
    @SerializedName(value = "specialNameLabId", alternate = {"specialNameLabID"})
    private int specialNameLabId;
    private long specialNameTextMapHash;

    /*  JADX ERROR: Dependency scan failed at insn: 0x000C: INVOKE_CUSTOM r-3, r-2, r-1, r0
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
    /*  JADX ERROR: Failed to decode insn: 0x000C: INVOKE_CUSTOM r0, r1, r2, r0, method: emu.grasscutter.data.excels.MonsterSpecialNameData.toString():java.lang.String
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I, J)Ljava/lang/String;}, MonsterSpecialNameData(specialNameId=, specialNameLabId=, specialNameTextMapHash=)]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I, J)Ljava/lang/String;}, MonsterSpecialNameData(specialNameId=, specialNameLabId=, specialNameTextMapHash=)]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public java.lang.String toString() {
        /*
            r5 = this;
            r0 = r5
            int r0 = r0.getSpecialNameId()
            r1 = r5
            int r1 = r1.getSpecialNameLabId()
            r2 = r5
            long r2 = r2.getSpecialNameTextMapHash()
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I, J)Ljava/lang/String;}, MonsterSpecialNameData(specialNameId=, specialNameLabId=, specialNameTextMapHash=)]}
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.data.excels.MonsterSpecialNameData.toString():java.lang.String");
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof MonsterSpecialNameData)) {
            return false;
        }
        MonsterSpecialNameData other = (MonsterSpecialNameData) o;
        return other.canEqual(this) && getSpecialNameId() == other.getSpecialNameId() && getSpecialNameLabId() == other.getSpecialNameLabId() && getSpecialNameTextMapHash() == other.getSpecialNameTextMapHash();
    }

    protected boolean canEqual(Object other) {
        return other instanceof MonsterSpecialNameData;
    }

    public int hashCode() {
        int result = (((1 * 59) + getSpecialNameId()) * 59) + getSpecialNameLabId();
        long $specialNameTextMapHash = getSpecialNameTextMapHash();
        return (result * 59) + ((int) (($specialNameTextMapHash >>> 32) ^ $specialNameTextMapHash));
    }

    public void setSpecialNameId(int specialNameId) {
        this.specialNameId = specialNameId;
    }

    public void setSpecialNameLabId(int specialNameLabId) {
        this.specialNameLabId = specialNameLabId;
    }

    public void setSpecialNameTextMapHash(long specialNameTextMapHash) {
        this.specialNameTextMapHash = specialNameTextMapHash;
    }

    public int getSpecialNameId() {
        return this.specialNameId;
    }

    public int getSpecialNameLabId() {
        return this.specialNameLabId;
    }

    public long getSpecialNameTextMapHash() {
        return this.specialNameTextMapHash;
    }

    @Override // emu.grasscutter.data.GameResource
    public int getId() {
        return this.specialNameId;
    }
}
