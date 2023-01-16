package org.greenrobot.eventbus;

/* loaded from: grasscutter.jar:org/greenrobot/eventbus/NoSubscriberEvent.class */
public final class NoSubscriberEvent {
    public final EventBus eventBus;
    public final Object originalEvent;

    public NoSubscriberEvent(EventBus eventBus, Object originalEvent) {
        this.eventBus = eventBus;
        this.originalEvent = originalEvent;
    }
}
