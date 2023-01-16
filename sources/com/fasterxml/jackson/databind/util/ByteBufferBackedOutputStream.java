package com.fasterxml.jackson.databind.util;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/util/ByteBufferBackedOutputStream.class */
public class ByteBufferBackedOutputStream extends OutputStream {

    /* renamed from: _b */
    protected final ByteBuffer f240_b;

    public ByteBufferBackedOutputStream(ByteBuffer buf) {
        this.f240_b = buf;
    }

    @Override // java.io.OutputStream
    public void write(int b) throws IOException {
        this.f240_b.put((byte) b);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bytes, int off, int len) throws IOException {
        this.f240_b.put(bytes, off, len);
    }
}
