package dev.morphia.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Deprecated(since = "2.2")
@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: grasscutter.jar:dev/morphia/annotations/Embedded.class */
public @interface Embedded {
    @Deprecated(since = "2.0", forRemoval = true)
    String value() default ".";

    boolean useDiscriminator() default true;

    String discriminatorKey() default ".";

    String discriminator() default ".";
}
