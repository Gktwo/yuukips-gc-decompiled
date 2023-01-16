package p014it.unimi.dsi.fastutil.doubles;

import java.util.Collection;
import java.util.Objects;
import java.util.function.DoublePredicate;
import java.util.function.Predicate;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import p014it.unimi.dsi.fastutil.Size64;

/* renamed from: it.unimi.dsi.fastutil.doubles.DoubleCollection */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleCollection.class */
public interface DoubleCollection extends Collection<Double>, DoubleIterable {
    @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
    DoubleIterator iterator();

    boolean add(double d);

    boolean contains(double d);

    boolean rem(double d);

    double[] toDoubleArray();

    double[] toArray(double[] dArr);

    boolean addAll(DoubleCollection doubleCollection);

    boolean containsAll(DoubleCollection doubleCollection);

    boolean removeAll(DoubleCollection doubleCollection);

    boolean retainAll(DoubleCollection doubleCollection);

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterable
    default DoubleIterator doubleIterator() {
        return iterator();
    }

    @Override // java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
    default DoubleSpliterator spliterator() {
        return DoubleSpliterators.asSpliterator(iterator(), Size64.sizeOf(this), 320);
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterable
    default DoubleSpliterator doubleSpliterator() {
        return spliterator();
    }

    @Deprecated
    default boolean add(Double key) {
        return add(key.doubleValue());
    }

    @Override // java.util.Collection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
    @Deprecated
    default boolean contains(Object key) {
        if (key == null) {
            return false;
        }
        return contains(((Double) key).doubleValue());
    }

    @Override // java.util.Collection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
    @Deprecated
    default boolean remove(Object key) {
        if (key == null) {
            return false;
        }
        return rem(((Double) key).doubleValue());
    }

    @Deprecated
    default double[] toDoubleArray(double[] a) {
        return toArray(a);
    }

    @Override // java.util.Collection
    @Deprecated
    default boolean removeIf(Predicate<? super Double> filter) {
        return removeIf(filter instanceof DoublePredicate ? (DoublePredicate) filter : key -> {
            return filter.test(Double.valueOf(key));
        });
    }

    default boolean removeIf(DoublePredicate filter) {
        Objects.requireNonNull(filter);
        boolean removed = false;
        DoubleIterator each = iterator();
        while (each.hasNext()) {
            if (filter.test(each.nextDouble())) {
                each.remove();
                removed = true;
            }
        }
        return removed;
    }

    default boolean removeIf(DoublePredicate filter) {
        return removeIf((DoublePredicate) filter);
    }

    @Override // java.util.Collection
    @Deprecated
    default Stream<Double> stream() {
        return stream();
    }

    default DoubleStream doubleStream() {
        return StreamSupport.doubleStream(doubleSpliterator(), false);
    }

    @Override // java.util.Collection
    @Deprecated
    default Stream<Double> parallelStream() {
        return parallelStream();
    }

    default DoubleStream doubleParallelStream() {
        return StreamSupport.doubleStream(doubleSpliterator(), true);
    }
}
