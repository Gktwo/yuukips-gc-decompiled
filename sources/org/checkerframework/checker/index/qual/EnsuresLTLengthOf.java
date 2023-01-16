package org.checkerframework.checker.index.qual;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.checkerframework.framework.qual.InheritedAnnotation;
import org.checkerframework.framework.qual.JavaExpression;
import org.checkerframework.framework.qual.PostconditionAnnotation;
import org.checkerframework.framework.qual.QualifierArgument;

@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
@PostconditionAnnotation(qualifier = LTLengthOf.class)
@InheritedAnnotation
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: grasscutter.jar:org/checkerframework/checker/index/qual/EnsuresLTLengthOf.class */
public @interface EnsuresLTLengthOf {
    String[] value();

    @QualifierArgument("value")
    @JavaExpression
    String[] targetValue();

    @QualifierArgument("offset")
    @JavaExpression
    String[] offset() default {};
}
