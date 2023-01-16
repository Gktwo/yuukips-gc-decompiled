package com.github.davidmoten.guavamini;

import com.github.davidmoten.guavamini.annotations.VisibleForTesting;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/* loaded from: grasscutter.jar:com/github/davidmoten/guavamini/Lists.class */
public final class Lists {
    private Lists() {
    }

    public static <E> ArrayList<E> newArrayList(E... elements) {
        Preconditions.checkNotNull(elements);
        ArrayList<E> list = new ArrayList<>(computeArrayListCapacity(elements.length));
        Collections.addAll(list, elements);
        return list;
    }

    @VisibleForTesting
    static int computeArrayListCapacity(int arraySize) {
        Preconditions.checkArgument(arraySize >= 0, "arraySize must be non-negative");
        return saturatedCast(5 + ((long) arraySize) + ((long) (arraySize / 10)));
    }

    @VisibleForTesting
    static int saturatedCast(long value) {
        if (value > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (value < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) value;
    }

    public static <E> ArrayList<E> newArrayList() {
        return new ArrayList<>();
    }

    public static <E> ArrayList<E> newArrayList(Iterable<? extends E> elements) {
        Preconditions.checkNotNull(elements);
        return elements instanceof Collection ? new ArrayList<>(Collections2.cast(elements)) : newArrayList(elements.iterator());
    }

    public static <E> ArrayList<E> newArrayList(Iterator<? extends E> elements) {
        ArrayList<E> list = newArrayList();
        Iterators.addAll(list, elements);
        return list;
    }
}
