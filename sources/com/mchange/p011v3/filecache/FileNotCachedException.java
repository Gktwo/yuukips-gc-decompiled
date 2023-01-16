package com.mchange.p011v3.filecache;

import java.io.FileNotFoundException;

/* renamed from: com.mchange.v3.filecache.FileNotCachedException */
/* loaded from: grasscutter.jar:com/mchange/v3/filecache/FileNotCachedException.class */
public class FileNotCachedException extends FileNotFoundException {
    /* access modifiers changed from: package-private */
    public FileNotCachedException(String str) {
        super(str);
    }

    FileNotCachedException() {
    }
}
