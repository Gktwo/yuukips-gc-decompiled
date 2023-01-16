package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/google/common/graph/MapIteratorCache.class */
public class MapIteratorCache<K, V> {
    private final Map<K, V> backingMap;
    private transient Map.Entry<K, V> entrySetCache;

    /* access modifiers changed from: package-private */
    public MapIteratorCache(Map<K, V> backingMap) {
        this.backingMap = (Map) Preconditions.checkNotNull(backingMap);
    }

    @CanIgnoreReturnValue
    public V put(K key, V value) {
        clearCache();
        return this.backingMap.put(key, value);
    }

    @CanIgnoreReturnValue
    public V remove(Object key) {
        clearCache();
        return this.backingMap.remove(key);
    }

    public void clear() {
        clearCache();
        this.backingMap.clear();
    }

    public V get(Object key) {
        V value = getIfCached(key);
        return value != null ? value : getWithoutCaching(key);
    }

    public final V getWithoutCaching(Object key) {
        return this.backingMap.get(key);
    }

    public final boolean containsKey(Object key) {
        return getIfCached(key) != null || this.backingMap.containsKey(key);
    }

    public final Set<K> unmodifiableKeySet() {
        return new AbstractSet<K>() { // from class: com.google.common.graph.MapIteratorCache.1
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
            public UnmodifiableIterator<K> iterator() {
                final Iterator<Map.Entry<K, V>> entryIterator = MapIteratorCache.this.backingMap.entrySet().iterator();
                return new UnmodifiableIterator<K>() { // from class: com.google.common.graph.MapIteratorCache.1.1
                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return entryIterator.hasNext();
                    }

                    @Override // java.util.Iterator
                    public K next() {
                        Map.Entry<K, V> entry = (Map.Entry) entryIterator.next();
                        MapIteratorCache.this.entrySetCache = entry;
                        return entry.getKey();
                    }
                };
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return MapIteratorCache.this.backingMap.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object key) {
                return MapIteratorCache.this.containsKey(key);
            }
        };
    }

    /* access modifiers changed from: protected */
    public V getIfCached(Object key) {
        Map.Entry<K, V> entry = this.entrySetCache;
        if (entry == null || entry.getKey() != key) {
            return null;
        }
        return entry.getValue();
    }

    /* access modifiers changed from: protected */
    public void clearCache() {
        this.entrySetCache = null;
    }
}
