package com.mchange.p006v1.cachedstore;

import com.mchange.p006v1.cachedstore.CachedStore;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.mchange.v1.cachedstore.NoCleanupCachedStore */
/* loaded from: grasscutter.jar:com/mchange/v1/cachedstore/NoCleanupCachedStore.class */
class NoCleanupCachedStore implements TweakableCachedStore {
    static final boolean DEBUG = true;
    protected Map cache = new HashMap();
    CachedStore.Manager manager;

    public NoCleanupCachedStore(CachedStore.Manager manager) {
        this.manager = manager;
    }

    @Override // com.mchange.p006v1.cachedstore.CachedStore
    public Object find(Object obj) throws CachedStoreException {
        try {
            Object cachedValue = getCachedValue(obj);
            if (cachedValue == null || this.manager.isDirty(obj, cachedValue)) {
                cachedValue = this.manager.recreateFromKey(obj);
                if (cachedValue != null) {
                    setCachedValue(obj, cachedValue);
                }
            }
            return cachedValue;
        } catch (CachedStoreException e) {
            throw e;
        } catch (Exception e2) {
            e2.printStackTrace();
            throw new CachedStoreException(e2);
        }
    }

    @Override // com.mchange.p006v1.cachedstore.TweakableCachedStore
    public Object getCachedValue(Object obj) {
        return this.cache.get(obj);
    }

    @Override // com.mchange.p006v1.cachedstore.TweakableCachedStore
    public void removeFromCache(Object obj) throws CachedStoreException {
        this.cache.remove(obj);
    }

    @Override // com.mchange.p006v1.cachedstore.TweakableCachedStore
    public void setCachedValue(Object obj, Object obj2) throws CachedStoreException {
        this.cache.put(obj, obj2);
    }

    @Override // com.mchange.p006v1.cachedstore.TweakableCachedStore
    public Iterator cachedKeys() throws CachedStoreException {
        return this.cache.keySet().iterator();
    }

    @Override // com.mchange.p006v1.cachedstore.CachedStore
    public void reset() {
        this.cache.clear();
    }
}
