package p014it.unimi.dsi.fastutil.ints;

import java.util.Objects;
import java.util.function.Consumer;

@FunctionalInterface
/* renamed from: it.unimi.dsi.fastutil.ints.IntConsumer */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntConsumer.class */
public interface IntConsumer extends Consumer<Integer>, java.util.function.IntConsumer {
    @Deprecated
    default void accept(Integer t) {
        accept(t.intValue());
    }

    @Override // java.util.function.IntConsumer
    default IntConsumer andThen(java.util.function.IntConsumer after) {
        Objects.requireNonNull(after);
        return t -> {
            accept(after);
            after.accept(after);
        };
    }

    default IntConsumer andThen(IntConsumer after) {
        return andThen((java.util.function.IntConsumer) after);
    }

    @Override // java.util.function.Consumer
    @Deprecated
    default Consumer<Integer> andThen(Consumer<? super Integer> after) {
        return andThen(after);
    }
}
