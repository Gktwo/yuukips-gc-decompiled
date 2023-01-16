package dev.morphia.mapping.codec.writer;

import com.mongodb.lang.Nullable;
import java.util.StringJoiner;
import java.util.stream.Stream;
import org.bson.Document;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:dev/morphia/mapping/codec/writer/WriteState.class */
public abstract class WriteState {
    private final DocumentWriter writer;
    private final WriteState previous;

    protected abstract String state();

    /*  JADX ERROR: Dependency scan failed at insn: 0x0013: INVOKE_CUSTOM r-2, r-1
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
    /*  JADX ERROR: Failed to decode insn: 0x0013: INVOKE_CUSTOM r2, r3, method: dev.morphia.mapping.codec.writer.WriteState.array():dev.morphia.mapping.codec.writer.WriteState
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, Ldev/morphia/mapping/codec/writer/DocumentWriter;)Ljava/lang/String;}, . writer: ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, Ldev/morphia/mapping/codec/writer/DocumentWriter;)Ljava/lang/String;}, . writer: ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    dev.morphia.mapping.codec.writer.WriteState array() {
        /*
            r5 = this;
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r1 = r0
            r2 = r5
            java.lang.String r2 = r2.state()
            r3 = 0
            java.util.Locale[] r3 = new java.util.Locale[r3]
            java.lang.String r2 = dev.morphia.sofia.Sofia.cantStartArray(r2, r3)
            r3 = r5
            dev.morphia.mapping.codec.writer.DocumentWriter r3 = r3.getWriter()
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, Ldev/morphia/mapping/codec/writer/DocumentWriter;)Ljava/lang/String;}, . writer: ]}
            r1.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: dev.morphia.mapping.codec.writer.WriteState.array():dev.morphia.mapping.codec.writer.WriteState");
    }

    /*  JADX ERROR: Dependency scan failed at insn: 0x0013: INVOKE_CUSTOM r-2, r-1
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
    /*  JADX ERROR: Failed to decode insn: 0x0013: INVOKE_CUSTOM r2, r3, method: dev.morphia.mapping.codec.writer.WriteState.document():dev.morphia.mapping.codec.writer.WriteState
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, Ldev/morphia/mapping/codec/writer/DocumentWriter;)Ljava/lang/String;}, . writer: ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, Ldev/morphia/mapping/codec/writer/DocumentWriter;)Ljava/lang/String;}, . writer: ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    dev.morphia.mapping.codec.writer.WriteState document() {
        /*
            r5 = this;
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r1 = r0
            r2 = r5
            java.lang.String r2 = r2.state()
            r3 = 0
            java.util.Locale[] r3 = new java.util.Locale[r3]
            java.lang.String r2 = dev.morphia.sofia.Sofia.cantStartDocument(r2, r3)
            r3 = r5
            dev.morphia.mapping.codec.writer.DocumentWriter r3 = r3.getWriter()
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, Ldev/morphia/mapping/codec/writer/DocumentWriter;)Ljava/lang/String;}, . writer: ]}
            r1.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: dev.morphia.mapping.codec.writer.WriteState.document():dev.morphia.mapping.codec.writer.WriteState");
    }

    /*  JADX ERROR: Dependency scan failed at insn: 0x0015: INVOKE_CUSTOM r-3, r-2
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
    /*  JADX ERROR: Failed to decode insn: 0x0015: INVOKE_CUSTOM r2, r3, method: dev.morphia.mapping.codec.writer.WriteState.name(java.lang.String):dev.morphia.mapping.codec.writer.WriteState
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, Ldev/morphia/mapping/codec/writer/DocumentWriter;)Ljava/lang/String;},   writer:  ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, Ldev/morphia/mapping/codec/writer/DocumentWriter;)Ljava/lang/String;},   writer:  ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    dev.morphia.mapping.codec.writer.WriteState name(java.lang.String r7) {
        /*
            r6 = this;
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r1 = r0
            java.lang.String r2 = "name"
            r3 = r6
            java.lang.String r3 = r3.state()
            r4 = 0
            java.util.Locale[] r4 = new java.util.Locale[r4]
            java.lang.String r2 = dev.morphia.sofia.Sofia.notInValidState(r2, r3, r4)
            r3 = r6
            dev.morphia.mapping.codec.writer.DocumentWriter r3 = r3.getWriter()
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, Ldev/morphia/mapping/codec/writer/DocumentWriter;)Ljava/lang/String;},   writer:  ]}
            r1.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: dev.morphia.mapping.codec.writer.WriteState.name(java.lang.String):dev.morphia.mapping.codec.writer.WriteState");
    }

    /*  JADX ERROR: Dependency scan failed at insn: 0x0015: INVOKE_CUSTOM r-3, r-2
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
    /*  JADX ERROR: Failed to decode insn: 0x0015: INVOKE_CUSTOM r2, r3, method: dev.morphia.mapping.codec.writer.WriteState.value(java.lang.Object):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, Ldev/morphia/mapping/codec/writer/DocumentWriter;)Ljava/lang/String;},   writer:  ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, Ldev/morphia/mapping/codec/writer/DocumentWriter;)Ljava/lang/String;},   writer:  ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    void value(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r1 = r0
            java.lang.String r2 = "value"
            r3 = r6
            java.lang.String r3 = r3.state()
            r4 = 0
            java.util.Locale[] r4 = new java.util.Locale[r4]
            java.lang.String r2 = dev.morphia.sofia.Sofia.notInValidState(r2, r3, r4)
            r3 = r6
            dev.morphia.mapping.codec.writer.DocumentWriter r3 = r3.getWriter()
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, Ldev/morphia/mapping/codec/writer/DocumentWriter;)Ljava/lang/String;},   writer:  ]}
            r1.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: dev.morphia.mapping.codec.writer.WriteState.value(java.lang.Object):void");
    }

    /* access modifiers changed from: package-private */
    public WriteState() {
        this.writer = null;
        this.previous = null;
    }

    /* access modifiers changed from: package-private */
    public WriteState(DocumentWriter writer, @Nullable WriteState previous) {
        this.writer = writer;
        this.previous = previous;
        writer.state(this);
    }

    protected String toString(Object value) {
        if (value instanceof Document) {
            StringJoiner joiner = new StringJoiner(", ", "{ ", " }");
            Stream<R> map = ((Document) value).entrySet().stream().map(
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0027: INVOKE  (r0v18 'map' java.util.stream.Stream<R>) = 
                  (wrap: java.util.stream.Stream<java.util.Map$Entry<java.lang.String, java.lang.Object>> : 0x001c: INVOKE  (r0v17 java.util.stream.Stream<java.util.Map$Entry<java.lang.String, java.lang.Object>> A[REMOVE]) = 
                  (wrap: java.util.Set<java.util.Map$Entry<java.lang.String, java.lang.Object>> : 0x0019: INVOKE  (r0v16 java.util.Set<java.util.Map$Entry<java.lang.String, java.lang.Object>> A[REMOVE]) = 
                  (wrap: org.bson.Document : 0x0016: CHECK_CAST (r0v15 org.bson.Document A[REMOVE]) = (org.bson.Document) (r7v0 'value' java.lang.Object A[D('value' java.lang.Object)]))
                 type: VIRTUAL call: org.bson.Document.entrySet():java.util.Set)
                 type: INTERFACE call: java.util.Set.stream():java.util.stream.Stream)
                  (wrap: java.util.function.Function<? super java.util.Map$Entry<java.lang.String, java.lang.Object>, ? extends R> : 0x0022: INVOKE_CUSTOM (r1v7 java.util.function.Function<? super java.util.Map$Entry<java.lang.String, java.lang.Object>, ? extends R> A[REMOVE]) = 
                  (r6v0 'this' dev.morphia.mapping.codec.writer.WriteState A[D('this' dev.morphia.mapping.codec.writer.WriteState), DONT_INLINE, IMMUTABLE_TYPE, THIS])
                
                 handle type: INVOKE_DIRECT
                 lambda: java.util.function.Function.apply(java.lang.Object):java.lang.Object
                 call insn: ?: INVOKE  (r1 I:dev.morphia.mapping.codec.writer.WriteState), (v1 java.util.Map$Entry) type: DIRECT call: dev.morphia.mapping.codec.writer.WriteState.lambda$toString$0(java.util.Map$Entry):java.lang.String)
                 type: INTERFACE call: java.util.stream.Stream.map(java.util.function.Function):java.util.stream.Stream in method: dev.morphia.mapping.codec.writer.WriteState.toString(java.lang.Object):java.lang.String, file: grasscutter.jar:dev/morphia/mapping/codec/writer/WriteState.class
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:94)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:137)
                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:349)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:302)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:271)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getCodeVar()" because the return value of "jadx.core.dex.instructions.args.RegisterArg.getSVar()" is null
                	at jadx.core.codegen.InsnGen.makeInlinedLambdaMethod(InsnGen.java:900)
                	at jadx.core.codegen.InsnGen.makeInvokeLambda(InsnGen.java:814)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:756)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:976)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:801)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:278)
                	... 21 more
                */
            /*
                this = this;
                r0 = r7
                boolean r0 = r0 instanceof org.bson.Document
                if (r0 == 0) goto L_0x0041
                java.util.StringJoiner r0 = new java.util.StringJoiner
                r1 = r0
                java.lang.String r2 = ", "
                java.lang.String r3 = "{ "
                java.lang.String r4 = " }"
                r1.<init>(r2, r3, r4)
                r8 = r0
                r0 = r7
                org.bson.Document r0 = (org.bson.Document) r0
                java.util.Set r0 = r0.entrySet()
                java.util.stream.Stream r0 = r0.stream()
                r1 = r6
                java.lang.String r1 = (v1) -> { // java.util.function.Function.apply(java.lang.Object):java.lang.Object
                    return r1.lambda$toString$0(v1);
                }
                java.util.stream.Stream r0 = r0.map(r1)
                r1 = r8
                r2 = r1
                java.lang.Object r2 = java.util.Objects.requireNonNull(r2)
                java.lang.String r1 = (v1) -> { // java.util.function.Consumer.accept(java.lang.Object):void
                    r1.add(v1);
                }
                r0.forEach(r1)
                r0 = r8
                java.lang.String r0 = r0.toString()
                return r0
            L_0x0041:
                r0 = r7
                boolean r0 = r0 instanceof java.util.List
                if (r0 == 0) goto L_0x007f
                java.util.StringJoiner r0 = new java.util.StringJoiner
                r1 = r0
                java.lang.String r2 = ", "
                java.lang.String r3 = "[ "
                java.lang.String r4 = " ]"
                r1.<init>(r2, r3, r4)
                r8 = r0
                r0 = r7
                java.util.List r0 = (java.util.List) r0
                java.util.stream.Stream r0 = r0.stream()
                r1 = r6
                java.lang.String r1 = this::toString
                java.util.stream.Stream r0 = r0.map(r1)
                r1 = r8
                r2 = r1
                java.lang.Object r2 = java.util.Objects.requireNonNull(r2)
                java.lang.String r1 = (v1) -> { // java.util.function.Consumer.accept(java.lang.Object):void
                    r1.add(v1);
                }
                r0.forEach(r1)
                r0 = r8
                java.lang.String r0 = r0.toString()
                return r0
            L_0x007f:
                r0 = r7
                java.lang.String r0 = java.lang.String.valueOf(r0)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: dev.morphia.mapping.codec.writer.WriteState.toString(java.lang.Object):java.lang.String");
        }

        void done() {
        }

        /* access modifiers changed from: package-private */
        public void end() {
            getWriter().state(this.previous);
            if (this.previous != null) {
                this.previous.done();
            }
        }

        DocumentWriter getWriter() {
            return this.writer;
        }
    }
