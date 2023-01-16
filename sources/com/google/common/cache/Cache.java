package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableMap;
import com.google.errorprone.annotations.CompatibleWith;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;

@GwtCompatible
/* loaded from: grasscutter.jar:com/google/common/cache/Cache.class */
public interface Cache<K, V> {
    V getIfPresent(@CompatibleWith("K") Object obj);

    V get(K k, Callable<? extends V> callable) throws ExecutionException;

    ImmutableMap<K, V> getAllPresent(Iterable<?> iterable);

    void put(K k, V v);

    void putAll(Map<? extends K, ? extends V> map);

    void invalidate(@CompatibleWith("K") Object obj);

    void invalidateAll(Iterable<?> iterable);

    void invalidateAll();

    long size();

    CacheStats stats();

    ConcurrentMap<K, V> asMap();

    void cleanUp();
}
