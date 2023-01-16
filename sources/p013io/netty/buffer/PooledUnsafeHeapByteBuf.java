package p013io.netty.buffer;

import p013io.netty.util.internal.ObjectPool;
import p013io.netty.util.internal.PlatformDependent;

/* access modifiers changed from: package-private */
/* renamed from: io.netty.buffer.PooledUnsafeHeapByteBuf */
/* loaded from: grasscutter.jar:io/netty/buffer/PooledUnsafeHeapByteBuf.class */
public final class PooledUnsafeHeapByteBuf extends PooledHeapByteBuf {
    private static final ObjectPool<PooledUnsafeHeapByteBuf> RECYCLER = ObjectPool.newPool(new ObjectPool.ObjectCreator<PooledUnsafeHeapByteBuf>() { // from class: io.netty.buffer.PooledUnsafeHeapByteBuf.1
        @Override // p013io.netty.util.internal.ObjectPool.ObjectCreator
        public PooledUnsafeHeapByteBuf newObject(ObjectPool.Handle<PooledUnsafeHeapByteBuf> handle) {
            return new PooledUnsafeHeapByteBuf(handle, 0);
        }
    });

    /* access modifiers changed from: package-private */
    public static PooledUnsafeHeapByteBuf newUnsafeInstance(int maxCapacity) {
        PooledUnsafeHeapByteBuf buf = RECYCLER.get();
        buf.reuse(maxCapacity);
        return buf;
    }

    private PooledUnsafeHeapByteBuf(ObjectPool.Handle<PooledUnsafeHeapByteBuf> recyclerHandle, int maxCapacity) {
        super(recyclerHandle, maxCapacity);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.PooledHeapByteBuf, p013io.netty.buffer.AbstractByteBuf
    public byte _getByte(int index) {
        return UnsafeByteBufUtil.getByte((byte[]) this.memory, idx(index));
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.PooledHeapByteBuf, p013io.netty.buffer.AbstractByteBuf
    public short _getShort(int index) {
        return UnsafeByteBufUtil.getShort((byte[]) this.memory, idx(index));
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.PooledHeapByteBuf, p013io.netty.buffer.AbstractByteBuf
    public short _getShortLE(int index) {
        return UnsafeByteBufUtil.getShortLE((byte[]) this.memory, idx(index));
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.PooledHeapByteBuf, p013io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMedium(int index) {
        return UnsafeByteBufUtil.getUnsignedMedium((byte[]) this.memory, idx(index));
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.PooledHeapByteBuf, p013io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMediumLE(int index) {
        return UnsafeByteBufUtil.getUnsignedMediumLE((byte[]) this.memory, idx(index));
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.PooledHeapByteBuf, p013io.netty.buffer.AbstractByteBuf
    public int _getInt(int index) {
        return UnsafeByteBufUtil.getInt((byte[]) this.memory, idx(index));
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.PooledHeapByteBuf, p013io.netty.buffer.AbstractByteBuf
    public int _getIntLE(int index) {
        return UnsafeByteBufUtil.getIntLE((byte[]) this.memory, idx(index));
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.PooledHeapByteBuf, p013io.netty.buffer.AbstractByteBuf
    public long _getLong(int index) {
        return UnsafeByteBufUtil.getLong((byte[]) this.memory, idx(index));
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.PooledHeapByteBuf, p013io.netty.buffer.AbstractByteBuf
    public long _getLongLE(int index) {
        return UnsafeByteBufUtil.getLongLE((byte[]) this.memory, idx(index));
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.PooledHeapByteBuf, p013io.netty.buffer.AbstractByteBuf
    public void _setByte(int index, int value) {
        UnsafeByteBufUtil.setByte((byte[]) this.memory, idx(index), value);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.PooledHeapByteBuf, p013io.netty.buffer.AbstractByteBuf
    public void _setShort(int index, int value) {
        UnsafeByteBufUtil.setShort((byte[]) this.memory, idx(index), value);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.PooledHeapByteBuf, p013io.netty.buffer.AbstractByteBuf
    public void _setShortLE(int index, int value) {
        UnsafeByteBufUtil.setShortLE((byte[]) this.memory, idx(index), value);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.PooledHeapByteBuf, p013io.netty.buffer.AbstractByteBuf
    public void _setMedium(int index, int value) {
        UnsafeByteBufUtil.setMedium((byte[]) this.memory, idx(index), value);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.PooledHeapByteBuf, p013io.netty.buffer.AbstractByteBuf
    public void _setMediumLE(int index, int value) {
        UnsafeByteBufUtil.setMediumLE((byte[]) this.memory, idx(index), value);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.PooledHeapByteBuf, p013io.netty.buffer.AbstractByteBuf
    public void _setInt(int index, int value) {
        UnsafeByteBufUtil.setInt((byte[]) this.memory, idx(index), value);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.PooledHeapByteBuf, p013io.netty.buffer.AbstractByteBuf
    public void _setIntLE(int index, int value) {
        UnsafeByteBufUtil.setIntLE((byte[]) this.memory, idx(index), value);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.PooledHeapByteBuf, p013io.netty.buffer.AbstractByteBuf
    public void _setLong(int index, long value) {
        UnsafeByteBufUtil.setLong((byte[]) this.memory, idx(index), value);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.PooledHeapByteBuf, p013io.netty.buffer.AbstractByteBuf
    public void _setLongLE(int index, long value) {
        UnsafeByteBufUtil.setLongLE((byte[]) this.memory, idx(index), value);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setZero(int index, int length) {
        if (PlatformDependent.javaVersion() < 7) {
            return setZero(index, length);
        }
        checkIndex(index, length);
        UnsafeByteBufUtil.setZero((byte[]) this.memory, idx(index), length);
        return this;
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf writeZero(int length) {
        if (PlatformDependent.javaVersion() < 7) {
            return writeZero(length);
        }
        ensureWritable(length);
        int wIndex = this.writerIndex;
        UnsafeByteBufUtil.setZero((byte[]) this.memory, idx(wIndex), length);
        this.writerIndex = wIndex + length;
        return this;
    }

    @Override // p013io.netty.buffer.AbstractByteBuf
    @Deprecated
    protected SwappedByteBuf newSwappedByteBuf() {
        if (PlatformDependent.isUnaligned()) {
            return new UnsafeHeapSwappedByteBuf(this);
        }
        return newSwappedByteBuf();
    }
}
