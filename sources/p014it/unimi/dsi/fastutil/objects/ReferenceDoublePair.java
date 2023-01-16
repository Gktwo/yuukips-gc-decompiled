package p014it.unimi.dsi.fastutil.objects;

import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.objects.ReferenceDoublePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ReferenceDoublePair.class */
public interface ReferenceDoublePair<K> extends Pair<K, Double> {
    double rightDouble();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Double right() {
        return Double.valueOf(rightDouble());
    }

    default ReferenceDoublePair<K> right(double r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default ReferenceDoublePair<K> right(Double l) {
        return right(l.doubleValue());
    }

    default double secondDouble() {
        return rightDouble();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Double second() {
        return Double.valueOf(secondDouble());
    }

    default ReferenceDoublePair<K> second(double r) {
        return right(r);
    }

    @Deprecated
    default ReferenceDoublePair<K> second(Double l) {
        return second(l.doubleValue());
    }

    default double valueDouble() {
        return rightDouble();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Double value() {
        return Double.valueOf(valueDouble());
    }

    default ReferenceDoublePair<K> value(double r) {
        return right(r);
    }

    @Deprecated
    default ReferenceDoublePair<K> value(Double l) {
        return value(l.doubleValue());
    }

    /* renamed from: of */
    static <K> ReferenceDoublePair<K> m507of(K left, double right) {
        return new ReferenceDoubleImmutablePair(left, right);
    }
}
