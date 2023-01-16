package p014it.unimi.dsi.fastutil.longs;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectCollection;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;

/* renamed from: it.unimi.dsi.fastutil.longs.Long2ObjectSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2ObjectSortedMap.class */
public interface Long2ObjectSortedMap<V> extends Long2ObjectMap<V>, SortedMap<Long, V> {

    /* renamed from: it.unimi.dsi.fastutil.longs.Long2ObjectSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2ObjectSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet<V> extends ObjectSortedSet<Long2ObjectMap.Entry<V>>, Long2ObjectMap.FastEntrySet<V> {
        @Override // p014it.unimi.dsi.fastutil.longs.Long2ObjectMap.FastEntrySet
        ObjectBidirectionalIterator<Long2ObjectMap.Entry<V>> fastIterator();

        ObjectBidirectionalIterator<Long2ObjectMap.Entry<V>> fastIterator(Long2ObjectMap.Entry<V> entry);
    }

    Long2ObjectSortedMap<V> subMap(long j, long j2);

    Long2ObjectSortedMap<V> headMap(long j);

    Long2ObjectSortedMap<V> tailMap(long j);

    long firstLongKey();

    long lastLongKey();

    ObjectSortedSet<Long2ObjectMap.Entry<V>> long2ObjectEntrySet();

    @Override // p014it.unimi.dsi.fastutil.longs.Long2ObjectMap, java.util.Map
    LongSortedSet keySet();

    @Override // p014it.unimi.dsi.fastutil.longs.Long2ObjectMap, java.util.Map
    ObjectCollection<V> values();

    /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongComparator' to match base method */
    @Override // java.util.SortedMap
    Comparator<? super Long> comparator();

    @Deprecated
    default Long2ObjectSortedMap<V> subMap(Long from, Long to) {
        return subMap(from.longValue(), to.longValue());
    }

    @Deprecated
    default Long2ObjectSortedMap<V> headMap(Long to) {
        return headMap(to.longValue());
    }

    @Deprecated
    default Long2ObjectSortedMap<V> tailMap(Long from) {
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

    @Override // p014it.unimi.dsi.fastutil.longs.Long2ObjectMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<Long, V>> entrySet() {
        return long2ObjectEntrySet();
    }
}
