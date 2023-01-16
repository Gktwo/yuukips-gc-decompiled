package com.mchange.p006v1.cachedstore;

/* renamed from: com.mchange.v1.cachedstore.CacheFlushException */
/* loaded from: grasscutter.jar:com/mchange/v1/cachedstore/CacheFlushException.class */
public class CacheFlushException extends CachedStoreException {
    public CacheFlushException(String str, Throwable th) {
        super(str, th);
    }

    public CacheFlushException(Throwable th) {
        super(th);
    }

    public CacheFlushException(String str) {
        super(str);
    }

    public CacheFlushException() {
    }
}
