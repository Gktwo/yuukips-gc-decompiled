package p013io.netty.util.concurrent;

import java.util.concurrent.TimeUnit;

/* renamed from: io.netty.util.concurrent.Future */
/* loaded from: grasscutter.jar:io/netty/util/concurrent/Future.class */
public interface Future<V> extends java.util.concurrent.Future<V> {
    boolean isSuccess();

    boolean isCancellable();

    Throwable cause();

    Future<V> addListener(GenericFutureListener<? extends Future<? super V>> genericFutureListener);

    Future<V> addListeners(GenericFutureListener<? extends Future<? super V>>... genericFutureListenerArr);

    Future<V> removeListener(GenericFutureListener<? extends Future<? super V>> genericFutureListener);

    Future<V> removeListeners(GenericFutureListener<? extends Future<? super V>>... genericFutureListenerArr);

    Future<V> sync() throws InterruptedException;

    Future<V> syncUninterruptibly();

    Future<V> await() throws InterruptedException;

    Future<V> awaitUninterruptibly();

    boolean await(long j, TimeUnit timeUnit) throws InterruptedException;

    boolean await(long j) throws InterruptedException;

    boolean awaitUninterruptibly(long j, TimeUnit timeUnit);

    boolean awaitUninterruptibly(long j);

    V getNow();

    @Override // java.util.concurrent.Future
    boolean cancel(boolean z);
}
