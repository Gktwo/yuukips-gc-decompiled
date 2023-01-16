package com.lmax.disruptor;

import java.util.concurrent.TimeUnit;

/* loaded from: grasscutter.jar:com/lmax/disruptor/PhasedBackoffWaitStrategy.class */
public final class PhasedBackoffWaitStrategy implements WaitStrategy {
    private static final int SPIN_TRIES = 10000;
    private final long spinTimeoutNanos;
    private final long yieldTimeoutNanos;
    private final WaitStrategy fallbackStrategy;

    public PhasedBackoffWaitStrategy(long spinTimeout, long yieldTimeout, TimeUnit units, WaitStrategy fallbackStrategy) {
        this.spinTimeoutNanos = units.toNanos(spinTimeout);
        this.yieldTimeoutNanos = this.spinTimeoutNanos + units.toNanos(yieldTimeout);
        this.fallbackStrategy = fallbackStrategy;
    }

    public static PhasedBackoffWaitStrategy withLock(long spinTimeout, long yieldTimeout, TimeUnit units) {
        return new PhasedBackoffWaitStrategy(spinTimeout, yieldTimeout, units, new BlockingWaitStrategy());
    }

    public static PhasedBackoffWaitStrategy withLiteLock(long spinTimeout, long yieldTimeout, TimeUnit units) {
        return new PhasedBackoffWaitStrategy(spinTimeout, yieldTimeout, units, new LiteBlockingWaitStrategy());
    }

    public static PhasedBackoffWaitStrategy withSleep(long spinTimeout, long yieldTimeout, TimeUnit units) {
        return new PhasedBackoffWaitStrategy(spinTimeout, yieldTimeout, units, new SleepingWaitStrategy(0));
    }

    /* JADX WARN: Type inference failed for: r0v20, types: [long] */
    @Override // com.lmax.disruptor.WaitStrategy
    public long waitFor(long sequence, Sequence cursor, Sequence dependentSequence, SequenceBarrier barrier) throws AlertException, InterruptedException, TimeoutException {
        char c = 0;
        int counter = 10000;
        while (true) {
            long availableSequence = dependentSequence.get();
            if (availableSequence >= sequence) {
                return availableSequence;
            }
            counter--;
            if (0 == counter) {
                if (0 == c) {
                    c = System.nanoTime();
                } else {
                    long timeDelta = System.nanoTime() - c;
                    if (timeDelta > this.yieldTimeoutNanos) {
                        return this.fallbackStrategy.waitFor(sequence, cursor, dependentSequence, barrier);
                    }
                    if (timeDelta > this.spinTimeoutNanos) {
                        Thread.yield();
                    }
                }
                counter = 10000;
            }
        }
    }

    @Override // com.lmax.disruptor.WaitStrategy
    public void signalAllWhenBlocking() {
        this.fallbackStrategy.signalAllWhenBlocking();
    }
}
