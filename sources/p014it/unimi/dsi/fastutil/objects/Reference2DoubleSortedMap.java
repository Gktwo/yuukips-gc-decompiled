package p014it.unimi.dsi.fastutil.objects;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.doubles.DoubleCollection;
import p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap;

/* renamed from: it.unimi.dsi.fastutil.objects.Reference2DoubleSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2DoubleSortedMap.class */
public interface Reference2DoubleSortedMap<K> extends Reference2DoubleMap<K>, SortedMap<K, Double> {

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2DoubleSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2DoubleSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet<K> extends ObjectSortedSet<Reference2DoubleMap.Entry<K>>, Reference2DoubleMap.FastEntrySet<K> {
        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap.FastEntrySet
        ObjectBidirectionalIterator<Reference2DoubleMap.Entry<K>> fastIterator();

        ObjectBidirectionalIterator<Reference2DoubleMap.Entry<K>> fastIterator(Reference2DoubleMap.Entry<K> entry);
    }

    @Override // java.util.SortedMap
    Reference2DoubleSortedMap<K> subMap(K k, K k2);

    @Override // java.util.SortedMap
    Reference2DoubleSortedMap<K> headMap(K k);

    @Override // java.util.SortedMap
    Reference2DoubleSortedMap<K> tailMap(K k);

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap
    ObjectSortedSet<Reference2DoubleMap.Entry<K>> reference2DoubleEntrySet();

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap, java.util.Map
    ReferenceSortedSet<K> keySet();

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap, java.util.Map
    DoubleCollection values();

    @Override // java.util.SortedMap
    Comparator<? super K> comparator();

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<K, Double>> entrySet() {
        return reference2DoubleEntrySet();
    }
}
