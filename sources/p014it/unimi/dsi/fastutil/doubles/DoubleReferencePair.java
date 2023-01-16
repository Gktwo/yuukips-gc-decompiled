package p014it.unimi.dsi.fastutil.doubles;

import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.doubles.DoubleReferencePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleReferencePair.class */
public interface DoubleReferencePair<V> extends Pair<Double, V> {
    double leftDouble();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Double left() {
        return Double.valueOf(leftDouble());
    }

    default DoubleReferencePair<V> left(double l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default DoubleReferencePair<V> left(Double l) {
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

    default DoubleReferencePair<V> first(double l) {
        return left(l);
    }

    @Deprecated
    default DoubleReferencePair<V> first(Double l) {
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

    default DoubleReferencePair<V> key(double l) {
        return left(l);
    }

    @Deprecated
    default DoubleReferencePair<V> key(Double l) {
        return key(l.doubleValue());
    }

    /* renamed from: of */
    static <V> DoubleReferencePair<V> m869of(double left, V right) {
        return new DoubleReferenceImmutablePair(left, right);
    }
}
