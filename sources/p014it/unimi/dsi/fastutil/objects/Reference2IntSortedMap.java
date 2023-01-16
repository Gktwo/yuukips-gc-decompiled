package p014it.unimi.dsi.fastutil.objects;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.ints.IntCollection;
import p014it.unimi.dsi.fastutil.objects.Reference2IntMap;

/* renamed from: it.unimi.dsi.fastutil.objects.Reference2IntSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2IntSortedMap.class */
public interface Reference2IntSortedMap<K> extends Reference2IntMap<K>, SortedMap<K, Integer> {

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2IntSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2IntSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet<K> extends ObjectSortedSet<Reference2IntMap.Entry<K>>, Reference2IntMap.FastEntrySet<K> {
        @Override // p014it.unimi.dsi.fastutil.objects.Reference2IntMap.FastEntrySet
        ObjectBidirectionalIterator<Reference2IntMap.Entry<K>> fastIterator();

        ObjectBidirectionalIterator<Reference2IntMap.Entry<K>> fastIterator(Reference2IntMap.Entry<K> entry);
    }

    @Override // java.util.SortedMap
    Reference2IntSortedMap<K> subMap(K k, K k2);

    @Override // java.util.SortedMap
    Reference2IntSortedMap<K> headMap(K k);

    @Override // java.util.SortedMap
    Reference2IntSortedMap<K> tailMap(K k);

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2IntMap
    ObjectSortedSet<Reference2IntMap.Entry<K>> reference2IntEntrySet();

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2IntMap, java.util.Map
    ReferenceSortedSet<K> keySet();

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2IntMap, java.util.Map
    IntCollection values();

    @Override // java.util.SortedMap
    Comparator<? super K> comparator();

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2IntMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<K, Integer>> entrySet() {
        return reference2IntEntrySet();
    }
}
