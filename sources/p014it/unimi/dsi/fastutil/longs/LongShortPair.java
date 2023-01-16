package p014it.unimi.dsi.fastutil.longs;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.longs.LongShortPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongShortPair.class */
public interface LongShortPair extends Pair<Long, Short> {
    long leftLong();

    short rightShort();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Long left() {
        return Long.valueOf(leftLong());
    }

    default LongShortPair left(long l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default LongShortPair left(Long l) {
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

    default LongShortPair first(long l) {
        return left(l);
    }

    @Deprecated
    default LongShortPair first(Long l) {
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

    default LongShortPair key(long l) {
        return left(l);
    }

    @Deprecated
    default LongShortPair key(Long l) {
        return key(l.longValue());
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Short right() {
        return Short.valueOf(rightShort());
    }

    default LongShortPair right(short r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default LongShortPair right(Short l) {
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

    default LongShortPair second(short r) {
        return right(r);
    }

    @Deprecated
    default LongShortPair second(Short l) {
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

    default LongShortPair value(short r) {
        return right(r);
    }

    @Deprecated
    default LongShortPair value(Short l) {
        return value(l.shortValue());
    }

    /* renamed from: of */
    static LongShortPair m607of(long left, short right) {
        return new LongShortImmutablePair(left, right);
    }

    static Comparator<LongShortPair> lexComparator() {
        return x, y -> {
            int t = Long.compare(x.leftLong(), y.leftLong());
            return t != 0 ? t : Short.compare(x.rightShort(), y.rightShort());
        };
    }
}
