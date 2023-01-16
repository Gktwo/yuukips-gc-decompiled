package p014it.unimi.dsi.fastutil.bytes;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ReferenceCollection;

/* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ReferenceSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ReferenceSortedMap.class */
public interface Byte2ReferenceSortedMap<V> extends Byte2ReferenceMap<V>, SortedMap<Byte, V> {

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ReferenceSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ReferenceSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet<V> extends ObjectSortedSet<Byte2ReferenceMap.Entry<V>>, Byte2ReferenceMap.FastEntrySet<V> {
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceMap.FastEntrySet
        ObjectBidirectionalIterator<Byte2ReferenceMap.Entry<V>> fastIterator();

        ObjectBidirectionalIterator<Byte2ReferenceMap.Entry<V>> fastIterator(Byte2ReferenceMap.Entry<V> entry);
    }

    Byte2ReferenceSortedMap<V> subMap(byte b, byte b2);

    Byte2ReferenceSortedMap<V> headMap(byte b);

    Byte2ReferenceSortedMap<V> tailMap(byte b);

    byte firstByteKey();

    byte lastByteKey();

    ObjectSortedSet<Byte2ReferenceMap.Entry<V>> byte2ReferenceEntrySet();

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceMap, java.util.Map
    ByteSortedSet keySet();

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceMap, java.util.Map
    ReferenceCollection<V> values();

    /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteComparator' to match base method */
    @Override // java.util.SortedMap
    Comparator<? super Byte> comparator();

    @Deprecated
    default Byte2ReferenceSortedMap<V> subMap(Byte from, Byte to) {
        return subMap(from.byteValue(), to.byteValue());
    }

    @Deprecated
    default Byte2ReferenceSortedMap<V> headMap(Byte to) {
        return headMap(to.byteValue());
    }

    @Deprecated
    default Byte2ReferenceSortedMap<V> tailMap(Byte from) {
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

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<Byte, V>> entrySet() {
        return byte2ReferenceEntrySet();
    }
}
