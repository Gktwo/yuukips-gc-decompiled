package p014it.unimi.dsi.fastutil.floats;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.doubles.DoubleCollection;
import p014it.unimi.dsi.fastutil.floats.Float2DoubleMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;

/* renamed from: it.unimi.dsi.fastutil.floats.Float2DoubleSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2DoubleSortedMap.class */
public interface Float2DoubleSortedMap extends Float2DoubleMap, SortedMap<Float, Double> {

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2DoubleSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2DoubleSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet extends ObjectSortedSet<Float2DoubleMap.Entry>, Float2DoubleMap.FastEntrySet {
        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMap.FastEntrySet
        ObjectBidirectionalIterator<Float2DoubleMap.Entry> fastIterator();

        ObjectBidirectionalIterator<Float2DoubleMap.Entry> fastIterator(Float2DoubleMap.Entry entry);
    }

    Float2DoubleSortedMap subMap(float f, float f2);

    Float2DoubleSortedMap headMap(float f);

    Float2DoubleSortedMap tailMap(float f);

    float firstFloatKey();

    float lastFloatKey();

    ObjectSortedSet<Float2DoubleMap.Entry> float2DoubleEntrySet();

    @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMap, java.util.Map
    FloatSortedSet keySet();

    @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMap, java.util.Map
    DoubleCollection values();

    /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatComparator' to match base method */
    @Override // java.util.SortedMap
    Comparator<? super Float> comparator();

    @Deprecated
    default Float2DoubleSortedMap subMap(Float from, Float to) {
        return subMap(from.floatValue(), to.floatValue());
    }

    @Deprecated
    default Float2DoubleSortedMap headMap(Float to) {
        return headMap(to.floatValue());
    }

    @Deprecated
    default Float2DoubleSortedMap tailMap(Float from) {
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

    @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<Float, Double>> entrySet() {
        return float2DoubleEntrySet();
    }
}
