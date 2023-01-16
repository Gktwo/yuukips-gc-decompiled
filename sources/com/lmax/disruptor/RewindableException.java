package com.lmax.disruptor;

/* loaded from: grasscutter.jar:com/lmax/disruptor/RewindableException.class */
public class RewindableException extends RuntimeException {
    public RewindableException(Throwable cause) {
        super("REWINDING BATCH", cause);
    }
}
