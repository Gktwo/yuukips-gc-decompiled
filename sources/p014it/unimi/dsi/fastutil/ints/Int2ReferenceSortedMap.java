package p014it.unimi.dsi.fastutil.ints;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.ints.Int2ReferenceMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ReferenceCollection;

/* renamed from: it.unimi.dsi.fastutil.ints.Int2ReferenceSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2ReferenceSortedMap.class */
public interface Int2ReferenceSortedMap<V> extends Int2ReferenceMap<V>, SortedMap<Integer, V> {

    /* renamed from: it.unimi.dsi.fastutil.ints.Int2ReferenceSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2ReferenceSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet<V> extends ObjectSortedSet<Int2ReferenceMap.Entry<V>>, Int2ReferenceMap.FastEntrySet<V> {
        @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceMap.FastEntrySet
        ObjectBidirectionalIterator<Int2ReferenceMap.Entry<V>> fastIterator();

        ObjectBidirectionalIterator<Int2ReferenceMap.Entry<V>> fastIterator(Int2ReferenceMap.Entry<V> entry);
    }

    Int2ReferenceSortedMap<V> subMap(int i, int i2);

    Int2ReferenceSortedMap<V> headMap(int i);

    Int2ReferenceSortedMap<V> tailMap(int i);

    int firstIntKey();

    int lastIntKey();

    ObjectSortedSet<Int2ReferenceMap.Entry<V>> int2ReferenceEntrySet();

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceMap, java.util.Map
    IntSortedSet keySet();

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceMap, java.util.Map
    ReferenceCollection<V> values();

    /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntComparator' to match base method */
    @Override // java.util.SortedMap
    Comparator<? super Integer> comparator();

    @Deprecated
    default Int2ReferenceSortedMap<V> subMap(Integer from, Integer to) {
        return subMap(from.intValue(), to.intValue());
    }

    @Deprecated
    default Int2ReferenceSortedMap<V> headMap(Integer to) {
        return headMap(to.intValue());
    }

    @Deprecated
    default Int2ReferenceSortedMap<V> tailMap(Integer from) {
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

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<Integer, V>> entrySet() {
        return int2ReferenceEntrySet();
    }
}
