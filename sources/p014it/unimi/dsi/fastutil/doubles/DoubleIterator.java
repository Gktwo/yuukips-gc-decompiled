package p014it.unimi.dsi.fastutil.doubles;

import java.util.Objects;
import java.util.PrimitiveIterator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

/* renamed from: it.unimi.dsi.fastutil.doubles.DoubleIterator */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleIterator.class */
public interface DoubleIterator extends PrimitiveIterator.OfDouble {
    @Override // java.util.PrimitiveIterator.OfDouble
    double nextDouble();

    @Override // java.util.PrimitiveIterator.OfDouble, java.util.Iterator
    @Deprecated
    default Double next() {
        return Double.valueOf(nextDouble());
    }

    default void forEachRemaining(DoubleConsumer action) {
        forEachRemaining((DoubleConsumer) action);
    }

    @Override // java.util.PrimitiveIterator.OfDouble, java.util.Iterator
    @Deprecated
    default void forEachRemaining(Consumer<? super Double> action) {
        DoubleConsumer doubleConsumer;
        if (action instanceof DoubleConsumer) {
            doubleConsumer = (DoubleConsumer) action;
        } else {
            Objects.requireNonNull(action);
            doubleConsumer = (v1) -> {
                r1.accept(v1);
            };
        }
        forEachRemaining(doubleConsumer);
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
            nextDouble();
        }
        return (n - i) - 1;
    }
}
