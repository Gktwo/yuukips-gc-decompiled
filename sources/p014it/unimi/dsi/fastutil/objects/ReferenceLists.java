package p014it.unimi.dsi.fastutil.objects;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.RandomAccess;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;
import okhttp3.HttpUrl;
import p014it.unimi.dsi.fastutil.objects.ReferenceCollections;

/* renamed from: it.unimi.dsi.fastutil.objects.ReferenceLists */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ReferenceLists.class */
public final class ReferenceLists {
    public static final EmptyList EMPTY_LIST = new EmptyList();

    private ReferenceLists() {
    }

    public static <K> ReferenceList<K> shuffle(ReferenceList<K> l, Random random) {
        int i = l.size();
        while (true) {
            i--;
            if (i == 0) {
                return l;
            }
            int p = random.nextInt(i + 1);
            K t = l.get(i);
            l.set(i, l.get(p));
            l.set(p, t);
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.ReferenceLists$EmptyList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ReferenceLists$EmptyList.class */
    public static class EmptyList<K> extends ReferenceCollections.EmptyCollection<K> implements ReferenceList<K>, RandomAccess, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptyList() {
        }

        @Override // java.util.List
        public K get(int i) {
            throw new IndexOutOfBoundsException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean remove(Object k) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.List
        public K remove(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.List
        public void add(int index, K k) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.List
        public K set(int index, K k) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.List
        public int indexOf(Object k) {
            return -1;
        }

        @Override // java.util.List
        public int lastIndexOf(Object k) {
            return -1;
        }

        @Override // java.util.List
        public boolean addAll(int i, Collection<? extends K> c) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.List
        public void replaceAll(UnaryOperator<K> operator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceList, java.util.List
        public void sort(Comparator<? super K> comparator) {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceList
        public void unstableSort(Comparator<? super K> comparator) {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceList, java.util.List
        public ObjectListIterator<K> listIterator() {
            return ObjectIterators.EMPTY_ITERATOR;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceCollections.EmptyCollection, p014it.unimi.dsi.fastutil.objects.AbstractReferenceCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection
        public ObjectListIterator<K> iterator() {
            return ObjectIterators.EMPTY_ITERATOR;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceList, java.util.List
        public ObjectListIterator<K> listIterator(int i) {
            if (i == 0) {
                return ObjectIterators.EMPTY_ITERATOR;
            }
            throw new IndexOutOfBoundsException(String.valueOf(i));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceList, java.util.List
        public ReferenceList<K> subList(int from, int to) {
            if (from == 0 && to == 0) {
                return this;
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceList
        public void getElements(int from, Object[] a, int offset, int length) {
            if (from != 0 || length != 0 || offset < 0 || offset > a.length) {
                throw new IndexOutOfBoundsException();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceList
        public void removeElements(int from, int to) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceList
        public void addElements(int index, K[] a, int offset, int length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceList
        public void addElements(int index, K[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceList
        public void setElements(K[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceList
        public void setElements(int index, K[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceList
        public void setElements(int index, K[] a, int offset, int length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceList
        public void size(int s) {
            throw new UnsupportedOperationException();
        }

        @Override // java.lang.Object
        public Object clone() {
            return ReferenceLists.EMPTY_LIST;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceCollections.EmptyCollection, java.util.Collection, java.lang.Object
        public int hashCode() {
            return 1;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceCollections.EmptyCollection, java.util.Collection, java.lang.Object
        public boolean equals(Object o) {
            return (o instanceof List) && ((List) o).isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceCollection, java.util.AbstractCollection, java.lang.Object
        public String toString() {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }

        private Object readResolve() {
            return ReferenceLists.EMPTY_LIST;
        }
    }

    public static <K> ReferenceList<K> emptyList() {
        return EMPTY_LIST;
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.ReferenceLists$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ReferenceLists$Singleton.class */
    public static class Singleton<K> extends AbstractReferenceList<K> implements RandomAccess, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        private final K element;

        protected Singleton(K element) {
            this.element = element;
        }

        @Override // java.util.List
        public K get(int i) {
            if (i == 0) {
                return this.element;
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean remove(Object k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceList, java.util.List
        public K remove(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object k) {
            return k == this.element;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceList, java.util.List
        public int indexOf(Object k) {
            return k == this.element ? 0 : -1;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public Object[] toArray() {
            return new Object[]{this.element};
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceList, p014it.unimi.dsi.fastutil.objects.ReferenceList, java.util.List
        public ObjectListIterator<K> listIterator() {
            return ObjectIterators.singleton(this.element);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceList, p014it.unimi.dsi.fastutil.objects.AbstractReferenceCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection
        public ObjectListIterator<K> iterator() {
            return listIterator();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<K> spliterator() {
            return ObjectSpliterators.singleton(this.element);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceList, p014it.unimi.dsi.fastutil.objects.ReferenceList, java.util.List
        public ObjectListIterator<K> listIterator(int i) {
            if (i > 1 || i < 0) {
                throw new IndexOutOfBoundsException();
            }
            ObjectListIterator<K> l = listIterator();
            if (i == 1) {
                l.next();
            }
            return l;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceList, p014it.unimi.dsi.fastutil.objects.ReferenceList, java.util.List
        public ReferenceList<K> subList(int from, int to) {
            ensureIndex(from);
            ensureIndex(to);
            if (from <= to) {
                return (from == 0 && to == 1) ? this : ReferenceLists.EMPTY_LIST;
            }
            throw new IndexOutOfBoundsException("Start index (" + from + ") is greater than end index (" + to + ")");
        }

        /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: K, ? super K */
        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceList, java.lang.Iterable
        public void forEach(Consumer<? super K> action) {
            action.accept((K) this.element);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceList, java.util.List
        public boolean addAll(int i, Collection<? extends K> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean addAll(Collection<? extends K> c) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean removeAll(Collection<?> c) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean retainAll(Collection<?> c) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public boolean removeIf(Predicate<? super K> filter) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.List
        public void replaceAll(UnaryOperator<K> operator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceList, java.util.List
        public void sort(Comparator<? super K> comparator) {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceList
        public void unstableSort(Comparator<? super K> comparator) {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceList, p014it.unimi.dsi.fastutil.objects.ReferenceList
        public void getElements(int from, Object[] a, int offset, int length) {
            if (offset < 0) {
                throw new ArrayIndexOutOfBoundsException("Offset (" + offset + ") is negative");
            } else if (offset + length > a.length) {
                throw new ArrayIndexOutOfBoundsException("End index (" + (offset + length) + ") is greater than array length (" + a.length + ")");
            } else if (from + length > size()) {
                throw new IndexOutOfBoundsException("End index (" + (from + length) + ") is greater than list size (" + size() + ")");
            } else if (length > 0) {
                a[offset] = this.element;
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceList, p014it.unimi.dsi.fastutil.objects.ReferenceList
        public void removeElements(int from, int to) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceList, p014it.unimi.dsi.fastutil.objects.ReferenceList
        public void addElements(int index, K[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceList, p014it.unimi.dsi.fastutil.objects.ReferenceList
        public void addElements(int index, K[] a, int offset, int length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceList
        public void setElements(K[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceList
        public void setElements(int index, K[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceList, p014it.unimi.dsi.fastutil.objects.ReferenceList
        public void setElements(int index, K[] a, int offset, int length) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return 1;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceList, p014it.unimi.dsi.fastutil.objects.ReferenceList
        public void size(int size) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // java.lang.Object
        public Object clone() {
            return this;
        }
    }

    public static <K> ReferenceList<K> singleton(K element) {
        return new Singleton(element);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.ReferenceLists$SynchronizedList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ReferenceLists$SynchronizedList.class */
    public static class SynchronizedList<K> extends ReferenceCollections.SynchronizedCollection<K> implements ReferenceList<K>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final ReferenceList<K> list;

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceCollections.SynchronizedCollection, java.lang.Object
        public /* bridge */ /* synthetic */ String toString() {
            return toString();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ void clear() {
            clear();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
            return retainAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
            return removeAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean containsAll(Collection collection) {
            return containsAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean addAll(Collection collection) {
            return addAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceCollections.SynchronizedCollection, java.lang.Iterable
        public /* bridge */ /* synthetic */ void forEach(Consumer consumer) {
            forEach(consumer);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Stream parallelStream() {
            return parallelStream();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Stream stream() {
            return stream();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public /* bridge */ /* synthetic */ ObjectSpliterator spliterator() {
            return spliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Object[] toArray(Object[] objArr) {
            return toArray(objArr);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Object[] toArray() {
            return toArray();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean isEmpty() {
            return isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceCollections.SynchronizedCollection, java.util.Collection, p014it.unimi.dsi.fastutil.BigList, p014it.unimi.dsi.fastutil.Size64
        public /* bridge */ /* synthetic */ int size() {
            return size();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean remove(Object obj) {
            return remove(obj);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean contains(Object obj) {
            return contains(obj);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceCollections.SynchronizedCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean add(Object obj) {
            return add(obj);
        }

        protected SynchronizedList(ReferenceList<K> l, Object sync) {
            super(l, sync);
            this.list = l;
        }

        protected SynchronizedList(ReferenceList<K> l) {
            super(l);
            this.list = l;
        }

        @Override // java.util.List
        public K get(int i) {
            K k;
            synchronized (this.sync) {
                k = this.list.get(i);
            }
            return k;
        }

        @Override // java.util.List
        public K set(int i, K k) {
            K k2;
            synchronized (this.sync) {
                k2 = this.list.set(i, k);
            }
            return k2;
        }

        @Override // java.util.List
        public void add(int i, K k) {
            synchronized (this.sync) {
                this.list.add(i, k);
            }
        }

        @Override // java.util.List
        public K remove(int i) {
            K remove;
            synchronized (this.sync) {
                remove = this.list.remove(i);
            }
            return remove;
        }

        @Override // java.util.List
        public int indexOf(Object k) {
            int indexOf;
            synchronized (this.sync) {
                indexOf = this.list.indexOf(k);
            }
            return indexOf;
        }

        @Override // java.util.List
        public int lastIndexOf(Object k) {
            int lastIndexOf;
            synchronized (this.sync) {
                lastIndexOf = this.list.lastIndexOf(k);
            }
            return lastIndexOf;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceCollections.SynchronizedCollection, java.util.Collection
        public boolean removeIf(Predicate<? super K> filter) {
            boolean removeIf;
            synchronized (this.sync) {
                removeIf = this.list.removeIf(filter);
            }
            return removeIf;
        }

        @Override // java.util.List
        public void replaceAll(UnaryOperator<K> operator) {
            synchronized (this.sync) {
                this.list.replaceAll(operator);
            }
        }

        @Override // java.util.List
        public boolean addAll(int index, Collection<? extends K> c) {
            boolean addAll;
            synchronized (this.sync) {
                addAll = this.list.addAll(index, c);
            }
            return addAll;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceList
        public void getElements(int from, Object[] a, int offset, int length) {
            synchronized (this.sync) {
                this.list.getElements(from, a, offset, length);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceList
        public void removeElements(int from, int to) {
            synchronized (this.sync) {
                this.list.removeElements(from, to);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceList
        public void addElements(int index, K[] a, int offset, int length) {
            synchronized (this.sync) {
                this.list.addElements(index, a, offset, length);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceList
        public void addElements(int index, K[] a) {
            synchronized (this.sync) {
                this.list.addElements(index, a);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceList
        public void setElements(K[] a) {
            synchronized (this.sync) {
                this.list.setElements(a);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceList
        public void setElements(int index, K[] a) {
            synchronized (this.sync) {
                this.list.setElements(index, a);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceList
        public void setElements(int index, K[] a, int offset, int length) {
            synchronized (this.sync) {
                this.list.setElements(index, a, offset, length);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceList
        public void size(int size) {
            synchronized (this.sync) {
                this.list.size(size);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceList, java.util.List
        public ObjectListIterator<K> listIterator() {
            return this.list.listIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceCollections.SynchronizedCollection, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection
        public ObjectListIterator<K> iterator() {
            return listIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceList, java.util.List
        public ObjectListIterator<K> listIterator(int i) {
            return this.list.listIterator(i);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceList, java.util.List
        public ReferenceList<K> subList(int from, int to) {
            SynchronizedList synchronizedList;
            synchronized (this.sync) {
                synchronizedList = new SynchronizedList(this.list.subList(from, to), this.sync);
            }
            return synchronizedList;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceCollections.SynchronizedCollection, java.util.Collection, java.lang.Object
        public boolean equals(Object o) {
            boolean equals;
            if (o == this) {
                return true;
            }
            synchronized (this.sync) {
                equals = this.collection.equals(o);
            }
            return equals;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceCollections.SynchronizedCollection, java.util.Collection, java.lang.Object
        public int hashCode() {
            int hashCode;
            synchronized (this.sync) {
                hashCode = this.collection.hashCode();
            }
            return hashCode;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceList, java.util.List
        public void sort(Comparator<? super K> comparator) {
            synchronized (this.sync) {
                this.list.sort(comparator);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceList
        public void unstableSort(Comparator<? super K> comparator) {
            synchronized (this.sync) {
                this.list.unstableSort(comparator);
            }
        }

        private void writeObject(ObjectOutputStream s) throws IOException {
            synchronized (this.sync) {
                s.defaultWriteObject();
            }
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.ReferenceLists$SynchronizedRandomAccessList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ReferenceLists$SynchronizedRandomAccessList.class */
    public static class SynchronizedRandomAccessList<K> extends SynchronizedList<K> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;

        protected SynchronizedRandomAccessList(ReferenceList<K> l, Object sync) {
            super(l, sync);
        }

        protected SynchronizedRandomAccessList(ReferenceList<K> l) {
            super(l);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceLists.SynchronizedList, p014it.unimi.dsi.fastutil.objects.ReferenceList, java.util.List
        public ReferenceList<K> subList(int from, int to) {
            SynchronizedRandomAccessList synchronizedRandomAccessList;
            synchronized (this.sync) {
                synchronizedRandomAccessList = new SynchronizedRandomAccessList(this.list.subList(from, to), this.sync);
            }
            return synchronizedRandomAccessList;
        }
    }

    public static <K> ReferenceList<K> synchronize(ReferenceList<K> l) {
        return l instanceof RandomAccess ? new SynchronizedRandomAccessList(l) : new SynchronizedList(l);
    }

    public static <K> ReferenceList<K> synchronize(ReferenceList<K> l, Object sync) {
        return l instanceof RandomAccess ? new SynchronizedRandomAccessList(l, sync) : new SynchronizedList(l, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.ReferenceLists$UnmodifiableList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ReferenceLists$UnmodifiableList.class */
    public static class UnmodifiableList<K> extends ReferenceCollections.UnmodifiableCollection<K> implements ReferenceList<K>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final ReferenceList<? extends K> list;

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceCollections.UnmodifiableCollection, java.lang.Object
        public /* bridge */ /* synthetic */ String toString() {
            return toString();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean removeIf(Predicate predicate) {
            return removeIf(predicate);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
            return retainAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
            return removeAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean addAll(Collection collection) {
            return addAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean containsAll(Collection collection) {
            return containsAll(collection);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceCollections.UnmodifiableCollection, java.lang.Iterable
        public /* bridge */ /* synthetic */ void forEach(Consumer consumer) {
            forEach(consumer);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Object[] toArray() {
            return toArray();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Object[] toArray(Object[] objArr) {
            return toArray(objArr);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ void clear() {
            clear();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Stream parallelStream() {
            return parallelStream();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ Stream stream() {
            return stream();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public /* bridge */ /* synthetic */ ObjectSpliterator spliterator() {
            return spliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean contains(Object obj) {
            return contains(obj);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean isEmpty() {
            return isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceCollections.UnmodifiableCollection, java.util.Collection, p014it.unimi.dsi.fastutil.BigList, p014it.unimi.dsi.fastutil.Size64
        public /* bridge */ /* synthetic */ int size() {
            return size();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean remove(Object obj) {
            return remove(obj);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceCollections.UnmodifiableCollection, java.util.Collection
        public /* bridge */ /* synthetic */ boolean add(Object obj) {
            return add(obj);
        }

        protected UnmodifiableList(ReferenceList<? extends K> l) {
            super(l);
            this.list = l;
        }

        @Override // java.util.List
        public K get(int i) {
            return (K) this.list.get(i);
        }

        @Override // java.util.List
        public K set(int i, K k) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.List
        public void add(int i, K k) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.List
        public K remove(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.List
        public int indexOf(Object k) {
            return this.list.indexOf(k);
        }

        @Override // java.util.List
        public int lastIndexOf(Object k) {
            return this.list.lastIndexOf(k);
        }

        @Override // java.util.List
        public boolean addAll(int index, Collection<? extends K> c) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.List
        public void replaceAll(UnaryOperator<K> operator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceList
        public void getElements(int from, Object[] a, int offset, int length) {
            this.list.getElements(from, a, offset, length);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceList
        public void removeElements(int from, int to) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceList
        public void addElements(int index, K[] a, int offset, int length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceList
        public void addElements(int index, K[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceList
        public void setElements(K[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceList
        public void setElements(int index, K[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceList
        public void setElements(int index, K[] a, int offset, int length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceList
        public void size(int size) {
            this.list.size(size);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceList, java.util.List
        public ObjectListIterator<K> listIterator() {
            return ObjectIterators.unmodifiable((ObjectListIterator) this.list.listIterator());
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceCollections.UnmodifiableCollection, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection
        public ObjectListIterator<K> iterator() {
            return listIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceList, java.util.List
        public ObjectListIterator<K> listIterator(int i) {
            return ObjectIterators.unmodifiable((ObjectListIterator) this.list.listIterator(i));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceList, java.util.List
        public ReferenceList<K> subList(int from, int to) {
            return new UnmodifiableList(this.list.subList(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceCollections.UnmodifiableCollection, java.util.Collection, java.lang.Object
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            return this.collection.equals(o);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceCollections.UnmodifiableCollection, java.util.Collection, java.lang.Object
        public int hashCode() {
            return this.collection.hashCode();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceList, java.util.List
        public void sort(Comparator<? super K> comparator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceList
        public void unstableSort(Comparator<? super K> comparator) {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.ReferenceLists$UnmodifiableRandomAccessList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ReferenceLists$UnmodifiableRandomAccessList.class */
    public static class UnmodifiableRandomAccessList<K> extends UnmodifiableList<K> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;

        protected UnmodifiableRandomAccessList(ReferenceList<? extends K> l) {
            super(l);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceLists.UnmodifiableList, p014it.unimi.dsi.fastutil.objects.ReferenceList, java.util.List
        public ReferenceList<K> subList(int from, int to) {
            return new UnmodifiableRandomAccessList(this.list.subList(from, to));
        }
    }

    public static <K> ReferenceList<K> unmodifiable(ReferenceList<? extends K> l) {
        return l instanceof RandomAccess ? new UnmodifiableRandomAccessList(l) : new UnmodifiableList(l);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.ReferenceLists$ImmutableListBase */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ReferenceLists$ImmutableListBase.class */
    static abstract class ImmutableListBase<K> extends AbstractReferenceList<K> implements ReferenceList<K> {
        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceList, java.util.List
        @Deprecated
        public final void add(int index, K k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceList, java.util.AbstractCollection, java.util.Collection, java.util.List
        @Deprecated
        public final boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceList, java.util.AbstractCollection, java.util.Collection, java.util.List
        @Deprecated
        public final boolean addAll(Collection<? extends K> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceList, java.util.List
        @Deprecated
        public final boolean addAll(int index, Collection<? extends K> c) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceList, java.util.List
        @Deprecated
        public final K remove(int index) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        @Deprecated
        public final boolean remove(Object k) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        @Deprecated
        public final boolean removeAll(Collection<?> c) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        @Deprecated
        public final boolean retainAll(Collection<?> c) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        @Deprecated
        public final boolean removeIf(Predicate<? super K> c) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.List
        @Deprecated
        public final void replaceAll(UnaryOperator<K> operator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceList, java.util.List
        @Deprecated
        public final K set(int index, K k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceList, java.util.AbstractCollection, java.util.Collection, java.util.List
        @Deprecated
        public final void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceList, p014it.unimi.dsi.fastutil.objects.ReferenceList
        @Deprecated
        public final void size(int size) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceList, p014it.unimi.dsi.fastutil.objects.ReferenceList
        @Deprecated
        public final void removeElements(int from, int to) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceList, p014it.unimi.dsi.fastutil.objects.ReferenceList
        @Deprecated
        public final void addElements(int index, K[] a, int offset, int length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceList, p014it.unimi.dsi.fastutil.objects.ReferenceList
        @Deprecated
        public final void setElements(int index, K[] a, int offset, int length) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceList, java.util.List
        @Deprecated
        public final void sort(Comparator<? super K> comparator) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceList
        @Deprecated
        public final void unstableSort(Comparator<? super K> comparator) {
            throw new UnsupportedOperationException();
        }
    }
}
