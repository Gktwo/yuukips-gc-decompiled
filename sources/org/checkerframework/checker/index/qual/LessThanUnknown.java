package org.checkerframework.checker.index.qual;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.checkerframework.framework.qual.DefaultQualifierInHierarchy;
import org.checkerframework.framework.qual.SubtypeOf;

@Target({ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
@SubtypeOf({})
@Retention(RetentionPolicy.RUNTIME)
@DefaultQualifierInHierarchy
/* loaded from: grasscutter.jar:org/checkerframework/checker/index/qual/LessThanUnknown.class */
public @interface LessThanUnknown {
}
