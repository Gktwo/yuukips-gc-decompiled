package p013io.netty.channel;

import p013io.netty.util.concurrent.Future;
import p013io.netty.util.concurrent.GenericFutureListener;

/* renamed from: io.netty.channel.ChannelFuture */
/* loaded from: grasscutter.jar:io/netty/channel/ChannelFuture.class */
public interface ChannelFuture extends Future<Void> {
    Channel channel();

    /* Return type fixed from 'io.netty.channel.ChannelFuture' to match base method */
    @Override // p013io.netty.util.concurrent.Future
    Future<Void> addListener(GenericFutureListener<? extends Future<? super Void>> genericFutureListener);

    /* Return type fixed from 'io.netty.channel.ChannelFuture' to match base method */
    @Override // p013io.netty.util.concurrent.Future
    Future<Void> addListeners(GenericFutureListener<? extends Future<? super Void>>... genericFutureListenerArr);

    /* Return type fixed from 'io.netty.channel.ChannelFuture' to match base method */
    @Override // p013io.netty.util.concurrent.Future
    Future<Void> removeListener(GenericFutureListener<? extends Future<? super Void>> genericFutureListener);

    /* Return type fixed from 'io.netty.channel.ChannelFuture' to match base method */
    @Override // p013io.netty.util.concurrent.Future
    Future<Void> removeListeners(GenericFutureListener<? extends Future<? super Void>>... genericFutureListenerArr);

    /* Return type fixed from 'io.netty.channel.ChannelFuture' to match base method */
    @Override // p013io.netty.util.concurrent.Future
    Future<Void> sync() throws InterruptedException;

    /* Return type fixed from 'io.netty.channel.ChannelFuture' to match base method */
    @Override // p013io.netty.util.concurrent.Future
    Future<Void> syncUninterruptibly();

    /* Return type fixed from 'io.netty.channel.ChannelFuture' to match base method */
    @Override // p013io.netty.util.concurrent.Future
    Future<Void> await() throws InterruptedException;

    /* Return type fixed from 'io.netty.channel.ChannelFuture' to match base method */
    @Override // p013io.netty.util.concurrent.Future
    Future<Void> awaitUninterruptibly();

    boolean isVoid();
}
