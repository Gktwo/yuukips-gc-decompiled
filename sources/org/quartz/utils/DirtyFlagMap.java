package org.quartz.utils;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: grasscutter.jar:org/quartz/utils/DirtyFlagMap.class */
public class DirtyFlagMap<K, V> implements Map<K, V>, Cloneable, Serializable {
    private static final long serialVersionUID = 1433884852607126222L;
    private boolean dirty;
    private Map<K, V> map;

    public DirtyFlagMap() {
        this.dirty = false;
        this.map = new HashMap();
    }

    public DirtyFlagMap(int initialCapacity) {
        this.dirty = false;
        this.map = new HashMap(initialCapacity);
    }

    public DirtyFlagMap(int initialCapacity, float loadFactor) {
        this.dirty = false;
        this.map = new HashMap(initialCapacity, loadFactor);
    }

    public void clearDirtyFlag() {
        this.dirty = false;
    }

    public boolean isDirty() {
        return this.dirty;
    }

    public Map<K, V> getWrappedMap() {
        return this.map;
    }

    @Override // java.util.Map
    public void clear() {
        if (!this.map.isEmpty()) {
            this.dirty = true;
        }
        this.map.clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object key) {
        return this.map.containsKey(key);
    }

    @Override // java.util.Map
    public boolean containsValue(Object val) {
        return this.map.containsValue(val);
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return new DirtyFlagMapEntrySet(this.map.entrySet());
    }

    @Override // java.util.Map, java.lang.Object
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DirtyFlagMap)) {
            return false;
        }
        return this.map.equals(((DirtyFlagMap) obj).getWrappedMap());
    }

    @Override // java.util.Map, java.lang.Object
    public int hashCode() {
        return this.map.hashCode();
    }

    @Override // java.util.Map
    public V get(Object key) {
        return this.map.get(key);
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return new DirtyFlagSet(this.map.keySet());
    }

    @Override // java.util.Map
    public V put(K key, V val) {
        this.dirty = true;
        return this.map.put(key, val);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> t) {
        if (!t.isEmpty()) {
            this.dirty = true;
        }
        this.map.putAll(t);
    }

    @Override // java.util.Map
    public V remove(Object key) {
        V obj = this.map.remove(key);
        if (obj != null) {
            this.dirty = true;
        }
        return obj;
    }

    @Override // java.util.Map
    public int size() {
        return this.map.size();
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return new DirtyFlagCollection(this.map.values());
    }

    @Override // java.lang.Object
    public Object clone() {
        try {
            DirtyFlagMap<K, V> copy = (DirtyFlagMap) clone();
            if (this.map instanceof HashMap) {
                copy.map = (Map) ((HashMap) this.map).clone();
            }
            return copy;
        } catch (CloneNotSupportedException e) {
            throw new IncompatibleClassChangeError("Not Cloneable.");
        }
    }

    /* loaded from: grasscutter.jar:org/quartz/utils/DirtyFlagMap$DirtyFlagCollection.class */
    private class DirtyFlagCollection<T> implements Collection<T> {
        private Collection<T> collection;

        public DirtyFlagCollection(Collection<T> c) {
            this.collection = c;
        }

        protected Collection<T> getWrappedCollection() {
            return this.collection;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<T> iterator() {
            return new DirtyFlagIterator(this.collection.iterator());
        }

        @Override // java.util.Collection
        public boolean remove(Object o) {
            boolean removed = this.collection.remove(o);
            if (removed) {
                DirtyFlagMap.this.dirty = true;
            }
            return removed;
        }

        @Override // java.util.Collection
        public boolean removeAll(Collection<?> c) {
            boolean changed = this.collection.removeAll(c);
            if (changed) {
                DirtyFlagMap.this.dirty = true;
            }
            return changed;
        }

        @Override // java.util.Collection
        public boolean retainAll(Collection<?> c) {
            boolean changed = this.collection.retainAll(c);
            if (changed) {
                DirtyFlagMap.this.dirty = true;
            }
            return changed;
        }

        @Override // java.util.Collection
        public void clear() {
            if (!this.collection.isEmpty()) {
                DirtyFlagMap.this.dirty = true;
            }
            this.collection.clear();
        }

        @Override // java.util.Collection
        public int size() {
            return this.collection.size();
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return this.collection.isEmpty();
        }

        @Override // java.util.Collection
        public boolean contains(Object o) {
            return this.collection.contains(o);
        }

        @Override // java.util.Collection
        public boolean add(T o) {
            return this.collection.add(o);
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends T> c) {
            return this.collection.addAll(c);
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection<?> c) {
            return this.collection.containsAll(c);
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            return this.collection.toArray();
        }

        @Override // java.util.Collection
        public <U> U[] toArray(U[] array) {
            return (U[]) this.collection.toArray(array);
        }
    }

    /* loaded from: grasscutter.jar:org/quartz/utils/DirtyFlagMap$DirtyFlagSet.class */
    private class DirtyFlagSet<T> extends DirtyFlagMap<K, V>.DirtyFlagCollection implements Set<T> {
        public DirtyFlagSet(Set<T> set) {
            super(set);
        }

        protected Set<T> getWrappedSet() {
            return (Set) getWrappedCollection();
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/quartz/utils/DirtyFlagMap$DirtyFlagIterator.class */
    public class DirtyFlagIterator<T> implements Iterator<T> {
        private Iterator<T> iterator;

        public DirtyFlagIterator(Iterator<T> iterator) {
            this.iterator = iterator;
        }

        @Override // java.util.Iterator
        public void remove() {
            DirtyFlagMap.this.dirty = true;
            this.iterator.remove();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            return this.iterator.next();
        }
    }

    /* loaded from: grasscutter.jar:org/quartz/utils/DirtyFlagMap$DirtyFlagMapEntrySet.class */
    private class DirtyFlagMapEntrySet extends DirtyFlagMap<K, V>.DirtyFlagSet {
        public DirtyFlagMapEntrySet(Set<Map.Entry<K, V>> set) {
            super(set);
        }

        @Override // org.quartz.utils.DirtyFlagMap.DirtyFlagCollection, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return new DirtyFlagMapEntryIterator(getWrappedSet().iterator());
        }

        @Override // org.quartz.utils.DirtyFlagMap.DirtyFlagCollection, java.util.Collection
        public Object[] toArray() {
            return toArray(new Object[size()]);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v26, resolved type: U[] */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.quartz.utils.DirtyFlagMap.DirtyFlagCollection, java.util.Collection
        public <U> U[] toArray(U[] array) {
            if (!array.getClass().getComponentType().isAssignableFrom(Map.Entry.class)) {
                throw new IllegalArgumentException("Array must be of type assignable from Map.Entry");
            }
            int size = size();
            U[] result = array.length < size ? (U[]) ((Object[]) Array.newInstance(array.getClass().getComponentType(), size)) : array;
            Iterator<Map.Entry<K, V>> entryIter = iterator();
            for (int i = 0; i < size; i++) {
                result[i] = entryIter.next();
            }
            if (result.length > size) {
                result[size] = null;
            }
            return result;
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/quartz/utils/DirtyFlagMap$DirtyFlagMapEntryIterator.class */
    public class DirtyFlagMapEntryIterator extends DirtyFlagMap<K, V>.DirtyFlagIterator {
        public DirtyFlagMapEntryIterator(Iterator<Map.Entry<K, V>> iterator) {
            super(iterator);
        }

        @Override // org.quartz.utils.DirtyFlagMap.DirtyFlagIterator, java.util.Iterator
        public DirtyFlagMap<K, V>.DirtyFlagMapEntry next() {
            return new DirtyFlagMapEntry(next());
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/quartz/utils/DirtyFlagMap$DirtyFlagMapEntry.class */
    public class DirtyFlagMapEntry implements Map.Entry<K, V> {
        private Map.Entry<K, V> entry;

        public DirtyFlagMapEntry(Map.Entry<K, V> entry) {
            this.entry = entry;
        }

        @Override // java.util.Map.Entry
        public V setValue(V o) {
            DirtyFlagMap.this.dirty = true;
            return this.entry.setValue(o);
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.entry.getKey();
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.entry.getValue();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            return this.entry.equals(o);
        }
    }
}
