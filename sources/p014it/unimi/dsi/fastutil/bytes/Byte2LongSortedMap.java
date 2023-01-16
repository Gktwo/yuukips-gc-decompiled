package p014it.unimi.dsi.fastutil.bytes;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.bytes.Byte2LongMap;
import p014it.unimi.dsi.fastutil.longs.LongCollection;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;

/* renamed from: it.unimi.dsi.fastutil.bytes.Byte2LongSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2LongSortedMap.class */
public interface Byte2LongSortedMap extends Byte2LongMap, SortedMap<Byte, Long> {

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2LongSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2LongSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet extends ObjectSortedSet<Byte2LongMap.Entry>, Byte2LongMap.FastEntrySet {
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongMap.FastEntrySet
        ObjectBidirectionalIterator<Byte2LongMap.Entry> fastIterator();

        ObjectBidirectionalIterator<Byte2LongMap.Entry> fastIterator(Byte2LongMap.Entry entry);
    }

    Byte2LongSortedMap subMap(byte b, byte b2);

    Byte2LongSortedMap headMap(byte b);

    Byte2LongSortedMap tailMap(byte b);

    byte firstByteKey();

    byte lastByteKey();

    ObjectSortedSet<Byte2LongMap.Entry> byte2LongEntrySet();

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongMap, java.util.Map
    ByteSortedSet keySet();

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongMap, java.util.Map
    LongCollection values();

    /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteComparator' to match base method */
    @Override // java.util.SortedMap
    Comparator<? super Byte> comparator();

    @Deprecated
    default Byte2LongSortedMap subMap(Byte from, Byte to) {
        return subMap(from.byteValue(), to.byteValue());
    }

    @Deprecated
    default Byte2LongSortedMap headMap(Byte to) {
        return headMap(to.byteValue());
    }

    @Deprecated
    default Byte2LongSortedMap tailMap(Byte from) {
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

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<Byte, Long>> entrySet() {
        return byte2LongEntrySet();
    }
}
