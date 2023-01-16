package p013io.netty.util.internal;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: io.netty.util.internal.EmptyPriorityQueue */
/* loaded from: grasscutter.jar:io/netty/util/internal/EmptyPriorityQueue.class */
public final class EmptyPriorityQueue<T> implements PriorityQueue<T> {
    private static final PriorityQueue<Object> INSTANCE = new EmptyPriorityQueue();

    private EmptyPriorityQueue() {
    }

    public static <V> EmptyPriorityQueue<V> instance() {
        return (EmptyPriorityQueue) INSTANCE;
    }

    @Override // p013io.netty.util.internal.PriorityQueue
    public boolean removeTyped(T node) {
        return false;
    }

    @Override // p013io.netty.util.internal.PriorityQueue
    public boolean containsTyped(T node) {
        return false;
    }

    @Override // p013io.netty.util.internal.PriorityQueue
    public void priorityChanged(T node) {
    }

    @Override // java.util.Collection
    public int size() {
        return 0;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return true;
    }

    @Override // java.util.Collection
    public boolean contains(Object o) {
        return false;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return Collections.emptyList().iterator();
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return EmptyArrays.EMPTY_OBJECTS;
    }

    @Override // java.util.Collection
    public <T1> T1[] toArray(T1[] a) {
        if (a.length > 0) {
            a[0] = null;
        }
        return a;
    }

    @Override // java.util.Queue, java.util.Collection
    public boolean add(T t) {
        return false;
    }

    @Override // java.util.Collection
    public boolean remove(Object o) {
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override // java.util.Collection
    public void clear() {
    }

    @Override // p013io.netty.util.internal.PriorityQueue
    public void clearIgnoringIndexes() {
    }

    @Override // java.util.Collection, java.lang.Object
    public boolean equals(Object o) {
        return (o instanceof PriorityQueue) && ((PriorityQueue) o).isEmpty();
    }

    @Override // java.util.Collection, java.lang.Object
    public int hashCode() {
        return 0;
    }

    @Override // java.util.Queue
    public boolean offer(T t) {
        return false;
    }

    @Override // java.util.Queue
    public T remove() {
        throw new NoSuchElementException();
    }

    @Override // java.util.Queue
    public T poll() {
        return null;
    }

    @Override // java.util.Queue
    public T element() {
        throw new NoSuchElementException();
    }

    @Override // java.util.Queue
    public T peek() {
        return null;
    }

    @Override // java.lang.Object
    public String toString() {
        return EmptyPriorityQueue.class.getSimpleName();
    }
}
