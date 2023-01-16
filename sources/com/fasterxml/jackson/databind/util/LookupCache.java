package com.fasterxml.jackson.databind.util;

/* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/util/LookupCache.class */
public interface LookupCache<K, V> {
    int size();

    V get(Object obj);

    V put(K k, V v);

    V putIfAbsent(K k, V v);

    void clear();
}
