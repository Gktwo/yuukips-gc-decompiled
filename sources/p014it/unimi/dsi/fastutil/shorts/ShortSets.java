package p014it.unimi.dsi.fastutil.shorts;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import p014it.unimi.dsi.fastutil.ints.IntIterator;
import p014it.unimi.dsi.fastutil.ints.IntIterators;
import p014it.unimi.dsi.fastutil.ints.IntSpliterator;
import p014it.unimi.dsi.fastutil.ints.IntSpliterators;
import p014it.unimi.dsi.fastutil.shorts.ShortCollections;

/* renamed from: it.unimi.dsi.fastutil.shorts.ShortSets */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortSets.class */
public final class ShortSets {
    static final int ARRAY_SET_CUTOFF = 4;
    public static final EmptySet EMPTY_SET = new EmptySet();
    static final ShortSet UNMODIFIABLE_EMPTY_SET = unmodifiable(new ShortArraySet(ShortArrays.EMPTY_ARRAY));

    private ShortSets() {
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortSets$EmptySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortSets$EmptySet.class */
    public static class EmptySet extends ShortCollections.EmptyCollection implements ShortSet, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSet
        public boolean remove(short ok) {
            throw new UnsupportedOperationException();
        }

        @Override // java.lang.Object
        public Object clone() {
            return ShortSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.EmptyCollection, java.util.Collection, java.lang.Object
        public boolean equals(Object o) {
            return (o instanceof Set) && ((Set) o).isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        @Deprecated
        public boolean rem(short k) {
            return rem(k);
        }

        private Object readResolve() {
            return ShortSets.EMPTY_SET;
        }
    }

    public static ShortSet emptySet() {
        return EMPTY_SET;
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortSets$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortSets$Singleton.class */
    public static class Singleton extends AbstractShortSet implements Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final short element;

        /* access modifiers changed from: protected */
        public Singleton(short element) {
            this.element = element;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public boolean contains(short k) {
            return k == this.element;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortSet, p014it.unimi.dsi.fastutil.shorts.ShortSet
        public boolean remove(short k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortSet, p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public ShortListIterator iterator() {
            return ShortIterators.singleton(this.element);
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public ShortSpliterator spliterator() {
            return ShortSpliterators.singleton(this.element);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return 1;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public short[] toShortArray() {
            return new short[]{this.element};
        }

        @Override // java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        @Deprecated
        public void forEach(Consumer<? super Short> action) {
            action.accept(Short.valueOf(this.element));
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
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public void forEach(ShortConsumer action) {
            action.accept(this.element);
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
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public IntIterator intIterator() {
            return IntIterators.singleton(this.element);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public IntSpliterator intSpliterator() {
            return IntSpliterators.singleton(this.element);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @Deprecated
        public Object[] toArray() {
            return new Object[]{Short.valueOf(this.element)};
        }

        @Override // java.lang.Object
        public Object clone() {
            return this;
        }
    }

    public static ShortSet singleton(short element) {
        return new Singleton(element);
    }

    public static ShortSet singleton(Short element) {
        return new Singleton(element.shortValue());
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortSets$SynchronizedSet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortSets$SynchronizedSet.class */
    public static class SynchronizedSet extends ShortCollections.SynchronizedCollection implements ShortSet, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.SynchronizedCollection, java.util.Collection, java.lang.Object
        public /* bridge */ /* synthetic */ boolean equals(Object obj) {
            return equals(obj);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.SynchronizedCollection, java.util.Collection, java.lang.Object
        public /* bridge */ /* synthetic */ int hashCode() {
            return hashCode();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.SynchronizedCollection, java.lang.Object
        public /* bridge */ /* synthetic */ String toString() {
            return toString();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ void clear() {
            clear();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public /* bridge */ /* synthetic */ boolean removeIf(ShortPredicate shortPredicate) {
            return removeIf(shortPredicate);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
            return retainAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
            return removeAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean containsAll(Collection collection) {
            return containsAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean addAll(Collection collection) {
            return addAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public /* bridge */ /* synthetic */ void forEach(ShortConsumer shortConsumer) {
            forEach(shortConsumer);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ Stream parallelStream() {
            return parallelStream();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ Stream stream() {
            return stream();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public /* bridge */ /* synthetic */ ShortSpliterator spliterator() {
            return spliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public /* bridge */ /* synthetic */ ShortIterator iterator() {
            return iterator();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Object[] toArray(Object[] objArr) {
            return toArray(objArr);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public /* bridge */ /* synthetic */ IntStream intParallelStream() {
            return intParallelStream();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public /* bridge */ /* synthetic */ IntStream intStream() {
            return intStream();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public /* bridge */ /* synthetic */ IntSpliterator intSpliterator() {
            return intSpliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public /* bridge */ /* synthetic */ IntIterator intIterator() {
            return intIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean remove(Object obj) {
            return remove(obj);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean contains(Object obj) {
            return contains(obj);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean add(Short sh) {
            return add(sh);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public /* bridge */ /* synthetic */ boolean retainAll(ShortCollection shortCollection) {
            return retainAll(shortCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public /* bridge */ /* synthetic */ boolean removeAll(ShortCollection shortCollection) {
            return removeAll(shortCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public /* bridge */ /* synthetic */ boolean containsAll(ShortCollection shortCollection) {
            return containsAll(shortCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public /* bridge */ /* synthetic */ boolean addAll(ShortCollection shortCollection) {
            return addAll(shortCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public /* bridge */ /* synthetic */ short[] toArray(short[] sArr) {
            return toArray(sArr);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        @Deprecated
        public /* bridge */ /* synthetic */ short[] toShortArray(short[] sArr) {
            return toShortArray(sArr);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Object[] toArray() {
            return toArray();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public /* bridge */ /* synthetic */ short[] toShortArray() {
            return toShortArray();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean isEmpty() {
            return isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.SynchronizedCollection, java.util.Collection, p014it.unimi.dsi.fastutil.BigList, p014it.unimi.dsi.fastutil.Size64
        public /* bridge */ /* synthetic */ int size() {
            return size();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public /* bridge */ /* synthetic */ boolean contains(short s) {
            return contains(s);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public /* bridge */ /* synthetic */ boolean add(short s) {
            return add(s);
        }

        /* access modifiers changed from: protected */
        public SynchronizedSet(ShortSet s, Object sync) {
            super(s, sync);
        }

        /* access modifiers changed from: protected */
        public SynchronizedSet(ShortSet s) {
            super(s);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSet
        public boolean remove(short k) {
            boolean rem;
            synchronized (this.sync) {
                rem = this.collection.rem(k);
            }
            return rem;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        @Deprecated
        public boolean rem(short k) {
            return rem(k);
        }
    }

    public static ShortSet synchronize(ShortSet s) {
        return new SynchronizedSet(s);
    }

    public static ShortSet synchronize(ShortSet s, Object sync) {
        return new SynchronizedSet(s, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortSets$UnmodifiableSet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortSets$UnmodifiableSet.class */
    public static class UnmodifiableSet extends ShortCollections.UnmodifiableCollection implements ShortSet, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.UnmodifiableCollection, java.lang.Object
        public /* bridge */ /* synthetic */ String toString() {
            return toString();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public /* bridge */ /* synthetic */ IntStream intParallelStream() {
            return intParallelStream();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public /* bridge */ /* synthetic */ IntStream intStream() {
            return intStream();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public /* bridge */ /* synthetic */ IntSpliterator intSpliterator() {
            return intSpliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public /* bridge */ /* synthetic */ IntIterator intIterator() {
            return intIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public /* bridge */ /* synthetic */ boolean retainAll(ShortCollection shortCollection) {
            return retainAll(shortCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public /* bridge */ /* synthetic */ boolean removeAll(ShortCollection shortCollection) {
            return removeAll(shortCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public /* bridge */ /* synthetic */ boolean addAll(ShortCollection shortCollection) {
            return addAll(shortCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public /* bridge */ /* synthetic */ boolean containsAll(ShortCollection shortCollection) {
            return containsAll(shortCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public /* bridge */ /* synthetic */ short[] toArray(short[] sArr) {
            return toArray(sArr);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        @Deprecated
        public /* bridge */ /* synthetic */ short[] toShortArray(short[] sArr) {
            return toShortArray(sArr);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public /* bridge */ /* synthetic */ short[] toShortArray() {
            return toShortArray();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean remove(Object obj) {
            return remove(obj);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean contains(Object obj) {
            return contains(obj);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean add(Short sh) {
            return add(sh);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public /* bridge */ /* synthetic */ boolean removeIf(ShortPredicate shortPredicate) {
            return removeIf(shortPredicate);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
            return retainAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
            return removeAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean addAll(Collection collection) {
            return addAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean containsAll(Collection collection) {
            return containsAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public /* bridge */ /* synthetic */ void forEach(ShortConsumer shortConsumer) {
            forEach(shortConsumer);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Object[] toArray() {
            return toArray();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Object[] toArray(Object[] objArr) {
            return toArray(objArr);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ void clear() {
            clear();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ Stream parallelStream() {
            return parallelStream();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ Stream stream() {
            return stream();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public /* bridge */ /* synthetic */ ShortSpliterator spliterator() {
            return spliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public /* bridge */ /* synthetic */ ShortIterator iterator() {
            return iterator();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public /* bridge */ /* synthetic */ boolean contains(short s) {
            return contains(s);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean isEmpty() {
            return isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.UnmodifiableCollection, java.util.Collection, p014it.unimi.dsi.fastutil.BigList, p014it.unimi.dsi.fastutil.Size64
        public /* bridge */ /* synthetic */ int size() {
            return size();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public /* bridge */ /* synthetic */ boolean add(short s) {
            return add(s);
        }

        /* access modifiers changed from: protected */
        public UnmodifiableSet(ShortSet s) {
            super(s);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSet
        public boolean remove(short k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.UnmodifiableCollection, java.util.Collection, java.lang.Object
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            return this.collection.equals(o);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.UnmodifiableCollection, java.util.Collection, java.lang.Object
        public int hashCode() {
            return this.collection.hashCode();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        @Deprecated
        public boolean rem(short k) {
            return rem(k);
        }
    }

    public static ShortSet unmodifiable(ShortSet s) {
        return new UnmodifiableSet(s);
    }

    public static ShortSet fromTo(final short from, final short to) {
        return new AbstractShortSet() { // from class: it.unimi.dsi.fastutil.shorts.ShortSets.1
            @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
            public boolean contains(short x) {
                return x >= from && x < to;
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortSet, p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
            public ShortIterator iterator() {
                return ShortIterators.fromTo(from, to);
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

    public static ShortSet from(final short from) {
        return new AbstractShortSet() { // from class: it.unimi.dsi.fastutil.shorts.ShortSets.2
            @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
            public boolean contains(short x) {
                return x >= from;
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortSet, p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
            public ShortIterator iterator() {
                return ShortIterators.concat(ShortIterators.fromTo(from, Short.MAX_VALUE), ShortSets.singleton(Short.MAX_VALUE).iterator());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                long size = (32767 - ((long) from)) + 1;
                if (size < 0 || size > 2147483647L) {
                    return Integer.MAX_VALUE;
                }
                return (int) size;
            }
        };
    }

    /* renamed from: to */
    public static ShortSet m387to(final short to) {
        return new AbstractShortSet() { // from class: it.unimi.dsi.fastutil.shorts.ShortSets.3
            @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
            public boolean contains(short x) {
                return x < to;
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortSet, p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
            public ShortIterator iterator() {
                return ShortIterators.fromTo(Short.MIN_VALUE, to);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                long size = ((long) to) - -32768;
                if (size < 0 || size > 2147483647L) {
                    return Integer.MAX_VALUE;
                }
                return (int) size;
            }
        };
    }
}
