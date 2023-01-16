package com.google.errorprone.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
/* loaded from: grasscutter.jar:com/google/errorprone/annotations/DoNotCall.class */
public @interface DoNotCall {
    String value() default "";
}
