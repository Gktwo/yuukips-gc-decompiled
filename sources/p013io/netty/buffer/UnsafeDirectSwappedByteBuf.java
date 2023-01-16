package p013io.netty.buffer;

import p013io.netty.util.internal.PlatformDependent;

/* renamed from: io.netty.buffer.UnsafeDirectSwappedByteBuf */
/* loaded from: grasscutter.jar:io/netty/buffer/UnsafeDirectSwappedByteBuf.class */
final class UnsafeDirectSwappedByteBuf extends AbstractUnsafeSwappedByteBuf {
    /* access modifiers changed from: package-private */
    public UnsafeDirectSwappedByteBuf(AbstractByteBuf buf) {
        super(buf);
    }

    private static long addr(AbstractByteBuf wrapped, int index) {
        return wrapped.memoryAddress() + ((long) index);
    }

    @Override // p013io.netty.buffer.AbstractUnsafeSwappedByteBuf
    protected long _getLong(AbstractByteBuf wrapped, int index) {
        return PlatformDependent.getLong(addr(wrapped, index));
    }

    @Override // p013io.netty.buffer.AbstractUnsafeSwappedByteBuf
    protected int _getInt(AbstractByteBuf wrapped, int index) {
        return PlatformDependent.getInt(addr(wrapped, index));
    }

    @Override // p013io.netty.buffer.AbstractUnsafeSwappedByteBuf
    protected short _getShort(AbstractByteBuf wrapped, int index) {
        return PlatformDependent.getShort(addr(wrapped, index));
    }

    @Override // p013io.netty.buffer.AbstractUnsafeSwappedByteBuf
    protected void _setShort(AbstractByteBuf wrapped, int index, short value) {
        PlatformDependent.putShort(addr(wrapped, index), value);
    }

    @Override // p013io.netty.buffer.AbstractUnsafeSwappedByteBuf
    protected void _setInt(AbstractByteBuf wrapped, int index, int value) {
        PlatformDependent.putInt(addr(wrapped, index), value);
    }

    @Override // p013io.netty.buffer.AbstractUnsafeSwappedByteBuf
    protected void _setLong(AbstractByteBuf wrapped, int index, long value) {
        PlatformDependent.putLong(addr(wrapped, index), value);
    }
}
