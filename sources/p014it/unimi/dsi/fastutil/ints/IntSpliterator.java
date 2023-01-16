package p014it.unimi.dsi.fastutil.ints;

import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* renamed from: it.unimi.dsi.fastutil.ints.IntSpliterator */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntSpliterator.class */
public interface IntSpliterator extends Spliterator.OfInt {
    @Override // java.util.Spliterator.OfInt, java.util.Spliterator.OfPrimitive, java.util.Spliterator
    IntSpliterator trySplit();

    @Override // java.util.Spliterator.OfInt, java.util.Spliterator
    @Deprecated
    default boolean tryAdvance(Consumer<? super Integer> action) {
        IntConsumer intConsumer;
        if (action instanceof IntConsumer) {
            intConsumer = (IntConsumer) action;
        } else {
            Objects.requireNonNull(action);
            intConsumer = (v1) -> {
                r1.accept(v1);
            };
        }
        return tryAdvance(intConsumer);
    }

    default boolean tryAdvance(IntConsumer action) {
        return tryAdvance((IntConsumer) action);
    }

    @Override // java.util.Spliterator.OfInt, java.util.Spliterator
    @Deprecated
    default void forEachRemaining(Consumer<? super Integer> action) {
        IntConsumer intConsumer;
        if (action instanceof IntConsumer) {
            intConsumer = (IntConsumer) action;
        } else {
            Objects.requireNonNull(action);
            intConsumer = (v1) -> {
                r1.accept(v1);
            };
        }
        forEachRemaining(intConsumer);
    }

    default void forEachRemaining(IntConsumer action) {
        forEachRemaining((IntConsumer) action);
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
    default IntComparator getComparator() {
        throw new IllegalStateException();
    }
}
