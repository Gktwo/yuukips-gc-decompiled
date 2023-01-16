package p013io.netty.channel.pool;

import java.util.Deque;
import java.util.concurrent.Callable;
import p013io.netty.bootstrap.Bootstrap;
import p013io.netty.channel.Channel;
import p013io.netty.channel.ChannelFuture;
import p013io.netty.channel.ChannelFutureListener;
import p013io.netty.channel.ChannelInitializer;
import p013io.netty.channel.EventLoop;
import p013io.netty.util.AttributeKey;
import p013io.netty.util.concurrent.Future;
import p013io.netty.util.concurrent.FutureListener;
import p013io.netty.util.concurrent.GenericFutureListener;
import p013io.netty.util.concurrent.GlobalEventExecutor;
import p013io.netty.util.concurrent.Promise;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.PlatformDependent;

/* renamed from: io.netty.channel.pool.SimpleChannelPool */
/* loaded from: grasscutter.jar:io/netty/channel/pool/SimpleChannelPool.class */
public class SimpleChannelPool implements ChannelPool {
    private static final AttributeKey<SimpleChannelPool> POOL_KEY;
    private final Deque<Channel> deque;
    private final ChannelPoolHandler handler;
    private final ChannelHealthChecker healthCheck;
    private final Bootstrap bootstrap;
    private final boolean releaseHealthCheck;
    private final boolean lastRecentUsed;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !SimpleChannelPool.class.desiredAssertionStatus();
        POOL_KEY = AttributeKey.newInstance("io.netty.channel.pool.SimpleChannelPool");
    }

    public SimpleChannelPool(Bootstrap bootstrap, ChannelPoolHandler handler) {
        this(bootstrap, handler, ChannelHealthChecker.ACTIVE);
    }

    public SimpleChannelPool(Bootstrap bootstrap, ChannelPoolHandler handler, ChannelHealthChecker healthCheck) {
        this(bootstrap, handler, healthCheck, true);
    }

    public SimpleChannelPool(Bootstrap bootstrap, ChannelPoolHandler handler, ChannelHealthChecker healthCheck, boolean releaseHealthCheck) {
        this(bootstrap, handler, healthCheck, releaseHealthCheck, true);
    }

    public SimpleChannelPool(Bootstrap bootstrap, final ChannelPoolHandler handler, ChannelHealthChecker healthCheck, boolean releaseHealthCheck, boolean lastRecentUsed) {
        this.deque = PlatformDependent.newConcurrentDeque();
        this.handler = (ChannelPoolHandler) ObjectUtil.checkNotNull(handler, "handler");
        this.healthCheck = (ChannelHealthChecker) ObjectUtil.checkNotNull(healthCheck, "healthCheck");
        this.releaseHealthCheck = releaseHealthCheck;
        this.bootstrap = ((Bootstrap) ObjectUtil.checkNotNull(bootstrap, "bootstrap")).clone();
        this.bootstrap.handler(new ChannelInitializer<Channel>() { // from class: io.netty.channel.pool.SimpleChannelPool.1
            static final /* synthetic */ boolean $assertionsDisabled;

            static {
                $assertionsDisabled = !SimpleChannelPool.class.desiredAssertionStatus();
            }

            @Override // p013io.netty.channel.ChannelInitializer
            protected void initChannel(Channel ch) throws Exception {
                if ($assertionsDisabled || ch.eventLoop().inEventLoop()) {
                    handler.channelCreated(ch);
                    return;
                }
                throw new AssertionError();
            }
        });
        this.lastRecentUsed = lastRecentUsed;
    }

    protected Bootstrap bootstrap() {
        return this.bootstrap;
    }

    protected ChannelPoolHandler handler() {
        return this.handler;
    }

    protected ChannelHealthChecker healthChecker() {
        return this.healthCheck;
    }

    protected boolean releaseHealthCheck() {
        return this.releaseHealthCheck;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [io.netty.bootstrap.BootstrapConfig] */
    @Override // p013io.netty.channel.pool.ChannelPool
    public final Future<Channel> acquire() {
        return acquire(this.bootstrap.config().group().next().newPromise());
    }

    @Override // p013io.netty.channel.pool.ChannelPool
    public Future<Channel> acquire(Promise<Channel> promise) {
        return acquireHealthyFromPoolOrNew((Promise) ObjectUtil.checkNotNull(promise, "promise"));
    }

    private Future<Channel> acquireHealthyFromPoolOrNew(final Promise<Channel> promise) {
        try {
            final Channel ch = pollChannel();
            if (ch == null) {
                Bootstrap bs = this.bootstrap.clone();
                bs.attr(POOL_KEY, this);
                ChannelFuture f = connectChannel(bs);
                if (f.isDone()) {
                    notifyConnect(f, promise);
                } else {
                    f.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.channel.pool.SimpleChannelPool.2
                        public void operationComplete(ChannelFuture future) throws Exception {
                            SimpleChannelPool.this.notifyConnect(future, promise);
                        }
                    });
                }
            } else {
                EventLoop loop = ch.eventLoop();
                if (loop.inEventLoop()) {
                    doHealthCheck(ch, promise);
                } else {
                    loop.execute(new Runnable() { // from class: io.netty.channel.pool.SimpleChannelPool.3
                        @Override // java.lang.Runnable
                        public void run() {
                            SimpleChannelPool.this.doHealthCheck(ch, promise);
                        }
                    });
                }
            }
        } catch (Throwable cause) {
            promise.tryFailure(cause);
        }
        return promise;
    }

    /* access modifiers changed from: private */
    public void notifyConnect(ChannelFuture future, Promise<Channel> promise) {
        try {
            if (future.isSuccess()) {
                Channel channel = future.channel();
                this.handler.channelAcquired(channel);
                if (!promise.trySuccess(channel)) {
                    release(channel);
                }
            } else {
                promise.tryFailure(future.cause());
            }
        } catch (Throwable cause) {
            closeAndFail(null, cause, promise);
        }
    }

    /* access modifiers changed from: private */
    public void doHealthCheck(final Channel channel, final Promise<Channel> promise) {
        try {
            if ($assertionsDisabled || channel.eventLoop().inEventLoop()) {
                Future<Boolean> f = this.healthCheck.isHealthy(channel);
                if (f.isDone()) {
                    notifyHealthCheck(f, channel, promise);
                } else {
                    f.addListener(new FutureListener<Boolean>() { // from class: io.netty.channel.pool.SimpleChannelPool.4
                        @Override // p013io.netty.util.concurrent.GenericFutureListener
                        public void operationComplete(Future<Boolean> future) {
                            SimpleChannelPool.this.notifyHealthCheck(future, channel, promise);
                        }
                    });
                }
                return;
            }
            throw new AssertionError();
        } catch (Throwable cause) {
            closeAndFail(channel, cause, promise);
        }
    }

    /* access modifiers changed from: private */
    public void notifyHealthCheck(Future<Boolean> future, Channel channel, Promise<Channel> promise) {
        try {
            if ($assertionsDisabled || channel.eventLoop().inEventLoop()) {
                if (!future.isSuccess() || !future.getNow().booleanValue()) {
                    closeChannel(channel);
                    acquireHealthyFromPoolOrNew(promise);
                } else {
                    channel.attr(POOL_KEY).set(this);
                    this.handler.channelAcquired(channel);
                    promise.setSuccess(channel);
                }
                return;
            }
            throw new AssertionError();
        } catch (Throwable cause) {
            closeAndFail(channel, cause, promise);
        }
    }

    protected ChannelFuture connectChannel(Bootstrap bs) {
        return bs.connect();
    }

    @Override // p013io.netty.channel.pool.ChannelPool
    public final Future<Void> release(Channel channel) {
        return release(channel, channel.eventLoop().newPromise());
    }

    @Override // p013io.netty.channel.pool.ChannelPool
    public Future<Void> release(final Channel channel, final Promise<Void> promise) {
        try {
            ObjectUtil.checkNotNull(channel, "channel");
            ObjectUtil.checkNotNull(promise, "promise");
            EventLoop loop = channel.eventLoop();
            if (loop.inEventLoop()) {
                doReleaseChannel(channel, promise);
            } else {
                loop.execute(new Runnable() { // from class: io.netty.channel.pool.SimpleChannelPool.5
                    @Override // java.lang.Runnable
                    public void run() {
                        SimpleChannelPool.this.doReleaseChannel(channel, promise);
                    }
                });
            }
        } catch (Throwable cause) {
            closeAndFail(channel, cause, promise);
        }
        return promise;
    }

    /* access modifiers changed from: private */
    public void doReleaseChannel(Channel channel, Promise<Void> promise) {
        try {
            if ($assertionsDisabled || channel.eventLoop().inEventLoop()) {
                if (channel.attr(POOL_KEY).getAndSet(null) != this) {
                    closeAndFail(channel, new IllegalArgumentException("Channel " + channel + " was not acquired from this ChannelPool"), promise);
                } else if (this.releaseHealthCheck) {
                    doHealthCheckOnRelease(channel, promise);
                } else {
                    releaseAndOffer(channel, promise);
                }
                return;
            }
            throw new AssertionError();
        } catch (Throwable cause) {
            closeAndFail(channel, cause, promise);
        }
    }

    private void doHealthCheckOnRelease(final Channel channel, final Promise<Void> promise) throws Exception {
        final Future<Boolean> f = this.healthCheck.isHealthy(channel);
        if (f.isDone()) {
            releaseAndOfferIfHealthy(channel, promise, f);
        } else {
            f.addListener(new FutureListener<Boolean>() { // from class: io.netty.channel.pool.SimpleChannelPool.6
                @Override // p013io.netty.util.concurrent.GenericFutureListener
                public void operationComplete(Future<Boolean> future) throws Exception {
                    SimpleChannelPool.this.releaseAndOfferIfHealthy(channel, promise, f);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void releaseAndOfferIfHealthy(Channel channel, Promise<Void> promise, Future<Boolean> future) {
        try {
            if (future.getNow().booleanValue()) {
                releaseAndOffer(channel, promise);
            } else {
                this.handler.channelReleased(channel);
                promise.setSuccess(null);
            }
        } catch (Throwable cause) {
            closeAndFail(channel, cause, promise);
        }
    }

    private void releaseAndOffer(Channel channel, Promise<Void> promise) throws Exception {
        if (offerChannel(channel)) {
            this.handler.channelReleased(channel);
            promise.setSuccess(null);
            return;
        }
        closeAndFail(channel, new ChannelPoolFullException(), promise);
    }

    private void closeChannel(Channel channel) throws Exception {
        channel.attr(POOL_KEY).getAndSet(null);
        channel.close();
    }

    private void closeAndFail(Channel channel, Throwable cause, Promise<?> promise) {
        if (channel != null) {
            try {
                closeChannel(channel);
            } catch (Throwable t) {
                promise.tryFailure(t);
            }
        }
        promise.tryFailure(cause);
    }

    protected Channel pollChannel() {
        return this.lastRecentUsed ? this.deque.pollLast() : this.deque.pollFirst();
    }

    protected boolean offerChannel(Channel channel) {
        return this.deque.offer(channel);
    }

    @Override // p013io.netty.channel.pool.ChannelPool, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        while (true) {
            Channel channel = pollChannel();
            if (channel != null) {
                channel.close().awaitUninterruptibly();
            } else {
                return;
            }
        }
    }

    public Future<Void> closeAsync() {
        return GlobalEventExecutor.INSTANCE.submit((Callable) new Callable<Void>() { // from class: io.netty.channel.pool.SimpleChannelPool.7
            @Override // java.util.concurrent.Callable
            public Void call() throws Exception {
                SimpleChannelPool.this.close();
                return null;
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.channel.pool.SimpleChannelPool$ChannelPoolFullException */
    /* loaded from: grasscutter.jar:io/netty/channel/pool/SimpleChannelPool$ChannelPoolFullException.class */
    public static final class ChannelPoolFullException extends IllegalStateException {
        private ChannelPoolFullException() {
            super("ChannelPool full");
        }

        @Override // java.lang.Throwable
        public Throwable fillInStackTrace() {
            return this;
        }
    }
}
