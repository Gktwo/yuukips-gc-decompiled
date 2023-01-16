package p014it.unimi.dsi.fastutil.booleans;

import java.util.Objects;
import java.util.PrimitiveIterator;
import java.util.function.Consumer;

/* renamed from: it.unimi.dsi.fastutil.booleans.BooleanIterator */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanIterator.class */
public interface BooleanIterator extends PrimitiveIterator<Boolean, BooleanConsumer> {
    boolean nextBoolean();

    @Override // java.util.Iterator
    @Deprecated
    default Boolean next() {
        return Boolean.valueOf(nextBoolean());
    }

    default void forEachRemaining(BooleanConsumer action) {
        Objects.requireNonNull(action);
        while (hasNext()) {
            action.accept(nextBoolean());
        }
    }

    @Override // java.util.Iterator
    @Deprecated
    default void forEachRemaining(Consumer<? super Boolean> action) {
        BooleanConsumer booleanConsumer;
        if (action instanceof BooleanConsumer) {
            booleanConsumer = (BooleanConsumer) action;
        } else {
            Objects.requireNonNull(action);
            booleanConsumer = (v1) -> {
                r1.accept(v1);
            };
        }
        forEachRemaining(booleanConsumer);
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
            nextBoolean();
        }
        return (n - i) - 1;
    }
}
