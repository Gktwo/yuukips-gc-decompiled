package dev.morphia.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: grasscutter.jar:dev/morphia/annotations/Entity.class */
public @interface Entity {
    CappedAt cap() default @CappedAt(value = -1, count = -1);

    String concern() default "";

    boolean useDiscriminator() default true;

    String value() default ".";

    String discriminatorKey() default ".";

    String discriminator() default ".";
}
