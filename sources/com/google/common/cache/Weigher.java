package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;

@FunctionalInterface
@GwtCompatible
/* loaded from: grasscutter.jar:com/google/common/cache/Weigher.class */
public interface Weigher<K, V> {
    int weigh(K k, V v);
}
