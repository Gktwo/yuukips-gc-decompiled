package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import kotlin.jvm.internal.LongCompanionObject;

@Beta
@GwtCompatible
/* loaded from: grasscutter.jar:com/google/common/primitives/UnsignedLongs.class */
public final class UnsignedLongs {
    public static final long MAX_VALUE = -1;

    private UnsignedLongs() {
    }

    private static long flip(long a) {
        return a ^ Long.MIN_VALUE;
    }

    public static int compare(long a, long b) {
        return Longs.compare(flip(a), flip(b));
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:17:0x002e */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1, types: [long] */
    /* JADX WARN: Type inference failed for: r0v12, types: [long] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long min(long... r5) {
        /*
            r0 = r5
            int r0 = r0.length
            if (r0 <= 0) goto L_0x0009
            r0 = 1
            goto L_0x000a
        L_0x0009:
            r0 = 0
        L_0x000a:
            com.google.common.base.Preconditions.checkArgument(r0)
            r0 = r5
            r1 = 0
            r0 = r0[r1]
            long r0 = flip(r0)
            r6 = r0
            r0 = 1
            r8 = r0
        L_0x0016:
            r0 = r8
            r1 = r5
            int r1 = r1.length
            if (r0 >= r1) goto L_0x0034
            r0 = r5
            r1 = r8
            r0 = r0[r1]
            long r0 = flip(r0)
            r9 = r0
            r0 = r9
            r1 = r6
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x002e
            r0 = r9
            r6 = r0
        L_0x002e:
            int r8 = r8 + 1
            goto L_0x0016
        L_0x0034:
            r0 = r6
            long r0 = flip(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.primitives.UnsignedLongs.min(long[]):long");
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:17:0x002e */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1, types: [long] */
    /* JADX WARN: Type inference failed for: r0v12, types: [long] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long max(long... r5) {
        /*
            r0 = r5
            int r0 = r0.length
            if (r0 <= 0) goto L_0x0009
            r0 = 1
            goto L_0x000a
        L_0x0009:
            r0 = 0
        L_0x000a:
            com.google.common.base.Preconditions.checkArgument(r0)
            r0 = r5
            r1 = 0
            r0 = r0[r1]
            long r0 = flip(r0)
            r6 = r0
            r0 = 1
            r8 = r0
        L_0x0016:
            r0 = r8
            r1 = r5
            int r1 = r1.length
            if (r0 >= r1) goto L_0x0034
            r0 = r5
            r1 = r8
            r0 = r0[r1]
            long r0 = flip(r0)
            r9 = r0
            r0 = r9
            r1 = r6
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x002e
            r0 = r9
            r6 = r0
        L_0x002e:
            int r8 = r8 + 1
            goto L_0x0016
        L_0x0034:
            r0 = r6
            long r0 = flip(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.primitives.UnsignedLongs.max(long[]):long");
    }

    public static String join(String separator, long... array) {
        Preconditions.checkNotNull(separator);
        if (array.length == 0) {
            return "";
        }
        StringBuilder builder = new StringBuilder(array.length * 5);
        builder.append(toString(array[0]));
        for (int i = 1; i < array.length; i++) {
            builder.append(separator).append(toString(array[i]));
        }
        return builder.toString();
    }

    public static Comparator<long[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    /* loaded from: grasscutter.jar:com/google/common/primitives/UnsignedLongs$LexicographicalComparator.class */
    enum LexicographicalComparator implements Comparator<long[]> {
        INSTANCE;

        public int compare(long[] left, long[] right) {
            int minLength = Math.min(left.length, right.length);
            for (int i = 0; i < minLength; i++) {
                if (left[i] != right[i]) {
                    return UnsignedLongs.compare(left[i], right[i]);
                }
            }
            return left.length - right.length;
        }

        @Override // java.lang.Enum, java.lang.Object
        public String toString() {
            return "UnsignedLongs.lexicographicalComparator()";
        }
    }

    public static void sort(long[] array) {
        Preconditions.checkNotNull(array);
        sort(array, 0, array.length);
    }

    public static void sort(long[] array, int fromIndex, int toIndex) {
        Preconditions.checkNotNull(array);
        Preconditions.checkPositionIndexes(fromIndex, toIndex, array.length);
        for (int i = fromIndex; i < toIndex; i++) {
            array[i] = flip(array[i]);
        }
        Arrays.sort(array, fromIndex, toIndex);
        for (int i2 = fromIndex; i2 < toIndex; i2++) {
            array[i2] = flip(array[i2]);
        }
    }

    public static void sortDescending(long[] array) {
        Preconditions.checkNotNull(array);
        sortDescending(array, 0, array.length);
    }

    public static void sortDescending(long[] array, int fromIndex, int toIndex) {
        Preconditions.checkNotNull(array);
        Preconditions.checkPositionIndexes(fromIndex, toIndex, array.length);
        for (int i = fromIndex; i < toIndex; i++) {
            array[i] = array[i] ^ LongCompanionObject.MAX_VALUE;
        }
        Arrays.sort(array, fromIndex, toIndex);
        for (int i2 = fromIndex; i2 < toIndex; i2++) {
            array[i2] = array[i2] ^ LongCompanionObject.MAX_VALUE;
        }
    }

    public static long divide(long dividend, long divisor) {
        if (divisor < 0) {
            if (compare(dividend, divisor) < 0) {
                return 0;
            }
            return 1;
        } else if (dividend >= 0) {
            return dividend / divisor;
        } else {
            long quotient = ((dividend >>> 1) / divisor) << 1;
            return quotient + ((long) (compare(dividend - (quotient * divisor), divisor) >= 0 ? 1 : 0));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    public static long remainder(long dividend, long divisor) {
        if (divisor < 0) {
            if (compare(dividend, divisor) < 0) {
                return dividend;
            }
            return dividend - divisor;
        } else if (dividend >= 0) {
            return dividend % divisor;
        } else {
            long rem = dividend - ((((dividend >>> 1) / divisor) << 1) * divisor);
            return rem - ((compare(rem, divisor) >= 0 ? divisor : 0) == true ? 1 : 0);
        }
    }

    @CanIgnoreReturnValue
    public static long parseUnsignedLong(String string) {
        return parseUnsignedLong(string, 10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [long] */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long parseUnsignedLong(java.lang.String r5, int r6) {
        /*
            r0 = r5
            java.lang.Object r0 = com.google.common.base.Preconditions.checkNotNull(r0)
            r0 = r5
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0016
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            r1 = r0
            java.lang.String r2 = "empty string"
            r1.<init>(r2)
            throw r0
        L_0x0016:
            r0 = r6
            r1 = 2
            if (r0 < r1) goto L_0x0021
            r0 = r6
            r1 = 36
            if (r0 <= r1) goto L_0x003c
        L_0x0021:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            r1 = r0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = r2
            r3.<init>()
            java.lang.String r3 = "illegal radix: "
            java.lang.StringBuilder r2 = r2.append(r3)
            r3 = r6
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r0
        L_0x003c:
            int[] r0 = com.google.common.primitives.UnsignedLongs.ParseOverflowDetection.maxSafeDigits
            r1 = r6
            r0 = r0[r1]
            r1 = 1
            int r0 = r0 - r1
            r7 = r0
            r0 = 0
            r8 = r0
            r0 = 0
            r10 = r0
        L_0x0049:
            r0 = r10
            r1 = r5
            int r1 = r1.length()
            if (r0 >= r1) goto L_0x00a7
            r0 = r5
            r1 = r10
            char r0 = r0.charAt(r1)
            r1 = r6
            int r0 = java.lang.Character.digit(r0, r1)
            r11 = r0
            r0 = r11
            r1 = -1
            if (r0 != r1) goto L_0x006d
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            r1 = r0
            r2 = r5
            r1.<init>(r2)
            throw r0
        L_0x006d:
            r0 = r10
            r1 = r7
            if (r0 <= r1) goto L_0x0098
            r0 = r8
            r1 = r11
            r2 = r6
            boolean r0 = com.google.common.primitives.UnsignedLongs.ParseOverflowDetection.overflowInParse(r0, r1, r2)
            if (r0 == 0) goto L_0x0098
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            r1 = r0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = r2
            r3.<init>()
            java.lang.String r3 = "Too large for unsigned long: "
            java.lang.StringBuilder r2 = r2.append(r3)
            r3 = r5
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r0
        L_0x0098:
            r0 = r8
            r1 = r6
            long r1 = (long) r1
            long r0 = r0 * r1
            r1 = r11
            long r1 = (long) r1
            long r0 = r0 + r1
            r8 = r0
            int r10 = r10 + 1
            goto L_0x0049
        L_0x00a7:
            r0 = r8
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.primitives.UnsignedLongs.parseUnsignedLong(java.lang.String, int):long");
    }

    @CanIgnoreReturnValue
    public static long decode(String stringValue) {
        ParseRequest request = ParseRequest.fromString(stringValue);
        try {
            return parseUnsignedLong(request.rawValue, request.radix);
        } catch (NumberFormatException e) {
            NumberFormatException decodeException = new NumberFormatException("Error parsing value: " + stringValue);
            decodeException.initCause(e);
            throw decodeException;
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/common/primitives/UnsignedLongs$ParseOverflowDetection.class */
    public static final class ParseOverflowDetection {
        static final long[] maxValueDivs = new long[37];
        static final int[] maxValueMods = new int[37];
        static final int[] maxSafeDigits = new int[37];

        private ParseOverflowDetection() {
        }

        static {
            BigInteger overflow = new BigInteger("10000000000000000", 16);
            for (int i = 2; i <= 36; i++) {
                maxValueDivs[i] = UnsignedLongs.divide(-1, (long) i);
                maxValueMods[i] = (int) UnsignedLongs.remainder(-1, (long) i);
                maxSafeDigits[i] = overflow.toString(i).length() - 1;
            }
        }

        static boolean overflowInParse(long current, int digit, int radix) {
            if (current < 0) {
                return true;
            }
            if (current < maxValueDivs[radix]) {
                return false;
            }
            return current > maxValueDivs[radix] || digit > maxValueMods[radix];
        }
    }

    public static String toString(long x) {
        return toString(x, 10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19, types: [long] */
    /* JADX WARN: Type inference failed for: r0v26, types: [long] */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r0v36, types: [long] */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r0v46 */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String toString(long r7, int r9) {
        /*
        // Method dump skipped, instructions count: 200
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.primitives.UnsignedLongs.toString(long, int):java.lang.String");
    }
}
