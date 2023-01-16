package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Sequences.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\"\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010(\n\u0002\b\u0002\b��\u0018��*\u0004\b��\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001b\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028��0\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00028��0\u00022\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00028��0\u000bH\u0002J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00028��0\u00022\u0006\u0010\t\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n��R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028��0\u0002X\u0004¢\u0006\u0002\n��¨\u0006\r"}, m373d2 = {"Lkotlin/sequences/DropSequence;", "T", "Lkotlin/sequences/Sequence;", "Lkotlin/sequences/DropTakeSequence;", "sequence", "count", "", "(Lkotlin/sequences/Sequence;I)V", "drop", "n", "iterator", "", "take", "kotlin-stdlib"})
/* loaded from: grasscutter.jar:kotlin/sequences/DropSequence.class */
public final class DropSequence<T> implements Sequence<T>, DropTakeSequence<T> {
    @NotNull
    private final Sequence<T> sequence;
    private final int count;

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.sequences.Sequence<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public DropSequence(@NotNull Sequence<? extends T> sequence, int count) {
        Intrinsics.checkNotNullParameter(sequence, "sequence");
        this.sequence = sequence;
        this.count = count;
        if (!(this.count >= 0)) {
            throw new IllegalArgumentException(("count must be non-negative, but was " + this.count + '.').toString());
        }
    }

    @Override // kotlin.sequences.DropTakeSequence
    @NotNull
    public Sequence<T> drop(int n) {
        int n1 = this.count + n;
        return n1 < 0 ? new DropSequence(this, n) : new DropSequence(this.sequence, n1);
    }

    @Override // kotlin.sequences.DropTakeSequence
    @NotNull
    public Sequence<T> take(int n) {
        int n1 = this.count + n;
        return n1 < 0 ? new TakeSequence(this, n) : new SubSequence(this.sequence, this.count, n1);
    }

    @Override // kotlin.sequences.Sequence
    @NotNull
    public Iterator<T> iterator() {
        return new Object(this) { // from class: kotlin.sequences.DropSequence$iterator$1
            @NotNull
            private final Iterator<T> iterator;
            private int left;

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            }

            /* access modifiers changed from: package-private */
            {
                this.iterator = DropSequence.access$getSequence$p(r4).iterator();
                this.left = DropSequence.access$getCount$p(r4);
            }

            @NotNull
            public final Iterator<T> getIterator() {
                return this.iterator;
            }

            public final int getLeft() {
                return this.left;
            }

            public final void setLeft(int i) {
                this.left = i;
            }

            private final void drop() {
                while (this.left > 0 && this.iterator.hasNext()) {
                    this.iterator.next();
                    this.left--;
                }
            }

            /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
            @Override // java.util.Iterator
            public T next() {
                drop();
                return this.iterator.next();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                drop();
                return this.iterator.hasNext();
            }
        };
    }
}
