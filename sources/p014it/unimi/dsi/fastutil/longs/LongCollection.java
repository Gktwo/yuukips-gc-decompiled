package p014it.unimi.dsi.fastutil.longs;

import java.util.Collection;
import java.util.Objects;
import java.util.function.LongPredicate;
import java.util.function.Predicate;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import p014it.unimi.dsi.fastutil.Size64;

/* renamed from: it.unimi.dsi.fastutil.longs.LongCollection */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongCollection.class */
public interface LongCollection extends Collection<Long>, LongIterable {
    @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
    LongIterator iterator();

    boolean add(long j);

    boolean contains(long j);

    boolean rem(long j);

    long[] toLongArray();

    long[] toArray(long[] jArr);

    boolean addAll(LongCollection longCollection);

    boolean containsAll(LongCollection longCollection);

    boolean removeAll(LongCollection longCollection);

    boolean retainAll(LongCollection longCollection);

    @Override // p014it.unimi.dsi.fastutil.longs.LongIterable
    default LongIterator longIterator() {
        return iterator();
    }

    @Override // java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
    default LongSpliterator spliterator() {
        return LongSpliterators.asSpliterator(iterator(), Size64.sizeOf(this), 320);
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongIterable
    default LongSpliterator longSpliterator() {
        return spliterator();
    }

    @Deprecated
    default boolean add(Long key) {
        return add(key.longValue());
    }

    @Override // java.util.Collection, p014it.unimi.dsi.fastutil.longs.LongCollection
    @Deprecated
    default boolean contains(Object key) {
        if (key == null) {
            return false;
        }
        return contains(((Long) key).longValue());
    }

    @Override // java.util.Collection, p014it.unimi.dsi.fastutil.longs.LongCollection
    @Deprecated
    default boolean remove(Object key) {
        if (key == null) {
            return false;
        }
        return rem(((Long) key).longValue());
    }

    @Deprecated
    default long[] toLongArray(long[] a) {
        return toArray(a);
    }

    @Override // java.util.Collection
    @Deprecated
    default boolean removeIf(Predicate<? super Long> filter) {
        return removeIf(filter instanceof LongPredicate ? (LongPredicate) filter : key -> {
            return filter.test(Long.valueOf(key));
        });
    }

    default boolean removeIf(LongPredicate filter) {
        Objects.requireNonNull(filter);
        boolean removed = false;
        LongIterator each = iterator();
        while (each.hasNext()) {
            if (filter.test(each.nextLong())) {
                each.remove();
                removed = true;
            }
        }
        return removed;
    }

    default boolean removeIf(LongPredicate filter) {
        return removeIf((LongPredicate) filter);
    }

    @Override // java.util.Collection
    @Deprecated
    default Stream<Long> stream() {
        return stream();
    }

    default LongStream longStream() {
        return StreamSupport.longStream(longSpliterator(), false);
    }

    @Override // java.util.Collection
    @Deprecated
    default Stream<Long> parallelStream() {
        return parallelStream();
    }

    default LongStream longParallelStream() {
        return StreamSupport.longStream(longSpliterator(), true);
    }
}
