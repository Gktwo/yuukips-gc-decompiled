package p014it.unimi.dsi.fastutil.doubles;

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
import java.util.function.DoubleConsumer;
import java.util.function.DoublePredicate;
import java.util.function.DoubleUnaryOperator;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;
import okhttp3.HttpUrl;
import p014it.unimi.dsi.fastutil.doubles.DoubleCollections;

/* renamed from: it.unimi.dsi.fastutil.doubles.DoubleLists */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleLists.class */
public final class DoubleLists {
    public static final EmptyList EMPTY_LIST = new EmptyList();

    private DoubleLists() {
    }

    public static DoubleList shuffle(DoubleList l, Random random) {
        int i = l.size();
        while (true) {
            i--;
            if (i == 0) {
                return l;
            }
            int p = random.nextInt(i + 1);
            double t = l.getDouble(i);
            l.set(i, l.getDouble(p));
            l.set(p, t);
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.DoubleLists$EmptyList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleLists$EmptyList.class */
    public static class EmptyList extends DoubleCollections.EmptyCollection implements DoubleList, RandomAccess, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptyList() {
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        public double getDouble(int i) {
            throw new IndexOutOfBoundsException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public boolean rem(double k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        public double removeDouble(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        public void add(int index, double k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        public double set(int index, double k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        public int indexOf(double k) {
            return -1;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        public int lastIndexOf(double k) {
            return -1;
        }

        @Override // java.util.List
        public boolean addAll(int i, Collection<? extends Double> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList, java.util.List
        @Deprecated
        public void replaceAll(UnaryOperator<Double> operator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        public void replaceAll(DoubleUnaryOperator operator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        public boolean addAll(DoubleList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        public boolean addAll(int i, DoubleCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        public boolean addAll(int i, DoubleList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        @Deprecated
        public void add(int index, Double k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList, java.util.List
        @Deprecated
        public Double get(int index) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        @Deprecated
        public boolean add(Double k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        @Deprecated
        public Double set(int index, Double k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList, java.util.List
        @Deprecated
        public Double remove(int k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList, java.util.List
        @Deprecated
        public int indexOf(Object k) {
            return -1;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList, java.util.List
        @Deprecated
        public int lastIndexOf(Object k) {
            return -1;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        public void sort(DoubleComparator comparator) {
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        public void unstableSort(DoubleComparator comparator) {
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList, java.util.List
        @Deprecated
        public void sort(Comparator<? super Double> comparator) {
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        @Deprecated
        public void unstableSort(Comparator<? super Double> comparator) {
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList, java.util.List
        public ListIterator<Double> listIterator() {
            return DoubleIterators.EMPTY_ITERATOR;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.EmptyCollection, p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public DoubleListIterator iterator() {
            return DoubleIterators.EMPTY_ITERATOR;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList, java.util.List
        public ListIterator<Double> listIterator(int i) {
            if (i == 0) {
                return DoubleIterators.EMPTY_ITERATOR;
            }
            throw new IndexOutOfBoundsException(String.valueOf(i));
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleList' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList, java.util.List
        public List<Double> subList(int from, int to) {
            if (from == 0 && to == 0) {
                return this;
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        public void getElements(int from, double[] a, int offset, int length) {
            if (from != 0 || length != 0 || offset < 0 || offset > a.length) {
                throw new IndexOutOfBoundsException();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        public void removeElements(int from, int to) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        public void addElements(int index, double[] a, int offset, int length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        public void addElements(int index, double[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        public void setElements(double[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        public void setElements(int index, double[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        public void setElements(int index, double[] a, int offset, int length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        public void size(int s) {
            throw new UnsupportedOperationException();
        }

        public int compareTo(List<? extends Double> o) {
            return (o != this && !o.isEmpty()) ? -1 : 0;
        }

        @Override // java.lang.Object
        public Object clone() {
            return DoubleLists.EMPTY_LIST;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.EmptyCollection, java.util.Collection, java.lang.Object
        public int hashCode() {
            return 1;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.EmptyCollection, java.util.Collection, java.lang.Object
        public boolean equals(Object o) {
            return (o instanceof List) && ((List) o).isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, java.util.AbstractCollection, java.lang.Object
        public String toString() {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }

        private Object readResolve() {
            return DoubleLists.EMPTY_LIST;
        }
    }

    public static DoubleList emptyList() {
        return EMPTY_LIST;
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.DoubleLists$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleLists$Singleton.class */
    public static class Singleton extends AbstractDoubleList implements RandomAccess, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        private final double element;

        protected Singleton(double element) {
            this.element = element;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        public double getDouble(int i) {
            if (i == 0) {
                return this.element;
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public boolean rem(double k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.DoubleList
        public double removeDouble(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public boolean contains(double k) {
            return Double.doubleToLongBits(k) == Double.doubleToLongBits(this.element);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.DoubleList
        public int indexOf(double k) {
            return Double.doubleToLongBits(k) == Double.doubleToLongBits(this.element) ? 0 : -1;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public double[] toDoubleArray() {
            return new double[]{this.element};
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.DoubleList, java.util.List
        public ListIterator<Double> listIterator() {
            return DoubleIterators.singleton(this.element);
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.doubles.DoubleListIterator] */
        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public DoubleListIterator iterator() {
            return listIterator();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public DoubleSpliterator spliterator() {
            return DoubleSpliterators.singleton(this.element);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleListIterator' to match base method */
        /* JADX WARN: Type inference failed for: r0v4, types: [it.unimi.dsi.fastutil.doubles.DoubleListIterator, java.util.ListIterator<java.lang.Double>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.DoubleList, java.util.List
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.util.ListIterator<java.lang.Double> listIterator(int r4) {
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
                it.unimi.dsi.fastutil.doubles.DoubleListIterator r0 = r0.listIterator()
                r5 = r0
                r0 = r4
                r1 = 1
                if (r0 != r1) goto L_0x0022
                r0 = r5
                double r0 = r0.nextDouble()
            L_0x0022:
                r0 = r5
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.doubles.DoubleLists.Singleton.listIterator(int):it.unimi.dsi.fastutil.doubles.DoubleListIterator");
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleList' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.DoubleList, java.util.List
        public List<Double> subList(int from, int to) {
            ensureIndex(from);
            ensureIndex(to);
            if (from <= to) {
                return (from == 0 && to == 1) ? this : DoubleLists.EMPTY_LIST;
            }
            throw new IndexOutOfBoundsException("Start index (" + from + ") is greater than end index (" + to + ")");
        }

        @Override // java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        @Deprecated
        public void forEach(Consumer<? super Double> action) {
            action.accept(Double.valueOf(this.element));
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, java.util.List
        public boolean addAll(int i, Collection<? extends Double> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, java.util.AbstractCollection, java.util.Collection
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

        @Override // java.util.Collection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        @Deprecated
        public boolean removeIf(Predicate<? super Double> filter) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList, java.util.List
        @Deprecated
        public void replaceAll(UnaryOperator<Double> operator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        public void replaceAll(DoubleUnaryOperator operator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public void forEach(DoubleConsumer action) {
            action.accept(this.element);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        public boolean addAll(DoubleList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        public boolean addAll(int i, DoubleList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.DoubleList
        public boolean addAll(int i, DoubleCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
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

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public boolean removeIf(DoublePredicate filter) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        @Deprecated
        public Object[] toArray() {
            return new Object[]{Double.valueOf(this.element)};
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        public void sort(DoubleComparator comparator) {
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        public void unstableSort(DoubleComparator comparator) {
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList, java.util.List
        @Deprecated
        public void sort(Comparator<? super Double> comparator) {
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        @Deprecated
        public void unstableSort(Comparator<? super Double> comparator) {
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.DoubleList
        public void getElements(int from, double[] a, int offset, int length) {
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

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.DoubleList
        public void removeElements(int from, int to) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.DoubleList
        public void addElements(int index, double[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.DoubleList
        public void addElements(int index, double[] a, int offset, int length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        public void setElements(double[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        public void setElements(int index, double[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.DoubleList
        public void setElements(int index, double[] a, int offset, int length) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return 1;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.DoubleList
        public void size(int size) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // java.lang.Object
        public Object clone() {
            return this;
        }
    }

    public static DoubleList singleton(double element) {
        return new Singleton(element);
    }

    public static DoubleList singleton(Object element) {
        return new Singleton(((Double) element).doubleValue());
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.DoubleLists$SynchronizedList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleLists$SynchronizedList.class */
    public static class SynchronizedList extends DoubleCollections.SynchronizedCollection implements DoubleList, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final DoubleList list;

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.SynchronizedCollection, java.lang.Object
        public /* bridge */ /* synthetic */ String toString() {
            return toString();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ void clear() {
            clear();
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

        protected SynchronizedList(DoubleList l, Object sync) {
            super(l, sync);
            this.list = l;
        }

        protected SynchronizedList(DoubleList l) {
            super(l);
            this.list = l;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        public double getDouble(int i) {
            double d;
            synchronized (this.sync) {
                d = this.list.getDouble(i);
            }
            return d;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        public double set(int i, double k) {
            double d;
            synchronized (this.sync) {
                d = this.list.set(i, k);
            }
            return d;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        public void add(int i, double k) {
            synchronized (this.sync) {
                this.list.add(i, k);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        public double removeDouble(int i) {
            double removeDouble;
            synchronized (this.sync) {
                removeDouble = this.list.removeDouble(i);
            }
            return removeDouble;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        public int indexOf(double k) {
            int indexOf;
            synchronized (this.sync) {
                indexOf = this.list.indexOf(k);
            }
            return indexOf;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        public int lastIndexOf(double k) {
            int lastIndexOf;
            synchronized (this.sync) {
                lastIndexOf = this.list.lastIndexOf(k);
            }
            return lastIndexOf;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public boolean removeIf(DoublePredicate filter) {
            boolean removeIf;
            synchronized (this.sync) {
                removeIf = this.list.removeIf(filter);
            }
            return removeIf;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        public void replaceAll(DoubleUnaryOperator operator) {
            synchronized (this.sync) {
                this.list.replaceAll(operator);
            }
        }

        @Override // java.util.List
        public boolean addAll(int index, Collection<? extends Double> c) {
            boolean addAll;
            synchronized (this.sync) {
                addAll = this.list.addAll(index, c);
            }
            return addAll;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        public void getElements(int from, double[] a, int offset, int length) {
            synchronized (this.sync) {
                this.list.getElements(from, a, offset, length);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        public void removeElements(int from, int to) {
            synchronized (this.sync) {
                this.list.removeElements(from, to);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        public void addElements(int index, double[] a, int offset, int length) {
            synchronized (this.sync) {
                this.list.addElements(index, a, offset, length);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        public void addElements(int index, double[] a) {
            synchronized (this.sync) {
                this.list.addElements(index, a);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        public void setElements(double[] a) {
            synchronized (this.sync) {
                this.list.setElements(a);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        public void setElements(int index, double[] a) {
            synchronized (this.sync) {
                this.list.setElements(index, a);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        public void setElements(int index, double[] a, int offset, int length) {
            synchronized (this.sync) {
                this.list.setElements(index, a, offset, length);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        public void size(int size) {
            synchronized (this.sync) {
                this.list.size(size);
            }
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList, java.util.List
        public ListIterator<Double> listIterator() {
            return this.list.listIterator();
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.doubles.DoubleListIterator] */
        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public DoubleListIterator iterator() {
            return listIterator();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList, java.util.List
        public ListIterator<Double> listIterator(int i) {
            return this.list.listIterator(i);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleList' to match base method */
        /* JADX WARN: Type inference failed for: r2v2, types: [it.unimi.dsi.fastutil.doubles.DoubleList] */
        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList, java.util.List
        public List<Double> subList(int from, int to) {
            SynchronizedList synchronizedList;
            synchronized (this.sync) {
                synchronizedList = new SynchronizedList(this.list.subList(from, to), this.sync);
            }
            return synchronizedList;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.SynchronizedCollection, java.util.Collection, java.lang.Object
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

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.SynchronizedCollection, java.util.Collection, java.lang.Object
        public int hashCode() {
            int hashCode;
            synchronized (this.sync) {
                hashCode = this.collection.hashCode();
            }
            return hashCode;
        }

        public int compareTo(List<? extends Double> o) {
            int compareTo;
            synchronized (this.sync) {
                compareTo = this.list.compareTo(o);
            }
            return compareTo;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        public boolean addAll(int index, DoubleCollection c) {
            boolean addAll;
            synchronized (this.sync) {
                addAll = this.list.addAll(index, c);
            }
            return addAll;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        public boolean addAll(int index, DoubleList l) {
            boolean addAll;
            synchronized (this.sync) {
                addAll = this.list.addAll(index, l);
            }
            return addAll;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        public boolean addAll(DoubleList l) {
            boolean addAll;
            synchronized (this.sync) {
                addAll = this.list.addAll(l);
            }
            return addAll;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList, java.util.List
        @Deprecated
        public Double get(int i) {
            Double d;
            synchronized (this.sync) {
                d = this.list.get(i);
            }
            return d;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        @Deprecated
        public void add(int i, Double k) {
            synchronized (this.sync) {
                this.list.add(i, k);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        @Deprecated
        public Double set(int index, Double k) {
            Double d;
            synchronized (this.sync) {
                d = this.list.set(index, k);
            }
            return d;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList, java.util.List
        @Deprecated
        public Double remove(int i) {
            Double remove;
            synchronized (this.sync) {
                remove = this.list.remove(i);
            }
            return remove;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList, java.util.List
        @Deprecated
        public int indexOf(Object o) {
            int indexOf;
            synchronized (this.sync) {
                indexOf = this.list.indexOf(o);
            }
            return indexOf;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList, java.util.List
        @Deprecated
        public int lastIndexOf(Object o) {
            int lastIndexOf;
            synchronized (this.sync) {
                lastIndexOf = this.list.lastIndexOf(o);
            }
            return lastIndexOf;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        public void sort(DoubleComparator comparator) {
            synchronized (this.sync) {
                this.list.sort(comparator);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        public void unstableSort(DoubleComparator comparator) {
            synchronized (this.sync) {
                this.list.unstableSort(comparator);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList, java.util.List
        @Deprecated
        public void sort(Comparator<? super Double> comparator) {
            synchronized (this.sync) {
                this.list.sort(comparator);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        @Deprecated
        public void unstableSort(Comparator<? super Double> comparator) {
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

    /* renamed from: it.unimi.dsi.fastutil.doubles.DoubleLists$SynchronizedRandomAccessList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleLists$SynchronizedRandomAccessList.class */
    public static class SynchronizedRandomAccessList extends SynchronizedList implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;

        protected SynchronizedRandomAccessList(DoubleList l, Object sync) {
            super(l, sync);
        }

        protected SynchronizedRandomAccessList(DoubleList l) {
            super(l);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleList' to match base method */
        /* JADX WARN: Type inference failed for: r2v2, types: [it.unimi.dsi.fastutil.doubles.DoubleList] */
        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleLists.SynchronizedList, p014it.unimi.dsi.fastutil.doubles.DoubleList, java.util.List
        public List<Double> subList(int from, int to) {
            SynchronizedRandomAccessList synchronizedRandomAccessList;
            synchronized (this.sync) {
                synchronizedRandomAccessList = new SynchronizedRandomAccessList(this.list.subList(from, to), this.sync);
            }
            return synchronizedRandomAccessList;
        }
    }

    public static DoubleList synchronize(DoubleList l) {
        return l instanceof RandomAccess ? new SynchronizedRandomAccessList(l) : new SynchronizedList(l);
    }

    public static DoubleList synchronize(DoubleList l, Object sync) {
        return l instanceof RandomAccess ? new SynchronizedRandomAccessList(l, sync) : new SynchronizedList(l, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.DoubleLists$UnmodifiableList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleLists$UnmodifiableList.class */
    public static class UnmodifiableList extends DoubleCollections.UnmodifiableCollection implements DoubleList, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final DoubleList list;

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

        protected UnmodifiableList(DoubleList l) {
            super(l);
            this.list = l;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        public double getDouble(int i) {
            return this.list.getDouble(i);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        public double set(int i, double k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        public void add(int i, double k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        public double removeDouble(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        public int indexOf(double k) {
            return this.list.indexOf(k);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        public int lastIndexOf(double k) {
            return this.list.lastIndexOf(k);
        }

        @Override // java.util.List
        public boolean addAll(int index, Collection<? extends Double> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList, java.util.List
        @Deprecated
        public void replaceAll(UnaryOperator<Double> operator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        public void getElements(int from, double[] a, int offset, int length) {
            this.list.getElements(from, a, offset, length);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        public void removeElements(int from, int to) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        public void addElements(int index, double[] a, int offset, int length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        public void addElements(int index, double[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        public void setElements(double[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        public void setElements(int index, double[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        public void setElements(int index, double[] a, int offset, int length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        public void size(int size) {
            this.list.size(size);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleListIterator' to match base method */
        /* JADX WARN: Type inference failed for: r0v2, types: [it.unimi.dsi.fastutil.doubles.DoubleListIterator] */
        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList, java.util.List
        public ListIterator<Double> listIterator() {
            return DoubleIterators.unmodifiable((DoubleListIterator) this.list.listIterator());
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.doubles.DoubleListIterator] */
        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public DoubleListIterator iterator() {
            return listIterator();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleListIterator' to match base method */
        /* JADX WARN: Type inference failed for: r0v2, types: [it.unimi.dsi.fastutil.doubles.DoubleListIterator] */
        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList, java.util.List
        public ListIterator<Double> listIterator(int i) {
            return DoubleIterators.unmodifiable((DoubleListIterator) this.list.listIterator(i));
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleList' to match base method */
        /* JADX WARN: Type inference failed for: r2v2, types: [it.unimi.dsi.fastutil.doubles.DoubleList] */
        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList, java.util.List
        public List<Double> subList(int from, int to) {
            return new UnmodifiableList(this.list.subList(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.UnmodifiableCollection, java.util.Collection, java.lang.Object
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            return this.collection.equals(o);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.UnmodifiableCollection, java.util.Collection, java.lang.Object
        public int hashCode() {
            return this.collection.hashCode();
        }

        public int compareTo(List<? extends Double> o) {
            return this.list.compareTo(o);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        public boolean addAll(int index, DoubleCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        public boolean addAll(DoubleList l) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        public boolean addAll(int index, DoubleList l) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        public void replaceAll(DoubleUnaryOperator operator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList, java.util.List
        @Deprecated
        public Double get(int i) {
            return this.list.get(i);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        @Deprecated
        public void add(int i, Double k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        @Deprecated
        public Double set(int index, Double k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList, java.util.List
        @Deprecated
        public Double remove(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList, java.util.List
        @Deprecated
        public int indexOf(Object o) {
            return this.list.indexOf(o);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList, java.util.List
        @Deprecated
        public int lastIndexOf(Object o) {
            return this.list.lastIndexOf(o);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        public void sort(DoubleComparator comparator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        public void unstableSort(DoubleComparator comparator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList, java.util.List
        @Deprecated
        public void sort(Comparator<? super Double> comparator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        @Deprecated
        public void unstableSort(Comparator<? super Double> comparator) {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.DoubleLists$UnmodifiableRandomAccessList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleLists$UnmodifiableRandomAccessList.class */
    public static class UnmodifiableRandomAccessList extends UnmodifiableList implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;

        protected UnmodifiableRandomAccessList(DoubleList l) {
            super(l);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleList' to match base method */
        /* JADX WARN: Type inference failed for: r2v2, types: [it.unimi.dsi.fastutil.doubles.DoubleList] */
        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleLists.UnmodifiableList, p014it.unimi.dsi.fastutil.doubles.DoubleList, java.util.List
        public List<Double> subList(int from, int to) {
            return new UnmodifiableRandomAccessList(this.list.subList(from, to));
        }
    }

    public static DoubleList unmodifiable(DoubleList l) {
        return l instanceof RandomAccess ? new UnmodifiableRandomAccessList(l) : new UnmodifiableList(l);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: it.unimi.dsi.fastutil.doubles.DoubleLists$ImmutableListBase */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleLists$ImmutableListBase.class */
    public static abstract class ImmutableListBase extends AbstractDoubleList implements DoubleList {
        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.DoubleList
        @Deprecated
        public final void add(int index, double k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        @Deprecated
        public final boolean add(double k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, java.util.AbstractCollection, java.util.Collection
        @Deprecated
        public final boolean addAll(Collection<? extends Double> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, java.util.List
        @Deprecated
        public final boolean addAll(int index, Collection<? extends Double> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.DoubleList
        @Deprecated
        public final double removeDouble(int index) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        @Deprecated
        public final boolean rem(double k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, java.util.AbstractCollection, java.util.Collection
        @Deprecated
        public final boolean removeAll(Collection<?> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, java.util.AbstractCollection, java.util.Collection
        @Deprecated
        public final boolean retainAll(Collection<?> c) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        @Deprecated
        public final boolean removeIf(Predicate<? super Double> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        @Deprecated
        public final boolean removeIf(DoublePredicate c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList, java.util.List
        @Deprecated
        public final void replaceAll(UnaryOperator<Double> operator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        @Deprecated
        public final void replaceAll(DoubleUnaryOperator operator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        @Deprecated
        public final void add(int index, Double k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        @Deprecated
        public final boolean add(Double k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList, java.util.List
        @Deprecated
        public final Double remove(int index) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, java.util.AbstractCollection, java.util.Collection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        @Deprecated
        public final boolean remove(Object k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        @Deprecated
        public final Double set(int index, Double k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        @Deprecated
        public final boolean addAll(DoubleCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        @Deprecated
        public final boolean addAll(DoubleList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.DoubleList
        @Deprecated
        public final boolean addAll(int index, DoubleCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        @Deprecated
        public final boolean addAll(int index, DoubleList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        @Deprecated
        public final boolean removeAll(DoubleCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        @Deprecated
        public final boolean retainAll(DoubleCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.DoubleList
        @Deprecated
        public final double set(int index, double k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, java.util.AbstractCollection, java.util.Collection, java.util.List
        @Deprecated
        public final void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.DoubleList
        @Deprecated
        public final void size(int size) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.DoubleList
        @Deprecated
        public final void removeElements(int from, int to) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.DoubleList
        @Deprecated
        public final void addElements(int index, double[] a, int offset, int length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.DoubleList
        @Deprecated
        public final void setElements(int index, double[] a, int offset, int length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        @Deprecated
        public final void sort(DoubleComparator comp) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        @Deprecated
        public final void unstableSort(DoubleComparator comp) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList, java.util.List
        @Deprecated
        public final void sort(Comparator<? super Double> comparator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        @Deprecated
        public final void unstableSort(Comparator<? super Double> comparator) {
            throw new UnsupportedOperationException();
        }
    }
}
