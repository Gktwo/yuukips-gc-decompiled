package p013io.netty.channel;

import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;
import p013io.netty.util.concurrent.AbstractEventExecutor;
import p013io.netty.util.concurrent.RejectedExecutionHandler;
import p013io.netty.util.concurrent.RejectedExecutionHandlers;
import p013io.netty.util.concurrent.SingleThreadEventExecutor;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.SystemPropertyUtil;

/* renamed from: io.netty.channel.SingleThreadEventLoop */
/* loaded from: grasscutter.jar:io/netty/channel/SingleThreadEventLoop.class */
public abstract class SingleThreadEventLoop extends SingleThreadEventExecutor implements EventLoop {
    protected static final int DEFAULT_MAX_PENDING_TASKS = Math.max(16, SystemPropertyUtil.getInt("io.netty.eventLoop.maxPendingTasks", Integer.MAX_VALUE));
    private final Queue<Runnable> tailTasks;

    /* access modifiers changed from: protected */
    public SingleThreadEventLoop(EventLoopGroup parent, ThreadFactory threadFactory, boolean addTaskWakesUp) {
        this(parent, threadFactory, addTaskWakesUp, DEFAULT_MAX_PENDING_TASKS, RejectedExecutionHandlers.reject());
    }

    /* access modifiers changed from: protected */
    public SingleThreadEventLoop(EventLoopGroup parent, Executor executor, boolean addTaskWakesUp) {
        this(parent, executor, addTaskWakesUp, DEFAULT_MAX_PENDING_TASKS, RejectedExecutionHandlers.reject());
    }

    protected SingleThreadEventLoop(EventLoopGroup parent, ThreadFactory threadFactory, boolean addTaskWakesUp, int maxPendingTasks, RejectedExecutionHandler rejectedExecutionHandler) {
        super(parent, threadFactory, addTaskWakesUp, maxPendingTasks, rejectedExecutionHandler);
        this.tailTasks = newTaskQueue(maxPendingTasks);
    }

    protected SingleThreadEventLoop(EventLoopGroup parent, Executor executor, boolean addTaskWakesUp, int maxPendingTasks, RejectedExecutionHandler rejectedExecutionHandler) {
        super(parent, executor, addTaskWakesUp, maxPendingTasks, rejectedExecutionHandler);
        this.tailTasks = newTaskQueue(maxPendingTasks);
    }

    /* access modifiers changed from: protected */
    public SingleThreadEventLoop(EventLoopGroup parent, Executor executor, boolean addTaskWakesUp, Queue<Runnable> taskQueue, Queue<Runnable> tailTaskQueue, RejectedExecutionHandler rejectedExecutionHandler) {
        super(parent, executor, addTaskWakesUp, taskQueue, rejectedExecutionHandler);
        this.tailTasks = (Queue) ObjectUtil.checkNotNull(tailTaskQueue, "tailTaskQueue");
    }

    @Override // p013io.netty.util.concurrent.AbstractEventExecutor, p013io.netty.util.concurrent.EventExecutor, p013io.netty.channel.EventLoop
    public EventLoopGroup parent() {
        return (EventLoopGroup) parent();
    }

    @Override // p013io.netty.util.concurrent.AbstractEventExecutor, p013io.netty.util.concurrent.EventExecutor, p013io.netty.util.concurrent.EventExecutorGroup, p013io.netty.channel.EventLoopGroup
    public EventLoop next() {
        return (EventLoop) next();
    }

    @Override // p013io.netty.channel.EventLoopGroup
    public ChannelFuture register(Channel channel) {
        return register(new DefaultChannelPromise(channel, this));
    }

    @Override // p013io.netty.channel.EventLoopGroup
    public ChannelFuture register(ChannelPromise promise) {
        ObjectUtil.checkNotNull(promise, "promise");
        promise.channel().unsafe().register(this, promise);
        return promise;
    }

    @Override // p013io.netty.channel.EventLoopGroup
    @Deprecated
    public ChannelFuture register(Channel channel, ChannelPromise promise) {
        ObjectUtil.checkNotNull(promise, "promise");
        ObjectUtil.checkNotNull(channel, "channel");
        channel.unsafe().register(this, promise);
        return promise;
    }

    public final void executeAfterEventLoopIteration(Runnable task) {
        ObjectUtil.checkNotNull(task, "task");
        if (isShutdown()) {
            reject();
        }
        if (!this.tailTasks.offer(task)) {
            reject(task);
        }
        if (!(task instanceof AbstractEventExecutor.LazyRunnable) && wakesUpForTask(task)) {
            wakeup(inEventLoop());
        }
    }

    final boolean removeAfterEventLoopIterationTask(Runnable task) {
        return this.tailTasks.remove(ObjectUtil.checkNotNull(task, "task"));
    }

    @Override // p013io.netty.util.concurrent.SingleThreadEventExecutor
    protected void afterRunningAllTasks() {
        runAllTasksFrom(this.tailTasks);
    }

    @Override // p013io.netty.util.concurrent.SingleThreadEventExecutor
    protected boolean hasTasks() {
        return hasTasks() || !this.tailTasks.isEmpty();
    }

    @Override // p013io.netty.util.concurrent.SingleThreadEventExecutor
    public int pendingTasks() {
        return pendingTasks() + this.tailTasks.size();
    }

    public int registeredChannels() {
        return -1;
    }
}
