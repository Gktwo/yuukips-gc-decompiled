package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Iterator;

/* access modifiers changed from: package-private */
@GwtCompatible(serializable = true)
/* loaded from: grasscutter.jar:com/google/common/collect/ReverseOrdering.class */
public final class ReverseOrdering<T> extends Ordering<T> implements Serializable {
    final Ordering<? super T> forwardOrder;
    private static final long serialVersionUID = 0;

    /* access modifiers changed from: package-private */
    public ReverseOrdering(Ordering<? super T> forwardOrder) {
        this.forwardOrder = (Ordering) Preconditions.checkNotNull(forwardOrder);
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(T a, T b) {
        return this.forwardOrder.compare(b, a);
    }

    /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: com.google.common.collect.Ordering<? super T>, com.google.common.collect.Ordering<S extends T> */
    @Override // com.google.common.collect.Ordering
    public <S extends T> Ordering<S> reverse() {
        return (Ordering<? super T>) this.forwardOrder;
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E min(E a, E b) {
        return (E) this.forwardOrder.max(a, b);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E min(E a, E b, E c, E... rest) {
        return (E) this.forwardOrder.max(a, b, c, rest);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E min(Iterator<E> iterator) {
        return (E) this.forwardOrder.max(iterator);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E min(Iterable<E> iterable) {
        return (E) this.forwardOrder.max(iterable);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E max(E a, E b) {
        return (E) this.forwardOrder.min(a, b);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E max(E a, E b, E c, E... rest) {
        return (E) this.forwardOrder.min(a, b, c, rest);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E max(Iterator<E> iterator) {
        return (E) this.forwardOrder.min(iterator);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E max(Iterable<E> iterable) {
        return (E) this.forwardOrder.min(iterable);
    }

    @Override // java.lang.Object
    public int hashCode() {
        return -this.forwardOrder.hashCode();
    }

    @Override // java.util.Comparator, java.lang.Object
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object instanceof ReverseOrdering) {
            return this.forwardOrder.equals(((ReverseOrdering) object).forwardOrder);
        }
        return false;
    }

    @Override // java.lang.Object
    public String toString() {
        return this.forwardOrder + ".reverse()";
    }
}
