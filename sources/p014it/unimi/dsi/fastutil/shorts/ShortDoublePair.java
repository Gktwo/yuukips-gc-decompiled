package p014it.unimi.dsi.fastutil.shorts;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.shorts.ShortDoublePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortDoublePair.class */
public interface ShortDoublePair extends Pair<Short, Double> {
    short leftShort();

    double rightDouble();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Short left() {
        return Short.valueOf(leftShort());
    }

    default ShortDoublePair left(short l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default ShortDoublePair left(Short l) {
        return left(l.shortValue());
    }

    default short firstShort() {
        return leftShort();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Short first() {
        return Short.valueOf(firstShort());
    }

    default ShortDoublePair first(short l) {
        return left(l);
    }

    @Deprecated
    default ShortDoublePair first(Short l) {
        return first(l.shortValue());
    }

    default short keyShort() {
        return firstShort();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Short key() {
        return Short.valueOf(keyShort());
    }

    default ShortDoublePair key(short l) {
        return left(l);
    }

    @Deprecated
    default ShortDoublePair key(Short l) {
        return key(l.shortValue());
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Double right() {
        return Double.valueOf(rightDouble());
    }

    default ShortDoublePair right(double r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default ShortDoublePair right(Double l) {
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

    default ShortDoublePair second(double r) {
        return right(r);
    }

    @Deprecated
    default ShortDoublePair second(Double l) {
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

    default ShortDoublePair value(double r) {
        return right(r);
    }

    @Deprecated
    default ShortDoublePair value(Double l) {
        return value(l.doubleValue());
    }

    /* renamed from: of */
    static ShortDoublePair m427of(short left, double right) {
        return new ShortDoubleImmutablePair(left, right);
    }

    static Comparator<ShortDoublePair> lexComparator() {
        return x, y -> {
            int t = Short.compare(x.leftShort(), y.leftShort());
            return t != 0 ? t : Double.compare(x.rightDouble(), y.rightDouble());
        };
    }
}
