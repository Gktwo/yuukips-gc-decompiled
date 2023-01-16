package p014it.unimi.dsi.fastutil.floats;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.floats.Float2ReferenceMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ReferenceCollection;

/* renamed from: it.unimi.dsi.fastutil.floats.Float2ReferenceSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ReferenceSortedMap.class */
public interface Float2ReferenceSortedMap<V> extends Float2ReferenceMap<V>, SortedMap<Float, V> {

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2ReferenceSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ReferenceSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet<V> extends ObjectSortedSet<Float2ReferenceMap.Entry<V>>, Float2ReferenceMap.FastEntrySet<V> {
        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceMap.FastEntrySet
        ObjectBidirectionalIterator<Float2ReferenceMap.Entry<V>> fastIterator();

        ObjectBidirectionalIterator<Float2ReferenceMap.Entry<V>> fastIterator(Float2ReferenceMap.Entry<V> entry);
    }

    Float2ReferenceSortedMap<V> subMap(float f, float f2);

    Float2ReferenceSortedMap<V> headMap(float f);

    Float2ReferenceSortedMap<V> tailMap(float f);

    float firstFloatKey();

    float lastFloatKey();

    ObjectSortedSet<Float2ReferenceMap.Entry<V>> float2ReferenceEntrySet();

    @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceMap, java.util.Map
    FloatSortedSet keySet();

    @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceMap, java.util.Map
    ReferenceCollection<V> values();

    /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatComparator' to match base method */
    @Override // java.util.SortedMap
    Comparator<? super Float> comparator();

    @Deprecated
    default Float2ReferenceSortedMap<V> subMap(Float from, Float to) {
        return subMap(from.floatValue(), to.floatValue());
    }

    @Deprecated
    default Float2ReferenceSortedMap<V> headMap(Float to) {
        return headMap(to.floatValue());
    }

    @Deprecated
    default Float2ReferenceSortedMap<V> tailMap(Float from) {
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

    @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<Float, V>> entrySet() {
        return float2ReferenceEntrySet();
    }
}
