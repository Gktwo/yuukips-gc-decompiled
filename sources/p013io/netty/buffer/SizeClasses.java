package p013io.netty.buffer;

/* access modifiers changed from: package-private */
/* renamed from: io.netty.buffer.SizeClasses */
/* loaded from: grasscutter.jar:io/netty/buffer/SizeClasses.class */
public abstract class SizeClasses implements SizeClassesMetric {
    static final int LOG2_QUANTUM = 4;
    private static final int LOG2_SIZE_CLASS_GROUP = 2;
    private static final int LOG2_MAX_LOOKUP_SIZE = 12;
    private static final int INDEX_IDX = 0;
    private static final int LOG2GROUP_IDX = 1;
    private static final int LOG2DELTA_IDX = 2;
    private static final int NDELTA_IDX = 3;
    private static final int PAGESIZE_IDX = 4;
    private static final int SUBPAGE_IDX = 5;
    private static final int LOG2_DELTA_LOOKUP_IDX = 6;

    /* renamed from: no */
    private static final byte f976no = 0;
    private static final byte yes = 1;
    protected final int pageSize;
    protected final int pageShifts;
    protected final int chunkSize;
    protected final int directMemoryCacheAlignment;
    final int nSizes;
    final int nSubpages;
    final int nPSizes;
    final int lookupMaxSize;
    final int smallMaxSizeIdx;
    private final int[] pageIdx2sizeTab;
    private final int[] sizeIdx2sizeTab;
    private final int[] size2idxTab;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !SizeClasses.class.desiredAssertionStatus();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v37, resolved type: short[] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v39, resolved type: short */
    /* JADX DEBUG: Multi-variable search result rejected for r0v41, resolved type: short */
    /* JADX DEBUG: Multi-variable search result rejected for r0v43, resolved type: short */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [short[][][][], short[][]] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public SizeClasses(int r7, int r8, int r9, int r10) {
        /*
        // Method dump skipped, instructions count: 358
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.buffer.SizeClasses.<init>(int, int, int, int):void");
    }

    private static short[] newSizeClass(int index, int log2Group, int log2Delta, int nDelta, int pageShifts) {
        short isMultiPageSize;
        if (log2Delta >= pageShifts) {
            isMultiPageSize = 1;
        } else {
            int pageSize = 1 << pageShifts;
            int size = calculateSize(log2Group, nDelta, log2Delta);
            isMultiPageSize = size == (size / pageSize) * pageSize ? (short) 1 : 0;
        }
        int log2Ndelta = nDelta == 0 ? 0 : PoolThreadCache.log2(nDelta);
        byte remove = (1 << log2Ndelta) < nDelta ? (byte) 1 : 0;
        int log2Size = log2Delta + log2Ndelta == log2Group ? log2Group + 1 : log2Group;
        if (log2Size == log2Group) {
            remove = 1;
        }
        return new short[]{(short) index, (short) log2Group, (short) log2Delta, (short) nDelta, isMultiPageSize, log2Size < pageShifts + 2 ? (short) 1 : 0, (short) ((log2Size < 12 || (log2Size == 12 && remove == 0)) ? log2Delta : 0)};
    }

    private static int[] newIdx2SizeTab(short[][] sizeClasses, int nSizes, int directMemoryCacheAlignment) {
        int[] sizeIdx2sizeTab = new int[nSizes];
        for (int i = 0; i < nSizes; i++) {
            sizeIdx2sizeTab[i] = sizeOf(sizeClasses[i], directMemoryCacheAlignment);
        }
        return sizeIdx2sizeTab;
    }

    private static int calculateSize(int log2Group, int nDelta, int log2Delta) {
        return (1 << log2Group) + (nDelta << log2Delta);
    }

    private static int sizeOf(short[] sizeClass, int directMemoryCacheAlignment) {
        return alignSizeIfNeeded(calculateSize(sizeClass[1], sizeClass[3], sizeClass[2]), directMemoryCacheAlignment);
    }

    private static int[] newPageIdx2sizeTab(short[][] sizeClasses, int nSizes, int nPSizes, int directMemoryCacheAlignment) {
        int[] pageIdx2sizeTab = new int[nPSizes];
        int pageIdx = 0;
        for (int i = 0; i < nSizes; i++) {
            short[] sizeClass = sizeClasses[i];
            if (sizeClass[4] == 1) {
                pageIdx++;
                pageIdx2sizeTab[pageIdx] = sizeOf(sizeClass, directMemoryCacheAlignment);
            }
        }
        return pageIdx2sizeTab;
    }

    private static int[] newSize2idxTab(int lookupMaxSize, short[][] sizeClasses) {
        int[] size2idxTab = new int[lookupMaxSize >> 4];
        int idx = 0;
        int size = 0;
        int i = 0;
        while (size <= lookupMaxSize) {
            int times = 1 << (sizeClasses[i][2] - 4);
            while (size <= lookupMaxSize) {
                times--;
                if (times > 0) {
                    idx++;
                    size2idxTab[idx] = i;
                    size = (idx + 1) << 4;
                }
            }
            i++;
        }
        return size2idxTab;
    }

    @Override // p013io.netty.buffer.SizeClassesMetric
    public int sizeIdx2size(int sizeIdx) {
        return this.sizeIdx2sizeTab[sizeIdx];
    }

    @Override // p013io.netty.buffer.SizeClassesMetric
    public int sizeIdx2sizeCompute(int sizeIdx) {
        int group = sizeIdx >> 2;
        return (group == 0 ? 0 : 32 << group) + (((sizeIdx & 3) + 1) << (((group == 0 ? 1 : group) + 4) - 1));
    }

    @Override // p013io.netty.buffer.SizeClassesMetric
    public long pageIdx2size(int pageIdx) {
        return (long) this.pageIdx2sizeTab[pageIdx];
    }

    @Override // p013io.netty.buffer.SizeClassesMetric
    public long pageIdx2sizeCompute(int pageIdx) {
        int group = pageIdx >> 2;
        return (group == 0 ? 0 : (1 << ((this.pageShifts + 2) - 1)) << group) + ((long) (((pageIdx & 3) + 1) << (((group == 0 ? 1 : group) + this.pageShifts) - 1)));
    }

    @Override // p013io.netty.buffer.SizeClassesMetric
    public int size2SizeIdx(int size) {
        if (size == 0) {
            return 0;
        }
        if (size > this.chunkSize) {
            return this.nSizes;
        }
        int size2 = alignSizeIfNeeded(size, this.directMemoryCacheAlignment);
        if (size2 <= this.lookupMaxSize) {
            return this.size2idxTab[(size2 - 1) >> 4];
        }
        int x = PoolThreadCache.log2((size2 << 1) - 1);
        int group = (x < 7 ? 0 : x - 6) << 2;
        int log2Delta = x < 7 ? 4 : (x - 2) - 1;
        return group + ((((size2 - 1) & (-1 << log2Delta)) >> log2Delta) & 3);
    }

    @Override // p013io.netty.buffer.SizeClassesMetric
    public int pages2pageIdx(int pages) {
        return pages2pageIdxCompute(pages, false);
    }

    @Override // p013io.netty.buffer.SizeClassesMetric
    public int pages2pageIdxFloor(int pages) {
        return pages2pageIdxCompute(pages, true);
    }

    private int pages2pageIdxCompute(int pages, boolean floor) {
        int pageSize = pages << this.pageShifts;
        if (pageSize > this.chunkSize) {
            return this.nPSizes;
        }
        int x = PoolThreadCache.log2((pageSize << 1) - 1);
        int group = (x < 2 + this.pageShifts ? 0 : x - (2 + this.pageShifts)) << 2;
        int log2Delta = x < (2 + this.pageShifts) + 1 ? this.pageShifts : (x - 2) - 1;
        int pageIdx = group + ((((pageSize - 1) & (-1 << log2Delta)) >> log2Delta) & 3);
        if (floor && this.pageIdx2sizeTab[pageIdx] > (pages << this.pageShifts)) {
            pageIdx--;
        }
        return pageIdx;
    }

    private static int alignSizeIfNeeded(int size, int directMemoryCacheAlignment) {
        if (directMemoryCacheAlignment <= 0) {
            return size;
        }
        int delta = size & (directMemoryCacheAlignment - 1);
        return delta == 0 ? size : (size + directMemoryCacheAlignment) - delta;
    }

    @Override // p013io.netty.buffer.SizeClassesMetric
    public int normalizeSize(int size) {
        if (size == 0) {
            return this.sizeIdx2sizeTab[0];
        }
        int size2 = alignSizeIfNeeded(size, this.directMemoryCacheAlignment);
        if (size2 > this.lookupMaxSize) {
            return normalizeSizeCompute(size2);
        }
        int ret = this.sizeIdx2sizeTab[this.size2idxTab[(size2 - 1) >> 4]];
        if ($assertionsDisabled || ret == normalizeSizeCompute(size2)) {
            return ret;
        }
        throw new AssertionError();
    }

    private static int normalizeSizeCompute(int size) {
        int x = PoolThreadCache.log2((size << 1) - 1);
        int delta_mask = (1 << (x < 7 ? 4 : (x - 2) - 1)) - 1;
        return (size + delta_mask) & (delta_mask ^ -1);
    }
}
