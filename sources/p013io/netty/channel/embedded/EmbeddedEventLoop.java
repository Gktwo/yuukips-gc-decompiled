package p013io.netty.channel.embedded;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import org.quartz.jobs.NativeJob;
import p013io.netty.channel.Channel;
import p013io.netty.channel.ChannelFuture;
import p013io.netty.channel.ChannelPromise;
import p013io.netty.channel.DefaultChannelPromise;
import p013io.netty.channel.EventLoop;
import p013io.netty.channel.EventLoopGroup;
import p013io.netty.util.concurrent.AbstractScheduledEventExecutor;
import p013io.netty.util.concurrent.Future;
import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.channel.embedded.EmbeddedEventLoop */
/* loaded from: grasscutter.jar:io/netty/channel/embedded/EmbeddedEventLoop.class */
final class EmbeddedEventLoop extends AbstractScheduledEventExecutor implements EventLoop {
    private long frozenTimestamp;
    private boolean timeFrozen;
    private long startTime = initialNanoTime();
    private final Queue<Runnable> tasks = new ArrayDeque(2);

    @Override // p013io.netty.util.concurrent.AbstractEventExecutor, p013io.netty.util.concurrent.EventExecutor, p013io.netty.channel.EventLoop
    public EventLoopGroup parent() {
        return (EventLoopGroup) parent();
    }

    @Override // p013io.netty.util.concurrent.AbstractEventExecutor, p013io.netty.util.concurrent.EventExecutor, p013io.netty.util.concurrent.EventExecutorGroup, p013io.netty.channel.EventLoopGroup
    public EventLoop next() {
        return (EventLoop) next();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: java.util.Queue<java.lang.Runnable> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.Executor
    public void execute(Runnable command) {
        this.tasks.add(ObjectUtil.checkNotNull(command, NativeJob.PROP_COMMAND));
    }

    /* access modifiers changed from: package-private */
    public void runTasks() {
        while (true) {
            Runnable task = this.tasks.poll();
            if (task != null) {
                task.run();
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean hasPendingNormalTasks() {
        return !this.tasks.isEmpty();
    }

    /* access modifiers changed from: package-private */
    public long runScheduledTasks() {
        long time = getCurrentTimeNanos();
        while (true) {
            Runnable task = pollScheduledTask(time);
            if (task == null) {
                return nextScheduledTaskNano();
            }
            task.run();
        }
    }

    /* access modifiers changed from: package-private */
    public long nextScheduledTask() {
        return nextScheduledTaskNano();
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.util.concurrent.AbstractScheduledEventExecutor
    public long getCurrentTimeNanos() {
        if (this.timeFrozen) {
            return this.frozenTimestamp;
        }
        return System.nanoTime() - this.startTime;
    }

    /* access modifiers changed from: package-private */
    public void advanceTimeBy(long nanos) {
        if (this.timeFrozen) {
            this.frozenTimestamp += nanos;
        } else {
            this.startTime -= nanos;
        }
    }

    /* access modifiers changed from: package-private */
    public void freezeTime() {
        if (!this.timeFrozen) {
            this.frozenTimestamp = getCurrentTimeNanos();
            this.timeFrozen = true;
        }
    }

    /* access modifiers changed from: package-private */
    public void unfreezeTime() {
        if (this.timeFrozen) {
            this.startTime = System.nanoTime() - this.frozenTimestamp;
            this.timeFrozen = false;
        }
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.util.concurrent.AbstractScheduledEventExecutor
    public void cancelScheduledTasks() {
        cancelScheduledTasks();
    }

    @Override // p013io.netty.util.concurrent.EventExecutorGroup
    public Future<?> shutdownGracefully(long quietPeriod, long timeout, TimeUnit unit) {
        throw new UnsupportedOperationException();
    }

    @Override // p013io.netty.util.concurrent.EventExecutorGroup
    public Future<?> terminationFuture() {
        throw new UnsupportedOperationException();
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
        channel.unsafe().register(this, promise);
        return promise;
    }

    @Override // p013io.netty.util.concurrent.AbstractEventExecutor, p013io.netty.util.concurrent.EventExecutor
    public boolean inEventLoop() {
        return true;
    }

    @Override // p013io.netty.util.concurrent.EventExecutor
    public boolean inEventLoop(Thread thread) {
        return true;
    }
}
