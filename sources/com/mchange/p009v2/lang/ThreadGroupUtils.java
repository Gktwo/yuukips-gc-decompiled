package com.mchange.p009v2.lang;

/* renamed from: com.mchange.v2.lang.ThreadGroupUtils */
/* loaded from: grasscutter.jar:com/mchange/v2/lang/ThreadGroupUtils.class */
public final class ThreadGroupUtils {
    public static ThreadGroup rootThreadGroup() {
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        ThreadGroup parent = threadGroup.getParent();
        while (parent != null) {
            threadGroup = parent;
            parent = threadGroup.getParent();
        }
        return threadGroup;
    }

    private ThreadGroupUtils() {
    }
}
