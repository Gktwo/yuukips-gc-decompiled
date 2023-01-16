package p014it.unimi.dsi.fastutil.doubles;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.bytes.ByteCollection;
import p014it.unimi.dsi.fastutil.doubles.Double2ByteMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;

/* renamed from: it.unimi.dsi.fastutil.doubles.Double2ByteSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2ByteSortedMap.class */
public interface Double2ByteSortedMap extends Double2ByteMap, SortedMap<Double, Byte> {

    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2ByteSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2ByteSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet extends ObjectSortedSet<Double2ByteMap.Entry>, Double2ByteMap.FastEntrySet {
        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ByteMap.FastEntrySet
        ObjectBidirectionalIterator<Double2ByteMap.Entry> fastIterator();

        ObjectBidirectionalIterator<Double2ByteMap.Entry> fastIterator(Double2ByteMap.Entry entry);
    }

    Double2ByteSortedMap subMap(double d, double d2);

    Double2ByteSortedMap headMap(double d);

    Double2ByteSortedMap tailMap(double d);

    double firstDoubleKey();

    double lastDoubleKey();

    ObjectSortedSet<Double2ByteMap.Entry> double2ByteEntrySet();

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2ByteMap, java.util.Map
    DoubleSortedSet keySet();

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2ByteMap, java.util.Map
    ByteCollection values();

    /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleComparator' to match base method */
    @Override // java.util.SortedMap
    Comparator<? super Double> comparator();

    @Deprecated
    default Double2ByteSortedMap subMap(Double from, Double to) {
        return subMap(from.doubleValue(), to.doubleValue());
    }

    @Deprecated
    default Double2ByteSortedMap headMap(Double to) {
        return headMap(to.doubleValue());
    }

    @Deprecated
    default Double2ByteSortedMap tailMap(Double from) {
        return tailMap(from.doubleValue());
    }

    @Override // java.util.SortedMap
    @Deprecated
    default Double firstKey() {
        return Double.valueOf(firstDoubleKey());
    }

    @Override // java.util.SortedMap
    @Deprecated
    default Double lastKey() {
        return Double.valueOf(lastDoubleKey());
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2ByteMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<Double, Byte>> entrySet() {
        return double2ByteEntrySet();
    }
}
