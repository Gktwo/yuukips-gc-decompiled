package p013io.netty.channel.group;

import java.util.Iterator;
import p013io.netty.channel.Channel;
import p013io.netty.channel.ChannelFuture;
import p013io.netty.util.concurrent.Future;
import p013io.netty.util.concurrent.GenericFutureListener;

/* renamed from: io.netty.channel.group.ChannelGroupFuture */
/* loaded from: grasscutter.jar:io/netty/channel/group/ChannelGroupFuture.class */
public interface ChannelGroupFuture extends Future<Void>, Iterable<ChannelFuture> {
    ChannelGroup group();

    ChannelFuture find(Channel channel);

    @Override // p013io.netty.util.concurrent.Future
    boolean isSuccess();

    @Override // p013io.netty.util.concurrent.Future
    ChannelGroupException cause();

    boolean isPartialSuccess();

    boolean isPartialFailure();

    /* Return type fixed from 'io.netty.channel.group.ChannelGroupFuture' to match base method */
    @Override // p013io.netty.util.concurrent.Future
    Future<Void> addListener(GenericFutureListener<? extends Future<? super Void>> genericFutureListener);

    /* Return type fixed from 'io.netty.channel.group.ChannelGroupFuture' to match base method */
    @Override // p013io.netty.util.concurrent.Future
    Future<Void> addListeners(GenericFutureListener<? extends Future<? super Void>>... genericFutureListenerArr);

    /* Return type fixed from 'io.netty.channel.group.ChannelGroupFuture' to match base method */
    @Override // p013io.netty.util.concurrent.Future
    Future<Void> removeListener(GenericFutureListener<? extends Future<? super Void>> genericFutureListener);

    /* Return type fixed from 'io.netty.channel.group.ChannelGroupFuture' to match base method */
    @Override // p013io.netty.util.concurrent.Future
    Future<Void> removeListeners(GenericFutureListener<? extends Future<? super Void>>... genericFutureListenerArr);

    /* Return type fixed from 'io.netty.channel.group.ChannelGroupFuture' to match base method */
    @Override // p013io.netty.util.concurrent.Future
    Future<Void> await() throws InterruptedException;

    /* Return type fixed from 'io.netty.channel.group.ChannelGroupFuture' to match base method */
    @Override // p013io.netty.util.concurrent.Future
    Future<Void> awaitUninterruptibly();

    /* Return type fixed from 'io.netty.channel.group.ChannelGroupFuture' to match base method */
    @Override // p013io.netty.util.concurrent.Future
    Future<Void> syncUninterruptibly();

    /* Return type fixed from 'io.netty.channel.group.ChannelGroupFuture' to match base method */
    @Override // p013io.netty.util.concurrent.Future
    Future<Void> sync() throws InterruptedException;

    @Override // java.lang.Iterable
    Iterator<ChannelFuture> iterator();
}
