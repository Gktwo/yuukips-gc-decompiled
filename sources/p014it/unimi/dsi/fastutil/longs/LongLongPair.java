package p014it.unimi.dsi.fastutil.longs;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.longs.LongLongPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongLongPair.class */
public interface LongLongPair extends Pair<Long, Long> {
    long leftLong();

    long rightLong();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Long left() {
        return Long.valueOf(leftLong());
    }

    default LongLongPair left(long l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default LongLongPair left(Long l) {
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

    default LongLongPair first(long l) {
        return left(l);
    }

    @Deprecated
    default LongLongPair first(Long l) {
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

    default LongLongPair key(long l) {
        return left(l);
    }

    @Deprecated
    default LongLongPair key(Long l) {
        return key(l.longValue());
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Long right() {
        return Long.valueOf(rightLong());
    }

    default LongLongPair right(long r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default LongLongPair right(Long l) {
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

    default LongLongPair second(long r) {
        return right(r);
    }

    @Deprecated
    default LongLongPair second(Long l) {
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

    default LongLongPair value(long r) {
        return right(r);
    }

    @Deprecated
    default LongLongPair value(Long l) {
        return value(l.longValue());
    }

    /* renamed from: of */
    static LongLongPair m630of(long left, long right) {
        return new LongLongImmutablePair(left, right);
    }

    static Comparator<LongLongPair> lexComparator() {
        return x, y -> {
            int t = Long.compare(x.leftLong(), y.leftLong());
            return t != 0 ? t : Long.compare(x.rightLong(), y.rightLong());
        };
    }
}
