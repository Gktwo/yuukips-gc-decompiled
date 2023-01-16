package p014it.unimi.dsi.fastutil.longs;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.longs.LongIntPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongIntPair.class */
public interface LongIntPair extends Pair<Long, Integer> {
    long leftLong();

    int rightInt();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Long left() {
        return Long.valueOf(leftLong());
    }

    default LongIntPair left(long l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default LongIntPair left(Long l) {
        return left(l.longValue());
    }

    default long firstLong() {
        return leftLong();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Long first() {
        return Long.valueOf(firstLong());
    }

    default LongIntPair first(long l) {
        return left(l);
    }

    @Deprecated
    default LongIntPair first(Long l) {
        return first(l.longValue());
    }

    default long keyLong() {
        return firstLong();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Long key() {
        return Long.valueOf(keyLong());
    }

    default LongIntPair key(long l) {
        return left(l);
    }

    @Deprecated
    default LongIntPair key(Long l) {
        return key(l.longValue());
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Integer right() {
        return Integer.valueOf(rightInt());
    }

    default LongIntPair right(int r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default LongIntPair right(Integer l) {
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

    default LongIntPair second(int r) {
        return right(r);
    }

    @Deprecated
    default LongIntPair second(Integer l) {
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

    default LongIntPair value(int r) {
        return right(r);
    }

    @Deprecated
    default LongIntPair value(Integer l) {
        return value(l.intValue());
    }

    /* renamed from: of */
    static LongIntPair m644of(long left, int right) {
        return new LongIntImmutablePair(left, right);
    }

    static Comparator<LongIntPair> lexComparator() {
        return x, y -> {
            int t = Long.compare(x.leftLong(), y.leftLong());
            return t != 0 ? t : Integer.compare(x.rightInt(), y.rightInt());
        };
    }
}
