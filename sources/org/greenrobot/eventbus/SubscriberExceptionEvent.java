package org.greenrobot.eventbus;

/* loaded from: grasscutter.jar:org/greenrobot/eventbus/SubscriberExceptionEvent.class */
public final class SubscriberExceptionEvent {
    public final EventBus eventBus;
    public final Throwable throwable;
    public final Object causingEvent;
    public final Object causingSubscriber;

    public SubscriberExceptionEvent(EventBus eventBus, Throwable throwable, Object causingEvent, Object causingSubscriber) {
        this.eventBus = eventBus;
        this.throwable = throwable;
        this.causingEvent = causingEvent;
        this.causingSubscriber = causingSubscriber;
    }
}
