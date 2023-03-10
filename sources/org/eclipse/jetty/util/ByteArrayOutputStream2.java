package org.eclipse.jetty.util;

import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/ByteArrayOutputStream2.class */
public class ByteArrayOutputStream2 extends ByteArrayOutputStream {
    public ByteArrayOutputStream2() {
    }

    public ByteArrayOutputStream2(int size) {
        super(size);
    }

    public byte[] getBuf() {
        return this.buf;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void reset(int minSize) {
        reset();
        if (this.buf.length < minSize) {
            this.buf = new byte[minSize];
        }
    }

    public void writeUnchecked(int b) {
        byte[] bArr = this.buf;
        int i = this.count;
        this.count = i + 1;
        bArr[i] = (byte) b;
    }

    public String toString(Charset charset) {
        return new String(this.buf, 0, this.count, charset);
    }
}
