package p014it.unimi.dsi.fastutil.bytes;

import java.io.Serializable;
import java.util.Comparator;
import java.util.NoSuchElementException;
import p014it.unimi.dsi.fastutil.SafeMath;
import p014it.unimi.dsi.fastutil.bytes.ByteSets;
import p014it.unimi.dsi.fastutil.ints.IntSpliterator;
import p014it.unimi.dsi.fastutil.ints.IntSpliterators;

/* renamed from: it.unimi.dsi.fastutil.bytes.ByteSortedSets */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteSortedSets.class */
public final class ByteSortedSets {
    public static final EmptySet EMPTY_SET = new EmptySet();

    private ByteSortedSets() {
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.ByteSortedSets$EmptySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteSortedSets$EmptySet.class */
    public static class EmptySet extends ByteSets.EmptySet implements ByteSortedSet, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        public ByteBidirectionalIterator iterator(byte from) {
            return ByteIterators.EMPTY_ITERATOR;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        public ByteSortedSet subSet(byte from, byte to) {
            return ByteSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        public ByteSortedSet headSet(byte from) {
            return ByteSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        public ByteSortedSet tailSet(byte to) {
            return ByteSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        public byte firstByte() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        public byte lastByte() {
            throw new NoSuchElementException();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet, java.util.SortedSet
        public Comparator<? super Byte> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        @Deprecated
        public ByteSortedSet subSet(Byte from, Byte to) {
            return ByteSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        @Deprecated
        public ByteSortedSet headSet(Byte from) {
            return ByteSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        @Deprecated
        public ByteSortedSet tailSet(Byte to) {
            return ByteSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet, java.util.SortedSet
        @Deprecated
        public Byte first() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet, java.util.SortedSet
        @Deprecated
        public Byte last() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSets.EmptySet, java.lang.Object
        public Object clone() {
            return ByteSortedSets.EMPTY_SET;
        }

        private Object readResolve() {
            return ByteSortedSets.EMPTY_SET;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.ByteSortedSets$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteSortedSets$Singleton.class */
    public static class Singleton extends ByteSets.Singleton implements ByteSortedSet, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        final ByteComparator comparator;

        /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.bytes.ByteListIterator, it.unimi.dsi.fastutil.bytes.ByteBidirectionalIterator] */
        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSets.Singleton, p014it.unimi.dsi.fastutil.bytes.AbstractByteSet, p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
        public /* bridge */ /* synthetic */ ByteBidirectionalIterator iterator() {
            return iterator();
        }

        protected Singleton(byte element, ByteComparator comparator) {
            super(element);
            this.comparator = comparator;
        }

        Singleton(byte element) {
            this(element, null);
        }

        final int compare(byte k1, byte k2) {
            return this.comparator == null ? Byte.compare(k1, k2) : this.comparator.compare(k1, k2);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        public ByteBidirectionalIterator iterator(byte from) {
            ByteBidirectionalIterator i = iterator();
            if (compare(this.element, from) <= 0) {
                i.nextByte();
            }
            return i;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet, java.util.SortedSet
        public Comparator<? super Byte> comparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSets.Singleton, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
        public ByteSpliterator spliterator() {
            return ByteSpliterators.singleton(this.element, this.comparator);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        public ByteSortedSet subSet(byte from, byte to) {
            return (compare(from, this.element) > 0 || compare(this.element, to) >= 0) ? ByteSortedSets.EMPTY_SET : this;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        public ByteSortedSet headSet(byte to) {
            return compare(this.element, to) < 0 ? this : ByteSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        public ByteSortedSet tailSet(byte from) {
            return compare(from, this.element) <= 0 ? this : ByteSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        public byte firstByte() {
            return this.element;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        public byte lastByte() {
            return this.element;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSets.Singleton, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable
        public IntSpliterator intSpliterator() {
            return IntSpliterators.singleton(this.element, left, right -> {
                return comparator().compare(SafeMath.safeIntToByte(left), SafeMath.safeIntToByte(right));
            });
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        @Deprecated
        public ByteSortedSet subSet(Byte from, Byte to) {
            return subSet(from.byteValue(), to.byteValue());
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        @Deprecated
        public ByteSortedSet headSet(Byte to) {
            return headSet(to.byteValue());
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        @Deprecated
        public ByteSortedSet tailSet(Byte from) {
            return tailSet(from.byteValue());
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet, java.util.SortedSet
        @Deprecated
        public Byte first() {
            return Byte.valueOf(this.element);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet, java.util.SortedSet
        @Deprecated
        public Byte last() {
            return Byte.valueOf(this.element);
        }
    }

    public static ByteSortedSet singleton(byte element) {
        return new Singleton(element);
    }

    public static ByteSortedSet singleton(byte element, ByteComparator comparator) {
        return new Singleton(element, comparator);
    }

    public static ByteSortedSet singleton(Object element) {
        return new Singleton(((Byte) element).byteValue());
    }

    public static ByteSortedSet singleton(Object element, ByteComparator comparator) {
        return new Singleton(((Byte) element).byteValue(), comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.ByteSortedSets$SynchronizedSortedSet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteSortedSets$SynchronizedSortedSet.class */
    public static class SynchronizedSortedSet extends ByteSets.SynchronizedSet implements ByteSortedSet, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final ByteSortedSet sortedSet;

        protected SynchronizedSortedSet(ByteSortedSet s, Object sync) {
            super(s, sync);
            this.sortedSet = s;
        }

        protected SynchronizedSortedSet(ByteSortedSet s) {
            super(s);
            this.sortedSet = s;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet, java.util.SortedSet
        public Comparator<? super Byte> comparator() {
            Comparator<? super Byte> comparator;
            synchronized (this.sync) {
                comparator = this.sortedSet.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        public ByteSortedSet subSet(byte from, byte to) {
            return new SynchronizedSortedSet(this.sortedSet.subSet(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        public ByteSortedSet headSet(byte to) {
            return new SynchronizedSortedSet(this.sortedSet.headSet(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        public ByteSortedSet tailSet(byte from) {
            return new SynchronizedSortedSet(this.sortedSet.tailSet(from), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSets.SynchronizedSet, p014it.unimi.dsi.fastutil.bytes.ByteCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
        public ByteBidirectionalIterator iterator() {
            return this.sortedSet.iterator();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        public ByteBidirectionalIterator iterator(byte from) {
            return this.sortedSet.iterator(from);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        public byte firstByte() {
            byte firstByte;
            synchronized (this.sync) {
                firstByte = this.sortedSet.firstByte();
            }
            return firstByte;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        public byte lastByte() {
            byte lastByte;
            synchronized (this.sync) {
                lastByte = this.sortedSet.lastByte();
            }
            return lastByte;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet, java.util.SortedSet
        @Deprecated
        public Byte first() {
            Byte first;
            synchronized (this.sync) {
                first = this.sortedSet.first();
            }
            return first;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet, java.util.SortedSet
        @Deprecated
        public Byte last() {
            Byte last;
            synchronized (this.sync) {
                last = this.sortedSet.last();
            }
            return last;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        @Deprecated
        public ByteSortedSet subSet(Byte from, Byte to) {
            return new SynchronizedSortedSet(this.sortedSet.subSet(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        @Deprecated
        public ByteSortedSet headSet(Byte to) {
            return new SynchronizedSortedSet(this.sortedSet.headSet(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        @Deprecated
        public ByteSortedSet tailSet(Byte from) {
            return new SynchronizedSortedSet(this.sortedSet.tailSet(from), this.sync);
        }
    }

    public static ByteSortedSet synchronize(ByteSortedSet s) {
        return new SynchronizedSortedSet(s);
    }

    public static ByteSortedSet synchronize(ByteSortedSet s, Object sync) {
        return new SynchronizedSortedSet(s, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.ByteSortedSets$UnmodifiableSortedSet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteSortedSets$UnmodifiableSortedSet.class */
    public static class UnmodifiableSortedSet extends ByteSets.UnmodifiableSet implements ByteSortedSet, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final ByteSortedSet sortedSet;

        protected UnmodifiableSortedSet(ByteSortedSet s) {
            super(s);
            this.sortedSet = s;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet, java.util.SortedSet
        public Comparator<? super Byte> comparator() {
            return this.sortedSet.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        public ByteSortedSet subSet(byte from, byte to) {
            return new UnmodifiableSortedSet(this.sortedSet.subSet(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        public ByteSortedSet headSet(byte to) {
            return new UnmodifiableSortedSet(this.sortedSet.headSet(to));
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        public ByteSortedSet tailSet(byte from) {
            return new UnmodifiableSortedSet(this.sortedSet.tailSet(from));
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSets.UnmodifiableSet, p014it.unimi.dsi.fastutil.bytes.ByteCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
        public ByteBidirectionalIterator iterator() {
            return ByteIterators.unmodifiable(this.sortedSet.iterator());
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        public ByteBidirectionalIterator iterator(byte from) {
            return ByteIterators.unmodifiable(this.sortedSet.iterator(from));
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        public byte firstByte() {
            return this.sortedSet.firstByte();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        public byte lastByte() {
            return this.sortedSet.lastByte();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet, java.util.SortedSet
        @Deprecated
        public Byte first() {
            return this.sortedSet.first();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet, java.util.SortedSet
        @Deprecated
        public Byte last() {
            return this.sortedSet.last();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        @Deprecated
        public ByteSortedSet subSet(Byte from, Byte to) {
            return new UnmodifiableSortedSet(this.sortedSet.subSet(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        @Deprecated
        public ByteSortedSet headSet(Byte to) {
            return new UnmodifiableSortedSet(this.sortedSet.headSet(to));
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        @Deprecated
        public ByteSortedSet tailSet(Byte from) {
            return new UnmodifiableSortedSet(this.sortedSet.tailSet(from));
        }
    }

    public static ByteSortedSet unmodifiable(ByteSortedSet s) {
        return new UnmodifiableSortedSet(s);
    }
}
