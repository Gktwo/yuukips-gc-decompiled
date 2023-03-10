package org.checkerframework.checker.units.qual;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.checkerframework.framework.qual.SubtypeOf;

@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
@Documented
@Retention(RetentionPolicy.RUNTIME)
@SubtypeOf({Mass.class})
/* renamed from: org.checkerframework.checker.units.qual.g */
/* loaded from: grasscutter.jar:org/checkerframework/checker/units/qual/g.class */
public @interface AbstractC5559g {
    Prefix value() default Prefix.one;
}
