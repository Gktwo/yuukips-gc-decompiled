package p014it.unimi.dsi.fastutil.longs;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.RandomAccess;
import java.util.function.Consumer;
import java.util.function.LongConsumer;
import java.util.function.LongPredicate;
import java.util.function.LongUnaryOperator;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import okhttp3.HttpUrl;
import p014it.unimi.dsi.fastutil.longs.LongCollections;

/* renamed from: it.unimi.dsi.fastutil.longs.LongLists */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongLists.class */
public final class LongLists {
    public static final EmptyList EMPTY_LIST = new EmptyList();

    private LongLists() {
    }

    public static LongList shuffle(LongList l, Random random) {
        int i = l.size();
        while (true) {
            i--;
            if (i == 0) {
                return l;
            }
            int p = random.nextInt(i + 1);
            long t = l.getLong(i);
            l.set(i, l.getLong(p));
            l.set(p, t);
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.LongLists$EmptyList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongLists$EmptyList.class */
    public static class EmptyList extends LongCollections.EmptyCollection implements LongList, RandomAccess, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptyList() {
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        public long getLong(int i) {
            throw new IndexOutOfBoundsException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public boolean rem(long k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        public long removeLong(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        public void add(int index, long k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        public long set(int index, long k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        public int indexOf(long k) {
            return -1;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        public int lastIndexOf(long k) {
            return -1;
        }

        @Override // java.util.List
        public boolean addAll(int i, Collection<? extends Long> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList, java.util.List
        @Deprecated
        public void replaceAll(UnaryOperator<Long> operator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        public void replaceAll(LongUnaryOperator operator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        public boolean addAll(LongList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        public boolean addAll(int i, LongCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        public boolean addAll(int i, LongList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        @Deprecated
        public void add(int index, Long k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList, java.util.List
        @Deprecated
        public Long get(int index) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        @Deprecated
        public boolean add(Long k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        @Deprecated
        public Long set(int index, Long k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList, java.util.List
        @Deprecated
        public Long remove(int k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList, java.util.List
        @Deprecated
        public int indexOf(Object k) {
            return -1;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList, java.util.List
        @Deprecated
        public int lastIndexOf(Object k) {
            return -1;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        public void sort(LongComparator comparator) {
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        public void unstableSort(LongComparator comparator) {
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList, java.util.List
        @Deprecated
        public void sort(Comparator<? super Long> comparator) {
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        @Deprecated
        public void unstableSort(Comparator<? super Long> comparator) {
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.LongList, java.util.List
        public ListIterator<Long> listIterator() {
            return LongIterators.EMPTY_ITERATOR;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.EmptyCollection, p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
        public LongListIterator iterator() {
            return LongIterators.EMPTY_ITERATOR;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.LongList, java.util.List
        public ListIterator<Long> listIterator(int i) {
            if (i == 0) {
                return LongIterators.EMPTY_ITERATOR;
            }
            throw new IndexOutOfBoundsException(String.valueOf(i));
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongList' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.LongList, java.util.List
        public List<Long> subList(int from, int to) {
            if (from == 0 && to == 0) {
                return this;
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        public void getElements(int from, long[] a, int offset, int length) {
            if (from != 0 || length != 0 || offset < 0 || offset > a.length) {
                throw new IndexOutOfBoundsException();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        public void removeElements(int from, int to) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        public void addElements(int index, long[] a, int offset, int length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        public void addElements(int index, long[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        public void setElements(long[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        public void setElements(int index, long[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        public void setElements(int index, long[] a, int offset, int length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        public void size(int s) {
            throw new UnsupportedOperationException();
        }

        public int compareTo(List<? extends Long> o) {
            return (o != this && !o.isEmpty()) ? -1 : 0;
        }

        @Override // java.lang.Object
        public Object clone() {
            return LongLists.EMPTY_LIST;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.EmptyCollection, java.util.Collection, java.lang.Object
        public int hashCode() {
            return 1;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.EmptyCollection, java.util.Collection, java.lang.Object
        public boolean equals(Object o) {
            return (o instanceof List) && ((List) o).isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, java.util.AbstractCollection, java.lang.Object
        public String toString() {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }

        private Object readResolve() {
            return LongLists.EMPTY_LIST;
        }
    }

    public static LongList emptyList() {
        return EMPTY_LIST;
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.LongLists$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongLists$Singleton.class */
    public static class Singleton extends AbstractLongList implements RandomAccess, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        private final long element;

        protected Singleton(long element) {
            this.element = element;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        public long getLong(int i) {
            if (i == 0) {
                return this.element;
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public boolean rem(long k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.LongList
        public long removeLong(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public boolean contains(long k) {
            return k == this.element;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.LongList
        public int indexOf(long k) {
            return k == this.element ? 0 : -1;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public long[] toLongArray() {
            return new long[]{this.element};
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.LongList, java.util.List
        public ListIterator<Long> listIterator() {
            return LongIterators.singleton(this.element);
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.longs.LongListIterator] */
        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
        public LongListIterator iterator() {
            return listIterator();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
        public LongSpliterator spliterator() {
            return LongSpliterators.singleton(this.element);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongListIterator' to match base method */
        /* JADX WARN: Type inference failed for: r0v4, types: [it.unimi.dsi.fastutil.longs.LongListIterator, java.util.ListIterator<java.lang.Long>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.LongList, java.util.List
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.util.ListIterator<java.lang.Long> listIterator(int r4) {
            /*
                r3 = this;
                r0 = r4
                r1 = 1
                if (r0 > r1) goto L_0x0009
                r0 = r4
                if (r0 >= 0) goto L_0x0011
            L_0x0009:
                java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException
                r1 = r0
                r1.<init>()
                throw r0
            L_0x0011:
                r0 = r3
                it.unimi.dsi.fastutil.longs.LongListIterator r0 = r0.listIterator()
                r5 = r0
                r0 = r4
                r1 = 1
                if (r0 != r1) goto L_0x0022
                r0 = r5
                long r0 = r0.nextLong()
            L_0x0022:
                r0 = r5
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.longs.LongLists.Singleton.listIterator(int):it.unimi.dsi.fastutil.longs.LongListIterator");
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongList' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.LongList, java.util.List
        public List<Long> subList(int from, int to) {
            ensureIndex(from);
            ensureIndex(to);
            if (from <= to) {
                return (from == 0 && to == 1) ? this : LongLists.EMPTY_LIST;
            }
            throw new IndexOutOfBoundsException("Start index (" + from + ") is greater than end index (" + to + ")");
        }

        @Override // java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongIterable
        @Deprecated
        public void forEach(Consumer<? super Long> action) {
            action.accept(Long.valueOf(this.element));
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, java.util.List
        public boolean addAll(int i, Collection<? extends Long> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection<? extends Long> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> c) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection, p014it.unimi.dsi.fastutil.longs.LongCollection
        @Deprecated
        public boolean removeIf(Predicate<? super Long> filter) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList, java.util.List
        @Deprecated
        public void replaceAll(UnaryOperator<Long> operator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        public void replaceAll(LongUnaryOperator operator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.LongIterable
        public void forEach(LongConsumer action) {
            action.accept(this.element);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        public boolean addAll(LongList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        public boolean addAll(int i, LongList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.LongList
        public boolean addAll(int i, LongCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public boolean addAll(LongCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public boolean removeAll(LongCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public boolean retainAll(LongCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollection
        public boolean removeIf(LongPredicate filter) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        @Deprecated
        public Object[] toArray() {
            return new Object[]{Long.valueOf(this.element)};
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        public void sort(LongComparator comparator) {
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        public void unstableSort(LongComparator comparator) {
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList, java.util.List
        @Deprecated
        public void sort(Comparator<? super Long> comparator) {
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        @Deprecated
        public void unstableSort(Comparator<? super Long> comparator) {
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.LongList
        public void getElements(int from, long[] a, int offset, int length) {
            if (offset < 0) {
                throw new ArrayIndexOutOfBoundsException("Offset (" + offset + ") is negative");
            } else if (offset + length > a.length) {
                throw new ArrayIndexOutOfBoundsException("End index (" + (offset + length) + ") is greater than array length (" + a.length + ")");
            } else if (from + length > size()) {
                throw new IndexOutOfBoundsException("End index (" + (from + length) + ") is greater than list size (" + size() + ")");
            } else if (length > 0) {
                a[offset] = this.element;
            }
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.LongList
        public void removeElements(int from, int to) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.LongList
        public void addElements(int index, long[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.LongList
        public void addElements(int index, long[] a, int offset, int length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        public void setElements(long[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        public void setElements(int index, long[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.LongList
        public void setElements(int index, long[] a, int offset, int length) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return 1;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.LongList
        public void size(int size) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // java.lang.Object
        public Object clone() {
            return this;
        }
    }

    public static LongList singleton(long element) {
        return new Singleton(element);
    }

    public static LongList singleton(Object element) {
        return new Singleton(((Long) element).longValue());
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.LongLists$SynchronizedList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongLists$SynchronizedList.class */
    public static class SynchronizedList extends LongCollections.SynchronizedCollection implements LongList, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final LongList list;

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.SynchronizedCollection, java.lang.Object
        public /* bridge */ /* synthetic */ String toString() {
            return toString();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ void clear() {
            clear();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
            return retainAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
            return removeAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean containsAll(Collection collection) {
            return containsAll(collection);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.Collection] */
        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean addAll(Collection<? extends Long> collection) {
            return addAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
        public /* bridge */ /* synthetic */ void forEach(LongConsumer longConsumer) {
            forEach(longConsumer);
        }

        /* Return type fixed from 'java.util.stream.Stream' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.longs.LongCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ Stream<Long> parallelStream() {
            return parallelStream();
        }

        /* Return type fixed from 'java.util.stream.Stream' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.longs.LongCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ Stream<Long> stream() {
            return stream();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.longs.LongCollection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongIterable
        public /* bridge */ /* synthetic */ LongSpliterator spliterator() {
            return spliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Object[] toArray(Object[] objArr) {
            return toArray(objArr);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public /* bridge */ /* synthetic */ LongStream longParallelStream() {
            return longParallelStream();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public /* bridge */ /* synthetic */ LongStream longStream() {
            return longStream();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
        public /* bridge */ /* synthetic */ LongSpliterator longSpliterator() {
            return longSpliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
        public /* bridge */ /* synthetic */ LongIterator longIterator() {
            return longIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.longs.LongCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean remove(Object obj) {
            return remove(obj);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.longs.LongCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean contains(Object obj) {
            return contains(obj);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean add(Long l) {
            return add(l);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public /* bridge */ /* synthetic */ boolean retainAll(LongCollection longCollection) {
            return retainAll(longCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public /* bridge */ /* synthetic */ boolean removeAll(LongCollection longCollection) {
            return removeAll(longCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public /* bridge */ /* synthetic */ boolean containsAll(LongCollection longCollection) {
            return containsAll(longCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public /* bridge */ /* synthetic */ boolean addAll(LongCollection longCollection) {
            return addAll(longCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public /* bridge */ /* synthetic */ long[] toArray(long[] jArr) {
            return toArray(jArr);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        @Deprecated
        public /* bridge */ /* synthetic */ long[] toLongArray(long[] jArr) {
            return toLongArray(jArr);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Object[] toArray() {
            return toArray();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public /* bridge */ /* synthetic */ long[] toLongArray() {
            return toLongArray();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean isEmpty() {
            return isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.SynchronizedCollection, java.util.Collection, p014it.unimi.dsi.fastutil.BigList, p014it.unimi.dsi.fastutil.Size64
        public /* bridge */ /* synthetic */ int size() {
            return size();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public /* bridge */ /* synthetic */ boolean rem(long j) {
            return rem(j);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public /* bridge */ /* synthetic */ boolean contains(long j) {
            return contains(j);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public /* bridge */ /* synthetic */ boolean add(long j) {
            return add(j);
        }

        protected SynchronizedList(LongList l, Object sync) {
            super(l, sync);
            this.list = l;
        }

        protected SynchronizedList(LongList l) {
            super(l);
            this.list = l;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        public long getLong(int i) {
            long j;
            synchronized (this.sync) {
                j = this.list.getLong(i);
            }
            return j;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        public long set(int i, long k) {
            long j;
            synchronized (this.sync) {
                j = this.list.set(i, k);
            }
            return j;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        public void add(int i, long k) {
            synchronized (this.sync) {
                this.list.add(i, k);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        public long removeLong(int i) {
            long removeLong;
            synchronized (this.sync) {
                removeLong = this.list.removeLong(i);
            }
            return removeLong;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        public int indexOf(long k) {
            int indexOf;
            synchronized (this.sync) {
                indexOf = this.list.indexOf(k);
            }
            return indexOf;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        public int lastIndexOf(long k) {
            int lastIndexOf;
            synchronized (this.sync) {
                lastIndexOf = this.list.lastIndexOf(k);
            }
            return lastIndexOf;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public boolean removeIf(LongPredicate filter) {
            boolean removeIf;
            synchronized (this.sync) {
                removeIf = this.list.removeIf(filter);
            }
            return removeIf;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        public void replaceAll(LongUnaryOperator operator) {
            synchronized (this.sync) {
                this.list.replaceAll(operator);
            }
        }

        @Override // java.util.List
        public boolean addAll(int index, Collection<? extends Long> c) {
            boolean addAll;
            synchronized (this.sync) {
                addAll = this.list.addAll(index, c);
            }
            return addAll;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        public void getElements(int from, long[] a, int offset, int length) {
            synchronized (this.sync) {
                this.list.getElements(from, a, offset, length);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        public void removeElements(int from, int to) {
            synchronized (this.sync) {
                this.list.removeElements(from, to);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        public void addElements(int index, long[] a, int offset, int length) {
            synchronized (this.sync) {
                this.list.addElements(index, a, offset, length);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        public void addElements(int index, long[] a) {
            synchronized (this.sync) {
                this.list.addElements(index, a);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        public void setElements(long[] a) {
            synchronized (this.sync) {
                this.list.setElements(a);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        public void setElements(int index, long[] a) {
            synchronized (this.sync) {
                this.list.setElements(index, a);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        public void setElements(int index, long[] a, int offset, int length) {
            synchronized (this.sync) {
                this.list.setElements(index, a, offset, length);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        public void size(int size) {
            synchronized (this.sync) {
                this.list.size(size);
            }
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.LongList, java.util.List
        public ListIterator<Long> listIterator() {
            return this.list.listIterator();
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.longs.LongListIterator] */
        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.longs.LongCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongIterable
        public LongListIterator iterator() {
            return listIterator();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.LongList, java.util.List
        public ListIterator<Long> listIterator(int i) {
            return this.list.listIterator(i);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongList' to match base method */
        /* JADX WARN: Type inference failed for: r2v2, types: [it.unimi.dsi.fastutil.longs.LongList] */
        @Override // p014it.unimi.dsi.fastutil.longs.LongList, java.util.List
        public List<Long> subList(int from, int to) {
            SynchronizedList synchronizedList;
            synchronized (this.sync) {
                synchronizedList = new SynchronizedList(this.list.subList(from, to), this.sync);
            }
            return synchronizedList;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.SynchronizedCollection, java.util.Collection, java.lang.Object
        public boolean equals(Object o) {
            boolean equals;
            if (o == this) {
                return true;
            }
            synchronized (this.sync) {
                equals = this.collection.equals(o);
            }
            return equals;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.SynchronizedCollection, java.util.Collection, java.lang.Object
        public int hashCode() {
            int hashCode;
            synchronized (this.sync) {
                hashCode = this.collection.hashCode();
            }
            return hashCode;
        }

        public int compareTo(List<? extends Long> o) {
            int compareTo;
            synchronized (this.sync) {
                compareTo = this.list.compareTo(o);
            }
            return compareTo;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        public boolean addAll(int index, LongCollection c) {
            boolean addAll;
            synchronized (this.sync) {
                addAll = this.list.addAll(index, c);
            }
            return addAll;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        public boolean addAll(int index, LongList l) {
            boolean addAll;
            synchronized (this.sync) {
                addAll = this.list.addAll(index, l);
            }
            return addAll;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        public boolean addAll(LongList l) {
            boolean addAll;
            synchronized (this.sync) {
                addAll = this.list.addAll(l);
            }
            return addAll;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList, java.util.List
        @Deprecated
        public Long get(int i) {
            Long l;
            synchronized (this.sync) {
                l = this.list.get(i);
            }
            return l;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        @Deprecated
        public void add(int i, Long k) {
            synchronized (this.sync) {
                this.list.add(i, k);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        @Deprecated
        public Long set(int index, Long k) {
            Long l;
            synchronized (this.sync) {
                l = this.list.set(index, k);
            }
            return l;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList, java.util.List
        @Deprecated
        public Long remove(int i) {
            Long remove;
            synchronized (this.sync) {
                remove = this.list.remove(i);
            }
            return remove;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList, java.util.List
        @Deprecated
        public int indexOf(Object o) {
            int indexOf;
            synchronized (this.sync) {
                indexOf = this.list.indexOf(o);
            }
            return indexOf;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList, java.util.List
        @Deprecated
        public int lastIndexOf(Object o) {
            int lastIndexOf;
            synchronized (this.sync) {
                lastIndexOf = this.list.lastIndexOf(o);
            }
            return lastIndexOf;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        public void sort(LongComparator comparator) {
            synchronized (this.sync) {
                this.list.sort(comparator);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        public void unstableSort(LongComparator comparator) {
            synchronized (this.sync) {
                this.list.unstableSort(comparator);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList, java.util.List
        @Deprecated
        public void sort(Comparator<? super Long> comparator) {
            synchronized (this.sync) {
                this.list.sort(comparator);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        @Deprecated
        public void unstableSort(Comparator<? super Long> comparator) {
            synchronized (this.sync) {
                this.list.unstableSort(comparator);
            }
        }

        private void writeObject(ObjectOutputStream s) throws IOException {
            synchronized (this.sync) {
                s.defaultWriteObject();
            }
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.LongLists$SynchronizedRandomAccessList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongLists$SynchronizedRandomAccessList.class */
    public static class SynchronizedRandomAccessList extends SynchronizedList implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;

        protected SynchronizedRandomAccessList(LongList l, Object sync) {
            super(l, sync);
        }

        protected SynchronizedRandomAccessList(LongList l) {
            super(l);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongList' to match base method */
        /* JADX WARN: Type inference failed for: r2v2, types: [it.unimi.dsi.fastutil.longs.LongList] */
        @Override // p014it.unimi.dsi.fastutil.longs.LongLists.SynchronizedList, p014it.unimi.dsi.fastutil.longs.LongList, java.util.List
        public List<Long> subList(int from, int to) {
            SynchronizedRandomAccessList synchronizedRandomAccessList;
            synchronized (this.sync) {
                synchronizedRandomAccessList = new SynchronizedRandomAccessList(this.list.subList(from, to), this.sync);
            }
            return synchronizedRandomAccessList;
        }
    }

    public static LongList synchronize(LongList l) {
        return l instanceof RandomAccess ? new SynchronizedRandomAccessList(l) : new SynchronizedList(l);
    }

    public static LongList synchronize(LongList l, Object sync) {
        return l instanceof RandomAccess ? new SynchronizedRandomAccessList(l, sync) : new SynchronizedList(l, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.LongLists$UnmodifiableList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongLists$UnmodifiableList.class */
    public static class UnmodifiableList extends LongCollections.UnmodifiableCollection implements LongList, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final LongList list;

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.UnmodifiableCollection, java.lang.Object
        public /* bridge */ /* synthetic */ String toString() {
            return toString();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public /* bridge */ /* synthetic */ LongStream longParallelStream() {
            return longParallelStream();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public /* bridge */ /* synthetic */ LongStream longStream() {
            return longStream();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
        public /* bridge */ /* synthetic */ LongSpliterator longSpliterator() {
            return longSpliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
        public /* bridge */ /* synthetic */ LongIterator longIterator() {
            return longIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public /* bridge */ /* synthetic */ boolean retainAll(LongCollection longCollection) {
            return retainAll(longCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public /* bridge */ /* synthetic */ boolean removeAll(LongCollection longCollection) {
            return removeAll(longCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public /* bridge */ /* synthetic */ boolean addAll(LongCollection longCollection) {
            return addAll(longCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public /* bridge */ /* synthetic */ boolean containsAll(LongCollection longCollection) {
            return containsAll(longCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public /* bridge */ /* synthetic */ long[] toArray(long[] jArr) {
            return toArray(jArr);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        @Deprecated
        public /* bridge */ /* synthetic */ long[] toLongArray(long[] jArr) {
            return toLongArray(jArr);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public /* bridge */ /* synthetic */ long[] toLongArray() {
            return toLongArray();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.longs.LongCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean remove(Object obj) {
            return remove(obj);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.longs.LongCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean contains(Object obj) {
            return contains(obj);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean add(Long l) {
            return add(l);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public /* bridge */ /* synthetic */ boolean removeIf(LongPredicate longPredicate) {
            return removeIf(longPredicate);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
            return retainAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
            return removeAll(collection);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.Collection] */
        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean addAll(Collection<? extends Long> collection) {
            return addAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean containsAll(Collection collection) {
            return containsAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
        public /* bridge */ /* synthetic */ void forEach(LongConsumer longConsumer) {
            forEach(longConsumer);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Object[] toArray() {
            return toArray();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Object[] toArray(Object[] objArr) {
            return toArray(objArr);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ void clear() {
            clear();
        }

        /* Return type fixed from 'java.util.stream.Stream' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.longs.LongCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ Stream<Long> parallelStream() {
            return parallelStream();
        }

        /* Return type fixed from 'java.util.stream.Stream' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.longs.LongCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ Stream<Long> stream() {
            return stream();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.longs.LongCollection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongIterable
        public /* bridge */ /* synthetic */ LongSpliterator spliterator() {
            return spliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public /* bridge */ /* synthetic */ boolean contains(long j) {
            return contains(j);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean isEmpty() {
            return isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.UnmodifiableCollection, java.util.Collection, p014it.unimi.dsi.fastutil.BigList, p014it.unimi.dsi.fastutil.Size64
        public /* bridge */ /* synthetic */ int size() {
            return size();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public /* bridge */ /* synthetic */ boolean rem(long j) {
            return rem(j);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public /* bridge */ /* synthetic */ boolean add(long j) {
            return add(j);
        }

        protected UnmodifiableList(LongList l) {
            super(l);
            this.list = l;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        public long getLong(int i) {
            return this.list.getLong(i);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        public long set(int i, long k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        public void add(int i, long k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        public long removeLong(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        public int indexOf(long k) {
            return this.list.indexOf(k);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        public int lastIndexOf(long k) {
            return this.list.lastIndexOf(k);
        }

        @Override // java.util.List
        public boolean addAll(int index, Collection<? extends Long> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList, java.util.List
        @Deprecated
        public void replaceAll(UnaryOperator<Long> operator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        public void getElements(int from, long[] a, int offset, int length) {
            this.list.getElements(from, a, offset, length);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        public void removeElements(int from, int to) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        public void addElements(int index, long[] a, int offset, int length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        public void addElements(int index, long[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        public void setElements(long[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        public void setElements(int index, long[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        public void setElements(int index, long[] a, int offset, int length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        public void size(int size) {
            this.list.size(size);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongListIterator' to match base method */
        /* JADX WARN: Type inference failed for: r0v2, types: [it.unimi.dsi.fastutil.longs.LongListIterator] */
        @Override // p014it.unimi.dsi.fastutil.longs.LongList, java.util.List
        public ListIterator<Long> listIterator() {
            return LongIterators.unmodifiable((LongListIterator) this.list.listIterator());
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.longs.LongListIterator] */
        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.longs.LongCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongIterable
        public LongListIterator iterator() {
            return listIterator();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongListIterator' to match base method */
        /* JADX WARN: Type inference failed for: r0v2, types: [it.unimi.dsi.fastutil.longs.LongListIterator] */
        @Override // p014it.unimi.dsi.fastutil.longs.LongList, java.util.List
        public ListIterator<Long> listIterator(int i) {
            return LongIterators.unmodifiable((LongListIterator) this.list.listIterator(i));
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongList' to match base method */
        /* JADX WARN: Type inference failed for: r2v2, types: [it.unimi.dsi.fastutil.longs.LongList] */
        @Override // p014it.unimi.dsi.fastutil.longs.LongList, java.util.List
        public List<Long> subList(int from, int to) {
            return new UnmodifiableList(this.list.subList(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.UnmodifiableCollection, java.util.Collection, java.lang.Object
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            return this.collection.equals(o);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.UnmodifiableCollection, java.util.Collection, java.lang.Object
        public int hashCode() {
            return this.collection.hashCode();
        }

        public int compareTo(List<? extends Long> o) {
            return this.list.compareTo(o);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        public boolean addAll(int index, LongCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        public boolean addAll(LongList l) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        public boolean addAll(int index, LongList l) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        public void replaceAll(LongUnaryOperator operator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList, java.util.List
        @Deprecated
        public Long get(int i) {
            return this.list.get(i);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        @Deprecated
        public void add(int i, Long k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        @Deprecated
        public Long set(int index, Long k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList, java.util.List
        @Deprecated
        public Long remove(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList, java.util.List
        @Deprecated
        public int indexOf(Object o) {
            return this.list.indexOf(o);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList, java.util.List
        @Deprecated
        public int lastIndexOf(Object o) {
            return this.list.lastIndexOf(o);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        public void sort(LongComparator comparator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        public void unstableSort(LongComparator comparator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList, java.util.List
        @Deprecated
        public void sort(Comparator<? super Long> comparator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        @Deprecated
        public void unstableSort(Comparator<? super Long> comparator) {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.LongLists$UnmodifiableRandomAccessList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongLists$UnmodifiableRandomAccessList.class */
    public static class UnmodifiableRandomAccessList extends UnmodifiableList implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;

        protected UnmodifiableRandomAccessList(LongList l) {
            super(l);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongList' to match base method */
        /* JADX WARN: Type inference failed for: r2v2, types: [it.unimi.dsi.fastutil.longs.LongList] */
        @Override // p014it.unimi.dsi.fastutil.longs.LongLists.UnmodifiableList, p014it.unimi.dsi.fastutil.longs.LongList, java.util.List
        public List<Long> subList(int from, int to) {
            return new UnmodifiableRandomAccessList(this.list.subList(from, to));
        }
    }

    public static LongList unmodifiable(LongList l) {
        return l instanceof RandomAccess ? new UnmodifiableRandomAccessList(l) : new UnmodifiableList(l);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: it.unimi.dsi.fastutil.longs.LongLists$ImmutableListBase */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongLists$ImmutableListBase.class */
    public static abstract class ImmutableListBase extends AbstractLongList implements LongList {
        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.LongList
        @Deprecated
        public final void add(int index, long k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        @Deprecated
        public final boolean add(long k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, java.util.AbstractCollection, java.util.Collection
        @Deprecated
        public final boolean addAll(Collection<? extends Long> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, java.util.List
        @Deprecated
        public final boolean addAll(int index, Collection<? extends Long> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.LongList
        @Deprecated
        public final long removeLong(int index) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        @Deprecated
        public final boolean rem(long k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, java.util.AbstractCollection, java.util.Collection
        @Deprecated
        public final boolean removeAll(Collection<?> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, java.util.AbstractCollection, java.util.Collection
        @Deprecated
        public final boolean retainAll(Collection<?> c) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection, p014it.unimi.dsi.fastutil.longs.LongCollection
        @Deprecated
        public final boolean removeIf(Predicate<? super Long> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollection
        @Deprecated
        public final boolean removeIf(LongPredicate c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList, java.util.List
        @Deprecated
        public final void replaceAll(UnaryOperator<Long> operator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        @Deprecated
        public final void replaceAll(LongUnaryOperator operator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        @Deprecated
        public final void add(int index, Long k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        @Deprecated
        public final boolean add(Long k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList, java.util.List
        @Deprecated
        public final Long remove(int index) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, java.util.AbstractCollection, java.util.Collection, p014it.unimi.dsi.fastutil.longs.LongCollection
        @Deprecated
        public final boolean remove(Object k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        @Deprecated
        public final Long set(int index, Long k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        @Deprecated
        public final boolean addAll(LongCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        @Deprecated
        public final boolean addAll(LongList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.LongList
        @Deprecated
        public final boolean addAll(int index, LongCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        @Deprecated
        public final boolean addAll(int index, LongList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        @Deprecated
        public final boolean removeAll(LongCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        @Deprecated
        public final boolean retainAll(LongCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.LongList
        @Deprecated
        public final long set(int index, long k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, java.util.AbstractCollection, java.util.Collection, java.util.List
        @Deprecated
        public final void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.LongList
        @Deprecated
        public final void size(int size) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.LongList
        @Deprecated
        public final void removeElements(int from, int to) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.LongList
        @Deprecated
        public final void addElements(int index, long[] a, int offset, int length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.LongList
        @Deprecated
        public final void setElements(int index, long[] a, int offset, int length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        @Deprecated
        public final void sort(LongComparator comp) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        @Deprecated
        public final void unstableSort(LongComparator comp) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList, java.util.List
        @Deprecated
        public final void sort(Comparator<? super Long> comparator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        @Deprecated
        public final void unstableSort(Comparator<? super Long> comparator) {
            throw new UnsupportedOperationException();
        }
    }
}
