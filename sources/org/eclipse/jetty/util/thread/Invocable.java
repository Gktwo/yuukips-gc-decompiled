package org.eclipse.jetty.util.thread;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/thread/Invocable.class */
public interface Invocable {
    public static final ThreadLocal<Boolean> __nonBlocking = new ThreadLocal<>();

    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/thread/Invocable$InvocationType.class */
    public enum InvocationType {
        BLOCKING,
        NON_BLOCKING,
        EITHER
    }

    static boolean isNonBlockingInvocation() {
        return Boolean.TRUE.equals(__nonBlocking.get());
    }

    static void invokeNonBlocking(Runnable task) {
        Boolean wasNonBlocking = __nonBlocking.get();
        try {
            __nonBlocking.set(Boolean.TRUE);
            task.run();
            __nonBlocking.set(wasNonBlocking);
        } catch (Throwable th) {
            __nonBlocking.set(wasNonBlocking);
            throw th;
        }
    }

    static InvocationType combine(InvocationType it1, InvocationType it2) {
        if (!(it1 == null || it2 == null)) {
            if (it1 == it2) {
                return it1;
            }
            if (it1 == InvocationType.EITHER) {
                return it2;
            }
            if (it2 == InvocationType.EITHER) {
                return it1;
            }
        }
        return InvocationType.BLOCKING;
    }

    static InvocationType getInvocationType(Object o) {
        if (o instanceof Invocable) {
            return ((Invocable) o).getInvocationType();
        }
        return InvocationType.BLOCKING;
    }

    default InvocationType getInvocationType() {
        return InvocationType.BLOCKING;
    }
}
