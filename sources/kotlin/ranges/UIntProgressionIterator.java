package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UInt;
import kotlin.UnsignedUtils;
import kotlin.collections.UIntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jline.builtins.Tmux;

/* compiled from: UIntRange.kt */
@SinceKotlin(version = "1.3")
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0003\u0018��2\u00020\u0001B \u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006ø\u0001��¢\u0006\u0002\u0010\u0007J\t\u0010\n\u001a\u00020\u000bH\u0002J\u0015\u0010\r\u001a\u00020\u0003H\u0016ø\u0001��ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\b\u001a\u00020\u0003X\u0004ø\u0001��ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n��R\u0016\u0010\f\u001a\u00020\u0003X\u000eø\u0001��ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\u0005\u001a\u00020\u0003X\u0004ø\u0001��ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\t\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0010"}, m373d2 = {"Lkotlin/ranges/UIntProgressionIterator;", "Lkotlin/collections/UIntIterator;", "first", "Lkotlin/UInt;", "last", "step", "", "(IIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "finalElement", "I", "hasNext", "", Tmux.CMD_NEXT, "nextUInt", "nextUInt-pVg5ArA", "()I", "kotlin-stdlib"})
/* loaded from: grasscutter.jar:kotlin/ranges/UIntProgressionIterator.class */
final class UIntProgressionIterator extends UIntIterator {
    private final int finalElement;
    private boolean hasNext;
    private final int step;
    private int next;

    public /* synthetic */ UIntProgressionIterator(int first, int last, int step, DefaultConstructorMarker $constructor_marker) {
        this(first, last, step);
    }

    private UIntProgressionIterator(int first, int last, int step) {
        this.finalElement = last;
        this.hasNext = step > 0 ? UnsignedUtils.uintCompare(first, last) <= 0 : UnsignedUtils.uintCompare(first, last) >= 0;
        this.step = UInt.m7201constructorimpl(step);
        this.next = this.hasNext ? first : this.finalElement;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override // kotlin.collections.UIntIterator
    /* renamed from: nextUInt-pVg5ArA */
    public int mo7223nextUIntpVg5ArA() {
        int value = this.next;
        if (value != this.finalElement) {
            this.next = UInt.m7201constructorimpl(this.next + this.step);
        } else if (!this.hasNext) {
            throw new NoSuchElementException();
        } else {
            this.hasNext = false;
        }
        return value;
    }
}
