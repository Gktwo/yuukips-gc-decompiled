package p014it.unimi.dsi.fastutil;

import java.util.Comparator;

/* renamed from: it.unimi.dsi.fastutil.PriorityQueue */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/PriorityQueue.class */
public interface PriorityQueue<K> {
    void enqueue(K k);

    K dequeue();

    int size();

    void clear();

    K first();

    Comparator<? super K> comparator();

    default boolean isEmpty() {
        return size() == 0;
    }

    default K last() {
        throw new UnsupportedOperationException();
    }

    default void changed() {
        throw new UnsupportedOperationException();
    }
}
