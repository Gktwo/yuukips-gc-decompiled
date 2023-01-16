package p014it.unimi.dsi.fastutil.objects;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.objects.ObjectLongPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectLongPair.class */
public interface ObjectLongPair<K> extends Pair<K, Long> {
    long rightLong();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Long right() {
        return Long.valueOf(rightLong());
    }

    default ObjectLongPair<K> right(long r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default ObjectLongPair<K> right(Long l) {
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

    default ObjectLongPair<K> second(long r) {
        return right(r);
    }

    @Deprecated
    default ObjectLongPair<K> second(Long l) {
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

    default ObjectLongPair<K> value(long r) {
        return right(r);
    }

    @Deprecated
    default ObjectLongPair<K> value(Long l) {
        return value(l.longValue());
    }

    /* renamed from: of */
    static <K> ObjectLongPair<K> m546of(K left, long right) {
        return new ObjectLongImmutablePair(left, right);
    }

    static <K> Comparator<ObjectLongPair<K>> lexComparator() {
        return x, y -> {
            int t = ((Comparable) x.left()).compareTo(y.left());
            return t != 0 ? t : Long.compare(x.rightLong(), y.rightLong());
        };
    }
}
