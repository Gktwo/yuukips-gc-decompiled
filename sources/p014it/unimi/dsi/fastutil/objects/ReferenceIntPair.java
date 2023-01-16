package p014it.unimi.dsi.fastutil.objects;

import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.objects.ReferenceIntPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ReferenceIntPair.class */
public interface ReferenceIntPair<K> extends Pair<K, Integer> {
    int rightInt();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Integer right() {
        return Integer.valueOf(rightInt());
    }

    default ReferenceIntPair<K> right(int r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default ReferenceIntPair<K> right(Integer l) {
        return right(l.intValue());
    }

    default int secondInt() {
        return rightInt();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Integer second() {
        return Integer.valueOf(secondInt());
    }

    default ReferenceIntPair<K> second(int r) {
        return right(r);
    }

    @Deprecated
    default ReferenceIntPair<K> second(Integer l) {
        return second(l.intValue());
    }

    default int valueInt() {
        return rightInt();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Integer value() {
        return Integer.valueOf(valueInt());
    }

    default ReferenceIntPair<K> value(int r) {
        return right(r);
    }

    @Deprecated
    default ReferenceIntPair<K> value(Integer l) {
        return value(l.intValue());
    }

    /* renamed from: of */
    static <K> ReferenceIntPair<K> m499of(K left, int right) {
        return new ReferenceIntImmutablePair(left, right);
    }
}
