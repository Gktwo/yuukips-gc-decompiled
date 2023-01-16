package p014it.unimi.dsi.fastutil.bytes;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;

/* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ByteSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ByteSortedMap.class */
public interface Byte2ByteSortedMap extends Byte2ByteMap, SortedMap<Byte, Byte> {

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ByteSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ByteSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet extends ObjectSortedSet<Byte2ByteMap.Entry>, Byte2ByteMap.FastEntrySet {
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap.FastEntrySet
        ObjectBidirectionalIterator<Byte2ByteMap.Entry> fastIterator();

        ObjectBidirectionalIterator<Byte2ByteMap.Entry> fastIterator(Byte2ByteMap.Entry entry);
    }

    Byte2ByteSortedMap subMap(byte b, byte b2);

    Byte2ByteSortedMap headMap(byte b);

    Byte2ByteSortedMap tailMap(byte b);

    byte firstByteKey();

    byte lastByteKey();

    ObjectSortedSet<Byte2ByteMap.Entry> byte2ByteEntrySet();

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap, java.util.Map
    ByteSortedSet keySet();

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap, java.util.Map
    ByteCollection values();

    /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteComparator' to match base method */
    @Override // java.util.SortedMap
    Comparator<? super Byte> comparator();

    @Deprecated
    default Byte2ByteSortedMap subMap(Byte from, Byte to) {
        return subMap(from.byteValue(), to.byteValue());
    }

    @Deprecated
    default Byte2ByteSortedMap headMap(Byte to) {
        return headMap(to.byteValue());
    }

    @Deprecated
    default Byte2ByteSortedMap tailMap(Byte from) {
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

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<Byte, Byte>> entrySet() {
        return byte2ByteEntrySet();
    }
}
