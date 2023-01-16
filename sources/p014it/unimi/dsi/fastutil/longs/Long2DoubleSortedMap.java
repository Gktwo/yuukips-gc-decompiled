package p014it.unimi.dsi.fastutil.longs;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.doubles.DoubleCollection;
import p014it.unimi.dsi.fastutil.longs.Long2DoubleMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;

/* renamed from: it.unimi.dsi.fastutil.longs.Long2DoubleSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2DoubleSortedMap.class */
public interface Long2DoubleSortedMap extends Long2DoubleMap, SortedMap<Long, Double> {

    /* renamed from: it.unimi.dsi.fastutil.longs.Long2DoubleSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2DoubleSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet extends ObjectSortedSet<Long2DoubleMap.Entry>, Long2DoubleMap.FastEntrySet {
        @Override // p014it.unimi.dsi.fastutil.longs.Long2DoubleMap.FastEntrySet
        ObjectBidirectionalIterator<Long2DoubleMap.Entry> fastIterator();

        ObjectBidirectionalIterator<Long2DoubleMap.Entry> fastIterator(Long2DoubleMap.Entry entry);
    }

    Long2DoubleSortedMap subMap(long j, long j2);

    Long2DoubleSortedMap headMap(long j);

    Long2DoubleSortedMap tailMap(long j);

    long firstLongKey();

    long lastLongKey();

    ObjectSortedSet<Long2DoubleMap.Entry> long2DoubleEntrySet();

    @Override // p014it.unimi.dsi.fastutil.longs.Long2DoubleMap, java.util.Map
    LongSortedSet keySet();

    @Override // p014it.unimi.dsi.fastutil.longs.Long2DoubleMap, java.util.Map
    DoubleCollection values();

    /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongComparator' to match base method */
    @Override // java.util.SortedMap
    Comparator<? super Long> comparator();

    @Deprecated
    default Long2DoubleSortedMap subMap(Long from, Long to) {
        return subMap(from.longValue(), to.longValue());
    }

    @Deprecated
    default Long2DoubleSortedMap headMap(Long to) {
        return headMap(to.longValue());
    }

    @Deprecated
    default Long2DoubleSortedMap tailMap(Long from) {
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

    @Override // p014it.unimi.dsi.fastutil.longs.Long2DoubleMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<Long, Double>> entrySet() {
        return long2DoubleEntrySet();
    }
}
