package p014it.unimi.dsi.fastutil.doubles;

import java.io.Serializable;
import java.util.Collection;
import java.util.function.DoubleConsumer;
import java.util.function.DoublePredicate;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;
import okhttp3.HttpUrl;
import p014it.unimi.dsi.fastutil.BigArrays;
import p014it.unimi.dsi.fastutil.BigList;
import p014it.unimi.dsi.fastutil.BigListIterator;
import p014it.unimi.dsi.fastutil.doubles.DoubleCollections;

/* renamed from: it.unimi.dsi.fastutil.doubles.DoubleBigLists */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleBigLists.class */
public final class DoubleBigLists {
    public static final EmptyBigList EMPTY_BIG_LIST = new EmptyBigList();

    private DoubleBigLists() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [long] */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [long] */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static p014it.unimi.dsi.fastutil.doubles.DoubleBigList shuffle(p014it.unimi.dsi.fastutil.doubles.DoubleBigList r7, java.util.Random r8) {
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
            double r0 = r0.getDouble(r1)
            r13 = r0
            r0 = r7
            r1 = r9
            r2 = r7
            r3 = r11
            double r2 = r2.getDouble(r3)
            double r0 = r0.set(r1, r2)
            r0 = r7
            r1 = r11
            r2 = r13
            double r0 = r0.set(r1, r2)
            goto L_0x0007
        L_0x0046:
            r0 = r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.doubles.DoubleBigLists.shuffle(it.unimi.dsi.fastutil.doubles.DoubleBigList, java.util.Random):it.unimi.dsi.fastutil.doubles.DoubleBigList");
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.DoubleBigLists$EmptyBigList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleBigLists$EmptyBigList.class */
    public static class EmptyBigList extends DoubleCollections.EmptyCollection implements DoubleBigList, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptyBigList() {
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList
        public double getDouble(long i) {
            throw new IndexOutOfBoundsException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public boolean rem(double k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList
        public double removeDouble(long i) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList
        public void add(long index, double k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList
        public double set(long index, double k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList
        public long indexOf(double k) {
            return -1;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList
        public long lastIndexOf(double k) {
            return -1;
        }

        @Override // p014it.unimi.dsi.fastutil.BigList
        public boolean addAll(long i, Collection<? extends Double> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.EmptyCollection, p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public boolean addAll(DoubleCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList
        public boolean addAll(DoubleBigList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList
        public boolean addAll(long i, DoubleCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList
        public boolean addAll(long i, DoubleBigList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList
        @Deprecated
        public void add(long index, Double k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        @Deprecated
        public boolean add(Double k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public Double get(long i) {
            throw new IndexOutOfBoundsException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList
        @Deprecated
        public Double set(long index, Double k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public Double remove(long k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public long indexOf(Object k) {
            return -1;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public long lastIndexOf(Object k) {
            return -1;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleBigListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Double> listIterator() {
            return DoubleBigListIterators.EMPTY_BIG_LIST_ITERATOR;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.EmptyCollection, p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public DoubleBigListIterator iterator() {
            return DoubleBigListIterators.EMPTY_BIG_LIST_ITERATOR;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleBigListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Double> listIterator(long i) {
            if (i == 0) {
                return DoubleBigListIterators.EMPTY_BIG_LIST_ITERATOR;
            }
            throw new IndexOutOfBoundsException(String.valueOf(i));
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.EmptyCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public DoubleSpliterator spliterator() {
            return DoubleSpliterators.EMPTY_SPLITERATOR;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleBigList' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList, p014it.unimi.dsi.fastutil.BigList
        public BigList<Double> subList(long from, long to) {
            if (from == 0 && to == 0) {
                return this;
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList
        public void getElements(long from, double[][] a, long offset, long length) {
            BigArrays.ensureOffsetLength(a, offset, length);
            if (from != 0) {
                throw new IndexOutOfBoundsException();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList
        public void removeElements(long from, long to) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList
        public void addElements(long index, double[][] a, long offset, long length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList
        public void addElements(long index, double[][] a) {
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

        public int compareTo(BigList<? extends Double> o) {
            return (o != this && !o.isEmpty()) ? -1 : 0;
        }

        @Override // java.lang.Object
        public Object clone() {
            return DoubleBigLists.EMPTY_BIG_LIST;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.EmptyCollection, java.util.Collection, java.lang.Object
        public int hashCode() {
            return 1;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.EmptyCollection, java.util.Collection, java.lang.Object
        public boolean equals(Object o) {
            return (o instanceof BigList) && ((BigList) o).isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, java.util.AbstractCollection, java.lang.Object
        public String toString() {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }

        private Object readResolve() {
            return DoubleBigLists.EMPTY_BIG_LIST;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.DoubleBigLists$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleBigLists$Singleton.class */
    public static class Singleton extends AbstractDoubleBigList implements Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        private final double element;

        protected Singleton(double element) {
            this.element = element;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList
        public double getDouble(long i) {
            if (i == 0) {
                return this.element;
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleBigList, p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public boolean rem(double k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleBigList, p014it.unimi.dsi.fastutil.doubles.DoubleBigList
        public double removeDouble(long i) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleBigList, p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public boolean contains(double k) {
            return Double.doubleToLongBits(k) == Double.doubleToLongBits(this.element);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleBigList, p014it.unimi.dsi.fastutil.doubles.DoubleBigList
        public long indexOf(double k) {
            return Double.doubleToLongBits(k) == Double.doubleToLongBits(this.element) ? 0 : -1;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public double[] toDoubleArray() {
            return new double[]{this.element};
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleBigListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleBigList, p014it.unimi.dsi.fastutil.doubles.DoubleBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Double> listIterator() {
            return DoubleBigListIterators.singleton(this.element);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleBigListIterator' to match base method */
        /* JADX WARN: Type inference failed for: r0v6, types: [it.unimi.dsi.fastutil.BigListIterator<java.lang.Double>, it.unimi.dsi.fastutil.doubles.DoubleBigListIterator] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleBigList, p014it.unimi.dsi.fastutil.doubles.DoubleBigList, p014it.unimi.dsi.fastutil.BigList
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public p014it.unimi.dsi.fastutil.BigListIterator<java.lang.Double> listIterator(long r6) {
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
                it.unimi.dsi.fastutil.doubles.DoubleBigListIterator r0 = r0.listIterator()
                r8 = r0
                r0 = r6
                r1 = 1
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 != 0) goto L_0x0026
                r0 = r8
                double r0 = r0.nextDouble()
            L_0x0026:
                r0 = r8
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.doubles.DoubleBigLists.Singleton.listIterator(long):it.unimi.dsi.fastutil.doubles.DoubleBigListIterator");
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public DoubleSpliterator spliterator() {
            return DoubleSpliterators.singleton(this.element);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleBigList' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleBigList, p014it.unimi.dsi.fastutil.doubles.DoubleBigList, p014it.unimi.dsi.fastutil.BigList
        public BigList<Double> subList(long from, long to) {
            ensureIndex(from);
            ensureIndex(to);
            if (from <= to) {
                return (from == 0 && to == 1) ? this : DoubleBigLists.EMPTY_BIG_LIST;
            }
            throw new IndexOutOfBoundsException("Start index (" + from + ") is greater than end index (" + to + ")");
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleBigList, p014it.unimi.dsi.fastutil.BigList
        public boolean addAll(long i, Collection<? extends Double> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleBigList, p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection<? extends Double> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList
        public boolean addAll(DoubleBigList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList
        public boolean addAll(long i, DoubleBigList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleBigList, p014it.unimi.dsi.fastutil.doubles.DoubleBigList
        public boolean addAll(long i, DoubleCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleBigList, p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public boolean addAll(DoubleCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public boolean removeAll(DoubleCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public boolean retainAll(DoubleCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleBigList, java.util.AbstractCollection, java.util.Collection
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

    public static DoubleBigList singleton(double element) {
        return new Singleton(element);
    }

    public static DoubleBigList singleton(Object element) {
        return new Singleton(((Double) element).doubleValue());
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.DoubleBigLists$SynchronizedBigList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleBigLists$SynchronizedBigList.class */
    public static class SynchronizedBigList extends DoubleCollections.SynchronizedCollection implements DoubleBigList, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final DoubleBigList list;

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.SynchronizedCollection, java.lang.Object
        public /* bridge */ /* synthetic */ String toString() {
            return toString();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ void clear() {
            clear();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public /* bridge */ /* synthetic */ boolean removeIf(DoublePredicate doublePredicate) {
            return removeIf(doublePredicate);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
            return retainAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
            return removeAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean containsAll(Collection collection) {
            return containsAll(collection);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.Collection] */
        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean addAll(Collection<? extends Double> collection) {
            return addAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public /* bridge */ /* synthetic */ void forEach(DoubleConsumer doubleConsumer) {
            forEach(doubleConsumer);
        }

        /* Return type fixed from 'java.util.stream.Stream' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ Stream<Double> parallelStream() {
            return parallelStream();
        }

        /* Return type fixed from 'java.util.stream.Stream' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ Stream<Double> stream() {
            return stream();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public /* bridge */ /* synthetic */ DoubleSpliterator spliterator() {
            return spliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Object[] toArray(Object[] objArr) {
            return toArray(objArr);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public /* bridge */ /* synthetic */ DoubleStream doubleParallelStream() {
            return doubleParallelStream();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public /* bridge */ /* synthetic */ DoubleStream doubleStream() {
            return doubleStream();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public /* bridge */ /* synthetic */ DoubleSpliterator doubleSpliterator() {
            return doubleSpliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public /* bridge */ /* synthetic */ DoubleIterator doubleIterator() {
            return doubleIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean remove(Object obj) {
            return remove(obj);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean contains(Object obj) {
            return contains(obj);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean add(Double d) {
            return add(d);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public /* bridge */ /* synthetic */ boolean retainAll(DoubleCollection doubleCollection) {
            return retainAll(doubleCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public /* bridge */ /* synthetic */ boolean removeAll(DoubleCollection doubleCollection) {
            return removeAll(doubleCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public /* bridge */ /* synthetic */ boolean containsAll(DoubleCollection doubleCollection) {
            return containsAll(doubleCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public /* bridge */ /* synthetic */ boolean addAll(DoubleCollection doubleCollection) {
            return addAll(doubleCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public /* bridge */ /* synthetic */ double[] toArray(double[] dArr) {
            return toArray(dArr);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        @Deprecated
        public /* bridge */ /* synthetic */ double[] toDoubleArray(double[] dArr) {
            return toDoubleArray(dArr);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Object[] toArray() {
            return toArray();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public /* bridge */ /* synthetic */ double[] toDoubleArray() {
            return toDoubleArray();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean isEmpty() {
            return isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.SynchronizedCollection, java.util.Collection, p014it.unimi.dsi.fastutil.BigList, p014it.unimi.dsi.fastutil.Size64
        public /* bridge */ /* synthetic */ int size() {
            return size();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public /* bridge */ /* synthetic */ boolean rem(double d) {
            return rem(d);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public /* bridge */ /* synthetic */ boolean contains(double d) {
            return contains(d);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public /* bridge */ /* synthetic */ boolean add(double d) {
            return add(d);
        }

        protected SynchronizedBigList(DoubleBigList l, Object sync) {
            super(l, sync);
            this.list = l;
        }

        protected SynchronizedBigList(DoubleBigList l) {
            super(l);
            this.list = l;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList
        public double getDouble(long i) {
            double d;
            synchronized (this.sync) {
                d = this.list.getDouble(i);
            }
            return d;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList
        public double set(long i, double k) {
            double d;
            synchronized (this.sync) {
                d = this.list.set(i, k);
            }
            return d;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList
        public void add(long i, double k) {
            synchronized (this.sync) {
                this.list.add(i, k);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList
        public double removeDouble(long i) {
            double removeDouble;
            synchronized (this.sync) {
                removeDouble = this.list.removeDouble(i);
            }
            return removeDouble;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList
        public long indexOf(double k) {
            long indexOf;
            synchronized (this.sync) {
                indexOf = this.list.indexOf(k);
            }
            return indexOf;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList
        public long lastIndexOf(double k) {
            long lastIndexOf;
            synchronized (this.sync) {
                lastIndexOf = this.list.lastIndexOf(k);
            }
            return lastIndexOf;
        }

        @Override // p014it.unimi.dsi.fastutil.BigList
        public boolean addAll(long index, Collection<? extends Double> c) {
            boolean addAll;
            synchronized (this.sync) {
                addAll = this.list.addAll(index, c);
            }
            return addAll;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList
        public void getElements(long from, double[][] a, long offset, long length) {
            synchronized (this.sync) {
                this.list.getElements(from, a, offset, length);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList
        public void removeElements(long from, long to) {
            synchronized (this.sync) {
                this.list.removeElements(from, to);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList
        public void addElements(long index, double[][] a, long offset, long length) {
            synchronized (this.sync) {
                this.list.addElements(index, a, offset, length);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList
        public void addElements(long index, double[][] a) {
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

        /* JADX WARN: Type inference failed for: r0v2, types: [it.unimi.dsi.fastutil.doubles.DoubleBigListIterator] */
        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public DoubleBigListIterator iterator() {
            return this.list.listIterator();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleBigListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Double> listIterator() {
            return this.list.listIterator();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleBigListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Double> listIterator(long i) {
            return this.list.listIterator(i);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleBigList' to match base method */
        /* JADX WARN: Type inference failed for: r0v6, types: [it.unimi.dsi.fastutil.doubles.DoubleBigList] */
        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList, p014it.unimi.dsi.fastutil.BigList
        public BigList<Double> subList(long from, long to) {
            DoubleBigList synchronize;
            synchronized (this.sync) {
                synchronize = DoubleBigLists.synchronize(this.list.subList(from, to), this.sync);
            }
            return synchronize;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.SynchronizedCollection, java.util.Collection, java.lang.Object
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

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.SynchronizedCollection, java.util.Collection, java.lang.Object
        public int hashCode() {
            int hashCode;
            synchronized (this.sync) {
                hashCode = this.list.hashCode();
            }
            return hashCode;
        }

        public int compareTo(BigList<? extends Double> o) {
            int compareTo;
            synchronized (this.sync) {
                compareTo = this.list.compareTo(o);
            }
            return compareTo;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList
        public boolean addAll(long index, DoubleCollection c) {
            boolean addAll;
            synchronized (this.sync) {
                addAll = this.list.addAll(index, c);
            }
            return addAll;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList
        public boolean addAll(long index, DoubleBigList l) {
            boolean addAll;
            synchronized (this.sync) {
                addAll = this.list.addAll(index, l);
            }
            return addAll;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList
        public boolean addAll(DoubleBigList l) {
            boolean addAll;
            synchronized (this.sync) {
                addAll = this.list.addAll(l);
            }
            return addAll;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList
        @Deprecated
        public void add(long i, Double k) {
            synchronized (this.sync) {
                this.list.add(i, k);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public Double get(long i) {
            Double d;
            synchronized (this.sync) {
                d = this.list.get(i);
            }
            return d;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList
        @Deprecated
        public Double set(long index, Double k) {
            Double d;
            synchronized (this.sync) {
                d = this.list.set(index, k);
            }
            return d;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public Double remove(long i) {
            Double remove;
            synchronized (this.sync) {
                remove = this.list.remove(i);
            }
            return remove;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public long indexOf(Object o) {
            long indexOf;
            synchronized (this.sync) {
                indexOf = this.list.indexOf(o);
            }
            return indexOf;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public long lastIndexOf(Object o) {
            long lastIndexOf;
            synchronized (this.sync) {
                lastIndexOf = this.list.lastIndexOf(o);
            }
            return lastIndexOf;
        }
    }

    public static DoubleBigList synchronize(DoubleBigList l) {
        return new SynchronizedBigList(l);
    }

    public static DoubleBigList synchronize(DoubleBigList l, Object sync) {
        return new SynchronizedBigList(l, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.DoubleBigLists$UnmodifiableBigList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleBigLists$UnmodifiableBigList.class */
    public static class UnmodifiableBigList extends DoubleCollections.UnmodifiableCollection implements DoubleBigList, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final DoubleBigList list;

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.UnmodifiableCollection, java.lang.Object
        public /* bridge */ /* synthetic */ String toString() {
            return toString();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public /* bridge */ /* synthetic */ DoubleStream doubleParallelStream() {
            return doubleParallelStream();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public /* bridge */ /* synthetic */ DoubleStream doubleStream() {
            return doubleStream();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public /* bridge */ /* synthetic */ DoubleSpliterator doubleSpliterator() {
            return doubleSpliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public /* bridge */ /* synthetic */ DoubleIterator doubleIterator() {
            return doubleIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public /* bridge */ /* synthetic */ boolean retainAll(DoubleCollection doubleCollection) {
            return retainAll(doubleCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public /* bridge */ /* synthetic */ boolean removeAll(DoubleCollection doubleCollection) {
            return removeAll(doubleCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public /* bridge */ /* synthetic */ boolean addAll(DoubleCollection doubleCollection) {
            return addAll(doubleCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public /* bridge */ /* synthetic */ boolean containsAll(DoubleCollection doubleCollection) {
            return containsAll(doubleCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public /* bridge */ /* synthetic */ double[] toArray(double[] dArr) {
            return toArray(dArr);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        @Deprecated
        public /* bridge */ /* synthetic */ double[] toDoubleArray(double[] dArr) {
            return toDoubleArray(dArr);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public /* bridge */ /* synthetic */ double[] toDoubleArray() {
            return toDoubleArray();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean remove(Object obj) {
            return remove(obj);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean contains(Object obj) {
            return contains(obj);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean add(Double d) {
            return add(d);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public /* bridge */ /* synthetic */ boolean removeIf(DoublePredicate doublePredicate) {
            return removeIf(doublePredicate);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
            return retainAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
            return removeAll(collection);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.Collection] */
        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean addAll(Collection<? extends Double> collection) {
            return addAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean containsAll(Collection collection) {
            return containsAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public /* bridge */ /* synthetic */ void forEach(DoubleConsumer doubleConsumer) {
            forEach(doubleConsumer);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Object[] toArray() {
            return toArray();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Object[] toArray(Object[] objArr) {
            return toArray(objArr);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ void clear() {
            clear();
        }

        /* Return type fixed from 'java.util.stream.Stream' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ Stream<Double> parallelStream() {
            return parallelStream();
        }

        /* Return type fixed from 'java.util.stream.Stream' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ Stream<Double> stream() {
            return stream();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public /* bridge */ /* synthetic */ DoubleSpliterator spliterator() {
            return spliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public /* bridge */ /* synthetic */ boolean contains(double d) {
            return contains(d);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean isEmpty() {
            return isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.UnmodifiableCollection, java.util.Collection, p014it.unimi.dsi.fastutil.BigList, p014it.unimi.dsi.fastutil.Size64
        public /* bridge */ /* synthetic */ int size() {
            return size();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public /* bridge */ /* synthetic */ boolean rem(double d) {
            return rem(d);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public /* bridge */ /* synthetic */ boolean add(double d) {
            return add(d);
        }

        protected UnmodifiableBigList(DoubleBigList l) {
            super(l);
            this.list = l;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList
        public double getDouble(long i) {
            return this.list.getDouble(i);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList
        public double set(long i, double k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList
        public void add(long i, double k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList
        public double removeDouble(long i) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList
        public long indexOf(double k) {
            return this.list.indexOf(k);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList
        public long lastIndexOf(double k) {
            return this.list.lastIndexOf(k);
        }

        @Override // p014it.unimi.dsi.fastutil.BigList
        public boolean addAll(long index, Collection<? extends Double> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList
        public void getElements(long from, double[][] a, long offset, long length) {
            this.list.getElements(from, a, offset, length);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList
        public void removeElements(long from, long to) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList
        public void addElements(long index, double[][] a, long offset, long length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList
        public void addElements(long index, double[][] a) {
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

        /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.doubles.DoubleBigListIterator] */
        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public DoubleBigListIterator iterator() {
            return listIterator();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleBigListIterator' to match base method */
        /* JADX WARN: Type inference failed for: r0v2, types: [it.unimi.dsi.fastutil.doubles.DoubleBigListIterator] */
        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Double> listIterator() {
            return DoubleBigListIterators.unmodifiable(this.list.listIterator());
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleBigListIterator' to match base method */
        /* JADX WARN: Type inference failed for: r0v2, types: [it.unimi.dsi.fastutil.doubles.DoubleBigListIterator] */
        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Double> listIterator(long i) {
            return DoubleBigListIterators.unmodifiable(this.list.listIterator(i));
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleBigList' to match base method */
        /* JADX WARN: Type inference failed for: r0v2, types: [it.unimi.dsi.fastutil.doubles.DoubleBigList] */
        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList, p014it.unimi.dsi.fastutil.BigList
        public BigList<Double> subList(long from, long to) {
            return DoubleBigLists.unmodifiable(this.list.subList(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.UnmodifiableCollection, java.util.Collection, java.lang.Object
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            return this.list.equals(o);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.UnmodifiableCollection, java.util.Collection, java.lang.Object
        public int hashCode() {
            return this.list.hashCode();
        }

        public int compareTo(BigList<? extends Double> o) {
            return this.list.compareTo(o);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList
        public boolean addAll(long index, DoubleCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList
        public boolean addAll(DoubleBigList l) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList
        public boolean addAll(long index, DoubleBigList l) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public Double get(long i) {
            return this.list.get(i);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList
        @Deprecated
        public void add(long i, Double k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList
        @Deprecated
        public Double set(long index, Double k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public Double remove(long i) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public long indexOf(Object o) {
            return this.list.indexOf(o);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public long lastIndexOf(Object o) {
            return this.list.lastIndexOf(o);
        }
    }

    public static DoubleBigList unmodifiable(DoubleBigList l) {
        return new UnmodifiableBigList(l);
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.DoubleBigLists$ListBigList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleBigLists$ListBigList.class */
    public static class ListBigList extends AbstractDoubleBigList implements Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        private final DoubleList list;

        protected ListBigList(DoubleList list) {
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

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleBigList, p014it.unimi.dsi.fastutil.BigList
        public void size(long size) {
            this.list.size(intIndex(size));
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleBigList, p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public DoubleBigListIterator iterator() {
            return DoubleBigListIterators.asBigListIterator(this.list.iterator());
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleBigListIterator' to match base method */
        /* JADX WARN: Type inference failed for: r0v2, types: [it.unimi.dsi.fastutil.doubles.DoubleListIterator] */
        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleBigList, p014it.unimi.dsi.fastutil.doubles.DoubleBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Double> listIterator() {
            return DoubleBigListIterators.asBigListIterator(this.list.listIterator());
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleBigListIterator' to match base method */
        /* JADX WARN: Type inference failed for: r0v2, types: [it.unimi.dsi.fastutil.doubles.DoubleListIterator] */
        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleBigList, p014it.unimi.dsi.fastutil.doubles.DoubleBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Double> listIterator(long index) {
            return DoubleBigListIterators.asBigListIterator(this.list.listIterator(intIndex(index)));
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleBigList, p014it.unimi.dsi.fastutil.BigList
        public boolean addAll(long index, Collection<? extends Double> c) {
            return this.list.addAll(intIndex(index), c);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleBigList' to match base method */
        /* JADX WARN: Type inference failed for: r2v2, types: [it.unimi.dsi.fastutil.doubles.DoubleList] */
        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleBigList, p014it.unimi.dsi.fastutil.doubles.DoubleBigList, p014it.unimi.dsi.fastutil.BigList
        public BigList<Double> subList(long from, long to) {
            return new ListBigList(this.list.subList(intIndex(from), intIndex(to)));
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleBigList, p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public boolean contains(double key) {
            return this.list.contains(key);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public double[] toDoubleArray() {
            return this.list.toDoubleArray();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleBigList, p014it.unimi.dsi.fastutil.doubles.DoubleBigList
        public void removeElements(long from, long to) {
            this.list.removeElements(intIndex(from), intIndex(to));
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        @Deprecated
        public double[] toDoubleArray(double[] a) {
            return this.list.toArray(a);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleBigList, p014it.unimi.dsi.fastutil.doubles.DoubleBigList
        public boolean addAll(long index, DoubleCollection c) {
            return this.list.addAll(intIndex(index), c);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleBigList, p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public boolean addAll(DoubleCollection c) {
            return this.list.addAll(c);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList
        public boolean addAll(long index, DoubleBigList c) {
            return this.list.addAll(intIndex(index), (DoubleCollection) c);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList
        public boolean addAll(DoubleBigList c) {
            return this.list.addAll((DoubleCollection) c);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public boolean containsAll(DoubleCollection c) {
            return this.list.containsAll(c);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public boolean removeAll(DoubleCollection c) {
            return this.list.removeAll(c);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public boolean retainAll(DoubleCollection c) {
            return this.list.retainAll(c);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleBigList, p014it.unimi.dsi.fastutil.doubles.DoubleBigList
        public void add(long index, double key) {
            this.list.add(intIndex(index), key);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleBigList, p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public boolean add(double key) {
            return this.list.add(key);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList
        public double getDouble(long index) {
            return this.list.getDouble(intIndex(index));
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleBigList, p014it.unimi.dsi.fastutil.doubles.DoubleBigList
        public long indexOf(double k) {
            return (long) this.list.indexOf(k);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleBigList, p014it.unimi.dsi.fastutil.doubles.DoubleBigList
        public long lastIndexOf(double k) {
            return (long) this.list.lastIndexOf(k);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleBigList, p014it.unimi.dsi.fastutil.doubles.DoubleBigList
        public double removeDouble(long index) {
            return this.list.removeDouble(intIndex(index));
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleBigList, p014it.unimi.dsi.fastutil.doubles.DoubleBigList
        public double set(long index, double k) {
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

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, java.util.AbstractCollection, java.util.Collection
        public boolean containsAll(Collection<?> c) {
            return this.list.containsAll(c);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleBigList, p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection<? extends Double> c) {
            return this.list.addAll(c);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> c) {
            return this.list.removeAll(c);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> c) {
            return this.list.retainAll(c);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleBigList, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.list.clear();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleBigList, java.util.Collection, java.lang.Object
        public int hashCode() {
            return this.list.hashCode();
        }
    }

    public static DoubleBigList asBigList(DoubleList list) {
        return new ListBigList(list);
    }
}
