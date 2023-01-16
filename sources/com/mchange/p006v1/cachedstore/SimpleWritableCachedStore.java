package com.mchange.p006v1.cachedstore;

import com.mchange.p006v1.cachedstore.WritableCachedStore;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.mchange.v1.cachedstore.SimpleWritableCachedStore */
/* loaded from: grasscutter.jar:com/mchange/v1/cachedstore/SimpleWritableCachedStore.class */
class SimpleWritableCachedStore implements WritableCachedStore {
    private static final Object REMOVE_TOKEN = new Object();
    TweakableCachedStore readOnlyCache;
    WritableCachedStore.Manager manager;
    HashMap writeCache = new HashMap();
    Set failedWrites = null;

    /* access modifiers changed from: package-private */
    public SimpleWritableCachedStore(TweakableCachedStore tweakableCachedStore, WritableCachedStore.Manager manager) {
        this.readOnlyCache = tweakableCachedStore;
        this.manager = manager;
    }

    @Override // com.mchange.p006v1.cachedstore.CachedStore
    public Object find(Object obj) throws CachedStoreException {
        Object obj2 = this.writeCache.get(obj);
        if (obj2 == null) {
            obj2 = this.readOnlyCache.find(obj);
        }
        if (obj2 == REMOVE_TOKEN) {
            return null;
        }
        return obj2;
    }

    @Override // com.mchange.p006v1.cachedstore.WritableCachedStore
    public void write(Object obj, Object obj2) {
        this.writeCache.put(obj, obj2);
    }

    @Override // com.mchange.p006v1.cachedstore.WritableCachedStore
    public void remove(Object obj) {
        write(obj, REMOVE_TOKEN);
    }

    @Override // com.mchange.p006v1.cachedstore.WritableCachedStore
    public void flushWrites() throws CacheFlushException {
        HashMap hashMap = (HashMap) this.writeCache.clone();
        for (Object obj : hashMap.keySet()) {
            Object obj2 = hashMap.get(obj);
            try {
                if (obj2 == REMOVE_TOKEN) {
                    this.manager.removeFromStorage(obj);
                } else {
                    this.manager.writeToStorage(obj, obj2);
                }
                this.readOnlyCache.setCachedValue(obj, obj2);
                this.writeCache.remove(obj);
                if (this.failedWrites != null) {
                    this.failedWrites.remove(obj);
                    if (this.failedWrites.size() == 0) {
                        try {
                            this.failedWrites = null;
                        } catch (CachedStoreException e) {
                            throw new CachedStoreError("SimpleWritableCachedStore: Internal cache is broken!");
                            break;
                        }
                    }
                }
            } catch (Exception e2) {
                if (this.failedWrites == null) {
                    this.failedWrites = new HashSet();
                }
                this.failedWrites.add(obj);
            }
        }
        if (this.failedWrites != null) {
            throw new CacheFlushException("Some keys failed to write!");
        }
    }

    @Override // com.mchange.p006v1.cachedstore.WritableCachedStore
    public Set getFailedWrites() {
        if (this.failedWrites == null) {
            return null;
        }
        return Collections.unmodifiableSet(this.failedWrites);
    }

    @Override // com.mchange.p006v1.cachedstore.WritableCachedStore
    public void clearPendingWrites() {
        this.writeCache.clear();
        this.failedWrites = null;
    }

    @Override // com.mchange.p006v1.cachedstore.WritableCachedStore, com.mchange.p006v1.cachedstore.CachedStore
    public void reset() throws CachedStoreException {
        this.writeCache.clear();
        this.readOnlyCache.reset();
        this.failedWrites = null;
    }

    @Override // com.mchange.p006v1.cachedstore.WritableCachedStore
    public void sync() throws CachedStoreException {
        flushWrites();
        reset();
    }
}
