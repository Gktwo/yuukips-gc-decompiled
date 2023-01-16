package p014it.unimi.dsi.fastutil.bytes;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import p014it.unimi.dsi.fastutil.ints.IntIterator;
import p014it.unimi.dsi.fastutil.ints.IntIterators;
import p014it.unimi.dsi.fastutil.ints.IntSpliterator;
import p014it.unimi.dsi.fastutil.ints.IntSpliterators;

/* renamed from: it.unimi.dsi.fastutil.bytes.ByteIterable */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteIterable.class */
public interface ByteIterable extends Iterable<Byte> {
    @Override // java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
    ByteIterator iterator();

    default IntIterator intIterator() {
        return IntIterators.wrap(iterator());
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
    default ByteSpliterator spliterator() {
        return ByteSpliterators.asSpliteratorUnknownSize(iterator(), 0);
    }

    default IntSpliterator intSpliterator() {
        return IntSpliterators.wrap(spliterator());
    }

    default void forEach(ByteConsumer action) {
        Objects.requireNonNull(action);
        iterator().forEachRemaining(action);
    }

    default void forEach(IntConsumer action) {
        ByteConsumer byteConsumer;
        Objects.requireNonNull(action);
        if (action instanceof ByteConsumer) {
            byteConsumer = (ByteConsumer) action;
        } else {
            Objects.requireNonNull(action);
            byteConsumer = (v1) -> {
                r1.accept(v1);
            };
        }
        forEach(byteConsumer);
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterable
    @Deprecated
    default void forEach(Consumer<? super Byte> action) {
        ByteConsumer byteConsumer;
        Objects.requireNonNull(action);
        if (action instanceof ByteConsumer) {
            byteConsumer = (ByteConsumer) action;
        } else {
            Objects.requireNonNull(action);
            byteConsumer = (v1) -> {
                r1.accept(v1);
            };
        }
        forEach(byteConsumer);
    }
}
