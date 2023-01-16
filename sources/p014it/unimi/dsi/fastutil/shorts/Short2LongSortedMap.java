package p014it.unimi.dsi.fastutil.shorts;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.longs.LongCollection;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.shorts.Short2LongMap;

/* renamed from: it.unimi.dsi.fastutil.shorts.Short2LongSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2LongSortedMap.class */
public interface Short2LongSortedMap extends Short2LongMap, SortedMap<Short, Long> {

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2LongSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2LongSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet extends ObjectSortedSet<Short2LongMap.Entry>, Short2LongMap.FastEntrySet {
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMap.FastEntrySet
        ObjectBidirectionalIterator<Short2LongMap.Entry> fastIterator();

        ObjectBidirectionalIterator<Short2LongMap.Entry> fastIterator(Short2LongMap.Entry entry);
    }

    Short2LongSortedMap subMap(short s, short s2);

    Short2LongSortedMap headMap(short s);

    Short2LongSortedMap tailMap(short s);

    short firstShortKey();

    short lastShortKey();

    ObjectSortedSet<Short2LongMap.Entry> short2LongEntrySet();

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMap, java.util.Map
    ShortSortedSet keySet();

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMap, java.util.Map
    LongCollection values();

    /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortComparator' to match base method */
    @Override // java.util.SortedMap
    Comparator<? super Short> comparator();

    @Deprecated
    default Short2LongSortedMap subMap(Short from, Short to) {
        return subMap(from.shortValue(), to.shortValue());
    }

    @Deprecated
    default Short2LongSortedMap headMap(Short to) {
        return headMap(to.shortValue());
    }

    @Deprecated
    default Short2LongSortedMap tailMap(Short from) {
        return tailMap(from.shortValue());
    }

    @Override // java.util.SortedMap
    @Deprecated
    default Short firstKey() {
        return Short.valueOf(firstShortKey());
    }

    @Override // java.util.SortedMap
    @Deprecated
    default Short lastKey() {
        return Short.valueOf(lastShortKey());
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<Short, Long>> entrySet() {
        return short2LongEntrySet();
    }
}
