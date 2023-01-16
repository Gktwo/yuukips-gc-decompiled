package p014it.unimi.dsi.fastutil.booleans;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.booleans.BooleanFloatPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanFloatPair.class */
public interface BooleanFloatPair extends Pair<Boolean, Float> {
    boolean leftBoolean();

    float rightFloat();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Boolean left() {
        return Boolean.valueOf(leftBoolean());
    }

    default BooleanFloatPair left(boolean l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default BooleanFloatPair left(Boolean l) {
        return left(l.booleanValue());
    }

    default boolean firstBoolean() {
        return leftBoolean();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Boolean first() {
        return Boolean.valueOf(firstBoolean());
    }

    default BooleanFloatPair first(boolean l) {
        return left(l);
    }

    @Deprecated
    default BooleanFloatPair first(Boolean l) {
        return first(l.booleanValue());
    }

    default boolean keyBoolean() {
        return firstBoolean();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Boolean key() {
        return Boolean.valueOf(keyBoolean());
    }

    default BooleanFloatPair key(boolean l) {
        return left(l);
    }

    @Deprecated
    default BooleanFloatPair key(Boolean l) {
        return key(l.booleanValue());
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Float right() {
        return Float.valueOf(rightFloat());
    }

    default BooleanFloatPair right(float r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default BooleanFloatPair right(Float l) {
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

    default BooleanFloatPair second(float r) {
        return right(r);
    }

    @Deprecated
    default BooleanFloatPair second(Float l) {
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

    default BooleanFloatPair value(float r) {
        return right(r);
    }

    @Deprecated
    default BooleanFloatPair value(Float l) {
        return value(l.floatValue());
    }

    /* renamed from: of */
    static BooleanFloatPair m1148of(boolean left, float right) {
        return new BooleanFloatImmutablePair(left, right);
    }

    static Comparator<BooleanFloatPair> lexComparator() {
        return x, y -> {
            int t = Boolean.compare(x.leftBoolean(), y.leftBoolean());
            return t != 0 ? t : Float.compare(x.rightFloat(), y.rightFloat());
        };
    }
}
