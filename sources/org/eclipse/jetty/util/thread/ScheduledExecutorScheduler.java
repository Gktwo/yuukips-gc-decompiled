package org.eclipse.jetty.util.thread;

import java.io.IOException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.eclipse.jetty.util.StringUtil;
import org.eclipse.jetty.util.annotation.ManagedAttribute;
import org.eclipse.jetty.util.annotation.ManagedObject;
import org.eclipse.jetty.util.annotation.Name;
import org.eclipse.jetty.util.component.AbstractLifeCycle;
import org.eclipse.jetty.util.component.Dumpable;
import org.eclipse.jetty.util.thread.Scheduler;

@ManagedObject
/* loaded from: grasscutter.jar:org/eclipse/jetty/util/thread/ScheduledExecutorScheduler.class */
public class ScheduledExecutorScheduler extends AbstractLifeCycle implements Scheduler, Dumpable {
    private final String name;
    private final boolean daemon;
    private final ClassLoader classloader;
    private final ThreadGroup threadGroup;
    private final int threads;
    private final AtomicInteger count;
    private volatile ScheduledThreadPoolExecutor scheduler;
    private volatile Thread thread;

    public ScheduledExecutorScheduler() {
        this(null, false);
    }

    public ScheduledExecutorScheduler(String name, boolean daemon) {
        this(name, daemon, (ClassLoader) null);
    }

    public ScheduledExecutorScheduler(@Name("name") String name, @Name("daemon") boolean daemon, @Name("threads") int threads) {
        this(name, daemon, null, null, threads);
    }

    public ScheduledExecutorScheduler(String name, boolean daemon, ClassLoader classLoader) {
        this(name, daemon, classLoader, null);
    }

    public ScheduledExecutorScheduler(String name, boolean daemon, ClassLoader classLoader, ThreadGroup threadGroup) {
        this(name, daemon, classLoader, threadGroup, -1);
    }

    public ScheduledExecutorScheduler(@Name("name") String name, @Name("daemon") boolean daemon, @Name("classLoader") ClassLoader classLoader, @Name("threadGroup") ThreadGroup threadGroup, @Name("threads") int threads) {
        this.count = new AtomicInteger();
        this.name = StringUtil.isBlank(name) ? "Scheduler-" + hashCode() : name;
        this.daemon = daemon;
        this.classloader = classLoader == null ? Thread.currentThread().getContextClassLoader() : classLoader;
        this.threadGroup = threadGroup;
        this.threads = threads;
    }

    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle
    protected void doStart() throws Exception {
        this.scheduler = new ScheduledThreadPoolExecutor(this.threads > 0 ? this.threads : 1, r -> {
            Thread thread = new Thread(this.threadGroup, r, this.name + "-" + this.count.incrementAndGet());
            this.thread = thread;
            thread.setDaemon(this.daemon);
            thread.setContextClassLoader(this.classloader);
            return thread;
        });
        this.scheduler.setRemoveOnCancelPolicy(true);
        doStart();
    }

    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle
    protected void doStop() throws Exception {
        this.scheduler.shutdownNow();
        doStop();
        this.scheduler = null;
    }

    @Override // org.eclipse.jetty.util.thread.Scheduler
    public Scheduler.Task schedule(Runnable task, long delay, TimeUnit unit) {
        ScheduledThreadPoolExecutor s = this.scheduler;
        if (s == null) {
            return () -> {
                return false;
            };
        }
        return new ScheduledFutureTask(s.schedule(task, delay, unit));
    }

    @Override // org.eclipse.jetty.util.component.Dumpable
    public String dump() {
        return Dumpable.dump(this);
    }

    @Override // org.eclipse.jetty.util.component.Dumpable
    public void dump(Appendable out, String indent) throws IOException {
        Thread thread = this.thread;
        if (thread == null) {
            Dumpable.dumpObject(out, this);
        } else {
            Dumpable.dumpObjects(out, indent, this, thread.getStackTrace());
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/thread/ScheduledExecutorScheduler$ScheduledFutureTask.class */
    private static class ScheduledFutureTask implements Scheduler.Task {
        private final ScheduledFuture<?> scheduledFuture;

        ScheduledFutureTask(ScheduledFuture<?> scheduledFuture) {
            this.scheduledFuture = scheduledFuture;
        }

        @Override // org.eclipse.jetty.util.thread.Scheduler.Task
        public boolean cancel() {
            return this.scheduledFuture.cancel(false);
        }
    }

    @ManagedAttribute("The name of the scheduler")
    public String getName() {
        return this.name;
    }

    @ManagedAttribute("Whether the scheduler uses daemon threads")
    public boolean isDaemon() {
        return this.daemon;
    }

    @ManagedAttribute("The number of scheduler threads")
    public int getThreads() {
        return this.threads;
    }
}
