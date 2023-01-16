package p014it.unimi.dsi.fastutil.objects;

import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.objects.ReferenceCharPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ReferenceCharPair.class */
public interface ReferenceCharPair<K> extends Pair<K, Character> {
    char rightChar();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Character right() {
        return Character.valueOf(rightChar());
    }

    default ReferenceCharPair<K> right(char r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default ReferenceCharPair<K> right(Character l) {
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

    default ReferenceCharPair<K> second(char r) {
        return right(r);
    }

    @Deprecated
    default ReferenceCharPair<K> second(Character l) {
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

    default ReferenceCharPair<K> value(char r) {
        return right(r);
    }

    @Deprecated
    default ReferenceCharPair<K> value(Character l) {
        return value(l.charValue());
    }

    /* renamed from: of */
    static <K> ReferenceCharPair<K> m510of(K left, char right) {
        return new ReferenceCharImmutablePair(left, right);
    }
}
