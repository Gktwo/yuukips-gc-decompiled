package p013io.netty.buffer;

import java.nio.ByteBuffer;
import p013io.netty.util.internal.PlatformDependent;

/* access modifiers changed from: package-private */
/* renamed from: io.netty.buffer.UnpooledUnsafeNoCleanerDirectByteBuf */
/* loaded from: grasscutter.jar:io/netty/buffer/UnpooledUnsafeNoCleanerDirectByteBuf.class */
public class UnpooledUnsafeNoCleanerDirectByteBuf extends UnpooledUnsafeDirectByteBuf {
    /* access modifiers changed from: package-private */
    public UnpooledUnsafeNoCleanerDirectByteBuf(ByteBufAllocator alloc, int initialCapacity, int maxCapacity) {
        super(alloc, initialCapacity, maxCapacity);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.UnpooledDirectByteBuf
    public ByteBuffer allocateDirect(int initialCapacity) {
        return PlatformDependent.allocateDirectNoCleaner(initialCapacity);
    }

    /* access modifiers changed from: package-private */
    public ByteBuffer reallocateDirect(ByteBuffer oldBuffer, int initialCapacity) {
        return PlatformDependent.reallocateDirectNoCleaner(oldBuffer, initialCapacity);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.UnpooledDirectByteBuf
    public void freeDirect(ByteBuffer buffer) {
        PlatformDependent.freeDirectNoCleaner(buffer);
    }

    @Override // p013io.netty.buffer.UnpooledDirectByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf capacity(int newCapacity) {
        checkNewCapacity(newCapacity);
        if (newCapacity == capacity()) {
            return this;
        }
        trimIndicesToCapacity(newCapacity);
        setByteBuffer(reallocateDirect(this.buffer, newCapacity), false);
        return this;
    }
}
