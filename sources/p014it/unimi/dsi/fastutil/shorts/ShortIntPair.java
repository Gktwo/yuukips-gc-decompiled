package p014it.unimi.dsi.fastutil.shorts;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.shorts.ShortIntPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortIntPair.class */
public interface ShortIntPair extends Pair<Short, Integer> {
    short leftShort();

    int rightInt();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Short left() {
        return Short.valueOf(leftShort());
    }

    default ShortIntPair left(short l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default ShortIntPair left(Short l) {
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

    default ShortIntPair first(short l) {
        return left(l);
    }

    @Deprecated
    default ShortIntPair first(Short l) {
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

    default ShortIntPair key(short l) {
        return left(l);
    }

    @Deprecated
    default ShortIntPair key(Short l) {
        return key(l.shortValue());
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Integer right() {
        return Integer.valueOf(rightInt());
    }

    default ShortIntPair right(int r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default ShortIntPair right(Integer l) {
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

    default ShortIntPair second(int r) {
        return right(r);
    }

    @Deprecated
    default ShortIntPair second(Integer l) {
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

    default ShortIntPair value(int r) {
        return right(r);
    }

    @Deprecated
    default ShortIntPair value(Integer l) {
        return value(l.intValue());
    }

    /* renamed from: of */
    static ShortIntPair m419of(short left, int right) {
        return new ShortIntImmutablePair(left, right);
    }

    static Comparator<ShortIntPair> lexComparator() {
        return x, y -> {
            int t = Short.compare(x.leftShort(), y.leftShort());
            return t != 0 ? t : Integer.compare(x.rightInt(), y.rightInt());
        };
    }
}
