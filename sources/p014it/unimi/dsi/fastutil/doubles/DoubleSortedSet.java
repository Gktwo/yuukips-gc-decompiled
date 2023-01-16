package p014it.unimi.dsi.fastutil.doubles;

import java.util.Comparator;
import java.util.SortedSet;
import p014it.unimi.dsi.fastutil.Size64;

/* renamed from: it.unimi.dsi.fastutil.doubles.DoubleSortedSet */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleSortedSet.class */
public interface DoubleSortedSet extends DoubleSet, SortedSet<Double>, DoubleBidirectionalIterable {
    DoubleBidirectionalIterator iterator(double d);

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSet, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
    DoubleBidirectionalIterator iterator();

    DoubleSortedSet subSet(double d, double d2);

    DoubleSortedSet headSet(double d);

    DoubleSortedSet tailSet(double d);

    /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleComparator' to match base method */
    @Override // java.util.SortedSet
    Comparator<? super Double> comparator();

    double firstDouble();

    double lastDouble();

    /* JADX WARN: Type inference failed for: r3v1, types: [it.unimi.dsi.fastutil.doubles.DoubleComparator] */
    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSet, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
    default DoubleSpliterator spliterator() {
        return DoubleSpliterators.asSpliteratorFromSorted(iterator(), Size64.sizeOf(this), 341, comparator());
    }

    @Deprecated
    default DoubleSortedSet subSet(Double from, Double to) {
        return subSet(from.doubleValue(), to.doubleValue());
    }

    @Deprecated
    default DoubleSortedSet headSet(Double to) {
        return headSet(to.doubleValue());
    }

    @Deprecated
    default DoubleSortedSet tailSet(Double from) {
        return tailSet(from.doubleValue());
    }

    @Override // java.util.SortedSet
    @Deprecated
    default Double first() {
        return Double.valueOf(firstDouble());
    }

    @Override // java.util.SortedSet
    @Deprecated
    default Double last() {
        return Double.valueOf(lastDouble());
    }
}
