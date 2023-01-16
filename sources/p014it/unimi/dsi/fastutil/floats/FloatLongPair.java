package p014it.unimi.dsi.fastutil.floats;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.floats.FloatLongPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatLongPair.class */
public interface FloatLongPair extends Pair<Float, Long> {
    float leftFloat();

    long rightLong();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Float left() {
        return Float.valueOf(leftFloat());
    }

    default FloatLongPair left(float l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default FloatLongPair left(Float l) {
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

    default FloatLongPair first(float l) {
        return left(l);
    }

    @Deprecated
    default FloatLongPair first(Float l) {
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

    default FloatLongPair key(float l) {
        return left(l);
    }

    @Deprecated
    default FloatLongPair key(Float l) {
        return key(l.floatValue());
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Long right() {
        return Long.valueOf(rightLong());
    }

    default FloatLongPair right(long r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default FloatLongPair right(Long l) {
        return right(l.longValue());
    }

    default long secondLong() {
        return rightLong();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Long second() {
        return Long.valueOf(secondLong());
    }

    default FloatLongPair second(long r) {
        return right(r);
    }

    @Deprecated
    default FloatLongPair second(Long l) {
        return second(l.longValue());
    }

    default long valueLong() {
        return rightLong();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Long value() {
        return Long.valueOf(valueLong());
    }

    default FloatLongPair value(long r) {
        return right(r);
    }

    @Deprecated
    default FloatLongPair value(Long l) {
        return value(l.longValue());
    }

    /* renamed from: of */
    static FloatLongPair m798of(float left, long right) {
        return new FloatLongImmutablePair(left, right);
    }

    static Comparator<FloatLongPair> lexComparator() {
        return x, y -> {
            int t = Float.compare(x.leftFloat(), y.leftFloat());
            return t != 0 ? t : Long.compare(x.rightLong(), y.rightLong());
        };
    }
}
