package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.NoSuchElementException;
import java.util.Set;
import okhttp3.HttpUrl;

/* access modifiers changed from: package-private */
@GwtCompatible(emulated = true)
/* loaded from: grasscutter.jar:com/google/common/collect/EmptyContiguousSet.class */
public final class EmptyContiguousSet<C extends Comparable> extends ContiguousSet<C> {
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.google.common.collect.EmptyContiguousSet<C extends java.lang.Comparable> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ContiguousSet, com.google.common.collect.ImmutableSortedSet
    /* bridge */ /* synthetic */ ImmutableSortedSet tailSetImpl(Object obj, boolean z) {
        return tailSetImpl((EmptyContiguousSet<C>) ((Comparable) obj), z);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.google.common.collect.EmptyContiguousSet<C extends java.lang.Comparable> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ContiguousSet, com.google.common.collect.ImmutableSortedSet
    /* bridge */ /* synthetic */ ImmutableSortedSet subSetImpl(Object obj, boolean z, Object obj2, boolean z2) {
        return subSetImpl((boolean) ((Comparable) obj), z, (boolean) ((Comparable) obj2), z2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.google.common.collect.EmptyContiguousSet<C extends java.lang.Comparable> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ContiguousSet, com.google.common.collect.ImmutableSortedSet
    /* bridge */ /* synthetic */ ImmutableSortedSet headSetImpl(Object obj, boolean z) {
        return headSetImpl((EmptyContiguousSet<C>) ((Comparable) obj), z);
    }

    /* access modifiers changed from: package-private */
    public EmptyContiguousSet(DiscreteDomain<C> domain) {
        super(domain);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    public C first() {
        throw new NoSuchElementException();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    public C last() {
        throw new NoSuchElementException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return 0;
    }

    @Override // com.google.common.collect.ContiguousSet
    public ContiguousSet<C> intersection(ContiguousSet<C> other) {
        return this;
    }

    @Override // com.google.common.collect.ContiguousSet
    public Range<C> range() {
        throw new NoSuchElementException();
    }

    @Override // com.google.common.collect.ContiguousSet
    public Range<C> range(BoundType lowerBoundType, BoundType upperBoundType) {
        throw new NoSuchElementException();
    }

    @Override // com.google.common.collect.ContiguousSet
    ContiguousSet<C> headSetImpl(C toElement, boolean inclusive) {
        return this;
    }

    @Override // com.google.common.collect.ContiguousSet
    ContiguousSet<C> subSetImpl(C fromElement, boolean fromInclusive, C toElement, boolean toInclusive) {
        return this;
    }

    @Override // com.google.common.collect.ContiguousSet
    ContiguousSet<C> tailSetImpl(C fromElement, boolean fromInclusive) {
        return this;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object object) {
        return false;
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    @GwtIncompatible
    int indexOf(Object target) {
        return -1;
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
    public UnmodifiableIterator<C> iterator() {
        return Iterators.emptyIterator();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    @GwtIncompatible
    public UnmodifiableIterator<C> descendingIterator() {
        return Iterators.emptyIterator();
    }

    @Override // com.google.common.collect.ImmutableCollection
    boolean isPartialView() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return true;
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    public ImmutableList<C> asList() {
        return ImmutableList.m1438of();
    }

    @Override // com.google.common.collect.ContiguousSet, java.util.AbstractCollection, java.lang.Object
    public String toString() {
        return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.lang.Object, java.util.Set
    public boolean equals(Object object) {
        if (object instanceof Set) {
            return ((Set) object).isEmpty();
        }
        return false;
    }

    @Override // com.google.common.collect.ImmutableSet
    @GwtIncompatible
    boolean isHashCodeFast() {
        return true;
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.lang.Object, java.util.Set
    public int hashCode() {
        return 0;
    }

    @GwtIncompatible
    /* loaded from: grasscutter.jar:com/google/common/collect/EmptyContiguousSet$SerializedForm.class */
    private static final class SerializedForm<C extends Comparable> implements Serializable {
        private final DiscreteDomain<C> domain;
        private static final long serialVersionUID = 0;

        private SerializedForm(DiscreteDomain<C> domain) {
            this.domain = domain;
        }

        private Object readResolve() {
            return new EmptyContiguousSet(this.domain);
        }
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    @GwtIncompatible
    Object writeReplace() {
        return new SerializedForm(this.domain);
    }

    @Override // com.google.common.collect.ContiguousSet, com.google.common.collect.ImmutableSortedSet
    @GwtIncompatible
    ImmutableSortedSet<C> createDescendingSet() {
        return ImmutableSortedSet.emptySet(Ordering.natural().reverse());
    }
}
