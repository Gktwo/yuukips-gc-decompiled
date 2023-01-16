package com.mchange.p006v1.cachedstore;

/* renamed from: com.mchange.v1.cachedstore.CachedStore */
/* loaded from: grasscutter.jar:com/mchange/v1/cachedstore/CachedStore.class */
public interface CachedStore {

    /* renamed from: com.mchange.v1.cachedstore.CachedStore$Manager */
    /* loaded from: grasscutter.jar:com/mchange/v1/cachedstore/CachedStore$Manager.class */
    public interface Manager {
        boolean isDirty(Object obj, Object obj2) throws Exception;

        Object recreateFromKey(Object obj) throws Exception;
    }

    Object find(Object obj) throws CachedStoreException;

    void reset() throws CachedStoreException;
}
