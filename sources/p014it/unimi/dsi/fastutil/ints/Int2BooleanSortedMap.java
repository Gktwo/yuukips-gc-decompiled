package p014it.unimi.dsi.fastutil.ints;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.booleans.BooleanCollection;
import p014it.unimi.dsi.fastutil.ints.Int2BooleanMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;

/* renamed from: it.unimi.dsi.fastutil.ints.Int2BooleanSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2BooleanSortedMap.class */
public interface Int2BooleanSortedMap extends Int2BooleanMap, SortedMap<Integer, Boolean> {

    /* renamed from: it.unimi.dsi.fastutil.ints.Int2BooleanSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2BooleanSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet extends ObjectSortedSet<Int2BooleanMap.Entry>, Int2BooleanMap.FastEntrySet {
        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanMap.FastEntrySet
        ObjectBidirectionalIterator<Int2BooleanMap.Entry> fastIterator();

        ObjectBidirectionalIterator<Int2BooleanMap.Entry> fastIterator(Int2BooleanMap.Entry entry);
    }

    Int2BooleanSortedMap subMap(int i, int i2);

    Int2BooleanSortedMap headMap(int i);

    Int2BooleanSortedMap tailMap(int i);

    int firstIntKey();

    int lastIntKey();

    ObjectSortedSet<Int2BooleanMap.Entry> int2BooleanEntrySet();

    @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanMap, java.util.Map
    IntSortedSet keySet();

    @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanMap, java.util.Map
    BooleanCollection values();

    /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntComparator' to match base method */
    @Override // java.util.SortedMap
    Comparator<? super Integer> comparator();

    @Deprecated
    default Int2BooleanSortedMap subMap(Integer from, Integer to) {
        return subMap(from.intValue(), to.intValue());
    }

    @Deprecated
    default Int2BooleanSortedMap headMap(Integer to) {
        return headMap(to.intValue());
    }

    @Deprecated
    default Int2BooleanSortedMap tailMap(Integer from) {
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

    @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<Integer, Boolean>> entrySet() {
        return int2BooleanEntrySet();
    }
}
