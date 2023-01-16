package com.mchange.p005io.impl;

import com.mchange.p005io.ReadOnlyMemoryFile;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* renamed from: com.mchange.io.impl.LazyReadOnlyMemoryFileImpl */
/* loaded from: grasscutter.jar:com/mchange/io/impl/LazyReadOnlyMemoryFileImpl.class */
public class LazyReadOnlyMemoryFileImpl implements ReadOnlyMemoryFile {
    File file;
    byte[] bytes;
    long last_mod;
    int last_len;

    public LazyReadOnlyMemoryFileImpl(File file) {
        this.bytes = null;
        this.last_mod = -1;
        this.last_len = -1;
        this.file = file;
    }

    public LazyReadOnlyMemoryFileImpl(String str) {
        this(new File(str));
    }

    @Override // com.mchange.p005io.ReadOnlyMemoryFile
    public File getFile() {
        return this.file;
    }

    @Override // com.mchange.p005io.ReadOnlyMemoryFile
    public synchronized byte[] getBytes() throws IOException {
        update();
        return this.bytes;
    }

    void update() throws IOException {
        if (this.file.lastModified() > this.last_mod) {
            if (this.bytes != null) {
                this.last_len = this.bytes.length;
            }
            refreshBytes();
        }
    }

    /* access modifiers changed from: package-private */
    public void refreshBytes() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = this.last_len > 0 ? new ByteArrayOutputStream(2 * this.last_len) : new ByteArrayOutputStream();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(this.file));
        for (int read = bufferedInputStream.read(); read >= 0; read = bufferedInputStream.read()) {
            byteArrayOutputStream.write((byte) read);
        }
        this.bytes = byteArrayOutputStream.toByteArray();
        this.last_mod = this.file.lastModified();
    }
}
