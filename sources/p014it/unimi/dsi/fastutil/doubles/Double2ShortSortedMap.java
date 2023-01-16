package p014it.unimi.dsi.fastutil.doubles;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.doubles.Double2ShortMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.shorts.ShortCollection;

/* renamed from: it.unimi.dsi.fastutil.doubles.Double2ShortSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2ShortSortedMap.class */
public interface Double2ShortSortedMap extends Double2ShortMap, SortedMap<Double, Short> {

    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2ShortSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2ShortSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet extends ObjectSortedSet<Double2ShortMap.Entry>, Double2ShortMap.FastEntrySet {
        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortMap.FastEntrySet
        ObjectBidirectionalIterator<Double2ShortMap.Entry> fastIterator();

        ObjectBidirectionalIterator<Double2ShortMap.Entry> fastIterator(Double2ShortMap.Entry entry);
    }

    Double2ShortSortedMap subMap(double d, double d2);

    Double2ShortSortedMap headMap(double d);

    Double2ShortSortedMap tailMap(double d);

    double firstDoubleKey();

    double lastDoubleKey();

    ObjectSortedSet<Double2ShortMap.Entry> double2ShortEntrySet();

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortMap, java.util.Map
    DoubleSortedSet keySet();

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortMap, java.util.Map
    ShortCollection values();

    /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleComparator' to match base method */
    @Override // java.util.SortedMap
    Comparator<? super Double> comparator();

    @Deprecated
    default Double2ShortSortedMap subMap(Double from, Double to) {
        return subMap(from.doubleValue(), to.doubleValue());
    }

    @Deprecated
    default Double2ShortSortedMap headMap(Double to) {
        return headMap(to.doubleValue());
    }

    @Deprecated
    default Double2ShortSortedMap tailMap(Double from) {
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

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<Double, Short>> entrySet() {
        return double2ShortEntrySet();
    }
}
