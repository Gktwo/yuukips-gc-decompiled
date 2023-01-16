package p014it.unimi.dsi.fastutil.shorts;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.shorts.ShortBooleanPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortBooleanPair.class */
public interface ShortBooleanPair extends Pair<Short, Boolean> {
    short leftShort();

    boolean rightBoolean();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Short left() {
        return Short.valueOf(leftShort());
    }

    default ShortBooleanPair left(short l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default ShortBooleanPair left(Short l) {
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

    default ShortBooleanPair first(short l) {
        return left(l);
    }

    @Deprecated
    default ShortBooleanPair first(Short l) {
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

    default ShortBooleanPair key(short l) {
        return left(l);
    }

    @Deprecated
    default ShortBooleanPair key(Short l) {
        return key(l.shortValue());
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Boolean right() {
        return Boolean.valueOf(rightBoolean());
    }

    default ShortBooleanPair right(boolean r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default ShortBooleanPair right(Boolean l) {
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

    default ShortBooleanPair second(boolean r) {
        return right(r);
    }

    @Deprecated
    default ShortBooleanPair second(Boolean l) {
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

    default ShortBooleanPair value(boolean r) {
        return right(r);
    }

    @Deprecated
    default ShortBooleanPair value(Boolean l) {
        return value(l.booleanValue());
    }

    /* renamed from: of */
    static ShortBooleanPair m436of(short left, boolean right) {
        return new ShortBooleanImmutablePair(left, right);
    }

    static Comparator<ShortBooleanPair> lexComparator() {
        return x, y -> {
            int t = Short.compare(x.leftShort(), y.leftShort());
            return t != 0 ? t : Boolean.compare(x.rightBoolean(), y.rightBoolean());
        };
    }
}
