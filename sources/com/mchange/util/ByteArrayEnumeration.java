package com.mchange.util;

import com.mchange.p005io.IOByteArrayEnumeration;

/* loaded from: grasscutter.jar:com/mchange/util/ByteArrayEnumeration.class */
public interface ByteArrayEnumeration extends MEnumeration, IOByteArrayEnumeration {
    @Override // com.mchange.p005io.IOByteArrayEnumeration
    byte[] nextBytes();

    @Override // com.mchange.p005io.IOByteArrayEnumeration
    boolean hasMoreBytes();
}
