package com.mchange.util.impl;

import com.mchange.util.StringEnumeration;

/* loaded from: grasscutter.jar:com/mchange/util/impl/StringEnumerationHelperBase.class */
public abstract class StringEnumerationHelperBase implements StringEnumeration {
    @Override // com.mchange.util.StringEnumeration, com.mchange.p005io.IOStringEnumeration
    public abstract boolean hasMoreStrings();

    @Override // com.mchange.util.StringEnumeration, com.mchange.p005io.IOStringEnumeration
    public abstract String nextString();

    @Override // com.mchange.util.MEnumeration, com.mchange.p005io.IOEnumeration
    public final boolean hasMoreElements() {
        return hasMoreStrings();
    }

    @Override // com.mchange.util.MEnumeration, com.mchange.p005io.IOEnumeration
    public final Object nextElement() {
        return nextString();
    }
}
