package p014it.unimi.dsi.fastutil.shorts;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ReferenceCollection;
import p014it.unimi.dsi.fastutil.shorts.Short2ReferenceMap;

/* renamed from: it.unimi.dsi.fastutil.shorts.Short2ReferenceSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ReferenceSortedMap.class */
public interface Short2ReferenceSortedMap<V> extends Short2ReferenceMap<V>, SortedMap<Short, V> {

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ReferenceSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ReferenceSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet<V> extends ObjectSortedSet<Short2ReferenceMap.Entry<V>>, Short2ReferenceMap.FastEntrySet<V> {
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceMap.FastEntrySet
        ObjectBidirectionalIterator<Short2ReferenceMap.Entry<V>> fastIterator();

        ObjectBidirectionalIterator<Short2ReferenceMap.Entry<V>> fastIterator(Short2ReferenceMap.Entry<V> entry);
    }

    Short2ReferenceSortedMap<V> subMap(short s, short s2);

    Short2ReferenceSortedMap<V> headMap(short s);

    Short2ReferenceSortedMap<V> tailMap(short s);

    short firstShortKey();

    short lastShortKey();

    ObjectSortedSet<Short2ReferenceMap.Entry<V>> short2ReferenceEntrySet();

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceMap, java.util.Map
    ShortSortedSet keySet();

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceMap, java.util.Map
    ReferenceCollection<V> values();

    /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortComparator' to match base method */
    @Override // java.util.SortedMap
    Comparator<? super Short> comparator();

    @Deprecated
    default Short2ReferenceSortedMap<V> subMap(Short from, Short to) {
        return subMap(from.shortValue(), to.shortValue());
    }

    @Deprecated
    default Short2ReferenceSortedMap<V> headMap(Short to) {
        return headMap(to.shortValue());
    }

    @Deprecated
    default Short2ReferenceSortedMap<V> tailMap(Short from) {
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

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<Short, V>> entrySet() {
        return short2ReferenceEntrySet();
    }
}
