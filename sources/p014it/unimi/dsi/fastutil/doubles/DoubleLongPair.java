package p014it.unimi.dsi.fastutil.doubles;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.doubles.DoubleLongPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleLongPair.class */
public interface DoubleLongPair extends Pair<Double, Long> {
    double leftDouble();

    long rightLong();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Double left() {
        return Double.valueOf(leftDouble());
    }

    default DoubleLongPair left(double l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default DoubleLongPair left(Double l) {
        return left(l.doubleValue());
    }

    default double firstDouble() {
        return leftDouble();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Double first() {
        return Double.valueOf(firstDouble());
    }

    default DoubleLongPair first(double l) {
        return left(l);
    }

    @Deprecated
    default DoubleLongPair first(Double l) {
        return first(l.doubleValue());
    }

    default double keyDouble() {
        return firstDouble();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Double key() {
        return Double.valueOf(keyDouble());
    }

    default DoubleLongPair key(double l) {
        return left(l);
    }

    @Deprecated
    default DoubleLongPair key(Double l) {
        return key(l.doubleValue());
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Long right() {
        return Long.valueOf(rightLong());
    }

    default DoubleLongPair right(long r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default DoubleLongPair right(Long l) {
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

    default DoubleLongPair second(long r) {
        return right(r);
    }

    @Deprecated
    default DoubleLongPair second(Long l) {
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

    default DoubleLongPair value(long r) {
        return right(r);
    }

    @Deprecated
    default DoubleLongPair value(Long l) {
        return value(l.longValue());
    }

    /* renamed from: of */
    static DoubleLongPair m882of(double left, long right) {
        return new DoubleLongImmutablePair(left, right);
    }

    static Comparator<DoubleLongPair> lexComparator() {
        return x, y -> {
            int t = Double.compare(x.leftDouble(), y.leftDouble());
            return t != 0 ? t : Long.compare(x.rightLong(), y.rightLong());
        };
    }
}
