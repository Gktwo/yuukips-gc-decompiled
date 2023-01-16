package p014it.unimi.dsi.fastutil.longs;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.longs.Long2LongMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;

/* renamed from: it.unimi.dsi.fastutil.longs.Long2LongSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2LongSortedMap.class */
public interface Long2LongSortedMap extends Long2LongMap, SortedMap<Long, Long> {

    /* renamed from: it.unimi.dsi.fastutil.longs.Long2LongSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2LongSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet extends ObjectSortedSet<Long2LongMap.Entry>, Long2LongMap.FastEntrySet {
        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongMap.FastEntrySet
        ObjectBidirectionalIterator<Long2LongMap.Entry> fastIterator();

        ObjectBidirectionalIterator<Long2LongMap.Entry> fastIterator(Long2LongMap.Entry entry);
    }

    Long2LongSortedMap subMap(long j, long j2);

    Long2LongSortedMap headMap(long j);

    Long2LongSortedMap tailMap(long j);

    long firstLongKey();

    long lastLongKey();

    ObjectSortedSet<Long2LongMap.Entry> long2LongEntrySet();

    @Override // p014it.unimi.dsi.fastutil.longs.Long2LongMap, java.util.Map
    LongSortedSet keySet();

    @Override // p014it.unimi.dsi.fastutil.longs.Long2LongMap, java.util.Map
    LongCollection values();

    /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongComparator' to match base method */
    @Override // java.util.SortedMap
    Comparator<? super Long> comparator();

    @Deprecated
    default Long2LongSortedMap subMap(Long from, Long to) {
        return subMap(from.longValue(), to.longValue());
    }

    @Deprecated
    default Long2LongSortedMap headMap(Long to) {
        return headMap(to.longValue());
    }

    @Deprecated
    default Long2LongSortedMap tailMap(Long from) {
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

    @Override // p014it.unimi.dsi.fastutil.longs.Long2LongMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<Long, Long>> entrySet() {
        return long2LongEntrySet();
    }
}
