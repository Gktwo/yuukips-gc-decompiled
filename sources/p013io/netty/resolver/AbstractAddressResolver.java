package p013io.netty.resolver;

import java.net.SocketAddress;
import java.nio.channels.UnsupportedAddressTypeException;
import java.util.Collections;
import java.util.List;
import p013io.netty.util.concurrent.EventExecutor;
import p013io.netty.util.concurrent.Future;
import p013io.netty.util.concurrent.Promise;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.TypeParameterMatcher;

/* renamed from: io.netty.resolver.AbstractAddressResolver */
/* loaded from: grasscutter.jar:io/netty/resolver/AbstractAddressResolver.class */
public abstract class AbstractAddressResolver<T extends SocketAddress> implements AddressResolver<T> {
    private final EventExecutor executor;
    private final TypeParameterMatcher matcher;

    protected abstract boolean doIsResolved(T t);

    protected abstract void doResolve(T t, Promise<T> promise) throws Exception;

    protected abstract void doResolveAll(T t, Promise<List<T>> promise) throws Exception;

    /* access modifiers changed from: protected */
    public AbstractAddressResolver(EventExecutor executor) {
        this.executor = (EventExecutor) ObjectUtil.checkNotNull(executor, "executor");
        this.matcher = TypeParameterMatcher.find(this, AbstractAddressResolver.class, "T");
    }

    /* access modifiers changed from: protected */
    public AbstractAddressResolver(EventExecutor executor, Class<? extends T> addressType) {
        this.executor = (EventExecutor) ObjectUtil.checkNotNull(executor, "executor");
        this.matcher = TypeParameterMatcher.get(addressType);
    }

    protected EventExecutor executor() {
        return this.executor;
    }

    @Override // p013io.netty.resolver.AddressResolver
    public boolean isSupported(SocketAddress address) {
        return this.matcher.match(address);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.net.SocketAddress */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // p013io.netty.resolver.AddressResolver
    public final boolean isResolved(SocketAddress address) {
        if (isSupported(address)) {
            return doIsResolved(address);
        }
        throw new UnsupportedAddressTypeException();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.net.SocketAddress */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // p013io.netty.resolver.AddressResolver
    public final Future<T> resolve(SocketAddress address) {
        if (!isSupported((SocketAddress) ObjectUtil.checkNotNull(address, "address"))) {
            return executor().newFailedFuture(new UnsupportedAddressTypeException());
        }
        if (isResolved(address)) {
            return this.executor.newSucceededFuture(address);
        }
        try {
            Promise<T> promise = executor().newPromise();
            doResolve(address, promise);
            return promise;
        } catch (Exception e) {
            return executor().newFailedFuture(e);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.net.SocketAddress */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // p013io.netty.resolver.AddressResolver
    public final Future<T> resolve(SocketAddress address, Promise<T> promise) {
        ObjectUtil.checkNotNull(address, "address");
        ObjectUtil.checkNotNull(promise, "promise");
        if (!isSupported(address)) {
            return promise.setFailure(new UnsupportedAddressTypeException());
        }
        if (isResolved(address)) {
            return promise.setSuccess(address);
        }
        try {
            doResolve(address, promise);
            return promise;
        } catch (Exception e) {
            return promise.setFailure(e);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.net.SocketAddress */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // p013io.netty.resolver.AddressResolver
    public final Future<List<T>> resolveAll(SocketAddress address) {
        if (!isSupported((SocketAddress) ObjectUtil.checkNotNull(address, "address"))) {
            return executor().newFailedFuture(new UnsupportedAddressTypeException());
        }
        if (isResolved(address)) {
            return this.executor.newSucceededFuture(Collections.singletonList(address));
        }
        try {
            Promise<List<T>> promise = executor().newPromise();
            doResolveAll(address, promise);
            return promise;
        } catch (Exception e) {
            return executor().newFailedFuture(e);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.net.SocketAddress */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // p013io.netty.resolver.AddressResolver
    public final Future<List<T>> resolveAll(SocketAddress address, Promise<List<T>> promise) {
        ObjectUtil.checkNotNull(address, "address");
        ObjectUtil.checkNotNull(promise, "promise");
        if (!isSupported(address)) {
            return promise.setFailure(new UnsupportedAddressTypeException());
        }
        if (isResolved(address)) {
            return promise.setSuccess(Collections.singletonList(address));
        }
        try {
            doResolveAll(address, promise);
            return promise;
        } catch (Exception e) {
            return promise.setFailure(e);
        }
    }

    @Override // p013io.netty.resolver.AddressResolver, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }
}
