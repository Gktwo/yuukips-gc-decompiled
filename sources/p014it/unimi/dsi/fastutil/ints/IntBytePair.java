package p014it.unimi.dsi.fastutil.ints;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.ints.IntBytePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntBytePair.class */
public interface IntBytePair extends Pair<Integer, Byte> {
    int leftInt();

    byte rightByte();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Integer left() {
        return Integer.valueOf(leftInt());
    }

    default IntBytePair left(int l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default IntBytePair left(Integer l) {
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

    default IntBytePair first(int l) {
        return left(l);
    }

    @Deprecated
    default IntBytePair first(Integer l) {
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

    default IntBytePair key(int l) {
        return left(l);
    }

    @Deprecated
    default IntBytePair key(Integer l) {
        return key(l.intValue());
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Byte right() {
        return Byte.valueOf(rightByte());
    }

    default IntBytePair right(byte r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default IntBytePair right(Byte l) {
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

    default IntBytePair second(byte r) {
        return right(r);
    }

    @Deprecated
    default IntBytePair second(Byte l) {
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

    default IntBytePair value(byte r) {
        return right(r);
    }

    @Deprecated
    default IntBytePair value(Byte l) {
        return value(l.byteValue());
    }

    /* renamed from: of */
    static IntBytePair m743of(int left, byte right) {
        return new IntByteImmutablePair(left, right);
    }

    static Comparator<IntBytePair> lexComparator() {
        return x, y -> {
            int t = Integer.compare(x.leftInt(), y.leftInt());
            return t != 0 ? t : Byte.compare(x.rightByte(), y.rightByte());
        };
    }
}
