package p014it.unimi.dsi.fastutil.doubles;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.doubles.DoubleFloatPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleFloatPair.class */
public interface DoubleFloatPair extends Pair<Double, Float> {
    double leftDouble();

    float rightFloat();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Double left() {
        return Double.valueOf(leftDouble());
    }

    default DoubleFloatPair left(double l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default DoubleFloatPair left(Double l) {
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

    default DoubleFloatPair first(double l) {
        return left(l);
    }

    @Deprecated
    default DoubleFloatPair first(Double l) {
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

    default DoubleFloatPair key(double l) {
        return left(l);
    }

    @Deprecated
    default DoubleFloatPair key(Double l) {
        return key(l.doubleValue());
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Float right() {
        return Float.valueOf(rightFloat());
    }

    default DoubleFloatPair right(float r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default DoubleFloatPair right(Float l) {
        return right(l.floatValue());
    }

    default float secondFloat() {
        return rightFloat();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Float second() {
        return Float.valueOf(secondFloat());
    }

    default DoubleFloatPair second(float r) {
        return right(r);
    }

    @Deprecated
    default DoubleFloatPair second(Float l) {
        return second(l.floatValue());
    }

    default float valueFloat() {
        return rightFloat();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Float value() {
        return Float.valueOf(valueFloat());
    }

    default DoubleFloatPair value(float r) {
        return right(r);
    }

    @Deprecated
    default DoubleFloatPair value(Float l) {
        return value(l.floatValue());
    }

    /* renamed from: of */
    static DoubleFloatPair m900of(double left, float right) {
        return new DoubleFloatImmutablePair(left, right);
    }

    static Comparator<DoubleFloatPair> lexComparator() {
        return x, y -> {
            int t = Double.compare(x.leftDouble(), y.leftDouble());
            return t != 0 ? t : Float.compare(x.rightFloat(), y.rightFloat());
        };
    }
}
