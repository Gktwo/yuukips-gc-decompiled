package p014it.unimi.dsi.fastutil.doubles;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.doubles.DoubleBooleanPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleBooleanPair.class */
public interface DoubleBooleanPair extends Pair<Double, Boolean> {
    double leftDouble();

    boolean rightBoolean();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Double left() {
        return Double.valueOf(leftDouble());
    }

    default DoubleBooleanPair left(double l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default DoubleBooleanPair left(Double l) {
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

    default DoubleBooleanPair first(double l) {
        return left(l);
    }

    @Deprecated
    default DoubleBooleanPair first(Double l) {
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

    default DoubleBooleanPair key(double l) {
        return left(l);
    }

    @Deprecated
    default DoubleBooleanPair key(Double l) {
        return key(l.doubleValue());
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Boolean right() {
        return Boolean.valueOf(rightBoolean());
    }

    default DoubleBooleanPair right(boolean r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default DoubleBooleanPair right(Boolean l) {
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

    default DoubleBooleanPair second(boolean r) {
        return right(r);
    }

    @Deprecated
    default DoubleBooleanPair second(Boolean l) {
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

    default DoubleBooleanPair value(boolean r) {
        return right(r);
    }

    @Deprecated
    default DoubleBooleanPair value(Boolean l) {
        return value(l.booleanValue());
    }

    /* renamed from: of */
    static DoubleBooleanPair m914of(double left, boolean right) {
        return new DoubleBooleanImmutablePair(left, right);
    }

    static Comparator<DoubleBooleanPair> lexComparator() {
        return x, y -> {
            int t = Double.compare(x.leftDouble(), y.leftDouble());
            return t != 0 ? t : Boolean.compare(x.rightBoolean(), y.rightBoolean());
        };
    }
}
