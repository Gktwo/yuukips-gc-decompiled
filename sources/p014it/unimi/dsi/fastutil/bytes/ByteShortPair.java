package p014it.unimi.dsi.fastutil.bytes;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.bytes.ByteShortPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteShortPair.class */
public interface ByteShortPair extends Pair<Byte, Short> {
    byte leftByte();

    short rightShort();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Byte left() {
        return Byte.valueOf(leftByte());
    }

    default ByteShortPair left(byte l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default ByteShortPair left(Byte l) {
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

    default ByteShortPair first(byte l) {
        return left(l);
    }

    @Deprecated
    default ByteShortPair first(Byte l) {
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

    default ByteShortPair key(byte l) {
        return left(l);
    }

    @Deprecated
    default ByteShortPair key(Byte l) {
        return key(l.byteValue());
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Short right() {
        return Short.valueOf(rightShort());
    }

    default ByteShortPair right(short r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default ByteShortPair right(Short l) {
        return right(l.shortValue());
    }

    default short secondShort() {
        return rightShort();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Short second() {
        return Short.valueOf(secondShort());
    }

    default ByteShortPair second(short r) {
        return right(r);
    }

    @Deprecated
    default ByteShortPair second(Short l) {
        return second(l.shortValue());
    }

    default short valueShort() {
        return rightShort();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Short value() {
        return Short.valueOf(valueShort());
    }

    default ByteShortPair value(short r) {
        return right(r);
    }

    @Deprecated
    default ByteShortPair value(Short l) {
        return value(l.shortValue());
    }

    /* renamed from: of */
    static ByteShortPair m1030of(byte left, short right) {
        return new ByteShortImmutablePair(left, right);
    }

    static Comparator<ByteShortPair> lexComparator() {
        return x, y -> {
            int t = Byte.compare(x.leftByte(), y.leftByte());
            return t != 0 ? t : Short.compare(x.rightShort(), y.rightShort());
        };
    }
}
