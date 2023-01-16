package com.mchange.p006v1.identicator;

/* renamed from: com.mchange.v1.identicator.StrongIdHashKey */
/* loaded from: grasscutter.jar:com/mchange/v1/identicator/StrongIdHashKey.class */
final class StrongIdHashKey extends IdHashKey {
    Object keyObj;

    public StrongIdHashKey(Object obj, Identicator identicator) {
        super(identicator);
        this.keyObj = obj;
    }

    @Override // com.mchange.p006v1.identicator.IdHashKey
    public Object getKeyObj() {
        return this.keyObj;
    }

    @Override // com.mchange.p006v1.identicator.IdHashKey
    public boolean equals(Object obj) {
        if (obj instanceof StrongIdHashKey) {
            return this.f379id.identical(this.keyObj, ((StrongIdHashKey) obj).keyObj);
        }
        return false;
    }

    @Override // com.mchange.p006v1.identicator.IdHashKey
    public int hashCode() {
        return this.f379id.hash(this.keyObj);
    }
}
