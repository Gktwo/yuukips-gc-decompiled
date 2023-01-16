package p014it.unimi.dsi.fastutil.longs;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.longs.LongObjectPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongObjectPair.class */
public interface LongObjectPair<V> extends Pair<Long, V> {
    long leftLong();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Long left() {
        return Long.valueOf(leftLong());
    }

    default LongObjectPair<V> left(long l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default LongObjectPair<V> left(Long l) {
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

    default LongObjectPair<V> first(long l) {
        return left(l);
    }

    @Deprecated
    default LongObjectPair<V> first(Long l) {
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

    default LongObjectPair<V> key(long l) {
        return left(l);
    }

    @Deprecated
    default LongObjectPair<V> key(Long l) {
        return key(l.longValue());
    }

    /* renamed from: of */
    static <V> LongObjectPair<V> m626of(long left, V right) {
        return new LongObjectImmutablePair(left, right);
    }

    static <V> Comparator<LongObjectPair<V>> lexComparator() {
        return x, y -> {
            int t = Long.compare(x.leftLong(), y.leftLong());
            return t != 0 ? t : ((Comparable) x.right()).compareTo(y.right());
        };
    }
}
