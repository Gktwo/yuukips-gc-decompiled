package p013io.netty.channel.pool;

import java.io.Closeable;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import p001ch.qos.logback.core.joran.action.Action;
import p013io.netty.channel.pool.ChannelPool;
import p013io.netty.util.concurrent.Future;
import p013io.netty.util.concurrent.GenericFutureListener;
import p013io.netty.util.concurrent.GlobalEventExecutor;
import p013io.netty.util.concurrent.Promise;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.PlatformDependent;
import p013io.netty.util.internal.ReadOnlyIterator;

/* renamed from: io.netty.channel.pool.AbstractChannelPoolMap */
/* loaded from: grasscutter.jar:io/netty/channel/pool/AbstractChannelPoolMap.class */
public abstract class AbstractChannelPoolMap<K, P extends ChannelPool> implements ChannelPoolMap<K, P>, Iterable<Map.Entry<K, P>>, Closeable {
    private final ConcurrentMap<K, P> map = PlatformDependent.newConcurrentHashMap();

    protected abstract P newPool(K k);

    @Override // p013io.netty.channel.pool.ChannelPoolMap
    public final P get(K key) {
        P pool = this.map.get(ObjectUtil.checkNotNull(key, Action.KEY_ATTRIBUTE));
        if (pool == null) {
            pool = newPool(key);
            P old = this.map.putIfAbsent(key, pool);
            if (old != null) {
                poolCloseAsyncIfSupported(pool);
                pool = old;
            }
        }
        return pool;
    }

    public final boolean remove(K key) {
        P pool = this.map.remove(ObjectUtil.checkNotNull(key, Action.KEY_ATTRIBUTE));
        if (pool == null) {
            return false;
        }
        poolCloseAsyncIfSupported(pool);
        return true;
    }

    private Future<Boolean> removeAsyncIfSupported(K key) {
        P pool = this.map.remove(ObjectUtil.checkNotNull(key, Action.KEY_ATTRIBUTE));
        if (pool == null) {
            return GlobalEventExecutor.INSTANCE.newSucceededFuture(Boolean.FALSE);
        }
        final Promise<Boolean> removePromise = GlobalEventExecutor.INSTANCE.newPromise();
        poolCloseAsyncIfSupported(pool).addListener(new GenericFutureListener<Future<? super Void>>() { // from class: io.netty.channel.pool.AbstractChannelPoolMap.1
            @Override // p013io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future<? super Void> future) throws Exception {
                if (future.isSuccess()) {
                    removePromise.setSuccess(Boolean.TRUE);
                } else {
                    removePromise.setFailure(future.cause());
                }
            }
        });
        return removePromise;
    }

    private static Future<Void> poolCloseAsyncIfSupported(ChannelPool pool) {
        if (pool instanceof SimpleChannelPool) {
            return ((SimpleChannelPool) pool).closeAsync();
        }
        try {
            pool.close();
            return GlobalEventExecutor.INSTANCE.newSucceededFuture(null);
        } catch (Exception e) {
            return GlobalEventExecutor.INSTANCE.newFailedFuture(e);
        }
    }

    @Override // java.lang.Iterable
    public final Iterator<Map.Entry<K, P>> iterator() {
        return new ReadOnlyIterator(this.map.entrySet().iterator());
    }

    public final int size() {
        return this.map.size();
    }

    public final boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override // p013io.netty.channel.pool.ChannelPoolMap
    public final boolean contains(K key) {
        return this.map.containsKey(ObjectUtil.checkNotNull(key, Action.KEY_ATTRIBUTE));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        for (K key : this.map.keySet()) {
            removeAsyncIfSupported(key).syncUninterruptibly();
        }
    }
}
