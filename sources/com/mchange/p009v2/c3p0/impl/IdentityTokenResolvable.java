package com.mchange.p009v2.c3p0.impl;

import com.mchange.p009v2.c3p0.C3P0Registry;
import java.io.ObjectStreamException;

/* renamed from: com.mchange.v2.c3p0.impl.IdentityTokenResolvable */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/impl/IdentityTokenResolvable.class */
public abstract class IdentityTokenResolvable extends AbstractIdentityTokenized {
    public static Object doResolve(IdentityTokenized itd) {
        return C3P0Registry.reregister(itd);
    }

    protected Object readResolve() throws ObjectStreamException {
        Object out = doResolve(this);
        verifyResolve(out);
        return out;
    }

    protected void verifyResolve(Object o) throws ObjectStreamException {
    }
}
