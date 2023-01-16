package p014it.unimi.dsi.fastutil.longs;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.longs.LongDoublePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongDoublePair.class */
public interface LongDoublePair extends Pair<Long, Double> {
    long leftLong();

    double rightDouble();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Long left() {
        return Long.valueOf(leftLong());
    }

    default LongDoublePair left(long l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default LongDoublePair left(Long l) {
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

    default LongDoublePair first(long l) {
        return left(l);
    }

    @Deprecated
    default LongDoublePair first(Long l) {
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

    default LongDoublePair key(long l) {
        return left(l);
    }

    @Deprecated
    default LongDoublePair key(Long l) {
        return key(l.longValue());
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Double right() {
        return Double.valueOf(rightDouble());
    }

    default LongDoublePair right(double r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default LongDoublePair right(Double l) {
        return right(l.doubleValue());
    }

    default double secondDouble() {
        return rightDouble();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Double second() {
        return Double.valueOf(secondDouble());
    }

    default LongDoublePair second(double r) {
        return right(r);
    }

    @Deprecated
    default LongDoublePair second(Double l) {
        return second(l.doubleValue());
    }

    default double valueDouble() {
        return rightDouble();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Double value() {
        return Double.valueOf(valueDouble());
    }

    default LongDoublePair value(double r) {
        return right(r);
    }

    @Deprecated
    default LongDoublePair value(Double l) {
        return value(l.doubleValue());
    }

    /* renamed from: of */
    static LongDoublePair m652of(long left, double right) {
        return new LongDoubleImmutablePair(left, right);
    }

    static Comparator<LongDoublePair> lexComparator() {
        return x, y -> {
            int t = Long.compare(x.leftLong(), y.leftLong());
            return t != 0 ? t : Double.compare(x.rightDouble(), y.rightDouble());
        };
    }
}
