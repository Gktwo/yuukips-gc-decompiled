package p013io.netty.channel.pool;

import java.nio.channels.ClosedChannelException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import p013io.netty.bootstrap.Bootstrap;
import p013io.netty.channel.Channel;
import p013io.netty.util.concurrent.EventExecutor;
import p013io.netty.util.concurrent.Future;
import p013io.netty.util.concurrent.FutureListener;
import p013io.netty.util.concurrent.GenericFutureListener;
import p013io.netty.util.concurrent.GlobalEventExecutor;
import p013io.netty.util.concurrent.Promise;
import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.channel.pool.FixedChannelPool */
/* loaded from: grasscutter.jar:io/netty/channel/pool/FixedChannelPool.class */
public class FixedChannelPool extends SimpleChannelPool {
    private final EventExecutor executor;
    private final long acquireTimeoutNanos;
    private final Runnable timeoutTask;
    private final Queue<AcquireTask> pendingAcquireQueue;
    private final int maxConnections;
    private final int maxPendingAcquires;
    private final AtomicInteger acquiredChannelCount;
    private int pendingAcquireCount;
    private boolean closed;
    static final /* synthetic */ boolean $assertionsDisabled;

    /* renamed from: io.netty.channel.pool.FixedChannelPool$AcquireTimeoutAction */
    /* loaded from: grasscutter.jar:io/netty/channel/pool/FixedChannelPool$AcquireTimeoutAction.class */
    public enum AcquireTimeoutAction {
        NEW,
        FAIL
    }

    static /* synthetic */ int access$906(FixedChannelPool x0) {
        int i = x0.pendingAcquireCount - 1;
        x0.pendingAcquireCount = i;
        return i;
    }

    static {
        $assertionsDisabled = !FixedChannelPool.class.desiredAssertionStatus();
    }

    public FixedChannelPool(Bootstrap bootstrap, ChannelPoolHandler handler, int maxConnections) {
        this(bootstrap, handler, maxConnections, Integer.MAX_VALUE);
    }

    public FixedChannelPool(Bootstrap bootstrap, ChannelPoolHandler handler, int maxConnections, int maxPendingAcquires) {
        this(bootstrap, handler, ChannelHealthChecker.ACTIVE, null, -1, maxConnections, maxPendingAcquires);
    }

    public FixedChannelPool(Bootstrap bootstrap, ChannelPoolHandler handler, ChannelHealthChecker healthCheck, AcquireTimeoutAction action, long acquireTimeoutMillis, int maxConnections, int maxPendingAcquires) {
        this(bootstrap, handler, healthCheck, action, acquireTimeoutMillis, maxConnections, maxPendingAcquires, true);
    }

    public FixedChannelPool(Bootstrap bootstrap, ChannelPoolHandler handler, ChannelHealthChecker healthCheck, AcquireTimeoutAction action, long acquireTimeoutMillis, int maxConnections, int maxPendingAcquires, boolean releaseHealthCheck) {
        this(bootstrap, handler, healthCheck, action, acquireTimeoutMillis, maxConnections, maxPendingAcquires, releaseHealthCheck, true);
    }

    /* JADX WARN: Type inference failed for: r1v6, types: [io.netty.bootstrap.BootstrapConfig] */
    public FixedChannelPool(Bootstrap bootstrap, ChannelPoolHandler handler, ChannelHealthChecker healthCheck, AcquireTimeoutAction action, long acquireTimeoutMillis, int maxConnections, int maxPendingAcquires, boolean releaseHealthCheck, boolean lastRecentUsed) {
        super(bootstrap, handler, healthCheck, releaseHealthCheck, lastRecentUsed);
        this.pendingAcquireQueue = new ArrayDeque();
        this.acquiredChannelCount = new AtomicInteger();
        ObjectUtil.checkPositive(maxConnections, "maxConnections");
        ObjectUtil.checkPositive(maxPendingAcquires, "maxPendingAcquires");
        if (action == null && acquireTimeoutMillis == -1) {
            this.timeoutTask = null;
            this.acquireTimeoutNanos = -1;
        } else if (action == null && acquireTimeoutMillis != -1) {
            throw new NullPointerException("action");
        } else if (action == null || acquireTimeoutMillis >= 0) {
            this.acquireTimeoutNanos = TimeUnit.MILLISECONDS.toNanos(acquireTimeoutMillis);
            switch (action) {
                case FAIL:
                    this.timeoutTask = new TimeoutTask() { // from class: io.netty.channel.pool.FixedChannelPool.1
                        @Override // p013io.netty.channel.pool.FixedChannelPool.TimeoutTask
                        public void onTimeout(AcquireTask task) {
                            task.promise.setFailure(new AcquireTimeoutException());
                        }
                    };
                    break;
                case NEW:
                    this.timeoutTask = new TimeoutTask() { // from class: io.netty.channel.pool.FixedChannelPool.2
                        @Override // p013io.netty.channel.pool.FixedChannelPool.TimeoutTask
                        public void onTimeout(AcquireTask task) {
                            task.acquired();
                            FixedChannelPool.this.acquire(task.promise);
                        }
                    };
                    break;
                default:
                    throw new Error();
            }
        } else {
            throw new IllegalArgumentException("acquireTimeoutMillis: " + acquireTimeoutMillis + " (expected: >= 0)");
        }
        this.executor = bootstrap.config().group().next();
        this.maxConnections = maxConnections;
        this.maxPendingAcquires = maxPendingAcquires;
    }

    public int acquiredChannelCount() {
        return this.acquiredChannelCount.get();
    }

    @Override // p013io.netty.channel.pool.SimpleChannelPool, p013io.netty.channel.pool.ChannelPool
    public Future<Channel> acquire(final Promise<Channel> promise) {
        try {
            if (this.executor.inEventLoop()) {
                acquire0(promise);
            } else {
                this.executor.execute(new Runnable() { // from class: io.netty.channel.pool.FixedChannelPool.3
                    @Override // java.lang.Runnable
                    public void run() {
                        FixedChannelPool.this.acquire0(promise);
                    }
                });
            }
        } catch (Throwable cause) {
            promise.tryFailure(cause);
        }
        return promise;
    }

    /* access modifiers changed from: private */
    public void acquire0(Promise<Channel> promise) {
        try {
            if (!$assertionsDisabled && !this.executor.inEventLoop()) {
                throw new AssertionError();
            } else if (this.closed) {
                promise.setFailure(new IllegalStateException("FixedChannelPool was closed"));
            } else {
                if (this.acquiredChannelCount.get() >= this.maxConnections) {
                    if (this.pendingAcquireCount >= this.maxPendingAcquires) {
                        tooManyOutstanding(promise);
                    } else {
                        AcquireTask task = new AcquireTask(promise);
                        if (this.pendingAcquireQueue.offer(task)) {
                            this.pendingAcquireCount++;
                            if (this.timeoutTask != null) {
                                task.timeoutFuture = this.executor.schedule(this.timeoutTask, this.acquireTimeoutNanos, TimeUnit.NANOSECONDS);
                            }
                        } else {
                            tooManyOutstanding(promise);
                        }
                    }
                    if (!$assertionsDisabled && this.pendingAcquireCount <= 0) {
                        throw new AssertionError();
                    }
                } else if ($assertionsDisabled || this.acquiredChannelCount.get() >= 0) {
                    Promise<Channel> p = this.executor.newPromise();
                    AcquireListener l = new AcquireListener(promise);
                    l.acquired();
                    p.addListener((GenericFutureListener<? extends Future<? super Channel>>) l);
                    acquire(p);
                } else {
                    throw new AssertionError();
                }
            }
        } catch (Throwable cause) {
            promise.tryFailure(cause);
        }
    }

    private void tooManyOutstanding(Promise<?> promise) {
        promise.setFailure(new IllegalStateException("Too many outstanding acquire operations"));
    }

    @Override // p013io.netty.channel.pool.SimpleChannelPool, p013io.netty.channel.pool.ChannelPool
    public Future<Void> release(final Channel channel, final Promise<Void> promise) {
        ObjectUtil.checkNotNull(promise, "promise");
        release(channel, this.executor.newPromise().addListener(new FutureListener<Void>() { // from class: io.netty.channel.pool.FixedChannelPool.4
            static final /* synthetic */ boolean $assertionsDisabled;

            static {
                $assertionsDisabled = !FixedChannelPool.class.desiredAssertionStatus();
            }

            @Override // p013io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future<Void> future) {
                try {
                    if (!$assertionsDisabled && !FixedChannelPool.this.executor.inEventLoop()) {
                        throw new AssertionError();
                    } else if (FixedChannelPool.this.closed) {
                        channel.close();
                        promise.setFailure(new IllegalStateException("FixedChannelPool was closed"));
                    } else {
                        if (future.isSuccess()) {
                            FixedChannelPool.this.decrementAndRunTaskQueue();
                            promise.setSuccess(null);
                        } else {
                            if (!(future.cause() instanceof IllegalArgumentException)) {
                                FixedChannelPool.this.decrementAndRunTaskQueue();
                            }
                            promise.setFailure(future.cause());
                        }
                    }
                } catch (Throwable cause) {
                    promise.tryFailure(cause);
                }
            }
        }));
        return promise;
    }

    /* access modifiers changed from: private */
    public void decrementAndRunTaskQueue() {
        int currentCount = this.acquiredChannelCount.decrementAndGet();
        if ($assertionsDisabled || currentCount >= 0) {
            runTaskQueue();
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: private */
    public void runTaskQueue() {
        AcquireTask task;
        while (this.acquiredChannelCount.get() < this.maxConnections && (task = this.pendingAcquireQueue.poll()) != null) {
            ScheduledFuture<?> timeoutFuture = task.timeoutFuture;
            if (timeoutFuture != null) {
                timeoutFuture.cancel(false);
            }
            this.pendingAcquireCount--;
            task.acquired();
            acquire(task.promise);
        }
        if (!$assertionsDisabled && this.pendingAcquireCount < 0) {
            throw new AssertionError();
        } else if (!$assertionsDisabled && this.acquiredChannelCount.get() < 0) {
            throw new AssertionError();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.channel.pool.FixedChannelPool$AcquireTask */
    /* loaded from: grasscutter.jar:io/netty/channel/pool/FixedChannelPool$AcquireTask.class */
    public final class AcquireTask extends AcquireListener {
        final Promise<Channel> promise;
        final long expireNanoTime;
        ScheduledFuture<?> timeoutFuture;

        AcquireTask(Promise<Channel> promise) {
            super(promise);
            this.expireNanoTime = System.nanoTime() + FixedChannelPool.this.acquireTimeoutNanos;
            this.promise = FixedChannelPool.this.executor.newPromise().addListener((GenericFutureListener) this);
        }
    }

    /* renamed from: io.netty.channel.pool.FixedChannelPool$TimeoutTask */
    /* loaded from: grasscutter.jar:io/netty/channel/pool/FixedChannelPool$TimeoutTask.class */
    private abstract class TimeoutTask implements Runnable {
        static final /* synthetic */ boolean $assertionsDisabled;

        public abstract void onTimeout(AcquireTask acquireTask);

        private TimeoutTask() {
        }

        static {
            $assertionsDisabled = !FixedChannelPool.class.desiredAssertionStatus();
        }

        @Override // java.lang.Runnable
        public final void run() {
            if ($assertionsDisabled || FixedChannelPool.this.executor.inEventLoop()) {
                long nanoTime = System.nanoTime();
                while (true) {
                    AcquireTask task = (AcquireTask) FixedChannelPool.this.pendingAcquireQueue.peek();
                    if (task != null && nanoTime - task.expireNanoTime >= 0) {
                        FixedChannelPool.this.pendingAcquireQueue.remove();
                        FixedChannelPool.access$906(FixedChannelPool.this);
                        onTimeout(task);
                    } else {
                        return;
                    }
                }
            } else {
                throw new AssertionError();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.channel.pool.FixedChannelPool$AcquireListener */
    /* loaded from: grasscutter.jar:io/netty/channel/pool/FixedChannelPool$AcquireListener.class */
    public class AcquireListener implements FutureListener<Channel> {
        private final Promise<Channel> originalPromise;
        protected boolean acquired;
        static final /* synthetic */ boolean $assertionsDisabled;

        static {
            $assertionsDisabled = !FixedChannelPool.class.desiredAssertionStatus();
        }

        AcquireListener(Promise<Channel> originalPromise) {
            this.originalPromise = originalPromise;
        }

        @Override // p013io.netty.util.concurrent.GenericFutureListener
        public void operationComplete(Future<Channel> future) throws Exception {
            try {
                if (!$assertionsDisabled && !FixedChannelPool.this.executor.inEventLoop()) {
                    throw new AssertionError();
                } else if (FixedChannelPool.this.closed) {
                    if (future.isSuccess()) {
                        future.getNow().close();
                    }
                    this.originalPromise.setFailure(new IllegalStateException("FixedChannelPool was closed"));
                } else {
                    if (future.isSuccess()) {
                        this.originalPromise.setSuccess(future.getNow());
                    } else {
                        if (this.acquired) {
                            FixedChannelPool.this.decrementAndRunTaskQueue();
                        } else {
                            FixedChannelPool.this.runTaskQueue();
                        }
                        this.originalPromise.setFailure(future.cause());
                    }
                }
            } catch (Throwable cause) {
                this.originalPromise.tryFailure(cause);
            }
        }

        public void acquired() {
            if (!this.acquired) {
                FixedChannelPool.this.acquiredChannelCount.incrementAndGet();
                this.acquired = true;
            }
        }
    }

    @Override // p013io.netty.channel.pool.SimpleChannelPool, p013io.netty.channel.pool.ChannelPool, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            closeAsync().await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    @Override // p013io.netty.channel.pool.SimpleChannelPool
    public Future<Void> closeAsync() {
        if (this.executor.inEventLoop()) {
            return close0();
        }
        final Promise<Void> closeComplete = this.executor.newPromise();
        this.executor.execute(new Runnable() { // from class: io.netty.channel.pool.FixedChannelPool.5
            @Override // java.lang.Runnable
            public void run() {
                FixedChannelPool.this.close0().addListener(new FutureListener<Void>() { // from class: io.netty.channel.pool.FixedChannelPool.5.1
                    @Override // p013io.netty.util.concurrent.GenericFutureListener
                    public void operationComplete(Future<Void> f) throws Exception {
                        if (f.isSuccess()) {
                            closeComplete.setSuccess(null);
                        } else {
                            closeComplete.setFailure(f.cause());
                        }
                    }
                });
            }
        });
        return closeComplete;
    }

    /* access modifiers changed from: private */
    public Future<Void> close0() {
        if (!$assertionsDisabled && !this.executor.inEventLoop()) {
            throw new AssertionError();
        } else if (this.closed) {
            return GlobalEventExecutor.INSTANCE.newSucceededFuture(null);
        } else {
            this.closed = true;
            while (true) {
                AcquireTask task = this.pendingAcquireQueue.poll();
                if (task == null) {
                    this.acquiredChannelCount.set(0);
                    this.pendingAcquireCount = 0;
                    return GlobalEventExecutor.INSTANCE.submit((Callable) new Callable<Void>() { // from class: io.netty.channel.pool.FixedChannelPool.6
                        @Override // java.util.concurrent.Callable
                        public Void call() throws Exception {
                            FixedChannelPool.this.close();
                            return null;
                        }
                    });
                }
                ScheduledFuture<?> f = task.timeoutFuture;
                if (f != null) {
                    f.cancel(false);
                }
                task.promise.setFailure(new ClosedChannelException());
            }
        }
    }

    /* renamed from: io.netty.channel.pool.FixedChannelPool$AcquireTimeoutException */
    /* loaded from: grasscutter.jar:io/netty/channel/pool/FixedChannelPool$AcquireTimeoutException.class */
    private static final class AcquireTimeoutException extends TimeoutException {
        private AcquireTimeoutException() {
            super("Acquire operation took longer then configured maximum time");
        }

        @Override // java.lang.Throwable
        public Throwable fillInStackTrace() {
            return this;
        }
    }
}
