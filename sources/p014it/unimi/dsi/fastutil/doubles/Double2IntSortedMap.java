package p014it.unimi.dsi.fastutil.doubles;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.doubles.Double2IntMap;
import p014it.unimi.dsi.fastutil.ints.IntCollection;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;

/* renamed from: it.unimi.dsi.fastutil.doubles.Double2IntSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2IntSortedMap.class */
public interface Double2IntSortedMap extends Double2IntMap, SortedMap<Double, Integer> {

    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2IntSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2IntSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet extends ObjectSortedSet<Double2IntMap.Entry>, Double2IntMap.FastEntrySet {
        @Override // p014it.unimi.dsi.fastutil.doubles.Double2IntMap.FastEntrySet
        ObjectBidirectionalIterator<Double2IntMap.Entry> fastIterator();

        ObjectBidirectionalIterator<Double2IntMap.Entry> fastIterator(Double2IntMap.Entry entry);
    }

    Double2IntSortedMap subMap(double d, double d2);

    Double2IntSortedMap headMap(double d);

    Double2IntSortedMap tailMap(double d);

    double firstDoubleKey();

    double lastDoubleKey();

    ObjectSortedSet<Double2IntMap.Entry> double2IntEntrySet();

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2IntMap, java.util.Map
    DoubleSortedSet keySet();

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2IntMap, java.util.Map
    IntCollection values();

    /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleComparator' to match base method */
    @Override // java.util.SortedMap
    Comparator<? super Double> comparator();

    @Deprecated
    default Double2IntSortedMap subMap(Double from, Double to) {
        return subMap(from.doubleValue(), to.doubleValue());
    }

    @Deprecated
    default Double2IntSortedMap headMap(Double to) {
        return headMap(to.doubleValue());
    }

    @Deprecated
    default Double2IntSortedMap tailMap(Double from) {
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

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2IntMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<Double, Integer>> entrySet() {
        return double2IntEntrySet();
    }
}
