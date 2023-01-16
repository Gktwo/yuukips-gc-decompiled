package p014it.unimi.dsi.fastutil.objects;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.objects.Reference2ReferenceMap;

/* renamed from: it.unimi.dsi.fastutil.objects.Reference2ReferenceSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2ReferenceSortedMap.class */
public interface Reference2ReferenceSortedMap<K, V> extends Reference2ReferenceMap<K, V>, SortedMap<K, V> {

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2ReferenceSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2ReferenceSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet<K, V> extends ObjectSortedSet<Reference2ReferenceMap.Entry<K, V>>, Reference2ReferenceMap.FastEntrySet<K, V> {
        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ReferenceMap.FastEntrySet
        ObjectBidirectionalIterator<Reference2ReferenceMap.Entry<K, V>> fastIterator();

        ObjectBidirectionalIterator<Reference2ReferenceMap.Entry<K, V>> fastIterator(Reference2ReferenceMap.Entry<K, V> entry);
    }

    @Override // java.util.SortedMap
    Reference2ReferenceSortedMap<K, V> subMap(K k, K k2);

    @Override // java.util.SortedMap
    Reference2ReferenceSortedMap<K, V> headMap(K k);

    @Override // java.util.SortedMap
    Reference2ReferenceSortedMap<K, V> tailMap(K k);

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2ReferenceMap
    ObjectSortedSet<Reference2ReferenceMap.Entry<K, V>> reference2ReferenceEntrySet();

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2ReferenceMap, java.util.Map
    ReferenceSortedSet<K> keySet();

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2ReferenceMap, java.util.Map
    ReferenceCollection<V> values();

    @Override // java.util.SortedMap
    Comparator<? super K> comparator();

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2ReferenceMap, java.util.Map
    default ObjectSortedSet<Map.Entry<K, V>> entrySet() {
        return reference2ReferenceEntrySet();
    }
}
