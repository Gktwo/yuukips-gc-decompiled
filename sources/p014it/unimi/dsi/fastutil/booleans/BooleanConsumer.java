package p014it.unimi.dsi.fastutil.booleans;

import java.util.Objects;
import java.util.function.Consumer;

@FunctionalInterface
/* renamed from: it.unimi.dsi.fastutil.booleans.BooleanConsumer */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanConsumer.class */
public interface BooleanConsumer extends Consumer<Boolean> {
    void accept(boolean z);

    @Deprecated
    default void accept(Boolean t) {
        accept(t.booleanValue());
    }

    default BooleanConsumer andThen(BooleanConsumer after) {
        Objects.requireNonNull(after);
        return t -> {
            accept(after);
            after.accept(after);
        };
    }

    @Override // java.util.function.Consumer
    @Deprecated
    default Consumer<Boolean> andThen(Consumer<? super Boolean> after) {
        return andThen(after);
    }
}
