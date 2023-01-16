package p013io.netty.util.concurrent;

/* renamed from: io.netty.util.concurrent.SucceededFuture */
/* loaded from: grasscutter.jar:io/netty/util/concurrent/SucceededFuture.class */
public final class SucceededFuture<V> extends CompleteFuture<V> {
    private final V result;

    public SucceededFuture(EventExecutor executor, V result) {
        super(executor);
        this.result = result;
    }

    @Override // p013io.netty.util.concurrent.Future
    public Throwable cause() {
        return null;
    }

    @Override // p013io.netty.util.concurrent.Future
    public boolean isSuccess() {
        return true;
    }

    @Override // p013io.netty.util.concurrent.Future
    public V getNow() {
        return this.result;
    }
}
