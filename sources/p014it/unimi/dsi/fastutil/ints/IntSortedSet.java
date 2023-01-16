package p014it.unimi.dsi.fastutil.ints;

import java.util.Comparator;
import java.util.SortedSet;
import p014it.unimi.dsi.fastutil.Size64;

/* renamed from: it.unimi.dsi.fastutil.ints.IntSortedSet */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntSortedSet.class */
public interface IntSortedSet extends IntSet, SortedSet<Integer>, IntBidirectionalIterable {
    IntBidirectionalIterator iterator(int i);

    @Override // p014it.unimi.dsi.fastutil.ints.IntSet, p014it.unimi.dsi.fastutil.ints.IntCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntIterable
    IntBidirectionalIterator iterator();

    IntSortedSet subSet(int i, int i2);

    IntSortedSet headSet(int i);

    IntSortedSet tailSet(int i);

    /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntComparator' to match base method */
    @Override // java.util.SortedSet
    Comparator<? super Integer> comparator();

    int firstInt();

    int lastInt();

    /* JADX WARN: Type inference failed for: r3v1, types: [it.unimi.dsi.fastutil.ints.IntComparator] */
    @Override // p014it.unimi.dsi.fastutil.ints.IntSet, p014it.unimi.dsi.fastutil.ints.IntCollection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntIterable
    default IntSpliterator spliterator() {
        return IntSpliterators.asSpliteratorFromSorted(iterator(), Size64.sizeOf(this), 341, comparator());
    }

    @Deprecated
    default IntSortedSet subSet(Integer from, Integer to) {
        return subSet(from.intValue(), to.intValue());
    }

    @Deprecated
    default IntSortedSet headSet(Integer to) {
        return headSet(to.intValue());
    }

    @Deprecated
    default IntSortedSet tailSet(Integer from) {
        return tailSet(from.intValue());
    }

    @Override // java.util.SortedSet
    @Deprecated
    default Integer first() {
        return Integer.valueOf(firstInt());
    }

    @Override // java.util.SortedSet
    @Deprecated
    default Integer last() {
        return Integer.valueOf(lastInt());
    }
}
