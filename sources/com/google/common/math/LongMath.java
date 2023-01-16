package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.primitives.UnsignedLongs;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.RetcodeOuterClass;
import java.math.RoundingMode;
import kotlin.jvm.internal.LongCompanionObject;
import okhttp3.internal.connection.RealConnection;
import p001ch.qos.logback.core.spi.AbstractComponentTracker;

@GwtCompatible(emulated = true)
/* loaded from: grasscutter.jar:com/google/common/math/LongMath.class */
public final class LongMath {
    @VisibleForTesting
    static final long MAX_SIGNED_POWER_OF_TWO = 4611686018427387904L;
    @VisibleForTesting
    static final long MAX_POWER_OF_SQRT2_UNSIGNED = -5402926248376769404L;
    @VisibleForTesting
    static final long FLOOR_SQRT_MAX_LONG = 3037000499L;
    private static final int SIEVE_30 = -545925251;
    @VisibleForTesting
    static final byte[] maxLog10ForLeadingZeros = {19, 18, 18, 18, 18, 17, 17, 17, 16, 16, 16, 15, 15, 15, 15, 14, 14, 14, 13, 13, 13, 12, 12, 12, 12, 11, 11, 11, 10, 10, 10, 9, 9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0};
    @VisibleForTesting
    @GwtIncompatible
    static final long[] powersOf10 = {1, 10, 100, 1000, AbstractComponentTracker.LINGERING_TIMEOUT, 100000, 1000000, 10000000, 100000000, 1000000000, RealConnection.IDLE_CONNECTION_HEALTHY_NS, 100000000000L, 1000000000000L, 10000000000000L, 100000000000000L, 1000000000000000L, 10000000000000000L, 100000000000000000L, 1000000000000000000L};
    @VisibleForTesting
    @GwtIncompatible
    static final long[] halfPowersOf10 = {3, 31, 316, 3162, 31622, 316227, 3162277, 31622776, 316227766, 3162277660L, 31622776601L, 316227766016L, 3162277660168L, 31622776601683L, 316227766016837L, 3162277660168379L, 31622776601683793L, 316227766016837933L, 3162277660168379331L};
    static final long[] factorials = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600, 6227020800L, 87178291200L, 1307674368000L, 20922789888000L, 355687428096000L, 6402373705728000L, 121645100408832000L, 2432902008176640000L};
    static final int[] biggestBinomials = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 3810779, 121977, 16175, 4337, 1733, 887, 534, 361, PacketOpcodes.SealBattleProgressNotify, 206, 169, 143, 125, 111, 101, 94, 88, 83, 79, 76, 74, 72, 70, 69, 68, 67, 67, 66, 66, 66, 66};
    @VisibleForTesting
    static final int[] biggestSimpleBinomials = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 2642246, 86251, 11724, 3218, RetcodeOuterClass.Retcode.RET_MAIL_SCOIN_EXCEED_LIMIT_VALUE, RetcodeOuterClass.Retcode.RET_INVALID_WIDGET_MATERIAL_ID_VALUE, PacketOpcodes.FinishedParentQuestNotify, 287, PacketOpcodes.SetSceneWeatherAreaReq, 169, 139, 119, 105, 95, 87, 81, 76, 73, 70, 68, 66, 64, 63, 62, 62, 61, 61, 61};
    private static final long[][] millerRabinBaseSets = {new long[]{291830, 126401071349994536L}, new long[]{885594168, 725270293939359937L, 3569819667048198375L}, new long[]{273919523040L, 15, 7363882082L, 992620450144556L}, new long[]{47636622961200L, 2, 2570940, 211991001, 3749873356L}, new long[]{7999252175582850L, 2, 4130806001517L, 149795463772692060L, 186635894390467037L, 3967304179347715805L}, new long[]{585226005592931976L, 2, 123635709730000L, 9233062284813009L, 43835965440333360L, 761179012939631437L, 1263739024124850375L}, new long[]{LongCompanionObject.MAX_VALUE, 2, 325, 9375, 28178, 450775, 9780504, 1795265022}};

    @Beta
    public static long ceilingPowerOfTwo(long x) {
        MathPreconditions.checkPositive("x", x);
        if (x <= 4611686018427387904L) {
            return 1 << (-Long.numberOfLeadingZeros(x - 1));
        }
        throw new ArithmeticException("ceilingPowerOfTwo(" + x + ") is not representable as a long");
    }

    @Beta
    public static long floorPowerOfTwo(long x) {
        MathPreconditions.checkPositive("x", x);
        return 1 << (63 - Long.numberOfLeadingZeros(x));
    }

    public static boolean isPowerOfTwo(long x) {
        return (x > 0) & ((x & (x - 1)) == 0);
    }

    @VisibleForTesting
    static int lessThanBranchFree(long x, long y) {
        return (int) ((((x - y) ^ -1) ^ -1) >>> 63);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.google.common.math.LongMath$1 */
    /* loaded from: grasscutter.jar:com/google/common/math/LongMath$1.class */
    public static /* synthetic */ class C05021 {
        static final /* synthetic */ int[] $SwitchMap$java$math$RoundingMode = new int[RoundingMode.values().length];

        static {
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.FLOOR.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.UP.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.CEILING.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_DOWN.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_EVEN.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static int log2(long x, RoundingMode mode) {
        MathPreconditions.checkPositive("x", x);
        switch (C05021.$SwitchMap$java$math$RoundingMode[mode.ordinal()]) {
            case 1:
                MathPreconditions.checkRoundingUnnecessary(isPowerOfTwo(x));
                break;
            case 2:
            case 3:
                break;
            case 4:
            case 5:
                return 64 - Long.numberOfLeadingZeros(x - 1);
            case 6:
            case 7:
            case 8:
                int leadingZeros = Long.numberOfLeadingZeros(x);
                return (63 - leadingZeros) + lessThanBranchFree(MAX_POWER_OF_SQRT2_UNSIGNED >>> leadingZeros, x);
            default:
                throw new AssertionError("impossible");
        }
        return 63 - Long.numberOfLeadingZeros(x);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @GwtIncompatible
    public static int log10(long x, RoundingMode mode) {
        MathPreconditions.checkPositive("x", x);
        int logFloor = log10Floor(x);
        long floorPow = powersOf10[logFloor];
        switch (C05021.$SwitchMap$java$math$RoundingMode[mode.ordinal()]) {
            case 1:
                MathPreconditions.checkRoundingUnnecessary(x == floorPow);
                break;
            case 2:
            case 3:
                break;
            case 4:
            case 5:
                return logFloor + lessThanBranchFree(floorPow, x);
            case 6:
            case 7:
            case 8:
                return logFloor + lessThanBranchFree(halfPowersOf10[logFloor], x);
            default:
                throw new AssertionError();
        }
        return logFloor;
    }

    @GwtIncompatible
    static int log10Floor(long x) {
        byte b = maxLog10ForLeadingZeros[Long.numberOfLeadingZeros(x)];
        return b - lessThanBranchFree(x, powersOf10[b]);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:45:0x00b6 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1, types: [long] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r0v10, types: [long] */
    /* JADX WARN: Type inference failed for: r0v12, types: [long] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARNING: Unknown variable types count: 1 */
    @com.google.common.annotations.GwtIncompatible
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long pow(long r5, int r7) {
        /*
            java.lang.String r0 = "exponent"
            r1 = r7
            int r0 = com.google.common.math.MathPreconditions.checkNonNegative(r0, r1)
            r0 = -2
            r1 = r5
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L_0x0085
            r0 = r5
            r1 = 2
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L_0x0085
            r0 = r5
            int r0 = (int) r0
            switch(r0) {
                case -2: goto L_0x0064;
                case -1: goto L_0x0048;
                case 0: goto L_0x003c;
                case 1: goto L_0x0046;
                case 2: goto L_0x0056;
                default: goto L_0x007d;
            }
        L_0x003c:
            r0 = r7
            if (r0 != 0) goto L_0x0044
            r0 = 1
            goto L_0x0045
        L_0x0044:
            r0 = 0
        L_0x0045:
            return r0
        L_0x0046:
            r0 = 1
            return r0
        L_0x0048:
            r0 = r7
            r1 = 1
            r0 = r0 & r1
            if (r0 != 0) goto L_0x0052
            r0 = 1
            goto L_0x0055
        L_0x0052:
            r0 = -1
        L_0x0055:
            return r0
        L_0x0056:
            r0 = r7
            r1 = 64
            if (r0 >= r1) goto L_0x0062
            r0 = 1
            r1 = r7
            long r0 = r0 << r1
            goto L_0x0063
        L_0x0062:
            r0 = 0
        L_0x0063:
            return r0
        L_0x0064:
            r0 = r7
            r1 = 64
            if (r0 >= r1) goto L_0x007b
            r0 = r7
            r1 = 1
            r0 = r0 & r1
            if (r0 != 0) goto L_0x0076
            r0 = 1
            r1 = r7
            long r0 = r0 << r1
            goto L_0x007a
        L_0x0076:
            r0 = 1
            r1 = r7
            long r0 = r0 << r1
            long r0 = -r0
        L_0x007a:
            return r0
        L_0x007b:
            r0 = 0
            return r0
        L_0x007d:
            java.lang.AssertionError r0 = new java.lang.AssertionError
            r1 = r0
            r1.<init>()
            throw r0
        L_0x0085:
            r0 = 1
            r8 = r0
        L_0x0087:
            r0 = r7
            switch(r0) {
                case 0: goto L_0x00a4;
                case 1: goto L_0x00a6;
                default: goto L_0x00aa;
            }
        L_0x00a4:
            r0 = r8
            return r0
        L_0x00a6:
            r0 = r8
            r1 = r5
            long r0 = r0 * r1
            return r0
        L_0x00aa:
            r0 = r8
            r1 = r7
            r2 = 1
            r1 = r1 & r2
            if (r1 != 0) goto L_0x00b5
            r1 = 1
            goto L_0x00b6
        L_0x00b5:
            r1 = r5
        L_0x00b6:
            long r0 = r0 * r1
            r8 = r0
            r0 = r5
            r1 = r5
            long r0 = r0 * r1
            r5 = r0
            r0 = r7
            r1 = 1
            int r0 = r0 >> r1
            r7 = r0
            goto L_0x0087
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.math.LongMath.pow(long, int):long");
    }

    @GwtIncompatible
    public static long sqrt(long x, RoundingMode mode) {
        MathPreconditions.checkNonNegative("x", x);
        if (fitsInInt(x)) {
            return (long) IntMath.sqrt((int) x, mode);
        }
        long guess = (long) Math.sqrt((double) x);
        long guessSquared = guess * guess;
        switch (C05021.$SwitchMap$java$math$RoundingMode[mode.ordinal()]) {
            case 1:
                MathPreconditions.checkRoundingUnnecessary(guessSquared == x);
                return guess;
            case 2:
            case 3:
                if (x < guessSquared) {
                    return guess - 1;
                }
                return guess;
            case 4:
            case 5:
                if (x > guessSquared) {
                    return guess + 1;
                }
                return guess;
            case 6:
            case 7:
            case 8:
                long sqrtFloor = guess - ((long) (x < guessSquared ? 1 : 0));
                return sqrtFloor + ((long) lessThanBranchFree((sqrtFloor * sqrtFloor) + sqrtFloor, x));
            default:
                throw new AssertionError();
        }
    }

    @GwtIncompatible
    public static long divide(long p, long q, RoundingMode mode) {
        boolean increment;
        Preconditions.checkNotNull(mode);
        long div = p / q;
        long rem = p - (q * div);
        if (rem == 0) {
            return div;
        }
        int signum = 1 | ((int) ((p ^ q) >> 63));
        switch (C05021.$SwitchMap$java$math$RoundingMode[mode.ordinal()]) {
            case 1:
                MathPreconditions.checkRoundingUnnecessary(rem == 0);
            case 2:
                increment = false;
                break;
            case 3:
                increment = signum < 0;
                break;
            case 4:
                increment = true;
                break;
            case 5:
                increment = signum > 0;
                break;
            case 6:
            case 7:
            case 8:
                long absRem = Math.abs(rem);
                long cmpRemToHalfDivisor = absRem - (Math.abs(q) - absRem);
                if (cmpRemToHalfDivisor != 0) {
                    increment = cmpRemToHalfDivisor > 0;
                    break;
                } else {
                    increment = (mode == RoundingMode.HALF_UP) | ((mode == RoundingMode.HALF_EVEN) & ((div & 1) != 0));
                    break;
                }
            default:
                throw new AssertionError();
        }
        return increment ? div + ((long) signum) : div;
    }

    @GwtIncompatible
    public static int mod(long x, int m) {
        return (int) mod(x, (long) m);
    }

    @GwtIncompatible
    public static long mod(long x, long m) {
        if (m <= 0) {
            throw new ArithmeticException("Modulus must be positive");
        }
        long result = x % m;
        return result >= 0 ? result : result + m;
    }

    /* JADX WARN: Type inference failed for: r0v11, types: [long] */
    /* JADX WARN: Type inference failed for: r0v15, types: [long] */
    /* JADX WARN: Type inference failed for: r0v28, types: [long] */
    /* JADX WARN: Type inference failed for: r0v30, types: [long] */
    public static long gcd(long a, long b) {
        MathPreconditions.checkNonNegative("a", a);
        MathPreconditions.checkNonNegative("b", b);
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }
        int aTwos = Long.numberOfTrailingZeros(a);
        int i = a >> aTwos;
        int bTwos = Long.numberOfTrailingZeros(b);
        int i2 = b >> bTwos;
        while (i != i2) {
            long delta = i - i2;
            long minDeltaOrZero = delta & (delta >> 63);
            long a2 = (delta - minDeltaOrZero) - minDeltaOrZero;
            i2 += minDeltaOrZero;
            i = a2 >> Long.numberOfTrailingZeros(a2);
        }
        return i << Math.min(aTwos, bTwos);
    }

    @GwtIncompatible
    public static long checkedAdd(long a, long b) {
        long result = a + b;
        MathPreconditions.checkNoOverflow(((a ^ b) < 0) | ((a ^ result) >= 0), "checkedAdd", a, b);
        return result;
    }

    @GwtIncompatible
    public static long checkedSubtract(long a, long b) {
        long result = a - b;
        MathPreconditions.checkNoOverflow(((a ^ b) >= 0) | ((a ^ result) >= 0), "checkedSubtract", a, b);
        return result;
    }

    public static long checkedMultiply(long a, long b) {
        int leadingZeros = Long.numberOfLeadingZeros(a) + Long.numberOfLeadingZeros(a ^ -1) + Long.numberOfLeadingZeros(b) + Long.numberOfLeadingZeros(b ^ -1);
        if (leadingZeros > 65) {
            return a * b;
        }
        MathPreconditions.checkNoOverflow(leadingZeros >= 64, "checkedMultiply", a, b);
        MathPreconditions.checkNoOverflow((a >= 0) | (b != Long.MIN_VALUE), "checkedMultiply", a, b);
        long result = a * b;
        MathPreconditions.checkNoOverflow(a == 0 || result / a == b, "checkedMultiply", a, b);
        return result;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:62:0x00a8 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:63:0x00a8 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [long] */
    /* JADX WARN: Type inference failed for: r7v1, types: [long] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r0v20, types: [long] */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r0v26, types: [long] */
    @GwtIncompatible
    public static long checkedPow(long j, int k) {
        MathPreconditions.checkNonNegative("exponent", k);
        if (!(j >= -2) || !(j <= 2)) {
            char c = 1;
            while (true) {
                switch (k) {
                    case 0:
                        return c;
                    case 1:
                        return checkedMultiply(c, j == true ? 1 : 0);
                    default:
                        c = c;
                        if ((k & 1) != 0) {
                            c = checkedMultiply(c, j);
                        }
                        k >>= 1;
                        if (k > 0) {
                            MathPreconditions.checkNoOverflow(-3037000499L <= j && j <= FLOOR_SQRT_MAX_LONG, "checkedPow", (long) j, (long) k);
                            j *= j;
                        }
                        break;
                }
            }
        } else {
            switch ((int) j) {
                case -2:
                    MathPreconditions.checkNoOverflow(k < 64, "checkedPow", (long) j, (long) k);
                    return (k & 1) == 0 ? 1 << k : -1 << k;
                case -1:
                    return (k & 1) == 0 ? 1 : -1;
                case 0:
                    return k == 0 ? 1 : 0;
                case 1:
                    return 1;
                case 2:
                    MathPreconditions.checkNoOverflow(k < 63, "checkedPow", (long) j, (long) k);
                    return 1 << k;
                default:
                    throw new AssertionError();
            }
        }
    }

    @Beta
    public static long saturatedAdd(long a, long b) {
        long naiveSum = a + b;
        if (((a ^ b) < 0) || ((a ^ naiveSum) >= 0)) {
            return naiveSum;
        }
        return LongCompanionObject.MAX_VALUE + ((naiveSum >>> 63) ^ 1);
    }

    @Beta
    public static long saturatedSubtract(long a, long b) {
        long naiveDifference = a - b;
        if (((a ^ b) >= 0) || ((a ^ naiveDifference) >= 0)) {
            return naiveDifference;
        }
        return LongCompanionObject.MAX_VALUE + ((naiveDifference >>> 63) ^ 1);
    }

    @Beta
    public static long saturatedMultiply(long a, long b) {
        int leadingZeros = Long.numberOfLeadingZeros(a) + Long.numberOfLeadingZeros(a ^ -1) + Long.numberOfLeadingZeros(b) + Long.numberOfLeadingZeros(b ^ -1);
        if (leadingZeros > 65) {
            return a * b;
        }
        long limit = LongCompanionObject.MAX_VALUE + ((a ^ b) >>> 63);
        if ((leadingZeros < 64) || ((a < 0) & (b == Long.MIN_VALUE))) {
            return limit;
        }
        long result = a * b;
        if (a == 0 || result / a == b) {
            return result;
        }
        return limit;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:68:0x00aa */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:69:0x00aa */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v1, types: [long] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r0v24, types: [long] */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r0v28, types: [long] */
    @Beta
    public static long saturatedPow(long b, int k) {
        MathPreconditions.checkNonNegative("exponent", k);
        if ((b >= -2) && (b <= 2)) {
            switch ((int) b) {
                case -2:
                    if (k >= 64) {
                        return LongCompanionObject.MAX_VALUE + ((long) (k & 1));
                    }
                    return (k & 1) == 0 ? 1 << k : -1 << k;
                case -1:
                    return (k & 1) == 0 ? 1 : -1;
                case 0:
                    return k == 0 ? 1 : 0;
                case 1:
                    return 1;
                case 2:
                    if (k >= 63) {
                        return LongCompanionObject.MAX_VALUE;
                    }
                    return 1 << k;
                default:
                    throw new AssertionError();
            }
        } else {
            char c = 1;
            long limit = LongCompanionObject.MAX_VALUE + ((b >>> 63) & ((long) (k & 1)));
            while (true) {
                switch (k) {
                    case 0:
                        return c;
                    case 1:
                        return saturatedMultiply(c, b == true ? 1 : 0);
                    default:
                        c = c;
                        if ((k & 1) != 0) {
                            c = saturatedMultiply(c, b);
                        }
                        k >>= 1;
                        if (k > 0) {
                            if ((-3037000499L > b) || (b > FLOOR_SQRT_MAX_LONG)) {
                                return limit;
                            }
                            b *= b;
                        }
                }
            }
        }
    }

    @GwtIncompatible
    public static long factorial(int n) {
        MathPreconditions.checkNonNegative("n", n);
        return n < factorials.length ? factorials[n] : LongCompanionObject.MAX_VALUE;
    }

    /* JADX WARN: Type inference failed for: r0v19, types: [long] */
    /* JADX WARN: Type inference failed for: r0v30, types: [long] */
    /* JADX WARN: Type inference failed for: r0v32, types: [long] */
    /* JADX WARN: Type inference failed for: r0v34, types: [long] */
    /* JADX WARN: Type inference failed for: r0v37, types: [long] */
    /* JADX WARN: Type inference failed for: r0v39, types: [long] */
    /* JADX WARN: Type inference failed for: r0v44, types: [long] */
    /* JADX WARN: Type inference failed for: r0v51, types: [long] */
    public static long binomial(int n, int k) {
        MathPreconditions.checkNonNegative("n", n);
        MathPreconditions.checkNonNegative("k", k);
        Preconditions.checkArgument(k <= n, "k (%s) > n (%s)", k, n);
        if (k > (n >> 1)) {
            k = n - k;
        }
        switch (k) {
            case 0:
                return 1;
            case 1:
                return (long) n;
            default:
                if (n < factorials.length) {
                    return factorials[n] / (factorials[k] * factorials[n - k]);
                }
                if (k >= biggestBinomials.length || n > biggestBinomials[k]) {
                    return LongCompanionObject.MAX_VALUE;
                }
                if (k >= biggestSimpleBinomials.length || n > biggestSimpleBinomials[k]) {
                    int nBits = log2((long) n, RoundingMode.CEILING);
                    char c = 1;
                    int n2 = n - 1;
                    char c2 = (long) n;
                    char c3 = 1;
                    int numeratorBits = nBits;
                    int i = 2;
                    while (i <= k) {
                        if (numeratorBits + nBits < 63) {
                            c2 *= (long) n2;
                            c3 *= (long) i;
                            numeratorBits += nBits;
                        } else {
                            c = multiplyFraction(c, c2, c3);
                            c2 = (long) n2;
                            c3 = (long) i;
                            numeratorBits = nBits;
                        }
                        i++;
                        n2--;
                    }
                    return multiplyFraction(c, c2, c3);
                }
                int n3 = n - 1;
                char c4 = (long) n;
                for (int i2 = 2; i2 <= k; i2++) {
                    c4 = (c4 * ((long) n3)) / ((long) i2);
                    n3--;
                }
                return c4;
        }
    }

    static long multiplyFraction(long x, long numerator, long denominator) {
        if (x == 1) {
            return numerator / denominator;
        }
        long commonDivisor = gcd(x, denominator);
        return (x / commonDivisor) * (numerator / (denominator / commonDivisor));
    }

    static boolean fitsInInt(long x) {
        return ((long) ((int) x)) == x;
    }

    public static long mean(long x, long y) {
        return (x & y) + ((x ^ y) >> 1);
    }

    @Beta
    @GwtIncompatible
    public static boolean isPrime(long n) {
        if (n < 2) {
            MathPreconditions.checkNonNegative("n", n);
            return false;
        } else if (n == 2 || n == 3 || n == 5 || n == 7 || n == 11 || n == 13) {
            return true;
        } else {
            if ((SIEVE_30 & (1 << ((int) (n % 30)))) != 0 || n % 7 == 0 || n % 11 == 0 || n % 13 == 0) {
                return false;
            }
            if (n < 289) {
                return true;
            }
            long[][] jArr = millerRabinBaseSets;
            for (long[] baseSet : jArr) {
                if (n <= baseSet[0]) {
                    for (int i = 1; i < baseSet.length; i++) {
                        if (!MillerRabinTester.test(baseSet[i], n)) {
                            return false;
                        }
                    }
                    return true;
                }
            }
            throw new AssertionError();
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/common/math/LongMath$MillerRabinTester.class */
    public enum MillerRabinTester {
        SMALL {
            @Override // com.google.common.math.LongMath.MillerRabinTester
            long mulMod(long a, long b, long m) {
                return (a * b) % m;
            }

            @Override // com.google.common.math.LongMath.MillerRabinTester
            long squareMod(long a, long m) {
                return (a * a) % m;
            }
        },
        LARGE {
            private long plusMod(long a, long b, long m) {
                return a >= m - b ? (a + b) - m : a + b;
            }

            private long times2ToThe32Mod(long a, long m) {
                int remainingPowersOf2 = 32;
                do {
                    int shift = Math.min(remainingPowersOf2, Long.numberOfLeadingZeros(a));
                    a = UnsignedLongs.remainder(a << shift, m);
                    remainingPowersOf2 -= shift;
                } while (remainingPowersOf2 > 0);
                return a;
            }

            /* JADX WARN: Type inference failed for: r0v11, types: [long] */
            /* JADX WARN: Type inference failed for: r0v21, types: [long] */
            @Override // com.google.common.math.LongMath.MillerRabinTester
            long mulMod(long a, long b, long m) {
                long aHi = a >>> 32;
                long bHi = b >>> 32;
                long aLo = a & 4294967295L;
                long bLo = b & 4294967295L;
                char times2ToThe32Mod = times2ToThe32Mod(aHi * bHi, m) + (aHi * bLo);
                if (times2ToThe32Mod < 0) {
                    times2ToThe32Mod = UnsignedLongs.remainder(times2ToThe32Mod, m);
                }
                return plusMod(times2ToThe32Mod(times2ToThe32Mod + (aLo * bHi), m), UnsignedLongs.remainder(aLo * bLo, m), m);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r19v1 */
            /* JADX WARN: Type inference failed for: r0v18, types: [long] */
            /* JADX WARN: Type inference failed for: r19v2 */
            /* JADX WARN: Type inference failed for: r19v4 */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // com.google.common.math.LongMath.MillerRabinTester
            /* Code decompiled incorrectly, please refer to instructions dump. */
            long squareMod(long r9, long r11) {
                /*
                    r8 = this;
                    r0 = r9
                    r1 = 32
                    long r0 = r0 >>> r1
                    r13 = r0
                    r0 = r9
                    r1 = 4294967295(0xffffffff, double:2.1219957905E-314)
                    long r0 = r0 & r1
                    r15 = r0
                    r0 = r8
                    r1 = r13
                    r2 = r13
                    long r1 = r1 * r2
                    r2 = r11
                    long r0 = r0.times2ToThe32Mod(r1, r2)
                    r17 = r0
                    r0 = r13
                    r1 = r15
                    long r0 = r0 * r1
                    r1 = 2
                    long r0 = r0 * r1
                    r19 = r0
                    r0 = r19
                    r1 = 0
                    int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                    if (r0 >= 0) goto L_0x0033
                    r0 = r19
                    r1 = r11
                    long r0 = com.google.common.primitives.UnsignedLongs.remainder(r0, r1)
                    r19 = r0
                L_0x0033:
                    r0 = r17
                    r1 = r19
                    long r0 = r0 + r1
                    r17 = r0
                    r0 = r8
                    r1 = r17
                    r2 = r11
                    long r0 = r0.times2ToThe32Mod(r1, r2)
                    r17 = r0
                    r0 = r8
                    r1 = r17
                    r2 = r15
                    r3 = r15
                    long r2 = r2 * r3
                    r3 = r11
                    long r2 = com.google.common.primitives.UnsignedLongs.remainder(r2, r3)
                    r3 = r11
                    long r0 = r0.plusMod(r1, r2, r3)
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.common.math.LongMath.MillerRabinTester.C05042.squareMod(long, long):long");
            }
        };

        abstract long mulMod(long j, long j2, long j3);

        abstract long squareMod(long j, long j2);

        /* synthetic */ MillerRabinTester(C05021 x2) {
            this();
        }

        static boolean test(long base, long n) {
            return (n <= LongMath.FLOOR_SQRT_MAX_LONG ? SMALL : LARGE).testWitness(base, n);
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:13:0x001c */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r8v0, types: [com.google.common.math.LongMath$MillerRabinTester] */
        /* JADX WARN: Type inference failed for: r11v1, types: [long] */
        /* JADX WARN: Type inference failed for: r9v1, types: [long] */
        /* JADX WARN: Type inference failed for: r0v8, types: [long] */
        /* JADX WARN: Type inference failed for: r9v2 */
        /* JADX WARN: Type inference failed for: r0v10, types: [long] */
        /* JADX WARN: Type inference failed for: r11v2 */
        /* JADX WARN: Type inference failed for: r0v12, types: [long] */
        /* JADX WARN: Type inference failed for: r9v4 */
        /* JADX WARN: Type inference failed for: r11v4 */
        /* JADX WARNING: Unknown variable types count: 2 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private long powMod(long r9, long r11, long r13) {
            /*
                r8 = this;
                r0 = 1
                r15 = r0
            L_0x0003:
                r0 = r11
                r1 = 0
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 == 0) goto L_0x002b
                r0 = r11
                r1 = 1
                long r0 = r0 & r1
                r1 = 0
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 == 0) goto L_0x001c
                r0 = r8
                r1 = r15
                r2 = r9
                r3 = r13
                long r0 = r0.mulMod(r1, r2, r3)
                r15 = r0
            L_0x001c:
                r0 = r8
                r1 = r9
                r2 = r13
                long r0 = r0.squareMod(r1, r2)
                r9 = r0
                r0 = r11
                r1 = 1
                long r0 = r0 >> r1
                r11 = r0
                goto L_0x0003
            L_0x002b:
                r0 = r15
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.math.LongMath.MillerRabinTester.powMod(long, long, long):long");
        }

        /* JADX WARN: Type inference failed for: r0v11, types: [long] */
        /* JADX WARN: Type inference failed for: r0v21, types: [long] */
        private boolean testWitness(long base, long n) {
            int r = Long.numberOfTrailingZeros(n - 1);
            long d = (n - 1) >> r;
            long base2 = base % n;
            if (base2 == 0) {
                return true;
            }
            char powMod = powMod(base2, d, n);
            if (powMod == 1) {
                return true;
            }
            int j = 0;
            while (powMod != n - 1) {
                j++;
                if (j == r) {
                    return false;
                }
                powMod = squareMod(powMod, n);
            }
            return true;
        }
    }

    private LongMath() {
    }
}
