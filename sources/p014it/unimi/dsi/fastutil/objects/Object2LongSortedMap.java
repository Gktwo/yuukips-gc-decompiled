package p014it.unimi.dsi.fastutil.objects;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.longs.LongCollection;
import p014it.unimi.dsi.fastutil.objects.Object2LongMap;

/* renamed from: it.unimi.dsi.fastutil.objects.Object2LongSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2LongSortedMap.class */
public interface Object2LongSortedMap<K> extends Object2LongMap<K>, SortedMap<K, Long> {

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2LongSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2LongSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet<K> extends ObjectSortedSet<Object2LongMap.Entry<K>>, Object2LongMap.FastEntrySet<K> {
        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap.FastEntrySet
        ObjectBidirectionalIterator<Object2LongMap.Entry<K>> fastIterator();

        ObjectBidirectionalIterator<Object2LongMap.Entry<K>> fastIterator(Object2LongMap.Entry<K> entry);
    }

    @Override // java.util.SortedMap
    Object2LongSortedMap<K> subMap(K k, K k2);

    @Override // java.util.SortedMap
    Object2LongSortedMap<K> headMap(K k);

    @Override // java.util.SortedMap
    Object2LongSortedMap<K> tailMap(K k);

    ObjectSortedSet<Object2LongMap.Entry<K>> object2LongEntrySet();

    @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap, java.util.Map
    ObjectSortedSet<K> keySet();

    @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap, java.util.Map
    LongCollection values();

    @Override // java.util.SortedMap
    Comparator<? super K> comparator();

    @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<K, Long>> entrySet() {
        return object2LongEntrySet();
    }
}
