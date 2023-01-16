package p014it.unimi.dsi.fastutil.booleans;

import java.util.function.UnaryOperator;

@FunctionalInterface
/* renamed from: it.unimi.dsi.fastutil.booleans.BooleanUnaryOperator */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanUnaryOperator.class */
public interface BooleanUnaryOperator extends UnaryOperator<Boolean> {
    boolean apply(boolean z);

    static BooleanUnaryOperator identity() {
        return i -> {
            return i;
        };
    }

    static BooleanUnaryOperator negation() {
        return i -> {
            return !i;
        };
    }

    @Deprecated
    default Boolean apply(Boolean x) {
        return Boolean.valueOf(apply(x.booleanValue()));
    }
}
