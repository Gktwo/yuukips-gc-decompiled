package p014it.unimi.dsi.fastutil.floats;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import p014it.unimi.dsi.fastutil.doubles.DoubleIterator;
import p014it.unimi.dsi.fastutil.doubles.DoubleIterators;
import p014it.unimi.dsi.fastutil.doubles.DoubleSpliterator;
import p014it.unimi.dsi.fastutil.doubles.DoubleSpliterators;

/* renamed from: it.unimi.dsi.fastutil.floats.FloatIterable */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatIterable.class */
public interface FloatIterable extends Iterable<Float> {
    @Override // java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
    FloatIterator iterator();

    default DoubleIterator doubleIterator() {
        return DoubleIterators.wrap(iterator());
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
    default FloatSpliterator spliterator() {
        return FloatSpliterators.asSpliteratorUnknownSize(iterator(), 0);
    }

    default DoubleSpliterator doubleSpliterator() {
        return DoubleSpliterators.wrap(spliterator());
    }

    default void forEach(FloatConsumer action) {
        Objects.requireNonNull(action);
        iterator().forEachRemaining(action);
    }

    default void forEach(DoubleConsumer action) {
        FloatConsumer floatConsumer;
        Objects.requireNonNull(action);
        if (action instanceof FloatConsumer) {
            floatConsumer = (FloatConsumer) action;
        } else {
            Objects.requireNonNull(action);
            floatConsumer = (v1) -> {
                r1.accept(v1);
            };
        }
        forEach(floatConsumer);
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatIterable
    @Deprecated
    default void forEach(Consumer<? super Float> action) {
        FloatConsumer floatConsumer;
        Objects.requireNonNull(action);
        if (action instanceof FloatConsumer) {
            floatConsumer = (FloatConsumer) action;
        } else {
            Objects.requireNonNull(action);
            floatConsumer = (v1) -> {
                r1.accept(v1);
            };
        }
        forEach(floatConsumer);
    }
}
