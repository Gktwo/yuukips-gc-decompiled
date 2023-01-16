package com.lmax.disruptor.dsl;

import com.lmax.disruptor.EventHandler;

/* loaded from: grasscutter.jar:com/lmax/disruptor/dsl/ExceptionHandlerSetting.class */
public class ExceptionHandlerSetting<T> {
    private final EventHandler<T> eventHandler;
    private final ConsumerRepository<T> consumerRepository;

    /*  JADX ERROR: Dependency scan failed at insn: 0x0033: INVOKE_CUSTOM r-5
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
    /*  JADX ERROR: Failed to decode insn: 0x0033: INVOKE_CUSTOM r2, method: com.lmax.disruptor.dsl.ExceptionHandlerSetting.with(com.lmax.disruptor.ExceptionHandler<? super T>):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Lcom/lmax/disruptor/EventProcessor;)Ljava/lang/String;}, EventProcessor:  is not a BatchEventProcessor and does not support exception handlers]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Lcom/lmax/disruptor/EventProcessor;)Ljava/lang/String;}, EventProcessor:  is not a BatchEventProcessor and does not support exception handlers]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public void with(com.lmax.disruptor.ExceptionHandler<? super T> r5) {
        /*
            r4 = this;
            r0 = r4
            com.lmax.disruptor.dsl.ConsumerRepository<T> r0 = r0.consumerRepository
            r1 = r4
            com.lmax.disruptor.EventHandler<T> r1 = r1.eventHandler
            com.lmax.disruptor.EventProcessor r0 = r0.getEventProcessorFor(r1)
            r6 = r0
            r0 = r6
            boolean r0 = r0 instanceof com.lmax.disruptor.BatchEventProcessor
            if (r0 == 0) goto L_0x002e
            r0 = r6
            com.lmax.disruptor.BatchEventProcessor r0 = (com.lmax.disruptor.BatchEventProcessor) r0
            r1 = r5
            r0.setExceptionHandler(r1)
            r0 = r4
            com.lmax.disruptor.dsl.ConsumerRepository<T> r0 = r0.consumerRepository
            r1 = r4
            com.lmax.disruptor.EventHandler<T> r1 = r1.eventHandler
            com.lmax.disruptor.SequenceBarrier r0 = r0.getBarrierFor(r1)
            r0.alert()
            goto L_0x003c
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r1 = r0
            r2 = r6
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Lcom/lmax/disruptor/EventProcessor;)Ljava/lang/String;}, EventProcessor:  is not a BatchEventProcessor and does not support exception handlers]}
            r1.<init>(r2)
            throw r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lmax.disruptor.dsl.ExceptionHandlerSetting.with(com.lmax.disruptor.ExceptionHandler):void");
    }

    /* access modifiers changed from: package-private */
    public ExceptionHandlerSetting(EventHandler<T> eventHandler, ConsumerRepository<T> consumerRepository) {
        this.eventHandler = eventHandler;
        this.consumerRepository = consumerRepository;
    }
}
