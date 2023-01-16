package edu.umd.p012cs.findbugs.annotations;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.PACKAGE})
@Documented
@Retention(RetentionPolicy.CLASS)
/* renamed from: edu.umd.cs.findbugs.annotations.DefaultAnnotationForParameters */
/* loaded from: grasscutter.jar:edu/umd/cs/findbugs/annotations/DefaultAnnotationForParameters.class */
public @interface DefaultAnnotationForParameters {
    Class<? extends Annotation>[] value();

    @Deprecated
    Priority priority() default Priority.MEDIUM;

    Confidence confidence() default Confidence.MEDIUM;
}