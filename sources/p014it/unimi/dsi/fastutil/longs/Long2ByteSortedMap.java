package p014it.unimi.dsi.fastutil.longs;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.bytes.ByteCollection;
import p014it.unimi.dsi.fastutil.longs.Long2ByteMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;

/* renamed from: it.unimi.dsi.fastutil.longs.Long2ByteSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2ByteSortedMap.class */
public interface Long2ByteSortedMap extends Long2ByteMap, SortedMap<Long, Byte> {

    /* renamed from: it.unimi.dsi.fastutil.longs.Long2ByteSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2ByteSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet extends ObjectSortedSet<Long2ByteMap.Entry>, Long2ByteMap.FastEntrySet {
        @Override // p014it.unimi.dsi.fastutil.longs.Long2ByteMap.FastEntrySet
        ObjectBidirectionalIterator<Long2ByteMap.Entry> fastIterator();

        ObjectBidirectionalIterator<Long2ByteMap.Entry> fastIterator(Long2ByteMap.Entry entry);
    }

    Long2ByteSortedMap subMap(long j, long j2);

    Long2ByteSortedMap headMap(long j);

    Long2ByteSortedMap tailMap(long j);

    long firstLongKey();

    long lastLongKey();

    ObjectSortedSet<Long2ByteMap.Entry> long2ByteEntrySet();

    @Override // p014it.unimi.dsi.fastutil.longs.Long2ByteMap, java.util.Map
    LongSortedSet keySet();

    @Override // p014it.unimi.dsi.fastutil.longs.Long2ByteMap, java.util.Map
    ByteCollection values();

    /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongComparator' to match base method */
    @Override // java.util.SortedMap
    Comparator<? super Long> comparator();

    @Deprecated
    default Long2ByteSortedMap subMap(Long from, Long to) {
        return subMap(from.longValue(), to.longValue());
    }

    @Deprecated
    default Long2ByteSortedMap headMap(Long to) {
        return headMap(to.longValue());
    }

    @Deprecated
    default Long2ByteSortedMap tailMap(Long from) {
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

    @Override // p014it.unimi.dsi.fastutil.longs.Long2ByteMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<Long, Byte>> entrySet() {
        return long2ByteEntrySet();
    }
}
