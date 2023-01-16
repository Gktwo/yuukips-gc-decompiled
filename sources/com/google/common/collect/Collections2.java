package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.math.IntMath;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;
import p001ch.qos.logback.core.util.FileSize;

@GwtCompatible
/* loaded from: grasscutter.jar:com/google/common/collect/Collections2.class */
public final class Collections2 {
    private Collections2() {
    }

    public static <E> Collection<E> filter(Collection<E> unfiltered, Predicate<? super E> predicate) {
        if (unfiltered instanceof FilteredCollection) {
            return ((FilteredCollection) unfiltered).createCombined(predicate);
        }
        return new FilteredCollection((Collection) Preconditions.checkNotNull(unfiltered), (Predicate) Preconditions.checkNotNull(predicate));
    }

    /* access modifiers changed from: package-private */
    public static boolean safeContains(Collection<?> collection, Object object) {
        Preconditions.checkNotNull(collection);
        try {
            return collection.contains(object);
        } catch (ClassCastException | NullPointerException e) {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public static boolean safeRemove(Collection<?> collection, Object object) {
        Preconditions.checkNotNull(collection);
        try {
            return collection.remove(object);
        } catch (ClassCastException | NullPointerException e) {
            return false;
        }
    }

    /* loaded from: grasscutter.jar:com/google/common/collect/Collections2$FilteredCollection.class */
    static class FilteredCollection<E> extends AbstractCollection<E> {
        final Collection<E> unfiltered;
        final Predicate<? super E> predicate;

        /* access modifiers changed from: package-private */
        public FilteredCollection(Collection<E> unfiltered, Predicate<? super E> predicate) {
            this.unfiltered = unfiltered;
            this.predicate = predicate;
        }

        FilteredCollection<E> createCombined(Predicate<? super E> newPredicate) {
            return new FilteredCollection<>(this.unfiltered, Predicates.and(this.predicate, newPredicate));
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean add(E element) {
            Preconditions.checkArgument(this.predicate.apply(element));
            return this.unfiltered.add(element);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection<? extends E> collection) {
            Iterator<? extends E> it = collection.iterator();
            while (it.hasNext()) {
                Preconditions.checkArgument(this.predicate.apply(it.next()));
            }
            return this.unfiltered.addAll(collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            Iterables.removeIf(this.unfiltered, this.predicate);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object element) {
            if (Collections2.safeContains(this.unfiltered, element)) {
                return this.predicate.apply(element);
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            return Collections2.containsAllImpl(this, collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return !Iterables.any(this.unfiltered, this.predicate);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<E> iterator() {
            return Iterators.filter(this.unfiltered.iterator(), this.predicate);
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Spliterator<E> spliterator() {
            return CollectSpliterators.filter(this.unfiltered.spliterator(), this.predicate);
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super E> action) {
            Preconditions.checkNotNull(action);
            this.unfiltered.forEach(e -> {
                if (this.predicate.test(action)) {
                    action.accept(action);
                }
            });
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object element) {
            return contains(element) && this.unfiltered.remove(element);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            collection.getClass();
            return removeIf(this::contains);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            return removeIf(element -> {
                return !collection.contains(element);
            });
        }

        @Override // java.util.Collection
        public boolean removeIf(java.util.function.Predicate<? super E> filter) {
            Preconditions.checkNotNull(filter);
            return this.unfiltered.removeIf(element -> {
                return this.predicate.apply(filter) && filter.test(filter);
            });
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            int size = 0;
            for (E e : this.unfiltered) {
                if (this.predicate.apply(e)) {
                    size++;
                }
            }
            return size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return Lists.newArrayList(iterator()).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <T> T[] toArray(T[] array) {
            return (T[]) Lists.newArrayList(iterator()).toArray(array);
        }
    }

    public static <F, T> Collection<T> transform(Collection<F> fromCollection, Function<? super F, T> function) {
        return new TransformedCollection(fromCollection, function);
    }

    /* loaded from: grasscutter.jar:com/google/common/collect/Collections2$TransformedCollection.class */
    static class TransformedCollection<F, T> extends AbstractCollection<T> {
        final Collection<F> fromCollection;
        final Function<? super F, ? extends T> function;

        TransformedCollection(Collection<F> fromCollection, Function<? super F, ? extends T> function) {
            this.fromCollection = (Collection) Preconditions.checkNotNull(fromCollection);
            this.function = (Function) Preconditions.checkNotNull(function);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.fromCollection.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.fromCollection.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<T> iterator() {
            return Iterators.transform(this.fromCollection.iterator(), this.function);
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Spliterator<T> spliterator() {
            return CollectSpliterators.map(this.fromCollection.spliterator(), this.function);
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super T> action) {
            Preconditions.checkNotNull(action);
            this.fromCollection.forEach(f -> {
                action.accept(this.function.apply(action));
            });
        }

        @Override // java.util.Collection
        public boolean removeIf(java.util.function.Predicate<? super T> filter) {
            Preconditions.checkNotNull(filter);
            return this.fromCollection.removeIf(element -> {
                return filter.test(this.function.apply(filter));
            });
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.fromCollection.size();
        }
    }

    /* access modifiers changed from: package-private */
    public static boolean containsAllImpl(Collection<?> self, Collection<?> c) {
        Iterator<?> it = c.iterator();
        while (it.hasNext()) {
            if (!self.contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public static String toStringImpl(Collection<?> collection) {
        StringBuilder sb = newStringBuilderForCollection(collection.size()).append('[');
        boolean first = true;
        for (Object o : collection) {
            if (!first) {
                sb.append(", ");
            }
            first = false;
            if (o == collection) {
                sb.append("(this Collection)");
            } else {
                sb.append(o);
            }
        }
        return sb.append(']').toString();
    }

    /* access modifiers changed from: package-private */
    public static StringBuilder newStringBuilderForCollection(int size) {
        CollectPreconditions.checkNonnegative(size, "size");
        return new StringBuilder((int) Math.min(((long) size) * 8, (long) FileSize.GB_COEFFICIENT));
    }

    /* access modifiers changed from: package-private */
    public static <T> Collection<T> cast(Iterable<T> iterable) {
        return (Collection) iterable;
    }

    @Beta
    public static <E extends Comparable<? super E>> Collection<List<E>> orderedPermutations(Iterable<E> elements) {
        return orderedPermutations(elements, Ordering.natural());
    }

    @Beta
    public static <E> Collection<List<E>> orderedPermutations(Iterable<E> elements, Comparator<? super E> comparator) {
        return new OrderedPermutationCollection(elements, comparator);
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/common/collect/Collections2$OrderedPermutationCollection.class */
    public static final class OrderedPermutationCollection<E> extends AbstractCollection<List<E>> {
        final ImmutableList<E> inputList;
        final Comparator<? super E> comparator;
        final int size;

        OrderedPermutationCollection(Iterable<E> input, Comparator<? super E> comparator) {
            this.inputList = ImmutableList.sortedCopyOf(comparator, input);
            this.comparator = comparator;
            this.size = calculateSize(this.inputList, comparator);
        }

        private static <E> int calculateSize(List<E> sortedInputList, Comparator<? super E> comparator) {
            int permutations = 1;
            int n = 1;
            int r = 1;
            while (n < sortedInputList.size()) {
                if (comparator.compare(sortedInputList.get(n - 1), sortedInputList.get(n)) < 0) {
                    permutations = IntMath.saturatedMultiply(permutations, IntMath.binomial(n, r));
                    r = 0;
                    if (permutations == Integer.MAX_VALUE) {
                        return Integer.MAX_VALUE;
                    }
                }
                n++;
                r++;
            }
            return IntMath.saturatedMultiply(permutations, IntMath.binomial(n, r));
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<List<E>> iterator() {
            return new OrderedPermutationIterator(this.inputList, this.comparator);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            if (!(obj instanceof List)) {
                return false;
            }
            return Collections2.isPermutation(this.inputList, (List) obj);
        }

        @Override // java.util.AbstractCollection, java.lang.Object
        public String toString() {
            return "orderedPermutationCollection(" + this.inputList + ")";
        }
    }

    /* loaded from: grasscutter.jar:com/google/common/collect/Collections2$OrderedPermutationIterator.class */
    private static final class OrderedPermutationIterator<E> extends AbstractIterator<List<E>> {
        List<E> nextPermutation;
        final Comparator<? super E> comparator;

        OrderedPermutationIterator(List<E> list, Comparator<? super E> comparator) {
            this.nextPermutation = Lists.newArrayList(list);
            this.comparator = comparator;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.common.collect.AbstractIterator
        public List<E> computeNext() {
            if (this.nextPermutation == null) {
                return endOfData();
            }
            ImmutableList<E> next = ImmutableList.copyOf((Collection) this.nextPermutation);
            calculateNextPermutation();
            return next;
        }

        void calculateNextPermutation() {
            int j = findNextJ();
            if (j == -1) {
                this.nextPermutation = null;
                return;
            }
            Collections.swap(this.nextPermutation, j, findNextL(j));
            Collections.reverse(this.nextPermutation.subList(j + 1, this.nextPermutation.size()));
        }

        /* JADX DEBUG: Type inference failed for r1v3. Raw type applied. Possible types: E, ? super E */
        /* JADX DEBUG: Type inference failed for r2v3. Raw type applied. Possible types: E, ? super E */
        int findNextJ() {
            for (int k = this.nextPermutation.size() - 2; k >= 0; k--) {
                if (this.comparator.compare((E) this.nextPermutation.get(k), (E) this.nextPermutation.get(k + 1)) < 0) {
                    return k;
                }
            }
            return -1;
        }

        /* JADX DEBUG: Type inference failed for r2v3. Raw type applied. Possible types: E, ? super E */
        int findNextL(int j) {
            E ak = this.nextPermutation.get(j);
            for (int l = this.nextPermutation.size() - 1; l > j; l--) {
                if (this.comparator.compare(ak, (E) this.nextPermutation.get(l)) < 0) {
                    return l;
                }
            }
            throw new AssertionError("this statement should be unreachable");
        }
    }

    @Beta
    public static <E> Collection<List<E>> permutations(Collection<E> elements) {
        return new PermutationCollection(ImmutableList.copyOf((Collection) elements));
    }

    /* loaded from: grasscutter.jar:com/google/common/collect/Collections2$PermutationCollection.class */
    private static final class PermutationCollection<E> extends AbstractCollection<List<E>> {
        final ImmutableList<E> inputList;

        PermutationCollection(ImmutableList<E> input) {
            this.inputList = input;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return IntMath.factorial(this.inputList.size());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<List<E>> iterator() {
            return new PermutationIterator(this.inputList);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            if (!(obj instanceof List)) {
                return false;
            }
            return Collections2.isPermutation(this.inputList, (List) obj);
        }

        @Override // java.util.AbstractCollection, java.lang.Object
        public String toString() {
            return "permutations(" + this.inputList + ")";
        }
    }

    /* loaded from: grasscutter.jar:com/google/common/collect/Collections2$PermutationIterator.class */
    private static class PermutationIterator<E> extends AbstractIterator<List<E>> {
        final List<E> list;

        /* renamed from: c */
        final int[] f278c;

        /* renamed from: o */
        final int[] f279o;

        /* renamed from: j */
        int f280j = Integer.MAX_VALUE;

        PermutationIterator(List<E> list) {
            this.list = new ArrayList(list);
            int n = list.size();
            this.f278c = new int[n];
            this.f279o = new int[n];
            Arrays.fill(this.f278c, 0);
            Arrays.fill(this.f279o, 1);
        }

        /* access modifiers changed from: protected */
        @Override // com.google.common.collect.AbstractIterator
        public List<E> computeNext() {
            if (this.f280j <= 0) {
                return endOfData();
            }
            ImmutableList<E> next = ImmutableList.copyOf((Collection) this.list);
            calculateNextPermutation();
            return next;
        }

        void calculateNextPermutation() {
            this.f280j = this.list.size() - 1;
            int s = 0;
            if (this.f280j != -1) {
                while (true) {
                    int q = this.f278c[this.f280j] + this.f279o[this.f280j];
                    if (q < 0) {
                        switchDirection();
                    } else if (q != this.f280j + 1) {
                        Collections.swap(this.list, (this.f280j - this.f278c[this.f280j]) + s, (this.f280j - q) + s);
                        this.f278c[this.f280j] = q;
                        return;
                    } else if (this.f280j != 0) {
                        s++;
                        switchDirection();
                    } else {
                        return;
                    }
                }
            }
        }

        void switchDirection() {
            this.f279o[this.f280j] = -this.f279o[this.f280j];
            this.f280j--;
        }
    }

    /* access modifiers changed from: private */
    public static boolean isPermutation(List<?> first, List<?> second) {
        if (first.size() != second.size()) {
            return false;
        }
        return HashMultiset.create(first).equals(HashMultiset.create(second));
    }
}
