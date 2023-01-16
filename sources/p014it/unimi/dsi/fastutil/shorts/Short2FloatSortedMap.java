package p014it.unimi.dsi.fastutil.shorts;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.floats.FloatCollection;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.shorts.Short2FloatMap;

/* renamed from: it.unimi.dsi.fastutil.shorts.Short2FloatSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2FloatSortedMap.class */
public interface Short2FloatSortedMap extends Short2FloatMap, SortedMap<Short, Float> {

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2FloatSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2FloatSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet extends ObjectSortedSet<Short2FloatMap.Entry>, Short2FloatMap.FastEntrySet {
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2FloatMap.FastEntrySet
        ObjectBidirectionalIterator<Short2FloatMap.Entry> fastIterator();

        ObjectBidirectionalIterator<Short2FloatMap.Entry> fastIterator(Short2FloatMap.Entry entry);
    }

    Short2FloatSortedMap subMap(short s, short s2);

    Short2FloatSortedMap headMap(short s);

    Short2FloatSortedMap tailMap(short s);

    short firstShortKey();

    short lastShortKey();

    ObjectSortedSet<Short2FloatMap.Entry> short2FloatEntrySet();

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2FloatMap, java.util.Map
    ShortSortedSet keySet();

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2FloatMap, java.util.Map
    FloatCollection values();

    /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortComparator' to match base method */
    @Override // java.util.SortedMap
    Comparator<? super Short> comparator();

    @Deprecated
    default Short2FloatSortedMap subMap(Short from, Short to) {
        return subMap(from.shortValue(), to.shortValue());
    }

    @Deprecated
    default Short2FloatSortedMap headMap(Short to) {
        return headMap(to.shortValue());
    }

    @Deprecated
    default Short2FloatSortedMap tailMap(Short from) {
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

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2FloatMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<Short, Float>> entrySet() {
        return short2FloatEntrySet();
    }
}
