package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;

/* access modifiers changed from: package-private */
@GwtCompatible
/* loaded from: grasscutter.jar:com/google/common/collect/Hashing.class */
public final class Hashing {

    /* renamed from: C1 */
    private static final long f281C1 = -862048943;

    /* renamed from: C2 */
    private static final long f282C2 = 461845907;
    private static final int MAX_TABLE_SIZE = 1073741824;

    private Hashing() {
    }

    /* access modifiers changed from: package-private */
    public static int smear(int hashCode) {
        return (int) (f282C2 * ((long) Integer.rotateLeft((int) (((long) hashCode) * f281C1), 15)));
    }

    /* access modifiers changed from: package-private */
    public static int smearedHash(Object o) {
        return smear(o == null ? 0 : o.hashCode());
    }

    /* access modifiers changed from: package-private */
    public static int closedTableSize(int expectedEntries, double loadFactor) {
        int expectedEntries2 = Math.max(expectedEntries, 2);
        int tableSize = Integer.highestOneBit(expectedEntries2);
        if (expectedEntries2 <= ((int) (loadFactor * ((double) tableSize)))) {
            return tableSize;
        }
        int tableSize2 = tableSize << 1;
        if (tableSize2 > 0) {
            return tableSize2;
        }
        return 1073741824;
    }

    /* access modifiers changed from: package-private */
    public static boolean needsResizing(int size, int tableSize, double loadFactor) {
        return ((double) size) > loadFactor * ((double) tableSize) && tableSize < 1073741824;
    }
}
