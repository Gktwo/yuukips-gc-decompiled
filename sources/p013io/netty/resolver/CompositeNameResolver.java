package p013io.netty.resolver;

import java.util.Arrays;
import java.util.List;
import p013io.netty.util.concurrent.EventExecutor;
import p013io.netty.util.concurrent.Future;
import p013io.netty.util.concurrent.FutureListener;
import p013io.netty.util.concurrent.Promise;
import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.resolver.CompositeNameResolver */
/* loaded from: grasscutter.jar:io/netty/resolver/CompositeNameResolver.class */
public final class CompositeNameResolver<T> extends SimpleNameResolver<T> {
    private final NameResolver<T>[] resolvers;

    public CompositeNameResolver(EventExecutor executor, NameResolver<T>... resolvers) {
        super(executor);
        ObjectUtil.checkNotNull(resolvers, "resolvers");
        for (int i = 0; i < resolvers.length; i++) {
            ObjectUtil.checkNotNull(resolvers[i], "resolvers[" + i + ']');
        }
        if (resolvers.length < 2) {
            throw new IllegalArgumentException("resolvers: " + Arrays.asList(resolvers) + " (expected: at least 2 resolvers)");
        }
        this.resolvers = (NameResolver[]) resolvers.clone();
    }

    @Override // p013io.netty.resolver.SimpleNameResolver
    protected void doResolve(String inetHost, Promise<T> promise) throws Exception {
        doResolveRec(inetHost, promise, 0, null);
    }

    /* access modifiers changed from: private */
    public void doResolveRec(final String inetHost, final Promise<T> promise, final int resolverIndex, Throwable lastFailure) throws Exception {
        if (resolverIndex >= this.resolvers.length) {
            promise.setFailure(lastFailure);
        } else {
            this.resolvers[resolverIndex].resolve(inetHost).addListener(new FutureListener<T>() { // from class: io.netty.resolver.CompositeNameResolver.1
                @Override // p013io.netty.util.concurrent.GenericFutureListener
                public void operationComplete(Future<T> future) throws Exception {
                    if (future.isSuccess()) {
                        promise.setSuccess(future.getNow());
                    } else {
                        CompositeNameResolver.this.doResolveRec(inetHost, promise, resolverIndex + 1, future.cause());
                    }
                }
            });
        }
    }

    @Override // p013io.netty.resolver.SimpleNameResolver
    protected void doResolveAll(String inetHost, Promise<List<T>> promise) throws Exception {
        doResolveAllRec(inetHost, promise, 0, null);
    }

    /* access modifiers changed from: private */
    public void doResolveAllRec(final String inetHost, final Promise<List<T>> promise, final int resolverIndex, Throwable lastFailure) throws Exception {
        if (resolverIndex >= this.resolvers.length) {
            promise.setFailure(lastFailure);
        } else {
            this.resolvers[resolverIndex].resolveAll(inetHost).addListener(new FutureListener<List<T>>() { // from class: io.netty.resolver.CompositeNameResolver.2
                @Override // p013io.netty.util.concurrent.GenericFutureListener
                public void operationComplete(Future<List<T>> future) throws Exception {
                    if (future.isSuccess()) {
                        promise.setSuccess(future.getNow());
                    } else {
                        CompositeNameResolver.this.doResolveAllRec(inetHost, promise, resolverIndex + 1, future.cause());
                    }
                }
            });
        }
    }
}
