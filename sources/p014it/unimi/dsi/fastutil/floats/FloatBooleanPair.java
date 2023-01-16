package p014it.unimi.dsi.fastutil.floats;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.floats.FloatBooleanPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatBooleanPair.class */
public interface FloatBooleanPair extends Pair<Float, Boolean> {
    float leftFloat();

    boolean rightBoolean();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Float left() {
        return Float.valueOf(leftFloat());
    }

    default FloatBooleanPair left(float l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default FloatBooleanPair left(Float l) {
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

    default FloatBooleanPair first(float l) {
        return left(l);
    }

    @Deprecated
    default FloatBooleanPair first(Float l) {
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

    default FloatBooleanPair key(float l) {
        return left(l);
    }

    @Deprecated
    default FloatBooleanPair key(Float l) {
        return key(l.floatValue());
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Boolean right() {
        return Boolean.valueOf(rightBoolean());
    }

    default FloatBooleanPair right(boolean r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default FloatBooleanPair right(Boolean l) {
        return right(l.booleanValue());
    }

    default boolean secondBoolean() {
        return rightBoolean();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Boolean second() {
        return Boolean.valueOf(secondBoolean());
    }

    default FloatBooleanPair second(boolean r) {
        return right(r);
    }

    @Deprecated
    default FloatBooleanPair second(Boolean l) {
        return second(l.booleanValue());
    }

    default boolean valueBoolean() {
        return rightBoolean();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Boolean value() {
        return Boolean.valueOf(valueBoolean());
    }

    default FloatBooleanPair value(boolean r) {
        return right(r);
    }

    @Deprecated
    default FloatBooleanPair value(Boolean l) {
        return value(l.booleanValue());
    }

    /* renamed from: of */
    static FloatBooleanPair m830of(float left, boolean right) {
        return new FloatBooleanImmutablePair(left, right);
    }

    static Comparator<FloatBooleanPair> lexComparator() {
        return x, y -> {
            int t = Float.compare(x.leftFloat(), y.leftFloat());
            return t != 0 ? t : Boolean.compare(x.rightBoolean(), y.rightBoolean());
        };
    }
}
