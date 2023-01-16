package p014it.unimi.dsi.fastutil.bytes;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.bytes.ByteDoublePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteDoublePair.class */
public interface ByteDoublePair extends Pair<Byte, Double> {
    byte leftByte();

    double rightDouble();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Byte left() {
        return Byte.valueOf(leftByte());
    }

    default ByteDoublePair left(byte l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default ByteDoublePair left(Byte l) {
        return left(l.byteValue());
    }

    default byte firstByte() {
        return leftByte();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Byte first() {
        return Byte.valueOf(firstByte());
    }

    default ByteDoublePair first(byte l) {
        return left(l);
    }

    @Deprecated
    default ByteDoublePair first(Byte l) {
        return first(l.byteValue());
    }

    default byte keyByte() {
        return firstByte();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Byte key() {
        return Byte.valueOf(keyByte());
    }

    default ByteDoublePair key(byte l) {
        return left(l);
    }

    @Deprecated
    default ByteDoublePair key(Byte l) {
        return key(l.byteValue());
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Double right() {
        return Double.valueOf(rightDouble());
    }

    default ByteDoublePair right(double r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default ByteDoublePair right(Double l) {
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

    default ByteDoublePair second(double r) {
        return right(r);
    }

    @Deprecated
    default ByteDoublePair second(Double l) {
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

    default ByteDoublePair value(double r) {
        return right(r);
    }

    @Deprecated
    default ByteDoublePair value(Double l) {
        return value(l.doubleValue());
    }

    /* renamed from: of */
    static ByteDoublePair m1073of(byte left, double right) {
        return new ByteDoubleImmutablePair(left, right);
    }

    static Comparator<ByteDoublePair> lexComparator() {
        return x, y -> {
            int t = Byte.compare(x.leftByte(), y.leftByte());
            return t != 0 ? t : Double.compare(x.rightDouble(), y.rightDouble());
        };
    }
}
