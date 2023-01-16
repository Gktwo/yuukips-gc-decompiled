package com.mchange.p006v1.cachedstore;

import com.mchange.lang.PotentiallySecondaryError;

/* renamed from: com.mchange.v1.cachedstore.CachedStoreError */
/* loaded from: grasscutter.jar:com/mchange/v1/cachedstore/CachedStoreError.class */
public class CachedStoreError extends PotentiallySecondaryError {
    public CachedStoreError(String str, Throwable th) {
        super(str, th);
    }

    public CachedStoreError(Throwable th) {
        super(th);
    }

    public CachedStoreError(String str) {
        super(str);
    }

    public CachedStoreError() {
    }
}
