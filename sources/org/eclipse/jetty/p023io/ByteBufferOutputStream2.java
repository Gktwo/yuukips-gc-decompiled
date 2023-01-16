package org.eclipse.jetty.p023io;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* renamed from: org.eclipse.jetty.io.ByteBufferOutputStream2 */
/* loaded from: grasscutter.jar:org/eclipse/jetty/io/ByteBufferOutputStream2.class */
public class ByteBufferOutputStream2 extends OutputStream {
    private final ByteBufferAccumulator _accumulator;
    private int _size;

    public ByteBufferOutputStream2() {
        this(null, false);
    }

    public ByteBufferOutputStream2(ByteBufferPool bufferPool, boolean direct) {
        this._size = 0;
        this._accumulator = new ByteBufferAccumulator(bufferPool == null ? new NullByteBufferPool() : bufferPool, direct);
    }

    public ByteBufferPool getByteBufferPool() {
        return this._accumulator.getByteBufferPool();
    }

    public ByteBuffer takeByteBuffer() {
        return this._accumulator.takeByteBuffer();
    }

    public ByteBuffer toByteBuffer() {
        return this._accumulator.toByteBuffer();
    }

    public byte[] toByteArray() {
        return this._accumulator.toByteArray();
    }

    public int size() {
        return this._size;
    }

    @Override // java.io.OutputStream
    public void write(int b) {
        write(new byte[]{(byte) b}, 0, 1);
    }

    @Override // java.io.OutputStream
    public void write(byte[] b, int off, int len) {
        this._size += len;
        this._accumulator.copyBytes(b, off, len);
    }

    public void write(ByteBuffer buffer) {
        this._size += buffer.remaining();
        this._accumulator.copyBuffer(buffer);
    }

    public void writeTo(ByteBuffer buffer) {
        this._accumulator.writeTo(buffer);
    }

    public void writeTo(OutputStream out) throws IOException {
        this._accumulator.writeTo(out);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this._accumulator.close();
        this._size = 0;
    }

    @Override // java.lang.Object
    public synchronized String toString() {
        return String.format("%s@%x{size=%d, byteAccumulator=%s}", getClass().getSimpleName(), Integer.valueOf(hashCode()), Integer.valueOf(this._size), this._accumulator);
    }
}
