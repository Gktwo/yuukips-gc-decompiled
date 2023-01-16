package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

@FunctionalInterface
@GwtCompatible
/* loaded from: grasscutter.jar:com/google/common/base/Function.class */
public interface Function<F, T> extends java.util.function.Function<F, T> {
    @Override // java.util.function.Function
    @CanIgnoreReturnValue
    T apply(F f);

    @Override // java.lang.Object
    boolean equals(Object obj);
}
