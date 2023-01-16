package p014it.unimi.dsi.fastutil.floats;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import p014it.unimi.dsi.fastutil.SafeMath;

@FunctionalInterface
/* renamed from: it.unimi.dsi.fastutil.floats.FloatConsumer */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatConsumer.class */
public interface FloatConsumer extends Consumer<Float>, DoubleConsumer {
    void accept(float f);

    @Override // java.util.function.DoubleConsumer
    @Deprecated
    default void accept(double t) {
        accept(SafeMath.safeDoubleToFloat(t));
    }

    @Deprecated
    default void accept(Float t) {
        accept(t.floatValue());
    }

    default FloatConsumer andThen(FloatConsumer after) {
        Objects.requireNonNull(after);
        return t -> {
            accept(after);
            after.accept(after);
        };
    }

    @Override // java.util.function.DoubleConsumer
    default FloatConsumer andThen(DoubleConsumer after) {
        FloatConsumer floatConsumer;
        if (after instanceof FloatConsumer) {
            floatConsumer = (FloatConsumer) after;
        } else {
            Objects.requireNonNull(after);
            floatConsumer = (v1) -> {
                r1.accept(v1);
            };
        }
        return andThen(floatConsumer);
    }

    @Override // java.util.function.Consumer
    @Deprecated
    default Consumer<Float> andThen(Consumer<? super Float> after) {
        return andThen(after);
    }
}
