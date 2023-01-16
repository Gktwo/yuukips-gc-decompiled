package com.fasterxml.jackson.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@JacksonAnnotation
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: grasscutter.jar:com/fasterxml/jackson/annotation/JsonTypeInfo.class */
public @interface JsonTypeInfo {

    /* renamed from: com.fasterxml.jackson.annotation.JsonTypeInfo$As */
    /* loaded from: grasscutter.jar:com/fasterxml/jackson/annotation/JsonTypeInfo$As.class */
    public enum EnumC0036As {
        PROPERTY,
        WRAPPER_OBJECT,
        WRAPPER_ARRAY,
        EXTERNAL_PROPERTY,
        EXISTING_PROPERTY
    }

    @Deprecated
    /* loaded from: grasscutter.jar:com/fasterxml/jackson/annotation/JsonTypeInfo$None.class */
    public static abstract class None {
    }

    EnumC0037Id use();

    EnumC0036As include() default EnumC0036As.PROPERTY;

    String property() default "";

    Class<?> defaultImpl() default JsonTypeInfo.class;

    boolean visible() default false;

    /* renamed from: com.fasterxml.jackson.annotation.JsonTypeInfo$Id */
    /* loaded from: grasscutter.jar:com/fasterxml/jackson/annotation/JsonTypeInfo$Id.class */
    public enum EnumC0037Id {
        NONE(null),
        CLASS("@class"),
        MINIMAL_CLASS("@c"),
        NAME("@type"),
        DEDUCTION(null),
        CUSTOM(null);
        
        private final String _defaultPropertyName;

        EnumC0037Id(String defProp) {
            this._defaultPropertyName = defProp;
        }

        public String getDefaultPropertyName() {
            return this._defaultPropertyName;
        }
    }
}
