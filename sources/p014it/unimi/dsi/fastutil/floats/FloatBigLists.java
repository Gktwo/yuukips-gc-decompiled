package p014it.unimi.dsi.fastutil.floats;

import java.io.Serializable;
import java.util.Collection;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;
import okhttp3.HttpUrl;
import p014it.unimi.dsi.fastutil.BigArrays;
import p014it.unimi.dsi.fastutil.BigList;
import p014it.unimi.dsi.fastutil.BigListIterator;
import p014it.unimi.dsi.fastutil.doubles.DoubleIterator;
import p014it.unimi.dsi.fastutil.doubles.DoubleSpliterator;
import p014it.unimi.dsi.fastutil.floats.FloatCollections;

/* renamed from: it.unimi.dsi.fastutil.floats.FloatBigLists */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatBigLists.class */
public final class FloatBigLists {
    public static final EmptyBigList EMPTY_BIG_LIST = new EmptyBigList();

    private FloatBigLists() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [long] */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [long] */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static p014it.unimi.dsi.fastutil.floats.FloatBigList shuffle(p014it.unimi.dsi.fastutil.floats.FloatBigList r7, java.util.Random r8) {
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
            float r0 = r0.getFloat(r1)
            r13 = r0
            r0 = r7
            r1 = r9
            r2 = r7
            r3 = r11
            float r2 = r2.getFloat(r3)
            float r0 = r0.set(r1, r2)
            r0 = r7
            r1 = r11
            r2 = r13
            float r0 = r0.set(r1, r2)
            goto L_0x0007
        L_0x0046:
            r0 = r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.floats.FloatBigLists.shuffle(it.unimi.dsi.fastutil.floats.FloatBigList, java.util.Random):it.unimi.dsi.fastutil.floats.FloatBigList");
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.FloatBigLists$EmptyBigList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatBigLists$EmptyBigList.class */
    public static class EmptyBigList extends FloatCollections.EmptyCollection implements FloatBigList, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptyBigList() {
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBigList
        public float getFloat(long i) {
            throw new IndexOutOfBoundsException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public boolean rem(float k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBigList
        public float removeFloat(long i) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBigList
        public void add(long index, float k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBigList
        public float set(long index, float k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBigList
        public long indexOf(float k) {
            return -1;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBigList
        public long lastIndexOf(float k) {
            return -1;
        }

        @Override // p014it.unimi.dsi.fastutil.BigList
        public boolean addAll(long i, Collection<? extends Float> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.EmptyCollection, p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public boolean addAll(FloatCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBigList
        public boolean addAll(FloatBigList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBigList
        public boolean addAll(long i, FloatCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBigList
        public boolean addAll(long i, FloatBigList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBigList
        @Deprecated
        public void add(long index, Float k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        @Deprecated
        public boolean add(Float k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public Float get(long i) {
            throw new IndexOutOfBoundsException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBigList
        @Deprecated
        public Float set(long index, Float k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public Float remove(long k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public long indexOf(Object k) {
            return -1;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public long lastIndexOf(Object k) {
            return -1;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatBigListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.FloatBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Float> listIterator() {
            return FloatBigListIterators.EMPTY_BIG_LIST_ITERATOR;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.EmptyCollection, p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
        public FloatBigListIterator iterator() {
            return FloatBigListIterators.EMPTY_BIG_LIST_ITERATOR;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatBigListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.FloatBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Float> listIterator(long i) {
            if (i == 0) {
                return FloatBigListIterators.EMPTY_BIG_LIST_ITERATOR;
            }
            throw new IndexOutOfBoundsException(String.valueOf(i));
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.EmptyCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
        public FloatSpliterator spliterator() {
            return FloatSpliterators.EMPTY_SPLITERATOR;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatBigList' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.FloatBigList, p014it.unimi.dsi.fastutil.BigList
        public BigList<Float> subList(long from, long to) {
            if (from == 0 && to == 0) {
                return this;
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBigList
        public void getElements(long from, float[][] a, long offset, long length) {
            BigArrays.ensureOffsetLength(a, offset, length);
            if (from != 0) {
                throw new IndexOutOfBoundsException();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBigList
        public void removeElements(long from, long to) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBigList
        public void addElements(long index, float[][] a, long offset, long length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBigList
        public void addElements(long index, float[][] a) {
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

        public int compareTo(BigList<? extends Float> o) {
            return (o != this && !o.isEmpty()) ? -1 : 0;
        }

        @Override // java.lang.Object
        public Object clone() {
            return FloatBigLists.EMPTY_BIG_LIST;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.EmptyCollection, java.util.Collection, java.lang.Object
        public int hashCode() {
            return 1;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.EmptyCollection, java.util.Collection, java.lang.Object
        public boolean equals(Object o) {
            return (o instanceof BigList) && ((BigList) o).isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, java.util.AbstractCollection, java.lang.Object
        public String toString() {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }

        private Object readResolve() {
            return FloatBigLists.EMPTY_BIG_LIST;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.FloatBigLists$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatBigLists$Singleton.class */
    public static class Singleton extends AbstractFloatBigList implements Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        private final float element;

        protected Singleton(float element) {
            this.element = element;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBigList
        public float getFloat(long i) {
            if (i == 0) {
                return this.element;
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatBigList, p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public boolean rem(float k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatBigList, p014it.unimi.dsi.fastutil.floats.FloatBigList
        public float removeFloat(long i) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatBigList, p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public boolean contains(float k) {
            return Float.floatToIntBits(k) == Float.floatToIntBits(this.element);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatBigList, p014it.unimi.dsi.fastutil.floats.FloatBigList
        public long indexOf(float k) {
            return Float.floatToIntBits(k) == Float.floatToIntBits(this.element) ? 0 : -1;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public float[] toFloatArray() {
            return new float[]{this.element};
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatBigListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatBigList, p014it.unimi.dsi.fastutil.floats.FloatBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Float> listIterator() {
            return FloatBigListIterators.singleton(this.element);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatBigListIterator' to match base method */
        /* JADX WARN: Type inference failed for: r0v6, types: [it.unimi.dsi.fastutil.floats.FloatBigListIterator, it.unimi.dsi.fastutil.BigListIterator<java.lang.Float>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatBigList, p014it.unimi.dsi.fastutil.floats.FloatBigList, p014it.unimi.dsi.fastutil.BigList
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public p014it.unimi.dsi.fastutil.BigListIterator<java.lang.Float> listIterator(long r6) {
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
                it.unimi.dsi.fastutil.floats.FloatBigListIterator r0 = r0.listIterator()
                r8 = r0
                r0 = r6
                r1 = 1
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 != 0) goto L_0x0026
                r0 = r8
                float r0 = r0.nextFloat()
            L_0x0026:
                r0 = r8
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.floats.FloatBigLists.Singleton.listIterator(long):it.unimi.dsi.fastutil.floats.FloatBigListIterator");
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
        public FloatSpliterator spliterator() {
            return FloatSpliterators.singleton(this.element);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatBigList' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatBigList, p014it.unimi.dsi.fastutil.floats.FloatBigList, p014it.unimi.dsi.fastutil.BigList
        public BigList<Float> subList(long from, long to) {
            ensureIndex(from);
            ensureIndex(to);
            if (from <= to) {
                return (from == 0 && to == 1) ? this : FloatBigLists.EMPTY_BIG_LIST;
            }
            throw new IndexOutOfBoundsException("Start index (" + from + ") is greater than end index (" + to + ")");
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatBigList, p014it.unimi.dsi.fastutil.BigList
        public boolean addAll(long i, Collection<? extends Float> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatBigList, p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, java.util.AbstractCollection, java.util.Collection
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

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBigList
        public boolean addAll(FloatBigList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBigList
        public boolean addAll(long i, FloatBigList c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatBigList, p014it.unimi.dsi.fastutil.floats.FloatBigList
        public boolean addAll(long i, FloatCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatBigList, p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
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

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatBigList, java.util.AbstractCollection, java.util.Collection
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

    public static FloatBigList singleton(float element) {
        return new Singleton(element);
    }

    public static FloatBigList singleton(Object element) {
        return new Singleton(((Float) element).floatValue());
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.FloatBigLists$SynchronizedBigList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatBigLists$SynchronizedBigList.class */
    public static class SynchronizedBigList extends FloatCollections.SynchronizedCollection implements FloatBigList, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final FloatBigList list;

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.SynchronizedCollection, java.lang.Object
        public /* bridge */ /* synthetic */ String toString() {
            return toString();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ void clear() {
            clear();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public /* bridge */ /* synthetic */ boolean removeIf(FloatPredicate floatPredicate) {
            return removeIf(floatPredicate);
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

        protected SynchronizedBigList(FloatBigList l, Object sync) {
            super(l, sync);
            this.list = l;
        }

        protected SynchronizedBigList(FloatBigList l) {
            super(l);
            this.list = l;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBigList
        public float getFloat(long i) {
            float f;
            synchronized (this.sync) {
                f = this.list.getFloat(i);
            }
            return f;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBigList
        public float set(long i, float k) {
            float f;
            synchronized (this.sync) {
                f = this.list.set(i, k);
            }
            return f;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBigList
        public void add(long i, float k) {
            synchronized (this.sync) {
                this.list.add(i, k);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBigList
        public float removeFloat(long i) {
            float removeFloat;
            synchronized (this.sync) {
                removeFloat = this.list.removeFloat(i);
            }
            return removeFloat;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBigList
        public long indexOf(float k) {
            long indexOf;
            synchronized (this.sync) {
                indexOf = this.list.indexOf(k);
            }
            return indexOf;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBigList
        public long lastIndexOf(float k) {
            long lastIndexOf;
            synchronized (this.sync) {
                lastIndexOf = this.list.lastIndexOf(k);
            }
            return lastIndexOf;
        }

        @Override // p014it.unimi.dsi.fastutil.BigList
        public boolean addAll(long index, Collection<? extends Float> c) {
            boolean addAll;
            synchronized (this.sync) {
                addAll = this.list.addAll(index, c);
            }
            return addAll;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBigList
        public void getElements(long from, float[][] a, long offset, long length) {
            synchronized (this.sync) {
                this.list.getElements(from, a, offset, length);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBigList
        public void removeElements(long from, long to) {
            synchronized (this.sync) {
                this.list.removeElements(from, to);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBigList
        public void addElements(long index, float[][] a, long offset, long length) {
            synchronized (this.sync) {
                this.list.addElements(index, a, offset, length);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBigList
        public void addElements(long index, float[][] a) {
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

        /* JADX WARN: Type inference failed for: r0v2, types: [it.unimi.dsi.fastutil.floats.FloatBigListIterator] */
        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatIterable
        public FloatBigListIterator iterator() {
            return this.list.listIterator();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatBigListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.FloatBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Float> listIterator() {
            return this.list.listIterator();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatBigListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.FloatBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Float> listIterator(long i) {
            return this.list.listIterator(i);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatBigList' to match base method */
        /* JADX WARN: Type inference failed for: r0v6, types: [it.unimi.dsi.fastutil.floats.FloatBigList] */
        @Override // p014it.unimi.dsi.fastutil.floats.FloatBigList, p014it.unimi.dsi.fastutil.BigList
        public BigList<Float> subList(long from, long to) {
            FloatBigList synchronize;
            synchronized (this.sync) {
                synchronize = FloatBigLists.synchronize(this.list.subList(from, to), this.sync);
            }
            return synchronize;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.SynchronizedCollection, java.util.Collection, java.lang.Object
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

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.SynchronizedCollection, java.util.Collection, java.lang.Object
        public int hashCode() {
            int hashCode;
            synchronized (this.sync) {
                hashCode = this.list.hashCode();
            }
            return hashCode;
        }

        public int compareTo(BigList<? extends Float> o) {
            int compareTo;
            synchronized (this.sync) {
                compareTo = this.list.compareTo(o);
            }
            return compareTo;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBigList
        public boolean addAll(long index, FloatCollection c) {
            boolean addAll;
            synchronized (this.sync) {
                addAll = this.list.addAll(index, c);
            }
            return addAll;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBigList
        public boolean addAll(long index, FloatBigList l) {
            boolean addAll;
            synchronized (this.sync) {
                addAll = this.list.addAll(index, l);
            }
            return addAll;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBigList
        public boolean addAll(FloatBigList l) {
            boolean addAll;
            synchronized (this.sync) {
                addAll = this.list.addAll(l);
            }
            return addAll;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBigList
        @Deprecated
        public void add(long i, Float k) {
            synchronized (this.sync) {
                this.list.add(i, k);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public Float get(long i) {
            Float f;
            synchronized (this.sync) {
                f = this.list.get(i);
            }
            return f;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBigList
        @Deprecated
        public Float set(long index, Float k) {
            Float f;
            synchronized (this.sync) {
                f = this.list.set(index, k);
            }
            return f;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public Float remove(long i) {
            Float remove;
            synchronized (this.sync) {
                remove = this.list.remove(i);
            }
            return remove;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public long indexOf(Object o) {
            long indexOf;
            synchronized (this.sync) {
                indexOf = this.list.indexOf(o);
            }
            return indexOf;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public long lastIndexOf(Object o) {
            long lastIndexOf;
            synchronized (this.sync) {
                lastIndexOf = this.list.lastIndexOf(o);
            }
            return lastIndexOf;
        }
    }

    public static FloatBigList synchronize(FloatBigList l) {
        return new SynchronizedBigList(l);
    }

    public static FloatBigList synchronize(FloatBigList l, Object sync) {
        return new SynchronizedBigList(l, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.FloatBigLists$UnmodifiableBigList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatBigLists$UnmodifiableBigList.class */
    public static class UnmodifiableBigList extends FloatCollections.UnmodifiableCollection implements FloatBigList, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final FloatBigList list;

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

        protected UnmodifiableBigList(FloatBigList l) {
            super(l);
            this.list = l;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBigList
        public float getFloat(long i) {
            return this.list.getFloat(i);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBigList
        public float set(long i, float k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBigList
        public void add(long i, float k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBigList
        public float removeFloat(long i) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBigList
        public long indexOf(float k) {
            return this.list.indexOf(k);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBigList
        public long lastIndexOf(float k) {
            return this.list.lastIndexOf(k);
        }

        @Override // p014it.unimi.dsi.fastutil.BigList
        public boolean addAll(long index, Collection<? extends Float> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBigList
        public void getElements(long from, float[][] a, long offset, long length) {
            this.list.getElements(from, a, offset, length);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBigList
        public void removeElements(long from, long to) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBigList
        public void addElements(long index, float[][] a, long offset, long length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBigList
        public void addElements(long index, float[][] a) {
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

        /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.floats.FloatBigListIterator] */
        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatIterable
        public FloatBigListIterator iterator() {
            return listIterator();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatBigListIterator' to match base method */
        /* JADX WARN: Type inference failed for: r0v2, types: [it.unimi.dsi.fastutil.floats.FloatBigListIterator] */
        @Override // p014it.unimi.dsi.fastutil.floats.FloatBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Float> listIterator() {
            return FloatBigListIterators.unmodifiable(this.list.listIterator());
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatBigListIterator' to match base method */
        /* JADX WARN: Type inference failed for: r0v2, types: [it.unimi.dsi.fastutil.floats.FloatBigListIterator] */
        @Override // p014it.unimi.dsi.fastutil.floats.FloatBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Float> listIterator(long i) {
            return FloatBigListIterators.unmodifiable(this.list.listIterator(i));
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatBigList' to match base method */
        /* JADX WARN: Type inference failed for: r0v2, types: [it.unimi.dsi.fastutil.floats.FloatBigList] */
        @Override // p014it.unimi.dsi.fastutil.floats.FloatBigList, p014it.unimi.dsi.fastutil.BigList
        public BigList<Float> subList(long from, long to) {
            return FloatBigLists.unmodifiable(this.list.subList(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.UnmodifiableCollection, java.util.Collection, java.lang.Object
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            return this.list.equals(o);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.UnmodifiableCollection, java.util.Collection, java.lang.Object
        public int hashCode() {
            return this.list.hashCode();
        }

        public int compareTo(BigList<? extends Float> o) {
            return this.list.compareTo(o);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBigList
        public boolean addAll(long index, FloatCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBigList
        public boolean addAll(FloatBigList l) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBigList
        public boolean addAll(long index, FloatBigList l) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public Float get(long i) {
            return this.list.get(i);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBigList
        @Deprecated
        public void add(long i, Float k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBigList
        @Deprecated
        public Float set(long index, Float k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public Float remove(long i) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public long indexOf(Object o) {
            return this.list.indexOf(o);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBigList, p014it.unimi.dsi.fastutil.BigList
        @Deprecated
        public long lastIndexOf(Object o) {
            return this.list.lastIndexOf(o);
        }
    }

    public static FloatBigList unmodifiable(FloatBigList l) {
        return new UnmodifiableBigList(l);
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.FloatBigLists$ListBigList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatBigLists$ListBigList.class */
    public static class ListBigList extends AbstractFloatBigList implements Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        private final FloatList list;

        protected ListBigList(FloatList list) {
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

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatBigList, p014it.unimi.dsi.fastutil.BigList
        public void size(long size) {
            this.list.size(intIndex(size));
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatBigList, p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
        public FloatBigListIterator iterator() {
            return FloatBigListIterators.asBigListIterator(this.list.iterator());
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatBigListIterator' to match base method */
        /* JADX WARN: Type inference failed for: r0v2, types: [it.unimi.dsi.fastutil.floats.FloatListIterator] */
        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatBigList, p014it.unimi.dsi.fastutil.floats.FloatBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Float> listIterator() {
            return FloatBigListIterators.asBigListIterator(this.list.listIterator());
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatBigListIterator' to match base method */
        /* JADX WARN: Type inference failed for: r0v2, types: [it.unimi.dsi.fastutil.floats.FloatListIterator] */
        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatBigList, p014it.unimi.dsi.fastutil.floats.FloatBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Float> listIterator(long index) {
            return FloatBigListIterators.asBigListIterator(this.list.listIterator(intIndex(index)));
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatBigList, p014it.unimi.dsi.fastutil.BigList
        public boolean addAll(long index, Collection<? extends Float> c) {
            return this.list.addAll(intIndex(index), c);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatBigList' to match base method */
        /* JADX WARN: Type inference failed for: r2v2, types: [it.unimi.dsi.fastutil.floats.FloatList] */
        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatBigList, p014it.unimi.dsi.fastutil.floats.FloatBigList, p014it.unimi.dsi.fastutil.BigList
        public BigList<Float> subList(long from, long to) {
            return new ListBigList(this.list.subList(intIndex(from), intIndex(to)));
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatBigList, p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public boolean contains(float key) {
            return this.list.contains(key);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public float[] toFloatArray() {
            return this.list.toFloatArray();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatBigList, p014it.unimi.dsi.fastutil.floats.FloatBigList
        public void removeElements(long from, long to) {
            this.list.removeElements(intIndex(from), intIndex(to));
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        @Deprecated
        public float[] toFloatArray(float[] a) {
            return this.list.toArray(a);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatBigList, p014it.unimi.dsi.fastutil.floats.FloatBigList
        public boolean addAll(long index, FloatCollection c) {
            return this.list.addAll(intIndex(index), c);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatBigList, p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public boolean addAll(FloatCollection c) {
            return this.list.addAll(c);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBigList
        public boolean addAll(long index, FloatBigList c) {
            return this.list.addAll(intIndex(index), (FloatCollection) c);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBigList
        public boolean addAll(FloatBigList c) {
            return this.list.addAll((FloatCollection) c);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public boolean containsAll(FloatCollection c) {
            return this.list.containsAll(c);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public boolean removeAll(FloatCollection c) {
            return this.list.removeAll(c);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public boolean retainAll(FloatCollection c) {
            return this.list.retainAll(c);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatBigList, p014it.unimi.dsi.fastutil.floats.FloatBigList
        public void add(long index, float key) {
            this.list.add(intIndex(index), key);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatBigList, p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public boolean add(float key) {
            return this.list.add(key);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBigList
        public float getFloat(long index) {
            return this.list.getFloat(intIndex(index));
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatBigList, p014it.unimi.dsi.fastutil.floats.FloatBigList
        public long indexOf(float k) {
            return (long) this.list.indexOf(k);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatBigList, p014it.unimi.dsi.fastutil.floats.FloatBigList
        public long lastIndexOf(float k) {
            return (long) this.list.lastIndexOf(k);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatBigList, p014it.unimi.dsi.fastutil.floats.FloatBigList
        public float removeFloat(long index) {
            return this.list.removeFloat(intIndex(index));
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatBigList, p014it.unimi.dsi.fastutil.floats.FloatBigList
        public float set(long index, float k) {
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

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, java.util.AbstractCollection, java.util.Collection
        public boolean containsAll(Collection<?> c) {
            return this.list.containsAll(c);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatBigList, p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection<? extends Float> c) {
            return this.list.addAll(c);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> c) {
            return this.list.removeAll(c);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> c) {
            return this.list.retainAll(c);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatBigList, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.list.clear();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatBigList, java.util.Collection, java.lang.Object
        public int hashCode() {
            return this.list.hashCode();
        }
    }

    public static FloatBigList asBigList(FloatList list) {
        return new ListBigList(list);
    }
}
