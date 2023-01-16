package p014it.unimi.dsi.fastutil.bytes;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.bytes.ByteIntPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteIntPair.class */
public interface ByteIntPair extends Pair<Byte, Integer> {
    byte leftByte();

    int rightInt();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Byte left() {
        return Byte.valueOf(leftByte());
    }

    default ByteIntPair left(byte l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default ByteIntPair left(Byte l) {
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

    default ByteIntPair first(byte l) {
        return left(l);
    }

    @Deprecated
    default ByteIntPair first(Byte l) {
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

    default ByteIntPair key(byte l) {
        return left(l);
    }

    @Deprecated
    default ByteIntPair key(Byte l) {
        return key(l.byteValue());
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Integer right() {
        return Integer.valueOf(rightInt());
    }

    default ByteIntPair right(int r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default ByteIntPair right(Integer l) {
        return right(l.intValue());
    }

    default int secondInt() {
        return rightInt();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Integer second() {
        return Integer.valueOf(secondInt());
    }

    default ByteIntPair second(int r) {
        return right(r);
    }

    @Deprecated
    default ByteIntPair second(Integer l) {
        return second(l.intValue());
    }

    default int valueInt() {
        return rightInt();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Integer value() {
        return Integer.valueOf(valueInt());
    }

    default ByteIntPair value(int r) {
        return right(r);
    }

    @Deprecated
    default ByteIntPair value(Integer l) {
        return value(l.intValue());
    }

    /* renamed from: of */
    static ByteIntPair m1065of(byte left, int right) {
        return new ByteIntImmutablePair(left, right);
    }

    static Comparator<ByteIntPair> lexComparator() {
        return x, y -> {
            int t = Byte.compare(x.leftByte(), y.leftByte());
            return t != 0 ? t : Integer.compare(x.rightInt(), y.rightInt());
        };
    }
}
