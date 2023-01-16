package p013io.netty.handler.timeout;

import java.util.concurrent.TimeUnit;
import p013io.netty.channel.ChannelFuture;
import p013io.netty.channel.ChannelFutureListener;
import p013io.netty.channel.ChannelHandlerContext;
import p013io.netty.channel.ChannelOutboundHandlerAdapter;
import p013io.netty.channel.ChannelPromise;
import p013io.netty.util.concurrent.Future;
import p013io.netty.util.concurrent.GenericFutureListener;
import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.handler.timeout.WriteTimeoutHandler */
/* loaded from: grasscutter.jar:io/netty/handler/timeout/WriteTimeoutHandler.class */
public class WriteTimeoutHandler extends ChannelOutboundHandlerAdapter {
    private static final long MIN_TIMEOUT_NANOS;
    private final long timeoutNanos;
    private WriteTimeoutTask lastTask;
    private boolean closed;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !WriteTimeoutHandler.class.desiredAssertionStatus();
        MIN_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(1);
    }

    public WriteTimeoutHandler(int timeoutSeconds) {
        this((long) timeoutSeconds, TimeUnit.SECONDS);
    }

    public WriteTimeoutHandler(long timeout, TimeUnit unit) {
        ObjectUtil.checkNotNull(unit, "unit");
        if (timeout <= 0) {
            this.timeoutNanos = 0;
        } else {
            this.timeoutNanos = Math.max(unit.toNanos(timeout), MIN_TIMEOUT_NANOS);
        }
    }

    @Override // p013io.netty.channel.ChannelOutboundHandlerAdapter, p013io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        if (this.timeoutNanos > 0) {
            promise = promise.unvoid();
            scheduleTimeout(ctx, promise);
        }
        ctx.write(msg, promise);
    }

    @Override // p013io.netty.channel.ChannelHandlerAdapter, p013io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        if ($assertionsDisabled || ctx.executor().inEventLoop()) {
            WriteTimeoutTask task = this.lastTask;
            this.lastTask = null;
            while (task != null) {
                if ($assertionsDisabled || task.ctx.executor().inEventLoop()) {
                    task.scheduledFuture.cancel(false);
                    WriteTimeoutTask prev = task.prev;
                    task.prev = null;
                    task.next = null;
                    task = prev;
                } else {
                    throw new AssertionError();
                }
            }
            return;
        }
        throw new AssertionError();
    }

    private void scheduleTimeout(ChannelHandlerContext ctx, ChannelPromise promise) {
        WriteTimeoutTask task = new WriteTimeoutTask(ctx, promise);
        task.scheduledFuture = ctx.executor().schedule((Runnable) task, this.timeoutNanos, TimeUnit.NANOSECONDS);
        if (!task.scheduledFuture.isDone()) {
            addWriteTimeoutTask(task);
            promise.addListener((GenericFutureListener<? extends Future<? super Void>>) task);
        }
    }

    private void addWriteTimeoutTask(WriteTimeoutTask task) {
        if ($assertionsDisabled || task.ctx.executor().inEventLoop()) {
            if (this.lastTask != null) {
                this.lastTask.next = task;
                task.prev = this.lastTask;
            }
            this.lastTask = task;
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: private */
    public void removeWriteTimeoutTask(WriteTimeoutTask task) {
        if ($assertionsDisabled || task.ctx.executor().inEventLoop()) {
            if (task == this.lastTask) {
                if ($assertionsDisabled || task.next == null) {
                    this.lastTask = this.lastTask.prev;
                    if (this.lastTask != null) {
                        this.lastTask.next = null;
                    }
                } else {
                    throw new AssertionError();
                }
            } else if (task.prev != null || task.next != null) {
                if (task.prev == null) {
                    task.next.prev = null;
                } else {
                    task.prev.next = task.next;
                    task.next.prev = task.prev;
                }
            } else {
                return;
            }
            task.prev = null;
            task.next = null;
            return;
        }
        throw new AssertionError();
    }

    protected void writeTimedOut(ChannelHandlerContext ctx) throws Exception {
        if (!this.closed) {
            ctx.fireExceptionCaught((Throwable) WriteTimeoutException.INSTANCE);
            ctx.close();
            this.closed = true;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.handler.timeout.WriteTimeoutHandler$WriteTimeoutTask */
    /* loaded from: grasscutter.jar:io/netty/handler/timeout/WriteTimeoutHandler$WriteTimeoutTask.class */
    public final class WriteTimeoutTask implements Runnable, ChannelFutureListener {
        private final ChannelHandlerContext ctx;
        private final ChannelPromise promise;
        WriteTimeoutTask prev;
        WriteTimeoutTask next;
        Future<?> scheduledFuture;
        static final /* synthetic */ boolean $assertionsDisabled;

        static {
            $assertionsDisabled = !WriteTimeoutHandler.class.desiredAssertionStatus();
        }

        WriteTimeoutTask(ChannelHandlerContext ctx, ChannelPromise promise) {
            this.ctx = ctx;
            this.promise = promise;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.promise.isDone()) {
                try {
                    WriteTimeoutHandler.this.writeTimedOut(this.ctx);
                } catch (Throwable t) {
                    this.ctx.fireExceptionCaught(t);
                }
            }
            WriteTimeoutHandler.this.removeWriteTimeoutTask(this);
        }

        public void operationComplete(ChannelFuture future) throws Exception {
            this.scheduledFuture.cancel(false);
            if (this.ctx.executor().inEventLoop()) {
                WriteTimeoutHandler.this.removeWriteTimeoutTask(this);
            } else if ($assertionsDisabled || this.promise.isDone()) {
                this.ctx.executor().execute(this);
            } else {
                throw new AssertionError();
            }
        }
    }
}
