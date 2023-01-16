package dev.morphia.annotations;

import com.mongodb.client.model.ValidationAction;
import com.mongodb.client.model.ValidationLevel;
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
/* loaded from: grasscutter.jar:dev/morphia/annotations/Validation.class */
public @interface Validation {
    String value();

    ValidationLevel level() default ValidationLevel.STRICT;

    ValidationAction action() default ValidationAction.ERROR;
}
