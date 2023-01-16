package p014it.unimi.dsi.fastutil.doubles;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.PriorityQueue;

/* renamed from: it.unimi.dsi.fastutil.doubles.DoublePriorityQueue */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoublePriorityQueue.class */
public interface DoublePriorityQueue extends PriorityQueue<Double> {
    void enqueue(double d);

    double dequeueDouble();

    double firstDouble();

    /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleComparator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.PriorityQueue
    Comparator<? super Double> comparator();

    default double lastDouble() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default void enqueue(Double x) {
        enqueue(x.doubleValue());
    }

    @Override // p014it.unimi.dsi.fastutil.PriorityQueue
    @Deprecated
    default Double dequeue() {
        return Double.valueOf(dequeueDouble());
    }

    @Override // p014it.unimi.dsi.fastutil.PriorityQueue
    @Deprecated
    default Double first() {
        return Double.valueOf(firstDouble());
    }

    @Override // p014it.unimi.dsi.fastutil.PriorityQueue
    @Deprecated
    default Double last() {
        return Double.valueOf(lastDouble());
    }
}
