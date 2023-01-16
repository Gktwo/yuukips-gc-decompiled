package com.mchange.p006v1.identicator;

/* renamed from: com.mchange.v1.identicator.IdHashKey */
/* loaded from: grasscutter.jar:com/mchange/v1/identicator/IdHashKey.class */
abstract class IdHashKey {

    /* renamed from: id */
    Identicator f379id;

    public abstract Object getKeyObj();

    public abstract boolean equals(Object obj);

    public abstract int hashCode();

    public IdHashKey(Identicator identicator) {
        this.f379id = identicator;
    }

    public Identicator getIdenticator() {
        return this.f379id;
    }
}
