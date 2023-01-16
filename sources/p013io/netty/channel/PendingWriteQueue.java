package p013io.netty.channel;

import p013io.netty.util.ReferenceCountUtil;
import p013io.netty.util.concurrent.EventExecutor;
import p013io.netty.util.concurrent.Promise;
import p013io.netty.util.concurrent.PromiseCombiner;
import p013io.netty.util.internal.ObjectPool;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.SystemPropertyUtil;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

/* renamed from: io.netty.channel.PendingWriteQueue */
/* loaded from: grasscutter.jar:io/netty/channel/PendingWriteQueue.class */
public final class PendingWriteQueue {
    private static final InternalLogger logger;
    private static final int PENDING_WRITE_OVERHEAD;
    private final ChannelOutboundInvoker invoker;
    private final EventExecutor executor;
    private final PendingBytesTracker tracker;
    private PendingWrite head;
    private PendingWrite tail;
    private int size;
    private long bytes;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !PendingWriteQueue.class.desiredAssertionStatus();
        logger = InternalLoggerFactory.getInstance(PendingWriteQueue.class);
        PENDING_WRITE_OVERHEAD = SystemPropertyUtil.getInt("io.netty.transport.pendingWriteSizeOverhead", 64);
    }

    public PendingWriteQueue(ChannelHandlerContext ctx) {
        this.tracker = PendingBytesTracker.newTracker(ctx.channel());
        this.invoker = ctx;
        this.executor = ctx.executor();
    }

    public PendingWriteQueue(Channel channel) {
        this.tracker = PendingBytesTracker.newTracker(channel);
        this.invoker = channel;
        this.executor = channel.eventLoop();
    }

    public boolean isEmpty() {
        if ($assertionsDisabled || this.executor.inEventLoop()) {
            return this.head == null;
        }
        throw new AssertionError();
    }

    public int size() {
        if ($assertionsDisabled || this.executor.inEventLoop()) {
            return this.size;
        }
        throw new AssertionError();
    }

    public long bytes() {
        if ($assertionsDisabled || this.executor.inEventLoop()) {
            return this.bytes;
        }
        throw new AssertionError();
    }

    private int size(Object msg) {
        int messageSize = this.tracker.size(msg);
        if (messageSize < 0) {
            messageSize = 0;
        }
        return messageSize + PENDING_WRITE_OVERHEAD;
    }

    public void add(Object msg, ChannelPromise promise) {
        if ($assertionsDisabled || this.executor.inEventLoop()) {
            ObjectUtil.checkNotNull(msg, "msg");
            ObjectUtil.checkNotNull(promise, "promise");
            int messageSize = size(msg);
            PendingWrite write = PendingWrite.newInstance(msg, messageSize, promise);
            PendingWrite currentTail = this.tail;
            if (currentTail == null) {
                this.head = write;
                this.tail = write;
            } else {
                currentTail.next = write;
                this.tail = write;
            }
            this.size++;
            this.bytes += (long) messageSize;
            this.tracker.incrementPendingOutboundBytes(write.size);
            return;
        }
        throw new AssertionError();
    }

    public ChannelFuture removeAndWriteAll() {
        if (!$assertionsDisabled && !this.executor.inEventLoop()) {
            throw new AssertionError();
        } else if (isEmpty()) {
            return null;
        } else {
            ChannelPromise p = this.invoker.newPromise();
            PromiseCombiner combiner = new PromiseCombiner(this.executor);
            try {
                PendingWrite write = this.head;
                while (write != null) {
                    this.tail = null;
                    this.head = null;
                    this.size = 0;
                    this.bytes = 0;
                    while (write != null) {
                        PendingWrite next = write.next;
                        Object msg = write.msg;
                        ChannelPromise promise = write.promise;
                        recycle(write, false);
                        if (!(promise instanceof VoidChannelPromise)) {
                            combiner.add((Promise) promise);
                        }
                        this.invoker.write(msg, promise);
                        write = next;
                    }
                    write = this.head;
                }
                combiner.finish(p);
            } catch (Throwable cause) {
                p.setFailure(cause);
            }
            assertEmpty();
            return p;
        }
    }

    public void removeAndFailAll(Throwable cause) {
        if ($assertionsDisabled || this.executor.inEventLoop()) {
            ObjectUtil.checkNotNull(cause, "cause");
            PendingWrite write = this.head;
            while (write != null) {
                this.tail = null;
                this.head = null;
                this.size = 0;
                this.bytes = 0;
                while (write != null) {
                    PendingWrite next = write.next;
                    ReferenceCountUtil.safeRelease(write.msg);
                    ChannelPromise promise = write.promise;
                    recycle(write, false);
                    safeFail(promise, cause);
                    write = next;
                }
                write = this.head;
            }
            assertEmpty();
            return;
        }
        throw new AssertionError();
    }

    public void removeAndFail(Throwable cause) {
        if ($assertionsDisabled || this.executor.inEventLoop()) {
            ObjectUtil.checkNotNull(cause, "cause");
            PendingWrite write = this.head;
            if (write != null) {
                ReferenceCountUtil.safeRelease(write.msg);
                safeFail(write.promise, cause);
                recycle(write, true);
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    private void assertEmpty() {
        if ($assertionsDisabled) {
            return;
        }
        if (this.tail != null || this.head != null || this.size != 0) {
            throw new AssertionError();
        }
    }

    public ChannelFuture removeAndWrite() {
        if ($assertionsDisabled || this.executor.inEventLoop()) {
            PendingWrite write = this.head;
            if (write == null) {
                return null;
            }
            Object msg = write.msg;
            ChannelPromise promise = write.promise;
            recycle(write, true);
            return this.invoker.write(msg, promise);
        }
        throw new AssertionError();
    }

    public ChannelPromise remove() {
        if ($assertionsDisabled || this.executor.inEventLoop()) {
            PendingWrite write = this.head;
            if (write == null) {
                return null;
            }
            ChannelPromise promise = write.promise;
            ReferenceCountUtil.safeRelease(write.msg);
            recycle(write, true);
            return promise;
        }
        throw new AssertionError();
    }

    public Object current() {
        if ($assertionsDisabled || this.executor.inEventLoop()) {
            PendingWrite write = this.head;
            if (write == null) {
                return null;
            }
            return write.msg;
        }
        throw new AssertionError();
    }

    private void recycle(PendingWrite write, boolean update) {
        PendingWrite next = write.next;
        long writeSize = write.size;
        if (update) {
            if (next == null) {
                this.tail = null;
                this.head = null;
                this.size = 0;
                this.bytes = 0;
            } else {
                this.head = next;
                this.size--;
                this.bytes -= writeSize;
                if (!$assertionsDisabled && (this.size <= 0 || this.bytes < 0)) {
                    throw new AssertionError();
                }
            }
        }
        write.recycle();
        this.tracker.decrementPendingOutboundBytes(writeSize);
    }

    private static void safeFail(ChannelPromise promise, Throwable cause) {
        if (!(promise instanceof VoidChannelPromise) && !promise.tryFailure(cause)) {
            logger.warn("Failed to mark a promise as failure because it's done already: {}", promise, cause);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: io.netty.channel.PendingWriteQueue$PendingWrite */
    /* loaded from: grasscutter.jar:io/netty/channel/PendingWriteQueue$PendingWrite.class */
    public static final class PendingWrite {
        private static final ObjectPool<PendingWrite> RECYCLER = ObjectPool.newPool(new ObjectPool.ObjectCreator<PendingWrite>() { // from class: io.netty.channel.PendingWriteQueue.PendingWrite.1
            @Override // p013io.netty.util.internal.ObjectPool.ObjectCreator
            public PendingWrite newObject(ObjectPool.Handle<PendingWrite> handle) {
                return new PendingWrite(handle);
            }
        });
        private final ObjectPool.Handle<PendingWrite> handle;
        private PendingWrite next;
        private long size;
        private ChannelPromise promise;
        private Object msg;

        private PendingWrite(ObjectPool.Handle<PendingWrite> handle) {
            this.handle = handle;
        }

        static PendingWrite newInstance(Object msg, int size, ChannelPromise promise) {
            PendingWrite write = RECYCLER.get();
            write.size = (long) size;
            write.msg = msg;
            write.promise = promise;
            return write;
        }

        /* access modifiers changed from: private */
        public void recycle() {
            this.size = 0;
            this.next = null;
            this.msg = null;
            this.promise = null;
            this.handle.recycle(this);
        }
    }
}
