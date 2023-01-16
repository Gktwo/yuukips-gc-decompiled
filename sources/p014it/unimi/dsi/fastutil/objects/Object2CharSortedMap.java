package p014it.unimi.dsi.fastutil.objects;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.chars.CharCollection;
import p014it.unimi.dsi.fastutil.objects.Object2CharMap;

/* renamed from: it.unimi.dsi.fastutil.objects.Object2CharSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2CharSortedMap.class */
public interface Object2CharSortedMap<K> extends Object2CharMap<K>, SortedMap<K, Character> {

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2CharSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2CharSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet<K> extends ObjectSortedSet<Object2CharMap.Entry<K>>, Object2CharMap.FastEntrySet<K> {
        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap.FastEntrySet
        ObjectBidirectionalIterator<Object2CharMap.Entry<K>> fastIterator();

        ObjectBidirectionalIterator<Object2CharMap.Entry<K>> fastIterator(Object2CharMap.Entry<K> entry);
    }

    @Override // java.util.SortedMap
    Object2CharSortedMap<K> subMap(K k, K k2);

    @Override // java.util.SortedMap
    Object2CharSortedMap<K> headMap(K k);

    @Override // java.util.SortedMap
    Object2CharSortedMap<K> tailMap(K k);

    ObjectSortedSet<Object2CharMap.Entry<K>> object2CharEntrySet();

    @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap, java.util.Map
    ObjectSortedSet<K> keySet();

    @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap, java.util.Map
    CharCollection values();

    @Override // java.util.SortedMap
    Comparator<? super K> comparator();

    @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<K, Character>> entrySet() {
        return object2CharEntrySet();
    }
}
