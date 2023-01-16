package p014it.unimi.dsi.fastutil.ints;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectCollection;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;

/* renamed from: it.unimi.dsi.fastutil.ints.Int2ObjectSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2ObjectSortedMap.class */
public interface Int2ObjectSortedMap<V> extends Int2ObjectMap<V>, SortedMap<Integer, V> {

    /* renamed from: it.unimi.dsi.fastutil.ints.Int2ObjectSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2ObjectSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet<V> extends ObjectSortedSet<Int2ObjectMap.Entry<V>>, Int2ObjectMap.FastEntrySet<V> {
        @Override // p014it.unimi.dsi.fastutil.ints.Int2ObjectMap.FastEntrySet
        ObjectBidirectionalIterator<Int2ObjectMap.Entry<V>> fastIterator();

        ObjectBidirectionalIterator<Int2ObjectMap.Entry<V>> fastIterator(Int2ObjectMap.Entry<V> entry);
    }

    Int2ObjectSortedMap<V> subMap(int i, int i2);

    Int2ObjectSortedMap<V> headMap(int i);

    Int2ObjectSortedMap<V> tailMap(int i);

    int firstIntKey();

    int lastIntKey();

    ObjectSortedSet<Int2ObjectMap.Entry<V>> int2ObjectEntrySet();

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ObjectMap, java.util.Map
    IntSortedSet keySet();

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ObjectMap, java.util.Map
    ObjectCollection<V> values();

    /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntComparator' to match base method */
    @Override // java.util.SortedMap
    Comparator<? super Integer> comparator();

    @Deprecated
    default Int2ObjectSortedMap<V> subMap(Integer from, Integer to) {
        return subMap(from.intValue(), to.intValue());
    }

    @Deprecated
    default Int2ObjectSortedMap<V> headMap(Integer to) {
        return headMap(to.intValue());
    }

    @Deprecated
    default Int2ObjectSortedMap<V> tailMap(Integer from) {
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

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ObjectMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<Integer, V>> entrySet() {
        return int2ObjectEntrySet();
    }
}
