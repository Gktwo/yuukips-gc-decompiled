package p013io.netty.util.concurrent;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.Async;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

/* renamed from: io.netty.util.concurrent.AbstractEventExecutor */
/* loaded from: grasscutter.jar:io/netty/util/concurrent/AbstractEventExecutor.class */
public abstract class AbstractEventExecutor extends AbstractExecutorService implements EventExecutor {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(AbstractEventExecutor.class);
    static final long DEFAULT_SHUTDOWN_QUIET_PERIOD = 2;
    static final long DEFAULT_SHUTDOWN_TIMEOUT = 15;
    private final EventExecutorGroup parent;
    private final Collection<EventExecutor> selfCollection;

    /* renamed from: io.netty.util.concurrent.AbstractEventExecutor$LazyRunnable */
    /* loaded from: grasscutter.jar:io/netty/util/concurrent/AbstractEventExecutor$LazyRunnable.class */
    public interface LazyRunnable extends Runnable {
    }

    @Override // java.util.concurrent.ExecutorService, p013io.netty.util.concurrent.EventExecutorGroup
    @Deprecated
    public abstract void shutdown();

    /* access modifiers changed from: protected */
    public AbstractEventExecutor() {
        this(null);
    }

    /* access modifiers changed from: protected */
    public AbstractEventExecutor(EventExecutorGroup parent) {
        this.selfCollection = Collections.singleton(this);
        this.parent = parent;
    }

    @Override // p013io.netty.util.concurrent.EventExecutor, p013io.netty.channel.EventLoop
    public EventExecutorGroup parent() {
        return this.parent;
    }

    @Override // p013io.netty.util.concurrent.EventExecutor, p013io.netty.util.concurrent.EventExecutorGroup, p013io.netty.channel.EventLoopGroup
    public EventExecutor next() {
        return this;
    }

    @Override // p013io.netty.util.concurrent.EventExecutor
    public boolean inEventLoop() {
        return inEventLoop(Thread.currentThread());
    }

    @Override // p013io.netty.util.concurrent.EventExecutorGroup, java.lang.Iterable
    public Iterator<EventExecutor> iterator() {
        return this.selfCollection.iterator();
    }

    @Override // p013io.netty.util.concurrent.EventExecutorGroup
    public Future<?> shutdownGracefully() {
        return shutdownGracefully(DEFAULT_SHUTDOWN_QUIET_PERIOD, DEFAULT_SHUTDOWN_TIMEOUT, TimeUnit.SECONDS);
    }

    @Override // java.util.concurrent.ExecutorService, p013io.netty.util.concurrent.EventExecutorGroup
    @Deprecated
    public List<Runnable> shutdownNow() {
        shutdown();
        return Collections.emptyList();
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

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, p013io.netty.util.concurrent.EventExecutorGroup
    public Future<?> submit(Runnable task) {
        return (Future) submit(task);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, p013io.netty.util.concurrent.EventExecutorGroup
    public <T> Future<T> submit(Runnable task, T result) {
        return (Future) submit(task, (Runnable) result);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, p013io.netty.util.concurrent.EventExecutorGroup
    public <T> Future<T> submit(Callable<T> task) {
        return (Future) submit((Callable) task);
    }

    @Override // java.util.concurrent.AbstractExecutorService
    protected final <T> RunnableFuture<T> newTaskFor(Runnable runnable, T value) {
        return new PromiseTask(this, runnable, value);
    }

    @Override // java.util.concurrent.AbstractExecutorService
    protected final <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new PromiseTask(this, callable);
    }

    @Override // p013io.netty.util.concurrent.EventExecutorGroup, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> schedule(Runnable command, long delay, TimeUnit unit) {
        throw new UnsupportedOperationException();
    }

    @Override // p013io.netty.util.concurrent.EventExecutorGroup, java.util.concurrent.ScheduledExecutorService
    public <V> ScheduledFuture<V> schedule(Callable<V> callable, long delay, TimeUnit unit) {
        throw new UnsupportedOperationException();
    }

    @Override // p013io.netty.util.concurrent.EventExecutorGroup, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit) {
        throw new UnsupportedOperationException();
    }

    @Override // p013io.netty.util.concurrent.EventExecutorGroup, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable command, long initialDelay, long delay, TimeUnit unit) {
        throw new UnsupportedOperationException();
    }

    protected static void safeExecute(Runnable task) {
        try {
            runTask(task);
        } catch (Throwable t) {
            logger.warn("A task raised an exception. Task: {}", task, t);
        }
    }

    /* access modifiers changed from: protected */
    public static void runTask(@Async.Execute Runnable task) {
        task.run();
    }

    public void lazyExecute(Runnable task) {
        lazyExecute0(task);
    }

    private void lazyExecute0(@Async.Schedule Runnable task) {
        execute(task);
    }
}
