package p013io.netty.util.concurrent;

/* renamed from: io.netty.util.concurrent.Promise */
/* loaded from: grasscutter.jar:io/netty/util/concurrent/Promise.class */
public interface Promise<V> extends Future<V> {
    @Override // p013io.netty.util.concurrent.ProgressivePromise
    Promise<V> setSuccess(V v);

    boolean trySuccess(V v);

    @Override // p013io.netty.channel.ChannelPromise
    Promise<V> setFailure(Throwable th);

    boolean tryFailure(Throwable th);

    boolean setUncancellable();

    @Override // p013io.netty.util.concurrent.Future
    Promise<V> addListener(GenericFutureListener<? extends Future<? super V>> genericFutureListener);

    @Override // p013io.netty.util.concurrent.Future
    Promise<V> addListeners(GenericFutureListener<? extends Future<? super V>>... genericFutureListenerArr);

    @Override // p013io.netty.util.concurrent.Future
    Promise<V> removeListener(GenericFutureListener<? extends Future<? super V>> genericFutureListener);

    @Override // p013io.netty.util.concurrent.Future
    Promise<V> removeListeners(GenericFutureListener<? extends Future<? super V>>... genericFutureListenerArr);

    @Override // p013io.netty.util.concurrent.Future
    Promise<V> await() throws InterruptedException;

    @Override // p013io.netty.util.concurrent.Future
    Promise<V> awaitUninterruptibly();

    @Override // p013io.netty.util.concurrent.Future
    Promise<V> sync() throws InterruptedException;

    @Override // p013io.netty.util.concurrent.Future
    Promise<V> syncUninterruptibly();
}
