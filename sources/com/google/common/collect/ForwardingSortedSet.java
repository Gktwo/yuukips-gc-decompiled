package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.SortedSet;

@GwtCompatible
/* loaded from: grasscutter.jar:com/google/common/collect/ForwardingSortedSet.class */
public abstract class ForwardingSortedSet<E> extends ForwardingSet<E> implements SortedSet<E> {
    /* access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public abstract SortedSet<E> delegate();

    @Override // java.util.SortedSet
    public Comparator<? super E> comparator() {
        return delegate().comparator();
    }

    @Override // java.util.SortedSet
    public E first() {
        return delegate().first();
    }

    @Override // java.util.SortedSet
    public SortedSet<E> headSet(E toElement) {
        return delegate().headSet(toElement);
    }

    @Override // java.util.SortedSet
    public E last() {
        return delegate().last();
    }

    @Override // java.util.SortedSet
    public SortedSet<E> subSet(E fromElement, E toElement) {
        return delegate().subSet(fromElement, toElement);
    }

    @Override // java.util.SortedSet
    public SortedSet<E> tailSet(E fromElement) {
        return delegate().tailSet(fromElement);
    }

    private int unsafeCompare(Object o1, Object o2) {
        Comparator<? super E> comparator = comparator();
        if (comparator == null) {
            return ((Comparable) o1).compareTo(o2);
        }
        return comparator.compare(o1, o2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ForwardingCollection
    @Beta
    protected boolean standardContains(Object object) {
        try {
            return unsafeCompare(tailSet(object).first(), object) == 0;
        } catch (ClassCastException | NullPointerException | NoSuchElementException e) {
            return false;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ForwardingCollection
    @Beta
    protected boolean standardRemove(Object object) {
        try {
            Iterator<Object> iterator = tailSet(object).iterator();
            if (!iterator.hasNext() || unsafeCompare(iterator.next(), object) != 0) {
                return false;
            }
            iterator.remove();
            return true;
        } catch (ClassCastException | NullPointerException e) {
            return false;
        }
    }

    @Beta
    protected SortedSet<E> standardSubSet(E fromElement, E toElement) {
        return tailSet(fromElement).headSet(toElement);
    }
}
