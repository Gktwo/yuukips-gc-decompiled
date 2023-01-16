package p014it.unimi.dsi.fastutil.doubles;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.doubles.Double2LongMap;
import p014it.unimi.dsi.fastutil.longs.LongCollection;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;

/* renamed from: it.unimi.dsi.fastutil.doubles.Double2LongSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2LongSortedMap.class */
public interface Double2LongSortedMap extends Double2LongMap, SortedMap<Double, Long> {

    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2LongSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2LongSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet extends ObjectSortedSet<Double2LongMap.Entry>, Double2LongMap.FastEntrySet {
        @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongMap.FastEntrySet
        ObjectBidirectionalIterator<Double2LongMap.Entry> fastIterator();

        ObjectBidirectionalIterator<Double2LongMap.Entry> fastIterator(Double2LongMap.Entry entry);
    }

    Double2LongSortedMap subMap(double d, double d2);

    Double2LongSortedMap headMap(double d);

    Double2LongSortedMap tailMap(double d);

    double firstDoubleKey();

    double lastDoubleKey();

    ObjectSortedSet<Double2LongMap.Entry> double2LongEntrySet();

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongMap, java.util.Map
    DoubleSortedSet keySet();

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongMap, java.util.Map
    LongCollection values();

    /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleComparator' to match base method */
    @Override // java.util.SortedMap
    Comparator<? super Double> comparator();

    @Deprecated
    default Double2LongSortedMap subMap(Double from, Double to) {
        return subMap(from.doubleValue(), to.doubleValue());
    }

    @Deprecated
    default Double2LongSortedMap headMap(Double to) {
        return headMap(to.doubleValue());
    }

    @Deprecated
    default Double2LongSortedMap tailMap(Double from) {
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

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<Double, Long>> entrySet() {
        return double2LongEntrySet();
    }
}
