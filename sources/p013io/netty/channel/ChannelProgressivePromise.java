package p013io.netty.channel;

import p013io.netty.util.concurrent.Future;
import p013io.netty.util.concurrent.GenericFutureListener;
import p013io.netty.util.concurrent.ProgressivePromise;

/* renamed from: io.netty.channel.ChannelProgressivePromise */
/* loaded from: grasscutter.jar:io/netty/channel/ChannelProgressivePromise.class */
public interface ChannelProgressivePromise extends ProgressivePromise<Void>, ChannelProgressiveFuture, ChannelPromise {
    @Override // p013io.netty.util.concurrent.ProgressivePromise, p013io.netty.util.concurrent.Promise, p013io.netty.util.concurrent.Future
    ChannelProgressivePromise addListener(GenericFutureListener<? extends Future<? super Void>> genericFutureListener);

    @Override // p013io.netty.util.concurrent.ProgressivePromise, p013io.netty.util.concurrent.Promise, p013io.netty.util.concurrent.Future
    ChannelProgressivePromise addListeners(GenericFutureListener<? extends Future<? super Void>>... genericFutureListenerArr);

    @Override // p013io.netty.util.concurrent.ProgressivePromise, p013io.netty.util.concurrent.Promise, p013io.netty.util.concurrent.Future
    ChannelProgressivePromise removeListener(GenericFutureListener<? extends Future<? super Void>> genericFutureListener);

    @Override // p013io.netty.util.concurrent.ProgressivePromise, p013io.netty.util.concurrent.Promise, p013io.netty.util.concurrent.Future
    ChannelProgressivePromise removeListeners(GenericFutureListener<? extends Future<? super Void>>... genericFutureListenerArr);

    @Override // p013io.netty.util.concurrent.ProgressivePromise, p013io.netty.util.concurrent.Promise, p013io.netty.util.concurrent.Future
    ChannelProgressivePromise sync() throws InterruptedException;

    @Override // p013io.netty.util.concurrent.ProgressivePromise, p013io.netty.util.concurrent.Promise, p013io.netty.util.concurrent.Future
    ChannelProgressivePromise syncUninterruptibly();

    @Override // p013io.netty.util.concurrent.ProgressivePromise, p013io.netty.util.concurrent.Promise, p013io.netty.util.concurrent.Future
    ChannelProgressivePromise await() throws InterruptedException;

    @Override // p013io.netty.util.concurrent.ProgressivePromise, p013io.netty.util.concurrent.Promise, p013io.netty.util.concurrent.Future
    ChannelProgressivePromise awaitUninterruptibly();

    @Override // p013io.netty.channel.ChannelPromise
    ChannelProgressivePromise setSuccess(Void v);

    @Override // p013io.netty.channel.ChannelPromise
    ChannelProgressivePromise setSuccess();

    @Override // p013io.netty.util.concurrent.ProgressivePromise, p013io.netty.util.concurrent.Promise, p013io.netty.channel.ChannelPromise
    ChannelProgressivePromise setFailure(Throwable th);

    /* Return type fixed from 'io.netty.channel.ChannelProgressivePromise' to match base method */
    @Override // p013io.netty.util.concurrent.ProgressivePromise
    ProgressivePromise<Void> setProgress(long j, long j2);

    @Override // p013io.netty.channel.ChannelPromise
    ChannelProgressivePromise unvoid();
}
