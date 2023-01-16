package p013io.netty.channel;

import p013io.netty.channel.ChannelFlushPromiseNotifier;
import p013io.netty.util.concurrent.DefaultProgressivePromise;
import p013io.netty.util.concurrent.EventExecutor;
import p013io.netty.util.concurrent.Future;
import p013io.netty.util.concurrent.GenericFutureListener;
import p013io.netty.util.concurrent.ProgressivePromise;

/* renamed from: io.netty.channel.DefaultChannelProgressivePromise */
/* loaded from: grasscutter.jar:io/netty/channel/DefaultChannelProgressivePromise.class */
public class DefaultChannelProgressivePromise extends DefaultProgressivePromise<Void> implements ChannelProgressivePromise, ChannelFlushPromiseNotifier.FlushCheckpoint {
    private final Channel channel;
    private long checkpoint;

    public DefaultChannelProgressivePromise(Channel channel) {
        this.channel = channel;
    }

    public DefaultChannelProgressivePromise(Channel channel, EventExecutor executor) {
        super(executor);
        this.channel = channel;
    }

    @Override // p013io.netty.util.concurrent.DefaultPromise
    protected EventExecutor executor() {
        EventExecutor e = executor();
        if (e == null) {
            return channel().eventLoop();
        }
        return e;
    }

    @Override // p013io.netty.channel.ChannelFuture
    public Channel channel() {
        return this.channel;
    }

    @Override // p013io.netty.channel.ChannelProgressivePromise, p013io.netty.channel.ChannelPromise
    public ChannelProgressivePromise setSuccess() {
        return setSuccess((Void) null);
    }

    @Override // p013io.netty.channel.ChannelProgressivePromise, p013io.netty.channel.ChannelPromise
    public ChannelProgressivePromise setSuccess(Void result) {
        setSuccess((DefaultChannelProgressivePromise) result);
        return this;
    }

    @Override // p013io.netty.channel.ChannelPromise
    public boolean trySuccess() {
        return trySuccess(null);
    }

    @Override // p013io.netty.util.concurrent.DefaultProgressivePromise, p013io.netty.util.concurrent.DefaultPromise, p013io.netty.util.concurrent.Promise, p013io.netty.channel.ChannelPromise
    public ChannelProgressivePromise setFailure(Throwable cause) {
        setFailure(cause);
        return this;
    }

    /* Return type fixed from 'io.netty.channel.ChannelProgressivePromise' to match base method */
    @Override // p013io.netty.util.concurrent.DefaultProgressivePromise, p013io.netty.util.concurrent.ProgressivePromise
    public ProgressivePromise<Void> setProgress(long progress, long total) {
        setProgress(progress, total);
        return this;
    }

    @Override // p013io.netty.util.concurrent.DefaultProgressivePromise, p013io.netty.util.concurrent.DefaultPromise, p013io.netty.util.concurrent.Future
    public ChannelProgressivePromise addListener(GenericFutureListener<? extends Future<? super Void>> listener) {
        addListener((GenericFutureListener) listener);
        return this;
    }

    @Override // p013io.netty.util.concurrent.DefaultProgressivePromise, p013io.netty.util.concurrent.DefaultPromise, p013io.netty.util.concurrent.Future
    public ChannelProgressivePromise addListeners(GenericFutureListener<? extends Future<? super Void>>... listeners) {
        addListeners((GenericFutureListener[]) listeners);
        return this;
    }

    @Override // p013io.netty.util.concurrent.DefaultProgressivePromise, p013io.netty.util.concurrent.DefaultPromise, p013io.netty.util.concurrent.Future
    public ChannelProgressivePromise removeListener(GenericFutureListener<? extends Future<? super Void>> listener) {
        removeListener((GenericFutureListener) listener);
        return this;
    }

    @Override // p013io.netty.util.concurrent.DefaultProgressivePromise, p013io.netty.util.concurrent.DefaultPromise, p013io.netty.util.concurrent.Future
    public ChannelProgressivePromise removeListeners(GenericFutureListener<? extends Future<? super Void>>... listeners) {
        removeListeners((GenericFutureListener[]) listeners);
        return this;
    }

    @Override // p013io.netty.util.concurrent.DefaultProgressivePromise, p013io.netty.util.concurrent.DefaultPromise, p013io.netty.util.concurrent.Future
    public ChannelProgressivePromise sync() throws InterruptedException {
        sync();
        return this;
    }

    @Override // p013io.netty.util.concurrent.DefaultProgressivePromise, p013io.netty.util.concurrent.DefaultPromise, p013io.netty.util.concurrent.Future
    public ChannelProgressivePromise syncUninterruptibly() {
        syncUninterruptibly();
        return this;
    }

    @Override // p013io.netty.util.concurrent.DefaultProgressivePromise, p013io.netty.util.concurrent.DefaultPromise, p013io.netty.util.concurrent.Future
    public ChannelProgressivePromise await() throws InterruptedException {
        await();
        return this;
    }

    @Override // p013io.netty.util.concurrent.DefaultProgressivePromise, p013io.netty.util.concurrent.DefaultPromise, p013io.netty.util.concurrent.Future
    public ChannelProgressivePromise awaitUninterruptibly() {
        awaitUninterruptibly();
        return this;
    }

    @Override // p013io.netty.channel.ChannelFlushPromiseNotifier.FlushCheckpoint
    public long flushCheckpoint() {
        return this.checkpoint;
    }

    @Override // p013io.netty.channel.ChannelFlushPromiseNotifier.FlushCheckpoint
    public void flushCheckpoint(long checkpoint) {
        this.checkpoint = checkpoint;
    }

    @Override // p013io.netty.channel.ChannelFlushPromiseNotifier.FlushCheckpoint
    public ChannelProgressivePromise promise() {
        return this;
    }

    @Override // p013io.netty.util.concurrent.DefaultPromise
    protected void checkDeadLock() {
        if (channel().isRegistered()) {
            checkDeadLock();
        }
    }

    @Override // p013io.netty.channel.ChannelProgressivePromise, p013io.netty.channel.ChannelPromise
    public ChannelProgressivePromise unvoid() {
        return this;
    }

    @Override // p013io.netty.channel.ChannelFuture
    public boolean isVoid() {
        return false;
    }
}
