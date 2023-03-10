package org.checkerframework.framework.qual;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: grasscutter.jar:org/checkerframework/framework/qual/ConditionalPostconditionAnnotation.class */
public @interface ConditionalPostconditionAnnotation {
    Class<? extends Annotation> qualifier();
}
