package com.mchange.p005io;

import java.io.File;
import java.io.IOException;

/* renamed from: com.mchange.io.ReadOnlyMemoryFile */
/* loaded from: grasscutter.jar:com/mchange/io/ReadOnlyMemoryFile.class */
public interface ReadOnlyMemoryFile {
    File getFile() throws IOException;

    byte[] getBytes() throws IOException;
}
