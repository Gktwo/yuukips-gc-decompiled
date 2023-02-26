package com.mchange.p006v1.cachedstore;

import com.mchange.p006v1.cachedstore.CachedStore;

/* access modifiers changed from: package-private */
/* renamed from: com.mchange.v1.cachedstore.ValueTransformingCachedStore */
/* loaded from: grasscutter.jar:com/mchange/v1/cachedstore/ValueTransformingCachedStore.class */
public abstract class ValueTransformingCachedStore extends NoCleanupCachedStore {
    /* access modifiers changed from: protected */
    public ValueTransformingCachedStore(CachedStore.Manager manager) {
        super(manager);
    }

    @Override // com.mchange.p006v1.cachedstore.NoCleanupCachedStore, com.mchange.p006v1.cachedstore.TweakableCachedStore
    public Object getCachedValue(Object obj) {
        return toUserValue(this.cache.get(obj));
    }

    @Override // com.mchange.p006v1.cachedstore.NoCleanupCachedStore, com.mchange.p006v1.cachedstore.TweakableCachedStore
    public void removeFromCache(Object obj) throws CachedStoreException {
        this.cache.remove(obj);
    }

    @Override // com.mchange.p006v1.cachedstore.NoCleanupCachedStore, com.mchange.p006v1.cachedstore.TweakableCachedStore
    public void setCachedValue(Object obj, Object obj2) throws CachedStoreException {
        this.cache.put(obj, toCacheValue(obj2));
    }

    protected Object toUserValue(Object obj) {
        return obj;
    }

    protected Object toCacheValue(Object obj) {
        return obj;
    }
}
