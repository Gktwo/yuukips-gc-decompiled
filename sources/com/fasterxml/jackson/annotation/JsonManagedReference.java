package com.fasterxml.jackson.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.METHOD})
@JacksonAnnotation
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: grasscutter.jar:com/fasterxml/jackson/annotation/JsonManagedReference.class */
public @interface JsonManagedReference {
    String value() default "defaultReference";
}
