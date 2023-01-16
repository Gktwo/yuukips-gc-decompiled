package p014it.unimi.dsi.fastutil.ints;

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
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import okhttp3.HttpUrl;
import p014it.unimi.dsi.fastutil.ints.IntCollections;

/* renamed from: it.unimi.dsi.fastutil.ints.IntLists */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntLists.class */
public final class IntLists {
    public static final EmptyList EMPTY_LIST = new EmptyList();

    private IntLists() {
    }

    public static IntList shuffle(IntList l, Random random) {
        int i = l.size();
        while (true) {
            i--;
            if (i == 0) {
                return l;
            }
            int p = random.nextInt(i + 1);
            int t = l.getInt(i);
            l.set(i, l.getInt(p));
            l.set(p, t);
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.IntLists$EmptyList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntLists$EmptyList.class */
    public static class EmptyList extends IntCollections.EmptyCollection implements IntList, RandomAccess, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptyList() {
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        public int getInt(int i) {
            throw new IndexOutOfBoundsException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public boolean rem(int k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        public int removeInt(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        public void add(int index, int k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        public int set(int index, int k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        public int indexOf(int k) {
            return -1;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        public int lastIndexOf(int k) {
            return -1;
        }

        @Override // java.util.List
        public boolean addAll(int i, Collection<? extends Integer> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList, java.util.List
        @Deprecated
        public void replaceAll(UnaryOperator<Integer> operator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        public void replaceAll(IntUnaryOperator operator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        public boolean addAll(IntList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        public boolean addAll(int i, IntCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        public boolean addAll(int i, IntList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        @Deprecated
        public void add(int index, Integer k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList, java.util.List
        @Deprecated
        public Integer get(int index) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        @Deprecated
        public boolean add(Integer k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        @Deprecated
        public Integer set(int index, Integer k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList, java.util.List
        @Deprecated
        public Integer remove(int k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList, java.util.List
        @Deprecated
        public int indexOf(Object k) {
            return -1;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList, java.util.List
        @Deprecated
        public int lastIndexOf(Object k) {
            return -1;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        public void sort(IntComparator comparator) {
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        public void unstableSort(IntComparator comparator) {
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList, java.util.List
        @Deprecated
        public void sort(Comparator<? super Integer> comparator) {
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        @Deprecated
        public void unstableSort(Comparator<? super Integer> comparator) {
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.IntList, java.util.List
        public ListIterator<Integer> listIterator() {
            return IntIterators.EMPTY_ITERATOR;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.EmptyCollection, p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
        public IntListIterator iterator() {
            return IntIterators.EMPTY_ITERATOR;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.IntList, java.util.List
        public ListIterator<Integer> listIterator(int i) {
            if (i == 0) {
                return IntIterators.EMPTY_ITERATOR;
            }
            throw new IndexOutOfBoundsException(String.valueOf(i));
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntList' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.IntList, java.util.List
        public List<Integer> subList(int from, int to) {
            if (from == 0 && to == 0) {
                return this;
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        public void getElements(int from, int[] a, int offset, int length) {
            if (from != 0 || length != 0 || offset < 0 || offset > a.length) {
                throw new IndexOutOfBoundsException();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        public void removeElements(int from, int to) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        public void addElements(int index, int[] a, int offset, int length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        public void addElements(int index, int[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        public void setElements(int[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        public void setElements(int index, int[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        public void setElements(int index, int[] a, int offset, int length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        public void size(int s) {
            throw new UnsupportedOperationException();
        }

        public int compareTo(List<? extends Integer> o) {
            return (o != this && !o.isEmpty()) ? -1 : 0;
        }

        @Override // java.lang.Object
        public Object clone() {
            return IntLists.EMPTY_LIST;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.EmptyCollection, java.util.Collection, java.lang.Object
        public int hashCode() {
            return 1;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.EmptyCollection, java.util.Collection, java.lang.Object
        public boolean equals(Object o) {
            return (o instanceof List) && ((List) o).isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, java.util.AbstractCollection, java.lang.Object
        public String toString() {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }

        private Object readResolve() {
            return IntLists.EMPTY_LIST;
        }
    }

    public static IntList emptyList() {
        return EMPTY_LIST;
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.IntLists$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntLists$Singleton.class */
    public static class Singleton extends AbstractIntList implements RandomAccess, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        private final int element;

        protected Singleton(int element) {
            this.element = element;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        public int getInt(int i) {
            if (i == 0) {
                return this.element;
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntList, p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public boolean rem(int k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntList, p014it.unimi.dsi.fastutil.ints.IntList
        public int removeInt(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntList, p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public boolean contains(int k) {
            return k == this.element;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntList, p014it.unimi.dsi.fastutil.ints.IntList
        public int indexOf(int k) {
            return k == this.element ? 0 : -1;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntList, p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public int[] toIntArray() {
            return new int[]{this.element};
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntList, p014it.unimi.dsi.fastutil.ints.IntList, java.util.List
        public ListIterator<Integer> listIterator() {
            return IntIterators.singleton(this.element);
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.ints.IntListIterator] */
        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntList, p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
        public IntListIterator iterator() {
            return listIterator();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
        public IntSpliterator spliterator() {
            return IntSpliterators.singleton(this.element);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntListIterator' to match base method */
        /* JADX WARN: Type inference failed for: r0v4, types: [java.util.ListIterator<java.lang.Integer>, it.unimi.dsi.fastutil.ints.IntListIterator] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntList, p014it.unimi.dsi.fastutil.ints.IntList, java.util.List
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.util.ListIterator<java.lang.Integer> listIterator(int r4) {
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
                it.unimi.dsi.fastutil.ints.IntListIterator r0 = r0.listIterator()
                r5 = r0
                r0 = r4
                r1 = 1
                if (r0 != r1) goto L_0x0022
                r0 = r5
                int r0 = r0.nextInt()
            L_0x0022:
                r0 = r5
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.ints.IntLists.Singleton.listIterator(int):it.unimi.dsi.fastutil.ints.IntListIterator");
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntList' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntList, p014it.unimi.dsi.fastutil.ints.IntList, java.util.List
        public List<Integer> subList(int from, int to) {
            ensureIndex(from);
            ensureIndex(to);
            if (from <= to) {
                return (from == 0 && to == 1) ? this : IntLists.EMPTY_LIST;
            }
            throw new IndexOutOfBoundsException("Start index (" + from + ") is greater than end index (" + to + ")");
        }

        @Override // java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntIterable
        @Deprecated
        public void forEach(Consumer<? super Integer> action) {
            action.accept(Integer.valueOf(this.element));
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntList, java.util.List
        public boolean addAll(int i, Collection<? extends Integer> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntList, p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection<? extends Integer> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> c) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection, p014it.unimi.dsi.fastutil.ints.IntCollection
        @Deprecated
        public boolean removeIf(Predicate<? super Integer> filter) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList, java.util.List
        @Deprecated
        public void replaceAll(UnaryOperator<Integer> operator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        public void replaceAll(IntUnaryOperator operator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntList, p014it.unimi.dsi.fastutil.ints.IntIterable
        public void forEach(IntConsumer action) {
            action.accept(this.element);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        public boolean addAll(IntList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        public boolean addAll(int i, IntList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntList, p014it.unimi.dsi.fastutil.ints.IntList
        public boolean addAll(int i, IntCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntList, p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public boolean addAll(IntCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public boolean removeAll(IntCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public boolean retainAll(IntCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollection
        public boolean removeIf(IntPredicate filter) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        @Deprecated
        public Object[] toArray() {
            return new Object[]{Integer.valueOf(this.element)};
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        public void sort(IntComparator comparator) {
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        public void unstableSort(IntComparator comparator) {
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList, java.util.List
        @Deprecated
        public void sort(Comparator<? super Integer> comparator) {
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        @Deprecated
        public void unstableSort(Comparator<? super Integer> comparator) {
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntList, p014it.unimi.dsi.fastutil.ints.IntList
        public void getElements(int from, int[] a, int offset, int length) {
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

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntList, p014it.unimi.dsi.fastutil.ints.IntList
        public void removeElements(int from, int to) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntList, p014it.unimi.dsi.fastutil.ints.IntList
        public void addElements(int index, int[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntList, p014it.unimi.dsi.fastutil.ints.IntList
        public void addElements(int index, int[] a, int offset, int length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        public void setElements(int[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        public void setElements(int index, int[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntList, p014it.unimi.dsi.fastutil.ints.IntList
        public void setElements(int index, int[] a, int offset, int length) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return 1;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntList, p014it.unimi.dsi.fastutil.ints.IntList
        public void size(int size) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // java.lang.Object
        public Object clone() {
            return this;
        }
    }

    public static IntList singleton(int element) {
        return new Singleton(element);
    }

    public static IntList singleton(Object element) {
        return new Singleton(((Integer) element).intValue());
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.IntLists$SynchronizedList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntLists$SynchronizedList.class */
    public static class SynchronizedList extends IntCollections.SynchronizedCollection implements IntList, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final IntList list;

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.SynchronizedCollection, java.lang.Object
        public /* bridge */ /* synthetic */ String toString() {
            return toString();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ void clear() {
            clear();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
            return retainAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
            return removeAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean containsAll(Collection collection) {
            return containsAll(collection);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.Collection] */
        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean addAll(Collection<? extends Integer> collection) {
            return addAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
        public /* bridge */ /* synthetic */ void forEach(IntConsumer intConsumer) {
            forEach(intConsumer);
        }

        /* Return type fixed from 'java.util.stream.Stream' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.ints.IntCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ Stream<Integer> parallelStream() {
            return parallelStream();
        }

        /* Return type fixed from 'java.util.stream.Stream' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.ints.IntCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ Stream<Integer> stream() {
            return stream();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.ints.IntCollection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntIterable
        public /* bridge */ /* synthetic */ IntSpliterator spliterator() {
            return spliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Object[] toArray(Object[] objArr) {
            return toArray(objArr);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public /* bridge */ /* synthetic */ IntStream intParallelStream() {
            return intParallelStream();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public /* bridge */ /* synthetic */ IntStream intStream() {
            return intStream();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
        public /* bridge */ /* synthetic */ IntSpliterator intSpliterator() {
            return intSpliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
        public /* bridge */ /* synthetic */ IntIterator intIterator() {
            return intIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.ints.IntCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean remove(Object obj) {
            return remove(obj);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.ints.IntCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean contains(Object obj) {
            return contains(obj);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean add(Integer num) {
            return add(num);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public /* bridge */ /* synthetic */ boolean retainAll(IntCollection intCollection) {
            return retainAll(intCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public /* bridge */ /* synthetic */ boolean removeAll(IntCollection intCollection) {
            return removeAll(intCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public /* bridge */ /* synthetic */ boolean containsAll(IntCollection intCollection) {
            return containsAll(intCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public /* bridge */ /* synthetic */ boolean addAll(IntCollection intCollection) {
            return addAll(intCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public /* bridge */ /* synthetic */ int[] toArray(int[] iArr) {
            return toArray(iArr);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        @Deprecated
        public /* bridge */ /* synthetic */ int[] toIntArray(int[] iArr) {
            return toIntArray(iArr);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Object[] toArray() {
            return toArray();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public /* bridge */ /* synthetic */ int[] toIntArray() {
            return toIntArray();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean isEmpty() {
            return isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.SynchronizedCollection, java.util.Collection, p014it.unimi.dsi.fastutil.BigList, p014it.unimi.dsi.fastutil.Size64
        public /* bridge */ /* synthetic */ int size() {
            return size();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public /* bridge */ /* synthetic */ boolean rem(int i) {
            return rem(i);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public /* bridge */ /* synthetic */ boolean contains(int i) {
            return contains(i);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public /* bridge */ /* synthetic */ boolean add(int i) {
            return add(i);
        }

        protected SynchronizedList(IntList l, Object sync) {
            super(l, sync);
            this.list = l;
        }

        protected SynchronizedList(IntList l) {
            super(l);
            this.list = l;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        public int getInt(int i) {
            int i2;
            synchronized (this.sync) {
                i2 = this.list.getInt(i);
            }
            return i2;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        public int set(int i, int k) {
            int i2;
            synchronized (this.sync) {
                i2 = this.list.set(i, k);
            }
            return i2;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        public void add(int i, int k) {
            synchronized (this.sync) {
                this.list.add(i, k);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        public int removeInt(int i) {
            int removeInt;
            synchronized (this.sync) {
                removeInt = this.list.removeInt(i);
            }
            return removeInt;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        public int indexOf(int k) {
            int indexOf;
            synchronized (this.sync) {
                indexOf = this.list.indexOf(k);
            }
            return indexOf;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        public int lastIndexOf(int k) {
            int lastIndexOf;
            synchronized (this.sync) {
                lastIndexOf = this.list.lastIndexOf(k);
            }
            return lastIndexOf;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public boolean removeIf(IntPredicate filter) {
            boolean removeIf;
            synchronized (this.sync) {
                removeIf = this.list.removeIf(filter);
            }
            return removeIf;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        public void replaceAll(IntUnaryOperator operator) {
            synchronized (this.sync) {
                this.list.replaceAll(operator);
            }
        }

        @Override // java.util.List
        public boolean addAll(int index, Collection<? extends Integer> c) {
            boolean addAll;
            synchronized (this.sync) {
                addAll = this.list.addAll(index, c);
            }
            return addAll;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        public void getElements(int from, int[] a, int offset, int length) {
            synchronized (this.sync) {
                this.list.getElements(from, a, offset, length);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        public void removeElements(int from, int to) {
            synchronized (this.sync) {
                this.list.removeElements(from, to);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        public void addElements(int index, int[] a, int offset, int length) {
            synchronized (this.sync) {
                this.list.addElements(index, a, offset, length);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        public void addElements(int index, int[] a) {
            synchronized (this.sync) {
                this.list.addElements(index, a);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        public void setElements(int[] a) {
            synchronized (this.sync) {
                this.list.setElements(a);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        public void setElements(int index, int[] a) {
            synchronized (this.sync) {
                this.list.setElements(index, a);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        public void setElements(int index, int[] a, int offset, int length) {
            synchronized (this.sync) {
                this.list.setElements(index, a, offset, length);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        public void size(int size) {
            synchronized (this.sync) {
                this.list.size(size);
            }
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.IntList, java.util.List
        public ListIterator<Integer> listIterator() {
            return this.list.listIterator();
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.ints.IntListIterator] */
        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.ints.IntCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntIterable
        public IntListIterator iterator() {
            return listIterator();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.IntList, java.util.List
        public ListIterator<Integer> listIterator(int i) {
            return this.list.listIterator(i);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntList' to match base method */
        /* JADX WARN: Type inference failed for: r2v2, types: [it.unimi.dsi.fastutil.ints.IntList] */
        @Override // p014it.unimi.dsi.fastutil.ints.IntList, java.util.List
        public List<Integer> subList(int from, int to) {
            SynchronizedList synchronizedList;
            synchronized (this.sync) {
                synchronizedList = new SynchronizedList(this.list.subList(from, to), this.sync);
            }
            return synchronizedList;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.SynchronizedCollection, java.util.Collection, java.lang.Object
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

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.SynchronizedCollection, java.util.Collection, java.lang.Object
        public int hashCode() {
            int hashCode;
            synchronized (this.sync) {
                hashCode = this.collection.hashCode();
            }
            return hashCode;
        }

        public int compareTo(List<? extends Integer> o) {
            int compareTo;
            synchronized (this.sync) {
                compareTo = this.list.compareTo(o);
            }
            return compareTo;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        public boolean addAll(int index, IntCollection c) {
            boolean addAll;
            synchronized (this.sync) {
                addAll = this.list.addAll(index, c);
            }
            return addAll;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        public boolean addAll(int index, IntList l) {
            boolean addAll;
            synchronized (this.sync) {
                addAll = this.list.addAll(index, l);
            }
            return addAll;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        public boolean addAll(IntList l) {
            boolean addAll;
            synchronized (this.sync) {
                addAll = this.list.addAll(l);
            }
            return addAll;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList, java.util.List
        @Deprecated
        public Integer get(int i) {
            Integer num;
            synchronized (this.sync) {
                num = this.list.get(i);
            }
            return num;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        @Deprecated
        public void add(int i, Integer k) {
            synchronized (this.sync) {
                this.list.add(i, k);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        @Deprecated
        public Integer set(int index, Integer k) {
            Integer num;
            synchronized (this.sync) {
                num = this.list.set(index, k);
            }
            return num;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList, java.util.List
        @Deprecated
        public Integer remove(int i) {
            Integer remove;
            synchronized (this.sync) {
                remove = this.list.remove(i);
            }
            return remove;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList, java.util.List
        @Deprecated
        public int indexOf(Object o) {
            int indexOf;
            synchronized (this.sync) {
                indexOf = this.list.indexOf(o);
            }
            return indexOf;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList, java.util.List
        @Deprecated
        public int lastIndexOf(Object o) {
            int lastIndexOf;
            synchronized (this.sync) {
                lastIndexOf = this.list.lastIndexOf(o);
            }
            return lastIndexOf;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        public void sort(IntComparator comparator) {
            synchronized (this.sync) {
                this.list.sort(comparator);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        public void unstableSort(IntComparator comparator) {
            synchronized (this.sync) {
                this.list.unstableSort(comparator);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList, java.util.List
        @Deprecated
        public void sort(Comparator<? super Integer> comparator) {
            synchronized (this.sync) {
                this.list.sort(comparator);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        @Deprecated
        public void unstableSort(Comparator<? super Integer> comparator) {
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

    /* renamed from: it.unimi.dsi.fastutil.ints.IntLists$SynchronizedRandomAccessList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntLists$SynchronizedRandomAccessList.class */
    public static class SynchronizedRandomAccessList extends SynchronizedList implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;

        protected SynchronizedRandomAccessList(IntList l, Object sync) {
            super(l, sync);
        }

        protected SynchronizedRandomAccessList(IntList l) {
            super(l);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntList' to match base method */
        /* JADX WARN: Type inference failed for: r2v2, types: [it.unimi.dsi.fastutil.ints.IntList] */
        @Override // p014it.unimi.dsi.fastutil.ints.IntLists.SynchronizedList, p014it.unimi.dsi.fastutil.ints.IntList, java.util.List
        public List<Integer> subList(int from, int to) {
            SynchronizedRandomAccessList synchronizedRandomAccessList;
            synchronized (this.sync) {
                synchronizedRandomAccessList = new SynchronizedRandomAccessList(this.list.subList(from, to), this.sync);
            }
            return synchronizedRandomAccessList;
        }
    }

    public static IntList synchronize(IntList l) {
        return l instanceof RandomAccess ? new SynchronizedRandomAccessList(l) : new SynchronizedList(l);
    }

    public static IntList synchronize(IntList l, Object sync) {
        return l instanceof RandomAccess ? new SynchronizedRandomAccessList(l, sync) : new SynchronizedList(l, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.IntLists$UnmodifiableList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntLists$UnmodifiableList.class */
    public static class UnmodifiableList extends IntCollections.UnmodifiableCollection implements IntList, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final IntList list;

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.UnmodifiableCollection, java.lang.Object
        public /* bridge */ /* synthetic */ String toString() {
            return toString();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public /* bridge */ /* synthetic */ IntStream intParallelStream() {
            return intParallelStream();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public /* bridge */ /* synthetic */ IntStream intStream() {
            return intStream();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
        public /* bridge */ /* synthetic */ IntSpliterator intSpliterator() {
            return intSpliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
        public /* bridge */ /* synthetic */ IntIterator intIterator() {
            return intIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public /* bridge */ /* synthetic */ boolean retainAll(IntCollection intCollection) {
            return retainAll(intCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public /* bridge */ /* synthetic */ boolean removeAll(IntCollection intCollection) {
            return removeAll(intCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public /* bridge */ /* synthetic */ boolean addAll(IntCollection intCollection) {
            return addAll(intCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public /* bridge */ /* synthetic */ boolean containsAll(IntCollection intCollection) {
            return containsAll(intCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public /* bridge */ /* synthetic */ int[] toArray(int[] iArr) {
            return toArray(iArr);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        @Deprecated
        public /* bridge */ /* synthetic */ int[] toIntArray(int[] iArr) {
            return toIntArray(iArr);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public /* bridge */ /* synthetic */ int[] toIntArray() {
            return toIntArray();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.ints.IntCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean remove(Object obj) {
            return remove(obj);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.ints.IntCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean contains(Object obj) {
            return contains(obj);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean add(Integer num) {
            return add(num);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public /* bridge */ /* synthetic */ boolean removeIf(IntPredicate intPredicate) {
            return removeIf(intPredicate);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
            return retainAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
            return removeAll(collection);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.Collection] */
        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean addAll(Collection<? extends Integer> collection) {
            return addAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean containsAll(Collection collection) {
            return containsAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
        public /* bridge */ /* synthetic */ void forEach(IntConsumer intConsumer) {
            forEach(intConsumer);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Object[] toArray() {
            return toArray();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Object[] toArray(Object[] objArr) {
            return toArray(objArr);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ void clear() {
            clear();
        }

        /* Return type fixed from 'java.util.stream.Stream' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.ints.IntCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ Stream<Integer> parallelStream() {
            return parallelStream();
        }

        /* Return type fixed from 'java.util.stream.Stream' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.ints.IntCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ Stream<Integer> stream() {
            return stream();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.ints.IntCollection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntIterable
        public /* bridge */ /* synthetic */ IntSpliterator spliterator() {
            return spliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public /* bridge */ /* synthetic */ boolean contains(int i) {
            return contains(i);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean isEmpty() {
            return isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.UnmodifiableCollection, java.util.Collection, p014it.unimi.dsi.fastutil.BigList, p014it.unimi.dsi.fastutil.Size64
        public /* bridge */ /* synthetic */ int size() {
            return size();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public /* bridge */ /* synthetic */ boolean rem(int i) {
            return rem(i);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public /* bridge */ /* synthetic */ boolean add(int i) {
            return add(i);
        }

        protected UnmodifiableList(IntList l) {
            super(l);
            this.list = l;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        public int getInt(int i) {
            return this.list.getInt(i);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        public int set(int i, int k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        public void add(int i, int k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        public int removeInt(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        public int indexOf(int k) {
            return this.list.indexOf(k);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        public int lastIndexOf(int k) {
            return this.list.lastIndexOf(k);
        }

        @Override // java.util.List
        public boolean addAll(int index, Collection<? extends Integer> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList, java.util.List
        @Deprecated
        public void replaceAll(UnaryOperator<Integer> operator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        public void getElements(int from, int[] a, int offset, int length) {
            this.list.getElements(from, a, offset, length);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        public void removeElements(int from, int to) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        public void addElements(int index, int[] a, int offset, int length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        public void addElements(int index, int[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        public void setElements(int[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        public void setElements(int index, int[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        public void setElements(int index, int[] a, int offset, int length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        public void size(int size) {
            this.list.size(size);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntListIterator' to match base method */
        /* JADX WARN: Type inference failed for: r0v2, types: [it.unimi.dsi.fastutil.ints.IntListIterator] */
        @Override // p014it.unimi.dsi.fastutil.ints.IntList, java.util.List
        public ListIterator<Integer> listIterator() {
            return IntIterators.unmodifiable((IntListIterator) this.list.listIterator());
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.ints.IntListIterator] */
        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.ints.IntCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntIterable
        public IntListIterator iterator() {
            return listIterator();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntListIterator' to match base method */
        /* JADX WARN: Type inference failed for: r0v2, types: [it.unimi.dsi.fastutil.ints.IntListIterator] */
        @Override // p014it.unimi.dsi.fastutil.ints.IntList, java.util.List
        public ListIterator<Integer> listIterator(int i) {
            return IntIterators.unmodifiable((IntListIterator) this.list.listIterator(i));
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntList' to match base method */
        /* JADX WARN: Type inference failed for: r2v2, types: [it.unimi.dsi.fastutil.ints.IntList] */
        @Override // p014it.unimi.dsi.fastutil.ints.IntList, java.util.List
        public List<Integer> subList(int from, int to) {
            return new UnmodifiableList(this.list.subList(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.UnmodifiableCollection, java.util.Collection, java.lang.Object
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            return this.collection.equals(o);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.UnmodifiableCollection, java.util.Collection, java.lang.Object
        public int hashCode() {
            return this.collection.hashCode();
        }

        public int compareTo(List<? extends Integer> o) {
            return this.list.compareTo(o);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        public boolean addAll(int index, IntCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        public boolean addAll(IntList l) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        public boolean addAll(int index, IntList l) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        public void replaceAll(IntUnaryOperator operator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList, java.util.List
        @Deprecated
        public Integer get(int i) {
            return this.list.get(i);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        @Deprecated
        public void add(int i, Integer k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        @Deprecated
        public Integer set(int index, Integer k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList, java.util.List
        @Deprecated
        public Integer remove(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList, java.util.List
        @Deprecated
        public int indexOf(Object o) {
            return this.list.indexOf(o);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList, java.util.List
        @Deprecated
        public int lastIndexOf(Object o) {
            return this.list.lastIndexOf(o);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        public void sort(IntComparator comparator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        public void unstableSort(IntComparator comparator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList, java.util.List
        @Deprecated
        public void sort(Comparator<? super Integer> comparator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        @Deprecated
        public void unstableSort(Comparator<? super Integer> comparator) {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.IntLists$UnmodifiableRandomAccessList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntLists$UnmodifiableRandomAccessList.class */
    public static class UnmodifiableRandomAccessList extends UnmodifiableList implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;

        protected UnmodifiableRandomAccessList(IntList l) {
            super(l);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntList' to match base method */
        /* JADX WARN: Type inference failed for: r2v2, types: [it.unimi.dsi.fastutil.ints.IntList] */
        @Override // p014it.unimi.dsi.fastutil.ints.IntLists.UnmodifiableList, p014it.unimi.dsi.fastutil.ints.IntList, java.util.List
        public List<Integer> subList(int from, int to) {
            return new UnmodifiableRandomAccessList(this.list.subList(from, to));
        }
    }

    public static IntList unmodifiable(IntList l) {
        return l instanceof RandomAccess ? new UnmodifiableRandomAccessList(l) : new UnmodifiableList(l);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: it.unimi.dsi.fastutil.ints.IntLists$ImmutableListBase */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntLists$ImmutableListBase.class */
    public static abstract class ImmutableListBase extends AbstractIntList implements IntList {
        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntList, p014it.unimi.dsi.fastutil.ints.IntList
        @Deprecated
        public final void add(int index, int k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntList, p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        @Deprecated
        public final boolean add(int k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntList, p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, java.util.AbstractCollection, java.util.Collection
        @Deprecated
        public final boolean addAll(Collection<? extends Integer> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntList, java.util.List
        @Deprecated
        public final boolean addAll(int index, Collection<? extends Integer> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntList, p014it.unimi.dsi.fastutil.ints.IntList
        @Deprecated
        public final int removeInt(int index) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntList, p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        @Deprecated
        public final boolean rem(int k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, java.util.AbstractCollection, java.util.Collection
        @Deprecated
        public final boolean removeAll(Collection<?> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, java.util.AbstractCollection, java.util.Collection
        @Deprecated
        public final boolean retainAll(Collection<?> c) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection, p014it.unimi.dsi.fastutil.ints.IntCollection
        @Deprecated
        public final boolean removeIf(Predicate<? super Integer> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollection
        @Deprecated
        public final boolean removeIf(IntPredicate c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList, java.util.List
        @Deprecated
        public final void replaceAll(UnaryOperator<Integer> operator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        @Deprecated
        public final void replaceAll(IntUnaryOperator operator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        @Deprecated
        public final void add(int index, Integer k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        @Deprecated
        public final boolean add(Integer k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList, java.util.List
        @Deprecated
        public final Integer remove(int index) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, java.util.AbstractCollection, java.util.Collection, p014it.unimi.dsi.fastutil.ints.IntCollection
        @Deprecated
        public final boolean remove(Object k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        @Deprecated
        public final Integer set(int index, Integer k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntList, p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        @Deprecated
        public final boolean addAll(IntCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        @Deprecated
        public final boolean addAll(IntList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntList, p014it.unimi.dsi.fastutil.ints.IntList
        @Deprecated
        public final boolean addAll(int index, IntCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        @Deprecated
        public final boolean addAll(int index, IntList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        @Deprecated
        public final boolean removeAll(IntCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        @Deprecated
        public final boolean retainAll(IntCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntList, p014it.unimi.dsi.fastutil.ints.IntList
        @Deprecated
        public final int set(int index, int k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntList, java.util.AbstractCollection, java.util.Collection, java.util.List
        @Deprecated
        public final void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntList, p014it.unimi.dsi.fastutil.ints.IntList
        @Deprecated
        public final void size(int size) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntList, p014it.unimi.dsi.fastutil.ints.IntList
        @Deprecated
        public final void removeElements(int from, int to) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntList, p014it.unimi.dsi.fastutil.ints.IntList
        @Deprecated
        public final void addElements(int index, int[] a, int offset, int length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntList, p014it.unimi.dsi.fastutil.ints.IntList
        @Deprecated
        public final void setElements(int index, int[] a, int offset, int length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        @Deprecated
        public final void sort(IntComparator comp) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        @Deprecated
        public final void unstableSort(IntComparator comp) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList, java.util.List
        @Deprecated
        public final void sort(Comparator<? super Integer> comparator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        @Deprecated
        public final void unstableSort(Comparator<? super Integer> comparator) {
            throw new UnsupportedOperationException();
        }
    }
}
