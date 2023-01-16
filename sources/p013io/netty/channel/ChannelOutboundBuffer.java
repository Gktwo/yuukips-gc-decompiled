package p013io.netty.channel;

import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.buffer.ByteBufHolder;
import p013io.netty.buffer.Unpooled;
import p013io.netty.util.ReferenceCountUtil;
import p013io.netty.util.concurrent.FastThreadLocal;
import p013io.netty.util.internal.InternalThreadLocalMap;
import p013io.netty.util.internal.ObjectPool;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.PromiseNotificationUtil;
import p013io.netty.util.internal.SystemPropertyUtil;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

/* renamed from: io.netty.channel.ChannelOutboundBuffer */
/* loaded from: grasscutter.jar:io/netty/channel/ChannelOutboundBuffer.class */
public final class ChannelOutboundBuffer {
    static final int CHANNEL_OUTBOUND_BUFFER_ENTRY_OVERHEAD;
    private static final InternalLogger logger;
    private static final FastThreadLocal<ByteBuffer[]> NIO_BUFFERS;
    private final Channel channel;
    private Entry flushedEntry;
    private Entry unflushedEntry;
    private Entry tailEntry;
    private int flushed;
    private int nioBufferCount;
    private long nioBufferSize;
    private boolean inFail;
    private static final AtomicLongFieldUpdater<ChannelOutboundBuffer> TOTAL_PENDING_SIZE_UPDATER;
    private volatile long totalPendingSize;
    private static final AtomicIntegerFieldUpdater<ChannelOutboundBuffer> UNWRITABLE_UPDATER;
    private volatile int unwritable;
    private volatile Runnable fireChannelWritabilityChangedTask;
    static final /* synthetic */ boolean $assertionsDisabled;

    /* renamed from: io.netty.channel.ChannelOutboundBuffer$MessageProcessor */
    /* loaded from: grasscutter.jar:io/netty/channel/ChannelOutboundBuffer$MessageProcessor.class */
    public interface MessageProcessor {
        boolean processMessage(Object obj) throws Exception;
    }

    static {
        $assertionsDisabled = !ChannelOutboundBuffer.class.desiredAssertionStatus();
        CHANNEL_OUTBOUND_BUFFER_ENTRY_OVERHEAD = SystemPropertyUtil.getInt("io.netty.transport.outboundBufferEntrySizeOverhead", 96);
        logger = InternalLoggerFactory.getInstance(ChannelOutboundBuffer.class);
        NIO_BUFFERS = new FastThreadLocal<ByteBuffer[]>() { // from class: io.netty.channel.ChannelOutboundBuffer.1
            /* access modifiers changed from: protected */
            @Override // p013io.netty.util.concurrent.FastThreadLocal
            public ByteBuffer[] initialValue() throws Exception {
                return new ByteBuffer[1024];
            }
        };
        TOTAL_PENDING_SIZE_UPDATER = AtomicLongFieldUpdater.newUpdater(ChannelOutboundBuffer.class, "totalPendingSize");
        UNWRITABLE_UPDATER = AtomicIntegerFieldUpdater.newUpdater(ChannelOutboundBuffer.class, "unwritable");
    }

    /* access modifiers changed from: package-private */
    public ChannelOutboundBuffer(AbstractChannel channel) {
        this.channel = channel;
    }

    public void addMessage(Object msg, int size, ChannelPromise promise) {
        Entry entry = Entry.newInstance(msg, size, total(msg), promise);
        if (this.tailEntry == null) {
            this.flushedEntry = null;
        } else {
            this.tailEntry.next = entry;
        }
        this.tailEntry = entry;
        if (this.unflushedEntry == null) {
            this.unflushedEntry = entry;
        }
        incrementPendingOutboundBytes((long) entry.pendingSize, false);
    }

    public void addFlush() {
        Entry entry = this.unflushedEntry;
        if (entry != null) {
            if (this.flushedEntry == null) {
                this.flushedEntry = entry;
            }
            do {
                this.flushed++;
                if (!entry.promise.setUncancellable()) {
                    decrementPendingOutboundBytes((long) entry.cancel(), false, true);
                }
                entry = entry.next;
            } while (entry != null);
            this.unflushedEntry = null;
        }
    }

    /* access modifiers changed from: package-private */
    public void incrementPendingOutboundBytes(long size) {
        incrementPendingOutboundBytes(size, true);
    }

    private void incrementPendingOutboundBytes(long size, boolean invokeLater) {
        if (size != 0 && TOTAL_PENDING_SIZE_UPDATER.addAndGet(this, size) > ((long) this.channel.config().getWriteBufferHighWaterMark())) {
            setUnwritable(invokeLater);
        }
    }

    /* access modifiers changed from: package-private */
    public void decrementPendingOutboundBytes(long size) {
        decrementPendingOutboundBytes(size, true, true);
    }

    private void decrementPendingOutboundBytes(long size, boolean invokeLater, boolean notifyWritability) {
        if (size != 0) {
            long newWriteBufferSize = TOTAL_PENDING_SIZE_UPDATER.addAndGet(this, -size);
            if (notifyWritability && newWriteBufferSize < ((long) this.channel.config().getWriteBufferLowWaterMark())) {
                setWritable(invokeLater);
            }
        }
    }

    private static long total(Object msg) {
        if (msg instanceof ByteBuf) {
            return (long) ((ByteBuf) msg).readableBytes();
        }
        if (msg instanceof FileRegion) {
            return ((FileRegion) msg).count();
        }
        if (msg instanceof ByteBufHolder) {
            return (long) ((ByteBufHolder) msg).content().readableBytes();
        }
        return -1;
    }

    public Object current() {
        Entry entry = this.flushedEntry;
        if (entry == null) {
            return null;
        }
        return entry.msg;
    }

    public long currentProgress() {
        Entry entry = this.flushedEntry;
        if (entry == null) {
            return 0;
        }
        return entry.progress;
    }

    public void progress(long amount) {
        Entry e = this.flushedEntry;
        if ($assertionsDisabled || e != null) {
            ChannelPromise p = e.promise;
            long progress = e.progress + amount;
            e.progress = progress;
            if (p instanceof ChannelProgressivePromise) {
                ((ChannelProgressivePromise) p).tryProgress(progress, e.total);
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    public boolean remove() {
        Entry e = this.flushedEntry;
        if (e == null) {
            clearNioBuffers();
            return false;
        }
        Object msg = e.msg;
        ChannelPromise promise = e.promise;
        int size = e.pendingSize;
        removeEntry(e);
        if (!e.cancelled) {
            ReferenceCountUtil.safeRelease(msg);
            safeSuccess(promise);
            decrementPendingOutboundBytes((long) size, false, true);
        }
        e.recycle();
        return true;
    }

    public boolean remove(Throwable cause) {
        return remove0(cause, true);
    }

    private boolean remove0(Throwable cause, boolean notifyWritability) {
        Entry e = this.flushedEntry;
        if (e == null) {
            clearNioBuffers();
            return false;
        }
        Object msg = e.msg;
        ChannelPromise promise = e.promise;
        int size = e.pendingSize;
        removeEntry(e);
        if (!e.cancelled) {
            ReferenceCountUtil.safeRelease(msg);
            safeFail(promise, cause);
            decrementPendingOutboundBytes((long) size, false, notifyWritability);
        }
        e.recycle();
        return true;
    }

    private void removeEntry(Entry e) {
        int i = this.flushed - 1;
        this.flushed = i;
        if (i == 0) {
            this.flushedEntry = null;
            if (e == this.tailEntry) {
                this.tailEntry = null;
                this.unflushedEntry = null;
                return;
            }
            return;
        }
        this.flushedEntry = e.next;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:24:0x0052 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [io.netty.channel.ChannelOutboundBuffer] */
    /* JADX WARN: Type inference failed for: r6v1, types: [long] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r0v30, types: [long] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARNING: Code restructure failed: missing block: B:0:?, code lost:
        r6 = r6;
     */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void removeBytes(long r6) {
        /*
            r5 = this;
        L_0x0000:
            r0 = r5
            java.lang.Object r0 = r0.current()
            r8 = r0
            r0 = r8
            boolean r0 = r0 instanceof p013io.netty.buffer.ByteBuf
            if (r0 != 0) goto L_0x0020
            boolean r0 = p013io.netty.channel.ChannelOutboundBuffer.$assertionsDisabled
            if (r0 != 0) goto L_0x0076
            r0 = r6
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0076
            java.lang.AssertionError r0 = new java.lang.AssertionError
            r1 = r0
            r1.<init>()
            throw r0
        L_0x0020:
            r0 = r8
            io.netty.buffer.ByteBuf r0 = (p013io.netty.buffer.ByteBuf) r0
            r9 = r0
            r0 = r9
            int r0 = r0.readerIndex()
            r10 = r0
            r0 = r9
            int r0 = r0.writerIndex()
            r1 = r10
            int r0 = r0 - r1
            r11 = r0
            r0 = r11
            long r0 = (long) r0
            r1 = r6
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L_0x005a
            r0 = r6
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0052
            r0 = r5
            r1 = r11
            long r1 = (long) r1
            r0.progress(r1)
            r0 = r6
            r1 = r11
            long r1 = (long) r1
            long r0 = r0 - r1
            r6 = r0
        L_0x0052:
            r0 = r5
            boolean r0 = r0.remove()
            goto L_0x0073
        L_0x005a:
            r0 = r6
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0076
            r0 = r9
            r1 = r10
            r2 = r6
            int r2 = (int) r2
            int r1 = r1 + r2
            io.netty.buffer.ByteBuf r0 = r0.readerIndex(r1)
            r0 = r5
            r1 = r6
            r0.progress(r1)
            goto L_0x0076
        L_0x0073:
            goto L_0x0000
        L_0x0076:
            r0 = r5
            r0.clearNioBuffers()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.channel.ChannelOutboundBuffer.removeBytes(long):void");
    }

    private void clearNioBuffers() {
        int count = this.nioBufferCount;
        if (count > 0) {
            this.nioBufferCount = 0;
            Arrays.fill(NIO_BUFFERS.get(), 0, count, (Object) null);
        }
    }

    public ByteBuffer[] nioBuffers() {
        return nioBuffers(Integer.MAX_VALUE, 2147483647L);
    }

    /* JADX WARN: Type inference failed for: r0v36, types: [long] */
    public ByteBuffer[] nioBuffers(int maxCount, long maxBytes) {
        ByteBuf buf;
        int readerIndex;
        int readableBytes;
        if (!$assertionsDisabled && maxCount <= 0) {
            throw new AssertionError();
        } else if ($assertionsDisabled || maxBytes > 0) {
            char c = 0;
            int nioBufferCount = 0;
            InternalThreadLocalMap threadLocalMap = InternalThreadLocalMap.get();
            ByteBuffer[] nioBuffers = NIO_BUFFERS.get(threadLocalMap);
            Entry entry = this.flushedEntry;
            while (isFlushedEntry(entry) && (entry.msg instanceof ByteBuf)) {
                if (!entry.cancelled && (readableBytes = buf.writerIndex() - (readerIndex = (buf = (ByteBuf) entry.msg).readerIndex())) > 0) {
                    if (maxBytes - ((long) readableBytes) < c && nioBufferCount != 0) {
                        break;
                    }
                    c += (long) readableBytes;
                    int count = entry.count;
                    if (count == -1) {
                        int nioBufferCount2 = buf.nioBufferCount();
                        count = nioBufferCount2;
                        entry.count = nioBufferCount2;
                    }
                    int neededSpace = Math.min(maxCount, nioBufferCount + count);
                    if (neededSpace > nioBuffers.length) {
                        nioBuffers = expandNioBufferArray(nioBuffers, neededSpace, nioBufferCount);
                        NIO_BUFFERS.set(threadLocalMap, nioBuffers);
                    }
                    if (count == 1) {
                        ByteBuffer nioBuf = entry.buf;
                        if (nioBuf == null) {
                            ByteBuffer internalNioBuffer = buf.internalNioBuffer(readerIndex, readableBytes);
                            nioBuf = internalNioBuffer;
                            entry.buf = internalNioBuffer;
                        }
                        nioBufferCount++;
                        nioBuffers[nioBufferCount] = nioBuf;
                    } else {
                        nioBufferCount = nioBuffers(entry, buf, nioBuffers, nioBufferCount, maxCount);
                    }
                    if (nioBufferCount >= maxCount) {
                        break;
                    }
                }
                entry = entry.next;
            }
            this.nioBufferCount = nioBufferCount;
            this.nioBufferSize = c;
            return nioBuffers;
        } else {
            throw new AssertionError();
        }
    }

    private static int nioBuffers(Entry entry, ByteBuf buf, ByteBuffer[] nioBuffers, int nioBufferCount, int maxCount) {
        ByteBuffer nioBuf;
        ByteBuffer[] nioBufs = entry.bufs;
        if (nioBufs == null) {
            ByteBuffer[] nioBuffers2 = buf.nioBuffers();
            nioBufs = nioBuffers2;
            entry.bufs = nioBuffers2;
        }
        int i = 0;
        while (i < nioBufs.length && nioBufferCount < maxCount && (nioBuf = nioBufs[i]) != null) {
            if (nioBuf.hasRemaining()) {
                nioBufferCount++;
                nioBuffers[nioBufferCount] = nioBuf;
            }
            i++;
        }
        return nioBufferCount;
    }

    private static ByteBuffer[] expandNioBufferArray(ByteBuffer[] array, int neededSpace, int size) {
        int newCapacity = array.length;
        do {
            newCapacity <<= 1;
            if (newCapacity < 0) {
                throw new IllegalStateException();
            }
        } while (neededSpace > newCapacity);
        ByteBuffer[] newArray = new ByteBuffer[newCapacity];
        System.arraycopy(array, 0, newArray, 0, size);
        return newArray;
    }

    public int nioBufferCount() {
        return this.nioBufferCount;
    }

    public long nioBufferSize() {
        return this.nioBufferSize;
    }

    public boolean isWritable() {
        return this.unwritable == 0;
    }

    public boolean getUserDefinedWritability(int index) {
        return (this.unwritable & writabilityMask(index)) == 0;
    }

    public void setUserDefinedWritability(int index, boolean writable) {
        if (writable) {
            setUserDefinedWritability(index);
        } else {
            clearUserDefinedWritability(index);
        }
    }

    private void setUserDefinedWritability(int index) {
        int oldValue;
        int newValue;
        int mask = writabilityMask(index) ^ -1;
        do {
            oldValue = this.unwritable;
            newValue = oldValue & mask;
        } while (!UNWRITABLE_UPDATER.compareAndSet(this, oldValue, newValue));
        if (oldValue != 0 && newValue == 0) {
            fireChannelWritabilityChanged(true);
        }
    }

    private void clearUserDefinedWritability(int index) {
        int oldValue;
        int newValue;
        int mask = writabilityMask(index);
        do {
            oldValue = this.unwritable;
            newValue = oldValue | mask;
        } while (!UNWRITABLE_UPDATER.compareAndSet(this, oldValue, newValue));
        if (oldValue == 0 && newValue != 0) {
            fireChannelWritabilityChanged(true);
        }
    }

    private static int writabilityMask(int index) {
        if (index >= 1 && index <= 31) {
            return 1 << index;
        }
        throw new IllegalArgumentException("index: " + index + " (expected: 1~31)");
    }

    private void setWritable(boolean invokeLater) {
        int oldValue;
        int newValue;
        do {
            oldValue = this.unwritable;
            newValue = oldValue & -2;
        } while (!UNWRITABLE_UPDATER.compareAndSet(this, oldValue, newValue));
        if (oldValue != 0 && newValue == 0) {
            fireChannelWritabilityChanged(invokeLater);
        }
    }

    private void setUnwritable(boolean invokeLater) {
        int oldValue;
        do {
            oldValue = this.unwritable;
        } while (!UNWRITABLE_UPDATER.compareAndSet(this, oldValue, oldValue | 1));
        if (oldValue == 0) {
            fireChannelWritabilityChanged(invokeLater);
        }
    }

    private void fireChannelWritabilityChanged(boolean invokeLater) {
        final ChannelPipeline pipeline = this.channel.pipeline();
        if (invokeLater) {
            Runnable task = this.fireChannelWritabilityChangedTask;
            if (task == null) {
                Runnable r1 = new Runnable() { // from class: io.netty.channel.ChannelOutboundBuffer.2
                    @Override // java.lang.Runnable
                    public void run() {
                        pipeline.fireChannelWritabilityChanged();
                    }
                };
                task = r1;
                this.fireChannelWritabilityChangedTask = r1;
            }
            this.channel.eventLoop().execute(task);
            return;
        }
        pipeline.fireChannelWritabilityChanged();
    }

    public int size() {
        return this.flushed;
    }

    public boolean isEmpty() {
        return this.flushed == 0;
    }

    /* access modifiers changed from: package-private */
    public void failFlushed(Throwable cause, boolean notify) {
        if (!this.inFail) {
            try {
                this.inFail = true;
                do {
                } while (remove0(cause, notify));
            } finally {
                this.inFail = false;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void close(final Throwable cause, final boolean allowChannelOpen) {
        if (this.inFail) {
            this.channel.eventLoop().execute(new Runnable() { // from class: io.netty.channel.ChannelOutboundBuffer.3
                @Override // java.lang.Runnable
                public void run() {
                    ChannelOutboundBuffer.this.close(cause, allowChannelOpen);
                }
            });
            return;
        }
        this.inFail = true;
        if (!allowChannelOpen && this.channel.isOpen()) {
            throw new IllegalStateException("close() must be invoked after the channel is closed.");
        } else if (!isEmpty()) {
            throw new IllegalStateException("close() must be invoked after all flushed writes are handled.");
        } else {
            try {
                for (Entry e = this.unflushedEntry; e != null; e = e.recycleAndGetNext()) {
                    TOTAL_PENDING_SIZE_UPDATER.addAndGet(this, (long) (-e.pendingSize));
                    if (!e.cancelled) {
                        ReferenceCountUtil.safeRelease(e.msg);
                        safeFail(e.promise, cause);
                    }
                }
                clearNioBuffers();
            } finally {
                this.inFail = false;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void close(ClosedChannelException cause) {
        close(cause, false);
    }

    private static void safeSuccess(ChannelPromise promise) {
        PromiseNotificationUtil.trySuccess(promise, null, promise instanceof VoidChannelPromise ? null : logger);
    }

    private static void safeFail(ChannelPromise promise, Throwable cause) {
        PromiseNotificationUtil.tryFailure(promise, cause, promise instanceof VoidChannelPromise ? null : logger);
    }

    @Deprecated
    public void recycle() {
    }

    public long totalPendingWriteBytes() {
        return this.totalPendingSize;
    }

    public long bytesBeforeUnwritable() {
        long bytes = ((long) this.channel.config().getWriteBufferHighWaterMark()) - this.totalPendingSize;
        if (bytes <= 0 || !isWritable()) {
            return 0;
        }
        return bytes;
    }

    public long bytesBeforeWritable() {
        long bytes = this.totalPendingSize - ((long) this.channel.config().getWriteBufferLowWaterMark());
        if (bytes <= 0 || isWritable()) {
            return 0;
        }
        return bytes;
    }

    public void forEachFlushedMessage(MessageProcessor processor) throws Exception {
        ObjectUtil.checkNotNull(processor, "processor");
        Entry entry = this.flushedEntry;
        if (entry != null) {
            do {
                if (entry.cancelled || processor.processMessage(entry.msg)) {
                    entry = entry.next;
                } else {
                    return;
                }
            } while (isFlushedEntry(entry));
        }
    }

    private boolean isFlushedEntry(Entry e) {
        return (e == null || e == this.unflushedEntry) ? false : true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: io.netty.channel.ChannelOutboundBuffer$Entry */
    /* loaded from: grasscutter.jar:io/netty/channel/ChannelOutboundBuffer$Entry.class */
    public static final class Entry {
        private static final ObjectPool<Entry> RECYCLER = ObjectPool.newPool(new ObjectPool.ObjectCreator<Entry>() { // from class: io.netty.channel.ChannelOutboundBuffer.Entry.1
            @Override // p013io.netty.util.internal.ObjectPool.ObjectCreator
            public Entry newObject(ObjectPool.Handle<Entry> handle) {
                return new Entry(handle);
            }
        });
        private final ObjectPool.Handle<Entry> handle;
        Entry next;
        Object msg;
        ByteBuffer[] bufs;
        ByteBuffer buf;
        ChannelPromise promise;
        long progress;
        long total;
        int pendingSize;
        int count;
        boolean cancelled;

        private Entry(ObjectPool.Handle<Entry> handle) {
            this.count = -1;
            this.handle = handle;
        }

        static Entry newInstance(Object msg, int size, long total, ChannelPromise promise) {
            Entry entry = RECYCLER.get();
            entry.msg = msg;
            entry.pendingSize = size + ChannelOutboundBuffer.CHANNEL_OUTBOUND_BUFFER_ENTRY_OVERHEAD;
            entry.total = total;
            entry.promise = promise;
            return entry;
        }

        int cancel() {
            if (this.cancelled) {
                return 0;
            }
            this.cancelled = true;
            int pSize = this.pendingSize;
            ReferenceCountUtil.safeRelease(this.msg);
            this.msg = Unpooled.EMPTY_BUFFER;
            this.pendingSize = 0;
            this.total = 0;
            this.progress = 0;
            this.bufs = null;
            this.buf = null;
            return pSize;
        }

        void recycle() {
            this.next = null;
            this.bufs = null;
            this.buf = null;
            this.msg = null;
            this.promise = null;
            this.progress = 0;
            this.total = 0;
            this.pendingSize = 0;
            this.count = -1;
            this.cancelled = false;
            this.handle.recycle(this);
        }

        Entry recycleAndGetNext() {
            Entry next = this.next;
            recycle();
            return next;
        }
    }
}
