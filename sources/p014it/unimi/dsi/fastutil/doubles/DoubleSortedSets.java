package p014it.unimi.dsi.fastutil.doubles;

import java.io.Serializable;
import java.util.Comparator;
import java.util.NoSuchElementException;
import p014it.unimi.dsi.fastutil.doubles.DoubleSets;

/* renamed from: it.unimi.dsi.fastutil.doubles.DoubleSortedSets */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleSortedSets.class */
public final class DoubleSortedSets {
    public static final EmptySet EMPTY_SET = new EmptySet();

    private DoubleSortedSets() {
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.DoubleSortedSets$EmptySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleSortedSets$EmptySet.class */
    public static class EmptySet extends DoubleSets.EmptySet implements DoubleSortedSet, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
        public DoubleBidirectionalIterator iterator(double from) {
            return DoubleIterators.EMPTY_ITERATOR;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
        public DoubleSortedSet subSet(double from, double to) {
            return DoubleSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
        public DoubleSortedSet headSet(double from) {
            return DoubleSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
        public DoubleSortedSet tailSet(double to) {
            return DoubleSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
        public double firstDouble() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
        public double lastDouble() {
            throw new NoSuchElementException();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet, java.util.SortedSet
        public Comparator<? super Double> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
        @Deprecated
        public DoubleSortedSet subSet(Double from, Double to) {
            return DoubleSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
        @Deprecated
        public DoubleSortedSet headSet(Double from) {
            return DoubleSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
        @Deprecated
        public DoubleSortedSet tailSet(Double to) {
            return DoubleSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet, java.util.SortedSet
        @Deprecated
        public Double first() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet, java.util.SortedSet
        @Deprecated
        public Double last() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSets.EmptySet, java.lang.Object
        public Object clone() {
            return DoubleSortedSets.EMPTY_SET;
        }

        private Object readResolve() {
            return DoubleSortedSets.EMPTY_SET;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.DoubleSortedSets$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleSortedSets$Singleton.class */
    public static class Singleton extends DoubleSets.Singleton implements DoubleSortedSet, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        final DoubleComparator comparator;

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSets.Singleton, p014it.unimi.dsi.fastutil.doubles.AbstractDoubleSet, p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public /* bridge */ /* synthetic */ DoubleBidirectionalIterator iterator() {
            return iterator();
        }

        protected Singleton(double element, DoubleComparator comparator) {
            super(element);
            this.comparator = comparator;
        }

        Singleton(double element) {
            this(element, null);
        }

        final int compare(double k1, double k2) {
            return this.comparator == null ? Double.compare(k1, k2) : this.comparator.compare(k1, k2);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
        public DoubleBidirectionalIterator iterator(double from) {
            DoubleBidirectionalIterator i = iterator();
            if (compare(this.element, from) <= 0) {
                i.nextDouble();
            }
            return i;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet, java.util.SortedSet
        public Comparator<? super Double> comparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSets.Singleton, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public DoubleSpliterator spliterator() {
            return DoubleSpliterators.singleton(this.element, this.comparator);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
        public DoubleSortedSet subSet(double from, double to) {
            return (compare(from, this.element) > 0 || compare(this.element, to) >= 0) ? DoubleSortedSets.EMPTY_SET : this;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
        public DoubleSortedSet headSet(double to) {
            return compare(this.element, to) < 0 ? this : DoubleSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
        public DoubleSortedSet tailSet(double from) {
            return compare(from, this.element) <= 0 ? this : DoubleSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
        public double firstDouble() {
            return this.element;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
        public double lastDouble() {
            return this.element;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
        @Deprecated
        public DoubleSortedSet subSet(Double from, Double to) {
            return subSet(from.doubleValue(), to.doubleValue());
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
        @Deprecated
        public DoubleSortedSet headSet(Double to) {
            return headSet(to.doubleValue());
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
        @Deprecated
        public DoubleSortedSet tailSet(Double from) {
            return tailSet(from.doubleValue());
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet, java.util.SortedSet
        @Deprecated
        public Double first() {
            return Double.valueOf(this.element);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet, java.util.SortedSet
        @Deprecated
        public Double last() {
            return Double.valueOf(this.element);
        }
    }

    public static DoubleSortedSet singleton(double element) {
        return new Singleton(element);
    }

    public static DoubleSortedSet singleton(double element, DoubleComparator comparator) {
        return new Singleton(element, comparator);
    }

    public static DoubleSortedSet singleton(Object element) {
        return new Singleton(((Double) element).doubleValue());
    }

    public static DoubleSortedSet singleton(Object element, DoubleComparator comparator) {
        return new Singleton(((Double) element).doubleValue(), comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.DoubleSortedSets$SynchronizedSortedSet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleSortedSets$SynchronizedSortedSet.class */
    public static class SynchronizedSortedSet extends DoubleSets.SynchronizedSet implements DoubleSortedSet, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final DoubleSortedSet sortedSet;

        protected SynchronizedSortedSet(DoubleSortedSet s, Object sync) {
            super(s, sync);
            this.sortedSet = s;
        }

        protected SynchronizedSortedSet(DoubleSortedSet s) {
            super(s);
            this.sortedSet = s;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet, java.util.SortedSet
        public Comparator<? super Double> comparator() {
            Comparator<? super Double> comparator;
            synchronized (this.sync) {
                comparator = this.sortedSet.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
        public DoubleSortedSet subSet(double from, double to) {
            return new SynchronizedSortedSet(this.sortedSet.subSet(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
        public DoubleSortedSet headSet(double to) {
            return new SynchronizedSortedSet(this.sortedSet.headSet(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
        public DoubleSortedSet tailSet(double from) {
            return new SynchronizedSortedSet(this.sortedSet.tailSet(from), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSets.SynchronizedSet, p014it.unimi.dsi.fastutil.doubles.DoubleCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public DoubleBidirectionalIterator iterator() {
            return this.sortedSet.iterator();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
        public DoubleBidirectionalIterator iterator(double from) {
            return this.sortedSet.iterator(from);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
        public double firstDouble() {
            double firstDouble;
            synchronized (this.sync) {
                firstDouble = this.sortedSet.firstDouble();
            }
            return firstDouble;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
        public double lastDouble() {
            double lastDouble;
            synchronized (this.sync) {
                lastDouble = this.sortedSet.lastDouble();
            }
            return lastDouble;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet, java.util.SortedSet
        @Deprecated
        public Double first() {
            Double first;
            synchronized (this.sync) {
                first = this.sortedSet.first();
            }
            return first;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet, java.util.SortedSet
        @Deprecated
        public Double last() {
            Double last;
            synchronized (this.sync) {
                last = this.sortedSet.last();
            }
            return last;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
        @Deprecated
        public DoubleSortedSet subSet(Double from, Double to) {
            return new SynchronizedSortedSet(this.sortedSet.subSet(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
        @Deprecated
        public DoubleSortedSet headSet(Double to) {
            return new SynchronizedSortedSet(this.sortedSet.headSet(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
        @Deprecated
        public DoubleSortedSet tailSet(Double from) {
            return new SynchronizedSortedSet(this.sortedSet.tailSet(from), this.sync);
        }
    }

    public static DoubleSortedSet synchronize(DoubleSortedSet s) {
        return new SynchronizedSortedSet(s);
    }

    public static DoubleSortedSet synchronize(DoubleSortedSet s, Object sync) {
        return new SynchronizedSortedSet(s, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.DoubleSortedSets$UnmodifiableSortedSet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleSortedSets$UnmodifiableSortedSet.class */
    public static class UnmodifiableSortedSet extends DoubleSets.UnmodifiableSet implements DoubleSortedSet, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final DoubleSortedSet sortedSet;

        protected UnmodifiableSortedSet(DoubleSortedSet s) {
            super(s);
            this.sortedSet = s;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet, java.util.SortedSet
        public Comparator<? super Double> comparator() {
            return this.sortedSet.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
        public DoubleSortedSet subSet(double from, double to) {
            return new UnmodifiableSortedSet(this.sortedSet.subSet(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
        public DoubleSortedSet headSet(double to) {
            return new UnmodifiableSortedSet(this.sortedSet.headSet(to));
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
        public DoubleSortedSet tailSet(double from) {
            return new UnmodifiableSortedSet(this.sortedSet.tailSet(from));
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSets.UnmodifiableSet, p014it.unimi.dsi.fastutil.doubles.DoubleCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public DoubleBidirectionalIterator iterator() {
            return DoubleIterators.unmodifiable(this.sortedSet.iterator());
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
        public DoubleBidirectionalIterator iterator(double from) {
            return DoubleIterators.unmodifiable(this.sortedSet.iterator(from));
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
        public double firstDouble() {
            return this.sortedSet.firstDouble();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
        public double lastDouble() {
            return this.sortedSet.lastDouble();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet, java.util.SortedSet
        @Deprecated
        public Double first() {
            return this.sortedSet.first();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet, java.util.SortedSet
        @Deprecated
        public Double last() {
            return this.sortedSet.last();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
        @Deprecated
        public DoubleSortedSet subSet(Double from, Double to) {
            return new UnmodifiableSortedSet(this.sortedSet.subSet(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
        @Deprecated
        public DoubleSortedSet headSet(Double to) {
            return new UnmodifiableSortedSet(this.sortedSet.headSet(to));
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
        @Deprecated
        public DoubleSortedSet tailSet(Double from) {
            return new UnmodifiableSortedSet(this.sortedSet.tailSet(from));
        }
    }

    public static DoubleSortedSet unmodifiable(DoubleSortedSet s) {
        return new UnmodifiableSortedSet(s);
    }
}
