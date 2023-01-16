package com.lmax.disruptor;

import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: grasscutter.jar:com/lmax/disruptor/BatchEventProcessor.class */
public final class BatchEventProcessor<T> implements EventProcessor {
    private static final int IDLE = 0;
    private static final int HALTED = 1;
    private static final int RUNNING = 2;
    private ExceptionHandler<? super T> exceptionHandler;
    private final DataProvider<T> dataProvider;
    private final SequenceBarrier sequenceBarrier;
    private final EventHandler<? super T> eventHandler;
    private final AtomicInteger running = new AtomicInteger(0);
    private final Sequence sequence = new Sequence(-1);
    private BatchRewindStrategy batchRewindStrategy = new SimpleBatchRewindStrategy();
    private int retriesAttempted = 0;

    public BatchEventProcessor(DataProvider<T> dataProvider, SequenceBarrier sequenceBarrier, EventHandler<? super T> eventHandler) {
        this.dataProvider = dataProvider;
        this.sequenceBarrier = sequenceBarrier;
        this.eventHandler = eventHandler;
        eventHandler.setSequenceCallback(this.sequence);
    }

    @Override // com.lmax.disruptor.EventProcessor
    public Sequence getSequence() {
        return this.sequence;
    }

    @Override // com.lmax.disruptor.EventProcessor
    public void halt() {
        this.running.set(1);
        this.sequenceBarrier.alert();
    }

    @Override // com.lmax.disruptor.EventProcessor
    public boolean isRunning() {
        return this.running.get() != 0;
    }

    public void setExceptionHandler(ExceptionHandler<? super T> exceptionHandler) {
        if (null == exceptionHandler) {
            throw new NullPointerException();
        }
        this.exceptionHandler = exceptionHandler;
    }

    public void setRewindStrategy(BatchRewindStrategy batchRewindStrategy) {
        if (null == batchRewindStrategy) {
            throw new NullPointerException();
        }
        this.batchRewindStrategy = batchRewindStrategy;
    }

    @Override // java.lang.Runnable
    public void run() {
        int witnessValue = this.running.compareAndExchange(0, 2);
        if (witnessValue == 0) {
            this.sequenceBarrier.clearAlert();
            notifyStart();
            try {
                if (this.running.get() == 2) {
                    processEvents();
                }
            } finally {
                notifyShutdown();
                this.running.set(0);
            }
        } else if (witnessValue == 2) {
            throw new IllegalStateException("Thread is already running");
        } else {
            earlyExit();
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:15:0x0072
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    private void processEvents() {
        /*
        // Method dump skipped, instructions count: 222
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lmax.disruptor.BatchEventProcessor.processEvents():void");
    }

    private void earlyExit() {
        notifyStart();
        notifyShutdown();
    }

    private void notifyTimeout(long availableSequence) {
        try {
            this.eventHandler.onTimeout(availableSequence);
        } catch (Throwable e) {
            handleEventException(e, availableSequence, null);
        }
    }

    private void notifyStart() {
        try {
            this.eventHandler.onStart();
        } catch (Throwable ex) {
            handleOnStartException(ex);
        }
    }

    private void notifyShutdown() {
        try {
            this.eventHandler.onShutdown();
        } catch (Throwable ex) {
            handleOnShutdownException(ex);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    private void handleEventException(Throwable ex, long sequence, T event) {
        getExceptionHandler().handleEventException(ex, sequence, event);
    }

    private void handleOnStartException(Throwable ex) {
        getExceptionHandler().handleOnStartException(ex);
    }

    private void handleOnShutdownException(Throwable ex) {
        getExceptionHandler().handleOnShutdownException(ex);
    }

    private ExceptionHandler<? super T> getExceptionHandler() {
        ExceptionHandler<? super T> handler = this.exceptionHandler;
        return handler == null ? ExceptionHandlers.defaultHandler() : handler;
    }
}
