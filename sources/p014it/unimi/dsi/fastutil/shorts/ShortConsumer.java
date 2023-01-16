package p014it.unimi.dsi.fastutil.shorts;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import p014it.unimi.dsi.fastutil.SafeMath;

@FunctionalInterface
/* renamed from: it.unimi.dsi.fastutil.shorts.ShortConsumer */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortConsumer.class */
public interface ShortConsumer extends Consumer<Short>, IntConsumer {
    void accept(short s);

    @Override // java.util.function.IntConsumer
    @Deprecated
    default void accept(int t) {
        accept(SafeMath.safeIntToShort(t));
    }

    @Deprecated
    default void accept(Short t) {
        accept(t.shortValue());
    }

    default ShortConsumer andThen(ShortConsumer after) {
        Objects.requireNonNull(after);
        return t -> {
            accept(after);
            after.accept(after);
        };
    }

    @Override // java.util.function.IntConsumer
    default ShortConsumer andThen(IntConsumer after) {
        ShortConsumer shortConsumer;
        if (after instanceof ShortConsumer) {
            shortConsumer = (ShortConsumer) after;
        } else {
            Objects.requireNonNull(after);
            shortConsumer = (v1) -> {
                r1.accept(v1);
            };
        }
        return andThen(shortConsumer);
    }

    @Override // java.util.function.Consumer
    @Deprecated
    default Consumer<Short> andThen(Consumer<? super Short> after) {
        return andThen(after);
    }
}
