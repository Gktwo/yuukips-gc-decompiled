package p014it.unimi.dsi.fastutil.chars;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.chars.CharObjectPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharObjectPair.class */
public interface CharObjectPair<V> extends Pair<Character, V> {
    char leftChar();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Character left() {
        return Character.valueOf(leftChar());
    }

    default CharObjectPair<V> left(char l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default CharObjectPair<V> left(Character l) {
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

    default CharObjectPair<V> first(char l) {
        return left(l);
    }

    @Deprecated
    default CharObjectPair<V> first(Character l) {
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

    default CharObjectPair<V> key(char l) {
        return left(l);
    }

    @Deprecated
    default CharObjectPair<V> key(Character l) {
        return key(l.charValue());
    }

    /* renamed from: of */
    static <V> CharObjectPair<V> m964of(char left, V right) {
        return new CharObjectImmutablePair(left, right);
    }

    static <V> Comparator<CharObjectPair<V>> lexComparator() {
        return x, y -> {
            int t = Character.compare(x.leftChar(), y.leftChar());
            return t != 0 ? t : ((Comparable) x.right()).compareTo(y.right());
        };
    }
}
