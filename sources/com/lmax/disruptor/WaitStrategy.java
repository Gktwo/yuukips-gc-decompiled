package com.lmax.disruptor;

/* loaded from: grasscutter.jar:com/lmax/disruptor/WaitStrategy.class */
public interface WaitStrategy {
    long waitFor(long j, Sequence sequence, Sequence sequence2, SequenceBarrier sequenceBarrier) throws AlertException, InterruptedException, TimeoutException;

    void signalAllWhenBlocking();
}
