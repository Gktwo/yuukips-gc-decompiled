package p014it.unimi.dsi.fastutil.doubles;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.doubles.DoubleObjectPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleObjectPair.class */
public interface DoubleObjectPair<V> extends Pair<Double, V> {
    double leftDouble();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Double left() {
        return Double.valueOf(leftDouble());
    }

    default DoubleObjectPair<V> left(double l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default DoubleObjectPair<V> left(Double l) {
        return left(l.doubleValue());
    }

    default double firstDouble() {
        return leftDouble();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Double first() {
        return Double.valueOf(firstDouble());
    }

    default DoubleObjectPair<V> first(double l) {
        return left(l);
    }

    @Deprecated
    default DoubleObjectPair<V> first(Double l) {
        return first(l.doubleValue());
    }

    default double keyDouble() {
        return firstDouble();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Double key() {
        return Double.valueOf(keyDouble());
    }

    default DoubleObjectPair<V> key(double l) {
        return left(l);
    }

    @Deprecated
    default DoubleObjectPair<V> key(Double l) {
        return key(l.doubleValue());
    }

    /* renamed from: of */
    static <V> DoubleObjectPair<V> m879of(double left, V right) {
        return new DoubleObjectImmutablePair(left, right);
    }

    static <V> Comparator<DoubleObjectPair<V>> lexComparator() {
        return x, y -> {
            int t = Double.compare(x.leftDouble(), y.leftDouble());
            return t != 0 ? t : ((Comparable) x.right()).compareTo(y.right());
        };
    }
}
