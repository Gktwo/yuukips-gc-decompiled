package edu.umd.p012cs.findbugs.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
@Documented
@Retention(RetentionPolicy.CLASS)
/* renamed from: edu.umd.cs.findbugs.annotations.CheckReturnValue */
/* loaded from: grasscutter.jar:edu/umd/cs/findbugs/annotations/CheckReturnValue.class */
public @interface CheckReturnValue {
    @Deprecated
    Priority priority() default Priority.MEDIUM;

    Confidence confidence() default Confidence.MEDIUM;

    String explanation() default "";
}
