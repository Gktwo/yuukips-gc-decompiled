package p014it.unimi.dsi.fastutil.ints;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.ints.Int2LongMap;
import p014it.unimi.dsi.fastutil.longs.LongCollection;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;

/* renamed from: it.unimi.dsi.fastutil.ints.Int2LongSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2LongSortedMap.class */
public interface Int2LongSortedMap extends Int2LongMap, SortedMap<Integer, Long> {

    /* renamed from: it.unimi.dsi.fastutil.ints.Int2LongSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2LongSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet extends ObjectSortedSet<Int2LongMap.Entry>, Int2LongMap.FastEntrySet {
        @Override // p014it.unimi.dsi.fastutil.ints.Int2LongMap.FastEntrySet
        ObjectBidirectionalIterator<Int2LongMap.Entry> fastIterator();

        ObjectBidirectionalIterator<Int2LongMap.Entry> fastIterator(Int2LongMap.Entry entry);
    }

    Int2LongSortedMap subMap(int i, int i2);

    Int2LongSortedMap headMap(int i);

    Int2LongSortedMap tailMap(int i);

    int firstIntKey();

    int lastIntKey();

    ObjectSortedSet<Int2LongMap.Entry> int2LongEntrySet();

    @Override // p014it.unimi.dsi.fastutil.ints.Int2LongMap, java.util.Map
    IntSortedSet keySet();

    @Override // p014it.unimi.dsi.fastutil.ints.Int2LongMap, java.util.Map
    LongCollection values();

    /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntComparator' to match base method */
    @Override // java.util.SortedMap
    Comparator<? super Integer> comparator();

    @Deprecated
    default Int2LongSortedMap subMap(Integer from, Integer to) {
        return subMap(from.intValue(), to.intValue());
    }

    @Deprecated
    default Int2LongSortedMap headMap(Integer to) {
        return headMap(to.intValue());
    }

    @Deprecated
    default Int2LongSortedMap tailMap(Integer from) {
        return tailMap(from.intValue());
    }

    @Override // java.util.SortedMap
    @Deprecated
    default Integer firstKey() {
        return Integer.valueOf(firstIntKey());
    }

    @Override // java.util.SortedMap
    @Deprecated
    default Integer lastKey() {
        return Integer.valueOf(lastIntKey());
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2LongMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<Integer, Long>> entrySet() {
        return int2LongEntrySet();
    }
}
