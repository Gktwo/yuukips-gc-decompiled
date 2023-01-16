package p014it.unimi.dsi.fastutil.ints;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.doubles.DoubleCollection;
import p014it.unimi.dsi.fastutil.ints.Int2DoubleMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;

/* renamed from: it.unimi.dsi.fastutil.ints.Int2DoubleSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2DoubleSortedMap.class */
public interface Int2DoubleSortedMap extends Int2DoubleMap, SortedMap<Integer, Double> {

    /* renamed from: it.unimi.dsi.fastutil.ints.Int2DoubleSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2DoubleSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet extends ObjectSortedSet<Int2DoubleMap.Entry>, Int2DoubleMap.FastEntrySet {
        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleMap.FastEntrySet
        ObjectBidirectionalIterator<Int2DoubleMap.Entry> fastIterator();

        ObjectBidirectionalIterator<Int2DoubleMap.Entry> fastIterator(Int2DoubleMap.Entry entry);
    }

    Int2DoubleSortedMap subMap(int i, int i2);

    Int2DoubleSortedMap headMap(int i);

    Int2DoubleSortedMap tailMap(int i);

    int firstIntKey();

    int lastIntKey();

    ObjectSortedSet<Int2DoubleMap.Entry> int2DoubleEntrySet();

    @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleMap, java.util.Map
    IntSortedSet keySet();

    @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleMap, java.util.Map
    DoubleCollection values();

    /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntComparator' to match base method */
    @Override // java.util.SortedMap
    Comparator<? super Integer> comparator();

    @Deprecated
    default Int2DoubleSortedMap subMap(Integer from, Integer to) {
        return subMap(from.intValue(), to.intValue());
    }

    @Deprecated
    default Int2DoubleSortedMap headMap(Integer to) {
        return headMap(to.intValue());
    }

    @Deprecated
    default Int2DoubleSortedMap tailMap(Integer from) {
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

    @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<Integer, Double>> entrySet() {
        return int2DoubleEntrySet();
    }
}
