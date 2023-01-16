package p014it.unimi.dsi.fastutil.objects;

import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.objects.ReferenceBooleanPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ReferenceBooleanPair.class */
public interface ReferenceBooleanPair<K> extends Pair<K, Boolean> {
    boolean rightBoolean();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Boolean right() {
        return Boolean.valueOf(rightBoolean());
    }

    default ReferenceBooleanPair<K> right(boolean r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default ReferenceBooleanPair<K> right(Boolean l) {
        return right(l.booleanValue());
    }

    default boolean secondBoolean() {
        return rightBoolean();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Boolean second() {
        return Boolean.valueOf(secondBoolean());
    }

    default ReferenceBooleanPair<K> second(boolean r) {
        return right(r);
    }

    @Deprecated
    default ReferenceBooleanPair<K> second(Boolean l) {
        return second(l.booleanValue());
    }

    default boolean valueBoolean() {
        return rightBoolean();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Boolean value() {
        return Boolean.valueOf(valueBoolean());
    }

    default ReferenceBooleanPair<K> value(boolean r) {
        return right(r);
    }

    @Deprecated
    default ReferenceBooleanPair<K> value(Boolean l) {
        return value(l.booleanValue());
    }

    /* renamed from: of */
    static <K> ReferenceBooleanPair<K> m516of(K left, boolean right) {
        return new ReferenceBooleanImmutablePair(left, right);
    }
}
