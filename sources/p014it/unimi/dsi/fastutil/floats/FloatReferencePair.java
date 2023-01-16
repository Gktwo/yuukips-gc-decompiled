package p014it.unimi.dsi.fastutil.floats;

import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.floats.FloatReferencePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatReferencePair.class */
public interface FloatReferencePair<V> extends Pair<Float, V> {
    float leftFloat();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Float left() {
        return Float.valueOf(leftFloat());
    }

    default FloatReferencePair<V> left(float l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default FloatReferencePair<V> left(Float l) {
        return left(l.floatValue());
    }

    default float firstFloat() {
        return leftFloat();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Float first() {
        return Float.valueOf(firstFloat());
    }

    default FloatReferencePair<V> first(float l) {
        return left(l);
    }

    @Deprecated
    default FloatReferencePair<V> first(Float l) {
        return first(l.floatValue());
    }

    default float keyFloat() {
        return firstFloat();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Float key() {
        return Float.valueOf(keyFloat());
    }

    default FloatReferencePair<V> key(float l) {
        return left(l);
    }

    @Deprecated
    default FloatReferencePair<V> key(Float l) {
        return key(l.floatValue());
    }

    /* renamed from: of */
    static <V> FloatReferencePair<V> m785of(float left, V right) {
        return new FloatReferenceImmutablePair(left, right);
    }
}
