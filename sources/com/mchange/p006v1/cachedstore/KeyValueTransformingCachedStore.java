package com.mchange.p006v1.cachedstore;

import com.mchange.p006v1.cachedstore.CachedStore;
import com.mchange.p006v1.util.WrapperIterator;
import java.util.Iterator;

/* renamed from: com.mchange.v1.cachedstore.KeyValueTransformingCachedStore */
/* loaded from: grasscutter.jar:com/mchange/v1/cachedstore/KeyValueTransformingCachedStore.class */
abstract class KeyValueTransformingCachedStore extends ValueTransformingCachedStore {
    protected KeyValueTransformingCachedStore(CachedStore.Manager manager) {
        super(manager);
    }

    @Override // com.mchange.p006v1.cachedstore.ValueTransformingCachedStore, com.mchange.p006v1.cachedstore.NoCleanupCachedStore, com.mchange.p006v1.cachedstore.TweakableCachedStore
    public Object getCachedValue(Object obj) {
        return toUserValue(this.cache.get(toCacheFetchKey(obj)));
    }

    public void clearCachedValue(Object obj) throws CachedStoreException {
        this.cache.remove(toCacheFetchKey(obj));
    }

    @Override // com.mchange.p006v1.cachedstore.ValueTransformingCachedStore, com.mchange.p006v1.cachedstore.NoCleanupCachedStore, com.mchange.p006v1.cachedstore.TweakableCachedStore
    public void setCachedValue(Object obj, Object obj2) throws CachedStoreException {
        this.cache.put(toCachePutKey(obj), toCacheValue(obj2));
    }

    @Override // com.mchange.p006v1.cachedstore.NoCleanupCachedStore, com.mchange.p006v1.cachedstore.TweakableCachedStore
    public Iterator cachedKeys() throws CachedStoreException {
        return new WrapperIterator(this.cache.keySet().iterator(), false) { // from class: com.mchange.v1.cachedstore.KeyValueTransformingCachedStore.1
            @Override // com.mchange.p006v1.util.WrapperIterator
            public Object transformObject(Object obj) {
                Object userKey = KeyValueTransformingCachedStore.this.toUserKey(obj);
                return userKey == null ? SKIP_TOKEN : userKey;
            }
        };
    }

    protected Object toUserKey(Object obj) {
        return obj;
    }

    protected Object toCacheFetchKey(Object obj) {
        return obj;
    }

    protected Object toCachePutKey(Object obj) {
        return obj;
    }
}
