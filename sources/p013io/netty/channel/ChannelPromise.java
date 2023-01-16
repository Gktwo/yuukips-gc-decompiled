package p013io.netty.channel;

import p013io.netty.util.concurrent.Future;
import p013io.netty.util.concurrent.GenericFutureListener;
import p013io.netty.util.concurrent.Promise;

/* renamed from: io.netty.channel.ChannelPromise */
/* loaded from: grasscutter.jar:io/netty/channel/ChannelPromise.class */
public interface ChannelPromise extends ChannelFuture, Promise<Void> {
    @Override // p013io.netty.channel.ChannelFuture
    Channel channel();

    ChannelPromise setSuccess(Void v);

    ChannelPromise setSuccess();

    boolean trySuccess();

    ChannelPromise setFailure(Throwable th);

    @Override // p013io.netty.channel.ChannelFuture, p013io.netty.util.concurrent.Future
    ChannelPromise addListener(GenericFutureListener<? extends Future<? super Void>> genericFutureListener);

    @Override // p013io.netty.channel.ChannelFuture, p013io.netty.util.concurrent.Future
    ChannelPromise addListeners(GenericFutureListener<? extends Future<? super Void>>... genericFutureListenerArr);

    @Override // p013io.netty.channel.ChannelFuture, p013io.netty.util.concurrent.Future
    ChannelPromise removeListener(GenericFutureListener<? extends Future<? super Void>> genericFutureListener);

    @Override // p013io.netty.channel.ChannelFuture, p013io.netty.util.concurrent.Future
    ChannelPromise removeListeners(GenericFutureListener<? extends Future<? super Void>>... genericFutureListenerArr);

    @Override // p013io.netty.channel.ChannelFuture, p013io.netty.util.concurrent.Future
    ChannelPromise sync() throws InterruptedException;

    @Override // p013io.netty.channel.ChannelFuture, p013io.netty.util.concurrent.Future
    ChannelPromise syncUninterruptibly();

    @Override // p013io.netty.channel.ChannelFuture, p013io.netty.util.concurrent.Future
    ChannelPromise await() throws InterruptedException;

    @Override // p013io.netty.channel.ChannelFuture, p013io.netty.util.concurrent.Future
    ChannelPromise awaitUninterruptibly();

    ChannelPromise unvoid();
}
