package p014it.unimi.dsi.fastutil.shorts;

import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.shorts.ShortReferencePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortReferencePair.class */
public interface ShortReferencePair<V> extends Pair<Short, V> {
    short leftShort();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Short left() {
        return Short.valueOf(leftShort());
    }

    default ShortReferencePair<V> left(short l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default ShortReferencePair<V> left(Short l) {
        return left(l.shortValue());
    }

    default short firstShort() {
        return leftShort();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Short first() {
        return Short.valueOf(firstShort());
    }

    default ShortReferencePair<V> first(short l) {
        return left(l);
    }

    @Deprecated
    default ShortReferencePair<V> first(Short l) {
        return first(l.shortValue());
    }

    default short keyShort() {
        return firstShort();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Short key() {
        return Short.valueOf(keyShort());
    }

    default ShortReferencePair<V> key(short l) {
        return left(l);
    }

    @Deprecated
    default ShortReferencePair<V> key(Short l) {
        return key(l.shortValue());
    }

    /* renamed from: of */
    static <V> ShortReferencePair<V> m393of(short left, V right) {
        return new ShortReferenceImmutablePair(left, right);
    }
}
