package p014it.unimi.dsi.fastutil.shorts;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.doubles.DoubleCollection;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.shorts.Short2DoubleMap;

/* renamed from: it.unimi.dsi.fastutil.shorts.Short2DoubleSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2DoubleSortedMap.class */
public interface Short2DoubleSortedMap extends Short2DoubleMap, SortedMap<Short, Double> {

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2DoubleSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2DoubleSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet extends ObjectSortedSet<Short2DoubleMap.Entry>, Short2DoubleMap.FastEntrySet {
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleMap.FastEntrySet
        ObjectBidirectionalIterator<Short2DoubleMap.Entry> fastIterator();

        ObjectBidirectionalIterator<Short2DoubleMap.Entry> fastIterator(Short2DoubleMap.Entry entry);
    }

    Short2DoubleSortedMap subMap(short s, short s2);

    Short2DoubleSortedMap headMap(short s);

    Short2DoubleSortedMap tailMap(short s);

    short firstShortKey();

    short lastShortKey();

    ObjectSortedSet<Short2DoubleMap.Entry> short2DoubleEntrySet();

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleMap, java.util.Map
    ShortSortedSet keySet();

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleMap, java.util.Map
    DoubleCollection values();

    /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortComparator' to match base method */
    @Override // java.util.SortedMap
    Comparator<? super Short> comparator();

    @Deprecated
    default Short2DoubleSortedMap subMap(Short from, Short to) {
        return subMap(from.shortValue(), to.shortValue());
    }

    @Deprecated
    default Short2DoubleSortedMap headMap(Short to) {
        return headMap(to.shortValue());
    }

    @Deprecated
    default Short2DoubleSortedMap tailMap(Short from) {
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

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<Short, Double>> entrySet() {
        return short2DoubleEntrySet();
    }
}
