package org.checkerframework.common.value.qual;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.checkerframework.framework.qual.DefaultInUncheckedCodeFor;
import org.checkerframework.framework.qual.DefaultQualifierInHierarchy;
import org.checkerframework.framework.qual.SubtypeOf;
import org.checkerframework.framework.qual.TypeUseLocation;

@Target({ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
@SubtypeOf({})
@Retention(RetentionPolicy.RUNTIME)
@DefaultQualifierInHierarchy
@DefaultInUncheckedCodeFor({TypeUseLocation.PARAMETER})
/* loaded from: grasscutter.jar:org/checkerframework/common/value/qual/UnknownVal.class */
public @interface UnknownVal {
}
