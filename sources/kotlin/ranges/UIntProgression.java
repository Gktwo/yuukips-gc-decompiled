package kotlin.ranges;

import java.util.Iterator;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UInt;
import kotlin.UnsignedUtils;
import kotlin.WasExperimental;
import kotlin.internal.UProgressionUtil;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jline.console.Printer;
import p001ch.qos.logback.classic.pattern.CallerDataConverter;

/* compiled from: UIntRange.kt */
@SinceKotlin(version = "1.5")
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��4\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n��\n\u0002\u0010��\n\u0002\b\u0003\n\u0002\u0010(\n��\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0017\u0018�� \u00192\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\"\b��\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006ø\u0001��¢\u0006\u0002\u0010\u0007J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016J\u0012\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0016H\u0002ø\u0001��J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0019\u0010\b\u001a\u00020\u0002ø\u0001��ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0019\u0010\f\u001a\u00020\u0002ø\u0001��ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n��\u001a\u0004\b\u000e\u0010\nø\u0001��\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u001a"}, m373d2 = {"Lkotlin/ranges/UIntProgression;", "", "Lkotlin/UInt;", "start", "endInclusive", "step", "", "(IIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "first", "getFirst-pVg5ArA", "()I", "I", "last", "getLast-pVg5ArA", "getStep", "equals", "", "other", "", "hashCode", "isEmpty", "iterator", "", Printer.TO_STRING, "", "Companion", "kotlin-stdlib"})
@WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
/* loaded from: grasscutter.jar:kotlin/ranges/UIntProgression.class */
public class UIntProgression implements Iterable<UInt>, KMappedMarker {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final int first;
    private final int last;
    private final int step;

    public /* synthetic */ UIntProgression(int start, int endInclusive, int step, DefaultConstructorMarker $constructor_marker) {
        this(start, endInclusive, step);
    }

    private UIntProgression(int start, int endInclusive, int step) {
        if (step == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        } else if (step == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        } else {
            this.first = start;
            this.last = UProgressionUtil.m8280getProgressionLastElementNkh28Cs(start, endInclusive, step);
            this.step = step;
        }
    }

    /* renamed from: getFirst-pVg5ArA  reason: not valid java name */
    public final int m8333getFirstpVg5ArA() {
        return this.first;
    }

    /* renamed from: getLast-pVg5ArA  reason: not valid java name */
    public final int m8334getLastpVg5ArA() {
        return this.last;
    }

    public final int getStep() {
        return this.step;
    }

    @Override // java.lang.Iterable
    @NotNull
    public final Iterator<UInt> iterator() {
        return new UIntProgressionIterator(m8333getFirstpVg5ArA(), m8334getLastpVg5ArA(), this.step, null);
    }

    @Override // kotlin.ranges.ClosedRange
    public boolean isEmpty() {
        return this.step > 0 ? UnsignedUtils.uintCompare(m8333getFirstpVg5ArA(), m8334getLastpVg5ArA()) > 0 : UnsignedUtils.uintCompare(m8333getFirstpVg5ArA(), m8334getLastpVg5ArA()) < 0;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object other) {
        return (other instanceof UIntProgression) && ((isEmpty() && ((UIntProgression) other).isEmpty()) || (m8333getFirstpVg5ArA() == ((UIntProgression) other).m8333getFirstpVg5ArA() && m8334getLastpVg5ArA() == ((UIntProgression) other).m8334getLastpVg5ArA() && this.step == ((UIntProgression) other).step));
    }

    @Override // java.lang.Object
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (31 * ((31 * m8333getFirstpVg5ArA()) + m8334getLastpVg5ArA())) + this.step;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        return this.step > 0 ? ((Object) UInt.m7195toStringimpl(m8333getFirstpVg5ArA())) + CallerDataConverter.DEFAULT_RANGE_DELIMITER + ((Object) UInt.m7195toStringimpl(m8334getLastpVg5ArA())) + " step " + this.step : ((Object) UInt.m7195toStringimpl(m8333getFirstpVg5ArA())) + " downTo " + ((Object) UInt.m7195toStringimpl(m8334getLastpVg5ArA())) + " step " + (-this.step);
    }

    /* compiled from: UIntRange.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\"\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tø\u0001��¢\u0006\u0004\b\n\u0010\u000b\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, m373d2 = {"Lkotlin/ranges/UIntProgression$Companion;", "", "()V", "fromClosedRange", "Lkotlin/ranges/UIntProgression;", "rangeStart", "Lkotlin/UInt;", "rangeEnd", "step", "", "fromClosedRange-Nkh28Cs", "(III)Lkotlin/ranges/UIntProgression;", "kotlin-stdlib"})
    /* loaded from: grasscutter.jar:kotlin/ranges/UIntProgression$Companion.class */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        /* renamed from: fromClosedRange-Nkh28Cs  reason: not valid java name */
        public final UIntProgression m8336fromClosedRangeNkh28Cs(int rangeStart, int rangeEnd, int step) {
            return new UIntProgression(rangeStart, rangeEnd, step, null);
        }
    }
}
