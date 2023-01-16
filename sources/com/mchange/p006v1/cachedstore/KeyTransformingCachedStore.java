package com.mchange.p006v1.cachedstore;

import com.mchange.p006v1.cachedstore.CachedStore;
import com.mchange.p006v1.util.WrapperIterator;
import java.util.Iterator;

/* access modifiers changed from: package-private */
/* renamed from: com.mchange.v1.cachedstore.KeyTransformingCachedStore */
/* loaded from: grasscutter.jar:com/mchange/v1/cachedstore/KeyTransformingCachedStore.class */
public abstract class KeyTransformingCachedStore extends NoCleanupCachedStore {
    /* access modifiers changed from: protected */
    public KeyTransformingCachedStore(CachedStore.Manager manager) {
        super(manager);
    }

    @Override // com.mchange.p006v1.cachedstore.NoCleanupCachedStore, com.mchange.p006v1.cachedstore.TweakableCachedStore
    public Object getCachedValue(Object obj) {
        return this.cache.get(toCacheFetchKey(obj));
    }

    @Override // com.mchange.p006v1.cachedstore.NoCleanupCachedStore, com.mchange.p006v1.cachedstore.TweakableCachedStore
    public void removeFromCache(Object obj) throws CachedStoreException {
        this.cache.remove(toCacheFetchKey(obj));
    }

    @Override // com.mchange.p006v1.cachedstore.NoCleanupCachedStore, com.mchange.p006v1.cachedstore.TweakableCachedStore
    public void setCachedValue(Object obj, Object obj2) throws CachedStoreException {
        this.cache.put(toCachePutKey(obj), obj2);
    }

    @Override // com.mchange.p006v1.cachedstore.NoCleanupCachedStore, com.mchange.p006v1.cachedstore.TweakableCachedStore
    public Iterator cachedKeys() throws CachedStoreException {
        return new WrapperIterator(this.cache.keySet().iterator(), false) { // from class: com.mchange.v1.cachedstore.KeyTransformingCachedStore.1
            @Override // com.mchange.p006v1.util.WrapperIterator
            public Object transformObject(Object obj) {
                Object userKey = KeyTransformingCachedStore.this.toUserKey(obj);
                return userKey == null ? SKIP_TOKEN : userKey;
            }
        };
    }

    protected Object toUserKey(Object obj) {
        return obj;
    }

    protected Object toCacheFetchKey(Object obj) {
        return toCachePutKey(obj);
    }

    protected Object toCachePutKey(Object obj) {
        return obj;
    }

    protected Object removeByTransformedKey(Object obj) {
        return this.cache.remove(obj);
    }
}
