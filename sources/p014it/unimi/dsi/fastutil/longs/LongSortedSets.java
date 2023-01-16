package p014it.unimi.dsi.fastutil.longs;

import java.io.Serializable;
import java.util.Comparator;
import java.util.NoSuchElementException;
import p014it.unimi.dsi.fastutil.longs.LongSets;

/* renamed from: it.unimi.dsi.fastutil.longs.LongSortedSets */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongSortedSets.class */
public final class LongSortedSets {
    public static final EmptySet EMPTY_SET = new EmptySet();

    private LongSortedSets() {
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.LongSortedSets$EmptySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongSortedSets$EmptySet.class */
    public static class EmptySet extends LongSets.EmptySet implements LongSortedSet, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
        public LongBidirectionalIterator iterator(long from) {
            return LongIterators.EMPTY_ITERATOR;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
        public LongSortedSet subSet(long from, long to) {
            return LongSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
        public LongSortedSet headSet(long from) {
            return LongSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
        public LongSortedSet tailSet(long to) {
            return LongSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
        public long firstLong() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
        public long lastLong() {
            throw new NoSuchElementException();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet, java.util.SortedSet
        public Comparator<? super Long> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
        @Deprecated
        public LongSortedSet subSet(Long from, Long to) {
            return LongSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
        @Deprecated
        public LongSortedSet headSet(Long from) {
            return LongSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
        @Deprecated
        public LongSortedSet tailSet(Long to) {
            return LongSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet, java.util.SortedSet
        @Deprecated
        public Long first() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet, java.util.SortedSet
        @Deprecated
        public Long last() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSets.EmptySet, java.lang.Object
        public Object clone() {
            return LongSortedSets.EMPTY_SET;
        }

        private Object readResolve() {
            return LongSortedSets.EMPTY_SET;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.LongSortedSets$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongSortedSets$Singleton.class */
    public static class Singleton extends LongSets.Singleton implements LongSortedSet, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        final LongComparator comparator;

        @Override // p014it.unimi.dsi.fastutil.longs.LongSets.Singleton, p014it.unimi.dsi.fastutil.longs.AbstractLongSet, p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
        public /* bridge */ /* synthetic */ LongBidirectionalIterator iterator() {
            return iterator();
        }

        protected Singleton(long element, LongComparator comparator) {
            super(element);
            this.comparator = comparator;
        }

        Singleton(long element) {
            this(element, null);
        }

        final int compare(long k1, long k2) {
            return this.comparator == null ? Long.compare(k1, k2) : this.comparator.compare(k1, k2);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
        public LongBidirectionalIterator iterator(long from) {
            LongBidirectionalIterator i = iterator();
            if (compare(this.element, from) <= 0) {
                i.nextLong();
            }
            return i;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet, java.util.SortedSet
        public Comparator<? super Long> comparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSets.Singleton, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
        public LongSpliterator spliterator() {
            return LongSpliterators.singleton(this.element, this.comparator);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
        public LongSortedSet subSet(long from, long to) {
            return (compare(from, this.element) > 0 || compare(this.element, to) >= 0) ? LongSortedSets.EMPTY_SET : this;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
        public LongSortedSet headSet(long to) {
            return compare(this.element, to) < 0 ? this : LongSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
        public LongSortedSet tailSet(long from) {
            return compare(from, this.element) <= 0 ? this : LongSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
        public long firstLong() {
            return this.element;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
        public long lastLong() {
            return this.element;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
        @Deprecated
        public LongSortedSet subSet(Long from, Long to) {
            return subSet(from.longValue(), to.longValue());
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
        @Deprecated
        public LongSortedSet headSet(Long to) {
            return headSet(to.longValue());
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
        @Deprecated
        public LongSortedSet tailSet(Long from) {
            return tailSet(from.longValue());
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet, java.util.SortedSet
        @Deprecated
        public Long first() {
            return Long.valueOf(this.element);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet, java.util.SortedSet
        @Deprecated
        public Long last() {
            return Long.valueOf(this.element);
        }
    }

    public static LongSortedSet singleton(long element) {
        return new Singleton(element);
    }

    public static LongSortedSet singleton(long element, LongComparator comparator) {
        return new Singleton(element, comparator);
    }

    public static LongSortedSet singleton(Object element) {
        return new Singleton(((Long) element).longValue());
    }

    public static LongSortedSet singleton(Object element, LongComparator comparator) {
        return new Singleton(((Long) element).longValue(), comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.LongSortedSets$SynchronizedSortedSet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongSortedSets$SynchronizedSortedSet.class */
    public static class SynchronizedSortedSet extends LongSets.SynchronizedSet implements LongSortedSet, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final LongSortedSet sortedSet;

        protected SynchronizedSortedSet(LongSortedSet s, Object sync) {
            super(s, sync);
            this.sortedSet = s;
        }

        protected SynchronizedSortedSet(LongSortedSet s) {
            super(s);
            this.sortedSet = s;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet, java.util.SortedSet
        public Comparator<? super Long> comparator() {
            Comparator<? super Long> comparator;
            synchronized (this.sync) {
                comparator = this.sortedSet.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
        public LongSortedSet subSet(long from, long to) {
            return new SynchronizedSortedSet(this.sortedSet.subSet(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
        public LongSortedSet headSet(long to) {
            return new SynchronizedSortedSet(this.sortedSet.headSet(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
        public LongSortedSet tailSet(long from) {
            return new SynchronizedSortedSet(this.sortedSet.tailSet(from), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSets.SynchronizedSet, p014it.unimi.dsi.fastutil.longs.LongCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.longs.LongCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongIterable
        public LongBidirectionalIterator iterator() {
            return this.sortedSet.iterator();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
        public LongBidirectionalIterator iterator(long from) {
            return this.sortedSet.iterator(from);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
        public long firstLong() {
            long firstLong;
            synchronized (this.sync) {
                firstLong = this.sortedSet.firstLong();
            }
            return firstLong;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
        public long lastLong() {
            long lastLong;
            synchronized (this.sync) {
                lastLong = this.sortedSet.lastLong();
            }
            return lastLong;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet, java.util.SortedSet
        @Deprecated
        public Long first() {
            Long first;
            synchronized (this.sync) {
                first = this.sortedSet.first();
            }
            return first;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet, java.util.SortedSet
        @Deprecated
        public Long last() {
            Long last;
            synchronized (this.sync) {
                last = this.sortedSet.last();
            }
            return last;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
        @Deprecated
        public LongSortedSet subSet(Long from, Long to) {
            return new SynchronizedSortedSet(this.sortedSet.subSet(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
        @Deprecated
        public LongSortedSet headSet(Long to) {
            return new SynchronizedSortedSet(this.sortedSet.headSet(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
        @Deprecated
        public LongSortedSet tailSet(Long from) {
            return new SynchronizedSortedSet(this.sortedSet.tailSet(from), this.sync);
        }
    }

    public static LongSortedSet synchronize(LongSortedSet s) {
        return new SynchronizedSortedSet(s);
    }

    public static LongSortedSet synchronize(LongSortedSet s, Object sync) {
        return new SynchronizedSortedSet(s, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.LongSortedSets$UnmodifiableSortedSet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongSortedSets$UnmodifiableSortedSet.class */
    public static class UnmodifiableSortedSet extends LongSets.UnmodifiableSet implements LongSortedSet, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final LongSortedSet sortedSet;

        protected UnmodifiableSortedSet(LongSortedSet s) {
            super(s);
            this.sortedSet = s;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet, java.util.SortedSet
        public Comparator<? super Long> comparator() {
            return this.sortedSet.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
        public LongSortedSet subSet(long from, long to) {
            return new UnmodifiableSortedSet(this.sortedSet.subSet(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
        public LongSortedSet headSet(long to) {
            return new UnmodifiableSortedSet(this.sortedSet.headSet(to));
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
        public LongSortedSet tailSet(long from) {
            return new UnmodifiableSortedSet(this.sortedSet.tailSet(from));
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSets.UnmodifiableSet, p014it.unimi.dsi.fastutil.longs.LongCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.longs.LongCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongIterable
        public LongBidirectionalIterator iterator() {
            return LongIterators.unmodifiable(this.sortedSet.iterator());
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
        public LongBidirectionalIterator iterator(long from) {
            return LongIterators.unmodifiable(this.sortedSet.iterator(from));
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
        public long firstLong() {
            return this.sortedSet.firstLong();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
        public long lastLong() {
            return this.sortedSet.lastLong();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet, java.util.SortedSet
        @Deprecated
        public Long first() {
            return this.sortedSet.first();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet, java.util.SortedSet
        @Deprecated
        public Long last() {
            return this.sortedSet.last();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
        @Deprecated
        public LongSortedSet subSet(Long from, Long to) {
            return new UnmodifiableSortedSet(this.sortedSet.subSet(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
        @Deprecated
        public LongSortedSet headSet(Long to) {
            return new UnmodifiableSortedSet(this.sortedSet.headSet(to));
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
        @Deprecated
        public LongSortedSet tailSet(Long from) {
            return new UnmodifiableSortedSet(this.sortedSet.tailSet(from));
        }
    }

    public static LongSortedSet unmodifiable(LongSortedSet s) {
        return new UnmodifiableSortedSet(s);
    }
}
