package p014it.unimi.dsi.fastutil.objects;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.bytes.ByteCollection;
import p014it.unimi.dsi.fastutil.objects.Object2ByteMap;

/* renamed from: it.unimi.dsi.fastutil.objects.Object2ByteSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ByteSortedMap.class */
public interface Object2ByteSortedMap<K> extends Object2ByteMap<K>, SortedMap<K, Byte> {

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ByteSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ByteSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet<K> extends ObjectSortedSet<Object2ByteMap.Entry<K>>, Object2ByteMap.FastEntrySet<K> {
        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap.FastEntrySet
        ObjectBidirectionalIterator<Object2ByteMap.Entry<K>> fastIterator();

        ObjectBidirectionalIterator<Object2ByteMap.Entry<K>> fastIterator(Object2ByteMap.Entry<K> entry);
    }

    @Override // java.util.SortedMap
    Object2ByteSortedMap<K> subMap(K k, K k2);

    @Override // java.util.SortedMap
    Object2ByteSortedMap<K> headMap(K k);

    @Override // java.util.SortedMap
    Object2ByteSortedMap<K> tailMap(K k);

    ObjectSortedSet<Object2ByteMap.Entry<K>> object2ByteEntrySet();

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap, java.util.Map
    ObjectSortedSet<K> keySet();

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap, java.util.Map
    ByteCollection values();

    @Override // java.util.SortedMap
    Comparator<? super K> comparator();

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<K, Byte>> entrySet() {
        return object2ByteEntrySet();
    }
}
