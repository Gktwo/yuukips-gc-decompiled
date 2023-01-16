package p014it.unimi.dsi.fastutil.objects;

import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.objects.ReferenceLongPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ReferenceLongPair.class */
public interface ReferenceLongPair<K> extends Pair<K, Long> {
    long rightLong();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Long right() {
        return Long.valueOf(rightLong());
    }

    default ReferenceLongPair<K> right(long r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default ReferenceLongPair<K> right(Long l) {
        return right(l.longValue());
    }

    default long secondLong() {
        return rightLong();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Long second() {
        return Long.valueOf(secondLong());
    }

    default ReferenceLongPair<K> second(long r) {
        return right(r);
    }

    @Deprecated
    default ReferenceLongPair<K> second(Long l) {
        return second(l.longValue());
    }

    default long valueLong() {
        return rightLong();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Long value() {
        return Long.valueOf(valueLong());
    }

    default ReferenceLongPair<K> value(long r) {
        return right(r);
    }

    @Deprecated
    default ReferenceLongPair<K> value(Long l) {
        return value(l.longValue());
    }

    /* renamed from: of */
    static <K> ReferenceLongPair<K> m486of(K left, long right) {
        return new ReferenceLongImmutablePair(left, right);
    }
}
