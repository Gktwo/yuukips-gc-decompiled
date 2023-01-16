package com.mchange.p005io;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/* renamed from: com.mchange.io.StringMemoryFile */
/* loaded from: grasscutter.jar:com/mchange/io/StringMemoryFile.class */
public interface StringMemoryFile extends ReadOnlyMemoryFile {
    String asString() throws IOException;

    String asString(String str) throws IOException, UnsupportedEncodingException;
}
