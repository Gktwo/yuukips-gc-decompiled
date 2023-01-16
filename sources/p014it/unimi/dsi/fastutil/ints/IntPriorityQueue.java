package p014it.unimi.dsi.fastutil.ints;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.PriorityQueue;

/* renamed from: it.unimi.dsi.fastutil.ints.IntPriorityQueue */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntPriorityQueue.class */
public interface IntPriorityQueue extends PriorityQueue<Integer> {
    void enqueue(int i);

    int dequeueInt();

    int firstInt();

    /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntComparator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.PriorityQueue
    Comparator<? super Integer> comparator();

    default int lastInt() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default void enqueue(Integer x) {
        enqueue(x.intValue());
    }

    @Override // p014it.unimi.dsi.fastutil.PriorityQueue
    @Deprecated
    default Integer dequeue() {
        return Integer.valueOf(dequeueInt());
    }

    @Override // p014it.unimi.dsi.fastutil.PriorityQueue
    @Deprecated
    default Integer first() {
        return Integer.valueOf(firstInt());
    }

    @Override // p014it.unimi.dsi.fastutil.PriorityQueue
    @Deprecated
    default Integer last() {
        return Integer.valueOf(lastInt());
    }
}
