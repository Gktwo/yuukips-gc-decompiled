package p013io.netty.buffer;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.LongCompanionObject;
import p013io.netty.buffer.PoolArena;
import p013io.netty.util.NettyRuntime;
import p013io.netty.util.concurrent.EventExecutor;
import p013io.netty.util.concurrent.FastThreadLocal;
import p013io.netty.util.concurrent.FastThreadLocalThread;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.PlatformDependent;
import p013io.netty.util.internal.StringUtil;
import p013io.netty.util.internal.SystemPropertyUtil;
import p013io.netty.util.internal.ThreadExecutorMap;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

/* renamed from: io.netty.buffer.PooledByteBufAllocator */
/* loaded from: grasscutter.jar:io/netty/buffer/PooledByteBufAllocator.class */
public class PooledByteBufAllocator extends AbstractByteBufAllocator implements ByteBufAllocatorMetricProvider {
    private static final InternalLogger logger;
    private static final int DEFAULT_NUM_HEAP_ARENA;
    private static final int DEFAULT_NUM_DIRECT_ARENA;
    private static final int DEFAULT_PAGE_SIZE;
    private static final int DEFAULT_MAX_ORDER;
    private static final int DEFAULT_SMALL_CACHE_SIZE;
    private static final int DEFAULT_NORMAL_CACHE_SIZE;
    static final int DEFAULT_MAX_CACHED_BUFFER_CAPACITY;
    private static final int DEFAULT_CACHE_TRIM_INTERVAL;
    private static final long DEFAULT_CACHE_TRIM_INTERVAL_MILLIS;
    private static final boolean DEFAULT_USE_CACHE_FOR_ALL_THREADS;
    private static final int DEFAULT_DIRECT_MEMORY_CACHE_ALIGNMENT;
    static final int DEFAULT_MAX_CACHED_BYTEBUFFERS_PER_CHUNK;
    private static final int MIN_PAGE_SIZE = 4096;
    private static final int MAX_CHUNK_SIZE = 1073741824;
    private static final int CACHE_NOT_USED = 0;
    private final Runnable trimTask;
    public static final PooledByteBufAllocator DEFAULT;
    private final PoolArena<byte[]>[] heapArenas;
    private final PoolArena<ByteBuffer>[] directArenas;
    private final int smallCacheSize;
    private final int normalCacheSize;
    private final List<PoolArenaMetric> heapArenaMetrics;
    private final List<PoolArenaMetric> directArenaMetrics;
    private final PoolThreadLocalCache threadCache;
    private final int chunkSize;
    private final PooledByteBufAllocatorMetric metric;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !PooledByteBufAllocator.class.desiredAssertionStatus();
        logger = InternalLoggerFactory.getInstance(PooledByteBufAllocator.class);
        int defaultAlignment = SystemPropertyUtil.getInt("io.netty.allocator.directMemoryCacheAlignment", 0);
        int defaultPageSize = SystemPropertyUtil.getInt("io.netty.allocator.pageSize", 8192);
        Throwable pageSizeFallbackCause = null;
        try {
            validateAndCalculatePageShifts(defaultPageSize, defaultAlignment);
        } catch (Throwable t) {
            pageSizeFallbackCause = t;
            defaultPageSize = 8192;
            defaultAlignment = 0;
        }
        DEFAULT_PAGE_SIZE = defaultPageSize;
        DEFAULT_DIRECT_MEMORY_CACHE_ALIGNMENT = defaultAlignment;
        int defaultMaxOrder = SystemPropertyUtil.getInt("io.netty.allocator.maxOrder", 9);
        Throwable maxOrderFallbackCause = null;
        try {
            validateAndCalculateChunkSize(DEFAULT_PAGE_SIZE, defaultMaxOrder);
        } catch (Throwable t2) {
            maxOrderFallbackCause = t2;
            defaultMaxOrder = 9;
        }
        DEFAULT_MAX_ORDER = defaultMaxOrder;
        Runtime runtime = Runtime.getRuntime();
        int defaultMinNumArena = NettyRuntime.availableProcessors() * 2;
        int defaultChunkSize = DEFAULT_PAGE_SIZE << DEFAULT_MAX_ORDER;
        DEFAULT_NUM_HEAP_ARENA = Math.max(0, SystemPropertyUtil.getInt("io.netty.allocator.numHeapArenas", (int) Math.min((long) defaultMinNumArena, ((runtime.maxMemory() / ((long) defaultChunkSize)) / 2) / 3)));
        DEFAULT_NUM_DIRECT_ARENA = Math.max(0, SystemPropertyUtil.getInt("io.netty.allocator.numDirectArenas", (int) Math.min((long) defaultMinNumArena, ((PlatformDependent.maxDirectMemory() / ((long) defaultChunkSize)) / 2) / 3)));
        DEFAULT_SMALL_CACHE_SIZE = SystemPropertyUtil.getInt("io.netty.allocator.smallCacheSize", 256);
        DEFAULT_NORMAL_CACHE_SIZE = SystemPropertyUtil.getInt("io.netty.allocator.normalCacheSize", 64);
        DEFAULT_MAX_CACHED_BUFFER_CAPACITY = SystemPropertyUtil.getInt("io.netty.allocator.maxCachedBufferCapacity", 32768);
        DEFAULT_CACHE_TRIM_INTERVAL = SystemPropertyUtil.getInt("io.netty.allocator.cacheTrimInterval", 8192);
        if (SystemPropertyUtil.contains("io.netty.allocation.cacheTrimIntervalMillis")) {
            logger.warn("-Dio.netty.allocation.cacheTrimIntervalMillis is deprecated, use -Dio.netty.allocator.cacheTrimIntervalMillis");
            if (SystemPropertyUtil.contains("io.netty.allocator.cacheTrimIntervalMillis")) {
                DEFAULT_CACHE_TRIM_INTERVAL_MILLIS = SystemPropertyUtil.getLong("io.netty.allocator.cacheTrimIntervalMillis", 0);
            } else {
                DEFAULT_CACHE_TRIM_INTERVAL_MILLIS = SystemPropertyUtil.getLong("io.netty.allocation.cacheTrimIntervalMillis", 0);
            }
        } else {
            DEFAULT_CACHE_TRIM_INTERVAL_MILLIS = SystemPropertyUtil.getLong("io.netty.allocator.cacheTrimIntervalMillis", 0);
        }
        DEFAULT_USE_CACHE_FOR_ALL_THREADS = SystemPropertyUtil.getBoolean("io.netty.allocator.useCacheForAllThreads", false);
        DEFAULT_MAX_CACHED_BYTEBUFFERS_PER_CHUNK = SystemPropertyUtil.getInt("io.netty.allocator.maxCachedByteBuffersPerChunk", 1023);
        if (logger.isDebugEnabled()) {
            logger.debug("-Dio.netty.allocator.numHeapArenas: {}", Integer.valueOf(DEFAULT_NUM_HEAP_ARENA));
            logger.debug("-Dio.netty.allocator.numDirectArenas: {}", Integer.valueOf(DEFAULT_NUM_DIRECT_ARENA));
            if (pageSizeFallbackCause == null) {
                logger.debug("-Dio.netty.allocator.pageSize: {}", Integer.valueOf(DEFAULT_PAGE_SIZE));
            } else {
                logger.debug("-Dio.netty.allocator.pageSize: {}", Integer.valueOf(DEFAULT_PAGE_SIZE), pageSizeFallbackCause);
            }
            if (maxOrderFallbackCause == null) {
                logger.debug("-Dio.netty.allocator.maxOrder: {}", Integer.valueOf(DEFAULT_MAX_ORDER));
            } else {
                logger.debug("-Dio.netty.allocator.maxOrder: {}", Integer.valueOf(DEFAULT_MAX_ORDER), maxOrderFallbackCause);
            }
            logger.debug("-Dio.netty.allocator.chunkSize: {}", Integer.valueOf(DEFAULT_PAGE_SIZE << DEFAULT_MAX_ORDER));
            logger.debug("-Dio.netty.allocator.smallCacheSize: {}", Integer.valueOf(DEFAULT_SMALL_CACHE_SIZE));
            logger.debug("-Dio.netty.allocator.normalCacheSize: {}", Integer.valueOf(DEFAULT_NORMAL_CACHE_SIZE));
            logger.debug("-Dio.netty.allocator.maxCachedBufferCapacity: {}", Integer.valueOf(DEFAULT_MAX_CACHED_BUFFER_CAPACITY));
            logger.debug("-Dio.netty.allocator.cacheTrimInterval: {}", Integer.valueOf(DEFAULT_CACHE_TRIM_INTERVAL));
            logger.debug("-Dio.netty.allocator.cacheTrimIntervalMillis: {}", Long.valueOf(DEFAULT_CACHE_TRIM_INTERVAL_MILLIS));
            logger.debug("-Dio.netty.allocator.useCacheForAllThreads: {}", Boolean.valueOf(DEFAULT_USE_CACHE_FOR_ALL_THREADS));
            logger.debug("-Dio.netty.allocator.maxCachedByteBuffersPerChunk: {}", Integer.valueOf(DEFAULT_MAX_CACHED_BYTEBUFFERS_PER_CHUNK));
        }
        DEFAULT = new PooledByteBufAllocator(PlatformDependent.directBufferPreferred());
    }

    public PooledByteBufAllocator() {
        this(false);
    }

    public PooledByteBufAllocator(boolean preferDirect) {
        this(preferDirect, DEFAULT_NUM_HEAP_ARENA, DEFAULT_NUM_DIRECT_ARENA, DEFAULT_PAGE_SIZE, DEFAULT_MAX_ORDER);
    }

    public PooledByteBufAllocator(int nHeapArena, int nDirectArena, int pageSize, int maxOrder) {
        this(false, nHeapArena, nDirectArena, pageSize, maxOrder);
    }

    @Deprecated
    public PooledByteBufAllocator(boolean preferDirect, int nHeapArena, int nDirectArena, int pageSize, int maxOrder) {
        this(preferDirect, nHeapArena, nDirectArena, pageSize, maxOrder, 0, DEFAULT_SMALL_CACHE_SIZE, DEFAULT_NORMAL_CACHE_SIZE);
    }

    @Deprecated
    public PooledByteBufAllocator(boolean preferDirect, int nHeapArena, int nDirectArena, int pageSize, int maxOrder, int tinyCacheSize, int smallCacheSize, int normalCacheSize) {
        this(preferDirect, nHeapArena, nDirectArena, pageSize, maxOrder, smallCacheSize, normalCacheSize, DEFAULT_USE_CACHE_FOR_ALL_THREADS, DEFAULT_DIRECT_MEMORY_CACHE_ALIGNMENT);
    }

    @Deprecated
    public PooledByteBufAllocator(boolean preferDirect, int nHeapArena, int nDirectArena, int pageSize, int maxOrder, int tinyCacheSize, int smallCacheSize, int normalCacheSize, boolean useCacheForAllThreads) {
        this(preferDirect, nHeapArena, nDirectArena, pageSize, maxOrder, smallCacheSize, normalCacheSize, useCacheForAllThreads);
    }

    public PooledByteBufAllocator(boolean preferDirect, int nHeapArena, int nDirectArena, int pageSize, int maxOrder, int smallCacheSize, int normalCacheSize, boolean useCacheForAllThreads) {
        this(preferDirect, nHeapArena, nDirectArena, pageSize, maxOrder, smallCacheSize, normalCacheSize, useCacheForAllThreads, DEFAULT_DIRECT_MEMORY_CACHE_ALIGNMENT);
    }

    @Deprecated
    public PooledByteBufAllocator(boolean preferDirect, int nHeapArena, int nDirectArena, int pageSize, int maxOrder, int tinyCacheSize, int smallCacheSize, int normalCacheSize, boolean useCacheForAllThreads, int directMemoryCacheAlignment) {
        this(preferDirect, nHeapArena, nDirectArena, pageSize, maxOrder, smallCacheSize, normalCacheSize, useCacheForAllThreads, directMemoryCacheAlignment);
    }

    public PooledByteBufAllocator(boolean preferDirect, int nHeapArena, int nDirectArena, int pageSize, int maxOrder, int smallCacheSize, int normalCacheSize, boolean useCacheForAllThreads, int directMemoryCacheAlignment) {
        super(preferDirect);
        this.trimTask = new Runnable() { // from class: io.netty.buffer.PooledByteBufAllocator.1
            @Override // java.lang.Runnable
            public void run() {
                PooledByteBufAllocator.this.trimCurrentThreadCache();
            }
        };
        this.threadCache = new PoolThreadLocalCache(useCacheForAllThreads);
        this.smallCacheSize = smallCacheSize;
        this.normalCacheSize = normalCacheSize;
        if (directMemoryCacheAlignment != 0) {
            if (!PlatformDependent.hasAlignDirectByteBuffer()) {
                throw new UnsupportedOperationException("Buffer alignment is not supported. Either Unsafe or ByteBuffer.alignSlice() must be available.");
            }
            pageSize = (int) PlatformDependent.align((long) pageSize, directMemoryCacheAlignment);
        }
        this.chunkSize = validateAndCalculateChunkSize(pageSize, maxOrder);
        ObjectUtil.checkPositiveOrZero(nHeapArena, "nHeapArena");
        ObjectUtil.checkPositiveOrZero(nDirectArena, "nDirectArena");
        ObjectUtil.checkPositiveOrZero(directMemoryCacheAlignment, "directMemoryCacheAlignment");
        if (directMemoryCacheAlignment > 0 && !isDirectMemoryCacheAlignmentSupported()) {
            throw new IllegalArgumentException("directMemoryCacheAlignment is not supported");
        } else if ((directMemoryCacheAlignment & (-directMemoryCacheAlignment)) != directMemoryCacheAlignment) {
            throw new IllegalArgumentException("directMemoryCacheAlignment: " + directMemoryCacheAlignment + " (expected: power of two)");
        } else {
            int pageShifts = validateAndCalculatePageShifts(pageSize, directMemoryCacheAlignment);
            if (nHeapArena > 0) {
                this.heapArenas = newArenaArray(nHeapArena);
                List<PoolArenaMetric> metrics = new ArrayList<>(this.heapArenas.length);
                for (int i = 0; i < this.heapArenas.length; i++) {
                    PoolArena.HeapArena arena = new PoolArena.HeapArena(this, pageSize, pageShifts, this.chunkSize);
                    this.heapArenas[i] = arena;
                    metrics.add(arena);
                }
                this.heapArenaMetrics = Collections.unmodifiableList(metrics);
            } else {
                this.heapArenas = null;
                this.heapArenaMetrics = Collections.emptyList();
            }
            if (nDirectArena > 0) {
                this.directArenas = newArenaArray(nDirectArena);
                List<PoolArenaMetric> metrics2 = new ArrayList<>(this.directArenas.length);
                for (int i2 = 0; i2 < this.directArenas.length; i2++) {
                    PoolArena.DirectArena arena2 = new PoolArena.DirectArena(this, pageSize, pageShifts, this.chunkSize, directMemoryCacheAlignment);
                    this.directArenas[i2] = arena2;
                    metrics2.add(arena2);
                }
                this.directArenaMetrics = Collections.unmodifiableList(metrics2);
            } else {
                this.directArenas = null;
                this.directArenaMetrics = Collections.emptyList();
            }
            this.metric = new PooledByteBufAllocatorMetric(this);
        }
    }

    private static <T> PoolArena<T>[] newArenaArray(int size) {
        return new PoolArena[size];
    }

    private static int validateAndCalculatePageShifts(int pageSize, int alignment) {
        if (pageSize < 4096) {
            throw new IllegalArgumentException("pageSize: " + pageSize + " (expected: 4096)");
        } else if ((pageSize & (pageSize - 1)) != 0) {
            throw new IllegalArgumentException("pageSize: " + pageSize + " (expected: power of 2)");
        } else if (pageSize >= alignment) {
            return 31 - Integer.numberOfLeadingZeros(pageSize);
        } else {
            throw new IllegalArgumentException("Alignment cannot be greater than page size. Alignment: " + alignment + ", page size: " + pageSize + '.');
        }
    }

    private static int validateAndCalculateChunkSize(int pageSize, int maxOrder) {
        if (maxOrder > 14) {
            throw new IllegalArgumentException("maxOrder: " + maxOrder + " (expected: 0-14)");
        }
        int chunkSize = pageSize;
        for (int i = maxOrder; i > 0; i--) {
            if (chunkSize > 536870912) {
                throw new IllegalArgumentException(String.format("pageSize (%d) << maxOrder (%d) must not exceed %d", Integer.valueOf(pageSize), Integer.valueOf(maxOrder), 1073741824));
            }
            chunkSize <<= 1;
        }
        return chunkSize;
    }

    @Override // p013io.netty.buffer.AbstractByteBufAllocator
    protected ByteBuf newHeapBuffer(int initialCapacity, int maxCapacity) {
        ByteBuf buf;
        PoolThreadCache cache = this.threadCache.get();
        PoolArena<byte[]> heapArena = cache.heapArena;
        if (heapArena != null) {
            buf = heapArena.allocate(cache, initialCapacity, maxCapacity);
        } else {
            buf = PlatformDependent.hasUnsafe() ? new UnpooledUnsafeHeapByteBuf(this, initialCapacity, maxCapacity) : new UnpooledHeapByteBuf(this, initialCapacity, maxCapacity);
        }
        return toLeakAwareBuffer(buf);
    }

    @Override // p013io.netty.buffer.AbstractByteBufAllocator
    protected ByteBuf newDirectBuffer(int initialCapacity, int maxCapacity) {
        ByteBuf buf;
        PoolThreadCache cache = this.threadCache.get();
        PoolArena<ByteBuffer> directArena = cache.directArena;
        if (directArena != null) {
            buf = directArena.allocate(cache, initialCapacity, maxCapacity);
        } else {
            buf = PlatformDependent.hasUnsafe() ? UnsafeByteBufUtil.newUnsafeDirectByteBuf(this, initialCapacity, maxCapacity) : new UnpooledDirectByteBuf(this, initialCapacity, maxCapacity);
        }
        return toLeakAwareBuffer(buf);
    }

    public static int defaultNumHeapArena() {
        return DEFAULT_NUM_HEAP_ARENA;
    }

    public static int defaultNumDirectArena() {
        return DEFAULT_NUM_DIRECT_ARENA;
    }

    public static int defaultPageSize() {
        return DEFAULT_PAGE_SIZE;
    }

    public static int defaultMaxOrder() {
        return DEFAULT_MAX_ORDER;
    }

    public static boolean defaultUseCacheForAllThreads() {
        return DEFAULT_USE_CACHE_FOR_ALL_THREADS;
    }

    public static boolean defaultPreferDirect() {
        return PlatformDependent.directBufferPreferred();
    }

    @Deprecated
    public static int defaultTinyCacheSize() {
        return 0;
    }

    public static int defaultSmallCacheSize() {
        return DEFAULT_SMALL_CACHE_SIZE;
    }

    public static int defaultNormalCacheSize() {
        return DEFAULT_NORMAL_CACHE_SIZE;
    }

    public static boolean isDirectMemoryCacheAlignmentSupported() {
        return PlatformDependent.hasUnsafe();
    }

    @Override // p013io.netty.buffer.ByteBufAllocator
    public boolean isDirectBufferPooled() {
        return this.directArenas != null;
    }

    @Deprecated
    public boolean hasThreadLocalCache() {
        return this.threadCache.isSet();
    }

    @Deprecated
    public void freeThreadLocalCache() {
        this.threadCache.remove();
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.buffer.PooledByteBufAllocator$PoolThreadLocalCache */
    /* loaded from: grasscutter.jar:io/netty/buffer/PooledByteBufAllocator$PoolThreadLocalCache.class */
    public final class PoolThreadLocalCache extends FastThreadLocal<PoolThreadCache> {
        private final boolean useCacheForAllThreads;

        PoolThreadLocalCache(boolean useCacheForAllThreads) {
            this.useCacheForAllThreads = useCacheForAllThreads;
        }

        /* access modifiers changed from: protected */
        @Override // p013io.netty.util.concurrent.FastThreadLocal
        public synchronized PoolThreadCache initialValue() {
            PoolArena<byte[]> heapArena = leastUsedArena(PooledByteBufAllocator.this.heapArenas);
            PoolArena<ByteBuffer> directArena = leastUsedArena(PooledByteBufAllocator.this.directArenas);
            Thread current = Thread.currentThread();
            EventExecutor executor = ThreadExecutorMap.currentExecutor();
            if (!this.useCacheForAllThreads && !(current instanceof FastThreadLocalThread) && executor == null) {
                return new PoolThreadCache(heapArena, directArena, 0, 0, 0, 0);
            }
            PoolThreadCache cache = new PoolThreadCache(heapArena, directArena, PooledByteBufAllocator.this.smallCacheSize, PooledByteBufAllocator.this.normalCacheSize, PooledByteBufAllocator.DEFAULT_MAX_CACHED_BUFFER_CAPACITY, PooledByteBufAllocator.DEFAULT_CACHE_TRIM_INTERVAL);
            if (PooledByteBufAllocator.DEFAULT_CACHE_TRIM_INTERVAL_MILLIS > 0 && executor != null) {
                executor.scheduleAtFixedRate(PooledByteBufAllocator.this.trimTask, PooledByteBufAllocator.DEFAULT_CACHE_TRIM_INTERVAL_MILLIS, PooledByteBufAllocator.DEFAULT_CACHE_TRIM_INTERVAL_MILLIS, TimeUnit.MILLISECONDS);
            }
            return cache;
        }

        /* access modifiers changed from: protected */
        public void onRemoval(PoolThreadCache threadCache) {
            threadCache.free(false);
        }

        private <T> PoolArena<T> leastUsedArena(PoolArena<T>[] arenas) {
            if (arenas == null || arenas.length == 0) {
                return null;
            }
            PoolArena<T> minArena = arenas[0];
            if (minArena.numThreadCaches.get() == 0) {
                return minArena;
            }
            for (int i = 1; i < arenas.length; i++) {
                PoolArena<T> arena = arenas[i];
                if (arena.numThreadCaches.get() < minArena.numThreadCaches.get()) {
                    minArena = arena;
                }
            }
            return minArena;
        }
    }

    @Override // p013io.netty.buffer.ByteBufAllocatorMetricProvider
    public PooledByteBufAllocatorMetric metric() {
        return this.metric;
    }

    @Deprecated
    public int numHeapArenas() {
        return this.heapArenaMetrics.size();
    }

    @Deprecated
    public int numDirectArenas() {
        return this.directArenaMetrics.size();
    }

    @Deprecated
    public List<PoolArenaMetric> heapArenas() {
        return this.heapArenaMetrics;
    }

    @Deprecated
    public List<PoolArenaMetric> directArenas() {
        return this.directArenaMetrics;
    }

    @Deprecated
    public int numThreadLocalCaches() {
        PoolArena[] poolArenaArr = this.heapArenas != null ? this.heapArenas : this.directArenas;
        if (poolArenaArr == null) {
            return 0;
        }
        int total = 0;
        for (PoolArena poolArena : poolArenaArr) {
            total += poolArena.numThreadCaches.get();
        }
        return total;
    }

    @Deprecated
    public int tinyCacheSize() {
        return 0;
    }

    @Deprecated
    public int smallCacheSize() {
        return this.smallCacheSize;
    }

    @Deprecated
    public int normalCacheSize() {
        return this.normalCacheSize;
    }

    @Deprecated
    public final int chunkSize() {
        return this.chunkSize;
    }

    /* access modifiers changed from: package-private */
    public final long usedHeapMemory() {
        return usedMemory(this.heapArenas);
    }

    /* access modifiers changed from: package-private */
    public final long usedDirectMemory() {
        return usedMemory(this.directArenas);
    }

    /* JADX WARN: Type inference failed for: r0v11, types: [long] */
    private static long usedMemory(PoolArena<?>[] arenas) {
        if (arenas == null) {
            return -1;
        }
        char c = 0;
        for (PoolArena<?> arena : arenas) {
            c += arena.numActiveBytes();
            if (c < 0) {
                return LongCompanionObject.MAX_VALUE;
            }
        }
        return c;
    }

    public final long pinnedHeapMemory() {
        return pinnedMemory(this.heapArenas);
    }

    public final long pinnedDirectMemory() {
        return pinnedMemory(this.directArenas);
    }

    /* JADX WARN: Type inference failed for: r0v11, types: [long] */
    private static long pinnedMemory(PoolArena<?>[] arenas) {
        if (arenas == null) {
            return -1;
        }
        char c = 0;
        for (PoolArena<?> arena : arenas) {
            c += arena.numPinnedBytes();
            if (c < 0) {
                return LongCompanionObject.MAX_VALUE;
            }
        }
        return c;
    }

    /* access modifiers changed from: package-private */
    public final PoolThreadCache threadCache() {
        PoolThreadCache cache = this.threadCache.get();
        if ($assertionsDisabled || cache != null) {
            return cache;
        }
        throw new AssertionError();
    }

    public boolean trimCurrentThreadCache() {
        PoolThreadCache cache = this.threadCache.getIfExists();
        if (cache == null) {
            return false;
        }
        cache.trim();
        return true;
    }

    public String dumpStats() {
        int heapArenasLen = this.heapArenas == null ? 0 : this.heapArenas.length;
        StringBuilder buf = new StringBuilder(512).append(heapArenasLen).append(" heap arena(s):").append(StringUtil.NEWLINE);
        if (heapArenasLen > 0) {
            for (PoolArena<byte[]> a : this.heapArenas) {
                buf.append(a);
            }
        }
        int directArenasLen = this.directArenas == null ? 0 : this.directArenas.length;
        buf.append(directArenasLen).append(" direct arena(s):").append(StringUtil.NEWLINE);
        if (directArenasLen > 0) {
            for (PoolArena<ByteBuffer> a2 : this.directArenas) {
                buf.append(a2);
            }
        }
        return buf.toString();
    }
}
