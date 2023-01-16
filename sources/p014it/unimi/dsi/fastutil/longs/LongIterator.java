package p014it.unimi.dsi.fastutil.longs;

import java.util.Objects;
import java.util.PrimitiveIterator;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

/* renamed from: it.unimi.dsi.fastutil.longs.LongIterator */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongIterator.class */
public interface LongIterator extends PrimitiveIterator.OfLong {
    @Override // java.util.PrimitiveIterator.OfLong
    long nextLong();

    @Override // java.util.PrimitiveIterator.OfLong, java.util.Iterator
    @Deprecated
    default Long next() {
        return Long.valueOf(nextLong());
    }

    default void forEachRemaining(LongConsumer action) {
        forEachRemaining((LongConsumer) action);
    }

    @Override // java.util.PrimitiveIterator.OfLong, java.util.Iterator
    @Deprecated
    default void forEachRemaining(Consumer<? super Long> action) {
        LongConsumer longConsumer;
        if (action instanceof LongConsumer) {
            longConsumer = (LongConsumer) action;
        } else {
            Objects.requireNonNull(action);
            longConsumer = (v1) -> {
                r1.accept(v1);
            };
        }
        forEachRemaining(longConsumer);
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
            nextLong();
        }
        return (n - i) - 1;
    }
}
