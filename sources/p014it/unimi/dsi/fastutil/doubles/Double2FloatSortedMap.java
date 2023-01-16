package p014it.unimi.dsi.fastutil.doubles;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.doubles.Double2FloatMap;
import p014it.unimi.dsi.fastutil.floats.FloatCollection;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;

/* renamed from: it.unimi.dsi.fastutil.doubles.Double2FloatSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2FloatSortedMap.class */
public interface Double2FloatSortedMap extends Double2FloatMap, SortedMap<Double, Float> {

    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2FloatSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2FloatSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet extends ObjectSortedSet<Double2FloatMap.Entry>, Double2FloatMap.FastEntrySet {
        @Override // p014it.unimi.dsi.fastutil.doubles.Double2FloatMap.FastEntrySet
        ObjectBidirectionalIterator<Double2FloatMap.Entry> fastIterator();

        ObjectBidirectionalIterator<Double2FloatMap.Entry> fastIterator(Double2FloatMap.Entry entry);
    }

    Double2FloatSortedMap subMap(double d, double d2);

    Double2FloatSortedMap headMap(double d);

    Double2FloatSortedMap tailMap(double d);

    double firstDoubleKey();

    double lastDoubleKey();

    ObjectSortedSet<Double2FloatMap.Entry> double2FloatEntrySet();

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2FloatMap, java.util.Map
    DoubleSortedSet keySet();

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2FloatMap, java.util.Map
    FloatCollection values();

    /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleComparator' to match base method */
    @Override // java.util.SortedMap
    Comparator<? super Double> comparator();

    @Deprecated
    default Double2FloatSortedMap subMap(Double from, Double to) {
        return subMap(from.doubleValue(), to.doubleValue());
    }

    @Deprecated
    default Double2FloatSortedMap headMap(Double to) {
        return headMap(to.doubleValue());
    }

    @Deprecated
    default Double2FloatSortedMap tailMap(Double from) {
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

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2FloatMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<Double, Float>> entrySet() {
        return double2FloatEntrySet();
    }
}
