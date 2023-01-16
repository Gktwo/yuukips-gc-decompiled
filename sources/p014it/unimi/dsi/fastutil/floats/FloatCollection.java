package p014it.unimi.dsi.fastutil.floats;

import java.util.Collection;
import java.util.Objects;
import java.util.function.DoublePredicate;
import java.util.function.Predicate;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import p014it.unimi.dsi.fastutil.SafeMath;
import p014it.unimi.dsi.fastutil.Size64;
import p014it.unimi.dsi.fastutil.doubles.DoubleIterator;
import p014it.unimi.dsi.fastutil.doubles.DoubleSpliterator;

/* renamed from: it.unimi.dsi.fastutil.floats.FloatCollection */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatCollection.class */
public interface FloatCollection extends Collection<Float>, FloatIterable {
    @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
    FloatIterator iterator();

    boolean add(float f);

    boolean contains(float f);

    boolean rem(float f);

    float[] toFloatArray();

    float[] toArray(float[] fArr);

    boolean addAll(FloatCollection floatCollection);

    boolean containsAll(FloatCollection floatCollection);

    boolean removeAll(FloatCollection floatCollection);

    boolean retainAll(FloatCollection floatCollection);

    @Override // p014it.unimi.dsi.fastutil.floats.FloatIterable
    default DoubleIterator doubleIterator() {
        return doubleIterator();
    }

    @Override // java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
    default FloatSpliterator spliterator() {
        return FloatSpliterators.asSpliterator(iterator(), Size64.sizeOf(this), 320);
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatIterable
    default DoubleSpliterator doubleSpliterator() {
        return doubleSpliterator();
    }

    @Deprecated
    default boolean add(Float key) {
        return add(key.floatValue());
    }

    @Override // java.util.Collection, p014it.unimi.dsi.fastutil.floats.FloatCollection
    @Deprecated
    default boolean contains(Object key) {
        if (key == null) {
            return false;
        }
        return contains(((Float) key).floatValue());
    }

    @Override // java.util.Collection, p014it.unimi.dsi.fastutil.floats.FloatCollection
    @Deprecated
    default boolean remove(Object key) {
        if (key == null) {
            return false;
        }
        return rem(((Float) key).floatValue());
    }

    @Deprecated
    default float[] toFloatArray(float[] a) {
        return toArray(a);
    }

    @Override // java.util.Collection
    @Deprecated
    default boolean removeIf(Predicate<? super Float> filter) {
        return removeIf(filter instanceof FloatPredicate ? (FloatPredicate) filter : key -> {
            return filter.test(Float.valueOf(SafeMath.safeDoubleToFloat((double) key)));
        });
    }

    default boolean removeIf(FloatPredicate filter) {
        Objects.requireNonNull(filter);
        boolean removed = false;
        FloatIterator each = iterator();
        while (each.hasNext()) {
            if (filter.test(each.nextFloat())) {
                each.remove();
                removed = true;
            }
        }
        return removed;
    }

    default boolean removeIf(DoublePredicate filter) {
        FloatPredicate floatPredicate;
        if (filter instanceof FloatPredicate) {
            floatPredicate = (FloatPredicate) filter;
        } else {
            Objects.requireNonNull(filter);
            floatPredicate = (v1) -> {
                return r1.test(v1);
            };
        }
        return removeIf(floatPredicate);
    }

    @Override // java.util.Collection
    @Deprecated
    default Stream<Float> stream() {
        return stream();
    }

    default DoubleStream doubleStream() {
        return StreamSupport.doubleStream(doubleSpliterator(), false);
    }

    @Override // java.util.Collection
    @Deprecated
    default Stream<Float> parallelStream() {
        return parallelStream();
    }

    default DoubleStream doubleParallelStream() {
        return StreamSupport.doubleStream(doubleSpliterator(), true);
    }
}
