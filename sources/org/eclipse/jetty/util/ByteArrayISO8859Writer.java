package org.eclipse.jetty.util;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/ByteArrayISO8859Writer.class */
public class ByteArrayISO8859Writer extends Writer {
    private byte[] _buf;
    private int _size;
    private ByteArrayOutputStream2 _bout;
    private OutputStreamWriter _writer;
    private boolean _fixed;

    public ByteArrayISO8859Writer() {
        this._bout = null;
        this._writer = null;
        this._fixed = false;
        this._buf = new byte[2048];
    }

    public ByteArrayISO8859Writer(int capacity) {
        this._bout = null;
        this._writer = null;
        this._fixed = false;
        this._buf = new byte[capacity];
    }

    public ByteArrayISO8859Writer(byte[] buf) {
        this._bout = null;
        this._writer = null;
        this._fixed = false;
        this._buf = buf;
        this._fixed = true;
    }

    public Object getLock() {
        return this.lock;
    }

    public int size() {
        return this._size;
    }

    public int capacity() {
        return this._buf.length;
    }

    public int spareCapacity() {
        return this._buf.length - this._size;
    }

    public void setLength(int l) {
        this._size = l;
    }

    public byte[] getBuf() {
        return this._buf;
    }

    public void writeTo(OutputStream out) throws IOException {
        out.write(this._buf, 0, this._size);
    }

    public void write(char c) throws IOException {
        ensureSpareCapacity(1);
        if (c < 0 || c > 127) {
            writeEncoded(new char[]{c}, 0, 1);
            return;
        }
        byte[] bArr = this._buf;
        int i = this._size;
        this._size = i + 1;
        bArr[i] = (byte) c;
    }

    @Override // java.io.Writer
    public void write(char[] ca) throws IOException {
        ensureSpareCapacity(ca.length);
        for (int i = 0; i < ca.length; i++) {
            char c = ca[i];
            if (c < 0 || c > 127) {
                writeEncoded(ca, i, ca.length - i);
                return;
            }
            byte[] bArr = this._buf;
            int i2 = this._size;
            this._size = i2 + 1;
            bArr[i2] = (byte) c;
        }
    }

    @Override // java.io.Writer
    public void write(char[] ca, int offset, int length) throws IOException {
        ensureSpareCapacity(length);
        for (int i = 0; i < length; i++) {
            char c = ca[offset + i];
            if (c < 0 || c > 127) {
                writeEncoded(ca, offset + i, length - i);
                return;
            }
            byte[] bArr = this._buf;
            int i2 = this._size;
            this._size = i2 + 1;
            bArr[i2] = (byte) c;
        }
    }

    @Override // java.io.Writer
    public void write(String s) throws IOException {
        if (s == null) {
            write("null", 0, 4);
            return;
        }
        int length = s.length();
        ensureSpareCapacity(length);
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c < 0 || c > 127) {
                writeEncoded(s.toCharArray(), i, length - i);
                return;
            }
            byte[] bArr = this._buf;
            int i2 = this._size;
            this._size = i2 + 1;
            bArr[i2] = (byte) c;
        }
    }

    @Override // java.io.Writer
    public void write(String s, int offset, int length) throws IOException {
        ensureSpareCapacity(length);
        for (int i = 0; i < length; i++) {
            char c = s.charAt(offset + i);
            if (c < 0 || c > 127) {
                writeEncoded(s.toCharArray(), offset + i, length - i);
                return;
            }
            byte[] bArr = this._buf;
            int i2 = this._size;
            this._size = i2 + 1;
            bArr[i2] = (byte) c;
        }
    }

    private void writeEncoded(char[] ca, int offset, int length) throws IOException {
        if (this._bout == null) {
            this._bout = new ByteArrayOutputStream2(2 * length);
            this._writer = new OutputStreamWriter(this._bout, StandardCharsets.ISO_8859_1);
        } else {
            this._bout.reset();
        }
        this._writer.write(ca, offset, length);
        this._writer.flush();
        ensureSpareCapacity(this._bout.getCount());
        System.arraycopy(this._bout.getBuf(), 0, this._buf, this._size, this._bout.getCount());
        this._size += this._bout.getCount();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
    }

    public void resetWriter() {
        this._size = 0;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public void destroy() {
        this._buf = null;
    }

    public void ensureSpareCapacity(int n) throws IOException {
        if (this._size + n <= this._buf.length) {
            return;
        }
        if (this._fixed) {
            throw new IOException("Buffer overflow: " + this._buf.length);
        }
        this._buf = Arrays.copyOf(this._buf, ((this._buf.length + n) * 4) / 3);
    }

    public byte[] getByteArray() {
        return Arrays.copyOf(this._buf, this._size);
    }
}
