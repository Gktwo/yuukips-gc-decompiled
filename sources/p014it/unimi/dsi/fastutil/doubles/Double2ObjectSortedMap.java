package p014it.unimi.dsi.fastutil.doubles;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.doubles.Double2ObjectMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectCollection;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;

/* renamed from: it.unimi.dsi.fastutil.doubles.Double2ObjectSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2ObjectSortedMap.class */
public interface Double2ObjectSortedMap<V> extends Double2ObjectMap<V>, SortedMap<Double, V> {

    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2ObjectSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2ObjectSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet<V> extends ObjectSortedSet<Double2ObjectMap.Entry<V>>, Double2ObjectMap.FastEntrySet<V> {
        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectMap.FastEntrySet
        ObjectBidirectionalIterator<Double2ObjectMap.Entry<V>> fastIterator();

        ObjectBidirectionalIterator<Double2ObjectMap.Entry<V>> fastIterator(Double2ObjectMap.Entry<V> entry);
    }

    Double2ObjectSortedMap<V> subMap(double d, double d2);

    Double2ObjectSortedMap<V> headMap(double d);

    Double2ObjectSortedMap<V> tailMap(double d);

    double firstDoubleKey();

    double lastDoubleKey();

    ObjectSortedSet<Double2ObjectMap.Entry<V>> double2ObjectEntrySet();

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectMap, java.util.Map
    DoubleSortedSet keySet();

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectMap, java.util.Map
    ObjectCollection<V> values();

    /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleComparator' to match base method */
    @Override // java.util.SortedMap
    Comparator<? super Double> comparator();

    @Deprecated
    default Double2ObjectSortedMap<V> subMap(Double from, Double to) {
        return subMap(from.doubleValue(), to.doubleValue());
    }

    @Deprecated
    default Double2ObjectSortedMap<V> headMap(Double to) {
        return headMap(to.doubleValue());
    }

    @Deprecated
    default Double2ObjectSortedMap<V> tailMap(Double from) {
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

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<Double, V>> entrySet() {
        return double2ObjectEntrySet();
    }
}
