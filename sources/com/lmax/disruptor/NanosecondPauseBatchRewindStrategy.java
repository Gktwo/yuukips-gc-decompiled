package com.lmax.disruptor;

import java.util.concurrent.locks.LockSupport;

/* loaded from: grasscutter.jar:com/lmax/disruptor/NanosecondPauseBatchRewindStrategy.class */
public class NanosecondPauseBatchRewindStrategy implements BatchRewindStrategy {
    private final long nanoSecondPauseTime;

    public NanosecondPauseBatchRewindStrategy(long nanoSecondPauseTime) {
        this.nanoSecondPauseTime = nanoSecondPauseTime;
    }

    @Override // com.lmax.disruptor.BatchRewindStrategy
    public RewindAction handleRewindException(RewindableException e, int retriesAttempted) {
        LockSupport.parkNanos(this.nanoSecondPauseTime);
        return RewindAction.REWIND;
    }
}
