package p014it.unimi.dsi.fastutil.longs;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.booleans.BooleanCollection;
import p014it.unimi.dsi.fastutil.longs.Long2BooleanMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;

/* renamed from: it.unimi.dsi.fastutil.longs.Long2BooleanSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2BooleanSortedMap.class */
public interface Long2BooleanSortedMap extends Long2BooleanMap, SortedMap<Long, Boolean> {

    /* renamed from: it.unimi.dsi.fastutil.longs.Long2BooleanSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2BooleanSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet extends ObjectSortedSet<Long2BooleanMap.Entry>, Long2BooleanMap.FastEntrySet {
        @Override // p014it.unimi.dsi.fastutil.longs.Long2BooleanMap.FastEntrySet
        ObjectBidirectionalIterator<Long2BooleanMap.Entry> fastIterator();

        ObjectBidirectionalIterator<Long2BooleanMap.Entry> fastIterator(Long2BooleanMap.Entry entry);
    }

    Long2BooleanSortedMap subMap(long j, long j2);

    Long2BooleanSortedMap headMap(long j);

    Long2BooleanSortedMap tailMap(long j);

    long firstLongKey();

    long lastLongKey();

    ObjectSortedSet<Long2BooleanMap.Entry> long2BooleanEntrySet();

    @Override // p014it.unimi.dsi.fastutil.longs.Long2BooleanMap, java.util.Map
    LongSortedSet keySet();

    @Override // p014it.unimi.dsi.fastutil.longs.Long2BooleanMap, java.util.Map
    BooleanCollection values();

    /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongComparator' to match base method */
    @Override // java.util.SortedMap
    Comparator<? super Long> comparator();

    @Deprecated
    default Long2BooleanSortedMap subMap(Long from, Long to) {
        return subMap(from.longValue(), to.longValue());
    }

    @Deprecated
    default Long2BooleanSortedMap headMap(Long to) {
        return headMap(to.longValue());
    }

    @Deprecated
    default Long2BooleanSortedMap tailMap(Long from) {
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

    @Override // p014it.unimi.dsi.fastutil.longs.Long2BooleanMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<Long, Boolean>> entrySet() {
        return long2BooleanEntrySet();
    }
}
