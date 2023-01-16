package p014it.unimi.dsi.fastutil.longs;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.LongConsumer;
import java.util.function.LongPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import p014it.unimi.dsi.fastutil.objects.ObjectArrays;

/* renamed from: it.unimi.dsi.fastutil.longs.LongCollections */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongCollections.class */
public final class LongCollections {
    private LongCollections() {
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.LongCollections$EmptyCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongCollections$EmptyCollection.class */
    public static abstract class EmptyCollection extends AbstractLongCollection {
        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public boolean contains(long k) {
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

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
        public LongBidirectionalIterator iterator() {
            return LongIterators.EMPTY_ITERATOR;
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
        public LongSpliterator spliterator() {
            return LongSpliterators.EMPTY_SPLITERATOR;
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

        @Override // java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongIterable
        @Deprecated
        public void forEach(Consumer<? super Long> action) {
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, java.util.AbstractCollection, java.util.Collection
        public boolean containsAll(Collection<?> c) {
            return c.isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, java.util.AbstractCollection, java.util.Collection
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

        @Override // java.util.Collection, p014it.unimi.dsi.fastutil.longs.LongCollection
        @Deprecated
        public boolean removeIf(Predicate<? super Long> filter) {
            Objects.requireNonNull(filter);
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public long[] toLongArray() {
            return LongArrays.EMPTY_ARRAY;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        @Deprecated
        public long[] toLongArray(long[] a) {
            return a;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongIterable
        public void forEach(LongConsumer action) {
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public boolean containsAll(LongCollection c) {
            return c.isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
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

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollection
        public boolean removeIf(LongPredicate filter) {
            Objects.requireNonNull(filter);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: it.unimi.dsi.fastutil.longs.LongCollections$SynchronizedCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongCollections$SynchronizedCollection.class */
    public static class SynchronizedCollection implements LongCollection, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final LongCollection collection;
        protected final Object sync;

        /* access modifiers changed from: protected */
        public SynchronizedCollection(LongCollection c, Object sync) {
            this.collection = (LongCollection) Objects.requireNonNull(c);
            this.sync = sync;
        }

        /* access modifiers changed from: protected */
        public SynchronizedCollection(LongCollection c) {
            this.collection = (LongCollection) Objects.requireNonNull(c);
            this.sync = this;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollection
        public boolean add(long k) {
            boolean add;
            synchronized (this.sync) {
                add = this.collection.add(k);
            }
            return add;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollection
        public boolean contains(long k) {
            boolean contains;
            synchronized (this.sync) {
                contains = this.collection.contains(k);
            }
            return contains;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollection
        public boolean rem(long k) {
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

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollection
        public long[] toLongArray() {
            long[] longArray;
            synchronized (this.sync) {
                longArray = this.collection.toLongArray();
            }
            return longArray;
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            Object[] array;
            synchronized (this.sync) {
                array = this.collection.toArray();
            }
            return array;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollection
        @Deprecated
        public long[] toLongArray(long[] a) {
            return toArray(a);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollection
        public long[] toArray(long[] a) {
            long[] array;
            synchronized (this.sync) {
                array = this.collection.toArray(a);
            }
            return array;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollection
        public boolean addAll(LongCollection c) {
            boolean addAll;
            synchronized (this.sync) {
                addAll = this.collection.addAll(c);
            }
            return addAll;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollection
        public boolean containsAll(LongCollection c) {
            boolean containsAll;
            synchronized (this.sync) {
                containsAll = this.collection.containsAll(c);
            }
            return containsAll;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollection
        public boolean removeAll(LongCollection c) {
            boolean removeAll;
            synchronized (this.sync) {
                removeAll = this.collection.removeAll(c);
            }
            return removeAll;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollection
        public boolean retainAll(LongCollection c) {
            boolean retainAll;
            synchronized (this.sync) {
                retainAll = this.collection.retainAll(c);
            }
            return retainAll;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollection
        @Deprecated
        public boolean add(Long k) {
            boolean add;
            synchronized (this.sync) {
                add = this.collection.add(k);
            }
            return add;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollection, java.util.Collection
        @Deprecated
        public boolean contains(Object k) {
            boolean contains;
            synchronized (this.sync) {
                contains = this.collection.contains(k);
            }
            return contains;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollection, java.util.Collection
        @Deprecated
        public boolean remove(Object k) {
            boolean remove;
            synchronized (this.sync) {
                remove = this.collection.remove(k);
            }
            return remove;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
        public LongIterator longIterator() {
            return this.collection.longIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
        public LongSpliterator longSpliterator() {
            return this.collection.longSpliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollection
        public LongStream longStream() {
            return this.collection.longStream();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollection
        public LongStream longParallelStream() {
            return this.collection.longParallelStream();
        }

        @Override // java.util.Collection
        public <T> T[] toArray(T[] a) {
            T[] tArr;
            synchronized (this.sync) {
                tArr = (T[]) this.collection.toArray(a);
            }
            return tArr;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongIterable
        public LongIterator iterator() {
            return this.collection.iterator();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongIterable
        public LongSpliterator spliterator() {
            return this.collection.spliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollection, java.util.Collection
        @Deprecated
        public Stream<Long> stream() {
            return this.collection.stream();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollection, java.util.Collection
        @Deprecated
        public Stream<Long> parallelStream() {
            return this.collection.parallelStream();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongIterable
        public void forEach(LongConsumer action) {
            synchronized (this.sync) {
                this.collection.forEach(action);
            }
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends Long> c) {
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

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollection
        public boolean removeIf(LongPredicate filter) {
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

    public static LongCollection synchronize(LongCollection c) {
        return new SynchronizedCollection(c);
    }

    public static LongCollection synchronize(LongCollection c, Object sync) {
        return new SynchronizedCollection(c, sync);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: it.unimi.dsi.fastutil.longs.LongCollections$UnmodifiableCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongCollections$UnmodifiableCollection.class */
    public static class UnmodifiableCollection implements LongCollection, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final LongCollection collection;

        /* access modifiers changed from: protected */
        public UnmodifiableCollection(LongCollection c) {
            this.collection = (LongCollection) Objects.requireNonNull(c);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollection
        public boolean add(long k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollection
        public boolean rem(long k) {
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

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollection
        public boolean contains(long o) {
            return this.collection.contains(o);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongIterable
        public LongIterator iterator() {
            return LongIterators.unmodifiable(this.collection.iterator());
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongIterable
        public LongSpliterator spliterator() {
            return this.collection.spliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollection, java.util.Collection
        @Deprecated
        public Stream<Long> stream() {
            return this.collection.stream();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollection, java.util.Collection
        @Deprecated
        public Stream<Long> parallelStream() {
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

        @Override // p014it.unimi.dsi.fastutil.longs.LongIterable
        public void forEach(LongConsumer action) {
            this.collection.forEach(action);
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection<?> c) {
            return this.collection.containsAll(c);
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends Long> c) {
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

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollection
        public boolean removeIf(LongPredicate filter) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollection
        @Deprecated
        public boolean add(Long k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollection, java.util.Collection
        @Deprecated
        public boolean contains(Object k) {
            return this.collection.contains(k);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollection, java.util.Collection
        @Deprecated
        public boolean remove(Object k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollection
        public long[] toLongArray() {
            return this.collection.toLongArray();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollection
        @Deprecated
        public long[] toLongArray(long[] a) {
            return toArray(a);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollection
        public long[] toArray(long[] a) {
            return this.collection.toArray(a);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollection
        public boolean containsAll(LongCollection c) {
            return this.collection.containsAll(c);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollection
        public boolean addAll(LongCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollection
        public boolean removeAll(LongCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollection
        public boolean retainAll(LongCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
        public LongIterator longIterator() {
            return this.collection.longIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
        public LongSpliterator longSpliterator() {
            return this.collection.longSpliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollection
        public LongStream longStream() {
            return this.collection.longStream();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollection
        public LongStream longParallelStream() {
            return this.collection.longParallelStream();
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

    public static LongCollection unmodifiable(LongCollection c) {
        return new UnmodifiableCollection(c);
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.LongCollections$IterableCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongCollections$IterableCollection.class */
    public static class IterableCollection extends AbstractLongCollection implements Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final LongIterable iterable;

        protected IterableCollection(LongIterable iterable) {
            this.iterable = (LongIterable) Objects.requireNonNull(iterable);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            long size = this.iterable.spliterator().getExactSizeIfKnown();
            if (size >= 0) {
                return (int) Math.min(2147483647L, size);
            }
            int c = 0;
            LongIterator iterator = iterator();
            while (iterator.hasNext()) {
                iterator.nextLong();
                c++;
            }
            return c;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return !this.iterable.iterator().hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
        public LongIterator iterator() {
            return this.iterable.iterator();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
        public LongSpliterator spliterator() {
            return this.iterable.spliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
        public LongIterator longIterator() {
            return this.iterable.longIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
        public LongSpliterator longSpliterator() {
            return this.iterable.longSpliterator();
        }
    }

    public static LongCollection asCollection(LongIterable iterable) {
        return iterable instanceof LongCollection ? (LongCollection) iterable : new IterableCollection(iterable);
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.LongCollections$SizeDecreasingSupplier */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongCollections$SizeDecreasingSupplier.class */
    static class SizeDecreasingSupplier<C extends LongCollection> implements Supplier<C> {
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
