package p014it.unimi.dsi.fastutil.bytes;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.shorts.ShortCollection;

/* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ShortSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ShortSortedMap.class */
public interface Byte2ShortSortedMap extends Byte2ShortMap, SortedMap<Byte, Short> {

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ShortSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ShortSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet extends ObjectSortedSet<Byte2ShortMap.Entry>, Byte2ShortMap.FastEntrySet {
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap.FastEntrySet
        ObjectBidirectionalIterator<Byte2ShortMap.Entry> fastIterator();

        ObjectBidirectionalIterator<Byte2ShortMap.Entry> fastIterator(Byte2ShortMap.Entry entry);
    }

    Byte2ShortSortedMap subMap(byte b, byte b2);

    Byte2ShortSortedMap headMap(byte b);

    Byte2ShortSortedMap tailMap(byte b);

    byte firstByteKey();

    byte lastByteKey();

    ObjectSortedSet<Byte2ShortMap.Entry> byte2ShortEntrySet();

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap, java.util.Map
    ByteSortedSet keySet();

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap, java.util.Map
    ShortCollection values();

    /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteComparator' to match base method */
    @Override // java.util.SortedMap
    Comparator<? super Byte> comparator();

    @Deprecated
    default Byte2ShortSortedMap subMap(Byte from, Byte to) {
        return subMap(from.byteValue(), to.byteValue());
    }

    @Deprecated
    default Byte2ShortSortedMap headMap(Byte to) {
        return headMap(to.byteValue());
    }

    @Deprecated
    default Byte2ShortSortedMap tailMap(Byte from) {
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

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<Byte, Short>> entrySet() {
        return byte2ShortEntrySet();
    }
}
