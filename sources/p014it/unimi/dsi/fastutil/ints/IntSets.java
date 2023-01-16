package p014it.unimi.dsi.fastutil.ints;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import p014it.unimi.dsi.fastutil.ints.IntCollections;

/* renamed from: it.unimi.dsi.fastutil.ints.IntSets */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntSets.class */
public final class IntSets {
    static final int ARRAY_SET_CUTOFF = 4;
    public static final EmptySet EMPTY_SET = new EmptySet();
    static final IntSet UNMODIFIABLE_EMPTY_SET = unmodifiable(new IntArraySet(IntArrays.EMPTY_ARRAY));

    private IntSets() {
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.IntSets$EmptySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntSets$EmptySet.class */
    public static class EmptySet extends IntCollections.EmptyCollection implements IntSet, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // p014it.unimi.dsi.fastutil.ints.IntSet
        public boolean remove(int ok) {
            throw new UnsupportedOperationException();
        }

        @Override // java.lang.Object
        public Object clone() {
            return IntSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.EmptyCollection, java.util.Collection, java.lang.Object
        public boolean equals(Object o) {
            return (o instanceof Set) && ((Set) o).isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        @Deprecated
        public boolean rem(int k) {
            return rem(k);
        }

        private Object readResolve() {
            return IntSets.EMPTY_SET;
        }
    }

    public static IntSet emptySet() {
        return EMPTY_SET;
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.IntSets$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntSets$Singleton.class */
    public static class Singleton extends AbstractIntSet implements Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final int element;

        /* access modifiers changed from: protected */
        public Singleton(int element) {
            this.element = element;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public boolean contains(int k) {
            return k == this.element;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntSet, p014it.unimi.dsi.fastutil.ints.IntSet
        public boolean remove(int k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntSet, p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
        public IntListIterator iterator() {
            return IntIterators.singleton(this.element);
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
        public IntSpliterator spliterator() {
            return IntSpliterators.singleton(this.element);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return 1;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public int[] toIntArray() {
            return new int[]{this.element};
        }

        @Override // java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntIterable
        @Deprecated
        public void forEach(Consumer<? super Integer> action) {
            action.accept(Integer.valueOf(this.element));
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
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntIterable
        public void forEach(IntConsumer action) {
            action.accept(this.element);
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
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @Deprecated
        public Object[] toArray() {
            return new Object[]{Integer.valueOf(this.element)};
        }

        @Override // java.lang.Object
        public Object clone() {
            return this;
        }
    }

    public static IntSet singleton(int element) {
        return new Singleton(element);
    }

    public static IntSet singleton(Integer element) {
        return new Singleton(element.intValue());
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.IntSets$SynchronizedSet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntSets$SynchronizedSet.class */
    public static class SynchronizedSet extends IntCollections.SynchronizedCollection implements IntSet, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.SynchronizedCollection, java.util.Collection, java.lang.Object
        public /* bridge */ /* synthetic */ boolean equals(Object obj) {
            return equals(obj);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.SynchronizedCollection, java.util.Collection, java.lang.Object
        public /* bridge */ /* synthetic */ int hashCode() {
            return hashCode();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.SynchronizedCollection, java.lang.Object
        public /* bridge */ /* synthetic */ String toString() {
            return toString();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ void clear() {
            clear();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public /* bridge */ /* synthetic */ boolean removeIf(IntPredicate intPredicate) {
            return removeIf(intPredicate);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
            return retainAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
            return removeAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean containsAll(Collection collection) {
            return containsAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean addAll(Collection collection) {
            return addAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
        public /* bridge */ /* synthetic */ void forEach(IntConsumer intConsumer) {
            forEach(intConsumer);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.ints.IntCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ Stream parallelStream() {
            return parallelStream();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.ints.IntCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ Stream stream() {
            return stream();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.ints.IntCollection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntIterable
        public /* bridge */ /* synthetic */ IntSpliterator spliterator() {
            return spliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.ints.IntCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntIterable
        public /* bridge */ /* synthetic */ IntIterator iterator() {
            return iterator();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Object[] toArray(Object[] objArr) {
            return toArray(objArr);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public /* bridge */ /* synthetic */ IntStream intParallelStream() {
            return intParallelStream();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public /* bridge */ /* synthetic */ IntStream intStream() {
            return intStream();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
        public /* bridge */ /* synthetic */ IntSpliterator intSpliterator() {
            return intSpliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
        public /* bridge */ /* synthetic */ IntIterator intIterator() {
            return intIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.ints.IntCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean remove(Object obj) {
            return remove(obj);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.ints.IntCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean contains(Object obj) {
            return contains(obj);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean add(Integer num) {
            return add(num);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public /* bridge */ /* synthetic */ boolean retainAll(IntCollection intCollection) {
            return retainAll(intCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public /* bridge */ /* synthetic */ boolean removeAll(IntCollection intCollection) {
            return removeAll(intCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public /* bridge */ /* synthetic */ boolean containsAll(IntCollection intCollection) {
            return containsAll(intCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public /* bridge */ /* synthetic */ boolean addAll(IntCollection intCollection) {
            return addAll(intCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public /* bridge */ /* synthetic */ int[] toArray(int[] iArr) {
            return toArray(iArr);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        @Deprecated
        public /* bridge */ /* synthetic */ int[] toIntArray(int[] iArr) {
            return toIntArray(iArr);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Object[] toArray() {
            return toArray();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public /* bridge */ /* synthetic */ int[] toIntArray() {
            return toIntArray();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean isEmpty() {
            return isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.SynchronizedCollection, java.util.Collection, p014it.unimi.dsi.fastutil.BigList, p014it.unimi.dsi.fastutil.Size64
        public /* bridge */ /* synthetic */ int size() {
            return size();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public /* bridge */ /* synthetic */ boolean contains(int i) {
            return contains(i);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public /* bridge */ /* synthetic */ boolean add(int i) {
            return add(i);
        }

        /* access modifiers changed from: protected */
        public SynchronizedSet(IntSet s, Object sync) {
            super(s, sync);
        }

        /* access modifiers changed from: protected */
        public SynchronizedSet(IntSet s) {
            super(s);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSet
        public boolean remove(int k) {
            boolean rem;
            synchronized (this.sync) {
                rem = this.collection.rem(k);
            }
            return rem;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        @Deprecated
        public boolean rem(int k) {
            return rem(k);
        }
    }

    public static IntSet synchronize(IntSet s) {
        return new SynchronizedSet(s);
    }

    public static IntSet synchronize(IntSet s, Object sync) {
        return new SynchronizedSet(s, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.IntSets$UnmodifiableSet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntSets$UnmodifiableSet.class */
    public static class UnmodifiableSet extends IntCollections.UnmodifiableCollection implements IntSet, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.UnmodifiableCollection, java.lang.Object
        public /* bridge */ /* synthetic */ String toString() {
            return toString();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public /* bridge */ /* synthetic */ IntStream intParallelStream() {
            return intParallelStream();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public /* bridge */ /* synthetic */ IntStream intStream() {
            return intStream();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
        public /* bridge */ /* synthetic */ IntSpliterator intSpliterator() {
            return intSpliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
        public /* bridge */ /* synthetic */ IntIterator intIterator() {
            return intIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public /* bridge */ /* synthetic */ boolean retainAll(IntCollection intCollection) {
            return retainAll(intCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public /* bridge */ /* synthetic */ boolean removeAll(IntCollection intCollection) {
            return removeAll(intCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public /* bridge */ /* synthetic */ boolean addAll(IntCollection intCollection) {
            return addAll(intCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public /* bridge */ /* synthetic */ boolean containsAll(IntCollection intCollection) {
            return containsAll(intCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public /* bridge */ /* synthetic */ int[] toArray(int[] iArr) {
            return toArray(iArr);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        @Deprecated
        public /* bridge */ /* synthetic */ int[] toIntArray(int[] iArr) {
            return toIntArray(iArr);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public /* bridge */ /* synthetic */ int[] toIntArray() {
            return toIntArray();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.ints.IntCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean remove(Object obj) {
            return remove(obj);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.ints.IntCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean contains(Object obj) {
            return contains(obj);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean add(Integer num) {
            return add(num);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public /* bridge */ /* synthetic */ boolean removeIf(IntPredicate intPredicate) {
            return removeIf(intPredicate);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
            return retainAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
            return removeAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean addAll(Collection collection) {
            return addAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean containsAll(Collection collection) {
            return containsAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
        public /* bridge */ /* synthetic */ void forEach(IntConsumer intConsumer) {
            forEach(intConsumer);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Object[] toArray() {
            return toArray();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Object[] toArray(Object[] objArr) {
            return toArray(objArr);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ void clear() {
            clear();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.ints.IntCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ Stream parallelStream() {
            return parallelStream();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.ints.IntCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ Stream stream() {
            return stream();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.ints.IntCollection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntIterable
        public /* bridge */ /* synthetic */ IntSpliterator spliterator() {
            return spliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.ints.IntCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntIterable
        public /* bridge */ /* synthetic */ IntIterator iterator() {
            return iterator();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public /* bridge */ /* synthetic */ boolean contains(int i) {
            return contains(i);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean isEmpty() {
            return isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.UnmodifiableCollection, java.util.Collection, p014it.unimi.dsi.fastutil.BigList, p014it.unimi.dsi.fastutil.Size64
        public /* bridge */ /* synthetic */ int size() {
            return size();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public /* bridge */ /* synthetic */ boolean add(int i) {
            return add(i);
        }

        /* access modifiers changed from: protected */
        public UnmodifiableSet(IntSet s) {
            super(s);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSet
        public boolean remove(int k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.UnmodifiableCollection, java.util.Collection, java.lang.Object
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            return this.collection.equals(o);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.UnmodifiableCollection, java.util.Collection, java.lang.Object
        public int hashCode() {
            return this.collection.hashCode();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        @Deprecated
        public boolean rem(int k) {
            return rem(k);
        }
    }

    public static IntSet unmodifiable(IntSet s) {
        return new UnmodifiableSet(s);
    }

    public static IntSet fromTo(final int from, final int to) {
        return new AbstractIntSet() { // from class: it.unimi.dsi.fastutil.ints.IntSets.1
            @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
            public boolean contains(int x) {
                return x >= from && x < to;
            }

            @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntSet, p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
            public IntIterator iterator() {
                return IntIterators.fromTo(from, to);
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

    public static IntSet from(final int from) {
        return new AbstractIntSet() { // from class: it.unimi.dsi.fastutil.ints.IntSets.2
            @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
            public boolean contains(int x) {
                return x >= from;
            }

            @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntSet, p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
            public IntIterator iterator() {
                return IntIterators.concat(IntIterators.fromTo(from, Integer.MAX_VALUE), IntSets.singleton(Integer.MAX_VALUE).iterator());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                long size = (2147483647L - ((long) from)) + 1;
                if (size < 0 || size > 2147483647L) {
                    return Integer.MAX_VALUE;
                }
                return (int) size;
            }
        };
    }

    /* renamed from: to */
    public static IntSet m695to(final int to) {
        return new AbstractIntSet() { // from class: it.unimi.dsi.fastutil.ints.IntSets.3
            @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
            public boolean contains(int x) {
                return x < to;
            }

            @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntSet, p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
            public IntIterator iterator() {
                return IntIterators.fromTo(Integer.MIN_VALUE, to);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                long size = ((long) to) - -2147483648L;
                if (size < 0 || size > 2147483647L) {
                    return Integer.MAX_VALUE;
                }
                return (int) size;
            }
        };
    }
}
