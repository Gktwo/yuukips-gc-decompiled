package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CharIterator;
import kotlin.jvm.internal.Intrinsics;
import org.jline.builtins.Tmux;

/* compiled from: ProgressionIterators.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b��\u0018��2\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\u0003H\u0016R\u000e\u0010\b\u001a\u00020\u0006X\u0004¢\u0006\u0002\n��R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n��R\u000e\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n��R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n��\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, m373d2 = {"Lkotlin/ranges/CharProgressionIterator;", "Lkotlin/collections/CharIterator;", "first", "", "last", "step", "", "(CCI)V", "finalElement", "hasNext", "", Tmux.CMD_NEXT, "getStep", "()I", "nextChar", "kotlin-stdlib"})
/* loaded from: grasscutter.jar:kotlin/ranges/CharProgressionIterator.class */
public final class CharProgressionIterator extends CharIterator {
    private final int step;
    private final int finalElement;
    private boolean hasNext;
    private int next;

    public CharProgressionIterator(char first, char last, int step) {
        this.step = step;
        this.finalElement = last;
        this.hasNext = this.step > 0 ? Intrinsics.compare((int) first, (int) last) <= 0 : Intrinsics.compare((int) first, (int) last) >= 0;
        this.next = this.hasNext ? first : this.finalElement;
    }

    public final int getStep() {
        return this.step;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override // kotlin.collections.CharIterator
    public char nextChar() {
        int value = this.next;
        if (value != this.finalElement) {
            this.next += this.step;
        } else if (!this.hasNext) {
            throw new NoSuchElementException();
        } else {
            this.hasNext = false;
        }
        return (char) value;
    }
}
