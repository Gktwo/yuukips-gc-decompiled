package p014it.unimi.dsi.fastutil.booleans;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.booleans.BooleanLongPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanLongPair.class */
public interface BooleanLongPair extends Pair<Boolean, Long> {
    boolean leftBoolean();

    long rightLong();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Boolean left() {
        return Boolean.valueOf(leftBoolean());
    }

    default BooleanLongPair left(boolean l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default BooleanLongPair left(Boolean l) {
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

    default BooleanLongPair first(boolean l) {
        return left(l);
    }

    @Deprecated
    default BooleanLongPair first(Boolean l) {
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

    default BooleanLongPair key(boolean l) {
        return left(l);
    }

    @Deprecated
    default BooleanLongPair key(Boolean l) {
        return key(l.booleanValue());
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Long right() {
        return Long.valueOf(rightLong());
    }

    default BooleanLongPair right(long r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default BooleanLongPair right(Long l) {
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

    default BooleanLongPair second(long r) {
        return right(r);
    }

    @Deprecated
    default BooleanLongPair second(Long l) {
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

    default BooleanLongPair value(long r) {
        return right(r);
    }

    @Deprecated
    default BooleanLongPair value(Long l) {
        return value(l.longValue());
    }

    /* renamed from: of */
    static BooleanLongPair m1135of(boolean left, long right) {
        return new BooleanLongImmutablePair(left, right);
    }

    static Comparator<BooleanLongPair> lexComparator() {
        return x, y -> {
            int t = Boolean.compare(x.leftBoolean(), y.leftBoolean());
            return t != 0 ? t : Long.compare(x.rightLong(), y.rightLong());
        };
    }
}
