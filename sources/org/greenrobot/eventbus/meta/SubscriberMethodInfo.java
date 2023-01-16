package org.greenrobot.eventbus.meta;

import org.greenrobot.eventbus.ThreadMode;

/* loaded from: grasscutter.jar:org/greenrobot/eventbus/meta/SubscriberMethodInfo.class */
public class SubscriberMethodInfo {
    final String methodName;
    final ThreadMode threadMode;
    final Class<?> eventType;
    final int priority;
    final boolean sticky;

    public SubscriberMethodInfo(String methodName, Class<?> eventType, ThreadMode threadMode, int priority, boolean sticky) {
        this.methodName = methodName;
        this.threadMode = threadMode;
        this.eventType = eventType;
        this.priority = priority;
        this.sticky = sticky;
    }

    public SubscriberMethodInfo(String methodName, Class<?> eventType) {
        this(methodName, eventType, ThreadMode.POSTING, 0, false);
    }

    public SubscriberMethodInfo(String methodName, Class<?> eventType, ThreadMode threadMode) {
        this(methodName, eventType, threadMode, 0, false);
    }
}
