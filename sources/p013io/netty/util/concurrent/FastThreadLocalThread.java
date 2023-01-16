package p013io.netty.util.concurrent;

import p013io.netty.util.internal.InternalThreadLocalMap;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

/* renamed from: io.netty.util.concurrent.FastThreadLocalThread */
/* loaded from: grasscutter.jar:io/netty/util/concurrent/FastThreadLocalThread.class */
public class FastThreadLocalThread extends Thread {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(FastThreadLocalThread.class);
    private final boolean cleanupFastThreadLocals = false;
    private InternalThreadLocalMap threadLocalMap;

    public FastThreadLocalThread() {
    }

    public FastThreadLocalThread(Runnable target) {
        super(FastThreadLocalRunnable.wrap(target));
    }

    public FastThreadLocalThread(ThreadGroup group, Runnable target) {
        super(group, FastThreadLocalRunnable.wrap(target));
    }

    public FastThreadLocalThread(String name) {
        super(name);
    }

    public FastThreadLocalThread(ThreadGroup group, String name) {
        super(group, name);
    }

    public FastThreadLocalThread(Runnable target, String name) {
        super(FastThreadLocalRunnable.wrap(target), name);
    }

    public FastThreadLocalThread(ThreadGroup group, Runnable target, String name) {
        super(group, FastThreadLocalRunnable.wrap(target), name);
    }

    public FastThreadLocalThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, FastThreadLocalRunnable.wrap(target), name, stackSize);
    }

    public final InternalThreadLocalMap threadLocalMap() {
        if (this != Thread.currentThread() && logger.isWarnEnabled()) {
            logger.warn(new RuntimeException("It's not thread-safe to get 'threadLocalMap' which doesn't belong to the caller thread"));
        }
        return this.threadLocalMap;
    }

    public final void setThreadLocalMap(InternalThreadLocalMap threadLocalMap) {
        if (this != Thread.currentThread() && logger.isWarnEnabled()) {
            logger.warn(new RuntimeException("It's not thread-safe to set 'threadLocalMap' which doesn't belong to the caller thread"));
        }
        this.threadLocalMap = threadLocalMap;
    }

    public boolean willCleanupFastThreadLocals() {
        return this.cleanupFastThreadLocals;
    }

    public static boolean willCleanupFastThreadLocals(Thread thread) {
        return (thread instanceof FastThreadLocalThread) && ((FastThreadLocalThread) thread).willCleanupFastThreadLocals();
    }
}
