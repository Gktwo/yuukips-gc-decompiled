package p014it.unimi.dsi.fastutil.doubles;

import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

/* renamed from: it.unimi.dsi.fastutil.doubles.DoubleSpliterator */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleSpliterator.class */
public interface DoubleSpliterator extends Spliterator.OfDouble {
    @Override // java.util.Spliterator.OfDouble, java.util.Spliterator.OfPrimitive, java.util.Spliterator
    DoubleSpliterator trySplit();

    @Override // java.util.Spliterator.OfDouble, java.util.Spliterator
    @Deprecated
    default boolean tryAdvance(Consumer<? super Double> action) {
        DoubleConsumer doubleConsumer;
        if (action instanceof DoubleConsumer) {
            doubleConsumer = (DoubleConsumer) action;
        } else {
            Objects.requireNonNull(action);
            doubleConsumer = (v1) -> {
                r1.accept(v1);
            };
        }
        return tryAdvance(doubleConsumer);
    }

    default boolean tryAdvance(DoubleConsumer action) {
        return tryAdvance((DoubleConsumer) action);
    }

    @Override // java.util.Spliterator.OfDouble, java.util.Spliterator
    @Deprecated
    default void forEachRemaining(Consumer<? super Double> action) {
        DoubleConsumer doubleConsumer;
        if (action instanceof DoubleConsumer) {
            doubleConsumer = (DoubleConsumer) action;
        } else {
            Objects.requireNonNull(action);
            doubleConsumer = (v1) -> {
                r1.accept(v1);
            };
        }
        forEachRemaining(doubleConsumer);
    }

    default void forEachRemaining(DoubleConsumer action) {
        forEachRemaining((DoubleConsumer) action);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [long] */
    default long skip(long n) {
        if (n < 0) {
            throw new IllegalArgumentException("Argument must be nonnegative: " + n);
        }
        char c = n;
        do {
            c--;
            if (c == 0) {
                break;
            }
        } while (tryAdvance(unused -> {
        }));
        return (n - c) - 1;
    }

    @Override // java.util.Spliterator
    default DoubleComparator getComparator() {
        throw new IllegalStateException();
    }
}
