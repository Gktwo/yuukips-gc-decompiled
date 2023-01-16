package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;

@GwtCompatible(serializable = true)
/* loaded from: grasscutter.jar:com/google/common/collect/UsingToStringOrdering.class */
final class UsingToStringOrdering extends Ordering<Object> implements Serializable {
    static final UsingToStringOrdering INSTANCE = new UsingToStringOrdering();
    private static final long serialVersionUID = 0;

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(Object left, Object right) {
        return left.toString().compareTo(right.toString());
    }

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // java.lang.Object
    public String toString() {
        return "Ordering.usingToString()";
    }

    private UsingToStringOrdering() {
    }
}
