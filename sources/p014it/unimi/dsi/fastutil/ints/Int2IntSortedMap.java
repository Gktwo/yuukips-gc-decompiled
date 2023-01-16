package p014it.unimi.dsi.fastutil.ints;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.ints.Int2IntMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;

/* renamed from: it.unimi.dsi.fastutil.ints.Int2IntSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2IntSortedMap.class */
public interface Int2IntSortedMap extends Int2IntMap, SortedMap<Integer, Integer> {

    /* renamed from: it.unimi.dsi.fastutil.ints.Int2IntSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2IntSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet extends ObjectSortedSet<Int2IntMap.Entry>, Int2IntMap.FastEntrySet {
        @Override // p014it.unimi.dsi.fastutil.ints.Int2IntMap.FastEntrySet
        ObjectBidirectionalIterator<Int2IntMap.Entry> fastIterator();

        ObjectBidirectionalIterator<Int2IntMap.Entry> fastIterator(Int2IntMap.Entry entry);
    }

    Int2IntSortedMap subMap(int i, int i2);

    Int2IntSortedMap headMap(int i);

    Int2IntSortedMap tailMap(int i);

    int firstIntKey();

    int lastIntKey();

    ObjectSortedSet<Int2IntMap.Entry> int2IntEntrySet();

    @Override // p014it.unimi.dsi.fastutil.ints.Int2IntMap, java.util.Map
    IntSortedSet keySet();

    @Override // p014it.unimi.dsi.fastutil.ints.Int2IntMap, java.util.Map
    IntCollection values();

    /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntComparator' to match base method */
    @Override // java.util.SortedMap
    Comparator<? super Integer> comparator();

    @Deprecated
    default Int2IntSortedMap subMap(Integer from, Integer to) {
        return subMap(from.intValue(), to.intValue());
    }

    @Deprecated
    default Int2IntSortedMap headMap(Integer to) {
        return headMap(to.intValue());
    }

    @Deprecated
    default Int2IntSortedMap tailMap(Integer from) {
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

    @Override // p014it.unimi.dsi.fastutil.ints.Int2IntMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<Integer, Integer>> entrySet() {
        return int2IntEntrySet();
    }
}
