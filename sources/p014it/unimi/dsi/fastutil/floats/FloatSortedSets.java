package p014it.unimi.dsi.fastutil.floats;

import java.io.Serializable;
import java.util.Comparator;
import java.util.NoSuchElementException;
import p014it.unimi.dsi.fastutil.SafeMath;
import p014it.unimi.dsi.fastutil.doubles.DoubleSpliterator;
import p014it.unimi.dsi.fastutil.doubles.DoubleSpliterators;
import p014it.unimi.dsi.fastutil.floats.FloatSets;

/* renamed from: it.unimi.dsi.fastutil.floats.FloatSortedSets */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatSortedSets.class */
public final class FloatSortedSets {
    public static final EmptySet EMPTY_SET = new EmptySet();

    private FloatSortedSets() {
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.FloatSortedSets$EmptySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatSortedSets$EmptySet.class */
    public static class EmptySet extends FloatSets.EmptySet implements FloatSortedSet, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet
        public FloatBidirectionalIterator iterator(float from) {
            return FloatIterators.EMPTY_ITERATOR;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet
        public FloatSortedSet subSet(float from, float to) {
            return FloatSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet
        public FloatSortedSet headSet(float from) {
            return FloatSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet
        public FloatSortedSet tailSet(float to) {
            return FloatSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet
        public float firstFloat() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet
        public float lastFloat() {
            throw new NoSuchElementException();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet, java.util.SortedSet
        public Comparator<? super Float> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet
        @Deprecated
        public FloatSortedSet subSet(Float from, Float to) {
            return FloatSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet
        @Deprecated
        public FloatSortedSet headSet(Float from) {
            return FloatSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet
        @Deprecated
        public FloatSortedSet tailSet(Float to) {
            return FloatSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet, java.util.SortedSet
        @Deprecated
        public Float first() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet, java.util.SortedSet
        @Deprecated
        public Float last() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSets.EmptySet, java.lang.Object
        public Object clone() {
            return FloatSortedSets.EMPTY_SET;
        }

        private Object readResolve() {
            return FloatSortedSets.EMPTY_SET;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.FloatSortedSets$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatSortedSets$Singleton.class */
    public static class Singleton extends FloatSets.Singleton implements FloatSortedSet, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        final FloatComparator comparator;

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSets.Singleton, p014it.unimi.dsi.fastutil.floats.AbstractFloatSet, p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
        public /* bridge */ /* synthetic */ FloatBidirectionalIterator iterator() {
            return iterator();
        }

        protected Singleton(float element, FloatComparator comparator) {
            super(element);
            this.comparator = comparator;
        }

        Singleton(float element) {
            this(element, null);
        }

        final int compare(float k1, float k2) {
            return this.comparator == null ? Float.compare(k1, k2) : this.comparator.compare(k1, k2);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet
        public FloatBidirectionalIterator iterator(float from) {
            FloatBidirectionalIterator i = iterator();
            if (compare(this.element, from) <= 0) {
                i.nextFloat();
            }
            return i;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet, java.util.SortedSet
        public Comparator<? super Float> comparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSets.Singleton, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
        public FloatSpliterator spliterator() {
            return FloatSpliterators.singleton(this.element, this.comparator);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet
        public FloatSortedSet subSet(float from, float to) {
            return (compare(from, this.element) > 0 || compare(this.element, to) >= 0) ? FloatSortedSets.EMPTY_SET : this;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet
        public FloatSortedSet headSet(float to) {
            return compare(this.element, to) < 0 ? this : FloatSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet
        public FloatSortedSet tailSet(float from) {
            return compare(from, this.element) <= 0 ? this : FloatSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet
        public float firstFloat() {
            return this.element;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet
        public float lastFloat() {
            return this.element;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSets.Singleton, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
        public DoubleSpliterator doubleSpliterator() {
            return DoubleSpliterators.singleton((double) this.element, left, right -> {
                return comparator().compare(SafeMath.safeDoubleToFloat(left), SafeMath.safeDoubleToFloat(right));
            });
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet
        @Deprecated
        public FloatSortedSet subSet(Float from, Float to) {
            return subSet(from.floatValue(), to.floatValue());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet
        @Deprecated
        public FloatSortedSet headSet(Float to) {
            return headSet(to.floatValue());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet
        @Deprecated
        public FloatSortedSet tailSet(Float from) {
            return tailSet(from.floatValue());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet, java.util.SortedSet
        @Deprecated
        public Float first() {
            return Float.valueOf(this.element);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet, java.util.SortedSet
        @Deprecated
        public Float last() {
            return Float.valueOf(this.element);
        }
    }

    public static FloatSortedSet singleton(float element) {
        return new Singleton(element);
    }

    public static FloatSortedSet singleton(float element, FloatComparator comparator) {
        return new Singleton(element, comparator);
    }

    public static FloatSortedSet singleton(Object element) {
        return new Singleton(((Float) element).floatValue());
    }

    public static FloatSortedSet singleton(Object element, FloatComparator comparator) {
        return new Singleton(((Float) element).floatValue(), comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.FloatSortedSets$SynchronizedSortedSet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatSortedSets$SynchronizedSortedSet.class */
    public static class SynchronizedSortedSet extends FloatSets.SynchronizedSet implements FloatSortedSet, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final FloatSortedSet sortedSet;

        protected SynchronizedSortedSet(FloatSortedSet s, Object sync) {
            super(s, sync);
            this.sortedSet = s;
        }

        protected SynchronizedSortedSet(FloatSortedSet s) {
            super(s);
            this.sortedSet = s;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet, java.util.SortedSet
        public Comparator<? super Float> comparator() {
            Comparator<? super Float> comparator;
            synchronized (this.sync) {
                comparator = this.sortedSet.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet
        public FloatSortedSet subSet(float from, float to) {
            return new SynchronizedSortedSet(this.sortedSet.subSet(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet
        public FloatSortedSet headSet(float to) {
            return new SynchronizedSortedSet(this.sortedSet.headSet(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet
        public FloatSortedSet tailSet(float from) {
            return new SynchronizedSortedSet(this.sortedSet.tailSet(from), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSets.SynchronizedSet, p014it.unimi.dsi.fastutil.floats.FloatCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatIterable
        public FloatBidirectionalIterator iterator() {
            return this.sortedSet.iterator();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet
        public FloatBidirectionalIterator iterator(float from) {
            return this.sortedSet.iterator(from);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet
        public float firstFloat() {
            float firstFloat;
            synchronized (this.sync) {
                firstFloat = this.sortedSet.firstFloat();
            }
            return firstFloat;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet
        public float lastFloat() {
            float lastFloat;
            synchronized (this.sync) {
                lastFloat = this.sortedSet.lastFloat();
            }
            return lastFloat;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet, java.util.SortedSet
        @Deprecated
        public Float first() {
            Float first;
            synchronized (this.sync) {
                first = this.sortedSet.first();
            }
            return first;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet, java.util.SortedSet
        @Deprecated
        public Float last() {
            Float last;
            synchronized (this.sync) {
                last = this.sortedSet.last();
            }
            return last;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet
        @Deprecated
        public FloatSortedSet subSet(Float from, Float to) {
            return new SynchronizedSortedSet(this.sortedSet.subSet(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet
        @Deprecated
        public FloatSortedSet headSet(Float to) {
            return new SynchronizedSortedSet(this.sortedSet.headSet(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet
        @Deprecated
        public FloatSortedSet tailSet(Float from) {
            return new SynchronizedSortedSet(this.sortedSet.tailSet(from), this.sync);
        }
    }

    public static FloatSortedSet synchronize(FloatSortedSet s) {
        return new SynchronizedSortedSet(s);
    }

    public static FloatSortedSet synchronize(FloatSortedSet s, Object sync) {
        return new SynchronizedSortedSet(s, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.FloatSortedSets$UnmodifiableSortedSet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatSortedSets$UnmodifiableSortedSet.class */
    public static class UnmodifiableSortedSet extends FloatSets.UnmodifiableSet implements FloatSortedSet, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final FloatSortedSet sortedSet;

        protected UnmodifiableSortedSet(FloatSortedSet s) {
            super(s);
            this.sortedSet = s;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet, java.util.SortedSet
        public Comparator<? super Float> comparator() {
            return this.sortedSet.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet
        public FloatSortedSet subSet(float from, float to) {
            return new UnmodifiableSortedSet(this.sortedSet.subSet(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet
        public FloatSortedSet headSet(float to) {
            return new UnmodifiableSortedSet(this.sortedSet.headSet(to));
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet
        public FloatSortedSet tailSet(float from) {
            return new UnmodifiableSortedSet(this.sortedSet.tailSet(from));
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSets.UnmodifiableSet, p014it.unimi.dsi.fastutil.floats.FloatCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatIterable
        public FloatBidirectionalIterator iterator() {
            return FloatIterators.unmodifiable(this.sortedSet.iterator());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet
        public FloatBidirectionalIterator iterator(float from) {
            return FloatIterators.unmodifiable(this.sortedSet.iterator(from));
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet
        public float firstFloat() {
            return this.sortedSet.firstFloat();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet
        public float lastFloat() {
            return this.sortedSet.lastFloat();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet, java.util.SortedSet
        @Deprecated
        public Float first() {
            return this.sortedSet.first();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet, java.util.SortedSet
        @Deprecated
        public Float last() {
            return this.sortedSet.last();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet
        @Deprecated
        public FloatSortedSet subSet(Float from, Float to) {
            return new UnmodifiableSortedSet(this.sortedSet.subSet(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet
        @Deprecated
        public FloatSortedSet headSet(Float to) {
            return new UnmodifiableSortedSet(this.sortedSet.headSet(to));
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet
        @Deprecated
        public FloatSortedSet tailSet(Float from) {
            return new UnmodifiableSortedSet(this.sortedSet.tailSet(from));
        }
    }

    public static FloatSortedSet unmodifiable(FloatSortedSet s) {
        return new UnmodifiableSortedSet(s);
    }
}
