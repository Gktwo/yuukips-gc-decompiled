package p014it.unimi.dsi.fastutil.shorts;

import java.util.ListIterator;

/* renamed from: it.unimi.dsi.fastutil.shorts.ShortListIterator */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortListIterator.class */
public interface ShortListIterator extends ShortBidirectionalIterator, ListIterator<Short> {
    default void set(short k) {
        throw new UnsupportedOperationException();
    }

    default void add(short k) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator, java.util.ListIterator
    default void remove() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default void set(Short k) {
        set(k.shortValue());
    }

    @Deprecated
    default void add(Short k) {
        add(k.shortValue());
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator, java.util.Iterator
    @Deprecated
    default Short next() {
        return next();
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortBidirectionalIterator, p014it.unimi.dsi.fastutil.BidirectionalIterator
    @Deprecated
    default Short previous() {
        return previous();
    }
}
