package p013io.netty.buffer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import p013io.netty.util.internal.ObjectPool;
import p013io.netty.util.internal.PlatformDependent;

/* access modifiers changed from: package-private */
/* renamed from: io.netty.buffer.PooledHeapByteBuf */
/* loaded from: grasscutter.jar:io/netty/buffer/PooledHeapByteBuf.class */
public class PooledHeapByteBuf extends PooledByteBuf<byte[]> {
    private static final ObjectPool<PooledHeapByteBuf> RECYCLER = ObjectPool.newPool(new ObjectPool.ObjectCreator<PooledHeapByteBuf>() { // from class: io.netty.buffer.PooledHeapByteBuf.1
        @Override // p013io.netty.util.internal.ObjectPool.ObjectCreator
        public PooledHeapByteBuf newObject(ObjectPool.Handle<PooledHeapByteBuf> handle) {
            return new PooledHeapByteBuf(handle, 0);
        }
    });

    /* access modifiers changed from: package-private */
    public static PooledHeapByteBuf newInstance(int maxCapacity) {
        PooledHeapByteBuf buf = RECYCLER.get();
        buf.reuse(maxCapacity);
        return buf;
    }

    /* access modifiers changed from: package-private */
    public PooledHeapByteBuf(ObjectPool.Handle<? extends PooledHeapByteBuf> recyclerHandle, int maxCapacity) {
        super(recyclerHandle, maxCapacity);
    }

    @Override // p013io.netty.buffer.ByteBuf
    public final boolean isDirect() {
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public byte _getByte(int index) {
        return HeapByteBufUtil.getByte((byte[]) this.memory, idx(index));
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public short _getShort(int index) {
        return HeapByteBufUtil.getShort((byte[]) this.memory, idx(index));
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public short _getShortLE(int index) {
        return HeapByteBufUtil.getShortLE((byte[]) this.memory, idx(index));
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMedium(int index) {
        return HeapByteBufUtil.getUnsignedMedium((byte[]) this.memory, idx(index));
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMediumLE(int index) {
        return HeapByteBufUtil.getUnsignedMediumLE((byte[]) this.memory, idx(index));
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public int _getInt(int index) {
        return HeapByteBufUtil.getInt((byte[]) this.memory, idx(index));
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public int _getIntLE(int index) {
        return HeapByteBufUtil.getIntLE((byte[]) this.memory, idx(index));
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public long _getLong(int index) {
        return HeapByteBufUtil.getLong((byte[]) this.memory, idx(index));
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public long _getLongLE(int index) {
        return HeapByteBufUtil.getLongLE((byte[]) this.memory, idx(index));
    }

    @Override // p013io.netty.buffer.ByteBuf
    public final ByteBuf getBytes(int index, ByteBuf dst, int dstIndex, int length) {
        checkDstIndex(index, length, dstIndex, dst.capacity());
        if (dst.hasMemoryAddress()) {
            PlatformDependent.copyMemory((byte[]) this.memory, idx(index), dst.memoryAddress() + ((long) dstIndex), (long) length);
        } else if (dst.hasArray()) {
            getBytes(index, dst.array(), dst.arrayOffset() + dstIndex, length);
        } else {
            dst.setBytes(dstIndex, (byte[]) this.memory, idx(index), length);
        }
        return this;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public final ByteBuf getBytes(int index, byte[] dst, int dstIndex, int length) {
        checkDstIndex(index, length, dstIndex, dst.length);
        System.arraycopy(this.memory, idx(index), dst, dstIndex, length);
        return this;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public final ByteBuf getBytes(int index, ByteBuffer dst) {
        int length = dst.remaining();
        checkIndex(index, length);
        dst.put((byte[]) this.memory, idx(index), length);
        return this;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public final ByteBuf getBytes(int index, OutputStream out, int length) throws IOException {
        checkIndex(index, length);
        out.write((byte[]) this.memory, idx(index), length);
        return this;
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public void _setByte(int index, int value) {
        HeapByteBufUtil.setByte((byte[]) this.memory, idx(index), value);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public void _setShort(int index, int value) {
        HeapByteBufUtil.setShort((byte[]) this.memory, idx(index), value);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public void _setShortLE(int index, int value) {
        HeapByteBufUtil.setShortLE((byte[]) this.memory, idx(index), value);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public void _setMedium(int index, int value) {
        HeapByteBufUtil.setMedium((byte[]) this.memory, idx(index), value);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public void _setMediumLE(int index, int value) {
        HeapByteBufUtil.setMediumLE((byte[]) this.memory, idx(index), value);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public void _setInt(int index, int value) {
        HeapByteBufUtil.setInt((byte[]) this.memory, idx(index), value);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public void _setIntLE(int index, int value) {
        HeapByteBufUtil.setIntLE((byte[]) this.memory, idx(index), value);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public void _setLong(int index, long value) {
        HeapByteBufUtil.setLong((byte[]) this.memory, idx(index), value);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.buffer.AbstractByteBuf
    public void _setLongLE(int index, long value) {
        HeapByteBufUtil.setLongLE((byte[]) this.memory, idx(index), value);
    }

    @Override // p013io.netty.buffer.ByteBuf
    public final ByteBuf setBytes(int index, ByteBuf src, int srcIndex, int length) {
        checkSrcIndex(index, length, srcIndex, src.capacity());
        if (src.hasMemoryAddress()) {
            PlatformDependent.copyMemory(src.memoryAddress() + ((long) srcIndex), (byte[]) this.memory, idx(index), (long) length);
        } else if (src.hasArray()) {
            setBytes(index, src.array(), src.arrayOffset() + srcIndex, length);
        } else {
            src.getBytes(srcIndex, (byte[]) this.memory, idx(index), length);
        }
        return this;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public final ByteBuf setBytes(int index, byte[] src, int srcIndex, int length) {
        checkSrcIndex(index, length, srcIndex, src.length);
        System.arraycopy(src, srcIndex, this.memory, idx(index), length);
        return this;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public final ByteBuf setBytes(int index, ByteBuffer src) {
        int length = src.remaining();
        checkIndex(index, length);
        src.get((byte[]) this.memory, idx(index), length);
        return this;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public final int setBytes(int index, InputStream in, int length) throws IOException {
        checkIndex(index, length);
        return in.read((byte[]) this.memory, idx(index), length);
    }

    @Override // p013io.netty.buffer.ByteBuf
    public final ByteBuf copy(int index, int length) {
        checkIndex(index, length);
        return alloc().heapBuffer(length, maxCapacity()).writeBytes((byte[]) this.memory, idx(index), length);
    }

    @Override // p013io.netty.buffer.PooledByteBuf
    final ByteBuffer duplicateInternalNioBuffer(int index, int length) {
        checkIndex(index, length);
        return ByteBuffer.wrap((byte[]) this.memory, idx(index), length).slice();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public final boolean hasArray() {
        return true;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public final byte[] array() {
        ensureAccessible();
        return (byte[]) this.memory;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public final int arrayOffset() {
        return this.offset;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public final boolean hasMemoryAddress() {
        return false;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public final long memoryAddress() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: protected */
    public final ByteBuffer newInternalNioBuffer(byte[] memory) {
        return ByteBuffer.wrap(memory);
    }
}
