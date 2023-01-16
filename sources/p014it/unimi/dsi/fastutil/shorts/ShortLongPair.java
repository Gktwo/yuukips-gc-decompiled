package p014it.unimi.dsi.fastutil.shorts;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.shorts.ShortLongPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortLongPair.class */
public interface ShortLongPair extends Pair<Short, Long> {
    short leftShort();

    long rightLong();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Short left() {
        return Short.valueOf(leftShort());
    }

    default ShortLongPair left(short l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default ShortLongPair left(Short l) {
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

    default ShortLongPair first(short l) {
        return left(l);
    }

    @Deprecated
    default ShortLongPair first(Short l) {
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

    default ShortLongPair key(short l) {
        return left(l);
    }

    @Deprecated
    default ShortLongPair key(Short l) {
        return key(l.shortValue());
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Long right() {
        return Long.valueOf(rightLong());
    }

    default ShortLongPair right(long r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default ShortLongPair right(Long l) {
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

    default ShortLongPair second(long r) {
        return right(r);
    }

    @Deprecated
    default ShortLongPair second(Long l) {
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

    default ShortLongPair value(long r) {
        return right(r);
    }

    @Deprecated
    default ShortLongPair value(Long l) {
        return value(l.longValue());
    }

    /* renamed from: of */
    static ShortLongPair m406of(short left, long right) {
        return new ShortLongImmutablePair(left, right);
    }

    static Comparator<ShortLongPair> lexComparator() {
        return x, y -> {
            int t = Short.compare(x.leftShort(), y.leftShort());
            return t != 0 ? t : Long.compare(x.rightLong(), y.rightLong());
        };
    }
}
