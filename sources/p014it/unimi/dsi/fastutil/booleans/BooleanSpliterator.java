package p014it.unimi.dsi.fastutil.booleans;

import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Consumer;

/* renamed from: it.unimi.dsi.fastutil.booleans.BooleanSpliterator */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanSpliterator.class */
public interface BooleanSpliterator extends Spliterator.OfPrimitive<Boolean, BooleanConsumer, BooleanSpliterator> {
    @Override // java.util.Spliterator.OfPrimitive, java.util.Spliterator
    BooleanSpliterator trySplit();

    @Override // java.util.Spliterator
    @Deprecated
    default boolean tryAdvance(Consumer<? super Boolean> action) {
        BooleanConsumer booleanConsumer;
        if (action instanceof BooleanConsumer) {
            booleanConsumer = (BooleanConsumer) action;
        } else {
            Objects.requireNonNull(action);
            booleanConsumer = (v1) -> {
                r1.accept(v1);
            };
        }
        return tryAdvance((BooleanSpliterator) booleanConsumer);
    }

    @Override // java.util.Spliterator
    @Deprecated
    default void forEachRemaining(Consumer<? super Boolean> action) {
        BooleanConsumer booleanConsumer;
        if (action instanceof BooleanConsumer) {
            booleanConsumer = (BooleanConsumer) action;
        } else {
            Objects.requireNonNull(action);
            booleanConsumer = (v1) -> {
                r1.accept(v1);
            };
        }
        forEachRemaining((BooleanSpliterator) booleanConsumer);
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
        } while (tryAdvance((BooleanSpliterator) unused -> {
        }));
        return (n - c) - 1;
    }

    @Override // java.util.Spliterator
    default BooleanComparator getComparator() {
        throw new IllegalStateException();
    }
}
