package com.mchange.lang;

import java.io.StringWriter;

/* loaded from: grasscutter.jar:com/mchange/lang/CharUtils.class */
public final class CharUtils {
    public static int charFromByteArray(byte[] bArr, int i) {
        return 0 | (ByteUtils.toUnsigned(bArr[i + 0]) << 8) | (ByteUtils.toUnsigned(bArr[i + 1]) << 0);
    }

    public static byte[] byteArrayFromChar(char c) {
        byte[] bArr = new byte[2];
        charIntoByteArray(c, 0, bArr);
        return bArr;
    }

    public static void charIntoByteArray(int i, int i2, byte[] bArr) {
        bArr[i2 + 0] = (byte) ((i >>> 8) & 255);
        bArr[i2 + 1] = (byte) ((i >>> 0) & 255);
    }

    public static String toHexAscii(char c) {
        StringWriter stringWriter = new StringWriter(4);
        ByteUtils.addHexAscii((byte) ((c >>> '\b') & 255), stringWriter);
        ByteUtils.addHexAscii((byte) (c & 255), stringWriter);
        return stringWriter.toString();
    }

    public static char[] fromHexAscii(String str) {
        int length = str.length();
        if (length % 4 != 0) {
            throw new NumberFormatException("Hex ascii must be exactly four digits per char.");
        }
        byte[] fromHexAscii = ByteUtils.fromHexAscii(str);
        int i = length / 4;
        char[] cArr = new char[i];
        int i2 = 0;
        while (length < i) {
            cArr[i2] = (char) charFromByteArray(fromHexAscii, i2 * 2);
            i2++;
        }
        return cArr;
    }

    private CharUtils() {
    }
}
