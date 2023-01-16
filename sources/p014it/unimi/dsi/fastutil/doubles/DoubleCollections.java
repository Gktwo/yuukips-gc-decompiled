package p014it.unimi.dsi.fastutil.doubles;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.DoublePredicate;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;
import p014it.unimi.dsi.fastutil.objects.ObjectArrays;

/* renamed from: it.unimi.dsi.fastutil.doubles.DoubleCollections */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleCollections.class */
public final class DoubleCollections {
    private DoubleCollections() {
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.DoubleCollections$EmptyCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleCollections$EmptyCollection.class */
    public static abstract class EmptyCollection extends AbstractDoubleCollection {
        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public boolean contains(double k) {
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return ObjectArrays.EMPTY_ARRAY;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <T> T[] toArray(T[] array) {
            if (array.length > 0) {
                array[0] = null;
            }
            return array;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public DoubleBidirectionalIterator iterator() {
            return DoubleIterators.EMPTY_ITERATOR;
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public DoubleSpliterator spliterator() {
            return DoubleSpliterators.EMPTY_SPLITERATOR;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return 0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
        }

        @Override // java.util.Collection, java.lang.Object
        public int hashCode() {
            return 0;
        }

        @Override // java.util.Collection, java.lang.Object
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof Collection)) {
                return false;
            }
            return ((Collection) o).isEmpty();
        }

        @Override // java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        @Deprecated
        public void forEach(Consumer<? super Double> action) {
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, java.util.AbstractCollection, java.util.Collection
        public boolean containsAll(Collection<?> c) {
            return c.isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, java.util.AbstractCollection, java.util.Collection
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
            Objects.requireNonNull(filter);
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public double[] toDoubleArray() {
            return DoubleArrays.EMPTY_ARRAY;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        @Deprecated
        public double[] toDoubleArray(double[] a) {
            return a;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public void forEach(DoubleConsumer action) {
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public boolean containsAll(DoubleCollection c) {
            return c.isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
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
            Objects.requireNonNull(filter);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: it.unimi.dsi.fastutil.doubles.DoubleCollections$SynchronizedCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleCollections$SynchronizedCollection.class */
    public static class SynchronizedCollection implements DoubleCollection, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final DoubleCollection collection;
        protected final Object sync;

        /* access modifiers changed from: protected */
        public SynchronizedCollection(DoubleCollection c, Object sync) {
            this.collection = (DoubleCollection) Objects.requireNonNull(c);
            this.sync = sync;
        }

        /* access modifiers changed from: protected */
        public SynchronizedCollection(DoubleCollection c) {
            this.collection = (DoubleCollection) Objects.requireNonNull(c);
            this.sync = this;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public boolean add(double k) {
            boolean add;
            synchronized (this.sync) {
                add = this.collection.add(k);
            }
            return add;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public boolean contains(double k) {
            boolean contains;
            synchronized (this.sync) {
                contains = this.collection.contains(k);
            }
            return contains;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public boolean rem(double k) {
            boolean rem;
            synchronized (this.sync) {
                rem = this.collection.rem(k);
            }
            return rem;
        }

        @Override // java.util.Collection, p014it.unimi.dsi.fastutil.BigList, p014it.unimi.dsi.fastutil.Size64
        public int size() {
            int size;
            synchronized (this.sync) {
                size = this.collection.size();
            }
            return size;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            boolean isEmpty;
            synchronized (this.sync) {
                isEmpty = this.collection.isEmpty();
            }
            return isEmpty;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public double[] toDoubleArray() {
            double[] doubleArray;
            synchronized (this.sync) {
                doubleArray = this.collection.toDoubleArray();
            }
            return doubleArray;
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            Object[] array;
            synchronized (this.sync) {
                array = this.collection.toArray();
            }
            return array;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        @Deprecated
        public double[] toDoubleArray(double[] a) {
            return toArray(a);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public double[] toArray(double[] a) {
            double[] array;
            synchronized (this.sync) {
                array = this.collection.toArray(a);
            }
            return array;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public boolean addAll(DoubleCollection c) {
            boolean addAll;
            synchronized (this.sync) {
                addAll = this.collection.addAll(c);
            }
            return addAll;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public boolean containsAll(DoubleCollection c) {
            boolean containsAll;
            synchronized (this.sync) {
                containsAll = this.collection.containsAll(c);
            }
            return containsAll;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public boolean removeAll(DoubleCollection c) {
            boolean removeAll;
            synchronized (this.sync) {
                removeAll = this.collection.removeAll(c);
            }
            return removeAll;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public boolean retainAll(DoubleCollection c) {
            boolean retainAll;
            synchronized (this.sync) {
                retainAll = this.collection.retainAll(c);
            }
            return retainAll;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        @Deprecated
        public boolean add(Double k) {
            boolean add;
            synchronized (this.sync) {
                add = this.collection.add(k);
            }
            return add;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollection, java.util.Collection
        @Deprecated
        public boolean contains(Object k) {
            boolean contains;
            synchronized (this.sync) {
                contains = this.collection.contains(k);
            }
            return contains;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollection, java.util.Collection
        @Deprecated
        public boolean remove(Object k) {
            boolean remove;
            synchronized (this.sync) {
                remove = this.collection.remove(k);
            }
            return remove;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public DoubleIterator doubleIterator() {
            return this.collection.doubleIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public DoubleSpliterator doubleSpliterator() {
            return this.collection.doubleSpliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public DoubleStream doubleStream() {
            return this.collection.doubleStream();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public DoubleStream doubleParallelStream() {
            return this.collection.doubleParallelStream();
        }

        @Override // java.util.Collection
        public <T> T[] toArray(T[] a) {
            T[] tArr;
            synchronized (this.sync) {
                tArr = (T[]) this.collection.toArray(a);
            }
            return tArr;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public DoubleIterator iterator() {
            return this.collection.iterator();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public DoubleSpliterator spliterator() {
            return this.collection.spliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollection, java.util.Collection
        @Deprecated
        public Stream<Double> stream() {
            return this.collection.stream();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollection, java.util.Collection
        @Deprecated
        public Stream<Double> parallelStream() {
            return this.collection.parallelStream();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public void forEach(DoubleConsumer action) {
            synchronized (this.sync) {
                this.collection.forEach(action);
            }
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends Double> c) {
            boolean addAll;
            synchronized (this.sync) {
                addAll = this.collection.addAll(c);
            }
            return addAll;
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection<?> c) {
            boolean containsAll;
            synchronized (this.sync) {
                containsAll = this.collection.containsAll(c);
            }
            return containsAll;
        }

        @Override // java.util.Collection
        public boolean removeAll(Collection<?> c) {
            boolean removeAll;
            synchronized (this.sync) {
                removeAll = this.collection.removeAll(c);
            }
            return removeAll;
        }

        @Override // java.util.Collection
        public boolean retainAll(Collection<?> c) {
            boolean retainAll;
            synchronized (this.sync) {
                retainAll = this.collection.retainAll(c);
            }
            return retainAll;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public boolean removeIf(DoublePredicate filter) {
            boolean removeIf;
            synchronized (this.sync) {
                removeIf = this.collection.removeIf(filter);
            }
            return removeIf;
        }

        @Override // java.util.Collection
        public void clear() {
            synchronized (this.sync) {
                this.collection.clear();
            }
        }

        @Override // java.lang.Object
        public String toString() {
            String obj;
            synchronized (this.sync) {
                obj = this.collection.toString();
            }
            return obj;
        }

        @Override // java.util.Collection, java.lang.Object
        public int hashCode() {
            int hashCode;
            synchronized (this.sync) {
                hashCode = this.collection.hashCode();
            }
            return hashCode;
        }

        @Override // java.util.Collection, java.lang.Object
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

        private void writeObject(ObjectOutputStream s) throws IOException {
            synchronized (this.sync) {
                s.defaultWriteObject();
            }
        }
    }

    public static DoubleCollection synchronize(DoubleCollection c) {
        return new SynchronizedCollection(c);
    }

    public static DoubleCollection synchronize(DoubleCollection c, Object sync) {
        return new SynchronizedCollection(c, sync);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: it.unimi.dsi.fastutil.doubles.DoubleCollections$UnmodifiableCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleCollections$UnmodifiableCollection.class */
    public static class UnmodifiableCollection implements DoubleCollection, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final DoubleCollection collection;

        /* access modifiers changed from: protected */
        public UnmodifiableCollection(DoubleCollection c) {
            this.collection = (DoubleCollection) Objects.requireNonNull(c);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public boolean add(double k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public boolean rem(double k) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection, p014it.unimi.dsi.fastutil.BigList, p014it.unimi.dsi.fastutil.Size64
        public int size() {
            return this.collection.size();
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return this.collection.isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public boolean contains(double o) {
            return this.collection.contains(o);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public DoubleIterator iterator() {
            return DoubleIterators.unmodifiable(this.collection.iterator());
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public DoubleSpliterator spliterator() {
            return this.collection.spliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollection, java.util.Collection
        @Deprecated
        public Stream<Double> stream() {
            return this.collection.stream();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollection, java.util.Collection
        @Deprecated
        public Stream<Double> parallelStream() {
            return this.collection.parallelStream();
        }

        @Override // java.util.Collection
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public <T> T[] toArray(T[] a) {
            return (T[]) this.collection.toArray(a);
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            return this.collection.toArray();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public void forEach(DoubleConsumer action) {
            this.collection.forEach(action);
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection<?> c) {
            return this.collection.containsAll(c);
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends Double> c) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public boolean removeAll(Collection<?> c) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public boolean retainAll(Collection<?> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public boolean removeIf(DoublePredicate filter) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        @Deprecated
        public boolean add(Double k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollection, java.util.Collection
        @Deprecated
        public boolean contains(Object k) {
            return this.collection.contains(k);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollection, java.util.Collection
        @Deprecated
        public boolean remove(Object k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public double[] toDoubleArray() {
            return this.collection.toDoubleArray();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        @Deprecated
        public double[] toDoubleArray(double[] a) {
            return toArray(a);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public double[] toArray(double[] a) {
            return this.collection.toArray(a);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public boolean containsAll(DoubleCollection c) {
            return this.collection.containsAll(c);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public boolean addAll(DoubleCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public boolean removeAll(DoubleCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public boolean retainAll(DoubleCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public DoubleIterator doubleIterator() {
            return this.collection.doubleIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public DoubleSpliterator doubleSpliterator() {
            return this.collection.doubleSpliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public DoubleStream doubleStream() {
            return this.collection.doubleStream();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public DoubleStream doubleParallelStream() {
            return this.collection.doubleParallelStream();
        }

        @Override // java.lang.Object
        public String toString() {
            return this.collection.toString();
        }

        @Override // java.util.Collection, java.lang.Object
        public int hashCode() {
            return this.collection.hashCode();
        }

        @Override // java.util.Collection, java.lang.Object
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            return this.collection.equals(o);
        }
    }

    public static DoubleCollection unmodifiable(DoubleCollection c) {
        return new UnmodifiableCollection(c);
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.DoubleCollections$IterableCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleCollections$IterableCollection.class */
    public static class IterableCollection extends AbstractDoubleCollection implements Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final DoubleIterable iterable;

        protected IterableCollection(DoubleIterable iterable) {
            this.iterable = (DoubleIterable) Objects.requireNonNull(iterable);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            long size = this.iterable.spliterator().getExactSizeIfKnown();
            if (size >= 0) {
                return (int) Math.min(2147483647L, size);
            }
            int c = 0;
            DoubleIterator iterator = iterator();
            while (iterator.hasNext()) {
                iterator.nextDouble();
                c++;
            }
            return c;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return !this.iterable.iterator().hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public DoubleIterator iterator() {
            return this.iterable.iterator();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public DoubleSpliterator spliterator() {
            return this.iterable.spliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public DoubleIterator doubleIterator() {
            return this.iterable.doubleIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public DoubleSpliterator doubleSpliterator() {
            return this.iterable.doubleSpliterator();
        }
    }

    public static DoubleCollection asCollection(DoubleIterable iterable) {
        return iterable instanceof DoubleCollection ? (DoubleCollection) iterable : new IterableCollection(iterable);
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.DoubleCollections$SizeDecreasingSupplier */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleCollections$SizeDecreasingSupplier.class */
    static class SizeDecreasingSupplier<C extends DoubleCollection> implements Supplier<C> {
        static final int RECOMMENDED_MIN_SIZE = 8;
        final AtomicInteger suppliedCount = new AtomicInteger(0);
        final int expectedFinalSize;
        final IntFunction<C> builder;

        /* access modifiers changed from: package-private */
        public SizeDecreasingSupplier(int expectedFinalSize, IntFunction<C> builder) {
            this.expectedFinalSize = expectedFinalSize;
            this.builder = builder;
        }

        @Override // java.util.function.Supplier
        public C get() {
            int expectedNeededNextSize = 1 + ((this.expectedFinalSize - 1) / this.suppliedCount.incrementAndGet());
            if (expectedNeededNextSize < 0) {
                expectedNeededNextSize = 8;
            }
            return this.builder.apply(expectedNeededNextSize);
        }
    }
}
