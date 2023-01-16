package com.fasterxml.jackson.databind.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/util/ByteBufferBackedInputStream.class */
public class ByteBufferBackedInputStream extends InputStream {

    /* renamed from: _b */
    protected final ByteBuffer f239_b;

    public ByteBufferBackedInputStream(ByteBuffer buf) {
        this.f239_b = buf;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f239_b.remaining();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.f239_b.hasRemaining()) {
            return this.f239_b.get() & 255;
        }
        return -1;
    }

    @Override // java.io.InputStream
    public int read(byte[] bytes, int off, int len) throws IOException {
        if (!this.f239_b.hasRemaining()) {
            return -1;
        }
        int len2 = Math.min(len, this.f239_b.remaining());
        this.f239_b.get(bytes, off, len2);
        return len2;
    }
}
