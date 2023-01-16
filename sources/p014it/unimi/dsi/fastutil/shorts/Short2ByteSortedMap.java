package p014it.unimi.dsi.fastutil.shorts;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.bytes.ByteCollection;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.shorts.Short2ByteMap;

/* renamed from: it.unimi.dsi.fastutil.shorts.Short2ByteSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ByteSortedMap.class */
public interface Short2ByteSortedMap extends Short2ByteMap, SortedMap<Short, Byte> {

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ByteSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ByteSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet extends ObjectSortedSet<Short2ByteMap.Entry>, Short2ByteMap.FastEntrySet {
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteMap.FastEntrySet
        ObjectBidirectionalIterator<Short2ByteMap.Entry> fastIterator();

        ObjectBidirectionalIterator<Short2ByteMap.Entry> fastIterator(Short2ByteMap.Entry entry);
    }

    Short2ByteSortedMap subMap(short s, short s2);

    Short2ByteSortedMap headMap(short s);

    Short2ByteSortedMap tailMap(short s);

    short firstShortKey();

    short lastShortKey();

    ObjectSortedSet<Short2ByteMap.Entry> short2ByteEntrySet();

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteMap, java.util.Map
    ShortSortedSet keySet();

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteMap, java.util.Map
    ByteCollection values();

    /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortComparator' to match base method */
    @Override // java.util.SortedMap
    Comparator<? super Short> comparator();

    @Deprecated
    default Short2ByteSortedMap subMap(Short from, Short to) {
        return subMap(from.shortValue(), to.shortValue());
    }

    @Deprecated
    default Short2ByteSortedMap headMap(Short to) {
        return headMap(to.shortValue());
    }

    @Deprecated
    default Short2ByteSortedMap tailMap(Short from) {
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

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<Short, Byte>> entrySet() {
        return short2ByteEntrySet();
    }
}
