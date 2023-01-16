package p014it.unimi.dsi.fastutil.booleans;

import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.booleans.BooleanReferencePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanReferencePair.class */
public interface BooleanReferencePair<V> extends Pair<Boolean, V> {
    boolean leftBoolean();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Boolean left() {
        return Boolean.valueOf(leftBoolean());
    }

    default BooleanReferencePair<V> left(boolean l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default BooleanReferencePair<V> left(Boolean l) {
        return left(l.booleanValue());
    }

    default boolean firstBoolean() {
        return leftBoolean();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Boolean first() {
        return Boolean.valueOf(firstBoolean());
    }

    default BooleanReferencePair<V> first(boolean l) {
        return left(l);
    }

    @Deprecated
    default BooleanReferencePair<V> first(Boolean l) {
        return first(l.booleanValue());
    }

    default boolean keyBoolean() {
        return firstBoolean();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Boolean key() {
        return Boolean.valueOf(keyBoolean());
    }

    default BooleanReferencePair<V> key(boolean l) {
        return left(l);
    }

    @Deprecated
    default BooleanReferencePair<V> key(Boolean l) {
        return key(l.booleanValue());
    }

    /* renamed from: of */
    static <V> BooleanReferencePair<V> m1123of(boolean left, V right) {
        return new BooleanReferenceImmutablePair(left, right);
    }
}
