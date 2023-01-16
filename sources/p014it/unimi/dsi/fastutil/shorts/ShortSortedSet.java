package p014it.unimi.dsi.fastutil.shorts;

import java.util.Comparator;
import java.util.SortedSet;
import p014it.unimi.dsi.fastutil.Size64;

/* renamed from: it.unimi.dsi.fastutil.shorts.ShortSortedSet */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortSortedSet.class */
public interface ShortSortedSet extends ShortSet, SortedSet<Short>, ShortBidirectionalIterable {
    ShortBidirectionalIterator iterator(short s);

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortSet, p014it.unimi.dsi.fastutil.shorts.ShortCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortIterable
    ShortBidirectionalIterator iterator();

    ShortSortedSet subSet(short s, short s2);

    ShortSortedSet headSet(short s);

    ShortSortedSet tailSet(short s);

    /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortComparator' to match base method */
    @Override // java.util.SortedSet
    Comparator<? super Short> comparator();

    short firstShort();

    short lastShort();

    /* JADX WARN: Type inference failed for: r3v1, types: [it.unimi.dsi.fastutil.shorts.ShortComparator] */
    @Override // p014it.unimi.dsi.fastutil.shorts.ShortSet, p014it.unimi.dsi.fastutil.shorts.ShortCollection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortIterable
    default ShortSpliterator spliterator() {
        return ShortSpliterators.asSpliteratorFromSorted(iterator(), Size64.sizeOf(this), 341, comparator());
    }

    @Deprecated
    default ShortSortedSet subSet(Short from, Short to) {
        return subSet(from.shortValue(), to.shortValue());
    }

    @Deprecated
    default ShortSortedSet headSet(Short to) {
        return headSet(to.shortValue());
    }

    @Deprecated
    default ShortSortedSet tailSet(Short from) {
        return tailSet(from.shortValue());
    }

    @Override // java.util.SortedSet
    @Deprecated
    default Short first() {
        return Short.valueOf(firstShort());
    }

    @Override // java.util.SortedSet
    @Deprecated
    default Short last() {
        return Short.valueOf(lastShort());
    }
}
