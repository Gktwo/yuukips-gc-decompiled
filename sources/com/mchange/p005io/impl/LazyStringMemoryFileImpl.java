package com.mchange.p005io.impl;

import com.mchange.p005io.StringMemoryFile;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/* renamed from: com.mchange.io.impl.LazyStringMemoryFileImpl */
/* loaded from: grasscutter.jar:com/mchange/io/impl/LazyStringMemoryFileImpl.class */
public class LazyStringMemoryFileImpl extends LazyReadOnlyMemoryFileImpl implements StringMemoryFile {
    private static final String DEFAULT_ENCODING;
    String encoding = null;
    String string = null;

    static {
        String property = System.getProperty("file.encoding");
        DEFAULT_ENCODING = property == null ? "8859_1" : property;
    }

    public LazyStringMemoryFileImpl(File file) {
        super(file);
    }

    public LazyStringMemoryFileImpl(String str) {
        super(str);
    }

    @Override // com.mchange.p005io.StringMemoryFile
    public synchronized String asString(String str) throws IOException, UnsupportedEncodingException {
        update();
        if (this.encoding != str) {
            this.string = new String(this.bytes, str);
        }
        return this.string;
    }

    @Override // com.mchange.p005io.StringMemoryFile
    public String asString() throws IOException {
        try {
            return asString(DEFAULT_ENCODING);
        } catch (UnsupportedEncodingException e) {
            throw new InternalError("Default Encoding is not supported?!");
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.mchange.p005io.impl.LazyReadOnlyMemoryFileImpl
    public void refreshBytes() throws IOException {
        refreshBytes();
        this.string = null;
        this.encoding = null;
    }
}
