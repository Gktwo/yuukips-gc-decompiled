package p014it.unimi.dsi.fastutil.bytes;

import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Consumer;

/* renamed from: it.unimi.dsi.fastutil.bytes.ByteSpliterator */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteSpliterator.class */
public interface ByteSpliterator extends Spliterator.OfPrimitive<Byte, ByteConsumer, ByteSpliterator> {
    @Override // java.util.Spliterator.OfPrimitive, java.util.Spliterator
    ByteSpliterator trySplit();

    @Override // java.util.Spliterator
    @Deprecated
    default boolean tryAdvance(Consumer<? super Byte> action) {
        ByteConsumer byteConsumer;
        if (action instanceof ByteConsumer) {
            byteConsumer = (ByteConsumer) action;
        } else {
            Objects.requireNonNull(action);
            byteConsumer = (v1) -> {
                r1.accept(v1);
            };
        }
        return tryAdvance((ByteSpliterator) byteConsumer);
    }

    @Override // java.util.Spliterator
    @Deprecated
    default void forEachRemaining(Consumer<? super Byte> action) {
        ByteConsumer byteConsumer;
        if (action instanceof ByteConsumer) {
            byteConsumer = (ByteConsumer) action;
        } else {
            Objects.requireNonNull(action);
            byteConsumer = (v1) -> {
                r1.accept(v1);
            };
        }
        forEachRemaining((ByteSpliterator) byteConsumer);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [long] */
    default long skip(long n) {
        if (n < 0) {
            throw new IllegalArgumentException("Argument must be nonnegative: " + n);
        }
        char c = n;
        do {
            c--;
            if (c == 0) {
                break;
            }
        } while (tryAdvance((ByteSpliterator) unused -> {
        }));
        return (n - c) - 1;
    }

    @Override // java.util.Spliterator
    default ByteComparator getComparator() {
        throw new IllegalStateException();
    }
}
