package org.eclipse.jetty.util;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.EnumSet;

@Deprecated
/* loaded from: grasscutter.jar:org/eclipse/jetty/util/ReadLineInputStream.class */
public class ReadLineInputStream extends BufferedInputStream {
    boolean _seenCRLF;
    boolean _skipLF;
    private EnumSet<Termination> _lineTerminations = EnumSet.noneOf(Termination.class);

    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/ReadLineInputStream$Termination.class */
    public enum Termination {
        CRLF,
        LF,
        CR,
        EOF
    }

    public EnumSet<Termination> getLineTerminations() {
        return this._lineTerminations;
    }

    public ReadLineInputStream(InputStream in) {
        super(in);
    }

    public ReadLineInputStream(InputStream in, int size) {
        super(in, size);
    }

    public String readLine() throws IOException {
        mark(this.buf.length);
        while (true) {
            int b = read();
            if (this.markpos < 0) {
                throw new IOException("Buffer size exceeded: no line terminator");
            }
            if (this._skipLF && b != 10) {
                this._lineTerminations.add(Termination.CR);
            }
            if (b == -1) {
                int m = this.markpos;
                this.markpos = -1;
                if (this.pos <= m) {
                    return null;
                }
                this._lineTerminations.add(Termination.EOF);
                return new String(this.buf, m, this.pos - m, StandardCharsets.UTF_8);
            } else if (b == 13) {
                int p = this.pos;
                if (!this._seenCRLF || this.pos >= this.count) {
                    this._skipLF = true;
                } else if (this.buf[this.pos] == 10) {
                    this._lineTerminations.add(Termination.CRLF);
                    this.pos++;
                } else {
                    this._lineTerminations.add(Termination.CR);
                }
                int m2 = this.markpos;
                this.markpos = -1;
                return new String(this.buf, m2, (p - m2) - 1, StandardCharsets.UTF_8);
            } else if (b == 10) {
                if (this._skipLF) {
                    this._skipLF = false;
                    this._seenCRLF = true;
                    this.markpos++;
                    this._lineTerminations.add(Termination.CRLF);
                } else {
                    int m3 = this.markpos;
                    this.markpos = -1;
                    this._lineTerminations.add(Termination.LF);
                    return new String(this.buf, m3, (this.pos - m3) - 1, StandardCharsets.UTF_8);
                }
            }
        }
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        int b = read();
        if (this._skipLF) {
            this._skipLF = false;
            if (this._seenCRLF && b == 10) {
                b = read();
            }
        }
        return b;
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] buf, int off, int len) throws IOException {
        if (this._skipLF && len > 0) {
            this._skipLF = false;
            if (this._seenCRLF) {
                int b = read();
                if (b == -1) {
                    return -1;
                }
                if (b != 10) {
                    buf[off] = (byte) (255 & b);
                    return 1 + read(buf, off + 1, len - 1);
                }
            }
        }
        return read(buf, off, len);
    }
}
