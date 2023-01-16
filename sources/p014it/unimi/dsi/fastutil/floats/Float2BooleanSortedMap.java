package p014it.unimi.dsi.fastutil.floats;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.booleans.BooleanCollection;
import p014it.unimi.dsi.fastutil.floats.Float2BooleanMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;

/* renamed from: it.unimi.dsi.fastutil.floats.Float2BooleanSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2BooleanSortedMap.class */
public interface Float2BooleanSortedMap extends Float2BooleanMap, SortedMap<Float, Boolean> {

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2BooleanSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2BooleanSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet extends ObjectSortedSet<Float2BooleanMap.Entry>, Float2BooleanMap.FastEntrySet {
        @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanMap.FastEntrySet
        ObjectBidirectionalIterator<Float2BooleanMap.Entry> fastIterator();

        ObjectBidirectionalIterator<Float2BooleanMap.Entry> fastIterator(Float2BooleanMap.Entry entry);
    }

    Float2BooleanSortedMap subMap(float f, float f2);

    Float2BooleanSortedMap headMap(float f);

    Float2BooleanSortedMap tailMap(float f);

    float firstFloatKey();

    float lastFloatKey();

    ObjectSortedSet<Float2BooleanMap.Entry> float2BooleanEntrySet();

    @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanMap, java.util.Map
    FloatSortedSet keySet();

    @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanMap, java.util.Map
    BooleanCollection values();

    /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatComparator' to match base method */
    @Override // java.util.SortedMap
    Comparator<? super Float> comparator();

    @Deprecated
    default Float2BooleanSortedMap subMap(Float from, Float to) {
        return subMap(from.floatValue(), to.floatValue());
    }

    @Deprecated
    default Float2BooleanSortedMap headMap(Float to) {
        return headMap(to.floatValue());
    }

    @Deprecated
    default Float2BooleanSortedMap tailMap(Float from) {
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

    @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<Float, Boolean>> entrySet() {
        return float2BooleanEntrySet();
    }
}
