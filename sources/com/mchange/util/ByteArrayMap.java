package com.mchange.util;

import com.mchange.p005io.IOByteArrayEnumeration;
import com.mchange.p005io.IOByteArrayMap;

/* loaded from: grasscutter.jar:com/mchange/util/ByteArrayMap.class */
public interface ByteArrayMap extends IOByteArrayMap {
    @Override // com.mchange.p005io.IOByteArrayMap
    byte[] get(byte[] bArr);

    @Override // com.mchange.p005io.IOByteArrayMap
    void put(byte[] bArr, byte[] bArr2);

    @Override // com.mchange.p005io.IOByteArrayMap
    boolean putNoReplace(byte[] bArr, byte[] bArr2);

    @Override // com.mchange.p005io.IOByteArrayMap
    boolean remove(byte[] bArr);

    @Override // com.mchange.p005io.IOByteArrayMap
    boolean containsKey(byte[] bArr);

    @Override // com.mchange.p005io.IOByteArrayMap
    IOByteArrayEnumeration keys();

    ByteArrayEnumeration mkeys();
}
