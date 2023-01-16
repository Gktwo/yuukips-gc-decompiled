package p014it.unimi.dsi.fastutil.doubles;

import java.util.Objects;
import java.util.function.Consumer;

@FunctionalInterface
/* renamed from: it.unimi.dsi.fastutil.doubles.DoubleConsumer */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleConsumer.class */
public interface DoubleConsumer extends Consumer<Double>, java.util.function.DoubleConsumer {
    @Deprecated
    default void accept(Double t) {
        accept(t.doubleValue());
    }

    @Override // java.util.function.DoubleConsumer
    default DoubleConsumer andThen(java.util.function.DoubleConsumer after) {
        Objects.requireNonNull(after);
        return t -> {
            accept(after);
            after.accept(after);
        };
    }

    default DoubleConsumer andThen(DoubleConsumer after) {
        return andThen((java.util.function.DoubleConsumer) after);
    }

    @Override // java.util.function.Consumer
    @Deprecated
    default Consumer<Double> andThen(Consumer<? super Double> after) {
        return andThen(after);
    }
}
