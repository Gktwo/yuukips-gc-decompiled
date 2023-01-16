package p014it.unimi.dsi.fastutil.booleans;

import java.util.ListIterator;

/* renamed from: it.unimi.dsi.fastutil.booleans.BooleanListIterator */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanListIterator.class */
public interface BooleanListIterator extends BooleanBidirectionalIterator, ListIterator<Boolean> {
    default void set(boolean k) {
        throw new UnsupportedOperationException();
    }

    default void add(boolean k) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator, java.util.ListIterator
    default void remove() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default void set(Boolean k) {
        set(k.booleanValue());
    }

    @Deprecated
    default void add(Boolean k) {
        add(k.booleanValue());
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterator, java.util.Iterator
    @Deprecated
    default Boolean next() {
        return next();
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBidirectionalIterator, p014it.unimi.dsi.fastutil.BidirectionalIterator
    @Deprecated
    default Boolean previous() {
        return previous();
    }
}
