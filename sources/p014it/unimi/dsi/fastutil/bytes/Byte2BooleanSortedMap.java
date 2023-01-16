package p014it.unimi.dsi.fastutil.bytes;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.booleans.BooleanCollection;
import p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;

/* renamed from: it.unimi.dsi.fastutil.bytes.Byte2BooleanSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2BooleanSortedMap.class */
public interface Byte2BooleanSortedMap extends Byte2BooleanMap, SortedMap<Byte, Boolean> {

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2BooleanSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2BooleanSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet extends ObjectSortedSet<Byte2BooleanMap.Entry>, Byte2BooleanMap.FastEntrySet {
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap.FastEntrySet
        ObjectBidirectionalIterator<Byte2BooleanMap.Entry> fastIterator();

        ObjectBidirectionalIterator<Byte2BooleanMap.Entry> fastIterator(Byte2BooleanMap.Entry entry);
    }

    Byte2BooleanSortedMap subMap(byte b, byte b2);

    Byte2BooleanSortedMap headMap(byte b);

    Byte2BooleanSortedMap tailMap(byte b);

    byte firstByteKey();

    byte lastByteKey();

    ObjectSortedSet<Byte2BooleanMap.Entry> byte2BooleanEntrySet();

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    ByteSortedSet keySet();

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    BooleanCollection values();

    /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteComparator' to match base method */
    @Override // java.util.SortedMap
    Comparator<? super Byte> comparator();

    @Deprecated
    default Byte2BooleanSortedMap subMap(Byte from, Byte to) {
        return subMap(from.byteValue(), to.byteValue());
    }

    @Deprecated
    default Byte2BooleanSortedMap headMap(Byte to) {
        return headMap(to.byteValue());
    }

    @Deprecated
    default Byte2BooleanSortedMap tailMap(Byte from) {
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

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<Byte, Boolean>> entrySet() {
        return byte2BooleanEntrySet();
    }
}
