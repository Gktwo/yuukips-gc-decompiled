package p014it.unimi.dsi.fastutil.longs;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.PriorityQueue;

/* renamed from: it.unimi.dsi.fastutil.longs.LongPriorityQueue */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongPriorityQueue.class */
public interface LongPriorityQueue extends PriorityQueue<Long> {
    void enqueue(long j);

    long dequeueLong();

    long firstLong();

    /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongComparator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.PriorityQueue
    Comparator<? super Long> comparator();

    default long lastLong() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default void enqueue(Long x) {
        enqueue(x.longValue());
    }

    @Override // p014it.unimi.dsi.fastutil.PriorityQueue
    @Deprecated
    default Long dequeue() {
        return Long.valueOf(dequeueLong());
    }

    @Override // p014it.unimi.dsi.fastutil.PriorityQueue
    @Deprecated
    default Long first() {
        return Long.valueOf(firstLong());
    }

    @Override // p014it.unimi.dsi.fastutil.PriorityQueue
    @Deprecated
    default Long last() {
        return Long.valueOf(lastLong());
    }
}
