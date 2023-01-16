package p014it.unimi.dsi.fastutil.shorts;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectCollection;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap;

/* renamed from: it.unimi.dsi.fastutil.shorts.Short2ObjectSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ObjectSortedMap.class */
public interface Short2ObjectSortedMap<V> extends Short2ObjectMap<V>, SortedMap<Short, V> {

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ObjectSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ObjectSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet<V> extends ObjectSortedSet<Short2ObjectMap.Entry<V>>, Short2ObjectMap.FastEntrySet<V> {
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap.FastEntrySet
        ObjectBidirectionalIterator<Short2ObjectMap.Entry<V>> fastIterator();

        ObjectBidirectionalIterator<Short2ObjectMap.Entry<V>> fastIterator(Short2ObjectMap.Entry<V> entry);
    }

    Short2ObjectSortedMap<V> subMap(short s, short s2);

    Short2ObjectSortedMap<V> headMap(short s);

    Short2ObjectSortedMap<V> tailMap(short s);

    short firstShortKey();

    short lastShortKey();

    ObjectSortedSet<Short2ObjectMap.Entry<V>> short2ObjectEntrySet();

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap, java.util.Map
    ShortSortedSet keySet();

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap, java.util.Map
    ObjectCollection<V> values();

    /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortComparator' to match base method */
    @Override // java.util.SortedMap
    Comparator<? super Short> comparator();

    @Deprecated
    default Short2ObjectSortedMap<V> subMap(Short from, Short to) {
        return subMap(from.shortValue(), to.shortValue());
    }

    @Deprecated
    default Short2ObjectSortedMap<V> headMap(Short to) {
        return headMap(to.shortValue());
    }

    @Deprecated
    default Short2ObjectSortedMap<V> tailMap(Short from) {
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

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<Short, V>> entrySet() {
        return short2ObjectEntrySet();
    }
}
