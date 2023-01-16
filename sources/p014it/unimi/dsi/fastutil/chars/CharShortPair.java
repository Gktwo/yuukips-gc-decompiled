package p014it.unimi.dsi.fastutil.chars;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.chars.CharShortPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharShortPair.class */
public interface CharShortPair extends Pair<Character, Short> {
    char leftChar();

    short rightShort();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Character left() {
        return Character.valueOf(leftChar());
    }

    default CharShortPair left(char l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default CharShortPair left(Character l) {
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

    default CharShortPair first(char l) {
        return left(l);
    }

    @Deprecated
    default CharShortPair first(Character l) {
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

    default CharShortPair key(char l) {
        return left(l);
    }

    @Deprecated
    default CharShortPair key(Character l) {
        return key(l.charValue());
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Short right() {
        return Short.valueOf(rightShort());
    }

    default CharShortPair right(short r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default CharShortPair right(Short l) {
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

    default CharShortPair second(short r) {
        return right(r);
    }

    @Deprecated
    default CharShortPair second(Short l) {
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

    default CharShortPair value(short r) {
        return right(r);
    }

    @Deprecated
    default CharShortPair value(Short l) {
        return value(l.shortValue());
    }

    /* renamed from: of */
    static CharShortPair m945of(char left, short right) {
        return new CharShortImmutablePair(left, right);
    }

    static Comparator<CharShortPair> lexComparator() {
        return x, y -> {
            int t = Character.compare(x.leftChar(), y.leftChar());
            return t != 0 ? t : Short.compare(x.rightShort(), y.rightShort());
        };
    }
}
