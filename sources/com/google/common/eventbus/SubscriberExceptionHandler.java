package com.google.common.eventbus;

/* loaded from: grasscutter.jar:com/google/common/eventbus/SubscriberExceptionHandler.class */
public interface SubscriberExceptionHandler {
    void handleException(Throwable th, SubscriberExceptionContext subscriberExceptionContext);
}
