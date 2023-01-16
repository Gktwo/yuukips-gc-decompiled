package p014it.unimi.dsi.fastutil.ints;

import java.io.Serializable;
import java.util.Collection;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import okhttp3.HttpUrl;
import p014it.unimi.dsi.fastutil.BigArrays;
import p014it.unimi.dsi.fastutil.BigList;
import p014it.unimi.dsi.fastutil.BigListIterator;
import p014it.unimi.dsi.fastutil.ints.IntCollections;

/* renamed from: it.unimi.dsi.fastutil.ints.IntBigLists */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntBigLists.class */
public final class IntBigLists {
    public static final EmptyBigList EMPTY_BIG_LIST = new EmptyBigList();

    private IntBigLists() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [long] */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [long] */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static p014it.unimi.dsi.fastutil.ints.IntBigList shuffle(p014it.unimi.dsi.fastutil.ints.IntBigList r7, java.util.Random r8) {
        /*
            r0 = r7
            long r0 = r0.size64()
            r9 = r0
        L_0x0007:
            r0 = r9
            r1 = r0; r0 = r0; 
            r2 = 1
            long r1 = r1 - r2
            r9 = r1
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0046
            r0 = r8
            long r0 = r0.nextLong()
            r1 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            long r0 = r0 & r1
            r1 = r9
            r2 = 1
            long r1 = r1 + r2
            long r0 = r0 % r1
            r11 = r0
            r0 = r7
            r1 = r9
            int r0 = r0.getInt(r1)
            r13 = r0
            r0 = r7
            r1 = r9
            r2 = r7
            r3 = r11
            int r2 = r2.getInt(r3)
            int r0 = r0.set(r1, r2)
            r0 = r7
            r1 = r11
            r2 = r13
            int r0 = r0.set(r1, r2)
            goto L_0x0007
        L_0x0046:
            r0 = r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.ints.IntBigLists.shuffle(it.unimi.dsi.fastutil.ints.IntBigList, java.util.Random):it.unimi.dsi.fastutil.ints.IntBigList");
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.IntBigLists$EmptyBigList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntBigLists$EmptyBigList.class */
    public static class EmptyBigList extends IntCollections.EmptyCollection implements IntBigList, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptyBigList() {
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBigList
        public int getInt(long i) {
            throw new IndexOutOfBoundsException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public boolean rem(int k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBigList
        public int removeInt(long i) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBigList
        public void add(long index, int k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBigList
        public int set(long index, int k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBigList
        public long indexOf(int k) {
            return -1;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBigList
        public long lastIndexOf(int k) {
            return -1;
        }

        @Override // p014it.unimi.dsi.fastutil.BigList
        public boolean addAll(long i, Collection<? extends Integer> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.EmptyCollection, p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public boolean addAll(IntCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBigList
        public boolean addAll(IntBigList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBigList
        public boolean addAll(long i, IntCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBigList
        public boolean addAll(long i, IntBigList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBigList
        @Deprecated
        public void add(long index, Integer k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        @Deprecated
        public boolean add(Integer k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public Integer get(long i) {
            throw new IndexOutOfBoundsException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBigList
        @Deprecated
        public Integer set(long index, Integer k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public Integer remove(long k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public long indexOf(Object k) {
            return -1;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public long lastIndexOf(Object k) {
            return -1;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntBigListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.IntBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Integer> listIterator() {
            return IntBigListIterators.EMPTY_BIG_LIST_ITERATOR;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.EmptyCollection, p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
        public IntBigListIterator iterator() {
            return IntBigListIterators.EMPTY_BIG_LIST_ITERATOR;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntBigListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.IntBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Integer> listIterator(long i) {
            if (i == 0) {
                return IntBigListIterators.EMPTY_BIG_LIST_ITERATOR;
            }
            throw new IndexOutOfBoundsException(String.valueOf(i));
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.EmptyCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
        public IntSpliterator spliterator() {
            return IntSpliterators.EMPTY_SPLITERATOR;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntBigList' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.IntBigList, p014it.unimi.dsi.fastutil.BigList
        public BigList<Integer> subList(long from, long to) {
            if (from == 0 && to == 0) {
                return this;
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBigList
        public void getElements(long from, int[][] a, long offset, long length) {
            BigArrays.ensureOffsetLength(a, offset, length);
            if (from != 0) {
                throw new IndexOutOfBoundsException();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBigList
        public void removeElements(long from, long to) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBigList
        public void addElements(long index, int[][] a, long offset, long length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBigList
        public void addElements(long index, int[][] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.BigList
        public void size(long s) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.Size64
        public long size64() {
            return 0;
        }

        public int compareTo(BigList<? extends Integer> o) {
            return (o != this && !o.isEmpty()) ? -1 : 0;
        }

        @Override // java.lang.Object
        public Object clone() {
            return IntBigLists.EMPTY_BIG_LIST;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.EmptyCollection, java.util.Collection, java.lang.Object
        public int hashCode() {
            return 1;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.EmptyCollection, java.util.Collection, java.lang.Object
        public boolean equals(Object o) {
            return (o instanceof BigList) && ((BigList) o).isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, java.util.AbstractCollection, java.lang.Object
        public String toString() {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }

        private Object readResolve() {
            return IntBigLists.EMPTY_BIG_LIST;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.IntBigLists$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntBigLists$Singleton.class */
    public static class Singleton extends AbstractIntBigList implements Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        private final int element;

        protected Singleton(int element) {
            this.element = element;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBigList
        public int getInt(long i) {
            if (i == 0) {
                return this.element;
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntBigList, p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public boolean rem(int k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntBigList, p014it.unimi.dsi.fastutil.ints.IntBigList
        public int removeInt(long i) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntBigList, p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public boolean contains(int k) {
            return k == this.element;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntBigList, p014it.unimi.dsi.fastutil.ints.IntBigList
        public long indexOf(int k) {
            return k == this.element ? 0 : -1;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public int[] toIntArray() {
            return new int[]{this.element};
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntBigListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntBigList, p014it.unimi.dsi.fastutil.ints.IntBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Integer> listIterator() {
            return IntBigListIterators.singleton(this.element);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntBigListIterator' to match base method */
        /* JADX WARN: Type inference failed for: r0v6, types: [it.unimi.dsi.fastutil.ints.IntBigListIterator, it.unimi.dsi.fastutil.BigListIterator<java.lang.Integer>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntBigList, p014it.unimi.dsi.fastutil.ints.IntBigList, p014it.unimi.dsi.fastutil.BigList
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public p014it.unimi.dsi.fastutil.BigListIterator<java.lang.Integer> listIterator(long r6) {
            /*
                r5 = this;
                r0 = r6
                r1 = 1
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 > 0) goto L_0x000c
                r0 = r6
                r1 = 0
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 >= 0) goto L_0x0014
            L_0x000c:
                java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException
                r1 = r0
                r1.<init>()
                throw r0
            L_0x0014:
                r0 = r5
                it.unimi.dsi.fastutil.ints.IntBigListIterator r0 = r0.listIterator()
                r8 = r0
                r0 = r6
                r1 = 1
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 != 0) goto L_0x0026
                r0 = r8
                int r0 = r0.nextInt()
            L_0x0026:
                r0 = r8
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.ints.IntBigLists.Singleton.listIterator(long):it.unimi.dsi.fastutil.ints.IntBigListIterator");
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
        public IntSpliterator spliterator() {
            return IntSpliterators.singleton(this.element);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntBigList' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntBigList, p014it.unimi.dsi.fastutil.ints.IntBigList, p014it.unimi.dsi.fastutil.BigList
        public BigList<Integer> subList(long from, long to) {
            ensureIndex(from);
            ensureIndex(to);
            if (from <= to) {
                return (from == 0 && to == 1) ? this : IntBigLists.EMPTY_BIG_LIST;
            }
            throw new IndexOutOfBoundsException("Start index (" + from + ") is greater than end index (" + to + ")");
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntBigList, p014it.unimi.dsi.fastutil.BigList
        public boolean addAll(long i, Collection<? extends Integer> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntBigList, p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, java.util.AbstractCollection, java.util.Collection
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

        @Override // p014it.unimi.dsi.fastutil.ints.IntBigList
        public boolean addAll(IntBigList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBigList
        public boolean addAll(long i, IntBigList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntBigList, p014it.unimi.dsi.fastutil.ints.IntBigList
        public boolean addAll(long i, IntCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntBigList, p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
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

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntBigList, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.Size64
        public long size64() {
            return 1;
        }

        @Override // java.lang.Object
        public Object clone() {
            return this;
        }
    }

    public static IntBigList singleton(int element) {
        return new Singleton(element);
    }

    public static IntBigList singleton(Object element) {
        return new Singleton(((Integer) element).intValue());
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.IntBigLists$SynchronizedBigList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntBigLists$SynchronizedBigList.class */
    public static class SynchronizedBigList extends IntCollections.SynchronizedCollection implements IntBigList, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final IntBigList list;

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.SynchronizedCollection, java.lang.Object
        public /* bridge */ /* synthetic */ String toString() {
            return toString();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ void clear() {
            clear();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public /* bridge */ /* synthetic */ boolean removeIf(IntPredicate intPredicate) {
            return removeIf(intPredicate);
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

        protected SynchronizedBigList(IntBigList l, Object sync) {
            super(l, sync);
            this.list = l;
        }

        protected SynchronizedBigList(IntBigList l) {
            super(l);
            this.list = l;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBigList
        public int getInt(long i) {
            int i2;
            synchronized (this.sync) {
                i2 = this.list.getInt(i);
            }
            return i2;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBigList
        public int set(long i, int k) {
            int i2;
            synchronized (this.sync) {
                i2 = this.list.set(i, k);
            }
            return i2;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBigList
        public void add(long i, int k) {
            synchronized (this.sync) {
                this.list.add(i, k);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBigList
        public int removeInt(long i) {
            int removeInt;
            synchronized (this.sync) {
                removeInt = this.list.removeInt(i);
            }
            return removeInt;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBigList
        public long indexOf(int k) {
            long indexOf;
            synchronized (this.sync) {
                indexOf = this.list.indexOf(k);
            }
            return indexOf;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBigList
        public long lastIndexOf(int k) {
            long lastIndexOf;
            synchronized (this.sync) {
                lastIndexOf = this.list.lastIndexOf(k);
            }
            return lastIndexOf;
        }

        @Override // p014it.unimi.dsi.fastutil.BigList
        public boolean addAll(long index, Collection<? extends Integer> c) {
            boolean addAll;
            synchronized (this.sync) {
                addAll = this.list.addAll(index, c);
            }
            return addAll;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBigList
        public void getElements(long from, int[][] a, long offset, long length) {
            synchronized (this.sync) {
                this.list.getElements(from, a, offset, length);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBigList
        public void removeElements(long from, long to) {
            synchronized (this.sync) {
                this.list.removeElements(from, to);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBigList
        public void addElements(long index, int[][] a, long offset, long length) {
            synchronized (this.sync) {
                this.list.addElements(index, a, offset, length);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBigList
        public void addElements(long index, int[][] a) {
            synchronized (this.sync) {
                this.list.addElements(index, a);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public void size(long size) {
            synchronized (this.sync) {
                this.list.size(size);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.Size64
        public long size64() {
            long size64;
            synchronized (this.sync) {
                size64 = this.list.size64();
            }
            return size64;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [it.unimi.dsi.fastutil.ints.IntBigListIterator] */
        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.ints.IntCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntIterable
        public IntBigListIterator iterator() {
            return this.list.listIterator();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntBigListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.IntBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Integer> listIterator() {
            return this.list.listIterator();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntBigListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.IntBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Integer> listIterator(long i) {
            return this.list.listIterator(i);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntBigList' to match base method */
        /* JADX WARN: Type inference failed for: r0v6, types: [it.unimi.dsi.fastutil.ints.IntBigList] */
        @Override // p014it.unimi.dsi.fastutil.ints.IntBigList, p014it.unimi.dsi.fastutil.BigList
        public BigList<Integer> subList(long from, long to) {
            IntBigList synchronize;
            synchronized (this.sync) {
                synchronize = IntBigLists.synchronize(this.list.subList(from, to), this.sync);
            }
            return synchronize;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.SynchronizedCollection, java.util.Collection, java.lang.Object
        public boolean equals(Object o) {
            boolean equals;
            if (o == this) {
                return true;
            }
            synchronized (this.sync) {
                equals = this.list.equals(o);
            }
            return equals;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.SynchronizedCollection, java.util.Collection, java.lang.Object
        public int hashCode() {
            int hashCode;
            synchronized (this.sync) {
                hashCode = this.list.hashCode();
            }
            return hashCode;
        }

        public int compareTo(BigList<? extends Integer> o) {
            int compareTo;
            synchronized (this.sync) {
                compareTo = this.list.compareTo(o);
            }
            return compareTo;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBigList
        public boolean addAll(long index, IntCollection c) {
            boolean addAll;
            synchronized (this.sync) {
                addAll = this.list.addAll(index, c);
            }
            return addAll;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBigList
        public boolean addAll(long index, IntBigList l) {
            boolean addAll;
            synchronized (this.sync) {
                addAll = this.list.addAll(index, l);
            }
            return addAll;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBigList
        public boolean addAll(IntBigList l) {
            boolean addAll;
            synchronized (this.sync) {
                addAll = this.list.addAll(l);
            }
            return addAll;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBigList
        @Deprecated
        public void add(long i, Integer k) {
            synchronized (this.sync) {
                this.list.add(i, k);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public Integer get(long i) {
            Integer num;
            synchronized (this.sync) {
                num = this.list.get(i);
            }
            return num;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBigList
        @Deprecated
        public Integer set(long index, Integer k) {
            Integer num;
            synchronized (this.sync) {
                num = this.list.set(index, k);
            }
            return num;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public Integer remove(long i) {
            Integer remove;
            synchronized (this.sync) {
                remove = this.list.remove(i);
            }
            return remove;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public long indexOf(Object o) {
            long indexOf;
            synchronized (this.sync) {
                indexOf = this.list.indexOf(o);
            }
            return indexOf;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public long lastIndexOf(Object o) {
            long lastIndexOf;
            synchronized (this.sync) {
                lastIndexOf = this.list.lastIndexOf(o);
            }
            return lastIndexOf;
        }
    }

    public static IntBigList synchronize(IntBigList l) {
        return new SynchronizedBigList(l);
    }

    public static IntBigList synchronize(IntBigList l, Object sync) {
        return new SynchronizedBigList(l, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.IntBigLists$UnmodifiableBigList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntBigLists$UnmodifiableBigList.class */
    public static class UnmodifiableBigList extends IntCollections.UnmodifiableCollection implements IntBigList, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final IntBigList list;

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

        protected UnmodifiableBigList(IntBigList l) {
            super(l);
            this.list = l;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBigList
        public int getInt(long i) {
            return this.list.getInt(i);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBigList
        public int set(long i, int k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBigList
        public void add(long i, int k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBigList
        public int removeInt(long i) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBigList
        public long indexOf(int k) {
            return this.list.indexOf(k);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBigList
        public long lastIndexOf(int k) {
            return this.list.lastIndexOf(k);
        }

        @Override // p014it.unimi.dsi.fastutil.BigList
        public boolean addAll(long index, Collection<? extends Integer> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBigList
        public void getElements(long from, int[][] a, long offset, long length) {
            this.list.getElements(from, a, offset, length);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBigList
        public void removeElements(long from, long to) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBigList
        public void addElements(long index, int[][] a, long offset, long length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBigList
        public void addElements(long index, int[][] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public void size(long size) {
            this.list.size(size);
        }

        @Override // p014it.unimi.dsi.fastutil.Size64
        public long size64() {
            return this.list.size64();
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.ints.IntBigListIterator] */
        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.ints.IntCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntIterable
        public IntBigListIterator iterator() {
            return listIterator();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntBigListIterator' to match base method */
        /* JADX WARN: Type inference failed for: r0v2, types: [it.unimi.dsi.fastutil.ints.IntBigListIterator] */
        @Override // p014it.unimi.dsi.fastutil.ints.IntBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Integer> listIterator() {
            return IntBigListIterators.unmodifiable(this.list.listIterator());
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntBigListIterator' to match base method */
        /* JADX WARN: Type inference failed for: r0v2, types: [it.unimi.dsi.fastutil.ints.IntBigListIterator] */
        @Override // p014it.unimi.dsi.fastutil.ints.IntBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Integer> listIterator(long i) {
            return IntBigListIterators.unmodifiable(this.list.listIterator(i));
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntBigList' to match base method */
        /* JADX WARN: Type inference failed for: r0v2, types: [it.unimi.dsi.fastutil.ints.IntBigList] */
        @Override // p014it.unimi.dsi.fastutil.ints.IntBigList, p014it.unimi.dsi.fastutil.BigList
        public BigList<Integer> subList(long from, long to) {
            return IntBigLists.unmodifiable(this.list.subList(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.UnmodifiableCollection, java.util.Collection, java.lang.Object
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            return this.list.equals(o);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.UnmodifiableCollection, java.util.Collection, java.lang.Object
        public int hashCode() {
            return this.list.hashCode();
        }

        public int compareTo(BigList<? extends Integer> o) {
            return this.list.compareTo(o);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBigList
        public boolean addAll(long index, IntCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBigList
        public boolean addAll(IntBigList l) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBigList
        public boolean addAll(long index, IntBigList l) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public Integer get(long i) {
            return this.list.get(i);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBigList
        @Deprecated
        public void add(long i, Integer k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBigList
        @Deprecated
        public Integer set(long index, Integer k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public Integer remove(long i) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public long indexOf(Object o) {
            return this.list.indexOf(o);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public long lastIndexOf(Object o) {
            return this.list.lastIndexOf(o);
        }
    }

    public static IntBigList unmodifiable(IntBigList l) {
        return new UnmodifiableBigList(l);
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.IntBigLists$ListBigList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntBigLists$ListBigList.class */
    public static class ListBigList extends AbstractIntBigList implements Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        private final IntList list;

        protected ListBigList(IntList list) {
            this.list = list;
        }

        private int intIndex(long index) {
            if (index < 2147483647L) {
                return (int) index;
            }
            throw new IndexOutOfBoundsException("This big list is restricted to 32-bit indices");
        }

        @Override // p014it.unimi.dsi.fastutil.Size64
        public long size64() {
            return (long) this.list.size();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntBigList, p014it.unimi.dsi.fastutil.BigList
        public void size(long size) {
            this.list.size(intIndex(size));
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntBigList, p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
        public IntBigListIterator iterator() {
            return IntBigListIterators.asBigListIterator(this.list.iterator());
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntBigListIterator' to match base method */
        /* JADX WARN: Type inference failed for: r0v2, types: [it.unimi.dsi.fastutil.ints.IntListIterator] */
        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntBigList, p014it.unimi.dsi.fastutil.ints.IntBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Integer> listIterator() {
            return IntBigListIterators.asBigListIterator(this.list.listIterator());
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntBigListIterator' to match base method */
        /* JADX WARN: Type inference failed for: r0v2, types: [it.unimi.dsi.fastutil.ints.IntListIterator] */
        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntBigList, p014it.unimi.dsi.fastutil.ints.IntBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Integer> listIterator(long index) {
            return IntBigListIterators.asBigListIterator(this.list.listIterator(intIndex(index)));
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntBigList, p014it.unimi.dsi.fastutil.BigList
        public boolean addAll(long index, Collection<? extends Integer> c) {
            return this.list.addAll(intIndex(index), c);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntBigList' to match base method */
        /* JADX WARN: Type inference failed for: r2v2, types: [it.unimi.dsi.fastutil.ints.IntList] */
        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntBigList, p014it.unimi.dsi.fastutil.ints.IntBigList, p014it.unimi.dsi.fastutil.BigList
        public BigList<Integer> subList(long from, long to) {
            return new ListBigList(this.list.subList(intIndex(from), intIndex(to)));
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntBigList, p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public boolean contains(int key) {
            return this.list.contains(key);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public int[] toIntArray() {
            return this.list.toIntArray();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntBigList, p014it.unimi.dsi.fastutil.ints.IntBigList
        public void removeElements(long from, long to) {
            this.list.removeElements(intIndex(from), intIndex(to));
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        @Deprecated
        public int[] toIntArray(int[] a) {
            return this.list.toArray(a);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntBigList, p014it.unimi.dsi.fastutil.ints.IntBigList
        public boolean addAll(long index, IntCollection c) {
            return this.list.addAll(intIndex(index), c);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntBigList, p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public boolean addAll(IntCollection c) {
            return this.list.addAll(c);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBigList
        public boolean addAll(long index, IntBigList c) {
            return this.list.addAll(intIndex(index), (IntCollection) c);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBigList
        public boolean addAll(IntBigList c) {
            return this.list.addAll((IntCollection) c);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public boolean containsAll(IntCollection c) {
            return this.list.containsAll(c);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public boolean removeAll(IntCollection c) {
            return this.list.removeAll(c);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public boolean retainAll(IntCollection c) {
            return this.list.retainAll(c);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntBigList, p014it.unimi.dsi.fastutil.ints.IntBigList
        public void add(long index, int key) {
            this.list.add(intIndex(index), key);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntBigList, p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public boolean add(int key) {
            return this.list.add(key);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBigList
        public int getInt(long index) {
            return this.list.getInt(intIndex(index));
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntBigList, p014it.unimi.dsi.fastutil.ints.IntBigList
        public long indexOf(int k) {
            return (long) this.list.indexOf(k);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntBigList, p014it.unimi.dsi.fastutil.ints.IntBigList
        public long lastIndexOf(int k) {
            return (long) this.list.lastIndexOf(k);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntBigList, p014it.unimi.dsi.fastutil.ints.IntBigList
        public int removeInt(long index) {
            return this.list.removeInt(intIndex(index));
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntBigList, p014it.unimi.dsi.fastutil.ints.IntBigList
        public int set(long index, int k) {
            return this.list.set(intIndex(index), k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, p014it.unimi.dsi.fastutil.Stack, java.util.List
        public boolean isEmpty() {
            return this.list.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <T> T[] toArray(T[] a) {
            return (T[]) this.list.toArray(a);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, java.util.AbstractCollection, java.util.Collection
        public boolean containsAll(Collection<?> c) {
            return this.list.containsAll(c);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntBigList, p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection<? extends Integer> c) {
            return this.list.addAll(c);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> c) {
            return this.list.removeAll(c);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> c) {
            return this.list.retainAll(c);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntBigList, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.list.clear();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntBigList, java.util.Collection, java.lang.Object
        public int hashCode() {
            return this.list.hashCode();
        }
    }

    public static IntBigList asBigList(IntList list) {
        return new ListBigList(list);
    }
}
