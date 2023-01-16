package p014it.unimi.dsi.fastutil.bytes;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.bytes.Byte2DoubleMap;
import p014it.unimi.dsi.fastutil.doubles.DoubleCollection;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;

/* renamed from: it.unimi.dsi.fastutil.bytes.Byte2DoubleSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2DoubleSortedMap.class */
public interface Byte2DoubleSortedMap extends Byte2DoubleMap, SortedMap<Byte, Double> {

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2DoubleSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2DoubleSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet extends ObjectSortedSet<Byte2DoubleMap.Entry>, Byte2DoubleMap.FastEntrySet {
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleMap.FastEntrySet
        ObjectBidirectionalIterator<Byte2DoubleMap.Entry> fastIterator();

        ObjectBidirectionalIterator<Byte2DoubleMap.Entry> fastIterator(Byte2DoubleMap.Entry entry);
    }

    Byte2DoubleSortedMap subMap(byte b, byte b2);

    Byte2DoubleSortedMap headMap(byte b);

    Byte2DoubleSortedMap tailMap(byte b);

    byte firstByteKey();

    byte lastByteKey();

    ObjectSortedSet<Byte2DoubleMap.Entry> byte2DoubleEntrySet();

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleMap, java.util.Map
    ByteSortedSet keySet();

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleMap, java.util.Map
    DoubleCollection values();

    /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteComparator' to match base method */
    @Override // java.util.SortedMap
    Comparator<? super Byte> comparator();

    @Deprecated
    default Byte2DoubleSortedMap subMap(Byte from, Byte to) {
        return subMap(from.byteValue(), to.byteValue());
    }

    @Deprecated
    default Byte2DoubleSortedMap headMap(Byte to) {
        return headMap(to.byteValue());
    }

    @Deprecated
    default Byte2DoubleSortedMap tailMap(Byte from) {
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

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<Byte, Double>> entrySet() {
        return byte2DoubleEntrySet();
    }
}
