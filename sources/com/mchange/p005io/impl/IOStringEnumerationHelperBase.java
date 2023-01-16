package com.mchange.p005io.impl;

import com.mchange.p005io.IOStringEnumeration;
import java.io.IOException;

/* renamed from: com.mchange.io.impl.IOStringEnumerationHelperBase */
/* loaded from: grasscutter.jar:com/mchange/io/impl/IOStringEnumerationHelperBase.class */
public abstract class IOStringEnumerationHelperBase implements IOStringEnumeration {
    @Override // com.mchange.p005io.IOStringEnumeration
    public abstract boolean hasMoreStrings() throws IOException;

    @Override // com.mchange.p005io.IOStringEnumeration
    public abstract String nextString() throws IOException;

    @Override // com.mchange.p005io.IOEnumeration
    public final boolean hasMoreElements() throws IOException {
        return hasMoreStrings();
    }

    @Override // com.mchange.p005io.IOEnumeration
    public final Object nextElement() throws IOException {
        return nextString();
    }
}
