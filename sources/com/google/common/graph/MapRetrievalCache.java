package com.google.common.graph;

import java.util.Map;

/* loaded from: grasscutter.jar:com/google/common/graph/MapRetrievalCache.class */
class MapRetrievalCache<K, V> extends MapIteratorCache<K, V> {
    private transient CacheEntry<K, V> cacheEntry1;
    private transient CacheEntry<K, V> cacheEntry2;

    /* access modifiers changed from: package-private */
    public MapRetrievalCache(Map<K, V> backingMap) {
        super(backingMap);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.MapIteratorCache
    public V get(Object key) {
        V value = getIfCached(key);
        if (value != null) {
            return value;
        }
        V value2 = getWithoutCaching(key);
        if (value2 != null) {
            addToCache(key, value2);
        }
        return value2;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.common.graph.MapIteratorCache
    public V getIfCached(Object key) {
        V value = getIfCached(key);
        if (value != null) {
            return value;
        }
        CacheEntry<K, V> entry = this.cacheEntry1;
        if (entry != null && entry.key == key) {
            return entry.value;
        }
        CacheEntry<K, V> entry2 = this.cacheEntry2;
        if (entry2 == null || entry2.key != key) {
            return null;
        }
        addToCache(entry2);
        return entry2.value;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.common.graph.MapIteratorCache
    public void clearCache() {
        clearCache();
        this.cacheEntry1 = null;
        this.cacheEntry2 = null;
    }

    private void addToCache(K key, V value) {
        addToCache(new CacheEntry<>(key, value));
    }

    private void addToCache(CacheEntry<K, V> entry) {
        this.cacheEntry2 = this.cacheEntry1;
        this.cacheEntry1 = entry;
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/common/graph/MapRetrievalCache$CacheEntry.class */
    public static final class CacheEntry<K, V> {
        final K key;
        final V value;

        CacheEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
