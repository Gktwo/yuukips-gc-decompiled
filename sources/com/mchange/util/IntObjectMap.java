package com.mchange.util;

/* loaded from: grasscutter.jar:com/mchange/util/IntObjectMap.class */
public interface IntObjectMap {
    Object get(int i);

    void put(int i, Object obj);

    boolean putNoReplace(int i, Object obj);

    Object remove(int i);

    boolean containsInt(int i);

    int getSize();

    void clear();

    IntEnumeration ints();
}
