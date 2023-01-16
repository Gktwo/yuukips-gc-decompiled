package p014it.unimi.dsi.fastutil.objects;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.floats.FloatCollection;
import p014it.unimi.dsi.fastutil.objects.Object2FloatMap;

/* renamed from: it.unimi.dsi.fastutil.objects.Object2FloatSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2FloatSortedMap.class */
public interface Object2FloatSortedMap<K> extends Object2FloatMap<K>, SortedMap<K, Float> {

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2FloatSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2FloatSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet<K> extends ObjectSortedSet<Object2FloatMap.Entry<K>>, Object2FloatMap.FastEntrySet<K> {
        @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatMap.FastEntrySet
        ObjectBidirectionalIterator<Object2FloatMap.Entry<K>> fastIterator();

        ObjectBidirectionalIterator<Object2FloatMap.Entry<K>> fastIterator(Object2FloatMap.Entry<K> entry);
    }

    @Override // java.util.SortedMap
    Object2FloatSortedMap<K> subMap(K k, K k2);

    @Override // java.util.SortedMap
    Object2FloatSortedMap<K> headMap(K k);

    @Override // java.util.SortedMap
    Object2FloatSortedMap<K> tailMap(K k);

    ObjectSortedSet<Object2FloatMap.Entry<K>> object2FloatEntrySet();

    @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatMap, java.util.Map
    ObjectSortedSet<K> keySet();

    @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatMap, java.util.Map
    FloatCollection values();

    @Override // java.util.SortedMap
    Comparator<? super K> comparator();

    @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<K, Float>> entrySet() {
        return object2FloatEntrySet();
    }
}
