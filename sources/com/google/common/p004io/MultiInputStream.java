package com.google.common.p004io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

@GwtIncompatible
/* renamed from: com.google.common.io.MultiInputStream */
/* loaded from: grasscutter.jar:com/google/common/io/MultiInputStream.class */
final class MultiInputStream extends InputStream {

    /* renamed from: it */
    private Iterator<? extends ByteSource> f324it;

    /* renamed from: in */
    private InputStream f325in;

    public MultiInputStream(Iterator<? extends ByteSource> it) throws IOException {
        this.f324it = (Iterator) Preconditions.checkNotNull(it);
        advance();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f325in != null) {
            try {
                this.f325in.close();
            } finally {
                this.f325in = null;
            }
        }
    }

    private void advance() throws IOException {
        close();
        if (this.f324it.hasNext()) {
            this.f325in = ((ByteSource) this.f324it.next()).openStream();
        }
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        if (this.f325in == null) {
            return 0;
        }
        return this.f325in.available();
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        while (this.f325in != null) {
            int result = this.f325in.read();
            if (result != -1) {
                return result;
            }
            advance();
        }
        return -1;
    }

    @Override // java.io.InputStream
    public int read(byte[] b, int off, int len) throws IOException {
        while (this.f325in != null) {
            int result = this.f325in.read(b, off, len);
            if (result != -1) {
                return result;
            }
            advance();
        }
        return -1;
    }

    @Override // java.io.InputStream
    public long skip(long n) throws IOException {
        if (this.f325in == null || n <= 0) {
            return 0;
        }
        long result = this.f325in.skip(n);
        if (result != 0) {
            return result;
        }
        if (read() == -1) {
            return 0;
        }
        return 1 + this.f325in.skip(n - 1);
    }
}
