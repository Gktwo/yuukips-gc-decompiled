package com.lmax.disruptor;

/* loaded from: grasscutter.jar:com/lmax/disruptor/ExceptionHandler.class */
public interface ExceptionHandler<T> {
    void handleEventException(Throwable th, long j, T t);

    void handleOnStartException(Throwable th);

    void handleOnShutdownException(Throwable th);
}
