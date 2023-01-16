package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Comparator;

/* access modifiers changed from: package-private */
@GwtCompatible(serializable = true)
/* loaded from: grasscutter.jar:com/google/common/collect/ComparatorOrdering.class */
public final class ComparatorOrdering<T> extends Ordering<T> implements Serializable {
    final Comparator<T> comparator;
    private static final long serialVersionUID = 0;

    /* access modifiers changed from: package-private */
    public ComparatorOrdering(Comparator<T> comparator) {
        this.comparator = (Comparator) Preconditions.checkNotNull(comparator);
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(T a, T b) {
        return this.comparator.compare(a, b);
    }

    @Override // java.util.Comparator, java.lang.Object
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object instanceof ComparatorOrdering) {
            return this.comparator.equals(((ComparatorOrdering) object).comparator);
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.comparator.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        return this.comparator.toString();
    }
}
