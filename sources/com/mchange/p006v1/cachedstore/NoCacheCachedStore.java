package com.mchange.p006v1.cachedstore;

import com.mchange.p006v1.cachedstore.CachedStore;
import com.mchange.p006v1.util.IteratorUtils;
import java.util.Iterator;

/* renamed from: com.mchange.v1.cachedstore.NoCacheCachedStore */
/* loaded from: grasscutter.jar:com/mchange/v1/cachedstore/NoCacheCachedStore.class */
class NoCacheCachedStore implements TweakableCachedStore {
    CachedStore.Manager mgr;

    /* access modifiers changed from: package-private */
    public NoCacheCachedStore(CachedStore.Manager manager) {
        this.mgr = manager;
    }

    @Override // com.mchange.p006v1.cachedstore.CachedStore
    public Object find(Object obj) throws CachedStoreException {
        try {
            return this.mgr.recreateFromKey(obj);
        } catch (Exception e) {
            e.printStackTrace();
            throw CachedStoreUtils.toCachedStoreException(e);
        }
    }

    @Override // com.mchange.p006v1.cachedstore.CachedStore
    public void reset() {
    }

    @Override // com.mchange.p006v1.cachedstore.TweakableCachedStore
    public Object getCachedValue(Object obj) {
        return null;
    }

    @Override // com.mchange.p006v1.cachedstore.TweakableCachedStore
    public void removeFromCache(Object obj) {
    }

    @Override // com.mchange.p006v1.cachedstore.TweakableCachedStore
    public void setCachedValue(Object obj, Object obj2) {
    }

    @Override // com.mchange.p006v1.cachedstore.TweakableCachedStore
    public Iterator cachedKeys() {
        return IteratorUtils.EMPTY_ITERATOR;
    }
}
