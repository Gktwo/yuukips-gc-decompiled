package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

@FunctionalInterface
@GwtCompatible
/* loaded from: grasscutter.jar:com/google/common/base/Supplier.class */
public interface Supplier<T> extends java.util.function.Supplier<T> {
    @Override // java.util.function.Supplier
    @CanIgnoreReturnValue
    T get();
}
