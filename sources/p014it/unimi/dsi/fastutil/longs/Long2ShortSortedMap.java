package p014it.unimi.dsi.fastutil.longs;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.longs.Long2ShortMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.shorts.ShortCollection;

/* renamed from: it.unimi.dsi.fastutil.longs.Long2ShortSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2ShortSortedMap.class */
public interface Long2ShortSortedMap extends Long2ShortMap, SortedMap<Long, Short> {

    /* renamed from: it.unimi.dsi.fastutil.longs.Long2ShortSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2ShortSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet extends ObjectSortedSet<Long2ShortMap.Entry>, Long2ShortMap.FastEntrySet {
        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortMap.FastEntrySet
        ObjectBidirectionalIterator<Long2ShortMap.Entry> fastIterator();

        ObjectBidirectionalIterator<Long2ShortMap.Entry> fastIterator(Long2ShortMap.Entry entry);
    }

    Long2ShortSortedMap subMap(long j, long j2);

    Long2ShortSortedMap headMap(long j);

    Long2ShortSortedMap tailMap(long j);

    long firstLongKey();

    long lastLongKey();

    ObjectSortedSet<Long2ShortMap.Entry> long2ShortEntrySet();

    @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortMap, java.util.Map
    LongSortedSet keySet();

    @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortMap, java.util.Map
    ShortCollection values();

    /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongComparator' to match base method */
    @Override // java.util.SortedMap
    Comparator<? super Long> comparator();

    @Deprecated
    default Long2ShortSortedMap subMap(Long from, Long to) {
        return subMap(from.longValue(), to.longValue());
    }

    @Deprecated
    default Long2ShortSortedMap headMap(Long to) {
        return headMap(to.longValue());
    }

    @Deprecated
    default Long2ShortSortedMap tailMap(Long from) {
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

    @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<Long, Short>> entrySet() {
        return long2ShortEntrySet();
    }
}
