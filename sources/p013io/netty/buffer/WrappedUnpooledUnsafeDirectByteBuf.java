package p013io.netty.buffer;

import java.nio.ByteBuffer;
import p013io.netty.util.internal.PlatformDependent;

/* renamed from: io.netty.buffer.WrappedUnpooledUnsafeDirectByteBuf */
/* loaded from: grasscutter.jar:io/netty/buffer/WrappedUnpooledUnsafeDirectByteBuf.class */
final class WrappedUnpooledUnsafeDirectByteBuf extends UnpooledUnsafeDirectByteBuf {
    /* access modifiers changed from: package-private */
    public WrappedUnpooledUnsafeDirectByteBuf(ByteBufAllocator alloc, long memoryAddress, int size, boolean doFree) {
        super(alloc, PlatformDependent.directBuffer(memoryAddress, size), size, doFree);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.UnpooledDirectByteBuf
    public void freeDirect(ByteBuffer buffer) {
        PlatformDependent.freeMemory(this.memoryAddress);
    }
}
