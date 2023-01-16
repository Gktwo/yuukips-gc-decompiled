package p014it.unimi.dsi.fastutil.chars;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.chars.CharCharPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharCharPair.class */
public interface CharCharPair extends Pair<Character, Character> {
    char leftChar();

    char rightChar();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Character left() {
        return Character.valueOf(leftChar());
    }

    default CharCharPair left(char l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default CharCharPair left(Character l) {
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

    default CharCharPair first(char l) {
        return left(l);
    }

    @Deprecated
    default CharCharPair first(Character l) {
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

    default CharCharPair key(char l) {
        return left(l);
    }

    @Deprecated
    default CharCharPair key(Character l) {
        return key(l.charValue());
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Character right() {
        return Character.valueOf(rightChar());
    }

    default CharCharPair right(char r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default CharCharPair right(Character l) {
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

    default CharCharPair second(char r) {
        return right(r);
    }

    @Deprecated
    default CharCharPair second(Character l) {
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

    default CharCharPair value(char r) {
        return right(r);
    }

    @Deprecated
    default CharCharPair value(Character l) {
        return value(l.charValue());
    }

    /* renamed from: of */
    static CharCharPair m992of(char left, char right) {
        return new CharCharImmutablePair(left, right);
    }

    static Comparator<CharCharPair> lexComparator() {
        return x, y -> {
            int t = Character.compare(x.leftChar(), y.leftChar());
            return t != 0 ? t : Character.compare(x.rightChar(), y.rightChar());
        };
    }
}
