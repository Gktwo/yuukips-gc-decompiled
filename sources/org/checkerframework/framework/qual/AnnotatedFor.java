package org.checkerframework.framework.qual;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.PACKAGE})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: grasscutter.jar:org/checkerframework/framework/qual/AnnotatedFor.class */
public @interface AnnotatedFor {
    String[] value();
}
