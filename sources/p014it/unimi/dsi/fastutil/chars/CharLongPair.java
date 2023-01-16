package p014it.unimi.dsi.fastutil.chars;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.chars.CharLongPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharLongPair.class */
public interface CharLongPair extends Pair<Character, Long> {
    char leftChar();

    long rightLong();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Character left() {
        return Character.valueOf(leftChar());
    }

    default CharLongPair left(char l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default CharLongPair left(Character l) {
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

    default CharLongPair first(char l) {
        return left(l);
    }

    @Deprecated
    default CharLongPair first(Character l) {
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

    default CharLongPair key(char l) {
        return left(l);
    }

    @Deprecated
    default CharLongPair key(Character l) {
        return key(l.charValue());
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Long right() {
        return Long.valueOf(rightLong());
    }

    default CharLongPair right(long r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default CharLongPair right(Long l) {
        return right(l.longValue());
    }

    default long secondLong() {
        return rightLong();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Long second() {
        return Long.valueOf(secondLong());
    }

    default CharLongPair second(long r) {
        return right(r);
    }

    @Deprecated
    default CharLongPair second(Long l) {
        return second(l.longValue());
    }

    default long valueLong() {
        return rightLong();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Long value() {
        return Long.valueOf(valueLong());
    }

    default CharLongPair value(long r) {
        return right(r);
    }

    @Deprecated
    default CharLongPair value(Long l) {
        return value(l.longValue());
    }

    /* renamed from: of */
    static CharLongPair m967of(char left, long right) {
        return new CharLongImmutablePair(left, right);
    }

    static Comparator<CharLongPair> lexComparator() {
        return x, y -> {
            int t = Character.compare(x.leftChar(), y.leftChar());
            return t != 0 ? t : Long.compare(x.rightLong(), y.rightLong());
        };
    }
}
