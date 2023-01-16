package p014it.unimi.dsi.fastutil.bytes;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.bytes.ByteCharPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteCharPair.class */
public interface ByteCharPair extends Pair<Byte, Character> {
    byte leftByte();

    char rightChar();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Byte left() {
        return Byte.valueOf(leftByte());
    }

    default ByteCharPair left(byte l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default ByteCharPair left(Byte l) {
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

    default ByteCharPair first(byte l) {
        return left(l);
    }

    @Deprecated
    default ByteCharPair first(Byte l) {
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

    default ByteCharPair key(byte l) {
        return left(l);
    }

    @Deprecated
    default ByteCharPair key(Byte l) {
        return key(l.byteValue());
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Character right() {
        return Character.valueOf(rightChar());
    }

    default ByteCharPair right(char r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default ByteCharPair right(Character l) {
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

    default ByteCharPair second(char r) {
        return right(r);
    }

    @Deprecated
    default ByteCharPair second(Character l) {
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

    default ByteCharPair value(char r) {
        return right(r);
    }

    @Deprecated
    default ByteCharPair value(Character l) {
        return value(l.charValue());
    }

    /* renamed from: of */
    static ByteCharPair m1076of(byte left, char right) {
        return new ByteCharImmutablePair(left, right);
    }

    static Comparator<ByteCharPair> lexComparator() {
        return x, y -> {
            int t = Byte.compare(x.leftByte(), y.leftByte());
            return t != 0 ? t : Character.compare(x.rightChar(), y.rightChar());
        };
    }
}
