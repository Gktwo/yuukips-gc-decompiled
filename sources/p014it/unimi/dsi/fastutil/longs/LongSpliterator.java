package p014it.unimi.dsi.fastutil.longs;

import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

/* renamed from: it.unimi.dsi.fastutil.longs.LongSpliterator */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongSpliterator.class */
public interface LongSpliterator extends Spliterator.OfLong {
    @Override // java.util.Spliterator.OfLong, java.util.Spliterator.OfPrimitive, java.util.Spliterator
    LongSpliterator trySplit();

    @Override // java.util.Spliterator.OfLong, java.util.Spliterator
    @Deprecated
    default boolean tryAdvance(Consumer<? super Long> action) {
        LongConsumer longConsumer;
        if (action instanceof LongConsumer) {
            longConsumer = (LongConsumer) action;
        } else {
            Objects.requireNonNull(action);
            longConsumer = (v1) -> {
                r1.accept(v1);
            };
        }
        return tryAdvance(longConsumer);
    }

    default boolean tryAdvance(LongConsumer action) {
        return tryAdvance((LongConsumer) action);
    }

    @Override // java.util.Spliterator.OfLong, java.util.Spliterator
    @Deprecated
    default void forEachRemaining(Consumer<? super Long> action) {
        LongConsumer longConsumer;
        if (action instanceof LongConsumer) {
            longConsumer = (LongConsumer) action;
        } else {
            Objects.requireNonNull(action);
            longConsumer = (v1) -> {
                r1.accept(v1);
            };
        }
        forEachRemaining(longConsumer);
    }

    default void forEachRemaining(LongConsumer action) {
        forEachRemaining((LongConsumer) action);
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
    default LongComparator getComparator() {
        throw new IllegalStateException();
    }
}
