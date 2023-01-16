package p014it.unimi.dsi.fastutil.chars;

import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.chars.CharReferencePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharReferencePair.class */
public interface CharReferencePair<V> extends Pair<Character, V> {
    char leftChar();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Character left() {
        return Character.valueOf(leftChar());
    }

    default CharReferencePair<V> left(char l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default CharReferencePair<V> left(Character l) {
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

    default CharReferencePair<V> first(char l) {
        return left(l);
    }

    @Deprecated
    default CharReferencePair<V> first(Character l) {
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

    default CharReferencePair<V> key(char l) {
        return left(l);
    }

    @Deprecated
    default CharReferencePair<V> key(Character l) {
        return key(l.charValue());
    }

    /* renamed from: of */
    static <V> CharReferencePair<V> m954of(char left, V right) {
        return new CharReferenceImmutablePair(left, right);
    }
}
