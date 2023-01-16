package com.mchange.p006v1.identicator;

/* renamed from: com.mchange.v1.identicator.StrongIdentityIdenticator */
/* loaded from: grasscutter.jar:com/mchange/v1/identicator/StrongIdentityIdenticator.class */
public class StrongIdentityIdenticator implements Identicator {
    @Override // com.mchange.p006v1.identicator.Identicator
    public boolean identical(Object obj, Object obj2) {
        return obj == obj2;
    }

    @Override // com.mchange.p006v1.identicator.Identicator
    public int hash(Object obj) {
        return System.identityHashCode(obj);
    }
}
