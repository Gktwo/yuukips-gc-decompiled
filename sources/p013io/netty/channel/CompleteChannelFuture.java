package p013io.netty.channel;

import p013io.netty.util.concurrent.CompleteFuture;
import p013io.netty.util.concurrent.EventExecutor;
import p013io.netty.util.concurrent.Future;
import p013io.netty.util.concurrent.GenericFutureListener;
import p013io.netty.util.internal.ObjectUtil;

/* access modifiers changed from: package-private */
/* renamed from: io.netty.channel.CompleteChannelFuture */
/* loaded from: grasscutter.jar:io/netty/channel/CompleteChannelFuture.class */
public abstract class CompleteChannelFuture extends CompleteFuture<Void> implements ChannelFuture {
    private final Channel channel;

    /* access modifiers changed from: protected */
    public CompleteChannelFuture(Channel channel, EventExecutor executor) {
        super(executor);
        this.channel = (Channel) ObjectUtil.checkNotNull(channel, "channel");
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.util.concurrent.CompleteFuture
    public EventExecutor executor() {
        EventExecutor e = executor();
        if (e == null) {
            return channel().eventLoop();
        }
        return e;
    }

    /* Return type fixed from 'io.netty.channel.ChannelFuture' to match base method */
    @Override // p013io.netty.util.concurrent.CompleteFuture, p013io.netty.util.concurrent.Future
    public Future<Void> addListener(GenericFutureListener<? extends Future<? super Void>> listener) {
        addListener((GenericFutureListener) listener);
        return this;
    }

    /* Return type fixed from 'io.netty.channel.ChannelFuture' to match base method */
    @Override // p013io.netty.util.concurrent.CompleteFuture, p013io.netty.util.concurrent.Future
    public Future<Void> addListeners(GenericFutureListener<? extends Future<? super Void>>... listeners) {
        addListeners((GenericFutureListener[]) listeners);
        return this;
    }

    /* Return type fixed from 'io.netty.channel.ChannelFuture' to match base method */
    @Override // p013io.netty.util.concurrent.CompleteFuture, p013io.netty.util.concurrent.Future
    public Future<Void> removeListener(GenericFutureListener<? extends Future<? super Void>> listener) {
        removeListener((GenericFutureListener) listener);
        return this;
    }

    /* Return type fixed from 'io.netty.channel.ChannelFuture' to match base method */
    @Override // p013io.netty.util.concurrent.CompleteFuture, p013io.netty.util.concurrent.Future
    public Future<Void> removeListeners(GenericFutureListener<? extends Future<? super Void>>... listeners) {
        removeListeners((GenericFutureListener[]) listeners);
        return this;
    }

    /* Return type fixed from 'io.netty.channel.ChannelFuture' to match base method */
    @Override // p013io.netty.util.concurrent.CompleteFuture, p013io.netty.util.concurrent.Future
    public Future<Void> syncUninterruptibly() {
        return this;
    }

    /* Return type fixed from 'io.netty.channel.ChannelFuture' to match base method */
    @Override // p013io.netty.util.concurrent.CompleteFuture, p013io.netty.util.concurrent.Future
    public Future<Void> sync() throws InterruptedException {
        return this;
    }

    /* Return type fixed from 'io.netty.channel.ChannelFuture' to match base method */
    @Override // p013io.netty.util.concurrent.CompleteFuture, p013io.netty.util.concurrent.Future
    public Future<Void> await() throws InterruptedException {
        return this;
    }

    /* Return type fixed from 'io.netty.channel.ChannelFuture' to match base method */
    @Override // p013io.netty.util.concurrent.CompleteFuture, p013io.netty.util.concurrent.Future
    public Future<Void> awaitUninterruptibly() {
        return this;
    }

    @Override // p013io.netty.channel.ChannelFuture
    public Channel channel() {
        return this.channel;
    }

    @Override // p013io.netty.util.concurrent.Future
    public Void getNow() {
        return null;
    }

    @Override // p013io.netty.channel.ChannelFuture
    public boolean isVoid() {
        return false;
    }
}
