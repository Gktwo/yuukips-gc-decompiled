package com.lmax.disruptor.dsl;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.EventProcessor;
import com.lmax.disruptor.Sequence;
import com.lmax.disruptor.SequenceBarrier;

/* loaded from: grasscutter.jar:com/lmax/disruptor/dsl/EventProcessorInfo.class */
class EventProcessorInfo<T> implements ConsumerInfo {
    private final EventProcessor eventprocessor;
    private final EventHandler<? super T> handler;
    private final SequenceBarrier barrier;
    private boolean endOfChain = true;

    /*  JADX ERROR: Dependency scan failed at insn: 0x0018: INVOKE_CUSTOM r-1
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
    /*  JADX ERROR: Failed to decode insn: 0x0018: INVOKE_CUSTOM r2, method: com.lmax.disruptor.dsl.EventProcessorInfo.start(java.util.concurrent.ThreadFactory):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Lcom/lmax/disruptor/EventProcessor;)Ljava/lang/String;}, Failed to create thread to run: ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Lcom/lmax/disruptor/EventProcessor;)Ljava/lang/String;}, Failed to create thread to run: ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    @Override // com.lmax.disruptor.dsl.ConsumerInfo
    public void start(java.util.concurrent.ThreadFactory r5) {
        /*
            r4 = this;
            r0 = r5
            r1 = r4
            com.lmax.disruptor.EventProcessor r1 = r1.eventprocessor
            java.lang.Thread r0 = r0.newThread(r1)
            r6 = r0
            r0 = 0
            r1 = r6
            if (r0 != r1) goto L_0x0021
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r1 = r0
            r2 = r4
            com.lmax.disruptor.EventProcessor r2 = r2.eventprocessor
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Lcom/lmax/disruptor/EventProcessor;)Ljava/lang/String;}, Failed to create thread to run: ]}
            r1.<init>(r2)
            throw r0
            r0 = r6
            r0.start()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lmax.disruptor.dsl.EventProcessorInfo.start(java.util.concurrent.ThreadFactory):void");
    }

    /* access modifiers changed from: package-private */
    public EventProcessorInfo(EventProcessor eventprocessor, EventHandler<? super T> handler, SequenceBarrier barrier) {
        this.eventprocessor = eventprocessor;
        this.handler = handler;
        this.barrier = barrier;
    }

    public EventProcessor getEventProcessor() {
        return this.eventprocessor;
    }

    @Override // com.lmax.disruptor.dsl.ConsumerInfo
    public Sequence[] getSequences() {
        return new Sequence[]{this.eventprocessor.getSequence()};
    }

    public EventHandler<? super T> getHandler() {
        return this.handler;
    }

    @Override // com.lmax.disruptor.dsl.ConsumerInfo
    public SequenceBarrier getBarrier() {
        return this.barrier;
    }

    @Override // com.lmax.disruptor.dsl.ConsumerInfo
    public boolean isEndOfChain() {
        return this.endOfChain;
    }

    @Override // com.lmax.disruptor.dsl.ConsumerInfo
    public void halt() {
        this.eventprocessor.halt();
    }

    @Override // com.lmax.disruptor.dsl.ConsumerInfo
    public void markAsUsedInBarrier() {
        this.endOfChain = false;
    }

    @Override // com.lmax.disruptor.dsl.ConsumerInfo
    public boolean isRunning() {
        return this.eventprocessor.isRunning();
    }
}
