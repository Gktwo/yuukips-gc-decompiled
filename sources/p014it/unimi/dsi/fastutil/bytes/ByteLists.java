package p014it.unimi.dsi.fastutil.bytes;

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
import p014it.unimi.dsi.fastutil.bytes.ByteCollections;
import p014it.unimi.dsi.fastutil.ints.IntIterator;
import p014it.unimi.dsi.fastutil.ints.IntIterators;
import p014it.unimi.dsi.fastutil.ints.IntSpliterator;
import p014it.unimi.dsi.fastutil.ints.IntSpliterators;

/* renamed from: it.unimi.dsi.fastutil.bytes.ByteLists */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteLists.class */
public final class ByteLists {
    public static final EmptyList EMPTY_LIST = new EmptyList();

    private ByteLists() {
    }

    public static ByteList shuffle(ByteList l, Random random) {
        int i = l.size();
        while (true) {
            i--;
            if (i == 0) {
                return l;
            }
            int p = random.nextInt(i + 1);
            byte t = l.getByte(i);
            l.set(i, l.getByte(p));
            l.set(p, t);
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.ByteLists$EmptyList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteLists$EmptyList.class */
    public static class EmptyList extends ByteCollections.EmptyCollection implements ByteList, RandomAccess, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptyList() {
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        public byte getByte(int i) {
            throw new IndexOutOfBoundsException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public boolean rem(byte k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        public byte removeByte(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        public void add(int index, byte k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        public byte set(int index, byte k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        public int indexOf(byte k) {
            return -1;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        public int lastIndexOf(byte k) {
            return -1;
        }

        @Override // java.util.List
        public boolean addAll(int i, Collection<? extends Byte> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList, java.util.List
        @Deprecated
        public void replaceAll(UnaryOperator<Byte> operator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        public void replaceAll(ByteUnaryOperator operator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        public boolean addAll(ByteList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        public boolean addAll(int i, ByteCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        public boolean addAll(int i, ByteList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        @Deprecated
        public void add(int index, Byte k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList, java.util.List
        @Deprecated
        public Byte get(int index) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        @Deprecated
        public boolean add(Byte k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        @Deprecated
        public Byte set(int index, Byte k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList, java.util.List
        @Deprecated
        public Byte remove(int k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList, java.util.List
        @Deprecated
        public int indexOf(Object k) {
            return -1;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList, java.util.List
        @Deprecated
        public int lastIndexOf(Object k) {
            return -1;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        public void sort(ByteComparator comparator) {
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        public void unstableSort(ByteComparator comparator) {
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList, java.util.List
        @Deprecated
        public void sort(Comparator<? super Byte> comparator) {
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        @Deprecated
        public void unstableSort(Comparator<? super Byte> comparator) {
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList, java.util.List
        public ListIterator<Byte> listIterator() {
            return ByteIterators.EMPTY_ITERATOR;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.EmptyCollection, p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
        public ByteListIterator iterator() {
            return ByteIterators.EMPTY_ITERATOR;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList, java.util.List
        public ListIterator<Byte> listIterator(int i) {
            if (i == 0) {
                return ByteIterators.EMPTY_ITERATOR;
            }
            throw new IndexOutOfBoundsException(String.valueOf(i));
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteList' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList, java.util.List
        public List<Byte> subList(int from, int to) {
            if (from == 0 && to == 0) {
                return this;
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        public void getElements(int from, byte[] a, int offset, int length) {
            if (from != 0 || length != 0 || offset < 0 || offset > a.length) {
                throw new IndexOutOfBoundsException();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        public void removeElements(int from, int to) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        public void addElements(int index, byte[] a, int offset, int length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        public void addElements(int index, byte[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        public void setElements(byte[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        public void setElements(int index, byte[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        public void setElements(int index, byte[] a, int offset, int length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        public void size(int s) {
            throw new UnsupportedOperationException();
        }

        public int compareTo(List<? extends Byte> o) {
            return (o != this && !o.isEmpty()) ? -1 : 0;
        }

        @Override // java.lang.Object
        public Object clone() {
            return ByteLists.EMPTY_LIST;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.EmptyCollection, java.util.Collection, java.lang.Object
        public int hashCode() {
            return 1;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.EmptyCollection, java.util.Collection, java.lang.Object
        public boolean equals(Object o) {
            return (o instanceof List) && ((List) o).isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, java.util.AbstractCollection, java.lang.Object
        public String toString() {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }

        private Object readResolve() {
            return ByteLists.EMPTY_LIST;
        }
    }

    public static ByteList emptyList() {
        return EMPTY_LIST;
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.ByteLists$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteLists$Singleton.class */
    public static class Singleton extends AbstractByteList implements RandomAccess, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        private final byte element;

        protected Singleton(byte element) {
            this.element = element;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        public byte getByte(int i) {
            if (i == 0) {
                return this.element;
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public boolean rem(byte k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, p014it.unimi.dsi.fastutil.bytes.ByteList
        public byte removeByte(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public boolean contains(byte k) {
            return k == this.element;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, p014it.unimi.dsi.fastutil.bytes.ByteList
        public int indexOf(byte k) {
            return k == this.element ? 0 : -1;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public byte[] toByteArray() {
            return new byte[]{this.element};
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, p014it.unimi.dsi.fastutil.bytes.ByteList, java.util.List
        public ListIterator<Byte> listIterator() {
            return ByteIterators.singleton(this.element);
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.bytes.ByteListIterator] */
        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
        public ByteListIterator iterator() {
            return listIterator();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
        public ByteSpliterator spliterator() {
            return ByteSpliterators.singleton(this.element);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteListIterator' to match base method */
        /* JADX WARN: Type inference failed for: r0v4, types: [java.util.ListIterator<java.lang.Byte>, it.unimi.dsi.fastutil.bytes.ByteListIterator] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, p014it.unimi.dsi.fastutil.bytes.ByteList, java.util.List
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.util.ListIterator<java.lang.Byte> listIterator(int r4) {
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
                it.unimi.dsi.fastutil.bytes.ByteListIterator r0 = r0.listIterator()
                r5 = r0
                r0 = r4
                r1 = 1
                if (r0 != r1) goto L_0x0022
                r0 = r5
                byte r0 = r0.nextByte()
            L_0x0022:
                r0 = r5
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.bytes.ByteLists.Singleton.listIterator(int):it.unimi.dsi.fastutil.bytes.ByteListIterator");
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteList' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, p014it.unimi.dsi.fastutil.bytes.ByteList, java.util.List
        public List<Byte> subList(int from, int to) {
            ensureIndex(from);
            ensureIndex(to);
            if (from <= to) {
                return (from == 0 && to == 1) ? this : ByteLists.EMPTY_LIST;
            }
            throw new IndexOutOfBoundsException("Start index (" + from + ") is greater than end index (" + to + ")");
        }

        @Override // java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteIterable
        @Deprecated
        public void forEach(Consumer<? super Byte> action) {
            action.accept(Byte.valueOf(this.element));
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, java.util.List
        public boolean addAll(int i, Collection<? extends Byte> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, java.util.AbstractCollection, java.util.Collection
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

        @Override // java.util.Collection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        @Deprecated
        public boolean removeIf(Predicate<? super Byte> filter) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList, java.util.List
        @Deprecated
        public void replaceAll(UnaryOperator<Byte> operator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        public void replaceAll(ByteUnaryOperator operator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, p014it.unimi.dsi.fastutil.bytes.ByteIterable
        public void forEach(ByteConsumer action) {
            action.accept(this.element);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        public boolean addAll(ByteList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        public boolean addAll(int i, ByteList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, p014it.unimi.dsi.fastutil.bytes.ByteList
        public boolean addAll(int i, ByteCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
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

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public boolean removeIf(BytePredicate filter) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable
        public IntIterator intIterator() {
            return IntIterators.singleton(this.element);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable
        public IntSpliterator intSpliterator() {
            return IntSpliterators.singleton(this.element);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        @Deprecated
        public Object[] toArray() {
            return new Object[]{Byte.valueOf(this.element)};
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        public void sort(ByteComparator comparator) {
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        public void unstableSort(ByteComparator comparator) {
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList, java.util.List
        @Deprecated
        public void sort(Comparator<? super Byte> comparator) {
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        @Deprecated
        public void unstableSort(Comparator<? super Byte> comparator) {
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, p014it.unimi.dsi.fastutil.bytes.ByteList
        public void getElements(int from, byte[] a, int offset, int length) {
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

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, p014it.unimi.dsi.fastutil.bytes.ByteList
        public void removeElements(int from, int to) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, p014it.unimi.dsi.fastutil.bytes.ByteList
        public void addElements(int index, byte[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, p014it.unimi.dsi.fastutil.bytes.ByteList
        public void addElements(int index, byte[] a, int offset, int length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        public void setElements(byte[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        public void setElements(int index, byte[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, p014it.unimi.dsi.fastutil.bytes.ByteList
        public void setElements(int index, byte[] a, int offset, int length) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return 1;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, p014it.unimi.dsi.fastutil.bytes.ByteList
        public void size(int size) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // java.lang.Object
        public Object clone() {
            return this;
        }
    }

    public static ByteList singleton(byte element) {
        return new Singleton(element);
    }

    public static ByteList singleton(Object element) {
        return new Singleton(((Byte) element).byteValue());
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.ByteLists$SynchronizedList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteLists$SynchronizedList.class */
    public static class SynchronizedList extends ByteCollections.SynchronizedCollection implements ByteList, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final ByteList list;

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.SynchronizedCollection, java.lang.Object
        public /* bridge */ /* synthetic */ String toString() {
            return toString();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ void clear() {
            clear();
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

        protected SynchronizedList(ByteList l, Object sync) {
            super(l, sync);
            this.list = l;
        }

        protected SynchronizedList(ByteList l) {
            super(l);
            this.list = l;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        public byte getByte(int i) {
            byte b;
            synchronized (this.sync) {
                b = this.list.getByte(i);
            }
            return b;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        public byte set(int i, byte k) {
            byte b;
            synchronized (this.sync) {
                b = this.list.set(i, k);
            }
            return b;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        public void add(int i, byte k) {
            synchronized (this.sync) {
                this.list.add(i, k);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        public byte removeByte(int i) {
            byte removeByte;
            synchronized (this.sync) {
                removeByte = this.list.removeByte(i);
            }
            return removeByte;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        public int indexOf(byte k) {
            int indexOf;
            synchronized (this.sync) {
                indexOf = this.list.indexOf(k);
            }
            return indexOf;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        public int lastIndexOf(byte k) {
            int lastIndexOf;
            synchronized (this.sync) {
                lastIndexOf = this.list.lastIndexOf(k);
            }
            return lastIndexOf;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public boolean removeIf(BytePredicate filter) {
            boolean removeIf;
            synchronized (this.sync) {
                removeIf = this.list.removeIf(filter);
            }
            return removeIf;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        public void replaceAll(ByteUnaryOperator operator) {
            synchronized (this.sync) {
                this.list.replaceAll(operator);
            }
        }

        @Override // java.util.List
        public boolean addAll(int index, Collection<? extends Byte> c) {
            boolean addAll;
            synchronized (this.sync) {
                addAll = this.list.addAll(index, c);
            }
            return addAll;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        public void getElements(int from, byte[] a, int offset, int length) {
            synchronized (this.sync) {
                this.list.getElements(from, a, offset, length);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        public void removeElements(int from, int to) {
            synchronized (this.sync) {
                this.list.removeElements(from, to);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        public void addElements(int index, byte[] a, int offset, int length) {
            synchronized (this.sync) {
                this.list.addElements(index, a, offset, length);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        public void addElements(int index, byte[] a) {
            synchronized (this.sync) {
                this.list.addElements(index, a);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        public void setElements(byte[] a) {
            synchronized (this.sync) {
                this.list.setElements(a);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        public void setElements(int index, byte[] a) {
            synchronized (this.sync) {
                this.list.setElements(index, a);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        public void setElements(int index, byte[] a, int offset, int length) {
            synchronized (this.sync) {
                this.list.setElements(index, a, offset, length);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        public void size(int size) {
            synchronized (this.sync) {
                this.list.size(size);
            }
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList, java.util.List
        public ListIterator<Byte> listIterator() {
            return this.list.listIterator();
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.bytes.ByteListIterator] */
        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
        public ByteListIterator iterator() {
            return listIterator();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList, java.util.List
        public ListIterator<Byte> listIterator(int i) {
            return this.list.listIterator(i);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteList' to match base method */
        /* JADX WARN: Type inference failed for: r2v2, types: [it.unimi.dsi.fastutil.bytes.ByteList] */
        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList, java.util.List
        public List<Byte> subList(int from, int to) {
            SynchronizedList synchronizedList;
            synchronized (this.sync) {
                synchronizedList = new SynchronizedList(this.list.subList(from, to), this.sync);
            }
            return synchronizedList;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.SynchronizedCollection, java.util.Collection, java.lang.Object
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

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.SynchronizedCollection, java.util.Collection, java.lang.Object
        public int hashCode() {
            int hashCode;
            synchronized (this.sync) {
                hashCode = this.collection.hashCode();
            }
            return hashCode;
        }

        public int compareTo(List<? extends Byte> o) {
            int compareTo;
            synchronized (this.sync) {
                compareTo = this.list.compareTo(o);
            }
            return compareTo;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        public boolean addAll(int index, ByteCollection c) {
            boolean addAll;
            synchronized (this.sync) {
                addAll = this.list.addAll(index, c);
            }
            return addAll;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        public boolean addAll(int index, ByteList l) {
            boolean addAll;
            synchronized (this.sync) {
                addAll = this.list.addAll(index, l);
            }
            return addAll;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        public boolean addAll(ByteList l) {
            boolean addAll;
            synchronized (this.sync) {
                addAll = this.list.addAll(l);
            }
            return addAll;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList, java.util.List
        @Deprecated
        public Byte get(int i) {
            Byte b;
            synchronized (this.sync) {
                b = this.list.get(i);
            }
            return b;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        @Deprecated
        public void add(int i, Byte k) {
            synchronized (this.sync) {
                this.list.add(i, k);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        @Deprecated
        public Byte set(int index, Byte k) {
            Byte b;
            synchronized (this.sync) {
                b = this.list.set(index, k);
            }
            return b;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList, java.util.List
        @Deprecated
        public Byte remove(int i) {
            Byte remove;
            synchronized (this.sync) {
                remove = this.list.remove(i);
            }
            return remove;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList, java.util.List
        @Deprecated
        public int indexOf(Object o) {
            int indexOf;
            synchronized (this.sync) {
                indexOf = this.list.indexOf(o);
            }
            return indexOf;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList, java.util.List
        @Deprecated
        public int lastIndexOf(Object o) {
            int lastIndexOf;
            synchronized (this.sync) {
                lastIndexOf = this.list.lastIndexOf(o);
            }
            return lastIndexOf;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        public void sort(ByteComparator comparator) {
            synchronized (this.sync) {
                this.list.sort(comparator);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        public void unstableSort(ByteComparator comparator) {
            synchronized (this.sync) {
                this.list.unstableSort(comparator);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList, java.util.List
        @Deprecated
        public void sort(Comparator<? super Byte> comparator) {
            synchronized (this.sync) {
                this.list.sort(comparator);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        @Deprecated
        public void unstableSort(Comparator<? super Byte> comparator) {
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

    /* renamed from: it.unimi.dsi.fastutil.bytes.ByteLists$SynchronizedRandomAccessList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteLists$SynchronizedRandomAccessList.class */
    public static class SynchronizedRandomAccessList extends SynchronizedList implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;

        protected SynchronizedRandomAccessList(ByteList l, Object sync) {
            super(l, sync);
        }

        protected SynchronizedRandomAccessList(ByteList l) {
            super(l);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteList' to match base method */
        /* JADX WARN: Type inference failed for: r2v2, types: [it.unimi.dsi.fastutil.bytes.ByteList] */
        @Override // p014it.unimi.dsi.fastutil.bytes.ByteLists.SynchronizedList, p014it.unimi.dsi.fastutil.bytes.ByteList, java.util.List
        public List<Byte> subList(int from, int to) {
            SynchronizedRandomAccessList synchronizedRandomAccessList;
            synchronized (this.sync) {
                synchronizedRandomAccessList = new SynchronizedRandomAccessList(this.list.subList(from, to), this.sync);
            }
            return synchronizedRandomAccessList;
        }
    }

    public static ByteList synchronize(ByteList l) {
        return l instanceof RandomAccess ? new SynchronizedRandomAccessList(l) : new SynchronizedList(l);
    }

    public static ByteList synchronize(ByteList l, Object sync) {
        return l instanceof RandomAccess ? new SynchronizedRandomAccessList(l, sync) : new SynchronizedList(l, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.ByteLists$UnmodifiableList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteLists$UnmodifiableList.class */
    public static class UnmodifiableList extends ByteCollections.UnmodifiableCollection implements ByteList, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final ByteList list;

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

        protected UnmodifiableList(ByteList l) {
            super(l);
            this.list = l;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        public byte getByte(int i) {
            return this.list.getByte(i);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        public byte set(int i, byte k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        public void add(int i, byte k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        public byte removeByte(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        public int indexOf(byte k) {
            return this.list.indexOf(k);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        public int lastIndexOf(byte k) {
            return this.list.lastIndexOf(k);
        }

        @Override // java.util.List
        public boolean addAll(int index, Collection<? extends Byte> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList, java.util.List
        @Deprecated
        public void replaceAll(UnaryOperator<Byte> operator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        public void getElements(int from, byte[] a, int offset, int length) {
            this.list.getElements(from, a, offset, length);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        public void removeElements(int from, int to) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        public void addElements(int index, byte[] a, int offset, int length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        public void addElements(int index, byte[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        public void setElements(byte[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        public void setElements(int index, byte[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        public void setElements(int index, byte[] a, int offset, int length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        public void size(int size) {
            this.list.size(size);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteListIterator' to match base method */
        /* JADX WARN: Type inference failed for: r0v2, types: [it.unimi.dsi.fastutil.bytes.ByteListIterator] */
        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList, java.util.List
        public ListIterator<Byte> listIterator() {
            return ByteIterators.unmodifiable((ByteListIterator) this.list.listIterator());
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.bytes.ByteListIterator] */
        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
        public ByteListIterator iterator() {
            return listIterator();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteListIterator' to match base method */
        /* JADX WARN: Type inference failed for: r0v2, types: [it.unimi.dsi.fastutil.bytes.ByteListIterator] */
        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList, java.util.List
        public ListIterator<Byte> listIterator(int i) {
            return ByteIterators.unmodifiable((ByteListIterator) this.list.listIterator(i));
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteList' to match base method */
        /* JADX WARN: Type inference failed for: r2v2, types: [it.unimi.dsi.fastutil.bytes.ByteList] */
        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList, java.util.List
        public List<Byte> subList(int from, int to) {
            return new UnmodifiableList(this.list.subList(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.UnmodifiableCollection, java.util.Collection, java.lang.Object
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            return this.collection.equals(o);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.UnmodifiableCollection, java.util.Collection, java.lang.Object
        public int hashCode() {
            return this.collection.hashCode();
        }

        public int compareTo(List<? extends Byte> o) {
            return this.list.compareTo(o);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        public boolean addAll(int index, ByteCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        public boolean addAll(ByteList l) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        public boolean addAll(int index, ByteList l) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        public void replaceAll(IntUnaryOperator operator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList, java.util.List
        @Deprecated
        public Byte get(int i) {
            return this.list.get(i);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        @Deprecated
        public void add(int i, Byte k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        @Deprecated
        public Byte set(int index, Byte k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList, java.util.List
        @Deprecated
        public Byte remove(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList, java.util.List
        @Deprecated
        public int indexOf(Object o) {
            return this.list.indexOf(o);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList, java.util.List
        @Deprecated
        public int lastIndexOf(Object o) {
            return this.list.lastIndexOf(o);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        public void sort(ByteComparator comparator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        public void unstableSort(ByteComparator comparator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList, java.util.List
        @Deprecated
        public void sort(Comparator<? super Byte> comparator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        @Deprecated
        public void unstableSort(Comparator<? super Byte> comparator) {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.ByteLists$UnmodifiableRandomAccessList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteLists$UnmodifiableRandomAccessList.class */
    public static class UnmodifiableRandomAccessList extends UnmodifiableList implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;

        protected UnmodifiableRandomAccessList(ByteList l) {
            super(l);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteList' to match base method */
        /* JADX WARN: Type inference failed for: r2v2, types: [it.unimi.dsi.fastutil.bytes.ByteList] */
        @Override // p014it.unimi.dsi.fastutil.bytes.ByteLists.UnmodifiableList, p014it.unimi.dsi.fastutil.bytes.ByteList, java.util.List
        public List<Byte> subList(int from, int to) {
            return new UnmodifiableRandomAccessList(this.list.subList(from, to));
        }
    }

    public static ByteList unmodifiable(ByteList l) {
        return l instanceof RandomAccess ? new UnmodifiableRandomAccessList(l) : new UnmodifiableList(l);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: it.unimi.dsi.fastutil.bytes.ByteLists$ImmutableListBase */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteLists$ImmutableListBase.class */
    public static abstract class ImmutableListBase extends AbstractByteList implements ByteList {
        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, p014it.unimi.dsi.fastutil.bytes.ByteList
        @Deprecated
        public final void add(int index, byte k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        @Deprecated
        public final boolean add(byte k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, java.util.AbstractCollection, java.util.Collection
        @Deprecated
        public final boolean addAll(Collection<? extends Byte> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, java.util.List
        @Deprecated
        public final boolean addAll(int index, Collection<? extends Byte> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, p014it.unimi.dsi.fastutil.bytes.ByteList
        @Deprecated
        public final byte removeByte(int index) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        @Deprecated
        public final boolean rem(byte k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, java.util.AbstractCollection, java.util.Collection
        @Deprecated
        public final boolean removeAll(Collection<?> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, java.util.AbstractCollection, java.util.Collection
        @Deprecated
        public final boolean retainAll(Collection<?> c) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        @Deprecated
        public final boolean removeIf(Predicate<? super Byte> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollection
        @Deprecated
        public final boolean removeIf(BytePredicate c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList, java.util.List
        @Deprecated
        public final void replaceAll(UnaryOperator<Byte> operator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        @Deprecated
        public final void replaceAll(IntUnaryOperator operator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        @Deprecated
        public final void add(int index, Byte k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        @Deprecated
        public final boolean add(Byte k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList, java.util.List
        @Deprecated
        public final Byte remove(int index) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, java.util.AbstractCollection, java.util.Collection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        @Deprecated
        public final boolean remove(Object k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        @Deprecated
        public final Byte set(int index, Byte k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        @Deprecated
        public final boolean addAll(ByteCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        @Deprecated
        public final boolean addAll(ByteList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, p014it.unimi.dsi.fastutil.bytes.ByteList
        @Deprecated
        public final boolean addAll(int index, ByteCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        @Deprecated
        public final boolean addAll(int index, ByteList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        @Deprecated
        public final boolean removeAll(ByteCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        @Deprecated
        public final boolean retainAll(ByteCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, p014it.unimi.dsi.fastutil.bytes.ByteList
        @Deprecated
        public final byte set(int index, byte k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, java.util.AbstractCollection, java.util.Collection, java.util.List
        @Deprecated
        public final void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, p014it.unimi.dsi.fastutil.bytes.ByteList
        @Deprecated
        public final void size(int size) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, p014it.unimi.dsi.fastutil.bytes.ByteList
        @Deprecated
        public final void removeElements(int from, int to) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, p014it.unimi.dsi.fastutil.bytes.ByteList
        @Deprecated
        public final void addElements(int index, byte[] a, int offset, int length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, p014it.unimi.dsi.fastutil.bytes.ByteList
        @Deprecated
        public final void setElements(int index, byte[] a, int offset, int length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        @Deprecated
        public final void sort(ByteComparator comp) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        @Deprecated
        public final void unstableSort(ByteComparator comp) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList, java.util.List
        @Deprecated
        public final void sort(Comparator<? super Byte> comparator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        @Deprecated
        public final void unstableSort(Comparator<? super Byte> comparator) {
            throw new UnsupportedOperationException();
        }
    }
}
