package com.mchange.p006v1.util;

import com.mchange.p009v2.lang.ObjectUtils;

/* renamed from: com.mchange.v1.util.ArrayUtils */
/* loaded from: grasscutter.jar:com/mchange/v1/util/ArrayUtils.class */
public final class ArrayUtils {
    public static int indexOf(Object[] objArr, Object obj) {
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            if (obj.equals(objArr[i])) {
                return i;
            }
        }
        return -1;
    }

    public static int identityIndexOf(Object[] objArr, Object obj) {
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            if (obj == objArr[i]) {
                return i;
            }
        }
        return -1;
    }

    public static boolean startsWith(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        int length2 = bArr2.length;
        if (length < length2) {
            return false;
        }
        for (int i = 0; i < length2; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static int hashArray(Object[] objArr) {
        int length = objArr.length;
        int i = length;
        for (int i2 = 0; i2 < length; i2++) {
            int hashOrZero = ObjectUtils.hashOrZero(objArr[i2]);
            int i3 = i2 % 32;
            i ^= (hashOrZero >>> i3) | (hashOrZero << (32 - i3));
        }
        return i;
    }

    public static int hashArray(int[] iArr) {
        int length = iArr.length;
        int i = length;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = iArr[i2];
            int i4 = i2 % 32;
            i ^= (i3 >>> i4) | (i3 << (32 - i4));
        }
        return i;
    }

    public static int hashOrZeroArray(Object[] objArr) {
        if (objArr == null) {
            return 0;
        }
        return hashArray(objArr);
    }

    public static int hashOrZeroArray(int[] iArr) {
        if (iArr == null) {
            return 0;
        }
        return hashArray(iArr);
    }

    public static String stringifyContents(Object[] objArr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[ ");
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(objArr[i].toString());
        }
        stringBuffer.append(" ]");
        return stringBuffer.toString();
    }

    private static String toString(String[] strArr, int i) {
        StringBuffer stringBuffer = new StringBuffer(i);
        boolean z = true;
        stringBuffer.append('[');
        for (String str : strArr) {
            if (z) {
                z = false;
            } else {
                stringBuffer.append(',');
            }
            stringBuffer.append(str);
        }
        stringBuffer.append(']');
        return stringBuffer.toString();
    }

    public static String toString(boolean[] zArr) {
        String[] strArr = new String[zArr.length];
        int i = 0;
        int length = zArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            String valueOf = String.valueOf(zArr[i2]);
            i += valueOf.length();
            strArr[i2] = valueOf;
        }
        return toString(strArr, i + zArr.length + 1);
    }

    public static String toString(byte[] bArr) {
        String[] strArr = new String[bArr.length];
        int i = 0;
        int length = bArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            String valueOf = String.valueOf((int) bArr[i2]);
            i += valueOf.length();
            strArr[i2] = valueOf;
        }
        return toString(strArr, i + bArr.length + 1);
    }

    public static String toString(char[] cArr) {
        String[] strArr = new String[cArr.length];
        int i = 0;
        int length = cArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            String valueOf = String.valueOf(cArr[i2]);
            i += valueOf.length();
            strArr[i2] = valueOf;
        }
        return toString(strArr, i + cArr.length + 1);
    }

    public static String toString(short[] sArr) {
        String[] strArr = new String[sArr.length];
        int i = 0;
        int length = sArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            String valueOf = String.valueOf((int) sArr[i2]);
            i += valueOf.length();
            strArr[i2] = valueOf;
        }
        return toString(strArr, i + sArr.length + 1);
    }

    public static String toString(int[] iArr) {
        String[] strArr = new String[iArr.length];
        int i = 0;
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            String valueOf = String.valueOf(iArr[i2]);
            i += valueOf.length();
            strArr[i2] = valueOf;
        }
        return toString(strArr, i + iArr.length + 1);
    }

    public static String toString(long[] jArr) {
        String[] strArr = new String[jArr.length];
        int i = 0;
        int length = jArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            String valueOf = String.valueOf(jArr[i2]);
            i += valueOf.length();
            strArr[i2] = valueOf;
        }
        return toString(strArr, i + jArr.length + 1);
    }

    public static String toString(float[] fArr) {
        String[] strArr = new String[fArr.length];
        int i = 0;
        int length = fArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            String valueOf = String.valueOf(fArr[i2]);
            i += valueOf.length();
            strArr[i2] = valueOf;
        }
        return toString(strArr, i + fArr.length + 1);
    }

    public static String toString(double[] dArr) {
        String[] strArr = new String[dArr.length];
        int i = 0;
        int length = dArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            String valueOf = String.valueOf(dArr[i2]);
            i += valueOf.length();
            strArr[i2] = valueOf;
        }
        return toString(strArr, i + dArr.length + 1);
    }

    public static String toString(Object[] objArr) {
        String str;
        String[] strArr = new String[objArr.length];
        int i = 0;
        int length = objArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            Object obj = objArr[i2];
            if (obj instanceof Object[]) {
                str = toString((Object[]) obj);
            } else if (obj instanceof double[]) {
                str = toString((double[]) obj);
            } else if (obj instanceof float[]) {
                str = toString((float[]) obj);
            } else if (obj instanceof long[]) {
                str = toString((long[]) obj);
            } else if (obj instanceof int[]) {
                str = toString((int[]) obj);
            } else if (obj instanceof short[]) {
                str = toString((short[]) obj);
            } else if (obj instanceof char[]) {
                str = toString((char[]) obj);
            } else if (obj instanceof byte[]) {
                str = toString((byte[]) obj);
            } else if (obj instanceof boolean[]) {
                str = toString((boolean[]) obj);
            } else {
                str = String.valueOf(objArr[i2]);
            }
            i += str.length();
            strArr[i2] = str;
        }
        return toString(strArr, i + objArr.length + 1);
    }

    private ArrayUtils() {
    }
}
