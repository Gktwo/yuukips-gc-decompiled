package com.lmax.disruptor.dsl;

import com.lmax.disruptor.ExceptionHandler;
import com.lmax.disruptor.ExceptionHandlers;

/* loaded from: grasscutter.jar:com/lmax/disruptor/dsl/ExceptionHandlerWrapper.class */
public class ExceptionHandlerWrapper<T> implements ExceptionHandler<T> {
    private ExceptionHandler<? super T> delegate;

    public void switchTo(ExceptionHandler<? super T> exceptionHandler) {
        this.delegate = exceptionHandler;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lmax.disruptor.ExceptionHandler
    public void handleEventException(Throwable ex, long sequence, T event) {
        getExceptionHandler().handleEventException(ex, sequence, event);
    }

    @Override // com.lmax.disruptor.ExceptionHandler
    public void handleOnStartException(Throwable ex) {
        getExceptionHandler().handleOnStartException(ex);
    }

    @Override // com.lmax.disruptor.ExceptionHandler
    public void handleOnShutdownException(Throwable ex) {
        getExceptionHandler().handleOnShutdownException(ex);
    }

    private ExceptionHandler<? super T> getExceptionHandler() {
        ExceptionHandler<? super T> handler = this.delegate;
        return handler == null ? ExceptionHandlers.defaultHandler() : handler;
    }
}
