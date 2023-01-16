package org.eclipse.jetty.util.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
/* loaded from: grasscutter.jar:org/eclipse/jetty/util/annotation/ManagedAttribute.class */
public @interface ManagedAttribute {
    String value() default "Not Specified";

    String name() default "";

    boolean readonly() default false;

    boolean proxied() default false;

    String setter() default "";
}
