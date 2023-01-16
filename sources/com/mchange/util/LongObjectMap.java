package com.mchange.util;

/* loaded from: grasscutter.jar:com/mchange/util/LongObjectMap.class */
public interface LongObjectMap {
    Object get(long j);

    void put(long j, Object obj);

    boolean putNoReplace(long j, Object obj);

    Object remove(long j);

    boolean containsLong(long j);

    long getSize();
}
