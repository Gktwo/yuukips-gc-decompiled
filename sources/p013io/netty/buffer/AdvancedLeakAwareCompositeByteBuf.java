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
import java.util.Iterator;
import java.util.List;
import p013io.netty.util.ByteProcessor;
import p013io.netty.util.ResourceLeakTracker;

/* access modifiers changed from: package-private */
/* renamed from: io.netty.buffer.AdvancedLeakAwareCompositeByteBuf */
/* loaded from: grasscutter.jar:io/netty/buffer/AdvancedLeakAwareCompositeByteBuf.class */
public final class AdvancedLeakAwareCompositeByteBuf extends SimpleLeakAwareCompositeByteBuf {
    /* access modifiers changed from: package-private */
    public AdvancedLeakAwareCompositeByteBuf(CompositeByteBuf wrapped, ResourceLeakTracker<ByteBuf> leak) {
        super(wrapped, leak);
    }

    @Override // p013io.netty.buffer.SimpleLeakAwareCompositeByteBuf, p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf order(ByteOrder endianness) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return order(endianness);
    }

    @Override // p013io.netty.buffer.SimpleLeakAwareCompositeByteBuf, p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf slice() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return slice();
    }

    @Override // p013io.netty.buffer.SimpleLeakAwareCompositeByteBuf, p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf retainedSlice() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return retainedSlice();
    }

    @Override // p013io.netty.buffer.SimpleLeakAwareCompositeByteBuf, p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf slice(int index, int length) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return slice(index, length);
    }

    @Override // p013io.netty.buffer.SimpleLeakAwareCompositeByteBuf, p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf retainedSlice(int index, int length) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return retainedSlice(index, length);
    }

    @Override // p013io.netty.buffer.SimpleLeakAwareCompositeByteBuf, p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf duplicate() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return duplicate();
    }

    @Override // p013io.netty.buffer.SimpleLeakAwareCompositeByteBuf, p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf retainedDuplicate() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return retainedDuplicate();
    }

    @Override // p013io.netty.buffer.SimpleLeakAwareCompositeByteBuf, p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf readSlice(int length) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return readSlice(length);
    }

    @Override // p013io.netty.buffer.SimpleLeakAwareCompositeByteBuf, p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf readRetainedSlice(int length) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return readRetainedSlice(length);
    }

    @Override // p013io.netty.buffer.SimpleLeakAwareCompositeByteBuf, p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf asReadOnly() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return asReadOnly();
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public boolean isReadOnly() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return isReadOnly();
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf discardReadBytes() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return discardReadBytes();
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf discardSomeReadBytes() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return discardSomeReadBytes();
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf ensureWritable(int minWritableBytes) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return ensureWritable(minWritableBytes);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int ensureWritable(int minWritableBytes, boolean force) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return ensureWritable(minWritableBytes, force);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public boolean getBoolean(int index) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return getBoolean(index);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public byte getByte(int index) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return getByte(index);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public short getUnsignedByte(int index) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return getUnsignedByte(index);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public short getShort(int index) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return getShort(index);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int getUnsignedShort(int index) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return getUnsignedShort(index);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int getMedium(int index) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return getMedium(index);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int getUnsignedMedium(int index) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return getUnsignedMedium(index);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int getInt(int index) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return getInt(index);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public long getUnsignedInt(int index) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return getUnsignedInt(index);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public long getLong(int index) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return getLong(index);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public char getChar(int index) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return getChar(index);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public float getFloat(int index) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return getFloat(index);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public double getDouble(int index) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return getDouble(index);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf getBytes(int index, ByteBuf dst) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return getBytes(index, dst);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf getBytes(int index, ByteBuf dst, int length) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return getBytes(index, dst, length);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf getBytes(int index, ByteBuf dst, int dstIndex, int length) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return getBytes(index, dst, dstIndex, length);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf getBytes(int index, byte[] dst) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return getBytes(index, dst);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf getBytes(int index, byte[] dst, int dstIndex, int length) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return getBytes(index, dst, dstIndex, length);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf getBytes(int index, ByteBuffer dst) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return getBytes(index, dst);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf getBytes(int index, OutputStream out, int length) throws IOException {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return getBytes(index, out, length);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.ByteBuf
    public int getBytes(int index, GatheringByteChannel out, int length) throws IOException {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return getBytes(index, out, length);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CharSequence getCharSequence(int index, int length, Charset charset) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return getCharSequence(index, length, charset);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf setBoolean(int index, boolean value) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return setBoolean(index, value);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf setByte(int index, int value) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return setByte(index, value);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf setShort(int index, int value) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return setShort(index, value);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf setMedium(int index, int value) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return setMedium(index, value);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf setInt(int index, int value) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return setInt(index, value);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf setLong(int index, long value) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return setLong(index, value);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf setChar(int index, int value) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return setChar(index, value);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf setFloat(int index, float value) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return setFloat(index, value);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf setDouble(int index, double value) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return setDouble(index, value);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf setBytes(int index, ByteBuf src) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return setBytes(index, src);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf setBytes(int index, ByteBuf src, int length) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return setBytes(index, src, length);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf setBytes(int index, ByteBuf src, int srcIndex, int length) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return setBytes(index, src, srcIndex, length);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf setBytes(int index, byte[] src) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return setBytes(index, src);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf setBytes(int index, byte[] src, int srcIndex, int length) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return setBytes(index, src, srcIndex, length);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf setBytes(int index, ByteBuffer src) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return setBytes(index, src);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.ByteBuf
    public int setBytes(int index, InputStream in, int length) throws IOException {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return setBytes(index, in, length);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.ByteBuf
    public int setBytes(int index, ScatteringByteChannel in, int length) throws IOException {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return setBytes(index, in, length);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf setZero(int index, int length) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return setZero(index, length);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public boolean readBoolean() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return readBoolean();
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public byte readByte() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return readByte();
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public short readUnsignedByte() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return readUnsignedByte();
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public short readShort() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return readShort();
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int readUnsignedShort() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return readUnsignedShort();
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int readMedium() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return readMedium();
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int readUnsignedMedium() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return readUnsignedMedium();
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int readInt() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return readInt();
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public long readUnsignedInt() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return readUnsignedInt();
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public long readLong() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return readLong();
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public char readChar() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return readChar();
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public float readFloat() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return readFloat();
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public double readDouble() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return readDouble();
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf readBytes(int length) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return readBytes(length);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf readBytes(ByteBuf dst) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return readBytes(dst);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf readBytes(ByteBuf dst, int length) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return readBytes(dst, length);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf readBytes(ByteBuf dst, int dstIndex, int length) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return readBytes(dst, dstIndex, length);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf readBytes(byte[] dst) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return readBytes(dst);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf readBytes(byte[] dst, int dstIndex, int length) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return readBytes(dst, dstIndex, length);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf readBytes(ByteBuffer dst) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return readBytes(dst);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf readBytes(OutputStream out, int length) throws IOException {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return readBytes(out, length);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int readBytes(GatheringByteChannel out, int length) throws IOException {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return readBytes(out, length);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CharSequence readCharSequence(int length, Charset charset) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return readCharSequence(length, charset);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf skipBytes(int length) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return skipBytes(length);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf writeBoolean(boolean value) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return writeBoolean(value);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf writeByte(int value) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return writeByte(value);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf writeShort(int value) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return writeShort(value);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf writeMedium(int value) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return writeMedium(value);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf writeInt(int value) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return writeInt(value);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf writeLong(long value) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return writeLong(value);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf writeChar(int value) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return writeChar(value);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf writeFloat(float value) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return writeFloat(value);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf writeDouble(double value) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return writeDouble(value);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf writeBytes(ByteBuf src) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return writeBytes(src);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf writeBytes(ByteBuf src, int length) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return writeBytes(src, length);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf writeBytes(ByteBuf src, int srcIndex, int length) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return writeBytes(src, srcIndex, length);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf writeBytes(byte[] src) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return writeBytes(src);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf writeBytes(byte[] src, int srcIndex, int length) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return writeBytes(src, srcIndex, length);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf writeBytes(ByteBuffer src) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return writeBytes(src);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int writeBytes(InputStream in, int length) throws IOException {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return writeBytes(in, length);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int writeBytes(ScatteringByteChannel in, int length) throws IOException {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return writeBytes(in, length);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf writeZero(int length) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return writeZero(length);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int writeCharSequence(CharSequence sequence, Charset charset) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return writeCharSequence(sequence, charset);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int indexOf(int fromIndex, int toIndex, byte value) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return indexOf(fromIndex, toIndex, value);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int bytesBefore(byte value) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return bytesBefore(value);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int bytesBefore(int length, byte value) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return bytesBefore(length, value);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int bytesBefore(int index, int length, byte value) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return bytesBefore(index, length, value);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int forEachByte(ByteProcessor processor) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return forEachByte(processor);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int forEachByte(int index, int length, ByteProcessor processor) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return forEachByte(index, length, processor);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int forEachByteDesc(ByteProcessor processor) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return forEachByteDesc(processor);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int forEachByteDesc(int index, int length, ByteProcessor processor) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return forEachByteDesc(index, length, processor);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf copy() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return copy();
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf copy(int index, int length) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return copy(index, length);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.ByteBuf
    public int nioBufferCount() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return nioBufferCount();
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return nioBuffer();
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer(int index, int length) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return nioBuffer(index, length);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return nioBuffers();
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers(int index, int length) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return nioBuffers(index, length);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuffer internalNioBuffer(int index, int length) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return internalNioBuffer(index, length);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public String toString(Charset charset) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return toString(charset);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public String toString(int index, int length, Charset charset) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return toString(index, length, charset);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf capacity(int newCapacity) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return capacity(newCapacity);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public short getShortLE(int index) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return getShortLE(index);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int getUnsignedShortLE(int index) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return getUnsignedShortLE(index);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int getUnsignedMediumLE(int index) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return getUnsignedMediumLE(index);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int getMediumLE(int index) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return getMediumLE(index);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int getIntLE(int index) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return getIntLE(index);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public long getUnsignedIntLE(int index) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return getUnsignedIntLE(index);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public long getLongLE(int index) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return getLongLE(index);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setShortLE(int index, int value) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return setShortLE(index, value);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setMediumLE(int index, int value) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return setMediumLE(index, value);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setIntLE(int index, int value) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return setIntLE(index, value);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setLongLE(int index, long value) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return setLongLE(index, value);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int setCharSequence(int index, CharSequence sequence, Charset charset) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return setCharSequence(index, sequence, charset);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public short readShortLE() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return readShortLE();
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int readUnsignedShortLE() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return readUnsignedShortLE();
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int readMediumLE() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return readMediumLE();
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int readUnsignedMediumLE() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return readUnsignedMediumLE();
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int readIntLE() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return readIntLE();
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public long readUnsignedIntLE() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return readUnsignedIntLE();
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public long readLongLE() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return readLongLE();
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf writeShortLE(int value) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return writeShortLE(value);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf writeMediumLE(int value) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return writeMediumLE(value);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf writeIntLE(int value) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return writeIntLE(value);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf writeLongLE(long value) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return writeLongLE(value);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf addComponent(ByteBuf buffer) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return addComponent(buffer);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf addComponents(ByteBuf... buffers) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return addComponents(buffers);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf addComponents(Iterable<ByteBuf> buffers) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return addComponents(buffers);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf addComponent(int cIndex, ByteBuf buffer) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return addComponent(cIndex, buffer);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf addComponents(int cIndex, ByteBuf... buffers) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return addComponents(cIndex, buffers);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf addComponents(int cIndex, Iterable<ByteBuf> buffers) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return addComponents(cIndex, buffers);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf addComponent(boolean increaseWriterIndex, ByteBuf buffer) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return addComponent(increaseWriterIndex, buffer);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf addComponents(boolean increaseWriterIndex, ByteBuf... buffers) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return addComponents(increaseWriterIndex, buffers);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf addComponents(boolean increaseWriterIndex, Iterable<ByteBuf> buffers) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return addComponents(increaseWriterIndex, buffers);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf addComponent(boolean increaseWriterIndex, int cIndex, ByteBuf buffer) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return addComponent(increaseWriterIndex, cIndex, buffer);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf addFlattenedComponents(boolean increaseWriterIndex, ByteBuf buffer) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return addFlattenedComponents(increaseWriterIndex, buffer);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf removeComponent(int cIndex) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return removeComponent(cIndex);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf removeComponents(int cIndex, int numComponents) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return removeComponents(cIndex, numComponents);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf, java.lang.Iterable
    public Iterator<ByteBuf> iterator() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return iterator();
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf
    public List<ByteBuf> decompose(int offset, int length) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return decompose(offset, length);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf consolidate() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return consolidate();
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf discardReadComponents() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return discardReadComponents();
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf consolidate(int cIndex, int numComponents) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return consolidate(cIndex, numComponents);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.ByteBuf
    public int getBytes(int index, FileChannel out, long position, int length) throws IOException {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return getBytes(index, out, position, length);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.ByteBuf
    public int setBytes(int index, FileChannel in, long position, int length) throws IOException {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return setBytes(index, in, position, length);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int readBytes(FileChannel out, long position, int length) throws IOException {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return readBytes(out, position, length);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int writeBytes(FileChannel in, long position, int length) throws IOException {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return writeBytes(in, position, length);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractReferenceCountedByteBuf, p013io.netty.buffer.ByteBuf, p013io.netty.util.ReferenceCounted
    public CompositeByteBuf retain() {
        this.leak.record();
        return retain();
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractReferenceCountedByteBuf, p013io.netty.buffer.ByteBuf, p013io.netty.util.ReferenceCounted
    public CompositeByteBuf retain(int increment) {
        this.leak.record();
        return retain(increment);
    }

    @Override // p013io.netty.buffer.SimpleLeakAwareCompositeByteBuf, p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractReferenceCountedByteBuf, p013io.netty.util.ReferenceCounted
    public boolean release() {
        this.leak.record();
        return release();
    }

    @Override // p013io.netty.buffer.SimpleLeakAwareCompositeByteBuf, p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractReferenceCountedByteBuf, p013io.netty.util.ReferenceCounted
    public boolean release(int decrement) {
        this.leak.record();
        return release(decrement);
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractReferenceCountedByteBuf, p013io.netty.buffer.ByteBuf, p013io.netty.util.ReferenceCounted
    public CompositeByteBuf touch() {
        this.leak.record();
        return this;
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractReferenceCountedByteBuf, p013io.netty.buffer.ByteBuf, p013io.netty.util.ReferenceCounted
    public CompositeByteBuf touch(Object hint) {
        this.leak.record(hint);
        return this;
    }

    @Override // p013io.netty.buffer.SimpleLeakAwareCompositeByteBuf
    protected AdvancedLeakAwareByteBuf newLeakAwareByteBuf(ByteBuf wrapped, ByteBuf trackedByteBuf, ResourceLeakTracker<ByteBuf> leakTracker) {
        return new AdvancedLeakAwareByteBuf(wrapped, trackedByteBuf, leakTracker);
    }
}
