package p014it.unimi.dsi.fastutil.objects;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.floats.FloatCollection;
import p014it.unimi.dsi.fastutil.objects.Reference2FloatMap;

/* renamed from: it.unimi.dsi.fastutil.objects.Reference2FloatSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2FloatSortedMap.class */
public interface Reference2FloatSortedMap<K> extends Reference2FloatMap<K>, SortedMap<K, Float> {

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2FloatSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2FloatSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet<K> extends ObjectSortedSet<Reference2FloatMap.Entry<K>>, Reference2FloatMap.FastEntrySet<K> {
        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMap.FastEntrySet
        ObjectBidirectionalIterator<Reference2FloatMap.Entry<K>> fastIterator();

        ObjectBidirectionalIterator<Reference2FloatMap.Entry<K>> fastIterator(Reference2FloatMap.Entry<K> entry);
    }

    @Override // java.util.SortedMap
    Reference2FloatSortedMap<K> subMap(K k, K k2);

    @Override // java.util.SortedMap
    Reference2FloatSortedMap<K> headMap(K k);

    @Override // java.util.SortedMap
    Reference2FloatSortedMap<K> tailMap(K k);

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMap
    ObjectSortedSet<Reference2FloatMap.Entry<K>> reference2FloatEntrySet();

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMap, java.util.Map
    ReferenceSortedSet<K> keySet();

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMap, java.util.Map
    FloatCollection values();

    @Override // java.util.SortedMap
    Comparator<? super K> comparator();

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<K, Float>> entrySet() {
        return reference2FloatEntrySet();
    }
}
