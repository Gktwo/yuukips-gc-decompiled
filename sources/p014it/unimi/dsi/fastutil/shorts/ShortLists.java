package p014it.unimi.dsi.fastutil.shorts;

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
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import okhttp3.HttpUrl;
import p014it.unimi.dsi.fastutil.ints.IntIterator;
import p014it.unimi.dsi.fastutil.ints.IntIterators;
import p014it.unimi.dsi.fastutil.ints.IntSpliterator;
import p014it.unimi.dsi.fastutil.ints.IntSpliterators;
import p014it.unimi.dsi.fastutil.shorts.ShortCollections;

/* renamed from: it.unimi.dsi.fastutil.shorts.ShortLists */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortLists.class */
public final class ShortLists {
    public static final EmptyList EMPTY_LIST = new EmptyList();

    private ShortLists() {
    }

    public static ShortList shuffle(ShortList l, Random random) {
        int i = l.size();
        while (true) {
            i--;
            if (i == 0) {
                return l;
            }
            int p = random.nextInt(i + 1);
            short t = l.getShort(i);
            l.set(i, l.getShort(p));
            l.set(p, t);
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortLists$EmptyList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortLists$EmptyList.class */
    public static class EmptyList extends ShortCollections.EmptyCollection implements ShortList, RandomAccess, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptyList() {
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        public short getShort(int i) {
            throw new IndexOutOfBoundsException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public boolean rem(short k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        public short removeShort(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        public void add(int index, short k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        public short set(int index, short k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        public int indexOf(short k) {
            return -1;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        public int lastIndexOf(short k) {
            return -1;
        }

        @Override // java.util.List
        public boolean addAll(int i, Collection<? extends Short> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList, java.util.List
        @Deprecated
        public void replaceAll(UnaryOperator<Short> operator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        public void replaceAll(ShortUnaryOperator operator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        public boolean addAll(ShortList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        public boolean addAll(int i, ShortCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        public boolean addAll(int i, ShortList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        @Deprecated
        public void add(int index, Short k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList, java.util.List
        @Deprecated
        public Short get(int index) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        @Deprecated
        public boolean add(Short k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        @Deprecated
        public Short set(int index, Short k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList, java.util.List
        @Deprecated
        public Short remove(int k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList, java.util.List
        @Deprecated
        public int indexOf(Object k) {
            return -1;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList, java.util.List
        @Deprecated
        public int lastIndexOf(Object k) {
            return -1;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        public void sort(ShortComparator comparator) {
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        public void unstableSort(ShortComparator comparator) {
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList, java.util.List
        @Deprecated
        public void sort(Comparator<? super Short> comparator) {
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        @Deprecated
        public void unstableSort(Comparator<? super Short> comparator) {
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList, java.util.List
        public ListIterator<Short> listIterator() {
            return ShortIterators.EMPTY_ITERATOR;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.EmptyCollection, p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public ShortListIterator iterator() {
            return ShortIterators.EMPTY_ITERATOR;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList, java.util.List
        public ListIterator<Short> listIterator(int i) {
            if (i == 0) {
                return ShortIterators.EMPTY_ITERATOR;
            }
            throw new IndexOutOfBoundsException(String.valueOf(i));
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortList' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList, java.util.List
        public List<Short> subList(int from, int to) {
            if (from == 0 && to == 0) {
                return this;
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        public void getElements(int from, short[] a, int offset, int length) {
            if (from != 0 || length != 0 || offset < 0 || offset > a.length) {
                throw new IndexOutOfBoundsException();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        public void removeElements(int from, int to) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        public void addElements(int index, short[] a, int offset, int length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        public void addElements(int index, short[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        public void setElements(short[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        public void setElements(int index, short[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        public void setElements(int index, short[] a, int offset, int length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        public void size(int s) {
            throw new UnsupportedOperationException();
        }

        public int compareTo(List<? extends Short> o) {
            return (o != this && !o.isEmpty()) ? -1 : 0;
        }

        @Override // java.lang.Object
        public Object clone() {
            return ShortLists.EMPTY_LIST;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.EmptyCollection, java.util.Collection, java.lang.Object
        public int hashCode() {
            return 1;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.EmptyCollection, java.util.Collection, java.lang.Object
        public boolean equals(Object o) {
            return (o instanceof List) && ((List) o).isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, java.util.AbstractCollection, java.lang.Object
        public String toString() {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }

        private Object readResolve() {
            return ShortLists.EMPTY_LIST;
        }
    }

    public static ShortList emptyList() {
        return EMPTY_LIST;
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortLists$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortLists$Singleton.class */
    public static class Singleton extends AbstractShortList implements RandomAccess, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        private final short element;

        protected Singleton(short element) {
            this.element = element;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        public short getShort(int i) {
            if (i == 0) {
                return this.element;
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public boolean rem(short k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.ShortList
        public short removeShort(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public boolean contains(short k) {
            return k == this.element;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.ShortList
        public int indexOf(short k) {
            return k == this.element ? 0 : -1;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public short[] toShortArray() {
            return new short[]{this.element};
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.ShortList, java.util.List
        public ListIterator<Short> listIterator() {
            return ShortIterators.singleton(this.element);
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.shorts.ShortListIterator] */
        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public ShortListIterator iterator() {
            return listIterator();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public ShortSpliterator spliterator() {
            return ShortSpliterators.singleton(this.element);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortListIterator' to match base method */
        /* JADX WARN: Type inference failed for: r0v4, types: [it.unimi.dsi.fastutil.shorts.ShortListIterator, java.util.ListIterator<java.lang.Short>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.ShortList, java.util.List
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.util.ListIterator<java.lang.Short> listIterator(int r4) {
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
                it.unimi.dsi.fastutil.shorts.ShortListIterator r0 = r0.listIterator()
                r5 = r0
                r0 = r4
                r1 = 1
                if (r0 != r1) goto L_0x0022
                r0 = r5
                short r0 = r0.nextShort()
            L_0x0022:
                r0 = r5
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.shorts.ShortLists.Singleton.listIterator(int):it.unimi.dsi.fastutil.shorts.ShortListIterator");
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortList' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.ShortList, java.util.List
        public List<Short> subList(int from, int to) {
            ensureIndex(from);
            ensureIndex(to);
            if (from <= to) {
                return (from == 0 && to == 1) ? this : ShortLists.EMPTY_LIST;
            }
            throw new IndexOutOfBoundsException("Start index (" + from + ") is greater than end index (" + to + ")");
        }

        @Override // java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        @Deprecated
        public void forEach(Consumer<? super Short> action) {
            action.accept(Short.valueOf(this.element));
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, java.util.List
        public boolean addAll(int i, Collection<? extends Short> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection<? extends Short> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> c) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        @Deprecated
        public boolean removeIf(Predicate<? super Short> filter) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList, java.util.List
        @Deprecated
        public void replaceAll(UnaryOperator<Short> operator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        public void replaceAll(ShortUnaryOperator operator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public void forEach(ShortConsumer action) {
            action.accept(this.element);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        public boolean addAll(ShortList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        public boolean addAll(int i, ShortList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.ShortList
        public boolean addAll(int i, ShortCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public boolean addAll(ShortCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public boolean removeAll(ShortCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public boolean retainAll(ShortCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public boolean removeIf(ShortPredicate filter) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public IntIterator intIterator() {
            return IntIterators.singleton(this.element);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public IntSpliterator intSpliterator() {
            return IntSpliterators.singleton(this.element);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        @Deprecated
        public Object[] toArray() {
            return new Object[]{Short.valueOf(this.element)};
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        public void sort(ShortComparator comparator) {
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        public void unstableSort(ShortComparator comparator) {
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList, java.util.List
        @Deprecated
        public void sort(Comparator<? super Short> comparator) {
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        @Deprecated
        public void unstableSort(Comparator<? super Short> comparator) {
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.ShortList
        public void getElements(int from, short[] a, int offset, int length) {
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

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.ShortList
        public void removeElements(int from, int to) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.ShortList
        public void addElements(int index, short[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.ShortList
        public void addElements(int index, short[] a, int offset, int length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        public void setElements(short[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        public void setElements(int index, short[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.ShortList
        public void setElements(int index, short[] a, int offset, int length) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return 1;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.ShortList
        public void size(int size) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // java.lang.Object
        public Object clone() {
            return this;
        }
    }

    public static ShortList singleton(short element) {
        return new Singleton(element);
    }

    public static ShortList singleton(Object element) {
        return new Singleton(((Short) element).shortValue());
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortLists$SynchronizedList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortLists$SynchronizedList.class */
    public static class SynchronizedList extends ShortCollections.SynchronizedCollection implements ShortList, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final ShortList list;

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.SynchronizedCollection, java.lang.Object
        public /* bridge */ /* synthetic */ String toString() {
            return toString();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ void clear() {
            clear();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
            return retainAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
            return removeAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean containsAll(Collection collection) {
            return containsAll(collection);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.Collection] */
        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean addAll(Collection<? extends Short> collection) {
            return addAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public /* bridge */ /* synthetic */ void forEach(ShortConsumer shortConsumer) {
            forEach(shortConsumer);
        }

        /* Return type fixed from 'java.util.stream.Stream' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ Stream<Short> parallelStream() {
            return parallelStream();
        }

        /* Return type fixed from 'java.util.stream.Stream' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ Stream<Short> stream() {
            return stream();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public /* bridge */ /* synthetic */ ShortSpliterator spliterator() {
            return spliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Object[] toArray(Object[] objArr) {
            return toArray(objArr);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public /* bridge */ /* synthetic */ IntStream intParallelStream() {
            return intParallelStream();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public /* bridge */ /* synthetic */ IntStream intStream() {
            return intStream();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public /* bridge */ /* synthetic */ IntSpliterator intSpliterator() {
            return intSpliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public /* bridge */ /* synthetic */ IntIterator intIterator() {
            return intIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean remove(Object obj) {
            return remove(obj);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean contains(Object obj) {
            return contains(obj);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean add(Short sh) {
            return add(sh);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public /* bridge */ /* synthetic */ boolean retainAll(ShortCollection shortCollection) {
            return retainAll(shortCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public /* bridge */ /* synthetic */ boolean removeAll(ShortCollection shortCollection) {
            return removeAll(shortCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public /* bridge */ /* synthetic */ boolean containsAll(ShortCollection shortCollection) {
            return containsAll(shortCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public /* bridge */ /* synthetic */ boolean addAll(ShortCollection shortCollection) {
            return addAll(shortCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public /* bridge */ /* synthetic */ short[] toArray(short[] sArr) {
            return toArray(sArr);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        @Deprecated
        public /* bridge */ /* synthetic */ short[] toShortArray(short[] sArr) {
            return toShortArray(sArr);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Object[] toArray() {
            return toArray();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public /* bridge */ /* synthetic */ short[] toShortArray() {
            return toShortArray();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean isEmpty() {
            return isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.SynchronizedCollection, java.util.Collection, p014it.unimi.dsi.fastutil.BigList, p014it.unimi.dsi.fastutil.Size64
        public /* bridge */ /* synthetic */ int size() {
            return size();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public /* bridge */ /* synthetic */ boolean rem(short s) {
            return rem(s);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public /* bridge */ /* synthetic */ boolean contains(short s) {
            return contains(s);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public /* bridge */ /* synthetic */ boolean add(short s) {
            return add(s);
        }

        protected SynchronizedList(ShortList l, Object sync) {
            super(l, sync);
            this.list = l;
        }

        protected SynchronizedList(ShortList l) {
            super(l);
            this.list = l;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        public short getShort(int i) {
            short s;
            synchronized (this.sync) {
                s = this.list.getShort(i);
            }
            return s;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        public short set(int i, short k) {
            short s;
            synchronized (this.sync) {
                s = this.list.set(i, k);
            }
            return s;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        public void add(int i, short k) {
            synchronized (this.sync) {
                this.list.add(i, k);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        public short removeShort(int i) {
            short removeShort;
            synchronized (this.sync) {
                removeShort = this.list.removeShort(i);
            }
            return removeShort;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        public int indexOf(short k) {
            int indexOf;
            synchronized (this.sync) {
                indexOf = this.list.indexOf(k);
            }
            return indexOf;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        public int lastIndexOf(short k) {
            int lastIndexOf;
            synchronized (this.sync) {
                lastIndexOf = this.list.lastIndexOf(k);
            }
            return lastIndexOf;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public boolean removeIf(ShortPredicate filter) {
            boolean removeIf;
            synchronized (this.sync) {
                removeIf = this.list.removeIf(filter);
            }
            return removeIf;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        public void replaceAll(ShortUnaryOperator operator) {
            synchronized (this.sync) {
                this.list.replaceAll(operator);
            }
        }

        @Override // java.util.List
        public boolean addAll(int index, Collection<? extends Short> c) {
            boolean addAll;
            synchronized (this.sync) {
                addAll = this.list.addAll(index, c);
            }
            return addAll;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        public void getElements(int from, short[] a, int offset, int length) {
            synchronized (this.sync) {
                this.list.getElements(from, a, offset, length);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        public void removeElements(int from, int to) {
            synchronized (this.sync) {
                this.list.removeElements(from, to);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        public void addElements(int index, short[] a, int offset, int length) {
            synchronized (this.sync) {
                this.list.addElements(index, a, offset, length);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        public void addElements(int index, short[] a) {
            synchronized (this.sync) {
                this.list.addElements(index, a);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        public void setElements(short[] a) {
            synchronized (this.sync) {
                this.list.setElements(a);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        public void setElements(int index, short[] a) {
            synchronized (this.sync) {
                this.list.setElements(index, a);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        public void setElements(int index, short[] a, int offset, int length) {
            synchronized (this.sync) {
                this.list.setElements(index, a, offset, length);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        public void size(int size) {
            synchronized (this.sync) {
                this.list.size(size);
            }
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList, java.util.List
        public ListIterator<Short> listIterator() {
            return this.list.listIterator();
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.shorts.ShortListIterator] */
        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public ShortListIterator iterator() {
            return listIterator();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList, java.util.List
        public ListIterator<Short> listIterator(int i) {
            return this.list.listIterator(i);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortList' to match base method */
        /* JADX WARN: Type inference failed for: r2v2, types: [it.unimi.dsi.fastutil.shorts.ShortList] */
        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList, java.util.List
        public List<Short> subList(int from, int to) {
            SynchronizedList synchronizedList;
            synchronized (this.sync) {
                synchronizedList = new SynchronizedList(this.list.subList(from, to), this.sync);
            }
            return synchronizedList;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.SynchronizedCollection, java.util.Collection, java.lang.Object
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

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.SynchronizedCollection, java.util.Collection, java.lang.Object
        public int hashCode() {
            int hashCode;
            synchronized (this.sync) {
                hashCode = this.collection.hashCode();
            }
            return hashCode;
        }

        public int compareTo(List<? extends Short> o) {
            int compareTo;
            synchronized (this.sync) {
                compareTo = this.list.compareTo(o);
            }
            return compareTo;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        public boolean addAll(int index, ShortCollection c) {
            boolean addAll;
            synchronized (this.sync) {
                addAll = this.list.addAll(index, c);
            }
            return addAll;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        public boolean addAll(int index, ShortList l) {
            boolean addAll;
            synchronized (this.sync) {
                addAll = this.list.addAll(index, l);
            }
            return addAll;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        public boolean addAll(ShortList l) {
            boolean addAll;
            synchronized (this.sync) {
                addAll = this.list.addAll(l);
            }
            return addAll;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList, java.util.List
        @Deprecated
        public Short get(int i) {
            Short sh;
            synchronized (this.sync) {
                sh = this.list.get(i);
            }
            return sh;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        @Deprecated
        public void add(int i, Short k) {
            synchronized (this.sync) {
                this.list.add(i, k);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        @Deprecated
        public Short set(int index, Short k) {
            Short sh;
            synchronized (this.sync) {
                sh = this.list.set(index, k);
            }
            return sh;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList, java.util.List
        @Deprecated
        public Short remove(int i) {
            Short remove;
            synchronized (this.sync) {
                remove = this.list.remove(i);
            }
            return remove;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList, java.util.List
        @Deprecated
        public int indexOf(Object o) {
            int indexOf;
            synchronized (this.sync) {
                indexOf = this.list.indexOf(o);
            }
            return indexOf;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList, java.util.List
        @Deprecated
        public int lastIndexOf(Object o) {
            int lastIndexOf;
            synchronized (this.sync) {
                lastIndexOf = this.list.lastIndexOf(o);
            }
            return lastIndexOf;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        public void sort(ShortComparator comparator) {
            synchronized (this.sync) {
                this.list.sort(comparator);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        public void unstableSort(ShortComparator comparator) {
            synchronized (this.sync) {
                this.list.unstableSort(comparator);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList, java.util.List
        @Deprecated
        public void sort(Comparator<? super Short> comparator) {
            synchronized (this.sync) {
                this.list.sort(comparator);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        @Deprecated
        public void unstableSort(Comparator<? super Short> comparator) {
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

    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortLists$SynchronizedRandomAccessList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortLists$SynchronizedRandomAccessList.class */
    public static class SynchronizedRandomAccessList extends SynchronizedList implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;

        protected SynchronizedRandomAccessList(ShortList l, Object sync) {
            super(l, sync);
        }

        protected SynchronizedRandomAccessList(ShortList l) {
            super(l);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortList' to match base method */
        /* JADX WARN: Type inference failed for: r2v2, types: [it.unimi.dsi.fastutil.shorts.ShortList] */
        @Override // p014it.unimi.dsi.fastutil.shorts.ShortLists.SynchronizedList, p014it.unimi.dsi.fastutil.shorts.ShortList, java.util.List
        public List<Short> subList(int from, int to) {
            SynchronizedRandomAccessList synchronizedRandomAccessList;
            synchronized (this.sync) {
                synchronizedRandomAccessList = new SynchronizedRandomAccessList(this.list.subList(from, to), this.sync);
            }
            return synchronizedRandomAccessList;
        }
    }

    public static ShortList synchronize(ShortList l) {
        return l instanceof RandomAccess ? new SynchronizedRandomAccessList(l) : new SynchronizedList(l);
    }

    public static ShortList synchronize(ShortList l, Object sync) {
        return l instanceof RandomAccess ? new SynchronizedRandomAccessList(l, sync) : new SynchronizedList(l, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortLists$UnmodifiableList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortLists$UnmodifiableList.class */
    public static class UnmodifiableList extends ShortCollections.UnmodifiableCollection implements ShortList, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final ShortList list;

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.UnmodifiableCollection, java.lang.Object
        public /* bridge */ /* synthetic */ String toString() {
            return toString();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public /* bridge */ /* synthetic */ IntStream intParallelStream() {
            return intParallelStream();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public /* bridge */ /* synthetic */ IntStream intStream() {
            return intStream();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public /* bridge */ /* synthetic */ IntSpliterator intSpliterator() {
            return intSpliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public /* bridge */ /* synthetic */ IntIterator intIterator() {
            return intIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public /* bridge */ /* synthetic */ boolean retainAll(ShortCollection shortCollection) {
            return retainAll(shortCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public /* bridge */ /* synthetic */ boolean removeAll(ShortCollection shortCollection) {
            return removeAll(shortCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public /* bridge */ /* synthetic */ boolean addAll(ShortCollection shortCollection) {
            return addAll(shortCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public /* bridge */ /* synthetic */ boolean containsAll(ShortCollection shortCollection) {
            return containsAll(shortCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public /* bridge */ /* synthetic */ short[] toArray(short[] sArr) {
            return toArray(sArr);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        @Deprecated
        public /* bridge */ /* synthetic */ short[] toShortArray(short[] sArr) {
            return toShortArray(sArr);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public /* bridge */ /* synthetic */ short[] toShortArray() {
            return toShortArray();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean remove(Object obj) {
            return remove(obj);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean contains(Object obj) {
            return contains(obj);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean add(Short sh) {
            return add(sh);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public /* bridge */ /* synthetic */ boolean removeIf(ShortPredicate shortPredicate) {
            return removeIf(shortPredicate);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
            return retainAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
            return removeAll(collection);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.Collection] */
        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean addAll(Collection<? extends Short> collection) {
            return addAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean containsAll(Collection collection) {
            return containsAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public /* bridge */ /* synthetic */ void forEach(ShortConsumer shortConsumer) {
            forEach(shortConsumer);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Object[] toArray() {
            return toArray();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Object[] toArray(Object[] objArr) {
            return toArray(objArr);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ void clear() {
            clear();
        }

        /* Return type fixed from 'java.util.stream.Stream' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ Stream<Short> parallelStream() {
            return parallelStream();
        }

        /* Return type fixed from 'java.util.stream.Stream' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ Stream<Short> stream() {
            return stream();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public /* bridge */ /* synthetic */ ShortSpliterator spliterator() {
            return spliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public /* bridge */ /* synthetic */ boolean contains(short s) {
            return contains(s);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean isEmpty() {
            return isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.UnmodifiableCollection, java.util.Collection, p014it.unimi.dsi.fastutil.BigList, p014it.unimi.dsi.fastutil.Size64
        public /* bridge */ /* synthetic */ int size() {
            return size();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public /* bridge */ /* synthetic */ boolean rem(short s) {
            return rem(s);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public /* bridge */ /* synthetic */ boolean add(short s) {
            return add(s);
        }

        protected UnmodifiableList(ShortList l) {
            super(l);
            this.list = l;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        public short getShort(int i) {
            return this.list.getShort(i);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        public short set(int i, short k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        public void add(int i, short k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        public short removeShort(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        public int indexOf(short k) {
            return this.list.indexOf(k);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        public int lastIndexOf(short k) {
            return this.list.lastIndexOf(k);
        }

        @Override // java.util.List
        public boolean addAll(int index, Collection<? extends Short> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList, java.util.List
        @Deprecated
        public void replaceAll(UnaryOperator<Short> operator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        public void getElements(int from, short[] a, int offset, int length) {
            this.list.getElements(from, a, offset, length);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        public void removeElements(int from, int to) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        public void addElements(int index, short[] a, int offset, int length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        public void addElements(int index, short[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        public void setElements(short[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        public void setElements(int index, short[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        public void setElements(int index, short[] a, int offset, int length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        public void size(int size) {
            this.list.size(size);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortListIterator' to match base method */
        /* JADX WARN: Type inference failed for: r0v2, types: [it.unimi.dsi.fastutil.shorts.ShortListIterator] */
        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList, java.util.List
        public ListIterator<Short> listIterator() {
            return ShortIterators.unmodifiable((ShortListIterator) this.list.listIterator());
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.shorts.ShortListIterator] */
        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public ShortListIterator iterator() {
            return listIterator();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortListIterator' to match base method */
        /* JADX WARN: Type inference failed for: r0v2, types: [it.unimi.dsi.fastutil.shorts.ShortListIterator] */
        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList, java.util.List
        public ListIterator<Short> listIterator(int i) {
            return ShortIterators.unmodifiable((ShortListIterator) this.list.listIterator(i));
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortList' to match base method */
        /* JADX WARN: Type inference failed for: r2v2, types: [it.unimi.dsi.fastutil.shorts.ShortList] */
        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList, java.util.List
        public List<Short> subList(int from, int to) {
            return new UnmodifiableList(this.list.subList(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.UnmodifiableCollection, java.util.Collection, java.lang.Object
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            return this.collection.equals(o);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.UnmodifiableCollection, java.util.Collection, java.lang.Object
        public int hashCode() {
            return this.collection.hashCode();
        }

        public int compareTo(List<? extends Short> o) {
            return this.list.compareTo(o);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        public boolean addAll(int index, ShortCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        public boolean addAll(ShortList l) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        public boolean addAll(int index, ShortList l) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        public void replaceAll(IntUnaryOperator operator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList, java.util.List
        @Deprecated
        public Short get(int i) {
            return this.list.get(i);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        @Deprecated
        public void add(int i, Short k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        @Deprecated
        public Short set(int index, Short k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList, java.util.List
        @Deprecated
        public Short remove(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList, java.util.List
        @Deprecated
        public int indexOf(Object o) {
            return this.list.indexOf(o);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList, java.util.List
        @Deprecated
        public int lastIndexOf(Object o) {
            return this.list.lastIndexOf(o);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        public void sort(ShortComparator comparator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        public void unstableSort(ShortComparator comparator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList, java.util.List
        @Deprecated
        public void sort(Comparator<? super Short> comparator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        @Deprecated
        public void unstableSort(Comparator<? super Short> comparator) {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortLists$UnmodifiableRandomAccessList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortLists$UnmodifiableRandomAccessList.class */
    public static class UnmodifiableRandomAccessList extends UnmodifiableList implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;

        protected UnmodifiableRandomAccessList(ShortList l) {
            super(l);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortList' to match base method */
        /* JADX WARN: Type inference failed for: r2v2, types: [it.unimi.dsi.fastutil.shorts.ShortList] */
        @Override // p014it.unimi.dsi.fastutil.shorts.ShortLists.UnmodifiableList, p014it.unimi.dsi.fastutil.shorts.ShortList, java.util.List
        public List<Short> subList(int from, int to) {
            return new UnmodifiableRandomAccessList(this.list.subList(from, to));
        }
    }

    public static ShortList unmodifiable(ShortList l) {
        return l instanceof RandomAccess ? new UnmodifiableRandomAccessList(l) : new UnmodifiableList(l);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortLists$ImmutableListBase */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortLists$ImmutableListBase.class */
    public static abstract class ImmutableListBase extends AbstractShortList implements ShortList {
        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.ShortList
        @Deprecated
        public final void add(int index, short k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        @Deprecated
        public final boolean add(short k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, java.util.AbstractCollection, java.util.Collection
        @Deprecated
        public final boolean addAll(Collection<? extends Short> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, java.util.List
        @Deprecated
        public final boolean addAll(int index, Collection<? extends Short> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.ShortList
        @Deprecated
        public final short removeShort(int index) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        @Deprecated
        public final boolean rem(short k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, java.util.AbstractCollection, java.util.Collection
        @Deprecated
        public final boolean removeAll(Collection<?> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, java.util.AbstractCollection, java.util.Collection
        @Deprecated
        public final boolean retainAll(Collection<?> c) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        @Deprecated
        public final boolean removeIf(Predicate<? super Short> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollection
        @Deprecated
        public final boolean removeIf(ShortPredicate c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList, java.util.List
        @Deprecated
        public final void replaceAll(UnaryOperator<Short> operator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        @Deprecated
        public final void replaceAll(IntUnaryOperator operator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        @Deprecated
        public final void add(int index, Short k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        @Deprecated
        public final boolean add(Short k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList, java.util.List
        @Deprecated
        public final Short remove(int index) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, java.util.AbstractCollection, java.util.Collection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        @Deprecated
        public final boolean remove(Object k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        @Deprecated
        public final Short set(int index, Short k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        @Deprecated
        public final boolean addAll(ShortCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        @Deprecated
        public final boolean addAll(ShortList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.ShortList
        @Deprecated
        public final boolean addAll(int index, ShortCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        @Deprecated
        public final boolean addAll(int index, ShortList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        @Deprecated
        public final boolean removeAll(ShortCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        @Deprecated
        public final boolean retainAll(ShortCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.ShortList
        @Deprecated
        public final short set(int index, short k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, java.util.AbstractCollection, java.util.Collection, java.util.List
        @Deprecated
        public final void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.ShortList
        @Deprecated
        public final void size(int size) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.ShortList
        @Deprecated
        public final void removeElements(int from, int to) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.ShortList
        @Deprecated
        public final void addElements(int index, short[] a, int offset, int length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.ShortList
        @Deprecated
        public final void setElements(int index, short[] a, int offset, int length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        @Deprecated
        public final void sort(ShortComparator comp) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        @Deprecated
        public final void unstableSort(ShortComparator comp) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList, java.util.List
        @Deprecated
        public final void sort(Comparator<? super Short> comparator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        @Deprecated
        public final void unstableSort(Comparator<? super Short> comparator) {
            throw new UnsupportedOperationException();
        }
    }
}
