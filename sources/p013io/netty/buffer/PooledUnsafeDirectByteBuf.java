package p013io.netty.buffer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import p013io.netty.util.internal.ObjectPool;
import p013io.netty.util.internal.PlatformDependent;

/* access modifiers changed from: package-private */
/* renamed from: io.netty.buffer.PooledUnsafeDirectByteBuf */
/* loaded from: grasscutter.jar:io/netty/buffer/PooledUnsafeDirectByteBuf.class */
public final class PooledUnsafeDirectByteBuf extends PooledByteBuf<ByteBuffer> {
    private static final ObjectPool<PooledUnsafeDirectByteBuf> RECYCLER = ObjectPool.newPool(new ObjectPool.ObjectCreator<PooledUnsafeDirectByteBuf>() { // from class: io.netty.buffer.PooledUnsafeDirectByteBuf.1
        @Override // p013io.netty.util.internal.ObjectPool.ObjectCreator
        public PooledUnsafeDirectByteBuf newObject(ObjectPool.Handle<PooledUnsafeDirectByteBuf> handle) {
            return new PooledUnsafeDirectByteBuf(handle, 0);
        }
    });
    private long memoryAddress;

    /* access modifiers changed from: package-private */
    public static PooledUnsafeDirectByteBuf newInstance(int maxCapacity) {
        PooledUnsafeDirectByteBuf buf = RECYCLER.get();
        buf.reuse(maxCapacity);
        return buf;
    }

    private PooledUnsafeDirectByteBuf(ObjectPool.Handle<PooledUnsafeDirectByteBuf> recyclerHandle, int maxCapacity) {
        super(recyclerHandle, maxCapacity);
    }

    /* access modifiers changed from: package-private */
    @Override // p013io.netty.buffer.PooledByteBuf
    public void init(PoolChunk<ByteBuffer> chunk, ByteBuffer nioBuffer, long handle, int offset, int length, int maxLength, PoolThreadCache cache) {
        init(chunk, nioBuffer, handle, offset, length, maxLength, cache);
        initMemoryAddress();
    }

    /* access modifiers changed from: package-private */
    @Override // p013io.netty.buffer.PooledByteBuf
    public void initUnpooled(PoolChunk<ByteBuffer> chunk, int length) {
        initUnpooled(chunk, length);
        initMemoryAddress();
    }

    private void initMemoryAddress() {
        this.memoryAddress = PlatformDependent.directBufferAddress((ByteBuffer) this.memory) + ((long) this.offset);
    }

    /* access modifiers changed from: protected */
    public ByteBuffer newInternalNioBuffer(ByteBuffer memory) {
        return memory.duplicate();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public boolean isDirect() {
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public byte _getByte(int index) {
        return UnsafeByteBufUtil.getByte(addr(index));
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public short _getShort(int index) {
        return UnsafeByteBufUtil.getShort(addr(index));
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public short _getShortLE(int index) {
        return UnsafeByteBufUtil.getShortLE(addr(index));
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMedium(int index) {
        return UnsafeByteBufUtil.getUnsignedMedium(addr(index));
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMediumLE(int index) {
        return UnsafeByteBufUtil.getUnsignedMediumLE(addr(index));
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public int _getInt(int index) {
        return UnsafeByteBufUtil.getInt(addr(index));
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public int _getIntLE(int index) {
        return UnsafeByteBufUtil.getIntLE(addr(index));
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public long _getLong(int index) {
        return UnsafeByteBufUtil.getLong(addr(index));
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public long _getLongLE(int index) {
        return UnsafeByteBufUtil.getLongLE(addr(index));
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int index, ByteBuf dst, int dstIndex, int length) {
        UnsafeByteBufUtil.getBytes(this, addr(index), index, dst, dstIndex, length);
        return this;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int index, byte[] dst, int dstIndex, int length) {
        UnsafeByteBufUtil.getBytes(this, addr(index), index, dst, dstIndex, length);
        return this;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int index, ByteBuffer dst) {
        UnsafeByteBufUtil.getBytes(this, addr(index), index, dst);
        return this;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int index, OutputStream out, int length) throws IOException {
        UnsafeByteBufUtil.getBytes(this, addr(index), index, out, length);
        return this;
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public void _setByte(int index, int value) {
        UnsafeByteBufUtil.setByte(addr(index), (byte) value);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public void _setShort(int index, int value) {
        UnsafeByteBufUtil.setShort(addr(index), value);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public void _setShortLE(int index, int value) {
        UnsafeByteBufUtil.setShortLE(addr(index), value);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public void _setMedium(int index, int value) {
        UnsafeByteBufUtil.setMedium(addr(index), value);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public void _setMediumLE(int index, int value) {
        UnsafeByteBufUtil.setMediumLE(addr(index), value);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public void _setInt(int index, int value) {
        UnsafeByteBufUtil.setInt(addr(index), value);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public void _setIntLE(int index, int value) {
        UnsafeByteBufUtil.setIntLE(addr(index), value);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public void _setLong(int index, long value) {
        UnsafeByteBufUtil.setLong(addr(index), value);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public void _setLongLE(int index, long value) {
        UnsafeByteBufUtil.setLongLE(addr(index), value);
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int index, ByteBuf src, int srcIndex, int length) {
        UnsafeByteBufUtil.setBytes(this, addr(index), index, src, srcIndex, length);
        return this;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int index, byte[] src, int srcIndex, int length) {
        UnsafeByteBufUtil.setBytes(this, addr(index), index, src, srcIndex, length);
        return this;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int index, ByteBuffer src) {
        UnsafeByteBufUtil.setBytes(this, addr(index), index, src);
        return this;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public int setBytes(int index, InputStream in, int length) throws IOException {
        return UnsafeByteBufUtil.setBytes(this, addr(index), index, in, length);
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf copy(int index, int length) {
        return UnsafeByteBufUtil.copy(this, addr(index), index, length);
    }

    @Override // p013io.netty.buffer.ByteBuf
    public boolean hasArray() {
        return false;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public byte[] array() {
        throw new UnsupportedOperationException("direct buffer");
    }

    @Override // p013io.netty.buffer.ByteBuf
    public int arrayOffset() {
        throw new UnsupportedOperationException("direct buffer");
    }

    @Override // p013io.netty.buffer.ByteBuf
    public boolean hasMemoryAddress() {
        return true;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public long memoryAddress() {
        ensureAccessible();
        return this.memoryAddress;
    }

    private long addr(int index) {
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
