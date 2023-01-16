package p013io.netty.resolver;

import java.io.Closeable;
import java.net.SocketAddress;
import java.util.IdentityHashMap;
import java.util.Map;
import p013io.netty.util.concurrent.EventExecutor;
import p013io.netty.util.concurrent.Future;
import p013io.netty.util.concurrent.FutureListener;
import p013io.netty.util.concurrent.GenericFutureListener;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

/* renamed from: io.netty.resolver.AddressResolverGroup */
/* loaded from: grasscutter.jar:io/netty/resolver/AddressResolverGroup.class */
public abstract class AddressResolverGroup<T extends SocketAddress> implements Closeable {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(AddressResolverGroup.class);
    private final Map<EventExecutor, AddressResolver<T>> resolvers = new IdentityHashMap();
    private final Map<EventExecutor, GenericFutureListener<Future<Object>>> executorTerminationListeners = new IdentityHashMap();

    protected abstract AddressResolver<T> newResolver(EventExecutor eventExecutor) throws Exception;

    public AddressResolver<T> getResolver(final EventExecutor executor) {
        AddressResolver<T> r;
        ObjectUtil.checkNotNull(executor, "executor");
        if (executor.isShuttingDown()) {
            throw new IllegalStateException("executor not accepting a task");
        }
        synchronized (this.resolvers) {
            r = this.resolvers.get(executor);
            if (r == null) {
                try {
                    final AddressResolver<T> newResolver = newResolver(executor);
                    this.resolvers.put(executor, newResolver);
                    FutureListener<Object> terminationListener = new FutureListener<Object>() { // from class: io.netty.resolver.AddressResolverGroup.1
                        @Override // p013io.netty.util.concurrent.GenericFutureListener
                        public void operationComplete(Future<Object> future) {
                            synchronized (AddressResolverGroup.this.resolvers) {
                                AddressResolverGroup.this.resolvers.remove(executor);
                                AddressResolverGroup.this.executorTerminationListeners.remove(executor);
                            }
                            newResolver.close();
                        }
                    };
                    this.executorTerminationListeners.put(executor, terminationListener);
                    executor.terminationFuture().addListener(terminationListener);
                    r = newResolver;
                } catch (Exception e) {
                    throw new IllegalStateException("failed to create a new resolver", e);
                }
            }
        }
        return r;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        AddressResolver<T>[] rArray;
        Map.Entry<EventExecutor, GenericFutureListener<Future<Object>>>[] listeners;
        synchronized (this.resolvers) {
            rArray = (AddressResolver[]) this.resolvers.values().toArray(new AddressResolver[0]);
            this.resolvers.clear();
            listeners = (Map.Entry[]) this.executorTerminationListeners.entrySet().toArray(new Map.Entry[0]);
            this.executorTerminationListeners.clear();
        }
        for (Map.Entry<EventExecutor, GenericFutureListener<Future<Object>>> entry : listeners) {
            entry.getKey().terminationFuture().removeListener(entry.getValue());
        }
        for (AddressResolver<T> r : rArray) {
            try {
                r.close();
            } catch (Throwable t) {
                logger.warn("Failed to close a resolver:", t);
            }
        }
    }
}
