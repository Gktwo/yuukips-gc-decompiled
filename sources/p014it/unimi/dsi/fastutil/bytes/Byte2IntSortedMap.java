package p014it.unimi.dsi.fastutil.bytes;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.bytes.Byte2IntMap;
import p014it.unimi.dsi.fastutil.ints.IntCollection;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;

/* renamed from: it.unimi.dsi.fastutil.bytes.Byte2IntSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2IntSortedMap.class */
public interface Byte2IntSortedMap extends Byte2IntMap, SortedMap<Byte, Integer> {

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2IntSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2IntSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet extends ObjectSortedSet<Byte2IntMap.Entry>, Byte2IntMap.FastEntrySet {
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntMap.FastEntrySet
        ObjectBidirectionalIterator<Byte2IntMap.Entry> fastIterator();

        ObjectBidirectionalIterator<Byte2IntMap.Entry> fastIterator(Byte2IntMap.Entry entry);
    }

    Byte2IntSortedMap subMap(byte b, byte b2);

    Byte2IntSortedMap headMap(byte b);

    Byte2IntSortedMap tailMap(byte b);

    byte firstByteKey();

    byte lastByteKey();

    ObjectSortedSet<Byte2IntMap.Entry> byte2IntEntrySet();

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntMap, java.util.Map
    ByteSortedSet keySet();

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntMap, java.util.Map
    IntCollection values();

    /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteComparator' to match base method */
    @Override // java.util.SortedMap
    Comparator<? super Byte> comparator();

    @Deprecated
    default Byte2IntSortedMap subMap(Byte from, Byte to) {
        return subMap(from.byteValue(), to.byteValue());
    }

    @Deprecated
    default Byte2IntSortedMap headMap(Byte to) {
        return headMap(to.byteValue());
    }

    @Deprecated
    default Byte2IntSortedMap tailMap(Byte from) {
        return tailMap(from.byteValue());
    }

    @Override // java.util.SortedMap
    @Deprecated
    default Byte firstKey() {
        return Byte.valueOf(firstByteKey());
    }

    @Override // java.util.SortedMap
    @Deprecated
    default Byte lastKey() {
        return Byte.valueOf(lastByteKey());
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<Byte, Integer>> entrySet() {
        return byte2IntEntrySet();
    }
}
