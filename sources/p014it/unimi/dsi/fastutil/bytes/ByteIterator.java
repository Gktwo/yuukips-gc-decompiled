package p014it.unimi.dsi.fastutil.bytes;

import java.util.Objects;
import java.util.PrimitiveIterator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* renamed from: it.unimi.dsi.fastutil.bytes.ByteIterator */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteIterator.class */
public interface ByteIterator extends PrimitiveIterator<Byte, ByteConsumer> {
    byte nextByte();

    @Override // java.util.Iterator
    @Deprecated
    default Byte next() {
        return Byte.valueOf(nextByte());
    }

    default void forEachRemaining(ByteConsumer action) {
        Objects.requireNonNull(action);
        while (hasNext()) {
            action.accept(nextByte());
        }
    }

    default void forEachRemaining(IntConsumer action) {
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
        forEachRemaining(byteConsumer);
    }

    @Override // java.util.Iterator
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
        forEachRemaining(byteConsumer);
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
            nextByte();
        }
        return (n - i) - 1;
    }
}
