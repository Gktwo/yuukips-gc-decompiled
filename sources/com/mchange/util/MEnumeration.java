package com.mchange.util;

import com.mchange.p005io.IOEnumeration;
import com.mchange.util.impl.EmptyMEnumeration;
import java.util.Enumeration;

/* loaded from: grasscutter.jar:com/mchange/util/MEnumeration.class */
public interface MEnumeration extends IOEnumeration, Enumeration {
    public static final MEnumeration EMPTY = EmptyMEnumeration.SINGLETON;

    @Override // com.mchange.p005io.IOEnumeration
    Object nextElement();

    @Override // com.mchange.p005io.IOEnumeration
    boolean hasMoreElements();
}
