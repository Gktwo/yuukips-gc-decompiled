package p014it.unimi.dsi.fastutil.ints;

import java.util.ListIterator;

/* renamed from: it.unimi.dsi.fastutil.ints.IntListIterator */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntListIterator.class */
public interface IntListIterator extends IntBidirectionalIterator, ListIterator<Integer> {
    default void set(int k) {
        throw new UnsupportedOperationException();
    }

    default void add(int k) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator, java.util.ListIterator
    default void remove() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default void set(Integer k) {
        set(k.intValue());
    }

    @Deprecated
    default void add(Integer k) {
        add(k.intValue());
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntIterator, java.util.PrimitiveIterator.OfInt, java.util.Iterator
    @Deprecated
    default Integer next() {
        return next();
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntBidirectionalIterator, p014it.unimi.dsi.fastutil.BidirectionalIterator
    @Deprecated
    default Integer previous() {
        return previous();
    }
}
