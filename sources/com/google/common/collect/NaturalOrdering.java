package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;

/* access modifiers changed from: package-private */
@GwtCompatible(serializable = true)
/* loaded from: grasscutter.jar:com/google/common/collect/NaturalOrdering.class */
public final class NaturalOrdering extends Ordering<Comparable> implements Serializable {
    static final NaturalOrdering INSTANCE = new NaturalOrdering();
    private transient Ordering<Comparable> nullsFirst;
    private transient Ordering<Comparable> nullsLast;
    private static final long serialVersionUID = 0;

    public int compare(Comparable left, Comparable right) {
        Preconditions.checkNotNull(left);
        Preconditions.checkNotNull(right);
        return left.compareTo(right);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.common.collect.Ordering<java.lang.Comparable>, com.google.common.collect.Ordering] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.google.common.collect.Ordering
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <S extends java.lang.Comparable> com.google.common.collect.Ordering<S> nullsFirst() {
        /*
            r4 = this;
            r0 = r4
            com.google.common.collect.Ordering<java.lang.Comparable> r0 = r0.nullsFirst
            r5 = r0
            r0 = r5
            if (r0 != 0) goto L_0x0013
            r0 = r4
            r1 = r4
            com.google.common.collect.Ordering r1 = r1.nullsFirst()
            r2 = r1; r1 = r0; r0 = r2; 
            r1.nullsFirst = r2
            r5 = r0
        L_0x0013:
            r0 = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.NaturalOrdering.nullsFirst():com.google.common.collect.Ordering");
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.common.collect.Ordering<java.lang.Comparable>, com.google.common.collect.Ordering] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.google.common.collect.Ordering
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <S extends java.lang.Comparable> com.google.common.collect.Ordering<S> nullsLast() {
        /*
            r4 = this;
            r0 = r4
            com.google.common.collect.Ordering<java.lang.Comparable> r0 = r0.nullsLast
            r5 = r0
            r0 = r5
            if (r0 != 0) goto L_0x0013
            r0 = r4
            r1 = r4
            com.google.common.collect.Ordering r1 = r1.nullsLast()
            r2 = r1; r1 = r0; r0 = r2; 
            r1.nullsLast = r2
            r5 = r0
        L_0x0013:
            r0 = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.NaturalOrdering.nullsLast():com.google.common.collect.Ordering");
    }

    @Override // com.google.common.collect.Ordering
    public <S extends Comparable> Ordering<S> reverse() {
        return ReverseNaturalOrdering.INSTANCE;
    }

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // java.lang.Object
    public String toString() {
        return "Ordering.natural()";
    }

    private NaturalOrdering() {
    }
}
