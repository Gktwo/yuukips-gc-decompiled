package p013io.netty.channel;

import p013io.netty.channel.ChannelFlushPromiseNotifier;
import p013io.netty.util.concurrent.DefaultPromise;
import p013io.netty.util.concurrent.EventExecutor;
import p013io.netty.util.concurrent.Future;
import p013io.netty.util.concurrent.GenericFutureListener;
import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.channel.DefaultChannelPromise */
/* loaded from: grasscutter.jar:io/netty/channel/DefaultChannelPromise.class */
public class DefaultChannelPromise extends DefaultPromise<Void> implements ChannelPromise, ChannelFlushPromiseNotifier.FlushCheckpoint {
    private final Channel channel;
    private long checkpoint;

    public DefaultChannelPromise(Channel channel) {
        this.channel = (Channel) ObjectUtil.checkNotNull(channel, "channel");
    }

    public DefaultChannelPromise(Channel channel, EventExecutor executor) {
        super(executor);
        this.channel = (Channel) ObjectUtil.checkNotNull(channel, "channel");
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.util.concurrent.DefaultPromise
    public EventExecutor executor() {
        EventExecutor e = executor();
        if (e == null) {
            return channel().eventLoop();
        }
        return e;
    }

    @Override // p013io.netty.channel.ChannelPromise, p013io.netty.channel.ChannelFuture
    public Channel channel() {
        return this.channel;
    }

    @Override // p013io.netty.channel.ChannelPromise
    public ChannelPromise setSuccess() {
        return setSuccess((Void) null);
    }

    @Override // p013io.netty.channel.ChannelPromise
    public ChannelPromise setSuccess(Void result) {
        setSuccess((DefaultChannelPromise) result);
        return this;
    }

    @Override // p013io.netty.channel.ChannelPromise
    public boolean trySuccess() {
        return trySuccess(null);
    }

    @Override // p013io.netty.util.concurrent.DefaultPromise, p013io.netty.util.concurrent.Promise, p013io.netty.channel.ChannelPromise
    public ChannelPromise setFailure(Throwable cause) {
        setFailure(cause);
        return this;
    }

    @Override // p013io.netty.util.concurrent.DefaultPromise, p013io.netty.util.concurrent.Future
    public ChannelPromise addListener(GenericFutureListener<? extends Future<? super Void>> listener) {
        addListener((GenericFutureListener) listener);
        return this;
    }

    @Override // p013io.netty.util.concurrent.DefaultPromise, p013io.netty.util.concurrent.Future
    public ChannelPromise addListeners(GenericFutureListener<? extends Future<? super Void>>... listeners) {
        addListeners((GenericFutureListener[]) listeners);
        return this;
    }

    @Override // p013io.netty.util.concurrent.DefaultPromise, p013io.netty.util.concurrent.Future
    public ChannelPromise removeListener(GenericFutureListener<? extends Future<? super Void>> listener) {
        removeListener((GenericFutureListener) listener);
        return this;
    }

    @Override // p013io.netty.util.concurrent.DefaultPromise, p013io.netty.util.concurrent.Future
    public ChannelPromise removeListeners(GenericFutureListener<? extends Future<? super Void>>... listeners) {
        removeListeners((GenericFutureListener[]) listeners);
        return this;
    }

    @Override // p013io.netty.util.concurrent.DefaultPromise, p013io.netty.util.concurrent.Future
    public ChannelPromise sync() throws InterruptedException {
        sync();
        return this;
    }

    @Override // p013io.netty.util.concurrent.DefaultPromise, p013io.netty.util.concurrent.Future
    public ChannelPromise syncUninterruptibly() {
        syncUninterruptibly();
        return this;
    }

    @Override // p013io.netty.util.concurrent.DefaultPromise, p013io.netty.util.concurrent.Future
    public ChannelPromise await() throws InterruptedException {
        await();
        return this;
    }

    @Override // p013io.netty.util.concurrent.DefaultPromise, p013io.netty.util.concurrent.Future
    public ChannelPromise awaitUninterruptibly() {
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
    public ChannelPromise promise() {
        return this;
    }

    @Override // p013io.netty.util.concurrent.DefaultPromise
    protected void checkDeadLock() {
        if (channel().isRegistered()) {
            checkDeadLock();
        }
    }

    @Override // p013io.netty.channel.ChannelPromise
    public ChannelPromise unvoid() {
        return this;
    }

    @Override // p013io.netty.channel.ChannelFuture
    public boolean isVoid() {
        return false;
    }
}
