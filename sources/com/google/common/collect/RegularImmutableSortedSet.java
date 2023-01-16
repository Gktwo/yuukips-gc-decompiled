package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.Consumer;

/* access modifiers changed from: package-private */
@GwtCompatible(serializable = true, emulated = true)
/* loaded from: grasscutter.jar:com/google/common/collect/RegularImmutableSortedSet.class */
public final class RegularImmutableSortedSet<E> extends ImmutableSortedSet<E> {
    static final RegularImmutableSortedSet<Comparable> NATURAL_EMPTY_SET = new RegularImmutableSortedSet<>(ImmutableList.m1438of(), Ordering.natural());
    private final transient ImmutableList<E> elements;

    /* access modifiers changed from: package-private */
    public RegularImmutableSortedSet(ImmutableList<E> elements, Comparator<? super E> comparator) {
        super(comparator);
        this.elements = elements;
    }

    @Override // com.google.common.collect.ImmutableCollection
    Object[] internalArray() {
        return this.elements.internalArray();
    }

    @Override // com.google.common.collect.ImmutableCollection
    int internalArrayStart() {
        return this.elements.internalArrayStart();
    }

    @Override // com.google.common.collect.ImmutableCollection
    int internalArrayEnd() {
        return this.elements.internalArrayEnd();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
    public UnmodifiableIterator<E> iterator() {
        return this.elements.iterator();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    @GwtIncompatible
    public UnmodifiableIterator<E> descendingIterator() {
        return this.elements.reverse().iterator();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable
    public Spliterator<E> spliterator() {
        return asList().spliterator();
    }

    @Override // java.lang.Iterable
    public void forEach(Consumer<? super E> action) {
        this.elements.forEach(action);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.elements.size();
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object o) {
        if (o != null) {
            try {
                if (unsafeBinarySearch(o) >= 0) {
                    return true;
                }
            } catch (ClassCastException e) {
                return false;
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> targets) {
        if (targets instanceof Multiset) {
            targets = ((Multiset) targets).elementSet();
        }
        if (!SortedIterables.hasSameComparator(comparator(), targets) || targets.size() <= 1) {
            return containsAll(targets);
        }
        Iterator<E> thisIterator = iterator();
        Iterator<?> thatIterator = targets.iterator();
        if (!thisIterator.hasNext()) {
            return false;
        }
        Object target = thatIterator.next();
        E current = thisIterator.next();
        while (true) {
            try {
                int cmp = unsafeCompare(current, target);
                if (cmp < 0) {
                    if (!thisIterator.hasNext()) {
                        return false;
                    }
                    current = thisIterator.next();
                } else if (cmp == 0) {
                    if (!thatIterator.hasNext()) {
                        return true;
                    }
                    target = thatIterator.next();
                } else if (cmp > 0) {
                    return false;
                }
            } catch (ClassCastException | NullPointerException e) {
                return false;
            }
        }
    }

    private int unsafeBinarySearch(Object key) throws ClassCastException {
        return Collections.binarySearch(this.elements, key, unsafeComparator());
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return this.elements.isPartialView();
    }

    @Override // com.google.common.collect.ImmutableCollection
    int copyIntoArray(Object[] dst, int offset) {
        return this.elements.copyIntoArray(dst, offset);
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.lang.Object, java.util.Set
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof Set)) {
            return false;
        }
        Set<?> that = (Set) object;
        if (size() != that.size()) {
            return false;
        }
        if (isEmpty()) {
            return true;
        }
        if (!SortedIterables.hasSameComparator(this.comparator, that)) {
            return containsAll(that);
        }
        Iterator<?> otherIterator = that.iterator();
        try {
            Iterator<E> iterator = iterator();
            while (iterator.hasNext()) {
                Object element = iterator.next();
                Object otherElement = otherIterator.next();
                if (otherElement == null || unsafeCompare(element, otherElement) != 0) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException e) {
            return false;
        } catch (NoSuchElementException e2) {
            return false;
        }
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    public E first() {
        if (!isEmpty()) {
            return this.elements.get(0);
        }
        throw new NoSuchElementException();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    public E last() {
        if (!isEmpty()) {
            return this.elements.get(size() - 1);
        }
        throw new NoSuchElementException();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public E lower(E element) {
        int index = headIndex(element, false) - 1;
        if (index == -1) {
            return null;
        }
        return this.elements.get(index);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public E floor(E element) {
        int index = headIndex(element, true) - 1;
        if (index == -1) {
            return null;
        }
        return this.elements.get(index);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public E ceiling(E element) {
        int index = tailIndex(element, true);
        if (index == size()) {
            return null;
        }
        return this.elements.get(index);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public E higher(E element) {
        int index = tailIndex(element, false);
        if (index == size()) {
            return null;
        }
        return this.elements.get(index);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableSortedSet
    public ImmutableSortedSet<E> headSetImpl(E toElement, boolean inclusive) {
        return getSubSet(0, headIndex(toElement, inclusive));
    }

    /* access modifiers changed from: package-private */
    public int headIndex(E toElement, boolean inclusive) {
        int index = Collections.binarySearch(this.elements, Preconditions.checkNotNull(toElement), comparator());
        if (index >= 0) {
            return inclusive ? index + 1 : index;
        }
        return index ^ -1;
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    ImmutableSortedSet<E> subSetImpl(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive) {
        return tailSetImpl(fromElement, fromInclusive).headSetImpl(toElement, toInclusive);
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    ImmutableSortedSet<E> tailSetImpl(E fromElement, boolean inclusive) {
        return getSubSet(tailIndex(fromElement, inclusive), size());
    }

    /* access modifiers changed from: package-private */
    public int tailIndex(E fromElement, boolean inclusive) {
        int index = Collections.binarySearch(this.elements, Preconditions.checkNotNull(fromElement), comparator());
        if (index >= 0) {
            return inclusive ? index : index + 1;
        }
        return index ^ -1;
    }

    Comparator<Object> unsafeComparator() {
        return this.comparator;
    }

    /* access modifiers changed from: package-private */
    public RegularImmutableSortedSet<E> getSubSet(int newFromIndex, int newToIndex) {
        if (newFromIndex == 0 && newToIndex == size()) {
            return this;
        }
        if (newFromIndex < newToIndex) {
            return new RegularImmutableSortedSet<>(this.elements.subList(newFromIndex, newToIndex), this.comparator);
        }
        return emptySet(this.comparator);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableSortedSet
    public int indexOf(Object target) {
        if (target == null) {
            return -1;
        }
        try {
            int position = Collections.binarySearch(this.elements, target, unsafeComparator());
            if (position >= 0) {
                return position;
            }
            return -1;
        } catch (ClassCastException e) {
            return -1;
        }
    }

    @Override // com.google.common.collect.ImmutableSet
    ImmutableList<E> createAsList() {
        return size() <= 1 ? this.elements : new ImmutableSortedAsList(this, this.elements);
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    ImmutableSortedSet<E> createDescendingSet() {
        Comparator<? super E> reversedOrder = Collections.reverseOrder(this.comparator);
        if (isEmpty()) {
            return emptySet(reversedOrder);
        }
        return new RegularImmutableSortedSet(this.elements.reverse(), reversedOrder);
    }
}
