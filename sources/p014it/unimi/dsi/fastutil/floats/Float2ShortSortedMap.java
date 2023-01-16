package p014it.unimi.dsi.fastutil.floats;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.floats.Float2ShortMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.shorts.ShortCollection;

/* renamed from: it.unimi.dsi.fastutil.floats.Float2ShortSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ShortSortedMap.class */
public interface Float2ShortSortedMap extends Float2ShortMap, SortedMap<Float, Short> {

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2ShortSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ShortSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet extends ObjectSortedSet<Float2ShortMap.Entry>, Float2ShortMap.FastEntrySet {
        @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortMap.FastEntrySet
        ObjectBidirectionalIterator<Float2ShortMap.Entry> fastIterator();

        ObjectBidirectionalIterator<Float2ShortMap.Entry> fastIterator(Float2ShortMap.Entry entry);
    }

    Float2ShortSortedMap subMap(float f, float f2);

    Float2ShortSortedMap headMap(float f);

    Float2ShortSortedMap tailMap(float f);

    float firstFloatKey();

    float lastFloatKey();

    ObjectSortedSet<Float2ShortMap.Entry> float2ShortEntrySet();

    @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortMap, java.util.Map
    FloatSortedSet keySet();

    @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortMap, java.util.Map
    ShortCollection values();

    /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatComparator' to match base method */
    @Override // java.util.SortedMap
    Comparator<? super Float> comparator();

    @Deprecated
    default Float2ShortSortedMap subMap(Float from, Float to) {
        return subMap(from.floatValue(), to.floatValue());
    }

    @Deprecated
    default Float2ShortSortedMap headMap(Float to) {
        return headMap(to.floatValue());
    }

    @Deprecated
    default Float2ShortSortedMap tailMap(Float from) {
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

    @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<Float, Short>> entrySet() {
        return float2ShortEntrySet();
    }
}
