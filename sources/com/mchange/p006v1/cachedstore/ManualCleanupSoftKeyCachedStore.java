package com.mchange.p006v1.cachedstore;

import com.mchange.p006v1.cachedstore.CachedStore;
import java.lang.ref.ReferenceQueue;

/* renamed from: com.mchange.v1.cachedstore.ManualCleanupSoftKeyCachedStore */
/* loaded from: grasscutter.jar:com/mchange/v1/cachedstore/ManualCleanupSoftKeyCachedStore.class */
class ManualCleanupSoftKeyCachedStore extends KeyTransformingCachedStore implements Vacuumable {
    ReferenceQueue queue = new ReferenceQueue();

    public ManualCleanupSoftKeyCachedStore(CachedStore.Manager manager) {
        super(manager);
    }

    @Override // com.mchange.p006v1.cachedstore.KeyTransformingCachedStore
    protected Object toUserKey(Object obj) {
        return ((SoftKey) obj).get();
    }

    @Override // com.mchange.p006v1.cachedstore.KeyTransformingCachedStore
    protected Object toCacheFetchKey(Object obj) {
        return new SoftKey(obj, null);
    }

    @Override // com.mchange.p006v1.cachedstore.KeyTransformingCachedStore
    protected Object toCachePutKey(Object obj) {
        return new SoftKey(obj, this.queue);
    }

    @Override // com.mchange.p006v1.cachedstore.Vacuumable
    public void vacuum() throws CachedStoreException {
        while (true) {
            SoftKey softKey = (SoftKey) this.queue.poll();
            if (softKey != null) {
                removeByTransformedKey(softKey);
            } else {
                return;
            }
        }
    }
}
