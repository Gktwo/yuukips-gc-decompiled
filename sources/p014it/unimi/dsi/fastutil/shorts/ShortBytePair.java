package p014it.unimi.dsi.fastutil.shorts;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.shorts.ShortBytePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortBytePair.class */
public interface ShortBytePair extends Pair<Short, Byte> {
    short leftShort();

    byte rightByte();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Short left() {
        return Short.valueOf(leftShort());
    }

    default ShortBytePair left(short l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default ShortBytePair left(Short l) {
        return left(l.shortValue());
    }

    default short firstShort() {
        return leftShort();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Short first() {
        return Short.valueOf(firstShort());
    }

    default ShortBytePair first(short l) {
        return left(l);
    }

    @Deprecated
    default ShortBytePair first(Short l) {
        return first(l.shortValue());
    }

    default short keyShort() {
        return firstShort();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Short key() {
        return Short.valueOf(keyShort());
    }

    default ShortBytePair key(short l) {
        return left(l);
    }

    @Deprecated
    default ShortBytePair key(Short l) {
        return key(l.shortValue());
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Byte right() {
        return Byte.valueOf(rightByte());
    }

    default ShortBytePair right(byte r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default ShortBytePair right(Byte l) {
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

    default ShortBytePair second(byte r) {
        return right(r);
    }

    @Deprecated
    default ShortBytePair second(Byte l) {
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

    default ShortBytePair value(byte r) {
        return right(r);
    }

    @Deprecated
    default ShortBytePair value(Byte l) {
        return value(l.byteValue());
    }

    /* renamed from: of */
    static ShortBytePair m433of(short left, byte right) {
        return new ShortByteImmutablePair(left, right);
    }

    static Comparator<ShortBytePair> lexComparator() {
        return x, y -> {
            int t = Short.compare(x.leftShort(), y.leftShort());
            return t != 0 ? t : Byte.compare(x.rightByte(), y.rightByte());
        };
    }
}
