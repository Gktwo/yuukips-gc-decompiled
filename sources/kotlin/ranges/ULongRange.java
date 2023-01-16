package kotlin.ranges;

import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.ULong;
import kotlin.UnsignedUtils;
import kotlin.WasExperimental;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jline.console.Printer;
import p001ch.qos.logback.classic.pattern.CallerDataConverter;

/* compiled from: ULongRange.kt */
@SinceKotlin(version = "1.5")
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��2\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010��\n��\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018�� \u00172\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0017B\u0018\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003ø\u0001��¢\u0006\u0002\u0010\u0006J\u001b\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0002ø\u0001��¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u001a\u0010\u0005\u001a\u00020\u00038VX\u0004ø\u0001��ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\u00020\u00038VX\u0004ø\u0001��ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\t\u0010\bø\u0001��\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0018"}, m373d2 = {"Lkotlin/ranges/ULongRange;", "Lkotlin/ranges/ULongProgression;", "Lkotlin/ranges/ClosedRange;", "Lkotlin/ULong;", "start", "endInclusive", "(JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getEndInclusive-s-VKNKU", "()J", "getStart-s-VKNKU", "contains", "", "value", "contains-VKZWuLQ", "(J)Z", "equals", "other", "", "hashCode", "", "isEmpty", Printer.TO_STRING, "", "Companion", "kotlin-stdlib"})
@WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
/* loaded from: grasscutter.jar:kotlin/ranges/ULongRange.class */
public final class ULongRange extends ULongProgression implements ClosedRange<ULong> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final ULongRange EMPTY = new ULongRange(-1, 0, null);

    public /* synthetic */ ULongRange(long start, long endInclusive, DefaultConstructorMarker $constructor_marker) {
        this(start, endInclusive);
    }

    /* Return type fixed from 'java.lang.Comparable' to match base method */
    @Override // kotlin.ranges.ClosedRange
    public /* bridge */ /* synthetic */ ULong getStart() {
        return ULong.m7281boximpl(m8348getStartsVKNKU());
    }

    /* Return type fixed from 'java.lang.Comparable' to match base method */
    @Override // kotlin.ranges.ClosedRange
    public /* bridge */ /* synthetic */ ULong getEndInclusive() {
        return ULong.m7281boximpl(m8349getEndInclusivesVKNKU());
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Comparable] */
    @Override // kotlin.ranges.ClosedRange
    public /* bridge */ /* synthetic */ boolean contains(ULong uLong) {
        return m8350containsVKZWuLQ(uLong.m7282unboximpl());
    }

    private ULongRange(long start, long endInclusive) {
        super(start, endInclusive, 1, null);
    }

    /* renamed from: getStart-s-VKNKU  reason: not valid java name */
    public long m8348getStartsVKNKU() {
        return m8344getFirstsVKNKU();
    }

    /* renamed from: getEndInclusive-s-VKNKU  reason: not valid java name */
    public long m8349getEndInclusivesVKNKU() {
        return m8345getLastsVKNKU();
    }

    /* renamed from: contains-VKZWuLQ  reason: not valid java name */
    public boolean m8350containsVKZWuLQ(long value) {
        return UnsignedUtils.ulongCompare(m8344getFirstsVKNKU(), value) <= 0 && UnsignedUtils.ulongCompare(value, m8345getLastsVKNKU()) <= 0;
    }

    @Override // kotlin.ranges.ULongProgression, kotlin.ranges.ClosedRange
    public boolean isEmpty() {
        return UnsignedUtils.ulongCompare(m8344getFirstsVKNKU(), m8345getLastsVKNKU()) > 0;
    }

    @Override // kotlin.ranges.ULongProgression, java.lang.Object
    public boolean equals(@Nullable Object other) {
        return (other instanceof ULongRange) && ((isEmpty() && ((ULongRange) other).isEmpty()) || (m8344getFirstsVKNKU() == ((ULongRange) other).m8344getFirstsVKNKU() && m8345getLastsVKNKU() == ((ULongRange) other).m8345getLastsVKNKU()));
    }

    @Override // kotlin.ranges.ULongProgression, java.lang.Object
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (31 * ((int) ULong.m7280constructorimpl(m8344getFirstsVKNKU() ^ ULong.m7280constructorimpl(m8344getFirstsVKNKU() >>> 32)))) + ((int) ULong.m7280constructorimpl(m8345getLastsVKNKU() ^ ULong.m7280constructorimpl(m8345getLastsVKNKU() >>> 32)));
    }

    @Override // kotlin.ranges.ULongProgression, java.lang.Object
    @NotNull
    public String toString() {
        return ((Object) ULong.m7277toStringimpl(m8344getFirstsVKNKU())) + CallerDataConverter.DEFAULT_RANGE_DELIMITER + ((Object) ULong.m7277toStringimpl(m8345getLastsVKNKU()));
    }

    /* compiled from: ULongRange.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u0014\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n��\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m373d2 = {"Lkotlin/ranges/ULongRange$Companion;", "", "()V", "EMPTY", "Lkotlin/ranges/ULongRange;", "getEMPTY", "()Lkotlin/ranges/ULongRange;", "kotlin-stdlib"})
    /* loaded from: grasscutter.jar:kotlin/ranges/ULongRange$Companion.class */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final ULongRange getEMPTY() {
            return ULongRange.EMPTY;
        }
    }
}
