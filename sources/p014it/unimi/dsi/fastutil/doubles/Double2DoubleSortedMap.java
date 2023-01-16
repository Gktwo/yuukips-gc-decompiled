package p014it.unimi.dsi.fastutil.doubles;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.doubles.Double2DoubleMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;

/* renamed from: it.unimi.dsi.fastutil.doubles.Double2DoubleSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2DoubleSortedMap.class */
public interface Double2DoubleSortedMap extends Double2DoubleMap, SortedMap<Double, Double> {

    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2DoubleSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2DoubleSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet extends ObjectSortedSet<Double2DoubleMap.Entry>, Double2DoubleMap.FastEntrySet {
        @Override // p014it.unimi.dsi.fastutil.doubles.Double2DoubleMap.FastEntrySet
        ObjectBidirectionalIterator<Double2DoubleMap.Entry> fastIterator();

        ObjectBidirectionalIterator<Double2DoubleMap.Entry> fastIterator(Double2DoubleMap.Entry entry);
    }

    Double2DoubleSortedMap subMap(double d, double d2);

    Double2DoubleSortedMap headMap(double d);

    Double2DoubleSortedMap tailMap(double d);

    double firstDoubleKey();

    double lastDoubleKey();

    ObjectSortedSet<Double2DoubleMap.Entry> double2DoubleEntrySet();

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2DoubleMap, java.util.Map
    DoubleSortedSet keySet();

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2DoubleMap, java.util.Map
    DoubleCollection values();

    /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleComparator' to match base method */
    @Override // java.util.SortedMap
    Comparator<? super Double> comparator();

    @Deprecated
    default Double2DoubleSortedMap subMap(Double from, Double to) {
        return subMap(from.doubleValue(), to.doubleValue());
    }

    @Deprecated
    default Double2DoubleSortedMap headMap(Double to) {
        return headMap(to.doubleValue());
    }

    @Deprecated
    default Double2DoubleSortedMap tailMap(Double from) {
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

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2DoubleMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<Double, Double>> entrySet() {
        return double2DoubleEntrySet();
    }
}
