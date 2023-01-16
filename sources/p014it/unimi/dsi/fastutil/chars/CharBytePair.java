package p014it.unimi.dsi.fastutil.chars;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.chars.CharBytePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharBytePair.class */
public interface CharBytePair extends Pair<Character, Byte> {
    char leftChar();

    byte rightByte();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Character left() {
        return Character.valueOf(leftChar());
    }

    default CharBytePair left(char l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default CharBytePair left(Character l) {
        return left(l.charValue());
    }

    default char firstChar() {
        return leftChar();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Character first() {
        return Character.valueOf(firstChar());
    }

    default CharBytePair first(char l) {
        return left(l);
    }

    @Deprecated
    default CharBytePair first(Character l) {
        return first(l.charValue());
    }

    default char keyChar() {
        return firstChar();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Character key() {
        return Character.valueOf(keyChar());
    }

    default CharBytePair key(char l) {
        return left(l);
    }

    @Deprecated
    default CharBytePair key(Character l) {
        return key(l.charValue());
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Byte right() {
        return Byte.valueOf(rightByte());
    }

    default CharBytePair right(byte r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default CharBytePair right(Byte l) {
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

    default CharBytePair second(byte r) {
        return right(r);
    }

    @Deprecated
    default CharBytePair second(Byte l) {
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

    default CharBytePair value(byte r) {
        return right(r);
    }

    @Deprecated
    default CharBytePair value(Byte l) {
        return value(l.byteValue());
    }

    /* renamed from: of */
    static CharBytePair m996of(char left, byte right) {
        return new CharByteImmutablePair(left, right);
    }

    static Comparator<CharBytePair> lexComparator() {
        return x, y -> {
            int t = Character.compare(x.leftChar(), y.leftChar());
            return t != 0 ? t : Byte.compare(x.rightByte(), y.rightByte());
        };
    }
}
