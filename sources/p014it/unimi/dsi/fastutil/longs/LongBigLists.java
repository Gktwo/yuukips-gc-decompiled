package p014it.unimi.dsi.fastutil.longs;

import java.io.Serializable;
import java.util.Collection;
import java.util.function.LongConsumer;
import java.util.function.LongPredicate;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import okhttp3.HttpUrl;
import p014it.unimi.dsi.fastutil.BigArrays;
import p014it.unimi.dsi.fastutil.BigList;
import p014it.unimi.dsi.fastutil.BigListIterator;
import p014it.unimi.dsi.fastutil.longs.LongCollections;

/* renamed from: it.unimi.dsi.fastutil.longs.LongBigLists */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongBigLists.class */
public final class LongBigLists {
    public static final EmptyBigList EMPTY_BIG_LIST = new EmptyBigList();

    private LongBigLists() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [long] */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [long] */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static p014it.unimi.dsi.fastutil.longs.LongBigList shuffle(p014it.unimi.dsi.fastutil.longs.LongBigList r7, java.util.Random r8) {
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
            long r0 = r0.getLong(r1)
            r13 = r0
            r0 = r7
            r1 = r9
            r2 = r7
            r3 = r11
            long r2 = r2.getLong(r3)
            long r0 = r0.set(r1, r2)
            r0 = r7
            r1 = r11
            r2 = r13
            long r0 = r0.set(r1, r2)
            goto L_0x0007
        L_0x0046:
            r0 = r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.longs.LongBigLists.shuffle(it.unimi.dsi.fastutil.longs.LongBigList, java.util.Random):it.unimi.dsi.fastutil.longs.LongBigList");
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.LongBigLists$EmptyBigList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongBigLists$EmptyBigList.class */
    public static class EmptyBigList extends LongCollections.EmptyCollection implements LongBigList, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptyBigList() {
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBigList
        public long getLong(long i) {
            throw new IndexOutOfBoundsException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public boolean rem(long k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBigList
        public long removeLong(long i) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBigList
        public void add(long index, long k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBigList
        public long set(long index, long k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBigList
        public long indexOf(long k) {
            return -1;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBigList
        public long lastIndexOf(long k) {
            return -1;
        }

        @Override // p014it.unimi.dsi.fastutil.BigList
        public boolean addAll(long i, Collection<? extends Long> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.EmptyCollection, p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public boolean addAll(LongCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBigList
        public boolean addAll(LongBigList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBigList
        public boolean addAll(long i, LongCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBigList
        public boolean addAll(long i, LongBigList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBigList
        @Deprecated
        public void add(long index, Long k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        @Deprecated
        public boolean add(Long k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public Long get(long i) {
            throw new IndexOutOfBoundsException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBigList
        @Deprecated
        public Long set(long index, Long k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public Long remove(long k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public long indexOf(Object k) {
            return -1;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public long lastIndexOf(Object k) {
            return -1;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongBigListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.LongBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Long> listIterator() {
            return LongBigListIterators.EMPTY_BIG_LIST_ITERATOR;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.EmptyCollection, p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
        public LongBigListIterator iterator() {
            return LongBigListIterators.EMPTY_BIG_LIST_ITERATOR;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongBigListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.LongBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Long> listIterator(long i) {
            if (i == 0) {
                return LongBigListIterators.EMPTY_BIG_LIST_ITERATOR;
            }
            throw new IndexOutOfBoundsException(String.valueOf(i));
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.EmptyCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
        public LongSpliterator spliterator() {
            return LongSpliterators.EMPTY_SPLITERATOR;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongBigList' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.LongBigList, p014it.unimi.dsi.fastutil.BigList
        public BigList<Long> subList(long from, long to) {
            if (from == 0 && to == 0) {
                return this;
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBigList
        public void getElements(long from, long[][] a, long offset, long length) {
            BigArrays.ensureOffsetLength(a, offset, length);
            if (from != 0) {
                throw new IndexOutOfBoundsException();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBigList
        public void removeElements(long from, long to) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBigList
        public void addElements(long index, long[][] a, long offset, long length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBigList
        public void addElements(long index, long[][] a) {
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

        public int compareTo(BigList<? extends Long> o) {
            return (o != this && !o.isEmpty()) ? -1 : 0;
        }

        @Override // java.lang.Object
        public Object clone() {
            return LongBigLists.EMPTY_BIG_LIST;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.EmptyCollection, java.util.Collection, java.lang.Object
        public int hashCode() {
            return 1;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.EmptyCollection, java.util.Collection, java.lang.Object
        public boolean equals(Object o) {
            return (o instanceof BigList) && ((BigList) o).isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, java.util.AbstractCollection, java.lang.Object
        public String toString() {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }

        private Object readResolve() {
            return LongBigLists.EMPTY_BIG_LIST;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.LongBigLists$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongBigLists$Singleton.class */
    public static class Singleton extends AbstractLongBigList implements Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        private final long element;

        protected Singleton(long element) {
            this.element = element;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBigList
        public long getLong(long i) {
            if (i == 0) {
                return this.element;
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList, p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public boolean rem(long k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList, p014it.unimi.dsi.fastutil.longs.LongBigList
        public long removeLong(long i) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList, p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public boolean contains(long k) {
            return k == this.element;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList, p014it.unimi.dsi.fastutil.longs.LongBigList
        public long indexOf(long k) {
            return k == this.element ? 0 : -1;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public long[] toLongArray() {
            return new long[]{this.element};
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongBigListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList, p014it.unimi.dsi.fastutil.longs.LongBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Long> listIterator() {
            return LongBigListIterators.singleton(this.element);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongBigListIterator' to match base method */
        /* JADX WARN: Type inference failed for: r0v6, types: [it.unimi.dsi.fastutil.longs.LongBigListIterator, it.unimi.dsi.fastutil.BigListIterator<java.lang.Long>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList, p014it.unimi.dsi.fastutil.longs.LongBigList, p014it.unimi.dsi.fastutil.BigList
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public p014it.unimi.dsi.fastutil.BigListIterator<java.lang.Long> listIterator(long r6) {
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
                it.unimi.dsi.fastutil.longs.LongBigListIterator r0 = r0.listIterator()
                r8 = r0
                r0 = r6
                r1 = 1
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 != 0) goto L_0x0026
                r0 = r8
                long r0 = r0.nextLong()
            L_0x0026:
                r0 = r8
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.longs.LongBigLists.Singleton.listIterator(long):it.unimi.dsi.fastutil.longs.LongBigListIterator");
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
        public LongSpliterator spliterator() {
            return LongSpliterators.singleton(this.element);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongBigList' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList, p014it.unimi.dsi.fastutil.longs.LongBigList, p014it.unimi.dsi.fastutil.BigList
        public BigList<Long> subList(long from, long to) {
            ensureIndex(from);
            ensureIndex(to);
            if (from <= to) {
                return (from == 0 && to == 1) ? this : LongBigLists.EMPTY_BIG_LIST;
            }
            throw new IndexOutOfBoundsException("Start index (" + from + ") is greater than end index (" + to + ")");
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList, p014it.unimi.dsi.fastutil.BigList
        public boolean addAll(long i, Collection<? extends Long> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList, p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, java.util.AbstractCollection, java.util.Collection
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

        @Override // p014it.unimi.dsi.fastutil.longs.LongBigList
        public boolean addAll(LongBigList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBigList
        public boolean addAll(long i, LongBigList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList, p014it.unimi.dsi.fastutil.longs.LongBigList
        public boolean addAll(long i, LongCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList, p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
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

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList, java.util.AbstractCollection, java.util.Collection
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

    public static LongBigList singleton(long element) {
        return new Singleton(element);
    }

    public static LongBigList singleton(Object element) {
        return new Singleton(((Long) element).longValue());
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.LongBigLists$SynchronizedBigList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongBigLists$SynchronizedBigList.class */
    public static class SynchronizedBigList extends LongCollections.SynchronizedCollection implements LongBigList, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final LongBigList list;

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.SynchronizedCollection, java.lang.Object
        public /* bridge */ /* synthetic */ String toString() {
            return toString();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ void clear() {
            clear();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public /* bridge */ /* synthetic */ boolean removeIf(LongPredicate longPredicate) {
            return removeIf(longPredicate);
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

        protected SynchronizedBigList(LongBigList l, Object sync) {
            super(l, sync);
            this.list = l;
        }

        protected SynchronizedBigList(LongBigList l) {
            super(l);
            this.list = l;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBigList
        public long getLong(long i) {
            long j;
            synchronized (this.sync) {
                j = this.list.getLong(i);
            }
            return j;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBigList
        public long set(long i, long k) {
            long j;
            synchronized (this.sync) {
                j = this.list.set(i, k);
            }
            return j;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBigList
        public void add(long i, long k) {
            synchronized (this.sync) {
                this.list.add(i, k);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBigList
        public long removeLong(long i) {
            long removeLong;
            synchronized (this.sync) {
                removeLong = this.list.removeLong(i);
            }
            return removeLong;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBigList
        public long indexOf(long k) {
            long indexOf;
            synchronized (this.sync) {
                indexOf = this.list.indexOf(k);
            }
            return indexOf;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBigList
        public long lastIndexOf(long k) {
            long lastIndexOf;
            synchronized (this.sync) {
                lastIndexOf = this.list.lastIndexOf(k);
            }
            return lastIndexOf;
        }

        @Override // p014it.unimi.dsi.fastutil.BigList
        public boolean addAll(long index, Collection<? extends Long> c) {
            boolean addAll;
            synchronized (this.sync) {
                addAll = this.list.addAll(index, c);
            }
            return addAll;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBigList
        public void getElements(long from, long[][] a, long offset, long length) {
            synchronized (this.sync) {
                this.list.getElements(from, a, offset, length);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBigList
        public void removeElements(long from, long to) {
            synchronized (this.sync) {
                this.list.removeElements(from, to);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBigList
        public void addElements(long index, long[][] a, long offset, long length) {
            synchronized (this.sync) {
                this.list.addElements(index, a, offset, length);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBigList
        public void addElements(long index, long[][] a) {
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

        /* JADX WARN: Type inference failed for: r0v2, types: [it.unimi.dsi.fastutil.longs.LongBigListIterator] */
        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.longs.LongCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongIterable
        public LongBigListIterator iterator() {
            return this.list.listIterator();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongBigListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.LongBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Long> listIterator() {
            return this.list.listIterator();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongBigListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.LongBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Long> listIterator(long i) {
            return this.list.listIterator(i);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongBigList' to match base method */
        /* JADX WARN: Type inference failed for: r0v6, types: [it.unimi.dsi.fastutil.longs.LongBigList] */
        @Override // p014it.unimi.dsi.fastutil.longs.LongBigList, p014it.unimi.dsi.fastutil.BigList
        public BigList<Long> subList(long from, long to) {
            LongBigList synchronize;
            synchronized (this.sync) {
                synchronize = LongBigLists.synchronize(this.list.subList(from, to), this.sync);
            }
            return synchronize;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.SynchronizedCollection, java.util.Collection, java.lang.Object
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

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.SynchronizedCollection, java.util.Collection, java.lang.Object
        public int hashCode() {
            int hashCode;
            synchronized (this.sync) {
                hashCode = this.list.hashCode();
            }
            return hashCode;
        }

        public int compareTo(BigList<? extends Long> o) {
            int compareTo;
            synchronized (this.sync) {
                compareTo = this.list.compareTo(o);
            }
            return compareTo;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBigList
        public boolean addAll(long index, LongCollection c) {
            boolean addAll;
            synchronized (this.sync) {
                addAll = this.list.addAll(index, c);
            }
            return addAll;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBigList
        public boolean addAll(long index, LongBigList l) {
            boolean addAll;
            synchronized (this.sync) {
                addAll = this.list.addAll(index, l);
            }
            return addAll;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBigList
        public boolean addAll(LongBigList l) {
            boolean addAll;
            synchronized (this.sync) {
                addAll = this.list.addAll(l);
            }
            return addAll;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBigList
        @Deprecated
        public void add(long i, Long k) {
            synchronized (this.sync) {
                this.list.add(i, k);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public Long get(long i) {
            Long l;
            synchronized (this.sync) {
                l = this.list.get(i);
            }
            return l;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBigList
        @Deprecated
        public Long set(long index, Long k) {
            Long l;
            synchronized (this.sync) {
                l = this.list.set(index, k);
            }
            return l;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public Long remove(long i) {
            Long remove;
            synchronized (this.sync) {
                remove = this.list.remove(i);
            }
            return remove;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public long indexOf(Object o) {
            long indexOf;
            synchronized (this.sync) {
                indexOf = this.list.indexOf(o);
            }
            return indexOf;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public long lastIndexOf(Object o) {
            long lastIndexOf;
            synchronized (this.sync) {
                lastIndexOf = this.list.lastIndexOf(o);
            }
            return lastIndexOf;
        }
    }

    public static LongBigList synchronize(LongBigList l) {
        return new SynchronizedBigList(l);
    }

    public static LongBigList synchronize(LongBigList l, Object sync) {
        return new SynchronizedBigList(l, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.LongBigLists$UnmodifiableBigList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongBigLists$UnmodifiableBigList.class */
    public static class UnmodifiableBigList extends LongCollections.UnmodifiableCollection implements LongBigList, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final LongBigList list;

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

        protected UnmodifiableBigList(LongBigList l) {
            super(l);
            this.list = l;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBigList
        public long getLong(long i) {
            return this.list.getLong(i);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBigList
        public long set(long i, long k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBigList
        public void add(long i, long k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBigList
        public long removeLong(long i) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBigList
        public long indexOf(long k) {
            return this.list.indexOf(k);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBigList
        public long lastIndexOf(long k) {
            return this.list.lastIndexOf(k);
        }

        @Override // p014it.unimi.dsi.fastutil.BigList
        public boolean addAll(long index, Collection<? extends Long> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBigList
        public void getElements(long from, long[][] a, long offset, long length) {
            this.list.getElements(from, a, offset, length);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBigList
        public void removeElements(long from, long to) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBigList
        public void addElements(long index, long[][] a, long offset, long length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBigList
        public void addElements(long index, long[][] a) {
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

        /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.longs.LongBigListIterator] */
        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.longs.LongCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongIterable
        public LongBigListIterator iterator() {
            return listIterator();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongBigListIterator' to match base method */
        /* JADX WARN: Type inference failed for: r0v2, types: [it.unimi.dsi.fastutil.longs.LongBigListIterator] */
        @Override // p014it.unimi.dsi.fastutil.longs.LongBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Long> listIterator() {
            return LongBigListIterators.unmodifiable(this.list.listIterator());
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongBigListIterator' to match base method */
        /* JADX WARN: Type inference failed for: r0v2, types: [it.unimi.dsi.fastutil.longs.LongBigListIterator] */
        @Override // p014it.unimi.dsi.fastutil.longs.LongBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Long> listIterator(long i) {
            return LongBigListIterators.unmodifiable(this.list.listIterator(i));
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongBigList' to match base method */
        /* JADX WARN: Type inference failed for: r0v2, types: [it.unimi.dsi.fastutil.longs.LongBigList] */
        @Override // p014it.unimi.dsi.fastutil.longs.LongBigList, p014it.unimi.dsi.fastutil.BigList
        public BigList<Long> subList(long from, long to) {
            return LongBigLists.unmodifiable(this.list.subList(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.UnmodifiableCollection, java.util.Collection, java.lang.Object
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            return this.list.equals(o);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.UnmodifiableCollection, java.util.Collection, java.lang.Object
        public int hashCode() {
            return this.list.hashCode();
        }

        public int compareTo(BigList<? extends Long> o) {
            return this.list.compareTo(o);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBigList
        public boolean addAll(long index, LongCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBigList
        public boolean addAll(LongBigList l) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBigList
        public boolean addAll(long index, LongBigList l) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public Long get(long i) {
            return this.list.get(i);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBigList
        @Deprecated
        public void add(long i, Long k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBigList
        @Deprecated
        public Long set(long index, Long k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public Long remove(long i) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public long indexOf(Object o) {
            return this.list.indexOf(o);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public long lastIndexOf(Object o) {
            return this.list.lastIndexOf(o);
        }
    }

    public static LongBigList unmodifiable(LongBigList l) {
        return new UnmodifiableBigList(l);
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.LongBigLists$ListBigList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongBigLists$ListBigList.class */
    public static class ListBigList extends AbstractLongBigList implements Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        private final LongList list;

        protected ListBigList(LongList list) {
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

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList, p014it.unimi.dsi.fastutil.BigList
        public void size(long size) {
            this.list.size(intIndex(size));
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList, p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
        public LongBigListIterator iterator() {
            return LongBigListIterators.asBigListIterator(this.list.iterator());
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongBigListIterator' to match base method */
        /* JADX WARN: Type inference failed for: r0v2, types: [it.unimi.dsi.fastutil.longs.LongListIterator] */
        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList, p014it.unimi.dsi.fastutil.longs.LongBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Long> listIterator() {
            return LongBigListIterators.asBigListIterator(this.list.listIterator());
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongBigListIterator' to match base method */
        /* JADX WARN: Type inference failed for: r0v2, types: [it.unimi.dsi.fastutil.longs.LongListIterator] */
        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList, p014it.unimi.dsi.fastutil.longs.LongBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Long> listIterator(long index) {
            return LongBigListIterators.asBigListIterator(this.list.listIterator(intIndex(index)));
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList, p014it.unimi.dsi.fastutil.BigList
        public boolean addAll(long index, Collection<? extends Long> c) {
            return this.list.addAll(intIndex(index), c);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongBigList' to match base method */
        /* JADX WARN: Type inference failed for: r2v2, types: [it.unimi.dsi.fastutil.longs.LongList] */
        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList, p014it.unimi.dsi.fastutil.longs.LongBigList, p014it.unimi.dsi.fastutil.BigList
        public BigList<Long> subList(long from, long to) {
            return new ListBigList(this.list.subList(intIndex(from), intIndex(to)));
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList, p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public boolean contains(long key) {
            return this.list.contains(key);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public long[] toLongArray() {
            return this.list.toLongArray();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList, p014it.unimi.dsi.fastutil.longs.LongBigList
        public void removeElements(long from, long to) {
            this.list.removeElements(intIndex(from), intIndex(to));
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        @Deprecated
        public long[] toLongArray(long[] a) {
            return this.list.toArray(a);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList, p014it.unimi.dsi.fastutil.longs.LongBigList
        public boolean addAll(long index, LongCollection c) {
            return this.list.addAll(intIndex(index), c);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList, p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public boolean addAll(LongCollection c) {
            return this.list.addAll(c);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBigList
        public boolean addAll(long index, LongBigList c) {
            return this.list.addAll(intIndex(index), (LongCollection) c);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBigList
        public boolean addAll(LongBigList c) {
            return this.list.addAll((LongCollection) c);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public boolean containsAll(LongCollection c) {
            return this.list.containsAll(c);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public boolean removeAll(LongCollection c) {
            return this.list.removeAll(c);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public boolean retainAll(LongCollection c) {
            return this.list.retainAll(c);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList, p014it.unimi.dsi.fastutil.longs.LongBigList
        public void add(long index, long key) {
            this.list.add(intIndex(index), key);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList, p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public boolean add(long key) {
            return this.list.add(key);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBigList
        public long getLong(long index) {
            return this.list.getLong(intIndex(index));
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList, p014it.unimi.dsi.fastutil.longs.LongBigList
        public long indexOf(long k) {
            return (long) this.list.indexOf(k);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList, p014it.unimi.dsi.fastutil.longs.LongBigList
        public long lastIndexOf(long k) {
            return (long) this.list.lastIndexOf(k);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList, p014it.unimi.dsi.fastutil.longs.LongBigList
        public long removeLong(long index) {
            return this.list.removeLong(intIndex(index));
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList, p014it.unimi.dsi.fastutil.longs.LongBigList
        public long set(long index, long k) {
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

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, java.util.AbstractCollection, java.util.Collection
        public boolean containsAll(Collection<?> c) {
            return this.list.containsAll(c);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList, p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection<? extends Long> c) {
            return this.list.addAll(c);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> c) {
            return this.list.removeAll(c);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> c) {
            return this.list.retainAll(c);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.list.clear();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList, java.util.Collection, java.lang.Object
        public int hashCode() {
            return this.list.hashCode();
        }
    }

    public static LongBigList asBigList(LongList list) {
        return new ListBigList(list);
    }
}
