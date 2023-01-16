package p014it.unimi.dsi.fastutil.objects;

import java.io.Serializable;
import java.util.Comparator;
import java.util.NoSuchElementException;
import p014it.unimi.dsi.fastutil.objects.ObjectSets;

/* renamed from: it.unimi.dsi.fastutil.objects.ObjectSortedSets */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectSortedSets.class */
public final class ObjectSortedSets {
    public static final EmptySet EMPTY_SET = new EmptySet();

    private ObjectSortedSets() {
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.ObjectSortedSets$EmptySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectSortedSets$EmptySet.class */
    public static class EmptySet<K> extends ObjectSets.EmptySet<K> implements ObjectSortedSet<K>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSortedSet
        public ObjectBidirectionalIterator<K> iterator(K from) {
            return ObjectIterators.EMPTY_ITERATOR;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSortedSet, java.util.SortedSet
        public ObjectSortedSet<K> subSet(K from, K to) {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSortedSet, java.util.SortedSet
        public ObjectSortedSet<K> headSet(K from) {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSortedSet, java.util.SortedSet
        public ObjectSortedSet<K> tailSet(K to) {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // java.util.SortedSet
        public K first() {
            throw new NoSuchElementException();
        }

        @Override // java.util.SortedSet
        public K last() {
            throw new NoSuchElementException();
        }

        @Override // java.util.SortedSet
        public Comparator<? super K> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSets.EmptySet, java.lang.Object
        public Object clone() {
            return ObjectSortedSets.EMPTY_SET;
        }

        private Object readResolve() {
            return ObjectSortedSets.EMPTY_SET;
        }
    }

    public static <K> ObjectSet<K> emptySet() {
        return EMPTY_SET;
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.ObjectSortedSets$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectSortedSets$Singleton.class */
    public static class Singleton<K> extends ObjectSets.Singleton<K> implements ObjectSortedSet<K>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        final Comparator<? super K> comparator;

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSets.Singleton, p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public /* bridge */ /* synthetic */ ObjectBidirectionalIterator iterator() {
            return iterator();
        }

        protected Singleton(K element, Comparator<? super K> comparator) {
            super(element);
            this.comparator = comparator;
        }

        Singleton(K element) {
            this(element, null);
        }

        final int compare(K k1, K k2) {
            return this.comparator == null ? ((Comparable) k1).compareTo(k2) : this.comparator.compare(k1, k2);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: it.unimi.dsi.fastutil.objects.ObjectSortedSets$Singleton<K> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSortedSet
        public ObjectBidirectionalIterator<K> iterator(K from) {
            ObjectBidirectionalIterator<K> i = iterator();
            if (compare(this.element, from) <= 0) {
                i.next();
            }
            return i;
        }

        @Override // java.util.SortedSet
        public Comparator<? super K> comparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSets.Singleton, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<K> spliterator() {
            return ObjectSpliterators.singleton(this.element, this.comparator);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: it.unimi.dsi.fastutil.objects.ObjectSortedSets$Singleton<K> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSortedSet, java.util.SortedSet
        public ObjectSortedSet<K> subSet(K from, K to) {
            return (compare(from, this.element) > 0 || compare(this.element, to) >= 0) ? ObjectSortedSets.EMPTY_SET : this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: it.unimi.dsi.fastutil.objects.ObjectSortedSets$Singleton<K> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSortedSet, java.util.SortedSet
        public ObjectSortedSet<K> headSet(K to) {
            return compare(this.element, to) < 0 ? this : ObjectSortedSets.EMPTY_SET;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: it.unimi.dsi.fastutil.objects.ObjectSortedSets$Singleton<K> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSortedSet, java.util.SortedSet
        public ObjectSortedSet<K> tailSet(K from) {
            return compare(from, this.element) <= 0 ? this : ObjectSortedSets.EMPTY_SET;
        }

        @Override // java.util.SortedSet
        public K first() {
            return (K) this.element;
        }

        @Override // java.util.SortedSet
        public K last() {
            return (K) this.element;
        }
    }

    public static <K> ObjectSortedSet<K> singleton(K element) {
        return new Singleton(element);
    }

    public static <K> ObjectSortedSet<K> singleton(K element, Comparator<? super K> comparator) {
        return new Singleton(element, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.ObjectSortedSets$SynchronizedSortedSet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectSortedSets$SynchronizedSortedSet.class */
    public static class SynchronizedSortedSet<K> extends ObjectSets.SynchronizedSet<K> implements ObjectSortedSet<K>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final ObjectSortedSet<K> sortedSet;

        protected SynchronizedSortedSet(ObjectSortedSet<K> s, Object sync) {
            super(s, sync);
            this.sortedSet = s;
        }

        protected SynchronizedSortedSet(ObjectSortedSet<K> s) {
            super(s);
            this.sortedSet = s;
        }

        @Override // java.util.SortedSet
        public Comparator<? super K> comparator() {
            Comparator<? super K> comparator;
            synchronized (this.sync) {
                comparator = this.sortedSet.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSortedSet, java.util.SortedSet
        public ObjectSortedSet<K> subSet(K from, K to) {
            return new SynchronizedSortedSet(this.sortedSet.subSet((Object) from, (Object) to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSortedSet, java.util.SortedSet
        public ObjectSortedSet<K> headSet(K to) {
            return new SynchronizedSortedSet(this.sortedSet.headSet((ObjectSortedSet<K>) to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSortedSet, java.util.SortedSet
        public ObjectSortedSet<K> tailSet(K from) {
            return new SynchronizedSortedSet(this.sortedSet.tailSet((ObjectSortedSet<K>) from), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSets.SynchronizedSet, p014it.unimi.dsi.fastutil.objects.ObjectCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.objects.ObjectCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectBidirectionalIterator<K> iterator() {
            return this.sortedSet.iterator();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSortedSet
        public ObjectBidirectionalIterator<K> iterator(K from) {
            return this.sortedSet.iterator(from);
        }

        @Override // java.util.SortedSet
        public K first() {
            K first;
            synchronized (this.sync) {
                first = this.sortedSet.first();
            }
            return first;
        }

        @Override // java.util.SortedSet
        public K last() {
            K last;
            synchronized (this.sync) {
                last = this.sortedSet.last();
            }
            return last;
        }
    }

    public static <K> ObjectSortedSet<K> synchronize(ObjectSortedSet<K> s) {
        return new SynchronizedSortedSet(s);
    }

    public static <K> ObjectSortedSet<K> synchronize(ObjectSortedSet<K> s, Object sync) {
        return new SynchronizedSortedSet(s, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.ObjectSortedSets$UnmodifiableSortedSet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectSortedSets$UnmodifiableSortedSet.class */
    public static class UnmodifiableSortedSet<K> extends ObjectSets.UnmodifiableSet<K> implements ObjectSortedSet<K>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final ObjectSortedSet<K> sortedSet;

        protected UnmodifiableSortedSet(ObjectSortedSet<K> s) {
            super(s);
            this.sortedSet = s;
        }

        @Override // java.util.SortedSet
        public Comparator<? super K> comparator() {
            return this.sortedSet.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSortedSet, java.util.SortedSet
        public ObjectSortedSet<K> subSet(K from, K to) {
            return new UnmodifiableSortedSet(this.sortedSet.subSet((Object) from, (Object) to));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSortedSet, java.util.SortedSet
        public ObjectSortedSet<K> headSet(K to) {
            return new UnmodifiableSortedSet(this.sortedSet.headSet((ObjectSortedSet<K>) to));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSortedSet, java.util.SortedSet
        public ObjectSortedSet<K> tailSet(K from) {
            return new UnmodifiableSortedSet(this.sortedSet.tailSet((ObjectSortedSet<K>) from));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSets.UnmodifiableSet, p014it.unimi.dsi.fastutil.objects.ObjectCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.objects.ObjectCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectBidirectionalIterator<K> iterator() {
            return ObjectIterators.unmodifiable((ObjectBidirectionalIterator) this.sortedSet.iterator());
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSortedSet
        public ObjectBidirectionalIterator<K> iterator(K from) {
            return ObjectIterators.unmodifiable((ObjectBidirectionalIterator) this.sortedSet.iterator(from));
        }

        @Override // java.util.SortedSet
        public K first() {
            return this.sortedSet.first();
        }

        @Override // java.util.SortedSet
        public K last() {
            return this.sortedSet.last();
        }
    }

    public static <K> ObjectSortedSet<K> unmodifiable(ObjectSortedSet<K> s) {
        return new UnmodifiableSortedSet(s);
    }
}
