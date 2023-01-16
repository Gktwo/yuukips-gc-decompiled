package com.google.j2objc.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.PACKAGE})
@Retention(RetentionPolicy.CLASS)
/* loaded from: grasscutter.jar:com/google/j2objc/annotations/ReflectionSupport.class */
public @interface ReflectionSupport {

    /* loaded from: grasscutter.jar:com/google/j2objc/annotations/ReflectionSupport$Level.class */
    public enum Level {
        NATIVE_ONLY,
        FULL
    }

    Level value();
}
