package com.mchange.lang;

/* loaded from: grasscutter.jar:com/mchange/lang/ArrayUtils.class */
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

    public static int hashAll(Object[] objArr) {
        int i = 0;
        for (Object obj : objArr) {
            if (obj != null) {
                i ^= obj.hashCode();
            }
        }
        return i;
    }

    public static int hashAll(int[] iArr) {
        int i = 0;
        for (int i2 : iArr) {
            i ^= i2;
        }
        return i;
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

    private ArrayUtils() {
    }
}
