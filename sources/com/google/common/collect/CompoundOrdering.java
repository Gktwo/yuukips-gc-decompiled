package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;

@GwtCompatible(serializable = true)
/* loaded from: grasscutter.jar:com/google/common/collect/CompoundOrdering.class */
final class CompoundOrdering<T> extends Ordering<T> implements Serializable {
    final Comparator<? super T>[] comparators;
    private static final long serialVersionUID = 0;

    /* access modifiers changed from: package-private */
    public CompoundOrdering(Comparator<? super T> primary, Comparator<? super T> secondary) {
        this.comparators = new Comparator[]{primary, secondary};
    }

    /* access modifiers changed from: package-private */
    public CompoundOrdering(Iterable<? extends Comparator<? super T>> comparators) {
        this.comparators = (Comparator[]) Iterables.toArray(comparators, new Comparator[0]);
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(T left, T right) {
        for (int i = 0; i < this.comparators.length; i++) {
            int result = this.comparators[i].compare(left, right);
            if (result != 0) {
                return result;
            }
        }
        return 0;
    }

    @Override // java.util.Comparator, java.lang.Object
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object instanceof CompoundOrdering) {
            return Arrays.equals(this.comparators, ((CompoundOrdering) object).comparators);
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return Arrays.hashCode(this.comparators);
    }

    @Override // java.lang.Object
    public String toString() {
        return "Ordering.compound(" + Arrays.toString(this.comparators) + ")";
    }
}
