package com.lmax.disruptor;

/* loaded from: grasscutter.jar:com/lmax/disruptor/BatchRewindStrategy.class */
public interface BatchRewindStrategy {
    RewindAction handleRewindException(RewindableException rewindableException, int i);
}
