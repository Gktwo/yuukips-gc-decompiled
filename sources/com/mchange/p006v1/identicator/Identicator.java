package com.mchange.p006v1.identicator;

/* renamed from: com.mchange.v1.identicator.Identicator */
/* loaded from: grasscutter.jar:com/mchange/v1/identicator/Identicator.class */
public interface Identicator {
    boolean identical(Object obj, Object obj2);

    int hash(Object obj);
}
