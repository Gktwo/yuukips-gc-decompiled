package p014it.unimi.dsi.fastutil.objects;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.objects.Reference2ShortMap;
import p014it.unimi.dsi.fastutil.shorts.ShortCollection;

/* renamed from: it.unimi.dsi.fastutil.objects.Reference2ShortSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2ShortSortedMap.class */
public interface Reference2ShortSortedMap<K> extends Reference2ShortMap<K>, SortedMap<K, Short> {

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2ShortSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2ShortSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet<K> extends ObjectSortedSet<Reference2ShortMap.Entry<K>>, Reference2ShortMap.FastEntrySet<K> {
        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ShortMap.FastEntrySet
        ObjectBidirectionalIterator<Reference2ShortMap.Entry<K>> fastIterator();

        ObjectBidirectionalIterator<Reference2ShortMap.Entry<K>> fastIterator(Reference2ShortMap.Entry<K> entry);
    }

    @Override // java.util.SortedMap
    Reference2ShortSortedMap<K> subMap(K k, K k2);

    @Override // java.util.SortedMap
    Reference2ShortSortedMap<K> headMap(K k);

    @Override // java.util.SortedMap
    Reference2ShortSortedMap<K> tailMap(K k);

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2ShortMap
    ObjectSortedSet<Reference2ShortMap.Entry<K>> reference2ShortEntrySet();

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2ShortMap, java.util.Map
    ReferenceSortedSet<K> keySet();

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2ShortMap, java.util.Map
    ShortCollection values();

    @Override // java.util.SortedMap
    Comparator<? super K> comparator();

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2ShortMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<K, Short>> entrySet() {
        return reference2ShortEntrySet();
    }
}
