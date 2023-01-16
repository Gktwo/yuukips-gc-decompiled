package p014it.unimi.dsi.fastutil.shorts;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.booleans.BooleanCollection;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.shorts.Short2BooleanMap;

/* renamed from: it.unimi.dsi.fastutil.shorts.Short2BooleanSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2BooleanSortedMap.class */
public interface Short2BooleanSortedMap extends Short2BooleanMap, SortedMap<Short, Boolean> {

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2BooleanSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2BooleanSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet extends ObjectSortedSet<Short2BooleanMap.Entry>, Short2BooleanMap.FastEntrySet {
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2BooleanMap.FastEntrySet
        ObjectBidirectionalIterator<Short2BooleanMap.Entry> fastIterator();

        ObjectBidirectionalIterator<Short2BooleanMap.Entry> fastIterator(Short2BooleanMap.Entry entry);
    }

    Short2BooleanSortedMap subMap(short s, short s2);

    Short2BooleanSortedMap headMap(short s);

    Short2BooleanSortedMap tailMap(short s);

    short firstShortKey();

    short lastShortKey();

    ObjectSortedSet<Short2BooleanMap.Entry> short2BooleanEntrySet();

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2BooleanMap, java.util.Map
    ShortSortedSet keySet();

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2BooleanMap, java.util.Map
    BooleanCollection values();

    /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortComparator' to match base method */
    @Override // java.util.SortedMap
    Comparator<? super Short> comparator();

    @Deprecated
    default Short2BooleanSortedMap subMap(Short from, Short to) {
        return subMap(from.shortValue(), to.shortValue());
    }

    @Deprecated
    default Short2BooleanSortedMap headMap(Short to) {
        return headMap(to.shortValue());
    }

    @Deprecated
    default Short2BooleanSortedMap tailMap(Short from) {
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

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2BooleanMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<Short, Boolean>> entrySet() {
        return short2BooleanEntrySet();
    }
}
