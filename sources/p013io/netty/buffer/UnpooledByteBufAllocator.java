package p013io.netty.buffer;

import java.nio.ByteBuffer;
import p013io.netty.util.internal.LongCounter;
import p013io.netty.util.internal.PlatformDependent;
import p013io.netty.util.internal.StringUtil;

/* renamed from: io.netty.buffer.UnpooledByteBufAllocator */
/* loaded from: grasscutter.jar:io/netty/buffer/UnpooledByteBufAllocator.class */
public final class UnpooledByteBufAllocator extends AbstractByteBufAllocator implements ByteBufAllocatorMetricProvider {
    private final UnpooledByteBufAllocatorMetric metric;
    private final boolean disableLeakDetector;
    private final boolean noCleaner;
    public static final UnpooledByteBufAllocator DEFAULT = new UnpooledByteBufAllocator(PlatformDependent.directBufferPreferred());

    public UnpooledByteBufAllocator(boolean preferDirect) {
        this(preferDirect, false);
    }

    public UnpooledByteBufAllocator(boolean preferDirect, boolean disableLeakDetector) {
        this(preferDirect, disableLeakDetector, PlatformDependent.useDirectBufferNoCleaner());
    }

    public UnpooledByteBufAllocator(boolean preferDirect, boolean disableLeakDetector, boolean tryNoCleaner) {
        super(preferDirect);
        this.metric = new UnpooledByteBufAllocatorMetric();
        this.disableLeakDetector = disableLeakDetector;
        this.noCleaner = tryNoCleaner && PlatformDependent.hasUnsafe() && PlatformDependent.hasDirectBufferNoCleanerConstructor();
    }

    @Override // p013io.netty.buffer.AbstractByteBufAllocator
    protected ByteBuf newHeapBuffer(int initialCapacity, int maxCapacity) {
        return PlatformDependent.hasUnsafe() ? new InstrumentedUnpooledUnsafeHeapByteBuf(this, initialCapacity, maxCapacity) : new InstrumentedUnpooledHeapByteBuf(this, initialCapacity, maxCapacity);
    }

    @Override // p013io.netty.buffer.AbstractByteBufAllocator
    protected ByteBuf newDirectBuffer(int initialCapacity, int maxCapacity) {
        ByteBuf buf;
        if (PlatformDependent.hasUnsafe()) {
            buf = this.noCleaner ? new InstrumentedUnpooledUnsafeNoCleanerDirectByteBuf(this, initialCapacity, maxCapacity) : new InstrumentedUnpooledUnsafeDirectByteBuf(this, initialCapacity, maxCapacity);
        } else {
            buf = new InstrumentedUnpooledDirectByteBuf(this, initialCapacity, maxCapacity);
        }
        return this.disableLeakDetector ? buf : toLeakAwareBuffer(buf);
    }

    @Override // p013io.netty.buffer.AbstractByteBufAllocator, p013io.netty.buffer.ByteBufAllocator
    public CompositeByteBuf compositeHeapBuffer(int maxNumComponents) {
        CompositeByteBuf buf = new CompositeByteBuf(this, false, maxNumComponents);
        return this.disableLeakDetector ? buf : toLeakAwareBuffer(buf);
    }

    @Override // p013io.netty.buffer.AbstractByteBufAllocator, p013io.netty.buffer.ByteBufAllocator
    public CompositeByteBuf compositeDirectBuffer(int maxNumComponents) {
        CompositeByteBuf buf = new CompositeByteBuf(this, true, maxNumComponents);
        return this.disableLeakDetector ? buf : toLeakAwareBuffer(buf);
    }

    @Override // p013io.netty.buffer.ByteBufAllocator
    public boolean isDirectBufferPooled() {
        return false;
    }

    @Override // p013io.netty.buffer.ByteBufAllocatorMetricProvider
    public ByteBufAllocatorMetric metric() {
        return this.metric;
    }

    void incrementDirect(int amount) {
        this.metric.directCounter.add((long) amount);
    }

    void decrementDirect(int amount) {
        this.metric.directCounter.add((long) (-amount));
    }

    void incrementHeap(int amount) {
        this.metric.heapCounter.add((long) amount);
    }

    void decrementHeap(int amount) {
        this.metric.heapCounter.add((long) (-amount));
    }

    /* renamed from: io.netty.buffer.UnpooledByteBufAllocator$InstrumentedUnpooledUnsafeHeapByteBuf */
    /* loaded from: grasscutter.jar:io/netty/buffer/UnpooledByteBufAllocator$InstrumentedUnpooledUnsafeHeapByteBuf.class */
    private static final class InstrumentedUnpooledUnsafeHeapByteBuf extends UnpooledUnsafeHeapByteBuf {
        InstrumentedUnpooledUnsafeHeapByteBuf(UnpooledByteBufAllocator alloc, int initialCapacity, int maxCapacity) {
            super(alloc, initialCapacity, maxCapacity);
        }

        @Override // p013io.netty.buffer.UnpooledUnsafeHeapByteBuf, p013io.netty.buffer.UnpooledHeapByteBuf
        protected byte[] allocateArray(int initialCapacity) {
            byte[] bytes = allocateArray(initialCapacity);
            ((UnpooledByteBufAllocator) alloc()).incrementHeap(bytes.length);
            return bytes;
        }

        @Override // p013io.netty.buffer.UnpooledHeapByteBuf
        protected void freeArray(byte[] array) {
            int length = array.length;
            freeArray(array);
            ((UnpooledByteBufAllocator) alloc()).decrementHeap(length);
        }
    }

    /* renamed from: io.netty.buffer.UnpooledByteBufAllocator$InstrumentedUnpooledHeapByteBuf */
    /* loaded from: grasscutter.jar:io/netty/buffer/UnpooledByteBufAllocator$InstrumentedUnpooledHeapByteBuf.class */
    private static final class InstrumentedUnpooledHeapByteBuf extends UnpooledHeapByteBuf {
        InstrumentedUnpooledHeapByteBuf(UnpooledByteBufAllocator alloc, int initialCapacity, int maxCapacity) {
            super(alloc, initialCapacity, maxCapacity);
        }

        @Override // p013io.netty.buffer.UnpooledHeapByteBuf
        protected byte[] allocateArray(int initialCapacity) {
            byte[] bytes = allocateArray(initialCapacity);
            ((UnpooledByteBufAllocator) alloc()).incrementHeap(bytes.length);
            return bytes;
        }

        @Override // p013io.netty.buffer.UnpooledHeapByteBuf
        protected void freeArray(byte[] array) {
            int length = array.length;
            freeArray(array);
            ((UnpooledByteBufAllocator) alloc()).decrementHeap(length);
        }
    }

    /* renamed from: io.netty.buffer.UnpooledByteBufAllocator$InstrumentedUnpooledUnsafeNoCleanerDirectByteBuf */
    /* loaded from: grasscutter.jar:io/netty/buffer/UnpooledByteBufAllocator$InstrumentedUnpooledUnsafeNoCleanerDirectByteBuf.class */
    private static final class InstrumentedUnpooledUnsafeNoCleanerDirectByteBuf extends UnpooledUnsafeNoCleanerDirectByteBuf {
        InstrumentedUnpooledUnsafeNoCleanerDirectByteBuf(UnpooledByteBufAllocator alloc, int initialCapacity, int maxCapacity) {
            super(alloc, initialCapacity, maxCapacity);
        }

        @Override // p013io.netty.buffer.UnpooledUnsafeNoCleanerDirectByteBuf, p013io.netty.buffer.UnpooledDirectByteBuf
        protected ByteBuffer allocateDirect(int initialCapacity) {
            ByteBuffer buffer = allocateDirect(initialCapacity);
            ((UnpooledByteBufAllocator) alloc()).incrementDirect(buffer.capacity());
            return buffer;
        }

        @Override // p013io.netty.buffer.UnpooledUnsafeNoCleanerDirectByteBuf
        ByteBuffer reallocateDirect(ByteBuffer oldBuffer, int initialCapacity) {
            int capacity = oldBuffer.capacity();
            ByteBuffer buffer = reallocateDirect(oldBuffer, initialCapacity);
            ((UnpooledByteBufAllocator) alloc()).incrementDirect(buffer.capacity() - capacity);
            return buffer;
        }

        @Override // p013io.netty.buffer.UnpooledUnsafeNoCleanerDirectByteBuf, p013io.netty.buffer.UnpooledDirectByteBuf
        protected void freeDirect(ByteBuffer buffer) {
            int capacity = buffer.capacity();
            freeDirect(buffer);
            ((UnpooledByteBufAllocator) alloc()).decrementDirect(capacity);
        }
    }

    /* renamed from: io.netty.buffer.UnpooledByteBufAllocator$InstrumentedUnpooledUnsafeDirectByteBuf */
    /* loaded from: grasscutter.jar:io/netty/buffer/UnpooledByteBufAllocator$InstrumentedUnpooledUnsafeDirectByteBuf.class */
    private static final class InstrumentedUnpooledUnsafeDirectByteBuf extends UnpooledUnsafeDirectByteBuf {
        InstrumentedUnpooledUnsafeDirectByteBuf(UnpooledByteBufAllocator alloc, int initialCapacity, int maxCapacity) {
            super(alloc, initialCapacity, maxCapacity);
        }

        @Override // p013io.netty.buffer.UnpooledDirectByteBuf
        protected ByteBuffer allocateDirect(int initialCapacity) {
            ByteBuffer buffer = allocateDirect(initialCapacity);
            ((UnpooledByteBufAllocator) alloc()).incrementDirect(buffer.capacity());
            return buffer;
        }

        @Override // p013io.netty.buffer.UnpooledDirectByteBuf
        protected void freeDirect(ByteBuffer buffer) {
            int capacity = buffer.capacity();
            freeDirect(buffer);
            ((UnpooledByteBufAllocator) alloc()).decrementDirect(capacity);
        }
    }

    /* renamed from: io.netty.buffer.UnpooledByteBufAllocator$InstrumentedUnpooledDirectByteBuf */
    /* loaded from: grasscutter.jar:io/netty/buffer/UnpooledByteBufAllocator$InstrumentedUnpooledDirectByteBuf.class */
    private static final class InstrumentedUnpooledDirectByteBuf extends UnpooledDirectByteBuf {
        InstrumentedUnpooledDirectByteBuf(UnpooledByteBufAllocator alloc, int initialCapacity, int maxCapacity) {
            super(alloc, initialCapacity, maxCapacity);
        }

        @Override // p013io.netty.buffer.UnpooledDirectByteBuf
        protected ByteBuffer allocateDirect(int initialCapacity) {
            ByteBuffer buffer = allocateDirect(initialCapacity);
            ((UnpooledByteBufAllocator) alloc()).incrementDirect(buffer.capacity());
            return buffer;
        }

        @Override // p013io.netty.buffer.UnpooledDirectByteBuf
        protected void freeDirect(ByteBuffer buffer) {
            int capacity = buffer.capacity();
            freeDirect(buffer);
            ((UnpooledByteBufAllocator) alloc()).decrementDirect(capacity);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.buffer.UnpooledByteBufAllocator$UnpooledByteBufAllocatorMetric */
    /* loaded from: grasscutter.jar:io/netty/buffer/UnpooledByteBufAllocator$UnpooledByteBufAllocatorMetric.class */
    public static final class UnpooledByteBufAllocatorMetric implements ByteBufAllocatorMetric {
        final LongCounter directCounter;
        final LongCounter heapCounter;

        private UnpooledByteBufAllocatorMetric() {
            this.directCounter = PlatformDependent.newLongCounter();
            this.heapCounter = PlatformDependent.newLongCounter();
        }

        @Override // p013io.netty.buffer.ByteBufAllocatorMetric
        public long usedHeapMemory() {
            return this.heapCounter.value();
        }

        @Override // p013io.netty.buffer.ByteBufAllocatorMetric
        public long usedDirectMemory() {
            return this.directCounter.value();
        }

        public String toString() {
            return StringUtil.simpleClassName(this) + "(usedHeapMemory: " + usedHeapMemory() + "; usedDirectMemory: " + usedDirectMemory() + ')';
        }
    }
}
