package p013io.netty.channel;

import java.util.concurrent.TimeUnit;
import p013io.netty.util.concurrent.AbstractFuture;
import p013io.netty.util.concurrent.Future;
import p013io.netty.util.concurrent.GenericFutureListener;
import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.channel.VoidChannelPromise */
/* loaded from: grasscutter.jar:io/netty/channel/VoidChannelPromise.class */
public final class VoidChannelPromise extends AbstractFuture<Void> implements ChannelPromise {
    private final Channel channel;
    private final ChannelFutureListener fireExceptionListener;

    public VoidChannelPromise(Channel channel, boolean fireException) {
        ObjectUtil.checkNotNull(channel, "channel");
        this.channel = channel;
        if (fireException) {
            this.fireExceptionListener = new ChannelFutureListener() { // from class: io.netty.channel.VoidChannelPromise.1
                public void operationComplete(ChannelFuture future) throws Exception {
                    Throwable cause = future.cause();
                    if (cause != null) {
                        VoidChannelPromise.this.fireException0(cause);
                    }
                }
            };
        } else {
            this.fireExceptionListener = null;
        }
    }

    @Override // p013io.netty.util.concurrent.Future
    public VoidChannelPromise addListener(GenericFutureListener<? extends Future<? super Void>> listener) {
        fail();
        return this;
    }

    @Override // p013io.netty.util.concurrent.Future
    public VoidChannelPromise addListeners(GenericFutureListener<? extends Future<? super Void>>... listeners) {
        fail();
        return this;
    }

    @Override // p013io.netty.util.concurrent.Future
    public VoidChannelPromise removeListener(GenericFutureListener<? extends Future<? super Void>> listener) {
        return this;
    }

    @Override // p013io.netty.util.concurrent.Future
    public VoidChannelPromise removeListeners(GenericFutureListener<? extends Future<? super Void>>... listeners) {
        return this;
    }

    @Override // p013io.netty.util.concurrent.Future
    public VoidChannelPromise await() throws InterruptedException {
        if (!Thread.interrupted()) {
            return this;
        }
        throw new InterruptedException();
    }

    @Override // p013io.netty.util.concurrent.Future
    public boolean await(long timeout, TimeUnit unit) {
        fail();
        return false;
    }

    @Override // p013io.netty.util.concurrent.Future
    public boolean await(long timeoutMillis) {
        fail();
        return false;
    }

    @Override // p013io.netty.util.concurrent.Future
    public VoidChannelPromise awaitUninterruptibly() {
        fail();
        return this;
    }

    @Override // p013io.netty.util.concurrent.Future
    public boolean awaitUninterruptibly(long timeout, TimeUnit unit) {
        fail();
        return false;
    }

    @Override // p013io.netty.util.concurrent.Future
    public boolean awaitUninterruptibly(long timeoutMillis) {
        fail();
        return false;
    }

    @Override // p013io.netty.channel.ChannelPromise, p013io.netty.channel.ChannelFuture
    public Channel channel() {
        return this.channel;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return false;
    }

    @Override // p013io.netty.util.concurrent.Future
    public boolean isSuccess() {
        return false;
    }

    @Override // p013io.netty.util.concurrent.Promise
    public boolean setUncancellable() {
        return true;
    }

    @Override // p013io.netty.util.concurrent.Future
    public boolean isCancellable() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return false;
    }

    @Override // p013io.netty.util.concurrent.Future
    public Throwable cause() {
        return null;
    }

    @Override // p013io.netty.util.concurrent.Future
    public VoidChannelPromise sync() {
        fail();
        return this;
    }

    @Override // p013io.netty.util.concurrent.Future
    public VoidChannelPromise syncUninterruptibly() {
        fail();
        return this;
    }

    @Override // p013io.netty.channel.ChannelPromise
    public VoidChannelPromise setFailure(Throwable cause) {
        fireException0(cause);
        return this;
    }

    @Override // p013io.netty.channel.ChannelPromise
    public VoidChannelPromise setSuccess() {
        return this;
    }

    @Override // p013io.netty.util.concurrent.Promise
    public boolean tryFailure(Throwable cause) {
        fireException0(cause);
        return false;
    }

    @Override // p013io.netty.util.concurrent.Future, java.util.concurrent.Future
    public boolean cancel(boolean mayInterruptIfRunning) {
        return false;
    }

    @Override // p013io.netty.channel.ChannelPromise
    public boolean trySuccess() {
        return false;
    }

    private static void fail() {
        throw new IllegalStateException("void future");
    }

    @Override // p013io.netty.channel.ChannelPromise
    public VoidChannelPromise setSuccess(Void result) {
        return this;
    }

    public boolean trySuccess(Void result) {
        return false;
    }

    @Override // p013io.netty.util.concurrent.Future
    public Void getNow() {
        return null;
    }

    @Override // p013io.netty.channel.ChannelPromise
    public ChannelPromise unvoid() {
        ChannelPromise promise = new DefaultChannelPromise(this.channel);
        if (this.fireExceptionListener != null) {
            promise.addListener(this.fireExceptionListener);
        }
        return promise;
    }

    @Override // p013io.netty.channel.ChannelFuture
    public boolean isVoid() {
        return true;
    }

    /* access modifiers changed from: private */
    public void fireException0(Throwable cause) {
        if (this.fireExceptionListener != null && this.channel.isRegistered()) {
            this.channel.pipeline().fireExceptionCaught(cause);
        }
    }
}
