package com.google.j2objc.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: grasscutter.jar:com/google/j2objc/annotations/Property.class */
public @interface Property {
    String value() default "";
}
