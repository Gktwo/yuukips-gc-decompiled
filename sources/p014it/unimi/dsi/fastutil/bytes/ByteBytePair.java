package p014it.unimi.dsi.fastutil.bytes;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.bytes.ByteBytePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteBytePair.class */
public interface ByteBytePair extends Pair<Byte, Byte> {
    byte leftByte();

    byte rightByte();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Byte left() {
        return Byte.valueOf(leftByte());
    }

    default ByteBytePair left(byte l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default ByteBytePair left(Byte l) {
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

    default ByteBytePair first(byte l) {
        return left(l);
    }

    @Deprecated
    default ByteBytePair first(Byte l) {
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

    default ByteBytePair key(byte l) {
        return left(l);
    }

    @Deprecated
    default ByteBytePair key(Byte l) {
        return key(l.byteValue());
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Byte right() {
        return Byte.valueOf(rightByte());
    }

    default ByteBytePair right(byte r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default ByteBytePair right(Byte l) {
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

    default ByteBytePair second(byte r) {
        return right(r);
    }

    @Deprecated
    default ByteBytePair second(Byte l) {
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

    default ByteBytePair value(byte r) {
        return right(r);
    }

    @Deprecated
    default ByteBytePair value(Byte l) {
        return value(l.byteValue());
    }

    /* renamed from: of */
    static ByteBytePair m1080of(byte left, byte right) {
        return new ByteByteImmutablePair(left, right);
    }

    static Comparator<ByteBytePair> lexComparator() {
        return x, y -> {
            int t = Byte.compare(x.leftByte(), y.leftByte());
            return t != 0 ? t : Byte.compare(x.rightByte(), y.rightByte());
        };
    }
}
