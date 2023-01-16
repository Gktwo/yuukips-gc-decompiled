package p014it.unimi.dsi.fastutil.doubles;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.DoublePredicate;
import java.util.function.Predicate;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;
import p014it.unimi.dsi.fastutil.doubles.DoubleCollections;

/* renamed from: it.unimi.dsi.fastutil.doubles.DoubleSets */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleSets.class */
public final class DoubleSets {
    static final int ARRAY_SET_CUTOFF = 4;
    public static final EmptySet EMPTY_SET = new EmptySet();
    static final DoubleSet UNMODIFIABLE_EMPTY_SET = unmodifiable(new DoubleArraySet(DoubleArrays.EMPTY_ARRAY));

    private DoubleSets() {
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.DoubleSets$EmptySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleSets$EmptySet.class */
    public static class EmptySet extends DoubleCollections.EmptyCollection implements DoubleSet, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSet
        public boolean remove(double ok) {
            throw new UnsupportedOperationException();
        }

        @Override // java.lang.Object
        public Object clone() {
            return DoubleSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.EmptyCollection, java.util.Collection, java.lang.Object
        public boolean equals(Object o) {
            return (o instanceof Set) && ((Set) o).isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        @Deprecated
        public boolean rem(double k) {
            return rem(k);
        }

        private Object readResolve() {
            return DoubleSets.EMPTY_SET;
        }
    }

    public static DoubleSet emptySet() {
        return EMPTY_SET;
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.DoubleSets$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleSets$Singleton.class */
    public static class Singleton extends AbstractDoubleSet implements Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final double element;

        /* access modifiers changed from: protected */
        public Singleton(double element) {
            this.element = element;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public boolean contains(double k) {
            return Double.doubleToLongBits(k) == Double.doubleToLongBits(this.element);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleSet, p014it.unimi.dsi.fastutil.doubles.DoubleSet
        public boolean remove(double k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleSet, p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public DoubleListIterator iterator() {
            return DoubleIterators.singleton(this.element);
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public DoubleSpliterator spliterator() {
            return DoubleSpliterators.singleton(this.element);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return 1;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public double[] toDoubleArray() {
            return new double[]{this.element};
        }

        @Override // java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        @Deprecated
        public void forEach(Consumer<? super Double> action) {
            action.accept(Double.valueOf(this.element));
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
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public void forEach(DoubleConsumer action) {
            action.accept(this.element);
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
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @Deprecated
        public Object[] toArray() {
            return new Object[]{Double.valueOf(this.element)};
        }

        @Override // java.lang.Object
        public Object clone() {
            return this;
        }
    }

    public static DoubleSet singleton(double element) {
        return new Singleton(element);
    }

    public static DoubleSet singleton(Double element) {
        return new Singleton(element.doubleValue());
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.DoubleSets$SynchronizedSet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleSets$SynchronizedSet.class */
    public static class SynchronizedSet extends DoubleCollections.SynchronizedCollection implements DoubleSet, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.SynchronizedCollection, java.util.Collection, java.lang.Object
        public /* bridge */ /* synthetic */ boolean equals(Object obj) {
            return equals(obj);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.SynchronizedCollection, java.util.Collection, java.lang.Object
        public /* bridge */ /* synthetic */ int hashCode() {
            return hashCode();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.SynchronizedCollection, java.lang.Object
        public /* bridge */ /* synthetic */ String toString() {
            return toString();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ void clear() {
            clear();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public /* bridge */ /* synthetic */ boolean removeIf(DoublePredicate doublePredicate) {
            return removeIf(doublePredicate);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
            return retainAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
            return removeAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean containsAll(Collection collection) {
            return containsAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean addAll(Collection collection) {
            return addAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public /* bridge */ /* synthetic */ void forEach(DoubleConsumer doubleConsumer) {
            forEach(doubleConsumer);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ Stream parallelStream() {
            return parallelStream();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ Stream stream() {
            return stream();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public /* bridge */ /* synthetic */ DoubleSpliterator spliterator() {
            return spliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public /* bridge */ /* synthetic */ DoubleIterator iterator() {
            return iterator();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Object[] toArray(Object[] objArr) {
            return toArray(objArr);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public /* bridge */ /* synthetic */ DoubleStream doubleParallelStream() {
            return doubleParallelStream();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public /* bridge */ /* synthetic */ DoubleStream doubleStream() {
            return doubleStream();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public /* bridge */ /* synthetic */ DoubleSpliterator doubleSpliterator() {
            return doubleSpliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public /* bridge */ /* synthetic */ DoubleIterator doubleIterator() {
            return doubleIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean remove(Object obj) {
            return remove(obj);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean contains(Object obj) {
            return contains(obj);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean add(Double d) {
            return add(d);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public /* bridge */ /* synthetic */ boolean retainAll(DoubleCollection doubleCollection) {
            return retainAll(doubleCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public /* bridge */ /* synthetic */ boolean removeAll(DoubleCollection doubleCollection) {
            return removeAll(doubleCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public /* bridge */ /* synthetic */ boolean containsAll(DoubleCollection doubleCollection) {
            return containsAll(doubleCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public /* bridge */ /* synthetic */ boolean addAll(DoubleCollection doubleCollection) {
            return addAll(doubleCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public /* bridge */ /* synthetic */ double[] toArray(double[] dArr) {
            return toArray(dArr);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        @Deprecated
        public /* bridge */ /* synthetic */ double[] toDoubleArray(double[] dArr) {
            return toDoubleArray(dArr);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Object[] toArray() {
            return toArray();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public /* bridge */ /* synthetic */ double[] toDoubleArray() {
            return toDoubleArray();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean isEmpty() {
            return isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.SynchronizedCollection, java.util.Collection, p014it.unimi.dsi.fastutil.BigList, p014it.unimi.dsi.fastutil.Size64
        public /* bridge */ /* synthetic */ int size() {
            return size();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public /* bridge */ /* synthetic */ boolean contains(double d) {
            return contains(d);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public /* bridge */ /* synthetic */ boolean add(double d) {
            return add(d);
        }

        /* access modifiers changed from: protected */
        public SynchronizedSet(DoubleSet s, Object sync) {
            super(s, sync);
        }

        /* access modifiers changed from: protected */
        public SynchronizedSet(DoubleSet s) {
            super(s);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSet
        public boolean remove(double k) {
            boolean rem;
            synchronized (this.sync) {
                rem = this.collection.rem(k);
            }
            return rem;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        @Deprecated
        public boolean rem(double k) {
            return rem(k);
        }
    }

    public static DoubleSet synchronize(DoubleSet s) {
        return new SynchronizedSet(s);
    }

    public static DoubleSet synchronize(DoubleSet s, Object sync) {
        return new SynchronizedSet(s, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.DoubleSets$UnmodifiableSet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleSets$UnmodifiableSet.class */
    public static class UnmodifiableSet extends DoubleCollections.UnmodifiableCollection implements DoubleSet, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.UnmodifiableCollection, java.lang.Object
        public /* bridge */ /* synthetic */ String toString() {
            return toString();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public /* bridge */ /* synthetic */ DoubleStream doubleParallelStream() {
            return doubleParallelStream();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public /* bridge */ /* synthetic */ DoubleStream doubleStream() {
            return doubleStream();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public /* bridge */ /* synthetic */ DoubleSpliterator doubleSpliterator() {
            return doubleSpliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public /* bridge */ /* synthetic */ DoubleIterator doubleIterator() {
            return doubleIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public /* bridge */ /* synthetic */ boolean retainAll(DoubleCollection doubleCollection) {
            return retainAll(doubleCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public /* bridge */ /* synthetic */ boolean removeAll(DoubleCollection doubleCollection) {
            return removeAll(doubleCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public /* bridge */ /* synthetic */ boolean addAll(DoubleCollection doubleCollection) {
            return addAll(doubleCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public /* bridge */ /* synthetic */ boolean containsAll(DoubleCollection doubleCollection) {
            return containsAll(doubleCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public /* bridge */ /* synthetic */ double[] toArray(double[] dArr) {
            return toArray(dArr);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        @Deprecated
        public /* bridge */ /* synthetic */ double[] toDoubleArray(double[] dArr) {
            return toDoubleArray(dArr);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public /* bridge */ /* synthetic */ double[] toDoubleArray() {
            return toDoubleArray();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean remove(Object obj) {
            return remove(obj);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean contains(Object obj) {
            return contains(obj);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean add(Double d) {
            return add(d);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public /* bridge */ /* synthetic */ boolean removeIf(DoublePredicate doublePredicate) {
            return removeIf(doublePredicate);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
            return retainAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
            return removeAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean addAll(Collection collection) {
            return addAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean containsAll(Collection collection) {
            return containsAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public /* bridge */ /* synthetic */ void forEach(DoubleConsumer doubleConsumer) {
            forEach(doubleConsumer);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Object[] toArray() {
            return toArray();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Object[] toArray(Object[] objArr) {
            return toArray(objArr);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ void clear() {
            clear();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ Stream parallelStream() {
            return parallelStream();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ Stream stream() {
            return stream();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public /* bridge */ /* synthetic */ DoubleSpliterator spliterator() {
            return spliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public /* bridge */ /* synthetic */ DoubleIterator iterator() {
            return iterator();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public /* bridge */ /* synthetic */ boolean contains(double d) {
            return contains(d);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean isEmpty() {
            return isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.UnmodifiableCollection, java.util.Collection, p014it.unimi.dsi.fastutil.BigList, p014it.unimi.dsi.fastutil.Size64
        public /* bridge */ /* synthetic */ int size() {
            return size();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public /* bridge */ /* synthetic */ boolean add(double d) {
            return add(d);
        }

        /* access modifiers changed from: protected */
        public UnmodifiableSet(DoubleSet s) {
            super(s);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSet
        public boolean remove(double k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.UnmodifiableCollection, java.util.Collection, java.lang.Object
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            return this.collection.equals(o);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.UnmodifiableCollection, java.util.Collection, java.lang.Object
        public int hashCode() {
            return this.collection.hashCode();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        @Deprecated
        public boolean rem(double k) {
            return rem(k);
        }
    }

    public static DoubleSet unmodifiable(DoubleSet s) {
        return new UnmodifiableSet(s);
    }
}
