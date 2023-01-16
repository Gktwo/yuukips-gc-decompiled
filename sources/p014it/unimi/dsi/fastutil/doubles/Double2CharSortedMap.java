package p014it.unimi.dsi.fastutil.doubles;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.chars.CharCollection;
import p014it.unimi.dsi.fastutil.doubles.Double2CharMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;

/* renamed from: it.unimi.dsi.fastutil.doubles.Double2CharSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2CharSortedMap.class */
public interface Double2CharSortedMap extends Double2CharMap, SortedMap<Double, Character> {

    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2CharSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2CharSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet extends ObjectSortedSet<Double2CharMap.Entry>, Double2CharMap.FastEntrySet {
        @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharMap.FastEntrySet
        ObjectBidirectionalIterator<Double2CharMap.Entry> fastIterator();

        ObjectBidirectionalIterator<Double2CharMap.Entry> fastIterator(Double2CharMap.Entry entry);
    }

    Double2CharSortedMap subMap(double d, double d2);

    Double2CharSortedMap headMap(double d);

    Double2CharSortedMap tailMap(double d);

    double firstDoubleKey();

    double lastDoubleKey();

    ObjectSortedSet<Double2CharMap.Entry> double2CharEntrySet();

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharMap, java.util.Map
    DoubleSortedSet keySet();

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharMap, java.util.Map
    CharCollection values();

    /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleComparator' to match base method */
    @Override // java.util.SortedMap
    Comparator<? super Double> comparator();

    @Deprecated
    default Double2CharSortedMap subMap(Double from, Double to) {
        return subMap(from.doubleValue(), to.doubleValue());
    }

    @Deprecated
    default Double2CharSortedMap headMap(Double to) {
        return headMap(to.doubleValue());
    }

    @Deprecated
    default Double2CharSortedMap tailMap(Double from) {
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

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<Double, Character>> entrySet() {
        return double2CharEntrySet();
    }
}
