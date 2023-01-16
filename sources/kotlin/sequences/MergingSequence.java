package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Sequences.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n��\b��\u0018��*\u0004\b��\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\b\u0012\u0004\u0012\u0002H\u00030\u0004B;\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028��0\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00028��\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\b¢\u0006\u0002\u0010\tJ\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00020\u000bH\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028��0\u0004X\u0004¢\u0006\u0002\n��R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004X\u0004¢\u0006\u0002\n��R \u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00028��\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\bX\u0004¢\u0006\u0002\n��¨\u0006\f"}, m373d2 = {"Lkotlin/sequences/MergingSequence;", "T1", "T2", "V", "Lkotlin/sequences/Sequence;", "sequence1", "sequence2", "transform", "Lkotlin/Function2;", "(Lkotlin/sequences/Sequence;Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function2;)V", "iterator", "", "kotlin-stdlib"})
/* loaded from: grasscutter.jar:kotlin/sequences/MergingSequence.class */
public final class MergingSequence<T1, T2, V> implements Sequence<V> {
    @NotNull
    private final Sequence<T1> sequence1;
    @NotNull
    private final Sequence<T2> sequence2;
    @NotNull
    private final Function2<T1, T2, V> transform;

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.sequences.Sequence<? extends T1> */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.sequences.Sequence<? extends T2> */
    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: kotlin.jvm.functions.Function2<? super T1, ? super T2, ? extends V> */
    /* JADX WARN: Multi-variable type inference failed */
    public MergingSequence(@NotNull Sequence<? extends T1> sequence, @NotNull Sequence<? extends T2> sequence2, @NotNull Function2<? super T1, ? super T2, ? extends V> function2) {
        Intrinsics.checkNotNullParameter(sequence, "sequence1");
        Intrinsics.checkNotNullParameter(sequence2, "sequence2");
        Intrinsics.checkNotNullParameter(function2, "transform");
        this.sequence1 = sequence;
        this.sequence2 = sequence2;
        this.transform = function2;
    }

    @Override // kotlin.sequences.Sequence
    @NotNull
    public Iterator<V> iterator() {
        return new Object(this) { // from class: kotlin.sequences.MergingSequence$iterator$1
            @NotNull
            private final Iterator<T1> iterator1;
            @NotNull
            private final Iterator<T2> iterator2;
            final /* synthetic */ MergingSequence<T1, T2, V> this$0;

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            }

            /* access modifiers changed from: package-private */
            {
                this.this$0 = r4;
                this.iterator1 = MergingSequence.access$getSequence1$p(r4).iterator();
                this.iterator2 = MergingSequence.access$getSequence2$p(r4).iterator();
            }

            @NotNull
            public final Iterator<T1> getIterator1() {
                return this.iterator1;
            }

            @NotNull
            public final Iterator<T2> getIterator2() {
                return this.iterator2;
            }

            /* JADX WARN: Type inference failed for: r0v3, types: [V, java.lang.Object] */
            @Override // java.util.Iterator
            public V next() {
                return MergingSequence.access$getTransform$p(this.this$0).invoke(this.iterator1.next(), this.iterator2.next());
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.iterator1.hasNext() && this.iterator2.hasNext();
            }
        };
    }
}
