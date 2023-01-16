package p014it.unimi.dsi.fastutil.floats;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.chars.CharCollection;
import p014it.unimi.dsi.fastutil.floats.Float2CharMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;

/* renamed from: it.unimi.dsi.fastutil.floats.Float2CharSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2CharSortedMap.class */
public interface Float2CharSortedMap extends Float2CharMap, SortedMap<Float, Character> {

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2CharSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2CharSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet extends ObjectSortedSet<Float2CharMap.Entry>, Float2CharMap.FastEntrySet {
        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap.FastEntrySet
        ObjectBidirectionalIterator<Float2CharMap.Entry> fastIterator();

        ObjectBidirectionalIterator<Float2CharMap.Entry> fastIterator(Float2CharMap.Entry entry);
    }

    Float2CharSortedMap subMap(float f, float f2);

    Float2CharSortedMap headMap(float f);

    Float2CharSortedMap tailMap(float f);

    float firstFloatKey();

    float lastFloatKey();

    ObjectSortedSet<Float2CharMap.Entry> float2CharEntrySet();

    @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap, java.util.Map
    FloatSortedSet keySet();

    @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap, java.util.Map
    CharCollection values();

    /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatComparator' to match base method */
    @Override // java.util.SortedMap
    Comparator<? super Float> comparator();

    @Deprecated
    default Float2CharSortedMap subMap(Float from, Float to) {
        return subMap(from.floatValue(), to.floatValue());
    }

    @Deprecated
    default Float2CharSortedMap headMap(Float to) {
        return headMap(to.floatValue());
    }

    @Deprecated
    default Float2CharSortedMap tailMap(Float from) {
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

    @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<Float, Character>> entrySet() {
        return float2CharEntrySet();
    }
}
