package p014it.unimi.dsi.fastutil.ints;

import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.ints.IntReferencePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntReferencePair.class */
public interface IntReferencePair<V> extends Pair<Integer, V> {
    int leftInt();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Integer left() {
        return Integer.valueOf(leftInt());
    }

    default IntReferencePair<V> left(int l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default IntReferencePair<V> left(Integer l) {
        return left(l.intValue());
    }

    default int firstInt() {
        return leftInt();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Integer first() {
        return Integer.valueOf(firstInt());
    }

    default IntReferencePair<V> first(int l) {
        return left(l);
    }

    @Deprecated
    default IntReferencePair<V> first(Integer l) {
        return first(l.intValue());
    }

    default int keyInt() {
        return firstInt();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Integer key() {
        return Integer.valueOf(keyInt());
    }

    default IntReferencePair<V> key(int l) {
        return left(l);
    }

    @Deprecated
    default IntReferencePair<V> key(Integer l) {
        return key(l.intValue());
    }

    /* renamed from: of */
    static <V> IntReferencePair<V> m701of(int left, V right) {
        return new IntReferenceImmutablePair(left, right);
    }
}
