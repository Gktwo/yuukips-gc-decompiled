package com.mchange.util;

import com.mchange.p005io.IOStringEnumeration;

/* loaded from: grasscutter.jar:com/mchange/util/StringEnumeration.class */
public interface StringEnumeration extends MEnumeration, IOStringEnumeration {
    @Override // com.mchange.p005io.IOStringEnumeration
    boolean hasMoreStrings();

    @Override // com.mchange.p005io.IOStringEnumeration
    String nextString();
}
