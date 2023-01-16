package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Sequences.kt */
/* access modifiers changed from: package-private */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��$\n\u0002\u0018\u0002\n��\n\u0002\u0010��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n��\b\u0002\u0018��*\b\b��\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B+\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018��0\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00028��\u0012\u0006\u0012\u0004\u0018\u00018��0\u0007¢\u0006\u0002\u0010\bJ\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00028��0\nH\u0002R\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018��0\u0005X\u0004¢\u0006\u0002\n��R\u001c\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00028��\u0012\u0006\u0012\u0004\u0018\u00018��0\u0007X\u0004¢\u0006\u0002\n��¨\u0006\u000b"}, m373d2 = {"Lkotlin/sequences/GeneratorSequence;", "T", "", "Lkotlin/sequences/Sequence;", "getInitialValue", "Lkotlin/Function0;", "getNextValue", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "iterator", "", "kotlin-stdlib"})
/* loaded from: grasscutter.jar:kotlin/sequences/GeneratorSequence.class */
public final class GeneratorSequence<T> implements Sequence<T> {
    @NotNull
    private final Function0<T> getInitialValue;
    @NotNull
    private final Function1<T, T> getNextValue;

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.functions.Function0<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.jvm.functions.Function1<? super T, ? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public GeneratorSequence(@NotNull Function0<? extends T> function0, @NotNull Function1<? super T, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(function0, "getInitialValue");
        Intrinsics.checkNotNullParameter(function1, "getNextValue");
        this.getInitialValue = function0;
        this.getNextValue = function1;
    }

    @Override // kotlin.sequences.Sequence
    @NotNull
    public Iterator<T> iterator() {
        return new Object(this) { // from class: kotlin.sequences.GeneratorSequence$iterator$1
            @Nullable
            private T nextItem;
            private int nextState = -2;
            final /* synthetic */ GeneratorSequence<T> this$0;

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            }

            /* access modifiers changed from: package-private */
            {
                this.this$0 = r4;
            }

            @Nullable
            public final T getNextItem() {
                return this.nextItem;
            }

            public final void setNextItem(@Nullable T t) {
                this.nextItem = t;
            }

            public final int getNextState() {
                return this.nextState;
            }

            public final void setNextState(int i) {
                this.nextState = i;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: T */
            /* JADX DEBUG: Multi-variable search result rejected for r1v16, resolved type: T */
            /* JADX DEBUG: Multi-variable search result rejected for r1v17, resolved type: T */
            /* JADX WARN: Multi-variable type inference failed */
            private final void calcNext() {
                T t;
                if (this.nextState == -2) {
                    t = GeneratorSequence.access$getGetInitialValue$p(this.this$0).invoke();
                } else {
                    Function1 access$getGetNextValue$p = GeneratorSequence.access$getGetNextValue$p(this.this$0);
                    T t2 = this.nextItem;
                    Intrinsics.checkNotNull(t2);
                    t = access$getGetNextValue$p.invoke(t2);
                }
                this.nextItem = t;
                this.nextState = this.nextItem == 0 ? 0 : 1;
            }

            @Override // java.util.Iterator
            @NotNull
            public T next() {
                if (this.nextState < 0) {
                    calcNext();
                }
                if (this.nextState == 0) {
                    throw new NoSuchElementException();
                }
                T t = this.nextItem;
                if (t == 0) {
                    throw new NullPointerException("null cannot be cast to non-null type T of kotlin.sequences.GeneratorSequence");
                }
                this.nextState = -1;
                return t;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.nextState < 0) {
                    calcNext();
                }
                return this.nextState == 1;
            }
        };
    }
}
