package p014it.unimi.dsi.fastutil.bytes;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import p014it.unimi.dsi.fastutil.bytes.ByteCollections;
import p014it.unimi.dsi.fastutil.ints.IntIterator;
import p014it.unimi.dsi.fastutil.ints.IntIterators;
import p014it.unimi.dsi.fastutil.ints.IntSpliterator;
import p014it.unimi.dsi.fastutil.ints.IntSpliterators;

/* renamed from: it.unimi.dsi.fastutil.bytes.ByteSets */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteSets.class */
public final class ByteSets {
    static final int ARRAY_SET_CUTOFF = 4;
    public static final EmptySet EMPTY_SET = new EmptySet();
    static final ByteSet UNMODIFIABLE_EMPTY_SET = unmodifiable(new ByteArraySet(ByteArrays.EMPTY_ARRAY));

    private ByteSets() {
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.ByteSets$EmptySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteSets$EmptySet.class */
    public static class EmptySet extends ByteCollections.EmptyCollection implements ByteSet, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSet
        public boolean remove(byte ok) {
            throw new UnsupportedOperationException();
        }

        @Override // java.lang.Object
        public Object clone() {
            return ByteSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.EmptyCollection, java.util.Collection, java.lang.Object
        public boolean equals(Object o) {
            return (o instanceof Set) && ((Set) o).isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        @Deprecated
        public boolean rem(byte k) {
            return rem(k);
        }

        private Object readResolve() {
            return ByteSets.EMPTY_SET;
        }
    }

    public static ByteSet emptySet() {
        return EMPTY_SET;
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.ByteSets$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteSets$Singleton.class */
    public static class Singleton extends AbstractByteSet implements Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final byte element;

        /* access modifiers changed from: protected */
        public Singleton(byte element) {
            this.element = element;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public boolean contains(byte k) {
            return k == this.element;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteSet, p014it.unimi.dsi.fastutil.bytes.ByteSet
        public boolean remove(byte k) {
            throw new UnsupportedOperationException();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteSet, p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
        public Iterator<Byte> iterator() {
            return ByteIterators.singleton(this.element);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteSpliterator' to match base method */
        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
        public Spliterator<Byte> spliterator() {
            return ByteSpliterators.singleton(this.element);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return 1;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public byte[] toByteArray() {
            return new byte[]{this.element};
        }

        @Override // java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteIterable
        @Deprecated
        public void forEach(Consumer<? super Byte> action) {
            action.accept(Byte.valueOf(this.element));
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
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterable
        public void forEach(ByteConsumer action) {
            action.accept(this.element);
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

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @Deprecated
        public Object[] toArray() {
            return new Object[]{Byte.valueOf(this.element)};
        }

        @Override // java.lang.Object
        public Object clone() {
            return this;
        }
    }

    public static ByteSet singleton(byte element) {
        return new Singleton(element);
    }

    public static ByteSet singleton(Byte element) {
        return new Singleton(element.byteValue());
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.ByteSets$SynchronizedSet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteSets$SynchronizedSet.class */
    public static class SynchronizedSet extends ByteCollections.SynchronizedCollection implements ByteSet, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.SynchronizedCollection, java.util.Collection, java.lang.Object
        public /* bridge */ /* synthetic */ boolean equals(Object obj) {
            return equals(obj);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.SynchronizedCollection, java.util.Collection, java.lang.Object
        public /* bridge */ /* synthetic */ int hashCode() {
            return hashCode();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.SynchronizedCollection, java.lang.Object
        public /* bridge */ /* synthetic */ String toString() {
            return toString();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ void clear() {
            clear();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public /* bridge */ /* synthetic */ boolean removeIf(BytePredicate bytePredicate) {
            return removeIf(bytePredicate);
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

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean addAll(Collection collection) {
            return addAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable
        public /* bridge */ /* synthetic */ void forEach(ByteConsumer byteConsumer) {
            forEach(byteConsumer);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ Stream parallelStream() {
            return parallelStream();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ Stream stream() {
            return stream();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteSpliterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
        public /* bridge */ /* synthetic */ Spliterator<Byte> spliterator() {
            return spliterator();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
        public /* bridge */ /* synthetic */ Iterator<Byte> iterator() {
            return iterator();
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
        public /* bridge */ /* synthetic */ boolean contains(byte b) {
            return contains(b);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public /* bridge */ /* synthetic */ boolean add(byte b) {
            return add(b);
        }

        /* access modifiers changed from: protected */
        public SynchronizedSet(ByteSet s, Object sync) {
            super(s, sync);
        }

        /* access modifiers changed from: protected */
        public SynchronizedSet(ByteSet s) {
            super(s);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSet
        public boolean remove(byte k) {
            boolean rem;
            synchronized (this.sync) {
                rem = this.collection.rem(k);
            }
            return rem;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        @Deprecated
        public boolean rem(byte k) {
            return rem(k);
        }
    }

    public static ByteSet synchronize(ByteSet s) {
        return new SynchronizedSet(s);
    }

    public static ByteSet synchronize(ByteSet s, Object sync) {
        return new SynchronizedSet(s, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.ByteSets$UnmodifiableSet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteSets$UnmodifiableSet.class */
    public static class UnmodifiableSet extends ByteCollections.UnmodifiableCollection implements ByteSet, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;

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

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean addAll(Collection collection) {
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

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ Stream parallelStream() {
            return parallelStream();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ Stream stream() {
            return stream();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteSpliterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
        public /* bridge */ /* synthetic */ Spliterator<Byte> spliterator() {
            return spliterator();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
        public /* bridge */ /* synthetic */ Iterator<Byte> iterator() {
            return iterator();
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
        public /* bridge */ /* synthetic */ boolean add(byte b) {
            return add(b);
        }

        /* access modifiers changed from: protected */
        public UnmodifiableSet(ByteSet s) {
            super(s);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSet
        public boolean remove(byte k) {
            throw new UnsupportedOperationException();
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

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        @Deprecated
        public boolean rem(byte k) {
            return rem(k);
        }
    }

    public static ByteSet unmodifiable(ByteSet s) {
        return new UnmodifiableSet(s);
    }

    public static ByteSet fromTo(final byte from, final byte to) {
        return new AbstractByteSet() { // from class: it.unimi.dsi.fastutil.bytes.ByteSets.1
            @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
            public boolean contains(byte x) {
                return x >= from && x < to;
            }

            /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteIterator' to match base method */
            @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteSet, p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
            public Iterator<Byte> iterator() {
                return ByteIterators.fromTo(from, to);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                long size = ((long) to) - ((long) from);
                if (size < 0 || size > 2147483647L) {
                    return Integer.MAX_VALUE;
                }
                return (int) size;
            }
        };
    }

    public static ByteSet from(final byte from) {
        return new AbstractByteSet() { // from class: it.unimi.dsi.fastutil.bytes.ByteSets.2
            @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
            public boolean contains(byte x) {
                return x >= from;
            }

            /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteIterator' to match base method */
            /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: it.unimi.dsi.fastutil.bytes.ByteIterator[] */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteSet, p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
            public Iterator<Byte> iterator() {
                return ByteIterators.concat(ByteIterators.fromTo(from, Byte.MAX_VALUE), ByteSets.singleton(Byte.MAX_VALUE).iterator());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                long size = (127 - ((long) from)) + 1;
                if (size < 0 || size > 2147483647L) {
                    return Integer.MAX_VALUE;
                }
                return (int) size;
            }
        };
    }

    /* renamed from: to */
    public static ByteSet m1033to(final byte to) {
        return new AbstractByteSet() { // from class: it.unimi.dsi.fastutil.bytes.ByteSets.3
            @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
            public boolean contains(byte x) {
                return x < to;
            }

            /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteIterator' to match base method */
            @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteSet, p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
            public Iterator<Byte> iterator() {
                return ByteIterators.fromTo(Byte.MIN_VALUE, to);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                long size = ((long) to) - -128;
                if (size < 0 || size > 2147483647L) {
                    return Integer.MAX_VALUE;
                }
                return (int) size;
            }
        };
    }
}
