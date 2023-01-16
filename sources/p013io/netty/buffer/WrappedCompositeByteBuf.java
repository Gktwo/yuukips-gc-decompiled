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

/* access modifiers changed from: package-private */
/* renamed from: io.netty.buffer.WrappedCompositeByteBuf */
/* loaded from: grasscutter.jar:io/netty/buffer/WrappedCompositeByteBuf.class */
public class WrappedCompositeByteBuf extends CompositeByteBuf {
    private final CompositeByteBuf wrapped;

    /* access modifiers changed from: package-private */
    public WrappedCompositeByteBuf(CompositeByteBuf wrapped) {
        super(wrapped.alloc());
        this.wrapped = wrapped;
    }

    @Override // p013io.netty.buffer.AbstractReferenceCountedByteBuf, p013io.netty.util.ReferenceCounted
    public boolean release() {
        return this.wrapped.release();
    }

    @Override // p013io.netty.buffer.AbstractReferenceCountedByteBuf, p013io.netty.util.ReferenceCounted
    public boolean release(int decrement) {
        return this.wrapped.release(decrement);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public final int maxCapacity() {
        return this.wrapped.maxCapacity();
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public final int readerIndex() {
        return this.wrapped.readerIndex();
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public final int writerIndex() {
        return this.wrapped.writerIndex();
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public final boolean isReadable() {
        return this.wrapped.isReadable();
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public final boolean isReadable(int numBytes) {
        return this.wrapped.isReadable(numBytes);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public final boolean isWritable() {
        return this.wrapped.isWritable();
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public final boolean isWritable(int numBytes) {
        return this.wrapped.isWritable(numBytes);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public final int readableBytes() {
        return this.wrapped.readableBytes();
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public final int writableBytes() {
        return this.wrapped.writableBytes();
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public final int maxWritableBytes() {
        return this.wrapped.maxWritableBytes();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public int maxFastWritableBytes() {
        return this.wrapped.maxFastWritableBytes();
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int ensureWritable(int minWritableBytes, boolean force) {
        return this.wrapped.ensureWritable(minWritableBytes, force);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf order(ByteOrder endianness) {
        return this.wrapped.order(endianness);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public boolean getBoolean(int index) {
        return this.wrapped.getBoolean(index);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public short getUnsignedByte(int index) {
        return this.wrapped.getUnsignedByte(index);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public short getShort(int index) {
        return this.wrapped.getShort(index);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public short getShortLE(int index) {
        return this.wrapped.getShortLE(index);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int getUnsignedShort(int index) {
        return this.wrapped.getUnsignedShort(index);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int getUnsignedShortLE(int index) {
        return this.wrapped.getUnsignedShortLE(index);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int getUnsignedMedium(int index) {
        return this.wrapped.getUnsignedMedium(index);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int getUnsignedMediumLE(int index) {
        return this.wrapped.getUnsignedMediumLE(index);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int getMedium(int index) {
        return this.wrapped.getMedium(index);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int getMediumLE(int index) {
        return this.wrapped.getMediumLE(index);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int getInt(int index) {
        return this.wrapped.getInt(index);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int getIntLE(int index) {
        return this.wrapped.getIntLE(index);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public long getUnsignedInt(int index) {
        return this.wrapped.getUnsignedInt(index);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public long getUnsignedIntLE(int index) {
        return this.wrapped.getUnsignedIntLE(index);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public long getLong(int index) {
        return this.wrapped.getLong(index);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public long getLongLE(int index) {
        return this.wrapped.getLongLE(index);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public char getChar(int index) {
        return this.wrapped.getChar(index);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public float getFloat(int index) {
        return this.wrapped.getFloat(index);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public double getDouble(int index) {
        return this.wrapped.getDouble(index);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setShortLE(int index, int value) {
        return this.wrapped.setShortLE(index, value);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setMediumLE(int index, int value) {
        return this.wrapped.setMediumLE(index, value);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setIntLE(int index, int value) {
        return this.wrapped.setIntLE(index, value);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setLongLE(int index, long value) {
        return this.wrapped.setLongLE(index, value);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public byte readByte() {
        return this.wrapped.readByte();
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public boolean readBoolean() {
        return this.wrapped.readBoolean();
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public short readUnsignedByte() {
        return this.wrapped.readUnsignedByte();
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public short readShort() {
        return this.wrapped.readShort();
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public short readShortLE() {
        return this.wrapped.readShortLE();
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int readUnsignedShort() {
        return this.wrapped.readUnsignedShort();
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int readUnsignedShortLE() {
        return this.wrapped.readUnsignedShortLE();
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int readMedium() {
        return this.wrapped.readMedium();
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int readMediumLE() {
        return this.wrapped.readMediumLE();
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int readUnsignedMedium() {
        return this.wrapped.readUnsignedMedium();
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int readUnsignedMediumLE() {
        return this.wrapped.readUnsignedMediumLE();
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int readInt() {
        return this.wrapped.readInt();
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int readIntLE() {
        return this.wrapped.readIntLE();
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public long readUnsignedInt() {
        return this.wrapped.readUnsignedInt();
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public long readUnsignedIntLE() {
        return this.wrapped.readUnsignedIntLE();
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public long readLong() {
        return this.wrapped.readLong();
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public long readLongLE() {
        return this.wrapped.readLongLE();
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public char readChar() {
        return this.wrapped.readChar();
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public float readFloat() {
        return this.wrapped.readFloat();
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public double readDouble() {
        return this.wrapped.readDouble();
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf readBytes(int length) {
        return this.wrapped.readBytes(length);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf slice() {
        return this.wrapped.slice();
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf retainedSlice() {
        return this.wrapped.retainedSlice();
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf slice(int index, int length) {
        return this.wrapped.slice(index, length);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf retainedSlice(int index, int length) {
        return this.wrapped.retainedSlice(index, length);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer() {
        return this.wrapped.nioBuffer();
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public String toString(Charset charset) {
        return this.wrapped.toString(charset);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public String toString(int index, int length, Charset charset) {
        return this.wrapped.toString(index, length, charset);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int indexOf(int fromIndex, int toIndex, byte value) {
        return this.wrapped.indexOf(fromIndex, toIndex, value);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int bytesBefore(byte value) {
        return this.wrapped.bytesBefore(value);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int bytesBefore(int length, byte value) {
        return this.wrapped.bytesBefore(length, value);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int bytesBefore(int index, int length, byte value) {
        return this.wrapped.bytesBefore(index, length, value);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int forEachByte(ByteProcessor processor) {
        return this.wrapped.forEachByte(processor);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int forEachByte(int index, int length, ByteProcessor processor) {
        return this.wrapped.forEachByte(index, length, processor);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int forEachByteDesc(ByteProcessor processor) {
        return this.wrapped.forEachByteDesc(processor);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int forEachByteDesc(int index, int length, ByteProcessor processor) {
        return this.wrapped.forEachByteDesc(index, length, processor);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf, java.lang.Object
    public final int hashCode() {
        return this.wrapped.hashCode();
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf, java.lang.Object
    public final boolean equals(Object o) {
        return this.wrapped.equals(o);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public final int compareTo(ByteBuf that) {
        return this.wrapped.compareTo(that);
    }

    @Override // p013io.netty.buffer.AbstractReferenceCountedByteBuf, p013io.netty.util.ReferenceCounted
    public final int refCnt() {
        return this.wrapped.refCnt();
    }

    /* access modifiers changed from: package-private */
    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractReferenceCountedByteBuf, p013io.netty.buffer.ByteBuf
    public final boolean isAccessible() {
        return this.wrapped.isAccessible();
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf duplicate() {
        return this.wrapped.duplicate();
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf retainedDuplicate() {
        return this.wrapped.retainedDuplicate();
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf readSlice(int length) {
        return this.wrapped.readSlice(length);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf readRetainedSlice(int length) {
        return this.wrapped.readRetainedSlice(length);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int readBytes(GatheringByteChannel out, int length) throws IOException {
        return this.wrapped.readBytes(out, length);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf writeShortLE(int value) {
        return this.wrapped.writeShortLE(value);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf writeMediumLE(int value) {
        return this.wrapped.writeMediumLE(value);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf writeIntLE(int value) {
        return this.wrapped.writeIntLE(value);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf writeLongLE(long value) {
        return this.wrapped.writeLongLE(value);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int writeBytes(InputStream in, int length) throws IOException {
        return this.wrapped.writeBytes(in, length);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int writeBytes(ScatteringByteChannel in, int length) throws IOException {
        return this.wrapped.writeBytes(in, length);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf copy() {
        return this.wrapped.copy();
    }

    @Override // p013io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf addComponent(ByteBuf buffer) {
        this.wrapped.addComponent(buffer);
        return this;
    }

    @Override // p013io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf addComponents(ByteBuf... buffers) {
        this.wrapped.addComponents(buffers);
        return this;
    }

    @Override // p013io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf addComponents(Iterable<ByteBuf> buffers) {
        this.wrapped.addComponents(buffers);
        return this;
    }

    @Override // p013io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf addComponent(int cIndex, ByteBuf buffer) {
        this.wrapped.addComponent(cIndex, buffer);
        return this;
    }

    @Override // p013io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf addComponents(int cIndex, ByteBuf... buffers) {
        this.wrapped.addComponents(cIndex, buffers);
        return this;
    }

    @Override // p013io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf addComponents(int cIndex, Iterable<ByteBuf> buffers) {
        this.wrapped.addComponents(cIndex, buffers);
        return this;
    }

    @Override // p013io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf addComponent(boolean increaseWriterIndex, ByteBuf buffer) {
        this.wrapped.addComponent(increaseWriterIndex, buffer);
        return this;
    }

    @Override // p013io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf addComponents(boolean increaseWriterIndex, ByteBuf... buffers) {
        this.wrapped.addComponents(increaseWriterIndex, buffers);
        return this;
    }

    @Override // p013io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf addComponents(boolean increaseWriterIndex, Iterable<ByteBuf> buffers) {
        this.wrapped.addComponents(increaseWriterIndex, buffers);
        return this;
    }

    @Override // p013io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf addComponent(boolean increaseWriterIndex, int cIndex, ByteBuf buffer) {
        this.wrapped.addComponent(increaseWriterIndex, cIndex, buffer);
        return this;
    }

    @Override // p013io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf addFlattenedComponents(boolean increaseWriterIndex, ByteBuf buffer) {
        this.wrapped.addFlattenedComponents(increaseWriterIndex, buffer);
        return this;
    }

    @Override // p013io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf removeComponent(int cIndex) {
        this.wrapped.removeComponent(cIndex);
        return this;
    }

    @Override // p013io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf removeComponents(int cIndex, int numComponents) {
        this.wrapped.removeComponents(cIndex, numComponents);
        return this;
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, java.lang.Iterable
    public Iterator<ByteBuf> iterator() {
        return this.wrapped.iterator();
    }

    @Override // p013io.netty.buffer.CompositeByteBuf
    public List<ByteBuf> decompose(int offset, int length) {
        return this.wrapped.decompose(offset, length);
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.ByteBuf
    public final boolean isDirect() {
        return this.wrapped.isDirect();
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.ByteBuf
    public final boolean hasArray() {
        return this.wrapped.hasArray();
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.ByteBuf
    public final byte[] array() {
        return this.wrapped.array();
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.ByteBuf
    public final int arrayOffset() {
        return this.wrapped.arrayOffset();
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.ByteBuf
    public final boolean hasMemoryAddress() {
        return this.wrapped.hasMemoryAddress();
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.ByteBuf
    public final long memoryAddress() {
        return this.wrapped.memoryAddress();
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.ByteBuf
    public final int capacity() {
        return this.wrapped.capacity();
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf capacity(int newCapacity) {
        this.wrapped.capacity(newCapacity);
        return this;
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.ByteBuf
    public final ByteBufAllocator alloc() {
        return this.wrapped.alloc();
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.ByteBuf
    public final ByteOrder order() {
        return this.wrapped.order();
    }

    @Override // p013io.netty.buffer.CompositeByteBuf
    public final int numComponents() {
        return this.wrapped.numComponents();
    }

    @Override // p013io.netty.buffer.CompositeByteBuf
    public final int maxNumComponents() {
        return this.wrapped.maxNumComponents();
    }

    @Override // p013io.netty.buffer.CompositeByteBuf
    public final int toComponentIndex(int offset) {
        return this.wrapped.toComponentIndex(offset);
    }

    @Override // p013io.netty.buffer.CompositeByteBuf
    public final int toByteIndex(int cIndex) {
        return this.wrapped.toByteIndex(cIndex);
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public byte getByte(int index) {
        return this.wrapped.getByte(index);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf
    public final byte _getByte(int index) {
        return this.wrapped._getByte(index);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf
    public final short _getShort(int index) {
        return this.wrapped._getShort(index);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf
    public final short _getShortLE(int index) {
        return this.wrapped._getShortLE(index);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf
    public final int _getUnsignedMedium(int index) {
        return this.wrapped._getUnsignedMedium(index);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf
    public final int _getUnsignedMediumLE(int index) {
        return this.wrapped._getUnsignedMediumLE(index);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf
    public final int _getInt(int index) {
        return this.wrapped._getInt(index);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf
    public final int _getIntLE(int index) {
        return this.wrapped._getIntLE(index);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf
    public final long _getLong(int index) {
        return this.wrapped._getLong(index);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf
    public final long _getLongLE(int index) {
        return this.wrapped._getLongLE(index);
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf getBytes(int index, byte[] dst, int dstIndex, int length) {
        this.wrapped.getBytes(index, dst, dstIndex, length);
        return this;
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf getBytes(int index, ByteBuffer dst) {
        this.wrapped.getBytes(index, dst);
        return this;
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf getBytes(int index, ByteBuf dst, int dstIndex, int length) {
        this.wrapped.getBytes(index, dst, dstIndex, length);
        return this;
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.ByteBuf
    public int getBytes(int index, GatheringByteChannel out, int length) throws IOException {
        return this.wrapped.getBytes(index, out, length);
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf getBytes(int index, OutputStream out, int length) throws IOException {
        this.wrapped.getBytes(index, out, length);
        return this;
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf setByte(int index, int value) {
        this.wrapped.setByte(index, value);
        return this;
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf
    public final void _setByte(int index, int value) {
        this.wrapped._setByte(index, value);
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf setShort(int index, int value) {
        this.wrapped.setShort(index, value);
        return this;
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf
    public final void _setShort(int index, int value) {
        this.wrapped._setShort(index, value);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf
    public final void _setShortLE(int index, int value) {
        this.wrapped._setShortLE(index, value);
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf setMedium(int index, int value) {
        this.wrapped.setMedium(index, value);
        return this;
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf
    public final void _setMedium(int index, int value) {
        this.wrapped._setMedium(index, value);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf
    public final void _setMediumLE(int index, int value) {
        this.wrapped._setMediumLE(index, value);
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf setInt(int index, int value) {
        this.wrapped.setInt(index, value);
        return this;
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf
    public final void _setInt(int index, int value) {
        this.wrapped._setInt(index, value);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf
    public final void _setIntLE(int index, int value) {
        this.wrapped._setIntLE(index, value);
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf setLong(int index, long value) {
        this.wrapped.setLong(index, value);
        return this;
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf
    public final void _setLong(int index, long value) {
        this.wrapped._setLong(index, value);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf
    public final void _setLongLE(int index, long value) {
        this.wrapped._setLongLE(index, value);
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf setBytes(int index, byte[] src, int srcIndex, int length) {
        this.wrapped.setBytes(index, src, srcIndex, length);
        return this;
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf setBytes(int index, ByteBuffer src) {
        this.wrapped.setBytes(index, src);
        return this;
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf setBytes(int index, ByteBuf src, int srcIndex, int length) {
        this.wrapped.setBytes(index, src, srcIndex, length);
        return this;
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.ByteBuf
    public int setBytes(int index, InputStream in, int length) throws IOException {
        return this.wrapped.setBytes(index, in, length);
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.ByteBuf
    public int setBytes(int index, ScatteringByteChannel in, int length) throws IOException {
        return this.wrapped.setBytes(index, in, length);
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf copy(int index, int length) {
        return this.wrapped.copy(index, length);
    }

    @Override // p013io.netty.buffer.CompositeByteBuf
    public final ByteBuf component(int cIndex) {
        return this.wrapped.component(cIndex);
    }

    @Override // p013io.netty.buffer.CompositeByteBuf
    public final ByteBuf componentAtOffset(int offset) {
        return this.wrapped.componentAtOffset(offset);
    }

    @Override // p013io.netty.buffer.CompositeByteBuf
    public final ByteBuf internalComponent(int cIndex) {
        return this.wrapped.internalComponent(cIndex);
    }

    @Override // p013io.netty.buffer.CompositeByteBuf
    public final ByteBuf internalComponentAtOffset(int offset) {
        return this.wrapped.internalComponentAtOffset(offset);
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.ByteBuf
    public int nioBufferCount() {
        return this.wrapped.nioBufferCount();
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuffer internalNioBuffer(int index, int length) {
        return this.wrapped.internalNioBuffer(index, length);
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer(int index, int length) {
        return this.wrapped.nioBuffer(index, length);
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers(int index, int length) {
        return this.wrapped.nioBuffers(index, length);
    }

    @Override // p013io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf consolidate() {
        this.wrapped.consolidate();
        return this;
    }

    @Override // p013io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf consolidate(int cIndex, int numComponents) {
        this.wrapped.consolidate(cIndex, numComponents);
        return this;
    }

    @Override // p013io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf discardReadComponents() {
        this.wrapped.discardReadComponents();
        return this;
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf discardReadBytes() {
        this.wrapped.discardReadBytes();
        return this;
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf, java.lang.Object
    public final String toString() {
        return this.wrapped.toString();
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public final CompositeByteBuf readerIndex(int readerIndex) {
        this.wrapped.readerIndex(readerIndex);
        return this;
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public final CompositeByteBuf writerIndex(int writerIndex) {
        this.wrapped.writerIndex(writerIndex);
        return this;
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public final CompositeByteBuf setIndex(int readerIndex, int writerIndex) {
        this.wrapped.setIndex(readerIndex, writerIndex);
        return this;
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public final CompositeByteBuf clear() {
        this.wrapped.clear();
        return this;
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public final CompositeByteBuf markReaderIndex() {
        this.wrapped.markReaderIndex();
        return this;
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public final CompositeByteBuf resetReaderIndex() {
        this.wrapped.resetReaderIndex();
        return this;
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public final CompositeByteBuf markWriterIndex() {
        this.wrapped.markWriterIndex();
        return this;
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public final CompositeByteBuf resetWriterIndex() {
        this.wrapped.resetWriterIndex();
        return this;
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf ensureWritable(int minWritableBytes) {
        this.wrapped.ensureWritable(minWritableBytes);
        return this;
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf getBytes(int index, ByteBuf dst) {
        this.wrapped.getBytes(index, dst);
        return this;
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf getBytes(int index, ByteBuf dst, int length) {
        this.wrapped.getBytes(index, dst, length);
        return this;
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf getBytes(int index, byte[] dst) {
        this.wrapped.getBytes(index, dst);
        return this;
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf setBoolean(int index, boolean value) {
        this.wrapped.setBoolean(index, value);
        return this;
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf setChar(int index, int value) {
        this.wrapped.setChar(index, value);
        return this;
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf setFloat(int index, float value) {
        this.wrapped.setFloat(index, value);
        return this;
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf setDouble(int index, double value) {
        this.wrapped.setDouble(index, value);
        return this;
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf setBytes(int index, ByteBuf src) {
        this.wrapped.setBytes(index, src);
        return this;
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf setBytes(int index, ByteBuf src, int length) {
        this.wrapped.setBytes(index, src, length);
        return this;
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf setBytes(int index, byte[] src) {
        this.wrapped.setBytes(index, src);
        return this;
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf setZero(int index, int length) {
        this.wrapped.setZero(index, length);
        return this;
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf readBytes(ByteBuf dst) {
        this.wrapped.readBytes(dst);
        return this;
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf readBytes(ByteBuf dst, int length) {
        this.wrapped.readBytes(dst, length);
        return this;
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf readBytes(ByteBuf dst, int dstIndex, int length) {
        this.wrapped.readBytes(dst, dstIndex, length);
        return this;
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf readBytes(byte[] dst) {
        this.wrapped.readBytes(dst);
        return this;
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf readBytes(byte[] dst, int dstIndex, int length) {
        this.wrapped.readBytes(dst, dstIndex, length);
        return this;
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf readBytes(ByteBuffer dst) {
        this.wrapped.readBytes(dst);
        return this;
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf readBytes(OutputStream out, int length) throws IOException {
        this.wrapped.readBytes(out, length);
        return this;
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.ByteBuf
    public int getBytes(int index, FileChannel out, long position, int length) throws IOException {
        return this.wrapped.getBytes(index, out, position, length);
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.ByteBuf
    public int setBytes(int index, FileChannel in, long position, int length) throws IOException {
        return this.wrapped.setBytes(index, in, position, length);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public boolean isReadOnly() {
        return this.wrapped.isReadOnly();
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf asReadOnly() {
        return this.wrapped.asReadOnly();
    }

    @Override // p013io.netty.buffer.AbstractByteBuf
    protected SwappedByteBuf newSwappedByteBuf() {
        return this.wrapped.newSwappedByteBuf();
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CharSequence getCharSequence(int index, int length, Charset charset) {
        return this.wrapped.getCharSequence(index, length, charset);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CharSequence readCharSequence(int length, Charset charset) {
        return this.wrapped.readCharSequence(length, charset);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int setCharSequence(int index, CharSequence sequence, Charset charset) {
        return this.wrapped.setCharSequence(index, sequence, charset);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int readBytes(FileChannel out, long position, int length) throws IOException {
        return this.wrapped.readBytes(out, position, length);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int writeBytes(FileChannel in, long position, int length) throws IOException {
        return this.wrapped.writeBytes(in, position, length);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int writeCharSequence(CharSequence sequence, Charset charset) {
        return this.wrapped.writeCharSequence(sequence, charset);
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf skipBytes(int length) {
        this.wrapped.skipBytes(length);
        return this;
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf writeBoolean(boolean value) {
        this.wrapped.writeBoolean(value);
        return this;
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf writeByte(int value) {
        this.wrapped.writeByte(value);
        return this;
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf writeShort(int value) {
        this.wrapped.writeShort(value);
        return this;
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf writeMedium(int value) {
        this.wrapped.writeMedium(value);
        return this;
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf writeInt(int value) {
        this.wrapped.writeInt(value);
        return this;
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf writeLong(long value) {
        this.wrapped.writeLong(value);
        return this;
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf writeChar(int value) {
        this.wrapped.writeChar(value);
        return this;
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf writeFloat(float value) {
        this.wrapped.writeFloat(value);
        return this;
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf writeDouble(double value) {
        this.wrapped.writeDouble(value);
        return this;
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf writeBytes(ByteBuf src) {
        this.wrapped.writeBytes(src);
        return this;
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf writeBytes(ByteBuf src, int length) {
        this.wrapped.writeBytes(src, length);
        return this;
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf writeBytes(ByteBuf src, int srcIndex, int length) {
        this.wrapped.writeBytes(src, srcIndex, length);
        return this;
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf writeBytes(byte[] src) {
        this.wrapped.writeBytes(src);
        return this;
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf writeBytes(byte[] src, int srcIndex, int length) {
        this.wrapped.writeBytes(src, srcIndex, length);
        return this;
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf writeBytes(ByteBuffer src) {
        this.wrapped.writeBytes(src);
        return this;
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf writeZero(int length) {
        this.wrapped.writeZero(length);
        return this;
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractReferenceCountedByteBuf, p013io.netty.buffer.ByteBuf, p013io.netty.util.ReferenceCounted
    public CompositeByteBuf retain(int increment) {
        this.wrapped.retain(increment);
        return this;
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractReferenceCountedByteBuf, p013io.netty.buffer.ByteBuf, p013io.netty.util.ReferenceCounted
    public CompositeByteBuf retain() {
        this.wrapped.retain();
        return this;
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractReferenceCountedByteBuf, p013io.netty.buffer.ByteBuf, p013io.netty.util.ReferenceCounted
    public CompositeByteBuf touch() {
        this.wrapped.touch();
        return this;
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractReferenceCountedByteBuf, p013io.netty.buffer.ByteBuf, p013io.netty.util.ReferenceCounted
    public CompositeByteBuf touch(Object hint) {
        this.wrapped.touch(hint);
        return this;
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers() {
        return this.wrapped.nioBuffers();
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public CompositeByteBuf discardSomeReadBytes() {
        this.wrapped.discardSomeReadBytes();
        return this;
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.AbstractReferenceCountedByteBuf
    public final void deallocate() {
        this.wrapped.deallocate();
    }

    @Override // p013io.netty.buffer.CompositeByteBuf, p013io.netty.buffer.ByteBuf
    public final ByteBuf unwrap() {
        return this.wrapped;
    }
}
