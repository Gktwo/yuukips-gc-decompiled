package p014it.unimi.dsi.fastutil.shorts;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import p014it.unimi.dsi.fastutil.ints.IntIterator;
import p014it.unimi.dsi.fastutil.ints.IntIterators;
import p014it.unimi.dsi.fastutil.ints.IntSpliterator;
import p014it.unimi.dsi.fastutil.ints.IntSpliterators;
import p014it.unimi.dsi.fastutil.objects.ObjectArrays;

/* renamed from: it.unimi.dsi.fastutil.shorts.ShortCollections */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortCollections.class */
public final class ShortCollections {
    private ShortCollections() {
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortCollections$EmptyCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortCollections$EmptyCollection.class */
    public static abstract class EmptyCollection extends AbstractShortCollection {
        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public boolean contains(short k) {
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

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public ShortBidirectionalIterator iterator() {
            return ShortIterators.EMPTY_ITERATOR;
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public ShortSpliterator spliterator() {
            return ShortSpliterators.EMPTY_SPLITERATOR;
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

        @Override // java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        @Deprecated
        public void forEach(Consumer<? super Short> action) {
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, java.util.AbstractCollection, java.util.Collection
        public boolean containsAll(Collection<?> c) {
            return c.isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection<? extends Short> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> c) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        @Deprecated
        public boolean removeIf(Predicate<? super Short> filter) {
            Objects.requireNonNull(filter);
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public short[] toShortArray() {
            return ShortArrays.EMPTY_ARRAY;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        @Deprecated
        public short[] toShortArray(short[] a) {
            return a;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public void forEach(ShortConsumer action) {
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public boolean containsAll(ShortCollection c) {
            return c.isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public boolean addAll(ShortCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public boolean removeAll(ShortCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public boolean retainAll(ShortCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public boolean removeIf(ShortPredicate filter) {
            Objects.requireNonNull(filter);
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public IntIterator intIterator() {
            return IntIterators.EMPTY_ITERATOR;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public IntSpliterator intSpliterator() {
            return IntSpliterators.EMPTY_SPLITERATOR;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortCollections$SynchronizedCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortCollections$SynchronizedCollection.class */
    public static class SynchronizedCollection implements ShortCollection, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final ShortCollection collection;
        protected final Object sync;

        /* access modifiers changed from: protected */
        public SynchronizedCollection(ShortCollection c, Object sync) {
            this.collection = (ShortCollection) Objects.requireNonNull(c);
            this.sync = sync;
        }

        /* access modifiers changed from: protected */
        public SynchronizedCollection(ShortCollection c) {
            this.collection = (ShortCollection) Objects.requireNonNull(c);
            this.sync = this;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public boolean add(short k) {
            boolean add;
            synchronized (this.sync) {
                add = this.collection.add(k);
            }
            return add;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public boolean contains(short k) {
            boolean contains;
            synchronized (this.sync) {
                contains = this.collection.contains(k);
            }
            return contains;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public boolean rem(short k) {
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

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public short[] toShortArray() {
            short[] shortArray;
            synchronized (this.sync) {
                shortArray = this.collection.toShortArray();
            }
            return shortArray;
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            Object[] array;
            synchronized (this.sync) {
                array = this.collection.toArray();
            }
            return array;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollection
        @Deprecated
        public short[] toShortArray(short[] a) {
            return toArray(a);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public short[] toArray(short[] a) {
            short[] array;
            synchronized (this.sync) {
                array = this.collection.toArray(a);
            }
            return array;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public boolean addAll(ShortCollection c) {
            boolean addAll;
            synchronized (this.sync) {
                addAll = this.collection.addAll(c);
            }
            return addAll;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public boolean containsAll(ShortCollection c) {
            boolean containsAll;
            synchronized (this.sync) {
                containsAll = this.collection.containsAll(c);
            }
            return containsAll;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public boolean removeAll(ShortCollection c) {
            boolean removeAll;
            synchronized (this.sync) {
                removeAll = this.collection.removeAll(c);
            }
            return removeAll;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public boolean retainAll(ShortCollection c) {
            boolean retainAll;
            synchronized (this.sync) {
                retainAll = this.collection.retainAll(c);
            }
            return retainAll;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollection
        @Deprecated
        public boolean add(Short k) {
            boolean add;
            synchronized (this.sync) {
                add = this.collection.add(k);
            }
            return add;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollection, java.util.Collection
        @Deprecated
        public boolean contains(Object k) {
            boolean contains;
            synchronized (this.sync) {
                contains = this.collection.contains(k);
            }
            return contains;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollection, java.util.Collection
        @Deprecated
        public boolean remove(Object k) {
            boolean remove;
            synchronized (this.sync) {
                remove = this.collection.remove(k);
            }
            return remove;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public IntIterator intIterator() {
            return this.collection.intIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public IntSpliterator intSpliterator() {
            return this.collection.intSpliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public IntStream intStream() {
            return this.collection.intStream();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollection
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

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public ShortIterator iterator() {
            return this.collection.iterator();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public ShortSpliterator spliterator() {
            return this.collection.spliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollection, java.util.Collection
        @Deprecated
        public Stream<Short> stream() {
            return this.collection.stream();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollection, java.util.Collection
        @Deprecated
        public Stream<Short> parallelStream() {
            return this.collection.parallelStream();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public void forEach(ShortConsumer action) {
            synchronized (this.sync) {
                this.collection.forEach(action);
            }
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends Short> c) {
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

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public boolean removeIf(ShortPredicate filter) {
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

    public static ShortCollection synchronize(ShortCollection c) {
        return new SynchronizedCollection(c);
    }

    public static ShortCollection synchronize(ShortCollection c, Object sync) {
        return new SynchronizedCollection(c, sync);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortCollections$UnmodifiableCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortCollections$UnmodifiableCollection.class */
    public static class UnmodifiableCollection implements ShortCollection, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final ShortCollection collection;

        /* access modifiers changed from: protected */
        public UnmodifiableCollection(ShortCollection c) {
            this.collection = (ShortCollection) Objects.requireNonNull(c);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public boolean add(short k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public boolean rem(short k) {
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

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public boolean contains(short o) {
            return this.collection.contains(o);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public ShortIterator iterator() {
            return ShortIterators.unmodifiable(this.collection.iterator());
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public ShortSpliterator spliterator() {
            return this.collection.spliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollection, java.util.Collection
        @Deprecated
        public Stream<Short> stream() {
            return this.collection.stream();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollection, java.util.Collection
        @Deprecated
        public Stream<Short> parallelStream() {
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

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public void forEach(ShortConsumer action) {
            this.collection.forEach(action);
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection<?> c) {
            return this.collection.containsAll(c);
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends Short> c) {
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

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public boolean removeIf(ShortPredicate filter) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollection
        @Deprecated
        public boolean add(Short k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollection, java.util.Collection
        @Deprecated
        public boolean contains(Object k) {
            return this.collection.contains(k);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollection, java.util.Collection
        @Deprecated
        public boolean remove(Object k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public short[] toShortArray() {
            return this.collection.toShortArray();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollection
        @Deprecated
        public short[] toShortArray(short[] a) {
            return toArray(a);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public short[] toArray(short[] a) {
            return this.collection.toArray(a);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public boolean containsAll(ShortCollection c) {
            return this.collection.containsAll(c);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public boolean addAll(ShortCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public boolean removeAll(ShortCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public boolean retainAll(ShortCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public IntIterator intIterator() {
            return this.collection.intIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public IntSpliterator intSpliterator() {
            return this.collection.intSpliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public IntStream intStream() {
            return this.collection.intStream();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollection
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

    public static ShortCollection unmodifiable(ShortCollection c) {
        return new UnmodifiableCollection(c);
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortCollections$IterableCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortCollections$IterableCollection.class */
    public static class IterableCollection extends AbstractShortCollection implements Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final ShortIterable iterable;

        protected IterableCollection(ShortIterable iterable) {
            this.iterable = (ShortIterable) Objects.requireNonNull(iterable);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            long size = this.iterable.spliterator().getExactSizeIfKnown();
            if (size >= 0) {
                return (int) Math.min(2147483647L, size);
            }
            int c = 0;
            ShortIterator iterator = iterator();
            while (iterator.hasNext()) {
                iterator.nextShort();
                c++;
            }
            return c;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return !this.iterable.iterator().hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public ShortIterator iterator() {
            return this.iterable.iterator();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public ShortSpliterator spliterator() {
            return this.iterable.spliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public IntIterator intIterator() {
            return this.iterable.intIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public IntSpliterator intSpliterator() {
            return this.iterable.intSpliterator();
        }
    }

    public static ShortCollection asCollection(ShortIterable iterable) {
        return iterable instanceof ShortCollection ? (ShortCollection) iterable : new IterableCollection(iterable);
    }
}
