package p014it.unimi.dsi.fastutil.doubles;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.doubles.DoubleDoublePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleDoublePair.class */
public interface DoubleDoublePair extends Pair<Double, Double> {
    double leftDouble();

    double rightDouble();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Double left() {
        return Double.valueOf(leftDouble());
    }

    default DoubleDoublePair left(double l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default DoubleDoublePair left(Double l) {
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

    default DoubleDoublePair first(double l) {
        return left(l);
    }

    @Deprecated
    default DoubleDoublePair first(Double l) {
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

    default DoubleDoublePair key(double l) {
        return left(l);
    }

    @Deprecated
    default DoubleDoublePair key(Double l) {
        return key(l.doubleValue());
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Double right() {
        return Double.valueOf(rightDouble());
    }

    default DoubleDoublePair right(double r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default DoubleDoublePair right(Double l) {
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

    default DoubleDoublePair second(double r) {
        return right(r);
    }

    @Deprecated
    default DoubleDoublePair second(Double l) {
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

    default DoubleDoublePair value(double r) {
        return right(r);
    }

    @Deprecated
    default DoubleDoublePair value(Double l) {
        return value(l.doubleValue());
    }

    /* renamed from: of */
    static DoubleDoublePair m904of(double left, double right) {
        return new DoubleDoubleImmutablePair(left, right);
    }

    static Comparator<DoubleDoublePair> lexComparator() {
        return x, y -> {
            int t = Double.compare(x.leftDouble(), y.leftDouble());
            return t != 0 ? t : Double.compare(x.rightDouble(), y.rightDouble());
        };
    }
}
