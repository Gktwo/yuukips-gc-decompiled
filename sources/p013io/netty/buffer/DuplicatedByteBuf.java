package p013io.netty.buffer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import p013io.netty.util.ByteProcessor;

@Deprecated
/* renamed from: io.netty.buffer.DuplicatedByteBuf */
/* loaded from: grasscutter.jar:io/netty/buffer/DuplicatedByteBuf.class */
public class DuplicatedByteBuf extends AbstractDerivedByteBuf {
    private final ByteBuf buffer;

    public DuplicatedByteBuf(ByteBuf buffer) {
        this(buffer, buffer.readerIndex(), buffer.writerIndex());
    }

    DuplicatedByteBuf(ByteBuf buffer, int readerIndex, int writerIndex) {
        super(buffer.maxCapacity());
        if (buffer instanceof DuplicatedByteBuf) {
            this.buffer = ((DuplicatedByteBuf) buffer).buffer;
        } else if (buffer instanceof AbstractPooledDerivedByteBuf) {
            this.buffer = buffer.unwrap();
        } else {
            this.buffer = buffer;
        }
        setIndex(readerIndex, writerIndex);
        markReaderIndex();
        markWriterIndex();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf unwrap() {
        return this.buffer;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBufAllocator alloc() {
        return unwrap().alloc();
    }

    @Override // p013io.netty.buffer.ByteBuf
    @Deprecated
    public ByteOrder order() {
        return unwrap().order();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public boolean isDirect() {
        return unwrap().isDirect();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public int capacity() {
        return unwrap().capacity();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf capacity(int newCapacity) {
        unwrap().capacity(newCapacity);
        return this;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public boolean hasArray() {
        return unwrap().hasArray();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public byte[] array() {
        return unwrap().array();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public int arrayOffset() {
        return unwrap().arrayOffset();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public boolean hasMemoryAddress() {
        return unwrap().hasMemoryAddress();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public long memoryAddress() {
        return unwrap().memoryAddress();
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public byte getByte(int index) {
        return unwrap().getByte(index);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf
    protected byte _getByte(int index) {
        return unwrap().getByte(index);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public short getShort(int index) {
        return unwrap().getShort(index);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf
    protected short _getShort(int index) {
        return unwrap().getShort(index);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public short getShortLE(int index) {
        return unwrap().getShortLE(index);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf
    protected short _getShortLE(int index) {
        return unwrap().getShortLE(index);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int getUnsignedMedium(int index) {
        return unwrap().getUnsignedMedium(index);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf
    protected int _getUnsignedMedium(int index) {
        return unwrap().getUnsignedMedium(index);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int getUnsignedMediumLE(int index) {
        return unwrap().getUnsignedMediumLE(index);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf
    protected int _getUnsignedMediumLE(int index) {
        return unwrap().getUnsignedMediumLE(index);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int getInt(int index) {
        return unwrap().getInt(index);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf
    protected int _getInt(int index) {
        return unwrap().getInt(index);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int getIntLE(int index) {
        return unwrap().getIntLE(index);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf
    protected int _getIntLE(int index) {
        return unwrap().getIntLE(index);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public long getLong(int index) {
        return unwrap().getLong(index);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf
    protected long _getLong(int index) {
        return unwrap().getLong(index);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public long getLongLE(int index) {
        return unwrap().getLongLE(index);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf
    protected long _getLongLE(int index) {
        return unwrap().getLongLE(index);
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf copy(int index, int length) {
        return unwrap().copy(index, length);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf slice(int index, int length) {
        return unwrap().slice(index, length);
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int index, ByteBuf dst, int dstIndex, int length) {
        unwrap().getBytes(index, dst, dstIndex, length);
        return this;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int index, byte[] dst, int dstIndex, int length) {
        unwrap().getBytes(index, dst, dstIndex, length);
        return this;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int index, ByteBuffer dst) {
        unwrap().getBytes(index, dst);
        return this;
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setByte(int index, int value) {
        unwrap().setByte(index, value);
        return this;
    }

    @Override // p013io.netty.buffer.AbstractByteBuf
    protected void _setByte(int index, int value) {
        unwrap().setByte(index, value);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setShort(int index, int value) {
        unwrap().setShort(index, value);
        return this;
    }

    @Override // p013io.netty.buffer.AbstractByteBuf
    protected void _setShort(int index, int value) {
        unwrap().setShort(index, value);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setShortLE(int index, int value) {
        unwrap().setShortLE(index, value);
        return this;
    }

    @Override // p013io.netty.buffer.AbstractByteBuf
    protected void _setShortLE(int index, int value) {
        unwrap().setShortLE(index, value);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setMedium(int index, int value) {
        unwrap().setMedium(index, value);
        return this;
    }

    @Override // p013io.netty.buffer.AbstractByteBuf
    protected void _setMedium(int index, int value) {
        unwrap().setMedium(index, value);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setMediumLE(int index, int value) {
        unwrap().setMediumLE(index, value);
        return this;
    }

    @Override // p013io.netty.buffer.AbstractByteBuf
    protected void _setMediumLE(int index, int value) {
        unwrap().setMediumLE(index, value);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setInt(int index, int value) {
        unwrap().setInt(index, value);
        return this;
    }

    @Override // p013io.netty.buffer.AbstractByteBuf
    protected void _setInt(int index, int value) {
        unwrap().setInt(index, value);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setIntLE(int index, int value) {
        unwrap().setIntLE(index, value);
        return this;
    }

    @Override // p013io.netty.buffer.AbstractByteBuf
    protected void _setIntLE(int index, int value) {
        unwrap().setIntLE(index, value);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setLong(int index, long value) {
        unwrap().setLong(index, value);
        return this;
    }

    @Override // p013io.netty.buffer.AbstractByteBuf
    protected void _setLong(int index, long value) {
        unwrap().setLong(index, value);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setLongLE(int index, long value) {
        unwrap().setLongLE(index, value);
        return this;
    }

    @Override // p013io.netty.buffer.AbstractByteBuf
    protected void _setLongLE(int index, long value) {
        unwrap().setLongLE(index, value);
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int index, byte[] src, int srcIndex, int length) {
        unwrap().setBytes(index, src, srcIndex, length);
        return this;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int index, ByteBuf src, int srcIndex, int length) {
        unwrap().setBytes(index, src, srcIndex, length);
        return this;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int index, ByteBuffer src) {
        unwrap().setBytes(index, src);
        return this;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int index, OutputStream out, int length) throws IOException {
        unwrap().getBytes(index, out, length);
        return this;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public int getBytes(int index, GatheringByteChannel out, int length) throws IOException {
        return unwrap().getBytes(index, out, length);
    }

    @Override // p013io.netty.buffer.ByteBuf
    public int getBytes(int index, FileChannel out, long position, int length) throws IOException {
        return unwrap().getBytes(index, out, position, length);
    }

    @Override // p013io.netty.buffer.ByteBuf
    public int setBytes(int index, InputStream in, int length) throws IOException {
        return unwrap().setBytes(index, in, length);
    }

    @Override // p013io.netty.buffer.ByteBuf
    public int setBytes(int index, ScatteringByteChannel in, int length) throws IOException {
        return unwrap().setBytes(index, in, length);
    }

    @Override // p013io.netty.buffer.ByteBuf
    public int setBytes(int index, FileChannel in, long position, int length) throws IOException {
        return unwrap().setBytes(index, in, position, length);
    }

    @Override // p013io.netty.buffer.ByteBuf
    public int nioBufferCount() {
        return unwrap().nioBufferCount();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers(int index, int length) {
        return unwrap().nioBuffers(index, length);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int forEachByte(int index, int length, ByteProcessor processor) {
        return unwrap().forEachByte(index, length, processor);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int forEachByteDesc(int index, int length, ByteProcessor processor) {
        return unwrap().forEachByteDesc(index, length, processor);
    }
}
