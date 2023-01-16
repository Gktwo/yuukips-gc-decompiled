package com.mchange.lang;

/* loaded from: grasscutter.jar:com/mchange/lang/LongUtils.class */
public class LongUtils {
    private LongUtils() {
    }

    public static long longFromByteArray(byte[] bArr, int i) {
        return 0 | (((long) ByteUtils.toUnsigned(bArr[i + 0])) << 56) | (((long) ByteUtils.toUnsigned(bArr[i + 1])) << 48) | (((long) ByteUtils.toUnsigned(bArr[i + 2])) << 40) | (((long) ByteUtils.toUnsigned(bArr[i + 3])) << 32) | (((long) ByteUtils.toUnsigned(bArr[i + 4])) << 24) | (((long) ByteUtils.toUnsigned(bArr[i + 5])) << 16) | (((long) ByteUtils.toUnsigned(bArr[i + 6])) << 8) | (((long) ByteUtils.toUnsigned(bArr[i + 7])) << 0);
    }

    public static byte[] byteArrayFromLong(long j) {
        byte[] bArr = new byte[8];
        longIntoByteArray(j, 0, bArr);
        return bArr;
    }

    public static void longIntoByteArray(long j, int i, byte[] bArr) {
        bArr[i + 0] = (byte) ((int) ((j >>> 56) & 255));
        bArr[i + 1] = (byte) ((int) ((j >>> 48) & 255));
        bArr[i + 2] = (byte) ((int) ((j >>> 40) & 255));
        bArr[i + 3] = (byte) ((int) ((j >>> 32) & 255));
        bArr[i + 4] = (byte) ((int) ((j >>> 24) & 255));
        bArr[i + 5] = (byte) ((int) ((j >>> 16) & 255));
        bArr[i + 6] = (byte) ((int) ((j >>> 8) & 255));
        bArr[i + 7] = (byte) ((int) ((j >>> 0) & 255));
    }

    public static long longFromByteArrayLittleEndian(byte[] bArr, int i) {
        return 0 | (((long) ByteUtils.toUnsigned(bArr[i + 7])) << 56) | (((long) ByteUtils.toUnsigned(bArr[i + 6])) << 48) | (((long) ByteUtils.toUnsigned(bArr[i + 5])) << 40) | (((long) ByteUtils.toUnsigned(bArr[i + 4])) << 32) | (((long) ByteUtils.toUnsigned(bArr[i + 3])) << 24) | (((long) ByteUtils.toUnsigned(bArr[i + 2])) << 16) | (((long) ByteUtils.toUnsigned(bArr[i + 1])) << 8) | (((long) ByteUtils.toUnsigned(bArr[i + 0])) << 0);
    }

    public static void longIntoByteArrayLittleEndian(long j, int i, byte[] bArr) {
        bArr[i + 7] = (byte) ((int) ((j >>> 56) & 255));
        bArr[i + 6] = (byte) ((int) ((j >>> 48) & 255));
        bArr[i + 5] = (byte) ((int) ((j >>> 40) & 255));
        bArr[i + 4] = (byte) ((int) ((j >>> 32) & 255));
        bArr[i + 3] = (byte) ((int) ((j >>> 24) & 255));
        bArr[i + 2] = (byte) ((int) ((j >>> 16) & 255));
        bArr[i + 1] = (byte) ((int) ((j >>> 8) & 255));
        bArr[i + 0] = (byte) ((int) ((j >>> 0) & 255));
    }

    public static int fullHashLong(long j) {
        return hashLong(j);
    }

    public static int hashLong(long j) {
        return ((int) j) ^ ((int) (j >>> 32));
    }
}
