package p014it.unimi.dsi.fastutil.shorts;

import java.util.Collection;
import java.util.Objects;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import p014it.unimi.dsi.fastutil.SafeMath;
import p014it.unimi.dsi.fastutil.Size64;
import p014it.unimi.dsi.fastutil.ints.IntIterator;
import p014it.unimi.dsi.fastutil.ints.IntSpliterator;

/* renamed from: it.unimi.dsi.fastutil.shorts.ShortCollection */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortCollection.class */
public interface ShortCollection extends Collection<Short>, ShortIterable {
    @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
    ShortIterator iterator();

    boolean add(short s);

    boolean contains(short s);

    boolean rem(short s);

    short[] toShortArray();

    short[] toArray(short[] sArr);

    boolean addAll(ShortCollection shortCollection);

    boolean containsAll(ShortCollection shortCollection);

    boolean removeAll(ShortCollection shortCollection);

    boolean retainAll(ShortCollection shortCollection);

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterable
    default IntIterator intIterator() {
        return intIterator();
    }

    @Override // java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
    default ShortSpliterator spliterator() {
        return ShortSpliterators.asSpliterator(iterator(), Size64.sizeOf(this), 320);
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterable
    default IntSpliterator intSpliterator() {
        return intSpliterator();
    }

    @Deprecated
    default boolean add(Short key) {
        return add(key.shortValue());
    }

    @Override // java.util.Collection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
    @Deprecated
    default boolean contains(Object key) {
        if (key == null) {
            return false;
        }
        return contains(((Short) key).shortValue());
    }

    @Override // java.util.Collection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
    @Deprecated
    default boolean remove(Object key) {
        if (key == null) {
            return false;
        }
        return rem(((Short) key).shortValue());
    }

    @Deprecated
    default short[] toShortArray(short[] a) {
        return toArray(a);
    }

    @Override // java.util.Collection
    @Deprecated
    default boolean removeIf(Predicate<? super Short> filter) {
        return removeIf(filter instanceof ShortPredicate ? (ShortPredicate) filter : key -> {
            return filter.test(Short.valueOf(SafeMath.safeIntToShort(key)));
        });
    }

    default boolean removeIf(ShortPredicate filter) {
        Objects.requireNonNull(filter);
        boolean removed = false;
        ShortIterator each = iterator();
        while (each.hasNext()) {
            if (filter.test(each.nextShort())) {
                each.remove();
                removed = true;
            }
        }
        return removed;
    }

    default boolean removeIf(IntPredicate filter) {
        ShortPredicate shortPredicate;
        if (filter instanceof ShortPredicate) {
            shortPredicate = (ShortPredicate) filter;
        } else {
            Objects.requireNonNull(filter);
            shortPredicate = (v1) -> {
                return r1.test(v1);
            };
        }
        return removeIf(shortPredicate);
    }

    @Override // java.util.Collection
    @Deprecated
    default Stream<Short> stream() {
        return stream();
    }

    default IntStream intStream() {
        return StreamSupport.intStream(intSpliterator(), false);
    }

    @Override // java.util.Collection
    @Deprecated
    default Stream<Short> parallelStream() {
        return parallelStream();
    }

    default IntStream intParallelStream() {
        return StreamSupport.intStream(intSpliterator(), true);
    }
}
