package dev.morphia.annotations;

import dev.morphia.utils.IndexDirection;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD})
@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: grasscutter.jar:dev/morphia/annotations/Indexed.class */
public @interface Indexed {
    IndexOptions options() default @IndexOptions;

    IndexDirection value() default IndexDirection.ASC;
}
