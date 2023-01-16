package com.google.common.p004io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;

@GwtIncompatible
/* renamed from: com.google.common.io.MultiReader */
/* loaded from: grasscutter.jar:com/google/common/io/MultiReader.class */
class MultiReader extends Reader {

    /* renamed from: it */
    private final Iterator<? extends CharSource> f326it;
    private Reader current;

    /* access modifiers changed from: package-private */
    public MultiReader(Iterator<? extends CharSource> readers) throws IOException {
        this.f326it = readers;
        advance();
    }

    private void advance() throws IOException {
        close();
        if (this.f326it.hasNext()) {
            this.current = ((CharSource) this.f326it.next()).openStream();
        }
    }

    @Override // java.io.Reader
    public int read(char[] cbuf, int off, int len) throws IOException {
        if (this.current == null) {
            return -1;
        }
        int result = this.current.read(cbuf, off, len);
        if (result != -1) {
            return result;
        }
        advance();
        return read(cbuf, off, len);
    }

    @Override // java.io.Reader
    public long skip(long n) throws IOException {
        Preconditions.checkArgument(n >= 0, "n is negative");
        if (n <= 0) {
            return 0;
        }
        while (this.current != null) {
            long result = this.current.skip(n);
            if (result > 0) {
                return result;
            }
            advance();
        }
        return 0;
    }

    @Override // java.io.Reader
    public boolean ready() throws IOException {
        return this.current != null && this.current.ready();
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.current != null) {
            try {
                this.current.close();
            } finally {
                this.current = null;
            }
        }
    }
}
