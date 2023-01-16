package emu.grasscutter.data.binout;

import com.github.davidmoten.rtreemulti.RTree;
import com.github.davidmoten.rtreemulti.geometry.Geometry;
import emu.grasscutter.scripts.data.SceneGroup;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: grasscutter.jar:emu/grasscutter/data/binout/SceneNpcBornData.class */
public class SceneNpcBornData {
    private int sceneId;
    private List<SceneNpcBornEntry> bornPosList;
    private transient RTree<SceneNpcBornEntry, Geometry> index;
    private transient Map<Integer, SceneGroup> groups = new ConcurrentHashMap();

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
    /*  JADX ERROR: Failed to decode insn: 0x0010: INVOKE_CUSTOM r0, r1, r2, r3, method: emu.grasscutter.data.binout.SceneNpcBornData.toString():java.lang.String
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Ljava/util/List;, Lcom/github/davidmoten/rtreemulti/RTree;, Ljava/util/Map;)Ljava/lang/String;}, SceneNpcBornData(sceneId=, bornPosList=, index=, groups=)]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Ljava/util/List;, Lcom/github/davidmoten/rtreemulti/RTree;, Ljava/util/Map;)Ljava/lang/String;}, SceneNpcBornData(sceneId=, bornPosList=, index=, groups=)]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public java.lang.String toString() {
        /*
            r5 = this;
            r0 = r5
            int r0 = r0.getSceneId()
            r1 = r5
            java.util.List r1 = r1.getBornPosList()
            r2 = r5
            com.github.davidmoten.rtreemulti.RTree r2 = r2.getIndex()
            r3 = r5
            java.util.Map r3 = r3.getGroups()
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Ljava/util/List;, Lcom/github/davidmoten/rtreemulti/RTree;, Ljava/util/Map;)Ljava/lang/String;}, SceneNpcBornData(sceneId=, bornPosList=, index=, groups=)]}
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.data.binout.SceneNpcBornData.toString():java.lang.String");
    }

    public void setSceneId(int sceneId) {
        this.sceneId = sceneId;
    }

    public void setBornPosList(List<SceneNpcBornEntry> bornPosList) {
        this.bornPosList = bornPosList;
    }

    public void setIndex(RTree<SceneNpcBornEntry, Geometry> index) {
        this.index = index;
    }

    public void setGroups(Map<Integer, SceneGroup> groups) {
        this.groups = groups;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof SceneNpcBornData)) {
            return false;
        }
        SceneNpcBornData other = (SceneNpcBornData) o;
        if (!other.canEqual(this) || getSceneId() != other.getSceneId()) {
            return false;
        }
        Object this$bornPosList = getBornPosList();
        Object other$bornPosList = other.getBornPosList();
        return this$bornPosList == null ? other$bornPosList == null : this$bornPosList.equals(other$bornPosList);
    }

    protected boolean canEqual(Object other) {
        return other instanceof SceneNpcBornData;
    }

    public int hashCode() {
        int result = (1 * 59) + getSceneId();
        Object $bornPosList = getBornPosList();
        return (result * 59) + ($bornPosList == null ? 43 : $bornPosList.hashCode());
    }

    public int getSceneId() {
        return this.sceneId;
    }

    public List<SceneNpcBornEntry> getBornPosList() {
        return this.bornPosList;
    }

    public RTree<SceneNpcBornEntry, Geometry> getIndex() {
        return this.index;
    }

    public Map<Integer, SceneGroup> getGroups() {
        return this.groups;
    }
}
