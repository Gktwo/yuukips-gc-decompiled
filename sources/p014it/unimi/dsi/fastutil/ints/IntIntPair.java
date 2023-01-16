package p014it.unimi.dsi.fastutil.ints;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.ints.IntIntPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntIntPair.class */
public interface IntIntPair extends Pair<Integer, Integer> {
    int leftInt();

    int rightInt();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Integer left() {
        return Integer.valueOf(leftInt());
    }

    default IntIntPair left(int l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default IntIntPair left(Integer l) {
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

    default IntIntPair first(int l) {
        return left(l);
    }

    @Deprecated
    default IntIntPair first(Integer l) {
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

    default IntIntPair key(int l) {
        return left(l);
    }

    @Deprecated
    default IntIntPair key(Integer l) {
        return key(l.intValue());
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Integer right() {
        return Integer.valueOf(rightInt());
    }

    default IntIntPair right(int r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default IntIntPair right(Integer l) {
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

    default IntIntPair second(int r) {
        return right(r);
    }

    @Deprecated
    default IntIntPair second(Integer l) {
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

    default IntIntPair value(int r) {
        return right(r);
    }

    @Deprecated
    default IntIntPair value(Integer l) {
        return value(l.intValue());
    }

    /* renamed from: of */
    static IntIntPair m728of(int left, int right) {
        return new IntIntImmutablePair(left, right);
    }

    static Comparator<IntIntPair> lexComparator() {
        return x, y -> {
            int t = Integer.compare(x.leftInt(), y.leftInt());
            return t != 0 ? t : Integer.compare(x.rightInt(), y.rightInt());
        };
    }
}
