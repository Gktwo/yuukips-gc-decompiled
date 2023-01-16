package javax.servlet.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
/* loaded from: grasscutter.jar:javax/servlet/annotation/WebInitParam.class */
public @interface WebInitParam {
    String name();

    String value();

    String description() default "";
}
