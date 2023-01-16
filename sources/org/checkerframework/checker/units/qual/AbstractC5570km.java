package org.checkerframework.checker.units.qual;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.checkerframework.framework.qual.SubtypeOf;

@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
@UnitsMultiple(quantity = AbstractC5571m.class, prefix = Prefix.kilo)
@Documented
@Retention(RetentionPolicy.RUNTIME)
@SubtypeOf({Length.class})
/* renamed from: org.checkerframework.checker.units.qual.km */
/* loaded from: grasscutter.jar:org/checkerframework/checker/units/qual/km.class */
public @interface AbstractC5570km {
}
