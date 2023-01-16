package com.github.davidmoten.guavamini;

import java.util.Collection;
import java.util.Iterator;

/* loaded from: grasscutter.jar:com/github/davidmoten/guavamini/Iterators.class */
public final class Iterators {
    private Iterators() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.Collection<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> boolean addAll(Collection<T> addTo, Iterator<? extends T> iterator) {
        Preconditions.checkNotNull(addTo);
        Preconditions.checkNotNull(iterator);
        boolean wasModified = false;
        while (iterator.hasNext()) {
            wasModified |= addTo.add(iterator.next());
        }
        return wasModified;
    }
}
