package p014it.unimi.dsi.fastutil.booleans;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.booleans.BooleanShortPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanShortPair.class */
public interface BooleanShortPair extends Pair<Boolean, Short> {
    boolean leftBoolean();

    short rightShort();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Boolean left() {
        return Boolean.valueOf(leftBoolean());
    }

    default BooleanShortPair left(boolean l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default BooleanShortPair left(Boolean l) {
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

    default BooleanShortPair first(boolean l) {
        return left(l);
    }

    @Deprecated
    default BooleanShortPair first(Boolean l) {
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

    default BooleanShortPair key(boolean l) {
        return left(l);
    }

    @Deprecated
    default BooleanShortPair key(Boolean l) {
        return key(l.booleanValue());
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Short right() {
        return Short.valueOf(rightShort());
    }

    default BooleanShortPair right(short r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default BooleanShortPair right(Short l) {
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

    default BooleanShortPair second(short r) {
        return right(r);
    }

    @Deprecated
    default BooleanShortPair second(Short l) {
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

    default BooleanShortPair value(short r) {
        return right(r);
    }

    @Deprecated
    default BooleanShortPair value(Short l) {
        return value(l.shortValue());
    }

    /* renamed from: of */
    static BooleanShortPair m1115of(boolean left, short right) {
        return new BooleanShortImmutablePair(left, right);
    }

    static Comparator<BooleanShortPair> lexComparator() {
        return x, y -> {
            int t = Boolean.compare(x.leftBoolean(), y.leftBoolean());
            return t != 0 ? t : Short.compare(x.rightShort(), y.rightShort());
        };
    }
}
