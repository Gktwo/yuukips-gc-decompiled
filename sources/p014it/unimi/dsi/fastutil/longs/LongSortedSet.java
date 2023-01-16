package p014it.unimi.dsi.fastutil.longs;

import java.util.Comparator;
import java.util.SortedSet;
import p014it.unimi.dsi.fastutil.Size64;

/* renamed from: it.unimi.dsi.fastutil.longs.LongSortedSet */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongSortedSet.class */
public interface LongSortedSet extends LongSet, SortedSet<Long>, LongBidirectionalIterable {
    LongBidirectionalIterator iterator(long j);

    @Override // p014it.unimi.dsi.fastutil.longs.LongSet, p014it.unimi.dsi.fastutil.longs.LongCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongIterable
    LongBidirectionalIterator iterator();

    LongSortedSet subSet(long j, long j2);

    LongSortedSet headSet(long j);

    LongSortedSet tailSet(long j);

    /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongComparator' to match base method */
    @Override // java.util.SortedSet
    Comparator<? super Long> comparator();

    long firstLong();

    long lastLong();

    /* JADX WARN: Type inference failed for: r3v1, types: [it.unimi.dsi.fastutil.longs.LongComparator] */
    @Override // p014it.unimi.dsi.fastutil.longs.LongSet, p014it.unimi.dsi.fastutil.longs.LongCollection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongIterable
    default LongSpliterator spliterator() {
        return LongSpliterators.asSpliteratorFromSorted(iterator(), Size64.sizeOf(this), 341, comparator());
    }

    @Deprecated
    default LongSortedSet subSet(Long from, Long to) {
        return subSet(from.longValue(), to.longValue());
    }

    @Deprecated
    default LongSortedSet headSet(Long to) {
        return headSet(to.longValue());
    }

    @Deprecated
    default LongSortedSet tailSet(Long from) {
        return tailSet(from.longValue());
    }

    @Override // java.util.SortedSet
    @Deprecated
    default Long first() {
        return Long.valueOf(firstLong());
    }

    @Override // java.util.SortedSet
    @Deprecated
    default Long last() {
        return Long.valueOf(lastLong());
    }
}
