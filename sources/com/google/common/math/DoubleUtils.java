package com.google.common.math;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;

/* access modifiers changed from: package-private */
@GwtIncompatible
/* loaded from: grasscutter.jar:com/google/common/math/DoubleUtils.class */
public final class DoubleUtils {
    static final long SIGNIFICAND_MASK = 4503599627370495L;
    static final long EXPONENT_MASK = 9218868437227405312L;
    static final long SIGN_MASK = Long.MIN_VALUE;
    static final int SIGNIFICAND_BITS = 52;
    static final int EXPONENT_BIAS = 1023;
    static final long IMPLICIT_BIT = 4503599627370496L;
    @VisibleForTesting
    static final long ONE_BITS = 4607182418800017408L;

    private DoubleUtils() {
    }

    static double nextDown(double d) {
        return -Math.nextUp(-d);
    }

    /* access modifiers changed from: package-private */
    public static long getSignificand(double d) {
        Preconditions.checkArgument(isFinite(d), "not a normal value");
        int exponent = Math.getExponent(d);
        long bits = Double.doubleToRawLongBits(d) & SIGNIFICAND_MASK;
        return exponent == -1023 ? bits << 1 : bits | IMPLICIT_BIT;
    }

    /* access modifiers changed from: package-private */
    public static boolean isFinite(double d) {
        return Math.getExponent(d) <= EXPONENT_BIAS;
    }

    /* access modifiers changed from: package-private */
    public static boolean isNormal(double d) {
        return Math.getExponent(d) >= -1022;
    }

    /* access modifiers changed from: package-private */
    public static double scaleNormalize(double x) {
        return Double.longBitsToDouble((Double.doubleToRawLongBits(x) & SIGNIFICAND_MASK) | ONE_BITS);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [long] */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v33 */
    /* JADX WARN: Type inference failed for: r0v51 */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static double bigToDouble(java.math.BigInteger r7) {
        /*
            r0 = r7
            java.math.BigInteger r0 = r0.abs()
            r8 = r0
            r0 = r8
            int r0 = r0.bitLength()
            r1 = 1
            int r0 = r0 - r1
            r9 = r0
            r0 = r9
            r1 = 63
            if (r0 >= r1) goto L_0x0018
            r0 = r7
            long r0 = r0.longValue()
            double r0 = (double) r0
            return r0
        L_0x0018:
            r0 = r9
            r1 = 1023(0x3ff, float:1.434E-42)
            if (r0 <= r1) goto L_0x0029
            r0 = r7
            int r0 = r0.signum()
            double r0 = (double) r0
            r1 = 9218868437227405312(0x7ff0000000000000, double:Infinity)
            double r0 = r0 * r1
            return r0
        L_0x0029:
            r0 = r9
            r1 = 52
            int r0 = r0 - r1
            r1 = 1
            int r0 = r0 - r1
            r10 = r0
            r0 = r8
            r1 = r10
            java.math.BigInteger r0 = r0.shiftRight(r1)
            long r0 = r0.longValue()
            r11 = r0
            r0 = r11
            r1 = 1
            long r0 = r0 >> r1
            r13 = r0
            r0 = r13
            r1 = 4503599627370495(0xfffffffffffff, double:2.225073858507201E-308)
            long r0 = r0 & r1
            r13 = r0
            r0 = r11
            r1 = 1
            long r0 = r0 & r1
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0066
            r0 = r13
            r1 = 1
            long r0 = r0 & r1
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x0062
            r0 = r8
            int r0 = r0.getLowestSetBit()
            r1 = r10
            if (r0 >= r1) goto L_0x0066
        L_0x0062:
            r0 = 1
            goto L_0x0067
        L_0x0066:
            r0 = 0
        L_0x0067:
            r15 = r0
            r0 = r15
            if (r0 == 0) goto L_0x0075
            r0 = r13
            r1 = 1
            long r0 = r0 + r1
            goto L_0x0077
        L_0x0075:
            r0 = r13
        L_0x0077:
            r16 = r0
            r0 = r9
            r1 = 1023(0x3ff, float:1.434E-42)
            int r0 = r0 + r1
            long r0 = (long) r0
            r1 = 52
            long r0 = r0 << r1
            r18 = r0
            r0 = r18
            r1 = r16
            long r0 = r0 + r1
            r18 = r0
            r0 = r18
            r1 = r7
            int r1 = r1.signum()
            long r1 = (long) r1
            r2 = -9223372036854775808
            long r1 = r1 & r2
            long r0 = r0 | r1
            r18 = r0
            r0 = r18
            double r0 = java.lang.Double.longBitsToDouble(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.math.DoubleUtils.bigToDouble(java.math.BigInteger):double");
    }

    /* access modifiers changed from: package-private */
    public static double ensureNonNegative(double value) {
        Preconditions.checkArgument(!Double.isNaN(value));
        if (value > 0.0d) {
            return value;
        }
        return 0.0d;
    }
}
