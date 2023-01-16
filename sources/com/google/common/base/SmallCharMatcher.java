package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.CharMatcher;
import java.util.BitSet;

@GwtIncompatible
/* loaded from: grasscutter.jar:com/google/common/base/SmallCharMatcher.class */
final class SmallCharMatcher extends CharMatcher.NamedFastMatcher {
    static final int MAX_SIZE = 1023;
    private final char[] table;
    private final boolean containsZero;
    private final long filter;

    /* renamed from: C1 */
    private static final int f262C1 = -862048943;

    /* renamed from: C2 */
    private static final int f263C2 = 461845907;
    private static final double DESIRED_LOAD_FACTOR = 0.5d;

    private SmallCharMatcher(char[] table, long filter, boolean containsZero, String description) {
        super(description);
        this.table = table;
        this.filter = filter;
        this.containsZero = containsZero;
    }

    static int smear(int hashCode) {
        return f263C2 * Integer.rotateLeft(hashCode * f262C1, 15);
    }

    private boolean checkFilter(int c) {
        return 1 == (1 & (this.filter >> c));
    }

    @VisibleForTesting
    static int chooseTableSize(int setSize) {
        if (setSize == 1) {
            return 2;
        }
        int highestOneBit = Integer.highestOneBit(setSize - 1);
        while (true) {
            int tableSize = highestOneBit << 1;
            if (((double) tableSize) * DESIRED_LOAD_FACTOR >= ((double) setSize)) {
                return tableSize;
            }
            highestOneBit = tableSize;
        }
    }

    /* JADX WARN: Type inference failed for: r0v17, types: [long] */
    /* access modifiers changed from: package-private */
    public static CharMatcher from(BitSet chars, String description) {
        int index;
        char c = 0;
        int size = chars.cardinality();
        boolean containsZero = chars.get(0);
        char[] table = new char[chooseTableSize(size)];
        int mask = table.length - 1;
        int c2 = chars.nextSetBit(0);
        while (c2 != -1) {
            c |= 1 << c2;
            int smear = smear(c2);
            while (true) {
                index = smear & mask;
                if (table[index] == 0) {
                    break;
                }
                smear = index + 1;
            }
            table[index] = (char) c2;
            c2 = chars.nextSetBit(c2 + 1);
        }
        return new SmallCharMatcher(table, c, containsZero, description);
    }

    @Override // com.google.common.base.CharMatcher
    public boolean matches(char c) {
        if (c == 0) {
            return this.containsZero;
        }
        if (!checkFilter(c)) {
            return false;
        }
        int mask = this.table.length - 1;
        int startingIndex = smear(c) & mask;
        int index = startingIndex;
        while (this.table[index] != 0) {
            if (this.table[index] == c) {
                return true;
            }
            index = (index + 1) & mask;
            if (index == startingIndex) {
                return false;
            }
        }
        return false;
    }

    @Override // com.google.common.base.CharMatcher
    void setBits(BitSet table) {
        if (this.containsZero) {
            table.set(0);
        }
        char[] cArr = this.table;
        for (char c : cArr) {
            if (c != 0) {
                table.set(c);
            }
        }
    }
}
