package p014it.unimi.dsi.fastutil.booleans;

import java.util.function.BinaryOperator;

@FunctionalInterface
/* renamed from: it.unimi.dsi.fastutil.booleans.BooleanBinaryOperator */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanBinaryOperator.class */
public interface BooleanBinaryOperator extends BinaryOperator<Boolean> {
    boolean apply(boolean z, boolean z2);

    @Deprecated
    default Boolean apply(Boolean x, Boolean y) {
        return Boolean.valueOf(apply(x.booleanValue(), y.booleanValue()));
    }
}
