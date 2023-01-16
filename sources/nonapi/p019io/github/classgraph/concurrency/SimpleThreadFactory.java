package nonapi.p019io.github.classgraph.concurrency;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: nonapi.io.github.classgraph.concurrency.SimpleThreadFactory */
/* loaded from: grasscutter.jar:nonapi/io/github/classgraph/concurrency/SimpleThreadFactory.class */
public class SimpleThreadFactory implements ThreadFactory {
    private final String threadNamePrefix;
    private static final AtomicInteger threadIdx = new AtomicInteger();
    private final boolean daemon;

    /* access modifiers changed from: package-private */
    public SimpleThreadFactory(String threadNamePrefix, boolean daemon) {
        this.threadNamePrefix = threadNamePrefix;
        this.daemon = daemon;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        SecurityManager s = System.getSecurityManager();
        Thread thread = new Thread(s != null ? s.getThreadGroup() : new ThreadGroup("ClassGraph-thread-group"), runnable, this.threadNamePrefix + threadIdx.getAndIncrement());
        thread.setDaemon(this.daemon);
        return thread;
    }
}
