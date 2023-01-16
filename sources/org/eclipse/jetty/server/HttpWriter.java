package org.eclipse.jetty.server;

import java.io.IOException;
import java.io.Writer;
import org.eclipse.jetty.util.ByteArrayOutputStream2;
import org.eclipse.jetty.util.Callback;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/HttpWriter.class */
public abstract class HttpWriter extends Writer {
    public static final int MAX_OUTPUT_CHARS = 512;
    final HttpOutput _out;
    final char[] _chars = new char[512];
    final ByteArrayOutputStream2 _bytes = new ByteArrayOutputStream2(512);

    public HttpWriter(HttpOutput out) {
        this._out = out;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this._out.close();
    }

    public void complete(Callback callback) {
        this._out.complete(callback);
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() throws IOException {
        this._out.flush();
    }

    @Override // java.io.Writer
    public void write(String s, int offset, int length) throws IOException {
        while (length > 512) {
            write(s, offset, 512);
            offset += 512;
            length -= 512;
        }
        s.getChars(offset, offset + length, this._chars, 0);
        write(this._chars, 0, length);
    }

    @Override // java.io.Writer
    public void write(char[] s, int offset, int length) throws IOException {
        throw new AbstractMethodError();
    }
}
