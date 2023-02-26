package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.ExperimentalStdlibApi;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.UnsignedUtils;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.random.URandom;
import okhttp3.internal.p021ws.WebSocketProtocol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: _URanges.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 5, m369xi = 49, m374d1 = {"��b\n��\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\n\u001a\u001e\u0010��\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0007ø\u0001��¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001e\u0010��\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0005H\u0007ø\u0001��¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001e\u0010��\u001a\u00020\b*\u00020\b2\u0006\u0010\u0002\u001a\u00020\bH\u0007ø\u0001��¢\u0006\u0004\b\t\u0010\n\u001a\u001e\u0010��\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u000bH\u0007ø\u0001��¢\u0006\u0004\b\f\u0010\r\u001a\u001e\u0010\u000e\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0007ø\u0001��¢\u0006\u0004\b\u0010\u0010\u0004\u001a\u001e\u0010\u000e\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0007ø\u0001��¢\u0006\u0004\b\u0011\u0010\u0007\u001a\u001e\u0010\u000e\u001a\u00020\b*\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0007ø\u0001��¢\u0006\u0004\b\u0012\u0010\n\u001a\u001e\u0010\u000e\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0007ø\u0001��¢\u0006\u0004\b\u0013\u0010\r\u001a&\u0010\u0014\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0007ø\u0001��¢\u0006\u0004\b\u0015\u0010\u0016\u001a&\u0010\u0014\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0007ø\u0001��¢\u0006\u0004\b\u0017\u0010\u0018\u001a$\u0010\u0014\u001a\u00020\u0005*\u00020\u00052\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u001aH\u0007ø\u0001��¢\u0006\u0004\b\u001b\u0010\u001c\u001a&\u0010\u0014\u001a\u00020\b*\u00020\b2\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0007ø\u0001��¢\u0006\u0004\b\u001d\u0010\u001e\u001a$\u0010\u0014\u001a\u00020\b*\u00020\b2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u001aH\u0007ø\u0001��¢\u0006\u0004\b\u001f\u0010 \u001a&\u0010\u0014\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0007ø\u0001��¢\u0006\u0004\b!\u0010\"\u001a\u001f\u0010#\u001a\u00020$*\u00020%2\u0006\u0010&\u001a\u00020\u0001H\u0002ø\u0001��¢\u0006\u0004\b'\u0010(\u001a\u001f\u0010#\u001a\u00020$*\u00020%2\b\u0010)\u001a\u0004\u0018\u00010\u0005H\nø\u0001��¢\u0006\u0002\b*\u001a\u001f\u0010#\u001a\u00020$*\u00020%2\u0006\u0010&\u001a\u00020\bH\u0002ø\u0001��¢\u0006\u0004\b+\u0010,\u001a\u001f\u0010#\u001a\u00020$*\u00020%2\u0006\u0010&\u001a\u00020\u000bH\u0002ø\u0001��¢\u0006\u0004\b-\u0010.\u001a\u001f\u0010#\u001a\u00020$*\u00020/2\u0006\u0010&\u001a\u00020\u0001H\u0002ø\u0001��¢\u0006\u0004\b0\u00101\u001a\u001f\u0010#\u001a\u00020$*\u00020/2\u0006\u0010&\u001a\u00020\u0005H\u0002ø\u0001��¢\u0006\u0004\b2\u00103\u001a\u001f\u0010#\u001a\u00020$*\u00020/2\b\u0010)\u001a\u0004\u0018\u00010\bH\nø\u0001��¢\u0006\u0002\b4\u001a\u001f\u0010#\u001a\u00020$*\u00020/2\u0006\u0010&\u001a\u00020\u000bH\u0002ø\u0001��¢\u0006\u0004\b5\u00106\u001a\u001f\u00107\u001a\u000208*\u00020\u00012\u0006\u00109\u001a\u00020\u0001H\u0004ø\u0001��¢\u0006\u0004\b:\u0010;\u001a\u001f\u00107\u001a\u000208*\u00020\u00052\u0006\u00109\u001a\u00020\u0005H\u0004ø\u0001��¢\u0006\u0004\b<\u0010=\u001a\u001f\u00107\u001a\u00020>*\u00020\b2\u0006\u00109\u001a\u00020\bH\u0004ø\u0001��¢\u0006\u0004\b?\u0010@\u001a\u001f\u00107\u001a\u000208*\u00020\u000b2\u0006\u00109\u001a\u00020\u000bH\u0004ø\u0001��¢\u0006\u0004\bA\u0010B\u001a\u0015\u0010C\u001a\u00020\u0005*\u00020%H\bø\u0001��¢\u0006\u0002\u0010D\u001a\u001c\u0010C\u001a\u00020\u0005*\u00020%2\u0006\u0010C\u001a\u00020EH\u0007ø\u0001��¢\u0006\u0002\u0010F\u001a\u0015\u0010C\u001a\u00020\b*\u00020/H\bø\u0001��¢\u0006\u0002\u0010G\u001a\u001c\u0010C\u001a\u00020\b*\u00020/2\u0006\u0010C\u001a\u00020EH\u0007ø\u0001��¢\u0006\u0002\u0010H\u001a\u0012\u0010I\u001a\u0004\u0018\u00010\u0005*\u00020%H\bø\u0001��\u001a\u0019\u0010I\u001a\u0004\u0018\u00010\u0005*\u00020%2\u0006\u0010C\u001a\u00020EH\u0007ø\u0001��\u001a\u0012\u0010I\u001a\u0004\u0018\u00010\b*\u00020/H\bø\u0001��\u001a\u0019\u0010I\u001a\u0004\u0018\u00010\b*\u00020/2\u0006\u0010C\u001a\u00020EH\u0007ø\u0001��\u001a\f\u0010J\u001a\u000208*\u000208H\u0007\u001a\f\u0010J\u001a\u00020>*\u00020>H\u0007\u001a\u0015\u0010K\u001a\u000208*\u0002082\u0006\u0010K\u001a\u00020LH\u0004\u001a\u0015\u0010K\u001a\u00020>*\u00020>2\u0006\u0010K\u001a\u00020MH\u0004\u001a\u001f\u0010N\u001a\u00020%*\u00020\u00012\u0006\u00109\u001a\u00020\u0001H\u0004ø\u0001��¢\u0006\u0004\bO\u0010P\u001a\u001f\u0010N\u001a\u00020%*\u00020\u00052\u0006\u00109\u001a\u00020\u0005H\u0004ø\u0001��¢\u0006\u0004\bQ\u0010R\u001a\u001f\u0010N\u001a\u00020/*\u00020\b2\u0006\u00109\u001a\u00020\bH\u0004ø\u0001��¢\u0006\u0004\bS\u0010T\u001a\u001f\u0010N\u001a\u00020%*\u00020\u000b2\u0006\u00109\u001a\u00020\u000bH\u0004ø\u0001��¢\u0006\u0004\bU\u0010V\u0002\u0004\n\u0002\b\u0019¨\u0006W"}, m373d2 = {"coerceAtLeast", "Lkotlin/UByte;", "minimumValue", "coerceAtLeast-Kr8caGY", "(BB)B", "Lkotlin/UInt;", "coerceAtLeast-J1ME1BU", "(II)I", "Lkotlin/ULong;", "coerceAtLeast-eb3DHEI", "(JJ)J", "Lkotlin/UShort;", "coerceAtLeast-5PvTz6A", "(SS)S", "coerceAtMost", "maximumValue", "coerceAtMost-Kr8caGY", "coerceAtMost-J1ME1BU", "coerceAtMost-eb3DHEI", "coerceAtMost-5PvTz6A", "coerceIn", "coerceIn-b33U2AM", "(BBB)B", "coerceIn-WZ9TVnA", "(III)I", "range", "Lkotlin/ranges/ClosedRange;", "coerceIn-wuiCnnA", "(ILkotlin/ranges/ClosedRange;)I", "coerceIn-sambcqE", "(JJJ)J", "coerceIn-JPwROB0", "(JLkotlin/ranges/ClosedRange;)J", "coerceIn-VKSA0NQ", "(SSS)S", "contains", "", "Lkotlin/ranges/UIntRange;", "value", "contains-68kG9v0", "(Lkotlin/ranges/UIntRange;B)Z", "element", "contains-biwQdVI", "contains-fz5IDCE", "(Lkotlin/ranges/UIntRange;J)Z", "contains-ZsK3CEQ", "(Lkotlin/ranges/UIntRange;S)Z", "Lkotlin/ranges/ULongRange;", "contains-ULb-yJY", "(Lkotlin/ranges/ULongRange;B)Z", "contains-Gab390E", "(Lkotlin/ranges/ULongRange;I)Z", "contains-GYNo2lE", "contains-uhHAxoY", "(Lkotlin/ranges/ULongRange;S)Z", "downTo", "Lkotlin/ranges/UIntProgression;", "to", "downTo-Kr8caGY", "(BB)Lkotlin/ranges/UIntProgression;", "downTo-J1ME1BU", "(II)Lkotlin/ranges/UIntProgression;", "Lkotlin/ranges/ULongProgression;", "downTo-eb3DHEI", "(JJ)Lkotlin/ranges/ULongProgression;", "downTo-5PvTz6A", "(SS)Lkotlin/ranges/UIntProgression;", "random", "(Lkotlin/ranges/UIntRange;)I", "Lkotlin/random/Random;", "(Lkotlin/ranges/UIntRange;Lkotlin/random/Random;)I", "(Lkotlin/ranges/ULongRange;)J", "(Lkotlin/ranges/ULongRange;Lkotlin/random/Random;)J", "randomOrNull", "reversed", "step", "", "", "until", "until-Kr8caGY", "(BB)Lkotlin/ranges/UIntRange;", "until-J1ME1BU", "(II)Lkotlin/ranges/UIntRange;", "until-eb3DHEI", "(JJ)Lkotlin/ranges/ULongRange;", "until-5PvTz6A", "(SS)Lkotlin/ranges/UIntRange;", "kotlin-stdlib"}, m368xs = "kotlin/ranges/URangesKt")
/* loaded from: grasscutter.jar:kotlin/ranges/URangesKt___URangesKt.class */
class URangesKt___URangesKt {
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    private static final int random(UIntRange $this$random) {
        Intrinsics.checkNotNullParameter($this$random, "<this>");
        return _URanges.random($this$random, Random.Default);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    private static final long random(ULongRange $this$random) {
        Intrinsics.checkNotNullParameter($this$random, "<this>");
        return _URanges.random($this$random, Random.Default);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final int random(@NotNull UIntRange $this$random, @NotNull Random random) {
        Intrinsics.checkNotNullParameter($this$random, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        try {
            return URandom.nextUInt(random, $this$random);
        } catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final long random(@NotNull ULongRange $this$random, @NotNull Random random) {
        Intrinsics.checkNotNullParameter($this$random, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        try {
            return URandom.nextULong(random, $this$random);
        } catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class, ExperimentalUnsignedTypes.class})
    @InlineOnly
    private static final UInt randomOrNull(UIntRange $this$randomOrNull) {
        Intrinsics.checkNotNullParameter($this$randomOrNull, "<this>");
        return _URanges.randomOrNull($this$randomOrNull, Random.Default);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class, ExperimentalUnsignedTypes.class})
    @InlineOnly
    private static final ULong randomOrNull(ULongRange $this$randomOrNull) {
        Intrinsics.checkNotNullParameter($this$randomOrNull, "<this>");
        return _URanges.randomOrNull($this$randomOrNull, Random.Default);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class, ExperimentalUnsignedTypes.class})
    @Nullable
    public static final UInt randomOrNull(@NotNull UIntRange $this$randomOrNull, @NotNull Random random) {
        Intrinsics.checkNotNullParameter($this$randomOrNull, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if ($this$randomOrNull.isEmpty()) {
            return null;
        }
        return UInt.m7199boximpl(URandom.nextUInt(random, $this$randomOrNull));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class, ExperimentalUnsignedTypes.class})
    @Nullable
    public static final ULong randomOrNull(@NotNull ULongRange $this$randomOrNull, @NotNull Random random) {
        Intrinsics.checkNotNullParameter($this$randomOrNull, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if ($this$randomOrNull.isEmpty()) {
            return null;
        }
        return ULong.m7278boximpl(URandom.nextULong(random, $this$randomOrNull));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    /* renamed from: contains-biwQdVI  reason: not valid java name */
    private static final boolean m8349containsbiwQdVI(UIntRange $this$contains_u2dbiwQdVI, UInt element) {
        Intrinsics.checkNotNullParameter($this$contains_u2dbiwQdVI, "$this$contains");
        return element != null && $this$contains_u2dbiwQdVI.m8339containsWZ4Q5Ns(element.m7200unboximpl());
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    /* renamed from: contains-GYNo2lE  reason: not valid java name */
    private static final boolean m8350containsGYNo2lE(ULongRange $this$contains_u2dGYNo2lE, ULong element) {
        Intrinsics.checkNotNullParameter($this$contains_u2dGYNo2lE, "$this$contains");
        return element != null && $this$contains_u2dGYNo2lE.m8347containsVKZWuLQ(element.m7279unboximpl());
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: contains-68kG9v0  reason: not valid java name */
    public static final boolean m8351contains68kG9v0(@NotNull UIntRange $this$contains_u2d68kG9v0, byte value) {
        Intrinsics.checkNotNullParameter($this$contains_u2d68kG9v0, "$this$contains");
        return $this$contains_u2d68kG9v0.m8339containsWZ4Q5Ns(UInt.m7198constructorimpl(value & 255));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: contains-ULb-yJY  reason: not valid java name */
    public static final boolean m8352containsULbyJY(@NotNull ULongRange $this$contains_u2dULb_u2dyJY, byte value) {
        Intrinsics.checkNotNullParameter($this$contains_u2dULb_u2dyJY, "$this$contains");
        return $this$contains_u2dULb_u2dyJY.m8347containsVKZWuLQ(ULong.m7277constructorimpl(((long) value) & 255));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: contains-Gab390E  reason: not valid java name */
    public static final boolean m8353containsGab390E(@NotNull ULongRange $this$contains_u2dGab390E, int value) {
        Intrinsics.checkNotNullParameter($this$contains_u2dGab390E, "$this$contains");
        return $this$contains_u2dGab390E.m8347containsVKZWuLQ(ULong.m7277constructorimpl(((long) value) & 4294967295L));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: contains-fz5IDCE  reason: not valid java name */
    public static final boolean m8354containsfz5IDCE(@NotNull UIntRange $this$contains_u2dfz5IDCE, long value) {
        Intrinsics.checkNotNullParameter($this$contains_u2dfz5IDCE, "$this$contains");
        return ULong.m7277constructorimpl(value >>> 32) == 0 && $this$contains_u2dfz5IDCE.m8339containsWZ4Q5Ns(UInt.m7198constructorimpl((int) value));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: contains-ZsK3CEQ  reason: not valid java name */
    public static final boolean m8355containsZsK3CEQ(@NotNull UIntRange $this$contains_u2dZsK3CEQ, short value) {
        Intrinsics.checkNotNullParameter($this$contains_u2dZsK3CEQ, "$this$contains");
        return $this$contains_u2dZsK3CEQ.m8339containsWZ4Q5Ns(UInt.m7198constructorimpl(value & 65535));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: contains-uhHAxoY  reason: not valid java name */
    public static final boolean m8356containsuhHAxoY(@NotNull ULongRange $this$contains_u2duhHAxoY, short value) {
        Intrinsics.checkNotNullParameter($this$contains_u2duhHAxoY, "$this$contains");
        return $this$contains_u2duhHAxoY.m8347containsVKZWuLQ(ULong.m7277constructorimpl(((long) value) & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @NotNull
    /* renamed from: downTo-Kr8caGY  reason: not valid java name */
    public static final UIntProgression m8357downToKr8caGY(byte $this$downTo_u2dKr8caGY, byte to) {
        return UIntProgression.Companion.m8336fromClosedRangeNkh28Cs(UInt.m7198constructorimpl($this$downTo_u2dKr8caGY & 255), UInt.m7198constructorimpl(to & 255), -1);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @NotNull
    /* renamed from: downTo-J1ME1BU  reason: not valid java name */
    public static final UIntProgression m8358downToJ1ME1BU(int $this$downTo_u2dJ1ME1BU, int to) {
        return UIntProgression.Companion.m8336fromClosedRangeNkh28Cs($this$downTo_u2dJ1ME1BU, to, -1);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @NotNull
    /* renamed from: downTo-eb3DHEI  reason: not valid java name */
    public static final ULongProgression m8359downToeb3DHEI(long $this$downTo_u2deb3DHEI, long to) {
        return ULongProgression.Companion.m8344fromClosedRange7ftBX0g($this$downTo_u2deb3DHEI, to, -1);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @NotNull
    /* renamed from: downTo-5PvTz6A  reason: not valid java name */
    public static final UIntProgression m8360downTo5PvTz6A(short $this$downTo_u2d5PvTz6A, short to) {
        return UIntProgression.Companion.m8336fromClosedRangeNkh28Cs(UInt.m7198constructorimpl($this$downTo_u2d5PvTz6A & 65535), UInt.m7198constructorimpl(to & 65535), -1);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @NotNull
    public static final UIntProgression reversed(@NotNull UIntProgression $this$reversed) {
        Intrinsics.checkNotNullParameter($this$reversed, "<this>");
        return UIntProgression.Companion.m8336fromClosedRangeNkh28Cs($this$reversed.m8334getLastpVg5ArA(), $this$reversed.m8333getFirstpVg5ArA(), -$this$reversed.getStep());
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @NotNull
    public static final ULongProgression reversed(@NotNull ULongProgression $this$reversed) {
        Intrinsics.checkNotNullParameter($this$reversed, "<this>");
        return ULongProgression.Companion.m8344fromClosedRange7ftBX0g($this$reversed.m8342getLastsVKNKU(), $this$reversed.m8341getFirstsVKNKU(), -$this$reversed.getStep());
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @NotNull
    public static final UIntProgression step(@NotNull UIntProgression $this$step, int step) {
        Intrinsics.checkNotNullParameter($this$step, "<this>");
        RangesKt.checkStepIsPositive(step > 0, Integer.valueOf(step));
        return UIntProgression.Companion.m8336fromClosedRangeNkh28Cs($this$step.m8333getFirstpVg5ArA(), $this$step.m8334getLastpVg5ArA(), $this$step.getStep() > 0 ? step : -step);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [long] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v8 */
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @NotNull
    public static final ULongProgression step(@NotNull ULongProgression $this$step, long j) {
        Intrinsics.checkNotNullParameter($this$step, "<this>");
        RangesKt.checkStepIsPositive(j > 0, Long.valueOf((long) j));
        return ULongProgression.Companion.m8344fromClosedRange7ftBX0g($this$step.m8341getFirstsVKNKU(), $this$step.m8342getLastsVKNKU(), (($this$step.getStep() > 0 ? 1 : ($this$step.getStep() == 0 ? 0 : -1)) > 0 ? j : -j) == true ? 1 : 0);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @NotNull
    /* renamed from: until-Kr8caGY  reason: not valid java name */
    public static final UIntRange m8361untilKr8caGY(byte $this$until_u2dKr8caGY, byte to) {
        return Intrinsics.compare(to & 255, 0 & 255) <= 0 ? UIntRange.Companion.getEMPTY() : new UIntRange(UInt.m7198constructorimpl($this$until_u2dKr8caGY & 255), UInt.m7198constructorimpl(UInt.m7198constructorimpl(to & 255) - 1), null);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @NotNull
    /* renamed from: until-J1ME1BU  reason: not valid java name */
    public static final UIntRange m8362untilJ1ME1BU(int $this$until_u2dJ1ME1BU, int to) {
        return UnsignedUtils.uintCompare(to, 0) <= 0 ? UIntRange.Companion.getEMPTY() : new UIntRange($this$until_u2dJ1ME1BU, UInt.m7198constructorimpl(to - 1), null);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @NotNull
    /* renamed from: until-eb3DHEI  reason: not valid java name */
    public static final ULongRange m8363untileb3DHEI(long $this$until_u2deb3DHEI, long to) {
        return UnsignedUtils.ulongCompare(to, 0) <= 0 ? ULongRange.Companion.getEMPTY() : new ULongRange($this$until_u2deb3DHEI, ULong.m7277constructorimpl(to - ULong.m7277constructorimpl(((long) 1) & 4294967295L)), null);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @NotNull
    /* renamed from: until-5PvTz6A  reason: not valid java name */
    public static final UIntRange m8364until5PvTz6A(short $this$until_u2d5PvTz6A, short to) {
        return Intrinsics.compare(to & 65535, 0 & 65535) <= 0 ? UIntRange.Companion.getEMPTY() : new UIntRange(UInt.m7198constructorimpl($this$until_u2d5PvTz6A & 65535), UInt.m7198constructorimpl(UInt.m7198constructorimpl(to & 65535) - 1), null);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: coerceAtLeast-J1ME1BU  reason: not valid java name */
    public static final int m8365coerceAtLeastJ1ME1BU(int $this$coerceAtLeast_u2dJ1ME1BU, int minimumValue) {
        return UnsignedUtils.uintCompare($this$coerceAtLeast_u2dJ1ME1BU, minimumValue) < 0 ? minimumValue : $this$coerceAtLeast_u2dJ1ME1BU;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: coerceAtLeast-eb3DHEI  reason: not valid java name */
    public static final long m8366coerceAtLeasteb3DHEI(long $this$coerceAtLeast_u2deb3DHEI, long minimumValue) {
        return UnsignedUtils.ulongCompare($this$coerceAtLeast_u2deb3DHEI, minimumValue) < 0 ? minimumValue : $this$coerceAtLeast_u2deb3DHEI;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: coerceAtLeast-Kr8caGY  reason: not valid java name */
    public static final byte m8367coerceAtLeastKr8caGY(byte $this$coerceAtLeast_u2dKr8caGY, byte minimumValue) {
        return Intrinsics.compare($this$coerceAtLeast_u2dKr8caGY & 255, minimumValue & 255) < 0 ? minimumValue : $this$coerceAtLeast_u2dKr8caGY;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: coerceAtLeast-5PvTz6A  reason: not valid java name */
    public static final short m8368coerceAtLeast5PvTz6A(short $this$coerceAtLeast_u2d5PvTz6A, short minimumValue) {
        return Intrinsics.compare($this$coerceAtLeast_u2d5PvTz6A & 65535, minimumValue & 65535) < 0 ? minimumValue : $this$coerceAtLeast_u2d5PvTz6A;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: coerceAtMost-J1ME1BU  reason: not valid java name */
    public static final int m8369coerceAtMostJ1ME1BU(int $this$coerceAtMost_u2dJ1ME1BU, int maximumValue) {
        return UnsignedUtils.uintCompare($this$coerceAtMost_u2dJ1ME1BU, maximumValue) > 0 ? maximumValue : $this$coerceAtMost_u2dJ1ME1BU;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: coerceAtMost-eb3DHEI  reason: not valid java name */
    public static final long m8370coerceAtMosteb3DHEI(long $this$coerceAtMost_u2deb3DHEI, long maximumValue) {
        return UnsignedUtils.ulongCompare($this$coerceAtMost_u2deb3DHEI, maximumValue) > 0 ? maximumValue : $this$coerceAtMost_u2deb3DHEI;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: coerceAtMost-Kr8caGY  reason: not valid java name */
    public static final byte m8371coerceAtMostKr8caGY(byte $this$coerceAtMost_u2dKr8caGY, byte maximumValue) {
        return Intrinsics.compare($this$coerceAtMost_u2dKr8caGY & 255, maximumValue & 255) > 0 ? maximumValue : $this$coerceAtMost_u2dKr8caGY;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: coerceAtMost-5PvTz6A  reason: not valid java name */
    public static final short m8372coerceAtMost5PvTz6A(short $this$coerceAtMost_u2d5PvTz6A, short maximumValue) {
        return Intrinsics.compare($this$coerceAtMost_u2d5PvTz6A & 65535, maximumValue & 65535) > 0 ? maximumValue : $this$coerceAtMost_u2d5PvTz6A;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: coerceIn-WZ9TVnA  reason: not valid java name */
    public static final int m8373coerceInWZ9TVnA(int $this$coerceIn_u2dWZ9TVnA, int minimumValue, int maximumValue) {
        if (UnsignedUtils.uintCompare(minimumValue, maximumValue) <= 0) {
            return UnsignedUtils.uintCompare($this$coerceIn_u2dWZ9TVnA, minimumValue) < 0 ? minimumValue : UnsignedUtils.uintCompare($this$coerceIn_u2dWZ9TVnA, maximumValue) > 0 ? maximumValue : $this$coerceIn_u2dWZ9TVnA;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((Object) UInt.m7195toStringimpl(maximumValue)) + " is less than minimum " + ((Object) UInt.m7195toStringimpl(minimumValue)) + '.');
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: coerceIn-sambcqE  reason: not valid java name */
    public static final long m8374coerceInsambcqE(long $this$coerceIn_u2dsambcqE, long minimumValue, long maximumValue) {
        if (UnsignedUtils.ulongCompare(minimumValue, maximumValue) <= 0) {
            return UnsignedUtils.ulongCompare($this$coerceIn_u2dsambcqE, minimumValue) < 0 ? minimumValue : UnsignedUtils.ulongCompare($this$coerceIn_u2dsambcqE, maximumValue) > 0 ? maximumValue : $this$coerceIn_u2dsambcqE;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((Object) ULong.m7274toStringimpl(maximumValue)) + " is less than minimum " + ((Object) ULong.m7274toStringimpl(minimumValue)) + '.');
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: coerceIn-b33U2AM  reason: not valid java name */
    public static final byte m8375coerceInb33U2AM(byte $this$coerceIn_u2db33U2AM, byte minimumValue, byte maximumValue) {
        if (Intrinsics.compare(minimumValue & 255, maximumValue & 255) <= 0) {
            return Intrinsics.compare($this$coerceIn_u2db33U2AM & 255, minimumValue & 255) < 0 ? minimumValue : Intrinsics.compare($this$coerceIn_u2db33U2AM & 255, maximumValue & 255) > 0 ? maximumValue : $this$coerceIn_u2db33U2AM;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((Object) UByte.m7116toStringimpl(maximumValue)) + " is less than minimum " + ((Object) UByte.m7116toStringimpl(minimumValue)) + '.');
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: coerceIn-VKSA0NQ  reason: not valid java name */
    public static final short m8376coerceInVKSA0NQ(short $this$coerceIn_u2dVKSA0NQ, short minimumValue, short maximumValue) {
        if (Intrinsics.compare(minimumValue & 65535, maximumValue & 65535) <= 0) {
            return Intrinsics.compare($this$coerceIn_u2dVKSA0NQ & 65535, minimumValue & 65535) < 0 ? minimumValue : Intrinsics.compare($this$coerceIn_u2dVKSA0NQ & 65535, maximumValue & 65535) > 0 ? maximumValue : $this$coerceIn_u2dVKSA0NQ;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((Object) UShort.m7380toStringimpl(maximumValue)) + " is less than minimum " + ((Object) UShort.m7380toStringimpl(minimumValue)) + '.');
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: coerceIn-wuiCnnA  reason: not valid java name */
    public static final int m8377coerceInwuiCnnA(int $this$coerceIn_u2dwuiCnnA, @NotNull ClosedRange<UInt> closedRange) {
        Intrinsics.checkNotNullParameter(closedRange, "range");
        if (closedRange instanceof ClosedFloatingPointRange) {
            return ((UInt) RangesKt.coerceIn(UInt.m7199boximpl($this$coerceIn_u2dwuiCnnA), (ClosedFloatingPointRange<UInt>) ((ClosedFloatingPointRange) closedRange))).m7200unboximpl();
        }
        if (!closedRange.isEmpty()) {
            return UnsignedUtils.uintCompare($this$coerceIn_u2dwuiCnnA, closedRange.getStart().m7200unboximpl()) < 0 ? closedRange.getStart().m7200unboximpl() : UnsignedUtils.uintCompare($this$coerceIn_u2dwuiCnnA, closedRange.getEndInclusive().m7200unboximpl()) > 0 ? closedRange.getEndInclusive().m7200unboximpl() : $this$coerceIn_u2dwuiCnnA;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + closedRange + '.');
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: coerceIn-JPwROB0  reason: not valid java name */
    public static final long m8378coerceInJPwROB0(long $this$coerceIn_u2dJPwROB0, @NotNull ClosedRange<ULong> closedRange) {
        Intrinsics.checkNotNullParameter(closedRange, "range");
        if (closedRange instanceof ClosedFloatingPointRange) {
            return ((ULong) RangesKt.coerceIn(ULong.m7278boximpl($this$coerceIn_u2dJPwROB0), (ClosedFloatingPointRange<ULong>) ((ClosedFloatingPointRange) closedRange))).m7279unboximpl();
        }
        if (!closedRange.isEmpty()) {
            return UnsignedUtils.ulongCompare($this$coerceIn_u2dJPwROB0, closedRange.getStart().m7279unboximpl()) < 0 ? closedRange.getStart().m7279unboximpl() : UnsignedUtils.ulongCompare($this$coerceIn_u2dJPwROB0, closedRange.getEndInclusive().m7279unboximpl()) > 0 ? closedRange.getEndInclusive().m7279unboximpl() : $this$coerceIn_u2dJPwROB0;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + closedRange + '.');
    }
}
