package p014it.unimi.dsi.fastutil.objects;

import java.io.Serializable;
import java.util.Comparator;
import java.util.NoSuchElementException;
import p014it.unimi.dsi.fastutil.objects.ReferenceSets;

/* renamed from: it.unimi.dsi.fastutil.objects.ReferenceSortedSets */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ReferenceSortedSets.class */
public final class ReferenceSortedSets {
    public static final EmptySet EMPTY_SET = new EmptySet();

    private ReferenceSortedSets() {
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.ReferenceSortedSets$EmptySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ReferenceSortedSets$EmptySet.class */
    public static class EmptySet<K> extends ReferenceSets.EmptySet<K> implements ReferenceSortedSet<K>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceSortedSet
        public ObjectBidirectionalIterator<K> iterator(K from) {
            return ObjectIterators.EMPTY_ITERATOR;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceSortedSet, java.util.SortedSet
        public ReferenceSortedSet<K> subSet(K from, K to) {
            return ReferenceSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceSortedSet, java.util.SortedSet
        public ReferenceSortedSet<K> headSet(K from) {
            return ReferenceSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceSortedSet, java.util.SortedSet
        public ReferenceSortedSet<K> tailSet(K to) {
            return ReferenceSortedSets.EMPTY_SET;
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

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceSets.EmptySet, java.lang.Object
        public Object clone() {
            return ReferenceSortedSets.EMPTY_SET;
        }

        private Object readResolve() {
            return ReferenceSortedSets.EMPTY_SET;
        }
    }

    public static <K> ReferenceSet<K> emptySet() {
        return EMPTY_SET;
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.ReferenceSortedSets$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ReferenceSortedSets$Singleton.class */
    public static class Singleton<K> extends ReferenceSets.Singleton<K> implements ReferenceSortedSet<K>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        final Comparator<? super K> comparator;

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceSets.Singleton, p014it.unimi.dsi.fastutil.objects.AbstractReferenceSet, p014it.unimi.dsi.fastutil.objects.AbstractReferenceCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection
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

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: it.unimi.dsi.fastutil.objects.ReferenceSortedSets$Singleton<K> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceSortedSet
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

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceSets.Singleton, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<K> spliterator() {
            return ObjectSpliterators.singleton(this.element, this.comparator);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: it.unimi.dsi.fastutil.objects.ReferenceSortedSets$Singleton<K> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceSortedSet, java.util.SortedSet
        public ReferenceSortedSet<K> subSet(K from, K to) {
            return (compare(from, this.element) > 0 || compare(this.element, to) >= 0) ? ReferenceSortedSets.EMPTY_SET : this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: it.unimi.dsi.fastutil.objects.ReferenceSortedSets$Singleton<K> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceSortedSet, java.util.SortedSet
        public ReferenceSortedSet<K> headSet(K to) {
            return compare(this.element, to) < 0 ? this : ReferenceSortedSets.EMPTY_SET;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: it.unimi.dsi.fastutil.objects.ReferenceSortedSets$Singleton<K> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceSortedSet, java.util.SortedSet
        public ReferenceSortedSet<K> tailSet(K from) {
            return compare(from, this.element) <= 0 ? this : ReferenceSortedSets.EMPTY_SET;
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

    public static <K> ReferenceSortedSet<K> singleton(K element) {
        return new Singleton(element);
    }

    public static <K> ReferenceSortedSet<K> singleton(K element, Comparator<? super K> comparator) {
        return new Singleton(element, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.ReferenceSortedSets$SynchronizedSortedSet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ReferenceSortedSets$SynchronizedSortedSet.class */
    public static class SynchronizedSortedSet<K> extends ReferenceSets.SynchronizedSet<K> implements ReferenceSortedSet<K>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final ReferenceSortedSet<K> sortedSet;

        protected SynchronizedSortedSet(ReferenceSortedSet<K> s, Object sync) {
            super(s, sync);
            this.sortedSet = s;
        }

        protected SynchronizedSortedSet(ReferenceSortedSet<K> s) {
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

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceSortedSet, java.util.SortedSet
        public ReferenceSortedSet<K> subSet(K from, K to) {
            return new SynchronizedSortedSet(this.sortedSet.subSet((Object) from, (Object) to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceSortedSet, java.util.SortedSet
        public ReferenceSortedSet<K> headSet(K to) {
            return new SynchronizedSortedSet(this.sortedSet.headSet((ReferenceSortedSet<K>) to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceSortedSet, java.util.SortedSet
        public ReferenceSortedSet<K> tailSet(K from) {
            return new SynchronizedSortedSet(this.sortedSet.tailSet((ReferenceSortedSet<K>) from), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceSets.SynchronizedSet, p014it.unimi.dsi.fastutil.objects.ReferenceCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection
        public ObjectBidirectionalIterator<K> iterator() {
            return this.sortedSet.iterator();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceSortedSet
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

    public static <K> ReferenceSortedSet<K> synchronize(ReferenceSortedSet<K> s) {
        return new SynchronizedSortedSet(s);
    }

    public static <K> ReferenceSortedSet<K> synchronize(ReferenceSortedSet<K> s, Object sync) {
        return new SynchronizedSortedSet(s, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.ReferenceSortedSets$UnmodifiableSortedSet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ReferenceSortedSets$UnmodifiableSortedSet.class */
    public static class UnmodifiableSortedSet<K> extends ReferenceSets.UnmodifiableSet<K> implements ReferenceSortedSet<K>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final ReferenceSortedSet<K> sortedSet;

        protected UnmodifiableSortedSet(ReferenceSortedSet<K> s) {
            super(s);
            this.sortedSet = s;
        }

        @Override // java.util.SortedSet
        public Comparator<? super K> comparator() {
            return this.sortedSet.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceSortedSet, java.util.SortedSet
        public ReferenceSortedSet<K> subSet(K from, K to) {
            return new UnmodifiableSortedSet(this.sortedSet.subSet((Object) from, (Object) to));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceSortedSet, java.util.SortedSet
        public ReferenceSortedSet<K> headSet(K to) {
            return new UnmodifiableSortedSet(this.sortedSet.headSet((ReferenceSortedSet<K>) to));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceSortedSet, java.util.SortedSet
        public ReferenceSortedSet<K> tailSet(K from) {
            return new UnmodifiableSortedSet(this.sortedSet.tailSet((ReferenceSortedSet<K>) from));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceSets.UnmodifiableSet, p014it.unimi.dsi.fastutil.objects.ReferenceCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection
        public ObjectBidirectionalIterator<K> iterator() {
            return ObjectIterators.unmodifiable((ObjectBidirectionalIterator) this.sortedSet.iterator());
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceSortedSet
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

    public static <K> ReferenceSortedSet<K> unmodifiable(ReferenceSortedSet<K> s) {
        return new UnmodifiableSortedSet(s);
    }
}
