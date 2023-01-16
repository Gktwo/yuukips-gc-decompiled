package p013io.netty.buffer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.charset.Charset;
import p013io.netty.util.ByteProcessor;
import p013io.netty.util.ResourceLeakDetector;
import p013io.netty.util.ResourceLeakTracker;
import p013io.netty.util.internal.SystemPropertyUtil;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

/* renamed from: io.netty.buffer.AdvancedLeakAwareByteBuf */
/* loaded from: grasscutter.jar:io/netty/buffer/AdvancedLeakAwareByteBuf.class */
final class AdvancedLeakAwareByteBuf extends SimpleLeakAwareByteBuf {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(AdvancedLeakAwareByteBuf.class);
    private static final String PROP_ACQUIRE_AND_RELEASE_ONLY = "io.netty.leakDetection.acquireAndReleaseOnly";
    private static final boolean ACQUIRE_AND_RELEASE_ONLY = SystemPropertyUtil.getBoolean(PROP_ACQUIRE_AND_RELEASE_ONLY, false);

    static {
        if (logger.isDebugEnabled()) {
            logger.debug("-D{}: {}", PROP_ACQUIRE_AND_RELEASE_ONLY, Boolean.valueOf(ACQUIRE_AND_RELEASE_ONLY));
        }
        ResourceLeakDetector.addExclusions(AdvancedLeakAwareByteBuf.class, "touch", "recordLeakNonRefCountingOperation");
    }

    /* access modifiers changed from: package-private */
    public AdvancedLeakAwareByteBuf(ByteBuf buf, ResourceLeakTracker<ByteBuf> leak) {
        super(buf, leak);
    }

    /* access modifiers changed from: package-private */
    public AdvancedLeakAwareByteBuf(ByteBuf wrapped, ByteBuf trackedByteBuf, ResourceLeakTracker<ByteBuf> leak) {
        super(wrapped, trackedByteBuf, leak);
    }

    /* access modifiers changed from: package-private */
    public static void recordLeakNonRefCountingOperation(ResourceLeakTracker<ByteBuf> leak) {
        if (!ACQUIRE_AND_RELEASE_ONLY) {
            leak.record();
        }
    }

    @Override // p013io.netty.buffer.SimpleLeakAwareByteBuf, p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf order(ByteOrder endianness) {
        recordLeakNonRefCountingOperation(this.leak);
        return order(endianness);
    }

    @Override // p013io.netty.buffer.SimpleLeakAwareByteBuf, p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf slice() {
        recordLeakNonRefCountingOperation(this.leak);
        return slice();
    }

    @Override // p013io.netty.buffer.SimpleLeakAwareByteBuf, p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf slice(int index, int length) {
        recordLeakNonRefCountingOperation(this.leak);
        return slice(index, length);
    }

    @Override // p013io.netty.buffer.SimpleLeakAwareByteBuf, p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf retainedSlice() {
        recordLeakNonRefCountingOperation(this.leak);
        return retainedSlice();
    }

    @Override // p013io.netty.buffer.SimpleLeakAwareByteBuf, p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf retainedSlice(int index, int length) {
        recordLeakNonRefCountingOperation(this.leak);
        return retainedSlice(index, length);
    }

    @Override // p013io.netty.buffer.SimpleLeakAwareByteBuf, p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf retainedDuplicate() {
        recordLeakNonRefCountingOperation(this.leak);
        return retainedDuplicate();
    }

    @Override // p013io.netty.buffer.SimpleLeakAwareByteBuf, p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf readRetainedSlice(int length) {
        recordLeakNonRefCountingOperation(this.leak);
        return readRetainedSlice(length);
    }

    @Override // p013io.netty.buffer.SimpleLeakAwareByteBuf, p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf duplicate() {
        recordLeakNonRefCountingOperation(this.leak);
        return duplicate();
    }

    @Override // p013io.netty.buffer.SimpleLeakAwareByteBuf, p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf readSlice(int length) {
        recordLeakNonRefCountingOperation(this.leak);
        return readSlice(length);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf discardReadBytes() {
        recordLeakNonRefCountingOperation(this.leak);
        return discardReadBytes();
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf discardSomeReadBytes() {
        recordLeakNonRefCountingOperation(this.leak);
        return discardSomeReadBytes();
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf ensureWritable(int minWritableBytes) {
        recordLeakNonRefCountingOperation(this.leak);
        return ensureWritable(minWritableBytes);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public int ensureWritable(int minWritableBytes, boolean force) {
        recordLeakNonRefCountingOperation(this.leak);
        return ensureWritable(minWritableBytes, force);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public boolean getBoolean(int index) {
        recordLeakNonRefCountingOperation(this.leak);
        return getBoolean(index);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public byte getByte(int index) {
        recordLeakNonRefCountingOperation(this.leak);
        return getByte(index);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public short getUnsignedByte(int index) {
        recordLeakNonRefCountingOperation(this.leak);
        return getUnsignedByte(index);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public short getShort(int index) {
        recordLeakNonRefCountingOperation(this.leak);
        return getShort(index);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public int getUnsignedShort(int index) {
        recordLeakNonRefCountingOperation(this.leak);
        return getUnsignedShort(index);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public int getMedium(int index) {
        recordLeakNonRefCountingOperation(this.leak);
        return getMedium(index);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public int getUnsignedMedium(int index) {
        recordLeakNonRefCountingOperation(this.leak);
        return getUnsignedMedium(index);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public int getInt(int index) {
        recordLeakNonRefCountingOperation(this.leak);
        return getInt(index);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public long getUnsignedInt(int index) {
        recordLeakNonRefCountingOperation(this.leak);
        return getUnsignedInt(index);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public long getLong(int index) {
        recordLeakNonRefCountingOperation(this.leak);
        return getLong(index);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public char getChar(int index) {
        recordLeakNonRefCountingOperation(this.leak);
        return getChar(index);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public float getFloat(int index) {
        recordLeakNonRefCountingOperation(this.leak);
        return getFloat(index);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public double getDouble(int index) {
        recordLeakNonRefCountingOperation(this.leak);
        return getDouble(index);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int index, ByteBuf dst) {
        recordLeakNonRefCountingOperation(this.leak);
        return getBytes(index, dst);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int index, ByteBuf dst, int length) {
        recordLeakNonRefCountingOperation(this.leak);
        return getBytes(index, dst, length);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int index, ByteBuf dst, int dstIndex, int length) {
        recordLeakNonRefCountingOperation(this.leak);
        return getBytes(index, dst, dstIndex, length);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int index, byte[] dst) {
        recordLeakNonRefCountingOperation(this.leak);
        return getBytes(index, dst);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int index, byte[] dst, int dstIndex, int length) {
        recordLeakNonRefCountingOperation(this.leak);
        return getBytes(index, dst, dstIndex, length);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int index, ByteBuffer dst) {
        recordLeakNonRefCountingOperation(this.leak);
        return getBytes(index, dst);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int index, OutputStream out, int length) throws IOException {
        recordLeakNonRefCountingOperation(this.leak);
        return getBytes(index, out, length);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public int getBytes(int index, GatheringByteChannel out, int length) throws IOException {
        recordLeakNonRefCountingOperation(this.leak);
        return getBytes(index, out, length);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public CharSequence getCharSequence(int index, int length, Charset charset) {
        recordLeakNonRefCountingOperation(this.leak);
        return getCharSequence(index, length, charset);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setBoolean(int index, boolean value) {
        recordLeakNonRefCountingOperation(this.leak);
        return setBoolean(index, value);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setByte(int index, int value) {
        recordLeakNonRefCountingOperation(this.leak);
        return setByte(index, value);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setShort(int index, int value) {
        recordLeakNonRefCountingOperation(this.leak);
        return setShort(index, value);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setMedium(int index, int value) {
        recordLeakNonRefCountingOperation(this.leak);
        return setMedium(index, value);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setInt(int index, int value) {
        recordLeakNonRefCountingOperation(this.leak);
        return setInt(index, value);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setLong(int index, long value) {
        recordLeakNonRefCountingOperation(this.leak);
        return setLong(index, value);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setChar(int index, int value) {
        recordLeakNonRefCountingOperation(this.leak);
        return setChar(index, value);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setFloat(int index, float value) {
        recordLeakNonRefCountingOperation(this.leak);
        return setFloat(index, value);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setDouble(int index, double value) {
        recordLeakNonRefCountingOperation(this.leak);
        return setDouble(index, value);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int index, ByteBuf src) {
        recordLeakNonRefCountingOperation(this.leak);
        return setBytes(index, src);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int index, ByteBuf src, int length) {
        recordLeakNonRefCountingOperation(this.leak);
        return setBytes(index, src, length);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int index, ByteBuf src, int srcIndex, int length) {
        recordLeakNonRefCountingOperation(this.leak);
        return setBytes(index, src, srcIndex, length);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int index, byte[] src) {
        recordLeakNonRefCountingOperation(this.leak);
        return setBytes(index, src);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int index, byte[] src, int srcIndex, int length) {
        recordLeakNonRefCountingOperation(this.leak);
        return setBytes(index, src, srcIndex, length);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int index, ByteBuffer src) {
        recordLeakNonRefCountingOperation(this.leak);
        return setBytes(index, src);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public int setBytes(int index, InputStream in, int length) throws IOException {
        recordLeakNonRefCountingOperation(this.leak);
        return setBytes(index, in, length);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public int setBytes(int index, ScatteringByteChannel in, int length) throws IOException {
        recordLeakNonRefCountingOperation(this.leak);
        return setBytes(index, in, length);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setZero(int index, int length) {
        recordLeakNonRefCountingOperation(this.leak);
        return setZero(index, length);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public int setCharSequence(int index, CharSequence sequence, Charset charset) {
        recordLeakNonRefCountingOperation(this.leak);
        return setCharSequence(index, sequence, charset);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public boolean readBoolean() {
        recordLeakNonRefCountingOperation(this.leak);
        return readBoolean();
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public byte readByte() {
        recordLeakNonRefCountingOperation(this.leak);
        return readByte();
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public short readUnsignedByte() {
        recordLeakNonRefCountingOperation(this.leak);
        return readUnsignedByte();
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public short readShort() {
        recordLeakNonRefCountingOperation(this.leak);
        return readShort();
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public int readUnsignedShort() {
        recordLeakNonRefCountingOperation(this.leak);
        return readUnsignedShort();
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public int readMedium() {
        recordLeakNonRefCountingOperation(this.leak);
        return readMedium();
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public int readUnsignedMedium() {
        recordLeakNonRefCountingOperation(this.leak);
        return readUnsignedMedium();
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public int readInt() {
        recordLeakNonRefCountingOperation(this.leak);
        return readInt();
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public long readUnsignedInt() {
        recordLeakNonRefCountingOperation(this.leak);
        return readUnsignedInt();
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public long readLong() {
        recordLeakNonRefCountingOperation(this.leak);
        return readLong();
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public char readChar() {
        recordLeakNonRefCountingOperation(this.leak);
        return readChar();
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public float readFloat() {
        recordLeakNonRefCountingOperation(this.leak);
        return readFloat();
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public double readDouble() {
        recordLeakNonRefCountingOperation(this.leak);
        return readDouble();
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf readBytes(int length) {
        recordLeakNonRefCountingOperation(this.leak);
        return readBytes(length);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuf dst) {
        recordLeakNonRefCountingOperation(this.leak);
        return readBytes(dst);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuf dst, int length) {
        recordLeakNonRefCountingOperation(this.leak);
        return readBytes(dst, length);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuf dst, int dstIndex, int length) {
        recordLeakNonRefCountingOperation(this.leak);
        return readBytes(dst, dstIndex, length);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf readBytes(byte[] dst) {
        recordLeakNonRefCountingOperation(this.leak);
        return readBytes(dst);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf readBytes(byte[] dst, int dstIndex, int length) {
        recordLeakNonRefCountingOperation(this.leak);
        return readBytes(dst, dstIndex, length);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuffer dst) {
        recordLeakNonRefCountingOperation(this.leak);
        return readBytes(dst);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf readBytes(OutputStream out, int length) throws IOException {
        recordLeakNonRefCountingOperation(this.leak);
        return readBytes(out, length);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public int readBytes(GatheringByteChannel out, int length) throws IOException {
        recordLeakNonRefCountingOperation(this.leak);
        return readBytes(out, length);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public CharSequence readCharSequence(int length, Charset charset) {
        recordLeakNonRefCountingOperation(this.leak);
        return readCharSequence(length, charset);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf skipBytes(int length) {
        recordLeakNonRefCountingOperation(this.leak);
        return skipBytes(length);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf writeBoolean(boolean value) {
        recordLeakNonRefCountingOperation(this.leak);
        return writeBoolean(value);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf writeByte(int value) {
        recordLeakNonRefCountingOperation(this.leak);
        return writeByte(value);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf writeShort(int value) {
        recordLeakNonRefCountingOperation(this.leak);
        return writeShort(value);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf writeMedium(int value) {
        recordLeakNonRefCountingOperation(this.leak);
        return writeMedium(value);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf writeInt(int value) {
        recordLeakNonRefCountingOperation(this.leak);
        return writeInt(value);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf writeLong(long value) {
        recordLeakNonRefCountingOperation(this.leak);
        return writeLong(value);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf writeChar(int value) {
        recordLeakNonRefCountingOperation(this.leak);
        return writeChar(value);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf writeFloat(float value) {
        recordLeakNonRefCountingOperation(this.leak);
        return writeFloat(value);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf writeDouble(double value) {
        recordLeakNonRefCountingOperation(this.leak);
        return writeDouble(value);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(ByteBuf src) {
        recordLeakNonRefCountingOperation(this.leak);
        return writeBytes(src);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(ByteBuf src, int length) {
        recordLeakNonRefCountingOperation(this.leak);
        return writeBytes(src, length);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(ByteBuf src, int srcIndex, int length) {
        recordLeakNonRefCountingOperation(this.leak);
        return writeBytes(src, srcIndex, length);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(byte[] src) {
        recordLeakNonRefCountingOperation(this.leak);
        return writeBytes(src);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(byte[] src, int srcIndex, int length) {
        recordLeakNonRefCountingOperation(this.leak);
        return writeBytes(src, srcIndex, length);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(ByteBuffer src) {
        recordLeakNonRefCountingOperation(this.leak);
        return writeBytes(src);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public int writeBytes(InputStream in, int length) throws IOException {
        recordLeakNonRefCountingOperation(this.leak);
        return writeBytes(in, length);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public int writeBytes(ScatteringByteChannel in, int length) throws IOException {
        recordLeakNonRefCountingOperation(this.leak);
        return writeBytes(in, length);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf writeZero(int length) {
        recordLeakNonRefCountingOperation(this.leak);
        return writeZero(length);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public int indexOf(int fromIndex, int toIndex, byte value) {
        recordLeakNonRefCountingOperation(this.leak);
        return indexOf(fromIndex, toIndex, value);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public int bytesBefore(byte value) {
        recordLeakNonRefCountingOperation(this.leak);
        return bytesBefore(value);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public int bytesBefore(int length, byte value) {
        recordLeakNonRefCountingOperation(this.leak);
        return bytesBefore(length, value);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public int bytesBefore(int index, int length, byte value) {
        recordLeakNonRefCountingOperation(this.leak);
        return bytesBefore(index, length, value);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public int forEachByte(ByteProcessor processor) {
        recordLeakNonRefCountingOperation(this.leak);
        return forEachByte(processor);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public int forEachByte(int index, int length, ByteProcessor processor) {
        recordLeakNonRefCountingOperation(this.leak);
        return forEachByte(index, length, processor);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public int forEachByteDesc(ByteProcessor processor) {
        recordLeakNonRefCountingOperation(this.leak);
        return forEachByteDesc(processor);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public int forEachByteDesc(int index, int length, ByteProcessor processor) {
        recordLeakNonRefCountingOperation(this.leak);
        return forEachByteDesc(index, length, processor);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf copy() {
        recordLeakNonRefCountingOperation(this.leak);
        return copy();
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf copy(int index, int length) {
        recordLeakNonRefCountingOperation(this.leak);
        return copy(index, length);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public int nioBufferCount() {
        recordLeakNonRefCountingOperation(this.leak);
        return nioBufferCount();
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer() {
        recordLeakNonRefCountingOperation(this.leak);
        return nioBuffer();
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer(int index, int length) {
        recordLeakNonRefCountingOperation(this.leak);
        return nioBuffer(index, length);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers() {
        recordLeakNonRefCountingOperation(this.leak);
        return nioBuffers();
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers(int index, int length) {
        recordLeakNonRefCountingOperation(this.leak);
        return nioBuffers(index, length);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuffer internalNioBuffer(int index, int length) {
        recordLeakNonRefCountingOperation(this.leak);
        return internalNioBuffer(index, length);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public String toString(Charset charset) {
        recordLeakNonRefCountingOperation(this.leak);
        return toString(charset);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public String toString(int index, int length, Charset charset) {
        recordLeakNonRefCountingOperation(this.leak);
        return toString(index, length, charset);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf capacity(int newCapacity) {
        recordLeakNonRefCountingOperation(this.leak);
        return capacity(newCapacity);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public short getShortLE(int index) {
        recordLeakNonRefCountingOperation(this.leak);
        return getShortLE(index);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public int getUnsignedShortLE(int index) {
        recordLeakNonRefCountingOperation(this.leak);
        return getUnsignedShortLE(index);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public int getMediumLE(int index) {
        recordLeakNonRefCountingOperation(this.leak);
        return getMediumLE(index);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public int getUnsignedMediumLE(int index) {
        recordLeakNonRefCountingOperation(this.leak);
        return getUnsignedMediumLE(index);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public int getIntLE(int index) {
        recordLeakNonRefCountingOperation(this.leak);
        return getIntLE(index);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public long getUnsignedIntLE(int index) {
        recordLeakNonRefCountingOperation(this.leak);
        return getUnsignedIntLE(index);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public long getLongLE(int index) {
        recordLeakNonRefCountingOperation(this.leak);
        return getLongLE(index);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setShortLE(int index, int value) {
        recordLeakNonRefCountingOperation(this.leak);
        return setShortLE(index, value);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setIntLE(int index, int value) {
        recordLeakNonRefCountingOperation(this.leak);
        return setIntLE(index, value);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setMediumLE(int index, int value) {
        recordLeakNonRefCountingOperation(this.leak);
        return setMediumLE(index, value);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setLongLE(int index, long value) {
        recordLeakNonRefCountingOperation(this.leak);
        return setLongLE(index, value);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public short readShortLE() {
        recordLeakNonRefCountingOperation(this.leak);
        return readShortLE();
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public int readUnsignedShortLE() {
        recordLeakNonRefCountingOperation(this.leak);
        return readUnsignedShortLE();
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public int readMediumLE() {
        recordLeakNonRefCountingOperation(this.leak);
        return readMediumLE();
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public int readUnsignedMediumLE() {
        recordLeakNonRefCountingOperation(this.leak);
        return readUnsignedMediumLE();
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public int readIntLE() {
        recordLeakNonRefCountingOperation(this.leak);
        return readIntLE();
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public long readUnsignedIntLE() {
        recordLeakNonRefCountingOperation(this.leak);
        return readUnsignedIntLE();
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public long readLongLE() {
        recordLeakNonRefCountingOperation(this.leak);
        return readLongLE();
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf writeShortLE(int value) {
        recordLeakNonRefCountingOperation(this.leak);
        return writeShortLE(value);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf writeMediumLE(int value) {
        recordLeakNonRefCountingOperation(this.leak);
        return writeMediumLE(value);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf writeIntLE(int value) {
        recordLeakNonRefCountingOperation(this.leak);
        return writeIntLE(value);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf writeLongLE(long value) {
        recordLeakNonRefCountingOperation(this.leak);
        return writeLongLE(value);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public int writeCharSequence(CharSequence sequence, Charset charset) {
        recordLeakNonRefCountingOperation(this.leak);
        return writeCharSequence(sequence, charset);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public int getBytes(int index, FileChannel out, long position, int length) throws IOException {
        recordLeakNonRefCountingOperation(this.leak);
        return getBytes(index, out, position, length);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public int setBytes(int index, FileChannel in, long position, int length) throws IOException {
        recordLeakNonRefCountingOperation(this.leak);
        return setBytes(index, in, position, length);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public int readBytes(FileChannel out, long position, int length) throws IOException {
        recordLeakNonRefCountingOperation(this.leak);
        return readBytes(out, position, length);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public int writeBytes(FileChannel in, long position, int length) throws IOException {
        recordLeakNonRefCountingOperation(this.leak);
        return writeBytes(in, position, length);
    }

    @Override // p013io.netty.buffer.SimpleLeakAwareByteBuf, p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf asReadOnly() {
        recordLeakNonRefCountingOperation(this.leak);
        return asReadOnly();
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf, p013io.netty.util.ReferenceCounted
    public ByteBuf retain() {
        this.leak.record();
        return retain();
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf, p013io.netty.util.ReferenceCounted
    public ByteBuf retain(int increment) {
        this.leak.record();
        return retain(increment);
    }

    @Override // p013io.netty.buffer.SimpleLeakAwareByteBuf, p013io.netty.buffer.WrappedByteBuf, p013io.netty.util.ReferenceCounted
    public boolean release() {
        this.leak.record();
        return release();
    }

    @Override // p013io.netty.buffer.SimpleLeakAwareByteBuf, p013io.netty.buffer.WrappedByteBuf, p013io.netty.util.ReferenceCounted
    public boolean release(int decrement) {
        this.leak.record();
        return release(decrement);
    }

    @Override // p013io.netty.buffer.SimpleLeakAwareByteBuf, p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf, p013io.netty.util.ReferenceCounted
    public ByteBuf touch() {
        this.leak.record();
        return this;
    }

    @Override // p013io.netty.buffer.SimpleLeakAwareByteBuf, p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf, p013io.netty.util.ReferenceCounted
    public ByteBuf touch(Object hint) {
        this.leak.record(hint);
        return this;
    }

    @Override // p013io.netty.buffer.SimpleLeakAwareByteBuf
    protected AdvancedLeakAwareByteBuf newLeakAwareByteBuf(ByteBuf buf, ByteBuf trackedByteBuf, ResourceLeakTracker<ByteBuf> leakTracker) {
        return new AdvancedLeakAwareByteBuf(buf, trackedByteBuf, leakTracker);
    }
}
