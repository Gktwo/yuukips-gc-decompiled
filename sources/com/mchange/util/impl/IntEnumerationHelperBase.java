package com.mchange.util.impl;

import com.mchange.util.IntEnumeration;

/* loaded from: grasscutter.jar:com/mchange/util/impl/IntEnumerationHelperBase.class */
public abstract class IntEnumerationHelperBase implements IntEnumeration {
    @Override // com.mchange.util.IntEnumeration
    public abstract boolean hasMoreInts();

    @Override // com.mchange.util.IntEnumeration
    public abstract int nextInt();

    @Override // com.mchange.util.MEnumeration, com.mchange.p005io.IOEnumeration
    public final boolean hasMoreElements() {
        return hasMoreInts();
    }

    @Override // com.mchange.util.MEnumeration, com.mchange.p005io.IOEnumeration
    public final Object nextElement() {
        return new Integer(nextInt());
    }
}
