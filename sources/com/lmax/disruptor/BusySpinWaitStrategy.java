package com.lmax.disruptor;

/* loaded from: grasscutter.jar:com/lmax/disruptor/BusySpinWaitStrategy.class */
public final class BusySpinWaitStrategy implements WaitStrategy {
    @Override // com.lmax.disruptor.WaitStrategy
    public long waitFor(long sequence, Sequence cursor, Sequence dependentSequence, SequenceBarrier barrier) throws AlertException, InterruptedException {
        while (true) {
            long availableSequence = dependentSequence.get();
            if (availableSequence >= sequence) {
                return availableSequence;
            }
            barrier.checkAlert();
            Thread.onSpinWait();
        }
    }

    @Override // com.lmax.disruptor.WaitStrategy
    public void signalAllWhenBlocking() {
    }
}
