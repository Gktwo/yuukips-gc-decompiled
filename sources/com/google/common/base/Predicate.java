package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

@FunctionalInterface
@GwtCompatible
/* loaded from: grasscutter.jar:com/google/common/base/Predicate.class */
public interface Predicate<T> extends java.util.function.Predicate<T> {
    @CanIgnoreReturnValue
    boolean apply(T t);

    @Override // java.lang.Object
    boolean equals(Object obj);

    @Override // java.util.function.Predicate
    default boolean test(T input) {
        return apply(input);
    }
}
