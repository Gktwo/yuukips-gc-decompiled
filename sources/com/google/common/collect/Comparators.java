package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;

@GwtCompatible
/* loaded from: grasscutter.jar:com/google/common/collect/Comparators.class */
public final class Comparators {
    private Comparators() {
    }

    @Beta
    public static <T, S extends T> Comparator<Iterable<S>> lexicographical(Comparator<T> comparator) {
        return new LexicographicalOrdering((Comparator) Preconditions.checkNotNull(comparator));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.util.Comparator<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Beta
    public static <T> boolean isInOrder(Iterable<? extends T> iterable, Comparator<T> comparator) {
        Preconditions.checkNotNull(comparator);
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return true;
        }
        Object next = it.next();
        while (it.hasNext()) {
            Object next2 = it.next();
            if (comparator.compare(next, next2) > 0) {
                return false;
            }
            next = next2;
        }
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.util.Comparator<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Beta
    public static <T> boolean isInStrictOrder(Iterable<? extends T> iterable, Comparator<T> comparator) {
        Preconditions.checkNotNull(comparator);
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return true;
        }
        Object next = it.next();
        while (it.hasNext()) {
            Object next2 = it.next();
            if (comparator.compare(next, next2) >= 0) {
                return false;
            }
            next = next2;
        }
        return true;
    }

    public static <T> Collector<T, ?, List<T>> least(int k, Comparator<? super T> comparator) {
        CollectPreconditions.checkNonnegative(k, "k");
        Preconditions.checkNotNull(comparator);
        return Collector.of(() -> {
            return TopKSelector.least(k, comparator);
        }, (v0, v1) -> {
            v0.offer(v1);
        }, (v0, v1) -> {
            return v0.combine(v1);
        }, (v0) -> {
            return v0.topK();
        }, Collector.Characteristics.UNORDERED);
    }

    public static <T> Collector<T, ?, List<T>> greatest(int k, Comparator<? super T> comparator) {
        return least(k, comparator.reversed());
    }

    @Beta
    public static <T> Comparator<Optional<T>> emptiesFirst(Comparator<? super T> valueComparator) {
        Preconditions.checkNotNull(valueComparator);
        return Comparator.comparing(o -> {
            return o.orElse(null);
        }, Comparator.nullsFirst(valueComparator));
    }

    @Beta
    public static <T> Comparator<Optional<T>> emptiesLast(Comparator<? super T> valueComparator) {
        Preconditions.checkNotNull(valueComparator);
        return Comparator.comparing(o -> {
            return o.orElse(null);
        }, Comparator.nullsLast(valueComparator));
    }
}
