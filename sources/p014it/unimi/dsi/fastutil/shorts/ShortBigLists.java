package p014it.unimi.dsi.fastutil.shorts;

import java.io.Serializable;
import java.util.Collection;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import okhttp3.HttpUrl;
import p014it.unimi.dsi.fastutil.BigArrays;
import p014it.unimi.dsi.fastutil.BigList;
import p014it.unimi.dsi.fastutil.BigListIterator;
import p014it.unimi.dsi.fastutil.ints.IntIterator;
import p014it.unimi.dsi.fastutil.ints.IntSpliterator;
import p014it.unimi.dsi.fastutil.shorts.ShortCollections;

/* renamed from: it.unimi.dsi.fastutil.shorts.ShortBigLists */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortBigLists.class */
public final class ShortBigLists {
    public static final EmptyBigList EMPTY_BIG_LIST = new EmptyBigList();

    private ShortBigLists() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [long] */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [long] */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static p014it.unimi.dsi.fastutil.shorts.ShortBigList shuffle(p014it.unimi.dsi.fastutil.shorts.ShortBigList r7, java.util.Random r8) {
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
            short r0 = r0.getShort(r1)
            r13 = r0
            r0 = r7
            r1 = r9
            r2 = r7
            r3 = r11
            short r2 = r2.getShort(r3)
            short r0 = r0.set(r1, r2)
            r0 = r7
            r1 = r11
            r2 = r13
            short r0 = r0.set(r1, r2)
            goto L_0x0007
        L_0x0046:
            r0 = r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.shorts.ShortBigLists.shuffle(it.unimi.dsi.fastutil.shorts.ShortBigList, java.util.Random):it.unimi.dsi.fastutil.shorts.ShortBigList");
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortBigLists$EmptyBigList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortBigLists$EmptyBigList.class */
    public static class EmptyBigList extends ShortCollections.EmptyCollection implements ShortBigList, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptyBigList() {
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList
        public short getShort(long i) {
            throw new IndexOutOfBoundsException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public boolean rem(short k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList
        public short removeShort(long i) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList
        public void add(long index, short k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList
        public short set(long index, short k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList
        public long indexOf(short k) {
            return -1;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList
        public long lastIndexOf(short k) {
            return -1;
        }

        @Override // p014it.unimi.dsi.fastutil.BigList
        public boolean addAll(long i, Collection<? extends Short> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.EmptyCollection, p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public boolean addAll(ShortCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList
        public boolean addAll(ShortBigList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList
        public boolean addAll(long i, ShortCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList
        public boolean addAll(long i, ShortBigList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList
        @Deprecated
        public void add(long index, Short k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        @Deprecated
        public boolean add(Short k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public Short get(long i) {
            throw new IndexOutOfBoundsException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList
        @Deprecated
        public Short set(long index, Short k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public Short remove(long k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public long indexOf(Object k) {
            return -1;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public long lastIndexOf(Object k) {
            return -1;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortBigListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Short> listIterator() {
            return ShortBigListIterators.EMPTY_BIG_LIST_ITERATOR;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.EmptyCollection, p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public ShortBigListIterator iterator() {
            return ShortBigListIterators.EMPTY_BIG_LIST_ITERATOR;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortBigListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Short> listIterator(long i) {
            if (i == 0) {
                return ShortBigListIterators.EMPTY_BIG_LIST_ITERATOR;
            }
            throw new IndexOutOfBoundsException(String.valueOf(i));
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.EmptyCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public ShortSpliterator spliterator() {
            return ShortSpliterators.EMPTY_SPLITERATOR;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortBigList' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList, p014it.unimi.dsi.fastutil.BigList
        public BigList<Short> subList(long from, long to) {
            if (from == 0 && to == 0) {
                return this;
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList
        public void getElements(long from, short[][] a, long offset, long length) {
            BigArrays.ensureOffsetLength(a, offset, length);
            if (from != 0) {
                throw new IndexOutOfBoundsException();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList
        public void removeElements(long from, long to) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList
        public void addElements(long index, short[][] a, long offset, long length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList
        public void addElements(long index, short[][] a) {
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

        public int compareTo(BigList<? extends Short> o) {
            return (o != this && !o.isEmpty()) ? -1 : 0;
        }

        @Override // java.lang.Object
        public Object clone() {
            return ShortBigLists.EMPTY_BIG_LIST;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.EmptyCollection, java.util.Collection, java.lang.Object
        public int hashCode() {
            return 1;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.EmptyCollection, java.util.Collection, java.lang.Object
        public boolean equals(Object o) {
            return (o instanceof BigList) && ((BigList) o).isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, java.util.AbstractCollection, java.lang.Object
        public String toString() {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }

        private Object readResolve() {
            return ShortBigLists.EMPTY_BIG_LIST;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortBigLists$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortBigLists$Singleton.class */
    public static class Singleton extends AbstractShortBigList implements Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        private final short element;

        protected Singleton(short element) {
            this.element = element;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList
        public short getShort(long i) {
            if (i == 0) {
                return this.element;
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList, p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public boolean rem(short k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList, p014it.unimi.dsi.fastutil.shorts.ShortBigList
        public short removeShort(long i) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList, p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public boolean contains(short k) {
            return k == this.element;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList, p014it.unimi.dsi.fastutil.shorts.ShortBigList
        public long indexOf(short k) {
            return k == this.element ? 0 : -1;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public short[] toShortArray() {
            return new short[]{this.element};
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortBigListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList, p014it.unimi.dsi.fastutil.shorts.ShortBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Short> listIterator() {
            return ShortBigListIterators.singleton(this.element);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortBigListIterator' to match base method */
        /* JADX WARN: Type inference failed for: r0v6, types: [it.unimi.dsi.fastutil.BigListIterator<java.lang.Short>, it.unimi.dsi.fastutil.shorts.ShortBigListIterator] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList, p014it.unimi.dsi.fastutil.shorts.ShortBigList, p014it.unimi.dsi.fastutil.BigList
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public p014it.unimi.dsi.fastutil.BigListIterator<java.lang.Short> listIterator(long r6) {
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
                it.unimi.dsi.fastutil.shorts.ShortBigListIterator r0 = r0.listIterator()
                r8 = r0
                r0 = r6
                r1 = 1
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 != 0) goto L_0x0026
                r0 = r8
                short r0 = r0.nextShort()
            L_0x0026:
                r0 = r8
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.shorts.ShortBigLists.Singleton.listIterator(long):it.unimi.dsi.fastutil.shorts.ShortBigListIterator");
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public ShortSpliterator spliterator() {
            return ShortSpliterators.singleton(this.element);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortBigList' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList, p014it.unimi.dsi.fastutil.shorts.ShortBigList, p014it.unimi.dsi.fastutil.BigList
        public BigList<Short> subList(long from, long to) {
            ensureIndex(from);
            ensureIndex(to);
            if (from <= to) {
                return (from == 0 && to == 1) ? this : ShortBigLists.EMPTY_BIG_LIST;
            }
            throw new IndexOutOfBoundsException("Start index (" + from + ") is greater than end index (" + to + ")");
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList, p014it.unimi.dsi.fastutil.BigList
        public boolean addAll(long i, Collection<? extends Short> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList, p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, java.util.AbstractCollection, java.util.Collection
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

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList
        public boolean addAll(ShortBigList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList
        public boolean addAll(long i, ShortBigList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList, p014it.unimi.dsi.fastutil.shorts.ShortBigList
        public boolean addAll(long i, ShortCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList, p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
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

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList, java.util.AbstractCollection, java.util.Collection
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

    public static ShortBigList singleton(short element) {
        return new Singleton(element);
    }

    public static ShortBigList singleton(Object element) {
        return new Singleton(((Short) element).shortValue());
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortBigLists$SynchronizedBigList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortBigLists$SynchronizedBigList.class */
    public static class SynchronizedBigList extends ShortCollections.SynchronizedCollection implements ShortBigList, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final ShortBigList list;

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.SynchronizedCollection, java.lang.Object
        public /* bridge */ /* synthetic */ String toString() {
            return toString();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ void clear() {
            clear();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public /* bridge */ /* synthetic */ boolean removeIf(ShortPredicate shortPredicate) {
            return removeIf(shortPredicate);
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

        protected SynchronizedBigList(ShortBigList l, Object sync) {
            super(l, sync);
            this.list = l;
        }

        protected SynchronizedBigList(ShortBigList l) {
            super(l);
            this.list = l;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList
        public short getShort(long i) {
            short s;
            synchronized (this.sync) {
                s = this.list.getShort(i);
            }
            return s;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList
        public short set(long i, short k) {
            short s;
            synchronized (this.sync) {
                s = this.list.set(i, k);
            }
            return s;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList
        public void add(long i, short k) {
            synchronized (this.sync) {
                this.list.add(i, k);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList
        public short removeShort(long i) {
            short removeShort;
            synchronized (this.sync) {
                removeShort = this.list.removeShort(i);
            }
            return removeShort;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList
        public long indexOf(short k) {
            long indexOf;
            synchronized (this.sync) {
                indexOf = this.list.indexOf(k);
            }
            return indexOf;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList
        public long lastIndexOf(short k) {
            long lastIndexOf;
            synchronized (this.sync) {
                lastIndexOf = this.list.lastIndexOf(k);
            }
            return lastIndexOf;
        }

        @Override // p014it.unimi.dsi.fastutil.BigList
        public boolean addAll(long index, Collection<? extends Short> c) {
            boolean addAll;
            synchronized (this.sync) {
                addAll = this.list.addAll(index, c);
            }
            return addAll;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList
        public void getElements(long from, short[][] a, long offset, long length) {
            synchronized (this.sync) {
                this.list.getElements(from, a, offset, length);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList
        public void removeElements(long from, long to) {
            synchronized (this.sync) {
                this.list.removeElements(from, to);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList
        public void addElements(long index, short[][] a, long offset, long length) {
            synchronized (this.sync) {
                this.list.addElements(index, a, offset, length);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList
        public void addElements(long index, short[][] a) {
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

        /* JADX WARN: Type inference failed for: r0v2, types: [it.unimi.dsi.fastutil.shorts.ShortBigListIterator] */
        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public ShortBigListIterator iterator() {
            return this.list.listIterator();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortBigListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Short> listIterator() {
            return this.list.listIterator();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortBigListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Short> listIterator(long i) {
            return this.list.listIterator(i);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortBigList' to match base method */
        /* JADX WARN: Type inference failed for: r0v6, types: [it.unimi.dsi.fastutil.shorts.ShortBigList] */
        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList, p014it.unimi.dsi.fastutil.BigList
        public BigList<Short> subList(long from, long to) {
            ShortBigList synchronize;
            synchronized (this.sync) {
                synchronize = ShortBigLists.synchronize(this.list.subList(from, to), this.sync);
            }
            return synchronize;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.SynchronizedCollection, java.util.Collection, java.lang.Object
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

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.SynchronizedCollection, java.util.Collection, java.lang.Object
        public int hashCode() {
            int hashCode;
            synchronized (this.sync) {
                hashCode = this.list.hashCode();
            }
            return hashCode;
        }

        public int compareTo(BigList<? extends Short> o) {
            int compareTo;
            synchronized (this.sync) {
                compareTo = this.list.compareTo(o);
            }
            return compareTo;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList
        public boolean addAll(long index, ShortCollection c) {
            boolean addAll;
            synchronized (this.sync) {
                addAll = this.list.addAll(index, c);
            }
            return addAll;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList
        public boolean addAll(long index, ShortBigList l) {
            boolean addAll;
            synchronized (this.sync) {
                addAll = this.list.addAll(index, l);
            }
            return addAll;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList
        public boolean addAll(ShortBigList l) {
            boolean addAll;
            synchronized (this.sync) {
                addAll = this.list.addAll(l);
            }
            return addAll;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList
        @Deprecated
        public void add(long i, Short k) {
            synchronized (this.sync) {
                this.list.add(i, k);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public Short get(long i) {
            Short sh;
            synchronized (this.sync) {
                sh = this.list.get(i);
            }
            return sh;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList
        @Deprecated
        public Short set(long index, Short k) {
            Short sh;
            synchronized (this.sync) {
                sh = this.list.set(index, k);
            }
            return sh;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public Short remove(long i) {
            Short remove;
            synchronized (this.sync) {
                remove = this.list.remove(i);
            }
            return remove;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public long indexOf(Object o) {
            long indexOf;
            synchronized (this.sync) {
                indexOf = this.list.indexOf(o);
            }
            return indexOf;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public long lastIndexOf(Object o) {
            long lastIndexOf;
            synchronized (this.sync) {
                lastIndexOf = this.list.lastIndexOf(o);
            }
            return lastIndexOf;
        }
    }

    public static ShortBigList synchronize(ShortBigList l) {
        return new SynchronizedBigList(l);
    }

    public static ShortBigList synchronize(ShortBigList l, Object sync) {
        return new SynchronizedBigList(l, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortBigLists$UnmodifiableBigList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortBigLists$UnmodifiableBigList.class */
    public static class UnmodifiableBigList extends ShortCollections.UnmodifiableCollection implements ShortBigList, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final ShortBigList list;

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

        protected UnmodifiableBigList(ShortBigList l) {
            super(l);
            this.list = l;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList
        public short getShort(long i) {
            return this.list.getShort(i);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList
        public short set(long i, short k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList
        public void add(long i, short k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList
        public short removeShort(long i) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList
        public long indexOf(short k) {
            return this.list.indexOf(k);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList
        public long lastIndexOf(short k) {
            return this.list.lastIndexOf(k);
        }

        @Override // p014it.unimi.dsi.fastutil.BigList
        public boolean addAll(long index, Collection<? extends Short> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList
        public void getElements(long from, short[][] a, long offset, long length) {
            this.list.getElements(from, a, offset, length);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList
        public void removeElements(long from, long to) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList
        public void addElements(long index, short[][] a, long offset, long length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList
        public void addElements(long index, short[][] a) {
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

        /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.shorts.ShortBigListIterator] */
        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public ShortBigListIterator iterator() {
            return listIterator();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortBigListIterator' to match base method */
        /* JADX WARN: Type inference failed for: r0v2, types: [it.unimi.dsi.fastutil.shorts.ShortBigListIterator] */
        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Short> listIterator() {
            return ShortBigListIterators.unmodifiable(this.list.listIterator());
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortBigListIterator' to match base method */
        /* JADX WARN: Type inference failed for: r0v2, types: [it.unimi.dsi.fastutil.shorts.ShortBigListIterator] */
        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Short> listIterator(long i) {
            return ShortBigListIterators.unmodifiable(this.list.listIterator(i));
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortBigList' to match base method */
        /* JADX WARN: Type inference failed for: r0v2, types: [it.unimi.dsi.fastutil.shorts.ShortBigList] */
        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList, p014it.unimi.dsi.fastutil.BigList
        public BigList<Short> subList(long from, long to) {
            return ShortBigLists.unmodifiable(this.list.subList(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.UnmodifiableCollection, java.util.Collection, java.lang.Object
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            return this.list.equals(o);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.UnmodifiableCollection, java.util.Collection, java.lang.Object
        public int hashCode() {
            return this.list.hashCode();
        }

        public int compareTo(BigList<? extends Short> o) {
            return this.list.compareTo(o);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList
        public boolean addAll(long index, ShortCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList
        public boolean addAll(ShortBigList l) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList
        public boolean addAll(long index, ShortBigList l) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public Short get(long i) {
            return this.list.get(i);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList
        @Deprecated
        public void add(long i, Short k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList
        @Deprecated
        public Short set(long index, Short k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public Short remove(long i) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public long indexOf(Object o) {
            return this.list.indexOf(o);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public long lastIndexOf(Object o) {
            return this.list.lastIndexOf(o);
        }
    }

    public static ShortBigList unmodifiable(ShortBigList l) {
        return new UnmodifiableBigList(l);
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortBigLists$ListBigList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortBigLists$ListBigList.class */
    public static class ListBigList extends AbstractShortBigList implements Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        private final ShortList list;

        protected ListBigList(ShortList list) {
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

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList, p014it.unimi.dsi.fastutil.BigList
        public void size(long size) {
            this.list.size(intIndex(size));
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList, p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public ShortBigListIterator iterator() {
            return ShortBigListIterators.asBigListIterator(this.list.iterator());
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortBigListIterator' to match base method */
        /* JADX WARN: Type inference failed for: r0v2, types: [it.unimi.dsi.fastutil.shorts.ShortListIterator] */
        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList, p014it.unimi.dsi.fastutil.shorts.ShortBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Short> listIterator() {
            return ShortBigListIterators.asBigListIterator(this.list.listIterator());
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortBigListIterator' to match base method */
        /* JADX WARN: Type inference failed for: r0v2, types: [it.unimi.dsi.fastutil.shorts.ShortListIterator] */
        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList, p014it.unimi.dsi.fastutil.shorts.ShortBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Short> listIterator(long index) {
            return ShortBigListIterators.asBigListIterator(this.list.listIterator(intIndex(index)));
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList, p014it.unimi.dsi.fastutil.BigList
        public boolean addAll(long index, Collection<? extends Short> c) {
            return this.list.addAll(intIndex(index), c);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortBigList' to match base method */
        /* JADX WARN: Type inference failed for: r2v2, types: [it.unimi.dsi.fastutil.shorts.ShortList] */
        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList, p014it.unimi.dsi.fastutil.shorts.ShortBigList, p014it.unimi.dsi.fastutil.BigList
        public BigList<Short> subList(long from, long to) {
            return new ListBigList(this.list.subList(intIndex(from), intIndex(to)));
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList, p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public boolean contains(short key) {
            return this.list.contains(key);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public short[] toShortArray() {
            return this.list.toShortArray();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList, p014it.unimi.dsi.fastutil.shorts.ShortBigList
        public void removeElements(long from, long to) {
            this.list.removeElements(intIndex(from), intIndex(to));
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        @Deprecated
        public short[] toShortArray(short[] a) {
            return this.list.toArray(a);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList, p014it.unimi.dsi.fastutil.shorts.ShortBigList
        public boolean addAll(long index, ShortCollection c) {
            return this.list.addAll(intIndex(index), c);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList, p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public boolean addAll(ShortCollection c) {
            return this.list.addAll(c);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList
        public boolean addAll(long index, ShortBigList c) {
            return this.list.addAll(intIndex(index), (ShortCollection) c);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList
        public boolean addAll(ShortBigList c) {
            return this.list.addAll((ShortCollection) c);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public boolean containsAll(ShortCollection c) {
            return this.list.containsAll(c);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public boolean removeAll(ShortCollection c) {
            return this.list.removeAll(c);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public boolean retainAll(ShortCollection c) {
            return this.list.retainAll(c);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList, p014it.unimi.dsi.fastutil.shorts.ShortBigList
        public void add(long index, short key) {
            this.list.add(intIndex(index), key);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList, p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public boolean add(short key) {
            return this.list.add(key);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList
        public short getShort(long index) {
            return this.list.getShort(intIndex(index));
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList, p014it.unimi.dsi.fastutil.shorts.ShortBigList
        public long indexOf(short k) {
            return (long) this.list.indexOf(k);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList, p014it.unimi.dsi.fastutil.shorts.ShortBigList
        public long lastIndexOf(short k) {
            return (long) this.list.lastIndexOf(k);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList, p014it.unimi.dsi.fastutil.shorts.ShortBigList
        public short removeShort(long index) {
            return this.list.removeShort(intIndex(index));
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList, p014it.unimi.dsi.fastutil.shorts.ShortBigList
        public short set(long index, short k) {
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

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, java.util.AbstractCollection, java.util.Collection
        public boolean containsAll(Collection<?> c) {
            return this.list.containsAll(c);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList, p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection<? extends Short> c) {
            return this.list.addAll(c);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> c) {
            return this.list.removeAll(c);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> c) {
            return this.list.retainAll(c);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.list.clear();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList, java.util.Collection, java.lang.Object
        public int hashCode() {
            return this.list.hashCode();
        }
    }

    public static ShortBigList asBigList(ShortList list) {
        return new ListBigList(list);
    }
}
