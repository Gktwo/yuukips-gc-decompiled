package p014it.unimi.dsi.fastutil.shorts;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.PriorityQueue;

/* renamed from: it.unimi.dsi.fastutil.shorts.ShortPriorityQueue */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortPriorityQueue.class */
public interface ShortPriorityQueue extends PriorityQueue<Short> {
    void enqueue(short s);

    short dequeueShort();

    short firstShort();

    /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortComparator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.PriorityQueue
    Comparator<? super Short> comparator();

    default short lastShort() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default void enqueue(Short x) {
        enqueue(x.shortValue());
    }

    @Override // p014it.unimi.dsi.fastutil.PriorityQueue
    @Deprecated
    default Short dequeue() {
        return Short.valueOf(dequeueShort());
    }

    @Override // p014it.unimi.dsi.fastutil.PriorityQueue
    @Deprecated
    default Short first() {
        return Short.valueOf(firstShort());
    }

    @Override // p014it.unimi.dsi.fastutil.PriorityQueue
    @Deprecated
    default Short last() {
        return Short.valueOf(lastShort());
    }
}
