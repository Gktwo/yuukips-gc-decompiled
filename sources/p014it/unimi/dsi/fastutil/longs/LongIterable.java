package p014it.unimi.dsi.fastutil.longs;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

/* renamed from: it.unimi.dsi.fastutil.longs.LongIterable */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongIterable.class */
public interface LongIterable extends Iterable<Long> {
    @Override // java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
    LongIterator iterator();

    default LongIterator longIterator() {
        return iterator();
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
    default LongSpliterator spliterator() {
        return LongSpliterators.asSpliteratorUnknownSize(iterator(), 0);
    }

    default LongSpliterator longSpliterator() {
        return spliterator();
    }

    default void forEach(LongConsumer action) {
        Objects.requireNonNull(action);
        iterator().forEachRemaining(action);
    }

    default void forEach(LongConsumer action) {
        forEach((LongConsumer) action);
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongIterable
    @Deprecated
    default void forEach(Consumer<? super Long> action) {
        LongConsumer longConsumer;
        Objects.requireNonNull(action);
        if (action instanceof LongConsumer) {
            longConsumer = (LongConsumer) action;
        } else {
            Objects.requireNonNull(action);
            longConsumer = (v1) -> {
                r1.accept(v1);
            };
        }
        forEach(longConsumer);
    }
}
