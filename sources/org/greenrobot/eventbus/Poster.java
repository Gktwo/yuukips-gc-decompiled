package org.greenrobot.eventbus;

/* loaded from: grasscutter.jar:org/greenrobot/eventbus/Poster.class */
public interface Poster {
    void enqueue(Subscription subscription, Object obj);
}
