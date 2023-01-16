package p013io.netty.util.concurrent;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

/* renamed from: io.netty.util.concurrent.UnorderedThreadPoolEventExecutor */
/* loaded from: grasscutter.jar:io/netty/util/concurrent/UnorderedThreadPoolEventExecutor.class */
public final class UnorderedThreadPoolEventExecutor extends ScheduledThreadPoolExecutor implements EventExecutor {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(UnorderedThreadPoolEventExecutor.class);
    private final Promise<?> terminationFuture;
    private final Set<EventExecutor> executorSet;

    public UnorderedThreadPoolEventExecutor(int corePoolSize) {
        this(corePoolSize, new DefaultThreadFactory(UnorderedThreadPoolEventExecutor.class));
    }

    public UnorderedThreadPoolEventExecutor(int corePoolSize, ThreadFactory threadFactory) {
        super(corePoolSize, threadFactory);
        this.terminationFuture = GlobalEventExecutor.INSTANCE.newPromise();
        this.executorSet = Collections.singleton(this);
    }

    public UnorderedThreadPoolEventExecutor(int corePoolSize, RejectedExecutionHandler handler) {
        this(corePoolSize, new DefaultThreadFactory(UnorderedThreadPoolEventExecutor.class), handler);
    }

    public UnorderedThreadPoolEventExecutor(int corePoolSize, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
        super(corePoolSize, threadFactory, handler);
        this.terminationFuture = GlobalEventExecutor.INSTANCE.newPromise();
        this.executorSet = Collections.singleton(this);
    }

    @Override // p013io.netty.util.concurrent.EventExecutor, p013io.netty.util.concurrent.EventExecutorGroup, p013io.netty.channel.EventLoopGroup
    public EventExecutor next() {
        return this;
    }

    @Override // p013io.netty.util.concurrent.EventExecutor, p013io.netty.channel.EventLoop
    public EventExecutorGroup parent() {
        return this;
    }

    @Override // p013io.netty.util.concurrent.EventExecutor
    public boolean inEventLoop() {
        return false;
    }

    @Override // p013io.netty.util.concurrent.EventExecutor
    public boolean inEventLoop(Thread thread) {
        return false;
    }

    @Override // p013io.netty.util.concurrent.EventExecutor
    public <V> Promise<V> newPromise() {
        return new DefaultPromise(this);
    }

    @Override // p013io.netty.util.concurrent.EventExecutor
    public <V> ProgressivePromise<V> newProgressivePromise() {
        return new DefaultProgressivePromise(this);
    }

    @Override // p013io.netty.util.concurrent.EventExecutor
    public <V> Future<V> newSucceededFuture(V result) {
        return new SucceededFuture(this, result);
    }

    @Override // p013io.netty.util.concurrent.EventExecutor
    public <V> Future<V> newFailedFuture(Throwable cause) {
        return new FailedFuture(this, cause);
    }

    @Override // p013io.netty.util.concurrent.EventExecutorGroup
    public boolean isShuttingDown() {
        return isShutdown();
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService, p013io.netty.util.concurrent.EventExecutorGroup
    public List<Runnable> shutdownNow() {
        List<Runnable> tasks = shutdownNow();
        this.terminationFuture.trySuccess(null);
        return tasks;
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService, p013io.netty.util.concurrent.EventExecutorGroup
    public void shutdown() {
        shutdown();
        this.terminationFuture.trySuccess(null);
    }

    @Override // p013io.netty.util.concurrent.EventExecutorGroup
    public Future<?> shutdownGracefully() {
        return shutdownGracefully(2, 15, TimeUnit.SECONDS);
    }

    @Override // p013io.netty.util.concurrent.EventExecutorGroup
    public Future<?> shutdownGracefully(long quietPeriod, long timeout, TimeUnit unit) {
        shutdown();
        return terminationFuture();
    }

    @Override // p013io.netty.util.concurrent.EventExecutorGroup
    public Future<?> terminationFuture() {
        return this.terminationFuture;
    }

    @Override // p013io.netty.util.concurrent.EventExecutorGroup, java.lang.Iterable
    public Iterator<EventExecutor> iterator() {
        return this.executorSet.iterator();
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor
    protected <V> RunnableScheduledFuture<V> decorateTask(Runnable runnable, RunnableScheduledFuture<V> task) {
        return runnable instanceof NonNotifyRunnable ? task : new RunnableScheduledFutureTask(this, task, false);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor
    protected <V> RunnableScheduledFuture<V> decorateTask(Callable<V> callable, RunnableScheduledFuture<V> task) {
        return new RunnableScheduledFutureTask(this, task, true);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ScheduledExecutorService, p013io.netty.util.concurrent.EventExecutorGroup
    public ScheduledFuture<?> schedule(Runnable command, long delay, TimeUnit unit) {
        return (ScheduledFuture) schedule(command, delay, unit);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ScheduledExecutorService, p013io.netty.util.concurrent.EventExecutorGroup
    public <V> ScheduledFuture<V> schedule(Callable<V> callable, long delay, TimeUnit unit) {
        return (ScheduledFuture) schedule((Callable) callable, delay, unit);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ScheduledExecutorService, p013io.netty.util.concurrent.EventExecutorGroup
    public ScheduledFuture<?> scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit) {
        return (ScheduledFuture) scheduleAtFixedRate(command, initialDelay, period, unit);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ScheduledExecutorService, p013io.netty.util.concurrent.EventExecutorGroup
    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable command, long initialDelay, long delay, TimeUnit unit) {
        return (ScheduledFuture) scheduleWithFixedDelay(command, initialDelay, delay, unit);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, p013io.netty.util.concurrent.EventExecutorGroup
    public Future<?> submit(Runnable task) {
        return (Future) submit(task);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, p013io.netty.util.concurrent.EventExecutorGroup
    public <T> Future<T> submit(Runnable task, T result) {
        return (Future) submit(task, (Runnable) result);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, p013io.netty.util.concurrent.EventExecutorGroup
    public <T> Future<T> submit(Callable<T> task) {
        return (Future) submit((Callable) task);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable command) {
        schedule((Runnable) new NonNotifyRunnable(command), 0L, TimeUnit.NANOSECONDS);
    }

    /* renamed from: io.netty.util.concurrent.UnorderedThreadPoolEventExecutor$RunnableScheduledFutureTask */
    /* loaded from: grasscutter.jar:io/netty/util/concurrent/UnorderedThreadPoolEventExecutor$RunnableScheduledFutureTask.class */
    private static final class RunnableScheduledFutureTask<V> extends PromiseTask<V> implements RunnableScheduledFuture<V>, ScheduledFuture<V> {
        private final RunnableScheduledFuture<V> future;
        private final boolean wasCallable;
        static final /* synthetic */ boolean $assertionsDisabled;

        static {
            $assertionsDisabled = !UnorderedThreadPoolEventExecutor.class.desiredAssertionStatus();
        }

        RunnableScheduledFutureTask(EventExecutor executor, RunnableScheduledFuture<V> future, boolean wasCallable) {
            super(executor, future);
            this.future = future;
            this.wasCallable = wasCallable;
        }

        /* access modifiers changed from: package-private */
        @Override // p013io.netty.util.concurrent.PromiseTask
        public V runTask() throws Throwable {
            V result = runTask();
            if (result != null || !this.wasCallable) {
                return result;
            }
            if ($assertionsDisabled || this.future.isDone()) {
                try {
                    return (V) this.future.get();
                } catch (ExecutionException e) {
                    throw e.getCause();
                }
            } else {
                throw new AssertionError();
            }
        }

        @Override // p013io.netty.util.concurrent.PromiseTask, java.util.concurrent.RunnableFuture, java.lang.Runnable
        public void run() {
            if (!isPeriodic()) {
                run();
            } else if (!isDone()) {
                try {
                    runTask();
                } catch (Throwable cause) {
                    if (!tryFailureInternal(cause)) {
                        UnorderedThreadPoolEventExecutor.logger.warn("Failure during execution of task", cause);
                    }
                }
            }
        }

        @Override // java.util.concurrent.RunnableScheduledFuture
        public boolean isPeriodic() {
            return this.future.isPeriodic();
        }

        @Override // java.util.concurrent.Delayed
        public long getDelay(TimeUnit unit) {
            return this.future.getDelay(unit);
        }

        public int compareTo(Delayed o) {
            return this.future.compareTo(o);
        }
    }

    /* renamed from: io.netty.util.concurrent.UnorderedThreadPoolEventExecutor$NonNotifyRunnable */
    /* loaded from: grasscutter.jar:io/netty/util/concurrent/UnorderedThreadPoolEventExecutor$NonNotifyRunnable.class */
    private static final class NonNotifyRunnable implements Runnable {
        private final Runnable task;

        NonNotifyRunnable(Runnable task) {
            this.task = task;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.task.run();
        }
    }
}
