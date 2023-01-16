package p014it.unimi.dsi.fastutil.shorts;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.shorts.Short2ShortMap;

/* renamed from: it.unimi.dsi.fastutil.shorts.Short2ShortSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ShortSortedMap.class */
public interface Short2ShortSortedMap extends Short2ShortMap, SortedMap<Short, Short> {

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ShortSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ShortSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet extends ObjectSortedSet<Short2ShortMap.Entry>, Short2ShortMap.FastEntrySet {
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortMap.FastEntrySet
        ObjectBidirectionalIterator<Short2ShortMap.Entry> fastIterator();

        ObjectBidirectionalIterator<Short2ShortMap.Entry> fastIterator(Short2ShortMap.Entry entry);
    }

    Short2ShortSortedMap subMap(short s, short s2);

    Short2ShortSortedMap headMap(short s);

    Short2ShortSortedMap tailMap(short s);

    short firstShortKey();

    short lastShortKey();

    ObjectSortedSet<Short2ShortMap.Entry> short2ShortEntrySet();

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortMap, java.util.Map
    ShortSortedSet keySet();

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortMap, java.util.Map
    ShortCollection values();

    /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortComparator' to match base method */
    @Override // java.util.SortedMap
    Comparator<? super Short> comparator();

    @Deprecated
    default Short2ShortSortedMap subMap(Short from, Short to) {
        return subMap(from.shortValue(), to.shortValue());
    }

    @Deprecated
    default Short2ShortSortedMap headMap(Short to) {
        return headMap(to.shortValue());
    }

    @Deprecated
    default Short2ShortSortedMap tailMap(Short from) {
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

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<Short, Short>> entrySet() {
        return short2ShortEntrySet();
    }
}
