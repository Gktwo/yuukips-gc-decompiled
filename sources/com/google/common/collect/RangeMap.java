package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import java.lang.Comparable;
import java.util.Map;

@Beta
@GwtIncompatible
/* loaded from: grasscutter.jar:com/google/common/collect/RangeMap.class */
public interface RangeMap<K extends Comparable, V> {
    V get(K k);

    Map.Entry<Range<K>, V> getEntry(K k);

    Range<K> span();

    void put(Range<K> range, V v);

    void putCoalescing(Range<K> range, V v);

    void putAll(RangeMap<K, V> rangeMap);

    void clear();

    void remove(Range<K> range);

    Map<Range<K>, V> asMapOfRanges();

    Map<Range<K>, V> asDescendingMapOfRanges();

    RangeMap<K, V> subRangeMap(Range<K> range);

    @Override // java.lang.Object
    boolean equals(Object obj);

    @Override // java.lang.Object
    int hashCode();

    @Override // java.lang.Object
    String toString();
}
