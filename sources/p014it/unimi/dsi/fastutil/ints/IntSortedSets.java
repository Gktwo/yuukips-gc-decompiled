package p014it.unimi.dsi.fastutil.ints;

import java.io.Serializable;
import java.util.Comparator;
import java.util.NoSuchElementException;
import p014it.unimi.dsi.fastutil.ints.IntSets;

/* renamed from: it.unimi.dsi.fastutil.ints.IntSortedSets */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntSortedSets.class */
public final class IntSortedSets {
    public static final EmptySet EMPTY_SET = new EmptySet();

    private IntSortedSets() {
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.IntSortedSets$EmptySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntSortedSets$EmptySet.class */
    public static class EmptySet extends IntSets.EmptySet implements IntSortedSet, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        public IntBidirectionalIterator iterator(int from) {
            return IntIterators.EMPTY_ITERATOR;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        public IntSortedSet subSet(int from, int to) {
            return IntSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        public IntSortedSet headSet(int from) {
            return IntSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        public IntSortedSet tailSet(int to) {
            return IntSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        public int firstInt() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        public int lastInt() {
            throw new NoSuchElementException();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet, java.util.SortedSet
        public Comparator<? super Integer> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        @Deprecated
        public IntSortedSet subSet(Integer from, Integer to) {
            return IntSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        @Deprecated
        public IntSortedSet headSet(Integer from) {
            return IntSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        @Deprecated
        public IntSortedSet tailSet(Integer to) {
            return IntSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet, java.util.SortedSet
        @Deprecated
        public Integer first() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet, java.util.SortedSet
        @Deprecated
        public Integer last() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSets.EmptySet, java.lang.Object
        public Object clone() {
            return IntSortedSets.EMPTY_SET;
        }

        private Object readResolve() {
            return IntSortedSets.EMPTY_SET;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.IntSortedSets$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntSortedSets$Singleton.class */
    public static class Singleton extends IntSets.Singleton implements IntSortedSet, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        final IntComparator comparator;

        @Override // p014it.unimi.dsi.fastutil.ints.IntSets.Singleton, p014it.unimi.dsi.fastutil.ints.AbstractIntSet, p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
        public /* bridge */ /* synthetic */ IntBidirectionalIterator iterator() {
            return iterator();
        }

        protected Singleton(int element, IntComparator comparator) {
            super(element);
            this.comparator = comparator;
        }

        Singleton(int element) {
            this(element, null);
        }

        final int compare(int k1, int k2) {
            return this.comparator == null ? Integer.compare(k1, k2) : this.comparator.compare(k1, k2);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        public IntBidirectionalIterator iterator(int from) {
            IntBidirectionalIterator i = iterator();
            if (compare(this.element, from) <= 0) {
                i.nextInt();
            }
            return i;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet, java.util.SortedSet
        public Comparator<? super Integer> comparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSets.Singleton, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
        public IntSpliterator spliterator() {
            return IntSpliterators.singleton(this.element, this.comparator);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        public IntSortedSet subSet(int from, int to) {
            return (compare(from, this.element) > 0 || compare(this.element, to) >= 0) ? IntSortedSets.EMPTY_SET : this;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        public IntSortedSet headSet(int to) {
            return compare(this.element, to) < 0 ? this : IntSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        public IntSortedSet tailSet(int from) {
            return compare(from, this.element) <= 0 ? this : IntSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        public int firstInt() {
            return this.element;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        public int lastInt() {
            return this.element;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        @Deprecated
        public IntSortedSet subSet(Integer from, Integer to) {
            return subSet(from.intValue(), to.intValue());
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        @Deprecated
        public IntSortedSet headSet(Integer to) {
            return headSet(to.intValue());
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        @Deprecated
        public IntSortedSet tailSet(Integer from) {
            return tailSet(from.intValue());
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet, java.util.SortedSet
        @Deprecated
        public Integer first() {
            return Integer.valueOf(this.element);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet, java.util.SortedSet
        @Deprecated
        public Integer last() {
            return Integer.valueOf(this.element);
        }
    }

    public static IntSortedSet singleton(int element) {
        return new Singleton(element);
    }

    public static IntSortedSet singleton(int element, IntComparator comparator) {
        return new Singleton(element, comparator);
    }

    public static IntSortedSet singleton(Object element) {
        return new Singleton(((Integer) element).intValue());
    }

    public static IntSortedSet singleton(Object element, IntComparator comparator) {
        return new Singleton(((Integer) element).intValue(), comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.IntSortedSets$SynchronizedSortedSet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntSortedSets$SynchronizedSortedSet.class */
    public static class SynchronizedSortedSet extends IntSets.SynchronizedSet implements IntSortedSet, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final IntSortedSet sortedSet;

        protected SynchronizedSortedSet(IntSortedSet s, Object sync) {
            super(s, sync);
            this.sortedSet = s;
        }

        protected SynchronizedSortedSet(IntSortedSet s) {
            super(s);
            this.sortedSet = s;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet, java.util.SortedSet
        public Comparator<? super Integer> comparator() {
            Comparator<? super Integer> comparator;
            synchronized (this.sync) {
                comparator = this.sortedSet.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        public IntSortedSet subSet(int from, int to) {
            return new SynchronizedSortedSet(this.sortedSet.subSet(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        public IntSortedSet headSet(int to) {
            return new SynchronizedSortedSet(this.sortedSet.headSet(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        public IntSortedSet tailSet(int from) {
            return new SynchronizedSortedSet(this.sortedSet.tailSet(from), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSets.SynchronizedSet, p014it.unimi.dsi.fastutil.ints.IntCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.ints.IntCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntIterable
        public IntBidirectionalIterator iterator() {
            return this.sortedSet.iterator();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        public IntBidirectionalIterator iterator(int from) {
            return this.sortedSet.iterator(from);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        public int firstInt() {
            int firstInt;
            synchronized (this.sync) {
                firstInt = this.sortedSet.firstInt();
            }
            return firstInt;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        public int lastInt() {
            int lastInt;
            synchronized (this.sync) {
                lastInt = this.sortedSet.lastInt();
            }
            return lastInt;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet, java.util.SortedSet
        @Deprecated
        public Integer first() {
            Integer first;
            synchronized (this.sync) {
                first = this.sortedSet.first();
            }
            return first;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet, java.util.SortedSet
        @Deprecated
        public Integer last() {
            Integer last;
            synchronized (this.sync) {
                last = this.sortedSet.last();
            }
            return last;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        @Deprecated
        public IntSortedSet subSet(Integer from, Integer to) {
            return new SynchronizedSortedSet(this.sortedSet.subSet(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        @Deprecated
        public IntSortedSet headSet(Integer to) {
            return new SynchronizedSortedSet(this.sortedSet.headSet(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        @Deprecated
        public IntSortedSet tailSet(Integer from) {
            return new SynchronizedSortedSet(this.sortedSet.tailSet(from), this.sync);
        }
    }

    public static IntSortedSet synchronize(IntSortedSet s) {
        return new SynchronizedSortedSet(s);
    }

    public static IntSortedSet synchronize(IntSortedSet s, Object sync) {
        return new SynchronizedSortedSet(s, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.IntSortedSets$UnmodifiableSortedSet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntSortedSets$UnmodifiableSortedSet.class */
    public static class UnmodifiableSortedSet extends IntSets.UnmodifiableSet implements IntSortedSet, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final IntSortedSet sortedSet;

        protected UnmodifiableSortedSet(IntSortedSet s) {
            super(s);
            this.sortedSet = s;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet, java.util.SortedSet
        public Comparator<? super Integer> comparator() {
            return this.sortedSet.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        public IntSortedSet subSet(int from, int to) {
            return new UnmodifiableSortedSet(this.sortedSet.subSet(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        public IntSortedSet headSet(int to) {
            return new UnmodifiableSortedSet(this.sortedSet.headSet(to));
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        public IntSortedSet tailSet(int from) {
            return new UnmodifiableSortedSet(this.sortedSet.tailSet(from));
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSets.UnmodifiableSet, p014it.unimi.dsi.fastutil.ints.IntCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.ints.IntCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntIterable
        public IntBidirectionalIterator iterator() {
            return IntIterators.unmodifiable(this.sortedSet.iterator());
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        public IntBidirectionalIterator iterator(int from) {
            return IntIterators.unmodifiable(this.sortedSet.iterator(from));
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        public int firstInt() {
            return this.sortedSet.firstInt();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        public int lastInt() {
            return this.sortedSet.lastInt();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet, java.util.SortedSet
        @Deprecated
        public Integer first() {
            return this.sortedSet.first();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet, java.util.SortedSet
        @Deprecated
        public Integer last() {
            return this.sortedSet.last();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        @Deprecated
        public IntSortedSet subSet(Integer from, Integer to) {
            return new UnmodifiableSortedSet(this.sortedSet.subSet(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        @Deprecated
        public IntSortedSet headSet(Integer to) {
            return new UnmodifiableSortedSet(this.sortedSet.headSet(to));
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        @Deprecated
        public IntSortedSet tailSet(Integer from) {
            return new UnmodifiableSortedSet(this.sortedSet.tailSet(from));
        }
    }

    public static IntSortedSet unmodifiable(IntSortedSet s) {
        return new UnmodifiableSortedSet(s);
    }
}
