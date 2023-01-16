package com.lmax.disruptor;

/* loaded from: grasscutter.jar:com/lmax/disruptor/SequenceBarrier.class */
public interface SequenceBarrier {
    long waitFor(long j) throws AlertException, InterruptedException, TimeoutException;

    long getCursor();

    boolean isAlerted();

    void alert();

    void clearAlert();

    void checkAlert() throws AlertException;
}
