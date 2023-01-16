package com.google.common.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD})
@GwtCompatible
@Retention(RetentionPolicy.CLASS)
@Documented
/* loaded from: grasscutter.jar:com/google/common/annotations/GwtCompatible.class */
public @interface GwtCompatible {
    boolean serializable() default false;

    boolean emulated() default false;
}
