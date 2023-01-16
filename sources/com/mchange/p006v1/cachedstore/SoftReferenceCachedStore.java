package com.mchange.p006v1.cachedstore;

import com.mchange.p006v1.cachedstore.CachedStore;
import java.lang.ref.SoftReference;

/* renamed from: com.mchange.v1.cachedstore.SoftReferenceCachedStore */
/* loaded from: grasscutter.jar:com/mchange/v1/cachedstore/SoftReferenceCachedStore.class */
class SoftReferenceCachedStore extends ValueTransformingCachedStore {
    public SoftReferenceCachedStore(CachedStore.Manager manager) {
        super(manager);
    }

    @Override // com.mchange.p006v1.cachedstore.ValueTransformingCachedStore
    protected Object toUserValue(Object obj) {
        if (obj == null) {
            return null;
        }
        return ((SoftReference) obj).get();
    }

    @Override // com.mchange.p006v1.cachedstore.ValueTransformingCachedStore
    protected Object toCacheValue(Object obj) {
        if (obj == null) {
            return null;
        }
        return new SoftReference(obj);
    }
}
