package p014it.unimi.dsi.fastutil.doubles;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.doubles.Double2ReferenceMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ReferenceCollection;

/* renamed from: it.unimi.dsi.fastutil.doubles.Double2ReferenceSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2ReferenceSortedMap.class */
public interface Double2ReferenceSortedMap<V> extends Double2ReferenceMap<V>, SortedMap<Double, V> {

    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2ReferenceSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2ReferenceSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet<V> extends ObjectSortedSet<Double2ReferenceMap.Entry<V>>, Double2ReferenceMap.FastEntrySet<V> {
        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ReferenceMap.FastEntrySet
        ObjectBidirectionalIterator<Double2ReferenceMap.Entry<V>> fastIterator();

        ObjectBidirectionalIterator<Double2ReferenceMap.Entry<V>> fastIterator(Double2ReferenceMap.Entry<V> entry);
    }

    Double2ReferenceSortedMap<V> subMap(double d, double d2);

    Double2ReferenceSortedMap<V> headMap(double d);

    Double2ReferenceSortedMap<V> tailMap(double d);

    double firstDoubleKey();

    double lastDoubleKey();

    ObjectSortedSet<Double2ReferenceMap.Entry<V>> double2ReferenceEntrySet();

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2ReferenceMap, java.util.Map
    DoubleSortedSet keySet();

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2ReferenceMap, java.util.Map
    ReferenceCollection<V> values();

    /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleComparator' to match base method */
    @Override // java.util.SortedMap
    Comparator<? super Double> comparator();

    @Deprecated
    default Double2ReferenceSortedMap<V> subMap(Double from, Double to) {
        return subMap(from.doubleValue(), to.doubleValue());
    }

    @Deprecated
    default Double2ReferenceSortedMap<V> headMap(Double to) {
        return headMap(to.doubleValue());
    }

    @Deprecated
    default Double2ReferenceSortedMap<V> tailMap(Double from) {
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

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2ReferenceMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<Double, V>> entrySet() {
        return double2ReferenceEntrySet();
    }
}
