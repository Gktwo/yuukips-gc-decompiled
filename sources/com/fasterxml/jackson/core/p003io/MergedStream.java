package com.fasterxml.jackson.core.p003io;

import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.fasterxml.jackson.core.io.MergedStream */
/* loaded from: grasscutter.jar:com/fasterxml/jackson/core/io/MergedStream.class */
public final class MergedStream extends InputStream {
    private final IOContext _ctxt;
    private final InputStream _in;

    /* renamed from: _b */
    private byte[] f220_b;
    private int _ptr;
    private final int _end;

    public MergedStream(IOContext ctxt, InputStream in, byte[] buf, int start, int end) {
        this._ctxt = ctxt;
        this._in = in;
        this.f220_b = buf;
        this._ptr = start;
        this._end = end;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        if (this.f220_b != null) {
            return this._end - this._ptr;
        }
        return this._in.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        _free();
        this._in.close();
    }

    @Override // java.io.InputStream
    public synchronized void mark(int readlimit) {
        if (this.f220_b == null) {
            this._in.mark(readlimit);
        }
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f220_b == null && this._in.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.f220_b == null) {
            return this._in.read();
        }
        byte[] bArr = this.f220_b;
        int i = this._ptr;
        this._ptr = i + 1;
        int c = bArr[i] & 255;
        if (this._ptr >= this._end) {
            _free();
        }
        return c;
    }

    @Override // java.io.InputStream
    public int read(byte[] b) throws IOException {
        return read(b, 0, b.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] b, int off, int len) throws IOException {
        if (this.f220_b == null) {
            return this._in.read(b, off, len);
        }
        int avail = this._end - this._ptr;
        if (len > avail) {
            len = avail;
        }
        System.arraycopy(this.f220_b, this._ptr, b, off, len);
        this._ptr += len;
        if (this._ptr >= this._end) {
            _free();
        }
        return len;
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        if (this.f220_b == null) {
            this._in.reset();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v1, types: [long] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v16, types: [long] */
    /* JADX WARN: Type inference failed for: r0v18, types: [long] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // java.io.InputStream
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long skip(long r7) throws java.io.IOException {
        /*
            r6 = this;
            r0 = 0
            r9 = r0
            r0 = r6
            byte[] r0 = r0.f220_b
            if (r0 == 0) goto L_0x0039
            r0 = r6
            int r0 = r0._end
            r1 = r6
            int r1 = r1._ptr
            int r0 = r0 - r1
            r11 = r0
            r0 = r11
            long r0 = (long) r0
            r1 = r7
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x0029
            r0 = r6
            r1 = r0
            int r1 = r1._ptr
            r2 = r7
            int r2 = (int) r2
            int r1 = r1 + r2
            r0._ptr = r1
            r0 = r7
            return r0
        L_0x0029:
            r0 = r6
            r0._free()
            r0 = r9
            r1 = r11
            long r1 = (long) r1
            long r0 = r0 + r1
            r9 = r0
            r0 = r7
            r1 = r11
            long r1 = (long) r1
            long r0 = r0 - r1
            r7 = r0
        L_0x0039:
            r0 = r7
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x004a
            r0 = r9
            r1 = r6
            java.io.InputStream r1 = r1._in
            r2 = r7
            long r1 = r1.skip(r2)
            long r0 = r0 + r1
            r9 = r0
        L_0x004a:
            r0 = r9
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.p003io.MergedStream.skip(long):long");
    }

    private void _free() {
        byte[] buf = this.f220_b;
        if (buf != null) {
            this.f220_b = null;
            if (this._ctxt != null) {
                this._ctxt.releaseReadIOBuffer(buf);
            }
        }
    }
}
