package p014it.unimi.dsi.fastutil.objects;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.objects.Object2ReferenceMap;

/* renamed from: it.unimi.dsi.fastutil.objects.Object2ReferenceSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ReferenceSortedMap.class */
public interface Object2ReferenceSortedMap<K, V> extends Object2ReferenceMap<K, V>, SortedMap<K, V> {

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ReferenceSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ReferenceSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet<K, V> extends ObjectSortedSet<Object2ReferenceMap.Entry<K, V>>, Object2ReferenceMap.FastEntrySet<K, V> {
        @Override // p014it.unimi.dsi.fastutil.objects.Object2ReferenceMap.FastEntrySet
        ObjectBidirectionalIterator<Object2ReferenceMap.Entry<K, V>> fastIterator();

        ObjectBidirectionalIterator<Object2ReferenceMap.Entry<K, V>> fastIterator(Object2ReferenceMap.Entry<K, V> entry);
    }

    @Override // java.util.SortedMap
    Object2ReferenceSortedMap<K, V> subMap(K k, K k2);

    @Override // java.util.SortedMap
    Object2ReferenceSortedMap<K, V> headMap(K k);

    @Override // java.util.SortedMap
    Object2ReferenceSortedMap<K, V> tailMap(K k);

    ObjectSortedSet<Object2ReferenceMap.Entry<K, V>> object2ReferenceEntrySet();

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ReferenceMap, java.util.Map
    ObjectSortedSet<K> keySet();

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ReferenceMap, java.util.Map
    ReferenceCollection<V> values();

    @Override // java.util.SortedMap
    Comparator<? super K> comparator();

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ReferenceMap, java.util.Map
    default ObjectSortedSet<Map.Entry<K, V>> entrySet() {
        return object2ReferenceEntrySet();
    }
}
