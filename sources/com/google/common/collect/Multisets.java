package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Multiset;
import com.google.common.collect.Sets;
import com.google.common.math.IntMath;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.stream.Collector;

@GwtCompatible
/* loaded from: grasscutter.jar:com/google/common/collect/Multisets.class */
public final class Multisets {
    private Multisets() {
    }

    public static <T, E, M extends Multiset<E>> Collector<T, ?, M> toMultiset(Function<? super T, E> elementFunction, ToIntFunction<? super T> countFunction, Supplier<M> multisetSupplier) {
        Preconditions.checkNotNull(elementFunction);
        Preconditions.checkNotNull(countFunction);
        Preconditions.checkNotNull(multisetSupplier);
        return Collector.of(multisetSupplier, ms, t -> {
            ms.add(elementFunction.apply(t), countFunction.applyAsInt(t));
        }, ms1, ms2 -> {
            ms1.addAll(ms2);
            return ms1;
        }, new Collector.Characteristics[0]);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.google.common.collect.Multiset<? extends E> */
    /* JADX WARN: Multi-variable type inference failed */
    public static <E> Multiset<E> unmodifiableMultiset(Multiset<? extends E> multiset) {
        if ((multiset instanceof UnmodifiableMultiset) || (multiset instanceof ImmutableMultiset)) {
            return multiset;
        }
        return new UnmodifiableMultiset((Multiset) Preconditions.checkNotNull(multiset));
    }

    @Deprecated
    public static <E> Multiset<E> unmodifiableMultiset(ImmutableMultiset<E> multiset) {
        return (Multiset) Preconditions.checkNotNull(multiset);
    }

    /* loaded from: grasscutter.jar:com/google/common/collect/Multisets$UnmodifiableMultiset.class */
    static class UnmodifiableMultiset<E> extends ForwardingMultiset<E> implements Serializable {
        final Multiset<? extends E> delegate;
        transient Set<E> elementSet;
        transient Set<Multiset.Entry<E>> entrySet;
        private static final long serialVersionUID = 0;

        /* access modifiers changed from: package-private */
        public UnmodifiableMultiset(Multiset<? extends E> delegate) {
            this.delegate = delegate;
        }

        /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: com.google.common.collect.Multiset<? extends E>, com.google.common.collect.Multiset<E> */
        /* access modifiers changed from: protected */
        @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public Multiset<E> delegate() {
            return (Multiset<? extends E>) this.delegate;
        }

        Set<E> createElementSet() {
            return Collections.unmodifiableSet(this.delegate.elementSet());
        }

        @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
        public Set<E> elementSet() {
            Set<E> es = this.elementSet;
            if (es != null) {
                return es;
            }
            Set<E> createElementSet = createElementSet();
            this.elementSet = createElementSet;
            return createElementSet;
        }

        @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
        public Set<Multiset.Entry<E>> entrySet() {
            Set<Multiset.Entry<E>> es = this.entrySet;
            if (es != null) {
                return es;
            }
            Set<Multiset.Entry<E>> unmodifiableSet = Collections.unmodifiableSet(this.delegate.entrySet());
            this.entrySet = unmodifiableSet;
            return unmodifiableSet;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return Iterators.unmodifiableIterator(this.delegate.iterator());
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Queue
        public boolean add(E element) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
        public int add(E element, int occurences) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
        public boolean addAll(Collection<? extends E> elementsToAdd) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean remove(Object element) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
        public int remove(Object element, int occurrences) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> elementsToRemove) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> elementsToRetain) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
        public int setCount(E element, int count) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
        public boolean setCount(E element, int oldCount, int newCount) {
            throw new UnsupportedOperationException();
        }
    }

    @Beta
    public static <E> SortedMultiset<E> unmodifiableSortedMultiset(SortedMultiset<E> sortedMultiset) {
        return new UnmodifiableSortedMultiset((SortedMultiset) Preconditions.checkNotNull(sortedMultiset));
    }

    public static <E> Multiset.Entry<E> immutableEntry(E e, int n) {
        return new ImmutableEntry(e, n);
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/google/common/collect/Multisets$ImmutableEntry.class */
    public static class ImmutableEntry<E> extends AbstractEntry<E> implements Serializable {
        private final E element;
        private final int count;
        private static final long serialVersionUID = 0;

        /* access modifiers changed from: package-private */
        public ImmutableEntry(E element, int count) {
            this.element = element;
            this.count = count;
            CollectPreconditions.checkNonnegative(count, "count");
        }

        @Override // com.google.common.collect.Multiset.Entry
        public final E getElement() {
            return this.element;
        }

        @Override // com.google.common.collect.Multiset.Entry
        public final int getCount() {
            return this.count;
        }

        public ImmutableEntry<E> nextInBucket() {
            return null;
        }
    }

    @Beta
    public static <E> Multiset<E> filter(Multiset<E> unfiltered, Predicate<? super E> predicate) {
        if (!(unfiltered instanceof FilteredMultiset)) {
            return new FilteredMultiset(unfiltered, predicate);
        }
        FilteredMultiset<E> filtered = (FilteredMultiset) unfiltered;
        return new FilteredMultiset(filtered.unfiltered, Predicates.and(filtered.predicate, predicate));
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/common/collect/Multisets$FilteredMultiset.class */
    public static final class FilteredMultiset<E> extends ViewMultiset<E> {
        final Multiset<E> unfiltered;
        final Predicate<? super E> predicate;

        FilteredMultiset(Multiset<E> unfiltered, Predicate<? super E> predicate) {
            super();
            this.unfiltered = (Multiset) Preconditions.checkNotNull(unfiltered);
            this.predicate = (Predicate) Preconditions.checkNotNull(predicate);
        }

        @Override // com.google.common.collect.Multisets.ViewMultiset, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
        public UnmodifiableIterator<E> iterator() {
            return Iterators.filter(this.unfiltered.iterator(), this.predicate);
        }

        @Override // com.google.common.collect.AbstractMultiset
        Set<E> createElementSet() {
            return Sets.filter(this.unfiltered.elementSet(), this.predicate);
        }

        @Override // com.google.common.collect.AbstractMultiset
        Iterator<E> elementIterator() {
            throw new AssertionError("should never be called");
        }

        @Override // com.google.common.collect.AbstractMultiset
        Set<Multiset.Entry<E>> createEntrySet() {
            return Sets.filter(this.unfiltered.entrySet(), new Predicate<Multiset.Entry<E>>() { // from class: com.google.common.collect.Multisets.FilteredMultiset.1
                @Override // com.google.common.base.Predicate
                public /* bridge */ /* synthetic */ boolean apply(Object obj) {
                    return apply((Multiset.Entry) ((Multiset.Entry) obj));
                }

                public boolean apply(Multiset.Entry<E> entry) {
                    return FilteredMultiset.this.predicate.apply(entry.getElement());
                }
            });
        }

        @Override // com.google.common.collect.AbstractMultiset
        Iterator<Multiset.Entry<E>> entryIterator() {
            throw new AssertionError("should never be called");
        }

        @Override // com.google.common.collect.Multiset
        public int count(Object element) {
            int count = this.unfiltered.count(element);
            if (count <= 0 || !this.predicate.apply(element)) {
                return 0;
            }
            return count;
        }

        @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
        public int add(E element, int occurrences) {
            Preconditions.checkArgument(this.predicate.apply(element), "Element %s does not match predicate %s", element, this.predicate);
            return this.unfiltered.add(element, occurrences);
        }

        @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
        public int remove(Object element, int occurrences) {
            CollectPreconditions.checkNonnegative(occurrences, "occurrences");
            if (occurrences == 0) {
                return count(element);
            }
            if (contains(element)) {
                return this.unfiltered.remove(element, occurrences);
            }
            return 0;
        }
    }

    /* access modifiers changed from: package-private */
    public static int inferDistinctElements(Iterable<?> elements) {
        if (elements instanceof Multiset) {
            return ((Multiset) elements).elementSet().size();
        }
        return 11;
    }

    @Beta
    public static <E> Multiset<E> union(final Multiset<? extends E> multiset1, final Multiset<? extends E> multiset2) {
        Preconditions.checkNotNull(multiset1);
        Preconditions.checkNotNull(multiset2);
        return new ViewMultiset<E>() { // from class: com.google.common.collect.Multisets.1
            @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
            public boolean contains(Object element) {
                return multiset1.contains(element) || multiset2.contains(element);
            }

            @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
            public boolean isEmpty() {
                return multiset1.isEmpty() && multiset2.isEmpty();
            }

            @Override // com.google.common.collect.Multiset
            public int count(Object element) {
                return Math.max(multiset1.count(element), multiset2.count(element));
            }

            @Override // com.google.common.collect.AbstractMultiset
            Set<E> createElementSet() {
                return Sets.union(multiset1.elementSet(), multiset2.elementSet());
            }

            @Override // com.google.common.collect.AbstractMultiset
            Iterator<E> elementIterator() {
                throw new AssertionError("should never be called");
            }

            @Override // com.google.common.collect.AbstractMultiset
            Iterator<Multiset.Entry<E>> entryIterator() {
                final Iterator it = multiset1.entrySet().iterator();
                final Iterator it2 = multiset2.entrySet().iterator();
                return new AbstractIterator<Multiset.Entry<E>>() { // from class: com.google.common.collect.Multisets.1.1
                    /* access modifiers changed from: protected */
                    @Override // com.google.common.collect.AbstractIterator
                    public Multiset.Entry<E> computeNext() {
                        if (it.hasNext()) {
                            Multiset.Entry entry = (Multiset.Entry) it.next();
                            Object element = entry.getElement();
                            return Multisets.immutableEntry(element, Math.max(entry.getCount(), multiset2.count(element)));
                        }
                        while (it2.hasNext()) {
                            Multiset.Entry entry2 = (Multiset.Entry) it2.next();
                            Object element2 = entry2.getElement();
                            if (!multiset1.contains(element2)) {
                                return Multisets.immutableEntry(element2, entry2.getCount());
                            }
                        }
                        return (Multiset.Entry) endOfData();
                    }
                };
            }
        };
    }

    public static <E> Multiset<E> intersection(final Multiset<E> multiset1, final Multiset<?> multiset2) {
        Preconditions.checkNotNull(multiset1);
        Preconditions.checkNotNull(multiset2);
        return new ViewMultiset<E>() { // from class: com.google.common.collect.Multisets.2
            @Override // com.google.common.collect.Multiset
            public int count(Object element) {
                int count1 = multiset1.count(element);
                if (count1 == 0) {
                    return 0;
                }
                return Math.min(count1, multiset2.count(element));
            }

            @Override // com.google.common.collect.AbstractMultiset
            Set<E> createElementSet() {
                return Sets.intersection(multiset1.elementSet(), multiset2.elementSet());
            }

            @Override // com.google.common.collect.AbstractMultiset
            Iterator<E> elementIterator() {
                throw new AssertionError("should never be called");
            }

            @Override // com.google.common.collect.AbstractMultiset
            Iterator<Multiset.Entry<E>> entryIterator() {
                final Iterator it = multiset1.entrySet().iterator();
                return new AbstractIterator<Multiset.Entry<E>>() { // from class: com.google.common.collect.Multisets.2.1
                    /* access modifiers changed from: protected */
                    @Override // com.google.common.collect.AbstractIterator
                    public Multiset.Entry<E> computeNext() {
                        while (it.hasNext()) {
                            Multiset.Entry entry = (Multiset.Entry) it.next();
                            Object element = entry.getElement();
                            int count = Math.min(entry.getCount(), multiset2.count(element));
                            if (count > 0) {
                                return Multisets.immutableEntry(element, count);
                            }
                        }
                        return (Multiset.Entry) endOfData();
                    }
                };
            }
        };
    }

    @Beta
    public static <E> Multiset<E> sum(final Multiset<? extends E> multiset1, final Multiset<? extends E> multiset2) {
        Preconditions.checkNotNull(multiset1);
        Preconditions.checkNotNull(multiset2);
        return new ViewMultiset<E>() { // from class: com.google.common.collect.Multisets.3
            @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
            public boolean contains(Object element) {
                return multiset1.contains(element) || multiset2.contains(element);
            }

            @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
            public boolean isEmpty() {
                return multiset1.isEmpty() && multiset2.isEmpty();
            }

            @Override // com.google.common.collect.Multisets.ViewMultiset, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
            public int size() {
                return IntMath.saturatedAdd(multiset1.size(), multiset2.size());
            }

            @Override // com.google.common.collect.Multiset
            public int count(Object element) {
                return multiset1.count(element) + multiset2.count(element);
            }

            @Override // com.google.common.collect.AbstractMultiset
            Set<E> createElementSet() {
                return Sets.union(multiset1.elementSet(), multiset2.elementSet());
            }

            @Override // com.google.common.collect.AbstractMultiset
            Iterator<E> elementIterator() {
                throw new AssertionError("should never be called");
            }

            @Override // com.google.common.collect.AbstractMultiset
            Iterator<Multiset.Entry<E>> entryIterator() {
                final Iterator it = multiset1.entrySet().iterator();
                final Iterator it2 = multiset2.entrySet().iterator();
                return new AbstractIterator<Multiset.Entry<E>>() { // from class: com.google.common.collect.Multisets.3.1
                    /* access modifiers changed from: protected */
                    @Override // com.google.common.collect.AbstractIterator
                    public Multiset.Entry<E> computeNext() {
                        if (it.hasNext()) {
                            Multiset.Entry entry = (Multiset.Entry) it.next();
                            Object element = entry.getElement();
                            return Multisets.immutableEntry(element, entry.getCount() + multiset2.count(element));
                        }
                        while (it2.hasNext()) {
                            Multiset.Entry entry2 = (Multiset.Entry) it2.next();
                            Object element2 = entry2.getElement();
                            if (!multiset1.contains(element2)) {
                                return Multisets.immutableEntry(element2, entry2.getCount());
                            }
                        }
                        return (Multiset.Entry) endOfData();
                    }
                };
            }
        };
    }

    @Beta
    public static <E> Multiset<E> difference(final Multiset<E> multiset1, final Multiset<?> multiset2) {
        Preconditions.checkNotNull(multiset1);
        Preconditions.checkNotNull(multiset2);
        return new ViewMultiset<E>() { // from class: com.google.common.collect.Multisets.4
            @Override // com.google.common.collect.Multiset
            public int count(Object element) {
                int count1 = multiset1.count(element);
                if (count1 == 0) {
                    return 0;
                }
                return Math.max(0, count1 - multiset2.count(element));
            }

            @Override // com.google.common.collect.Multisets.ViewMultiset, com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
            public void clear() {
                throw new UnsupportedOperationException();
            }

            @Override // com.google.common.collect.AbstractMultiset
            Iterator<E> elementIterator() {
                final Iterator it = multiset1.entrySet().iterator();
                return new AbstractIterator<E>() { // from class: com.google.common.collect.Multisets.4.1
                    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.google.common.collect.Multiset */
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Type inference failed for: r0v10, types: [E, java.lang.Object] */
                    /* JADX WARNING: Unknown variable types count: 1 */
                    @Override // com.google.common.collect.AbstractIterator
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    protected E computeNext() {
                        /*
                            r4 = this;
                        L_0x0000:
                            r0 = r4
                            java.util.Iterator r0 = r0
                            boolean r0 = r0.hasNext()
                            if (r0 == 0) goto L_0x003b
                            r0 = r4
                            java.util.Iterator r0 = r0
                            java.lang.Object r0 = r0.next()
                            com.google.common.collect.Multiset$Entry r0 = (com.google.common.collect.Multiset.Entry) r0
                            r5 = r0
                            r0 = r5
                            java.lang.Object r0 = r0.getElement()
                            r6 = r0
                            r0 = r5
                            int r0 = r0.getCount()
                            r1 = r4
                            com.google.common.collect.Multisets$4 r1 = com.google.common.collect.Multisets.C03214.this
                            com.google.common.collect.Multiset r1 = r6
                            r2 = r6
                            int r1 = r1.count(r2)
                            if (r0 <= r1) goto L_0x0038
                            r0 = r6
                            return r0
                        L_0x0038:
                            goto L_0x0000
                        L_0x003b:
                            r0 = r4
                            java.lang.Object r0 = r0.endOfData()
                            return r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.Multisets.C03214.C03221.computeNext():java.lang.Object");
                    }
                };
            }

            @Override // com.google.common.collect.AbstractMultiset
            Iterator<Multiset.Entry<E>> entryIterator() {
                final Iterator it = multiset1.entrySet().iterator();
                return new AbstractIterator<Multiset.Entry<E>>() { // from class: com.google.common.collect.Multisets.4.2
                    /* access modifiers changed from: protected */
                    @Override // com.google.common.collect.AbstractIterator
                    public Multiset.Entry<E> computeNext() {
                        while (it.hasNext()) {
                            Multiset.Entry entry = (Multiset.Entry) it.next();
                            Object element = entry.getElement();
                            int count = entry.getCount() - multiset2.count(element);
                            if (count > 0) {
                                return Multisets.immutableEntry(element, count);
                            }
                        }
                        return (Multiset.Entry) endOfData();
                    }
                };
            }

            @Override // com.google.common.collect.Multisets.ViewMultiset, com.google.common.collect.AbstractMultiset
            int distinctElements() {
                return Iterators.size(entryIterator());
            }
        };
    }

    @CanIgnoreReturnValue
    public static boolean containsOccurrences(Multiset<?> superMultiset, Multiset<?> subMultiset) {
        Preconditions.checkNotNull(superMultiset);
        Preconditions.checkNotNull(subMultiset);
        for (Multiset.Entry<?> entry : subMultiset.entrySet()) {
            if (superMultiset.count(entry.getElement()) < entry.getCount()) {
                return false;
            }
        }
        return true;
    }

    @CanIgnoreReturnValue
    public static boolean retainOccurrences(Multiset<?> multisetToModify, Multiset<?> multisetToRetain) {
        return retainOccurrencesImpl(multisetToModify, multisetToRetain);
    }

    private static <E> boolean retainOccurrencesImpl(Multiset<E> multisetToModify, Multiset<?> occurrencesToRetain) {
        Preconditions.checkNotNull(multisetToModify);
        Preconditions.checkNotNull(occurrencesToRetain);
        Iterator<Multiset.Entry<E>> entryIterator = multisetToModify.entrySet().iterator();
        boolean changed = false;
        while (entryIterator.hasNext()) {
            Multiset.Entry<E> entry = entryIterator.next();
            int retainCount = occurrencesToRetain.count(entry.getElement());
            if (retainCount == 0) {
                entryIterator.remove();
                changed = true;
            } else if (retainCount < entry.getCount()) {
                multisetToModify.setCount(entry.getElement(), retainCount);
                changed = true;
            }
        }
        return changed;
    }

    @CanIgnoreReturnValue
    public static boolean removeOccurrences(Multiset<?> multisetToModify, Iterable<?> occurrencesToRemove) {
        if (occurrencesToRemove instanceof Multiset) {
            return removeOccurrences(multisetToModify, (Multiset<?>) ((Multiset) occurrencesToRemove));
        }
        Preconditions.checkNotNull(multisetToModify);
        Preconditions.checkNotNull(occurrencesToRemove);
        boolean changed = false;
        Iterator<?> it = occurrencesToRemove.iterator();
        while (it.hasNext()) {
            changed |= multisetToModify.remove(it.next());
        }
        return changed;
    }

    @CanIgnoreReturnValue
    public static boolean removeOccurrences(Multiset<?> multisetToModify, Multiset<?> occurrencesToRemove) {
        Preconditions.checkNotNull(multisetToModify);
        Preconditions.checkNotNull(occurrencesToRemove);
        boolean changed = false;
        Iterator<? extends Multiset.Entry<?>> entryIterator = multisetToModify.entrySet().iterator();
        while (entryIterator.hasNext()) {
            Multiset.Entry<?> entry = entryIterator.next();
            int removeCount = occurrencesToRemove.count(entry.getElement());
            if (removeCount >= entry.getCount()) {
                entryIterator.remove();
                changed = true;
            } else if (removeCount > 0) {
                multisetToModify.remove(entry.getElement(), removeCount);
                changed = true;
            }
        }
        return changed;
    }

    /* loaded from: grasscutter.jar:com/google/common/collect/Multisets$AbstractEntry.class */
    static abstract class AbstractEntry<E> implements Multiset.Entry<E> {
        @Override // com.google.common.collect.Multiset.Entry
        public boolean equals(Object object) {
            if (!(object instanceof Multiset.Entry)) {
                return false;
            }
            Multiset.Entry<?> that = (Multiset.Entry) object;
            return getCount() == that.getCount() && Objects.equal(getElement(), that.getElement());
        }

        @Override // com.google.common.collect.Multiset.Entry
        public int hashCode() {
            E e = getElement();
            return (e == null ? 0 : e.hashCode()) ^ getCount();
        }

        @Override // com.google.common.collect.Multiset.Entry
        public String toString() {
            String text = String.valueOf(getElement());
            int n = getCount();
            return n == 1 ? text : text + " x " + n;
        }
    }

    /* access modifiers changed from: package-private */
    public static boolean equalsImpl(Multiset<?> multiset, Object object) {
        if (object == multiset) {
            return true;
        }
        if (!(object instanceof Multiset)) {
            return false;
        }
        Multiset<?> that = (Multiset) object;
        if (!(multiset.size() == that.size() && multiset.entrySet().size() == that.entrySet().size())) {
            return false;
        }
        for (Multiset.Entry<?> entry : that.entrySet()) {
            if (multiset.count(entry.getElement()) != entry.getCount()) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public static <E> boolean addAllImpl(Multiset<E> self, Collection<? extends E> elements) {
        Preconditions.checkNotNull(self);
        Preconditions.checkNotNull(elements);
        if (elements instanceof Multiset) {
            return addAllImpl((Multiset) self, cast(elements));
        }
        if (elements.isEmpty()) {
            return false;
        }
        return Iterators.addAll(self, elements.iterator());
    }

    private static <E> boolean addAllImpl(Multiset<E> self, Multiset<? extends E> elements) {
        if (elements.isEmpty()) {
            return false;
        }
        self.getClass();
        elements.forEachEntry(this::add);
        return true;
    }

    /* access modifiers changed from: package-private */
    public static boolean removeAllImpl(Multiset<?> self, Collection<?> elementsToRemove) {
        return self.elementSet().removeAll(elementsToRemove instanceof Multiset ? ((Multiset) elementsToRemove).elementSet() : elementsToRemove);
    }

    /* access modifiers changed from: package-private */
    public static boolean retainAllImpl(Multiset<?> self, Collection<?> elementsToRetain) {
        Preconditions.checkNotNull(elementsToRetain);
        return self.elementSet().retainAll(elementsToRetain instanceof Multiset ? ((Multiset) elementsToRetain).elementSet() : elementsToRetain);
    }

    /* access modifiers changed from: package-private */
    public static <E> int setCountImpl(Multiset<E> self, E element, int count) {
        CollectPreconditions.checkNonnegative(count, "count");
        int oldCount = self.count(element);
        int delta = count - oldCount;
        if (delta > 0) {
            self.add(element, delta);
        } else if (delta < 0) {
            self.remove(element, -delta);
        }
        return oldCount;
    }

    /* access modifiers changed from: package-private */
    public static <E> boolean setCountImpl(Multiset<E> self, E element, int oldCount, int newCount) {
        CollectPreconditions.checkNonnegative(oldCount, "oldCount");
        CollectPreconditions.checkNonnegative(newCount, "newCount");
        if (self.count(element) != oldCount) {
            return false;
        }
        self.setCount(element, newCount);
        return true;
    }

    /* access modifiers changed from: package-private */
    public static <E> Iterator<E> elementIterator(Iterator<Multiset.Entry<E>> entryIterator) {
        return new TransformedIterator<Multiset.Entry<E>, E>(entryIterator) { // from class: com.google.common.collect.Multisets.5
            @Override // com.google.common.collect.TransformedIterator
            /* bridge */ /* synthetic */ Object transform(Object obj) {
                return transform((Multiset.Entry<Object>) ((Multiset.Entry) obj));
            }

            /* JADX WARN: Type inference failed for: r0v1, types: [E, java.lang.Object] */
            E transform(Multiset.Entry<E> entry) {
                return entry.getElement();
            }
        };
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/google/common/collect/Multisets$ElementSet.class */
    public static abstract class ElementSet<E> extends Sets.ImprovedAbstractSet<E> {
        abstract Multiset<E> multiset();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        public abstract Iterator<E> iterator();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            multiset().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            return multiset().contains(o);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> c) {
            return multiset().containsAll(c);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return multiset().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            return multiset().remove(o, Integer.MAX_VALUE) > 0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return multiset().entrySet().size();
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/google/common/collect/Multisets$EntrySet.class */
    public static abstract class EntrySet<E> extends Sets.ImprovedAbstractSet<Multiset.Entry<E>> {
        abstract Multiset<E> multiset();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            if (!(o instanceof Multiset.Entry)) {
                return false;
            }
            Multiset.Entry<?> entry = (Multiset.Entry) o;
            return entry.getCount() > 0 && multiset().count(entry.getElement()) == entry.getCount();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object object) {
            if (!(object instanceof Multiset.Entry)) {
                return false;
            }
            Multiset.Entry<?> entry = (Multiset.Entry) object;
            Object obj = (E) entry.getElement();
            int entryCount = entry.getCount();
            if (entryCount != 0) {
                return multiset().setCount(obj, entryCount, 0);
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            multiset().clear();
        }
    }

    /* access modifiers changed from: package-private */
    public static <E> Iterator<E> iteratorImpl(Multiset<E> multiset) {
        return new MultisetIteratorImpl(multiset, multiset.entrySet().iterator());
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/google/common/collect/Multisets$MultisetIteratorImpl.class */
    public static final class MultisetIteratorImpl<E> implements Iterator<E> {
        private final Multiset<E> multiset;
        private final Iterator<Multiset.Entry<E>> entryIterator;
        private Multiset.Entry<E> currentEntry;
        private int laterCount;
        private int totalCount;
        private boolean canRemove;

        MultisetIteratorImpl(Multiset<E> multiset, Iterator<Multiset.Entry<E>> entryIterator) {
            this.multiset = multiset;
            this.entryIterator = entryIterator;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.laterCount > 0 || this.entryIterator.hasNext();
        }

        @Override // java.util.Iterator
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (this.laterCount == 0) {
                this.currentEntry = this.entryIterator.next();
                int count = this.currentEntry.getCount();
                this.laterCount = count;
                this.totalCount = count;
            }
            this.laterCount--;
            this.canRemove = true;
            return this.currentEntry.getElement();
        }

        @Override // java.util.Iterator
        public void remove() {
            CollectPreconditions.checkRemove(this.canRemove);
            if (this.totalCount == 1) {
                this.entryIterator.remove();
            } else {
                this.multiset.remove(this.currentEntry.getElement());
            }
            this.totalCount--;
            this.canRemove = false;
        }
    }

    /* access modifiers changed from: package-private */
    public static <E> Spliterator<E> spliteratorImpl(Multiset<E> multiset) {
        Spliterator<Multiset.Entry<E>> entrySpliterator = multiset.entrySet().spliterator();
        return CollectSpliterators.flatMap(entrySpliterator, entry -> {
            return Collections.nCopies(entry.getCount(), entry.getElement()).spliterator();
        }, 64 | (entrySpliterator.characteristics() & 1296), (long) multiset.size());
    }

    /* JADX WARN: Type inference failed for: r0v12, types: [long] */
    /* access modifiers changed from: package-private */
    public static int linearTimeSizeImpl(Multiset<?> multiset) {
        char c = 0;
        for (Multiset.Entry<?> entry : multiset.entrySet()) {
            c += (long) entry.getCount();
        }
        return Ints.saturatedCast(c);
    }

    /* access modifiers changed from: package-private */
    public static <T> Multiset<T> cast(Iterable<T> iterable) {
        return (Multiset) iterable;
    }

    @Beta
    public static <E> ImmutableMultiset<E> copyHighestCountFirst(Multiset<E> multiset) {
        Multiset.Entry<E>[] entries = (Multiset.Entry[]) multiset.entrySet().toArray(new Multiset.Entry[0]);
        Arrays.sort(entries, DecreasingCount.INSTANCE);
        return ImmutableMultiset.copyFromEntries(Arrays.asList(entries));
    }

    /* loaded from: grasscutter.jar:com/google/common/collect/Multisets$DecreasingCount.class */
    private static final class DecreasingCount implements Comparator<Multiset.Entry<?>> {
        static final DecreasingCount INSTANCE = new DecreasingCount();

        private DecreasingCount() {
        }

        public int compare(Multiset.Entry<?> entry1, Multiset.Entry<?> entry2) {
            return entry2.getCount() - entry1.getCount();
        }
    }

    /* loaded from: grasscutter.jar:com/google/common/collect/Multisets$ViewMultiset.class */
    private static abstract class ViewMultiset<E> extends AbstractMultiset<E> {
        private ViewMultiset() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
        public int size() {
            return Multisets.linearTimeSizeImpl(this);
        }

        @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            elementSet().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
        public Iterator<E> iterator() {
            return Multisets.iteratorImpl(this);
        }

        @Override // com.google.common.collect.AbstractMultiset
        int distinctElements() {
            return elementSet().size();
        }
    }
}
