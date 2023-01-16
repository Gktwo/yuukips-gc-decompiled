package p014it.unimi.dsi.fastutil.floats;

import java.util.ListIterator;

/* renamed from: it.unimi.dsi.fastutil.floats.FloatListIterator */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatListIterator.class */
public interface FloatListIterator extends FloatBidirectionalIterator, ListIterator<Float> {
    default void set(float k) {
        throw new UnsupportedOperationException();
    }

    default void add(float k) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator, java.util.ListIterator
    default void remove() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default void set(Float k) {
        set(k.floatValue());
    }

    @Deprecated
    default void add(Float k) {
        add(k.floatValue());
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator, java.util.Iterator
    @Deprecated
    default Float next() {
        return next();
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatBidirectionalIterator, p014it.unimi.dsi.fastutil.BidirectionalIterator
    @Deprecated
    default Float previous() {
        return previous();
    }
}
