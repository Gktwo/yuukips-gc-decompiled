package p014it.unimi.dsi.fastutil.bytes;

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

/* renamed from: it.unimi.dsi.fastutil.bytes.ByteCollections */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteCollections.class */
public final class ByteCollections {
    private ByteCollections() {
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.ByteCollections$EmptyCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteCollections$EmptyCollection.class */
    public static abstract class EmptyCollection extends AbstractByteCollection {
        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public boolean contains(byte k) {
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

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
        public ByteBidirectionalIterator iterator() {
            return ByteIterators.EMPTY_ITERATOR;
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
        public ByteSpliterator spliterator() {
            return ByteSpliterators.EMPTY_SPLITERATOR;
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

        @Override // java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteIterable
        @Deprecated
        public void forEach(Consumer<? super Byte> action) {
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, java.util.AbstractCollection, java.util.Collection
        public boolean containsAll(Collection<?> c) {
            return c.isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, java.util.AbstractCollection, java.util.Collection
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
            Objects.requireNonNull(filter);
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public byte[] toByteArray() {
            return ByteArrays.EMPTY_ARRAY;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        @Deprecated
        public byte[] toByteArray(byte[] a) {
            return a;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterable
        public void forEach(ByteConsumer action) {
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public boolean containsAll(ByteCollection c) {
            return c.isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
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
            Objects.requireNonNull(filter);
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable
        public IntIterator intIterator() {
            return IntIterators.EMPTY_ITERATOR;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable
        public IntSpliterator intSpliterator() {
            return IntSpliterators.EMPTY_SPLITERATOR;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: it.unimi.dsi.fastutil.bytes.ByteCollections$SynchronizedCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteCollections$SynchronizedCollection.class */
    public static class SynchronizedCollection implements ByteCollection, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final ByteCollection collection;
        protected final Object sync;

        /* access modifiers changed from: protected */
        public SynchronizedCollection(ByteCollection c, Object sync) {
            this.collection = (ByteCollection) Objects.requireNonNull(c);
            this.sync = sync;
        }

        /* access modifiers changed from: protected */
        public SynchronizedCollection(ByteCollection c) {
            this.collection = (ByteCollection) Objects.requireNonNull(c);
            this.sync = this;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public boolean add(byte k) {
            boolean add;
            synchronized (this.sync) {
                add = this.collection.add(k);
            }
            return add;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public boolean contains(byte k) {
            boolean contains;
            synchronized (this.sync) {
                contains = this.collection.contains(k);
            }
            return contains;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public boolean rem(byte k) {
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

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public byte[] toByteArray() {
            byte[] byteArray;
            synchronized (this.sync) {
                byteArray = this.collection.toByteArray();
            }
            return byteArray;
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            Object[] array;
            synchronized (this.sync) {
                array = this.collection.toArray();
            }
            return array;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollection
        @Deprecated
        public byte[] toByteArray(byte[] a) {
            return toArray(a);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public byte[] toArray(byte[] a) {
            byte[] array;
            synchronized (this.sync) {
                array = this.collection.toArray(a);
            }
            return array;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public boolean addAll(ByteCollection c) {
            boolean addAll;
            synchronized (this.sync) {
                addAll = this.collection.addAll(c);
            }
            return addAll;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public boolean containsAll(ByteCollection c) {
            boolean containsAll;
            synchronized (this.sync) {
                containsAll = this.collection.containsAll(c);
            }
            return containsAll;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public boolean removeAll(ByteCollection c) {
            boolean removeAll;
            synchronized (this.sync) {
                removeAll = this.collection.removeAll(c);
            }
            return removeAll;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public boolean retainAll(ByteCollection c) {
            boolean retainAll;
            synchronized (this.sync) {
                retainAll = this.collection.retainAll(c);
            }
            return retainAll;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollection
        @Deprecated
        public boolean add(Byte k) {
            boolean add;
            synchronized (this.sync) {
                add = this.collection.add(k);
            }
            return add;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollection, java.util.Collection
        @Deprecated
        public boolean contains(Object k) {
            boolean contains;
            synchronized (this.sync) {
                contains = this.collection.contains(k);
            }
            return contains;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollection, java.util.Collection
        @Deprecated
        public boolean remove(Object k) {
            boolean remove;
            synchronized (this.sync) {
                remove = this.collection.remove(k);
            }
            return remove;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable
        public IntIterator intIterator() {
            return this.collection.intIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable
        public IntSpliterator intSpliterator() {
            return this.collection.intSpliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public IntStream intStream() {
            return this.collection.intStream();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollection
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

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
        public ByteIterator iterator() {
            return this.collection.iterator();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
        public ByteSpliterator spliterator() {
            return this.collection.spliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollection, java.util.Collection
        @Deprecated
        public Stream<Byte> stream() {
            return this.collection.stream();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollection, java.util.Collection
        @Deprecated
        public Stream<Byte> parallelStream() {
            return this.collection.parallelStream();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterable
        public void forEach(ByteConsumer action) {
            synchronized (this.sync) {
                this.collection.forEach(action);
            }
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends Byte> c) {
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

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public boolean removeIf(BytePredicate filter) {
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

    public static ByteCollection synchronize(ByteCollection c) {
        return new SynchronizedCollection(c);
    }

    public static ByteCollection synchronize(ByteCollection c, Object sync) {
        return new SynchronizedCollection(c, sync);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: it.unimi.dsi.fastutil.bytes.ByteCollections$UnmodifiableCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteCollections$UnmodifiableCollection.class */
    public static class UnmodifiableCollection implements ByteCollection, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final ByteCollection collection;

        /* access modifiers changed from: protected */
        public UnmodifiableCollection(ByteCollection c) {
            this.collection = (ByteCollection) Objects.requireNonNull(c);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public boolean add(byte k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public boolean rem(byte k) {
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

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public boolean contains(byte o) {
            return this.collection.contains(o);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
        public ByteIterator iterator() {
            return ByteIterators.unmodifiable(this.collection.iterator());
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
        public ByteSpliterator spliterator() {
            return this.collection.spliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollection, java.util.Collection
        @Deprecated
        public Stream<Byte> stream() {
            return this.collection.stream();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollection, java.util.Collection
        @Deprecated
        public Stream<Byte> parallelStream() {
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

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterable
        public void forEach(ByteConsumer action) {
            this.collection.forEach(action);
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection<?> c) {
            return this.collection.containsAll(c);
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends Byte> c) {
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

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public boolean removeIf(BytePredicate filter) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollection
        @Deprecated
        public boolean add(Byte k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollection, java.util.Collection
        @Deprecated
        public boolean contains(Object k) {
            return this.collection.contains(k);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollection, java.util.Collection
        @Deprecated
        public boolean remove(Object k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public byte[] toByteArray() {
            return this.collection.toByteArray();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollection
        @Deprecated
        public byte[] toByteArray(byte[] a) {
            return toArray(a);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public byte[] toArray(byte[] a) {
            return this.collection.toArray(a);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public boolean containsAll(ByteCollection c) {
            return this.collection.containsAll(c);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public boolean addAll(ByteCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public boolean removeAll(ByteCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public boolean retainAll(ByteCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable
        public IntIterator intIterator() {
            return this.collection.intIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable
        public IntSpliterator intSpliterator() {
            return this.collection.intSpliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public IntStream intStream() {
            return this.collection.intStream();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollection
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

    public static ByteCollection unmodifiable(ByteCollection c) {
        return new UnmodifiableCollection(c);
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.ByteCollections$IterableCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteCollections$IterableCollection.class */
    public static class IterableCollection extends AbstractByteCollection implements Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final ByteIterable iterable;

        protected IterableCollection(ByteIterable iterable) {
            this.iterable = (ByteIterable) Objects.requireNonNull(iterable);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            long size = this.iterable.spliterator().getExactSizeIfKnown();
            if (size >= 0) {
                return (int) Math.min(2147483647L, size);
            }
            int c = 0;
            ByteIterator iterator = iterator();
            while (iterator.hasNext()) {
                iterator.nextByte();
                c++;
            }
            return c;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return !this.iterable.iterator().hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
        public ByteIterator iterator() {
            return this.iterable.iterator();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
        public ByteSpliterator spliterator() {
            return this.iterable.spliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable
        public IntIterator intIterator() {
            return this.iterable.intIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable
        public IntSpliterator intSpliterator() {
            return this.iterable.intSpliterator();
        }
    }

    public static ByteCollection asCollection(ByteIterable iterable) {
        return iterable instanceof ByteCollection ? (ByteCollection) iterable : new IterableCollection(iterable);
    }
}
