package com.mchange.p005io;

import java.io.IOException;

/* renamed from: com.mchange.io.IOStringObjectMap */
/* loaded from: grasscutter.jar:com/mchange/io/IOStringObjectMap.class */
public interface IOStringObjectMap {
    Object get(String str) throws IOException;

    void put(String str, Object obj) throws IOException;

    boolean putNoReplace(String str, Object obj) throws IOException;

    boolean remove(String str) throws IOException;

    boolean containsKey(String str) throws IOException;

    IOStringEnumeration keys() throws IOException;
}
