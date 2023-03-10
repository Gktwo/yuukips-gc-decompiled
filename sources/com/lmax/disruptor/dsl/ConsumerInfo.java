package com.lmax.disruptor.dsl;

import com.lmax.disruptor.Sequence;
import com.lmax.disruptor.SequenceBarrier;
import java.util.concurrent.ThreadFactory;

/* loaded from: grasscutter.jar:com/lmax/disruptor/dsl/ConsumerInfo.class */
interface ConsumerInfo {
    Sequence[] getSequences();

    SequenceBarrier getBarrier();

    boolean isEndOfChain();

    void start(ThreadFactory threadFactory);

    void halt();

    void markAsUsedInBarrier();

    boolean isRunning();
}
