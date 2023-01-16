package com.google.common.p004io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@Beta
@GwtIncompatible
/* renamed from: com.google.common.io.CountingOutputStream */
/* loaded from: grasscutter.jar:com/google/common/io/CountingOutputStream.class */
public final class CountingOutputStream extends FilterOutputStream {
    private long count;

    public CountingOutputStream(OutputStream out) {
        super((OutputStream) Preconditions.checkNotNull(out));
    }

    public long getCount() {
        return this.count;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] b, int off, int len) throws IOException {
        this.out.write(b, off, len);
        this.count += (long) len;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int b) throws IOException {
        this.out.write(b);
        this.count++;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.out.close();
    }
}
