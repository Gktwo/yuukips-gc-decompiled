package p014it.unimi.dsi.fastutil.doubles;

import java.util.ListIterator;

/* renamed from: it.unimi.dsi.fastutil.doubles.DoubleListIterator */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleListIterator.class */
public interface DoubleListIterator extends DoubleBidirectionalIterator, ListIterator<Double> {
    default void set(double k) {
        throw new UnsupportedOperationException();
    }

    default void add(double k) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator, java.util.ListIterator
    default void remove() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default void set(Double k) {
        set(k.doubleValue());
    }

    @Deprecated
    default void add(Double k) {
        add(k.doubleValue());
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, java.util.PrimitiveIterator.OfDouble, java.util.Iterator
    @Deprecated
    default Double next() {
        return next();
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBidirectionalIterator, p014it.unimi.dsi.fastutil.BidirectionalIterator
    @Deprecated
    default Double previous() {
        return previous();
    }
}
