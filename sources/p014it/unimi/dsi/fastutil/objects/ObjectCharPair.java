package p014it.unimi.dsi.fastutil.objects;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.objects.ObjectCharPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectCharPair.class */
public interface ObjectCharPair<K> extends Pair<K, Character> {
    char rightChar();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Character right() {
        return Character.valueOf(rightChar());
    }

    default ObjectCharPair<K> right(char r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default ObjectCharPair<K> right(Character l) {
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

    default ObjectCharPair<K> second(char r) {
        return right(r);
    }

    @Deprecated
    default ObjectCharPair<K> second(Character l) {
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

    default ObjectCharPair<K> value(char r) {
        return right(r);
    }

    @Deprecated
    default ObjectCharPair<K> value(Character l) {
        return value(l.charValue());
    }

    /* renamed from: of */
    static <K> ObjectCharPair<K> m570of(K left, char right) {
        return new ObjectCharImmutablePair(left, right);
    }

    static <K> Comparator<ObjectCharPair<K>> lexComparator() {
        return x, y -> {
            int t = ((Comparable) x.left()).compareTo(y.left());
            return t != 0 ? t : Character.compare(x.rightChar(), y.rightChar());
        };
    }
}
