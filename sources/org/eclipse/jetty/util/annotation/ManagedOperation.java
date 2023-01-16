package org.eclipse.jetty.util.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
/* loaded from: grasscutter.jar:org/eclipse/jetty/util/annotation/ManagedOperation.class */
public @interface ManagedOperation {
    String value() default "Not Specified";

    String impact() default "UNKNOWN";

    boolean proxied() default false;
}
