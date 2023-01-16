package p014it.unimi.dsi.fastutil.chars;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.chars.CharBooleanPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharBooleanPair.class */
public interface CharBooleanPair extends Pair<Character, Boolean> {
    char leftChar();

    boolean rightBoolean();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Character left() {
        return Character.valueOf(leftChar());
    }

    default CharBooleanPair left(char l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default CharBooleanPair left(Character l) {
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

    default CharBooleanPair first(char l) {
        return left(l);
    }

    @Deprecated
    default CharBooleanPair first(Character l) {
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

    default CharBooleanPair key(char l) {
        return left(l);
    }

    @Deprecated
    default CharBooleanPair key(Character l) {
        return key(l.charValue());
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Boolean right() {
        return Boolean.valueOf(rightBoolean());
    }

    default CharBooleanPair right(boolean r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default CharBooleanPair right(Boolean l) {
        return right(l.booleanValue());
    }

    default boolean secondBoolean() {
        return rightBoolean();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Boolean second() {
        return Boolean.valueOf(secondBoolean());
    }

    default CharBooleanPair second(boolean r) {
        return right(r);
    }

    @Deprecated
    default CharBooleanPair second(Boolean l) {
        return second(l.booleanValue());
    }

    default boolean valueBoolean() {
        return rightBoolean();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Boolean value() {
        return Boolean.valueOf(valueBoolean());
    }

    default CharBooleanPair value(boolean r) {
        return right(r);
    }

    @Deprecated
    default CharBooleanPair value(Boolean l) {
        return value(l.booleanValue());
    }

    /* renamed from: of */
    static CharBooleanPair m999of(char left, boolean right) {
        return new CharBooleanImmutablePair(left, right);
    }

    static Comparator<CharBooleanPair> lexComparator() {
        return x, y -> {
            int t = Character.compare(x.leftChar(), y.leftChar());
            return t != 0 ? t : Boolean.compare(x.rightBoolean(), y.rightBoolean());
        };
    }
}
