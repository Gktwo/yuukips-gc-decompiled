package p014it.unimi.dsi.fastutil;

import java.util.Comparator;

/* renamed from: it.unimi.dsi.fastutil.IndirectPriorityQueue */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/IndirectPriorityQueue.class */
public interface IndirectPriorityQueue<K> {
    void enqueue(int i);

    int dequeue();

    int size();

    void clear();

    int first();

    Comparator<? super K> comparator();

    default boolean isEmpty() {
        return size() == 0;
    }

    default int last() {
        throw new UnsupportedOperationException();
    }

    default void changed() {
        changed(first());
    }

    default void changed(int index) {
        throw new UnsupportedOperationException();
    }

    default void allChanged() {
        throw new UnsupportedOperationException();
    }

    default boolean contains(int index) {
        throw new UnsupportedOperationException();
    }

    default boolean remove(int index) {
        throw new UnsupportedOperationException();
    }

    default int front(int[] a) {
        throw new UnsupportedOperationException();
    }
}
