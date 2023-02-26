package emu.grasscutter.scripts.data;

import com.github.davidmoten.rtreemulti.RTree;
import com.github.davidmoten.rtreemulti.geometry.Geometry;
import com.github.davidmoten.rtreemulti.geometry.Rectangle;
import emu.grasscutter.utils.Position;
import java.util.Map;

/* loaded from: grasscutter.jar:emu/grasscutter/scripts/data/SceneBlock.class */
public class SceneBlock {

    /* renamed from: id */
    public int f921id;
    public Position max;
    public Position min;
    public int sceneId;
    public Map<Integer, SceneGroup> groups;
    public RTree<SceneGroup, Geometry> sceneGroupIndex;
    private transient boolean loaded;

    /*  JADX ERROR: Dependency scan failed at insn: 0x0019: INVOKE_CUSTOM r-7, r-6, r-5
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
    /*  JADX ERROR: Dependency scan failed at insn: 0x009F: INVOKE_CUSTOM r-16, r-15
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
    /*  JADX ERROR: Failed to decode insn: 0x0019: INVOKE_CUSTOM r0, r1, r2, method: emu.grasscutter.scripts.data.SceneBlock.load(int, javax.script.Bindings):emu.grasscutter.scripts.data.SceneBlock
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I, I)Ljava/lang/String;}, Scene//scene_block.lua]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I, I)Ljava/lang/String;}, Scene//scene_block.lua]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    /*  JADX ERROR: Failed to decode insn: 0x009F: INVOKE_CUSTOM r1, r2, method: emu.grasscutter.scripts.data.SceneBlock.load(int, javax.script.Bindings):emu.grasscutter.scripts.data.SceneBlock
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I)Ljava/lang/String;}, An error occurred while loading block  in scene ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I)Ljava/lang/String;}, An error occurred while loading block  in scene ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public emu.grasscutter.scripts.data.SceneBlock load(int r7, javax.script.Bindings r8) {
        /*
            r6 = this;
            r0 = r6
            boolean r0 = r0.loaded
            if (r0 == 0) goto L_0x0009
            r0 = r6
            return r0
            r0 = r6
            r1 = r7
            r0.sceneId = r1
            r0 = r6
            r1 = 1
            r0.setLoaded(r1)
            r0 = r7
            r1 = r7
            r2 = r6
            int r2 = r2.f921id
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I, I)Ljava/lang/String;}, Scene//scene_block.lua]}
            r9 = r0
            r0 = r9
            javax.script.CompiledScript r0 = emu.grasscutter.scripts.ScriptLoader.getScript(r0)
            r10 = r0
            r0 = r10
            if (r0 != 0) goto L_0x002c
            r0 = 0
            return r0
            r0 = r10
            r1 = r8
            java.lang.Object r0 = r0.eval(r1)
            r0 = r6
            emu.grasscutter.scripts.serializer.Serializer r1 = emu.grasscutter.scripts.ScriptLoader.getSerializer()
            java.lang.Class<emu.grasscutter.scripts.data.SceneGroup> r2 = emu.grasscutter.scripts.data.SceneGroup.class
            r3 = r8
            java.lang.String r4 = "groups"
            java.lang.Object r3 = r3.get(r4)
            java.util.List r1 = r1.toList(r2, r3)
            java.util.stream.Stream r1 = r1.stream()
            emu.grasscutter.scripts.data.SceneBlock r2 = (v0) -> { // java.util.function.Function.apply(java.lang.Object):java.lang.Object
                return lambda$load$0(v0);
            }
            emu.grasscutter.scripts.data.SceneBlock r3 = (v0) -> { // java.util.function.Function.apply(java.lang.Object):java.lang.Object
                return lambda$load$1(v0);
            }
            emu.grasscutter.scripts.data.SceneBlock r4 = (v0, v1) -> { // java.util.function.BinaryOperator.apply(java.lang.Object, java.lang.Object):java.lang.Object
                return lambda$load$2(v0, v1);
            }
            java.util.stream.Collector r2 = java.util.stream.Collectors.toMap(r2, r3, r4)
            java.lang.Object r1 = r1.collect(r2)
            java.util.Map r1 = (java.util.Map) r1
            r0.groups = r1
            r0 = r6
            java.util.Map<java.lang.Integer, emu.grasscutter.scripts.data.SceneGroup> r0 = r0.groups
            java.util.Collection r0 = r0.values()
            r1 = r6
            emu.grasscutter.scripts.data.SceneBlock r1 = (v1) -> { // java.util.function.Consumer.accept(java.lang.Object):void
                r1.lambda$load$3(v1);
            }
            r0.forEach(r1)
            r0 = r6
            r1 = 3
            r2 = r6
            java.util.Map<java.lang.Integer, emu.grasscutter.scripts.data.SceneGroup> r2 = r2.groups
            java.util.Collection r2 = r2.values()
            emu.grasscutter.scripts.data.SceneBlock r3 = (v0) -> { // java.util.function.Function.apply(java.lang.Object):java.lang.Object
                return lambda$load$4(v0);
            }
            com.github.davidmoten.rtreemulti.RTree r1 = emu.grasscutter.scripts.SceneIndexManager.buildIndex(r1, r2, r3)
            r0.sceneGroupIndex = r1
            goto L_0x00a9
            r11 = move-exception
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            r1 = r6
            int r1 = r1.f921id
            r2 = r7
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I)Ljava/lang/String;}, An error occurred while loading block  in scene ]}
            r2 = r11
            r0.error(r1, r2)
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            java.lang.String r1 = "Successfully loaded block {} in scene {}."
            r2 = r6
            int r2 = r2.f921id
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r3 = r7
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r0.debug(r1, r2, r3)
            r0 = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.scripts.data.SceneBlock.load(int, javax.script.Bindings):emu.grasscutter.scripts.data.SceneBlock");
    }

    /*  JADX ERROR: Dependency scan failed at insn: 0x001C: INVOKE_CUSTOM r-7, r-6, r-5, r-4, r-3, r-2, r-1
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
    /*  JADX ERROR: Failed to decode insn: 0x001C: INVOKE_CUSTOM r0, r1, r2, r3, r4, r5, r6, method: emu.grasscutter.scripts.data.SceneBlock.toString():java.lang.String
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Lemu/grasscutter/utils/Position;, Lemu/grasscutter/utils/Position;, I, Ljava/util/Map;, Lcom/github/davidmoten/rtreemulti/RTree;, Z)Ljava/lang/String;}, SceneBlock(id=, max=, min=, sceneId=, groups=, sceneGroupIndex=, loaded=)]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Lemu/grasscutter/utils/Position;, Lemu/grasscutter/utils/Position;, I, Ljava/util/Map;, Lcom/github/davidmoten/rtreemulti/RTree;, Z)Ljava/lang/String;}, SceneBlock(id=, max=, min=, sceneId=, groups=, sceneGroupIndex=, loaded=)]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public java.lang.String toString() {
        /*
            r8 = this;
            r0 = r8
            int r0 = r0.f921id
            r1 = r8
            emu.grasscutter.utils.Position r1 = r1.max
            r2 = r8
            emu.grasscutter.utils.Position r2 = r2.min
            r3 = r8
            int r3 = r3.sceneId
            r4 = r8
            java.util.Map<java.lang.Integer, emu.grasscutter.scripts.data.SceneGroup> r4 = r4.groups
            r5 = r8
            com.github.davidmoten.rtreemulti.RTree<emu.grasscutter.scripts.data.SceneGroup, com.github.davidmoten.rtreemulti.geometry.Geometry> r5 = r5.sceneGroupIndex
            r6 = r8
            boolean r6 = r6.isLoaded()
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Lemu/grasscutter/utils/Position;, Lemu/grasscutter/utils/Position;, I, Ljava/util/Map;, Lcom/github/davidmoten/rtreemulti/RTree;, Z)Ljava/lang/String;}, SceneBlock(id=, max=, min=, sceneId=, groups=, sceneGroupIndex=, loaded=)]}
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.scripts.data.SceneBlock.toString():java.lang.String");
    }

    public void setId(int id) {
        this.f921id = id;
    }

    public void setMax(Position max) {
        this.max = max;
    }

    public void setMin(Position min) {
        this.min = min;
    }

    public void setSceneId(int sceneId) {
        this.sceneId = sceneId;
    }

    public void setGroups(Map<Integer, SceneGroup> groups) {
        this.groups = groups;
    }

    public void setSceneGroupIndex(RTree<SceneGroup, Geometry> sceneGroupIndex) {
        this.sceneGroupIndex = sceneGroupIndex;
    }

    public boolean isLoaded() {
        return this.loaded;
    }

    public void setLoaded(boolean loaded) {
        this.loaded = loaded;
    }

    public boolean contains(Position pos) {
        return pos.getX() <= this.max.getX() && pos.getX() >= this.min.getX() && pos.getZ() <= this.max.getZ() && pos.getZ() >= this.min.getZ();
    }

    public Rectangle toRectangle() {
        return Rectangle.create(this.min.toXZDoubleArray(), this.max.toXZDoubleArray());
    }
}
