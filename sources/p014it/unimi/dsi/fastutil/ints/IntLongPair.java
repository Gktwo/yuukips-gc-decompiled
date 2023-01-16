package p014it.unimi.dsi.fastutil.ints;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.ints.IntLongPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntLongPair.class */
public interface IntLongPair extends Pair<Integer, Long> {
    int leftInt();

    long rightLong();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Integer left() {
        return Integer.valueOf(leftInt());
    }

    default IntLongPair left(int l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default IntLongPair left(Integer l) {
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

    default IntLongPair first(int l) {
        return left(l);
    }

    @Deprecated
    default IntLongPair first(Integer l) {
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

    default IntLongPair key(int l) {
        return left(l);
    }

    @Deprecated
    default IntLongPair key(Integer l) {
        return key(l.intValue());
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Long right() {
        return Long.valueOf(rightLong());
    }

    default IntLongPair right(long r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default IntLongPair right(Long l) {
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

    default IntLongPair second(long r) {
        return right(r);
    }

    @Deprecated
    default IntLongPair second(Long l) {
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

    default IntLongPair value(long r) {
        return right(r);
    }

    @Deprecated
    default IntLongPair value(Long l) {
        return value(l.longValue());
    }

    /* renamed from: of */
    static IntLongPair m714of(int left, long right) {
        return new IntLongImmutablePair(left, right);
    }

    static Comparator<IntLongPair> lexComparator() {
        return x, y -> {
            int t = Integer.compare(x.leftInt(), y.leftInt());
            return t != 0 ? t : Long.compare(x.rightLong(), y.rightLong());
        };
    }
}
