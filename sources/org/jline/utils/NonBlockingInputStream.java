package org.jline.utils;

import java.io.IOException;
import java.io.InputStream;

/* WARNING: Classes with same name are omitted:
  
 */
/* loaded from: grasscutter.jar:org/jline/utils/NonBlockingInputStream.class */
public abstract class NonBlockingInputStream extends InputStream {
    public static final int EOF = -1;
    public static final int READ_EXPIRED = -2;

    public abstract int read(long j, boolean z) throws IOException;

    @Override // java.io.InputStream
    public int read() throws IOException {
        return read(0, false);
    }

    public int peek(long timeout) throws IOException {
        return read(timeout, true);
    }

    public int read(long timeout) throws IOException {
        return read(timeout, false);
    }

    @Override // java.io.InputStream
    public int read(byte[] b, int off, int len) throws IOException {
        if (b == null) {
            throw new NullPointerException();
        } else if (off < 0 || len < 0 || len > b.length - off) {
            throw new IndexOutOfBoundsException();
        } else if (len == 0) {
            return 0;
        } else {
            int c = read();
            if (c == -1) {
                return -1;
            }
            b[off] = (byte) c;
            return 1;
        }
    }

    public int readBuffered(byte[] b) throws IOException {
        if (b == null) {
            throw new NullPointerException();
        } else if (b.length == 0) {
            return 0;
        } else {
            return read(b, 0, b.length);
        }
    }

    public void shutdown() {
    }
}
