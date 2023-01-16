package p014it.unimi.dsi.fastutil.shorts;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.ints.IntCollection;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.shorts.Short2IntMap;

/* renamed from: it.unimi.dsi.fastutil.shorts.Short2IntSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2IntSortedMap.class */
public interface Short2IntSortedMap extends Short2IntMap, SortedMap<Short, Integer> {

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2IntSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2IntSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet extends ObjectSortedSet<Short2IntMap.Entry>, Short2IntMap.FastEntrySet {
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntMap.FastEntrySet
        ObjectBidirectionalIterator<Short2IntMap.Entry> fastIterator();

        ObjectBidirectionalIterator<Short2IntMap.Entry> fastIterator(Short2IntMap.Entry entry);
    }

    Short2IntSortedMap subMap(short s, short s2);

    Short2IntSortedMap headMap(short s);

    Short2IntSortedMap tailMap(short s);

    short firstShortKey();

    short lastShortKey();

    ObjectSortedSet<Short2IntMap.Entry> short2IntEntrySet();

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntMap, java.util.Map
    ShortSortedSet keySet();

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntMap, java.util.Map
    IntCollection values();

    /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortComparator' to match base method */
    @Override // java.util.SortedMap
    Comparator<? super Short> comparator();

    @Deprecated
    default Short2IntSortedMap subMap(Short from, Short to) {
        return subMap(from.shortValue(), to.shortValue());
    }

    @Deprecated
    default Short2IntSortedMap headMap(Short to) {
        return headMap(to.shortValue());
    }

    @Deprecated
    default Short2IntSortedMap tailMap(Short from) {
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

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<Short, Integer>> entrySet() {
        return short2IntEntrySet();
    }
}
