package p013io.netty.channel;

import p013io.netty.util.concurrent.Future;
import p013io.netty.util.concurrent.GenericFutureListener;

@Deprecated
/* renamed from: io.netty.channel.ThreadPerChannelEventLoop */
/* loaded from: grasscutter.jar:io/netty/channel/ThreadPerChannelEventLoop.class */
public class ThreadPerChannelEventLoop extends SingleThreadEventLoop {
    private final ThreadPerChannelEventLoopGroup parent;

    /* renamed from: ch */
    private Channel f943ch;

    public ThreadPerChannelEventLoop(ThreadPerChannelEventLoopGroup parent) {
        super((EventLoopGroup) parent, parent.executor, true);
        this.parent = parent;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [io.netty.channel.ChannelFuture] */
    @Override // p013io.netty.channel.SingleThreadEventLoop, p013io.netty.channel.EventLoopGroup
    public ChannelFuture register(ChannelPromise promise) {
        return register(promise).addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.channel.ThreadPerChannelEventLoop.1
            public void operationComplete(ChannelFuture future) throws Exception {
                if (future.isSuccess()) {
                    ThreadPerChannelEventLoop.this.f943ch = future.channel();
                    return;
                }
                ThreadPerChannelEventLoop.this.deregister();
            }
        });
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [io.netty.channel.ChannelFuture] */
    @Override // p013io.netty.channel.SingleThreadEventLoop, p013io.netty.channel.EventLoopGroup
    @Deprecated
    public ChannelFuture register(Channel channel, ChannelPromise promise) {
        return register(channel, promise).addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.channel.ThreadPerChannelEventLoop.2
            public void operationComplete(ChannelFuture future) throws Exception {
                if (future.isSuccess()) {
                    ThreadPerChannelEventLoop.this.f943ch = future.channel();
                    return;
                }
                ThreadPerChannelEventLoop.this.deregister();
            }
        });
    }

    @Override // p013io.netty.util.concurrent.SingleThreadEventExecutor
    protected void run() {
        while (true) {
            Runnable task = takeTask();
            if (task != null) {
                task.run();
                updateLastExecutionTime();
            }
            Channel ch = this.f943ch;
            if (isShuttingDown()) {
                if (ch != null) {
                    ch.unsafe().close(ch.unsafe().voidPromise());
                }
                if (confirmShutdown()) {
                    return;
                }
            } else if (ch != null && !ch.isRegistered()) {
                runAllTasks();
                deregister();
            }
        }
    }

    protected void deregister() {
        this.f943ch = null;
        this.parent.activeChildren.remove(this);
        this.parent.idleChildren.add(this);
    }

    @Override // p013io.netty.channel.SingleThreadEventLoop
    public int registeredChannels() {
        return 1;
    }
}
