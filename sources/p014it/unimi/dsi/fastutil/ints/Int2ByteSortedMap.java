package p014it.unimi.dsi.fastutil.ints;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.bytes.ByteCollection;
import p014it.unimi.dsi.fastutil.ints.Int2ByteMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;

/* renamed from: it.unimi.dsi.fastutil.ints.Int2ByteSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2ByteSortedMap.class */
public interface Int2ByteSortedMap extends Int2ByteMap, SortedMap<Integer, Byte> {

    /* renamed from: it.unimi.dsi.fastutil.ints.Int2ByteSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2ByteSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet extends ObjectSortedSet<Int2ByteMap.Entry>, Int2ByteMap.FastEntrySet {
        @Override // p014it.unimi.dsi.fastutil.ints.Int2ByteMap.FastEntrySet
        ObjectBidirectionalIterator<Int2ByteMap.Entry> fastIterator();

        ObjectBidirectionalIterator<Int2ByteMap.Entry> fastIterator(Int2ByteMap.Entry entry);
    }

    Int2ByteSortedMap subMap(int i, int i2);

    Int2ByteSortedMap headMap(int i);

    Int2ByteSortedMap tailMap(int i);

    int firstIntKey();

    int lastIntKey();

    ObjectSortedSet<Int2ByteMap.Entry> int2ByteEntrySet();

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ByteMap, java.util.Map
    IntSortedSet keySet();

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ByteMap, java.util.Map
    ByteCollection values();

    /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntComparator' to match base method */
    @Override // java.util.SortedMap
    Comparator<? super Integer> comparator();

    @Deprecated
    default Int2ByteSortedMap subMap(Integer from, Integer to) {
        return subMap(from.intValue(), to.intValue());
    }

    @Deprecated
    default Int2ByteSortedMap headMap(Integer to) {
        return headMap(to.intValue());
    }

    @Deprecated
    default Int2ByteSortedMap tailMap(Integer from) {
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

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ByteMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<Integer, Byte>> entrySet() {
        return int2ByteEntrySet();
    }
}
