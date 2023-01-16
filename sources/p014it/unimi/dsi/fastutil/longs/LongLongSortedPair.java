package p014it.unimi.dsi.fastutil.longs;

import java.io.Serializable;
import p014it.unimi.dsi.fastutil.SortedPair;

/* renamed from: it.unimi.dsi.fastutil.longs.LongLongSortedPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongLongSortedPair.class */
public interface LongLongSortedPair extends LongLongPair, SortedPair<Long>, Serializable {
    /* renamed from: of */
    static LongLongSortedPair m629of(long left, long right) {
        return LongLongImmutableSortedPair.m632of(left, right);
    }

    default boolean contains(long e) {
        return e == leftLong() || e == rightLong();
    }

    @Override // p014it.unimi.dsi.fastutil.SortedPair
    @Deprecated
    default boolean contains(Object o) {
        if (o == null) {
            return false;
        }
        return contains(((Long) o).longValue());
    }
}
