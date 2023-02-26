package org.checkerframework.checker.guieffect.qual;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.checkerframework.framework.qual.DefaultQualifierInHierarchy;
import org.checkerframework.framework.qual.ImplicitFor;
import org.checkerframework.framework.qual.LiteralKind;
import org.checkerframework.framework.qual.SubtypeOf;

@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
@ImplicitFor(literals = {LiteralKind.NULL})
@SubtypeOf({AbstractC5554UI.class})
@Documented
@Retention(RetentionPolicy.RUNTIME)
@DefaultQualifierInHierarchy
/* loaded from: grasscutter.jar:org/checkerframework/checker/guieffect/qual/AlwaysSafe.class */
public @interface AlwaysSafe {
}
