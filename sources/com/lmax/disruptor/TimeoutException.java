package com.lmax.disruptor;

/* loaded from: grasscutter.jar:com/lmax/disruptor/TimeoutException.class */
public final class TimeoutException extends Exception {
    public static final TimeoutException INSTANCE = new TimeoutException();

    private TimeoutException() {
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        return this;
    }
}
