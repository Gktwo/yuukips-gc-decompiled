package emu.grasscutter.scripts.data;

import emu.grasscutter.utils.Position;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.script.Bindings;
import javax.script.CompiledScript;

/* loaded from: grasscutter.jar:emu/grasscutter/scripts/data/SceneGroup.class */
public class SceneGroup {
    public transient int block_id;

    /* renamed from: id */
    public int f922id;
    public int refresh_id;
    public Position pos;
    public Map<Integer, SceneMonster> monsters;
    public Map<Integer, SceneGadget> gadgets;
    public Map<String, SceneTrigger> triggers;
    public Map<Integer, SceneRegion> regions;
    public List<SceneSuite> suites;
    public List<SceneVar> variables;
    public SceneBusiness business;
    public SceneGarbage garbages;
    public SceneInitConfig init_config;
    private transient boolean loaded;
    private transient CompiledScript script;
    private transient Bindings bindings;

    /*  JADX ERROR: Dependency scan failed at insn: 0x0020: INVOKE_CUSTOM r-6, r-5, r-4
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
    /*  JADX ERROR: Dependency scan failed at insn: 0x023C: INVOKE_CUSTOM r-54
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
    /*  JADX ERROR: Failed to decode insn: 0x0020: INVOKE_CUSTOM r0, r1, r2, method: emu.grasscutter.scripts.data.SceneGroup.load(int):emu.grasscutter.scripts.data.SceneGroup
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I, I)Ljava/lang/String;}, Scene//scene_group.lua]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I, I)Ljava/lang/String;}, Scene//scene_group.lua]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    /*  JADX ERROR: Failed to decode insn: 0x023C: INVOKE_CUSTOM r1, method: emu.grasscutter.scripts.data.SceneGroup.load(int):emu.grasscutter.scripts.data.SceneGroup
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, An error occurred while loading file script group ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, An error occurred while loading file script group ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public synchronized emu.grasscutter.scripts.data.SceneGroup load(int r7) {
        /*
        // Method dump skipped, instructions count: 603
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.scripts.data.SceneGroup.load(int):emu.grasscutter.scripts.data.SceneGroup");
    }

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
    /*  JADX ERROR: Failed to decode insn: 0x0040: INVOKE_CUSTOM r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, method: emu.grasscutter.scripts.data.SceneGroup.toString():java.lang.String
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I, I, Lemu/grasscutter/utils/Position;, Ljava/util/Map;, Ljava/util/Map;, Ljava/util/Map;, Ljava/util/Map;, Ljava/util/List;, Ljava/util/List;, Lemu/grasscutter/scripts/data/SceneBusiness;, Lemu/grasscutter/scripts/data/SceneGarbage;, Lemu/grasscutter/scripts/data/SceneInitConfig;, Z, Ljavax/script/CompiledScript;, Ljavax/script/Bindings;)Ljava/lang/String;}, SceneGroup(block_id=, id=, refresh_id=, pos=, monsters=, gadgets=, triggers=, regions=, suites=, variables=, business=, garbages=, init_config=, loaded=, script=, bindings=)]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I, I, Lemu/grasscutter/utils/Position;, Ljava/util/Map;, Ljava/util/Map;, Ljava/util/Map;, Ljava/util/Map;, Ljava/util/List;, Ljava/util/List;, Lemu/grasscutter/scripts/data/SceneBusiness;, Lemu/grasscutter/scripts/data/SceneGarbage;, Lemu/grasscutter/scripts/data/SceneInitConfig;, Z, Ljavax/script/CompiledScript;, Ljavax/script/Bindings;)Ljava/lang/String;}, SceneGroup(block_id=, id=, refresh_id=, pos=, monsters=, gadgets=, triggers=, regions=, suites=, variables=, business=, garbages=, init_config=, loaded=, script=, bindings=)]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public java.lang.String toString() {
        /*
            r17 = this;
            r0 = r17
            int r0 = r0.block_id
            r1 = r17
            int r1 = r1.f922id
            r2 = r17
            int r2 = r2.refresh_id
            r3 = r17
            emu.grasscutter.utils.Position r3 = r3.pos
            r4 = r17
            java.util.Map<java.lang.Integer, emu.grasscutter.scripts.data.SceneMonster> r4 = r4.monsters
            r5 = r17
            java.util.Map<java.lang.Integer, emu.grasscutter.scripts.data.SceneGadget> r5 = r5.gadgets
            r6 = r17
            java.util.Map<java.lang.String, emu.grasscutter.scripts.data.SceneTrigger> r6 = r6.triggers
            r7 = r17
            java.util.Map<java.lang.Integer, emu.grasscutter.scripts.data.SceneRegion> r7 = r7.regions
            r8 = r17
            java.util.List<emu.grasscutter.scripts.data.SceneSuite> r8 = r8.suites
            r9 = r17
            java.util.List<emu.grasscutter.scripts.data.SceneVar> r9 = r9.variables
            r10 = r17
            emu.grasscutter.scripts.data.SceneBusiness r10 = r10.business
            r11 = r17
            emu.grasscutter.scripts.data.SceneGarbage r11 = r11.garbages
            r12 = r17
            emu.grasscutter.scripts.data.SceneInitConfig r12 = r12.init_config
            r13 = r17
            boolean r13 = r13.isLoaded()
            r14 = r17
            javax.script.CompiledScript r14 = r14.getScript()
            r15 = r17
            javax.script.Bindings r15 = r15.getBindings()
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I, I, Lemu/grasscutter/utils/Position;, Ljava/util/Map;, Ljava/util/Map;, Ljava/util/Map;, Ljava/util/Map;, Ljava/util/List;, Ljava/util/List;, Lemu/grasscutter/scripts/data/SceneBusiness;, Lemu/grasscutter/scripts/data/SceneGarbage;, Lemu/grasscutter/scripts/data/SceneInitConfig;, Z, Ljavax/script/CompiledScript;, Ljavax/script/Bindings;)Ljava/lang/String;}, SceneGroup(block_id=, id=, refresh_id=, pos=, monsters=, gadgets=, triggers=, regions=, suites=, variables=, business=, garbages=, init_config=, loaded=, script=, bindings=)]}
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.scripts.data.SceneGroup.toString():java.lang.String");
    }

    public void setBlock_id(int block_id) {
        this.block_id = block_id;
    }

    public void setId(int id) {
        this.f922id = id;
    }

    public void setRefresh_id(int refresh_id) {
        this.refresh_id = refresh_id;
    }

    public void setPos(Position pos) {
        this.pos = pos;
    }

    public void setMonsters(Map<Integer, SceneMonster> monsters) {
        this.monsters = monsters;
    }

    public void setGadgets(Map<Integer, SceneGadget> gadgets) {
        this.gadgets = gadgets;
    }

    public void setTriggers(Map<String, SceneTrigger> triggers) {
        this.triggers = triggers;
    }

    public void setRegions(Map<Integer, SceneRegion> regions) {
        this.regions = regions;
    }

    public void setSuites(List<SceneSuite> suites) {
        this.suites = suites;
    }

    public void setVariables(List<SceneVar> variables) {
        this.variables = variables;
    }

    public void setBusiness(SceneBusiness business) {
        this.business = business;
    }

    public void setGarbages(SceneGarbage garbages) {
        this.garbages = garbages;
    }

    public void setInit_config(SceneInitConfig init_config) {
        this.init_config = init_config;
    }

    public void setScript(CompiledScript script) {
        this.script = script;
    }

    public void setBindings(Bindings bindings) {
        this.bindings = bindings;
    }

    /* renamed from: of */
    public static SceneGroup m1194of(int groupId) {
        SceneGroup group = new SceneGroup();
        group.f922id = groupId;
        return group;
    }

    public boolean isLoaded() {
        return this.loaded;
    }

    public void setLoaded(boolean loaded) {
        this.loaded = loaded;
    }

    public int getBusinessType() {
        if (this.business == null) {
            return 0;
        }
        return this.business.type;
    }

    public List<SceneGadget> getGarbageGadgets() {
        if (this.garbages == null) {
            return null;
        }
        return this.garbages.gadgets;
    }

    public CompiledScript getScript() {
        return this.script;
    }

    public SceneSuite getSuiteByIndex(int index) {
        if (index < 1 || index > this.suites.size()) {
            return null;
        }
        return this.suites.get(index - 1);
    }

    public Bindings getBindings() {
        return this.bindings;
    }

    public Optional<SceneBossChest> searchBossChestInGroup() {
        return this.gadgets.values().stream().filter(g -> {
            return g.boss_chest != null && g.boss_chest.monster_config_id > 0;
        }).map(g -> {
            return g.boss_chest;
        }).findFirst();
    }
}
