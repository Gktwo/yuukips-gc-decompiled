package org.terracotta.quartz.collections;

import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.terracotta.toolkit.concurrent.locks.ToolkitReadWriteLock;
import org.terracotta.toolkit.config.Configuration;
import org.terracotta.toolkit.search.QueryBuilder;
import org.terracotta.toolkit.search.attribute.ToolkitAttributeExtractor;
import org.terracotta.toolkit.store.ToolkitStore;

/* loaded from: grasscutter.jar:org/terracotta/quartz/collections/SerializedToolkitStore.class */
public class SerializedToolkitStore<K, V extends Serializable> implements ToolkitStore<K, V> {
    private final ToolkitStore<String, V> toolkitStore;

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: org.terracotta.quartz.collections.SerializedToolkitStore<K, V extends java.io.Serializable> */
    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ void putNoReturn(Object obj, Object obj2) {
        putNoReturn((SerializedToolkitStore<K, V>) obj, (Object) ((Serializable) obj2));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: org.terracotta.quartz.collections.SerializedToolkitStore<K, V extends java.io.Serializable> */
    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ Object replace(Object obj, Object obj2) {
        return replace((SerializedToolkitStore<K, V>) obj, (Object) ((Serializable) obj2));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: org.terracotta.quartz.collections.SerializedToolkitStore<K, V extends java.io.Serializable> */
    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ boolean replace(Object obj, Object obj2, Object obj3) {
        return replace((SerializedToolkitStore<K, V>) obj, (Serializable) obj2, (Serializable) obj3);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: org.terracotta.quartz.collections.SerializedToolkitStore<K, V extends java.io.Serializable> */
    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ Object putIfAbsent(Object obj, Object obj2) {
        return putIfAbsent((SerializedToolkitStore<K, V>) obj, (Object) ((Serializable) obj2));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: org.terracotta.quartz.collections.SerializedToolkitStore<K, V extends java.io.Serializable> */
    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return put((SerializedToolkitStore<K, V>) obj, (Object) ((Serializable) obj2));
    }

    public SerializedToolkitStore(ToolkitStore toolkitMap) {
        this.toolkitStore = toolkitMap;
    }

    public int size() {
        return this.toolkitStore.size();
    }

    public boolean isEmpty() {
        return this.toolkitStore.isEmpty();
    }

    /* access modifiers changed from: private */
    public static String serializeToString(Object key) {
        try {
            return SerializationHelper.serializeToString(key);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /* access modifiers changed from: private */
    public static Object deserializeFromString(String key) {
        try {
            return SerializationHelper.deserializeFromString(key);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e2) {
            throw new RuntimeException(e2);
        }
    }

    public boolean containsKey(Object key) {
        return this.toolkitStore.containsKey(serializeToString(key));
    }

    public V get(Object key) {
        return (V) ((Serializable) this.toolkitStore.get(serializeToString(key)));
    }

    public V put(K key, V value) {
        return (V) ((Serializable) this.toolkitStore.put(serializeToString(key), value));
    }

    public V remove(Object key) {
        return (V) ((Serializable) this.toolkitStore.remove(serializeToString(key)));
    }

    public void putAll(Map<? extends K, ? extends V> m) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<? extends K, ? extends V> entry : m.entrySet()) {
            hashMap.put(serializeToString(entry.getKey()), entry.getValue());
        }
        this.toolkitStore.putAll(hashMap);
    }

    public void clear() {
        this.toolkitStore.clear();
    }

    public Set<K> keySet() {
        return new ToolkitKeySet(this.toolkitStore.keySet());
    }

    public boolean isDestroyed() {
        return this.toolkitStore.isDestroyed();
    }

    public void destroy() {
        this.toolkitStore.destroy();
    }

    public String getName() {
        return this.toolkitStore.getName();
    }

    public ToolkitReadWriteLock createLockForKey(K key) {
        return this.toolkitStore.createLockForKey(serializeToString(key));
    }

    public void removeNoReturn(Object key) {
        this.toolkitStore.removeNoReturn(serializeToString(key));
    }

    public void putNoReturn(K key, V value) {
        this.toolkitStore.putNoReturn(serializeToString(key), value);
    }

    public Map<K, V> getAll(Collection<? extends K> keys) {
        HashSet<String> tempSet = new HashSet<>();
        Iterator i$ = keys.iterator();
        while (i$.hasNext()) {
            tempSet.add(serializeToString(i$.next()));
        }
        Map<String, V> m = this.toolkitStore.getAll(tempSet);
        Map<K, V> tempMap = m.isEmpty() ? Collections.EMPTY_MAP : new HashMap<>();
        for (Map.Entry<String, V> entry : m.entrySet()) {
            tempMap.put(deserializeFromString(entry.getKey()), entry.getValue());
        }
        return tempMap;
    }

    public Configuration getConfiguration() {
        return this.toolkitStore.getConfiguration();
    }

    public void setConfigField(String name, Serializable value) {
        this.toolkitStore.setConfigField(name, value);
    }

    public boolean containsValue(Object value) {
        return this.toolkitStore.containsValue(value);
    }

    public V putIfAbsent(K key, V value) {
        return (V) ((Serializable) this.toolkitStore.putIfAbsent(serializeToString(key), value));
    }

    public Set<Map.Entry<K, V>> entrySet() {
        return new ToolkitEntrySet(this.toolkitStore.entrySet());
    }

    public Collection<V> values() {
        return this.toolkitStore.values();
    }

    public boolean remove(Object key, Object value) {
        return this.toolkitStore.remove(serializeToString(key), value);
    }

    public boolean replace(K key, V oldValue, V newValue) {
        return this.toolkitStore.replace(serializeToString(key), oldValue, newValue);
    }

    public V replace(K key, V value) {
        return (V) ((Serializable) this.toolkitStore.replace(serializeToString(key), value));
    }

    public boolean isBulkLoadEnabled() {
        return this.toolkitStore.isBulkLoadEnabled();
    }

    public boolean isNodeBulkLoadEnabled() {
        return this.toolkitStore.isNodeBulkLoadEnabled();
    }

    public void setNodeBulkLoadEnabled(boolean enabledBulkLoad) {
        this.toolkitStore.setNodeBulkLoadEnabled(enabledBulkLoad);
    }

    public void waitUntilBulkLoadComplete() throws InterruptedException {
        this.toolkitStore.waitUntilBulkLoadComplete();
    }

    /* loaded from: grasscutter.jar:org/terracotta/quartz/collections/SerializedToolkitStore$ToolkitEntrySet.class */
    private static class ToolkitEntrySet<K, V> implements Set<Map.Entry<K, V>> {
        private final Set<Map.Entry<String, V>> set;

        @Override // java.util.Set, java.util.Collection
        public /* bridge */ /* synthetic */ boolean add(Object obj) {
            return add((Map.Entry) ((Map.Entry) obj));
        }

        public ToolkitEntrySet(Set<Map.Entry<String, V>> set) {
            this.set = set;
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return this.set.size();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return this.set.isEmpty();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<K, V> entry = (Map.Entry) o;
            return this.set.contains(new ToolkitMapEntry<>(SerializedToolkitStore.serializeToString(entry.getKey()), entry.getValue()));
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return new ToolkitEntryIterator(this.set.iterator());
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] a) {
            throw new UnsupportedOperationException();
        }

        public boolean add(Map.Entry<K, V> e) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object o) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> c) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends Map.Entry<K, V>> c) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> c) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> c) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            throw new UnsupportedOperationException();
        }
    }

    /* loaded from: grasscutter.jar:org/terracotta/quartz/collections/SerializedToolkitStore$ToolkitEntryIterator.class */
    private static class ToolkitEntryIterator<K, V> implements Iterator<Map.Entry<K, V>> {
        private final Iterator<Map.Entry<String, V>> iter;

        public ToolkitEntryIterator(Iterator<Map.Entry<String, V>> iter) {
            this.iter = iter;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iter.hasNext();
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            Map.Entry<String, V> entry = this.iter.next();
            if (entry == null) {
                return null;
            }
            return new ToolkitMapEntry(SerializedToolkitStore.deserializeFromString(entry.getKey()), entry.getValue());
        }

        @Override // java.util.Iterator
        public void remove() {
            this.iter.remove();
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/terracotta/quartz/collections/SerializedToolkitStore$ToolkitMapEntry.class */
    public static class ToolkitMapEntry<K, V> implements Map.Entry<K, V> {

        /* renamed from: k */
        private final K f3345k;

        /* renamed from: v */
        private final V f3346v;

        public ToolkitMapEntry(K k, V v) {
            this.f3345k = k;
            this.f3346v = v;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f3345k;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f3346v;
        }

        @Override // java.util.Map.Entry
        public V setValue(V value) {
            throw new UnsupportedOperationException();
        }
    }

    /* loaded from: grasscutter.jar:org/terracotta/quartz/collections/SerializedToolkitStore$ToolkitKeySet.class */
    private static class ToolkitKeySet<K> implements Set<K> {
        private final Set<String> set;

        public ToolkitKeySet(Set<String> set) {
            this.set = set;
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return this.set.size();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return this.set.isEmpty();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object o) {
            return this.set.contains(SerializedToolkitStore.serializeToString(o));
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return new ToolkitKeyIterator(this.set.iterator());
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(K e) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object o) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> c) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends K> c) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> c) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> c) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            throw new UnsupportedOperationException();
        }
    }

    /* loaded from: grasscutter.jar:org/terracotta/quartz/collections/SerializedToolkitStore$ToolkitKeyIterator.class */
    private static class ToolkitKeyIterator<K> implements Iterator<K> {
        private final Iterator<String> iter;

        public ToolkitKeyIterator(Iterator<String> iter) {
            this.iter = iter;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iter.hasNext();
        }

        @Override // java.util.Iterator
        public K next() {
            String k = this.iter.next();
            if (k == null) {
                return null;
            }
            return (K) SerializedToolkitStore.deserializeFromString(k);
        }

        @Override // java.util.Iterator
        public void remove() {
            this.iter.remove();
        }
    }

    public void setAttributeExtractor(ToolkitAttributeExtractor attrExtractor) {
        this.toolkitStore.setAttributeExtractor(attrExtractor);
    }

    public QueryBuilder createQueryBuilder() {
        throw new UnsupportedOperationException();
    }
}
