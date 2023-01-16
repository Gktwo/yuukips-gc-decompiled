package com.lmax.disruptor;

/* loaded from: grasscutter.jar:com/lmax/disruptor/AlertException.class */
public final class AlertException extends Exception {
    public static final AlertException INSTANCE = new AlertException();

    private AlertException() {
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        return this;
    }
}
