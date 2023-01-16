package p013io.netty.buffer;

import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.Deque;
import p013io.netty.util.internal.LongCounter;
import p013io.netty.util.internal.PlatformDependent;

/* access modifiers changed from: package-private */
/* renamed from: io.netty.buffer.PoolChunk */
/* loaded from: grasscutter.jar:io/netty/buffer/PoolChunk.class */
public final class PoolChunk<T> implements PoolChunkMetric {
    private static final int SIZE_BIT_LENGTH = 15;
    private static final int INUSED_BIT_LENGTH = 1;
    private static final int SUBPAGE_BIT_LENGTH = 1;
    private static final int BITMAP_IDX_BIT_LENGTH = 32;
    static final int IS_SUBPAGE_SHIFT = 32;
    static final int IS_USED_SHIFT = 33;
    static final int SIZE_SHIFT = 34;
    static final int RUN_OFFSET_SHIFT = 49;
    final PoolArena<T> arena;
    final Object base;
    final T memory;
    final boolean unpooled;
    private final LongLongHashMap runsAvailMap;
    private final LongPriorityQueue[] runsAvail;
    private final PoolSubpage<T>[] subpages;
    private final LongCounter pinnedBytes;
    private final int pageSize;
    private final int pageShifts;
    private final int chunkSize;
    private final Deque<ByteBuffer> cachedNioBuffers;
    int freeBytes;
    PoolChunkList<T> parent;
    PoolChunk<T> prev;
    PoolChunk<T> next;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !PoolChunk.class.desiredAssertionStatus();
    }

    /* access modifiers changed from: package-private */
    public PoolChunk(PoolArena<T> arena, Object base, T memory, int pageSize, int pageShifts, int chunkSize, int maxPageIdx) {
        this.pinnedBytes = PlatformDependent.newLongCounter();
        this.unpooled = false;
        this.arena = arena;
        this.base = base;
        this.memory = memory;
        this.pageSize = pageSize;
        this.pageShifts = pageShifts;
        this.chunkSize = chunkSize;
        this.freeBytes = chunkSize;
        this.runsAvail = newRunsAvailqueueArray(maxPageIdx);
        this.runsAvailMap = new LongLongHashMap(-1);
        this.subpages = new PoolSubpage[chunkSize >> pageShifts];
        int pages = chunkSize >> pageShifts;
        insertAvailRun(0, pages, ((long) pages) << 34);
        this.cachedNioBuffers = new ArrayDeque(8);
    }

    /* access modifiers changed from: package-private */
    public PoolChunk(PoolArena<T> arena, Object base, T memory, int size) {
        this.pinnedBytes = PlatformDependent.newLongCounter();
        this.unpooled = true;
        this.arena = arena;
        this.base = base;
        this.memory = memory;
        this.pageSize = 0;
        this.pageShifts = 0;
        this.runsAvailMap = null;
        this.runsAvail = null;
        this.subpages = null;
        this.chunkSize = size;
        this.cachedNioBuffers = null;
    }

    private static LongPriorityQueue[] newRunsAvailqueueArray(int size) {
        LongPriorityQueue[] queueArray = new LongPriorityQueue[size];
        for (int i = 0; i < queueArray.length; i++) {
            queueArray[i] = new LongPriorityQueue();
        }
        return queueArray;
    }

    private void insertAvailRun(int runOffset, int pages, long handle) {
        this.runsAvail[this.arena.pages2pageIdxFloor(pages)].offer(handle);
        insertAvailRun0(runOffset, handle);
        if (pages > 1) {
            insertAvailRun0(lastPage(runOffset, pages), handle);
        }
    }

    private void insertAvailRun0(int runOffset, long handle) {
        long pre = this.runsAvailMap.put((long) runOffset, handle);
        if (!$assertionsDisabled && pre != -1) {
            throw new AssertionError();
        }
    }

    private void removeAvailRun(long handle) {
        removeAvailRun(this.runsAvail[this.arena.pages2pageIdxFloor(runPages(handle))], handle);
    }

    private void removeAvailRun(LongPriorityQueue queue, long handle) {
        queue.remove(handle);
        int runOffset = runOffset(handle);
        int pages = runPages(handle);
        this.runsAvailMap.remove((long) runOffset);
        if (pages > 1) {
            this.runsAvailMap.remove((long) lastPage(runOffset, pages));
        }
    }

    private static int lastPage(int runOffset, int pages) {
        return (runOffset + pages) - 1;
    }

    private long getAvailRunByOffset(int runOffset) {
        return this.runsAvailMap.get((long) runOffset);
    }

    @Override // p013io.netty.buffer.PoolChunkMetric
    public int usage() {
        int freeBytes;
        synchronized (this.arena) {
            freeBytes = this.freeBytes;
        }
        return usage(freeBytes);
    }

    private int usage(int freeBytes) {
        if (freeBytes == 0) {
            return 100;
        }
        int freePercentage = (int) ((((long) freeBytes) * 100) / ((long) this.chunkSize));
        if (freePercentage == 0) {
            return 99;
        }
        return 100 - freePercentage;
    }

    /* JADX WARN: Type inference failed for: r0v15, types: [long] */
    /* JADX WARN: Type inference failed for: r0v24, types: [long] */
    /* access modifiers changed from: package-private */
    public boolean allocate(PooledByteBuf<T> buf, int reqCapacity, int sizeIdx, PoolThreadCache cache) {
        char c;
        if (sizeIdx <= this.arena.smallMaxSizeIdx) {
            c = allocateSubpage(sizeIdx);
            if (c < 0) {
                return false;
            }
            if (!$assertionsDisabled && !isSubpage(c)) {
                throw new AssertionError();
            }
        } else {
            c = allocateRun(this.arena.sizeIdx2size(sizeIdx));
            if (c < 0) {
                return false;
            }
            if (!$assertionsDisabled && isSubpage(c)) {
                throw new AssertionError();
            }
        }
        initBuf(buf, this.cachedNioBuffers != null ? this.cachedNioBuffers.pollLast() : null, c, reqCapacity, cache);
        return true;
    }

    /* JADX WARN: Type inference failed for: r0v16, types: [long] */
    /* JADX WARN: Type inference failed for: r0v27, types: [long] */
    private long allocateRun(int runSize) {
        int pages = runSize >> this.pageShifts;
        int pageIdx = this.arena.pages2pageIdx(pages);
        synchronized (this.runsAvail) {
            int queueIdx = runFirstBestFit(pageIdx);
            if (queueIdx == -1) {
                return -1;
            }
            LongPriorityQueue queue = this.runsAvail[queueIdx];
            char poll = queue.poll();
            if ($assertionsDisabled || (poll != -1 && !isUsed(poll))) {
                removeAvailRun(queue, poll);
                if (poll != -1) {
                    poll = splitLargeRun(poll, pages);
                }
                this.freeBytes -= runSize(this.pageShifts, poll);
                return poll;
            }
            throw new AssertionError("invalid handle: " + ((long) poll));
        }
    }

    private int calculateRunSize(int sizeIdx) {
        int nElements;
        int maxElements = 1 << (this.pageShifts - 4);
        int runSize = 0;
        int elemSize = this.arena.sizeIdx2size(sizeIdx);
        do {
            runSize += this.pageSize;
            nElements = runSize / elemSize;
            if (nElements >= maxElements) {
                break;
            }
        } while (runSize != nElements * elemSize);
        while (nElements > maxElements) {
            runSize -= this.pageSize;
            nElements = runSize / elemSize;
        }
        if (!$assertionsDisabled && nElements <= 0) {
            throw new AssertionError();
        } else if (!$assertionsDisabled && runSize > this.chunkSize) {
            throw new AssertionError();
        } else if ($assertionsDisabled || runSize >= elemSize) {
            return runSize;
        } else {
            throw new AssertionError();
        }
    }

    private int runFirstBestFit(int pageIdx) {
        if (this.freeBytes == this.chunkSize) {
            return this.arena.nPSizes - 1;
        }
        for (int i = pageIdx; i < this.arena.nPSizes; i++) {
            LongPriorityQueue queue = this.runsAvail[i];
            if (!(queue == null || queue.isEmpty())) {
                return i;
            }
        }
        return -1;
    }

    private long splitLargeRun(long handle, int needPages) {
        if ($assertionsDisabled || needPages > 0) {
            int totalPages = runPages(handle);
            if ($assertionsDisabled || needPages <= totalPages) {
                int remPages = totalPages - needPages;
                if (remPages <= 0) {
                    return handle | 8589934592L;
                }
                int runOffset = runOffset(handle);
                int availOffset = runOffset + needPages;
                insertAvailRun(availOffset, remPages, toRunHandle(availOffset, remPages, 0));
                return toRunHandle(runOffset, needPages, 1);
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    private long allocateSubpage(int sizeIdx) {
        PoolSubpage<T> head = this.arena.findSubpagePoolHead(sizeIdx);
        synchronized (head) {
            long runHandle = allocateRun(calculateRunSize(sizeIdx));
            if (runHandle < 0) {
                return -1;
            }
            int runOffset = runOffset(runHandle);
            if ($assertionsDisabled || this.subpages[runOffset] == null) {
                PoolSubpage<T> subpage = new PoolSubpage<>(head, this, this.pageShifts, runOffset, runSize(this.pageShifts, runHandle), this.arena.sizeIdx2size(sizeIdx));
                this.subpages[runOffset] = subpage;
                return subpage.allocate();
            }
            throw new AssertionError();
        }
    }

    /* access modifiers changed from: package-private */
    public void free(long handle, int normCapacity, ByteBuffer nioBuffer) {
        int runSize = runSize(this.pageShifts, handle);
        if (isSubpage(handle)) {
            PoolSubpage<T> head = this.arena.findSubpagePoolHead(this.arena.size2SizeIdx(normCapacity));
            int sIdx = runOffset(handle);
            PoolSubpage<T> subpage = this.subpages[sIdx];
            if ($assertionsDisabled || (subpage != null && subpage.doNotDestroy)) {
                synchronized (head) {
                    if (!subpage.free(head, bitmapIdx(handle))) {
                        if ($assertionsDisabled || !subpage.doNotDestroy) {
                            this.subpages[sIdx] = null;
                        } else {
                            throw new AssertionError();
                        }
                    } else {
                        return;
                    }
                }
            } else {
                throw new AssertionError();
            }
        }
        synchronized (this.runsAvail) {
            long finalRun = collapseRuns(handle) & -8589934593L & -4294967297L;
            insertAvailRun(runOffset(finalRun), runPages(finalRun), finalRun);
            this.freeBytes += runSize;
        }
        if (nioBuffer != null && this.cachedNioBuffers != null && this.cachedNioBuffers.size() < PooledByteBufAllocator.DEFAULT_MAX_CACHED_BYTEBUFFERS_PER_CHUNK) {
            this.cachedNioBuffers.offer(nioBuffer);
        }
    }

    private long collapseRuns(long handle) {
        return collapseNext(collapsePast(handle));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1, types: [long] */
    /* JADX WARN: Type inference failed for: r0v20, types: [long] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARNING: Code restructure failed: missing block: B:0:?, code lost:
        r6 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0053, code lost:
        return r6;
     */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private long collapsePast(long r6) {
        /*
            r5 = this;
        L_0x0000:
            r0 = r6
            int r0 = runOffset(r0)
            r8 = r0
            r0 = r6
            int r0 = runPages(r0)
            r9 = r0
            r0 = r5
            r1 = r8
            r2 = 1
            int r1 = r1 - r2
            long r0 = r0.getAvailRunByOffset(r1)
            r10 = r0
            r0 = r10
            r1 = -1
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x001f
            r0 = r6
            return r0
        L_0x001f:
            r0 = r10
            int r0 = runOffset(r0)
            r12 = r0
            r0 = r10
            int r0 = runPages(r0)
            r13 = r0
            r0 = r10
            r1 = r6
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0052
            r0 = r12
            r1 = r13
            int r0 = r0 + r1
            r1 = r8
            if (r0 != r1) goto L_0x0052
            r0 = r5
            r1 = r10
            r0.removeAvailRun(r1)
            r0 = r12
            r1 = r13
            r2 = r9
            int r1 = r1 + r2
            r2 = 0
            long r0 = toRunHandle(r0, r1, r2)
            r6 = r0
            goto L_0x0054
        L_0x0052:
            r0 = r6
            return r0
        L_0x0054:
            goto L_0x0000
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.buffer.PoolChunk.collapsePast(long):long");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1, types: [long] */
    /* JADX WARN: Type inference failed for: r0v20, types: [long] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARNING: Code restructure failed: missing block: B:0:?, code lost:
        r6 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0053, code lost:
        return r6;
     */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private long collapseNext(long r6) {
        /*
            r5 = this;
        L_0x0000:
            r0 = r6
            int r0 = runOffset(r0)
            r8 = r0
            r0 = r6
            int r0 = runPages(r0)
            r9 = r0
            r0 = r5
            r1 = r8
            r2 = r9
            int r1 = r1 + r2
            long r0 = r0.getAvailRunByOffset(r1)
            r10 = r0
            r0 = r10
            r1 = -1
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x0020
            r0 = r6
            return r0
        L_0x0020:
            r0 = r10
            int r0 = runOffset(r0)
            r12 = r0
            r0 = r10
            int r0 = runPages(r0)
            r13 = r0
            r0 = r10
            r1 = r6
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0052
            r0 = r8
            r1 = r9
            int r0 = r0 + r1
            r1 = r12
            if (r0 != r1) goto L_0x0052
            r0 = r5
            r1 = r10
            r0.removeAvailRun(r1)
            r0 = r8
            r1 = r9
            r2 = r13
            int r1 = r1 + r2
            r2 = 0
            long r0 = toRunHandle(r0, r1, r2)
            r6 = r0
            goto L_0x0054
        L_0x0052:
            r0 = r6
            return r0
        L_0x0054:
            goto L_0x0000
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.buffer.PoolChunk.collapseNext(long):long");
    }

    private static long toRunHandle(int runOffset, int runPages, int inUsed) {
        return (((long) runOffset) << 49) | (((long) runPages) << 34) | (((long) inUsed) << 33);
    }

    /* access modifiers changed from: package-private */
    public void initBuf(PooledByteBuf<T> buf, ByteBuffer nioBuffer, long handle, int reqCapacity, PoolThreadCache threadCache) {
        if (isSubpage(handle)) {
            initBufWithSubpage(buf, nioBuffer, handle, reqCapacity, threadCache);
            return;
        }
        buf.init(this, nioBuffer, handle, runOffset(handle) << this.pageShifts, reqCapacity, runSize(this.pageShifts, handle), this.arena.parent.threadCache());
    }

    /* access modifiers changed from: package-private */
    public void initBufWithSubpage(PooledByteBuf<T> buf, ByteBuffer nioBuffer, long handle, int reqCapacity, PoolThreadCache threadCache) {
        int runOffset = runOffset(handle);
        int bitmapIdx = bitmapIdx(handle);
        PoolSubpage<T> s = this.subpages[runOffset];
        if (!$assertionsDisabled && !s.doNotDestroy) {
            throw new AssertionError();
        } else if ($assertionsDisabled || reqCapacity <= s.elemSize) {
            buf.init(this, nioBuffer, handle, (runOffset << this.pageShifts) + (bitmapIdx * s.elemSize), reqCapacity, s.elemSize, threadCache);
        } else {
            throw new AssertionError(reqCapacity + "<=" + s.elemSize);
        }
    }

    /* access modifiers changed from: package-private */
    public void incrementPinnedMemory(int delta) {
        if ($assertionsDisabled || delta > 0) {
            this.pinnedBytes.add((long) delta);
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    public void decrementPinnedMemory(int delta) {
        if ($assertionsDisabled || delta > 0) {
            this.pinnedBytes.add((long) (-delta));
            return;
        }
        throw new AssertionError();
    }

    @Override // p013io.netty.buffer.PoolChunkMetric
    public int chunkSize() {
        return this.chunkSize;
    }

    @Override // p013io.netty.buffer.PoolChunkMetric
    public int freeBytes() {
        int i;
        synchronized (this.arena) {
            i = this.freeBytes;
        }
        return i;
    }

    public int pinnedBytes() {
        return (int) this.pinnedBytes.value();
    }

    public String toString() {
        int freeBytes;
        synchronized (this.arena) {
            freeBytes = this.freeBytes;
        }
        return "Chunk(" + Integer.toHexString(System.identityHashCode(this)) + ": " + usage(freeBytes) + "%, " + (this.chunkSize - freeBytes) + '/' + this.chunkSize + ')';
    }

    /* access modifiers changed from: package-private */
    public void destroy() {
        this.arena.destroyChunk(this);
    }

    static int runOffset(long handle) {
        return (int) (handle >> 49);
    }

    static int runSize(int pageShifts, long handle) {
        return runPages(handle) << pageShifts;
    }

    static int runPages(long handle) {
        return (int) ((handle >> 34) & 32767);
    }

    static boolean isUsed(long handle) {
        return ((handle >> 33) & 1) == 1;
    }

    static boolean isRun(long handle) {
        return !isSubpage(handle);
    }

    /* access modifiers changed from: package-private */
    public static boolean isSubpage(long handle) {
        return ((handle >> 32) & 1) == 1;
    }

    static int bitmapIdx(long handle) {
        return (int) handle;
    }
}
