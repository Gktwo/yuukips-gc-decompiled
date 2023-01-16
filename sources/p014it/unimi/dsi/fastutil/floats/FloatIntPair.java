package p014it.unimi.dsi.fastutil.floats;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.floats.FloatIntPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatIntPair.class */
public interface FloatIntPair extends Pair<Float, Integer> {
    float leftFloat();

    int rightInt();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Float left() {
        return Float.valueOf(leftFloat());
    }

    default FloatIntPair left(float l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default FloatIntPair left(Float l) {
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

    default FloatIntPair first(float l) {
        return left(l);
    }

    @Deprecated
    default FloatIntPair first(Float l) {
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

    default FloatIntPair key(float l) {
        return left(l);
    }

    @Deprecated
    default FloatIntPair key(Float l) {
        return key(l.floatValue());
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Integer right() {
        return Integer.valueOf(rightInt());
    }

    default FloatIntPair right(int r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default FloatIntPair right(Integer l) {
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

    default FloatIntPair second(int r) {
        return right(r);
    }

    @Deprecated
    default FloatIntPair second(Integer l) {
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

    default FloatIntPair value(int r) {
        return right(r);
    }

    @Deprecated
    default FloatIntPair value(Integer l) {
        return value(l.intValue());
    }

    /* renamed from: of */
    static FloatIntPair m811of(float left, int right) {
        return new FloatIntImmutablePair(left, right);
    }

    static Comparator<FloatIntPair> lexComparator() {
        return x, y -> {
            int t = Float.compare(x.leftFloat(), y.leftFloat());
            return t != 0 ? t : Integer.compare(x.rightInt(), y.rightInt());
        };
    }
}
