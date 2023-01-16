package p014it.unimi.dsi.fastutil.objects;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.objects.Object2ObjectMap;

/* renamed from: it.unimi.dsi.fastutil.objects.Object2ObjectSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ObjectSortedMap.class */
public interface Object2ObjectSortedMap<K, V> extends Object2ObjectMap<K, V>, SortedMap<K, V> {

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ObjectSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ObjectSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet<K, V> extends ObjectSortedSet<Object2ObjectMap.Entry<K, V>>, Object2ObjectMap.FastEntrySet<K, V> {
        @Override // p014it.unimi.dsi.fastutil.objects.Object2ObjectMap.FastEntrySet
        ObjectBidirectionalIterator<Object2ObjectMap.Entry<K, V>> fastIterator();

        ObjectBidirectionalIterator<Object2ObjectMap.Entry<K, V>> fastIterator(Object2ObjectMap.Entry<K, V> entry);
    }

    @Override // java.util.SortedMap
    Object2ObjectSortedMap<K, V> subMap(K k, K k2);

    @Override // java.util.SortedMap
    Object2ObjectSortedMap<K, V> headMap(K k);

    @Override // java.util.SortedMap
    Object2ObjectSortedMap<K, V> tailMap(K k);

    ObjectSortedSet<Object2ObjectMap.Entry<K, V>> object2ObjectEntrySet();

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ObjectMap, java.util.Map
    ObjectSortedSet<K> keySet();

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ObjectMap, java.util.Map
    ObjectCollection<V> values();

    @Override // java.util.SortedMap
    Comparator<? super K> comparator();

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ObjectMap, java.util.Map
    default ObjectSortedSet<Map.Entry<K, V>> entrySet() {
        return object2ObjectEntrySet();
    }
}
