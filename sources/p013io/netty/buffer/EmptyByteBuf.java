package p013io.netty.buffer;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.charset.Charset;
import p013io.netty.util.ByteProcessor;
import p013io.netty.util.internal.EmptyArrays;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.StringUtil;

/* renamed from: io.netty.buffer.EmptyByteBuf */
/* loaded from: grasscutter.jar:io/netty/buffer/EmptyByteBuf.class */
public final class EmptyByteBuf extends ByteBuf {
    static final int EMPTY_BYTE_BUF_HASH_CODE = 1;
    private static final ByteBuffer EMPTY_BYTE_BUFFER = ByteBuffer.allocateDirect(0);
    private static final long EMPTY_BYTE_BUFFER_ADDRESS;
    private final ByteBufAllocator alloc;
    private final ByteOrder order;
    private final String str;
    private EmptyByteBuf swapped;

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:10:0x0009 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:7:0x0019 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [long] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARNING: Unknown variable types count: 1 */
    static {
        /*
            r0 = 0
            java.nio.ByteBuffer r0 = java.nio.ByteBuffer.allocateDirect(r0)
            p013io.netty.buffer.EmptyByteBuf.EMPTY_BYTE_BUFFER = r0
            r0 = 0
            r3 = r0
            boolean r0 = p013io.netty.util.internal.PlatformDependent.hasUnsafe()     // Catch: Throwable -> 0x0019
            if (r0 == 0) goto L_0x0016
            java.nio.ByteBuffer r0 = p013io.netty.buffer.EmptyByteBuf.EMPTY_BYTE_BUFFER     // Catch: Throwable -> 0x0019
            long r0 = p013io.netty.util.internal.PlatformDependent.directBufferAddress(r0)     // Catch: Throwable -> 0x0019
            r3 = r0
        L_0x0016:
            goto L_0x001a
        L_0x0019:
            r5 = move-exception
        L_0x001a:
            r0 = r3
            p013io.netty.buffer.EmptyByteBuf.EMPTY_BYTE_BUFFER_ADDRESS = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.buffer.EmptyByteBuf.m5921clinit():void");
    }

    public EmptyByteBuf(ByteBufAllocator alloc) {
        this(alloc, ByteOrder.BIG_ENDIAN);
    }

    private EmptyByteBuf(ByteBufAllocator alloc, ByteOrder order) {
        this.alloc = (ByteBufAllocator) ObjectUtil.checkNotNull(alloc, "alloc");
        this.order = order;
        this.str = StringUtil.simpleClassName(this) + (order == ByteOrder.BIG_ENDIAN ? "BE" : "LE");
    }

    @Override // p013io.netty.buffer.ByteBuf
    public int capacity() {
        return 0;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf capacity(int newCapacity) {
        throw new ReadOnlyBufferException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBufAllocator alloc() {
        return this.alloc;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteOrder order() {
        return this.order;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf unwrap() {
        return null;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf asReadOnly() {
        return Unpooled.unmodifiableBuffer(this);
    }

    @Override // p013io.netty.buffer.ByteBuf
    public boolean isReadOnly() {
        return false;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public boolean isDirect() {
        return true;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public int maxCapacity() {
        return 0;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf order(ByteOrder endianness) {
        if (ObjectUtil.checkNotNull(endianness, "endianness") == order()) {
            return this;
        }
        EmptyByteBuf swapped = this.swapped;
        if (swapped != null) {
            return swapped;
        }
        EmptyByteBuf swapped2 = new EmptyByteBuf(alloc(), endianness);
        this.swapped = swapped2;
        return swapped2;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public int readerIndex() {
        return 0;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf readerIndex(int readerIndex) {
        return checkIndex(readerIndex);
    }

    @Override // p013io.netty.buffer.ByteBuf
    public int writerIndex() {
        return 0;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf writerIndex(int writerIndex) {
        return checkIndex(writerIndex);
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf setIndex(int readerIndex, int writerIndex) {
        checkIndex(readerIndex);
        checkIndex(writerIndex);
        return this;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public int readableBytes() {
        return 0;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public int writableBytes() {
        return 0;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public int maxWritableBytes() {
        return 0;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public boolean isReadable() {
        return false;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public boolean isWritable() {
        return false;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf clear() {
        return this;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf markReaderIndex() {
        return this;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf resetReaderIndex() {
        return this;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf markWriterIndex() {
        return this;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf resetWriterIndex() {
        return this;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf discardReadBytes() {
        return this;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf discardSomeReadBytes() {
        return this;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf ensureWritable(int minWritableBytes) {
        ObjectUtil.checkPositiveOrZero(minWritableBytes, "minWritableBytes");
        if (minWritableBytes == 0) {
            return this;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public int ensureWritable(int minWritableBytes, boolean force) {
        ObjectUtil.checkPositiveOrZero(minWritableBytes, "minWritableBytes");
        if (minWritableBytes == 0) {
            return 0;
        }
        return 1;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public boolean getBoolean(int index) {
        throw new IndexOutOfBoundsException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public byte getByte(int index) {
        throw new IndexOutOfBoundsException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public short getUnsignedByte(int index) {
        throw new IndexOutOfBoundsException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public short getShort(int index) {
        throw new IndexOutOfBoundsException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public short getShortLE(int index) {
        throw new IndexOutOfBoundsException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public int getUnsignedShort(int index) {
        throw new IndexOutOfBoundsException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public int getUnsignedShortLE(int index) {
        throw new IndexOutOfBoundsException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public int getMedium(int index) {
        throw new IndexOutOfBoundsException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public int getMediumLE(int index) {
        throw new IndexOutOfBoundsException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public int getUnsignedMedium(int index) {
        throw new IndexOutOfBoundsException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public int getUnsignedMediumLE(int index) {
        throw new IndexOutOfBoundsException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public int getInt(int index) {
        throw new IndexOutOfBoundsException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public int getIntLE(int index) {
        throw new IndexOutOfBoundsException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public long getUnsignedInt(int index) {
        throw new IndexOutOfBoundsException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public long getUnsignedIntLE(int index) {
        throw new IndexOutOfBoundsException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public long getLong(int index) {
        throw new IndexOutOfBoundsException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public long getLongLE(int index) {
        throw new IndexOutOfBoundsException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public char getChar(int index) {
        throw new IndexOutOfBoundsException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public float getFloat(int index) {
        throw new IndexOutOfBoundsException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public double getDouble(int index) {
        throw new IndexOutOfBoundsException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int index, ByteBuf dst) {
        return checkIndex(index, dst.writableBytes());
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int index, ByteBuf dst, int length) {
        return checkIndex(index, length);
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int index, ByteBuf dst, int dstIndex, int length) {
        return checkIndex(index, length);
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int index, byte[] dst) {
        return checkIndex(index, dst.length);
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int index, byte[] dst, int dstIndex, int length) {
        return checkIndex(index, length);
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int index, ByteBuffer dst) {
        return checkIndex(index, dst.remaining());
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int index, OutputStream out, int length) {
        return checkIndex(index, length);
    }

    @Override // p013io.netty.buffer.ByteBuf
    public int getBytes(int index, GatheringByteChannel out, int length) {
        checkIndex(index, length);
        return 0;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public int getBytes(int index, FileChannel out, long position, int length) {
        checkIndex(index, length);
        return 0;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public CharSequence getCharSequence(int index, int length, Charset charset) {
        checkIndex(index, length);
        return null;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf setBoolean(int index, boolean value) {
        throw new IndexOutOfBoundsException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf setByte(int index, int value) {
        throw new IndexOutOfBoundsException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf setShort(int index, int value) {
        throw new IndexOutOfBoundsException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf setShortLE(int index, int value) {
        throw new IndexOutOfBoundsException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf setMedium(int index, int value) {
        throw new IndexOutOfBoundsException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf setMediumLE(int index, int value) {
        throw new IndexOutOfBoundsException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf setInt(int index, int value) {
        throw new IndexOutOfBoundsException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf setIntLE(int index, int value) {
        throw new IndexOutOfBoundsException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf setLong(int index, long value) {
        throw new IndexOutOfBoundsException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf setLongLE(int index, long value) {
        throw new IndexOutOfBoundsException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf setChar(int index, int value) {
        throw new IndexOutOfBoundsException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf setFloat(int index, float value) {
        throw new IndexOutOfBoundsException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf setDouble(int index, double value) {
        throw new IndexOutOfBoundsException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int index, ByteBuf src) {
        throw new IndexOutOfBoundsException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int index, ByteBuf src, int length) {
        return checkIndex(index, length);
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int index, ByteBuf src, int srcIndex, int length) {
        return checkIndex(index, length);
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int index, byte[] src) {
        return checkIndex(index, src.length);
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int index, byte[] src, int srcIndex, int length) {
        return checkIndex(index, length);
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int index, ByteBuffer src) {
        return checkIndex(index, src.remaining());
    }

    @Override // p013io.netty.buffer.ByteBuf
    public int setBytes(int index, InputStream in, int length) {
        checkIndex(index, length);
        return 0;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public int setBytes(int index, ScatteringByteChannel in, int length) {
        checkIndex(index, length);
        return 0;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public int setBytes(int index, FileChannel in, long position, int length) {
        checkIndex(index, length);
        return 0;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf setZero(int index, int length) {
        return checkIndex(index, length);
    }

    @Override // p013io.netty.buffer.ByteBuf
    public int setCharSequence(int index, CharSequence sequence, Charset charset) {
        throw new IndexOutOfBoundsException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public boolean readBoolean() {
        throw new IndexOutOfBoundsException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public byte readByte() {
        throw new IndexOutOfBoundsException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public short readUnsignedByte() {
        throw new IndexOutOfBoundsException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public short readShort() {
        throw new IndexOutOfBoundsException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public short readShortLE() {
        throw new IndexOutOfBoundsException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public int readUnsignedShort() {
        throw new IndexOutOfBoundsException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public int readUnsignedShortLE() {
        throw new IndexOutOfBoundsException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public int readMedium() {
        throw new IndexOutOfBoundsException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public int readMediumLE() {
        throw new IndexOutOfBoundsException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public int readUnsignedMedium() {
        throw new IndexOutOfBoundsException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public int readUnsignedMediumLE() {
        throw new IndexOutOfBoundsException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public int readInt() {
        throw new IndexOutOfBoundsException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public int readIntLE() {
        throw new IndexOutOfBoundsException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public long readUnsignedInt() {
        throw new IndexOutOfBoundsException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public long readUnsignedIntLE() {
        throw new IndexOutOfBoundsException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public long readLong() {
        throw new IndexOutOfBoundsException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public long readLongLE() {
        throw new IndexOutOfBoundsException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public char readChar() {
        throw new IndexOutOfBoundsException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public float readFloat() {
        throw new IndexOutOfBoundsException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public double readDouble() {
        throw new IndexOutOfBoundsException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf readBytes(int length) {
        return checkLength(length);
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf readSlice(int length) {
        return checkLength(length);
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf readRetainedSlice(int length) {
        return checkLength(length);
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuf dst) {
        return checkLength(dst.writableBytes());
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuf dst, int length) {
        return checkLength(length);
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuf dst, int dstIndex, int length) {
        return checkLength(length);
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf readBytes(byte[] dst) {
        return checkLength(dst.length);
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf readBytes(byte[] dst, int dstIndex, int length) {
        return checkLength(length);
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuffer dst) {
        return checkLength(dst.remaining());
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf readBytes(OutputStream out, int length) {
        return checkLength(length);
    }

    @Override // p013io.netty.buffer.ByteBuf
    public int readBytes(GatheringByteChannel out, int length) {
        checkLength(length);
        return 0;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public int readBytes(FileChannel out, long position, int length) {
        checkLength(length);
        return 0;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public CharSequence readCharSequence(int length, Charset charset) {
        checkLength(length);
        return "";
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf skipBytes(int length) {
        return checkLength(length);
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf writeBoolean(boolean value) {
        throw new IndexOutOfBoundsException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf writeByte(int value) {
        throw new IndexOutOfBoundsException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf writeShort(int value) {
        throw new IndexOutOfBoundsException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf writeShortLE(int value) {
        throw new IndexOutOfBoundsException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf writeMedium(int value) {
        throw new IndexOutOfBoundsException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf writeMediumLE(int value) {
        throw new IndexOutOfBoundsException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf writeInt(int value) {
        throw new IndexOutOfBoundsException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf writeIntLE(int value) {
        throw new IndexOutOfBoundsException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf writeLong(long value) {
        throw new IndexOutOfBoundsException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf writeLongLE(long value) {
        throw new IndexOutOfBoundsException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf writeChar(int value) {
        throw new IndexOutOfBoundsException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf writeFloat(float value) {
        throw new IndexOutOfBoundsException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf writeDouble(double value) {
        throw new IndexOutOfBoundsException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(ByteBuf src) {
        return checkLength(src.readableBytes());
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(ByteBuf src, int length) {
        return checkLength(length);
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(ByteBuf src, int srcIndex, int length) {
        return checkLength(length);
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(byte[] src) {
        return checkLength(src.length);
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(byte[] src, int srcIndex, int length) {
        return checkLength(length);
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(ByteBuffer src) {
        return checkLength(src.remaining());
    }

    @Override // p013io.netty.buffer.ByteBuf
    public int writeBytes(InputStream in, int length) {
        checkLength(length);
        return 0;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public int writeBytes(ScatteringByteChannel in, int length) {
        checkLength(length);
        return 0;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public int writeBytes(FileChannel in, long position, int length) {
        checkLength(length);
        return 0;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf writeZero(int length) {
        return checkLength(length);
    }

    @Override // p013io.netty.buffer.ByteBuf
    public int writeCharSequence(CharSequence sequence, Charset charset) {
        throw new IndexOutOfBoundsException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public int indexOf(int fromIndex, int toIndex, byte value) {
        checkIndex(fromIndex);
        checkIndex(toIndex);
        return -1;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public int bytesBefore(byte value) {
        return -1;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public int bytesBefore(int length, byte value) {
        checkLength(length);
        return -1;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public int bytesBefore(int index, int length, byte value) {
        checkIndex(index, length);
        return -1;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public int forEachByte(ByteProcessor processor) {
        return -1;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public int forEachByte(int index, int length, ByteProcessor processor) {
        checkIndex(index, length);
        return -1;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public int forEachByteDesc(ByteProcessor processor) {
        return -1;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public int forEachByteDesc(int index, int length, ByteProcessor processor) {
        checkIndex(index, length);
        return -1;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf copy() {
        return this;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf copy(int index, int length) {
        return checkIndex(index, length);
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf slice() {
        return this;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf retainedSlice() {
        return this;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf slice(int index, int length) {
        return checkIndex(index, length);
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf retainedSlice(int index, int length) {
        return checkIndex(index, length);
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf duplicate() {
        return this;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf retainedDuplicate() {
        return this;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public int nioBufferCount() {
        return 1;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer() {
        return EMPTY_BYTE_BUFFER;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer(int index, int length) {
        checkIndex(index, length);
        return nioBuffer();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers() {
        return new ByteBuffer[]{EMPTY_BYTE_BUFFER};
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers(int index, int length) {
        checkIndex(index, length);
        return nioBuffers();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuffer internalNioBuffer(int index, int length) {
        return EMPTY_BYTE_BUFFER;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public boolean hasArray() {
        return true;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public byte[] array() {
        return EmptyArrays.EMPTY_BYTES;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public int arrayOffset() {
        return 0;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public boolean hasMemoryAddress() {
        return EMPTY_BYTE_BUFFER_ADDRESS != 0;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public long memoryAddress() {
        if (hasMemoryAddress()) {
            return EMPTY_BYTE_BUFFER_ADDRESS;
        }
        throw new UnsupportedOperationException();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public boolean isContiguous() {
        return true;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public String toString(Charset charset) {
        return "";
    }

    @Override // p013io.netty.buffer.ByteBuf
    public String toString(int index, int length, Charset charset) {
        checkIndex(index, length);
        return toString(charset);
    }

    @Override // p013io.netty.buffer.ByteBuf, java.lang.Object
    public int hashCode() {
        return 1;
    }

    @Override // p013io.netty.buffer.ByteBuf, java.lang.Object
    public boolean equals(Object obj) {
        return (obj instanceof ByteBuf) && !((ByteBuf) obj).isReadable();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public int compareTo(ByteBuf buffer) {
        return buffer.isReadable() ? -1 : 0;
    }

    @Override // p013io.netty.buffer.ByteBuf, java.lang.Object
    public String toString() {
        return this.str;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public boolean isReadable(int size) {
        return false;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public boolean isWritable(int size) {
        return false;
    }

    @Override // p013io.netty.util.ReferenceCounted
    public int refCnt() {
        return 1;
    }

    @Override // p013io.netty.buffer.ByteBuf, p013io.netty.util.ReferenceCounted
    public ByteBuf retain() {
        return this;
    }

    @Override // p013io.netty.buffer.ByteBuf, p013io.netty.util.ReferenceCounted
    public ByteBuf retain(int increment) {
        return this;
    }

    @Override // p013io.netty.buffer.ByteBuf, p013io.netty.util.ReferenceCounted
    public ByteBuf touch() {
        return this;
    }

    @Override // p013io.netty.buffer.ByteBuf, p013io.netty.util.ReferenceCounted
    public ByteBuf touch(Object hint) {
        return this;
    }

    @Override // p013io.netty.util.ReferenceCounted
    public boolean release() {
        return false;
    }

    @Override // p013io.netty.util.ReferenceCounted
    public boolean release(int decrement) {
        return false;
    }

    private ByteBuf checkIndex(int index) {
        if (index == 0) {
            return this;
        }
        throw new IndexOutOfBoundsException();
    }

    private ByteBuf checkIndex(int index, int length) {
        ObjectUtil.checkPositiveOrZero(length, "length");
        if (index == 0 && length == 0) {
            return this;
        }
        throw new IndexOutOfBoundsException();
    }

    private ByteBuf checkLength(int length) {
        ObjectUtil.checkPositiveOrZero(length, "length");
        if (length == 0) {
            return this;
        }
        throw new IndexOutOfBoundsException();
    }
}
