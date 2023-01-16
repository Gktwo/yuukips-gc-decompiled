package p014it.unimi.dsi.fastutil.longs;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.LongConsumer;
import java.util.function.LongPredicate;
import java.util.function.Predicate;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import kotlin.jvm.internal.LongCompanionObject;
import p014it.unimi.dsi.fastutil.longs.LongCollections;

/* renamed from: it.unimi.dsi.fastutil.longs.LongSets */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongSets.class */
public final class LongSets {
    static final int ARRAY_SET_CUTOFF = 4;
    public static final EmptySet EMPTY_SET = new EmptySet();
    static final LongSet UNMODIFIABLE_EMPTY_SET = unmodifiable(new LongArraySet(LongArrays.EMPTY_ARRAY));

    private LongSets() {
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.LongSets$EmptySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongSets$EmptySet.class */
    public static class EmptySet extends LongCollections.EmptyCollection implements LongSet, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // p014it.unimi.dsi.fastutil.longs.LongSet
        public boolean remove(long ok) {
            throw new UnsupportedOperationException();
        }

        @Override // java.lang.Object
        public Object clone() {
            return LongSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.EmptyCollection, java.util.Collection, java.lang.Object
        public boolean equals(Object o) {
            return (o instanceof Set) && ((Set) o).isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        @Deprecated
        public boolean rem(long k) {
            return rem(k);
        }

        private Object readResolve() {
            return LongSets.EMPTY_SET;
        }
    }

    public static LongSet emptySet() {
        return EMPTY_SET;
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.LongSets$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongSets$Singleton.class */
    public static class Singleton extends AbstractLongSet implements Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final long element;

        /* access modifiers changed from: protected */
        public Singleton(long element) {
            this.element = element;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public boolean contains(long k) {
            return k == this.element;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongSet, p014it.unimi.dsi.fastutil.longs.LongSet
        public boolean remove(long k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongSet, p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
        public LongListIterator iterator() {
            return LongIterators.singleton(this.element);
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
        public LongSpliterator spliterator() {
            return LongSpliterators.singleton(this.element);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return 1;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public long[] toLongArray() {
            return new long[]{this.element};
        }

        @Override // java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongIterable
        @Deprecated
        public void forEach(Consumer<? super Long> action) {
            action.accept(Long.valueOf(this.element));
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
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongIterable
        public void forEach(LongConsumer action) {
            action.accept(this.element);
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
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @Deprecated
        public Object[] toArray() {
            return new Object[]{Long.valueOf(this.element)};
        }

        @Override // java.lang.Object
        public Object clone() {
            return this;
        }
    }

    public static LongSet singleton(long element) {
        return new Singleton(element);
    }

    public static LongSet singleton(Long element) {
        return new Singleton(element.longValue());
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.LongSets$SynchronizedSet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongSets$SynchronizedSet.class */
    public static class SynchronizedSet extends LongCollections.SynchronizedCollection implements LongSet, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.SynchronizedCollection, java.util.Collection, java.lang.Object
        public /* bridge */ /* synthetic */ boolean equals(Object obj) {
            return equals(obj);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.SynchronizedCollection, java.util.Collection, java.lang.Object
        public /* bridge */ /* synthetic */ int hashCode() {
            return hashCode();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.SynchronizedCollection, java.lang.Object
        public /* bridge */ /* synthetic */ String toString() {
            return toString();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ void clear() {
            clear();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public /* bridge */ /* synthetic */ boolean removeIf(LongPredicate longPredicate) {
            return removeIf(longPredicate);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
            return retainAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
            return removeAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean containsAll(Collection collection) {
            return containsAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean addAll(Collection collection) {
            return addAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
        public /* bridge */ /* synthetic */ void forEach(LongConsumer longConsumer) {
            forEach(longConsumer);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.longs.LongCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ Stream parallelStream() {
            return parallelStream();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.longs.LongCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ Stream stream() {
            return stream();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.longs.LongCollection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongIterable
        public /* bridge */ /* synthetic */ LongSpliterator spliterator() {
            return spliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.longs.LongCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongIterable
        public /* bridge */ /* synthetic */ LongIterator iterator() {
            return iterator();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Object[] toArray(Object[] objArr) {
            return toArray(objArr);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public /* bridge */ /* synthetic */ LongStream longParallelStream() {
            return longParallelStream();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public /* bridge */ /* synthetic */ LongStream longStream() {
            return longStream();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
        public /* bridge */ /* synthetic */ LongSpliterator longSpliterator() {
            return longSpliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
        public /* bridge */ /* synthetic */ LongIterator longIterator() {
            return longIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.longs.LongCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean remove(Object obj) {
            return remove(obj);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.longs.LongCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean contains(Object obj) {
            return contains(obj);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean add(Long l) {
            return add(l);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public /* bridge */ /* synthetic */ boolean retainAll(LongCollection longCollection) {
            return retainAll(longCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public /* bridge */ /* synthetic */ boolean removeAll(LongCollection longCollection) {
            return removeAll(longCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public /* bridge */ /* synthetic */ boolean containsAll(LongCollection longCollection) {
            return containsAll(longCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public /* bridge */ /* synthetic */ boolean addAll(LongCollection longCollection) {
            return addAll(longCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public /* bridge */ /* synthetic */ long[] toArray(long[] jArr) {
            return toArray(jArr);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        @Deprecated
        public /* bridge */ /* synthetic */ long[] toLongArray(long[] jArr) {
            return toLongArray(jArr);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Object[] toArray() {
            return toArray();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public /* bridge */ /* synthetic */ long[] toLongArray() {
            return toLongArray();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean isEmpty() {
            return isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.SynchronizedCollection, java.util.Collection, p014it.unimi.dsi.fastutil.BigList, p014it.unimi.dsi.fastutil.Size64
        public /* bridge */ /* synthetic */ int size() {
            return size();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public /* bridge */ /* synthetic */ boolean contains(long j) {
            return contains(j);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public /* bridge */ /* synthetic */ boolean add(long j) {
            return add(j);
        }

        /* access modifiers changed from: protected */
        public SynchronizedSet(LongSet s, Object sync) {
            super(s, sync);
        }

        /* access modifiers changed from: protected */
        public SynchronizedSet(LongSet s) {
            super(s);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSet
        public boolean remove(long k) {
            boolean rem;
            synchronized (this.sync) {
                rem = this.collection.rem(k);
            }
            return rem;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        @Deprecated
        public boolean rem(long k) {
            return rem(k);
        }
    }

    public static LongSet synchronize(LongSet s) {
        return new SynchronizedSet(s);
    }

    public static LongSet synchronize(LongSet s, Object sync) {
        return new SynchronizedSet(s, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.LongSets$UnmodifiableSet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongSets$UnmodifiableSet.class */
    public static class UnmodifiableSet extends LongCollections.UnmodifiableCollection implements LongSet, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.UnmodifiableCollection, java.lang.Object
        public /* bridge */ /* synthetic */ String toString() {
            return toString();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public /* bridge */ /* synthetic */ LongStream longParallelStream() {
            return longParallelStream();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public /* bridge */ /* synthetic */ LongStream longStream() {
            return longStream();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
        public /* bridge */ /* synthetic */ LongSpliterator longSpliterator() {
            return longSpliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
        public /* bridge */ /* synthetic */ LongIterator longIterator() {
            return longIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public /* bridge */ /* synthetic */ boolean retainAll(LongCollection longCollection) {
            return retainAll(longCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public /* bridge */ /* synthetic */ boolean removeAll(LongCollection longCollection) {
            return removeAll(longCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public /* bridge */ /* synthetic */ boolean addAll(LongCollection longCollection) {
            return addAll(longCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public /* bridge */ /* synthetic */ boolean containsAll(LongCollection longCollection) {
            return containsAll(longCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public /* bridge */ /* synthetic */ long[] toArray(long[] jArr) {
            return toArray(jArr);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        @Deprecated
        public /* bridge */ /* synthetic */ long[] toLongArray(long[] jArr) {
            return toLongArray(jArr);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public /* bridge */ /* synthetic */ long[] toLongArray() {
            return toLongArray();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.longs.LongCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean remove(Object obj) {
            return remove(obj);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.longs.LongCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean contains(Object obj) {
            return contains(obj);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean add(Long l) {
            return add(l);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public /* bridge */ /* synthetic */ boolean removeIf(LongPredicate longPredicate) {
            return removeIf(longPredicate);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
            return retainAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
            return removeAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean addAll(Collection collection) {
            return addAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean containsAll(Collection collection) {
            return containsAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
        public /* bridge */ /* synthetic */ void forEach(LongConsumer longConsumer) {
            forEach(longConsumer);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Object[] toArray() {
            return toArray();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Object[] toArray(Object[] objArr) {
            return toArray(objArr);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ void clear() {
            clear();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.longs.LongCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ Stream parallelStream() {
            return parallelStream();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.longs.LongCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ Stream stream() {
            return stream();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.longs.LongCollection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongIterable
        public /* bridge */ /* synthetic */ LongSpliterator spliterator() {
            return spliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.longs.LongCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongIterable
        public /* bridge */ /* synthetic */ LongIterator iterator() {
            return iterator();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public /* bridge */ /* synthetic */ boolean contains(long j) {
            return contains(j);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean isEmpty() {
            return isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.UnmodifiableCollection, java.util.Collection, p014it.unimi.dsi.fastutil.BigList, p014it.unimi.dsi.fastutil.Size64
        public /* bridge */ /* synthetic */ int size() {
            return size();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public /* bridge */ /* synthetic */ boolean add(long j) {
            return add(j);
        }

        /* access modifiers changed from: protected */
        public UnmodifiableSet(LongSet s) {
            super(s);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSet
        public boolean remove(long k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.UnmodifiableCollection, java.util.Collection, java.lang.Object
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            return this.collection.equals(o);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.UnmodifiableCollection, java.util.Collection, java.lang.Object
        public int hashCode() {
            return this.collection.hashCode();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        @Deprecated
        public boolean rem(long k) {
            return rem(k);
        }
    }

    public static LongSet unmodifiable(LongSet s) {
        return new UnmodifiableSet(s);
    }

    public static LongSet fromTo(final long from, final long to) {
        return new AbstractLongSet() { // from class: it.unimi.dsi.fastutil.longs.LongSets.1
            @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
            public boolean contains(long x) {
                return x >= from && x < to;
            }

            @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongSet, p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
            public LongIterator iterator() {
                return LongIterators.fromTo(from, to);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                long size = to - from;
                if (size < 0 || size > 2147483647L) {
                    return Integer.MAX_VALUE;
                }
                return (int) size;
            }
        };
    }

    public static LongSet from(final long from) {
        return new AbstractLongSet() { // from class: it.unimi.dsi.fastutil.longs.LongSets.2
            @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
            public boolean contains(long x) {
                return x >= from;
            }

            @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongSet, p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
            public LongIterator iterator() {
                return LongIterators.concat(LongIterators.fromTo(from, LongCompanionObject.MAX_VALUE), LongSets.singleton((long) LongCompanionObject.MAX_VALUE).iterator());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                long size = (LongCompanionObject.MAX_VALUE - from) + 1;
                if (size < 0 || size > 2147483647L) {
                    return Integer.MAX_VALUE;
                }
                return (int) size;
            }
        };
    }

    /* renamed from: to */
    public static LongSet m610to(final long to) {
        return new AbstractLongSet() { // from class: it.unimi.dsi.fastutil.longs.LongSets.3
            @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
            public boolean contains(long x) {
                return x < to;
            }

            @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongSet, p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
            public LongIterator iterator() {
                return LongIterators.fromTo(Long.MIN_VALUE, to);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                long size = to - Long.MIN_VALUE;
                if (size < 0 || size > 2147483647L) {
                    return Integer.MAX_VALUE;
                }
                return (int) size;
            }
        };
    }
}
