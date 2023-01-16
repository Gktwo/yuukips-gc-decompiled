package com.mchange.p006v1.identicator;

/* renamed from: com.mchange.v1.identicator.IdentityHashCodeIdenticator */
/* loaded from: grasscutter.jar:com/mchange/v1/identicator/IdentityHashCodeIdenticator.class */
public class IdentityHashCodeIdenticator implements Identicator {
    public static IdentityHashCodeIdenticator INSTANCE = new IdentityHashCodeIdenticator();

    @Override // com.mchange.p006v1.identicator.Identicator
    public boolean identical(Object obj, Object obj2) {
        return System.identityHashCode(obj) == System.identityHashCode(obj2);
    }

    @Override // com.mchange.p006v1.identicator.Identicator
    public int hash(Object obj) {
        return System.identityHashCode(obj);
    }
}
