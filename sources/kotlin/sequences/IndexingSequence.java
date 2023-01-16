package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Sequences.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u0018\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010(\n��\b��\u0018��*\u0004\b��\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028��0\u0002¢\u0006\u0002\u0010\u0005J\u0015\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028��0\u00030\u0007H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028��0\u0002X\u0004¢\u0006\u0002\n��¨\u0006\b"}, m373d2 = {"Lkotlin/sequences/IndexingSequence;", "T", "Lkotlin/sequences/Sequence;", "Lkotlin/collections/IndexedValue;", "sequence", "(Lkotlin/sequences/Sequence;)V", "iterator", "", "kotlin-stdlib"})
/* loaded from: grasscutter.jar:kotlin/sequences/IndexingSequence.class */
public final class IndexingSequence<T> implements Sequence<IndexedValue<? extends T>> {
    @NotNull
    private final Sequence<T> sequence;

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.sequences.Sequence<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public IndexingSequence(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "sequence");
        this.sequence = sequence;
    }

    @Override // kotlin.sequences.Sequence
    @NotNull
    public Iterator<IndexedValue<T>> iterator() {
        return new Object(this) { // from class: kotlin.sequences.IndexingSequence$iterator$1
            @NotNull
            private final Iterator<T> iterator;
            private int index;

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            }

            /* access modifiers changed from: package-private */
            {
                this.iterator = IndexingSequence.access$getSequence$p(r4).iterator();
            }

            @NotNull
            public final Iterator<T> getIterator() {
                return this.iterator;
            }

            public final int getIndex() {
                return this.index;
            }

            public final void setIndex(int i) {
                this.index = i;
            }

            @Override // java.util.Iterator
            @NotNull
            public IndexedValue<T> next() {
                int i = this.index;
                this.index = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                return new IndexedValue<>(i, this.iterator.next());
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.iterator.hasNext();
            }
        };
    }
}
