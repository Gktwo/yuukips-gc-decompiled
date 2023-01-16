package p013io.netty.buffer;

import p013io.netty.util.ResourceLeakDetector;
import p013io.netty.util.ResourceLeakTracker;
import p013io.netty.util.internal.MathUtil;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.PlatformDependent;
import p013io.netty.util.internal.StringUtil;

/* renamed from: io.netty.buffer.AbstractByteBufAllocator */
/* loaded from: grasscutter.jar:io/netty/buffer/AbstractByteBufAllocator.class */
public abstract class AbstractByteBufAllocator implements ByteBufAllocator {
    static final int DEFAULT_INITIAL_CAPACITY = 256;
    static final int DEFAULT_MAX_CAPACITY = Integer.MAX_VALUE;
    static final int DEFAULT_MAX_COMPONENTS = 16;
    static final int CALCULATE_THRESHOLD = 4194304;
    private final boolean directByDefault;
    private final ByteBuf emptyBuf;

    protected abstract ByteBuf newHeapBuffer(int i, int i2);

    protected abstract ByteBuf newDirectBuffer(int i, int i2);

    static {
        ResourceLeakDetector.addExclusions(AbstractByteBufAllocator.class, "toLeakAwareBuffer");
    }

    protected static ByteBuf toLeakAwareBuffer(ByteBuf buf) {
        switch (ResourceLeakDetector.getLevel()) {
            case SIMPLE:
                ResourceLeakTracker<ByteBuf> leak = AbstractByteBuf.leakDetector.track(buf);
                if (leak != null) {
                    buf = new SimpleLeakAwareByteBuf(buf, leak);
                    break;
                }
                break;
            case ADVANCED:
            case PARANOID:
                ResourceLeakTracker<ByteBuf> leak2 = AbstractByteBuf.leakDetector.track(buf);
                if (leak2 != null) {
                    buf = new AdvancedLeakAwareByteBuf(buf, leak2);
                    break;
                }
                break;
        }
        return buf;
    }

    protected static CompositeByteBuf toLeakAwareBuffer(CompositeByteBuf buf) {
        switch (ResourceLeakDetector.getLevel()) {
            case SIMPLE:
                ResourceLeakTracker<ByteBuf> leak = AbstractByteBuf.leakDetector.track(buf);
                if (leak != null) {
                    buf = new SimpleLeakAwareCompositeByteBuf(buf, leak);
                    break;
                }
                break;
            case ADVANCED:
            case PARANOID:
                ResourceLeakTracker<ByteBuf> leak2 = AbstractByteBuf.leakDetector.track(buf);
                if (leak2 != null) {
                    buf = new AdvancedLeakAwareCompositeByteBuf(buf, leak2);
                    break;
                }
                break;
        }
        return buf;
    }

    protected AbstractByteBufAllocator() {
        this(false);
    }

    /* access modifiers changed from: protected */
    public AbstractByteBufAllocator(boolean preferDirect) {
        this.directByDefault = preferDirect && PlatformDependent.hasUnsafe();
        this.emptyBuf = new EmptyByteBuf(this);
    }

    @Override // p013io.netty.buffer.ByteBufAllocator
    public ByteBuf buffer() {
        if (this.directByDefault) {
            return directBuffer();
        }
        return heapBuffer();
    }

    @Override // p013io.netty.buffer.ByteBufAllocator
    public ByteBuf buffer(int initialCapacity) {
        if (this.directByDefault) {
            return directBuffer(initialCapacity);
        }
        return heapBuffer(initialCapacity);
    }

    @Override // p013io.netty.buffer.ByteBufAllocator
    public ByteBuf buffer(int initialCapacity, int maxCapacity) {
        if (this.directByDefault) {
            return directBuffer(initialCapacity, maxCapacity);
        }
        return heapBuffer(initialCapacity, maxCapacity);
    }

    @Override // p013io.netty.buffer.ByteBufAllocator
    public ByteBuf ioBuffer() {
        if (PlatformDependent.hasUnsafe() || isDirectBufferPooled()) {
            return directBuffer(256);
        }
        return heapBuffer(256);
    }

    @Override // p013io.netty.buffer.ByteBufAllocator
    public ByteBuf ioBuffer(int initialCapacity) {
        if (PlatformDependent.hasUnsafe() || isDirectBufferPooled()) {
            return directBuffer(initialCapacity);
        }
        return heapBuffer(initialCapacity);
    }

    @Override // p013io.netty.buffer.ByteBufAllocator
    public ByteBuf ioBuffer(int initialCapacity, int maxCapacity) {
        if (PlatformDependent.hasUnsafe() || isDirectBufferPooled()) {
            return directBuffer(initialCapacity, maxCapacity);
        }
        return heapBuffer(initialCapacity, maxCapacity);
    }

    @Override // p013io.netty.buffer.ByteBufAllocator
    public ByteBuf heapBuffer() {
        return heapBuffer(256, Integer.MAX_VALUE);
    }

    @Override // p013io.netty.buffer.ByteBufAllocator
    public ByteBuf heapBuffer(int initialCapacity) {
        return heapBuffer(initialCapacity, Integer.MAX_VALUE);
    }

    @Override // p013io.netty.buffer.ByteBufAllocator
    public ByteBuf heapBuffer(int initialCapacity, int maxCapacity) {
        if (initialCapacity == 0 && maxCapacity == 0) {
            return this.emptyBuf;
        }
        validate(initialCapacity, maxCapacity);
        return newHeapBuffer(initialCapacity, maxCapacity);
    }

    @Override // p013io.netty.buffer.ByteBufAllocator
    public ByteBuf directBuffer() {
        return directBuffer(256, Integer.MAX_VALUE);
    }

    @Override // p013io.netty.buffer.ByteBufAllocator
    public ByteBuf directBuffer(int initialCapacity) {
        return directBuffer(initialCapacity, Integer.MAX_VALUE);
    }

    @Override // p013io.netty.buffer.ByteBufAllocator
    public ByteBuf directBuffer(int initialCapacity, int maxCapacity) {
        if (initialCapacity == 0 && maxCapacity == 0) {
            return this.emptyBuf;
        }
        validate(initialCapacity, maxCapacity);
        return newDirectBuffer(initialCapacity, maxCapacity);
    }

    @Override // p013io.netty.buffer.ByteBufAllocator
    public CompositeByteBuf compositeBuffer() {
        if (this.directByDefault) {
            return compositeDirectBuffer();
        }
        return compositeHeapBuffer();
    }

    @Override // p013io.netty.buffer.ByteBufAllocator
    public CompositeByteBuf compositeBuffer(int maxNumComponents) {
        if (this.directByDefault) {
            return compositeDirectBuffer(maxNumComponents);
        }
        return compositeHeapBuffer(maxNumComponents);
    }

    @Override // p013io.netty.buffer.ByteBufAllocator
    public CompositeByteBuf compositeHeapBuffer() {
        return compositeHeapBuffer(16);
    }

    @Override // p013io.netty.buffer.ByteBufAllocator
    public CompositeByteBuf compositeHeapBuffer(int maxNumComponents) {
        return toLeakAwareBuffer(new CompositeByteBuf(this, false, maxNumComponents));
    }

    @Override // p013io.netty.buffer.ByteBufAllocator
    public CompositeByteBuf compositeDirectBuffer() {
        return compositeDirectBuffer(16);
    }

    @Override // p013io.netty.buffer.ByteBufAllocator
    public CompositeByteBuf compositeDirectBuffer(int maxNumComponents) {
        return toLeakAwareBuffer(new CompositeByteBuf(this, true, maxNumComponents));
    }

    private static void validate(int initialCapacity, int maxCapacity) {
        ObjectUtil.checkPositiveOrZero(initialCapacity, "initialCapacity");
        if (initialCapacity > maxCapacity) {
            throw new IllegalArgumentException(String.format("initialCapacity: %d (expected: not greater than maxCapacity(%d)", Integer.valueOf(initialCapacity), Integer.valueOf(maxCapacity)));
        }
    }

    public String toString() {
        return StringUtil.simpleClassName(this) + "(directByDefault: " + this.directByDefault + ')';
    }

    @Override // p013io.netty.buffer.ByteBufAllocator
    public int calculateNewCapacity(int minNewCapacity, int maxCapacity) {
        int newCapacity;
        ObjectUtil.checkPositiveOrZero(minNewCapacity, "minNewCapacity");
        if (minNewCapacity > maxCapacity) {
            throw new IllegalArgumentException(String.format("minNewCapacity: %d (expected: not greater than maxCapacity(%d)", Integer.valueOf(minNewCapacity), Integer.valueOf(maxCapacity)));
        } else if (minNewCapacity == 4194304) {
            return 4194304;
        } else {
            if (minNewCapacity <= 4194304) {
                return Math.min(MathUtil.findNextPositivePowerOfTwo(Math.max(minNewCapacity, 64)), maxCapacity);
            }
            int newCapacity2 = (minNewCapacity / 4194304) * 4194304;
            if (newCapacity2 > maxCapacity - 4194304) {
                newCapacity = maxCapacity;
            } else {
                newCapacity = newCapacity2 + 4194304;
            }
            return newCapacity;
        }
    }
}
