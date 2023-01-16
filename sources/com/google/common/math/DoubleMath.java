package com.google.common.math;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Booleans;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Iterator;

@GwtCompatible(emulated = true)
/* loaded from: grasscutter.jar:com/google/common/math/DoubleMath.class */
public final class DoubleMath {
    private static final double MIN_INT_AS_DOUBLE = -2.147483648E9d;
    private static final double MAX_INT_AS_DOUBLE = 2.147483647E9d;
    private static final double MIN_LONG_AS_DOUBLE = -9.223372036854776E18d;
    private static final double MAX_LONG_AS_DOUBLE_PLUS_ONE = 9.223372036854776E18d;
    @VisibleForTesting
    static final int MAX_FACTORIAL = 170;
    private static final double LN_2 = Math.log(2.0d);
    @VisibleForTesting
    static final double[] everySixteenthFactorial = {1.0d, 2.0922789888E13d, 2.631308369336935E35d, 1.2413915592536073E61d, 1.2688693218588417E89d, 7.156945704626381E118d, 9.916779348709496E149d, 1.974506857221074E182d, 3.856204823625804E215d, 5.5502938327393044E249d, 4.7147236359920616E284d};

    @GwtIncompatible
    static double roundIntermediate(double x, RoundingMode mode) {
        if (!DoubleUtils.isFinite(x)) {
            throw new ArithmeticException("input is infinite or NaN");
        }
        switch (C04991.$SwitchMap$java$math$RoundingMode[mode.ordinal()]) {
            case 1:
                MathPreconditions.checkRoundingUnnecessary(isMathematicalInteger(x));
                return x;
            case 2:
                if (x >= 0.0d || isMathematicalInteger(x)) {
                    return x;
                }
                return (double) (((long) x) - 1);
            case 3:
                if (x <= 0.0d || isMathematicalInteger(x)) {
                    return x;
                }
                return (double) (((long) x) + 1);
            case 4:
                return x;
            case 5:
                if (isMathematicalInteger(x)) {
                    return x;
                }
                return (double) (((long) x) + ((long) (x > 0.0d ? 1 : -1)));
            case 6:
                return Math.rint(x);
            case 7:
                double z = Math.rint(x);
                if (Math.abs(x - z) == 0.5d) {
                    return x + Math.copySign(0.5d, x);
                }
                return z;
            case 8:
                double z2 = Math.rint(x);
                if (Math.abs(x - z2) == 0.5d) {
                    return x;
                }
                return z2;
            default:
                throw new AssertionError();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.google.common.math.DoubleMath$1 */
    /* loaded from: grasscutter.jar:com/google/common/math/DoubleMath$1.class */
    public static /* synthetic */ class C04991 {
        static final /* synthetic */ int[] $SwitchMap$java$math$RoundingMode = new int[RoundingMode.values().length];

        static {
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.FLOOR.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.CEILING.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.DOWN.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.UP.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_EVEN.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_DOWN.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    @GwtIncompatible
    public static int roundToInt(double x, RoundingMode mode) {
        double z = roundIntermediate(x, mode);
        MathPreconditions.checkInRangeForRoundingInputs((z > -2.147483649E9d) & (z < 2.147483648E9d), x, mode);
        return (int) z;
    }

    @GwtIncompatible
    public static long roundToLong(double x, RoundingMode mode) {
        double z = roundIntermediate(x, mode);
        MathPreconditions.checkInRangeForRoundingInputs((MIN_LONG_AS_DOUBLE - z < 1.0d) & (z < MAX_LONG_AS_DOUBLE_PLUS_ONE), x, mode);
        return (long) z;
    }

    @GwtIncompatible
    public static BigInteger roundToBigInteger(double x, RoundingMode mode) {
        double x2 = roundIntermediate(x, mode);
        if ((MIN_LONG_AS_DOUBLE - x2 < 1.0d) && (x2 < MAX_LONG_AS_DOUBLE_PLUS_ONE)) {
            return BigInteger.valueOf((long) x2);
        }
        BigInteger result = BigInteger.valueOf(DoubleUtils.getSignificand(x2)).shiftLeft(Math.getExponent(x2) - 52);
        return x2 < 0.0d ? result.negate() : result;
    }

    @GwtIncompatible
    public static boolean isPowerOfTwo(double x) {
        if (x <= 0.0d || !DoubleUtils.isFinite(x)) {
            return false;
        }
        long significand = DoubleUtils.getSignificand(x);
        return (significand & (significand - 1)) == 0;
    }

    public static double log2(double x) {
        return Math.log(x) / LN_2;
    }

    @GwtIncompatible
    public static int log2(double x, RoundingMode mode) {
        boolean increment;
        Preconditions.checkArgument(x > 0.0d && DoubleUtils.isFinite(x), "x must be positive and finite");
        int exponent = Math.getExponent(x);
        if (!DoubleUtils.isNormal(x)) {
            return log2(x * 4.503599627370496E15d, mode) - 52;
        }
        switch (C04991.$SwitchMap$java$math$RoundingMode[mode.ordinal()]) {
            case 1:
                MathPreconditions.checkRoundingUnnecessary(isPowerOfTwo(x));
            case 2:
                increment = false;
                break;
            case 3:
                increment = !isPowerOfTwo(x);
                break;
            case 4:
                increment = (exponent < 0) & (!isPowerOfTwo(x));
                break;
            case 5:
                increment = (exponent >= 0) & (!isPowerOfTwo(x));
                break;
            case 6:
            case 7:
            case 8:
                double xScaled = DoubleUtils.scaleNormalize(x);
                increment = xScaled * xScaled > 2.0d;
                break;
            default:
                throw new AssertionError();
        }
        return increment ? exponent + 1 : exponent;
    }

    @GwtIncompatible
    public static boolean isMathematicalInteger(double x) {
        return DoubleUtils.isFinite(x) && (x == 0.0d || 52 - Long.numberOfTrailingZeros(DoubleUtils.getSignificand(x)) <= Math.getExponent(x));
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [double] */
    public static double factorial(int n) {
        MathPreconditions.checkNonNegative("n", n);
        if (n > 170) {
            return Double.POSITIVE_INFINITY;
        }
        char c = 0;
        for (int i = 1 + (n & -16); i <= n; i++) {
            c *= (double) i;
        }
        return c * everySixteenthFactorial[n >> 4];
    }

    public static boolean fuzzyEquals(double a, double b, double tolerance) {
        MathPreconditions.checkNonNegative("tolerance", tolerance);
        return Math.copySign(a - b, 1.0d) <= tolerance || a == b || (Double.isNaN(a) && Double.isNaN(b));
    }

    public static int fuzzyCompare(double a, double b, double tolerance) {
        if (fuzzyEquals(a, b, tolerance)) {
            return 0;
        }
        if (a < b) {
            return -1;
        }
        if (a > b) {
            return 1;
        }
        return Booleans.compare(Double.isNaN(a), Double.isNaN(b));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1, types: [double] */
    /* JADX WARN: Type inference failed for: r0v14, types: [long] */
    /* JADX WARN: Type inference failed for: r0v16, types: [double] */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    @com.google.common.annotations.GwtIncompatible
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static double mean(double... r7) {
        /*
            r0 = r7
            int r0 = r0.length
            if (r0 <= 0) goto L_0x0009
            r0 = 1
            goto L_0x000a
        L_0x0009:
            r0 = 0
        L_0x000a:
            java.lang.String r1 = "Cannot take mean of 0 values"
            com.google.common.base.Preconditions.checkArgument(r0, r1)
            r0 = 1
            r8 = r0
            r0 = r7
            r1 = 0
            r0 = r0[r1]
            double r0 = checkFinite(r0)
            r10 = r0
            r0 = 1
            r12 = r0
        L_0x001b:
            r0 = r12
            r1 = r7
            int r1 = r1.length
            if (r0 >= r1) goto L_0x0040
            r0 = r7
            r1 = r12
            r0 = r0[r1]
            double r0 = checkFinite(r0)
            r0 = r8
            r1 = 1
            long r0 = r0 + r1
            r8 = r0
            r0 = r10
            r1 = r7
            r2 = r12
            r1 = r1[r2]
            r2 = r10
            double r1 = r1 - r2
            r2 = r8
            double r2 = (double) r2
            double r1 = r1 / r2
            double r0 = r0 + r1
            r10 = r0
            int r12 = r12 + 1
            goto L_0x001b
        L_0x0040:
            r0 = r10
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.math.DoubleMath.mean(double[]):double");
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [long] */
    @Deprecated
    public static double mean(int... values) {
        Preconditions.checkArgument(values.length > 0, "Cannot take mean of 0 values");
        char c = 0;
        for (int i : values) {
            c += (long) i;
        }
        return ((double) c) / ((double) values.length);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1, types: [double] */
    /* JADX WARN: Type inference failed for: r0v11, types: [long] */
    /* JADX WARN: Type inference failed for: r0v13, types: [double] */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static double mean(long... r7) {
        /*
            r0 = r7
            int r0 = r0.length
            if (r0 <= 0) goto L_0x0009
            r0 = 1
            goto L_0x000a
        L_0x0009:
            r0 = 0
        L_0x000a:
            java.lang.String r1 = "Cannot take mean of 0 values"
            com.google.common.base.Preconditions.checkArgument(r0, r1)
            r0 = 1
            r8 = r0
            r0 = r7
            r1 = 0
            r0 = r0[r1]
            double r0 = (double) r0
            r10 = r0
            r0 = 1
            r12 = r0
        L_0x0019:
            r0 = r12
            r1 = r7
            int r1 = r1.length
            if (r0 >= r1) goto L_0x0037
            r0 = r8
            r1 = 1
            long r0 = r0 + r1
            r8 = r0
            r0 = r10
            r1 = r7
            r2 = r12
            r1 = r1[r2]
            double r1 = (double) r1
            r2 = r10
            double r1 = r1 - r2
            r2 = r8
            double r2 = (double) r2
            double r1 = r1 / r2
            double r0 = r0 + r1
            r10 = r0
            int r12 = r12 + 1
            goto L_0x0019
        L_0x0037:
            r0 = r10
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.math.DoubleMath.mean(long[]):double");
    }

    @GwtIncompatible
    @Deprecated
    public static double mean(Iterable<? extends Number> values) {
        return mean(values.iterator());
    }

    /* JADX WARN: Type inference failed for: r0v18, types: [long] */
    @GwtIncompatible
    @Deprecated
    public static double mean(Iterator<? extends Number> values) {
        Preconditions.checkArgument(values.hasNext(), "Cannot take mean of 0 values");
        char c = 1;
        double mean = checkFinite(((Number) values.next()).doubleValue());
        while (values.hasNext()) {
            c++;
            mean += (checkFinite(((Number) values.next()).doubleValue()) - mean) / ((double) c);
        }
        return mean;
    }

    @CanIgnoreReturnValue
    @GwtIncompatible
    private static double checkFinite(double argument) {
        Preconditions.checkArgument(DoubleUtils.isFinite(argument));
        return argument;
    }

    private DoubleMath() {
    }
}
