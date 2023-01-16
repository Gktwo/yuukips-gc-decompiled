package com.lmax.disruptor;

/* loaded from: grasscutter.jar:com/lmax/disruptor/YieldingWaitStrategy.class */
public final class YieldingWaitStrategy implements WaitStrategy {
    private static final int SPIN_TRIES = 100;

    @Override // com.lmax.disruptor.WaitStrategy
    public long waitFor(long sequence, Sequence cursor, Sequence dependentSequence, SequenceBarrier barrier) throws AlertException, InterruptedException {
        int counter = 100;
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
        if (0 != counter) {
            return counter - 1;
        }
        Thread.yield();
        return counter;
    }
}
