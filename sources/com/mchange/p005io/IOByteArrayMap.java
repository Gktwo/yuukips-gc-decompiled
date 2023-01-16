package com.mchange.p005io;

import java.io.IOException;

/* renamed from: com.mchange.io.IOByteArrayMap */
/* loaded from: grasscutter.jar:com/mchange/io/IOByteArrayMap.class */
public interface IOByteArrayMap {
    byte[] get(byte[] bArr) throws IOException;

    void put(byte[] bArr, byte[] bArr2) throws IOException;

    boolean putNoReplace(byte[] bArr, byte[] bArr2) throws IOException;

    boolean remove(byte[] bArr) throws IOException;

    boolean containsKey(byte[] bArr) throws IOException;

    IOByteArrayEnumeration keys() throws IOException;
}
