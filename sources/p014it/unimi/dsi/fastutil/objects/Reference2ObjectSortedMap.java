package p014it.unimi.dsi.fastutil.objects;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.objects.Reference2ObjectMap;

/* renamed from: it.unimi.dsi.fastutil.objects.Reference2ObjectSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2ObjectSortedMap.class */
public interface Reference2ObjectSortedMap<K, V> extends Reference2ObjectMap<K, V>, SortedMap<K, V> {

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2ObjectSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2ObjectSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet<K, V> extends ObjectSortedSet<Reference2ObjectMap.Entry<K, V>>, Reference2ObjectMap.FastEntrySet<K, V> {
        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectMap.FastEntrySet
        ObjectBidirectionalIterator<Reference2ObjectMap.Entry<K, V>> fastIterator();

        ObjectBidirectionalIterator<Reference2ObjectMap.Entry<K, V>> fastIterator(Reference2ObjectMap.Entry<K, V> entry);
    }

    @Override // java.util.SortedMap
    Reference2ObjectSortedMap<K, V> subMap(K k, K k2);

    @Override // java.util.SortedMap
    Reference2ObjectSortedMap<K, V> headMap(K k);

    @Override // java.util.SortedMap
    Reference2ObjectSortedMap<K, V> tailMap(K k);

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectMap
    ObjectSortedSet<Reference2ObjectMap.Entry<K, V>> reference2ObjectEntrySet();

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectMap, java.util.Map
    ReferenceSortedSet<K> keySet();

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectMap, java.util.Map
    ObjectCollection<V> values();

    @Override // java.util.SortedMap
    Comparator<? super K> comparator();

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectMap, java.util.Map
    default ObjectSortedSet<Map.Entry<K, V>> entrySet() {
        return reference2ObjectEntrySet();
    }
}
