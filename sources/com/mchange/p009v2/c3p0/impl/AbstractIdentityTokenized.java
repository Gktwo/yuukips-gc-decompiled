package com.mchange.p009v2.c3p0.impl;

/* renamed from: com.mchange.v2.c3p0.impl.AbstractIdentityTokenized */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/impl/AbstractIdentityTokenized.class */
public abstract class AbstractIdentityTokenized implements IdentityTokenized {
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof IdentityTokenized) {
            return getIdentityToken().equals(((IdentityTokenized) o).getIdentityToken());
        }
        return false;
    }

    public int hashCode() {
        return getIdentityToken().hashCode() ^ -1;
    }
}
