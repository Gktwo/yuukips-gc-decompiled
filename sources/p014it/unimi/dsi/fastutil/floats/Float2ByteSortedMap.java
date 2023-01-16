package p014it.unimi.dsi.fastutil.floats;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.bytes.ByteCollection;
import p014it.unimi.dsi.fastutil.floats.Float2ByteMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;

/* renamed from: it.unimi.dsi.fastutil.floats.Float2ByteSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ByteSortedMap.class */
public interface Float2ByteSortedMap extends Float2ByteMap, SortedMap<Float, Byte> {

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2ByteSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ByteSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet extends ObjectSortedSet<Float2ByteMap.Entry>, Float2ByteMap.FastEntrySet {
        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMap.FastEntrySet
        ObjectBidirectionalIterator<Float2ByteMap.Entry> fastIterator();

        ObjectBidirectionalIterator<Float2ByteMap.Entry> fastIterator(Float2ByteMap.Entry entry);
    }

    Float2ByteSortedMap subMap(float f, float f2);

    Float2ByteSortedMap headMap(float f);

    Float2ByteSortedMap tailMap(float f);

    float firstFloatKey();

    float lastFloatKey();

    ObjectSortedSet<Float2ByteMap.Entry> float2ByteEntrySet();

    @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMap, java.util.Map
    FloatSortedSet keySet();

    @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMap, java.util.Map
    ByteCollection values();

    /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatComparator' to match base method */
    @Override // java.util.SortedMap
    Comparator<? super Float> comparator();

    @Deprecated
    default Float2ByteSortedMap subMap(Float from, Float to) {
        return subMap(from.floatValue(), to.floatValue());
    }

    @Deprecated
    default Float2ByteSortedMap headMap(Float to) {
        return headMap(to.floatValue());
    }

    @Deprecated
    default Float2ByteSortedMap tailMap(Float from) {
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

    @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<Float, Byte>> entrySet() {
        return float2ByteEntrySet();
    }
}
