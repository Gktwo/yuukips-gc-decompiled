package p014it.unimi.dsi.fastutil.floats;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.floats.Float2LongMap;
import p014it.unimi.dsi.fastutil.longs.LongCollection;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;

/* renamed from: it.unimi.dsi.fastutil.floats.Float2LongSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2LongSortedMap.class */
public interface Float2LongSortedMap extends Float2LongMap, SortedMap<Float, Long> {

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2LongSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2LongSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet extends ObjectSortedSet<Float2LongMap.Entry>, Float2LongMap.FastEntrySet {
        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap.FastEntrySet
        ObjectBidirectionalIterator<Float2LongMap.Entry> fastIterator();

        ObjectBidirectionalIterator<Float2LongMap.Entry> fastIterator(Float2LongMap.Entry entry);
    }

    Float2LongSortedMap subMap(float f, float f2);

    Float2LongSortedMap headMap(float f);

    Float2LongSortedMap tailMap(float f);

    float firstFloatKey();

    float lastFloatKey();

    ObjectSortedSet<Float2LongMap.Entry> float2LongEntrySet();

    @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap, java.util.Map
    FloatSortedSet keySet();

    @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap, java.util.Map
    LongCollection values();

    /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatComparator' to match base method */
    @Override // java.util.SortedMap
    Comparator<? super Float> comparator();

    @Deprecated
    default Float2LongSortedMap subMap(Float from, Float to) {
        return subMap(from.floatValue(), to.floatValue());
    }

    @Deprecated
    default Float2LongSortedMap headMap(Float to) {
        return headMap(to.floatValue());
    }

    @Deprecated
    default Float2LongSortedMap tailMap(Float from) {
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

    @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<Float, Long>> entrySet() {
        return float2LongEntrySet();
    }
}
