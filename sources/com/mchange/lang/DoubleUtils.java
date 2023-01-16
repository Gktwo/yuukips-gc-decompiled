package com.mchange.lang;

/* loaded from: grasscutter.jar:com/mchange/lang/DoubleUtils.class */
public final class DoubleUtils {
    public static byte[] byteArrayFromDouble(double d) {
        return LongUtils.byteArrayFromLong(Double.doubleToLongBits(d));
    }

    public static double doubleFromByteArray(byte[] bArr, int i) {
        return Double.longBitsToDouble(LongUtils.longFromByteArray(bArr, i));
    }
}
