package p013io.netty.util.concurrent;

/* renamed from: io.netty.util.concurrent.ProgressivePromise */
/* loaded from: grasscutter.jar:io/netty/util/concurrent/ProgressivePromise.class */
public interface ProgressivePromise<V> extends Promise<V>, ProgressiveFuture<V> {
    ProgressivePromise<V> setProgress(long j, long j2);

    boolean tryProgress(long j, long j2);

    ProgressivePromise<V> setSuccess(V v);

    @Override // p013io.netty.util.concurrent.Promise, p013io.netty.channel.ChannelPromise
    ProgressivePromise<V> setFailure(Throwable th);

    @Override // p013io.netty.util.concurrent.Promise, p013io.netty.util.concurrent.Future
    ProgressivePromise<V> addListener(GenericFutureListener<? extends Future<? super V>> genericFutureListener);

    @Override // p013io.netty.util.concurrent.Promise, p013io.netty.util.concurrent.Future
    ProgressivePromise<V> addListeners(GenericFutureListener<? extends Future<? super V>>... genericFutureListenerArr);

    @Override // p013io.netty.util.concurrent.Promise, p013io.netty.util.concurrent.Future
    ProgressivePromise<V> removeListener(GenericFutureListener<? extends Future<? super V>> genericFutureListener);

    @Override // p013io.netty.util.concurrent.Promise, p013io.netty.util.concurrent.Future
    ProgressivePromise<V> removeListeners(GenericFutureListener<? extends Future<? super V>>... genericFutureListenerArr);

    @Override // p013io.netty.util.concurrent.Promise, p013io.netty.util.concurrent.Future
    ProgressivePromise<V> await() throws InterruptedException;

    @Override // p013io.netty.util.concurrent.Promise, p013io.netty.util.concurrent.Future
    ProgressivePromise<V> awaitUninterruptibly();

    @Override // p013io.netty.util.concurrent.Promise, p013io.netty.util.concurrent.Future
    ProgressivePromise<V> sync() throws InterruptedException;

    @Override // p013io.netty.util.concurrent.Promise, p013io.netty.util.concurrent.Future
    ProgressivePromise<V> syncUninterruptibly();
}
