package com.mchange.p009v2.util;

/* renamed from: com.mchange.v2.util.XORShiftRandomUtils */
/* loaded from: grasscutter.jar:com/mchange/v2/util/XORShiftRandomUtils.class */
public final class XORShiftRandomUtils {
    public static long nextLong(long j) {
        long j2 = j ^ (j << 21);
        long j3 = j2 ^ (j2 >>> 35);
        return j3 ^ (j3 << 4);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [long] */
    /* JADX WARN: Type inference failed for: r0v13, types: [long] */
    public static void main(String[] strArr) {
        char currentTimeMillis = System.currentTimeMillis();
        int[] iArr = new int[100];
        for (int i = 0; i < 1000000; i++) {
            currentTimeMillis = nextLong(currentTimeMillis);
            int abs = (int) (Math.abs((long) currentTimeMillis) % ((long) 100));
            iArr[abs] = iArr[abs] + 1;
            if (i % 10000 == 0) {
                System.out.println((long) currentTimeMillis);
            }
        }
        for (int i2 = 0; i2 < 100; i2++) {
            if (i2 != 0) {
                System.out.print(", ");
            }
            System.out.print(i2 + " -> " + iArr[i2]);
        }
        System.out.println();
    }
}
