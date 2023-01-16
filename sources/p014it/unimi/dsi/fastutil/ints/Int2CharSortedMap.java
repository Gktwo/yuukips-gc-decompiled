package p014it.unimi.dsi.fastutil.ints;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.chars.CharCollection;
import p014it.unimi.dsi.fastutil.ints.Int2CharMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;

/* renamed from: it.unimi.dsi.fastutil.ints.Int2CharSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2CharSortedMap.class */
public interface Int2CharSortedMap extends Int2CharMap, SortedMap<Integer, Character> {

    /* renamed from: it.unimi.dsi.fastutil.ints.Int2CharSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2CharSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet extends ObjectSortedSet<Int2CharMap.Entry>, Int2CharMap.FastEntrySet {
        @Override // p014it.unimi.dsi.fastutil.ints.Int2CharMap.FastEntrySet
        ObjectBidirectionalIterator<Int2CharMap.Entry> fastIterator();

        ObjectBidirectionalIterator<Int2CharMap.Entry> fastIterator(Int2CharMap.Entry entry);
    }

    Int2CharSortedMap subMap(int i, int i2);

    Int2CharSortedMap headMap(int i);

    Int2CharSortedMap tailMap(int i);

    int firstIntKey();

    int lastIntKey();

    ObjectSortedSet<Int2CharMap.Entry> int2CharEntrySet();

    @Override // p014it.unimi.dsi.fastutil.ints.Int2CharMap, java.util.Map
    IntSortedSet keySet();

    @Override // p014it.unimi.dsi.fastutil.ints.Int2CharMap, java.util.Map
    CharCollection values();

    /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntComparator' to match base method */
    @Override // java.util.SortedMap
    Comparator<? super Integer> comparator();

    @Deprecated
    default Int2CharSortedMap subMap(Integer from, Integer to) {
        return subMap(from.intValue(), to.intValue());
    }

    @Deprecated
    default Int2CharSortedMap headMap(Integer to) {
        return headMap(to.intValue());
    }

    @Deprecated
    default Int2CharSortedMap tailMap(Integer from) {
        return tailMap(from.intValue());
    }

    @Override // java.util.SortedMap
    @Deprecated
    default Integer firstKey() {
        return Integer.valueOf(firstIntKey());
    }

    @Override // java.util.SortedMap
    @Deprecated
    default Integer lastKey() {
        return Integer.valueOf(lastIntKey());
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2CharMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<Integer, Character>> entrySet() {
        return int2CharEntrySet();
    }
}
