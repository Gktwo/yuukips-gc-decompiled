package p014it.unimi.dsi.fastutil.objects;

import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.objects.ReferenceFloatPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ReferenceFloatPair.class */
public interface ReferenceFloatPair<K> extends Pair<K, Float> {
    float rightFloat();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Float right() {
        return Float.valueOf(rightFloat());
    }

    default ReferenceFloatPair<K> right(float r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default ReferenceFloatPair<K> right(Float l) {
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

    default ReferenceFloatPair<K> second(float r) {
        return right(r);
    }

    @Deprecated
    default ReferenceFloatPair<K> second(Float l) {
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

    default ReferenceFloatPair<K> value(float r) {
        return right(r);
    }

    @Deprecated
    default ReferenceFloatPair<K> value(Float l) {
        return value(l.floatValue());
    }

    /* renamed from: of */
    static <K> ReferenceFloatPair<K> m504of(K left, float right) {
        return new ReferenceFloatImmutablePair(left, right);
    }
}
