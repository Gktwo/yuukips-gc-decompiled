package p014it.unimi.dsi.fastutil.longs;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.floats.FloatCollection;
import p014it.unimi.dsi.fastutil.longs.Long2FloatMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;

/* renamed from: it.unimi.dsi.fastutil.longs.Long2FloatSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2FloatSortedMap.class */
public interface Long2FloatSortedMap extends Long2FloatMap, SortedMap<Long, Float> {

    /* renamed from: it.unimi.dsi.fastutil.longs.Long2FloatSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2FloatSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet extends ObjectSortedSet<Long2FloatMap.Entry>, Long2FloatMap.FastEntrySet {
        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap.FastEntrySet
        ObjectBidirectionalIterator<Long2FloatMap.Entry> fastIterator();

        ObjectBidirectionalIterator<Long2FloatMap.Entry> fastIterator(Long2FloatMap.Entry entry);
    }

    Long2FloatSortedMap subMap(long j, long j2);

    Long2FloatSortedMap headMap(long j);

    Long2FloatSortedMap tailMap(long j);

    long firstLongKey();

    long lastLongKey();

    ObjectSortedSet<Long2FloatMap.Entry> long2FloatEntrySet();

    @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap, java.util.Map
    LongSortedSet keySet();

    @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap, java.util.Map
    FloatCollection values();

    /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongComparator' to match base method */
    @Override // java.util.SortedMap
    Comparator<? super Long> comparator();

    @Deprecated
    default Long2FloatSortedMap subMap(Long from, Long to) {
        return subMap(from.longValue(), to.longValue());
    }

    @Deprecated
    default Long2FloatSortedMap headMap(Long to) {
        return headMap(to.longValue());
    }

    @Deprecated
    default Long2FloatSortedMap tailMap(Long from) {
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

    @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<Long, Float>> entrySet() {
        return long2FloatEntrySet();
    }
}
