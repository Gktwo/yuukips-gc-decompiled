package org.checkerframework.checker.index.qual;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.checkerframework.framework.qual.ImplicitFor;
import org.checkerframework.framework.qual.LiteralKind;
import org.checkerframework.framework.qual.SubtypeOf;

@Target({ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
@ImplicitFor(literals = {LiteralKind.NULL})
@SubtypeOf({LessThan.class})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: grasscutter.jar:org/checkerframework/checker/index/qual/LessThanBottom.class */
public @interface LessThanBottom {
}
