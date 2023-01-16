package com.lmax.disruptor;

/* loaded from: grasscutter.jar:com/lmax/disruptor/SimpleBatchRewindStrategy.class */
public class SimpleBatchRewindStrategy implements BatchRewindStrategy {
    @Override // com.lmax.disruptor.BatchRewindStrategy
    public RewindAction handleRewindException(RewindableException e, int retriesAttempted) {
        return RewindAction.REWIND;
    }
}
