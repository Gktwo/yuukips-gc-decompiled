package dev.morphia.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.ANNOTATION_TYPE})
@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: grasscutter.jar:dev/morphia/annotations/IndexOptions.class */
public @interface IndexOptions {
    boolean background() default false;

    boolean disableValidation() default false;

    int expireAfterSeconds() default -1;

    String language() default "";

    String languageOverride() default "";

    String name() default "";

    boolean sparse() default false;

    boolean unique() default false;

    String partialFilter() default "";

    Collation collation() default @Collation(locale = "");
}
