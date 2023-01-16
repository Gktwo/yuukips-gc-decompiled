package p014it.unimi.dsi.fastutil.chars;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.chars.CharIntPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharIntPair.class */
public interface CharIntPair extends Pair<Character, Integer> {
    char leftChar();

    int rightInt();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Character left() {
        return Character.valueOf(leftChar());
    }

    default CharIntPair left(char l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default CharIntPair left(Character l) {
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

    default CharIntPair first(char l) {
        return left(l);
    }

    @Deprecated
    default CharIntPair first(Character l) {
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

    default CharIntPair key(char l) {
        return left(l);
    }

    @Deprecated
    default CharIntPair key(Character l) {
        return key(l.charValue());
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Integer right() {
        return Integer.valueOf(rightInt());
    }

    default CharIntPair right(int r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default CharIntPair right(Integer l) {
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

    default CharIntPair second(int r) {
        return right(r);
    }

    @Deprecated
    default CharIntPair second(Integer l) {
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

    default CharIntPair value(int r) {
        return right(r);
    }

    @Deprecated
    default CharIntPair value(Integer l) {
        return value(l.intValue());
    }

    /* renamed from: of */
    static CharIntPair m980of(char left, int right) {
        return new CharIntImmutablePair(left, right);
    }

    static Comparator<CharIntPair> lexComparator() {
        return x, y -> {
            int t = Character.compare(x.leftChar(), y.leftChar());
            return t != 0 ? t : Integer.compare(x.rightInt(), y.rightInt());
        };
    }
}
