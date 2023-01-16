package p014it.unimi.dsi.fastutil.objects;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.booleans.BooleanCollection;
import p014it.unimi.dsi.fastutil.objects.Object2BooleanMap;

/* renamed from: it.unimi.dsi.fastutil.objects.Object2BooleanSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2BooleanSortedMap.class */
public interface Object2BooleanSortedMap<K> extends Object2BooleanMap<K>, SortedMap<K, Boolean> {

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2BooleanSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2BooleanSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet<K> extends ObjectSortedSet<Object2BooleanMap.Entry<K>>, Object2BooleanMap.FastEntrySet<K> {
        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanMap.FastEntrySet
        ObjectBidirectionalIterator<Object2BooleanMap.Entry<K>> fastIterator();

        ObjectBidirectionalIterator<Object2BooleanMap.Entry<K>> fastIterator(Object2BooleanMap.Entry<K> entry);
    }

    @Override // java.util.SortedMap
    Object2BooleanSortedMap<K> subMap(K k, K k2);

    @Override // java.util.SortedMap
    Object2BooleanSortedMap<K> headMap(K k);

    @Override // java.util.SortedMap
    Object2BooleanSortedMap<K> tailMap(K k);

    ObjectSortedSet<Object2BooleanMap.Entry<K>> object2BooleanEntrySet();

    @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanMap, java.util.Map
    ObjectSortedSet<K> keySet();

    @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanMap, java.util.Map
    BooleanCollection values();

    @Override // java.util.SortedMap
    Comparator<? super K> comparator();

    @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<K, Boolean>> entrySet() {
        return object2BooleanEntrySet();
    }
}
