package emu.grasscutter.scripts.data;

/* loaded from: grasscutter.jar:emu/grasscutter/scripts/data/SceneGadget.class */
public class SceneGadget extends SceneObject {
    public int config_id;
    public int gadget_id;
    public int level;
    public int chest_drop_id;
    public int drop_count;
    public String drop_tag;
    boolean showcutscene;
    boolean persistence;
    public int state;
    public int point_type;
    public int owner;
    public SceneBossChest boss_chest;
    public int interact_id;
    public boolean isOneoff;
    public int area_id;
    public int draft_id;

    /*  JADX ERROR: Dependency scan failed at insn: 0x0040: INVOKE_CUSTOM r-16, r-15, r-14, r-13, r-12, r-11, r-10, r-9, r-8, r-7, r-6, r-5, r-4, r-3, r-2, r-1
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
    /*  JADX ERROR: Failed to decode insn: 0x0040: INVOKE_CUSTOM r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, method: emu.grasscutter.scripts.data.SceneGadget.toString():java.lang.String
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I, I, I, I, Ljava/lang/String;, Z, Z, I, I, I, Lemu/grasscutter/scripts/data/SceneBossChest;, I, Z, I, I)Ljava/lang/String;}, SceneGadget(config_id=, gadget_id=, level=, chest_drop_id=, drop_count=, drop_tag=, showcutscene=, persistence=, state=, point_type=, owner=, boss_chest=, interact_id=, isOneoff=, area_id=, draft_id=)]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I, I, I, I, Ljava/lang/String;, Z, Z, I, I, I, Lemu/grasscutter/scripts/data/SceneBossChest;, I, Z, I, I)Ljava/lang/String;}, SceneGadget(config_id=, gadget_id=, level=, chest_drop_id=, drop_count=, drop_tag=, showcutscene=, persistence=, state=, point_type=, owner=, boss_chest=, interact_id=, isOneoff=, area_id=, draft_id=)]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    @Override // emu.grasscutter.scripts.data.SceneObject
    public java.lang.String toString() {
        /*
            r17 = this;
            r0 = r17
            int r0 = r0.config_id
            r1 = r17
            int r1 = r1.gadget_id
            r2 = r17
            int r2 = r2.level
            r3 = r17
            int r3 = r3.chest_drop_id
            r4 = r17
            int r4 = r4.drop_count
            r5 = r17
            java.lang.String r5 = r5.drop_tag
            r6 = r17
            boolean r6 = r6.showcutscene
            r7 = r17
            boolean r7 = r7.persistence
            r8 = r17
            int r8 = r8.state
            r9 = r17
            int r9 = r9.point_type
            r10 = r17
            int r10 = r10.owner
            r11 = r17
            emu.grasscutter.scripts.data.SceneBossChest r11 = r11.boss_chest
            r12 = r17
            int r12 = r12.interact_id
            r13 = r17
            boolean r13 = r13.isOneoff
            r14 = r17
            int r14 = r14.area_id
            r15 = r17
            int r15 = r15.draft_id
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I, I, I, I, Ljava/lang/String;, Z, Z, I, I, I, Lemu/grasscutter/scripts/data/SceneBossChest;, I, Z, I, I)Ljava/lang/String;}, SceneGadget(config_id=, gadget_id=, level=, chest_drop_id=, drop_count=, drop_tag=, showcutscene=, persistence=, state=, point_type=, owner=, boss_chest=, interact_id=, isOneoff=, area_id=, draft_id=)]}
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.scripts.data.SceneGadget.toString():java.lang.String");
    }

    @Override // emu.grasscutter.scripts.data.SceneObject
    public void setConfig_id(int config_id) {
        this.config_id = config_id;
    }

    public void setGadget_id(int gadget_id) {
        this.gadget_id = gadget_id;
    }

    @Override // emu.grasscutter.scripts.data.SceneObject
    public void setLevel(int level) {
        this.level = level;
    }

    public void setChest_drop_id(int chest_drop_id) {
        this.chest_drop_id = chest_drop_id;
    }

    public void setDrop_count(int drop_count) {
        this.drop_count = drop_count;
    }

    public void setDrop_tag(String drop_tag) {
        this.drop_tag = drop_tag;
    }

    public void setShowcutscene(boolean showcutscene) {
        this.showcutscene = showcutscene;
    }

    public void setPersistence(boolean persistence) {
        this.persistence = persistence;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void setPoint_type(int point_type) {
        this.point_type = point_type;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    public void setBoss_chest(SceneBossChest boss_chest) {
        this.boss_chest = boss_chest;
    }

    public void setInteract_id(int interact_id) {
        this.interact_id = interact_id;
    }

    @Override // emu.grasscutter.scripts.data.SceneObject
    public void setArea_id(int area_id) {
        this.area_id = area_id;
    }

    public void setDraft_id(int draft_id) {
        this.draft_id = draft_id;
    }

    public void setIsOneoff(boolean isOneoff) {
        this.isOneoff = isOneoff;
    }
}
