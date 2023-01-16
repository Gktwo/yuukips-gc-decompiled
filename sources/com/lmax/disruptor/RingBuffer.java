package com.lmax.disruptor;

import com.lmax.disruptor.dsl.ProducerType;

/* loaded from: grasscutter.jar:com/lmax/disruptor/RingBuffer.class */
public final class RingBuffer<E> extends RingBufferFields<E> implements Cursored, EventSequencer<E>, EventSink<E> {
    public static final long INITIAL_CURSOR_VALUE = -1;
    protected byte p10;
    protected byte p11;
    protected byte p12;
    protected byte p13;
    protected byte p14;
    protected byte p15;
    protected byte p16;
    protected byte p17;
    protected byte p20;
    protected byte p21;
    protected byte p22;
    protected byte p23;
    protected byte p24;
    protected byte p25;
    protected byte p26;
    protected byte p27;
    protected byte p30;
    protected byte p31;
    protected byte p32;
    protected byte p33;
    protected byte p34;
    protected byte p35;
    protected byte p36;
    protected byte p37;
    protected byte p40;
    protected byte p41;
    protected byte p42;
    protected byte p43;
    protected byte p44;
    protected byte p45;
    protected byte p46;
    protected byte p47;
    protected byte p50;
    protected byte p51;
    protected byte p52;
    protected byte p53;
    protected byte p54;
    protected byte p55;
    protected byte p56;
    protected byte p57;
    protected byte p60;
    protected byte p61;
    protected byte p62;
    protected byte p63;
    protected byte p64;
    protected byte p65;
    protected byte p66;
    protected byte p67;
    protected byte p70;
    protected byte p71;
    protected byte p72;
    protected byte p73;
    protected byte p74;
    protected byte p75;
    protected byte p76;
    protected byte p77;

    /*  JADX ERROR: Dependency scan failed at insn: 0x000E: INVOKE_CUSTOM r-1, r0
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
    /*  JADX ERROR: Dependency scan failed at insn: 0x0028: INVOKE_CUSTOM r-3, r-2
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
    /*  JADX ERROR: Failed to decode insn: 0x000E: INVOKE_CUSTOM r2, r3, method: com.lmax.disruptor.RingBuffer.checkBatchSizing(int, int):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I)Ljava/lang/String;}, Both batchStartsAt and batchSize must be positive but got: batchStartsAt  and batchSize ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I)Ljava/lang/String;}, Both batchStartsAt and batchSize must be positive but got: batchStartsAt  and batchSize ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    /*  JADX ERROR: Failed to decode insn: 0x0028: INVOKE_CUSTOM r2, r3, method: com.lmax.disruptor.RingBuffer.checkBatchSizing(int, int):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I)Ljava/lang/String;}, The ring buffer cannot accommodate  it only has space for  entities.]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I)Ljava/lang/String;}, The ring buffer cannot accommodate  it only has space for  entities.]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    private void checkBatchSizing(int r6, int r7) {
        /*
            r5 = this;
            r0 = r6
            if (r0 < 0) goto L_0x0008
            r0 = r7
            if (r0 >= 0) goto L_0x0017
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = r0
            r2 = r6
            r3 = r7
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I)Ljava/lang/String;}, Both batchStartsAt and batchSize must be positive but got: batchStartsAt  and batchSize ]}
            r1.<init>(r2)
            throw r0
            r0 = r7
            r1 = r5
            int r1 = r1.bufferSize
            if (r0 <= r1) goto L_0x0031
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = r0
            r2 = r7
            r3 = r5
            int r3 = r3.bufferSize
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I)Ljava/lang/String;}, The ring buffer cannot accommodate  it only has space for  entities.]}
            r1.<init>(r2)
            throw r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lmax.disruptor.RingBuffer.checkBatchSizing(int, int):void");
    }

    /*  JADX ERROR: Dependency scan failed at insn: 0x0012: INVOKE_CUSTOM r-2, r-1, r0
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
    /*  JADX ERROR: Failed to decode insn: 0x0012: INVOKE_CUSTOM r2, r3, r4, method: com.lmax.disruptor.RingBuffer.batchOverRuns(A[], int, int):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I, I)Ljava/lang/String;}, A batchSize of:  with batchStatsAt of:  will overrun the available number of arguments: ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I, I)Ljava/lang/String;}, A batchSize of:  with batchStatsAt of:  will overrun the available number of arguments: ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    private <A> void batchOverRuns(A[] r8, int r9, int r10) {
        /*
            r7 = this;
            r0 = r9
            r1 = r10
            int r0 = r0 + r1
            r1 = r8
            int r1 = r1.length
            if (r0 <= r1) goto L_0x001b
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = r0
            r2 = r10
            r3 = r9
            r4 = r8
            int r4 = r4.length
            r5 = r9
            int r4 = r4 - r5
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I, I)Ljava/lang/String;}, A batchSize of:  with batchStatsAt of:  will overrun the available number of arguments: ]}
            r1.<init>(r2)
            throw r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lmax.disruptor.RingBuffer.batchOverRuns(java.lang.Object[], int, int):void");
    }

    /*  JADX ERROR: Dependency scan failed at insn: 0x0008: INVOKE_CUSTOM r-2, r-1
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
    /*  JADX ERROR: Failed to decode insn: 0x0008: INVOKE_CUSTOM r0, r1, method: com.lmax.disruptor.RingBuffer.toString():java.lang.String
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Lcom/lmax/disruptor/Sequencer;)Ljava/lang/String;}, RingBuffer{bufferSize=, sequencer=}]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Lcom/lmax/disruptor/Sequencer;)Ljava/lang/String;}, RingBuffer{bufferSize=, sequencer=}]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public java.lang.String toString() {
        /*
            r3 = this;
            r0 = r3
            int r0 = r0.bufferSize
            r1 = r3
            com.lmax.disruptor.Sequencer r1 = r1.sequencer
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Lcom/lmax/disruptor/Sequencer;)Ljava/lang/String;}, RingBuffer{bufferSize=, sequencer=}]}
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lmax.disruptor.RingBuffer.toString():java.lang.String");
    }

    RingBuffer(EventFactory<E> eventFactory, Sequencer sequencer) {
        super(eventFactory, sequencer);
    }

    public static <E> RingBuffer<E> createMultiProducer(EventFactory<E> factory, int bufferSize, WaitStrategy waitStrategy) {
        return new RingBuffer<>(factory, new MultiProducerSequencer(bufferSize, waitStrategy));
    }

    public static <E> RingBuffer<E> createMultiProducer(EventFactory<E> factory, int bufferSize) {
        return createMultiProducer(factory, bufferSize, new BlockingWaitStrategy());
    }

    public static <E> RingBuffer<E> createSingleProducer(EventFactory<E> factory, int bufferSize, WaitStrategy waitStrategy) {
        return new RingBuffer<>(factory, new SingleProducerSequencer(bufferSize, waitStrategy));
    }

    public static <E> RingBuffer<E> createSingleProducer(EventFactory<E> factory, int bufferSize) {
        return createSingleProducer(factory, bufferSize, new BlockingWaitStrategy());
    }

    public static <E> RingBuffer<E> create(ProducerType producerType, EventFactory<E> factory, int bufferSize, WaitStrategy waitStrategy) {
        switch (producerType) {
            case SINGLE:
                return createSingleProducer(factory, bufferSize, waitStrategy);
            case MULTI:
                return createMultiProducer(factory, bufferSize, waitStrategy);
            default:
                throw new IllegalStateException(producerType.toString());
        }
    }

    @Override // com.lmax.disruptor.DataProvider
    public E get(long sequence) {
        return elementAt(sequence);
    }

    @Override // com.lmax.disruptor.Sequenced
    public long next() {
        return this.sequencer.next();
    }

    @Override // com.lmax.disruptor.Sequenced
    public long next(int n) {
        return this.sequencer.next(n);
    }

    @Override // com.lmax.disruptor.Sequenced
    public long tryNext() throws InsufficientCapacityException {
        return this.sequencer.tryNext();
    }

    @Override // com.lmax.disruptor.Sequenced
    public long tryNext(int n) throws InsufficientCapacityException {
        return this.sequencer.tryNext(n);
    }

    @Deprecated
    public void resetTo(long sequence) {
        this.sequencer.claim(sequence);
        this.sequencer.publish(sequence);
    }

    public E claimAndGetPreallocated(long sequence) {
        this.sequencer.claim(sequence);
        return get(sequence);
    }

    public boolean isAvailable(long sequence) {
        return this.sequencer.isAvailable(sequence);
    }

    public void addGatingSequences(Sequence... gatingSequences) {
        this.sequencer.addGatingSequences(gatingSequences);
    }

    public long getMinimumGatingSequence() {
        return this.sequencer.getMinimumSequence();
    }

    public boolean removeGatingSequence(Sequence sequence) {
        return this.sequencer.removeGatingSequence(sequence);
    }

    public SequenceBarrier newBarrier(Sequence... sequencesToTrack) {
        return this.sequencer.newBarrier(sequencesToTrack);
    }

    public EventPoller<E> newPoller(Sequence... gatingSequences) {
        return this.sequencer.newPoller(this, gatingSequences);
    }

    @Override // com.lmax.disruptor.Cursored
    public long getCursor() {
        return this.sequencer.getCursor();
    }

    @Override // com.lmax.disruptor.Sequenced
    public int getBufferSize() {
        return this.bufferSize;
    }

    @Override // com.lmax.disruptor.Sequenced
    public boolean hasAvailableCapacity(int requiredCapacity) {
        return this.sequencer.hasAvailableCapacity(requiredCapacity);
    }

    @Override // com.lmax.disruptor.EventSink
    public void publishEvent(EventTranslator<E> translator) {
        translateAndPublish(translator, this.sequencer.next());
    }

    @Override // com.lmax.disruptor.EventSink
    public boolean tryPublishEvent(EventTranslator<E> translator) {
        try {
            translateAndPublish(translator, this.sequencer.tryNext());
            return true;
        } catch (InsufficientCapacityException e) {
            return false;
        }
    }

    @Override // com.lmax.disruptor.EventSink
    public <A> void publishEvent(EventTranslatorOneArg<E, A> translator, A arg0) {
        translateAndPublish((EventTranslatorOneArg<E, long>) translator, this.sequencer.next(), (long) arg0);
    }

    @Override // com.lmax.disruptor.EventSink
    public <A> boolean tryPublishEvent(EventTranslatorOneArg<E, A> translator, A arg0) {
        try {
            translateAndPublish((EventTranslatorOneArg<E, long>) translator, this.sequencer.tryNext(), (long) arg0);
            return true;
        } catch (InsufficientCapacityException e) {
            return false;
        }
    }

    @Override // com.lmax.disruptor.EventSink
    public <A, B> void publishEvent(EventTranslatorTwoArg<E, A, B> translator, A arg0, B arg1) {
        translateAndPublish(translator, this.sequencer.next(), arg0, arg1);
    }

    @Override // com.lmax.disruptor.EventSink
    public <A, B> boolean tryPublishEvent(EventTranslatorTwoArg<E, A, B> translator, A arg0, B arg1) {
        try {
            translateAndPublish(translator, this.sequencer.tryNext(), arg0, arg1);
            return true;
        } catch (InsufficientCapacityException e) {
            return false;
        }
    }

    @Override // com.lmax.disruptor.EventSink
    public <A, B, C> void publishEvent(EventTranslatorThreeArg<E, A, B, C> translator, A arg0, B arg1, C arg2) {
        translateAndPublish(translator, this.sequencer.next(), arg0, arg1, arg2);
    }

    @Override // com.lmax.disruptor.EventSink
    public <A, B, C> boolean tryPublishEvent(EventTranslatorThreeArg<E, A, B, C> translator, A arg0, B arg1, C arg2) {
        try {
            translateAndPublish(translator, this.sequencer.tryNext(), arg0, arg1, arg2);
            return true;
        } catch (InsufficientCapacityException e) {
            return false;
        }
    }

    @Override // com.lmax.disruptor.EventSink
    public void publishEvent(EventTranslatorVararg<E> translator, Object... args) {
        translateAndPublish(translator, this.sequencer.next(), args);
    }

    @Override // com.lmax.disruptor.EventSink
    public boolean tryPublishEvent(EventTranslatorVararg<E> translator, Object... args) {
        try {
            translateAndPublish(translator, this.sequencer.tryNext(), args);
            return true;
        } catch (InsufficientCapacityException e) {
            return false;
        }
    }

    @Override // com.lmax.disruptor.EventSink
    public void publishEvents(EventTranslator<E>[] translators) {
        publishEvents(translators, 0, translators.length);
    }

    @Override // com.lmax.disruptor.EventSink
    public void publishEvents(EventTranslator<E>[] translators, int batchStartsAt, int batchSize) {
        checkBounds((EventTranslator[]) translators, batchStartsAt, batchSize);
        translateAndPublishBatch(translators, batchStartsAt, batchSize, this.sequencer.next(batchSize));
    }

    @Override // com.lmax.disruptor.EventSink
    public boolean tryPublishEvents(EventTranslator<E>[] translators) {
        return tryPublishEvents(translators, 0, translators.length);
    }

    @Override // com.lmax.disruptor.EventSink
    public boolean tryPublishEvents(EventTranslator<E>[] translators, int batchStartsAt, int batchSize) {
        checkBounds((EventTranslator[]) translators, batchStartsAt, batchSize);
        try {
            translateAndPublishBatch(translators, batchStartsAt, batchSize, this.sequencer.tryNext(batchSize));
            return true;
        } catch (InsufficientCapacityException e) {
            return false;
        }
    }

    @Override // com.lmax.disruptor.EventSink
    public <A> void publishEvents(EventTranslatorOneArg<E, A> translator, A[] arg0) {
        publishEvents(translator, 0, arg0.length, arg0);
    }

    @Override // com.lmax.disruptor.EventSink
    public <A> void publishEvents(EventTranslatorOneArg<E, A> translator, int batchStartsAt, int batchSize, A[] arg0) {
        checkBounds(arg0, batchStartsAt, batchSize);
        translateAndPublishBatch(translator, arg0, batchStartsAt, batchSize, this.sequencer.next(batchSize));
    }

    @Override // com.lmax.disruptor.EventSink
    public <A> boolean tryPublishEvents(EventTranslatorOneArg<E, A> translator, A[] arg0) {
        return tryPublishEvents(translator, 0, arg0.length, arg0);
    }

    @Override // com.lmax.disruptor.EventSink
    public <A> boolean tryPublishEvents(EventTranslatorOneArg<E, A> translator, int batchStartsAt, int batchSize, A[] arg0) {
        checkBounds(arg0, batchStartsAt, batchSize);
        try {
            translateAndPublishBatch(translator, arg0, batchStartsAt, batchSize, this.sequencer.tryNext(batchSize));
            return true;
        } catch (InsufficientCapacityException e) {
            return false;
        }
    }

    @Override // com.lmax.disruptor.EventSink
    public <A, B> void publishEvents(EventTranslatorTwoArg<E, A, B> translator, A[] arg0, B[] arg1) {
        publishEvents(translator, 0, arg0.length, arg0, arg1);
    }

    @Override // com.lmax.disruptor.EventSink
    public <A, B> void publishEvents(EventTranslatorTwoArg<E, A, B> translator, int batchStartsAt, int batchSize, A[] arg0, B[] arg1) {
        checkBounds(arg0, arg1, batchStartsAt, batchSize);
        translateAndPublishBatch(translator, arg0, arg1, batchStartsAt, batchSize, this.sequencer.next(batchSize));
    }

    @Override // com.lmax.disruptor.EventSink
    public <A, B> boolean tryPublishEvents(EventTranslatorTwoArg<E, A, B> translator, A[] arg0, B[] arg1) {
        return tryPublishEvents(translator, 0, arg0.length, arg0, arg1);
    }

    @Override // com.lmax.disruptor.EventSink
    public <A, B> boolean tryPublishEvents(EventTranslatorTwoArg<E, A, B> translator, int batchStartsAt, int batchSize, A[] arg0, B[] arg1) {
        checkBounds(arg0, arg1, batchStartsAt, batchSize);
        try {
            translateAndPublishBatch(translator, arg0, arg1, batchStartsAt, batchSize, this.sequencer.tryNext(batchSize));
            return true;
        } catch (InsufficientCapacityException e) {
            return false;
        }
    }

    @Override // com.lmax.disruptor.EventSink
    public <A, B, C> void publishEvents(EventTranslatorThreeArg<E, A, B, C> translator, A[] arg0, B[] arg1, C[] arg2) {
        publishEvents(translator, 0, arg0.length, arg0, arg1, arg2);
    }

    @Override // com.lmax.disruptor.EventSink
    public <A, B, C> void publishEvents(EventTranslatorThreeArg<E, A, B, C> translator, int batchStartsAt, int batchSize, A[] arg0, B[] arg1, C[] arg2) {
        checkBounds(arg0, arg1, arg2, batchStartsAt, batchSize);
        translateAndPublishBatch(translator, arg0, arg1, arg2, batchStartsAt, batchSize, this.sequencer.next(batchSize));
    }

    @Override // com.lmax.disruptor.EventSink
    public <A, B, C> boolean tryPublishEvents(EventTranslatorThreeArg<E, A, B, C> translator, A[] arg0, B[] arg1, C[] arg2) {
        return tryPublishEvents(translator, 0, arg0.length, arg0, arg1, arg2);
    }

    @Override // com.lmax.disruptor.EventSink
    public <A, B, C> boolean tryPublishEvents(EventTranslatorThreeArg<E, A, B, C> translator, int batchStartsAt, int batchSize, A[] arg0, B[] arg1, C[] arg2) {
        checkBounds(arg0, arg1, arg2, batchStartsAt, batchSize);
        try {
            translateAndPublishBatch(translator, arg0, arg1, arg2, batchStartsAt, batchSize, this.sequencer.tryNext(batchSize));
            return true;
        } catch (InsufficientCapacityException e) {
            return false;
        }
    }

    @Override // com.lmax.disruptor.EventSink
    public void publishEvents(EventTranslatorVararg<E> translator, Object[]... args) {
        publishEvents(translator, 0, args.length, args);
    }

    @Override // com.lmax.disruptor.EventSink
    public void publishEvents(EventTranslatorVararg<E> translator, int batchStartsAt, int batchSize, Object[]... args) {
        checkBounds(batchStartsAt, batchSize, args);
        translateAndPublishBatch(translator, batchStartsAt, batchSize, this.sequencer.next(batchSize), args);
    }

    @Override // com.lmax.disruptor.EventSink
    public boolean tryPublishEvents(EventTranslatorVararg<E> translator, Object[]... args) {
        return tryPublishEvents(translator, 0, args.length, args);
    }

    @Override // com.lmax.disruptor.EventSink
    public boolean tryPublishEvents(EventTranslatorVararg<E> translator, int batchStartsAt, int batchSize, Object[]... args) {
        checkBounds(args, batchStartsAt, batchSize);
        try {
            translateAndPublishBatch(translator, batchStartsAt, batchSize, this.sequencer.tryNext(batchSize), args);
            return true;
        } catch (InsufficientCapacityException e) {
            return false;
        }
    }

    @Override // com.lmax.disruptor.Sequenced
    public void publish(long sequence) {
        this.sequencer.publish(sequence);
    }

    @Override // com.lmax.disruptor.Sequenced
    public void publish(long lo, long hi) {
        this.sequencer.publish(lo, hi);
    }

    @Override // com.lmax.disruptor.Sequenced
    public long remainingCapacity() {
        return this.sequencer.remainingCapacity();
    }

    private void checkBounds(EventTranslator<E>[] translators, int batchStartsAt, int batchSize) {
        checkBatchSizing(batchStartsAt, batchSize);
        batchOverRuns(translators, batchStartsAt, batchSize);
    }

    private <A> void checkBounds(A[] arg0, int batchStartsAt, int batchSize) {
        checkBatchSizing(batchStartsAt, batchSize);
        batchOverRuns(arg0, batchStartsAt, batchSize);
    }

    private <A, B> void checkBounds(A[] arg0, B[] arg1, int batchStartsAt, int batchSize) {
        checkBatchSizing(batchStartsAt, batchSize);
        batchOverRuns(arg0, batchStartsAt, batchSize);
        batchOverRuns(arg1, batchStartsAt, batchSize);
    }

    private <A, B, C> void checkBounds(A[] arg0, B[] arg1, C[] arg2, int batchStartsAt, int batchSize) {
        checkBatchSizing(batchStartsAt, batchSize);
        batchOverRuns(arg0, batchStartsAt, batchSize);
        batchOverRuns(arg1, batchStartsAt, batchSize);
        batchOverRuns(arg2, batchStartsAt, batchSize);
    }

    private void checkBounds(int batchStartsAt, int batchSize, Object[][] args) {
        checkBatchSizing(batchStartsAt, batchSize);
        batchOverRuns(args, batchStartsAt, batchSize);
    }

    private void translateAndPublish(EventTranslator<E> translator, long sequence) {
        try {
            translator.translateTo(get(sequence), sequence);
            this.sequencer.publish(sequence);
        } catch (Throwable th) {
            this.sequencer.publish(sequence);
            throw th;
        }
    }

    private <A> void translateAndPublish(EventTranslatorOneArg<E, A> translator, long sequence, A arg0) {
        try {
            translator.translateTo(get(sequence), sequence, arg0);
            this.sequencer.publish(sequence);
        } catch (Throwable th) {
            this.sequencer.publish(sequence);
            throw th;
        }
    }

    private <A, B> void translateAndPublish(EventTranslatorTwoArg<E, A, B> translator, long sequence, A arg0, B arg1) {
        try {
            translator.translateTo(get(sequence), sequence, arg0, arg1);
            this.sequencer.publish(sequence);
        } catch (Throwable th) {
            this.sequencer.publish(sequence);
            throw th;
        }
    }

    private <A, B, C> void translateAndPublish(EventTranslatorThreeArg<E, A, B, C> translator, long sequence, A arg0, B arg1, C arg2) {
        try {
            translator.translateTo(get(sequence), sequence, arg0, arg1, arg2);
            this.sequencer.publish(sequence);
        } catch (Throwable th) {
            this.sequencer.publish(sequence);
            throw th;
        }
    }

    private void translateAndPublish(EventTranslatorVararg<E> translator, long sequence, Object... args) {
        try {
            translator.translateTo(get(sequence), sequence, args);
            this.sequencer.publish(sequence);
        } catch (Throwable th) {
            this.sequencer.publish(sequence);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [long] */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.lmax.disruptor.Sequencer] */
    /* JADX WARN: Type inference failed for: r17v0 */
    /* JADX WARN: Type inference failed for: r17v1, types: [long] */
    /* JADX WARN: Type inference failed for: r0v11, types: [com.lmax.disruptor.Sequencer] */
    /* JADX WARN: Type inference failed for: r17v4 */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void translateAndPublishBatch(com.lmax.disruptor.EventTranslator<E>[] r10, int r11, int r12, long r13) {
        /*
            r9 = this;
            r0 = r13
            r1 = r12
            r2 = 1
            int r1 = r1 - r2
            long r1 = (long) r1
            long r0 = r0 - r1
            r15 = r0
            r0 = r15
            r17 = r0
            r0 = r11
            r1 = r12
            int r0 = r0 + r1
            r19 = r0
            r0 = r11
            r20 = r0
        L_0x0015:
            r0 = r20
            r1 = r19
            if (r0 >= r1) goto L_0x003c
            r0 = r10
            r1 = r20
            r0 = r0[r1]     // Catch: all -> 0x004c
            r21 = r0
            r0 = r21
            r1 = r9
            r2 = r17
            java.lang.Object r1 = r1.get(r2)     // Catch: all -> 0x004c
            r2 = r17
            r3 = r2; r0 = r0;      // Catch: all -> 0x004c
            r4 = 1
            long r3 = r3 + r4
            r17 = r3
            r0.translateTo(r1, r2)     // Catch: all -> 0x004c
            int r20 = r20 + 1
            goto L_0x0015
        L_0x003c:
            r0 = r9
            com.lmax.disruptor.Sequencer r0 = r0.sequencer
            r1 = r15
            r2 = r13
            r0.publish(r1, r2)
            goto L_0x005e
        L_0x004c:
            r22 = move-exception
            r0 = r9
            com.lmax.disruptor.Sequencer r0 = r0.sequencer
            r1 = r15
            r2 = r13
            r0.publish(r1, r2)
            r0 = r22
            throw r0
        L_0x005e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lmax.disruptor.RingBuffer.translateAndPublishBatch(com.lmax.disruptor.EventTranslator[], int, int, long):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [long] */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.lmax.disruptor.Sequencer] */
    /* JADX WARN: Type inference failed for: r18v0 */
    /* JADX WARN: Type inference failed for: r18v1, types: [long] */
    /* JADX WARN: Type inference failed for: r0v11, types: [com.lmax.disruptor.Sequencer] */
    /* JADX WARN: Type inference failed for: r18v4 */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private <A> void translateAndPublishBatch(com.lmax.disruptor.EventTranslatorOneArg<E, A> r10, A[] r11, int r12, int r13, long r14) {
        /*
            r9 = this;
            r0 = r14
            r1 = r13
            r2 = 1
            int r1 = r1 - r2
            long r1 = (long) r1
            long r0 = r0 - r1
            r16 = r0
            r0 = r16
            r18 = r0
            r0 = r12
            r1 = r13
            int r0 = r0 + r1
            r20 = r0
            r0 = r12
            r21 = r0
        L_0x0017:
            r0 = r21
            r1 = r20
            if (r0 >= r1) goto L_0x003b
            r0 = r10
            r1 = r9
            r2 = r18
            java.lang.Object r1 = r1.get(r2)     // Catch: all -> 0x004b
            r2 = r18
            r3 = r2; r0 = r0;      // Catch: all -> 0x004b
            r4 = 1
            long r3 = r3 + r4
            r18 = r3
            r3 = r11
            r4 = r21
            r3 = r3[r4]     // Catch: all -> 0x004b
            r0.translateTo(r1, r2, r3)     // Catch: all -> 0x004b
            int r21 = r21 + 1
            goto L_0x0017
        L_0x003b:
            r0 = r9
            com.lmax.disruptor.Sequencer r0 = r0.sequencer
            r1 = r16
            r2 = r14
            r0.publish(r1, r2)
            goto L_0x005d
        L_0x004b:
            r22 = move-exception
            r0 = r9
            com.lmax.disruptor.Sequencer r0 = r0.sequencer
            r1 = r16
            r2 = r14
            r0.publish(r1, r2)
            r0 = r22
            throw r0
        L_0x005d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lmax.disruptor.RingBuffer.translateAndPublishBatch(com.lmax.disruptor.EventTranslatorOneArg, java.lang.Object[], int, int, long):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [long] */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.lmax.disruptor.Sequencer] */
    /* JADX WARN: Type inference failed for: r19v0 */
    /* JADX WARN: Type inference failed for: r19v1, types: [long] */
    /* JADX WARN: Type inference failed for: r0v11, types: [com.lmax.disruptor.Sequencer] */
    /* JADX WARN: Type inference failed for: r19v4 */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private <A, B> void translateAndPublishBatch(com.lmax.disruptor.EventTranslatorTwoArg<E, A, B> r10, A[] r11, B[] r12, int r13, int r14, long r15) {
        /*
            r9 = this;
            r0 = r15
            r1 = r14
            r2 = 1
            int r1 = r1 - r2
            long r1 = (long) r1
            long r0 = r0 - r1
            r17 = r0
            r0 = r17
            r19 = r0
            r0 = r13
            r1 = r14
            int r0 = r0 + r1
            r21 = r0
            r0 = r13
            r22 = r0
        L_0x0019:
            r0 = r22
            r1 = r21
            if (r0 >= r1) goto L_0x0041
            r0 = r10
            r1 = r9
            r2 = r19
            java.lang.Object r1 = r1.get(r2)     // Catch: all -> 0x0051
            r2 = r19
            r3 = r2; r0 = r0;      // Catch: all -> 0x0051
            r4 = 1
            long r3 = r3 + r4
            r19 = r3
            r3 = r11
            r4 = r22
            r3 = r3[r4]     // Catch: all -> 0x0051
            r4 = r12
            r5 = r22
            r4 = r4[r5]     // Catch: all -> 0x0051
            r0.translateTo(r1, r2, r3, r4)     // Catch: all -> 0x0051
            int r22 = r22 + 1
            goto L_0x0019
        L_0x0041:
            r0 = r9
            com.lmax.disruptor.Sequencer r0 = r0.sequencer
            r1 = r17
            r2 = r15
            r0.publish(r1, r2)
            goto L_0x0063
        L_0x0051:
            r23 = move-exception
            r0 = r9
            com.lmax.disruptor.Sequencer r0 = r0.sequencer
            r1 = r17
            r2 = r15
            r0.publish(r1, r2)
            r0 = r23
            throw r0
        L_0x0063:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lmax.disruptor.RingBuffer.translateAndPublishBatch(com.lmax.disruptor.EventTranslatorTwoArg, java.lang.Object[], java.lang.Object[], int, int, long):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [long] */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.lmax.disruptor.Sequencer] */
    /* JADX WARN: Type inference failed for: r20v0 */
    /* JADX WARN: Type inference failed for: r20v1, types: [long] */
    /* JADX WARN: Type inference failed for: r0v11, types: [com.lmax.disruptor.Sequencer] */
    /* JADX WARN: Type inference failed for: r20v4 */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private <A, B, C> void translateAndPublishBatch(com.lmax.disruptor.EventTranslatorThreeArg<E, A, B, C> r10, A[] r11, B[] r12, C[] r13, int r14, int r15, long r16) {
        /*
            r9 = this;
            r0 = r16
            r1 = r15
            r2 = 1
            int r1 = r1 - r2
            long r1 = (long) r1
            long r0 = r0 - r1
            r18 = r0
            r0 = r18
            r20 = r0
            r0 = r14
            r1 = r15
            int r0 = r0 + r1
            r22 = r0
            r0 = r14
            r23 = r0
        L_0x0019:
            r0 = r23
            r1 = r22
            if (r0 >= r1) goto L_0x0046
            r0 = r10
            r1 = r9
            r2 = r20
            java.lang.Object r1 = r1.get(r2)     // Catch: all -> 0x0056
            r2 = r20
            r3 = r2; r0 = r0;      // Catch: all -> 0x0056
            r4 = 1
            long r3 = r3 + r4
            r20 = r3
            r3 = r11
            r4 = r23
            r3 = r3[r4]     // Catch: all -> 0x0056
            r4 = r12
            r5 = r23
            r4 = r4[r5]     // Catch: all -> 0x0056
            r5 = r13
            r6 = r23
            r5 = r5[r6]     // Catch: all -> 0x0056
            r0.translateTo(r1, r2, r3, r4, r5)     // Catch: all -> 0x0056
            int r23 = r23 + 1
            goto L_0x0019
        L_0x0046:
            r0 = r9
            com.lmax.disruptor.Sequencer r0 = r0.sequencer
            r1 = r18
            r2 = r16
            r0.publish(r1, r2)
            goto L_0x0068
        L_0x0056:
            r24 = move-exception
            r0 = r9
            com.lmax.disruptor.Sequencer r0 = r0.sequencer
            r1 = r18
            r2 = r16
            r0.publish(r1, r2)
            r0 = r24
            throw r0
        L_0x0068:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lmax.disruptor.RingBuffer.translateAndPublishBatch(com.lmax.disruptor.EventTranslatorThreeArg, java.lang.Object[], java.lang.Object[], java.lang.Object[], int, int, long):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [long] */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.lmax.disruptor.Sequencer] */
    /* JADX WARN: Type inference failed for: r18v0 */
    /* JADX WARN: Type inference failed for: r18v1, types: [long] */
    /* JADX WARN: Type inference failed for: r0v11, types: [com.lmax.disruptor.Sequencer] */
    /* JADX WARN: Type inference failed for: r18v4 */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void translateAndPublishBatch(com.lmax.disruptor.EventTranslatorVararg<E> r10, int r11, int r12, long r13, java.lang.Object[][] r15) {
        /*
            r9 = this;
            r0 = r13
            r1 = r12
            r2 = 1
            int r1 = r1 - r2
            long r1 = (long) r1
            long r0 = r0 - r1
            r16 = r0
            r0 = r16
            r18 = r0
            r0 = r11
            r1 = r12
            int r0 = r0 + r1
            r20 = r0
            r0 = r11
            r21 = r0
        L_0x0015:
            r0 = r21
            r1 = r20
            if (r0 >= r1) goto L_0x003a
            r0 = r10
            r1 = r9
            r2 = r18
            java.lang.Object r1 = r1.get(r2)     // Catch: all -> 0x004a
            r2 = r18
            r3 = r2; r0 = r0;      // Catch: all -> 0x004a
            r4 = 1
            long r3 = r3 + r4
            r18 = r3
            r3 = r15
            r4 = r21
            r3 = r3[r4]     // Catch: all -> 0x004a
            r0.translateTo(r1, r2, r3)     // Catch: all -> 0x004a
            int r21 = r21 + 1
            goto L_0x0015
        L_0x003a:
            r0 = r9
            com.lmax.disruptor.Sequencer r0 = r0.sequencer
            r1 = r16
            r2 = r13
            r0.publish(r1, r2)
            goto L_0x005c
        L_0x004a:
            r22 = move-exception
            r0 = r9
            com.lmax.disruptor.Sequencer r0 = r0.sequencer
            r1 = r16
            r2 = r13
            r0.publish(r1, r2)
            r0 = r22
            throw r0
        L_0x005c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lmax.disruptor.RingBuffer.translateAndPublishBatch(com.lmax.disruptor.EventTranslatorVararg, int, int, long, java.lang.Object[][]):void");
    }
}
