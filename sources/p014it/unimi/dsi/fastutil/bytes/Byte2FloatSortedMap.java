package p014it.unimi.dsi.fastutil.bytes;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.bytes.Byte2FloatMap;
import p014it.unimi.dsi.fastutil.floats.FloatCollection;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;

/* renamed from: it.unimi.dsi.fastutil.bytes.Byte2FloatSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2FloatSortedMap.class */
public interface Byte2FloatSortedMap extends Byte2FloatMap, SortedMap<Byte, Float> {

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2FloatSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2FloatSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet extends ObjectSortedSet<Byte2FloatMap.Entry>, Byte2FloatMap.FastEntrySet {
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatMap.FastEntrySet
        ObjectBidirectionalIterator<Byte2FloatMap.Entry> fastIterator();

        ObjectBidirectionalIterator<Byte2FloatMap.Entry> fastIterator(Byte2FloatMap.Entry entry);
    }

    Byte2FloatSortedMap subMap(byte b, byte b2);

    Byte2FloatSortedMap headMap(byte b);

    Byte2FloatSortedMap tailMap(byte b);

    byte firstByteKey();

    byte lastByteKey();

    ObjectSortedSet<Byte2FloatMap.Entry> byte2FloatEntrySet();

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatMap, java.util.Map
    ByteSortedSet keySet();

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatMap, java.util.Map
    FloatCollection values();

    /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteComparator' to match base method */
    @Override // java.util.SortedMap
    Comparator<? super Byte> comparator();

    @Deprecated
    default Byte2FloatSortedMap subMap(Byte from, Byte to) {
        return subMap(from.byteValue(), to.byteValue());
    }

    @Deprecated
    default Byte2FloatSortedMap headMap(Byte to) {
        return headMap(to.byteValue());
    }

    @Deprecated
    default Byte2FloatSortedMap tailMap(Byte from) {
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

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<Byte, Float>> entrySet() {
        return byte2FloatEntrySet();
    }
}
