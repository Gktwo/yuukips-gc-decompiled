package p014it.unimi.dsi.fastutil.objects;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.objects.Object2ShortMap;
import p014it.unimi.dsi.fastutil.shorts.ShortCollection;

/* renamed from: it.unimi.dsi.fastutil.objects.Object2ShortSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ShortSortedMap.class */
public interface Object2ShortSortedMap<K> extends Object2ShortMap<K>, SortedMap<K, Short> {

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ShortSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ShortSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet<K> extends ObjectSortedSet<Object2ShortMap.Entry<K>>, Object2ShortMap.FastEntrySet<K> {
        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap.FastEntrySet
        ObjectBidirectionalIterator<Object2ShortMap.Entry<K>> fastIterator();

        ObjectBidirectionalIterator<Object2ShortMap.Entry<K>> fastIterator(Object2ShortMap.Entry<K> entry);
    }

    @Override // java.util.SortedMap
    Object2ShortSortedMap<K> subMap(K k, K k2);

    @Override // java.util.SortedMap
    Object2ShortSortedMap<K> headMap(K k);

    @Override // java.util.SortedMap
    Object2ShortSortedMap<K> tailMap(K k);

    ObjectSortedSet<Object2ShortMap.Entry<K>> object2ShortEntrySet();

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap, java.util.Map
    ObjectSortedSet<K> keySet();

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap, java.util.Map
    ShortCollection values();

    @Override // java.util.SortedMap
    Comparator<? super K> comparator();

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<K, Short>> entrySet() {
        return object2ShortEntrySet();
    }
}
