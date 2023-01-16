package p013io.netty.buffer;

/* access modifiers changed from: package-private */
/* renamed from: io.netty.buffer.PoolSubpage */
/* loaded from: grasscutter.jar:io/netty/buffer/PoolSubpage.class */
public final class PoolSubpage<T> implements PoolSubpageMetric {
    final PoolChunk<T> chunk;
    final int elemSize;
    private final int pageShifts;
    private final int runOffset;
    private final int runSize;
    private final long[] bitmap;
    PoolSubpage<T> prev;
    PoolSubpage<T> next;
    boolean doNotDestroy;
    private int maxNumElems;
    private int bitmapLength;
    private int nextAvail;
    private int numAvail;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !PoolSubpage.class.desiredAssertionStatus();
    }

    /* access modifiers changed from: package-private */
    public PoolSubpage() {
        this.chunk = null;
        this.pageShifts = -1;
        this.runOffset = -1;
        this.elemSize = -1;
        this.runSize = -1;
        this.bitmap = null;
    }

    /* access modifiers changed from: package-private */
    public PoolSubpage(PoolSubpage<T> head, PoolChunk<T> chunk, int pageShifts, int runOffset, int runSize, int elemSize) {
        this.chunk = chunk;
        this.pageShifts = pageShifts;
        this.runOffset = runOffset;
        this.runSize = runSize;
        this.elemSize = elemSize;
        this.bitmap = new long[runSize >>> 10];
        this.doNotDestroy = true;
        if (elemSize != 0) {
            int i = runSize / elemSize;
            this.numAvail = i;
            this.maxNumElems = i;
            this.nextAvail = 0;
            this.bitmapLength = this.maxNumElems >>> 6;
            if ((this.maxNumElems & 63) != 0) {
                this.bitmapLength++;
            }
            for (int i2 = 0; i2 < this.bitmapLength; i2++) {
                this.bitmap[i2] = 0;
            }
        }
        addToPool(head);
    }

    /* access modifiers changed from: package-private */
    public long allocate() {
        if (this.numAvail == 0 || !this.doNotDestroy) {
            return -1;
        }
        int bitmapIdx = getNextAvail();
        int q = bitmapIdx >>> 6;
        int r = bitmapIdx & 63;
        if ($assertionsDisabled || ((this.bitmap[q] >>> r) & 1) == 0) {
            long[] jArr = this.bitmap;
            jArr[q] = jArr[q] | (1 << r);
            int i = this.numAvail - 1;
            this.numAvail = i;
            if (i == 0) {
                removeFromPool();
            }
            return toHandle(bitmapIdx);
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    public boolean free(PoolSubpage<T> head, int bitmapIdx) {
        if (this.elemSize == 0) {
            return true;
        }
        int q = bitmapIdx >>> 6;
        int r = bitmapIdx & 63;
        if ($assertionsDisabled || ((this.bitmap[q] >>> r) & 1) != 0) {
            long[] jArr = this.bitmap;
            jArr[q] = jArr[q] ^ (1 << r);
            setNextAvail(bitmapIdx);
            int i = this.numAvail;
            this.numAvail = i + 1;
            if (i == 0) {
                addToPool(head);
                if (this.maxNumElems > 1) {
                    return true;
                }
            }
            if (this.numAvail != this.maxNumElems || this.prev == this.next) {
                return true;
            }
            this.doNotDestroy = false;
            removeFromPool();
            return false;
        }
        throw new AssertionError();
    }

    private void addToPool(PoolSubpage<T> head) {
        if ($assertionsDisabled || (this.prev == null && this.next == null)) {
            this.prev = head;
            this.next = head.next;
            this.next.prev = this;
            head.next = this;
            return;
        }
        throw new AssertionError();
    }

    private void removeFromPool() {
        if ($assertionsDisabled || !(this.prev == null || this.next == null)) {
            this.prev.next = this.next;
            this.next.prev = this.prev;
            this.next = null;
            this.prev = null;
            return;
        }
        throw new AssertionError();
    }

    private void setNextAvail(int bitmapIdx) {
        this.nextAvail = bitmapIdx;
    }

    private int getNextAvail() {
        int nextAvail = this.nextAvail;
        if (nextAvail < 0) {
            return findNextAvail();
        }
        this.nextAvail = -1;
        return nextAvail;
    }

    private int findNextAvail() {
        long[] bitmap = this.bitmap;
        int bitmapLength = this.bitmapLength;
        for (int i = 0; i < bitmapLength; i++) {
            long bits = bitmap[i];
            if ((bits ^ -1) != 0) {
                return findNextAvail0(i, bits);
            }
        }
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v1, types: [long] */
    /* JADX WARN: Type inference failed for: r0v16, types: [long] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int findNextAvail0(int r6, long r7) {
        /*
            r5 = this;
            r0 = r5
            int r0 = r0.maxNumElems
            r9 = r0
            r0 = r6
            r1 = 6
            int r0 = r0 << r1
            r10 = r0
            r0 = 0
            r11 = r0
        L_0x000f:
            r0 = r11
            r1 = 64
            if (r0 >= r1) goto L_0x0039
            r0 = r7
            r1 = 1
            long r0 = r0 & r1
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x002f
            r0 = r10
            r1 = r11
            r0 = r0 | r1
            r12 = r0
            r0 = r12
            r1 = r9
            if (r0 >= r1) goto L_0x0039
            r0 = r12
            return r0
        L_0x002f:
            r0 = r7
            r1 = 1
            long r0 = r0 >>> r1
            r7 = r0
            int r11 = r11 + 1
            goto L_0x000f
        L_0x0039:
            r0 = -1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.buffer.PoolSubpage.findNextAvail0(int, long):int");
    }

    private long toHandle(int bitmapIdx) {
        return (((long) this.runOffset) << 49) | (((long) (this.runSize >> this.pageShifts)) << 34) | 8589934592L | 4294967296L | ((long) bitmapIdx);
    }

    public String toString() {
        int elemSize;
        int numAvail;
        int maxNumElems;
        boolean doNotDestroy;
        if (this.chunk == null) {
            doNotDestroy = true;
            maxNumElems = 0;
            numAvail = 0;
            elemSize = -1;
        } else {
            synchronized (this.chunk.arena) {
                if (!this.doNotDestroy) {
                    doNotDestroy = false;
                    elemSize = -1;
                    numAvail = -1;
                    maxNumElems = -1;
                } else {
                    doNotDestroy = true;
                    maxNumElems = this.maxNumElems;
                    numAvail = this.numAvail;
                    elemSize = this.elemSize;
                }
            }
        }
        if (!doNotDestroy) {
            return "(" + this.runOffset + ": not in use)";
        }
        return "(" + this.runOffset + ": " + (maxNumElems - numAvail) + '/' + maxNumElems + ", offset: " + this.runOffset + ", length: " + this.runSize + ", elemSize: " + elemSize + ')';
    }

    @Override // p013io.netty.buffer.PoolSubpageMetric
    public int maxNumElements() {
        int i;
        if (this.chunk == null) {
            return 0;
        }
        synchronized (this.chunk.arena) {
            i = this.maxNumElems;
        }
        return i;
    }

    @Override // p013io.netty.buffer.PoolSubpageMetric
    public int numAvailable() {
        int i;
        if (this.chunk == null) {
            return 0;
        }
        synchronized (this.chunk.arena) {
            i = this.numAvail;
        }
        return i;
    }

    @Override // p013io.netty.buffer.PoolSubpageMetric
    public int elementSize() {
        int i;
        if (this.chunk == null) {
            return -1;
        }
        synchronized (this.chunk.arena) {
            i = this.elemSize;
        }
        return i;
    }

    @Override // p013io.netty.buffer.PoolSubpageMetric
    public int pageSize() {
        return 1 << this.pageShifts;
    }

    /* access modifiers changed from: package-private */
    public void destroy() {
        if (this.chunk != null) {
            this.chunk.destroy();
        }
    }
}
