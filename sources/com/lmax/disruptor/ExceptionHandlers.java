package com.lmax.disruptor;

/* loaded from: grasscutter.jar:com/lmax/disruptor/ExceptionHandlers.class */
public final class ExceptionHandlers {
    public static ExceptionHandler<Object> defaultHandler() {
        return DefaultExceptionHandlerHolder.HANDLER;
    }

    private ExceptionHandlers() {
    }

    /* loaded from: grasscutter.jar:com/lmax/disruptor/ExceptionHandlers$DefaultExceptionHandlerHolder.class */
    private static final class DefaultExceptionHandlerHolder {
        private static final ExceptionHandler<Object> HANDLER = new FatalExceptionHandler();

        private DefaultExceptionHandlerHolder() {
        }
    }
}
