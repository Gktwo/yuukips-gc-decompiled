package p014it.unimi.dsi.fastutil.shorts;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import p014it.unimi.dsi.fastutil.ints.IntIterator;
import p014it.unimi.dsi.fastutil.ints.IntIterators;
import p014it.unimi.dsi.fastutil.ints.IntSpliterator;
import p014it.unimi.dsi.fastutil.ints.IntSpliterators;

/* renamed from: it.unimi.dsi.fastutil.shorts.ShortIterable */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortIterable.class */
public interface ShortIterable extends Iterable<Short> {
    @Override // java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
    ShortIterator iterator();

    default IntIterator intIterator() {
        return IntIterators.wrap(iterator());
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
    default ShortSpliterator spliterator() {
        return ShortSpliterators.asSpliteratorUnknownSize(iterator(), 0);
    }

    default IntSpliterator intSpliterator() {
        return IntSpliterators.wrap(spliterator());
    }

    default void forEach(ShortConsumer action) {
        Objects.requireNonNull(action);
        iterator().forEachRemaining(action);
    }

    default void forEach(IntConsumer action) {
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
        forEach(shortConsumer);
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterable
    @Deprecated
    default void forEach(Consumer<? super Short> action) {
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
        forEach(shortConsumer);
    }
}
