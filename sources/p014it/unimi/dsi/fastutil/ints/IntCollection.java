package p014it.unimi.dsi.fastutil.ints;

import java.util.Collection;
import java.util.Objects;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import p014it.unimi.dsi.fastutil.Size64;

/* renamed from: it.unimi.dsi.fastutil.ints.IntCollection */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntCollection.class */
public interface IntCollection extends Collection<Integer>, IntIterable {
    @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
    IntIterator iterator();

    boolean add(int i);

    boolean contains(int i);

    boolean rem(int i);

    int[] toIntArray();

    int[] toArray(int[] iArr);

    boolean addAll(IntCollection intCollection);

    boolean containsAll(IntCollection intCollection);

    boolean removeAll(IntCollection intCollection);

    boolean retainAll(IntCollection intCollection);

    @Override // p014it.unimi.dsi.fastutil.ints.IntIterable
    default IntIterator intIterator() {
        return iterator();
    }

    @Override // java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
    default IntSpliterator spliterator() {
        return IntSpliterators.asSpliterator(iterator(), Size64.sizeOf(this), 320);
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntIterable
    default IntSpliterator intSpliterator() {
        return spliterator();
    }

    @Deprecated
    default boolean add(Integer key) {
        return add(key.intValue());
    }

    @Override // java.util.Collection, p014it.unimi.dsi.fastutil.ints.IntCollection
    @Deprecated
    default boolean contains(Object key) {
        if (key == null) {
            return false;
        }
        return contains(((Integer) key).intValue());
    }

    @Override // java.util.Collection, p014it.unimi.dsi.fastutil.ints.IntCollection
    @Deprecated
    default boolean remove(Object key) {
        if (key == null) {
            return false;
        }
        return rem(((Integer) key).intValue());
    }

    @Deprecated
    default int[] toIntArray(int[] a) {
        return toArray(a);
    }

    @Override // java.util.Collection
    @Deprecated
    default boolean removeIf(Predicate<? super Integer> filter) {
        return removeIf(filter instanceof IntPredicate ? (IntPredicate) filter : key -> {
            return filter.test(Integer.valueOf(key));
        });
    }

    default boolean removeIf(IntPredicate filter) {
        Objects.requireNonNull(filter);
        boolean removed = false;
        IntIterator each = iterator();
        while (each.hasNext()) {
            if (filter.test(each.nextInt())) {
                each.remove();
                removed = true;
            }
        }
        return removed;
    }

    default boolean removeIf(IntPredicate filter) {
        return removeIf((IntPredicate) filter);
    }

    @Override // java.util.Collection
    @Deprecated
    default Stream<Integer> stream() {
        return stream();
    }

    default IntStream intStream() {
        return StreamSupport.intStream(intSpliterator(), false);
    }

    @Override // java.util.Collection
    @Deprecated
    default Stream<Integer> parallelStream() {
        return parallelStream();
    }

    default IntStream intParallelStream() {
        return StreamSupport.intStream(intSpliterator(), true);
    }
}
