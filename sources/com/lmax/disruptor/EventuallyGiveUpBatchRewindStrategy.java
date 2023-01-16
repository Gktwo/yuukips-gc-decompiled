package com.lmax.disruptor;

/* loaded from: grasscutter.jar:com/lmax/disruptor/EventuallyGiveUpBatchRewindStrategy.class */
public class EventuallyGiveUpBatchRewindStrategy implements BatchRewindStrategy {
    private final long maxAttempts;

    public EventuallyGiveUpBatchRewindStrategy(long maxAttempts) {
        this.maxAttempts = maxAttempts;
    }

    @Override // com.lmax.disruptor.BatchRewindStrategy
    public RewindAction handleRewindException(RewindableException e, int retriesAttempted) {
        if (((long) retriesAttempted) == this.maxAttempts) {
            return RewindAction.THROW;
        }
        return RewindAction.REWIND;
    }
}
