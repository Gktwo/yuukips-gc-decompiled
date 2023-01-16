package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;

/* access modifiers changed from: package-private */
@GwtCompatible(serializable = true)
/* loaded from: grasscutter.jar:com/google/common/collect/NullsFirstOrdering.class */
public final class NullsFirstOrdering<T> extends Ordering<T> implements Serializable {
    final Ordering<? super T> ordering;
    private static final long serialVersionUID = 0;

    /* access modifiers changed from: package-private */
    public NullsFirstOrdering(Ordering<? super T> ordering) {
        this.ordering = ordering;
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(T left, T right) {
        if (left == right) {
            return 0;
        }
        if (left == null) {
            return -1;
        }
        if (right == null) {
            return 1;
        }
        return this.ordering.compare(left, right);
    }

    @Override // com.google.common.collect.Ordering
    public <S extends T> Ordering<S> reverse() {
        return this.ordering.reverse().nullsLast();
    }

    @Override // com.google.common.collect.Ordering
    public <S extends T> Ordering<S> nullsFirst() {
        return this;
    }

    @Override // com.google.common.collect.Ordering
    public <S extends T> Ordering<S> nullsLast() {
        return this.ordering.nullsLast();
    }

    @Override // java.util.Comparator, java.lang.Object
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object instanceof NullsFirstOrdering) {
            return this.ordering.equals(((NullsFirstOrdering) object).ordering);
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.ordering.hashCode() ^ 957692532;
    }

    @Override // java.lang.Object
    public String toString() {
        return this.ordering + ".nullsFirst()";
    }
}
