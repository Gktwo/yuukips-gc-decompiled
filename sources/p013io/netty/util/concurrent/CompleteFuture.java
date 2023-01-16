package p013io.netty.util.concurrent;

import java.util.concurrent.TimeUnit;
import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.util.concurrent.CompleteFuture */
/* loaded from: grasscutter.jar:io/netty/util/concurrent/CompleteFuture.class */
public abstract class CompleteFuture<V> extends AbstractFuture<V> {
    private final EventExecutor executor;

    /* access modifiers changed from: protected */
    public CompleteFuture(EventExecutor executor) {
        this.executor = executor;
    }

    /* access modifiers changed from: protected */
    public EventExecutor executor() {
        return this.executor;
    }

    @Override // p013io.netty.util.concurrent.Future
    public Future<V> addListener(GenericFutureListener<? extends Future<? super V>> listener) {
        DefaultPromise.notifyListener(executor(), this, (GenericFutureListener) ObjectUtil.checkNotNull(listener, "listener"));
        return this;
    }

    @Override // p013io.netty.util.concurrent.Future
    public Future<V> addListeners(GenericFutureListener<? extends Future<? super V>>... listeners) {
        GenericFutureListener<? extends Future<? super V>> l;
        GenericFutureListener<? extends Future<? super V>>[] genericFutureListenerArr = (GenericFutureListener[]) ObjectUtil.checkNotNull(listeners, "listeners");
        int length = genericFutureListenerArr.length;
        int i = 0;
        while (i < length && (l = genericFutureListenerArr[i]) != null) {
            DefaultPromise.notifyListener(executor(), this, l);
            i++;
        }
        return this;
    }

    @Override // p013io.netty.util.concurrent.Future
    public Future<V> removeListener(GenericFutureListener<? extends Future<? super V>> listener) {
        return this;
    }

    @Override // p013io.netty.util.concurrent.Future
    public Future<V> removeListeners(GenericFutureListener<? extends Future<? super V>>... listeners) {
        return this;
    }

    @Override // p013io.netty.util.concurrent.Future
    public Future<V> await() throws InterruptedException {
        if (!Thread.interrupted()) {
            return this;
        }
        throw new InterruptedException();
    }

    @Override // p013io.netty.util.concurrent.Future
    public boolean await(long timeout, TimeUnit unit) throws InterruptedException {
        if (!Thread.interrupted()) {
            return true;
        }
        throw new InterruptedException();
    }

    @Override // p013io.netty.util.concurrent.Future
    public Future<V> sync() throws InterruptedException {
        return this;
    }

    @Override // p013io.netty.util.concurrent.Future
    public Future<V> syncUninterruptibly() {
        return this;
    }

    @Override // p013io.netty.util.concurrent.Future
    public boolean await(long timeoutMillis) throws InterruptedException {
        if (!Thread.interrupted()) {
            return true;
        }
        throw new InterruptedException();
    }

    @Override // p013io.netty.util.concurrent.Future
    public Future<V> awaitUninterruptibly() {
        return this;
    }

    @Override // p013io.netty.util.concurrent.Future
    public boolean awaitUninterruptibly(long timeout, TimeUnit unit) {
        return true;
    }

    @Override // p013io.netty.util.concurrent.Future
    public boolean awaitUninterruptibly(long timeoutMillis) {
        return true;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return true;
    }

    @Override // p013io.netty.util.concurrent.Future
    public boolean isCancellable() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return false;
    }

    @Override // p013io.netty.util.concurrent.Future, java.util.concurrent.Future
    public boolean cancel(boolean mayInterruptIfRunning) {
        return false;
    }
}
