package com.lmax.disruptor.dsl;

import com.lmax.disruptor.BatchEventProcessor;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.EventProcessor;
import com.lmax.disruptor.EventTranslator;
import com.lmax.disruptor.EventTranslatorOneArg;
import com.lmax.disruptor.EventTranslatorThreeArg;
import com.lmax.disruptor.EventTranslatorTwoArg;
import com.lmax.disruptor.ExceptionHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.Sequence;
import com.lmax.disruptor.SequenceBarrier;
import com.lmax.disruptor.TimeoutException;
import com.lmax.disruptor.WaitStrategy;
import com.lmax.disruptor.util.Util;
import java.util.Iterator;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: grasscutter.jar:com/lmax/disruptor/dsl/Disruptor.class */
public class Disruptor<T> {
    private final RingBuffer<T> ringBuffer;
    private final ThreadFactory threadFactory;
    private final ConsumerRepository<T> consumerRepository;
    private final AtomicBoolean started;
    private ExceptionHandler<? super T> exceptionHandler;

    /*  JADX ERROR: Dependency scan failed at insn: 0x000C: INVOKE_CUSTOM r-3, r-2, r-1
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
    /*  JADX ERROR: Failed to decode insn: 0x000C: INVOKE_CUSTOM r0, r1, r2, method: com.lmax.disruptor.dsl.Disruptor.toString():java.lang.String
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Lcom/lmax/disruptor/RingBuffer;, Ljava/util/concurrent/atomic/AtomicBoolean;, Ljava/util/concurrent/ThreadFactory;)Ljava/lang/String;}, Disruptor{ringBuffer=, started=, threadFactory=}]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Lcom/lmax/disruptor/RingBuffer;, Ljava/util/concurrent/atomic/AtomicBoolean;, Ljava/util/concurrent/ThreadFactory;)Ljava/lang/String;}, Disruptor{ringBuffer=, started=, threadFactory=}]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public java.lang.String toString() {
        /*
            r4 = this;
            r0 = r4
            com.lmax.disruptor.RingBuffer<T> r0 = r0.ringBuffer
            r1 = r4
            java.util.concurrent.atomic.AtomicBoolean r1 = r1.started
            r2 = r4
            java.util.concurrent.ThreadFactory r2 = r2.threadFactory
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Lcom/lmax/disruptor/RingBuffer;, Ljava/util/concurrent/atomic/AtomicBoolean;, Ljava/util/concurrent/ThreadFactory;)Ljava/lang/String;}, Disruptor{ringBuffer=, started=, threadFactory=}]}
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lmax.disruptor.dsl.Disruptor.toString():java.lang.String");
    }

    public Disruptor(EventFactory<T> eventFactory, int ringBufferSize, ThreadFactory threadFactory) {
        this(RingBuffer.createMultiProducer(eventFactory, ringBufferSize), threadFactory);
    }

    public Disruptor(EventFactory<T> eventFactory, int ringBufferSize, ThreadFactory threadFactory, ProducerType producerType, WaitStrategy waitStrategy) {
        this(RingBuffer.create(producerType, eventFactory, ringBufferSize, waitStrategy), threadFactory);
    }

    private Disruptor(RingBuffer<T> ringBuffer, ThreadFactory threadFactory) {
        this.consumerRepository = new ConsumerRepository<>();
        this.started = new AtomicBoolean(false);
        this.exceptionHandler = new ExceptionHandlerWrapper();
        this.ringBuffer = ringBuffer;
        this.threadFactory = threadFactory;
    }

    @SafeVarargs
    public final EventHandlerGroup<T> handleEventsWith(EventHandler<? super T>... handlers) {
        return createEventProcessors(new Sequence[0], handlers);
    }

    @SafeVarargs
    public final EventHandlerGroup<T> handleEventsWith(EventProcessorFactory<T>... eventProcessorFactories) {
        return createEventProcessors(new Sequence[0], eventProcessorFactories);
    }

    public EventHandlerGroup<T> handleEventsWith(EventProcessor... processors) {
        for (EventProcessor processor : processors) {
            this.consumerRepository.add(processor);
        }
        Sequence[] sequences = new Sequence[processors.length];
        for (int i = 0; i < processors.length; i++) {
            sequences[i] = processors[i].getSequence();
        }
        this.ringBuffer.addGatingSequences(sequences);
        return new EventHandlerGroup<>(this, this.consumerRepository, Util.getSequencesFor(processors));
    }

    @Deprecated
    public void handleExceptionsWith(ExceptionHandler<? super T> exceptionHandler) {
        this.exceptionHandler = exceptionHandler;
    }

    public void setDefaultExceptionHandler(ExceptionHandler<? super T> exceptionHandler) {
        checkNotStarted();
        if (!(this.exceptionHandler instanceof ExceptionHandlerWrapper)) {
            throw new IllegalStateException("setDefaultExceptionHandler can not be used after handleExceptionsWith");
        }
        ((ExceptionHandlerWrapper) this.exceptionHandler).switchTo(exceptionHandler);
    }

    public ExceptionHandlerSetting<T> handleExceptionsFor(EventHandler<T> eventHandler) {
        return new ExceptionHandlerSetting<>(eventHandler, this.consumerRepository);
    }

    @SafeVarargs
    public final EventHandlerGroup<T> after(EventHandler<T>... handlers) {
        Sequence[] sequences = new Sequence[handlers.length];
        int handlersLength = handlers.length;
        for (int i = 0; i < handlersLength; i++) {
            sequences[i] = this.consumerRepository.getSequenceFor(handlers[i]);
        }
        return new EventHandlerGroup<>(this, this.consumerRepository, sequences);
    }

    public EventHandlerGroup<T> after(EventProcessor... processors) {
        return new EventHandlerGroup<>(this, this.consumerRepository, Util.getSequencesFor(processors));
    }

    public void publishEvent(EventTranslator<T> eventTranslator) {
        this.ringBuffer.publishEvent(eventTranslator);
    }

    public <A> void publishEvent(EventTranslatorOneArg<T, A> eventTranslator, A arg) {
        this.ringBuffer.publishEvent((EventTranslatorOneArg<T, EventTranslatorOneArg<T, A>>) eventTranslator, (EventTranslatorOneArg<T, A>) arg);
    }

    public <A> void publishEvents(EventTranslatorOneArg<T, A> eventTranslator, A[] arg) {
        this.ringBuffer.publishEvents(eventTranslator, arg);
    }

    public <A, B> void publishEvent(EventTranslatorTwoArg<T, A, B> eventTranslator, A arg0, B arg1) {
        this.ringBuffer.publishEvent(eventTranslator, arg0, arg1);
    }

    public <A, B, C> void publishEvent(EventTranslatorThreeArg<T, A, B, C> eventTranslator, A arg0, B arg1, C arg2) {
        this.ringBuffer.publishEvent(eventTranslator, arg0, arg1, arg2);
    }

    public RingBuffer<T> start() {
        checkOnlyStartedOnce();
        Iterator<ConsumerInfo> it = this.consumerRepository.iterator();
        while (it.hasNext()) {
            it.next().start(this.threadFactory);
        }
        return this.ringBuffer;
    }

    public void halt() {
        Iterator<ConsumerInfo> it = this.consumerRepository.iterator();
        while (it.hasNext()) {
            it.next().halt();
        }
    }

    public void shutdown() {
        try {
            shutdown(-1, TimeUnit.MILLISECONDS);
        } catch (TimeoutException e) {
            this.exceptionHandler.handleOnShutdownException(e);
        }
    }

    public void shutdown(long timeout, TimeUnit timeUnit) throws TimeoutException {
        long timeOutAt = System.currentTimeMillis() + timeUnit.toMillis(timeout);
        while (hasBacklog()) {
            if (timeout >= 0 && System.currentTimeMillis() > timeOutAt) {
                throw TimeoutException.INSTANCE;
            }
        }
        halt();
    }

    public RingBuffer<T> getRingBuffer() {
        return this.ringBuffer;
    }

    public long getCursor() {
        return this.ringBuffer.getCursor();
    }

    public long getBufferSize() {
        return (long) this.ringBuffer.getBufferSize();
    }

    public T get(long sequence) {
        return this.ringBuffer.get(sequence);
    }

    public SequenceBarrier getBarrierFor(EventHandler<T> handler) {
        return this.consumerRepository.getBarrierFor(handler);
    }

    public long getSequenceValueFor(EventHandler<T> b1) {
        return this.consumerRepository.getSequenceFor(b1).get();
    }

    private boolean hasBacklog() {
        return this.consumerRepository.hasBacklog(this.ringBuffer.getCursor(), false);
    }

    public boolean hasStarted() {
        return this.started.get();
    }

    /* access modifiers changed from: package-private */
    public EventHandlerGroup<T> createEventProcessors(Sequence[] barrierSequences, EventHandler<? super T>[] eventHandlers) {
        checkNotStarted();
        Sequence[] processorSequences = new Sequence[eventHandlers.length];
        SequenceBarrier barrier = this.ringBuffer.newBarrier(barrierSequences);
        int eventHandlersLength = eventHandlers.length;
        for (int i = 0; i < eventHandlersLength; i++) {
            EventHandler<? super T> eventHandler = eventHandlers[i];
            BatchEventProcessor<T> batchEventProcessor = new BatchEventProcessor<>(this.ringBuffer, barrier, eventHandler);
            if (this.exceptionHandler != null) {
                batchEventProcessor.setExceptionHandler(this.exceptionHandler);
            }
            this.consumerRepository.add(batchEventProcessor, eventHandler, barrier);
            processorSequences[i] = batchEventProcessor.getSequence();
        }
        updateGatingSequencesForNextInChain(barrierSequences, processorSequences);
        return new EventHandlerGroup<>(this, this.consumerRepository, processorSequences);
    }

    private void updateGatingSequencesForNextInChain(Sequence[] barrierSequences, Sequence[] processorSequences) {
        if (processorSequences.length > 0) {
            this.ringBuffer.addGatingSequences(processorSequences);
            for (Sequence barrierSequence : barrierSequences) {
                this.ringBuffer.removeGatingSequence(barrierSequence);
            }
            this.consumerRepository.unMarkEventProcessorsAsEndOfChain(barrierSequences);
        }
    }

    /* access modifiers changed from: package-private */
    public EventHandlerGroup<T> createEventProcessors(Sequence[] barrierSequences, EventProcessorFactory<T>[] processorFactories) {
        EventProcessor[] eventProcessors = new EventProcessor[processorFactories.length];
        for (int i = 0; i < processorFactories.length; i++) {
            eventProcessors[i] = processorFactories[i].createEventProcessor(this.ringBuffer, barrierSequences);
        }
        return handleEventsWith(eventProcessors);
    }

    private void checkNotStarted() {
        if (this.started.get()) {
            throw new IllegalStateException("All event handlers must be added before calling starts.");
        }
    }

    private void checkOnlyStartedOnce() {
        if (!this.started.compareAndSet(false, true)) {
            throw new IllegalStateException("Disruptor.start() must only be called once.");
        }
    }
}
