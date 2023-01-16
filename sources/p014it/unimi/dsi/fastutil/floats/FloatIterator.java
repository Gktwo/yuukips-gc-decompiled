package p014it.unimi.dsi.fastutil.floats;

import java.util.Objects;
import java.util.PrimitiveIterator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

/* renamed from: it.unimi.dsi.fastutil.floats.FloatIterator */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatIterator.class */
public interface FloatIterator extends PrimitiveIterator<Float, FloatConsumer> {
    float nextFloat();

    @Override // java.util.Iterator
    @Deprecated
    default Float next() {
        return Float.valueOf(nextFloat());
    }

    default void forEachRemaining(FloatConsumer action) {
        Objects.requireNonNull(action);
        while (hasNext()) {
            action.accept(nextFloat());
        }
    }

    default void forEachRemaining(DoubleConsumer action) {
        FloatConsumer floatConsumer;
        Objects.requireNonNull(action);
        if (action instanceof FloatConsumer) {
            floatConsumer = (FloatConsumer) action;
        } else {
            Objects.requireNonNull(action);
            floatConsumer = (v1) -> {
                r1.accept(v1);
            };
        }
        forEachRemaining(floatConsumer);
    }

    @Override // java.util.Iterator
    @Deprecated
    default void forEachRemaining(Consumer<? super Float> action) {
        FloatConsumer floatConsumer;
        if (action instanceof FloatConsumer) {
            floatConsumer = (FloatConsumer) action;
        } else {
            Objects.requireNonNull(action);
            floatConsumer = (v1) -> {
                r1.accept(v1);
            };
        }
        forEachRemaining(floatConsumer);
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
            nextFloat();
        }
        return (n - i) - 1;
    }
}
