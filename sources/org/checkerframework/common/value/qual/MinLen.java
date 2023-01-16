package org.checkerframework.common.value.qual;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
/* loaded from: grasscutter.jar:org/checkerframework/common/value/qual/MinLen.class */
public @interface MinLen {
    int value() default 0;
}
