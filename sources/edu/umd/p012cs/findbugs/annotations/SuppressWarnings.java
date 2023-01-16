package edu.umd.p012cs.findbugs.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.CONSTRUCTOR, ElementType.LOCAL_VARIABLE, ElementType.PACKAGE})
@Retention(RetentionPolicy.CLASS)
@Deprecated
/* renamed from: edu.umd.cs.findbugs.annotations.SuppressWarnings */
/* loaded from: grasscutter.jar:edu/umd/cs/findbugs/annotations/SuppressWarnings.class */
public @interface SuppressWarnings {
    String[] value() default {};

    String justification() default "";
}
