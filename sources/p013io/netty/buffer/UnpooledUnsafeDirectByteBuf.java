package p013io.netty.buffer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import p013io.netty.util.internal.PlatformDependent;

/* renamed from: io.netty.buffer.UnpooledUnsafeDirectByteBuf */
/* loaded from: grasscutter.jar:io/netty/buffer/UnpooledUnsafeDirectByteBuf.class */
public class UnpooledUnsafeDirectByteBuf extends UnpooledDirectByteBuf {
    long memoryAddress;

    public UnpooledUnsafeDirectByteBuf(ByteBufAllocator alloc, int initialCapacity, int maxCapacity) {
        super(alloc, initialCapacity, maxCapacity);
    }

    /* access modifiers changed from: protected */
    public UnpooledUnsafeDirectByteBuf(ByteBufAllocator alloc, ByteBuffer initialBuffer, int maxCapacity) {
        super(alloc, initialBuffer, maxCapacity, false, true);
    }

    /* access modifiers changed from: package-private */
    public UnpooledUnsafeDirectByteBuf(ByteBufAllocator alloc, ByteBuffer initialBuffer, int maxCapacity, boolean doFree) {
        super(alloc, initialBuffer, maxCapacity, doFree, false);
    }

    /* access modifiers changed from: package-private */
    @Override // p013io.netty.buffer.UnpooledDirectByteBuf
    public final void setByteBuffer(ByteBuffer buffer, boolean tryFree) {
        setByteBuffer(buffer, tryFree);
        this.memoryAddress = PlatformDependent.directBufferAddress(buffer);
    }

    @Override // p013io.netty.buffer.UnpooledDirectByteBuf, p013io.netty.buffer.ByteBuf
    public boolean hasMemoryAddress() {
        return true;
    }

    @Override // p013io.netty.buffer.UnpooledDirectByteBuf, p013io.netty.buffer.ByteBuf
    public long memoryAddress() {
        ensureAccessible();
        return this.memoryAddress;
    }

    @Override // p013io.netty.buffer.UnpooledDirectByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public byte getByte(int index) {
        checkIndex(index);
        return _getByte(index);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.UnpooledDirectByteBuf, p013io.netty.buffer.AbstractByteBuf
    public byte _getByte(int index) {
        return UnsafeByteBufUtil.getByte(addr(index));
    }

    @Override // p013io.netty.buffer.UnpooledDirectByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public short getShort(int index) {
        checkIndex(index, 2);
        return _getShort(index);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.UnpooledDirectByteBuf, p013io.netty.buffer.AbstractByteBuf
    public short _getShort(int index) {
        return UnsafeByteBufUtil.getShort(addr(index));
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.UnpooledDirectByteBuf, p013io.netty.buffer.AbstractByteBuf
    public short _getShortLE(int index) {
        return UnsafeByteBufUtil.getShortLE(addr(index));
    }

    @Override // p013io.netty.buffer.UnpooledDirectByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int getUnsignedMedium(int index) {
        checkIndex(index, 3);
        return _getUnsignedMedium(index);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.UnpooledDirectByteBuf, p013io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMedium(int index) {
        return UnsafeByteBufUtil.getUnsignedMedium(addr(index));
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.UnpooledDirectByteBuf, p013io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMediumLE(int index) {
        return UnsafeByteBufUtil.getUnsignedMediumLE(addr(index));
    }

    @Override // p013io.netty.buffer.UnpooledDirectByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int getInt(int index) {
        checkIndex(index, 4);
        return _getInt(index);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.UnpooledDirectByteBuf, p013io.netty.buffer.AbstractByteBuf
    public int _getInt(int index) {
        return UnsafeByteBufUtil.getInt(addr(index));
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.UnpooledDirectByteBuf, p013io.netty.buffer.AbstractByteBuf
    public int _getIntLE(int index) {
        return UnsafeByteBufUtil.getIntLE(addr(index));
    }

    @Override // p013io.netty.buffer.UnpooledDirectByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public long getLong(int index) {
        checkIndex(index, 8);
        return _getLong(index);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.UnpooledDirectByteBuf, p013io.netty.buffer.AbstractByteBuf
    public long _getLong(int index) {
        return UnsafeByteBufUtil.getLong(addr(index));
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.UnpooledDirectByteBuf, p013io.netty.buffer.AbstractByteBuf
    public long _getLongLE(int index) {
        return UnsafeByteBufUtil.getLongLE(addr(index));
    }

    @Override // p013io.netty.buffer.UnpooledDirectByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int index, ByteBuf dst, int dstIndex, int length) {
        UnsafeByteBufUtil.getBytes(this, addr(index), index, dst, dstIndex, length);
        return this;
    }

    @Override // p013io.netty.buffer.UnpooledDirectByteBuf
    void getBytes(int index, byte[] dst, int dstIndex, int length, boolean internal) {
        UnsafeByteBufUtil.getBytes(this, addr(index), index, dst, dstIndex, length);
    }

    @Override // p013io.netty.buffer.UnpooledDirectByteBuf
    void getBytes(int index, ByteBuffer dst, boolean internal) {
        UnsafeByteBufUtil.getBytes(this, addr(index), index, dst);
    }

    @Override // p013io.netty.buffer.UnpooledDirectByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setByte(int index, int value) {
        checkIndex(index);
        _setByte(index, value);
        return this;
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.UnpooledDirectByteBuf, p013io.netty.buffer.AbstractByteBuf
    public void _setByte(int index, int value) {
        UnsafeByteBufUtil.setByte(addr(index), value);
    }

    @Override // p013io.netty.buffer.UnpooledDirectByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setShort(int index, int value) {
        checkIndex(index, 2);
        _setShort(index, value);
        return this;
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.UnpooledDirectByteBuf, p013io.netty.buffer.AbstractByteBuf
    public void _setShort(int index, int value) {
        UnsafeByteBufUtil.setShort(addr(index), value);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.UnpooledDirectByteBuf, p013io.netty.buffer.AbstractByteBuf
    public void _setShortLE(int index, int value) {
        UnsafeByteBufUtil.setShortLE(addr(index), value);
    }

    @Override // p013io.netty.buffer.UnpooledDirectByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setMedium(int index, int value) {
        checkIndex(index, 3);
        _setMedium(index, value);
        return this;
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.UnpooledDirectByteBuf, p013io.netty.buffer.AbstractByteBuf
    public void _setMedium(int index, int value) {
        UnsafeByteBufUtil.setMedium(addr(index), value);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.UnpooledDirectByteBuf, p013io.netty.buffer.AbstractByteBuf
    public void _setMediumLE(int index, int value) {
        UnsafeByteBufUtil.setMediumLE(addr(index), value);
    }

    @Override // p013io.netty.buffer.UnpooledDirectByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setInt(int index, int value) {
        checkIndex(index, 4);
        _setInt(index, value);
        return this;
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.UnpooledDirectByteBuf, p013io.netty.buffer.AbstractByteBuf
    public void _setInt(int index, int value) {
        UnsafeByteBufUtil.setInt(addr(index), value);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.UnpooledDirectByteBuf, p013io.netty.buffer.AbstractByteBuf
    public void _setIntLE(int index, int value) {
        UnsafeByteBufUtil.setIntLE(addr(index), value);
    }

    @Override // p013io.netty.buffer.UnpooledDirectByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setLong(int index, long value) {
        checkIndex(index, 8);
        _setLong(index, value);
        return this;
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.UnpooledDirectByteBuf, p013io.netty.buffer.AbstractByteBuf
    public void _setLong(int index, long value) {
        UnsafeByteBufUtil.setLong(addr(index), value);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.UnpooledDirectByteBuf, p013io.netty.buffer.AbstractByteBuf
    public void _setLongLE(int index, long value) {
        UnsafeByteBufUtil.setLongLE(addr(index), value);
    }

    @Override // p013io.netty.buffer.UnpooledDirectByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int index, ByteBuf src, int srcIndex, int length) {
        UnsafeByteBufUtil.setBytes(this, addr(index), index, src, srcIndex, length);
        return this;
    }

    @Override // p013io.netty.buffer.UnpooledDirectByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int index, byte[] src, int srcIndex, int length) {
        UnsafeByteBufUtil.setBytes(this, addr(index), index, src, srcIndex, length);
        return this;
    }

    @Override // p013io.netty.buffer.UnpooledDirectByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int index, ByteBuffer src) {
        UnsafeByteBufUtil.setBytes(this, addr(index), index, src);
        return this;
    }

    @Override // p013io.netty.buffer.UnpooledDirectByteBuf
    void getBytes(int index, OutputStream out, int length, boolean internal) throws IOException {
        UnsafeByteBufUtil.getBytes(this, addr(index), index, out, length);
    }

    @Override // p013io.netty.buffer.UnpooledDirectByteBuf, p013io.netty.buffer.ByteBuf
    public int setBytes(int index, InputStream in, int length) throws IOException {
        return UnsafeByteBufUtil.setBytes(this, addr(index), index, in, length);
    }

    @Override // p013io.netty.buffer.UnpooledDirectByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf copy(int index, int length) {
        return UnsafeByteBufUtil.copy(this, addr(index), index, length);
    }

    final long addr(int index) {
        return this.memoryAddress + ((long) index);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf
    protected SwappedByteBuf newSwappedByteBuf() {
        if (PlatformDependent.isUnaligned()) {
            return new UnsafeDirectSwappedByteBuf(this);
        }
        return newSwappedByteBuf();
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setZero(int index, int length) {
        checkIndex(index, length);
        UnsafeByteBufUtil.setZero(addr(index), length);
        return this;
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf writeZero(int length) {
        ensureWritable(length);
        int wIndex = this.writerIndex;
        UnsafeByteBufUtil.setZero(addr(wIndex), length);
        this.writerIndex = wIndex + length;
        return this;
    }
}
