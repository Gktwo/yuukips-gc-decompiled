package p014it.unimi.dsi.fastutil.ints;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.floats.FloatCollection;
import p014it.unimi.dsi.fastutil.ints.Int2FloatMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;

/* renamed from: it.unimi.dsi.fastutil.ints.Int2FloatSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2FloatSortedMap.class */
public interface Int2FloatSortedMap extends Int2FloatMap, SortedMap<Integer, Float> {

    /* renamed from: it.unimi.dsi.fastutil.ints.Int2FloatSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2FloatSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet extends ObjectSortedSet<Int2FloatMap.Entry>, Int2FloatMap.FastEntrySet {
        @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatMap.FastEntrySet
        ObjectBidirectionalIterator<Int2FloatMap.Entry> fastIterator();

        ObjectBidirectionalIterator<Int2FloatMap.Entry> fastIterator(Int2FloatMap.Entry entry);
    }

    Int2FloatSortedMap subMap(int i, int i2);

    Int2FloatSortedMap headMap(int i);

    Int2FloatSortedMap tailMap(int i);

    int firstIntKey();

    int lastIntKey();

    ObjectSortedSet<Int2FloatMap.Entry> int2FloatEntrySet();

    @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatMap, java.util.Map
    IntSortedSet keySet();

    @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatMap, java.util.Map
    FloatCollection values();

    /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntComparator' to match base method */
    @Override // java.util.SortedMap
    Comparator<? super Integer> comparator();

    @Deprecated
    default Int2FloatSortedMap subMap(Integer from, Integer to) {
        return subMap(from.intValue(), to.intValue());
    }

    @Deprecated
    default Int2FloatSortedMap headMap(Integer to) {
        return headMap(to.intValue());
    }

    @Deprecated
    default Int2FloatSortedMap tailMap(Integer from) {
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

    @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<Integer, Float>> entrySet() {
        return int2FloatEntrySet();
    }
}
