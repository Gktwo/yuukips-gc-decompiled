package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableSet;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;
import java.util.stream.Collector;

@GwtCompatible(serializable = true, emulated = true)
/* loaded from: grasscutter.jar:com/google/common/collect/ImmutableSortedSet.class */
public abstract class ImmutableSortedSet<E> extends ImmutableSortedSetFauxverideShim<E> implements NavigableSet<E>, SortedIterable<E> {
    static final int SPLITERATOR_CHARACTERISTICS = 1301;
    final transient Comparator<? super E> comparator;
    @GwtIncompatible
    @LazyInit
    transient ImmutableSortedSet<E> descendingSet;

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
    public abstract UnmodifiableIterator<E> iterator();

    /* access modifiers changed from: package-private */
    public abstract ImmutableSortedSet<E> headSetImpl(E e, boolean z);

    abstract ImmutableSortedSet<E> subSetImpl(E e, boolean z, E e2, boolean z2);

    abstract ImmutableSortedSet<E> tailSetImpl(E e, boolean z);

    @GwtIncompatible
    abstract ImmutableSortedSet<E> createDescendingSet();

    @Override // java.util.NavigableSet
    @GwtIncompatible
    public abstract UnmodifiableIterator<E> descendingIterator();

    /* access modifiers changed from: package-private */
    public abstract int indexOf(Object obj);

    public static <E> Collector<E, ?, ImmutableSortedSet<E>> toImmutableSortedSet(Comparator<? super E> comparator) {
        return CollectCollectors.toImmutableSortedSet(comparator);
    }

    /* access modifiers changed from: package-private */
    public static <E> RegularImmutableSortedSet<E> emptySet(Comparator<? super E> comparator) {
        if (Ordering.natural().equals(comparator)) {
            return (RegularImmutableSortedSet<E>) RegularImmutableSortedSet.NATURAL_EMPTY_SET;
        }
        return new RegularImmutableSortedSet<>(ImmutableList.m1438of(), comparator);
    }

    /* renamed from: of */
    public static <E> ImmutableSortedSet<E> m1358of() {
        return RegularImmutableSortedSet.NATURAL_EMPTY_SET;
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    /* renamed from: of */
    public static ImmutableSortedSet m1357of(Comparable comparable) {
        return new RegularImmutableSortedSet(ImmutableList.m1437of(comparable), Ordering.natural());
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    /* renamed from: of */
    public static ImmutableSortedSet m1356of(Comparable comparable, Comparable comparable2) {
        return construct(Ordering.natural(), 2, comparable, comparable2);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    /* renamed from: of */
    public static ImmutableSortedSet m1355of(Comparable comparable, Comparable comparable2, Comparable comparable3) {
        return construct(Ordering.natural(), 3, comparable, comparable2, comparable3);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    /* renamed from: of */
    public static ImmutableSortedSet m1354of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4) {
        return construct(Ordering.natural(), 4, comparable, comparable2, comparable3, comparable4);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    /* renamed from: of */
    public static ImmutableSortedSet m1353of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4, Comparable comparable5) {
        return construct(Ordering.natural(), 5, comparable, comparable2, comparable3, comparable4, comparable5);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;TE;TE;[TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    /* renamed from: of */
    public static ImmutableSortedSet m1352of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4, Comparable comparable5, Comparable comparable6, Comparable... comparableArr) {
        Comparable[] contents = new Comparable[6 + comparableArr.length];
        contents[0] = comparable;
        contents[1] = comparable2;
        contents[2] = comparable3;
        contents[3] = comparable4;
        contents[4] = comparable5;
        contents[5] = comparable6;
        System.arraycopy(comparableArr, 0, contents, 6, comparableArr.length);
        return construct(Ordering.natural(), contents.length, contents);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>([TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet copyOf(Comparable[] comparableArr) {
        return construct(Ordering.natural(), comparableArr.length, (Object[]) comparableArr.clone());
    }

    public static <E> ImmutableSortedSet<E> copyOf(Iterable<? extends E> elements) {
        return copyOf(Ordering.natural(), elements);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Collection<? extends E> elements) {
        return copyOf((Comparator) Ordering.natural(), (Collection) elements);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Iterator<? extends E> elements) {
        return copyOf(Ordering.natural(), elements);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Comparator<? super E> comparator, Iterator<? extends E> elements) {
        return new Builder(comparator).addAll((Iterator) elements).build();
    }

    public static <E> ImmutableSortedSet<E> copyOf(Comparator<? super E> comparator, Iterable<? extends E> elements) {
        Preconditions.checkNotNull(comparator);
        if (SortedIterables.hasSameComparator(comparator, elements) && (elements instanceof ImmutableSortedSet)) {
            ImmutableSortedSet<E> original = (ImmutableSortedSet) elements;
            if (!original.isPartialView()) {
                return original;
            }
        }
        Object[] array = Iterables.toArray(elements);
        return construct(comparator, array.length, array);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Comparator<? super E> comparator, Collection<? extends E> elements) {
        return copyOf((Comparator) comparator, (Iterable) elements);
    }

    public static <E> ImmutableSortedSet<E> copyOfSorted(SortedSet<E> sortedSet) {
        Comparator<? super E> comparator = SortedIterables.comparator(sortedSet);
        ImmutableList<E> list = ImmutableList.copyOf((Collection) sortedSet);
        if (list.isEmpty()) {
            return emptySet(comparator);
        }
        return new RegularImmutableSortedSet(list, comparator);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: E[] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v18, resolved type: java.lang.Object[] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v19, resolved type: java.lang.Object[] */
    /* JADX WARN: Multi-variable type inference failed */
    static <E> ImmutableSortedSet<E> construct(Comparator<? super E> comparator, int n, E... contents) {
        if (n == 0) {
            return emptySet(comparator);
        }
        ObjectArrays.checkElementsNotNull(contents, n);
        Arrays.sort(contents, 0, n, comparator);
        int uniques = 1;
        for (int i = 1; i < n; i++) {
            Object obj = (Object) contents[i];
            if (comparator.compare(obj, (Object) contents[uniques - 1]) != 0) {
                uniques++;
                contents[uniques] = obj;
            }
        }
        Arrays.fill(contents, uniques, n, (Object) null);
        return new RegularImmutableSortedSet(ImmutableList.asImmutableList(contents, uniques), comparator);
    }

    public static <E> Builder<E> orderedBy(Comparator<E> comparator) {
        return new Builder<>(comparator);
    }

    public static <E extends Comparable<?>> Builder<E> reverseOrder() {
        return new Builder<>(Collections.reverseOrder());
    }

    public static <E extends Comparable<?>> Builder<E> naturalOrder() {
        return new Builder<>(Ordering.natural());
    }

    /* loaded from: grasscutter.jar:com/google/common/collect/ImmutableSortedSet$Builder.class */
    public static final class Builder<E> extends ImmutableSet.Builder<E> {
        private final Comparator<? super E> comparator;
        private E[] elements = (E[]) new Object[4];

        /* renamed from: n */
        private int f283n = 0;

        public Builder(Comparator<? super E> comparator) {
            super(true);
            this.comparator = (Comparator) Preconditions.checkNotNull(comparator);
        }

        @Override // com.google.common.collect.ImmutableSet.Builder
        void copy() {
            this.elements = (E[]) Arrays.copyOf(this.elements, this.elements.length);
        }

        private void sortAndDedup() {
            if (this.f283n != 0) {
                Arrays.sort(this.elements, 0, this.f283n, this.comparator);
                int unique = 1;
                for (int i = 1; i < this.f283n; i++) {
                    int cmp = this.comparator.compare((Object) this.elements[unique - 1], (Object) this.elements[i]);
                    if (cmp < 0) {
                        unique++;
                        this.elements[unique] = this.elements[i];
                    } else if (cmp > 0) {
                        throw new AssertionError("Comparator " + this.comparator + " compare method violates its contract");
                    }
                }
                Arrays.fill(this.elements, unique, this.f283n, (Object) null);
                this.f283n = unique;
            }
        }

        @Override // com.google.common.collect.ImmutableSet.Builder, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> add(E element) {
            Preconditions.checkNotNull(element);
            copyIfNecessary();
            if (this.f283n == this.elements.length) {
                sortAndDedup();
                int newLength = ImmutableCollection.Builder.expandedCapacity(this.f283n, this.f283n + 1);
                if (newLength > this.elements.length) {
                    this.elements = (E[]) Arrays.copyOf(this.elements, newLength);
                }
            }
            E[] eArr = this.elements;
            int i = this.f283n;
            this.f283n = i + 1;
            eArr[i] = element;
            return this;
        }

        @Override // com.google.common.collect.ImmutableSet.Builder, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> add(E... elements) {
            ObjectArrays.checkElementsNotNull(elements);
            for (E e : elements) {
                add((Builder<E>) e);
            }
            return this;
        }

        @Override // com.google.common.collect.ImmutableSet.Builder, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> addAll(Iterable<? extends E> elements) {
            addAll((Iterable) elements);
            return this;
        }

        @Override // com.google.common.collect.ImmutableSet.Builder, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> addAll(Iterator<? extends E> elements) {
            addAll((Iterator) elements);
            return this;
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableSet.Builder
        @CanIgnoreReturnValue
        public Builder<E> combine(ImmutableSet.Builder<E> builder) {
            copyIfNecessary();
            Builder<E> other = (Builder) builder;
            for (int i = 0; i < other.f283n; i++) {
                add((Builder<E>) other.elements[i]);
            }
            return this;
        }

        @Override // com.google.common.collect.ImmutableSet.Builder, com.google.common.collect.ImmutableCollection.Builder
        public ImmutableSortedSet<E> build() {
            sortAndDedup();
            if (this.f283n == 0) {
                return ImmutableSortedSet.emptySet(this.comparator);
            }
            this.forceCopy = true;
            return new RegularImmutableSortedSet(ImmutableList.asImmutableList(this.elements, this.f283n), this.comparator);
        }
    }

    int unsafeCompare(Object a, Object b) {
        return unsafeCompare(this.comparator, a, b);
    }

    static int unsafeCompare(Comparator<?> comparator, Object a, Object b) {
        return comparator.compare(a, b);
    }

    /* access modifiers changed from: package-private */
    public ImmutableSortedSet(Comparator<? super E> comparator) {
        this.comparator = comparator;
    }

    @Override // java.util.SortedSet, com.google.common.collect.SortedIterable
    public Comparator<? super E> comparator() {
        return this.comparator;
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    public ImmutableSortedSet<E> headSet(E toElement) {
        return headSet((ImmutableSortedSet<E>) toElement, false);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.google.common.collect.ImmutableSortedSet<E> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableSet
    @GwtIncompatible
    public ImmutableSortedSet<E> headSet(E toElement, boolean inclusive) {
        return headSetImpl(Preconditions.checkNotNull(toElement), inclusive);
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    public ImmutableSortedSet<E> subSet(E fromElement, E toElement) {
        return subSet((boolean) fromElement, true, (boolean) toElement, false);
    }

    @Override // java.util.NavigableSet
    @GwtIncompatible
    public ImmutableSortedSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive) {
        Preconditions.checkNotNull(fromElement);
        Preconditions.checkNotNull(toElement);
        Preconditions.checkArgument(this.comparator.compare(fromElement, toElement) <= 0);
        return subSetImpl(fromElement, fromInclusive, toElement, toInclusive);
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    public ImmutableSortedSet<E> tailSet(E fromElement) {
        return tailSet((ImmutableSortedSet<E>) fromElement, true);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.google.common.collect.ImmutableSortedSet<E> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableSet
    @GwtIncompatible
    public ImmutableSortedSet<E> tailSet(E fromElement, boolean inclusive) {
        return tailSetImpl(Preconditions.checkNotNull(fromElement), inclusive);
    }

    @Override // java.util.NavigableSet
    @GwtIncompatible
    public E lower(E e) {
        return (E) Iterators.getNext(headSet((ImmutableSortedSet<E>) e, false).descendingIterator(), null);
    }

    @Override // java.util.NavigableSet
    @GwtIncompatible
    public E floor(E e) {
        return (E) Iterators.getNext(headSet((ImmutableSortedSet<E>) e, true).descendingIterator(), null);
    }

    @Override // java.util.NavigableSet
    @GwtIncompatible
    public E ceiling(E e) {
        return (E) Iterables.getFirst(tailSet((ImmutableSortedSet<E>) e, true), null);
    }

    @Override // java.util.NavigableSet
    @GwtIncompatible
    public E higher(E e) {
        return (E) Iterables.getFirst(tailSet((ImmutableSortedSet<E>) e, false), null);
    }

    @Override // java.util.SortedSet
    public E first() {
        return iterator().next();
    }

    @Override // java.util.SortedSet
    public E last() {
        return descendingIterator().next();
    }

    @Override // java.util.NavigableSet
    @CanIgnoreReturnValue
    @GwtIncompatible
    @Deprecated
    public final E pollFirst() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableSet
    @CanIgnoreReturnValue
    @GwtIncompatible
    @Deprecated
    public final E pollLast() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableSet
    @GwtIncompatible
    public ImmutableSortedSet<E> descendingSet() {
        ImmutableSortedSet<E> result = this.descendingSet;
        if (result == null) {
            ImmutableSortedSet<E> createDescendingSet = createDescendingSet();
            this.descendingSet = createDescendingSet;
            result = createDescendingSet;
            result.descendingSet = this;
        }
        return result;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable
    public Spliterator<E> spliterator() {
        return new Spliterators.AbstractSpliterator<E>((long) size(), 1365) { // from class: com.google.common.collect.ImmutableSortedSet.1
            final UnmodifiableIterator<E> iterator;

            {
                this.iterator = ImmutableSortedSet.this.iterator();
            }

            /* JADX DEBUG: Type inference failed for r1v2. Raw type applied. Possible types: E, ? super E */
            @Override // java.util.Spliterator
            public boolean tryAdvance(Consumer<? super E> action) {
                if (!this.iterator.hasNext()) {
                    return false;
                }
                action.accept((E) this.iterator.next());
                return true;
            }

            @Override // java.util.Spliterator
            public Comparator<? super E> getComparator() {
                return ImmutableSortedSet.this.comparator;
            }
        };
    }

    /* loaded from: grasscutter.jar:com/google/common/collect/ImmutableSortedSet$SerializedForm.class */
    private static class SerializedForm<E> implements Serializable {
        final Comparator<? super E> comparator;
        final Object[] elements;
        private static final long serialVersionUID = 0;

        public SerializedForm(Comparator<? super E> comparator, Object[] elements) {
            this.comparator = comparator;
            this.elements = elements;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.collect.ImmutableSortedSet$Builder */
        /* JADX WARN: Multi-variable type inference failed */
        Object readResolve() {
            return new Builder(this.comparator).add(this.elements).build();
        }
    }

    private void readObject(ObjectInputStream unused) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    Object writeReplace() {
        return new SerializedForm(this.comparator, toArray());
    }
}
