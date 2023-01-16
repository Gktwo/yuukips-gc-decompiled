package dev.morphia.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
/* loaded from: grasscutter.jar:dev/morphia/annotations/CappedAt.class */
public @interface CappedAt {
    long count() default 0;

    long value() default 1048576;
}
