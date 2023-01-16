package p014it.unimi.dsi.fastutil.objects;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.bytes.ByteCollection;
import p014it.unimi.dsi.fastutil.objects.Reference2ByteMap;

/* renamed from: it.unimi.dsi.fastutil.objects.Reference2ByteSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2ByteSortedMap.class */
public interface Reference2ByteSortedMap<K> extends Reference2ByteMap<K>, SortedMap<K, Byte> {

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2ByteSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2ByteSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet<K> extends ObjectSortedSet<Reference2ByteMap.Entry<K>>, Reference2ByteMap.FastEntrySet<K> {
        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ByteMap.FastEntrySet
        ObjectBidirectionalIterator<Reference2ByteMap.Entry<K>> fastIterator();

        ObjectBidirectionalIterator<Reference2ByteMap.Entry<K>> fastIterator(Reference2ByteMap.Entry<K> entry);
    }

    @Override // java.util.SortedMap
    Reference2ByteSortedMap<K> subMap(K k, K k2);

    @Override // java.util.SortedMap
    Reference2ByteSortedMap<K> headMap(K k);

    @Override // java.util.SortedMap
    Reference2ByteSortedMap<K> tailMap(K k);

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2ByteMap
    ObjectSortedSet<Reference2ByteMap.Entry<K>> reference2ByteEntrySet();

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2ByteMap, java.util.Map
    ReferenceSortedSet<K> keySet();

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2ByteMap, java.util.Map
    ByteCollection values();

    @Override // java.util.SortedMap
    Comparator<? super K> comparator();

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2ByteMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<K, Byte>> entrySet() {
        return reference2ByteEntrySet();
    }
}
