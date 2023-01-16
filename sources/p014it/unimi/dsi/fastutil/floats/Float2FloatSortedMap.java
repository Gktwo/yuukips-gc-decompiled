package p014it.unimi.dsi.fastutil.floats;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.floats.Float2FloatMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;

/* renamed from: it.unimi.dsi.fastutil.floats.Float2FloatSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2FloatSortedMap.class */
public interface Float2FloatSortedMap extends Float2FloatMap, SortedMap<Float, Float> {

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2FloatSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2FloatSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet extends ObjectSortedSet<Float2FloatMap.Entry>, Float2FloatMap.FastEntrySet {
        @Override // p014it.unimi.dsi.fastutil.floats.Float2FloatMap.FastEntrySet
        ObjectBidirectionalIterator<Float2FloatMap.Entry> fastIterator();

        ObjectBidirectionalIterator<Float2FloatMap.Entry> fastIterator(Float2FloatMap.Entry entry);
    }

    Float2FloatSortedMap subMap(float f, float f2);

    Float2FloatSortedMap headMap(float f);

    Float2FloatSortedMap tailMap(float f);

    float firstFloatKey();

    float lastFloatKey();

    ObjectSortedSet<Float2FloatMap.Entry> float2FloatEntrySet();

    @Override // p014it.unimi.dsi.fastutil.floats.Float2FloatMap, java.util.Map
    FloatSortedSet keySet();

    @Override // p014it.unimi.dsi.fastutil.floats.Float2FloatMap, java.util.Map
    FloatCollection values();

    /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatComparator' to match base method */
    @Override // java.util.SortedMap
    Comparator<? super Float> comparator();

    @Deprecated
    default Float2FloatSortedMap subMap(Float from, Float to) {
        return subMap(from.floatValue(), to.floatValue());
    }

    @Deprecated
    default Float2FloatSortedMap headMap(Float to) {
        return headMap(to.floatValue());
    }

    @Deprecated
    default Float2FloatSortedMap tailMap(Float from) {
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

    @Override // p014it.unimi.dsi.fastutil.floats.Float2FloatMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<Float, Float>> entrySet() {
        return float2FloatEntrySet();
    }
}
