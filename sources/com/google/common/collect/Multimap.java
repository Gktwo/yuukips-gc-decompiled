package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.CompatibleWith;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

@GwtCompatible
/* loaded from: grasscutter.jar:com/google/common/collect/Multimap.class */
public interface Multimap<K, V> {
    int size();

    boolean isEmpty();

    boolean containsKey(@CompatibleWith("K") Object obj);

    boolean containsValue(@CompatibleWith("V") Object obj);

    boolean containsEntry(@CompatibleWith("K") Object obj, @CompatibleWith("V") Object obj2);

    @CanIgnoreReturnValue
    boolean put(K k, V v);

    @CanIgnoreReturnValue
    boolean remove(@CompatibleWith("K") Object obj, @CompatibleWith("V") Object obj2);

    @CanIgnoreReturnValue
    boolean putAll(K k, Iterable<? extends V> iterable);

    @CanIgnoreReturnValue
    boolean putAll(Multimap<? extends K, ? extends V> multimap);

    @Override // com.google.common.collect.ListMultimap
    @CanIgnoreReturnValue
    Collection<V> replaceValues(K k, Iterable<? extends V> iterable);

    @Override // com.google.common.collect.ListMultimap
    @CanIgnoreReturnValue
    Collection<V> removeAll(@CompatibleWith("K") Object obj);

    void clear();

    @Override // com.google.common.collect.ListMultimap
    Collection<V> get(K k);

    Set<K> keySet();

    Multiset<K> keys();

    Collection<V> values();

    Collection<Map.Entry<K, V>> entries();

    @Override // com.google.common.collect.ListMultimap
    Map<K, Collection<V>> asMap();

    @Override // java.lang.Object, com.google.common.collect.ListMultimap
    boolean equals(Object obj);

    int hashCode();

    default void forEach(BiConsumer<? super K, ? super V> action) {
        Preconditions.checkNotNull(action);
        entries().forEach(entry -> {
            action.accept(entry.getKey(), entry.getValue());
        });
    }
}
