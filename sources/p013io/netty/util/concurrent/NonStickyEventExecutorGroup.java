package p013io.netty.util.concurrent;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.PlatformDependent;

/* renamed from: io.netty.util.concurrent.NonStickyEventExecutorGroup */
/* loaded from: grasscutter.jar:io/netty/util/concurrent/NonStickyEventExecutorGroup.class */
public final class NonStickyEventExecutorGroup implements EventExecutorGroup {
    private final EventExecutorGroup group;
    private final int maxTaskExecutePerRun;

    public NonStickyEventExecutorGroup(EventExecutorGroup group) {
        this(group, 1024);
    }

    public NonStickyEventExecutorGroup(EventExecutorGroup group, int maxTaskExecutePerRun) {
        this.group = verify(group);
        this.maxTaskExecutePerRun = ObjectUtil.checkPositive(maxTaskExecutePerRun, "maxTaskExecutePerRun");
    }

    private static EventExecutorGroup verify(EventExecutorGroup group) {
        for (EventExecutor executor : (EventExecutorGroup) ObjectUtil.checkNotNull(group, "group")) {
            if (executor instanceof OrderedEventExecutor) {
                throw new IllegalArgumentException("EventExecutorGroup " + group + " contains OrderedEventExecutors: " + executor);
            }
        }
        return group;
    }

    /* access modifiers changed from: private */
    public NonStickyOrderedEventExecutor newExecutor(EventExecutor executor) {
        return new NonStickyOrderedEventExecutor(executor, this.maxTaskExecutePerRun);
    }

    @Override // p013io.netty.util.concurrent.EventExecutorGroup
    public boolean isShuttingDown() {
        return this.group.isShuttingDown();
    }

    @Override // p013io.netty.util.concurrent.EventExecutorGroup
    public Future<?> shutdownGracefully() {
        return this.group.shutdownGracefully();
    }

    @Override // p013io.netty.util.concurrent.EventExecutorGroup
    public Future<?> shutdownGracefully(long quietPeriod, long timeout, TimeUnit unit) {
        return this.group.shutdownGracefully(quietPeriod, timeout, unit);
    }

    @Override // p013io.netty.util.concurrent.EventExecutorGroup
    public Future<?> terminationFuture() {
        return this.group.terminationFuture();
    }

    @Override // p013io.netty.util.concurrent.EventExecutorGroup, java.util.concurrent.ExecutorService
    public void shutdown() {
        this.group.shutdown();
    }

    @Override // p013io.netty.util.concurrent.EventExecutorGroup
    public List<Runnable> shutdownNow() {
        return this.group.shutdownNow();
    }

    @Override // p013io.netty.util.concurrent.EventExecutorGroup, p013io.netty.channel.EventLoopGroup
    public EventExecutor next() {
        return newExecutor(this.group.next());
    }

    @Override // p013io.netty.util.concurrent.EventExecutorGroup, java.lang.Iterable
    public Iterator<EventExecutor> iterator() {
        final Iterator<EventExecutor> itr = this.group.iterator();
        return new Iterator<EventExecutor>() { // from class: io.netty.util.concurrent.NonStickyEventExecutorGroup.1
            @Override // java.util.Iterator
            public boolean hasNext() {
                return itr.hasNext();
            }

            @Override // java.util.Iterator
            public EventExecutor next() {
                return NonStickyEventExecutorGroup.this.newExecutor((EventExecutor) itr.next());
            }

            @Override // java.util.Iterator
            public void remove() {
                itr.remove();
            }
        };
    }

    @Override // p013io.netty.util.concurrent.EventExecutorGroup, java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable task) {
        return this.group.submit(task);
    }

    @Override // p013io.netty.util.concurrent.EventExecutorGroup, java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Runnable task, T result) {
        return this.group.submit(task, (Runnable) result);
    }

    @Override // p013io.netty.util.concurrent.EventExecutorGroup, java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Callable<T> task) {
        return this.group.submit((Callable) task);
    }

    @Override // p013io.netty.util.concurrent.EventExecutorGroup, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> schedule(Runnable command, long delay, TimeUnit unit) {
        return this.group.schedule(command, delay, unit);
    }

    @Override // p013io.netty.util.concurrent.EventExecutorGroup, java.util.concurrent.ScheduledExecutorService
    public <V> ScheduledFuture<V> schedule(Callable<V> callable, long delay, TimeUnit unit) {
        return this.group.schedule((Callable) callable, delay, unit);
    }

    @Override // p013io.netty.util.concurrent.EventExecutorGroup, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit) {
        return this.group.scheduleAtFixedRate(command, initialDelay, period, unit);
    }

    @Override // p013io.netty.util.concurrent.EventExecutorGroup, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable command, long initialDelay, long delay, TimeUnit unit) {
        return this.group.scheduleWithFixedDelay(command, initialDelay, delay, unit);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.group.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.group.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        return this.group.awaitTermination(timeout, unit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
        return this.group.invokeAll(tasks);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException {
        return this.group.invokeAll(tasks, timeout, unit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
        return (T) this.group.invokeAny(tasks);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return (T) this.group.invokeAny(tasks, timeout, unit);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable command) {
        this.group.execute(command);
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.util.concurrent.NonStickyEventExecutorGroup$NonStickyOrderedEventExecutor */
    /* loaded from: grasscutter.jar:io/netty/util/concurrent/NonStickyEventExecutorGroup$NonStickyOrderedEventExecutor.class */
    public static final class NonStickyOrderedEventExecutor extends AbstractEventExecutor implements Runnable, OrderedEventExecutor {
        private final EventExecutor executor;
        private static final int NONE = 0;
        private static final int SUBMITTED = 1;
        private static final int RUNNING = 2;
        private final int maxTaskExecutePerRun;
        private final Queue<Runnable> tasks = PlatformDependent.newMpscQueue();
        private final AtomicInteger state = new AtomicInteger();

        NonStickyOrderedEventExecutor(EventExecutor executor, int maxTaskExecutePerRun) {
            super(executor);
            this.executor = executor;
            this.maxTaskExecutePerRun = maxTaskExecutePerRun;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable task;
            if (this.state.compareAndSet(1, 2)) {
                while (true) {
                    int i = 0;
                    while (i < this.maxTaskExecutePerRun && (task = this.tasks.poll()) != null) {
                        try {
                            safeExecute(task);
                            i++;
                        } catch (Throwable th) {
                            if (i == this.maxTaskExecutePerRun) {
                                try {
                                    this.state.set(1);
                                    this.executor.execute(this);
                                    return;
                                } catch (Throwable th2) {
                                    this.state.set(2);
                                    throw th;
                                }
                            } else {
                                this.state.set(0);
                                if (this.tasks.isEmpty() || !this.state.compareAndSet(0, 2)) {
                                    return;
                                }
                            }
                            throw th;
                        }
                    }
                    if (i == this.maxTaskExecutePerRun) {
                        try {
                            this.state.set(1);
                            this.executor.execute(this);
                            return;
                        } catch (Throwable th3) {
                            this.state.set(2);
                        }
                    } else {
                        this.state.set(0);
                        if (this.tasks.isEmpty() || !this.state.compareAndSet(0, 2)) {
                            return;
                        }
                    }
                }
            }
        }

        @Override // p013io.netty.util.concurrent.EventExecutor
        public boolean inEventLoop(Thread thread) {
            return false;
        }

        @Override // p013io.netty.util.concurrent.AbstractEventExecutor, p013io.netty.util.concurrent.EventExecutor
        public boolean inEventLoop() {
            return false;
        }

        @Override // p013io.netty.util.concurrent.EventExecutorGroup
        public boolean isShuttingDown() {
            return this.executor.isShutdown();
        }

        @Override // p013io.netty.util.concurrent.EventExecutorGroup
        public Future<?> shutdownGracefully(long quietPeriod, long timeout, TimeUnit unit) {
            return this.executor.shutdownGracefully(quietPeriod, timeout, unit);
        }

        @Override // p013io.netty.util.concurrent.EventExecutorGroup
        public Future<?> terminationFuture() {
            return this.executor.terminationFuture();
        }

        @Override // p013io.netty.util.concurrent.AbstractEventExecutor, java.util.concurrent.ExecutorService, p013io.netty.util.concurrent.EventExecutorGroup
        public void shutdown() {
            this.executor.shutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isShutdown() {
            return this.executor.isShutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isTerminated() {
            return this.executor.isTerminated();
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
            return this.executor.awaitTermination(timeout, unit);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable command) {
            if (!this.tasks.offer(command)) {
                throw new RejectedExecutionException();
            } else if (this.state.compareAndSet(0, 1)) {
                this.executor.execute(this);
            }
        }
    }
}
