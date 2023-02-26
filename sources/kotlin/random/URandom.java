package kotlin.random;

import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UnsignedUtils;
import kotlin.WasExperimental;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.UIntRange;
import kotlin.ranges.ULongRange;
import org.jetbrains.annotations.NotNull;

@Metadata(m371mv = {1, 6, 0}, m372k = 2, m369xi = 48, m374d1 = {"��:\n��\n\u0002\u0010\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\"\u0010��\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H��ø\u0001��¢\u0006\u0004\b\u0005\u0010\u0006\u001a\"\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\bH��ø\u0001��¢\u0006\u0004\b\t\u0010\n\u001a\u001c\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007ø\u0001��¢\u0006\u0002\u0010\u0010\u001a\u001e\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u0011\u001a\u00020\fH\u0007ø\u0001��¢\u0006\u0004\b\u0012\u0010\u0013\u001a2\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u0011\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\u000fH\u0007ø\u0001��¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0014\u0010\u0018\u001a\u00020\u0003*\u00020\rH\u0007ø\u0001��¢\u0006\u0002\u0010\u0019\u001a\u001e\u0010\u0018\u001a\u00020\u0003*\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0003H\u0007ø\u0001��¢\u0006\u0004\b\u001a\u0010\u001b\u001a&\u0010\u0018\u001a\u00020\u0003*\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0007ø\u0001��¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u001c\u0010\u0018\u001a\u00020\u0003*\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007ø\u0001��¢\u0006\u0002\u0010 \u001a\u0014\u0010!\u001a\u00020\b*\u00020\rH\u0007ø\u0001��¢\u0006\u0002\u0010\"\u001a\u001e\u0010!\u001a\u00020\b*\u00020\r2\u0006\u0010\u0004\u001a\u00020\bH\u0007ø\u0001��¢\u0006\u0004\b#\u0010$\u001a&\u0010!\u001a\u00020\b*\u00020\r2\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\bH\u0007ø\u0001��¢\u0006\u0004\b%\u0010&\u001a\u001c\u0010!\u001a\u00020\b*\u00020\r2\u0006\u0010\u001e\u001a\u00020'H\u0007ø\u0001��¢\u0006\u0002\u0010(\u0002\u0004\n\u0002\b\u0019¨\u0006)"}, m373d2 = {"checkUIntRangeBounds", "", "from", "Lkotlin/UInt;", "until", "checkUIntRangeBounds-J1ME1BU", "(II)V", "checkULongRangeBounds", "Lkotlin/ULong;", "checkULongRangeBounds-eb3DHEI", "(JJ)V", "nextUBytes", "Lkotlin/UByteArray;", "Lkotlin/random/Random;", "size", "", "(Lkotlin/random/Random;I)[B", "array", "nextUBytes-EVgfTAA", "(Lkotlin/random/Random;[B)[B", "fromIndex", "toIndex", "nextUBytes-Wvrt4B4", "(Lkotlin/random/Random;[BII)[B", "nextUInt", "(Lkotlin/random/Random;)I", "nextUInt-qCasIEU", "(Lkotlin/random/Random;I)I", "nextUInt-a8DCA5k", "(Lkotlin/random/Random;II)I", "range", "Lkotlin/ranges/UIntRange;", "(Lkotlin/random/Random;Lkotlin/ranges/UIntRange;)I", "nextULong", "(Lkotlin/random/Random;)J", "nextULong-V1Xi4fY", "(Lkotlin/random/Random;J)J", "nextULong-jmpaW-c", "(Lkotlin/random/Random;JJ)J", "Lkotlin/ranges/ULongRange;", "(Lkotlin/random/Random;Lkotlin/ranges/ULongRange;)J", "kotlin-stdlib"})
/* renamed from: kotlin.random.URandomKt */
/* loaded from: grasscutter.jar:kotlin/random/URandomKt.class */
public final class URandom {
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final int nextUInt(@NotNull Random $this$nextUInt) {
        Intrinsics.checkNotNullParameter($this$nextUInt, "<this>");
        return UInt.m7198constructorimpl($this$nextUInt.nextInt());
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: nextUInt-qCasIEU  reason: not valid java name */
    public static final int m8317nextUIntqCasIEU(@NotNull Random $this$nextUInt_u2dqCasIEU, int until) {
        Intrinsics.checkNotNullParameter($this$nextUInt_u2dqCasIEU, "$this$nextUInt");
        return m8318nextUInta8DCA5k($this$nextUInt_u2dqCasIEU, 0, until);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: nextUInt-a8DCA5k  reason: not valid java name */
    public static final int m8318nextUInta8DCA5k(@NotNull Random $this$nextUInt_u2da8DCA5k, int from, int until) {
        Intrinsics.checkNotNullParameter($this$nextUInt_u2da8DCA5k, "$this$nextUInt");
        m8324checkUIntRangeBoundsJ1ME1BU(from, until);
        return UInt.m7198constructorimpl($this$nextUInt_u2da8DCA5k.nextInt(from ^ Integer.MIN_VALUE, until ^ Integer.MIN_VALUE) ^ Integer.MIN_VALUE);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final int nextUInt(@NotNull Random $this$nextUInt, @NotNull UIntRange range) {
        Intrinsics.checkNotNullParameter($this$nextUInt, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        if (range.isEmpty()) {
            throw new IllegalArgumentException("Cannot get random in empty range: " + range);
        } else if (UnsignedUtils.uintCompare(range.m8334getLastpVg5ArA(), -1) < 0) {
            return m8318nextUInta8DCA5k($this$nextUInt, range.m8333getFirstpVg5ArA(), UInt.m7198constructorimpl(range.m8334getLastpVg5ArA() + 1));
        } else {
            if (UnsignedUtils.uintCompare(range.m8333getFirstpVg5ArA(), 0) > 0) {
                return UInt.m7198constructorimpl(m8318nextUInta8DCA5k($this$nextUInt, UInt.m7198constructorimpl(range.m8333getFirstpVg5ArA() - 1), range.m8334getLastpVg5ArA()) + 1);
            }
            return nextUInt($this$nextUInt);
        }
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final long nextULong(@NotNull Random $this$nextULong) {
        Intrinsics.checkNotNullParameter($this$nextULong, "<this>");
        return ULong.m7277constructorimpl($this$nextULong.nextLong());
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: nextULong-V1Xi4fY  reason: not valid java name */
    public static final long m8319nextULongV1Xi4fY(@NotNull Random $this$nextULong_u2dV1Xi4fY, long until) {
        Intrinsics.checkNotNullParameter($this$nextULong_u2dV1Xi4fY, "$this$nextULong");
        return m8320nextULongjmpaWc($this$nextULong_u2dV1Xi4fY, 0, until);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: nextULong-jmpaW-c  reason: not valid java name */
    public static final long m8320nextULongjmpaWc(@NotNull Random $this$nextULong_u2djmpaW_u2dc, long from, long until) {
        Intrinsics.checkNotNullParameter($this$nextULong_u2djmpaW_u2dc, "$this$nextULong");
        m8325checkULongRangeBoundseb3DHEI(from, until);
        return ULong.m7277constructorimpl($this$nextULong_u2djmpaW_u2dc.nextLong(from ^ Long.MIN_VALUE, until ^ Long.MIN_VALUE) ^ Long.MIN_VALUE);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final long nextULong(@NotNull Random $this$nextULong, @NotNull ULongRange range) {
        Intrinsics.checkNotNullParameter($this$nextULong, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        if (range.isEmpty()) {
            throw new IllegalArgumentException("Cannot get random in empty range: " + range);
        } else if (UnsignedUtils.ulongCompare(range.m8342getLastsVKNKU(), -1) < 0) {
            return m8320nextULongjmpaWc($this$nextULong, range.m8341getFirstsVKNKU(), ULong.m7277constructorimpl(range.m8342getLastsVKNKU() + ULong.m7277constructorimpl(((long) 1) & 4294967295L)));
        } else {
            if (UnsignedUtils.ulongCompare(range.m8341getFirstsVKNKU(), 0) > 0) {
                return ULong.m7277constructorimpl(m8320nextULongjmpaWc($this$nextULong, ULong.m7277constructorimpl(range.m8341getFirstsVKNKU() - ULong.m7277constructorimpl(((long) 1) & 4294967295L)), range.m8342getLastsVKNKU()) + ULong.m7277constructorimpl(((long) 1) & 4294967295L));
            }
            return nextULong($this$nextULong);
        }
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: nextUBytes-EVgfTAA  reason: not valid java name */
    public static final byte[] m8321nextUBytesEVgfTAA(@NotNull Random $this$nextUBytes_u2dEVgfTAA, @NotNull byte[] array) {
        Intrinsics.checkNotNullParameter($this$nextUBytes_u2dEVgfTAA, "$this$nextUBytes");
        Intrinsics.checkNotNullParameter(array, "array");
        $this$nextUBytes_u2dEVgfTAA.nextBytes(array);
        return array;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final byte[] nextUBytes(@NotNull Random $this$nextUBytes, int size) {
        Intrinsics.checkNotNullParameter($this$nextUBytes, "<this>");
        return UByteArray.m7137constructorimpl($this$nextUBytes.nextBytes(size));
    }

    /* renamed from: nextUBytes-Wvrt4B4$default  reason: not valid java name */
    public static /* synthetic */ byte[] m8323nextUBytesWvrt4B4$default(Random random, byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UByteArray.m7127getSizeimpl(bArr);
        }
        return m8322nextUBytesWvrt4B4(random, bArr, i, i2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: nextUBytes-Wvrt4B4  reason: not valid java name */
    public static final byte[] m8322nextUBytesWvrt4B4(@NotNull Random $this$nextUBytes_u2dWvrt4B4, @NotNull byte[] array, int fromIndex, int toIndex) {
        Intrinsics.checkNotNullParameter($this$nextUBytes_u2dWvrt4B4, "$this$nextUBytes");
        Intrinsics.checkNotNullParameter(array, "array");
        $this$nextUBytes_u2dWvrt4B4.nextBytes(array, fromIndex, toIndex);
        return array;
    }

    /* renamed from: checkUIntRangeBounds-J1ME1BU  reason: not valid java name */
    public static final void m8324checkUIntRangeBoundsJ1ME1BU(int from, int until) {
        if (!(UnsignedUtils.uintCompare(until, from) > 0)) {
            throw new IllegalArgumentException(RandomKt.boundsErrorMessage(UInt.m7199boximpl(from), UInt.m7199boximpl(until)).toString());
        }
    }

    /* renamed from: checkULongRangeBounds-eb3DHEI  reason: not valid java name */
    public static final void m8325checkULongRangeBoundseb3DHEI(long from, long until) {
        if (!(UnsignedUtils.ulongCompare(until, from) > 0)) {
            throw new IllegalArgumentException(RandomKt.boundsErrorMessage(ULong.m7278boximpl(from), ULong.m7278boximpl(until)).toString());
        }
    }
}
