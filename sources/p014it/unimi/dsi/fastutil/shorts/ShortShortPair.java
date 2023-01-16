package p014it.unimi.dsi.fastutil.shorts;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.shorts.ShortShortPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortShortPair.class */
public interface ShortShortPair extends Pair<Short, Short> {
    short leftShort();

    short rightShort();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Short left() {
        return Short.valueOf(leftShort());
    }

    default ShortShortPair left(short l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default ShortShortPair left(Short l) {
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

    default ShortShortPair first(short l) {
        return left(l);
    }

    @Deprecated
    default ShortShortPair first(Short l) {
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

    default ShortShortPair key(short l) {
        return left(l);
    }

    @Deprecated
    default ShortShortPair key(Short l) {
        return key(l.shortValue());
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Short right() {
        return Short.valueOf(rightShort());
    }

    default ShortShortPair right(short r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default ShortShortPair right(Short l) {
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

    default ShortShortPair second(short r) {
        return right(r);
    }

    @Deprecated
    default ShortShortPair second(Short l) {
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

    default ShortShortPair value(short r) {
        return right(r);
    }

    @Deprecated
    default ShortShortPair value(Short l) {
        return value(l.shortValue());
    }

    /* renamed from: of */
    static ShortShortPair m383of(short left, short right) {
        return new ShortShortImmutablePair(left, right);
    }

    static Comparator<ShortShortPair> lexComparator() {
        return x, y -> {
            int t = Short.compare(x.leftShort(), y.leftShort());
            return t != 0 ? t : Short.compare(x.rightShort(), y.rightShort());
        };
    }
}
