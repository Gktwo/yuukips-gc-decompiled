package p014it.unimi.dsi.fastutil.ints;

import java.io.Serializable;
import p014it.unimi.dsi.fastutil.SortedPair;

/* renamed from: it.unimi.dsi.fastutil.ints.IntIntSortedPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntIntSortedPair.class */
public interface IntIntSortedPair extends IntIntPair, SortedPair<Integer>, Serializable {
    /* renamed from: of */
    static IntIntSortedPair m727of(int left, int right) {
        return IntIntImmutableSortedPair.m730of(left, right);
    }

    default boolean contains(int e) {
        return e == leftInt() || e == rightInt();
    }

    @Override // p014it.unimi.dsi.fastutil.SortedPair
    @Deprecated
    default boolean contains(Object o) {
        if (o == null) {
            return false;
        }
        return contains(((Integer) o).intValue());
    }
}
