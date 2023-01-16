package emu.grasscutter.scripts.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

/* loaded from: grasscutter.jar:emu/grasscutter/scripts/data/SceneSuite.class */
public class SceneSuite {
    public int rand_weight;
    public List<Integer> monsters = List.of();
    public List<Integer> gadgets = List.of();
    public List<String> triggers = List.of();
    public List<Integer> regions = List.of();
    public transient List<SceneMonster> sceneMonsters = List.of();
    public transient List<SceneGadget> sceneGadgets = List.of();
    public transient List<SceneTrigger> sceneTriggers = List.of();
    public transient List<SceneRegion> sceneRegions = List.of();

    /*  JADX ERROR: Dependency scan failed at insn: 0x0024: INVOKE_CUSTOM r-9, r-8, r-7, r-6, r-5, r-4, r-3, r-2, r-1
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
    /*  JADX ERROR: Failed to decode insn: 0x0024: INVOKE_CUSTOM r0, r1, r2, r3, r4, r5, r6, r7, r8, method: emu.grasscutter.scripts.data.SceneSuite.toString():java.lang.String
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/util/List;, Ljava/util/List;, Ljava/util/List;, Ljava/util/List;, I, Ljava/util/List;, Ljava/util/List;, Ljava/util/List;, Ljava/util/List;)Ljava/lang/String;}, SceneSuite(monsters=, gadgets=, triggers=, regions=, rand_weight=, sceneMonsters=, sceneGadgets=, sceneTriggers=, sceneRegions=)]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/util/List;, Ljava/util/List;, Ljava/util/List;, Ljava/util/List;, I, Ljava/util/List;, Ljava/util/List;, Ljava/util/List;, Ljava/util/List;)Ljava/lang/String;}, SceneSuite(monsters=, gadgets=, triggers=, regions=, rand_weight=, sceneMonsters=, sceneGadgets=, sceneTriggers=, sceneRegions=)]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public java.lang.String toString() {
        /*
            r10 = this;
            r0 = r10
            java.util.List<java.lang.Integer> r0 = r0.monsters
            r1 = r10
            java.util.List<java.lang.Integer> r1 = r1.gadgets
            r2 = r10
            java.util.List<java.lang.String> r2 = r2.triggers
            r3 = r10
            java.util.List<java.lang.Integer> r3 = r3.regions
            r4 = r10
            int r4 = r4.rand_weight
            r5 = r10
            java.util.List<emu.grasscutter.scripts.data.SceneMonster> r5 = r5.sceneMonsters
            r6 = r10
            java.util.List<emu.grasscutter.scripts.data.SceneGadget> r6 = r6.sceneGadgets
            r7 = r10
            java.util.List<emu.grasscutter.scripts.data.SceneTrigger> r7 = r7.sceneTriggers
            r8 = r10
            java.util.List<emu.grasscutter.scripts.data.SceneRegion> r8 = r8.sceneRegions
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/util/List;, Ljava/util/List;, Ljava/util/List;, Ljava/util/List;, I, Ljava/util/List;, Ljava/util/List;, Ljava/util/List;, Ljava/util/List;)Ljava/lang/String;}, SceneSuite(monsters=, gadgets=, triggers=, regions=, rand_weight=, sceneMonsters=, sceneGadgets=, sceneTriggers=, sceneRegions=)]}
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.scripts.data.SceneSuite.toString():java.lang.String");
    }

    public void setMonsters(List<Integer> monsters) {
        this.monsters = monsters;
    }

    public void setGadgets(List<Integer> gadgets) {
        this.gadgets = gadgets;
    }

    public void setTriggers(List<String> triggers) {
        this.triggers = triggers;
    }

    public void setRegions(List<Integer> regions) {
        this.regions = regions;
    }

    public void setRand_weight(int rand_weight) {
        this.rand_weight = rand_weight;
    }

    public void setSceneMonsters(List<SceneMonster> sceneMonsters) {
        this.sceneMonsters = sceneMonsters;
    }

    public void setSceneGadgets(List<SceneGadget> sceneGadgets) {
        this.sceneGadgets = sceneGadgets;
    }

    public void setSceneTriggers(List<SceneTrigger> sceneTriggers) {
        this.sceneTriggers = sceneTriggers;
    }

    public void setSceneRegions(List<SceneRegion> sceneRegions) {
        this.sceneRegions = sceneRegions;
    }

    public void init(SceneGroup sceneGroup) {
        if (sceneGroup.monsters != null) {
            Stream<Integer> stream = this.monsters.stream();
            Map<Integer, SceneMonster> map = sceneGroup.monsters;
            Objects.requireNonNull(map);
            Stream<Integer> filter = stream.filter((v1) -> {
                return r4.containsKey(v1);
            });
            Map<Integer, SceneMonster> map2 = sceneGroup.monsters;
            Objects.requireNonNull(map2);
            this.sceneMonsters = new ArrayList(filter.map((v1) -> {
                return r4.get(v1);
            }).toList());
        }
        if (sceneGroup.gadgets != null) {
            Stream<Integer> stream2 = this.gadgets.stream();
            Map<Integer, SceneGadget> map3 = sceneGroup.gadgets;
            Objects.requireNonNull(map3);
            Stream<Integer> filter2 = stream2.filter((v1) -> {
                return r4.containsKey(v1);
            });
            Map<Integer, SceneGadget> map4 = sceneGroup.gadgets;
            Objects.requireNonNull(map4);
            this.sceneGadgets = new ArrayList(filter2.map((v1) -> {
                return r4.get(v1);
            }).toList());
        }
        if (sceneGroup.triggers != null) {
            Stream<String> stream3 = this.triggers.stream();
            Map<String, SceneTrigger> map5 = sceneGroup.triggers;
            Objects.requireNonNull(map5);
            Stream<String> filter3 = stream3.filter((v1) -> {
                return r4.containsKey(v1);
            });
            Map<String, SceneTrigger> map6 = sceneGroup.triggers;
            Objects.requireNonNull(map6);
            this.sceneTriggers = new ArrayList(filter3.map((v1) -> {
                return r4.get(v1);
            }).toList());
        }
        if (sceneGroup.regions != null) {
            Stream<Integer> stream4 = this.regions.stream();
            Map<Integer, SceneRegion> map7 = sceneGroup.regions;
            Objects.requireNonNull(map7);
            Stream<Integer> filter4 = stream4.filter((v1) -> {
                return r4.containsKey(v1);
            });
            Map<Integer, SceneRegion> map8 = sceneGroup.regions;
            Objects.requireNonNull(map8);
            this.sceneRegions = new ArrayList(filter4.map((v1) -> {
                return r4.get(v1);
            }).toList());
        }
    }
}
