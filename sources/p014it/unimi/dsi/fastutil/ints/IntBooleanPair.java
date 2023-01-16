package p014it.unimi.dsi.fastutil.ints;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.ints.IntBooleanPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntBooleanPair.class */
public interface IntBooleanPair extends Pair<Integer, Boolean> {
    int leftInt();

    boolean rightBoolean();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Integer left() {
        return Integer.valueOf(leftInt());
    }

    default IntBooleanPair left(int l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default IntBooleanPair left(Integer l) {
        return left(l.intValue());
    }

    default int firstInt() {
        return leftInt();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Integer first() {
        return Integer.valueOf(firstInt());
    }

    default IntBooleanPair first(int l) {
        return left(l);
    }

    @Deprecated
    default IntBooleanPair first(Integer l) {
        return first(l.intValue());
    }

    default int keyInt() {
        return firstInt();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Integer key() {
        return Integer.valueOf(keyInt());
    }

    default IntBooleanPair key(int l) {
        return left(l);
    }

    @Deprecated
    default IntBooleanPair key(Integer l) {
        return key(l.intValue());
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Boolean right() {
        return Boolean.valueOf(rightBoolean());
    }

    default IntBooleanPair right(boolean r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default IntBooleanPair right(Boolean l) {
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

    default IntBooleanPair second(boolean r) {
        return right(r);
    }

    @Deprecated
    default IntBooleanPair second(Boolean l) {
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

    default IntBooleanPair value(boolean r) {
        return right(r);
    }

    @Deprecated
    default IntBooleanPair value(Boolean l) {
        return value(l.booleanValue());
    }

    /* renamed from: of */
    static IntBooleanPair m746of(int left, boolean right) {
        return new IntBooleanImmutablePair(left, right);
    }

    static Comparator<IntBooleanPair> lexComparator() {
        return x, y -> {
            int t = Integer.compare(x.leftInt(), y.leftInt());
            return t != 0 ? t : Boolean.compare(x.rightBoolean(), y.rightBoolean());
        };
    }
}
