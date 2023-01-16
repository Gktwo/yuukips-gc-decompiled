package p014it.unimi.dsi.fastutil.floats;

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
import java.util.function.DoubleUnaryOperator;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;
import okhttp3.HttpUrl;
import p014it.unimi.dsi.fastutil.doubles.DoubleIterator;
import p014it.unimi.dsi.fastutil.doubles.DoubleIterators;
import p014it.unimi.dsi.fastutil.doubles.DoubleSpliterator;
import p014it.unimi.dsi.fastutil.doubles.DoubleSpliterators;
import p014it.unimi.dsi.fastutil.floats.FloatCollections;

/* renamed from: it.unimi.dsi.fastutil.floats.FloatLists */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatLists.class */
public final class FloatLists {
    public static final EmptyList EMPTY_LIST = new EmptyList();

    private FloatLists() {
    }

    public static FloatList shuffle(FloatList l, Random random) {
        int i = l.size();
        while (true) {
            i--;
            if (i == 0) {
                return l;
            }
            int p = random.nextInt(i + 1);
            float t = l.getFloat(i);
            l.set(i, l.getFloat(p));
            l.set(p, t);
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.FloatLists$EmptyList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatLists$EmptyList.class */
    public static class EmptyList extends FloatCollections.EmptyCollection implements FloatList, RandomAccess, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptyList() {
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        public float getFloat(int i) {
            throw new IndexOutOfBoundsException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public boolean rem(float k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        public float removeFloat(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        public void add(int index, float k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        public float set(int index, float k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        public int indexOf(float k) {
            return -1;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        public int lastIndexOf(float k) {
            return -1;
        }

        @Override // java.util.List
        public boolean addAll(int i, Collection<? extends Float> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList, java.util.List
        @Deprecated
        public void replaceAll(UnaryOperator<Float> operator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        public void replaceAll(FloatUnaryOperator operator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        public boolean addAll(FloatList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        public boolean addAll(int i, FloatCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        public boolean addAll(int i, FloatList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        @Deprecated
        public void add(int index, Float k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList, java.util.List
        @Deprecated
        public Float get(int index) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        @Deprecated
        public boolean add(Float k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        @Deprecated
        public Float set(int index, Float k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList, java.util.List
        @Deprecated
        public Float remove(int k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList, java.util.List
        @Deprecated
        public int indexOf(Object k) {
            return -1;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList, java.util.List
        @Deprecated
        public int lastIndexOf(Object k) {
            return -1;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        public void sort(FloatComparator comparator) {
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        public void unstableSort(FloatComparator comparator) {
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList, java.util.List
        @Deprecated
        public void sort(Comparator<? super Float> comparator) {
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        @Deprecated
        public void unstableSort(Comparator<? super Float> comparator) {
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.FloatList, java.util.List
        public ListIterator<Float> listIterator() {
            return FloatIterators.EMPTY_ITERATOR;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.EmptyCollection, p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
        public FloatListIterator iterator() {
            return FloatIterators.EMPTY_ITERATOR;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.FloatList, java.util.List
        public ListIterator<Float> listIterator(int i) {
            if (i == 0) {
                return FloatIterators.EMPTY_ITERATOR;
            }
            throw new IndexOutOfBoundsException(String.valueOf(i));
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatList' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.FloatList, java.util.List
        public List<Float> subList(int from, int to) {
            if (from == 0 && to == 0) {
                return this;
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        public void getElements(int from, float[] a, int offset, int length) {
            if (from != 0 || length != 0 || offset < 0 || offset > a.length) {
                throw new IndexOutOfBoundsException();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        public void removeElements(int from, int to) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        public void addElements(int index, float[] a, int offset, int length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        public void addElements(int index, float[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        public void setElements(float[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        public void setElements(int index, float[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        public void setElements(int index, float[] a, int offset, int length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        public void size(int s) {
            throw new UnsupportedOperationException();
        }

        public int compareTo(List<? extends Float> o) {
            return (o != this && !o.isEmpty()) ? -1 : 0;
        }

        @Override // java.lang.Object
        public Object clone() {
            return FloatLists.EMPTY_LIST;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.EmptyCollection, java.util.Collection, java.lang.Object
        public int hashCode() {
            return 1;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.EmptyCollection, java.util.Collection, java.lang.Object
        public boolean equals(Object o) {
            return (o instanceof List) && ((List) o).isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, java.util.AbstractCollection, java.lang.Object
        public String toString() {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }

        private Object readResolve() {
            return FloatLists.EMPTY_LIST;
        }
    }

    public static FloatList emptyList() {
        return EMPTY_LIST;
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.FloatLists$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatLists$Singleton.class */
    public static class Singleton extends AbstractFloatList implements RandomAccess, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        private final float element;

        protected Singleton(float element) {
            this.element = element;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        public float getFloat(int i) {
            if (i == 0) {
                return this.element;
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public boolean rem(float k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.FloatList
        public float removeFloat(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public boolean contains(float k) {
            return Float.floatToIntBits(k) == Float.floatToIntBits(this.element);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.FloatList
        public int indexOf(float k) {
            return Float.floatToIntBits(k) == Float.floatToIntBits(this.element) ? 0 : -1;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public float[] toFloatArray() {
            return new float[]{this.element};
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.FloatList, java.util.List
        public ListIterator<Float> listIterator() {
            return FloatIterators.singleton(this.element);
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.floats.FloatListIterator] */
        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
        public FloatListIterator iterator() {
            return listIterator();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
        public FloatSpliterator spliterator() {
            return FloatSpliterators.singleton(this.element);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatListIterator' to match base method */
        /* JADX WARN: Type inference failed for: r0v4, types: [java.util.ListIterator<java.lang.Float>, it.unimi.dsi.fastutil.floats.FloatListIterator] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.FloatList, java.util.List
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.util.ListIterator<java.lang.Float> listIterator(int r4) {
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
                it.unimi.dsi.fastutil.floats.FloatListIterator r0 = r0.listIterator()
                r5 = r0
                r0 = r4
                r1 = 1
                if (r0 != r1) goto L_0x0022
                r0 = r5
                float r0 = r0.nextFloat()
            L_0x0022:
                r0 = r5
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.floats.FloatLists.Singleton.listIterator(int):it.unimi.dsi.fastutil.floats.FloatListIterator");
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatList' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.FloatList, java.util.List
        public List<Float> subList(int from, int to) {
            ensureIndex(from);
            ensureIndex(to);
            if (from <= to) {
                return (from == 0 && to == 1) ? this : FloatLists.EMPTY_LIST;
            }
            throw new IndexOutOfBoundsException("Start index (" + from + ") is greater than end index (" + to + ")");
        }

        @Override // java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatIterable
        @Deprecated
        public void forEach(Consumer<? super Float> action) {
            action.accept(Float.valueOf(this.element));
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, java.util.List
        public boolean addAll(int i, Collection<? extends Float> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection<? extends Float> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> c) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        @Deprecated
        public boolean removeIf(Predicate<? super Float> filter) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList, java.util.List
        @Deprecated
        public void replaceAll(UnaryOperator<Float> operator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        public void replaceAll(FloatUnaryOperator operator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.FloatIterable
        public void forEach(FloatConsumer action) {
            action.accept(this.element);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        public boolean addAll(FloatList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        public boolean addAll(int i, FloatList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.FloatList
        public boolean addAll(int i, FloatCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public boolean addAll(FloatCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public boolean removeAll(FloatCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public boolean retainAll(FloatCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollection
        public boolean removeIf(FloatPredicate filter) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
        public DoubleIterator doubleIterator() {
            return DoubleIterators.singleton((double) this.element);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
        public DoubleSpliterator doubleSpliterator() {
            return DoubleSpliterators.singleton((double) this.element);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        @Deprecated
        public Object[] toArray() {
            return new Object[]{Float.valueOf(this.element)};
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        public void sort(FloatComparator comparator) {
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        public void unstableSort(FloatComparator comparator) {
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList, java.util.List
        @Deprecated
        public void sort(Comparator<? super Float> comparator) {
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        @Deprecated
        public void unstableSort(Comparator<? super Float> comparator) {
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.FloatList
        public void getElements(int from, float[] a, int offset, int length) {
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

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.FloatList
        public void removeElements(int from, int to) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.FloatList
        public void addElements(int index, float[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.FloatList
        public void addElements(int index, float[] a, int offset, int length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        public void setElements(float[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        public void setElements(int index, float[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.FloatList
        public void setElements(int index, float[] a, int offset, int length) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return 1;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.FloatList
        public void size(int size) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // java.lang.Object
        public Object clone() {
            return this;
        }
    }

    public static FloatList singleton(float element) {
        return new Singleton(element);
    }

    public static FloatList singleton(Object element) {
        return new Singleton(((Float) element).floatValue());
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.FloatLists$SynchronizedList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatLists$SynchronizedList.class */
    public static class SynchronizedList extends FloatCollections.SynchronizedCollection implements FloatList, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final FloatList list;

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.SynchronizedCollection, java.lang.Object
        public /* bridge */ /* synthetic */ String toString() {
            return toString();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ void clear() {
            clear();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
            return retainAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
            return removeAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean containsAll(Collection collection) {
            return containsAll(collection);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.Collection] */
        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean addAll(Collection<? extends Float> collection) {
            return addAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
        public /* bridge */ /* synthetic */ void forEach(FloatConsumer floatConsumer) {
            forEach(floatConsumer);
        }

        /* Return type fixed from 'java.util.stream.Stream' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ Stream<Float> parallelStream() {
            return parallelStream();
        }

        /* Return type fixed from 'java.util.stream.Stream' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ Stream<Float> stream() {
            return stream();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatIterable
        public /* bridge */ /* synthetic */ FloatSpliterator spliterator() {
            return spliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Object[] toArray(Object[] objArr) {
            return toArray(objArr);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public /* bridge */ /* synthetic */ DoubleStream doubleParallelStream() {
            return doubleParallelStream();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public /* bridge */ /* synthetic */ DoubleStream doubleStream() {
            return doubleStream();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
        public /* bridge */ /* synthetic */ DoubleSpliterator doubleSpliterator() {
            return doubleSpliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
        public /* bridge */ /* synthetic */ DoubleIterator doubleIterator() {
            return doubleIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean remove(Object obj) {
            return remove(obj);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean contains(Object obj) {
            return contains(obj);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean add(Float f) {
            return add(f);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public /* bridge */ /* synthetic */ boolean retainAll(FloatCollection floatCollection) {
            return retainAll(floatCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public /* bridge */ /* synthetic */ boolean removeAll(FloatCollection floatCollection) {
            return removeAll(floatCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public /* bridge */ /* synthetic */ boolean containsAll(FloatCollection floatCollection) {
            return containsAll(floatCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public /* bridge */ /* synthetic */ boolean addAll(FloatCollection floatCollection) {
            return addAll(floatCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public /* bridge */ /* synthetic */ float[] toArray(float[] fArr) {
            return toArray(fArr);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        @Deprecated
        public /* bridge */ /* synthetic */ float[] toFloatArray(float[] fArr) {
            return toFloatArray(fArr);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Object[] toArray() {
            return toArray();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public /* bridge */ /* synthetic */ float[] toFloatArray() {
            return toFloatArray();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean isEmpty() {
            return isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.SynchronizedCollection, java.util.Collection, p014it.unimi.dsi.fastutil.BigList, p014it.unimi.dsi.fastutil.Size64
        public /* bridge */ /* synthetic */ int size() {
            return size();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public /* bridge */ /* synthetic */ boolean rem(float f) {
            return rem(f);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public /* bridge */ /* synthetic */ boolean contains(float f) {
            return contains(f);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public /* bridge */ /* synthetic */ boolean add(float f) {
            return add(f);
        }

        protected SynchronizedList(FloatList l, Object sync) {
            super(l, sync);
            this.list = l;
        }

        protected SynchronizedList(FloatList l) {
            super(l);
            this.list = l;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        public float getFloat(int i) {
            float f;
            synchronized (this.sync) {
                f = this.list.getFloat(i);
            }
            return f;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        public float set(int i, float k) {
            float f;
            synchronized (this.sync) {
                f = this.list.set(i, k);
            }
            return f;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        public void add(int i, float k) {
            synchronized (this.sync) {
                this.list.add(i, k);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        public float removeFloat(int i) {
            float removeFloat;
            synchronized (this.sync) {
                removeFloat = this.list.removeFloat(i);
            }
            return removeFloat;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        public int indexOf(float k) {
            int indexOf;
            synchronized (this.sync) {
                indexOf = this.list.indexOf(k);
            }
            return indexOf;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        public int lastIndexOf(float k) {
            int lastIndexOf;
            synchronized (this.sync) {
                lastIndexOf = this.list.lastIndexOf(k);
            }
            return lastIndexOf;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public boolean removeIf(FloatPredicate filter) {
            boolean removeIf;
            synchronized (this.sync) {
                removeIf = this.list.removeIf(filter);
            }
            return removeIf;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        public void replaceAll(FloatUnaryOperator operator) {
            synchronized (this.sync) {
                this.list.replaceAll(operator);
            }
        }

        @Override // java.util.List
        public boolean addAll(int index, Collection<? extends Float> c) {
            boolean addAll;
            synchronized (this.sync) {
                addAll = this.list.addAll(index, c);
            }
            return addAll;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        public void getElements(int from, float[] a, int offset, int length) {
            synchronized (this.sync) {
                this.list.getElements(from, a, offset, length);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        public void removeElements(int from, int to) {
            synchronized (this.sync) {
                this.list.removeElements(from, to);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        public void addElements(int index, float[] a, int offset, int length) {
            synchronized (this.sync) {
                this.list.addElements(index, a, offset, length);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        public void addElements(int index, float[] a) {
            synchronized (this.sync) {
                this.list.addElements(index, a);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        public void setElements(float[] a) {
            synchronized (this.sync) {
                this.list.setElements(a);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        public void setElements(int index, float[] a) {
            synchronized (this.sync) {
                this.list.setElements(index, a);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        public void setElements(int index, float[] a, int offset, int length) {
            synchronized (this.sync) {
                this.list.setElements(index, a, offset, length);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        public void size(int size) {
            synchronized (this.sync) {
                this.list.size(size);
            }
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.FloatList, java.util.List
        public ListIterator<Float> listIterator() {
            return this.list.listIterator();
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.floats.FloatListIterator] */
        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatIterable
        public FloatListIterator iterator() {
            return listIterator();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.FloatList, java.util.List
        public ListIterator<Float> listIterator(int i) {
            return this.list.listIterator(i);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatList' to match base method */
        /* JADX WARN: Type inference failed for: r2v2, types: [it.unimi.dsi.fastutil.floats.FloatList] */
        @Override // p014it.unimi.dsi.fastutil.floats.FloatList, java.util.List
        public List<Float> subList(int from, int to) {
            SynchronizedList synchronizedList;
            synchronized (this.sync) {
                synchronizedList = new SynchronizedList(this.list.subList(from, to), this.sync);
            }
            return synchronizedList;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.SynchronizedCollection, java.util.Collection, java.lang.Object
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

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.SynchronizedCollection, java.util.Collection, java.lang.Object
        public int hashCode() {
            int hashCode;
            synchronized (this.sync) {
                hashCode = this.collection.hashCode();
            }
            return hashCode;
        }

        public int compareTo(List<? extends Float> o) {
            int compareTo;
            synchronized (this.sync) {
                compareTo = this.list.compareTo(o);
            }
            return compareTo;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        public boolean addAll(int index, FloatCollection c) {
            boolean addAll;
            synchronized (this.sync) {
                addAll = this.list.addAll(index, c);
            }
            return addAll;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        public boolean addAll(int index, FloatList l) {
            boolean addAll;
            synchronized (this.sync) {
                addAll = this.list.addAll(index, l);
            }
            return addAll;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        public boolean addAll(FloatList l) {
            boolean addAll;
            synchronized (this.sync) {
                addAll = this.list.addAll(l);
            }
            return addAll;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList, java.util.List
        @Deprecated
        public Float get(int i) {
            Float f;
            synchronized (this.sync) {
                f = this.list.get(i);
            }
            return f;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        @Deprecated
        public void add(int i, Float k) {
            synchronized (this.sync) {
                this.list.add(i, k);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        @Deprecated
        public Float set(int index, Float k) {
            Float f;
            synchronized (this.sync) {
                f = this.list.set(index, k);
            }
            return f;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList, java.util.List
        @Deprecated
        public Float remove(int i) {
            Float remove;
            synchronized (this.sync) {
                remove = this.list.remove(i);
            }
            return remove;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList, java.util.List
        @Deprecated
        public int indexOf(Object o) {
            int indexOf;
            synchronized (this.sync) {
                indexOf = this.list.indexOf(o);
            }
            return indexOf;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList, java.util.List
        @Deprecated
        public int lastIndexOf(Object o) {
            int lastIndexOf;
            synchronized (this.sync) {
                lastIndexOf = this.list.lastIndexOf(o);
            }
            return lastIndexOf;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        public void sort(FloatComparator comparator) {
            synchronized (this.sync) {
                this.list.sort(comparator);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        public void unstableSort(FloatComparator comparator) {
            synchronized (this.sync) {
                this.list.unstableSort(comparator);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList, java.util.List
        @Deprecated
        public void sort(Comparator<? super Float> comparator) {
            synchronized (this.sync) {
                this.list.sort(comparator);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        @Deprecated
        public void unstableSort(Comparator<? super Float> comparator) {
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

    /* renamed from: it.unimi.dsi.fastutil.floats.FloatLists$SynchronizedRandomAccessList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatLists$SynchronizedRandomAccessList.class */
    public static class SynchronizedRandomAccessList extends SynchronizedList implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;

        protected SynchronizedRandomAccessList(FloatList l, Object sync) {
            super(l, sync);
        }

        protected SynchronizedRandomAccessList(FloatList l) {
            super(l);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatList' to match base method */
        /* JADX WARN: Type inference failed for: r2v2, types: [it.unimi.dsi.fastutil.floats.FloatList] */
        @Override // p014it.unimi.dsi.fastutil.floats.FloatLists.SynchronizedList, p014it.unimi.dsi.fastutil.floats.FloatList, java.util.List
        public List<Float> subList(int from, int to) {
            SynchronizedRandomAccessList synchronizedRandomAccessList;
            synchronized (this.sync) {
                synchronizedRandomAccessList = new SynchronizedRandomAccessList(this.list.subList(from, to), this.sync);
            }
            return synchronizedRandomAccessList;
        }
    }

    public static FloatList synchronize(FloatList l) {
        return l instanceof RandomAccess ? new SynchronizedRandomAccessList(l) : new SynchronizedList(l);
    }

    public static FloatList synchronize(FloatList l, Object sync) {
        return l instanceof RandomAccess ? new SynchronizedRandomAccessList(l, sync) : new SynchronizedList(l, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.FloatLists$UnmodifiableList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatLists$UnmodifiableList.class */
    public static class UnmodifiableList extends FloatCollections.UnmodifiableCollection implements FloatList, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final FloatList list;

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.UnmodifiableCollection, java.lang.Object
        public /* bridge */ /* synthetic */ String toString() {
            return toString();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public /* bridge */ /* synthetic */ DoubleStream doubleParallelStream() {
            return doubleParallelStream();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public /* bridge */ /* synthetic */ DoubleStream doubleStream() {
            return doubleStream();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
        public /* bridge */ /* synthetic */ DoubleSpliterator doubleSpliterator() {
            return doubleSpliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
        public /* bridge */ /* synthetic */ DoubleIterator doubleIterator() {
            return doubleIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public /* bridge */ /* synthetic */ boolean retainAll(FloatCollection floatCollection) {
            return retainAll(floatCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public /* bridge */ /* synthetic */ boolean removeAll(FloatCollection floatCollection) {
            return removeAll(floatCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public /* bridge */ /* synthetic */ boolean addAll(FloatCollection floatCollection) {
            return addAll(floatCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public /* bridge */ /* synthetic */ boolean containsAll(FloatCollection floatCollection) {
            return containsAll(floatCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public /* bridge */ /* synthetic */ float[] toArray(float[] fArr) {
            return toArray(fArr);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        @Deprecated
        public /* bridge */ /* synthetic */ float[] toFloatArray(float[] fArr) {
            return toFloatArray(fArr);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public /* bridge */ /* synthetic */ float[] toFloatArray() {
            return toFloatArray();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean remove(Object obj) {
            return remove(obj);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean contains(Object obj) {
            return contains(obj);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean add(Float f) {
            return add(f);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public /* bridge */ /* synthetic */ boolean removeIf(FloatPredicate floatPredicate) {
            return removeIf(floatPredicate);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
            return retainAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
            return removeAll(collection);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.Collection] */
        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean addAll(Collection<? extends Float> collection) {
            return addAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean containsAll(Collection collection) {
            return containsAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
        public /* bridge */ /* synthetic */ void forEach(FloatConsumer floatConsumer) {
            forEach(floatConsumer);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Object[] toArray() {
            return toArray();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Object[] toArray(Object[] objArr) {
            return toArray(objArr);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ void clear() {
            clear();
        }

        /* Return type fixed from 'java.util.stream.Stream' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ Stream<Float> parallelStream() {
            return parallelStream();
        }

        /* Return type fixed from 'java.util.stream.Stream' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ Stream<Float> stream() {
            return stream();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatIterable
        public /* bridge */ /* synthetic */ FloatSpliterator spliterator() {
            return spliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public /* bridge */ /* synthetic */ boolean contains(float f) {
            return contains(f);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean isEmpty() {
            return isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.UnmodifiableCollection, java.util.Collection, p014it.unimi.dsi.fastutil.BigList, p014it.unimi.dsi.fastutil.Size64
        public /* bridge */ /* synthetic */ int size() {
            return size();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public /* bridge */ /* synthetic */ boolean rem(float f) {
            return rem(f);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public /* bridge */ /* synthetic */ boolean add(float f) {
            return add(f);
        }

        protected UnmodifiableList(FloatList l) {
            super(l);
            this.list = l;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        public float getFloat(int i) {
            return this.list.getFloat(i);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        public float set(int i, float k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        public void add(int i, float k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        public float removeFloat(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        public int indexOf(float k) {
            return this.list.indexOf(k);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        public int lastIndexOf(float k) {
            return this.list.lastIndexOf(k);
        }

        @Override // java.util.List
        public boolean addAll(int index, Collection<? extends Float> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList, java.util.List
        @Deprecated
        public void replaceAll(UnaryOperator<Float> operator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        public void getElements(int from, float[] a, int offset, int length) {
            this.list.getElements(from, a, offset, length);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        public void removeElements(int from, int to) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        public void addElements(int index, float[] a, int offset, int length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        public void addElements(int index, float[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        public void setElements(float[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        public void setElements(int index, float[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        public void setElements(int index, float[] a, int offset, int length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        public void size(int size) {
            this.list.size(size);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatListIterator' to match base method */
        /* JADX WARN: Type inference failed for: r0v2, types: [it.unimi.dsi.fastutil.floats.FloatListIterator] */
        @Override // p014it.unimi.dsi.fastutil.floats.FloatList, java.util.List
        public ListIterator<Float> listIterator() {
            return FloatIterators.unmodifiable((FloatListIterator) this.list.listIterator());
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.floats.FloatListIterator] */
        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatIterable
        public FloatListIterator iterator() {
            return listIterator();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatListIterator' to match base method */
        /* JADX WARN: Type inference failed for: r0v2, types: [it.unimi.dsi.fastutil.floats.FloatListIterator] */
        @Override // p014it.unimi.dsi.fastutil.floats.FloatList, java.util.List
        public ListIterator<Float> listIterator(int i) {
            return FloatIterators.unmodifiable((FloatListIterator) this.list.listIterator(i));
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatList' to match base method */
        /* JADX WARN: Type inference failed for: r2v2, types: [it.unimi.dsi.fastutil.floats.FloatList] */
        @Override // p014it.unimi.dsi.fastutil.floats.FloatList, java.util.List
        public List<Float> subList(int from, int to) {
            return new UnmodifiableList(this.list.subList(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.UnmodifiableCollection, java.util.Collection, java.lang.Object
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            return this.collection.equals(o);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.UnmodifiableCollection, java.util.Collection, java.lang.Object
        public int hashCode() {
            return this.collection.hashCode();
        }

        public int compareTo(List<? extends Float> o) {
            return this.list.compareTo(o);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        public boolean addAll(int index, FloatCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        public boolean addAll(FloatList l) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        public boolean addAll(int index, FloatList l) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        public void replaceAll(DoubleUnaryOperator operator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList, java.util.List
        @Deprecated
        public Float get(int i) {
            return this.list.get(i);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        @Deprecated
        public void add(int i, Float k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        @Deprecated
        public Float set(int index, Float k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList, java.util.List
        @Deprecated
        public Float remove(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList, java.util.List
        @Deprecated
        public int indexOf(Object o) {
            return this.list.indexOf(o);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList, java.util.List
        @Deprecated
        public int lastIndexOf(Object o) {
            return this.list.lastIndexOf(o);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        public void sort(FloatComparator comparator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        public void unstableSort(FloatComparator comparator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList, java.util.List
        @Deprecated
        public void sort(Comparator<? super Float> comparator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        @Deprecated
        public void unstableSort(Comparator<? super Float> comparator) {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.FloatLists$UnmodifiableRandomAccessList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatLists$UnmodifiableRandomAccessList.class */
    public static class UnmodifiableRandomAccessList extends UnmodifiableList implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;

        protected UnmodifiableRandomAccessList(FloatList l) {
            super(l);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatList' to match base method */
        /* JADX WARN: Type inference failed for: r2v2, types: [it.unimi.dsi.fastutil.floats.FloatList] */
        @Override // p014it.unimi.dsi.fastutil.floats.FloatLists.UnmodifiableList, p014it.unimi.dsi.fastutil.floats.FloatList, java.util.List
        public List<Float> subList(int from, int to) {
            return new UnmodifiableRandomAccessList(this.list.subList(from, to));
        }
    }

    public static FloatList unmodifiable(FloatList l) {
        return l instanceof RandomAccess ? new UnmodifiableRandomAccessList(l) : new UnmodifiableList(l);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: it.unimi.dsi.fastutil.floats.FloatLists$ImmutableListBase */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatLists$ImmutableListBase.class */
    public static abstract class ImmutableListBase extends AbstractFloatList implements FloatList {
        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.FloatList
        @Deprecated
        public final void add(int index, float k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        @Deprecated
        public final boolean add(float k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, java.util.AbstractCollection, java.util.Collection
        @Deprecated
        public final boolean addAll(Collection<? extends Float> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, java.util.List
        @Deprecated
        public final boolean addAll(int index, Collection<? extends Float> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.FloatList
        @Deprecated
        public final float removeFloat(int index) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        @Deprecated
        public final boolean rem(float k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, java.util.AbstractCollection, java.util.Collection
        @Deprecated
        public final boolean removeAll(Collection<?> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, java.util.AbstractCollection, java.util.Collection
        @Deprecated
        public final boolean retainAll(Collection<?> c) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        @Deprecated
        public final boolean removeIf(Predicate<? super Float> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollection
        @Deprecated
        public final boolean removeIf(FloatPredicate c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList, java.util.List
        @Deprecated
        public final void replaceAll(UnaryOperator<Float> operator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        @Deprecated
        public final void replaceAll(DoubleUnaryOperator operator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        @Deprecated
        public final void add(int index, Float k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        @Deprecated
        public final boolean add(Float k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList, java.util.List
        @Deprecated
        public final Float remove(int index) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, java.util.AbstractCollection, java.util.Collection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        @Deprecated
        public final boolean remove(Object k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        @Deprecated
        public final Float set(int index, Float k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        @Deprecated
        public final boolean addAll(FloatCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        @Deprecated
        public final boolean addAll(FloatList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.FloatList
        @Deprecated
        public final boolean addAll(int index, FloatCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        @Deprecated
        public final boolean addAll(int index, FloatList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        @Deprecated
        public final boolean removeAll(FloatCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        @Deprecated
        public final boolean retainAll(FloatCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.FloatList
        @Deprecated
        public final float set(int index, float k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, java.util.AbstractCollection, java.util.Collection, java.util.List
        @Deprecated
        public final void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.FloatList
        @Deprecated
        public final void size(int size) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.FloatList
        @Deprecated
        public final void removeElements(int from, int to) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.FloatList
        @Deprecated
        public final void addElements(int index, float[] a, int offset, int length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.FloatList
        @Deprecated
        public final void setElements(int index, float[] a, int offset, int length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        @Deprecated
        public final void sort(FloatComparator comp) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        @Deprecated
        public final void unstableSort(FloatComparator comp) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList, java.util.List
        @Deprecated
        public final void sort(Comparator<? super Float> comparator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        @Deprecated
        public final void unstableSort(Comparator<? super Float> comparator) {
            throw new UnsupportedOperationException();
        }
    }
}
