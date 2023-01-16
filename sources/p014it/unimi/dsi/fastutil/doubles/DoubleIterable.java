package p014it.unimi.dsi.fastutil.doubles;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

/* renamed from: it.unimi.dsi.fastutil.doubles.DoubleIterable */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleIterable.class */
public interface DoubleIterable extends Iterable<Double> {
    @Override // java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
    DoubleIterator iterator();

    default DoubleIterator doubleIterator() {
        return iterator();
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
    default DoubleSpliterator spliterator() {
        return DoubleSpliterators.asSpliteratorUnknownSize(iterator(), 0);
    }

    default DoubleSpliterator doubleSpliterator() {
        return spliterator();
    }

    default void forEach(DoubleConsumer action) {
        Objects.requireNonNull(action);
        iterator().forEachRemaining(action);
    }

    default void forEach(DoubleConsumer action) {
        forEach((DoubleConsumer) action);
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterable
    @Deprecated
    default void forEach(Consumer<? super Double> action) {
        DoubleConsumer doubleConsumer;
        Objects.requireNonNull(action);
        if (action instanceof DoubleConsumer) {
            doubleConsumer = (DoubleConsumer) action;
        } else {
            Objects.requireNonNull(action);
            doubleConsumer = (v1) -> {
                r1.accept(v1);
            };
        }
        forEach(doubleConsumer);
    }
}
