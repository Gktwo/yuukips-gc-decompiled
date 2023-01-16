package p014it.unimi.dsi.fastutil.ints;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import p014it.unimi.dsi.fastutil.objects.ObjectArrays;

/* renamed from: it.unimi.dsi.fastutil.ints.IntCollections */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntCollections.class */
public final class IntCollections {
    private IntCollections() {
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.IntCollections$EmptyCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntCollections$EmptyCollection.class */
    public static abstract class EmptyCollection extends AbstractIntCollection {
        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public boolean contains(int k) {
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

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
        public IntBidirectionalIterator iterator() {
            return IntIterators.EMPTY_ITERATOR;
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
        public IntSpliterator spliterator() {
            return IntSpliterators.EMPTY_SPLITERATOR;
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

        @Override // java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntIterable
        @Deprecated
        public void forEach(Consumer<? super Integer> action) {
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, java.util.AbstractCollection, java.util.Collection
        public boolean containsAll(Collection<?> c) {
            return c.isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, java.util.AbstractCollection, java.util.Collection
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

        @Override // java.util.Collection, p014it.unimi.dsi.fastutil.ints.IntCollection
        @Deprecated
        public boolean removeIf(Predicate<? super Integer> filter) {
            Objects.requireNonNull(filter);
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public int[] toIntArray() {
            return IntArrays.EMPTY_ARRAY;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        @Deprecated
        public int[] toIntArray(int[] a) {
            return a;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntIterable
        public void forEach(IntConsumer action) {
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public boolean containsAll(IntCollection c) {
            return c.isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
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

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollection
        public boolean removeIf(IntPredicate filter) {
            Objects.requireNonNull(filter);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: it.unimi.dsi.fastutil.ints.IntCollections$SynchronizedCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntCollections$SynchronizedCollection.class */
    public static class SynchronizedCollection implements IntCollection, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final IntCollection collection;
        protected final Object sync;

        /* access modifiers changed from: protected */
        public SynchronizedCollection(IntCollection c, Object sync) {
            this.collection = (IntCollection) Objects.requireNonNull(c);
            this.sync = sync;
        }

        /* access modifiers changed from: protected */
        public SynchronizedCollection(IntCollection c) {
            this.collection = (IntCollection) Objects.requireNonNull(c);
            this.sync = this;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollection
        public boolean add(int k) {
            boolean add;
            synchronized (this.sync) {
                add = this.collection.add(k);
            }
            return add;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollection
        public boolean contains(int k) {
            boolean contains;
            synchronized (this.sync) {
                contains = this.collection.contains(k);
            }
            return contains;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollection
        public boolean rem(int k) {
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

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollection
        public int[] toIntArray() {
            int[] intArray;
            synchronized (this.sync) {
                intArray = this.collection.toIntArray();
            }
            return intArray;
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            Object[] array;
            synchronized (this.sync) {
                array = this.collection.toArray();
            }
            return array;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollection
        @Deprecated
        public int[] toIntArray(int[] a) {
            return toArray(a);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollection
        public int[] toArray(int[] a) {
            int[] array;
            synchronized (this.sync) {
                array = this.collection.toArray(a);
            }
            return array;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollection
        public boolean addAll(IntCollection c) {
            boolean addAll;
            synchronized (this.sync) {
                addAll = this.collection.addAll(c);
            }
            return addAll;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollection
        public boolean containsAll(IntCollection c) {
            boolean containsAll;
            synchronized (this.sync) {
                containsAll = this.collection.containsAll(c);
            }
            return containsAll;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollection
        public boolean removeAll(IntCollection c) {
            boolean removeAll;
            synchronized (this.sync) {
                removeAll = this.collection.removeAll(c);
            }
            return removeAll;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollection
        public boolean retainAll(IntCollection c) {
            boolean retainAll;
            synchronized (this.sync) {
                retainAll = this.collection.retainAll(c);
            }
            return retainAll;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollection
        @Deprecated
        public boolean add(Integer k) {
            boolean add;
            synchronized (this.sync) {
                add = this.collection.add(k);
            }
            return add;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollection, java.util.Collection
        @Deprecated
        public boolean contains(Object k) {
            boolean contains;
            synchronized (this.sync) {
                contains = this.collection.contains(k);
            }
            return contains;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollection, java.util.Collection
        @Deprecated
        public boolean remove(Object k) {
            boolean remove;
            synchronized (this.sync) {
                remove = this.collection.remove(k);
            }
            return remove;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
        public IntIterator intIterator() {
            return this.collection.intIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
        public IntSpliterator intSpliterator() {
            return this.collection.intSpliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollection
        public IntStream intStream() {
            return this.collection.intStream();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollection
        public IntStream intParallelStream() {
            return this.collection.intParallelStream();
        }

        @Override // java.util.Collection
        public <T> T[] toArray(T[] a) {
            T[] tArr;
            synchronized (this.sync) {
                tArr = (T[]) this.collection.toArray(a);
            }
            return tArr;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntIterable
        public IntIterator iterator() {
            return this.collection.iterator();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntIterable
        public IntSpliterator spliterator() {
            return this.collection.spliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollection, java.util.Collection
        @Deprecated
        public Stream<Integer> stream() {
            return this.collection.stream();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollection, java.util.Collection
        @Deprecated
        public Stream<Integer> parallelStream() {
            return this.collection.parallelStream();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntIterable
        public void forEach(IntConsumer action) {
            synchronized (this.sync) {
                this.collection.forEach(action);
            }
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends Integer> c) {
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

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollection
        public boolean removeIf(IntPredicate filter) {
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

    public static IntCollection synchronize(IntCollection c) {
        return new SynchronizedCollection(c);
    }

    public static IntCollection synchronize(IntCollection c, Object sync) {
        return new SynchronizedCollection(c, sync);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: it.unimi.dsi.fastutil.ints.IntCollections$UnmodifiableCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntCollections$UnmodifiableCollection.class */
    public static class UnmodifiableCollection implements IntCollection, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final IntCollection collection;

        /* access modifiers changed from: protected */
        public UnmodifiableCollection(IntCollection c) {
            this.collection = (IntCollection) Objects.requireNonNull(c);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollection
        public boolean add(int k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollection
        public boolean rem(int k) {
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

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollection
        public boolean contains(int o) {
            return this.collection.contains(o);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntIterable
        public IntIterator iterator() {
            return IntIterators.unmodifiable(this.collection.iterator());
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntIterable
        public IntSpliterator spliterator() {
            return this.collection.spliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollection, java.util.Collection
        @Deprecated
        public Stream<Integer> stream() {
            return this.collection.stream();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollection, java.util.Collection
        @Deprecated
        public Stream<Integer> parallelStream() {
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

        @Override // p014it.unimi.dsi.fastutil.ints.IntIterable
        public void forEach(IntConsumer action) {
            this.collection.forEach(action);
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection<?> c) {
            return this.collection.containsAll(c);
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends Integer> c) {
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

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollection
        public boolean removeIf(IntPredicate filter) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollection
        @Deprecated
        public boolean add(Integer k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollection, java.util.Collection
        @Deprecated
        public boolean contains(Object k) {
            return this.collection.contains(k);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollection, java.util.Collection
        @Deprecated
        public boolean remove(Object k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollection
        public int[] toIntArray() {
            return this.collection.toIntArray();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollection
        @Deprecated
        public int[] toIntArray(int[] a) {
            return toArray(a);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollection
        public int[] toArray(int[] a) {
            return this.collection.toArray(a);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollection
        public boolean containsAll(IntCollection c) {
            return this.collection.containsAll(c);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollection
        public boolean addAll(IntCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollection
        public boolean removeAll(IntCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollection
        public boolean retainAll(IntCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
        public IntIterator intIterator() {
            return this.collection.intIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
        public IntSpliterator intSpliterator() {
            return this.collection.intSpliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollection
        public IntStream intStream() {
            return this.collection.intStream();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollection
        public IntStream intParallelStream() {
            return this.collection.intParallelStream();
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

    public static IntCollection unmodifiable(IntCollection c) {
        return new UnmodifiableCollection(c);
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.IntCollections$IterableCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntCollections$IterableCollection.class */
    public static class IterableCollection extends AbstractIntCollection implements Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final IntIterable iterable;

        protected IterableCollection(IntIterable iterable) {
            this.iterable = (IntIterable) Objects.requireNonNull(iterable);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            long size = this.iterable.spliterator().getExactSizeIfKnown();
            if (size >= 0) {
                return (int) Math.min(2147483647L, size);
            }
            int c = 0;
            IntIterator iterator = iterator();
            while (iterator.hasNext()) {
                iterator.nextInt();
                c++;
            }
            return c;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return !this.iterable.iterator().hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
        public IntIterator iterator() {
            return this.iterable.iterator();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
        public IntSpliterator spliterator() {
            return this.iterable.spliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
        public IntIterator intIterator() {
            return this.iterable.intIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
        public IntSpliterator intSpliterator() {
            return this.iterable.intSpliterator();
        }
    }

    public static IntCollection asCollection(IntIterable iterable) {
        return iterable instanceof IntCollection ? (IntCollection) iterable : new IterableCollection(iterable);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: it.unimi.dsi.fastutil.ints.IntCollections$SizeDecreasingSupplier */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntCollections$SizeDecreasingSupplier.class */
    public static class SizeDecreasingSupplier<C extends IntCollection> implements Supplier<C> {
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
