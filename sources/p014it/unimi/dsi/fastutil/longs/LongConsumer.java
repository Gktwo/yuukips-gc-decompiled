package p014it.unimi.dsi.fastutil.longs;

import java.util.Objects;
import java.util.function.Consumer;

@FunctionalInterface
/* renamed from: it.unimi.dsi.fastutil.longs.LongConsumer */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongConsumer.class */
public interface LongConsumer extends Consumer<Long>, java.util.function.LongConsumer {
    @Deprecated
    default void accept(Long t) {
        accept(t.longValue());
    }

    @Override // java.util.function.LongConsumer
    default LongConsumer andThen(java.util.function.LongConsumer after) {
        Objects.requireNonNull(after);
        return t -> {
            accept(after);
            after.accept(after);
        };
    }

    default LongConsumer andThen(LongConsumer after) {
        return andThen((java.util.function.LongConsumer) after);
    }

    @Override // java.util.function.Consumer
    @Deprecated
    default Consumer<Long> andThen(Consumer<? super Long> after) {
        return andThen(after);
    }
}
