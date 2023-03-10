package org.eclipse.jetty.p023io;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.nio.charset.Charset;

/* renamed from: org.eclipse.jetty.io.WriterOutputStream */
/* loaded from: grasscutter.jar:org/eclipse/jetty/io/WriterOutputStream.class */
public class WriterOutputStream extends OutputStream {
    protected final Writer _writer;
    protected final Charset _encoding;
    private final byte[] _buf;

    public WriterOutputStream(Writer writer, String encoding) {
        this._buf = new byte[1];
        this._writer = writer;
        this._encoding = encoding == null ? null : Charset.forName(encoding);
    }

    public WriterOutputStream(Writer writer) {
        this._buf = new byte[1];
        this._writer = writer;
        this._encoding = null;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this._writer.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this._writer.flush();
    }

    @Override // java.io.OutputStream
    public void write(byte[] b) throws IOException {
        if (this._encoding == null) {
            this._writer.write(new String(b));
        } else {
            this._writer.write(new String(b, this._encoding));
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] b, int off, int len) throws IOException {
        if (this._encoding == null) {
            this._writer.write(new String(b, off, len));
        } else {
            this._writer.write(new String(b, off, len, this._encoding));
        }
    }

    @Override // java.io.OutputStream
    public synchronized void write(int b) throws IOException {
        this._buf[0] = (byte) b;
        write(this._buf);
    }
}
