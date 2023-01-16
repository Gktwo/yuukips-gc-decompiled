package p014it.unimi.dsi.fastutil.longs;

import java.util.function.BinaryOperator;

@FunctionalInterface
/* renamed from: it.unimi.dsi.fastutil.longs.LongBinaryOperator */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongBinaryOperator.class */
public interface LongBinaryOperator extends BinaryOperator<Long>, java.util.function.LongBinaryOperator {
    long apply(long j, long j2);

    @Override // java.util.function.LongBinaryOperator
    @Deprecated
    default long applyAsLong(long x, long y) {
        return apply(x, y);
    }

    @Deprecated
    default Long apply(Long x, Long y) {
        return Long.valueOf(apply(x.longValue(), y.longValue()));
    }
}
