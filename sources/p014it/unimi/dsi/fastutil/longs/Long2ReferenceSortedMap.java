package p014it.unimi.dsi.fastutil.longs;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.longs.Long2ReferenceMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ReferenceCollection;

/* renamed from: it.unimi.dsi.fastutil.longs.Long2ReferenceSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2ReferenceSortedMap.class */
public interface Long2ReferenceSortedMap<V> extends Long2ReferenceMap<V>, SortedMap<Long, V> {

    /* renamed from: it.unimi.dsi.fastutil.longs.Long2ReferenceSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2ReferenceSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet<V> extends ObjectSortedSet<Long2ReferenceMap.Entry<V>>, Long2ReferenceMap.FastEntrySet<V> {
        @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceMap.FastEntrySet
        ObjectBidirectionalIterator<Long2ReferenceMap.Entry<V>> fastIterator();

        ObjectBidirectionalIterator<Long2ReferenceMap.Entry<V>> fastIterator(Long2ReferenceMap.Entry<V> entry);
    }

    Long2ReferenceSortedMap<V> subMap(long j, long j2);

    Long2ReferenceSortedMap<V> headMap(long j);

    Long2ReferenceSortedMap<V> tailMap(long j);

    long firstLongKey();

    long lastLongKey();

    ObjectSortedSet<Long2ReferenceMap.Entry<V>> long2ReferenceEntrySet();

    @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceMap, java.util.Map
    LongSortedSet keySet();

    @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceMap, java.util.Map
    ReferenceCollection<V> values();

    /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongComparator' to match base method */
    @Override // java.util.SortedMap
    Comparator<? super Long> comparator();

    @Deprecated
    default Long2ReferenceSortedMap<V> subMap(Long from, Long to) {
        return subMap(from.longValue(), to.longValue());
    }

    @Deprecated
    default Long2ReferenceSortedMap<V> headMap(Long to) {
        return headMap(to.longValue());
    }

    @Deprecated
    default Long2ReferenceSortedMap<V> tailMap(Long from) {
        return tailMap(from.longValue());
    }

    @Override // java.util.SortedMap
    @Deprecated
    default Long firstKey() {
        return Long.valueOf(firstLongKey());
    }

    @Override // java.util.SortedMap
    @Deprecated
    default Long lastKey() {
        return Long.valueOf(lastLongKey());
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<Long, V>> entrySet() {
        return long2ReferenceEntrySet();
    }
}
