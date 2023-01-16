package emu.grasscutter.data.binout;

import com.google.gson.annotations.SerializedName;
import com.mongodb.DBCollection;
import emu.grasscutter.utils.Position;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/data/binout/SceneNpcBornEntry.class */
public class SceneNpcBornEntry {
    @SerializedName(value = "id", alternate = {DBCollection.ID_FIELD_NAME, "ID"})

    /* renamed from: id */
    private int f503id;
    @SerializedName(value = "configId", alternate = {"_configId"})
    private int configId;
    @SerializedName(value = "pos", alternate = {"_pos"})
    private Position pos;
    @SerializedName(value = "rot", alternate = {"_rot"})
    private Position rot;
    @SerializedName(value = "groupId", alternate = {"_groupId"})
    private int groupId;
    @SerializedName(value = "suiteIdList", alternate = {"_suiteIdList"})
    private List<Integer> suiteIdList;

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
    /*  JADX ERROR: Failed to decode insn: 0x0018: INVOKE_CUSTOM r0, r1, r2, r3, r4, r5, method: emu.grasscutter.data.binout.SceneNpcBornEntry.toString():java.lang.String
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I, Lemu/grasscutter/utils/Position;, Lemu/grasscutter/utils/Position;, I, Ljava/util/List;)Ljava/lang/String;}, SceneNpcBornEntry(id=, configId=, pos=, rot=, groupId=, suiteIdList=)]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I, Lemu/grasscutter/utils/Position;, Lemu/grasscutter/utils/Position;, I, Ljava/util/List;)Ljava/lang/String;}, SceneNpcBornEntry(id=, configId=, pos=, rot=, groupId=, suiteIdList=)]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public java.lang.String toString() {
        /*
            r7 = this;
            r0 = r7
            int r0 = r0.getId()
            r1 = r7
            int r1 = r1.getConfigId()
            r2 = r7
            emu.grasscutter.utils.Position r2 = r2.getPos()
            r3 = r7
            emu.grasscutter.utils.Position r3 = r3.getRot()
            r4 = r7
            int r4 = r4.getGroupId()
            r5 = r7
            java.util.List r5 = r5.getSuiteIdList()
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I, Lemu/grasscutter/utils/Position;, Lemu/grasscutter/utils/Position;, I, Ljava/util/List;)Ljava/lang/String;}, SceneNpcBornEntry(id=, configId=, pos=, rot=, groupId=, suiteIdList=)]}
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.data.binout.SceneNpcBornEntry.toString():java.lang.String");
    }

    public void setId(int id) {
        this.f503id = id;
    }

    public void setConfigId(int configId) {
        this.configId = configId;
    }

    public void setPos(Position pos) {
        this.pos = pos;
    }

    public void setRot(Position rot) {
        this.rot = rot;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public void setSuiteIdList(List<Integer> suiteIdList) {
        this.suiteIdList = suiteIdList;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof SceneNpcBornEntry)) {
            return false;
        }
        SceneNpcBornEntry other = (SceneNpcBornEntry) o;
        if (!other.canEqual(this) || getId() != other.getId() || getConfigId() != other.getConfigId() || getGroupId() != other.getGroupId()) {
            return false;
        }
        Object this$pos = getPos();
        Object other$pos = other.getPos();
        if (this$pos == null) {
            if (other$pos != null) {
                return false;
            }
        } else if (!this$pos.equals(other$pos)) {
            return false;
        }
        Object this$rot = getRot();
        Object other$rot = other.getRot();
        if (this$rot == null) {
            if (other$rot != null) {
                return false;
            }
        } else if (!this$rot.equals(other$rot)) {
            return false;
        }
        Object this$suiteIdList = getSuiteIdList();
        Object other$suiteIdList = other.getSuiteIdList();
        return this$suiteIdList == null ? other$suiteIdList == null : this$suiteIdList.equals(other$suiteIdList);
    }

    protected boolean canEqual(Object other) {
        return other instanceof SceneNpcBornEntry;
    }

    public int hashCode() {
        int result = (((((1 * 59) + getId()) * 59) + getConfigId()) * 59) + getGroupId();
        Object $pos = getPos();
        int result2 = (result * 59) + ($pos == null ? 43 : $pos.hashCode());
        Object $rot = getRot();
        int result3 = (result2 * 59) + ($rot == null ? 43 : $rot.hashCode());
        Object $suiteIdList = getSuiteIdList();
        return (result3 * 59) + ($suiteIdList == null ? 43 : $suiteIdList.hashCode());
    }

    public int getId() {
        return this.f503id;
    }

    public int getConfigId() {
        return this.configId;
    }

    public Position getPos() {
        return this.pos;
    }

    public Position getRot() {
        return this.rot;
    }

    public int getGroupId() {
        return this.groupId;
    }

    public List<Integer> getSuiteIdList() {
        return this.suiteIdList;
    }
}
