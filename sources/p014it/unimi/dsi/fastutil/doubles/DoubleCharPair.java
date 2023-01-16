package p014it.unimi.dsi.fastutil.doubles;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.doubles.DoubleCharPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleCharPair.class */
public interface DoubleCharPair extends Pair<Double, Character> {
    double leftDouble();

    char rightChar();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Double left() {
        return Double.valueOf(leftDouble());
    }

    default DoubleCharPair left(double l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default DoubleCharPair left(Double l) {
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

    default DoubleCharPair first(double l) {
        return left(l);
    }

    @Deprecated
    default DoubleCharPair first(Double l) {
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

    default DoubleCharPair key(double l) {
        return left(l);
    }

    @Deprecated
    default DoubleCharPair key(Double l) {
        return key(l.doubleValue());
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Character right() {
        return Character.valueOf(rightChar());
    }

    default DoubleCharPair right(char r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default DoubleCharPair right(Character l) {
        return right(l.charValue());
    }

    default char secondChar() {
        return rightChar();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Character second() {
        return Character.valueOf(secondChar());
    }

    default DoubleCharPair second(char r) {
        return right(r);
    }

    @Deprecated
    default DoubleCharPair second(Character l) {
        return second(l.charValue());
    }

    default char valueChar() {
        return rightChar();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Character value() {
        return Character.valueOf(valueChar());
    }

    default DoubleCharPair value(char r) {
        return right(r);
    }

    @Deprecated
    default DoubleCharPair value(Character l) {
        return value(l.charValue());
    }

    /* renamed from: of */
    static DoubleCharPair m908of(double left, char right) {
        return new DoubleCharImmutablePair(left, right);
    }

    static Comparator<DoubleCharPair> lexComparator() {
        return x, y -> {
            int t = Double.compare(x.leftDouble(), y.leftDouble());
            return t != 0 ? t : Character.compare(x.rightChar(), y.rightChar());
        };
    }
}
