package p014it.unimi.dsi.fastutil.floats;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.floats.FloatShortPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatShortPair.class */
public interface FloatShortPair extends Pair<Float, Short> {
    float leftFloat();

    short rightShort();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Float left() {
        return Float.valueOf(leftFloat());
    }

    default FloatShortPair left(float l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default FloatShortPair left(Float l) {
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

    default FloatShortPair first(float l) {
        return left(l);
    }

    @Deprecated
    default FloatShortPair first(Float l) {
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

    default FloatShortPair key(float l) {
        return left(l);
    }

    @Deprecated
    default FloatShortPair key(Float l) {
        return key(l.floatValue());
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Short right() {
        return Short.valueOf(rightShort());
    }

    default FloatShortPair right(short r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default FloatShortPair right(Short l) {
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

    default FloatShortPair second(short r) {
        return right(r);
    }

    @Deprecated
    default FloatShortPair second(Short l) {
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

    default FloatShortPair value(short r) {
        return right(r);
    }

    @Deprecated
    default FloatShortPair value(Short l) {
        return value(l.shortValue());
    }

    /* renamed from: of */
    static FloatShortPair m777of(float left, short right) {
        return new FloatShortImmutablePair(left, right);
    }

    static Comparator<FloatShortPair> lexComparator() {
        return x, y -> {
            int t = Float.compare(x.leftFloat(), y.leftFloat());
            return t != 0 ? t : Short.compare(x.rightShort(), y.rightShort());
        };
    }
}
