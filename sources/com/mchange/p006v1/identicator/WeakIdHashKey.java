package com.mchange.p006v1.identicator;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* renamed from: com.mchange.v1.identicator.WeakIdHashKey */
/* loaded from: grasscutter.jar:com/mchange/v1/identicator/WeakIdHashKey.class */
final class WeakIdHashKey extends IdHashKey {
    Ref keyRef;
    int hash;

    public WeakIdHashKey(Object obj, Identicator identicator, ReferenceQueue referenceQueue) {
        super(identicator);
        if (obj == null) {
            throw new UnsupportedOperationException("Collection does not accept nulls!");
        }
        this.keyRef = new Ref(obj, referenceQueue);
        this.hash = identicator.hash(obj);
    }

    public Ref getInternalRef() {
        return this.keyRef;
    }

    @Override // com.mchange.p006v1.identicator.IdHashKey
    public Object getKeyObj() {
        return this.keyRef.get();
    }

    @Override // com.mchange.p006v1.identicator.IdHashKey
    public boolean equals(Object obj) {
        if (!(obj instanceof WeakIdHashKey)) {
            return false;
        }
        WeakIdHashKey weakIdHashKey = (WeakIdHashKey) obj;
        if (this.keyRef == weakIdHashKey.keyRef) {
            return true;
        }
        Object obj2 = this.keyRef.get();
        Object obj3 = weakIdHashKey.keyRef.get();
        if (obj2 == null || obj3 == null) {
            return false;
        }
        return this.f379id.identical(obj2, obj3);
    }

    @Override // com.mchange.p006v1.identicator.IdHashKey
    public int hashCode() {
        return this.hash;
    }

    /* renamed from: com.mchange.v1.identicator.WeakIdHashKey$Ref */
    /* loaded from: grasscutter.jar:com/mchange/v1/identicator/WeakIdHashKey$Ref.class */
    class Ref extends WeakReference {
        public Ref(Object obj, ReferenceQueue referenceQueue) {
            super(obj, referenceQueue);
        }

        /* access modifiers changed from: package-private */
        public WeakIdHashKey getKey() {
            return WeakIdHashKey.this;
        }
    }
}
