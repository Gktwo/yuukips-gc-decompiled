package p014it.unimi.dsi.fastutil.floats;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.floats.FloatDoublePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatDoublePair.class */
public interface FloatDoublePair extends Pair<Float, Double> {
    float leftFloat();

    double rightDouble();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Float left() {
        return Float.valueOf(leftFloat());
    }

    default FloatDoublePair left(float l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default FloatDoublePair left(Float l) {
        return left(l.floatValue());
    }

    default float firstFloat() {
        return leftFloat();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Float first() {
        return Float.valueOf(firstFloat());
    }

    default FloatDoublePair first(float l) {
        return left(l);
    }

    @Deprecated
    default FloatDoublePair first(Float l) {
        return first(l.floatValue());
    }

    default float keyFloat() {
        return firstFloat();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Float key() {
        return Float.valueOf(keyFloat());
    }

    default FloatDoublePair key(float l) {
        return left(l);
    }

    @Deprecated
    default FloatDoublePair key(Float l) {
        return key(l.floatValue());
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Double right() {
        return Double.valueOf(rightDouble());
    }

    default FloatDoublePair right(double r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default FloatDoublePair right(Double l) {
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

    default FloatDoublePair second(double r) {
        return right(r);
    }

    @Deprecated
    default FloatDoublePair second(Double l) {
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

    default FloatDoublePair value(double r) {
        return right(r);
    }

    @Deprecated
    default FloatDoublePair value(Double l) {
        return value(l.doubleValue());
    }

    /* renamed from: of */
    static FloatDoublePair m821of(float left, double right) {
        return new FloatDoubleImmutablePair(left, right);
    }

    static Comparator<FloatDoublePair> lexComparator() {
        return x, y -> {
            int t = Float.compare(x.leftFloat(), y.leftFloat());
            return t != 0 ? t : Double.compare(x.rightDouble(), y.rightDouble());
        };
    }
}
