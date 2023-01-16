package p014it.unimi.dsi.fastutil.bytes;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.bytes.Byte2ObjectMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectCollection;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;

/* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ObjectSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ObjectSortedMap.class */
public interface Byte2ObjectSortedMap<V> extends Byte2ObjectMap<V>, SortedMap<Byte, V> {

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ObjectSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ObjectSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet<V> extends ObjectSortedSet<Byte2ObjectMap.Entry<V>>, Byte2ObjectMap.FastEntrySet<V> {
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ObjectMap.FastEntrySet
        ObjectBidirectionalIterator<Byte2ObjectMap.Entry<V>> fastIterator();

        ObjectBidirectionalIterator<Byte2ObjectMap.Entry<V>> fastIterator(Byte2ObjectMap.Entry<V> entry);
    }

    Byte2ObjectSortedMap<V> subMap(byte b, byte b2);

    Byte2ObjectSortedMap<V> headMap(byte b);

    Byte2ObjectSortedMap<V> tailMap(byte b);

    byte firstByteKey();

    byte lastByteKey();

    ObjectSortedSet<Byte2ObjectMap.Entry<V>> byte2ObjectEntrySet();

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ObjectMap, java.util.Map
    ByteSortedSet keySet();

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ObjectMap, java.util.Map
    ObjectCollection<V> values();

    /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteComparator' to match base method */
    @Override // java.util.SortedMap
    Comparator<? super Byte> comparator();

    @Deprecated
    default Byte2ObjectSortedMap<V> subMap(Byte from, Byte to) {
        return subMap(from.byteValue(), to.byteValue());
    }

    @Deprecated
    default Byte2ObjectSortedMap<V> headMap(Byte to) {
        return headMap(to.byteValue());
    }

    @Deprecated
    default Byte2ObjectSortedMap<V> tailMap(Byte from) {
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

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ObjectMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<Byte, V>> entrySet() {
        return byte2ObjectEntrySet();
    }
}
