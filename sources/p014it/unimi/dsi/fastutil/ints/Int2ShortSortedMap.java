package p014it.unimi.dsi.fastutil.ints;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.ints.Int2ShortMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.shorts.ShortCollection;

/* renamed from: it.unimi.dsi.fastutil.ints.Int2ShortSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2ShortSortedMap.class */
public interface Int2ShortSortedMap extends Int2ShortMap, SortedMap<Integer, Short> {

    /* renamed from: it.unimi.dsi.fastutil.ints.Int2ShortSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2ShortSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet extends ObjectSortedSet<Int2ShortMap.Entry>, Int2ShortMap.FastEntrySet {
        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMap.FastEntrySet
        ObjectBidirectionalIterator<Int2ShortMap.Entry> fastIterator();

        ObjectBidirectionalIterator<Int2ShortMap.Entry> fastIterator(Int2ShortMap.Entry entry);
    }

    Int2ShortSortedMap subMap(int i, int i2);

    Int2ShortSortedMap headMap(int i);

    Int2ShortSortedMap tailMap(int i);

    int firstIntKey();

    int lastIntKey();

    ObjectSortedSet<Int2ShortMap.Entry> int2ShortEntrySet();

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMap, java.util.Map
    IntSortedSet keySet();

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMap, java.util.Map
    ShortCollection values();

    /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntComparator' to match base method */
    @Override // java.util.SortedMap
    Comparator<? super Integer> comparator();

    @Deprecated
    default Int2ShortSortedMap subMap(Integer from, Integer to) {
        return subMap(from.intValue(), to.intValue());
    }

    @Deprecated
    default Int2ShortSortedMap headMap(Integer to) {
        return headMap(to.intValue());
    }

    @Deprecated
    default Int2ShortSortedMap tailMap(Integer from) {
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

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<Integer, Short>> entrySet() {
        return int2ShortEntrySet();
    }
}
