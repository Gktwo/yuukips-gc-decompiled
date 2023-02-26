package kotlin;

import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(m371mv = {1, 6, 0}, m372k = 2, m369xi = 48, m374d1 = {"��0\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0018\u0010��\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001ø\u0001��¢\u0006\u0002\u0010\u0004\u001a\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0003H\u0001ø\u0001��¢\u0006\u0002\u0010\u0007\u001a\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0001\u001a\"\u0010\f\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0001H\u0001ø\u0001��¢\u0006\u0004\b\r\u0010\u000e\u001a\"\u0010\u000f\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0001H\u0001ø\u0001��¢\u0006\u0004\b\u0010\u0010\u000e\u001a\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\tH\u0001\u001a\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\u0013H\u0001\u001a\"\u0010\u0014\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0001ø\u0001��¢\u0006\u0004\b\u0015\u0010\u0016\u001a\"\u0010\u0017\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0001ø\u0001��¢\u0006\u0004\b\u0018\u0010\u0016\u001a\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0013H\u0001\u001a\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u0013H��\u001a\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\tH��\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, m373d2 = {"doubleToUInt", "Lkotlin/UInt;", "v", "", "(D)I", "doubleToULong", "Lkotlin/ULong;", "(D)J", "uintCompare", "", "v1", "v2", "uintDivide", "uintDivide-J1ME1BU", "(II)I", "uintRemainder", "uintRemainder-J1ME1BU", "uintToDouble", "ulongCompare", "", "ulongDivide", "ulongDivide-eb3DHEI", "(JJ)J", "ulongRemainder", "ulongRemainder-eb3DHEI", "ulongToDouble", "ulongToString", "", "base", "kotlin-stdlib"})
@JvmName(name = "UnsignedKt")
/* renamed from: kotlin.UnsignedKt */
/* loaded from: grasscutter.jar:kotlin/UnsignedKt.class */
public final class UnsignedUtils {
    @PublishedApi
    public static final int uintCompare(int v1, int v2) {
        return Intrinsics.compare(v1 ^ Integer.MIN_VALUE, v2 ^ Integer.MIN_VALUE);
    }

    @PublishedApi
    public static final int ulongCompare(long v1, long v2) {
        return Intrinsics.compare(v1 ^ Long.MIN_VALUE, v2 ^ Long.MIN_VALUE);
    }

    @PublishedApi
    /* renamed from: uintDivide-J1ME1BU  reason: not valid java name */
    public static final int m7408uintDivideJ1ME1BU(int v1, int v2) {
        return UInt.m7198constructorimpl((int) ((((long) v1) & 4294967295L) / (((long) v2) & 4294967295L)));
    }

    @PublishedApi
    /* renamed from: uintRemainder-J1ME1BU  reason: not valid java name */
    public static final int m7409uintRemainderJ1ME1BU(int v1, int v2) {
        return UInt.m7198constructorimpl((int) ((((long) v1) & 4294967295L) % (((long) v2) & 4294967295L)));
    }

    @PublishedApi
    /* renamed from: ulongDivide-eb3DHEI  reason: not valid java name */
    public static final long m7410ulongDivideeb3DHEI(long v1, long v2) {
        if (v2 < 0) {
            return ulongCompare(v1, v2) < 0 ? ULong.m7277constructorimpl(0) : ULong.m7277constructorimpl(1);
        }
        if (v1 >= 0) {
            return ULong.m7277constructorimpl(v1 / v2);
        }
        long quotient = ((v1 >>> 1) / v2) << 1;
        return ULong.m7277constructorimpl(quotient + ((long) (ulongCompare(ULong.m7277constructorimpl(v1 - (quotient * v2)), ULong.m7277constructorimpl(v2)) >= 0 ? 1 : 0)));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    @PublishedApi
    /* renamed from: ulongRemainder-eb3DHEI  reason: not valid java name */
    public static final long m7411ulongRemaindereb3DHEI(long v1, long v2) {
        if (v2 < 0) {
            if (ulongCompare(v1, v2) < 0) {
                return v1;
            }
            return ULong.m7277constructorimpl(v1 - v2);
        } else if (v1 >= 0) {
            return ULong.m7277constructorimpl(v1 % v2);
        } else {
            long rem = v1 - ((((v1 >>> 1) / v2) << 1) * v2);
            return ULong.m7277constructorimpl(rem - ((ulongCompare(ULong.m7277constructorimpl(rem), ULong.m7277constructorimpl(v2)) >= 0 ? v2 : 0) == true ? 1 : 0));
        }
    }

    @PublishedApi
    public static final int doubleToUInt(double v) {
        if (Double.isNaN(v) || v <= uintToDouble(0)) {
            return 0;
        }
        if (v >= uintToDouble(-1)) {
            return -1;
        }
        return v <= 2.147483647E9d ? UInt.m7198constructorimpl((int) v) : UInt.m7198constructorimpl(UInt.m7198constructorimpl((int) (v - ((double) Integer.MAX_VALUE))) + UInt.m7198constructorimpl(Integer.MAX_VALUE));
    }

    @PublishedApi
    public static final long doubleToULong(double v) {
        if (Double.isNaN(v) || v <= ulongToDouble(0)) {
            return 0;
        }
        if (v >= ulongToDouble(-1)) {
            return -1;
        }
        return v < 9.223372036854776E18d ? ULong.m7277constructorimpl((long) v) : ULong.m7277constructorimpl(ULong.m7277constructorimpl((long) (v - 9.223372036854776E18d)) - Long.MIN_VALUE);
    }

    @PublishedApi
    public static final double uintToDouble(int v) {
        return ((double) (v & Integer.MAX_VALUE)) + (((double) ((v >>> 31) << 30)) * ((double) 2));
    }

    @PublishedApi
    public static final double ulongToDouble(long v) {
        return (((double) (v >>> 11)) * ((double) 2048)) + ((double) (v & 2047));
    }

    @NotNull
    public static final String ulongToString(long v) {
        return ulongToString(v, 10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [long] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r0v15, types: [long] */
    /* JADX WARN: Type inference failed for: r0v17, types: [long] */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String ulongToString(long r7, int r9) {
        /*
            r0 = r7
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L_0x0015
            r0 = r7
            r1 = r9
            int r1 = kotlin.text.CharsKt.checkRadix(r1)
            java.lang.String r0 = java.lang.Long.toString(r0, r1)
            r1 = r0
            java.lang.String r2 = "toString(this, checkRadix(radix))"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            return r0
        L_0x0015:
            r0 = r7
            r1 = 1
            long r0 = r0 >>> r1
            r1 = r9
            long r1 = (long) r1
            long r0 = r0 / r1
            r1 = 1
            long r0 = r0 << r1
            r10 = r0
            r0 = r7
            r1 = r10
            r2 = r9
            long r2 = (long) r2
            long r1 = r1 * r2
            long r0 = r0 - r1
            r12 = r0
            r0 = r12
            r1 = r9
            long r1 = (long) r1
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L_0x0039
            r0 = r12
            r1 = r9
            long r1 = (long) r1
            long r0 = r0 - r1
            r12 = r0
            r0 = r10
            r1 = 1
            long r0 = r0 + r1
            r10 = r0
        L_0x0039:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r1 = r10
            r2 = r9
            int r2 = kotlin.text.CharsKt.checkRadix(r2)
            java.lang.String r1 = java.lang.Long.toString(r1, r2)
            r2 = r1
            java.lang.String r3 = "toString(this, checkRadix(radix))"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            java.lang.StringBuilder r0 = r0.append(r1)
            r1 = r12
            r2 = r9
            int r2 = kotlin.text.CharsKt.checkRadix(r2)
            java.lang.String r1 = java.lang.Long.toString(r1, r2)
            r2 = r1
            java.lang.String r3 = "toString(this, checkRadix(radix))"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.UnsignedUtils.ulongToString(long, int):java.lang.String");
    }
}
