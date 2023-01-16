package com.mchange.p005io;

import java.io.IOException;

/* renamed from: com.mchange.io.IOByteArrayEnumeration */
/* loaded from: grasscutter.jar:com/mchange/io/IOByteArrayEnumeration.class */
public interface IOByteArrayEnumeration extends IOEnumeration {
    byte[] nextBytes() throws IOException;

    boolean hasMoreBytes() throws IOException;

    @Override // com.mchange.p005io.IOEnumeration
    Object nextElement() throws IOException;

    @Override // com.mchange.p005io.IOEnumeration
    boolean hasMoreElements() throws IOException;
}
