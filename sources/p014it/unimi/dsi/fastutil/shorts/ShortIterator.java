package p014it.unimi.dsi.fastutil.shorts;

import java.util.Objects;
import java.util.PrimitiveIterator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* renamed from: it.unimi.dsi.fastutil.shorts.ShortIterator */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortIterator.class */
public interface ShortIterator extends PrimitiveIterator<Short, ShortConsumer> {
    short nextShort();

    @Override // java.util.Iterator
    @Deprecated
    default Short next() {
        return Short.valueOf(nextShort());
    }

    default void forEachRemaining(ShortConsumer action) {
        Objects.requireNonNull(action);
        while (hasNext()) {
            action.accept(nextShort());
        }
    }

    default void forEachRemaining(IntConsumer action) {
        ShortConsumer shortConsumer;
        Objects.requireNonNull(action);
        if (action instanceof ShortConsumer) {
            shortConsumer = (ShortConsumer) action;
        } else {
            Objects.requireNonNull(action);
            shortConsumer = (v1) -> {
                r1.accept(v1);
            };
        }
        forEachRemaining(shortConsumer);
    }

    @Override // java.util.Iterator
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
        forEachRemaining(shortConsumer);
    }

    @Override // p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
    default int skip(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Argument must be nonnegative: " + n);
        }
        int i = n;
        while (true) {
            i--;
            if (i == 0 || !hasNext()) {
                break;
            }
            nextShort();
        }
        return (n - i) - 1;
    }
}
