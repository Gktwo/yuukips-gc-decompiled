package org.bson.types;

import com.mchange.p009v2.c3p0.subst.C3P0Substitutions;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.luaj.vm2.LuaDouble;

/* loaded from: grasscutter.jar:org/bson/types/Decimal128.class */
public final class Decimal128 extends Number implements Comparable<Decimal128> {
    private static final long serialVersionUID = 4570973266503637887L;
    private static final long SIGN_BIT_MASK = Long.MIN_VALUE;
    private static final int MIN_EXPONENT = -6176;
    private static final int MAX_EXPONENT = 6111;
    private static final int EXPONENT_OFFSET = 6176;
    private static final int MAX_BIT_LENGTH = 113;
    private final long high;
    private final long low;
    private static final BigInteger BIG_INT_TEN = new BigInteger(C3P0Substitutions.TRACE);
    private static final BigInteger BIG_INT_ONE = new BigInteger("1");
    private static final BigInteger BIG_INT_ZERO = new BigInteger("0");
    private static final Set<String> NaN_STRINGS = new HashSet(Collections.singletonList(LuaDouble.JSTR_NAN));
    private static final Set<String> NEGATIVE_NaN_STRINGS = new HashSet(Collections.singletonList("-nan"));
    private static final Set<String> POSITIVE_INFINITY_STRINGS = new HashSet(Arrays.asList(LuaDouble.JSTR_POSINF, "+inf", "infinity", "+infinity"));
    private static final Set<String> NEGATIVE_INFINITY_STRINGS = new HashSet(Arrays.asList(LuaDouble.JSTR_NEGINF, "-infinity"));
    private static final long INFINITY_MASK = 8646911284551352320L;
    public static final Decimal128 POSITIVE_INFINITY = fromIEEE754BIDEncoding(INFINITY_MASK, 0);
    public static final Decimal128 NEGATIVE_INFINITY = fromIEEE754BIDEncoding(-576460752303423488L, 0);
    public static final Decimal128 NEGATIVE_NaN = fromIEEE754BIDEncoding(-288230376151711744L, 0);
    private static final long NaN_MASK = 8935141660703064064L;
    public static final Decimal128 NaN = fromIEEE754BIDEncoding(NaN_MASK, 0);
    public static final Decimal128 POSITIVE_ZERO = fromIEEE754BIDEncoding(3476778912330022912L, 0);
    public static final Decimal128 NEGATIVE_ZERO = fromIEEE754BIDEncoding(-5746593124524752896L, 0);

    public static Decimal128 parse(String value) {
        String lowerCasedValue = value.toLowerCase();
        if (NaN_STRINGS.contains(lowerCasedValue)) {
            return NaN;
        }
        if (NEGATIVE_NaN_STRINGS.contains(lowerCasedValue)) {
            return NEGATIVE_NaN;
        }
        if (POSITIVE_INFINITY_STRINGS.contains(lowerCasedValue)) {
            return POSITIVE_INFINITY;
        }
        if (NEGATIVE_INFINITY_STRINGS.contains(lowerCasedValue)) {
            return NEGATIVE_INFINITY;
        }
        return new Decimal128(new BigDecimal(value), value.charAt(0) == '-');
    }

    public static Decimal128 fromIEEE754BIDEncoding(long high, long low) {
        return new Decimal128(high, low);
    }

    public Decimal128(long value) {
        this(new BigDecimal(value, MathContext.DECIMAL128));
    }

    public Decimal128(BigDecimal value) {
        this(value, value.signum() == -1);
    }

    private Decimal128(long high, long low) {
        this.high = high;
        this.low = low;
    }

    /* JADX WARN: Type inference failed for: r0v29, types: [long] */
    /* JADX WARN: Type inference failed for: r0v35, types: [long] */
    /* JADX WARN: Type inference failed for: r0v40, types: [long] */
    /* JADX WARN: Type inference failed for: r0v44, types: [long] */
    private Decimal128(BigDecimal initialValue, boolean isNegative) {
        char c;
        char c2 = 0;
        char c3 = 0;
        BigDecimal value = clampAndRound(initialValue);
        long exponent = (long) (-value.scale());
        if (exponent < -6176 || exponent > 6111) {
            throw new AssertionError("Exponent is out of range for Decimal128 encoding: " + exponent);
        } else if (value.unscaledValue().bitLength() > 113) {
            throw new AssertionError("Unscaled roundedValue is out of range for Decimal128 encoding:" + value.unscaledValue());
        } else {
            BigInteger significand = value.unscaledValue().abs();
            int bitLength = significand.bitLength();
            for (int i = 0; i < Math.min(64, bitLength); i++) {
                if (significand.testBit(i)) {
                    c3 |= 1 << i;
                }
            }
            for (int i2 = 64; i2 < bitLength; i2++) {
                if (significand.testBit(i2)) {
                    c2 |= 1 << (i2 - 64);
                }
            }
            this.high = (value.signum() == -1 || isNegative) ? c2 | ((exponent + 6176) << 49) | 0 : c;
            this.low = c3;
        }
    }

    private BigDecimal clampAndRound(BigDecimal initialValue) {
        BigDecimal value;
        if ((-initialValue.scale()) > MAX_EXPONENT) {
            int diff = (-initialValue.scale()) - MAX_EXPONENT;
            if (initialValue.unscaledValue().equals(BIG_INT_ZERO)) {
                value = new BigDecimal(initialValue.unscaledValue(), -6111);
            } else if (diff + initialValue.precision() > 34) {
                throw new NumberFormatException("Exponent is out of range for Decimal128 encoding of " + initialValue);
            } else {
                value = new BigDecimal(initialValue.unscaledValue().multiply(BIG_INT_TEN.pow(diff)), initialValue.scale() + diff);
            }
        } else if ((-initialValue.scale()) < MIN_EXPONENT) {
            int diff2 = initialValue.scale() + MIN_EXPONENT;
            value = new BigDecimal(initialValue.unscaledValue().divide(ensureExactRounding(initialValue, diff2) == 0 ? BIG_INT_ONE : BIG_INT_TEN.pow(diff2)), initialValue.scale() - diff2);
        } else {
            value = initialValue.round(MathContext.DECIMAL128);
            int extraPrecision = initialValue.precision() - value.precision();
            if (extraPrecision > 0) {
                ensureExactRounding(initialValue, extraPrecision);
            }
        }
        return value;
    }

    private int ensureExactRounding(BigDecimal initialValue, int extraPrecision) {
        String significand = initialValue.unscaledValue().abs().toString();
        int undiscardedPrecision = Math.max(0, significand.length() - extraPrecision);
        for (int i = undiscardedPrecision; i < significand.length(); i++) {
            if (significand.charAt(i) != '0') {
                throw new NumberFormatException("Conversion to Decimal128 would require inexact rounding of " + initialValue);
            }
        }
        return undiscardedPrecision;
    }

    public long getHigh() {
        return this.high;
    }

    public long getLow() {
        return this.low;
    }

    public BigDecimal bigDecimalValue() {
        if (isNaN()) {
            throw new ArithmeticException("NaN can not be converted to a BigDecimal");
        } else if (isInfinite()) {
            throw new ArithmeticException("Infinity can not be converted to a BigDecimal");
        } else {
            BigDecimal bigDecimal = bigDecimalValueNoNegativeZeroCheck();
            if (!isNegative() || bigDecimal.signum() != 0) {
                return bigDecimal;
            }
            throw new ArithmeticException("Negative zero can not be converted to a BigDecimal");
        }
    }

    private boolean hasDifferentSign(BigDecimal bigDecimal) {
        return isNegative() && bigDecimal.signum() == 0;
    }

    private boolean isZero(BigDecimal bigDecimal) {
        return !isNaN() && !isInfinite() && bigDecimal.compareTo(BigDecimal.ZERO) == 0;
    }

    private BigDecimal bigDecimalValueNoNegativeZeroCheck() {
        int scale = -getExponent();
        if (twoHighestCombinationBitsAreSet()) {
            return BigDecimal.valueOf(0, scale);
        }
        return new BigDecimal(new BigInteger(isNegative() ? -1 : 1, getBytes()), scale);
    }

    /* JADX WARN: Type inference failed for: r0v13, types: [long] */
    /* JADX WARN: Type inference failed for: r0v16, types: [long] */
    private byte[] getBytes() {
        byte[] bytes = new byte[15];
        char c = 255;
        for (int i = 14; i >= 7; i--) {
            bytes[i] = (byte) ((int) ((this.low & c) >>> ((14 - i) << 3)));
            c <<= '\b';
        }
        char c2 = 255;
        for (int i2 = 6; i2 >= 1; i2--) {
            bytes[i2] = (byte) ((int) ((this.high & c2) >>> ((6 - i2) << 3)));
            c2 <<= '\b';
        }
        bytes[0] = (byte) ((int) ((this.high & 281474976710656L) >>> 48));
        return bytes;
    }

    private int getExponent() {
        if (twoHighestCombinationBitsAreSet()) {
            return ((int) ((this.high & 2305807824841605120L) >>> 47)) - EXPONENT_OFFSET;
        }
        return ((int) ((this.high & 9223231299366420480L) >>> 49)) - EXPONENT_OFFSET;
    }

    private boolean twoHighestCombinationBitsAreSet() {
        return (this.high & 6917529027641081856L) == 6917529027641081856L;
    }

    public boolean isNegative() {
        return (this.high & Long.MIN_VALUE) == Long.MIN_VALUE;
    }

    public boolean isInfinite() {
        return (this.high & INFINITY_MASK) == INFINITY_MASK;
    }

    public boolean isFinite() {
        return !isInfinite();
    }

    public boolean isNaN() {
        return (this.high & NaN_MASK) == NaN_MASK;
    }

    public int compareTo(Decimal128 o) {
        if (isNaN()) {
            return o.isNaN() ? 0 : 1;
        }
        if (!isInfinite()) {
            BigDecimal bigDecimal = bigDecimalValueNoNegativeZeroCheck();
            BigDecimal otherBigDecimal = o.bigDecimalValueNoNegativeZeroCheck();
            if (isZero(bigDecimal) && o.isZero(otherBigDecimal)) {
                if (hasDifferentSign(bigDecimal)) {
                    if (o.hasDifferentSign(otherBigDecimal)) {
                        return 0;
                    }
                    return -1;
                } else if (o.hasDifferentSign(otherBigDecimal)) {
                    return 1;
                }
            }
            if (o.isNaN()) {
                return -1;
            }
            if (!o.isInfinite()) {
                return bigDecimal.compareTo(otherBigDecimal);
            }
            if (o.isNegative()) {
                return 1;
            }
            return -1;
        } else if (isNegative()) {
            if (!o.isInfinite() || !o.isNegative()) {
                return -1;
            }
            return 0;
        } else if (o.isNaN()) {
            return -1;
        } else {
            if (!o.isInfinite() || o.isNegative()) {
                return 1;
            }
            return 0;
        }
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) doubleValue();
    }

    @Override // java.lang.Number
    public long longValue() {
        return (long) doubleValue();
    }

    @Override // java.lang.Number
    public float floatValue() {
        return (float) doubleValue();
    }

    @Override // java.lang.Number
    public double doubleValue() {
        if (isNaN()) {
            return Double.NaN;
        }
        if (!isInfinite()) {
            BigDecimal bigDecimal = bigDecimalValueNoNegativeZeroCheck();
            if (hasDifferentSign(bigDecimal)) {
                return -0.0d;
            }
            return bigDecimal.doubleValue();
        } else if (isNegative()) {
            return Double.NEGATIVE_INFINITY;
        } else {
            return Double.POSITIVE_INFINITY;
        }
    }

    @Override // java.lang.Object
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Decimal128 that = (Decimal128) o;
        if (this.high == that.high && this.low == that.low) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (31 * ((int) (this.low ^ (this.low >>> 32)))) + ((int) (this.high ^ (this.high >>> 32)));
    }

    @Override // java.lang.Object
    public String toString() {
        if (isNaN()) {
            return "NaN";
        }
        if (!isInfinite()) {
            return toStringWithBigDecimal();
        }
        if (isNegative()) {
            return "-Infinity";
        }
        return "Infinity";
    }

    private String toStringWithBigDecimal() {
        StringBuilder buffer = new StringBuilder();
        BigDecimal bigDecimal = bigDecimalValueNoNegativeZeroCheck();
        String significand = bigDecimal.unscaledValue().abs().toString();
        if (isNegative()) {
            buffer.append('-');
        }
        int exponent = -bigDecimal.scale();
        int adjustedExponent = exponent + (significand.length() - 1);
        if (exponent > 0 || adjustedExponent < -6) {
            buffer.append(significand.charAt(0));
            if (significand.length() > 1) {
                buffer.append('.');
                buffer.append((CharSequence) significand, 1, significand.length());
            }
            buffer.append('E');
            if (adjustedExponent > 0) {
                buffer.append('+');
            }
            buffer.append(adjustedExponent);
        } else if (exponent == 0) {
            buffer.append(significand);
        } else {
            int pad = (-exponent) - significand.length();
            if (pad >= 0) {
                buffer.append('0');
                buffer.append('.');
                for (int i = 0; i < pad; i++) {
                    buffer.append('0');
                }
                buffer.append((CharSequence) significand, 0, significand.length());
            } else {
                buffer.append((CharSequence) significand, 0, -pad);
                buffer.append('.');
                buffer.append((CharSequence) significand, -pad, (-pad) - exponent);
            }
        }
        return buffer.toString();
    }
}
