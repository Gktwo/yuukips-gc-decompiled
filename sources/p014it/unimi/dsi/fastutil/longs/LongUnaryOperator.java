package p014it.unimi.dsi.fastutil.longs;

import java.util.function.UnaryOperator;

@FunctionalInterface
/* renamed from: it.unimi.dsi.fastutil.longs.LongUnaryOperator */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongUnaryOperator.class */
public interface LongUnaryOperator extends UnaryOperator<Long>, java.util.function.LongUnaryOperator {
    long apply(long j);

    static LongUnaryOperator identity() {
        return i -> {
            return i;
        };
    }

    static LongUnaryOperator negation() {
        return i -> {
            return -i;
        };
    }

    @Override // java.util.function.LongUnaryOperator
    @Deprecated
    default long applyAsLong(long x) {
        return apply(x);
    }

    @Deprecated
    default Long apply(Long x) {
        return Long.valueOf(apply(x.longValue()));
    }
}
