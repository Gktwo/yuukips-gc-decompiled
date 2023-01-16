package p014it.unimi.dsi.fastutil.booleans;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;
import p014it.unimi.dsi.fastutil.booleans.BooleanCollections;

/* renamed from: it.unimi.dsi.fastutil.booleans.BooleanSets */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanSets.class */
public final class BooleanSets {
    static final int ARRAY_SET_CUTOFF = 4;
    public static final EmptySet EMPTY_SET = new EmptySet();
    static final BooleanSet UNMODIFIABLE_EMPTY_SET = unmodifiable(new BooleanArraySet(BooleanArrays.EMPTY_ARRAY));

    private BooleanSets() {
    }

    /* renamed from: it.unimi.dsi.fastutil.booleans.BooleanSets$EmptySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanSets$EmptySet.class */
    public static class EmptySet extends BooleanCollections.EmptyCollection implements BooleanSet, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanSet
        public boolean remove(boolean ok) {
            throw new UnsupportedOperationException();
        }

        @Override // java.lang.Object
        public Object clone() {
            return BooleanSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.EmptyCollection, java.util.Collection, java.lang.Object
        public boolean equals(Object o) {
            return (o instanceof Set) && ((Set) o).isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        @Deprecated
        public boolean rem(boolean k) {
            return rem(k);
        }

        private Object readResolve() {
            return BooleanSets.EMPTY_SET;
        }
    }

    public static BooleanSet emptySet() {
        return EMPTY_SET;
    }

    /* renamed from: it.unimi.dsi.fastutil.booleans.BooleanSets$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanSets$Singleton.class */
    public static class Singleton extends AbstractBooleanSet implements Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final boolean element;

        protected Singleton(boolean element) {
            this.element = element;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        public boolean contains(boolean k) {
            return k == this.element;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanSet, p014it.unimi.dsi.fastutil.booleans.BooleanSet
        public boolean remove(boolean k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanSet, p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.booleans.BooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanIterable, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public BooleanListIterator iterator() {
            return BooleanIterators.singleton(this.element);
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.booleans.BooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanIterable, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public BooleanSpliterator spliterator() {
            return BooleanSpliterators.singleton(this.element);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return 1;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        public boolean[] toBooleanArray() {
            return new boolean[]{this.element};
        }

        @Override // java.lang.Iterable, p014it.unimi.dsi.fastutil.booleans.BooleanIterable
        @Deprecated
        public void forEach(Consumer<? super Boolean> action) {
            action.accept(Boolean.valueOf(this.element));
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection<? extends Boolean> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> c) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        @Deprecated
        public boolean removeIf(Predicate<? super Boolean> filter) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterable
        public void forEach(BooleanConsumer action) {
            action.accept(this.element);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        public boolean addAll(BooleanCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        public boolean removeAll(BooleanCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        public boolean retainAll(BooleanCollection c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        public boolean removeIf(BooleanPredicate filter) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @Deprecated
        public Object[] toArray() {
            return new Object[]{Boolean.valueOf(this.element)};
        }

        @Override // java.lang.Object
        public Object clone() {
            return this;
        }
    }

    public static BooleanSet singleton(boolean element) {
        return new Singleton(element);
    }

    public static BooleanSet singleton(Boolean element) {
        return new Singleton(element.booleanValue());
    }

    /* renamed from: it.unimi.dsi.fastutil.booleans.BooleanSets$SynchronizedSet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanSets$SynchronizedSet.class */
    public static class SynchronizedSet extends BooleanCollections.SynchronizedCollection implements BooleanSet, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.SynchronizedCollection, java.util.Collection, java.lang.Object
        public /* bridge */ /* synthetic */ boolean equals(Object obj) {
            return equals(obj);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.SynchronizedCollection, java.util.Collection, java.lang.Object
        public /* bridge */ /* synthetic */ int hashCode() {
            return hashCode();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.SynchronizedCollection, java.lang.Object
        public /* bridge */ /* synthetic */ String toString() {
            return toString();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ void clear() {
            clear();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        public /* bridge */ /* synthetic */ boolean removeIf(BooleanPredicate booleanPredicate) {
            return removeIf(booleanPredicate);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
            return retainAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
            return removeAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean containsAll(Collection collection) {
            return containsAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean addAll(Collection collection) {
            return addAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.booleans.BooleanIterable
        public /* bridge */ /* synthetic */ void forEach(BooleanConsumer booleanConsumer) {
            forEach(booleanConsumer);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Stream parallelStream() {
            return parallelStream();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Stream stream() {
            return stream();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection, java.lang.Iterable, p014it.unimi.dsi.fastutil.booleans.BooleanIterable, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public /* bridge */ /* synthetic */ BooleanSpliterator spliterator() {
            return spliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.booleans.BooleanIterable, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public /* bridge */ /* synthetic */ BooleanIterator iterator() {
            return iterator();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Object[] toArray(Object[] objArr) {
            return toArray(objArr);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean remove(Object obj) {
            return remove(obj);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean contains(Object obj) {
            return contains(obj);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean add(Boolean bool) {
            return add(bool);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        public /* bridge */ /* synthetic */ boolean retainAll(BooleanCollection booleanCollection) {
            return retainAll(booleanCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        public /* bridge */ /* synthetic */ boolean removeAll(BooleanCollection booleanCollection) {
            return removeAll(booleanCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        public /* bridge */ /* synthetic */ boolean containsAll(BooleanCollection booleanCollection) {
            return containsAll(booleanCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        public /* bridge */ /* synthetic */ boolean addAll(BooleanCollection booleanCollection) {
            return addAll(booleanCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        public /* bridge */ /* synthetic */ boolean[] toArray(boolean[] zArr) {
            return toArray(zArr);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean[] toBooleanArray(boolean[] zArr) {
            return toBooleanArray(zArr);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Object[] toArray() {
            return toArray();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        public /* bridge */ /* synthetic */ boolean[] toBooleanArray() {
            return toBooleanArray();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean isEmpty() {
            return isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.SynchronizedCollection, java.util.Collection, p014it.unimi.dsi.fastutil.BigList, p014it.unimi.dsi.fastutil.Size64
        public /* bridge */ /* synthetic */ int size() {
            return size();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        public /* bridge */ /* synthetic */ boolean contains(boolean z) {
            return contains(z);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        public /* bridge */ /* synthetic */ boolean add(boolean z) {
            return add(z);
        }

        protected SynchronizedSet(BooleanSet s, Object sync) {
            super(s, sync);
        }

        protected SynchronizedSet(BooleanSet s) {
            super(s);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanSet
        public boolean remove(boolean k) {
            boolean rem;
            synchronized (this.sync) {
                rem = this.collection.rem(k);
            }
            return rem;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        @Deprecated
        public boolean rem(boolean k) {
            return rem(k);
        }
    }

    public static BooleanSet synchronize(BooleanSet s) {
        return new SynchronizedSet(s);
    }

    public static BooleanSet synchronize(BooleanSet s, Object sync) {
        return new SynchronizedSet(s, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.booleans.BooleanSets$UnmodifiableSet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanSets$UnmodifiableSet.class */
    public static class UnmodifiableSet extends BooleanCollections.UnmodifiableCollection implements BooleanSet, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.UnmodifiableCollection, java.lang.Object
        public /* bridge */ /* synthetic */ String toString() {
            return toString();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        public /* bridge */ /* synthetic */ boolean retainAll(BooleanCollection booleanCollection) {
            return retainAll(booleanCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        public /* bridge */ /* synthetic */ boolean removeAll(BooleanCollection booleanCollection) {
            return removeAll(booleanCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        public /* bridge */ /* synthetic */ boolean addAll(BooleanCollection booleanCollection) {
            return addAll(booleanCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        public /* bridge */ /* synthetic */ boolean containsAll(BooleanCollection booleanCollection) {
            return containsAll(booleanCollection);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        public /* bridge */ /* synthetic */ boolean[] toArray(boolean[] zArr) {
            return toArray(zArr);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean[] toBooleanArray(boolean[] zArr) {
            return toBooleanArray(zArr);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        public /* bridge */ /* synthetic */ boolean[] toBooleanArray() {
            return toBooleanArray();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean remove(Object obj) {
            return remove(obj);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection, java.util.Collection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean contains(Object obj) {
            return contains(obj);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        @Deprecated
        public /* bridge */ /* synthetic */ boolean add(Boolean bool) {
            return add(bool);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        public /* bridge */ /* synthetic */ boolean removeIf(BooleanPredicate booleanPredicate) {
            return removeIf(booleanPredicate);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
            return retainAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
            return removeAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean addAll(Collection collection) {
            return addAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean containsAll(Collection collection) {
            return containsAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.booleans.BooleanIterable
        public /* bridge */ /* synthetic */ void forEach(BooleanConsumer booleanConsumer) {
            forEach(booleanConsumer);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Object[] toArray() {
            return toArray();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Object[] toArray(Object[] objArr) {
            return toArray(objArr);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ void clear() {
            clear();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Stream parallelStream() {
            return parallelStream();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Stream stream() {
            return stream();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection, java.lang.Iterable, p014it.unimi.dsi.fastutil.booleans.BooleanIterable, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public /* bridge */ /* synthetic */ BooleanSpliterator spliterator() {
            return spliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.booleans.BooleanIterable, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public /* bridge */ /* synthetic */ BooleanIterator iterator() {
            return iterator();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        public /* bridge */ /* synthetic */ boolean contains(boolean z) {
            return contains(z);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean isEmpty() {
            return isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.UnmodifiableCollection, java.util.Collection, p014it.unimi.dsi.fastutil.BigList, p014it.unimi.dsi.fastutil.Size64
        public /* bridge */ /* synthetic */ int size() {
            return size();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        public /* bridge */ /* synthetic */ boolean add(boolean z) {
            return add(z);
        }

        protected UnmodifiableSet(BooleanSet s) {
            super(s);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanSet
        public boolean remove(boolean k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.UnmodifiableCollection, java.util.Collection, java.lang.Object
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            return this.collection.equals(o);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.UnmodifiableCollection, java.util.Collection, java.lang.Object
        public int hashCode() {
            return this.collection.hashCode();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        @Deprecated
        public boolean rem(boolean k) {
            return rem(k);
        }
    }

    public static BooleanSet unmodifiable(BooleanSet s) {
        return new UnmodifiableSet(s);
    }
}
