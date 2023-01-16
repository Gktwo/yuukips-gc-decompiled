package org.checkerframework.common.value.qual;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.checkerframework.framework.qual.SubtypeOf;

@Target({ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
@SubtypeOf({UnknownVal.class})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: grasscutter.jar:org/checkerframework/common/value/qual/ArrayLenRange.class */
public @interface ArrayLenRange {
    int from() default 0;

    /* renamed from: to */
    int m45to() default Integer.MAX_VALUE;
}
