package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.math.BigInteger;

@GwtCompatible(serializable = true)
/* loaded from: grasscutter.jar:com/google/common/primitives/UnsignedLong.class */
public final class UnsignedLong extends Number implements Comparable<UnsignedLong>, Serializable {
    private static final long UNSIGNED_MASK = Long.MAX_VALUE;
    public static final UnsignedLong ZERO = new UnsignedLong(0);
    public static final UnsignedLong ONE = new UnsignedLong(1);
    public static final UnsignedLong MAX_VALUE = new UnsignedLong(-1);
    private final long value;

    private UnsignedLong(long value) {
        this.value = value;
    }

    public static UnsignedLong fromLongBits(long bits) {
        return new UnsignedLong(bits);
    }

    @CanIgnoreReturnValue
    public static UnsignedLong valueOf(long value) {
        Preconditions.checkArgument(value >= 0, "value (%s) is outside the range for an unsigned long value", value);
        return fromLongBits(value);
    }

    @CanIgnoreReturnValue
    public static UnsignedLong valueOf(BigInteger value) {
        Preconditions.checkNotNull(value);
        Preconditions.checkArgument(value.signum() >= 0 && value.bitLength() <= 64, "value (%s) is outside the range for an unsigned long value", value);
        return fromLongBits(value.longValue());
    }

    @CanIgnoreReturnValue
    public static UnsignedLong valueOf(String string) {
        return valueOf(string, 10);
    }

    @CanIgnoreReturnValue
    public static UnsignedLong valueOf(String string, int radix) {
        return fromLongBits(UnsignedLongs.parseUnsignedLong(string, radix));
    }

    public UnsignedLong plus(UnsignedLong val) {
        return fromLongBits(this.value + ((UnsignedLong) Preconditions.checkNotNull(val)).value);
    }

    public UnsignedLong minus(UnsignedLong val) {
        return fromLongBits(this.value - ((UnsignedLong) Preconditions.checkNotNull(val)).value);
    }

    public UnsignedLong times(UnsignedLong val) {
        return fromLongBits(this.value * ((UnsignedLong) Preconditions.checkNotNull(val)).value);
    }

    public UnsignedLong dividedBy(UnsignedLong val) {
        return fromLongBits(UnsignedLongs.divide(this.value, ((UnsignedLong) Preconditions.checkNotNull(val)).value));
    }

    public UnsignedLong mod(UnsignedLong val) {
        return fromLongBits(UnsignedLongs.remainder(this.value, ((UnsignedLong) Preconditions.checkNotNull(val)).value));
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) this.value;
    }

    @Override // java.lang.Number
    public long longValue() {
        return this.value;
    }

    @Override // java.lang.Number
    public float floatValue() {
        float fValue = (float) (this.value & Long.MAX_VALUE);
        if (this.value < 0) {
            fValue += 9.223372E18f;
        }
        return fValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r0v9, types: [double] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // java.lang.Number
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public double doubleValue() {
        /*
            r5 = this;
            r0 = r5
            long r0 = r0.value
            r1 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            long r0 = r0 & r1
            double r0 = (double) r0
            r6 = r0
            r0 = r5
            long r0 = r0.value
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0019
            r0 = r6
            r1 = 4890909195324358656(0x43e0000000000000, double:9.223372036854776E18)
            double r0 = r0 + r1
            r6 = r0
        L_0x0019:
            r0 = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.primitives.UnsignedLong.doubleValue():double");
    }

    public BigInteger bigIntegerValue() {
        BigInteger bigInt = BigInteger.valueOf(this.value & Long.MAX_VALUE);
        if (this.value < 0) {
            bigInt = bigInt.setBit(63);
        }
        return bigInt;
    }

    public int compareTo(UnsignedLong o) {
        Preconditions.checkNotNull(o);
        return UnsignedLongs.compare(this.value, o.value);
    }

    @Override // java.lang.Object
    public int hashCode() {
        return Longs.hashCode(this.value);
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        return (obj instanceof UnsignedLong) && this.value == ((UnsignedLong) obj).value;
    }

    @Override // java.lang.Object
    public String toString() {
        return UnsignedLongs.toString(this.value);
    }

    public String toString(int radix) {
        return UnsignedLongs.toString(this.value, radix);
    }
}
