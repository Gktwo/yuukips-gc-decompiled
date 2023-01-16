package com.github.davidmoten.guavamini;

import com.github.davidmoten.guavamini.annotations.VisibleForTesting;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: grasscutter.jar:com/github/davidmoten/guavamini/Sets.class */
public final class Sets {
    static final int MAX_POWER_OF_TWO = 1073741824;

    private Sets() {
    }

    public static <E> HashSet<E> newHashSet(E... elements) {
        Preconditions.checkNotNull(elements);
        HashSet<E> set = newHashSetWithExpectedSize(elements.length);
        Collections.addAll(set, elements);
        return set;
    }

    public static <E> HashSet<E> newHashSetWithExpectedSize(int expectedSize) {
        return new HashSet<>(capacity(expectedSize));
    }

    @VisibleForTesting
    static int capacity(int expectedSize) {
        if (expectedSize < 3) {
            checkNonnegative(expectedSize, "expectedSize");
            return expectedSize + 1;
        } else if (expectedSize < 1073741824) {
            return expectedSize + (expectedSize / 3);
        } else {
            return Integer.MAX_VALUE;
        }
    }

    @VisibleForTesting
    static int checkNonnegative(int value, String name) {
        if (value >= 0) {
            return value;
        }
        throw new IllegalArgumentException(name + " cannot be negative but was: " + value);
    }

    public static <E> HashSet<E> newHashSet(Iterable<? extends E> elements) {
        return elements instanceof Collection ? new HashSet<>(Collections2.cast(elements)) : newHashSet(elements.iterator());
    }

    public static <E> HashSet<E> newHashSet(Iterator<? extends E> elements) {
        HashSet<E> set = newHashSet();
        Iterators.addAll(set, elements);
        return set;
    }

    public static <E> HashSet<E> newHashSet() {
        return new HashSet<>();
    }
}
