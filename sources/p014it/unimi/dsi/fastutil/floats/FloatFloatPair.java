package p014it.unimi.dsi.fastutil.floats;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.floats.FloatFloatPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatFloatPair.class */
public interface FloatFloatPair extends Pair<Float, Float> {
    float leftFloat();

    float rightFloat();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Float left() {
        return Float.valueOf(leftFloat());
    }

    default FloatFloatPair left(float l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default FloatFloatPair left(Float l) {
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

    default FloatFloatPair first(float l) {
        return left(l);
    }

    @Deprecated
    default FloatFloatPair first(Float l) {
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

    default FloatFloatPair key(float l) {
        return left(l);
    }

    @Deprecated
    default FloatFloatPair key(Float l) {
        return key(l.floatValue());
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Float right() {
        return Float.valueOf(rightFloat());
    }

    default FloatFloatPair right(float r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default FloatFloatPair right(Float l) {
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

    default FloatFloatPair second(float r) {
        return right(r);
    }

    @Deprecated
    default FloatFloatPair second(Float l) {
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

    default FloatFloatPair value(float r) {
        return right(r);
    }

    @Deprecated
    default FloatFloatPair value(Float l) {
        return value(l.floatValue());
    }

    /* renamed from: of */
    static FloatFloatPair m817of(float left, float right) {
        return new FloatFloatImmutablePair(left, right);
    }

    static Comparator<FloatFloatPair> lexComparator() {
        return x, y -> {
            int t = Float.compare(x.leftFloat(), y.leftFloat());
            return t != 0 ? t : Float.compare(x.rightFloat(), y.rightFloat());
        };
    }
}
