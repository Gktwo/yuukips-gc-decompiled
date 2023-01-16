package p014it.unimi.dsi.fastutil.ints;

import java.util.Objects;
import java.util.PrimitiveIterator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* renamed from: it.unimi.dsi.fastutil.ints.IntIterator */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntIterator.class */
public interface IntIterator extends PrimitiveIterator.OfInt {
    @Override // java.util.PrimitiveIterator.OfInt
    int nextInt();

    @Override // java.util.PrimitiveIterator.OfInt, java.util.Iterator
    @Deprecated
    default Integer next() {
        return Integer.valueOf(nextInt());
    }

    default void forEachRemaining(IntConsumer action) {
        forEachRemaining((IntConsumer) action);
    }

    @Override // java.util.PrimitiveIterator.OfInt, java.util.Iterator
    @Deprecated
    default void forEachRemaining(Consumer<? super Integer> action) {
        IntConsumer intConsumer;
        if (action instanceof IntConsumer) {
            intConsumer = (IntConsumer) action;
        } else {
            Objects.requireNonNull(action);
            intConsumer = (v1) -> {
                r1.accept(v1);
            };
        }
        forEachRemaining(intConsumer);
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
            nextInt();
        }
        return (n - i) - 1;
    }
}
