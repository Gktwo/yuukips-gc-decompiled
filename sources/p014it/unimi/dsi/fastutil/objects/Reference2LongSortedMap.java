package p014it.unimi.dsi.fastutil.objects;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.longs.LongCollection;
import p014it.unimi.dsi.fastutil.objects.Reference2LongMap;

/* renamed from: it.unimi.dsi.fastutil.objects.Reference2LongSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2LongSortedMap.class */
public interface Reference2LongSortedMap<K> extends Reference2LongMap<K>, SortedMap<K, Long> {

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2LongSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2LongSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet<K> extends ObjectSortedSet<Reference2LongMap.Entry<K>>, Reference2LongMap.FastEntrySet<K> {
        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongMap.FastEntrySet
        ObjectBidirectionalIterator<Reference2LongMap.Entry<K>> fastIterator();

        ObjectBidirectionalIterator<Reference2LongMap.Entry<K>> fastIterator(Reference2LongMap.Entry<K> entry);
    }

    @Override // java.util.SortedMap
    Reference2LongSortedMap<K> subMap(K k, K k2);

    @Override // java.util.SortedMap
    Reference2LongSortedMap<K> headMap(K k);

    @Override // java.util.SortedMap
    Reference2LongSortedMap<K> tailMap(K k);

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongMap
    ObjectSortedSet<Reference2LongMap.Entry<K>> reference2LongEntrySet();

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongMap, java.util.Map
    ReferenceSortedSet<K> keySet();

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongMap, java.util.Map
    LongCollection values();

    @Override // java.util.SortedMap
    Comparator<? super K> comparator();

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<K, Long>> entrySet() {
        return reference2LongEntrySet();
    }
}
