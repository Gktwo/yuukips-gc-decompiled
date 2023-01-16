package com.fasterxml.jackson.annotation;

import java.lang.annotation.Annotation;

/* loaded from: grasscutter.jar:com/fasterxml/jackson/annotation/JacksonAnnotationValue.class */
public interface JacksonAnnotationValue<A extends Annotation> {
    Class<A> valueFor();
}
