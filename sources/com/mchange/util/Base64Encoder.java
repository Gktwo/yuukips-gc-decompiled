package com.mchange.util;

/* loaded from: grasscutter.jar:com/mchange/util/Base64Encoder.class */
public interface Base64Encoder {
    String encode(byte[] bArr);

    byte[] decode(String str) throws Base64FormatException;
}
