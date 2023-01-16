package p013io.netty.buffer;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import p013io.netty.buffer.PoolArena;
import p013io.netty.util.internal.MathUtil;
import p013io.netty.util.internal.ObjectPool;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.PlatformDependent;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

/* access modifiers changed from: package-private */
/* renamed from: io.netty.buffer.PoolThreadCache */
/* loaded from: grasscutter.jar:io/netty/buffer/PoolThreadCache.class */
public final class PoolThreadCache {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(PoolThreadCache.class);
    private static final int INTEGER_SIZE_MINUS_ONE = 31;
    final PoolArena<byte[]> heapArena;
    final PoolArena<ByteBuffer> directArena;
    private final MemoryRegionCache<byte[]>[] smallSubPageHeapCaches;
    private final MemoryRegionCache<ByteBuffer>[] smallSubPageDirectCaches;
    private final MemoryRegionCache<byte[]>[] normalHeapCaches;
    private final MemoryRegionCache<ByteBuffer>[] normalDirectCaches;
    private final int freeSweepAllocationThreshold;
    private final AtomicBoolean freed = new AtomicBoolean();
    private int allocations;

    /* access modifiers changed from: package-private */
    public PoolThreadCache(PoolArena<byte[]> heapArena, PoolArena<ByteBuffer> directArena, int smallCacheSize, int normalCacheSize, int maxCachedBufferCapacity, int freeSweepAllocationThreshold) {
        ObjectUtil.checkPositiveOrZero(maxCachedBufferCapacity, "maxCachedBufferCapacity");
        this.freeSweepAllocationThreshold = freeSweepAllocationThreshold;
        this.heapArena = heapArena;
        this.directArena = directArena;
        if (directArena != null) {
            this.smallSubPageDirectCaches = createSubPageCaches(smallCacheSize, directArena.numSmallSubpagePools);
            this.normalDirectCaches = createNormalCaches(normalCacheSize, maxCachedBufferCapacity, directArena);
            directArena.numThreadCaches.getAndIncrement();
        } else {
            this.smallSubPageDirectCaches = null;
            this.normalDirectCaches = null;
        }
        if (heapArena != null) {
            this.smallSubPageHeapCaches = createSubPageCaches(smallCacheSize, heapArena.numSmallSubpagePools);
            this.normalHeapCaches = createNormalCaches(normalCacheSize, maxCachedBufferCapacity, heapArena);
            heapArena.numThreadCaches.getAndIncrement();
        } else {
            this.smallSubPageHeapCaches = null;
            this.normalHeapCaches = null;
        }
        if (!(this.smallSubPageDirectCaches == null && this.normalDirectCaches == null && this.smallSubPageHeapCaches == null && this.normalHeapCaches == null) && freeSweepAllocationThreshold < 1) {
            throw new IllegalArgumentException("freeSweepAllocationThreshold: " + freeSweepAllocationThreshold + " (expected: > 0)");
        }
    }

    private static <T> MemoryRegionCache<T>[] createSubPageCaches(int cacheSize, int numCaches) {
        if (cacheSize <= 0 || numCaches <= 0) {
            return null;
        }
        MemoryRegionCache<T>[] cache = new MemoryRegionCache[numCaches];
        for (int i = 0; i < cache.length; i++) {
            cache[i] = new SubPageMemoryRegionCache(cacheSize);
        }
        return cache;
    }

    private static <T> MemoryRegionCache<T>[] createNormalCaches(int cacheSize, int maxCachedBufferCapacity, PoolArena<T> area) {
        if (cacheSize <= 0 || maxCachedBufferCapacity <= 0) {
            return null;
        }
        int max = Math.min(area.chunkSize, maxCachedBufferCapacity);
        List<MemoryRegionCache<T>> cache = new ArrayList<>();
        int idx = area.numSmallSubpagePools;
        while (idx < area.nSizes && area.sizeIdx2size(idx) <= max) {
            cache.add(new NormalMemoryRegionCache<>(cacheSize));
            idx++;
        }
        return (MemoryRegionCache[]) cache.toArray(new MemoryRegionCache[0]);
    }

    /* access modifiers changed from: package-private */
    public static int log2(int val) {
        return 31 - Integer.numberOfLeadingZeros(val);
    }

    /* access modifiers changed from: package-private */
    public boolean allocateSmall(PoolArena<?> area, PooledByteBuf<?> buf, int reqCapacity, int sizeIdx) {
        return allocate(cacheForSmall(area, sizeIdx), buf, reqCapacity);
    }

    /* access modifiers changed from: package-private */
    public boolean allocateNormal(PoolArena<?> area, PooledByteBuf<?> buf, int reqCapacity, int sizeIdx) {
        return allocate(cacheForNormal(area, sizeIdx), buf, reqCapacity);
    }

    private boolean allocate(MemoryRegionCache<?> cache, PooledByteBuf buf, int reqCapacity) {
        if (cache == null) {
            return false;
        }
        boolean allocated = cache.allocate(buf, reqCapacity, this);
        int i = this.allocations + 1;
        this.allocations = i;
        if (i >= this.freeSweepAllocationThreshold) {
            this.allocations = 0;
            trim();
        }
        return allocated;
    }

    /* access modifiers changed from: package-private */
    public boolean add(PoolArena<?> area, PoolChunk chunk, ByteBuffer nioBuffer, long handle, int normCapacity, PoolArena.SizeClass sizeClass) {
        MemoryRegionCache<?> cache = cache(area, area.size2SizeIdx(normCapacity), sizeClass);
        if (cache == null) {
            return false;
        }
        return cache.add(chunk, nioBuffer, handle, normCapacity);
    }

    private MemoryRegionCache<?> cache(PoolArena<?> area, int sizeIdx, PoolArena.SizeClass sizeClass) {
        switch (sizeClass) {
            case Normal:
                return cacheForNormal(area, sizeIdx);
            case Small:
                return cacheForSmall(area, sizeIdx);
            default:
                throw new Error();
        }
    }

    protected void finalize() throws Throwable {
        try {
            finalize();
        } finally {
            free(true);
        }
    }

    /* access modifiers changed from: package-private */
    public void free(boolean finalizer) {
        if (this.freed.compareAndSet(false, true)) {
            int numFreed = free(this.smallSubPageDirectCaches, finalizer) + free(this.normalDirectCaches, finalizer) + free((MemoryRegionCache<?>[]) this.smallSubPageHeapCaches, finalizer) + free((MemoryRegionCache<?>[]) this.normalHeapCaches, finalizer);
            if (numFreed > 0 && logger.isDebugEnabled()) {
                logger.debug("Freed {} thread-local buffer(s) from thread: {}", Integer.valueOf(numFreed), Thread.currentThread().getName());
            }
            if (this.directArena != null) {
                this.directArena.numThreadCaches.getAndDecrement();
            }
            if (this.heapArena != null) {
                this.heapArena.numThreadCaches.getAndDecrement();
            }
        }
    }

    private static int free(MemoryRegionCache<?>[] caches, boolean finalizer) {
        if (caches == null) {
            return 0;
        }
        int numFreed = 0;
        for (MemoryRegionCache<?> c : caches) {
            numFreed += free(c, finalizer);
        }
        return numFreed;
    }

    private static int free(MemoryRegionCache<?> cache, boolean finalizer) {
        if (cache == null) {
            return 0;
        }
        return cache.free(finalizer);
    }

    /* access modifiers changed from: package-private */
    public void trim() {
        trim(this.smallSubPageDirectCaches);
        trim(this.normalDirectCaches);
        trim((MemoryRegionCache<?>[]) this.smallSubPageHeapCaches);
        trim((MemoryRegionCache<?>[]) this.normalHeapCaches);
    }

    private static void trim(MemoryRegionCache<?>[] caches) {
        if (caches != null) {
            for (MemoryRegionCache<?> c : caches) {
                trim(c);
            }
        }
    }

    private static void trim(MemoryRegionCache<?> cache) {
        if (cache != null) {
            cache.trim();
        }
    }

    private MemoryRegionCache<?> cacheForSmall(PoolArena<?> area, int sizeIdx) {
        if (area.isDirect()) {
            return cache(this.smallSubPageDirectCaches, sizeIdx);
        }
        return cache(this.smallSubPageHeapCaches, sizeIdx);
    }

    private MemoryRegionCache<?> cacheForNormal(PoolArena<?> area, int sizeIdx) {
        int idx = sizeIdx - area.numSmallSubpagePools;
        if (area.isDirect()) {
            return cache(this.normalDirectCaches, idx);
        }
        return cache(this.normalHeapCaches, idx);
    }

    private static <T> MemoryRegionCache<T> cache(MemoryRegionCache<T>[] cache, int sizeIdx) {
        if (cache == null || sizeIdx > cache.length - 1) {
            return null;
        }
        return cache[sizeIdx];
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.buffer.PoolThreadCache$SubPageMemoryRegionCache */
    /* loaded from: grasscutter.jar:io/netty/buffer/PoolThreadCache$SubPageMemoryRegionCache.class */
    public static final class SubPageMemoryRegionCache<T> extends MemoryRegionCache<T> {
        SubPageMemoryRegionCache(int size) {
            super(size, PoolArena.SizeClass.Small);
        }

        @Override // p013io.netty.buffer.PoolThreadCache.MemoryRegionCache
        protected void initBuf(PoolChunk<T> chunk, ByteBuffer nioBuffer, long handle, PooledByteBuf<T> buf, int reqCapacity, PoolThreadCache threadCache) {
            chunk.initBufWithSubpage(buf, nioBuffer, handle, reqCapacity, threadCache);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.buffer.PoolThreadCache$NormalMemoryRegionCache */
    /* loaded from: grasscutter.jar:io/netty/buffer/PoolThreadCache$NormalMemoryRegionCache.class */
    public static final class NormalMemoryRegionCache<T> extends MemoryRegionCache<T> {
        NormalMemoryRegionCache(int size) {
            super(size, PoolArena.SizeClass.Normal);
        }

        @Override // p013io.netty.buffer.PoolThreadCache.MemoryRegionCache
        protected void initBuf(PoolChunk<T> chunk, ByteBuffer nioBuffer, long handle, PooledByteBuf<T> buf, int reqCapacity, PoolThreadCache threadCache) {
            chunk.initBuf(buf, nioBuffer, handle, reqCapacity, threadCache);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.buffer.PoolThreadCache$MemoryRegionCache */
    /* loaded from: grasscutter.jar:io/netty/buffer/PoolThreadCache$MemoryRegionCache.class */
    public static abstract class MemoryRegionCache<T> {
        private final int size;
        private final Queue<Entry<T>> queue;
        private final PoolArena.SizeClass sizeClass;
        private int allocations;
        private static final ObjectPool<Entry> RECYCLER = ObjectPool.newPool(new ObjectPool.ObjectCreator<Entry>() { // from class: io.netty.buffer.PoolThreadCache.MemoryRegionCache.1
            @Override // p013io.netty.util.internal.ObjectPool.ObjectCreator
            public Entry newObject(ObjectPool.Handle<Entry> handle) {
                return new Entry(handle);
            }
        });

        protected abstract void initBuf(PoolChunk<T> poolChunk, ByteBuffer byteBuffer, long j, PooledByteBuf<T> pooledByteBuf, int i, PoolThreadCache poolThreadCache);

        MemoryRegionCache(int size, PoolArena.SizeClass sizeClass) {
            this.size = MathUtil.safeFindNextPositivePowerOfTwo(size);
            this.queue = PlatformDependent.newFixedMpscQueue(this.size);
            this.sizeClass = sizeClass;
        }

        public final boolean add(PoolChunk<T> chunk, ByteBuffer nioBuffer, long handle, int normCapacity) {
            Entry<T> entry = newEntry(chunk, nioBuffer, handle, normCapacity);
            boolean queued = this.queue.offer(entry);
            if (!queued) {
                entry.recycle();
            }
            return queued;
        }

        public final boolean allocate(PooledByteBuf<T> buf, int reqCapacity, PoolThreadCache threadCache) {
            Entry<T> entry = this.queue.poll();
            if (entry == null) {
                return false;
            }
            initBuf(entry.chunk, entry.nioBuffer, entry.handle, buf, reqCapacity, threadCache);
            entry.recycle();
            this.allocations++;
            return true;
        }

        public final int free(boolean finalizer) {
            return free(Integer.MAX_VALUE, finalizer);
        }

        private int free(int max, boolean finalizer) {
            int numFreed = 0;
            while (numFreed < max) {
                Entry<T> entry = this.queue.poll();
                if (entry == null) {
                    return numFreed;
                }
                freeEntry(entry, finalizer);
                numFreed++;
            }
            return numFreed;
        }

        public final void trim() {
            int free = this.size - this.allocations;
            this.allocations = 0;
            if (free > 0) {
                free(free, false);
            }
        }

        private void freeEntry(Entry entry, boolean finalizer) {
            PoolChunk chunk = entry.chunk;
            long handle = entry.handle;
            ByteBuffer nioBuffer = entry.nioBuffer;
            int normCapacity = entry.normCapacity;
            if (!finalizer) {
                entry.recycle();
            }
            chunk.arena.freeChunk(chunk, handle, normCapacity, this.sizeClass, nioBuffer, finalizer);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: io.netty.buffer.PoolThreadCache$MemoryRegionCache$Entry */
        /* loaded from: grasscutter.jar:io/netty/buffer/PoolThreadCache$MemoryRegionCache$Entry.class */
        public static final class Entry<T> {
            final ObjectPool.Handle<Entry<?>> recyclerHandle;
            PoolChunk<T> chunk;
            ByteBuffer nioBuffer;
            long handle = -1;
            int normCapacity;

            Entry(ObjectPool.Handle<Entry<?>> recyclerHandle) {
                this.recyclerHandle = recyclerHandle;
            }

            void recycle() {
                this.chunk = null;
                this.nioBuffer = null;
                this.handle = -1;
                this.recyclerHandle.recycle(this);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: io.netty.buffer.PoolChunk<?> */
        /* JADX WARN: Multi-variable type inference failed */
        private static Entry newEntry(PoolChunk<?> chunk, ByteBuffer nioBuffer, long handle, int normCapacity) {
            Entry entry = RECYCLER.get();
            entry.chunk = chunk;
            entry.nioBuffer = nioBuffer;
            entry.handle = handle;
            entry.normCapacity = normCapacity;
            return entry;
        }
    }
}
