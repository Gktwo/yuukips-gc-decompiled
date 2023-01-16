package p014it.unimi.dsi.fastutil.longs;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.chars.CharCollection;
import p014it.unimi.dsi.fastutil.longs.Long2CharMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;

/* renamed from: it.unimi.dsi.fastutil.longs.Long2CharSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2CharSortedMap.class */
public interface Long2CharSortedMap extends Long2CharMap, SortedMap<Long, Character> {

    /* renamed from: it.unimi.dsi.fastutil.longs.Long2CharSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2CharSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet extends ObjectSortedSet<Long2CharMap.Entry>, Long2CharMap.FastEntrySet {
        @Override // p014it.unimi.dsi.fastutil.longs.Long2CharMap.FastEntrySet
        ObjectBidirectionalIterator<Long2CharMap.Entry> fastIterator();

        ObjectBidirectionalIterator<Long2CharMap.Entry> fastIterator(Long2CharMap.Entry entry);
    }

    Long2CharSortedMap subMap(long j, long j2);

    Long2CharSortedMap headMap(long j);

    Long2CharSortedMap tailMap(long j);

    long firstLongKey();

    long lastLongKey();

    ObjectSortedSet<Long2CharMap.Entry> long2CharEntrySet();

    @Override // p014it.unimi.dsi.fastutil.longs.Long2CharMap, java.util.Map
    LongSortedSet keySet();

    @Override // p014it.unimi.dsi.fastutil.longs.Long2CharMap, java.util.Map
    CharCollection values();

    /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongComparator' to match base method */
    @Override // java.util.SortedMap
    Comparator<? super Long> comparator();

    @Deprecated
    default Long2CharSortedMap subMap(Long from, Long to) {
        return subMap(from.longValue(), to.longValue());
    }

    @Deprecated
    default Long2CharSortedMap headMap(Long to) {
        return headMap(to.longValue());
    }

    @Deprecated
    default Long2CharSortedMap tailMap(Long from) {
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

    @Override // p014it.unimi.dsi.fastutil.longs.Long2CharMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<Long, Character>> entrySet() {
        return long2CharEntrySet();
    }
}
