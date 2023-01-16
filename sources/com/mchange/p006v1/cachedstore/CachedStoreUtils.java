package com.mchange.p006v1.cachedstore;

import com.mchange.lang.PotentiallySecondary;
import com.mchange.p006v1.lang.Synchronizer;

/* renamed from: com.mchange.v1.cachedstore.CachedStoreUtils */
/* loaded from: grasscutter.jar:com/mchange/v1/cachedstore/CachedStoreUtils.class */
public final class CachedStoreUtils {
    static final boolean DEBUG = true;

    public static CachedStore synchronizedCachedStore(CachedStore cachedStore) {
        return (CachedStore) Synchronizer.createSynchronizedWrapper(cachedStore);
    }

    public static TweakableCachedStore synchronizedTweakableCachedStore(TweakableCachedStore tweakableCachedStore) {
        return (TweakableCachedStore) Synchronizer.createSynchronizedWrapper(tweakableCachedStore);
    }

    public static WritableCachedStore synchronizedWritableCachedStore(WritableCachedStore writableCachedStore) {
        return (WritableCachedStore) Synchronizer.createSynchronizedWrapper(writableCachedStore);
    }

    public static CachedStore untweakableCachedStore(final TweakableCachedStore tweakableCachedStore) {
        return new CachedStore() { // from class: com.mchange.v1.cachedstore.CachedStoreUtils.1
            @Override // com.mchange.p006v1.cachedstore.CachedStore
            public Object find(Object obj) throws CachedStoreException {
                return tweakableCachedStore.find(obj);
            }

            @Override // com.mchange.p006v1.cachedstore.CachedStore
            public void reset() throws CachedStoreException {
                tweakableCachedStore.reset();
            }
        };
    }

    /* access modifiers changed from: package-private */
    public static CachedStoreException toCachedStoreException(Throwable th) {
        th.printStackTrace();
        if (th instanceof CachedStoreException) {
            return (CachedStoreException) th;
        }
        if (th instanceof PotentiallySecondary) {
            Throwable nestedThrowable = ((PotentiallySecondary) th).getNestedThrowable();
            if (nestedThrowable instanceof CachedStoreException) {
                return (CachedStoreException) nestedThrowable;
            }
        }
        return new CachedStoreException(th);
    }

    static CacheFlushException toCacheFlushException(Throwable th) {
        th.printStackTrace();
        if (th instanceof CacheFlushException) {
            return (CacheFlushException) th;
        }
        return new CacheFlushException(th);
    }

    private CachedStoreUtils() {
    }
}
