package com.mchange.p006v1.cachedstore;

import com.mchange.p006v1.cachedstore.CachedStore;
import java.util.Set;

/* renamed from: com.mchange.v1.cachedstore.WritableCachedStore */
/* loaded from: grasscutter.jar:com/mchange/v1/cachedstore/WritableCachedStore.class */
public interface WritableCachedStore extends CachedStore {

    /* renamed from: com.mchange.v1.cachedstore.WritableCachedStore$Manager */
    /* loaded from: grasscutter.jar:com/mchange/v1/cachedstore/WritableCachedStore$Manager.class */
    public interface Manager extends CachedStore.Manager {
        void writeToStorage(Object obj, Object obj2) throws Exception;

        void removeFromStorage(Object obj) throws Exception;
    }

    void write(Object obj, Object obj2) throws CachedStoreException;

    void remove(Object obj) throws CachedStoreException;

    void flushWrites() throws CacheFlushException;

    Set getFailedWrites() throws CachedStoreException;

    void clearPendingWrites() throws CachedStoreException;

    @Override // com.mchange.p006v1.cachedstore.CachedStore
    void reset() throws CachedStoreException;

    void sync() throws CachedStoreException;
}
