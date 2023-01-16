package p014it.unimi.dsi.fastutil.doubles;

import java.io.Serializable;
import p014it.unimi.dsi.fastutil.SortedPair;

/* renamed from: it.unimi.dsi.fastutil.doubles.DoubleDoubleSortedPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleDoubleSortedPair.class */
public interface DoubleDoubleSortedPair extends DoubleDoublePair, SortedPair<Double>, Serializable {
    /* renamed from: of */
    static DoubleDoubleSortedPair m903of(double left, double right) {
        return DoubleDoubleImmutableSortedPair.m906of(left, right);
    }

    default boolean contains(double e) {
        return e == leftDouble() || e == rightDouble();
    }

    @Override // p014it.unimi.dsi.fastutil.SortedPair
    @Deprecated
    default boolean contains(Object o) {
        if (o == null) {
            return false;
        }
        return contains(((Double) o).doubleValue());
    }
}
