package p013io.netty.buffer;

import p013io.netty.util.internal.PlatformDependent;

/* renamed from: io.netty.buffer.UnsafeHeapSwappedByteBuf */
/* loaded from: grasscutter.jar:io/netty/buffer/UnsafeHeapSwappedByteBuf.class */
final class UnsafeHeapSwappedByteBuf extends AbstractUnsafeSwappedByteBuf {
    /* access modifiers changed from: package-private */
    public UnsafeHeapSwappedByteBuf(AbstractByteBuf buf) {
        super(buf);
    }

    private static int idx(ByteBuf wrapped, int index) {
        return wrapped.arrayOffset() + index;
    }

    @Override // p013io.netty.buffer.AbstractUnsafeSwappedByteBuf
    protected long _getLong(AbstractByteBuf wrapped, int index) {
        return PlatformDependent.getLong(wrapped.array(), idx(wrapped, index));
    }

    @Override // p013io.netty.buffer.AbstractUnsafeSwappedByteBuf
    protected int _getInt(AbstractByteBuf wrapped, int index) {
        return PlatformDependent.getInt(wrapped.array(), idx(wrapped, index));
    }

    @Override // p013io.netty.buffer.AbstractUnsafeSwappedByteBuf
    protected short _getShort(AbstractByteBuf wrapped, int index) {
        return PlatformDependent.getShort(wrapped.array(), idx(wrapped, index));
    }

    @Override // p013io.netty.buffer.AbstractUnsafeSwappedByteBuf
    protected void _setShort(AbstractByteBuf wrapped, int index, short value) {
        PlatformDependent.putShort(wrapped.array(), idx(wrapped, index), value);
    }

    @Override // p013io.netty.buffer.AbstractUnsafeSwappedByteBuf
    protected void _setInt(AbstractByteBuf wrapped, int index, int value) {
        PlatformDependent.putInt(wrapped.array(), idx(wrapped, index), value);
    }

    @Override // p013io.netty.buffer.AbstractUnsafeSwappedByteBuf
    protected void _setLong(AbstractByteBuf wrapped, int index, long value) {
        PlatformDependent.putLong(wrapped.array(), idx(wrapped, index), value);
    }
}
