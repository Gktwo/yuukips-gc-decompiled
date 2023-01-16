package com.mchange.p006v1.cachedstore;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

/* access modifiers changed from: package-private */
/* renamed from: com.mchange.v1.cachedstore.SoftKey */
/* loaded from: grasscutter.jar:com/mchange/v1/cachedstore/SoftKey.class */
public final class SoftKey extends SoftReference {
    int hash_code;

    /* access modifiers changed from: package-private */
    public SoftKey(Object obj, ReferenceQueue referenceQueue) {
        super(obj, referenceQueue);
        this.hash_code = obj.hashCode();
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.hash_code;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        Object obj2 = get();
        if (obj2 != null && getClass() == obj.getClass()) {
            return obj2.equals(((SoftKey) obj).get());
        }
        return false;
    }
}
