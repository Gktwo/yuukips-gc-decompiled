package kotlin.ranges;

import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UInt;
import kotlin.UnsignedUtils;
import kotlin.WasExperimental;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jline.console.Printer;
import p001ch.qos.logback.classic.pattern.CallerDataConverter;

/* compiled from: UIntRange.kt */
@SinceKotlin(version = "1.5")
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��2\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010��\n��\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018�� \u00172\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0017B\u0018\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003ø\u0001��¢\u0006\u0002\u0010\u0006J\u001b\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0002ø\u0001��¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u001a\u0010\u0005\u001a\u00020\u00038VX\u0004ø\u0001��ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\u00020\u00038VX\u0004ø\u0001��ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\t\u0010\bø\u0001��\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0018"}, m373d2 = {"Lkotlin/ranges/UIntRange;", "Lkotlin/ranges/UIntProgression;", "Lkotlin/ranges/ClosedRange;", "Lkotlin/UInt;", "start", "endInclusive", "(IILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getEndInclusive-pVg5ArA", "()I", "getStart-pVg5ArA", "contains", "", "value", "contains-WZ4Q5Ns", "(I)Z", "equals", "other", "", "hashCode", "", "isEmpty", Printer.TO_STRING, "", "Companion", "kotlin-stdlib"})
@WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
/* loaded from: grasscutter.jar:kotlin/ranges/UIntRange.class */
public final class UIntRange extends UIntProgression implements ClosedRange<UInt> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final UIntRange EMPTY = new UIntRange(-1, 0, null);

    public /* synthetic */ UIntRange(int start, int endInclusive, DefaultConstructorMarker $constructor_marker) {
        this(start, endInclusive);
    }

    /* Return type fixed from 'java.lang.Comparable' to match base method */
    @Override // kotlin.ranges.ClosedRange
    public /* bridge */ /* synthetic */ UInt getStart() {
        return UInt.m7202boximpl(m8340getStartpVg5ArA());
    }

    /* Return type fixed from 'java.lang.Comparable' to match base method */
    @Override // kotlin.ranges.ClosedRange
    public /* bridge */ /* synthetic */ UInt getEndInclusive() {
        return UInt.m7202boximpl(m8341getEndInclusivepVg5ArA());
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Comparable] */
    @Override // kotlin.ranges.ClosedRange
    public /* bridge */ /* synthetic */ boolean contains(UInt uInt) {
        return m8342containsWZ4Q5Ns(uInt.m7203unboximpl());
    }

    private UIntRange(int start, int endInclusive) {
        super(start, endInclusive, 1, null);
    }

    /* renamed from: getStart-pVg5ArA  reason: not valid java name */
    public int m8340getStartpVg5ArA() {
        return m8336getFirstpVg5ArA();
    }

    /* renamed from: getEndInclusive-pVg5ArA  reason: not valid java name */
    public int m8341getEndInclusivepVg5ArA() {
        return m8337getLastpVg5ArA();
    }

    /* renamed from: contains-WZ4Q5Ns  reason: not valid java name */
    public boolean m8342containsWZ4Q5Ns(int value) {
        return UnsignedUtils.uintCompare(m8336getFirstpVg5ArA(), value) <= 0 && UnsignedUtils.uintCompare(value, m8337getLastpVg5ArA()) <= 0;
    }

    @Override // kotlin.ranges.UIntProgression, kotlin.ranges.ClosedRange
    public boolean isEmpty() {
        return UnsignedUtils.uintCompare(m8336getFirstpVg5ArA(), m8337getLastpVg5ArA()) > 0;
    }

    @Override // kotlin.ranges.UIntProgression, java.lang.Object
    public boolean equals(@Nullable Object other) {
        return (other instanceof UIntRange) && ((isEmpty() && ((UIntRange) other).isEmpty()) || (m8336getFirstpVg5ArA() == ((UIntRange) other).m8336getFirstpVg5ArA() && m8337getLastpVg5ArA() == ((UIntRange) other).m8337getLastpVg5ArA()));
    }

    @Override // kotlin.ranges.UIntProgression, java.lang.Object
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (31 * m8336getFirstpVg5ArA()) + m8337getLastpVg5ArA();
    }

    @Override // kotlin.ranges.UIntProgression, java.lang.Object
    @NotNull
    public String toString() {
        return ((Object) UInt.m7198toStringimpl(m8336getFirstpVg5ArA())) + CallerDataConverter.DEFAULT_RANGE_DELIMITER + ((Object) UInt.m7198toStringimpl(m8337getLastpVg5ArA()));
    }

    /* compiled from: UIntRange.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u0014\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n��\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m373d2 = {"Lkotlin/ranges/UIntRange$Companion;", "", "()V", "EMPTY", "Lkotlin/ranges/UIntRange;", "getEMPTY", "()Lkotlin/ranges/UIntRange;", "kotlin-stdlib"})
    /* loaded from: grasscutter.jar:kotlin/ranges/UIntRange$Companion.class */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final UIntRange getEMPTY() {
            return UIntRange.EMPTY;
        }
    }
}
