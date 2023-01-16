package p013io.netty.util.concurrent;

import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.PlatformDependent;

/* renamed from: io.netty.util.concurrent.FailedFuture */
/* loaded from: grasscutter.jar:io/netty/util/concurrent/FailedFuture.class */
public final class FailedFuture<V> extends CompleteFuture<V> {
    private final Throwable cause;

    public FailedFuture(EventExecutor executor, Throwable cause) {
        super(executor);
        this.cause = (Throwable) ObjectUtil.checkNotNull(cause, "cause");
    }

    @Override // p013io.netty.util.concurrent.Future
    public Throwable cause() {
        return this.cause;
    }

    @Override // p013io.netty.util.concurrent.Future
    public boolean isSuccess() {
        return false;
    }

    @Override // p013io.netty.util.concurrent.CompleteFuture, p013io.netty.util.concurrent.Future
    public Future<V> sync() {
        PlatformDependent.throwException(this.cause);
        return this;
    }

    @Override // p013io.netty.util.concurrent.CompleteFuture, p013io.netty.util.concurrent.Future
    public Future<V> syncUninterruptibly() {
        PlatformDependent.throwException(this.cause);
        return this;
    }

    @Override // p013io.netty.util.concurrent.Future
    public V getNow() {
        return null;
    }
}
