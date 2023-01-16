package com.mchange.lang;

/* loaded from: grasscutter.jar:com/mchange/lang/IntegerUtils.class */
public final class IntegerUtils {
    public static final long UNSIGNED_MAX_VALUE = -1;

    public static int parseInt(String str, int i) {
        if (str == null) {
            return i;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return i;
        }
    }

    public static int parseInt(String str, int i, int i2) {
        if (str == null) {
            return i2;
        }
        try {
            return Integer.parseInt(str, i);
        } catch (NumberFormatException e) {
            return i2;
        }
    }

    public static int intFromByteArray(byte[] bArr, int i) {
        return 0 | (ByteUtils.unsignedPromote(bArr[i + 0]) << 24) | (ByteUtils.unsignedPromote(bArr[i + 1]) << 16) | (ByteUtils.unsignedPromote(bArr[i + 2]) << 8) | (ByteUtils.unsignedPromote(bArr[i + 3]) << 0);
    }

    public static byte[] byteArrayFromInt(int i) {
        byte[] bArr = new byte[4];
        intIntoByteArray(i, 0, bArr);
        return bArr;
    }

    public static void intIntoByteArray(int i, int i2, byte[] bArr) {
        bArr[i2 + 0] = (byte) ((i >>> 24) & 255);
        bArr[i2 + 1] = (byte) ((i >>> 16) & 255);
        bArr[i2 + 2] = (byte) ((i >>> 8) & 255);
        bArr[i2 + 3] = (byte) ((i >>> 0) & 255);
    }

    public static int intFromByteArrayLittleEndian(byte[] bArr, int i) {
        return 0 | (ByteUtils.unsignedPromote(bArr[i + 3]) << 24) | (ByteUtils.unsignedPromote(bArr[i + 2]) << 16) | (ByteUtils.unsignedPromote(bArr[i + 1]) << 8) | (ByteUtils.unsignedPromote(bArr[i + 0]) << 0);
    }

    public static void intIntoByteArrayLittleEndian(int i, int i2, byte[] bArr) {
        bArr[i2 + 3] = (byte) ((i >>> 24) & 255);
        bArr[i2 + 2] = (byte) ((i >>> 16) & 255);
        bArr[i2 + 1] = (byte) ((i >>> 8) & 255);
        bArr[i2 + 0] = (byte) ((i >>> 0) & 255);
    }

    public static long toUnsigned(int i) {
        return 4294967295L & ((long) i);
    }

    private IntegerUtils() {
    }
}
