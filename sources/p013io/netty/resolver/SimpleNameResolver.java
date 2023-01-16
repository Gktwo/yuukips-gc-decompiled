package p013io.netty.resolver;

import java.util.List;
import p013io.netty.util.concurrent.EventExecutor;
import p013io.netty.util.concurrent.Future;
import p013io.netty.util.concurrent.Promise;
import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.resolver.SimpleNameResolver */
/* loaded from: grasscutter.jar:io/netty/resolver/SimpleNameResolver.class */
public abstract class SimpleNameResolver<T> implements NameResolver<T> {
    private final EventExecutor executor;

    protected abstract void doResolve(String str, Promise<T> promise) throws Exception;

    protected abstract void doResolveAll(String str, Promise<List<T>> promise) throws Exception;

    /* access modifiers changed from: protected */
    public SimpleNameResolver(EventExecutor executor) {
        this.executor = (EventExecutor) ObjectUtil.checkNotNull(executor, "executor");
    }

    protected EventExecutor executor() {
        return this.executor;
    }

    @Override // p013io.netty.resolver.NameResolver
    public final Future<T> resolve(String inetHost) {
        return resolve(inetHost, executor().newPromise());
    }

    @Override // p013io.netty.resolver.NameResolver
    public Future<T> resolve(String inetHost, Promise<T> promise) {
        ObjectUtil.checkNotNull(promise, "promise");
        try {
            doResolve(inetHost, promise);
            return promise;
        } catch (Exception e) {
            return promise.setFailure(e);
        }
    }

    @Override // p013io.netty.resolver.NameResolver
    public final Future<List<T>> resolveAll(String inetHost) {
        return resolveAll(inetHost, executor().newPromise());
    }

    @Override // p013io.netty.resolver.NameResolver
    public Future<List<T>> resolveAll(String inetHost, Promise<List<T>> promise) {
        ObjectUtil.checkNotNull(promise, "promise");
        try {
            doResolveAll(inetHost, promise);
            return promise;
        } catch (Exception e) {
            return promise.setFailure(e);
        }
    }

    @Override // p013io.netty.resolver.NameResolver, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }
}
