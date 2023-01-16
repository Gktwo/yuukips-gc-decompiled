package p013io.netty.util.concurrent;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jetbrains.annotations.Async;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.ThreadExecutorMap;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

/* renamed from: io.netty.util.concurrent.GlobalEventExecutor */
/* loaded from: grasscutter.jar:io/netty/util/concurrent/GlobalEventExecutor.class */
public final class GlobalEventExecutor extends AbstractScheduledEventExecutor implements OrderedEventExecutor {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(GlobalEventExecutor.class);
    private static final long SCHEDULE_QUIET_PERIOD_INTERVAL = TimeUnit.SECONDS.toNanos(1);
    public static final GlobalEventExecutor INSTANCE = new GlobalEventExecutor();
    volatile Thread thread;
    final BlockingQueue<Runnable> taskQueue = new LinkedBlockingQueue();
    final ScheduledFutureTask<Void> quietPeriodTask = new ScheduledFutureTask<>(this, Executors.callable(new Runnable() { // from class: io.netty.util.concurrent.GlobalEventExecutor.1
        @Override // java.lang.Runnable
        public void run() {
        }
    }, null), deadlineNanos(getCurrentTimeNanos(), SCHEDULE_QUIET_PERIOD_INTERVAL), -SCHEDULE_QUIET_PERIOD_INTERVAL);
    private final TaskRunner taskRunner = new TaskRunner();
    private final AtomicBoolean started = new AtomicBoolean();
    private final Future<?> terminationFuture = new FailedFuture(this, new UnsupportedOperationException());
    final ThreadFactory threadFactory = ThreadExecutorMap.apply(new DefaultThreadFactory(DefaultThreadFactory.toPoolName(getClass()), false, 5, null), this);

    private GlobalEventExecutor() {
        scheduledTaskQueue().add(this.quietPeriodTask);
    }

    Runnable takeTask() {
        Runnable task;
        BlockingQueue<Runnable> taskQueue = this.taskQueue;
        do {
            ScheduledFutureTask<?> scheduledTask = peekScheduledTask();
            if (scheduledTask == null) {
                Runnable task2 = null;
                try {
                    task2 = taskQueue.take();
                } catch (InterruptedException e) {
                }
                return task2;
            }
            long delayNanos = scheduledTask.delayNanos();
            task = null;
            if (delayNanos > 0) {
                try {
                    task = taskQueue.poll(delayNanos, TimeUnit.NANOSECONDS);
                } catch (InterruptedException e2) {
                    return null;
                }
            }
            if (task == null) {
                fetchFromScheduledTaskQueue();
                task = taskQueue.poll();
            }
        } while (task == null);
        return task;
    }

    private void fetchFromScheduledTaskQueue() {
        long nanoTime = getCurrentTimeNanos();
        Runnable scheduledTask = pollScheduledTask(nanoTime);
        while (scheduledTask != null) {
            this.taskQueue.add(scheduledTask);
            scheduledTask = pollScheduledTask(nanoTime);
        }
    }

    public int pendingTasks() {
        return this.taskQueue.size();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: java.util.concurrent.BlockingQueue<java.lang.Runnable> */
    /* JADX WARN: Multi-variable type inference failed */
    private void addTask(Runnable task) {
        this.taskQueue.add(ObjectUtil.checkNotNull(task, "task"));
    }

    @Override // p013io.netty.util.concurrent.EventExecutor
    public boolean inEventLoop(Thread thread) {
        return thread == this.thread;
    }

    @Override // p013io.netty.util.concurrent.EventExecutorGroup
    public Future<?> shutdownGracefully(long quietPeriod, long timeout, TimeUnit unit) {
        return terminationFuture();
    }

    @Override // p013io.netty.util.concurrent.EventExecutorGroup
    public Future<?> terminationFuture() {
        return this.terminationFuture;
    }

    @Override // p013io.netty.util.concurrent.AbstractEventExecutor, java.util.concurrent.ExecutorService, p013io.netty.util.concurrent.EventExecutorGroup
    @Deprecated
    public void shutdown() {
        throw new UnsupportedOperationException();
    }

    @Override // p013io.netty.util.concurrent.EventExecutorGroup
    public boolean isShuttingDown() {
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long timeout, TimeUnit unit) {
        return false;
    }

    public boolean awaitInactivity(long timeout, TimeUnit unit) throws InterruptedException {
        ObjectUtil.checkNotNull(unit, "unit");
        Thread thread = this.thread;
        if (thread == null) {
            throw new IllegalStateException("thread was not started");
        }
        thread.join(unit.toMillis(timeout));
        return !thread.isAlive();
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable task) {
        execute0(task);
    }

    private void execute0(@Async.Schedule Runnable task) {
        addTask((Runnable) ObjectUtil.checkNotNull(task, "task"));
        if (!inEventLoop()) {
            startThread();
        }
    }

    private void startThread() {
        if (this.started.compareAndSet(false, true)) {
            final Thread t = this.threadFactory.newThread(this.taskRunner);
            AccessController.doPrivileged(new PrivilegedAction<Void>() { // from class: io.netty.util.concurrent.GlobalEventExecutor.2
                @Override // java.security.PrivilegedAction
                public Void run() {
                    t.setContextClassLoader(null);
                    return null;
                }
            });
            this.thread = t;
            t.start();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: io.netty.util.concurrent.GlobalEventExecutor$TaskRunner */
    /* loaded from: grasscutter.jar:io/netty/util/concurrent/GlobalEventExecutor$TaskRunner.class */
    public final class TaskRunner implements Runnable {
        static final /* synthetic */ boolean $assertionsDisabled;

        TaskRunner() {
        }

        static {
            $assertionsDisabled = !GlobalEventExecutor.class.desiredAssertionStatus();
        }

        @Override // java.lang.Runnable
        public void run() {
            while (true) {
                Runnable task = GlobalEventExecutor.this.takeTask();
                if (task != null) {
                    try {
                        AbstractEventExecutor.runTask(task);
                    } catch (Throwable t) {
                        GlobalEventExecutor.logger.warn("Unexpected exception from the global event executor: ", t);
                    }
                    if (task != GlobalEventExecutor.this.quietPeriodTask) {
                        continue;
                    }
                }
                Queue<ScheduledFutureTask<?>> scheduledTaskQueue = GlobalEventExecutor.this.scheduledTaskQueue;
                if (GlobalEventExecutor.this.taskQueue.isEmpty() && (scheduledTaskQueue == null || scheduledTaskQueue.size() == 1)) {
                    boolean stopped = GlobalEventExecutor.this.started.compareAndSet(true, false);
                    if (!$assertionsDisabled && !stopped) {
                        throw new AssertionError();
                    } else if (GlobalEventExecutor.this.taskQueue.isEmpty() || !GlobalEventExecutor.this.started.compareAndSet(false, true)) {
                        return;
                    }
                }
            }
        }
    }
}
