package p014it.unimi.dsi.fastutil.objects;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.booleans.BooleanCollection;
import p014it.unimi.dsi.fastutil.objects.Reference2BooleanMap;

/* renamed from: it.unimi.dsi.fastutil.objects.Reference2BooleanSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2BooleanSortedMap.class */
public interface Reference2BooleanSortedMap<K> extends Reference2BooleanMap<K>, SortedMap<K, Boolean> {

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2BooleanSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2BooleanSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet<K> extends ObjectSortedSet<Reference2BooleanMap.Entry<K>>, Reference2BooleanMap.FastEntrySet<K> {
        @Override // p014it.unimi.dsi.fastutil.objects.Reference2BooleanMap.FastEntrySet
        ObjectBidirectionalIterator<Reference2BooleanMap.Entry<K>> fastIterator();

        ObjectBidirectionalIterator<Reference2BooleanMap.Entry<K>> fastIterator(Reference2BooleanMap.Entry<K> entry);
    }

    @Override // java.util.SortedMap
    Reference2BooleanSortedMap<K> subMap(K k, K k2);

    @Override // java.util.SortedMap
    Reference2BooleanSortedMap<K> headMap(K k);

    @Override // java.util.SortedMap
    Reference2BooleanSortedMap<K> tailMap(K k);

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2BooleanMap
    ObjectSortedSet<Reference2BooleanMap.Entry<K>> reference2BooleanEntrySet();

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2BooleanMap, java.util.Map
    ReferenceSortedSet<K> keySet();

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2BooleanMap, java.util.Map
    BooleanCollection values();

    @Override // java.util.SortedMap
    Comparator<? super K> comparator();

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2BooleanMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<K, Boolean>> entrySet() {
        return reference2BooleanEntrySet();
    }
}
