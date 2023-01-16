package p013io.netty.buffer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import p013io.netty.util.ByteProcessor;
import p013io.netty.util.internal.ObjectPool;

/* access modifiers changed from: package-private */
/* renamed from: io.netty.buffer.PooledDuplicatedByteBuf */
/* loaded from: grasscutter.jar:io/netty/buffer/PooledDuplicatedByteBuf.class */
public final class PooledDuplicatedByteBuf extends AbstractPooledDerivedByteBuf {
    private static final ObjectPool<PooledDuplicatedByteBuf> RECYCLER = ObjectPool.newPool(new ObjectPool.ObjectCreator<PooledDuplicatedByteBuf>() { // from class: io.netty.buffer.PooledDuplicatedByteBuf.1
        @Override // p013io.netty.util.internal.ObjectPool.ObjectCreator
        public PooledDuplicatedByteBuf newObject(ObjectPool.Handle<PooledDuplicatedByteBuf> handle) {
            return new PooledDuplicatedByteBuf(handle);
        }
    });

    /* access modifiers changed from: package-private */
    public static PooledDuplicatedByteBuf newInstance(AbstractByteBuf unwrapped, ByteBuf wrapped, int readerIndex, int writerIndex) {
        PooledDuplicatedByteBuf duplicate = RECYCLER.get();
        duplicate.init(unwrapped, wrapped, readerIndex, writerIndex, unwrapped.maxCapacity());
        duplicate.markReaderIndex();
        duplicate.markWriterIndex();
        return duplicate;
    }

    private PooledDuplicatedByteBuf(ObjectPool.Handle<PooledDuplicatedByteBuf> handle) {
        super(handle);
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
    public int arrayOffset() {
        return unwrap().arrayOffset();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public long memoryAddress() {
        return unwrap().memoryAddress();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer(int index, int length) {
        return unwrap().nioBuffer(index, length);
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers(int index, int length) {
        return unwrap().nioBuffers(index, length);
    }

    @Override // p013io.netty.buffer.ByteBuf
    public ByteBuf copy(int index, int length) {
        return unwrap().copy(index, length);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf retainedSlice(int index, int length) {
        return PooledSlicedByteBuf.newInstance(unwrap(), this, index, length);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf duplicate() {
        return duplicate0().setIndex(readerIndex(), writerIndex());
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf retainedDuplicate() {
        return newInstance(unwrap(), this, readerIndex(), writerIndex());
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public byte getByte(int index) {
        return unwrap().getByte(index);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public byte _getByte(int index) {
        return unwrap()._getByte(index);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public short getShort(int index) {
        return unwrap().getShort(index);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public short _getShort(int index) {
        return unwrap()._getShort(index);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public short getShortLE(int index) {
        return unwrap().getShortLE(index);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public short _getShortLE(int index) {
        return unwrap()._getShortLE(index);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int getUnsignedMedium(int index) {
        return unwrap().getUnsignedMedium(index);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMedium(int index) {
        return unwrap()._getUnsignedMedium(index);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int getUnsignedMediumLE(int index) {
        return unwrap().getUnsignedMediumLE(index);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMediumLE(int index) {
        return unwrap()._getUnsignedMediumLE(index);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int getInt(int index) {
        return unwrap().getInt(index);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public int _getInt(int index) {
        return unwrap()._getInt(index);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int getIntLE(int index) {
        return unwrap().getIntLE(index);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public int _getIntLE(int index) {
        return unwrap()._getIntLE(index);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public long getLong(int index) {
        return unwrap().getLong(index);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public long _getLong(int index) {
        return unwrap()._getLong(index);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public long getLongLE(int index) {
        return unwrap().getLongLE(index);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public long _getLongLE(int index) {
        return unwrap()._getLongLE(index);
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

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public void _setByte(int index, int value) {
        unwrap()._setByte(index, value);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setShort(int index, int value) {
        unwrap().setShort(index, value);
        return this;
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public void _setShort(int index, int value) {
        unwrap()._setShort(index, value);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setShortLE(int index, int value) {
        unwrap().setShortLE(index, value);
        return this;
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public void _setShortLE(int index, int value) {
        unwrap()._setShortLE(index, value);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setMedium(int index, int value) {
        unwrap().setMedium(index, value);
        return this;
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public void _setMedium(int index, int value) {
        unwrap()._setMedium(index, value);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setMediumLE(int index, int value) {
        unwrap().setMediumLE(index, value);
        return this;
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public void _setMediumLE(int index, int value) {
        unwrap()._setMediumLE(index, value);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setInt(int index, int value) {
        unwrap().setInt(index, value);
        return this;
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public void _setInt(int index, int value) {
        unwrap()._setInt(index, value);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setIntLE(int index, int value) {
        unwrap().setIntLE(index, value);
        return this;
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public void _setIntLE(int index, int value) {
        unwrap()._setIntLE(index, value);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setLong(int index, long value) {
        unwrap().setLong(index, value);
        return this;
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public void _setLong(int index, long value) {
        unwrap()._setLong(index, value);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf setLongLE(int index, long value) {
        unwrap().setLongLE(index, value);
        return this;
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public void _setLongLE(int index, long value) {
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

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int forEachByte(int index, int length, ByteProcessor processor) {
        return unwrap().forEachByte(index, length, processor);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public int forEachByteDesc(int index, int length, ByteProcessor processor) {
        return unwrap().forEachByteDesc(index, length, processor);
    }
}
