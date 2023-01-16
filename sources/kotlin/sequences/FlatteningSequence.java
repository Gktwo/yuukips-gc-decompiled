package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Sequences.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010(\n\u0002\b\u0002\b��\u0018��*\u0004\b��\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\b\u0012\u0004\u0012\u0002H\u00030\u0004BA\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028��0\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028��\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\t0\u0007¢\u0006\u0002\u0010\nJ\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00020\tH\u0002R \u0010\b\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\t0\u0007X\u0004¢\u0006\u0002\n��R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028��0\u0004X\u0004¢\u0006\u0002\n��R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028��\u0012\u0004\u0012\u00028\u00010\u0007X\u0004¢\u0006\u0002\n��¨\u0006\u000b"}, m373d2 = {"Lkotlin/sequences/FlatteningSequence;", "T", "R", "E", "Lkotlin/sequences/Sequence;", "sequence", "transformer", "Lkotlin/Function1;", "iterator", "", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "kotlin-stdlib"})
/* loaded from: grasscutter.jar:kotlin/sequences/FlatteningSequence.class */
public final class FlatteningSequence<T, R, E> implements Sequence<E> {
    @NotNull
    private final Sequence<T> sequence;
    @NotNull
    private final Function1<T, R> transformer;
    @NotNull
    private final Function1<R, Iterator<E>> iterator;

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.sequences.Sequence<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.jvm.functions.Function1<? super T, ? extends R> */
    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: kotlin.jvm.functions.Function1<? super R, ? extends java.util.Iterator<? extends E>> */
    /* JADX WARN: Multi-variable type inference failed */
    public FlatteningSequence(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, ? extends R> function1, @NotNull Function1<? super R, ? extends Iterator<? extends E>> function12) {
        Intrinsics.checkNotNullParameter(sequence, "sequence");
        Intrinsics.checkNotNullParameter(function1, "transformer");
        Intrinsics.checkNotNullParameter(function12, "iterator");
        this.sequence = sequence;
        this.transformer = function1;
        this.iterator = function12;
    }

    @Override // kotlin.sequences.Sequence
    @NotNull
    public Iterator<E> iterator() {
        return new Object(this) { // from class: kotlin.sequences.FlatteningSequence$iterator$1
            @NotNull
            private final Iterator<T> iterator;
            @Nullable
            private Iterator<? extends E> itemIterator;
            final /* synthetic */ FlatteningSequence<T, R, E> this$0;

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            }

            /* access modifiers changed from: package-private */
            {
                this.this$0 = r4;
                this.iterator = FlatteningSequence.access$getSequence$p(r4).iterator();
            }

            @NotNull
            public final Iterator<T> getIterator() {
                return this.iterator;
            }

            /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: java.util.Iterator<? extends E>, java.util.Iterator<E> */
            @Nullable
            public final Iterator<E> getItemIterator() {
                return this.itemIterator;
            }

            public final void setItemIterator(@Nullable Iterator<? extends E> it) {
                this.itemIterator = it;
            }

            /* JADX WARN: Type inference failed for: r0v4, types: [E, java.lang.Object] */
            @Override // java.util.Iterator
            public E next() {
                if (!ensureItemIterator()) {
                    throw new NoSuchElementException();
                }
                Iterator<? extends E> it = this.itemIterator;
                Intrinsics.checkNotNull(it);
                return it.next();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return ensureItemIterator();
            }

            private final boolean ensureItemIterator() {
                Iterator<? extends E> it = this.itemIterator;
                if (it != 0 ? !it.hasNext() : false) {
                    this.itemIterator = null;
                }
                while (this.itemIterator == null) {
                    if (!this.iterator.hasNext()) {
                        return false;
                    }
                    Iterator nextItemIterator = (Iterator) FlatteningSequence.access$getIterator$p(this.this$0).invoke(FlatteningSequence.access$getTransformer$p(this.this$0).invoke(this.iterator.next()));
                    if (nextItemIterator.hasNext()) {
                        this.itemIterator = nextItemIterator;
                        return true;
                    }
                }
                return true;
            }
        };
    }
}
