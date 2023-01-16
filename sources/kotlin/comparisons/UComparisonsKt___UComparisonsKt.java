package kotlin.comparisons;

import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.UShortArray;
import kotlin.UnsignedUtils;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: _UComparisons.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 5, m369xi = 49, m374d1 = {"��B\n��\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\u001a\"\u0010��\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0007ø\u0001��¢\u0006\u0004\b\u0004\u0010\u0005\u001a+\u0010��\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\bø\u0001��¢\u0006\u0004\b\u0007\u0010\b\u001a&\u0010��\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\n\u0010\t\u001a\u00020\n\"\u00020\u0001H\u0007ø\u0001��¢\u0006\u0004\b\u000b\u0010\f\u001a\"\u0010��\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\rH\u0007ø\u0001��¢\u0006\u0004\b\u000e\u0010\u000f\u001a+\u0010��\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\rH\bø\u0001��¢\u0006\u0004\b\u0010\u0010\u0011\u001a&\u0010��\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\n\u0010\t\u001a\u00020\u0012\"\u00020\rH\u0007ø\u0001��¢\u0006\u0004\b\u0013\u0010\u0014\u001a\"\u0010��\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0015H\u0007ø\u0001��¢\u0006\u0004\b\u0016\u0010\u0017\u001a+\u0010��\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0015H\bø\u0001��¢\u0006\u0004\b\u0018\u0010\u0019\u001a&\u0010��\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\n\u0010\t\u001a\u00020\u001a\"\u00020\u0015H\u0007ø\u0001��¢\u0006\u0004\b\u001b\u0010\u001c\u001a\"\u0010��\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u001dH\u0007ø\u0001��¢\u0006\u0004\b\u001e\u0010\u001f\u001a+\u0010��\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u001d2\u0006\u0010\u0006\u001a\u00020\u001dH\bø\u0001��¢\u0006\u0004\b \u0010!\u001a&\u0010��\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\n\u0010\t\u001a\u00020\"\"\u00020\u001dH\u0007ø\u0001��¢\u0006\u0004\b#\u0010$\u001a\"\u0010%\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0007ø\u0001��¢\u0006\u0004\b&\u0010\u0005\u001a+\u0010%\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\bø\u0001��¢\u0006\u0004\b'\u0010\b\u001a&\u0010%\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\n\u0010\t\u001a\u00020\n\"\u00020\u0001H\u0007ø\u0001��¢\u0006\u0004\b(\u0010\f\u001a\"\u0010%\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\rH\u0007ø\u0001��¢\u0006\u0004\b)\u0010\u000f\u001a+\u0010%\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\rH\bø\u0001��¢\u0006\u0004\b*\u0010\u0011\u001a&\u0010%\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\n\u0010\t\u001a\u00020\u0012\"\u00020\rH\u0007ø\u0001��¢\u0006\u0004\b+\u0010\u0014\u001a\"\u0010%\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0015H\u0007ø\u0001��¢\u0006\u0004\b,\u0010\u0017\u001a+\u0010%\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0015H\bø\u0001��¢\u0006\u0004\b-\u0010\u0019\u001a&\u0010%\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\n\u0010\t\u001a\u00020\u001a\"\u00020\u0015H\u0007ø\u0001��¢\u0006\u0004\b.\u0010\u001c\u001a\"\u0010%\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u001dH\u0007ø\u0001��¢\u0006\u0004\b/\u0010\u001f\u001a+\u0010%\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u001d2\u0006\u0010\u0006\u001a\u00020\u001dH\bø\u0001��¢\u0006\u0004\b0\u0010!\u001a&\u0010%\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\n\u0010\t\u001a\u00020\"\"\u00020\u001dH\u0007ø\u0001��¢\u0006\u0004\b1\u0010$\u0002\u0004\n\u0002\b\u0019¨\u00062"}, m373d2 = {"maxOf", "Lkotlin/UByte;", "a", "b", "maxOf-Kr8caGY", "(BB)B", "c", "maxOf-b33U2AM", "(BBB)B", "other", "Lkotlin/UByteArray;", "maxOf-Wr6uiD8", "(B[B)B", "Lkotlin/UInt;", "maxOf-J1ME1BU", "(II)I", "maxOf-WZ9TVnA", "(III)I", "Lkotlin/UIntArray;", "maxOf-Md2H83M", "(I[I)I", "Lkotlin/ULong;", "maxOf-eb3DHEI", "(JJ)J", "maxOf-sambcqE", "(JJJ)J", "Lkotlin/ULongArray;", "maxOf-R03FKyM", "(J[J)J", "Lkotlin/UShort;", "maxOf-5PvTz6A", "(SS)S", "maxOf-VKSA0NQ", "(SSS)S", "Lkotlin/UShortArray;", "maxOf-t1qELG4", "(S[S)S", "minOf", "minOf-Kr8caGY", "minOf-b33U2AM", "minOf-Wr6uiD8", "minOf-J1ME1BU", "minOf-WZ9TVnA", "minOf-Md2H83M", "minOf-eb3DHEI", "minOf-sambcqE", "minOf-R03FKyM", "minOf-5PvTz6A", "minOf-VKSA0NQ", "minOf-t1qELG4", "kotlin-stdlib"}, m368xs = "kotlin/comparisons/UComparisonsKt")
/* loaded from: grasscutter.jar:kotlin/comparisons/UComparisonsKt___UComparisonsKt.class */
class UComparisonsKt___UComparisonsKt {
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: maxOf-J1ME1BU  reason: not valid java name */
    public static final int m8242maxOfJ1ME1BU(int a, int b) {
        return UnsignedUtils.uintCompare(a, b) >= 0 ? a : b;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: maxOf-eb3DHEI  reason: not valid java name */
    public static final long m8243maxOfeb3DHEI(long a, long b) {
        return UnsignedUtils.ulongCompare(a, b) >= 0 ? a : b;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: maxOf-Kr8caGY  reason: not valid java name */
    public static final byte m8244maxOfKr8caGY(byte a, byte b) {
        return Intrinsics.compare(a & 255, b & 255) >= 0 ? a : b;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: maxOf-5PvTz6A  reason: not valid java name */
    public static final short m8245maxOf5PvTz6A(short a, short b) {
        return Intrinsics.compare(a & 65535, b & 65535) >= 0 ? a : b;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    /* renamed from: maxOf-WZ9TVnA  reason: not valid java name */
    private static final int m8246maxOfWZ9TVnA(int a, int b, int c) {
        return _UComparisons.m8242maxOfJ1ME1BU(a, _UComparisons.m8242maxOfJ1ME1BU(b, c));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    /* renamed from: maxOf-sambcqE  reason: not valid java name */
    private static final long m8247maxOfsambcqE(long a, long b, long c) {
        return _UComparisons.m8243maxOfeb3DHEI(a, _UComparisons.m8243maxOfeb3DHEI(b, c));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    /* renamed from: maxOf-b33U2AM  reason: not valid java name */
    private static final byte m8248maxOfb33U2AM(byte a, byte b, byte c) {
        return _UComparisons.m8244maxOfKr8caGY(a, _UComparisons.m8244maxOfKr8caGY(b, c));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    /* renamed from: maxOf-VKSA0NQ  reason: not valid java name */
    private static final short m8249maxOfVKSA0NQ(short a, short b, short c) {
        return _UComparisons.m8245maxOf5PvTz6A(a, _UComparisons.m8245maxOf5PvTz6A(b, c));
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: maxOf-Md2H83M  reason: not valid java name */
    public static final int m8250maxOfMd2H83M(int a, @NotNull int... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int max = a;
        int r0 = UIntArray.m7209getSizeimpl(other);
        for (int i = 0; i < r0; i++) {
            max = _UComparisons.m8242maxOfJ1ME1BU(max, UIntArray.m7207getpVg5ArA(other, i));
        }
        return max;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [long] */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [long] */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    @kotlin.SinceKotlin(version = "1.4")
    @kotlin.ExperimentalUnsignedTypes
    /* renamed from: maxOf-R03FKyM  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final long m8251maxOfR03FKyM(long r5, @org.jetbrains.annotations.NotNull long... r7) {
        /*
            r0 = r7
            java.lang.String r1 = "other"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r0 = r5
            r8 = r0
            r0 = 0
            r10 = r0
            r0 = r7
            int r0 = kotlin.ULongArray.m7288getSizeimpl(r0)
            r11 = r0
        L_0x0011:
            r0 = r10
            r1 = r11
            if (r0 >= r1) goto L_0x002d
            r0 = r7
            r1 = r10
            long r0 = kotlin.ULongArray.m7286getsVKNKU(r0, r1)
            r12 = r0
            r0 = r8
            r1 = r12
            long r0 = kotlin.comparisons._UComparisons.m8243maxOfeb3DHEI(r0, r1)
            r8 = r0
            int r10 = r10 + 1
            goto L_0x0011
        L_0x002d:
            r0 = r8
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.comparisons.UComparisonsKt___UComparisonsKt.m8251maxOfR03FKyM(long, long[]):long");
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: maxOf-Wr6uiD8  reason: not valid java name */
    public static final byte m8252maxOfWr6uiD8(byte a, @NotNull byte... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        byte max = a;
        int r0 = UByteArray.m7130getSizeimpl(other);
        for (int i = 0; i < r0; i++) {
            max = _UComparisons.m8244maxOfKr8caGY(max, UByteArray.m7128getw2LRezQ(other, i));
        }
        return max;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: maxOf-t1qELG4  reason: not valid java name */
    public static final short m8253maxOft1qELG4(short a, @NotNull short... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        short max = a;
        int r0 = UShortArray.m7394getSizeimpl(other);
        for (int i = 0; i < r0; i++) {
            max = _UComparisons.m8245maxOf5PvTz6A(max, UShortArray.m7392getMh2AYeg(other, i));
        }
        return max;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: minOf-J1ME1BU  reason: not valid java name */
    public static final int m8254minOfJ1ME1BU(int a, int b) {
        return UnsignedUtils.uintCompare(a, b) <= 0 ? a : b;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: minOf-eb3DHEI  reason: not valid java name */
    public static final long m8255minOfeb3DHEI(long a, long b) {
        return UnsignedUtils.ulongCompare(a, b) <= 0 ? a : b;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: minOf-Kr8caGY  reason: not valid java name */
    public static final byte m8256minOfKr8caGY(byte a, byte b) {
        return Intrinsics.compare(a & 255, b & 255) <= 0 ? a : b;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: minOf-5PvTz6A  reason: not valid java name */
    public static final short m8257minOf5PvTz6A(short a, short b) {
        return Intrinsics.compare(a & 65535, b & 65535) <= 0 ? a : b;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    /* renamed from: minOf-WZ9TVnA  reason: not valid java name */
    private static final int m8258minOfWZ9TVnA(int a, int b, int c) {
        return _UComparisons.m8254minOfJ1ME1BU(a, _UComparisons.m8254minOfJ1ME1BU(b, c));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    /* renamed from: minOf-sambcqE  reason: not valid java name */
    private static final long m8259minOfsambcqE(long a, long b, long c) {
        return _UComparisons.m8255minOfeb3DHEI(a, _UComparisons.m8255minOfeb3DHEI(b, c));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    /* renamed from: minOf-b33U2AM  reason: not valid java name */
    private static final byte m8260minOfb33U2AM(byte a, byte b, byte c) {
        return _UComparisons.m8256minOfKr8caGY(a, _UComparisons.m8256minOfKr8caGY(b, c));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    /* renamed from: minOf-VKSA0NQ  reason: not valid java name */
    private static final short m8261minOfVKSA0NQ(short a, short b, short c) {
        return _UComparisons.m8257minOf5PvTz6A(a, _UComparisons.m8257minOf5PvTz6A(b, c));
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: minOf-Md2H83M  reason: not valid java name */
    public static final int m8262minOfMd2H83M(int a, @NotNull int... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int min = a;
        int r0 = UIntArray.m7209getSizeimpl(other);
        for (int i = 0; i < r0; i++) {
            min = _UComparisons.m8254minOfJ1ME1BU(min, UIntArray.m7207getpVg5ArA(other, i));
        }
        return min;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [long] */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [long] */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    @kotlin.SinceKotlin(version = "1.4")
    @kotlin.ExperimentalUnsignedTypes
    /* renamed from: minOf-R03FKyM  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final long m8263minOfR03FKyM(long r5, @org.jetbrains.annotations.NotNull long... r7) {
        /*
            r0 = r7
            java.lang.String r1 = "other"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r0 = r5
            r8 = r0
            r0 = 0
            r10 = r0
            r0 = r7
            int r0 = kotlin.ULongArray.m7288getSizeimpl(r0)
            r11 = r0
        L_0x0011:
            r0 = r10
            r1 = r11
            if (r0 >= r1) goto L_0x002d
            r0 = r7
            r1 = r10
            long r0 = kotlin.ULongArray.m7286getsVKNKU(r0, r1)
            r12 = r0
            r0 = r8
            r1 = r12
            long r0 = kotlin.comparisons._UComparisons.m8255minOfeb3DHEI(r0, r1)
            r8 = r0
            int r10 = r10 + 1
            goto L_0x0011
        L_0x002d:
            r0 = r8
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.comparisons.UComparisonsKt___UComparisonsKt.m8263minOfR03FKyM(long, long[]):long");
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: minOf-Wr6uiD8  reason: not valid java name */
    public static final byte m8264minOfWr6uiD8(byte a, @NotNull byte... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        byte min = a;
        int r0 = UByteArray.m7130getSizeimpl(other);
        for (int i = 0; i < r0; i++) {
            min = _UComparisons.m8256minOfKr8caGY(min, UByteArray.m7128getw2LRezQ(other, i));
        }
        return min;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: minOf-t1qELG4  reason: not valid java name */
    public static final short m8265minOft1qELG4(short a, @NotNull short... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        short min = a;
        int r0 = UShortArray.m7394getSizeimpl(other);
        for (int i = 0; i < r0; i++) {
            min = _UComparisons.m8257minOf5PvTz6A(min, UShortArray.m7392getMh2AYeg(other, i));
        }
        return min;
    }
}
