package p013io.netty.buffer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import p013io.netty.util.internal.StringUtil;

/* access modifiers changed from: package-private */
/* renamed from: io.netty.buffer.ReadOnlyByteBufferBuf */
/* loaded from: grasscutter.jar:io/netty/buffer/ReadOnlyByteBufferBuf.class */
public class ReadOnlyByteBufferBuf extends AbstractReferenceCountedByteBuf {
    protected final ByteBuffer buffer;
    private final ByteBufAllocator allocator;
    private ByteBuffer tmpNioBuf;

    /* access modifiers changed from: package-private */
    public ReadOnlyByteBufferBuf(ByteBufAllocator allocator, ByteBuffer buffer) {
        super(buffer.remaining());
        if (!buffer.isReadOnly()) {
            throw new IllegalArgumentException("must be a readonly buffer: " + StringUtil.simpleClassName(buffer));
        }
        this.allocator = allocator;
        this.buffer = buffer.slice().order(ByteOrder.BIG_ENDIAN);
        writerIndex(this.buffer.limit());
    }

    @Override // p013io.netty.buffer.AbstractReferenceCountedByteBuf
    protected void deallocate() {
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public boolean isWritable() {
        return false;
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public boolean isWritable(int numBytes) {
        return false;
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf ensureWritable(int minWritableBytes) {
        throw new ReadOnlyBufferException();
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int ensureWritable(int minWritableBytes, boolean force) {
        return 1;
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public byte getByte(int index) {
        ensureAccessible();
        return _getByte(index);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public byte _getByte(int index) {
        return this.buffer.get(index);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public short getShort(int index) {
        ensureAccessible();
        return _getShort(index);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public short _getShort(int index) {
        return this.buffer.getShort(index);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public short getShortLE(int index) {
        ensureAccessible();
        return _getShortLE(index);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public short _getShortLE(int index) {
        return ByteBufUtil.swapShort(this.buffer.getShort(index));
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int getUnsignedMedium(int index) {
        ensureAccessible();
        return _getUnsignedMedium(index);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMedium(int index) {
        return ((getByte(index) & 255) << 16) | ((getByte(index + 1) & 255) << 8) | (getByte(index + 2) & 255);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int getUnsignedMediumLE(int index) {
        ensureAccessible();
        return _getUnsignedMediumLE(index);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMediumLE(int index) {
        return (getByte(index) & 255) | ((getByte(index + 1) & 255) << 8) | ((getByte(index + 2) & 255) << 16);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int getInt(int index) {
        ensureAccessible();
        return _getInt(index);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public int _getInt(int index) {
        return this.buffer.getInt(index);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int getIntLE(int index) {
        ensureAccessible();
        return _getIntLE(index);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public int _getIntLE(int index) {
        return ByteBufUtil.swapInt(this.buffer.getInt(index));
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public long getLong(int index) {
        ensureAccessible();
        return _getLong(index);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public long _getLong(int index) {
        return this.buffer.getLong(index);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public long getLongLE(int index) {
        ensureAccessible();
        return _getLongLE(index);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public long _getLongLE(int index) {
        return ByteBufUtil.swapLong(this.buffer.getLong(index));
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int index, ByteBuf dst, int dstIndex, int length) {
        checkDstIndex(index, length, dstIndex, dst.capacity());
        if (dst.hasArray()) {
            getBytes(index, dst.array(), dst.arrayOffset() + dstIndex, length);
        } else if (dst.nioBufferCount() > 0) {
            ByteBuffer[] nioBuffers = dst.nioBuffers(dstIndex, length);
            for (ByteBuffer bb : nioBuffers) {
                int bbLen = bb.remaining();
                getBytes(index, bb);
                index += bbLen;
            }
        } else {
            dst.setBytes(dstIndex, this, index, length);
        }
        return this;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int index, byte[] dst, int dstIndex, int length) {
        checkDstIndex(index, length, dstIndex, dst.length);
        ByteBuffer tmpBuf = internalNioBuffer();
        tmpBuf.clear().position(index).limit(index + length);
        tmpBuf.get(dst, dstIndex, length);
        return this;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int index, ByteBuffer dst) {
        checkIndex(index, dst.remaining());
        ByteBuffer tmpBuf = internalNioBuffer();
        tmpBuf.clear().position(index).limit(index + dst.remaining());
        dst.put(tmpBuf);
        return this;
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setByte(int index, int value) {
        throw new ReadOnlyBufferException();
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public void _setByte(int index, int value) {
        throw new ReadOnlyBufferException();
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setShort(int index, int value) {
        throw new ReadOnlyBufferException();
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public void _setShort(int index, int value) {
        throw new ReadOnlyBufferException();
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setShortLE(int index, int value) {
        throw new ReadOnlyBufferException();
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public void _setShortLE(int index, int value) {
        throw new ReadOnlyBufferException();
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setMedium(int index, int value) {
        throw new ReadOnlyBufferException();
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public void _setMedium(int index, int value) {
        throw new ReadOnlyBufferException();
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setMediumLE(int index, int value) {
        throw new ReadOnlyBufferException();
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public void _setMediumLE(int index, int value) {
        throw new ReadOnlyBufferException();
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setInt(int index, int value) {
        throw new ReadOnlyBufferException();
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public void _setInt(int index, int value) {
        throw new ReadOnlyBufferException();
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setIntLE(int index, int value) {
        throw new ReadOnlyBufferException();
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public void _setIntLE(int index, int value) {
        throw new ReadOnlyBufferException();
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setLong(int index, long value) {
        throw new ReadOnlyBufferException();
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public void _setLong(int index, long value) {
        throw new ReadOnlyBufferException();
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setLongLE(int index, long value) {
        throw new ReadOnlyBufferException();
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public void _setLongLE(int index, long value) {
        throw new ReadOnlyBufferException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public int capacity() {
        return maxCapacity();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf capacity(int newCapacity) {
        throw new ReadOnlyBufferException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBufAllocator alloc() {
        return this.allocator;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteOrder order() {
        return ByteOrder.BIG_ENDIAN;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf unwrap() {
        return null;
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public boolean isReadOnly() {
        return this.buffer.isReadOnly();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public boolean isDirect() {
        return this.buffer.isDirect();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int index, OutputStream out, int length) throws IOException {
        ensureAccessible();
        if (length == 0) {
            return this;
        }
        if (this.buffer.hasArray()) {
            out.write(this.buffer.array(), index + this.buffer.arrayOffset(), length);
        } else {
            byte[] tmp = ByteBufUtil.threadLocalTempArray(length);
            ByteBuffer tmpBuf = internalNioBuffer();
            tmpBuf.clear().position(index);
            tmpBuf.get(tmp, 0, length);
            out.write(tmp, 0, length);
        }
        return this;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public int getBytes(int index, GatheringByteChannel out, int length) throws IOException {
        ensureAccessible();
        if (length == 0) {
            return 0;
        }
        ByteBuffer tmpBuf = internalNioBuffer();
        tmpBuf.clear().position(index).limit(index + length);
        return out.write(tmpBuf);
    }

    @Override // p013io.netty.buffer.ByteBuf
    public int getBytes(int index, FileChannel out, long position, int length) throws IOException {
        ensureAccessible();
        if (length == 0) {
            return 0;
        }
        ByteBuffer tmpBuf = internalNioBuffer();
        tmpBuf.clear().position(index).limit(index + length);
        return out.write(tmpBuf, position);
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int index, ByteBuf src, int srcIndex, int length) {
        throw new ReadOnlyBufferException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int index, byte[] src, int srcIndex, int length) {
        throw new ReadOnlyBufferException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int index, ByteBuffer src) {
        throw new ReadOnlyBufferException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public int setBytes(int index, InputStream in, int length) throws IOException {
        throw new ReadOnlyBufferException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public int setBytes(int index, ScatteringByteChannel in, int length) throws IOException {
        throw new ReadOnlyBufferException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public int setBytes(int index, FileChannel in, long position, int length) throws IOException {
        throw new ReadOnlyBufferException();
    }

    protected final ByteBuffer internalNioBuffer() {
        ByteBuffer tmpNioBuf = this.tmpNioBuf;
        if (tmpNioBuf == null) {
            ByteBuffer duplicate = this.buffer.duplicate();
            tmpNioBuf = duplicate;
            this.tmpNioBuf = duplicate;
        }
        return tmpNioBuf;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf copy(int index, int length) {
        ensureAccessible();
        try {
            ByteBuffer src = (ByteBuffer) internalNioBuffer().clear().position(index).limit(index + length);
            ByteBuf dst = src.isDirect() ? alloc().directBuffer(length) : alloc().heapBuffer(length);
            dst.writeBytes(src);
            return dst;
        } catch (IllegalArgumentException e) {
            throw new IndexOutOfBoundsException("Too many bytes to read - Need " + (index + length));
        }
    }

    @Override // p013io.netty.buffer.ByteBuf
    public int nioBufferCount() {
        return 1;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers(int index, int length) {
        return new ByteBuffer[]{nioBuffer(index, length)};
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer(int index, int length) {
        checkIndex(index, length);
        return (ByteBuffer) this.buffer.duplicate().position(index).limit(index + length);
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuffer internalNioBuffer(int index, int length) {
        ensureAccessible();
        return (ByteBuffer) internalNioBuffer().clear().position(index).limit(index + length);
    }

    @Override // p013io.netty.buffer.ByteBuf
    public final boolean isContiguous() {
        return true;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public boolean hasArray() {
        return this.buffer.hasArray();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public byte[] array() {
        return this.buffer.array();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public int arrayOffset() {
        return this.buffer.arrayOffset();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public boolean hasMemoryAddress() {
        return false;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public long memoryAddress() {
        throw new UnsupportedOperationException();
    }
}
