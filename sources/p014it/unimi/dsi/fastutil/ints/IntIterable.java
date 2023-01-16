package p014it.unimi.dsi.fastutil.ints;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* renamed from: it.unimi.dsi.fastutil.ints.IntIterable */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntIterable.class */
public interface IntIterable extends Iterable<Integer> {
    @Override // java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
    IntIterator iterator();

    default IntIterator intIterator() {
        return iterator();
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
    default IntSpliterator spliterator() {
        return IntSpliterators.asSpliteratorUnknownSize(iterator(), 0);
    }

    default IntSpliterator intSpliterator() {
        return spliterator();
    }

    default void forEach(IntConsumer action) {
        Objects.requireNonNull(action);
        iterator().forEachRemaining(action);
    }

    default void forEach(IntConsumer action) {
        forEach((IntConsumer) action);
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntIterable
    @Deprecated
    default void forEach(Consumer<? super Integer> action) {
        IntConsumer intConsumer;
        Objects.requireNonNull(action);
        if (action instanceof IntConsumer) {
            intConsumer = (IntConsumer) action;
        } else {
            Objects.requireNonNull(action);
            intConsumer = (v1) -> {
                r1.accept(v1);
            };
        }
        forEach(intConsumer);
    }
}
