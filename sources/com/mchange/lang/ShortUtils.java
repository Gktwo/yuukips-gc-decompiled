package com.mchange.lang;

/* loaded from: grasscutter.jar:com/mchange/lang/ShortUtils.class */
public class ShortUtils {
    public static final int UNSIGNED_MAX_VALUE = 65535;

    public static short shortFromByteArray(byte[] bArr, int i) {
        return (short) (0 | (ByteUtils.toUnsigned(bArr[i + 0]) << 8) | (ByteUtils.toUnsigned(bArr[i + 1]) << 0));
    }

    public static byte[] byteArrayFromShort(short s) {
        byte[] bArr = new byte[2];
        shortIntoByteArray(s, 0, bArr);
        return bArr;
    }

    public static void shortIntoByteArray(short s, int i, byte[] bArr) {
        bArr[i + 0] = (byte) ((s >>> 8) & 255);
        bArr[i + 1] = (byte) ((s >>> 0) & 255);
    }

    public static int toUnsigned(short s) {
        return s < 0 ? 65536 + s : s;
    }

    private ShortUtils() {
    }
}
