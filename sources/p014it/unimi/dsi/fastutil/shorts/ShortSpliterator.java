package p014it.unimi.dsi.fastutil.shorts;

import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Consumer;

/* renamed from: it.unimi.dsi.fastutil.shorts.ShortSpliterator */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortSpliterator.class */
public interface ShortSpliterator extends Spliterator.OfPrimitive<Short, ShortConsumer, ShortSpliterator> {
    @Override // java.util.Spliterator.OfPrimitive, java.util.Spliterator
    ShortSpliterator trySplit();

    @Override // java.util.Spliterator
    @Deprecated
    default boolean tryAdvance(Consumer<? super Short> action) {
        ShortConsumer shortConsumer;
        if (action instanceof ShortConsumer) {
            shortConsumer = (ShortConsumer) action;
        } else {
            Objects.requireNonNull(action);
            shortConsumer = (v1) -> {
                r1.accept(v1);
            };
        }
        return tryAdvance((ShortSpliterator) shortConsumer);
    }

    @Override // java.util.Spliterator
    @Deprecated
    default void forEachRemaining(Consumer<? super Short> action) {
        ShortConsumer shortConsumer;
        if (action instanceof ShortConsumer) {
            shortConsumer = (ShortConsumer) action;
        } else {
            Objects.requireNonNull(action);
            shortConsumer = (v1) -> {
                r1.accept(v1);
            };
        }
        forEachRemaining((ShortSpliterator) shortConsumer);
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
        } while (tryAdvance((ShortSpliterator) unused -> {
        }));
        return (n - c) - 1;
    }

    @Override // java.util.Spliterator
    default ShortComparator getComparator() {
        throw new IllegalStateException();
    }
}
