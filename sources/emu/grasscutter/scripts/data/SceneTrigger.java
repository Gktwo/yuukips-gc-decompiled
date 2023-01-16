package emu.grasscutter.scripts.data;

/* loaded from: grasscutter.jar:emu/grasscutter/scripts/data/SceneTrigger.class */
public class SceneTrigger {
    public String name;
    public int config_id;
    public int event;
    public String source;
    public String condition;
    public String action;
    public transient SceneGroup currentGroup;

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
    /*  JADX ERROR: Failed to decode insn: 0x0018: INVOKE_CUSTOM r0, r1, r2, r3, r4, r5, method: emu.grasscutter.scripts.data.SceneTrigger.toString():java.lang.String
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, I, I, Ljava/lang/String;, Ljava/lang/String;, Ljava/lang/String;)Ljava/lang/String;}, SceneTrigger{name='', config_id=, event=, source='', condition='', action=''}]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, I, I, Ljava/lang/String;, Ljava/lang/String;, Ljava/lang/String;)Ljava/lang/String;}, SceneTrigger{name='', config_id=, event=, source='', condition='', action=''}]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public java.lang.String toString() {
        /*
            r7 = this;
            r0 = r7
            java.lang.String r0 = r0.name
            r1 = r7
            int r1 = r1.config_id
            r2 = r7
            int r2 = r2.event
            r3 = r7
            java.lang.String r3 = r3.source
            r4 = r7
            java.lang.String r4 = r4.condition
            r5 = r7
            java.lang.String r5 = r5.action
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, I, I, Ljava/lang/String;, Ljava/lang/String;, Ljava/lang/String;)Ljava/lang/String;}, SceneTrigger{name='', config_id=, event=, source='', condition='', action=''}]}
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.scripts.data.SceneTrigger.toString():java.lang.String");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setConfig_id(int config_id) {
        this.config_id = config_id;
    }

    public void setEvent(int event) {
        this.event = event;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setCurrentGroup(SceneGroup currentGroup) {
        this.currentGroup = currentGroup;
    }

    public boolean equals(Object obj) {
        if (obj instanceof SceneTrigger) {
            return this.name.equals(((SceneTrigger) obj).name);
        }
        return equals(obj);
    }

    public int hashCode() {
        return this.name.hashCode();
    }
}
