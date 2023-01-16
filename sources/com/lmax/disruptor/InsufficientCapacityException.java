package com.lmax.disruptor;

/* loaded from: grasscutter.jar:com/lmax/disruptor/InsufficientCapacityException.class */
public final class InsufficientCapacityException extends Exception {
    public static final InsufficientCapacityException INSTANCE = new InsufficientCapacityException();

    private InsufficientCapacityException() {
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        return this;
    }
}
