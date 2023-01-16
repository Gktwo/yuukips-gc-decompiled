package dev.morphia.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: grasscutter.jar:dev/morphia/annotations/AlsoLoad.class */
public @interface AlsoLoad {
    String[] value();
}
