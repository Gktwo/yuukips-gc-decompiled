package com.github.davidmoten.rtreemulti.internal.util;

import com.github.davidmoten.guavamini.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/* loaded from: grasscutter.jar:com/github/davidmoten/rtreemulti/internal/util/BoundedPriorityQueue.class */
public final class BoundedPriorityQueue<T> {
    private final PriorityQueue<T> queue;
    private final Comparator<? super T> comparator;
    private final int maxSize;

    public BoundedPriorityQueue(int maxSize, Comparator<? super T> comparator) {
        Preconditions.checkArgument(maxSize > 0, "maxSize must be > 0");
        Preconditions.checkNotNull(comparator, "comparator cannot be null");
        this.queue = new PriorityQueue<>(reverse(comparator));
        this.comparator = comparator;
        this.maxSize = maxSize;
    }

    private static <T> Comparator<T> reverse(final Comparator<T> comparator) {
        return new Comparator<T>() { // from class: com.github.davidmoten.rtreemulti.internal.util.BoundedPriorityQueue.1
            @Override // java.util.Comparator
            public int compare(T o1, T o2) {
                return comparator.compare(o2, o1);
            }
        };
    }

    public static <T> BoundedPriorityQueue<T> create(int maxSize, Comparator<? super T> comparator) {
        return new BoundedPriorityQueue<>(maxSize, comparator);
    }

    public void add(T t) {
        if (t == null) {
            throw new NullPointerException("cannot add null to the queue");
        }
        if (this.queue.size() >= this.maxSize) {
            if (this.comparator.compare(this.queue.peek(), t) >= 1) {
                this.queue.poll();
            } else {
                return;
            }
        }
        this.queue.add(t);
    }

    public List<T> asList() {
        return Collections.unmodifiableList(new ArrayList(this.queue));
    }

    public List<T> asOrderedList() {
        List<T> list = new ArrayList<>(this.queue);
        Collections.sort(list, this.comparator);
        return list;
    }
}
