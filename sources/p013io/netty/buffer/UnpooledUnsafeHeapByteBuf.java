package p013io.netty.buffer;

import p013io.netty.util.internal.PlatformDependent;

/* renamed from: io.netty.buffer.UnpooledUnsafeHeapByteBuf */
/* loaded from: grasscutter.jar:io/netty/buffer/UnpooledUnsafeHeapByteBuf.class */
public class UnpooledUnsafeHeapByteBuf extends UnpooledHeapByteBuf {
    public UnpooledUnsafeHeapByteBuf(ByteBufAllocator alloc, int initialCapacity, int maxCapacity) {
        super(alloc, initialCapacity, maxCapacity);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.UnpooledHeapByteBuf
    public byte[] allocateArray(int initialCapacity) {
        return PlatformDependent.allocateUninitializedArray(initialCapacity);
    }

    @Override // p013io.netty.buffer.UnpooledHeapByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public byte getByte(int index) {
        checkIndex(index);
        return _getByte(index);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.UnpooledHeapByteBuf, p013io.netty.buffer.AbstractByteBuf
    public byte _getByte(int index) {
        return UnsafeByteBufUtil.getByte(this.array, index);
    }

    @Override // p013io.netty.buffer.UnpooledHeapByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public short getShort(int index) {
        checkIndex(index, 2);
        return _getShort(index);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.UnpooledHeapByteBuf, p013io.netty.buffer.AbstractByteBuf
    public short _getShort(int index) {
        return UnsafeByteBufUtil.getShort(this.array, index);
    }

    @Override // p013io.netty.buffer.UnpooledHeapByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public short getShortLE(int index) {
        checkIndex(index, 2);
        return _getShortLE(index);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.UnpooledHeapByteBuf, p013io.netty.buffer.AbstractByteBuf
    public short _getShortLE(int index) {
        return UnsafeByteBufUtil.getShortLE(this.array, index);
    }

    @Override // p013io.netty.buffer.UnpooledHeapByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int getUnsignedMedium(int index) {
        checkIndex(index, 3);
        return _getUnsignedMedium(index);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.UnpooledHeapByteBuf, p013io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMedium(int index) {
        return UnsafeByteBufUtil.getUnsignedMedium(this.array, index);
    }

    @Override // p013io.netty.buffer.UnpooledHeapByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int getUnsignedMediumLE(int index) {
        checkIndex(index, 3);
        return _getUnsignedMediumLE(index);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.UnpooledHeapByteBuf, p013io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMediumLE(int index) {
        return UnsafeByteBufUtil.getUnsignedMediumLE(this.array, index);
    }

    @Override // p013io.netty.buffer.UnpooledHeapByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int getInt(int index) {
        checkIndex(index, 4);
        return _getInt(index);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.UnpooledHeapByteBuf, p013io.netty.buffer.AbstractByteBuf
    public int _getInt(int index) {
        return UnsafeByteBufUtil.getInt(this.array, index);
    }

    @Override // p013io.netty.buffer.UnpooledHeapByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int getIntLE(int index) {
        checkIndex(index, 4);
        return _getIntLE(index);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.UnpooledHeapByteBuf, p013io.netty.buffer.AbstractByteBuf
    public int _getIntLE(int index) {
        return UnsafeByteBufUtil.getIntLE(this.array, index);
    }

    @Override // p013io.netty.buffer.UnpooledHeapByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public long getLong(int index) {
        checkIndex(index, 8);
        return _getLong(index);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.UnpooledHeapByteBuf, p013io.netty.buffer.AbstractByteBuf
    public long _getLong(int index) {
        return UnsafeByteBufUtil.getLong(this.array, index);
    }

    @Override // p013io.netty.buffer.UnpooledHeapByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public long getLongLE(int index) {
        checkIndex(index, 8);
        return _getLongLE(index);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.UnpooledHeapByteBuf, p013io.netty.buffer.AbstractByteBuf
    public long _getLongLE(int index) {
        return UnsafeByteBufUtil.getLongLE(this.array, index);
    }

    @Override // p013io.netty.buffer.UnpooledHeapByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setByte(int index, int value) {
        checkIndex(index);
        _setByte(index, value);
        return this;
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.UnpooledHeapByteBuf, p013io.netty.buffer.AbstractByteBuf
    public void _setByte(int index, int value) {
        UnsafeByteBufUtil.setByte(this.array, index, value);
    }

    @Override // p013io.netty.buffer.UnpooledHeapByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setShort(int index, int value) {
        checkIndex(index, 2);
        _setShort(index, value);
        return this;
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.UnpooledHeapByteBuf, p013io.netty.buffer.AbstractByteBuf
    public void _setShort(int index, int value) {
        UnsafeByteBufUtil.setShort(this.array, index, value);
    }

    @Override // p013io.netty.buffer.UnpooledHeapByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setShortLE(int index, int value) {
        checkIndex(index, 2);
        _setShortLE(index, value);
        return this;
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.UnpooledHeapByteBuf, p013io.netty.buffer.AbstractByteBuf
    public void _setShortLE(int index, int value) {
        UnsafeByteBufUtil.setShortLE(this.array, index, value);
    }

    @Override // p013io.netty.buffer.UnpooledHeapByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setMedium(int index, int value) {
        checkIndex(index, 3);
        _setMedium(index, value);
        return this;
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.UnpooledHeapByteBuf, p013io.netty.buffer.AbstractByteBuf
    public void _setMedium(int index, int value) {
        UnsafeByteBufUtil.setMedium(this.array, index, value);
    }

    @Override // p013io.netty.buffer.UnpooledHeapByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setMediumLE(int index, int value) {
        checkIndex(index, 3);
        _setMediumLE(index, value);
        return this;
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.UnpooledHeapByteBuf, p013io.netty.buffer.AbstractByteBuf
    public void _setMediumLE(int index, int value) {
        UnsafeByteBufUtil.setMediumLE(this.array, index, value);
    }

    @Override // p013io.netty.buffer.UnpooledHeapByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setInt(int index, int value) {
        checkIndex(index, 4);
        _setInt(index, value);
        return this;
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.UnpooledHeapByteBuf, p013io.netty.buffer.AbstractByteBuf
    public void _setInt(int index, int value) {
        UnsafeByteBufUtil.setInt(this.array, index, value);
    }

    @Override // p013io.netty.buffer.UnpooledHeapByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setIntLE(int index, int value) {
        checkIndex(index, 4);
        _setIntLE(index, value);
        return this;
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.UnpooledHeapByteBuf, p013io.netty.buffer.AbstractByteBuf
    public void _setIntLE(int index, int value) {
        UnsafeByteBufUtil.setIntLE(this.array, index, value);
    }

    @Override // p013io.netty.buffer.UnpooledHeapByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setLong(int index, long value) {
        checkIndex(index, 8);
        _setLong(index, value);
        return this;
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.UnpooledHeapByteBuf, p013io.netty.buffer.AbstractByteBuf
    public void _setLong(int index, long value) {
        UnsafeByteBufUtil.setLong(this.array, index, value);
    }

    @Override // p013io.netty.buffer.UnpooledHeapByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setLongLE(int index, long value) {
        checkIndex(index, 8);
        _setLongLE(index, value);
        return this;
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.UnpooledHeapByteBuf, p013io.netty.buffer.AbstractByteBuf
    public void _setLongLE(int index, long value) {
        UnsafeByteBufUtil.setLongLE(this.array, index, value);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setZero(int index, int length) {
        if (PlatformDependent.javaVersion() < 7) {
            return setZero(index, length);
        }
        checkIndex(index, length);
        UnsafeByteBufUtil.setZero(this.array, index, length);
        return this;
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf writeZero(int length) {
        if (PlatformDependent.javaVersion() < 7) {
            return writeZero(length);
        }
        ensureWritable(length);
        int wIndex = this.writerIndex;
        UnsafeByteBufUtil.setZero(this.array, wIndex, length);
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
