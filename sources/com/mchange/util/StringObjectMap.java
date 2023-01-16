package com.mchange.util;

import com.mchange.p005io.IOStringEnumeration;
import com.mchange.p005io.IOStringObjectMap;

/* loaded from: grasscutter.jar:com/mchange/util/StringObjectMap.class */
public interface StringObjectMap extends IOStringObjectMap {
    @Override // com.mchange.p005io.IOStringObjectMap
    Object get(String str);

    @Override // com.mchange.p005io.IOStringObjectMap
    void put(String str, Object obj);

    @Override // com.mchange.p005io.IOStringObjectMap
    boolean putNoReplace(String str, Object obj);

    @Override // com.mchange.p005io.IOStringObjectMap
    boolean remove(String str);

    @Override // com.mchange.p005io.IOStringObjectMap
    boolean containsKey(String str);

    @Override // com.mchange.p005io.IOStringObjectMap
    IOStringEnumeration keys();

    StringEnumeration mkeys();
}
