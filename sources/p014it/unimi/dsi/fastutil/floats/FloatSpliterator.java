package p014it.unimi.dsi.fastutil.floats;

import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Consumer;

/* renamed from: it.unimi.dsi.fastutil.floats.FloatSpliterator */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatSpliterator.class */
public interface FloatSpliterator extends Spliterator.OfPrimitive<Float, FloatConsumer, FloatSpliterator> {
    @Override // java.util.Spliterator.OfPrimitive, java.util.Spliterator
    FloatSpliterator trySplit();

    @Override // java.util.Spliterator
    @Deprecated
    default boolean tryAdvance(Consumer<? super Float> action) {
        FloatConsumer floatConsumer;
        if (action instanceof FloatConsumer) {
            floatConsumer = (FloatConsumer) action;
        } else {
            Objects.requireNonNull(action);
            floatConsumer = (v1) -> {
                r1.accept(v1);
            };
        }
        return tryAdvance((FloatSpliterator) floatConsumer);
    }

    @Override // java.util.Spliterator
    @Deprecated
    default void forEachRemaining(Consumer<? super Float> action) {
        FloatConsumer floatConsumer;
        if (action instanceof FloatConsumer) {
            floatConsumer = (FloatConsumer) action;
        } else {
            Objects.requireNonNull(action);
            floatConsumer = (v1) -> {
                r1.accept(v1);
            };
        }
        forEachRemaining((FloatSpliterator) floatConsumer);
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
        } while (tryAdvance((FloatSpliterator) unused -> {
        }));
        return (n - c) - 1;
    }

    @Override // java.util.Spliterator
    default FloatComparator getComparator() {
        throw new IllegalStateException();
    }
}
