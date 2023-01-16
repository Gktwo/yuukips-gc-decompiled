package p014it.unimi.dsi.fastutil.floats;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.floats.Float2IntMap;
import p014it.unimi.dsi.fastutil.ints.IntCollection;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;

/* renamed from: it.unimi.dsi.fastutil.floats.Float2IntSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2IntSortedMap.class */
public interface Float2IntSortedMap extends Float2IntMap, SortedMap<Float, Integer> {

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2IntSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2IntSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet extends ObjectSortedSet<Float2IntMap.Entry>, Float2IntMap.FastEntrySet {
        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntMap.FastEntrySet
        ObjectBidirectionalIterator<Float2IntMap.Entry> fastIterator();

        ObjectBidirectionalIterator<Float2IntMap.Entry> fastIterator(Float2IntMap.Entry entry);
    }

    Float2IntSortedMap subMap(float f, float f2);

    Float2IntSortedMap headMap(float f);

    Float2IntSortedMap tailMap(float f);

    float firstFloatKey();

    float lastFloatKey();

    ObjectSortedSet<Float2IntMap.Entry> float2IntEntrySet();

    @Override // p014it.unimi.dsi.fastutil.floats.Float2IntMap, java.util.Map
    FloatSortedSet keySet();

    @Override // p014it.unimi.dsi.fastutil.floats.Float2IntMap, java.util.Map
    IntCollection values();

    /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatComparator' to match base method */
    @Override // java.util.SortedMap
    Comparator<? super Float> comparator();

    @Deprecated
    default Float2IntSortedMap subMap(Float from, Float to) {
        return subMap(from.floatValue(), to.floatValue());
    }

    @Deprecated
    default Float2IntSortedMap headMap(Float to) {
        return headMap(to.floatValue());
    }

    @Deprecated
    default Float2IntSortedMap tailMap(Float from) {
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

    @Override // p014it.unimi.dsi.fastutil.floats.Float2IntMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<Float, Integer>> entrySet() {
        return float2IntEntrySet();
    }
}
