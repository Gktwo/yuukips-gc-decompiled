package p013io.netty.channel.group;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import p013io.netty.channel.Channel;
import p013io.netty.channel.ChannelFuture;
import p013io.netty.channel.ChannelFutureListener;
import p013io.netty.util.concurrent.BlockingOperationException;
import p013io.netty.util.concurrent.DefaultPromise;
import p013io.netty.util.concurrent.EventExecutor;
import p013io.netty.util.concurrent.Future;
import p013io.netty.util.concurrent.GenericFutureListener;
import p013io.netty.util.concurrent.ImmediateEventExecutor;
import p013io.netty.util.internal.ObjectUtil;

/* access modifiers changed from: package-private */
/* renamed from: io.netty.channel.group.DefaultChannelGroupFuture */
/* loaded from: grasscutter.jar:io/netty/channel/group/DefaultChannelGroupFuture.class */
public final class DefaultChannelGroupFuture extends DefaultPromise<Void> implements ChannelGroupFuture {
    private final ChannelGroup group;
    private final Map<Channel, ChannelFuture> futures;
    private int successCount;
    private int failureCount;
    private final ChannelFutureListener childListener = new ChannelFutureListener() { // from class: io.netty.channel.group.DefaultChannelGroupFuture.1
        static final /* synthetic */ boolean $assertionsDisabled;

        static {
            $assertionsDisabled = !DefaultChannelGroupFuture.class.desiredAssertionStatus();
        }

        public void operationComplete(ChannelFuture future) throws Exception {
            boolean callSetDone;
            boolean success = future.isSuccess();
            synchronized (DefaultChannelGroupFuture.this) {
                if (success) {
                    DefaultChannelGroupFuture.access$008(DefaultChannelGroupFuture.this);
                } else {
                    DefaultChannelGroupFuture.access$108(DefaultChannelGroupFuture.this);
                }
                callSetDone = DefaultChannelGroupFuture.this.successCount + DefaultChannelGroupFuture.this.failureCount == DefaultChannelGroupFuture.this.futures.size();
                if (!$assertionsDisabled && DefaultChannelGroupFuture.this.successCount + DefaultChannelGroupFuture.this.failureCount > DefaultChannelGroupFuture.this.futures.size()) {
                    throw new AssertionError();
                }
            }
            if (!callSetDone) {
                return;
            }
            if (DefaultChannelGroupFuture.this.failureCount > 0) {
                List<Map.Entry<Channel, Throwable>> failed = new ArrayList<>(DefaultChannelGroupFuture.this.failureCount);
                for (ChannelFuture f : DefaultChannelGroupFuture.this.futures.values()) {
                    if (!f.isSuccess()) {
                        failed.add(new DefaultEntry<>(f.channel(), f.cause()));
                    }
                }
                DefaultChannelGroupFuture.this.setFailure0(new ChannelGroupException(failed));
                return;
            }
            DefaultChannelGroupFuture.this.setSuccess0();
        }
    };

    static /* synthetic */ int access$008(DefaultChannelGroupFuture x0) {
        int i = x0.successCount;
        x0.successCount = i + 1;
        return i;
    }

    static /* synthetic */ int access$108(DefaultChannelGroupFuture x0) {
        int i = x0.failureCount;
        x0.failureCount = i + 1;
        return i;
    }

    DefaultChannelGroupFuture(ChannelGroup group, Collection<ChannelFuture> futures, EventExecutor executor) {
        super(executor);
        this.group = (ChannelGroup) ObjectUtil.checkNotNull(group, "group");
        ObjectUtil.checkNotNull(futures, "futures");
        Map<Channel, ChannelFuture> futureMap = new LinkedHashMap<>();
        for (ChannelFuture f : futures) {
            futureMap.put(f.channel(), f);
        }
        this.futures = Collections.unmodifiableMap(futureMap);
        for (ChannelFuture f2 : this.futures.values()) {
            f2.addListener((GenericFutureListener<? extends Future<? super Void>>) this.childListener);
        }
        if (this.futures.isEmpty()) {
            setSuccess0();
        }
    }

    /* access modifiers changed from: package-private */
    public DefaultChannelGroupFuture(ChannelGroup group, Map<Channel, ChannelFuture> futures, EventExecutor executor) {
        super(executor);
        this.group = group;
        this.futures = Collections.unmodifiableMap(futures);
        for (ChannelFuture f : this.futures.values()) {
            f.addListener((GenericFutureListener<? extends Future<? super Void>>) this.childListener);
        }
        if (this.futures.isEmpty()) {
            setSuccess0();
        }
    }

    @Override // p013io.netty.channel.group.ChannelGroupFuture
    public ChannelGroup group() {
        return this.group;
    }

    @Override // p013io.netty.channel.group.ChannelGroupFuture
    public ChannelFuture find(Channel channel) {
        return this.futures.get(channel);
    }

    @Override // p013io.netty.channel.group.ChannelGroupFuture, java.lang.Iterable
    public Iterator<ChannelFuture> iterator() {
        return this.futures.values().iterator();
    }

    @Override // p013io.netty.channel.group.ChannelGroupFuture
    public synchronized boolean isPartialSuccess() {
        return (this.successCount == 0 || this.successCount == this.futures.size()) ? false : true;
    }

    @Override // p013io.netty.channel.group.ChannelGroupFuture
    public synchronized boolean isPartialFailure() {
        return (this.failureCount == 0 || this.failureCount == this.futures.size()) ? false : true;
    }

    /* Return type fixed from 'io.netty.channel.group.DefaultChannelGroupFuture' to match base method */
    @Override // p013io.netty.util.concurrent.DefaultPromise, p013io.netty.util.concurrent.Future
    public Future<Void> addListener(GenericFutureListener<? extends Future<? super Void>> listener) {
        addListener((GenericFutureListener) listener);
        return this;
    }

    /* Return type fixed from 'io.netty.channel.group.DefaultChannelGroupFuture' to match base method */
    @Override // p013io.netty.util.concurrent.DefaultPromise, p013io.netty.util.concurrent.Future
    public Future<Void> addListeners(GenericFutureListener<? extends Future<? super Void>>... listeners) {
        addListeners((GenericFutureListener[]) listeners);
        return this;
    }

    /* Return type fixed from 'io.netty.channel.group.DefaultChannelGroupFuture' to match base method */
    @Override // p013io.netty.util.concurrent.DefaultPromise, p013io.netty.util.concurrent.Future
    public Future<Void> removeListener(GenericFutureListener<? extends Future<? super Void>> listener) {
        removeListener((GenericFutureListener) listener);
        return this;
    }

    /* Return type fixed from 'io.netty.channel.group.DefaultChannelGroupFuture' to match base method */
    @Override // p013io.netty.util.concurrent.DefaultPromise, p013io.netty.util.concurrent.Future
    public Future<Void> removeListeners(GenericFutureListener<? extends Future<? super Void>>... listeners) {
        removeListeners((GenericFutureListener[]) listeners);
        return this;
    }

    /* Return type fixed from 'io.netty.channel.group.DefaultChannelGroupFuture' to match base method */
    @Override // p013io.netty.util.concurrent.DefaultPromise, p013io.netty.util.concurrent.Future
    public Future<Void> await() throws InterruptedException {
        await();
        return this;
    }

    /* Return type fixed from 'io.netty.channel.group.DefaultChannelGroupFuture' to match base method */
    @Override // p013io.netty.util.concurrent.DefaultPromise, p013io.netty.util.concurrent.Future
    public Future<Void> awaitUninterruptibly() {
        awaitUninterruptibly();
        return this;
    }

    /* Return type fixed from 'io.netty.channel.group.DefaultChannelGroupFuture' to match base method */
    @Override // p013io.netty.util.concurrent.DefaultPromise, p013io.netty.util.concurrent.Future
    public Future<Void> syncUninterruptibly() {
        syncUninterruptibly();
        return this;
    }

    /* Return type fixed from 'io.netty.channel.group.DefaultChannelGroupFuture' to match base method */
    @Override // p013io.netty.util.concurrent.DefaultPromise, p013io.netty.util.concurrent.Future
    public Future<Void> sync() throws InterruptedException {
        sync();
        return this;
    }

    @Override // p013io.netty.util.concurrent.DefaultPromise, p013io.netty.util.concurrent.Future
    public ChannelGroupException cause() {
        return (ChannelGroupException) cause();
    }

    /* access modifiers changed from: private */
    public void setSuccess0() {
        setSuccess((DefaultChannelGroupFuture) null);
    }

    /* access modifiers changed from: private */
    public void setFailure0(ChannelGroupException cause) {
        setFailure((Throwable) cause);
    }

    public DefaultChannelGroupFuture setSuccess(Void result) {
        throw new IllegalStateException();
    }

    public boolean trySuccess(Void result) {
        throw new IllegalStateException();
    }

    @Override // p013io.netty.util.concurrent.DefaultPromise, p013io.netty.util.concurrent.Promise, p013io.netty.channel.ChannelPromise
    public DefaultChannelGroupFuture setFailure(Throwable cause) {
        throw new IllegalStateException();
    }

    @Override // p013io.netty.util.concurrent.DefaultPromise, p013io.netty.util.concurrent.Promise
    public boolean tryFailure(Throwable cause) {
        throw new IllegalStateException();
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.util.concurrent.DefaultPromise
    public void checkDeadLock() {
        EventExecutor e = executor();
        if (e != null && e != ImmediateEventExecutor.INSTANCE && e.inEventLoop()) {
            throw new BlockingOperationException();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.channel.group.DefaultChannelGroupFuture$DefaultEntry */
    /* loaded from: grasscutter.jar:io/netty/channel/group/DefaultChannelGroupFuture$DefaultEntry.class */
    public static final class DefaultEntry<K, V> implements Map.Entry<K, V> {
        private final K key;
        private final V value;

        DefaultEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public V setValue(V value) {
            throw new UnsupportedOperationException("read-only");
        }
    }
}
