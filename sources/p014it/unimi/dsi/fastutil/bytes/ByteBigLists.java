package p014it.unimi.dsi.fastutil.bytes;

import java.io.Serializable;
import java.util.Collection;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import okhttp3.HttpUrl;
import p014it.unimi.dsi.fastutil.BigArrays;
import p014it.unimi.dsi.fastutil.BigList;
import p014it.unimi.dsi.fastutil.BigListIterator;
import p014it.unimi.dsi.fastutil.bytes.ByteCollections;
import p014it.unimi.dsi.fastutil.ints.IntIterator;
import p014it.unimi.dsi.fastutil.ints.IntSpliterator;

/* renamed from: it.unimi.dsi.fastutil.bytes.ByteBigLists */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteBigLists.class */
public final class ByteBigLists {
    public static final EmptyBigList EMPTY_BIG_LIST = new EmptyBigList();

    private ByteBigLists() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [long] */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [long] */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static p014it.unimi.dsi.fastutil.bytes.ByteBigList shuffle(p014it.unimi.dsi.fastutil.bytes.ByteBigList r7, java.util.Random r8) {
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
            byte r0 = r0.getByte(r1)
            r13 = r0
            r0 = r7
            r1 = r9
            r2 = r7
            r3 = r11
            byte r2 = r2.getByte(r3)
            byte r0 = r0.set(r1, r2)
            r0 = r7
            r1 = r11
            r2 = r13
            byte r0 = r0.set(r1, r2)
            goto L_0x0007
        L_0x0046:
            r0 = r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.bytes.ByteBigLists.shuffle(it.unimi.dsi.fastutil.bytes.ByteBigList, java.util.Random):it.unimi.dsi.fastutil.bytes.ByteBigList");
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.ByteBigLists$EmptyBigList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteBigLists$EmptyBigList.class */
    public static class EmptyBigList extends ByteCollections.EmptyCollection implements ByteBigList, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptyBigList() {
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBigList
        public byte getByte(long i) {
            throw new IndexOutOfBoundsException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public boolean rem(byte k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBigList
        public byte removeByte(long i) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBigList
        public void add(long index, byte k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBigList
        public byte set(long index, byte k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBigList
        public long indexOf(byte k) {
            return -1;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBigList
        public long lastIndexOf(byte k) {
            return -1;
        }

        @Override // p014it.unimi.dsi.fastutil.BigList
        public boolean addAll(long i, Collection<? extends Byte> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.EmptyCollection, p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public boolean addAll(ByteCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBigList
        public boolean addAll(ByteBigList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBigList
        public boolean addAll(long i, ByteCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBigList
        public boolean addAll(long i, ByteBigList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBigList
        @Deprecated
        public void add(long index, Byte k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        @Deprecated
        public boolean add(Byte k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public Byte get(long i) {
            throw new IndexOutOfBoundsException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBigList
        @Deprecated
        public Byte set(long index, Byte k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public Byte remove(long k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public long indexOf(Object k) {
            return -1;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public long lastIndexOf(Object k) {
            return -1;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteBigListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Byte> listIterator() {
            return ByteBigListIterators.EMPTY_BIG_LIST_ITERATOR;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.EmptyCollection, p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
        public ByteBigListIterator iterator() {
            return ByteBigListIterators.EMPTY_BIG_LIST_ITERATOR;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteBigListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Byte> listIterator(long i) {
            if (i == 0) {
                return ByteBigListIterators.EMPTY_BIG_LIST_ITERATOR;
            }
            throw new IndexOutOfBoundsException(String.valueOf(i));
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.EmptyCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
        public ByteSpliterator spliterator() {
            return ByteSpliterators.EMPTY_SPLITERATOR;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteBigList' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBigList, p014it.unimi.dsi.fastutil.BigList
        public BigList<Byte> subList(long from, long to) {
            if (from == 0 && to == 0) {
                return this;
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBigList
        public void getElements(long from, byte[][] a, long offset, long length) {
            BigArrays.ensureOffsetLength(a, offset, length);
            if (from != 0) {
                throw new IndexOutOfBoundsException();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBigList
        public void removeElements(long from, long to) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBigList
        public void addElements(long index, byte[][] a, long offset, long length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBigList
        public void addElements(long index, byte[][] a) {
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

        public int compareTo(BigList<? extends Byte> o) {
            return (o != this && !o.isEmpty()) ? -1 : 0;
        }

        @Override // java.lang.Object
        public Object clone() {
            return ByteBigLists.EMPTY_BIG_LIST;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.EmptyCollection, java.util.Collection, java.lang.Object
        public int hashCode() {
            return 1;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.EmptyCollection, java.util.Collection, java.lang.Object
        public boolean equals(Object o) {
            return (o instanceof BigList) && ((BigList) o).isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, java.util.AbstractCollection, java.lang.Object
        public String toString() {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }

        private Object readResolve() {
            return ByteBigLists.EMPTY_BIG_LIST;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.ByteBigLists$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteBigLists$Singleton.class */
    public static class Singleton extends AbstractByteBigList implements Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        private final byte element;

        protected Singleton(byte element) {
            this.element = element;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBigList
        public byte getByte(long i) {
            if (i == 0) {
                return this.element;
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteBigList, p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public boolean rem(byte k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteBigList, p014it.unimi.dsi.fastutil.bytes.ByteBigList
        public byte removeByte(long i) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteBigList, p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public boolean contains(byte k) {
            return k == this.element;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteBigList, p014it.unimi.dsi.fastutil.bytes.ByteBigList
        public long indexOf(byte k) {
            return k == this.element ? 0 : -1;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public byte[] toByteArray() {
            return new byte[]{this.element};
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteBigListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteBigList, p014it.unimi.dsi.fastutil.bytes.ByteBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Byte> listIterator() {
            return ByteBigListIterators.singleton(this.element);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteBigListIterator' to match base method */
        /* JADX WARN: Type inference failed for: r0v6, types: [it.unimi.dsi.fastutil.BigListIterator<java.lang.Byte>, it.unimi.dsi.fastutil.bytes.ByteBigListIterator] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteBigList, p014it.unimi.dsi.fastutil.bytes.ByteBigList, p014it.unimi.dsi.fastutil.BigList
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public p014it.unimi.dsi.fastutil.BigListIterator<java.lang.Byte> listIterator(long r6) {
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
                it.unimi.dsi.fastutil.bytes.ByteBigListIterator r0 = r0.listIterator()
                r8 = r0
                r0 = r6
                r1 = 1
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 != 0) goto L_0x0026
                r0 = r8
                byte r0 = r0.nextByte()
            L_0x0026:
                r0 = r8
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.bytes.ByteBigLists.Singleton.listIterator(long):it.unimi.dsi.fastutil.bytes.ByteBigListIterator");
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
        public ByteSpliterator spliterator() {
            return ByteSpliterators.singleton(this.element);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteBigList' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteBigList, p014it.unimi.dsi.fastutil.bytes.ByteBigList, p014it.unimi.dsi.fastutil.BigList
        public BigList<Byte> subList(long from, long to) {
            ensureIndex(from);
            ensureIndex(to);
            if (from <= to) {
                return (from == 0 && to == 1) ? this : ByteBigLists.EMPTY_BIG_LIST;
            }
            throw new IndexOutOfBoundsException("Start index (" + from + ") is greater than end index (" + to + ")");
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteBigList, p014it.unimi.dsi.fastutil.BigList
        public boolean addAll(long i, Collection<? extends Byte> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteBigList, p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection<? extends Byte> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBigList
        public boolean addAll(ByteBigList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBigList
        public boolean addAll(long i, ByteBigList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteBigList, p014it.unimi.dsi.fastutil.bytes.ByteBigList
        public boolean addAll(long i, ByteCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteBigList, p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public boolean addAll(ByteCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public boolean removeAll(ByteCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public boolean retainAll(ByteCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteBigList, java.util.AbstractCollection, java.util.Collection
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

    public static ByteBigList singleton(byte element) {
        return new Singleton(element);
    }

    public static ByteBigList singleton(Object element) {
        return new Singleton(((Byte) element).byteValue());
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.ByteBigLists$SynchronizedBigList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteBigLists$SynchronizedBigList.class */
    public static class SynchronizedBigList extends ByteCollections.SynchronizedCollection implements ByteBigList, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final ByteBigList list;

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.SynchronizedCollection, java.lang.Object
        public /* bridge */ /* synthetic */ String toString() {
            return toString();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ void clear() {
            clear();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public /* bridge */ /* synthetic */ boolean removeIf(BytePredicate bytePredicate) {
            return removeIf(bytePredicate);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
            return retainAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
            return removeAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean containsAll(Collection collection) {
            return containsAll(collection);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.Collection] */
        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean addAll(Collection<? extends Byte> collection) {
            return addAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable
        public /* bridge */ /* synthetic */ void forEach(ByteConsumer byteConsumer) {
            forEach(byteConsumer);
        }

        /* Return type fixed from 'java.util.stream.Stream' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ Stream<Byte> parallelStream() {
            return parallelStream();
        }

        /* Return type fixed from 'java.util.stream.Stream' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ Stream<Byte> stream() {
            return stream();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
        public /* bridge */ /* synthetic */ ByteSpliterator spliterator() {
            return spliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Object[] toArray(Object[] objArr) {
            return toArray(objArr);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public /* bridge */ /* synthetic */ IntStream intParallelStream() {
            return intParallelStream();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public /* bridge */ /* synthetic */ IntStream intStream() {
            return intStream();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable
        public /* bridge */ /* synthetic */ IntSpliterator intSpliterator() {
            return intSpliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable
        public /* bridge */ /* synthetic */ IntIterator intIterator() {
            return intIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean remove(Object obj) {
            return remove(obj);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean contains(Object obj) {
            return contains(obj);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean add(Byte b) {
            return add(b);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public /* bridge */ /* synthetic */ boolean retainAll(ByteCollection byteCollection) {
            return retainAll(byteCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public /* bridge */ /* synthetic */ boolean removeAll(ByteCollection byteCollection) {
            return removeAll(byteCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public /* bridge */ /* synthetic */ boolean containsAll(ByteCollection byteCollection) {
            return containsAll(byteCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public /* bridge */ /* synthetic */ boolean addAll(ByteCollection byteCollection) {
            return addAll(byteCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public /* bridge */ /* synthetic */ byte[] toArray(byte[] bArr) {
            return toArray(bArr);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        @Deprecated
        public /* bridge */ /* synthetic */ byte[] toByteArray(byte[] bArr) {
            return toByteArray(bArr);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Object[] toArray() {
            return toArray();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public /* bridge */ /* synthetic */ byte[] toByteArray() {
            return toByteArray();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean isEmpty() {
            return isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.SynchronizedCollection, java.util.Collection, p014it.unimi.dsi.fastutil.BigList, p014it.unimi.dsi.fastutil.Size64
        public /* bridge */ /* synthetic */ int size() {
            return size();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public /* bridge */ /* synthetic */ boolean rem(byte b) {
            return rem(b);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public /* bridge */ /* synthetic */ boolean contains(byte b) {
            return contains(b);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public /* bridge */ /* synthetic */ boolean add(byte b) {
            return add(b);
        }

        protected SynchronizedBigList(ByteBigList l, Object sync) {
            super(l, sync);
            this.list = l;
        }

        protected SynchronizedBigList(ByteBigList l) {
            super(l);
            this.list = l;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBigList
        public byte getByte(long i) {
            byte b;
            synchronized (this.sync) {
                b = this.list.getByte(i);
            }
            return b;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBigList
        public byte set(long i, byte k) {
            byte b;
            synchronized (this.sync) {
                b = this.list.set(i, k);
            }
            return b;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBigList
        public void add(long i, byte k) {
            synchronized (this.sync) {
                this.list.add(i, k);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBigList
        public byte removeByte(long i) {
            byte removeByte;
            synchronized (this.sync) {
                removeByte = this.list.removeByte(i);
            }
            return removeByte;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBigList
        public long indexOf(byte k) {
            long indexOf;
            synchronized (this.sync) {
                indexOf = this.list.indexOf(k);
            }
            return indexOf;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBigList
        public long lastIndexOf(byte k) {
            long lastIndexOf;
            synchronized (this.sync) {
                lastIndexOf = this.list.lastIndexOf(k);
            }
            return lastIndexOf;
        }

        @Override // p014it.unimi.dsi.fastutil.BigList
        public boolean addAll(long index, Collection<? extends Byte> c) {
            boolean addAll;
            synchronized (this.sync) {
                addAll = this.list.addAll(index, c);
            }
            return addAll;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBigList
        public void getElements(long from, byte[][] a, long offset, long length) {
            synchronized (this.sync) {
                this.list.getElements(from, a, offset, length);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBigList
        public void removeElements(long from, long to) {
            synchronized (this.sync) {
                this.list.removeElements(from, to);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBigList
        public void addElements(long index, byte[][] a, long offset, long length) {
            synchronized (this.sync) {
                this.list.addElements(index, a, offset, length);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBigList
        public void addElements(long index, byte[][] a) {
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

        /* JADX WARN: Type inference failed for: r0v2, types: [it.unimi.dsi.fastutil.bytes.ByteBigListIterator] */
        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
        public ByteBigListIterator iterator() {
            return this.list.listIterator();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteBigListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Byte> listIterator() {
            return this.list.listIterator();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteBigListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Byte> listIterator(long i) {
            return this.list.listIterator(i);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteBigList' to match base method */
        /* JADX WARN: Type inference failed for: r0v6, types: [it.unimi.dsi.fastutil.bytes.ByteBigList] */
        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBigList, p014it.unimi.dsi.fastutil.BigList
        public BigList<Byte> subList(long from, long to) {
            ByteBigList synchronize;
            synchronized (this.sync) {
                synchronize = ByteBigLists.synchronize(this.list.subList(from, to), this.sync);
            }
            return synchronize;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.SynchronizedCollection, java.util.Collection, java.lang.Object
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

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.SynchronizedCollection, java.util.Collection, java.lang.Object
        public int hashCode() {
            int hashCode;
            synchronized (this.sync) {
                hashCode = this.list.hashCode();
            }
            return hashCode;
        }

        public int compareTo(BigList<? extends Byte> o) {
            int compareTo;
            synchronized (this.sync) {
                compareTo = this.list.compareTo(o);
            }
            return compareTo;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBigList
        public boolean addAll(long index, ByteCollection c) {
            boolean addAll;
            synchronized (this.sync) {
                addAll = this.list.addAll(index, c);
            }
            return addAll;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBigList
        public boolean addAll(long index, ByteBigList l) {
            boolean addAll;
            synchronized (this.sync) {
                addAll = this.list.addAll(index, l);
            }
            return addAll;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBigList
        public boolean addAll(ByteBigList l) {
            boolean addAll;
            synchronized (this.sync) {
                addAll = this.list.addAll(l);
            }
            return addAll;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBigList
        @Deprecated
        public void add(long i, Byte k) {
            synchronized (this.sync) {
                this.list.add(i, k);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public Byte get(long i) {
            Byte b;
            synchronized (this.sync) {
                b = this.list.get(i);
            }
            return b;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBigList
        @Deprecated
        public Byte set(long index, Byte k) {
            Byte b;
            synchronized (this.sync) {
                b = this.list.set(index, k);
            }
            return b;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public Byte remove(long i) {
            Byte remove;
            synchronized (this.sync) {
                remove = this.list.remove(i);
            }
            return remove;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public long indexOf(Object o) {
            long indexOf;
            synchronized (this.sync) {
                indexOf = this.list.indexOf(o);
            }
            return indexOf;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public long lastIndexOf(Object o) {
            long lastIndexOf;
            synchronized (this.sync) {
                lastIndexOf = this.list.lastIndexOf(o);
            }
            return lastIndexOf;
        }
    }

    public static ByteBigList synchronize(ByteBigList l) {
        return new SynchronizedBigList(l);
    }

    public static ByteBigList synchronize(ByteBigList l, Object sync) {
        return new SynchronizedBigList(l, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.ByteBigLists$UnmodifiableBigList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteBigLists$UnmodifiableBigList.class */
    public static class UnmodifiableBigList extends ByteCollections.UnmodifiableCollection implements ByteBigList, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final ByteBigList list;

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.UnmodifiableCollection, java.lang.Object
        public /* bridge */ /* synthetic */ String toString() {
            return toString();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public /* bridge */ /* synthetic */ IntStream intParallelStream() {
            return intParallelStream();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public /* bridge */ /* synthetic */ IntStream intStream() {
            return intStream();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable
        public /* bridge */ /* synthetic */ IntSpliterator intSpliterator() {
            return intSpliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable
        public /* bridge */ /* synthetic */ IntIterator intIterator() {
            return intIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public /* bridge */ /* synthetic */ boolean retainAll(ByteCollection byteCollection) {
            return retainAll(byteCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public /* bridge */ /* synthetic */ boolean removeAll(ByteCollection byteCollection) {
            return removeAll(byteCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public /* bridge */ /* synthetic */ boolean addAll(ByteCollection byteCollection) {
            return addAll(byteCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public /* bridge */ /* synthetic */ boolean containsAll(ByteCollection byteCollection) {
            return containsAll(byteCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public /* bridge */ /* synthetic */ byte[] toArray(byte[] bArr) {
            return toArray(bArr);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        @Deprecated
        public /* bridge */ /* synthetic */ byte[] toByteArray(byte[] bArr) {
            return toByteArray(bArr);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public /* bridge */ /* synthetic */ byte[] toByteArray() {
            return toByteArray();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean remove(Object obj) {
            return remove(obj);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean contains(Object obj) {
            return contains(obj);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean add(Byte b) {
            return add(b);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public /* bridge */ /* synthetic */ boolean removeIf(BytePredicate bytePredicate) {
            return removeIf(bytePredicate);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
            return retainAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
            return removeAll(collection);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.Collection] */
        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean addAll(Collection<? extends Byte> collection) {
            return addAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean containsAll(Collection collection) {
            return containsAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable
        public /* bridge */ /* synthetic */ void forEach(ByteConsumer byteConsumer) {
            forEach(byteConsumer);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Object[] toArray() {
            return toArray();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Object[] toArray(Object[] objArr) {
            return toArray(objArr);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ void clear() {
            clear();
        }

        /* Return type fixed from 'java.util.stream.Stream' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ Stream<Byte> parallelStream() {
            return parallelStream();
        }

        /* Return type fixed from 'java.util.stream.Stream' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ Stream<Byte> stream() {
            return stream();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
        public /* bridge */ /* synthetic */ ByteSpliterator spliterator() {
            return spliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public /* bridge */ /* synthetic */ boolean contains(byte b) {
            return contains(b);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean isEmpty() {
            return isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.UnmodifiableCollection, java.util.Collection, p014it.unimi.dsi.fastutil.BigList, p014it.unimi.dsi.fastutil.Size64
        public /* bridge */ /* synthetic */ int size() {
            return size();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public /* bridge */ /* synthetic */ boolean rem(byte b) {
            return rem(b);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public /* bridge */ /* synthetic */ boolean add(byte b) {
            return add(b);
        }

        protected UnmodifiableBigList(ByteBigList l) {
            super(l);
            this.list = l;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBigList
        public byte getByte(long i) {
            return this.list.getByte(i);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBigList
        public byte set(long i, byte k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBigList
        public void add(long i, byte k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBigList
        public byte removeByte(long i) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBigList
        public long indexOf(byte k) {
            return this.list.indexOf(k);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBigList
        public long lastIndexOf(byte k) {
            return this.list.lastIndexOf(k);
        }

        @Override // p014it.unimi.dsi.fastutil.BigList
        public boolean addAll(long index, Collection<? extends Byte> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBigList
        public void getElements(long from, byte[][] a, long offset, long length) {
            this.list.getElements(from, a, offset, length);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBigList
        public void removeElements(long from, long to) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBigList
        public void addElements(long index, byte[][] a, long offset, long length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBigList
        public void addElements(long index, byte[][] a) {
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

        /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.bytes.ByteBigListIterator] */
        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
        public ByteBigListIterator iterator() {
            return listIterator();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteBigListIterator' to match base method */
        /* JADX WARN: Type inference failed for: r0v2, types: [it.unimi.dsi.fastutil.bytes.ByteBigListIterator] */
        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Byte> listIterator() {
            return ByteBigListIterators.unmodifiable(this.list.listIterator());
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteBigListIterator' to match base method */
        /* JADX WARN: Type inference failed for: r0v2, types: [it.unimi.dsi.fastutil.bytes.ByteBigListIterator] */
        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Byte> listIterator(long i) {
            return ByteBigListIterators.unmodifiable(this.list.listIterator(i));
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteBigList' to match base method */
        /* JADX WARN: Type inference failed for: r0v2, types: [it.unimi.dsi.fastutil.bytes.ByteBigList] */
        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBigList, p014it.unimi.dsi.fastutil.BigList
        public BigList<Byte> subList(long from, long to) {
            return ByteBigLists.unmodifiable(this.list.subList(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.UnmodifiableCollection, java.util.Collection, java.lang.Object
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            return this.list.equals(o);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.UnmodifiableCollection, java.util.Collection, java.lang.Object
        public int hashCode() {
            return this.list.hashCode();
        }

        public int compareTo(BigList<? extends Byte> o) {
            return this.list.compareTo(o);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBigList
        public boolean addAll(long index, ByteCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBigList
        public boolean addAll(ByteBigList l) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBigList
        public boolean addAll(long index, ByteBigList l) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public Byte get(long i) {
            return this.list.get(i);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBigList
        @Deprecated
        public void add(long i, Byte k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBigList
        @Deprecated
        public Byte set(long index, Byte k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public Byte remove(long i) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public long indexOf(Object o) {
            return this.list.indexOf(o);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public long lastIndexOf(Object o) {
            return this.list.lastIndexOf(o);
        }
    }

    public static ByteBigList unmodifiable(ByteBigList l) {
        return new UnmodifiableBigList(l);
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.ByteBigLists$ListBigList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteBigLists$ListBigList.class */
    public static class ListBigList extends AbstractByteBigList implements Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        private final ByteList list;

        protected ListBigList(ByteList list) {
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

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteBigList, p014it.unimi.dsi.fastutil.BigList
        public void size(long size) {
            this.list.size(intIndex(size));
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteBigList, p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
        public ByteBigListIterator iterator() {
            return ByteBigListIterators.asBigListIterator(this.list.iterator());
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteBigListIterator' to match base method */
        /* JADX WARN: Type inference failed for: r0v2, types: [it.unimi.dsi.fastutil.bytes.ByteListIterator] */
        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteBigList, p014it.unimi.dsi.fastutil.bytes.ByteBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Byte> listIterator() {
            return ByteBigListIterators.asBigListIterator(this.list.listIterator());
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteBigListIterator' to match base method */
        /* JADX WARN: Type inference failed for: r0v2, types: [it.unimi.dsi.fastutil.bytes.ByteListIterator] */
        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteBigList, p014it.unimi.dsi.fastutil.bytes.ByteBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Byte> listIterator(long index) {
            return ByteBigListIterators.asBigListIterator(this.list.listIterator(intIndex(index)));
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteBigList, p014it.unimi.dsi.fastutil.BigList
        public boolean addAll(long index, Collection<? extends Byte> c) {
            return this.list.addAll(intIndex(index), c);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteBigList' to match base method */
        /* JADX WARN: Type inference failed for: r2v2, types: [it.unimi.dsi.fastutil.bytes.ByteList] */
        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteBigList, p014it.unimi.dsi.fastutil.bytes.ByteBigList, p014it.unimi.dsi.fastutil.BigList
        public BigList<Byte> subList(long from, long to) {
            return new ListBigList(this.list.subList(intIndex(from), intIndex(to)));
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteBigList, p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public boolean contains(byte key) {
            return this.list.contains(key);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public byte[] toByteArray() {
            return this.list.toByteArray();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteBigList, p014it.unimi.dsi.fastutil.bytes.ByteBigList
        public void removeElements(long from, long to) {
            this.list.removeElements(intIndex(from), intIndex(to));
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        @Deprecated
        public byte[] toByteArray(byte[] a) {
            return this.list.toArray(a);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteBigList, p014it.unimi.dsi.fastutil.bytes.ByteBigList
        public boolean addAll(long index, ByteCollection c) {
            return this.list.addAll(intIndex(index), c);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteBigList, p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public boolean addAll(ByteCollection c) {
            return this.list.addAll(c);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBigList
        public boolean addAll(long index, ByteBigList c) {
            return this.list.addAll(intIndex(index), (ByteCollection) c);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBigList
        public boolean addAll(ByteBigList c) {
            return this.list.addAll((ByteCollection) c);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public boolean containsAll(ByteCollection c) {
            return this.list.containsAll(c);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public boolean removeAll(ByteCollection c) {
            return this.list.removeAll(c);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public boolean retainAll(ByteCollection c) {
            return this.list.retainAll(c);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteBigList, p014it.unimi.dsi.fastutil.bytes.ByteBigList
        public void add(long index, byte key) {
            this.list.add(intIndex(index), key);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteBigList, p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public boolean add(byte key) {
            return this.list.add(key);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBigList
        public byte getByte(long index) {
            return this.list.getByte(intIndex(index));
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteBigList, p014it.unimi.dsi.fastutil.bytes.ByteBigList
        public long indexOf(byte k) {
            return (long) this.list.indexOf(k);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteBigList, p014it.unimi.dsi.fastutil.bytes.ByteBigList
        public long lastIndexOf(byte k) {
            return (long) this.list.lastIndexOf(k);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteBigList, p014it.unimi.dsi.fastutil.bytes.ByteBigList
        public byte removeByte(long index) {
            return this.list.removeByte(intIndex(index));
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteBigList, p014it.unimi.dsi.fastutil.bytes.ByteBigList
        public byte set(long index, byte k) {
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

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, java.util.AbstractCollection, java.util.Collection
        public boolean containsAll(Collection<?> c) {
            return this.list.containsAll(c);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteBigList, p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection<? extends Byte> c) {
            return this.list.addAll(c);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> c) {
            return this.list.removeAll(c);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> c) {
            return this.list.retainAll(c);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteBigList, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.list.clear();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteBigList, java.util.Collection, java.lang.Object
        public int hashCode() {
            return this.list.hashCode();
        }
    }

    public static ByteBigList asBigList(ByteList list) {
        return new ListBigList(list);
    }
}
