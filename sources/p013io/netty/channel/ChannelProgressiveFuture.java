package p013io.netty.channel;

import p013io.netty.util.concurrent.Future;
import p013io.netty.util.concurrent.GenericFutureListener;
import p013io.netty.util.concurrent.ProgressiveFuture;

/* renamed from: io.netty.channel.ChannelProgressiveFuture */
/* loaded from: grasscutter.jar:io/netty/channel/ChannelProgressiveFuture.class */
public interface ChannelProgressiveFuture extends ChannelFuture, ProgressiveFuture<Void> {
    @Override // p013io.netty.channel.ChannelFuture, p013io.netty.util.concurrent.Future
    ChannelProgressiveFuture addListener(GenericFutureListener<? extends Future<? super Void>> genericFutureListener);

    @Override // p013io.netty.channel.ChannelFuture, p013io.netty.util.concurrent.Future
    ChannelProgressiveFuture addListeners(GenericFutureListener<? extends Future<? super Void>>... genericFutureListenerArr);

    @Override // p013io.netty.channel.ChannelFuture, p013io.netty.util.concurrent.Future
    ChannelProgressiveFuture removeListener(GenericFutureListener<? extends Future<? super Void>> genericFutureListener);

    @Override // p013io.netty.channel.ChannelFuture, p013io.netty.util.concurrent.Future
    ChannelProgressiveFuture removeListeners(GenericFutureListener<? extends Future<? super Void>>... genericFutureListenerArr);

    @Override // p013io.netty.channel.ChannelFuture, p013io.netty.util.concurrent.Future
    ChannelProgressiveFuture sync() throws InterruptedException;

    @Override // p013io.netty.channel.ChannelFuture, p013io.netty.util.concurrent.Future
    ChannelProgressiveFuture syncUninterruptibly();

    @Override // p013io.netty.channel.ChannelFuture, p013io.netty.util.concurrent.Future
    ChannelProgressiveFuture await() throws InterruptedException;

    @Override // p013io.netty.channel.ChannelFuture, p013io.netty.util.concurrent.Future
    ChannelProgressiveFuture awaitUninterruptibly();
}
