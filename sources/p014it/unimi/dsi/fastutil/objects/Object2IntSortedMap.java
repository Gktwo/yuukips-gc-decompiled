package p014it.unimi.dsi.fastutil.objects;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.ints.IntCollection;
import p014it.unimi.dsi.fastutil.objects.Object2IntMap;

/* renamed from: it.unimi.dsi.fastutil.objects.Object2IntSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2IntSortedMap.class */
public interface Object2IntSortedMap<K> extends Object2IntMap<K>, SortedMap<K, Integer> {

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2IntSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2IntSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet<K> extends ObjectSortedSet<Object2IntMap.Entry<K>>, Object2IntMap.FastEntrySet<K> {
        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntMap.FastEntrySet
        ObjectBidirectionalIterator<Object2IntMap.Entry<K>> fastIterator();

        ObjectBidirectionalIterator<Object2IntMap.Entry<K>> fastIterator(Object2IntMap.Entry<K> entry);
    }

    @Override // java.util.SortedMap
    Object2IntSortedMap<K> subMap(K k, K k2);

    @Override // java.util.SortedMap
    Object2IntSortedMap<K> headMap(K k);

    @Override // java.util.SortedMap
    Object2IntSortedMap<K> tailMap(K k);

    ObjectSortedSet<Object2IntMap.Entry<K>> object2IntEntrySet();

    @Override // p014it.unimi.dsi.fastutil.objects.Object2IntMap, java.util.Map
    ObjectSortedSet<K> keySet();

    @Override // p014it.unimi.dsi.fastutil.objects.Object2IntMap, java.util.Map
    IntCollection values();

    @Override // java.util.SortedMap
    Comparator<? super K> comparator();

    @Override // p014it.unimi.dsi.fastutil.objects.Object2IntMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<K, Integer>> entrySet() {
        return object2IntEntrySet();
    }
}
