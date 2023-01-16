package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Sequences.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"�� \n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010(\n��\b��\u0018��*\u0004\b��\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B'\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028��0\u0002\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028��\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00028��0\tH\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028��\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n��R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028��0\u0002X\u0004¢\u0006\u0002\n��¨\u0006\n"}, m373d2 = {"Lkotlin/sequences/DropWhileSequence;", "T", "Lkotlin/sequences/Sequence;", "sequence", "predicate", "Lkotlin/Function1;", "", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)V", "iterator", "", "kotlin-stdlib"})
/* loaded from: grasscutter.jar:kotlin/sequences/DropWhileSequence.class */
public final class DropWhileSequence<T> implements Sequence<T> {
    @NotNull
    private final Sequence<T> sequence;
    @NotNull
    private final Function1<T, Boolean> predicate;

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.sequences.Sequence<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.jvm.functions.Function1<? super T, java.lang.Boolean> */
    /* JADX WARN: Multi-variable type inference failed */
    public DropWhileSequence(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(sequence, "sequence");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        this.sequence = sequence;
        this.predicate = function1;
    }

    @Override // kotlin.sequences.Sequence
    @NotNull
    public Iterator<T> iterator() {
        return new Object(this) { // from class: kotlin.sequences.DropWhileSequence$iterator$1
            @NotNull
            private final Iterator<T> iterator;
            private int dropState = -1;
            @Nullable
            private T nextItem;
            final /* synthetic */ DropWhileSequence<T> this$0;

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            }

            /* access modifiers changed from: package-private */
            {
                this.this$0 = r4;
                this.iterator = DropWhileSequence.access$getSequence$p(r4).iterator();
            }

            @NotNull
            public final Iterator<T> getIterator() {
                return this.iterator;
            }

            public final int getDropState() {
                return this.dropState;
            }

            public final void setDropState(int i) {
                this.dropState = i;
            }

            @Nullable
            public final T getNextItem() {
                return this.nextItem;
            }

            public final void setNextItem(@Nullable T t) {
                this.nextItem = t;
            }

            /* JADX WARN: Type inference failed for: r0v6, types: [T, java.lang.Object] */
            /* JADX WARNING: Unknown variable types count: 1 */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private final void drop() {
                /*
                    r3 = this;
                L_0x0000:
                    r0 = r3
                    java.util.Iterator<T> r0 = r0.iterator
                    boolean r0 = r0.hasNext()
                    if (r0 == 0) goto L_0x0037
                    r0 = r3
                    java.util.Iterator<T> r0 = r0.iterator
                    java.lang.Object r0 = r0.next()
                    r4 = r0
                    r0 = r3
                    kotlin.sequences.DropWhileSequence<T> r0 = r0.this$0
                    kotlin.jvm.functions.Function1 r0 = kotlin.sequences.DropWhileSequence.access$getPredicate$p(r0)
                    r1 = r4
                    java.lang.Object r0 = r0.invoke(r1)
                    java.lang.Boolean r0 = (java.lang.Boolean) r0
                    boolean r0 = r0.booleanValue()
                    if (r0 != 0) goto L_0x0000
                    r0 = r3
                    r1 = r4
                    r0.nextItem = r1
                    r0 = r3
                    r1 = 1
                    r0.dropState = r1
                    return
                L_0x0037:
                    r0 = r3
                    r1 = 0
                    r0.dropState = r1
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.sequences.DropWhileSequence$iterator$1.drop():void");
            }

            /* JADX WARN: Type inference failed for: r0v6, types: [T, java.lang.Object] */
            @Override // java.util.Iterator
            public T next() {
                if (this.dropState == -1) {
                    drop();
                }
                if (this.dropState != 1) {
                    return this.iterator.next();
                }
                T t = this.nextItem;
                this.nextItem = null;
                this.dropState = 0;
                return t;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.dropState == -1) {
                    drop();
                }
                return this.dropState == 1 || this.iterator.hasNext();
            }
        };
    }
}
