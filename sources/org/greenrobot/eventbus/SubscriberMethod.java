package org.greenrobot.eventbus;

import java.lang.reflect.Method;

/* loaded from: grasscutter.jar:org/greenrobot/eventbus/SubscriberMethod.class */
public class SubscriberMethod {
    final Method method;
    final ThreadMode threadMode;
    final Class<?> eventType;
    final int priority;
    final boolean sticky;
    String methodString;

    public SubscriberMethod(Method method, Class<?> eventType, ThreadMode threadMode, int priority, boolean sticky) {
        this.method = method;
        this.threadMode = threadMode;
        this.eventType = eventType;
        this.priority = priority;
        this.sticky = sticky;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof SubscriberMethod)) {
            return false;
        }
        checkMethodString();
        SubscriberMethod otherSubscriberMethod = (SubscriberMethod) other;
        otherSubscriberMethod.checkMethodString();
        return this.methodString.equals(otherSubscriberMethod.methodString);
    }

    private synchronized void checkMethodString() {
        if (this.methodString == null) {
            StringBuilder builder = new StringBuilder(64);
            builder.append(this.method.getDeclaringClass().getName());
            builder.append('#').append(this.method.getName());
            builder.append('(').append(this.eventType.getName());
            this.methodString = builder.toString();
        }
    }

    public int hashCode() {
        return this.method.hashCode();
    }
}
