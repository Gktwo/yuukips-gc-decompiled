package p014it.unimi.dsi.fastutil.booleans;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.booleans.BooleanDoublePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanDoublePair.class */
public interface BooleanDoublePair extends Pair<Boolean, Double> {
    boolean leftBoolean();

    double rightDouble();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Boolean left() {
        return Boolean.valueOf(leftBoolean());
    }

    default BooleanDoublePair left(boolean l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default BooleanDoublePair left(Boolean l) {
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

    default BooleanDoublePair first(boolean l) {
        return left(l);
    }

    @Deprecated
    default BooleanDoublePair first(Boolean l) {
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

    default BooleanDoublePair key(boolean l) {
        return left(l);
    }

    @Deprecated
    default BooleanDoublePair key(Boolean l) {
        return key(l.booleanValue());
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Double right() {
        return Double.valueOf(rightDouble());
    }

    default BooleanDoublePair right(double r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default BooleanDoublePair right(Double l) {
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

    default BooleanDoublePair second(double r) {
        return right(r);
    }

    @Deprecated
    default BooleanDoublePair second(Double l) {
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

    default BooleanDoublePair value(double r) {
        return right(r);
    }

    @Deprecated
    default BooleanDoublePair value(Double l) {
        return value(l.doubleValue());
    }

    /* renamed from: of */
    static BooleanDoublePair m1151of(boolean left, double right) {
        return new BooleanDoubleImmutablePair(left, right);
    }

    static Comparator<BooleanDoublePair> lexComparator() {
        return x, y -> {
            int t = Boolean.compare(x.leftBoolean(), y.leftBoolean());
            return t != 0 ? t : Double.compare(x.rightDouble(), y.rightDouble());
        };
    }
}
