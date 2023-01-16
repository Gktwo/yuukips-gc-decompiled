package p014it.unimi.dsi.fastutil.objects;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;
import p014it.unimi.dsi.fastutil.objects.ObjectCollections;

/* renamed from: it.unimi.dsi.fastutil.objects.ObjectSets */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectSets.class */
public final class ObjectSets {
    static final int ARRAY_SET_CUTOFF = 4;
    public static final EmptySet EMPTY_SET = new EmptySet();
    static final ObjectSet UNMODIFIABLE_EMPTY_SET = unmodifiable(new ObjectArraySet(ObjectArrays.EMPTY_ARRAY));

    private ObjectSets() {
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.ObjectSets$EmptySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectSets$EmptySet.class */
    public static class EmptySet<K> extends ObjectCollections.EmptyCollection<K> implements ObjectSet<K>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object ok) {
            throw new UnsupportedOperationException();
        }

        @Override // java.lang.Object
        public Object clone() {
            return ObjectSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectCollections.EmptyCollection, java.util.Collection, java.lang.Object
        public boolean equals(Object o) {
            return (o instanceof Set) && ((Set) o).isEmpty();
        }

        private Object readResolve() {
            return ObjectSets.EMPTY_SET;
        }
    }

    public static <K> ObjectSet<K> emptySet() {
        return EMPTY_SET;
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.ObjectSets$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectSets$Singleton.class */
    public static class Singleton<K> extends AbstractObjectSet<K> implements Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final K element;

        /* access modifiers changed from: protected */
        public Singleton(K element) {
            this.element = element;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object k) {
            return Objects.equals(k, this.element);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectListIterator<K> iterator() {
            return ObjectIterators.singleton(this.element);
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<K> spliterator() {
            return ObjectSpliterators.singleton(this.element);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return 1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return new Object[]{this.element};
        }

        /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: K, ? super K */
        @Override // java.lang.Iterable
        public void forEach(Consumer<? super K> action) {
            action.accept((K) this.element);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean addAll(Collection<? extends K> c) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> c) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> c) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public boolean removeIf(Predicate<? super K> filter) {
            throw new UnsupportedOperationException();
        }

        @Override // java.lang.Object
        public Object clone() {
            return this;
        }
    }

    public static <K> ObjectSet<K> singleton(K element) {
        return new Singleton(element);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.ObjectSets$SynchronizedSet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectSets$SynchronizedSet.class */
    public static class SynchronizedSet<K> extends ObjectCollections.SynchronizedCollection<K> implements ObjectSet<K>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectCollections.SynchronizedCollection, java.util.Collection, java.lang.Object
        public /* bridge */ /* synthetic */ boolean equals(Object obj) {
            return equals(obj);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectCollections.SynchronizedCollection, java.util.Collection, java.lang.Object
        public /* bridge */ /* synthetic */ int hashCode() {
            return hashCode();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectCollections.SynchronizedCollection, java.lang.Object
        public /* bridge */ /* synthetic */ String toString() {
            return toString();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ void clear() {
            clear();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean removeIf(Predicate predicate) {
            return removeIf(predicate);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
            return retainAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
            return removeAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean containsAll(Collection collection) {
            return containsAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean addAll(Collection collection) {
            return addAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectCollections.SynchronizedCollection, java.lang.Iterable
        public /* bridge */ /* synthetic */ void forEach(Consumer consumer) {
            forEach(consumer);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Stream parallelStream() {
            return parallelStream();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Stream stream() {
            return stream();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.objects.ObjectCollection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public /* bridge */ /* synthetic */ ObjectSpliterator spliterator() {
            return spliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.objects.ObjectCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public /* bridge */ /* synthetic */ ObjectIterator iterator() {
            return iterator();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Object[] toArray(Object[] objArr) {
            return toArray(objArr);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Object[] toArray() {
            return toArray();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean isEmpty() {
            return isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectCollections.SynchronizedCollection, java.util.Collection, p014it.unimi.dsi.fastutil.BigList, p014it.unimi.dsi.fastutil.Size64
        public /* bridge */ /* synthetic */ int size() {
            return size();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean contains(Object obj) {
            return contains(obj);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.ObjectCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean add(Object obj) {
            return add(obj);
        }

        /* access modifiers changed from: protected */
        public SynchronizedSet(ObjectSet<K> s, Object sync) {
            super(s, sync);
        }

        /* access modifiers changed from: protected */
        public SynchronizedSet(ObjectSet<K> s) {
            super(s);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectCollections.SynchronizedCollection, java.util.Collection
        public boolean remove(Object k) {
            boolean remove;
            synchronized (this.sync) {
                remove = this.collection.remove(k);
            }
            return remove;
        }
    }

    public static <K> ObjectSet<K> synchronize(ObjectSet<K> s) {
        return new SynchronizedSet(s);
    }

    public static <K> ObjectSet<K> synchronize(ObjectSet<K> s, Object sync) {
        return new SynchronizedSet(s, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.ObjectSets$UnmodifiableSet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectSets$UnmodifiableSet.class */
    public static class UnmodifiableSet<K> extends ObjectCollections.UnmodifiableCollection<K> implements ObjectSet<K>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectCollections.UnmodifiableCollection, java.lang.Object
        public /* bridge */ /* synthetic */ String toString() {
            return toString();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean removeIf(Predicate predicate) {
            return removeIf(predicate);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
            return retainAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
            return removeAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean addAll(Collection collection) {
            return addAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean containsAll(Collection collection) {
            return containsAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectCollections.UnmodifiableCollection, java.lang.Iterable
        public /* bridge */ /* synthetic */ void forEach(Consumer consumer) {
            forEach(consumer);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Object[] toArray() {
            return toArray();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Object[] toArray(Object[] objArr) {
            return toArray(objArr);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ void clear() {
            clear();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Stream parallelStream() {
            return parallelStream();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Stream stream() {
            return stream();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.objects.ObjectCollection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public /* bridge */ /* synthetic */ ObjectSpliterator spliterator() {
            return spliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.objects.ObjectCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public /* bridge */ /* synthetic */ ObjectIterator iterator() {
            return iterator();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean contains(Object obj) {
            return contains(obj);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean isEmpty() {
            return isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectCollections.UnmodifiableCollection, java.util.Collection, p014it.unimi.dsi.fastutil.BigList, p014it.unimi.dsi.fastutil.Size64
        public /* bridge */ /* synthetic */ int size() {
            return size();
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.ObjectCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean add(Object obj) {
            return add(obj);
        }

        /* access modifiers changed from: protected */
        public UnmodifiableSet(ObjectSet<? extends K> s) {
            super(s);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectCollections.UnmodifiableCollection, java.util.Collection
        public boolean remove(Object k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectCollections.UnmodifiableCollection, java.util.Collection, java.lang.Object
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            return this.collection.equals(o);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectCollections.UnmodifiableCollection, java.util.Collection, java.lang.Object
        public int hashCode() {
            return this.collection.hashCode();
        }
    }

    public static <K> ObjectSet<K> unmodifiable(ObjectSet<? extends K> s) {
        return new UnmodifiableSet(s);
    }
}
