package p014it.unimi.dsi.fastutil.doubles;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.doubles.DoubleIntPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleIntPair.class */
public interface DoubleIntPair extends Pair<Double, Integer> {
    double leftDouble();

    int rightInt();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Double left() {
        return Double.valueOf(leftDouble());
    }

    default DoubleIntPair left(double l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default DoubleIntPair left(Double l) {
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

    default DoubleIntPair first(double l) {
        return left(l);
    }

    @Deprecated
    default DoubleIntPair first(Double l) {
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

    default DoubleIntPair key(double l) {
        return left(l);
    }

    @Deprecated
    default DoubleIntPair key(Double l) {
        return key(l.doubleValue());
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Integer right() {
        return Integer.valueOf(rightInt());
    }

    default DoubleIntPair right(int r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default DoubleIntPair right(Integer l) {
        return right(l.intValue());
    }

    default int secondInt() {
        return rightInt();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Integer second() {
        return Integer.valueOf(secondInt());
    }

    default DoubleIntPair second(int r) {
        return right(r);
    }

    @Deprecated
    default DoubleIntPair second(Integer l) {
        return second(l.intValue());
    }

    default int valueInt() {
        return rightInt();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Integer value() {
        return Integer.valueOf(valueInt());
    }

    default DoubleIntPair value(int r) {
        return right(r);
    }

    @Deprecated
    default DoubleIntPair value(Integer l) {
        return value(l.intValue());
    }

    /* renamed from: of */
    static DoubleIntPair m895of(double left, int right) {
        return new DoubleIntImmutablePair(left, right);
    }

    static Comparator<DoubleIntPair> lexComparator() {
        return x, y -> {
            int t = Double.compare(x.leftDouble(), y.leftDouble());
            return t != 0 ? t : Integer.compare(x.rightInt(), y.rightInt());
        };
    }
}
