package p014it.unimi.dsi.fastutil.doubles;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.booleans.BooleanCollection;
import p014it.unimi.dsi.fastutil.doubles.Double2BooleanMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;

/* renamed from: it.unimi.dsi.fastutil.doubles.Double2BooleanSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2BooleanSortedMap.class */
public interface Double2BooleanSortedMap extends Double2BooleanMap, SortedMap<Double, Boolean> {

    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2BooleanSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2BooleanSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet extends ObjectSortedSet<Double2BooleanMap.Entry>, Double2BooleanMap.FastEntrySet {
        @Override // p014it.unimi.dsi.fastutil.doubles.Double2BooleanMap.FastEntrySet
        ObjectBidirectionalIterator<Double2BooleanMap.Entry> fastIterator();

        ObjectBidirectionalIterator<Double2BooleanMap.Entry> fastIterator(Double2BooleanMap.Entry entry);
    }

    Double2BooleanSortedMap subMap(double d, double d2);

    Double2BooleanSortedMap headMap(double d);

    Double2BooleanSortedMap tailMap(double d);

    double firstDoubleKey();

    double lastDoubleKey();

    ObjectSortedSet<Double2BooleanMap.Entry> double2BooleanEntrySet();

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2BooleanMap, java.util.Map
    DoubleSortedSet keySet();

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2BooleanMap, java.util.Map
    BooleanCollection values();

    /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleComparator' to match base method */
    @Override // java.util.SortedMap
    Comparator<? super Double> comparator();

    @Deprecated
    default Double2BooleanSortedMap subMap(Double from, Double to) {
        return subMap(from.doubleValue(), to.doubleValue());
    }

    @Deprecated
    default Double2BooleanSortedMap headMap(Double to) {
        return headMap(to.doubleValue());
    }

    @Deprecated
    default Double2BooleanSortedMap tailMap(Double from) {
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

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2BooleanMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<Double, Boolean>> entrySet() {
        return double2BooleanEntrySet();
    }
}
