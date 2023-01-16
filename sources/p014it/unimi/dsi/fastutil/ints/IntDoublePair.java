package p014it.unimi.dsi.fastutil.ints;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.ints.IntDoublePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntDoublePair.class */
public interface IntDoublePair extends Pair<Integer, Double> {
    int leftInt();

    double rightDouble();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Integer left() {
        return Integer.valueOf(leftInt());
    }

    default IntDoublePair left(int l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default IntDoublePair left(Integer l) {
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

    default IntDoublePair first(int l) {
        return left(l);
    }

    @Deprecated
    default IntDoublePair first(Integer l) {
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

    default IntDoublePair key(int l) {
        return left(l);
    }

    @Deprecated
    default IntDoublePair key(Integer l) {
        return key(l.intValue());
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Double right() {
        return Double.valueOf(rightDouble());
    }

    default IntDoublePair right(double r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default IntDoublePair right(Double l) {
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

    default IntDoublePair second(double r) {
        return right(r);
    }

    @Deprecated
    default IntDoublePair second(Double l) {
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

    default IntDoublePair value(double r) {
        return right(r);
    }

    @Deprecated
    default IntDoublePair value(Double l) {
        return value(l.doubleValue());
    }

    /* renamed from: of */
    static IntDoublePair m737of(int left, double right) {
        return new IntDoubleImmutablePair(left, right);
    }

    static Comparator<IntDoublePair> lexComparator() {
        return x, y -> {
            int t = Integer.compare(x.leftInt(), y.leftInt());
            return t != 0 ? t : Double.compare(x.rightDouble(), y.rightDouble());
        };
    }
}
