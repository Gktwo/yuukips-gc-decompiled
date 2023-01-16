package com.mchange.p006v1.cachedstore;

import java.util.Iterator;

/* renamed from: com.mchange.v1.cachedstore.TweakableCachedStore */
/* loaded from: grasscutter.jar:com/mchange/v1/cachedstore/TweakableCachedStore.class */
public interface TweakableCachedStore extends CachedStore {
    Object getCachedValue(Object obj) throws CachedStoreException;

    void removeFromCache(Object obj) throws CachedStoreException;

    void setCachedValue(Object obj, Object obj2) throws CachedStoreException;

    Iterator cachedKeys() throws CachedStoreException;
}
