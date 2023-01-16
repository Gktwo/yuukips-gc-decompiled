package p014it.unimi.dsi.fastutil.bytes;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import p014it.unimi.dsi.fastutil.SafeMath;

@FunctionalInterface
/* renamed from: it.unimi.dsi.fastutil.bytes.ByteConsumer */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteConsumer.class */
public interface ByteConsumer extends Consumer<Byte>, IntConsumer {
    void accept(byte b);

    @Override // java.util.function.IntConsumer
    @Deprecated
    default void accept(int t) {
        accept(SafeMath.safeIntToByte(t));
    }

    @Deprecated
    default void accept(Byte t) {
        accept(t.byteValue());
    }

    default ByteConsumer andThen(ByteConsumer after) {
        Objects.requireNonNull(after);
        return t -> {
            accept(after);
            after.accept(after);
        };
    }

    @Override // java.util.function.IntConsumer
    default ByteConsumer andThen(IntConsumer after) {
        ByteConsumer byteConsumer;
        if (after instanceof ByteConsumer) {
            byteConsumer = (ByteConsumer) after;
        } else {
            Objects.requireNonNull(after);
            byteConsumer = (v1) -> {
                r1.accept(v1);
            };
        }
        return andThen(byteConsumer);
    }

    @Override // java.util.function.Consumer
    @Deprecated
    default Consumer<Byte> andThen(Consumer<? super Byte> after) {
        return andThen(after);
    }
}
