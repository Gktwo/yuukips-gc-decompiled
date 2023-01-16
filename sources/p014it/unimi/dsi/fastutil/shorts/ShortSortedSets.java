package p014it.unimi.dsi.fastutil.shorts;

import java.io.Serializable;
import java.util.Comparator;
import java.util.NoSuchElementException;
import p014it.unimi.dsi.fastutil.SafeMath;
import p014it.unimi.dsi.fastutil.ints.IntSpliterator;
import p014it.unimi.dsi.fastutil.ints.IntSpliterators;
import p014it.unimi.dsi.fastutil.shorts.ShortSets;

/* renamed from: it.unimi.dsi.fastutil.shorts.ShortSortedSets */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortSortedSets.class */
public final class ShortSortedSets {
    public static final EmptySet EMPTY_SET = new EmptySet();

    private ShortSortedSets() {
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortSortedSets$EmptySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortSortedSets$EmptySet.class */
    public static class EmptySet extends ShortSets.EmptySet implements ShortSortedSet, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
        public ShortBidirectionalIterator iterator(short from) {
            return ShortIterators.EMPTY_ITERATOR;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
        public ShortSortedSet subSet(short from, short to) {
            return ShortSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
        public ShortSortedSet headSet(short from) {
            return ShortSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
        public ShortSortedSet tailSet(short to) {
            return ShortSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
        public short firstShort() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
        public short lastShort() {
            throw new NoSuchElementException();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet, java.util.SortedSet
        public Comparator<? super Short> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
        @Deprecated
        public ShortSortedSet subSet(Short from, Short to) {
            return ShortSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
        @Deprecated
        public ShortSortedSet headSet(Short from) {
            return ShortSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
        @Deprecated
        public ShortSortedSet tailSet(Short to) {
            return ShortSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet, java.util.SortedSet
        @Deprecated
        public Short first() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet, java.util.SortedSet
        @Deprecated
        public Short last() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSets.EmptySet, java.lang.Object
        public Object clone() {
            return ShortSortedSets.EMPTY_SET;
        }

        private Object readResolve() {
            return ShortSortedSets.EMPTY_SET;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortSortedSets$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortSortedSets$Singleton.class */
    public static class Singleton extends ShortSets.Singleton implements ShortSortedSet, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        final ShortComparator comparator;

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSets.Singleton, p014it.unimi.dsi.fastutil.shorts.AbstractShortSet, p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public /* bridge */ /* synthetic */ ShortBidirectionalIterator iterator() {
            return iterator();
        }

        protected Singleton(short element, ShortComparator comparator) {
            super(element);
            this.comparator = comparator;
        }

        Singleton(short element) {
            this(element, null);
        }

        final int compare(short k1, short k2) {
            return this.comparator == null ? Short.compare(k1, k2) : this.comparator.compare(k1, k2);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
        public ShortBidirectionalIterator iterator(short from) {
            ShortBidirectionalIterator i = iterator();
            if (compare(this.element, from) <= 0) {
                i.nextShort();
            }
            return i;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet, java.util.SortedSet
        public Comparator<? super Short> comparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSets.Singleton, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public ShortSpliterator spliterator() {
            return ShortSpliterators.singleton(this.element, this.comparator);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
        public ShortSortedSet subSet(short from, short to) {
            return (compare(from, this.element) > 0 || compare(this.element, to) >= 0) ? ShortSortedSets.EMPTY_SET : this;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
        public ShortSortedSet headSet(short to) {
            return compare(this.element, to) < 0 ? this : ShortSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
        public ShortSortedSet tailSet(short from) {
            return compare(from, this.element) <= 0 ? this : ShortSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
        public short firstShort() {
            return this.element;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
        public short lastShort() {
            return this.element;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSets.Singleton, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public IntSpliterator intSpliterator() {
            return IntSpliterators.singleton(this.element, left, right -> {
                return comparator().compare(SafeMath.safeIntToShort(left), SafeMath.safeIntToShort(right));
            });
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
        @Deprecated
        public ShortSortedSet subSet(Short from, Short to) {
            return subSet(from.shortValue(), to.shortValue());
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
        @Deprecated
        public ShortSortedSet headSet(Short to) {
            return headSet(to.shortValue());
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
        @Deprecated
        public ShortSortedSet tailSet(Short from) {
            return tailSet(from.shortValue());
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet, java.util.SortedSet
        @Deprecated
        public Short first() {
            return Short.valueOf(this.element);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet, java.util.SortedSet
        @Deprecated
        public Short last() {
            return Short.valueOf(this.element);
        }
    }

    public static ShortSortedSet singleton(short element) {
        return new Singleton(element);
    }

    public static ShortSortedSet singleton(short element, ShortComparator comparator) {
        return new Singleton(element, comparator);
    }

    public static ShortSortedSet singleton(Object element) {
        return new Singleton(((Short) element).shortValue());
    }

    public static ShortSortedSet singleton(Object element, ShortComparator comparator) {
        return new Singleton(((Short) element).shortValue(), comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortSortedSets$SynchronizedSortedSet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortSortedSets$SynchronizedSortedSet.class */
    public static class SynchronizedSortedSet extends ShortSets.SynchronizedSet implements ShortSortedSet, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final ShortSortedSet sortedSet;

        protected SynchronizedSortedSet(ShortSortedSet s, Object sync) {
            super(s, sync);
            this.sortedSet = s;
        }

        protected SynchronizedSortedSet(ShortSortedSet s) {
            super(s);
            this.sortedSet = s;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet, java.util.SortedSet
        public Comparator<? super Short> comparator() {
            Comparator<? super Short> comparator;
            synchronized (this.sync) {
                comparator = this.sortedSet.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
        public ShortSortedSet subSet(short from, short to) {
            return new SynchronizedSortedSet(this.sortedSet.subSet(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
        public ShortSortedSet headSet(short to) {
            return new SynchronizedSortedSet(this.sortedSet.headSet(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
        public ShortSortedSet tailSet(short from) {
            return new SynchronizedSortedSet(this.sortedSet.tailSet(from), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSets.SynchronizedSet, p014it.unimi.dsi.fastutil.shorts.ShortCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public ShortBidirectionalIterator iterator() {
            return this.sortedSet.iterator();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
        public ShortBidirectionalIterator iterator(short from) {
            return this.sortedSet.iterator(from);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
        public short firstShort() {
            short firstShort;
            synchronized (this.sync) {
                firstShort = this.sortedSet.firstShort();
            }
            return firstShort;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
        public short lastShort() {
            short lastShort;
            synchronized (this.sync) {
                lastShort = this.sortedSet.lastShort();
            }
            return lastShort;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet, java.util.SortedSet
        @Deprecated
        public Short first() {
            Short first;
            synchronized (this.sync) {
                first = this.sortedSet.first();
            }
            return first;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet, java.util.SortedSet
        @Deprecated
        public Short last() {
            Short last;
            synchronized (this.sync) {
                last = this.sortedSet.last();
            }
            return last;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
        @Deprecated
        public ShortSortedSet subSet(Short from, Short to) {
            return new SynchronizedSortedSet(this.sortedSet.subSet(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
        @Deprecated
        public ShortSortedSet headSet(Short to) {
            return new SynchronizedSortedSet(this.sortedSet.headSet(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
        @Deprecated
        public ShortSortedSet tailSet(Short from) {
            return new SynchronizedSortedSet(this.sortedSet.tailSet(from), this.sync);
        }
    }

    public static ShortSortedSet synchronize(ShortSortedSet s) {
        return new SynchronizedSortedSet(s);
    }

    public static ShortSortedSet synchronize(ShortSortedSet s, Object sync) {
        return new SynchronizedSortedSet(s, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortSortedSets$UnmodifiableSortedSet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortSortedSets$UnmodifiableSortedSet.class */
    public static class UnmodifiableSortedSet extends ShortSets.UnmodifiableSet implements ShortSortedSet, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final ShortSortedSet sortedSet;

        protected UnmodifiableSortedSet(ShortSortedSet s) {
            super(s);
            this.sortedSet = s;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet, java.util.SortedSet
        public Comparator<? super Short> comparator() {
            return this.sortedSet.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
        public ShortSortedSet subSet(short from, short to) {
            return new UnmodifiableSortedSet(this.sortedSet.subSet(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
        public ShortSortedSet headSet(short to) {
            return new UnmodifiableSortedSet(this.sortedSet.headSet(to));
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
        public ShortSortedSet tailSet(short from) {
            return new UnmodifiableSortedSet(this.sortedSet.tailSet(from));
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSets.UnmodifiableSet, p014it.unimi.dsi.fastutil.shorts.ShortCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public ShortBidirectionalIterator iterator() {
            return ShortIterators.unmodifiable(this.sortedSet.iterator());
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
        public ShortBidirectionalIterator iterator(short from) {
            return ShortIterators.unmodifiable(this.sortedSet.iterator(from));
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
        public short firstShort() {
            return this.sortedSet.firstShort();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
        public short lastShort() {
            return this.sortedSet.lastShort();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet, java.util.SortedSet
        @Deprecated
        public Short first() {
            return this.sortedSet.first();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet, java.util.SortedSet
        @Deprecated
        public Short last() {
            return this.sortedSet.last();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
        @Deprecated
        public ShortSortedSet subSet(Short from, Short to) {
            return new UnmodifiableSortedSet(this.sortedSet.subSet(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
        @Deprecated
        public ShortSortedSet headSet(Short to) {
            return new UnmodifiableSortedSet(this.sortedSet.headSet(to));
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
        @Deprecated
        public ShortSortedSet tailSet(Short from) {
            return new UnmodifiableSortedSet(this.sortedSet.tailSet(from));
        }
    }

    public static ShortSortedSet unmodifiable(ShortSortedSet s) {
        return new UnmodifiableSortedSet(s);
    }
}
