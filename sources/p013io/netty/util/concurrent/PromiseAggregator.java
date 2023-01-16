package p013io.netty.util.concurrent;

import java.util.LinkedHashSet;
import java.util.Set;
import p013io.netty.util.concurrent.Future;
import p013io.netty.util.internal.ObjectUtil;

@Deprecated
/* renamed from: io.netty.util.concurrent.PromiseAggregator */
/* loaded from: grasscutter.jar:io/netty/util/concurrent/PromiseAggregator.class */
public class PromiseAggregator<V, F extends Future<V>> implements GenericFutureListener<F> {
    private final Promise<?> aggregatePromise;
    private final boolean failPending;
    private Set<Promise<V>> pendingPromises;

    public PromiseAggregator(Promise<Void> aggregatePromise, boolean failPending) {
        this.aggregatePromise = (Promise) ObjectUtil.checkNotNull(aggregatePromise, "aggregatePromise");
        this.failPending = failPending;
    }

    public PromiseAggregator(Promise<Void> aggregatePromise) {
        this(aggregatePromise, true);
    }

    @SafeVarargs
    public final PromiseAggregator<V, F> add(Promise<V>... promises) {
        int size;
        ObjectUtil.checkNotNull(promises, "promises");
        if (promises.length == 0) {
            return this;
        }
        synchronized (this) {
            if (this.pendingPromises == null) {
                if (promises.length > 1) {
                    size = promises.length;
                } else {
                    size = 2;
                }
                this.pendingPromises = new LinkedHashSet(size);
            }
            for (Promise<V> p : promises) {
                if (p != null) {
                    this.pendingPromises.add(p);
                    p.addListener((GenericFutureListener) this);
                }
            }
        }
        return this;
    }

    @Override // p013io.netty.util.concurrent.GenericFutureListener
    public synchronized void operationComplete(F future) throws Exception {
        if (this.pendingPromises == null) {
            this.aggregatePromise.setSuccess(null);
            return;
        }
        this.pendingPromises.remove(future);
        if (!future.isSuccess()) {
            Throwable cause = future.cause();
            this.aggregatePromise.setFailure(cause);
            if (this.failPending) {
                for (Promise<V> pendingFuture : this.pendingPromises) {
                    pendingFuture.setFailure(cause);
                }
            }
        } else if (this.pendingPromises.isEmpty()) {
            this.aggregatePromise.setSuccess(null);
        }
    }
}
