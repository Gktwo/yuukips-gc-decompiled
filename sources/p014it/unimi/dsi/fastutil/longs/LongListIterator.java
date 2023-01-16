package p014it.unimi.dsi.fastutil.longs;

import java.util.ListIterator;

/* renamed from: it.unimi.dsi.fastutil.longs.LongListIterator */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongListIterator.class */
public interface LongListIterator extends LongBidirectionalIterator, ListIterator<Long> {
    default void set(long k) {
        throw new UnsupportedOperationException();
    }

    default void add(long k) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator, java.util.ListIterator
    default void remove() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default void set(Long k) {
        set(k.longValue());
    }

    @Deprecated
    default void add(Long k) {
        add(k.longValue());
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, java.util.PrimitiveIterator.OfLong, java.util.Iterator
    @Deprecated
    default Long next() {
        return next();
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongBidirectionalIterator, p014it.unimi.dsi.fastutil.BidirectionalIterator
    @Deprecated
    default Long previous() {
        return previous();
    }
}
