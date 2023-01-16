package p013io.netty.util.concurrent;

/* renamed from: io.netty.util.concurrent.ProgressiveFuture */
/* loaded from: grasscutter.jar:io/netty/util/concurrent/ProgressiveFuture.class */
public interface ProgressiveFuture<V> extends Future<V> {
    @Override // p013io.netty.util.concurrent.Future
    ProgressiveFuture<V> addListener(GenericFutureListener<? extends Future<? super V>> genericFutureListener);

    @Override // p013io.netty.util.concurrent.Future
    ProgressiveFuture<V> addListeners(GenericFutureListener<? extends Future<? super V>>... genericFutureListenerArr);

    @Override // p013io.netty.util.concurrent.Future
    ProgressiveFuture<V> removeListener(GenericFutureListener<? extends Future<? super V>> genericFutureListener);

    @Override // p013io.netty.util.concurrent.Future
    ProgressiveFuture<V> removeListeners(GenericFutureListener<? extends Future<? super V>>... genericFutureListenerArr);

    @Override // p013io.netty.util.concurrent.Future
    ProgressiveFuture<V> sync() throws InterruptedException;

    @Override // p013io.netty.util.concurrent.Future
    ProgressiveFuture<V> syncUninterruptibly();

    @Override // p013io.netty.util.concurrent.Future
    ProgressiveFuture<V> await() throws InterruptedException;

    @Override // p013io.netty.util.concurrent.Future
    ProgressiveFuture<V> awaitUninterruptibly();
}
