package p014it.unimi.dsi.fastutil.objects;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.doubles.DoubleCollection;
import p014it.unimi.dsi.fastutil.objects.Object2DoubleMap;

/* renamed from: it.unimi.dsi.fastutil.objects.Object2DoubleSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2DoubleSortedMap.class */
public interface Object2DoubleSortedMap<K> extends Object2DoubleMap<K>, SortedMap<K, Double> {

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2DoubleSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2DoubleSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet<K> extends ObjectSortedSet<Object2DoubleMap.Entry<K>>, Object2DoubleMap.FastEntrySet<K> {
        @Override // p014it.unimi.dsi.fastutil.objects.Object2DoubleMap.FastEntrySet
        ObjectBidirectionalIterator<Object2DoubleMap.Entry<K>> fastIterator();

        ObjectBidirectionalIterator<Object2DoubleMap.Entry<K>> fastIterator(Object2DoubleMap.Entry<K> entry);
    }

    @Override // java.util.SortedMap
    Object2DoubleSortedMap<K> subMap(K k, K k2);

    @Override // java.util.SortedMap
    Object2DoubleSortedMap<K> headMap(K k);

    @Override // java.util.SortedMap
    Object2DoubleSortedMap<K> tailMap(K k);

    ObjectSortedSet<Object2DoubleMap.Entry<K>> object2DoubleEntrySet();

    @Override // p014it.unimi.dsi.fastutil.objects.Object2DoubleMap, java.util.Map
    ObjectSortedSet<K> keySet();

    @Override // p014it.unimi.dsi.fastutil.objects.Object2DoubleMap, java.util.Map
    DoubleCollection values();

    @Override // java.util.SortedMap
    Comparator<? super K> comparator();

    @Override // p014it.unimi.dsi.fastutil.objects.Object2DoubleMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<K, Double>> entrySet() {
        return object2DoubleEntrySet();
    }
}
