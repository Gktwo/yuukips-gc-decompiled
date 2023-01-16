package com.lmax.disruptor;

import java.util.concurrent.locks.LockSupport;

/* loaded from: grasscutter.jar:com/lmax/disruptor/SleepingWaitStrategy.class */
public final class SleepingWaitStrategy implements WaitStrategy {
    private static final int SPIN_THRESHOLD = 100;
    private static final int DEFAULT_RETRIES = 200;
    private static final long DEFAULT_SLEEP = 100;
    private final int retries;
    private final long sleepTimeNs;

    public SleepingWaitStrategy() {
        this(200, DEFAULT_SLEEP);
    }

    public SleepingWaitStrategy(int retries) {
        this(retries, DEFAULT_SLEEP);
    }

    public SleepingWaitStrategy(int retries, long sleepTimeNs) {
        this.retries = retries;
        this.sleepTimeNs = sleepTimeNs;
    }

    @Override // com.lmax.disruptor.WaitStrategy
    public long waitFor(long sequence, Sequence cursor, Sequence dependentSequence, SequenceBarrier barrier) throws AlertException {
        int counter = this.retries;
        while (true) {
            long availableSequence = dependentSequence.get();
            if (availableSequence >= sequence) {
                return availableSequence;
            }
            counter = applyWaitMethod(barrier, counter);
        }
    }

    @Override // com.lmax.disruptor.WaitStrategy
    public void signalAllWhenBlocking() {
    }

    private int applyWaitMethod(SequenceBarrier barrier, int counter) throws AlertException {
        barrier.checkAlert();
        if (counter > 100) {
            return counter - 1;
        }
        if (counter > 0) {
            Thread.yield();
            return counter - 1;
        }
        LockSupport.parkNanos(this.sleepTimeNs);
        return counter;
    }
}
