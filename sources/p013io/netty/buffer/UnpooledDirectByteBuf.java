package p013io.netty.buffer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.PlatformDependent;

/* renamed from: io.netty.buffer.UnpooledDirectByteBuf */
/* loaded from: grasscutter.jar:io/netty/buffer/UnpooledDirectByteBuf.class */
public class UnpooledDirectByteBuf extends AbstractReferenceCountedByteBuf {
    private final ByteBufAllocator alloc;
    ByteBuffer buffer;
    private ByteBuffer tmpNioBuf;
    private int capacity;
    private boolean doNotFree;

    public UnpooledDirectByteBuf(ByteBufAllocator alloc, int initialCapacity, int maxCapacity) {
        super(maxCapacity);
        ObjectUtil.checkNotNull(alloc, "alloc");
        ObjectUtil.checkPositiveOrZero(initialCapacity, "initialCapacity");
        ObjectUtil.checkPositiveOrZero(maxCapacity, "maxCapacity");
        if (initialCapacity > maxCapacity) {
            throw new IllegalArgumentException(String.format("initialCapacity(%d) > maxCapacity(%d)", Integer.valueOf(initialCapacity), Integer.valueOf(maxCapacity)));
        }
        this.alloc = alloc;
        setByteBuffer(allocateDirect(initialCapacity), false);
    }

    /* access modifiers changed from: protected */
    public UnpooledDirectByteBuf(ByteBufAllocator alloc, ByteBuffer initialBuffer, int maxCapacity) {
        this(alloc, initialBuffer, maxCapacity, false, true);
    }

    /* access modifiers changed from: package-private */
    public UnpooledDirectByteBuf(ByteBufAllocator alloc, ByteBuffer initialBuffer, int maxCapacity, boolean doFree, boolean slice) {
        super(maxCapacity);
        ObjectUtil.checkNotNull(alloc, "alloc");
        ObjectUtil.checkNotNull(initialBuffer, "initialBuffer");
        if (!initialBuffer.isDirect()) {
            throw new IllegalArgumentException("initialBuffer is not a direct buffer.");
        } else if (initialBuffer.isReadOnly()) {
            throw new IllegalArgumentException("initialBuffer is a read-only buffer.");
        } else {
            int initialCapacity = initialBuffer.remaining();
            if (initialCapacity > maxCapacity) {
                throw new IllegalArgumentException(String.format("initialCapacity(%d) > maxCapacity(%d)", Integer.valueOf(initialCapacity), Integer.valueOf(maxCapacity)));
            }
            this.alloc = alloc;
            this.doNotFree = !doFree;
            setByteBuffer((slice ? initialBuffer.slice() : initialBuffer).order(ByteOrder.BIG_ENDIAN), false);
            writerIndex(initialCapacity);
        }
    }

    /* access modifiers changed from: protected */
    public ByteBuffer allocateDirect(int initialCapacity) {
        return ByteBuffer.allocateDirect(initialCapacity);
    }

    /* access modifiers changed from: protected */
    public void freeDirect(ByteBuffer buffer) {
        PlatformDependent.freeDirectBuffer(buffer);
    }

    /* access modifiers changed from: package-private */
    public void setByteBuffer(ByteBuffer buffer, boolean tryFree) {
        ByteBuffer oldBuffer;
        if (tryFree && (oldBuffer = this.buffer) != null) {
            if (this.doNotFree) {
                this.doNotFree = false;
            } else {
                freeDirect(oldBuffer);
            }
        }
        this.buffer = buffer;
        this.tmpNioBuf = null;
        this.capacity = buffer.remaining();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public boolean isDirect() {
        return true;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public int capacity() {
        return this.capacity;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf capacity(int newCapacity) {
        int bytesToCopy;
        checkNewCapacity(newCapacity);
        int oldCapacity = this.capacity;
        if (newCapacity == oldCapacity) {
            return this;
        }
        if (newCapacity > oldCapacity) {
            bytesToCopy = oldCapacity;
        } else {
            trimIndicesToCapacity(newCapacity);
            bytesToCopy = newCapacity;
        }
        ByteBuffer oldBuffer = this.buffer;
        ByteBuffer newBuffer = allocateDirect(newCapacity);
        oldBuffer.position(0).limit(bytesToCopy);
        newBuffer.position(0).limit(bytesToCopy);
        newBuffer.put(oldBuffer).clear();
        setByteBuffer(newBuffer, true);
        return this;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBufAllocator alloc() {
        return this.alloc;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteOrder order() {
        return ByteOrder.BIG_ENDIAN;
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
        return false;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public long memoryAddress() {
        throw new UnsupportedOperationException();
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
        getBytes(index, dst, dstIndex, length, false);
        return this;
    }

    void getBytes(int index, byte[] dst, int dstIndex, int length, boolean internal) {
        ByteBuffer tmpBuf;
        checkDstIndex(index, length, dstIndex, dst.length);
        if (internal) {
            tmpBuf = internalNioBuffer();
        } else {
            tmpBuf = this.buffer.duplicate();
        }
        tmpBuf.clear().position(index).limit(index + length);
        tmpBuf.get(dst, dstIndex, length);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf readBytes(byte[] dst, int dstIndex, int length) {
        checkReadableBytes(length);
        getBytes(this.readerIndex, dst, dstIndex, length, true);
        this.readerIndex += length;
        return this;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int index, ByteBuffer dst) {
        getBytes(index, dst, false);
        return this;
    }

    void getBytes(int index, ByteBuffer dst, boolean internal) {
        ByteBuffer tmpBuf;
        checkIndex(index, dst.remaining());
        if (internal) {
            tmpBuf = internalNioBuffer();
        } else {
            tmpBuf = this.buffer.duplicate();
        }
        tmpBuf.clear().position(index).limit(index + dst.remaining());
        dst.put(tmpBuf);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuffer dst) {
        int length = dst.remaining();
        checkReadableBytes(length);
        getBytes(this.readerIndex, dst, true);
        this.readerIndex += length;
        return this;
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setByte(int index, int value) {
        ensureAccessible();
        _setByte(index, value);
        return this;
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public void _setByte(int index, int value) {
        this.buffer.put(index, (byte) value);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setShort(int index, int value) {
        ensureAccessible();
        _setShort(index, value);
        return this;
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public void _setShort(int index, int value) {
        this.buffer.putShort(index, (short) value);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public void _setShortLE(int index, int value) {
        this.buffer.putShort(index, ByteBufUtil.swapShort((short) value));
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setMedium(int index, int value) {
        ensureAccessible();
        _setMedium(index, value);
        return this;
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public void _setMedium(int index, int value) {
        setByte(index, (byte) (value >>> 16));
        setByte(index + 1, (byte) (value >>> 8));
        setByte(index + 2, (byte) value);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public void _setMediumLE(int index, int value) {
        setByte(index, (byte) value);
        setByte(index + 1, (byte) (value >>> 8));
        setByte(index + 2, (byte) (value >>> 16));
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setInt(int index, int value) {
        ensureAccessible();
        _setInt(index, value);
        return this;
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public void _setInt(int index, int value) {
        this.buffer.putInt(index, value);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public void _setIntLE(int index, int value) {
        this.buffer.putInt(index, ByteBufUtil.swapInt(value));
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setLong(int index, long value) {
        ensureAccessible();
        _setLong(index, value);
        return this;
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public void _setLong(int index, long value) {
        this.buffer.putLong(index, value);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public void _setLongLE(int index, long value) {
        this.buffer.putLong(index, ByteBufUtil.swapLong(value));
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int index, ByteBuf src, int srcIndex, int length) {
        checkSrcIndex(index, length, srcIndex, src.capacity());
        if (src.nioBufferCount() > 0) {
            ByteBuffer[] nioBuffers = src.nioBuffers(srcIndex, length);
            for (ByteBuffer bb : nioBuffers) {
                int bbLen = bb.remaining();
                setBytes(index, bb);
                index += bbLen;
            }
        } else {
            src.getBytes(srcIndex, this, index, length);
        }
        return this;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int index, byte[] src, int srcIndex, int length) {
        checkSrcIndex(index, length, srcIndex, src.length);
        ByteBuffer tmpBuf = internalNioBuffer();
        tmpBuf.clear().position(index).limit(index + length);
        tmpBuf.put(src, srcIndex, length);
        return this;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int index, ByteBuffer src) {
        ensureAccessible();
        ByteBuffer tmpBuf = internalNioBuffer();
        if (src == tmpBuf) {
            src = src.duplicate();
        }
        tmpBuf.clear().position(index).limit(index + src.remaining());
        tmpBuf.put(src);
        return this;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int index, OutputStream out, int length) throws IOException {
        getBytes(index, out, length, false);
        return this;
    }

    void getBytes(int index, OutputStream out, int length, boolean internal) throws IOException {
        ensureAccessible();
        if (length != 0) {
            ByteBufUtil.readBytes(alloc(), internal ? internalNioBuffer() : this.buffer.duplicate(), index, length, out);
        }
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf readBytes(OutputStream out, int length) throws IOException {
        checkReadableBytes(length);
        getBytes(this.readerIndex, out, length, true);
        this.readerIndex += length;
        return this;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public int getBytes(int index, GatheringByteChannel out, int length) throws IOException {
        return getBytes(index, out, length, false);
    }

    private int getBytes(int index, GatheringByteChannel out, int length, boolean internal) throws IOException {
        ByteBuffer tmpBuf;
        ensureAccessible();
        if (length == 0) {
            return 0;
        }
        if (internal) {
            tmpBuf = internalNioBuffer();
        } else {
            tmpBuf = this.buffer.duplicate();
        }
        tmpBuf.clear().position(index).limit(index + length);
        return out.write(tmpBuf);
    }

    @Override // p013io.netty.buffer.ByteBuf
    public int getBytes(int index, FileChannel out, long position, int length) throws IOException {
        return getBytes(index, out, position, length, false);
    }

    private int getBytes(int index, FileChannel out, long position, int length, boolean internal) throws IOException {
        ensureAccessible();
        if (length == 0) {
            return 0;
        }
        ByteBuffer tmpBuf = internal ? internalNioBuffer() : this.buffer.duplicate();
        tmpBuf.clear().position(index).limit(index + length);
        return out.write(tmpBuf, position);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int readBytes(GatheringByteChannel out, int length) throws IOException {
        checkReadableBytes(length);
        int readBytes = getBytes(this.readerIndex, out, length, true);
        this.readerIndex += readBytes;
        return readBytes;
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int readBytes(FileChannel out, long position, int length) throws IOException {
        checkReadableBytes(length);
        int readBytes = getBytes(this.readerIndex, out, position, length, true);
        this.readerIndex += readBytes;
        return readBytes;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public int setBytes(int index, InputStream in, int length) throws IOException {
        ensureAccessible();
        if (this.buffer.hasArray()) {
            return in.read(this.buffer.array(), this.buffer.arrayOffset() + index, length);
        }
        byte[] tmp = ByteBufUtil.threadLocalTempArray(length);
        int readBytes = in.read(tmp, 0, length);
        if (readBytes <= 0) {
            return readBytes;
        }
        ByteBuffer tmpBuf = internalNioBuffer();
        tmpBuf.clear().position(index);
        tmpBuf.put(tmp, 0, readBytes);
        return readBytes;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public int setBytes(int index, ScatteringByteChannel in, int length) throws IOException {
        ensureAccessible();
        ByteBuffer tmpBuf = internalNioBuffer();
        tmpBuf.clear().position(index).limit(index + length);
        try {
            return in.read(tmpBuf);
        } catch (ClosedChannelException e) {
            return -1;
        }
    }

    @Override // p013io.netty.buffer.ByteBuf
    public int setBytes(int index, FileChannel in, long position, int length) throws IOException {
        ensureAccessible();
        ByteBuffer tmpBuf = internalNioBuffer();
        tmpBuf.clear().position(index).limit(index + length);
        try {
            return in.read(tmpBuf, position);
        } catch (ClosedChannelException e) {
            return -1;
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
    public final boolean isContiguous() {
        return true;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf copy(int index, int length) {
        ensureAccessible();
        try {
            return alloc().directBuffer(length, maxCapacity()).writeBytes((ByteBuffer) this.buffer.duplicate().clear().position(index).limit(index + length));
        } catch (IllegalArgumentException e) {
            throw new IndexOutOfBoundsException("Too many bytes to read - Need " + (index + length));
        }
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuffer internalNioBuffer(int index, int length) {
        checkIndex(index, length);
        return (ByteBuffer) internalNioBuffer().clear().position(index).limit(index + length);
    }

    private ByteBuffer internalNioBuffer() {
        ByteBuffer tmpNioBuf = this.tmpNioBuf;
        if (tmpNioBuf == null) {
            ByteBuffer duplicate = this.buffer.duplicate();
            tmpNioBuf = duplicate;
            this.tmpNioBuf = duplicate;
        }
        return tmpNioBuf;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer(int index, int length) {
        checkIndex(index, length);
        return ((ByteBuffer) this.buffer.duplicate().position(index).limit(index + length)).slice();
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractReferenceCountedByteBuf
    public void deallocate() {
        ByteBuffer buffer = this.buffer;
        if (buffer != null) {
            this.buffer = null;
            if (!this.doNotFree) {
                freeDirect(buffer);
            }
        }
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf unwrap() {
        return null;
    }
}
