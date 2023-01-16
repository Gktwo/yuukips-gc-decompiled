package p014it.unimi.dsi.fastutil.shorts;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.shorts.ShortFloatPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortFloatPair.class */
public interface ShortFloatPair extends Pair<Short, Float> {
    short leftShort();

    float rightFloat();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Short left() {
        return Short.valueOf(leftShort());
    }

    default ShortFloatPair left(short l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default ShortFloatPair left(Short l) {
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

    default ShortFloatPair first(short l) {
        return left(l);
    }

    @Deprecated
    default ShortFloatPair first(Short l) {
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

    default ShortFloatPair key(short l) {
        return left(l);
    }

    @Deprecated
    default ShortFloatPair key(Short l) {
        return key(l.shortValue());
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Float right() {
        return Float.valueOf(rightFloat());
    }

    default ShortFloatPair right(float r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default ShortFloatPair right(Float l) {
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

    default ShortFloatPair second(float r) {
        return right(r);
    }

    @Deprecated
    default ShortFloatPair second(Float l) {
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

    default ShortFloatPair value(float r) {
        return right(r);
    }

    @Deprecated
    default ShortFloatPair value(Float l) {
        return value(l.floatValue());
    }

    /* renamed from: of */
    static ShortFloatPair m424of(short left, float right) {
        return new ShortFloatImmutablePair(left, right);
    }

    static Comparator<ShortFloatPair> lexComparator() {
        return x, y -> {
            int t = Short.compare(x.leftShort(), y.leftShort());
            return t != 0 ? t : Float.compare(x.rightFloat(), y.rightFloat());
        };
    }
}
