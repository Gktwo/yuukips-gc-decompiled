package p014it.unimi.dsi.fastutil.booleans;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.booleans.BooleanIntPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanIntPair.class */
public interface BooleanIntPair extends Pair<Boolean, Integer> {
    boolean leftBoolean();

    int rightInt();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Boolean left() {
        return Boolean.valueOf(leftBoolean());
    }

    default BooleanIntPair left(boolean l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default BooleanIntPair left(Boolean l) {
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

    default BooleanIntPair first(boolean l) {
        return left(l);
    }

    @Deprecated
    default BooleanIntPair first(Boolean l) {
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

    default BooleanIntPair key(boolean l) {
        return left(l);
    }

    @Deprecated
    default BooleanIntPair key(Boolean l) {
        return key(l.booleanValue());
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Integer right() {
        return Integer.valueOf(rightInt());
    }

    default BooleanIntPair right(int r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default BooleanIntPair right(Integer l) {
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

    default BooleanIntPair second(int r) {
        return right(r);
    }

    @Deprecated
    default BooleanIntPair second(Integer l) {
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

    default BooleanIntPair value(int r) {
        return right(r);
    }

    @Deprecated
    default BooleanIntPair value(Integer l) {
        return value(l.intValue());
    }

    /* renamed from: of */
    static BooleanIntPair m1143of(boolean left, int right) {
        return new BooleanIntImmutablePair(left, right);
    }

    static Comparator<BooleanIntPair> lexComparator() {
        return x, y -> {
            int t = Boolean.compare(x.leftBoolean(), y.leftBoolean());
            return t != 0 ? t : Integer.compare(x.rightInt(), y.rightInt());
        };
    }
}
