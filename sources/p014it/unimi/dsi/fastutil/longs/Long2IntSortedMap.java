package p014it.unimi.dsi.fastutil.longs;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.ints.IntCollection;
import p014it.unimi.dsi.fastutil.longs.Long2IntMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;

/* renamed from: it.unimi.dsi.fastutil.longs.Long2IntSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2IntSortedMap.class */
public interface Long2IntSortedMap extends Long2IntMap, SortedMap<Long, Integer> {

    /* renamed from: it.unimi.dsi.fastutil.longs.Long2IntSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2IntSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet extends ObjectSortedSet<Long2IntMap.Entry>, Long2IntMap.FastEntrySet {
        @Override // p014it.unimi.dsi.fastutil.longs.Long2IntMap.FastEntrySet
        ObjectBidirectionalIterator<Long2IntMap.Entry> fastIterator();

        ObjectBidirectionalIterator<Long2IntMap.Entry> fastIterator(Long2IntMap.Entry entry);
    }

    Long2IntSortedMap subMap(long j, long j2);

    Long2IntSortedMap headMap(long j);

    Long2IntSortedMap tailMap(long j);

    long firstLongKey();

    long lastLongKey();

    ObjectSortedSet<Long2IntMap.Entry> long2IntEntrySet();

    @Override // p014it.unimi.dsi.fastutil.longs.Long2IntMap, java.util.Map
    LongSortedSet keySet();

    @Override // p014it.unimi.dsi.fastutil.longs.Long2IntMap, java.util.Map
    IntCollection values();

    /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongComparator' to match base method */
    @Override // java.util.SortedMap
    Comparator<? super Long> comparator();

    @Deprecated
    default Long2IntSortedMap subMap(Long from, Long to) {
        return subMap(from.longValue(), to.longValue());
    }

    @Deprecated
    default Long2IntSortedMap headMap(Long to) {
        return headMap(to.longValue());
    }

    @Deprecated
    default Long2IntSortedMap tailMap(Long from) {
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

    @Override // p014it.unimi.dsi.fastutil.longs.Long2IntMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<Long, Integer>> entrySet() {
        return long2IntEntrySet();
    }
}
