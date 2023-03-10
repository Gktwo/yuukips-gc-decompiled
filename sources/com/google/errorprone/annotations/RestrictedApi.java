package com.google.errorprone.annotations;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.CONSTRUCTOR, ElementType.METHOD})
/* loaded from: grasscutter.jar:com/google/errorprone/annotations/RestrictedApi.class */
public @interface RestrictedApi {
    String checkerName() default "RestrictedApi";

    String explanation();

    String link();

    String allowedOnPath() default "";

    Class<? extends Annotation>[] whitelistAnnotations() default {};

    Class<? extends Annotation>[] whitelistWithWarningAnnotations() default {};
}
