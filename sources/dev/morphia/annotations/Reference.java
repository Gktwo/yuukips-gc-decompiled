package dev.morphia.annotations;

import dev.morphia.mapping.codec.references.ReferenceCodec;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD})
@Handler(ReferenceCodec.class)
@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: grasscutter.jar:dev/morphia/annotations/Reference.class */
public @interface Reference {
    boolean idOnly() default false;

    boolean ignoreMissing() default false;

    boolean lazy() default false;

    String value() default ".";
}
