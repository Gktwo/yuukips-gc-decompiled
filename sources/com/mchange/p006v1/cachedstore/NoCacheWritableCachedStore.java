package com.mchange.p006v1.cachedstore;

import com.mchange.p006v1.cachedstore.WritableCachedStore;
import java.util.Collections;
import java.util.Set;

/* renamed from: com.mchange.v1.cachedstore.NoCacheWritableCachedStore */
/* loaded from: grasscutter.jar:com/mchange/v1/cachedstore/NoCacheWritableCachedStore.class */
class NoCacheWritableCachedStore implements WritableCachedStore, Autoflushing {
    WritableCachedStore.Manager mgr;

    /* access modifiers changed from: package-private */
    public NoCacheWritableCachedStore(WritableCachedStore.Manager manager) {
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

    @Override // com.mchange.p006v1.cachedstore.WritableCachedStore, com.mchange.p006v1.cachedstore.CachedStore
    public void reset() {
    }

    @Override // com.mchange.p006v1.cachedstore.WritableCachedStore
    public void write(Object obj, Object obj2) throws CachedStoreException {
        try {
            this.mgr.writeToStorage(obj, obj2);
        } catch (Exception e) {
            e.printStackTrace();
            throw CachedStoreUtils.toCachedStoreException(e);
        }
    }

    @Override // com.mchange.p006v1.cachedstore.WritableCachedStore
    public void remove(Object obj) throws CachedStoreException {
        try {
            this.mgr.removeFromStorage(obj);
        } catch (Exception e) {
            e.printStackTrace();
            throw CachedStoreUtils.toCachedStoreException(e);
        }
    }

    @Override // com.mchange.p006v1.cachedstore.WritableCachedStore
    public void flushWrites() throws CacheFlushException {
    }

    @Override // com.mchange.p006v1.cachedstore.WritableCachedStore
    public Set getFailedWrites() throws CachedStoreException {
        return Collections.EMPTY_SET;
    }

    @Override // com.mchange.p006v1.cachedstore.WritableCachedStore
    public void clearPendingWrites() throws CachedStoreException {
    }

    @Override // com.mchange.p006v1.cachedstore.WritableCachedStore
    public void sync() throws CachedStoreException {
    }
}
