package emu.grasscutter.utils;

/* loaded from: grasscutter.jar:emu/grasscutter/utils/ByteHelper.class */
public class ByteHelper {
    public static byte[] changeBytes(byte[] a) {
        byte[] b = new byte[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = a[(a.length - i) - 1];
        }
        return b;
    }

    public static byte[] longToBytes(long x) {
        return new byte[]{(byte) ((int) (x >> 56)), (byte) ((int) (x >> 48)), (byte) ((int) (x >> 40)), (byte) ((int) (x >> 32)), (byte) ((int) (x >> 24)), (byte) ((int) (x >> 16)), (byte) ((int) (x >> 8)), (byte) ((int) x)};
    }
}
