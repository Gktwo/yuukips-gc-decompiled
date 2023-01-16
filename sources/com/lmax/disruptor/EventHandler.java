package com.lmax.disruptor;

/* loaded from: grasscutter.jar:com/lmax/disruptor/EventHandler.class */
public interface EventHandler<T> {
    void onEvent(T t, long j, boolean z) throws Exception;

    default void onBatchStart(long batchSize) {
    }

    default void onStart() {
    }

    default void onShutdown() {
    }

    default void setSequenceCallback(Sequence sequenceCallback) {
    }

    default void onTimeout(long sequence) throws Exception {
    }
}
