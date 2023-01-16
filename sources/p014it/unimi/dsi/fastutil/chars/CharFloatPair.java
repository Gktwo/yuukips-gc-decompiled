package p014it.unimi.dsi.fastutil.chars;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.chars.CharFloatPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharFloatPair.class */
public interface CharFloatPair extends Pair<Character, Float> {
    char leftChar();

    float rightFloat();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Character left() {
        return Character.valueOf(leftChar());
    }

    default CharFloatPair left(char l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default CharFloatPair left(Character l) {
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

    default CharFloatPair first(char l) {
        return left(l);
    }

    @Deprecated
    default CharFloatPair first(Character l) {
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

    default CharFloatPair key(char l) {
        return left(l);
    }

    @Deprecated
    default CharFloatPair key(Character l) {
        return key(l.charValue());
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Float right() {
        return Float.valueOf(rightFloat());
    }

    default CharFloatPair right(float r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default CharFloatPair right(Float l) {
        return right(l.floatValue());
    }

    default float secondFloat() {
        return rightFloat();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Float second() {
        return Float.valueOf(secondFloat());
    }

    default CharFloatPair second(float r) {
        return right(r);
    }

    @Deprecated
    default CharFloatPair second(Float l) {
        return second(l.floatValue());
    }

    default float valueFloat() {
        return rightFloat();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Float value() {
        return Float.valueOf(valueFloat());
    }

    default CharFloatPair value(float r) {
        return right(r);
    }

    @Deprecated
    default CharFloatPair value(Float l) {
        return value(l.floatValue());
    }

    /* renamed from: of */
    static CharFloatPair m985of(char left, float right) {
        return new CharFloatImmutablePair(left, right);
    }

    static Comparator<CharFloatPair> lexComparator() {
        return x, y -> {
            int t = Character.compare(x.leftChar(), y.leftChar());
            return t != 0 ? t : Float.compare(x.rightFloat(), y.rightFloat());
        };
    }
}
