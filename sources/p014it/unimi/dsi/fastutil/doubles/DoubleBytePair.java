package p014it.unimi.dsi.fastutil.doubles;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.doubles.DoubleBytePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleBytePair.class */
public interface DoubleBytePair extends Pair<Double, Byte> {
    double leftDouble();

    byte rightByte();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Double left() {
        return Double.valueOf(leftDouble());
    }

    default DoubleBytePair left(double l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default DoubleBytePair left(Double l) {
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

    default DoubleBytePair first(double l) {
        return left(l);
    }

    @Deprecated
    default DoubleBytePair first(Double l) {
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

    default DoubleBytePair key(double l) {
        return left(l);
    }

    @Deprecated
    default DoubleBytePair key(Double l) {
        return key(l.doubleValue());
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Byte right() {
        return Byte.valueOf(rightByte());
    }

    default DoubleBytePair right(byte r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default DoubleBytePair right(Byte l) {
        return right(l.byteValue());
    }

    default byte secondByte() {
        return rightByte();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Byte second() {
        return Byte.valueOf(secondByte());
    }

    default DoubleBytePair second(byte r) {
        return right(r);
    }

    @Deprecated
    default DoubleBytePair second(Byte l) {
        return second(l.byteValue());
    }

    default byte valueByte() {
        return rightByte();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Byte value() {
        return Byte.valueOf(valueByte());
    }

    default DoubleBytePair value(byte r) {
        return right(r);
    }

    @Deprecated
    default DoubleBytePair value(Byte l) {
        return value(l.byteValue());
    }

    /* renamed from: of */
    static DoubleBytePair m911of(double left, byte right) {
        return new DoubleByteImmutablePair(left, right);
    }

    static Comparator<DoubleBytePair> lexComparator() {
        return x, y -> {
            int t = Double.compare(x.leftDouble(), y.leftDouble());
            return t != 0 ? t : Byte.compare(x.rightByte(), y.rightByte());
        };
    }
}
