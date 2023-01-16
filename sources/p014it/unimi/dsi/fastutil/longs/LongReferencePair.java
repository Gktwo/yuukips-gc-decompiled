package p014it.unimi.dsi.fastutil.longs;

import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.longs.LongReferencePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongReferencePair.class */
public interface LongReferencePair<V> extends Pair<Long, V> {
    long leftLong();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Long left() {
        return Long.valueOf(leftLong());
    }

    default LongReferencePair<V> left(long l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default LongReferencePair<V> left(Long l) {
        return left(l.longValue());
    }

    default long firstLong() {
        return leftLong();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Long first() {
        return Long.valueOf(firstLong());
    }

    default LongReferencePair<V> first(long l) {
        return left(l);
    }

    @Deprecated
    default LongReferencePair<V> first(Long l) {
        return first(l.longValue());
    }

    default long keyLong() {
        return firstLong();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Long key() {
        return Long.valueOf(keyLong());
    }

    default LongReferencePair<V> key(long l) {
        return left(l);
    }

    @Deprecated
    default LongReferencePair<V> key(Long l) {
        return key(l.longValue());
    }

    /* renamed from: of */
    static <V> LongReferencePair<V> m616of(long left, V right) {
        return new LongReferenceImmutablePair(left, right);
    }
}
