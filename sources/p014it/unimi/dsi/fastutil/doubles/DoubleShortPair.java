package p014it.unimi.dsi.fastutil.doubles;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.doubles.DoubleShortPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleShortPair.class */
public interface DoubleShortPair extends Pair<Double, Short> {
    double leftDouble();

    short rightShort();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Double left() {
        return Double.valueOf(leftDouble());
    }

    default DoubleShortPair left(double l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default DoubleShortPair left(Double l) {
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

    default DoubleShortPair first(double l) {
        return left(l);
    }

    @Deprecated
    default DoubleShortPair first(Double l) {
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

    default DoubleShortPair key(double l) {
        return left(l);
    }

    @Deprecated
    default DoubleShortPair key(Double l) {
        return key(l.doubleValue());
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Short right() {
        return Short.valueOf(rightShort());
    }

    default DoubleShortPair right(short r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default DoubleShortPair right(Short l) {
        return right(l.shortValue());
    }

    default short secondShort() {
        return rightShort();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Short second() {
        return Short.valueOf(secondShort());
    }

    default DoubleShortPair second(short r) {
        return right(r);
    }

    @Deprecated
    default DoubleShortPair second(Short l) {
        return second(l.shortValue());
    }

    default short valueShort() {
        return rightShort();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Short value() {
        return Short.valueOf(valueShort());
    }

    default DoubleShortPair value(short r) {
        return right(r);
    }

    @Deprecated
    default DoubleShortPair value(Short l) {
        return value(l.shortValue());
    }

    /* renamed from: of */
    static DoubleShortPair m861of(double left, short right) {
        return new DoubleShortImmutablePair(left, right);
    }

    static Comparator<DoubleShortPair> lexComparator() {
        return x, y -> {
            int t = Double.compare(x.leftDouble(), y.leftDouble());
            return t != 0 ? t : Short.compare(x.rightShort(), y.rightShort());
        };
    }
}
