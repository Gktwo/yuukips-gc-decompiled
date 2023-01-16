package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Ordering;
import java.io.Serializable;
import java.util.List;

/* access modifiers changed from: package-private */
@GwtCompatible(serializable = true)
/* loaded from: grasscutter.jar:com/google/common/collect/ExplicitOrdering.class */
public final class ExplicitOrdering<T> extends Ordering<T> implements Serializable {
    final ImmutableMap<T, Integer> rankMap;
    private static final long serialVersionUID = 0;

    /* access modifiers changed from: package-private */
    public ExplicitOrdering(List<T> valuesInOrder) {
        this(Maps.indexMap(valuesInOrder));
    }

    ExplicitOrdering(ImmutableMap<T, Integer> rankMap) {
        this.rankMap = rankMap;
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(T left, T right) {
        return rank(left) - rank(right);
    }

    private int rank(T value) {
        Integer rank = this.rankMap.get(value);
        if (rank != null) {
            return rank.intValue();
        }
        throw new Ordering.IncomparableValueException(value);
    }

    @Override // java.util.Comparator, java.lang.Object
    public boolean equals(Object object) {
        if (object instanceof ExplicitOrdering) {
            return this.rankMap.equals(((ExplicitOrdering) object).rankMap);
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.rankMap.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        return "Ordering.explicit(" + this.rankMap.keySet() + ")";
    }
}
