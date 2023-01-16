package p014it.unimi.dsi.fastutil.floats;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;
import p014it.unimi.dsi.fastutil.doubles.DoubleIterator;
import p014it.unimi.dsi.fastutil.doubles.DoubleIterators;
import p014it.unimi.dsi.fastutil.doubles.DoubleSpliterator;
import p014it.unimi.dsi.fastutil.doubles.DoubleSpliterators;
import p014it.unimi.dsi.fastutil.floats.FloatCollections;

/* renamed from: it.unimi.dsi.fastutil.floats.FloatSets */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatSets.class */
public final class FloatSets {
    static final int ARRAY_SET_CUTOFF = 4;
    public static final EmptySet EMPTY_SET = new EmptySet();
    static final FloatSet UNMODIFIABLE_EMPTY_SET = unmodifiable(new FloatArraySet(FloatArrays.EMPTY_ARRAY));

    private FloatSets() {
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.FloatSets$EmptySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatSets$EmptySet.class */
    public static class EmptySet extends FloatCollections.EmptyCollection implements FloatSet, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSet
        public boolean remove(float ok) {
            throw new UnsupportedOperationException();
        }

        @Override // java.lang.Object
        public Object clone() {
            return FloatSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.EmptyCollection, java.util.Collection, java.lang.Object
        public boolean equals(Object o) {
            return (o instanceof Set) && ((Set) o).isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        @Deprecated
        public boolean rem(float k) {
            return rem(k);
        }

        private Object readResolve() {
            return FloatSets.EMPTY_SET;
        }
    }

    public static FloatSet emptySet() {
        return EMPTY_SET;
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.FloatSets$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatSets$Singleton.class */
    public static class Singleton extends AbstractFloatSet implements Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final float element;

        /* access modifiers changed from: protected */
        public Singleton(float element) {
            this.element = element;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public boolean contains(float k) {
            return Float.floatToIntBits(k) == Float.floatToIntBits(this.element);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatSet, p014it.unimi.dsi.fastutil.floats.FloatSet
        public boolean remove(float k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatSet, p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
        public FloatListIterator iterator() {
            return FloatIterators.singleton(this.element);
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
        public FloatSpliterator spliterator() {
            return FloatSpliterators.singleton(this.element);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return 1;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public float[] toFloatArray() {
            return new float[]{this.element};
        }

        @Override // java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatIterable
        @Deprecated
        public void forEach(Consumer<? super Float> action) {
            action.accept(Float.valueOf(this.element));
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection<? extends Float> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> c) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        @Deprecated
        public boolean removeIf(Predicate<? super Float> filter) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterable
        public void forEach(FloatConsumer action) {
            action.accept(this.element);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public boolean addAll(FloatCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public boolean removeAll(FloatCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public boolean retainAll(FloatCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollection
        public boolean removeIf(FloatPredicate filter) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
        public DoubleIterator doubleIterator() {
            return DoubleIterators.singleton((double) this.element);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
        public DoubleSpliterator doubleSpliterator() {
            return DoubleSpliterators.singleton((double) this.element);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @Deprecated
        public Object[] toArray() {
            return new Object[]{Float.valueOf(this.element)};
        }

        @Override // java.lang.Object
        public Object clone() {
            return this;
        }
    }

    public static FloatSet singleton(float element) {
        return new Singleton(element);
    }

    public static FloatSet singleton(Float element) {
        return new Singleton(element.floatValue());
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.FloatSets$SynchronizedSet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatSets$SynchronizedSet.class */
    public static class SynchronizedSet extends FloatCollections.SynchronizedCollection implements FloatSet, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.SynchronizedCollection, java.util.Collection, java.lang.Object
        public /* bridge */ /* synthetic */ boolean equals(Object obj) {
            return equals(obj);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.SynchronizedCollection, java.util.Collection, java.lang.Object
        public /* bridge */ /* synthetic */ int hashCode() {
            return hashCode();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.SynchronizedCollection, java.lang.Object
        public /* bridge */ /* synthetic */ String toString() {
            return toString();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ void clear() {
            clear();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public /* bridge */ /* synthetic */ boolean removeIf(FloatPredicate floatPredicate) {
            return removeIf(floatPredicate);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
            return retainAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
            return removeAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean containsAll(Collection collection) {
            return containsAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean addAll(Collection collection) {
            return addAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
        public /* bridge */ /* synthetic */ void forEach(FloatConsumer floatConsumer) {
            forEach(floatConsumer);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ Stream parallelStream() {
            return parallelStream();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ Stream stream() {
            return stream();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatIterable
        public /* bridge */ /* synthetic */ FloatSpliterator spliterator() {
            return spliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatIterable
        public /* bridge */ /* synthetic */ FloatIterator iterator() {
            return iterator();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Object[] toArray(Object[] objArr) {
            return toArray(objArr);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public /* bridge */ /* synthetic */ DoubleStream doubleParallelStream() {
            return doubleParallelStream();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public /* bridge */ /* synthetic */ DoubleStream doubleStream() {
            return doubleStream();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
        public /* bridge */ /* synthetic */ DoubleSpliterator doubleSpliterator() {
            return doubleSpliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
        public /* bridge */ /* synthetic */ DoubleIterator doubleIterator() {
            return doubleIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean remove(Object obj) {
            return remove(obj);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean contains(Object obj) {
            return contains(obj);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean add(Float f) {
            return add(f);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public /* bridge */ /* synthetic */ boolean retainAll(FloatCollection floatCollection) {
            return retainAll(floatCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public /* bridge */ /* synthetic */ boolean removeAll(FloatCollection floatCollection) {
            return removeAll(floatCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public /* bridge */ /* synthetic */ boolean containsAll(FloatCollection floatCollection) {
            return containsAll(floatCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public /* bridge */ /* synthetic */ boolean addAll(FloatCollection floatCollection) {
            return addAll(floatCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public /* bridge */ /* synthetic */ float[] toArray(float[] fArr) {
            return toArray(fArr);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        @Deprecated
        public /* bridge */ /* synthetic */ float[] toFloatArray(float[] fArr) {
            return toFloatArray(fArr);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Object[] toArray() {
            return toArray();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public /* bridge */ /* synthetic */ float[] toFloatArray() {
            return toFloatArray();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean isEmpty() {
            return isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.SynchronizedCollection, java.util.Collection, p014it.unimi.dsi.fastutil.BigList, p014it.unimi.dsi.fastutil.Size64
        public /* bridge */ /* synthetic */ int size() {
            return size();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public /* bridge */ /* synthetic */ boolean contains(float f) {
            return contains(f);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public /* bridge */ /* synthetic */ boolean add(float f) {
            return add(f);
        }

        /* access modifiers changed from: protected */
        public SynchronizedSet(FloatSet s, Object sync) {
            super(s, sync);
        }

        /* access modifiers changed from: protected */
        public SynchronizedSet(FloatSet s) {
            super(s);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSet
        public boolean remove(float k) {
            boolean rem;
            synchronized (this.sync) {
                rem = this.collection.rem(k);
            }
            return rem;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        @Deprecated
        public boolean rem(float k) {
            return rem(k);
        }
    }

    public static FloatSet synchronize(FloatSet s) {
        return new SynchronizedSet(s);
    }

    public static FloatSet synchronize(FloatSet s, Object sync) {
        return new SynchronizedSet(s, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.FloatSets$UnmodifiableSet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatSets$UnmodifiableSet.class */
    public static class UnmodifiableSet extends FloatCollections.UnmodifiableCollection implements FloatSet, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.UnmodifiableCollection, java.lang.Object
        public /* bridge */ /* synthetic */ String toString() {
            return toString();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public /* bridge */ /* synthetic */ DoubleStream doubleParallelStream() {
            return doubleParallelStream();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public /* bridge */ /* synthetic */ DoubleStream doubleStream() {
            return doubleStream();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
        public /* bridge */ /* synthetic */ DoubleSpliterator doubleSpliterator() {
            return doubleSpliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
        public /* bridge */ /* synthetic */ DoubleIterator doubleIterator() {
            return doubleIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public /* bridge */ /* synthetic */ boolean retainAll(FloatCollection floatCollection) {
            return retainAll(floatCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public /* bridge */ /* synthetic */ boolean removeAll(FloatCollection floatCollection) {
            return removeAll(floatCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public /* bridge */ /* synthetic */ boolean addAll(FloatCollection floatCollection) {
            return addAll(floatCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public /* bridge */ /* synthetic */ boolean containsAll(FloatCollection floatCollection) {
            return containsAll(floatCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public /* bridge */ /* synthetic */ float[] toArray(float[] fArr) {
            return toArray(fArr);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        @Deprecated
        public /* bridge */ /* synthetic */ float[] toFloatArray(float[] fArr) {
            return toFloatArray(fArr);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public /* bridge */ /* synthetic */ float[] toFloatArray() {
            return toFloatArray();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean remove(Object obj) {
            return remove(obj);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean contains(Object obj) {
            return contains(obj);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean add(Float f) {
            return add(f);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public /* bridge */ /* synthetic */ boolean removeIf(FloatPredicate floatPredicate) {
            return removeIf(floatPredicate);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
            return retainAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
            return removeAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean addAll(Collection collection) {
            return addAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean containsAll(Collection collection) {
            return containsAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
        public /* bridge */ /* synthetic */ void forEach(FloatConsumer floatConsumer) {
            forEach(floatConsumer);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Object[] toArray() {
            return toArray();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Object[] toArray(Object[] objArr) {
            return toArray(objArr);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ void clear() {
            clear();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ Stream parallelStream() {
            return parallelStream();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ Stream stream() {
            return stream();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatIterable
        public /* bridge */ /* synthetic */ FloatSpliterator spliterator() {
            return spliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatIterable
        public /* bridge */ /* synthetic */ FloatIterator iterator() {
            return iterator();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public /* bridge */ /* synthetic */ boolean contains(float f) {
            return contains(f);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean isEmpty() {
            return isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.UnmodifiableCollection, java.util.Collection, p014it.unimi.dsi.fastutil.BigList, p014it.unimi.dsi.fastutil.Size64
        public /* bridge */ /* synthetic */ int size() {
            return size();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public /* bridge */ /* synthetic */ boolean add(float f) {
            return add(f);
        }

        /* access modifiers changed from: protected */
        public UnmodifiableSet(FloatSet s) {
            super(s);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSet
        public boolean remove(float k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.UnmodifiableCollection, java.util.Collection, java.lang.Object
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            return this.collection.equals(o);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.UnmodifiableCollection, java.util.Collection, java.lang.Object
        public int hashCode() {
            return this.collection.hashCode();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        @Deprecated
        public boolean rem(float k) {
            return rem(k);
        }
    }

    public static FloatSet unmodifiable(FloatSet s) {
        return new UnmodifiableSet(s);
    }
}
