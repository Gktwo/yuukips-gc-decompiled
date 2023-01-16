package p014it.unimi.dsi.fastutil.booleans;

import java.util.Objects;
import java.util.function.Consumer;

/* renamed from: it.unimi.dsi.fastutil.booleans.BooleanIterable */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanIterable.class */
public interface BooleanIterable extends Iterable<Boolean> {
    @Override // java.lang.Iterable, p014it.unimi.dsi.fastutil.booleans.BooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanIterable, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
    BooleanIterator iterator();

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanIterable, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
    default BooleanSpliterator spliterator() {
        return BooleanSpliterators.asSpliteratorUnknownSize(iterator(), 0);
    }

    default void forEach(BooleanConsumer action) {
        Objects.requireNonNull(action);
        iterator().forEachRemaining(action);
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterable
    @Deprecated
    default void forEach(Consumer<? super Boolean> action) {
        BooleanConsumer booleanConsumer;
        Objects.requireNonNull(action);
        if (action instanceof BooleanConsumer) {
            booleanConsumer = (BooleanConsumer) action;
        } else {
            Objects.requireNonNull(action);
            booleanConsumer = (v1) -> {
                r1.accept(v1);
            };
        }
        forEach(booleanConsumer);
    }
}
