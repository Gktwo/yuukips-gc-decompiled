package org.eclipse.jetty.p023io;

import java.io.OutputStream;
import java.nio.ByteBuffer;
import org.eclipse.jetty.util.BufferUtil;

/* renamed from: org.eclipse.jetty.io.ByteBufferOutputStream */
/* loaded from: grasscutter.jar:org/eclipse/jetty/io/ByteBufferOutputStream.class */
public class ByteBufferOutputStream extends OutputStream {
    final ByteBuffer _buffer;

    public ByteBufferOutputStream(ByteBuffer buffer) {
        this._buffer = buffer;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
    }

    @Override // java.io.OutputStream
    public void write(byte[] b) {
        write(b, 0, b.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] b, int off, int len) {
        BufferUtil.append(this._buffer, b, off, len);
    }

    @Override // java.io.OutputStream
    public void write(int b) {
        BufferUtil.append(this._buffer, (byte) b);
    }
}
