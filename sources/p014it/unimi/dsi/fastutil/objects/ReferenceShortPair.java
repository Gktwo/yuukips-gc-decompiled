package p014it.unimi.dsi.fastutil.objects;

import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.objects.ReferenceShortPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ReferenceShortPair.class */
public interface ReferenceShortPair<K> extends Pair<K, Short> {
    short rightShort();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Short right() {
        return Short.valueOf(rightShort());
    }

    default ReferenceShortPair<K> right(short r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default ReferenceShortPair<K> right(Short l) {
        return right(l.shortValue());
    }

    default short secondShort() {
        return rightShort();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Short second() {
        return Short.valueOf(secondShort());
    }

    default ReferenceShortPair<K> second(short r) {
        return right(r);
    }

    @Deprecated
    default ReferenceShortPair<K> second(Short l) {
        return second(l.shortValue());
    }

    default short valueShort() {
        return rightShort();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Short value() {
        return Short.valueOf(valueShort());
    }

    default ReferenceShortPair<K> value(short r) {
        return right(r);
    }

    @Deprecated
    default ReferenceShortPair<K> value(Short l) {
        return value(l.shortValue());
    }

    /* renamed from: of */
    static <K> ReferenceShortPair<K> m467of(K left, short right) {
        return new ReferenceShortImmutablePair(left, right);
    }
}
