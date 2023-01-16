package p013io.netty.buffer;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import p013io.netty.util.internal.ObjectPool;

/* access modifiers changed from: package-private */
/* renamed from: io.netty.buffer.PooledByteBuf */
/* loaded from: grasscutter.jar:io/netty/buffer/PooledByteBuf.class */
public abstract class PooledByteBuf<T> extends AbstractReferenceCountedByteBuf {
    private final ObjectPool.Handle<PooledByteBuf<T>> recyclerHandle;
    protected PoolChunk<T> chunk;
    protected long handle;
    protected T memory;
    protected int offset;
    protected int length;
    int maxLength;
    PoolThreadCache cache;
    ByteBuffer tmpNioBuf;
    private ByteBufAllocator allocator;
    static final /* synthetic */ boolean $assertionsDisabled;

    protected abstract ByteBuffer newInternalNioBuffer(T t);

    static {
        $assertionsDisabled = !PooledByteBuf.class.desiredAssertionStatus();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: io.netty.util.internal.ObjectPool$Handle<? extends io.netty.buffer.PooledByteBuf<T>> */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: protected */
    public PooledByteBuf(ObjectPool.Handle<? extends PooledByteBuf<T>> recyclerHandle, int maxCapacity) {
        super(maxCapacity);
        this.recyclerHandle = recyclerHandle;
    }

    /* access modifiers changed from: package-private */
    public void init(PoolChunk<T> chunk, ByteBuffer nioBuffer, long handle, int offset, int length, int maxLength, PoolThreadCache cache) {
        init0(chunk, nioBuffer, handle, offset, length, maxLength, cache);
    }

    /* access modifiers changed from: package-private */
    public void initUnpooled(PoolChunk<T> chunk, int length) {
        init0(chunk, null, 0, 0, length, length, null);
    }

    private void init0(PoolChunk<T> chunk, ByteBuffer nioBuffer, long handle, int offset, int length, int maxLength, PoolThreadCache cache) {
        if (!$assertionsDisabled && handle < 0) {
            throw new AssertionError();
        } else if (!$assertionsDisabled && chunk == null) {
            throw new AssertionError();
        } else if ($assertionsDisabled || !PoolChunk.isSubpage(handle) || chunk.arena.size2SizeIdx(maxLength) <= chunk.arena.smallMaxSizeIdx) {
            chunk.incrementPinnedMemory(maxLength);
            this.chunk = chunk;
            this.memory = chunk.memory;
            this.tmpNioBuf = nioBuffer;
            this.allocator = chunk.arena.parent;
            this.cache = cache;
            this.handle = handle;
            this.offset = offset;
            this.length = length;
            this.maxLength = maxLength;
        } else {
            throw new AssertionError("Allocated small sub-page handle for a buffer size that isn't \"small.\"");
        }
    }

    final void reuse(int maxCapacity) {
        maxCapacity(maxCapacity);
        resetRefCnt();
        setIndex0(0, 0);
        discardMarks();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public final int capacity() {
        return this.length;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public int maxFastWritableBytes() {
        return Math.min(this.maxLength, maxCapacity()) - this.writerIndex;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public final ByteBuf capacity(int newCapacity) {
        if (newCapacity == this.length) {
            ensureAccessible();
            return this;
        }
        checkNewCapacity(newCapacity);
        if (!this.chunk.unpooled) {
            if (newCapacity > this.length) {
                if (newCapacity <= this.maxLength) {
                    this.length = newCapacity;
                    return this;
                }
            } else if (newCapacity > (this.maxLength >>> 1) && (this.maxLength > 512 || newCapacity > this.maxLength - 16)) {
                this.length = newCapacity;
                trimIndicesToCapacity(newCapacity);
                return this;
            }
        }
        this.chunk.decrementPinnedMemory(this.maxLength);
        this.chunk.arena.reallocate(this, newCapacity, true);
        return this;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public final ByteBufAllocator alloc() {
        return this.allocator;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public final ByteOrder order() {
        return ByteOrder.BIG_ENDIAN;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public final ByteBuf unwrap() {
        return null;
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public final ByteBuf retainedDuplicate() {
        return PooledDuplicatedByteBuf.newInstance(this, this, readerIndex(), writerIndex());
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public final ByteBuf retainedSlice() {
        int index = readerIndex();
        return retainedSlice(index, writerIndex() - index);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public final ByteBuf retainedSlice(int index, int length) {
        return PooledSlicedByteBuf.newInstance(this, this, index, length);
    }

    /* access modifiers changed from: protected */
    public final ByteBuffer internalNioBuffer() {
        ByteBuffer tmpNioBuf = this.tmpNioBuf;
        if (tmpNioBuf == null) {
            ByteBuffer newInternalNioBuffer = newInternalNioBuffer(this.memory);
            tmpNioBuf = newInternalNioBuffer;
            this.tmpNioBuf = newInternalNioBuffer;
        } else {
            tmpNioBuf.clear();
        }
        return tmpNioBuf;
    }

    @Override // p013io.netty.buffer.AbstractReferenceCountedByteBuf
    protected final void deallocate() {
        if (this.handle >= 0) {
            long handle = this.handle;
            this.handle = -1;
            this.memory = null;
            this.chunk.decrementPinnedMemory(this.maxLength);
            this.chunk.arena.free(this.chunk, this.tmpNioBuf, handle, this.maxLength, this.cache);
            this.tmpNioBuf = null;
            this.chunk = null;
            recycle();
        }
    }

    private void recycle() {
        this.recyclerHandle.recycle(this);
    }

    protected final int idx(int index) {
        return this.offset + index;
    }

    final ByteBuffer _internalNioBuffer(int index, int length, boolean duplicate) {
        int index2 = idx(index);
        ByteBuffer buffer = duplicate ? newInternalNioBuffer(this.memory) : internalNioBuffer();
        buffer.limit(index2 + length).position(index2);
        return buffer;
    }

    ByteBuffer duplicateInternalNioBuffer(int index, int length) {
        checkIndex(index, length);
        return _internalNioBuffer(index, length, true);
    }

    @Override // p013io.netty.buffer.ByteBuf
    public final ByteBuffer internalNioBuffer(int index, int length) {
        checkIndex(index, length);
        return _internalNioBuffer(index, length, false);
    }

    @Override // p013io.netty.buffer.ByteBuf
    public final int nioBufferCount() {
        return 1;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public final ByteBuffer nioBuffer(int index, int length) {
        return duplicateInternalNioBuffer(index, length).slice();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public final ByteBuffer[] nioBuffers(int index, int length) {
        return new ByteBuffer[]{nioBuffer(index, length)};
    }

    @Override // p013io.netty.buffer.ByteBuf
    public final boolean isContiguous() {
        return true;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public final int getBytes(int index, GatheringByteChannel out, int length) throws IOException {
        return out.write(duplicateInternalNioBuffer(index, length));
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public final int readBytes(GatheringByteChannel out, int length) throws IOException {
        checkReadableBytes(length);
        int readBytes = out.write(_internalNioBuffer(this.readerIndex, length, false));
        this.readerIndex += readBytes;
        return readBytes;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public final int getBytes(int index, FileChannel out, long position, int length) throws IOException {
        return out.write(duplicateInternalNioBuffer(index, length), position);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public final int readBytes(FileChannel out, long position, int length) throws IOException {
        checkReadableBytes(length);
        int readBytes = out.write(_internalNioBuffer(this.readerIndex, length, false), position);
        this.readerIndex += readBytes;
        return readBytes;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public final int setBytes(int index, ScatteringByteChannel in, int length) throws IOException {
        try {
            return in.read(internalNioBuffer(index, length));
        } catch (ClosedChannelException e) {
            return -1;
        }
    }

    @Override // p013io.netty.buffer.ByteBuf
    public final int setBytes(int index, FileChannel in, long position, int length) throws IOException {
        try {
            return in.read(internalNioBuffer(index, length), position);
        } catch (ClosedChannelException e) {
            return -1;
        }
    }
}
