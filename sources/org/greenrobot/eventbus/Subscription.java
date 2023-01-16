package org.greenrobot.eventbus;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/greenrobot/eventbus/Subscription.class */
public final class Subscription {
    final Object subscriber;
    final SubscriberMethod subscriberMethod;
    volatile boolean active = true;

    /* access modifiers changed from: package-private */
    public Subscription(Object subscriber, SubscriberMethod subscriberMethod) {
        this.subscriber = subscriber;
        this.subscriberMethod = subscriberMethod;
    }

    public boolean equals(Object other) {
        if (!(other instanceof Subscription)) {
            return false;
        }
        Subscription otherSubscription = (Subscription) other;
        return this.subscriber == otherSubscription.subscriber && this.subscriberMethod.equals(otherSubscription.subscriberMethod);
    }

    public int hashCode() {
        return this.subscriber.hashCode() + this.subscriberMethod.methodString.hashCode();
    }
}
