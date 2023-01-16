package p013io.netty.buffer;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import p013io.netty.util.internal.LongCounter;
import p013io.netty.util.internal.PlatformDependent;
import p013io.netty.util.internal.StringUtil;

/* access modifiers changed from: package-private */
/* renamed from: io.netty.buffer.PoolArena */
/* loaded from: grasscutter.jar:io/netty/buffer/PoolArena.class */
public abstract class PoolArena<T> extends SizeClasses implements PoolArenaMetric {
    static final boolean HAS_UNSAFE;
    final PooledByteBufAllocator parent;
    final int directMemoryCacheAlignment;
    private final PoolChunkList<T> q050;
    private final PoolChunkList<T> q025;
    private final PoolChunkList<T> q000;
    private final PoolChunkList<T> qInit;
    private final PoolChunkList<T> q075;
    private final PoolChunkList<T> q100;
    private final List<PoolChunkListMetric> chunkListMetrics;
    private long allocationsNormal;
    private long deallocationsSmall;
    private long deallocationsNormal;
    static final /* synthetic */ boolean $assertionsDisabled;
    private final LongCounter allocationsSmall = PlatformDependent.newLongCounter();
    private final LongCounter allocationsHuge = PlatformDependent.newLongCounter();
    private final LongCounter activeBytesHuge = PlatformDependent.newLongCounter();
    private final LongCounter deallocationsHuge = PlatformDependent.newLongCounter();
    final AtomicInteger numThreadCaches = new AtomicInteger();
    final int numSmallSubpagePools = this.nSubpages;
    private final PoolSubpage<T>[] smallSubpagePools = newSubpagePoolArray(this.numSmallSubpagePools);

    /* access modifiers changed from: package-private */
    /* renamed from: io.netty.buffer.PoolArena$SizeClass */
    /* loaded from: grasscutter.jar:io/netty/buffer/PoolArena$SizeClass.class */
    public enum SizeClass {
        Small,
        Normal
    }

    /* access modifiers changed from: package-private */
    public abstract boolean isDirect();

    protected abstract PoolChunk<T> newChunk(int i, int i2, int i3, int i4);

    protected abstract PoolChunk<T> newUnpooledChunk(int i);

    protected abstract PooledByteBuf<T> newByteBuf(int i);

    protected abstract void memoryCopy(T t, int i, PooledByteBuf<T> pooledByteBuf, int i2);

    /* access modifiers changed from: protected */
    public abstract void destroyChunk(PoolChunk<T> poolChunk);

    static {
        $assertionsDisabled = !PoolArena.class.desiredAssertionStatus();
        HAS_UNSAFE = PlatformDependent.hasUnsafe();
    }

    protected PoolArena(PooledByteBufAllocator parent, int pageSize, int pageShifts, int chunkSize, int cacheAlignment) {
        super(pageSize, pageShifts, chunkSize, cacheAlignment);
        this.parent = parent;
        this.directMemoryCacheAlignment = cacheAlignment;
        for (int i = 0; i < this.smallSubpagePools.length; i++) {
            this.smallSubpagePools[i] = newSubpagePoolHead();
        }
        this.q100 = new PoolChunkList<>(this, null, 100, Integer.MAX_VALUE, chunkSize);
        this.q075 = new PoolChunkList<>(this, this.q100, 75, 100, chunkSize);
        this.q050 = new PoolChunkList<>(this, this.q075, 50, 100, chunkSize);
        this.q025 = new PoolChunkList<>(this, this.q050, 25, 75, chunkSize);
        this.q000 = new PoolChunkList<>(this, this.q025, 1, 50, chunkSize);
        this.qInit = new PoolChunkList<>(this, this.q000, Integer.MIN_VALUE, 25, chunkSize);
        this.q100.prevList(this.q075);
        this.q075.prevList(this.q050);
        this.q050.prevList(this.q025);
        this.q025.prevList(this.q000);
        this.q000.prevList(null);
        this.qInit.prevList(this.qInit);
        List<PoolChunkListMetric> metrics = new ArrayList<>(6);
        metrics.add(this.qInit);
        metrics.add(this.q000);
        metrics.add(this.q025);
        metrics.add(this.q050);
        metrics.add(this.q075);
        metrics.add(this.q100);
        this.chunkListMetrics = Collections.unmodifiableList(metrics);
    }

    private PoolSubpage<T> newSubpagePoolHead() {
        PoolSubpage<T> head = new PoolSubpage<>();
        head.prev = head;
        head.next = head;
        return head;
    }

    private PoolSubpage<T>[] newSubpagePoolArray(int size) {
        return new PoolSubpage[size];
    }

    /* access modifiers changed from: package-private */
    public PooledByteBuf<T> allocate(PoolThreadCache cache, int reqCapacity, int maxCapacity) {
        PooledByteBuf<T> buf = newByteBuf(maxCapacity);
        allocate(cache, buf, reqCapacity);
        return buf;
    }

    private void allocate(PoolThreadCache cache, PooledByteBuf<T> buf, int reqCapacity) {
        int sizeIdx = size2SizeIdx(reqCapacity);
        if (sizeIdx <= this.smallMaxSizeIdx) {
            tcacheAllocateSmall(cache, buf, reqCapacity, sizeIdx);
        } else if (sizeIdx < this.nSizes) {
            tcacheAllocateNormal(cache, buf, reqCapacity, sizeIdx);
        } else {
            allocateHuge(buf, this.directMemoryCacheAlignment > 0 ? normalizeSize(reqCapacity) : reqCapacity);
        }
    }

    private void tcacheAllocateSmall(PoolThreadCache cache, PooledByteBuf<T> buf, int reqCapacity, int sizeIdx) {
        boolean needsNormalAllocation;
        if (!cache.allocateSmall(this, buf, reqCapacity, sizeIdx)) {
            PoolSubpage<T> head = this.smallSubpagePools[sizeIdx];
            synchronized (head) {
                PoolSubpage<T> s = head.next;
                needsNormalAllocation = s == head;
                if (!needsNormalAllocation) {
                    if ($assertionsDisabled || (s.doNotDestroy && s.elemSize == sizeIdx2size(sizeIdx))) {
                        long handle = s.allocate();
                        if ($assertionsDisabled || handle >= 0) {
                            s.chunk.initBufWithSubpage(buf, null, handle, reqCapacity, cache);
                        } else {
                            throw new AssertionError();
                        }
                    } else {
                        throw new AssertionError("doNotDestroy=" + s.doNotDestroy + ", elemSize=" + s.elemSize + ", sizeIdx=" + sizeIdx);
                    }
                }
            }
            if (needsNormalAllocation) {
                synchronized (this) {
                    allocateNormal(buf, reqCapacity, sizeIdx, cache);
                }
            }
            incSmallAllocation();
        }
    }

    private void tcacheAllocateNormal(PoolThreadCache cache, PooledByteBuf<T> buf, int reqCapacity, int sizeIdx) {
        if (!cache.allocateNormal(this, buf, reqCapacity, sizeIdx)) {
            synchronized (this) {
                allocateNormal(buf, reqCapacity, sizeIdx, cache);
                this.allocationsNormal++;
            }
        }
    }

    private void allocateNormal(PooledByteBuf<T> buf, int reqCapacity, int sizeIdx, PoolThreadCache threadCache) {
        if (!this.q050.allocate(buf, reqCapacity, sizeIdx, threadCache) && !this.q025.allocate(buf, reqCapacity, sizeIdx, threadCache) && !this.q000.allocate(buf, reqCapacity, sizeIdx, threadCache) && !this.qInit.allocate(buf, reqCapacity, sizeIdx, threadCache) && !this.q075.allocate(buf, reqCapacity, sizeIdx, threadCache)) {
            PoolChunk<T> c = newChunk(this.pageSize, this.nPSizes, this.pageShifts, this.chunkSize);
            boolean success = c.allocate(buf, reqCapacity, sizeIdx, threadCache);
            if ($assertionsDisabled || success) {
                this.qInit.add(c);
                return;
            }
            throw new AssertionError();
        }
    }

    private void incSmallAllocation() {
        this.allocationsSmall.increment();
    }

    private void allocateHuge(PooledByteBuf<T> buf, int reqCapacity) {
        PoolChunk<T> chunk = newUnpooledChunk(reqCapacity);
        this.activeBytesHuge.add((long) chunk.chunkSize());
        buf.initUnpooled(chunk, reqCapacity);
        this.allocationsHuge.increment();
    }

    /* access modifiers changed from: package-private */
    public void free(PoolChunk<T> chunk, ByteBuffer nioBuffer, long handle, int normCapacity, PoolThreadCache cache) {
        if (chunk.unpooled) {
            int size = chunk.chunkSize();
            destroyChunk(chunk);
            this.activeBytesHuge.add((long) (-size));
            this.deallocationsHuge.increment();
            return;
        }
        SizeClass sizeClass = sizeClass(handle);
        if (cache == null || !cache.add(this, chunk, nioBuffer, handle, normCapacity, sizeClass)) {
            freeChunk(chunk, handle, normCapacity, sizeClass, nioBuffer, false);
        }
    }

    private static SizeClass sizeClass(long handle) {
        return PoolChunk.isSubpage(handle) ? SizeClass.Small : SizeClass.Normal;
    }

    /* access modifiers changed from: package-private */
    public void freeChunk(PoolChunk<T> chunk, long handle, int normCapacity, SizeClass sizeClass, ByteBuffer nioBuffer, boolean finalizer) {
        boolean destroyChunk;
        synchronized (this) {
            if (!finalizer) {
                switch (sizeClass) {
                    case Normal:
                        this.deallocationsNormal++;
                        break;
                    case Small:
                        this.deallocationsSmall++;
                        break;
                    default:
                        throw new Error();
                }
            }
            destroyChunk = !chunk.parent.free(chunk, handle, normCapacity, nioBuffer);
        }
        if (destroyChunk) {
            destroyChunk(chunk);
        }
    }

    /* access modifiers changed from: package-private */
    public PoolSubpage<T> findSubpagePoolHead(int sizeIdx) {
        return this.smallSubpagePools[sizeIdx];
    }

    /* access modifiers changed from: package-private */
    public void reallocate(PooledByteBuf<T> buf, int newCapacity, boolean freeOldMemory) {
        int bytesToCopy;
        if ($assertionsDisabled || (newCapacity >= 0 && newCapacity <= buf.maxCapacity())) {
            int oldCapacity = buf.length;
            if (oldCapacity != newCapacity) {
                PoolChunk<T> oldChunk = buf.chunk;
                ByteBuffer oldNioBuffer = buf.tmpNioBuf;
                long oldHandle = buf.handle;
                T oldMemory = buf.memory;
                int oldOffset = buf.offset;
                int oldMaxLength = buf.maxLength;
                allocate(this.parent.threadCache(), buf, newCapacity);
                if (newCapacity > oldCapacity) {
                    bytesToCopy = oldCapacity;
                } else {
                    buf.trimIndicesToCapacity(newCapacity);
                    bytesToCopy = newCapacity;
                }
                memoryCopy(oldMemory, oldOffset, buf, bytesToCopy);
                if (freeOldMemory) {
                    free(oldChunk, oldNioBuffer, oldHandle, oldMaxLength, buf.cache);
                    return;
                }
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    @Override // p013io.netty.buffer.PoolArenaMetric
    public int numThreadCaches() {
        return this.numThreadCaches.get();
    }

    @Override // p013io.netty.buffer.PoolArenaMetric
    public int numTinySubpages() {
        return 0;
    }

    @Override // p013io.netty.buffer.PoolArenaMetric
    public int numSmallSubpages() {
        return this.smallSubpagePools.length;
    }

    @Override // p013io.netty.buffer.PoolArenaMetric
    public int numChunkLists() {
        return this.chunkListMetrics.size();
    }

    @Override // p013io.netty.buffer.PoolArenaMetric
    public List<PoolSubpageMetric> tinySubpages() {
        return Collections.emptyList();
    }

    @Override // p013io.netty.buffer.PoolArenaMetric
    public List<PoolSubpageMetric> smallSubpages() {
        return subPageMetricList(this.smallSubpagePools);
    }

    @Override // p013io.netty.buffer.PoolArenaMetric
    public List<PoolChunkListMetric> chunkLists() {
        return this.chunkListMetrics;
    }

    private static List<PoolSubpageMetric> subPageMetricList(PoolSubpage<?>[] pages) {
        List<PoolSubpageMetric> metrics = new ArrayList<>();
        for (PoolSubpage<?> head : pages) {
            if (head.next != head) {
                PoolSubpage<?> s = head.next;
                do {
                    metrics.add(s);
                    s = s.next;
                } while (s != head);
            }
        }
        return metrics;
    }

    @Override // p013io.netty.buffer.PoolArenaMetric
    public long numAllocations() {
        long allocsNormal;
        synchronized (this) {
            allocsNormal = this.allocationsNormal;
        }
        return this.allocationsSmall.value() + allocsNormal + this.allocationsHuge.value();
    }

    @Override // p013io.netty.buffer.PoolArenaMetric
    public long numTinyAllocations() {
        return 0;
    }

    @Override // p013io.netty.buffer.PoolArenaMetric
    public long numSmallAllocations() {
        return this.allocationsSmall.value();
    }

    @Override // p013io.netty.buffer.PoolArenaMetric
    public synchronized long numNormalAllocations() {
        return this.allocationsNormal;
    }

    @Override // p013io.netty.buffer.PoolArenaMetric
    public long numDeallocations() {
        long deallocs;
        synchronized (this) {
            deallocs = this.deallocationsSmall + this.deallocationsNormal;
        }
        return deallocs + this.deallocationsHuge.value();
    }

    @Override // p013io.netty.buffer.PoolArenaMetric
    public long numTinyDeallocations() {
        return 0;
    }

    @Override // p013io.netty.buffer.PoolArenaMetric
    public synchronized long numSmallDeallocations() {
        return this.deallocationsSmall;
    }

    @Override // p013io.netty.buffer.PoolArenaMetric
    public synchronized long numNormalDeallocations() {
        return this.deallocationsNormal;
    }

    @Override // p013io.netty.buffer.PoolArenaMetric
    public long numHugeAllocations() {
        return this.allocationsHuge.value();
    }

    @Override // p013io.netty.buffer.PoolArenaMetric
    public long numHugeDeallocations() {
        return this.deallocationsHuge.value();
    }

    @Override // p013io.netty.buffer.PoolArenaMetric
    public long numActiveAllocations() {
        long val;
        long val2 = (this.allocationsSmall.value() + this.allocationsHuge.value()) - this.deallocationsHuge.value();
        synchronized (this) {
            val = val2 + (this.allocationsNormal - (this.deallocationsSmall + this.deallocationsNormal));
        }
        return Math.max(val, 0L);
    }

    @Override // p013io.netty.buffer.PoolArenaMetric
    public long numActiveTinyAllocations() {
        return 0;
    }

    @Override // p013io.netty.buffer.PoolArenaMetric
    public long numActiveSmallAllocations() {
        return Math.max(numSmallAllocations() - numSmallDeallocations(), 0L);
    }

    @Override // p013io.netty.buffer.PoolArenaMetric
    public long numActiveNormalAllocations() {
        long val;
        synchronized (this) {
            val = this.allocationsNormal - this.deallocationsNormal;
        }
        return Math.max(val, 0L);
    }

    @Override // p013io.netty.buffer.PoolArenaMetric
    public long numActiveHugeAllocations() {
        return Math.max(numHugeAllocations() - numHugeDeallocations(), 0L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v2, types: [long] */
    /* JADX WARN: Type inference failed for: r0v22, types: [long] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // p013io.netty.buffer.PoolArenaMetric
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long numActiveBytes() {
        /*
            r5 = this;
            r0 = r5
            io.netty.util.internal.LongCounter r0 = r0.activeBytesHuge
            long r0 = r0.value()
            r6 = r0
            r0 = r5
            r1 = r0
            r8 = r1
            monitor-enter(r0)
            r0 = 0
            r9 = r0
        L_0x0011:
            r0 = r9
            r1 = r5
            java.util.List<io.netty.buffer.PoolChunkListMetric> r1 = r1.chunkListMetrics     // Catch: all -> 0x0063
            int r1 = r1.size()     // Catch: all -> 0x0063
            if (r0 >= r1) goto L_0x005e
            r0 = r5
            java.util.List<io.netty.buffer.PoolChunkListMetric> r0 = r0.chunkListMetrics     // Catch: all -> 0x0063
            r1 = r9
            java.lang.Object r0 = r0.get(r1)     // Catch: all -> 0x0063
            io.netty.buffer.PoolChunkListMetric r0 = (p013io.netty.buffer.PoolChunkListMetric) r0     // Catch: all -> 0x0063
            java.util.Iterator r0 = r0.iterator()     // Catch: all -> 0x0063
            r10 = r0
        L_0x0034:
            r0 = r10
            boolean r0 = r0.hasNext()     // Catch: all -> 0x0063
            if (r0 == 0) goto L_0x0058
            r0 = r10
            java.lang.Object r0 = r0.next()     // Catch: all -> 0x0063
            io.netty.buffer.PoolChunkMetric r0 = (p013io.netty.buffer.PoolChunkMetric) r0     // Catch: all -> 0x0063
            r11 = r0
            r0 = r6
            r1 = r11
            int r1 = r1.chunkSize()     // Catch: all -> 0x0063
            long r1 = (long) r1     // Catch: all -> 0x0063
            long r0 = r0 + r1
            r6 = r0
            goto L_0x0034
        L_0x0058:
            int r9 = r9 + 1
            goto L_0x0011
        L_0x005e:
            r0 = r8
            monitor-exit(r0)     // Catch: all -> 0x0063
            goto L_0x006a
        L_0x0063:
            r12 = move-exception
            r0 = r8
            monitor-exit(r0)     // Catch: all -> 0x0063
            r0 = r12
            throw r0
        L_0x006a:
            r0 = 0
            r1 = r6
            long r0 = java.lang.Math.max(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.buffer.PoolArena.numActiveBytes():long");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v2, types: [long] */
    /* JADX WARN: Type inference failed for: r0v22, types: [long] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long numPinnedBytes() {
        /*
            r5 = this;
            r0 = r5
            io.netty.util.internal.LongCounter r0 = r0.activeBytesHuge
            long r0 = r0.value()
            r6 = r0
            r0 = r5
            r1 = r0
            r8 = r1
            monitor-enter(r0)
            r0 = 0
            r9 = r0
        L_0x0011:
            r0 = r9
            r1 = r5
            java.util.List<io.netty.buffer.PoolChunkListMetric> r1 = r1.chunkListMetrics     // Catch: all -> 0x0064
            int r1 = r1.size()     // Catch: all -> 0x0064
            if (r0 >= r1) goto L_0x005f
            r0 = r5
            java.util.List<io.netty.buffer.PoolChunkListMetric> r0 = r0.chunkListMetrics     // Catch: all -> 0x0064
            r1 = r9
            java.lang.Object r0 = r0.get(r1)     // Catch: all -> 0x0064
            io.netty.buffer.PoolChunkListMetric r0 = (p013io.netty.buffer.PoolChunkListMetric) r0     // Catch: all -> 0x0064
            java.util.Iterator r0 = r0.iterator()     // Catch: all -> 0x0064
            r10 = r0
        L_0x0034:
            r0 = r10
            boolean r0 = r0.hasNext()     // Catch: all -> 0x0064
            if (r0 == 0) goto L_0x0059
            r0 = r10
            java.lang.Object r0 = r0.next()     // Catch: all -> 0x0064
            io.netty.buffer.PoolChunkMetric r0 = (p013io.netty.buffer.PoolChunkMetric) r0     // Catch: all -> 0x0064
            r11 = r0
            r0 = r6
            r1 = r11
            io.netty.buffer.PoolChunk r1 = (p013io.netty.buffer.PoolChunk) r1     // Catch: all -> 0x0064
            int r1 = r1.pinnedBytes()     // Catch: all -> 0x0064
            long r1 = (long) r1     // Catch: all -> 0x0064
            long r0 = r0 + r1
            r6 = r0
            goto L_0x0034
        L_0x0059:
            int r9 = r9 + 1
            goto L_0x0011
        L_0x005f:
            r0 = r8
            monitor-exit(r0)     // Catch: all -> 0x0064
            goto L_0x006b
        L_0x0064:
            r12 = move-exception
            r0 = r8
            monitor-exit(r0)     // Catch: all -> 0x0064
            r0 = r12
            throw r0
        L_0x006b:
            r0 = 0
            r1 = r6
            long r0 = java.lang.Math.max(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.buffer.PoolArena.numPinnedBytes():long");
    }

    public synchronized String toString() {
        StringBuilder buf = new StringBuilder().append("Chunk(s) at 0~25%:").append(StringUtil.NEWLINE).append(this.qInit).append(StringUtil.NEWLINE).append("Chunk(s) at 0~50%:").append(StringUtil.NEWLINE).append(this.q000).append(StringUtil.NEWLINE).append("Chunk(s) at 25~75%:").append(StringUtil.NEWLINE).append(this.q025).append(StringUtil.NEWLINE).append("Chunk(s) at 50~100%:").append(StringUtil.NEWLINE).append(this.q050).append(StringUtil.NEWLINE).append("Chunk(s) at 75~100%:").append(StringUtil.NEWLINE).append(this.q075).append(StringUtil.NEWLINE).append("Chunk(s) at 100%:").append(StringUtil.NEWLINE).append(this.q100).append(StringUtil.NEWLINE).append("small subpages:");
        appendPoolSubPages(buf, this.smallSubpagePools);
        buf.append(StringUtil.NEWLINE);
        return buf.toString();
    }

    private static void appendPoolSubPages(StringBuilder buf, PoolSubpage<?>[] subpages) {
        for (int i = 0; i < subpages.length; i++) {
            PoolSubpage<?> head = subpages[i];
            if (head.next != head) {
                buf.append(StringUtil.NEWLINE).append(i).append(": ");
                PoolSubpage<?> s = head.next;
                do {
                    buf.append(s);
                    s = s.next;
                } while (s != head);
            }
        }
    }

    protected final void finalize() throws Throwable {
        try {
            finalize();
            destroyPoolSubPages(this.smallSubpagePools);
            destroyPoolChunkLists(this.qInit, this.q000, this.q025, this.q050, this.q075, this.q100);
        } catch (Throwable th) {
            destroyPoolSubPages(this.smallSubpagePools);
            destroyPoolChunkLists(this.qInit, this.q000, this.q025, this.q050, this.q075, this.q100);
            throw th;
        }
    }

    private static void destroyPoolSubPages(PoolSubpage<?>[] pages) {
        for (PoolSubpage<?> page : pages) {
            page.destroy();
        }
    }

    private void destroyPoolChunkLists(PoolChunkList<T>... chunkLists) {
        for (PoolChunkList<T> chunkList : chunkLists) {
            chunkList.destroy(this);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: io.netty.buffer.PoolArena$HeapArena */
    /* loaded from: grasscutter.jar:io/netty/buffer/PoolArena$HeapArena.class */
    public static final class HeapArena extends PoolArena<byte[]> {
        /* access modifiers changed from: package-private */
        public HeapArena(PooledByteBufAllocator parent, int pageSize, int pageShifts, int chunkSize) {
            super(parent, pageSize, pageShifts, chunkSize, 0);
        }

        private static byte[] newByteArray(int size) {
            return PlatformDependent.allocateUninitializedArray(size);
        }

        @Override // p013io.netty.buffer.PoolArena
        boolean isDirect() {
            return false;
        }

        @Override // p013io.netty.buffer.PoolArena
        protected PoolChunk<byte[]> newChunk(int pageSize, int maxPageIdx, int pageShifts, int chunkSize) {
            return new PoolChunk<>(this, null, newByteArray(chunkSize), pageSize, pageShifts, chunkSize, maxPageIdx);
        }

        @Override // p013io.netty.buffer.PoolArena
        protected PoolChunk<byte[]> newUnpooledChunk(int capacity) {
            return new PoolChunk<>(this, null, newByteArray(capacity), capacity);
        }

        @Override // p013io.netty.buffer.PoolArena
        protected void destroyChunk(PoolChunk<byte[]> chunk) {
        }

        @Override // p013io.netty.buffer.PoolArena
        protected PooledByteBuf<byte[]> newByteBuf(int maxCapacity) {
            return HAS_UNSAFE ? PooledUnsafeHeapByteBuf.newUnsafeInstance(maxCapacity) : PooledHeapByteBuf.newInstance(maxCapacity);
        }

        /* access modifiers changed from: protected */
        public void memoryCopy(byte[] src, int srcOffset, PooledByteBuf<byte[]> dst, int length) {
            if (length != 0) {
                System.arraycopy(src, srcOffset, dst.memory, dst.offset, length);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: io.netty.buffer.PoolArena$DirectArena */
    /* loaded from: grasscutter.jar:io/netty/buffer/PoolArena$DirectArena.class */
    public static final class DirectArena extends PoolArena<ByteBuffer> {
        /* access modifiers changed from: package-private */
        public DirectArena(PooledByteBufAllocator parent, int pageSize, int pageShifts, int chunkSize, int directMemoryCacheAlignment) {
            super(parent, pageSize, pageShifts, chunkSize, directMemoryCacheAlignment);
        }

        @Override // p013io.netty.buffer.PoolArena
        boolean isDirect() {
            return true;
        }

        @Override // p013io.netty.buffer.PoolArena
        protected PoolChunk<ByteBuffer> newChunk(int pageSize, int maxPageIdx, int pageShifts, int chunkSize) {
            if (this.directMemoryCacheAlignment == 0) {
                ByteBuffer memory = allocateDirect(chunkSize);
                return new PoolChunk<>(this, memory, memory, pageSize, pageShifts, chunkSize, maxPageIdx);
            }
            ByteBuffer base = allocateDirect(chunkSize + this.directMemoryCacheAlignment);
            return new PoolChunk<>(this, base, PlatformDependent.alignDirectBuffer(base, this.directMemoryCacheAlignment), pageSize, pageShifts, chunkSize, maxPageIdx);
        }

        @Override // p013io.netty.buffer.PoolArena
        protected PoolChunk<ByteBuffer> newUnpooledChunk(int capacity) {
            if (this.directMemoryCacheAlignment == 0) {
                ByteBuffer memory = allocateDirect(capacity);
                return new PoolChunk<>(this, memory, memory, capacity);
            }
            ByteBuffer base = allocateDirect(capacity + this.directMemoryCacheAlignment);
            return new PoolChunk<>(this, base, PlatformDependent.alignDirectBuffer(base, this.directMemoryCacheAlignment), capacity);
        }

        private static ByteBuffer allocateDirect(int capacity) {
            return PlatformDependent.useDirectBufferNoCleaner() ? PlatformDependent.allocateDirectNoCleaner(capacity) : ByteBuffer.allocateDirect(capacity);
        }

        @Override // p013io.netty.buffer.PoolArena
        protected void destroyChunk(PoolChunk<ByteBuffer> chunk) {
            if (PlatformDependent.useDirectBufferNoCleaner()) {
                PlatformDependent.freeDirectNoCleaner((ByteBuffer) chunk.base);
            } else {
                PlatformDependent.freeDirectBuffer((ByteBuffer) chunk.base);
            }
        }

        @Override // p013io.netty.buffer.PoolArena
        protected PooledByteBuf<ByteBuffer> newByteBuf(int maxCapacity) {
            if (HAS_UNSAFE) {
                return PooledUnsafeDirectByteBuf.newInstance(maxCapacity);
            }
            return PooledDirectByteBuf.newInstance(maxCapacity);
        }

        /* access modifiers changed from: protected */
        public void memoryCopy(ByteBuffer src, int srcOffset, PooledByteBuf<ByteBuffer> dstBuf, int length) {
            if (length != 0) {
                if (HAS_UNSAFE) {
                    PlatformDependent.copyMemory(PlatformDependent.directBufferAddress(src) + ((long) srcOffset), PlatformDependent.directBufferAddress(dstBuf.memory) + ((long) dstBuf.offset), (long) length);
                    return;
                }
                ByteBuffer src2 = src.duplicate();
                ByteBuffer dst = dstBuf.internalNioBuffer();
                src2.position(srcOffset).limit(srcOffset + length);
                dst.position(dstBuf.offset);
                dst.put(src2);
            }
        }
    }
}
