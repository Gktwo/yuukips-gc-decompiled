package p014it.unimi.dsi.fastutil.objects;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.chars.CharCollection;
import p014it.unimi.dsi.fastutil.objects.Reference2CharMap;

/* renamed from: it.unimi.dsi.fastutil.objects.Reference2CharSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2CharSortedMap.class */
public interface Reference2CharSortedMap<K> extends Reference2CharMap<K>, SortedMap<K, Character> {

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2CharSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2CharSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet<K> extends ObjectSortedSet<Reference2CharMap.Entry<K>>, Reference2CharMap.FastEntrySet<K> {
        @Override // p014it.unimi.dsi.fastutil.objects.Reference2CharMap.FastEntrySet
        ObjectBidirectionalIterator<Reference2CharMap.Entry<K>> fastIterator();

        ObjectBidirectionalIterator<Reference2CharMap.Entry<K>> fastIterator(Reference2CharMap.Entry<K> entry);
    }

    @Override // java.util.SortedMap
    Reference2CharSortedMap<K> subMap(K k, K k2);

    @Override // java.util.SortedMap
    Reference2CharSortedMap<K> headMap(K k);

    @Override // java.util.SortedMap
    Reference2CharSortedMap<K> tailMap(K k);

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2CharMap
    ObjectSortedSet<Reference2CharMap.Entry<K>> reference2CharEntrySet();

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2CharMap, java.util.Map
    ReferenceSortedSet<K> keySet();

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2CharMap, java.util.Map
    CharCollection values();

    @Override // java.util.SortedMap
    Comparator<? super K> comparator();

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2CharMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<K, Character>> entrySet() {
        return reference2CharEntrySet();
    }
}
