package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.ListIterator;

/* access modifiers changed from: package-private */
@GwtCompatible
/* loaded from: grasscutter.jar:com/google/common/collect/TransformedListIterator.class */
public abstract class TransformedListIterator<F, T> extends TransformedIterator<F, T> implements ListIterator<T> {
    /* access modifiers changed from: package-private */
    public TransformedListIterator(ListIterator<? extends F> backingIterator) {
        super(backingIterator);
    }

    private ListIterator<? extends F> backingIterator() {
        return Iterators.cast(this.backingIterator);
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return backingIterator().hasPrevious();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.google.common.collect.TransformedListIterator<F, T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.ListIterator
    public final T previous() {
        return (T) transform(backingIterator().previous());
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return backingIterator().nextIndex();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return backingIterator().previousIndex();
    }

    @Override // java.util.ListIterator
    public void set(T element) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public void add(T element) {
        throw new UnsupportedOperationException();
    }
}
