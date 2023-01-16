package p014it.unimi.dsi.fastutil.floats;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.floats.Float2ObjectMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectCollection;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;

/* renamed from: it.unimi.dsi.fastutil.floats.Float2ObjectSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ObjectSortedMap.class */
public interface Float2ObjectSortedMap<V> extends Float2ObjectMap<V>, SortedMap<Float, V> {

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2ObjectSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ObjectSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet<V> extends ObjectSortedSet<Float2ObjectMap.Entry<V>>, Float2ObjectMap.FastEntrySet<V> {
        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectMap.FastEntrySet
        ObjectBidirectionalIterator<Float2ObjectMap.Entry<V>> fastIterator();

        ObjectBidirectionalIterator<Float2ObjectMap.Entry<V>> fastIterator(Float2ObjectMap.Entry<V> entry);
    }

    Float2ObjectSortedMap<V> subMap(float f, float f2);

    Float2ObjectSortedMap<V> headMap(float f);

    Float2ObjectSortedMap<V> tailMap(float f);

    float firstFloatKey();

    float lastFloatKey();

    ObjectSortedSet<Float2ObjectMap.Entry<V>> float2ObjectEntrySet();

    @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectMap, java.util.Map
    FloatSortedSet keySet();

    @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectMap, java.util.Map
    ObjectCollection<V> values();

    /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatComparator' to match base method */
    @Override // java.util.SortedMap
    Comparator<? super Float> comparator();

    @Deprecated
    default Float2ObjectSortedMap<V> subMap(Float from, Float to) {
        return subMap(from.floatValue(), to.floatValue());
    }

    @Deprecated
    default Float2ObjectSortedMap<V> headMap(Float to) {
        return headMap(to.floatValue());
    }

    @Deprecated
    default Float2ObjectSortedMap<V> tailMap(Float from) {
        return tailMap(from.floatValue());
    }

    @Override // java.util.SortedMap
    @Deprecated
    default Float firstKey() {
        return Float.valueOf(firstFloatKey());
    }

    @Override // java.util.SortedMap
    @Deprecated
    default Float lastKey() {
        return Float.valueOf(lastFloatKey());
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<Float, V>> entrySet() {
        return float2ObjectEntrySet();
    }
}
