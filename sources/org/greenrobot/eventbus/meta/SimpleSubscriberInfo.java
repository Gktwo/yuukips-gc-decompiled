package org.greenrobot.eventbus.meta;

import org.greenrobot.eventbus.SubscriberMethod;

/* loaded from: grasscutter.jar:org/greenrobot/eventbus/meta/SimpleSubscriberInfo.class */
public class SimpleSubscriberInfo extends AbstractSubscriberInfo {
    private final SubscriberMethodInfo[] methodInfos;

    public SimpleSubscriberInfo(Class subscriberClass, boolean shouldCheckSuperclass, SubscriberMethodInfo[] methodInfos) {
        super(subscriberClass, null, shouldCheckSuperclass);
        this.methodInfos = methodInfos;
    }

    @Override // org.greenrobot.eventbus.meta.SubscriberInfo
    public synchronized SubscriberMethod[] getSubscriberMethods() {
        int length = this.methodInfos.length;
        SubscriberMethod[] methods = new SubscriberMethod[length];
        for (int i = 0; i < length; i++) {
            SubscriberMethodInfo info = this.methodInfos[i];
            methods[i] = createSubscriberMethod(info.methodName, info.eventType, info.threadMode, info.priority, info.sticky);
        }
        return methods;
    }
}
