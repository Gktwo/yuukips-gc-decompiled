package org.checkerframework.framework.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import org.checkerframework.framework.qual.DefaultQualifierInHierarchy;
import org.checkerframework.framework.qual.InvisibleQualifier;
import org.checkerframework.framework.qual.SubtypeOf;

@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
@InvisibleQualifier
@SubtypeOf({})
@DefaultQualifierInHierarchy
/* loaded from: grasscutter.jar:org/checkerframework/framework/util/PurityUnqualified.class */
public @interface PurityUnqualified {
}
