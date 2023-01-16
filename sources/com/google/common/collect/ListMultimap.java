package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@GwtCompatible
/* loaded from: grasscutter.jar:com/google/common/collect/ListMultimap.class */
public interface ListMultimap<K, V> extends Multimap<K, V> {
    List<V> get(K k);

    @CanIgnoreReturnValue
    List<V> removeAll(Object obj);

    @CanIgnoreReturnValue
    List<V> replaceValues(K k, Iterable<? extends V> iterable);

    Map<K, Collection<V>> asMap();

    @Override // com.google.common.collect.ListMultimap
    boolean equals(Object obj);
}
