package p013io.netty.util;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import p013io.netty.util.concurrent.DefaultThreadFactory;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.StringUtil;
import p013io.netty.util.internal.SystemPropertyUtil;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

@Deprecated
/* renamed from: io.netty.util.ThreadDeathWatcher */
/* loaded from: grasscutter.jar:io/netty/util/ThreadDeathWatcher.class */
public final class ThreadDeathWatcher {
    static final ThreadFactory threadFactory;
    private static volatile Thread watcherThread;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(ThreadDeathWatcher.class);
    private static final Queue<Entry> pendingEntries = new ConcurrentLinkedQueue();
    private static final Watcher watcher = new Watcher();
    private static final AtomicBoolean started = new AtomicBoolean();

    static {
        String poolName = "threadDeathWatcher";
        String serviceThreadPrefix = SystemPropertyUtil.get("io.netty.serviceThreadPrefix");
        if (!StringUtil.isNullOrEmpty(serviceThreadPrefix)) {
            poolName = serviceThreadPrefix + poolName;
        }
        threadFactory = new DefaultThreadFactory(poolName, true, 1, null);
    }

    public static void watch(Thread thread, Runnable task) {
        ObjectUtil.checkNotNull(thread, "thread");
        ObjectUtil.checkNotNull(task, "task");
        if (!thread.isAlive()) {
            throw new IllegalArgumentException("thread must be alive.");
        }
        schedule(thread, task, true);
    }

    public static void unwatch(Thread thread, Runnable task) {
        schedule((Thread) ObjectUtil.checkNotNull(thread, "thread"), (Runnable) ObjectUtil.checkNotNull(task, "task"), false);
    }

    private static void schedule(Thread thread, Runnable task, boolean isWatch) {
        pendingEntries.add(new Entry(thread, task, isWatch));
        if (started.compareAndSet(false, true)) {
            final Thread watcherThread2 = threadFactory.newThread(watcher);
            AccessController.doPrivileged(new PrivilegedAction<Void>() { // from class: io.netty.util.ThreadDeathWatcher.1
                @Override // java.security.PrivilegedAction
                public Void run() {
                    watcherThread2.setContextClassLoader(null);
                    return null;
                }
            });
            watcherThread2.start();
            watcherThread = watcherThread2;
        }
    }

    public static boolean awaitInactivity(long timeout, TimeUnit unit) throws InterruptedException {
        ObjectUtil.checkNotNull(unit, "unit");
        Thread watcherThread2 = watcherThread;
        if (watcherThread2 == null) {
            return true;
        }
        watcherThread2.join(unit.toMillis(timeout));
        return !watcherThread2.isAlive();
    }

    private ThreadDeathWatcher() {
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.util.ThreadDeathWatcher$Watcher */
    /* loaded from: grasscutter.jar:io/netty/util/ThreadDeathWatcher$Watcher.class */
    public static final class Watcher implements Runnable {
        private final List<Entry> watchees;
        static final /* synthetic */ boolean $assertionsDisabled;

        private Watcher() {
            this.watchees = new ArrayList();
        }

        static {
            $assertionsDisabled = !ThreadDeathWatcher.class.desiredAssertionStatus();
        }

        @Override // java.lang.Runnable
        public void run() {
            while (true) {
                fetchWatchees();
                notifyWatchees();
                fetchWatchees();
                notifyWatchees();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
                if (this.watchees.isEmpty() && ThreadDeathWatcher.pendingEntries.isEmpty()) {
                    boolean stopped = ThreadDeathWatcher.started.compareAndSet(true, false);
                    if (!$assertionsDisabled && !stopped) {
                        throw new AssertionError();
                    } else if (ThreadDeathWatcher.pendingEntries.isEmpty() || !ThreadDeathWatcher.started.compareAndSet(false, true)) {
                        return;
                    }
                }
            }
        }

        private void fetchWatchees() {
            while (true) {
                Entry e = (Entry) ThreadDeathWatcher.pendingEntries.poll();
                if (e != null) {
                    if (e.isWatch) {
                        this.watchees.add(e);
                    } else {
                        this.watchees.remove(e);
                    }
                } else {
                    return;
                }
            }
        }

        private void notifyWatchees() {
            List<Entry> watchees = this.watchees;
            int i = 0;
            while (i < watchees.size()) {
                Entry e = watchees.get(i);
                if (!e.thread.isAlive()) {
                    watchees.remove(i);
                    try {
                        e.task.run();
                    } catch (Throwable t) {
                        ThreadDeathWatcher.logger.warn("Thread death watcher task raised an exception:", t);
                    }
                } else {
                    i++;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.util.ThreadDeathWatcher$Entry */
    /* loaded from: grasscutter.jar:io/netty/util/ThreadDeathWatcher$Entry.class */
    public static final class Entry {
        final Thread thread;
        final Runnable task;
        final boolean isWatch;

        Entry(Thread thread, Runnable task, boolean isWatch) {
            this.thread = thread;
            this.task = task;
            this.isWatch = isWatch;
        }

        public int hashCode() {
            return this.thread.hashCode() ^ this.task.hashCode();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry that = (Entry) obj;
            return this.thread == that.thread && this.task == that.task;
        }
    }
}
