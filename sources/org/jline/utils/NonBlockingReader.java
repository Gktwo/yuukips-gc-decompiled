package org.jline.utils;

import java.io.IOException;
import java.io.Reader;

/* WARNING: Classes with same name are omitted:
  
 */
/* loaded from: grasscutter.jar:org/jline/utils/NonBlockingReader.class */
public abstract class NonBlockingReader extends Reader {
    public static final int EOF = -1;
    public static final int READ_EXPIRED = -2;

    public abstract int readBuffered(char[] cArr) throws IOException;

    protected abstract int read(long j, boolean z) throws IOException;

    public void shutdown() {
    }

    @Override // java.io.Reader
    public int read() throws IOException {
        return read(0, false);
    }

    public int peek(long timeout) throws IOException {
        return read(timeout, true);
    }

    public int read(long timeout) throws IOException {
        return read(timeout, false);
    }

    @Override // java.io.Reader
    public int read(char[] b, int off, int len) throws IOException {
        if (b == null) {
            throw new NullPointerException();
        } else if (off < 0 || len < 0 || len > b.length - off) {
            throw new IndexOutOfBoundsException();
        } else if (len == 0) {
            return 0;
        } else {
            int c = read(0);
            if (c == -1) {
                return -1;
            }
            b[off] = (char) c;
            return 1;
        }
    }

    public int available() {
        return 0;
    }
}
