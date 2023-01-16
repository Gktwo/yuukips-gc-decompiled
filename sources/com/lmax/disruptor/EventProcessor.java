package com.lmax.disruptor;

/* loaded from: grasscutter.jar:com/lmax/disruptor/EventProcessor.class */
public interface EventProcessor extends Runnable {
    Sequence getSequence();

    void halt();

    boolean isRunning();
}
