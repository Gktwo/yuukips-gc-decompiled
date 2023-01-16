package org.eclipse.jetty.p023io;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.eclipse.jetty.util.BufferUtil;

/* renamed from: org.eclipse.jetty.io.ByteBufferAccumulator */
/* loaded from: grasscutter.jar:org/eclipse/jetty/io/ByteBufferAccumulator.class */
public class ByteBufferAccumulator implements AutoCloseable {
    private final List<ByteBuffer> _buffers;
    private final ByteBufferPool _bufferPool;
    private final boolean _direct;

    public ByteBufferAccumulator() {
        this(null, false);
    }

    public ByteBufferAccumulator(ByteBufferPool bufferPool, boolean direct) {
        this._buffers = new ArrayList();
        this._bufferPool = bufferPool == null ? new NullByteBufferPool() : bufferPool;
        this._direct = direct;
    }

    public int getLength() {
        int length = 0;
        for (ByteBuffer buffer : this._buffers) {
            length = Math.addExact(length, buffer.remaining());
        }
        return length;
    }

    public ByteBufferPool getByteBufferPool() {
        return this._bufferPool;
    }

    public ByteBuffer ensureBuffer(int minAllocationSize) {
        return ensureBuffer(1, minAllocationSize);
    }

    public ByteBuffer ensureBuffer(int minSize, int minAllocationSize) {
        ByteBuffer buffer = this._buffers.isEmpty() ? BufferUtil.EMPTY_BUFFER : this._buffers.get(this._buffers.size() - 1);
        if (BufferUtil.space(buffer) < minSize) {
            buffer = this._bufferPool.acquire(minAllocationSize, this._direct);
            this._buffers.add(buffer);
        }
        return buffer;
    }

    public void copyBytes(byte[] buf, int offset, int length) {
        copyBuffer(BufferUtil.toBuffer(buf, offset, length));
    }

    public void copyBuffer(ByteBuffer buffer) {
        while (buffer.hasRemaining()) {
            ByteBuffer b = ensureBuffer(buffer.remaining());
            int pos = BufferUtil.flipToFill(b);
            BufferUtil.put(buffer, b);
            BufferUtil.flipToFlush(b, pos);
        }
    }

    public ByteBuffer takeByteBuffer() {
        if (this._buffers.size() == 1) {
            ByteBuffer combinedBuffer = this._buffers.get(0);
            this._buffers.clear();
            return combinedBuffer;
        }
        ByteBuffer combinedBuffer2 = this._bufferPool.acquire(getLength(), this._direct);
        BufferUtil.clearToFill(combinedBuffer2);
        for (ByteBuffer buffer : this._buffers) {
            combinedBuffer2.put(buffer);
            this._bufferPool.release(buffer);
        }
        BufferUtil.flipToFlush(combinedBuffer2, 0);
        this._buffers.clear();
        return combinedBuffer2;
    }

    public ByteBuffer toByteBuffer() {
        ByteBuffer combinedBuffer = takeByteBuffer();
        this._buffers.add(combinedBuffer);
        return combinedBuffer;
    }

    public byte[] toByteArray() {
        int length = getLength();
        if (length == 0) {
            return new byte[0];
        }
        byte[] bytes = new byte[length];
        ByteBuffer buffer = BufferUtil.toBuffer(bytes);
        BufferUtil.clear(buffer);
        writeTo(buffer);
        return bytes;
    }

    public void writeTo(ByteBuffer buffer) {
        int pos = BufferUtil.flipToFill(buffer);
        for (ByteBuffer bb : this._buffers) {
            buffer.put(bb.slice());
        }
        BufferUtil.flipToFlush(buffer, pos);
    }

    public void writeTo(OutputStream out) throws IOException {
        for (ByteBuffer bb : this._buffers) {
            BufferUtil.writeTo(bb.slice(), out);
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        List<ByteBuffer> list = this._buffers;
        ByteBufferPool byteBufferPool = this._bufferPool;
        Objects.requireNonNull(byteBufferPool);
        list.forEach(this::release);
        this._buffers.clear();
    }
}
